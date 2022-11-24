package com.ghc.springboot.notice.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ghc.springboot.notice.Notice;
import com.ghc.springboot.notice.constant.ThirdConstant;
import com.ghc.springboot.notice.dingTalk.constant.DingTalkConstant;
import com.ghc.springboot.notice.dingTalk.entity.GetAccessTokenDTO;
import com.ghc.springboot.notice.dingTalk.entity.SendCommonMsgDTO;
import com.ghc.springboot.notice.dingTalk.entity.SendMsgToB;
import com.ghc.springboot.notice.dingTalk.entity.SendTaskMsgDTO;
import com.ghc.springboot.notice.entity.ThirdResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author 郭昊晨
 * @version 1.0
 * 2022/11/21 - 22:07
 */
@Slf4j
@Component(ThirdConstant.DING_TALK)
public class DingTalkImpl implements Notice {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Resource
    private RestTemplate restTemplate;

    @Value("${notice.dingTalk.appKey:}")
    private String appKey;

    @Value("${notice.dingTalk.appSecret:}")
    private String appSecret;


    @Override
    public ThirdResult getAccessToken() {
        String url = DingTalkConstant.GET_ACCESS_TOKEN_URL + "?appkey=" + appKey + "&appsecret=" + appSecret;

        ThirdResult result=new ThirdResult();
        do {
            result.setResult(Boolean.TRUE);
            result.setMsg("获取token成功");
            try {
                ResponseEntity<GetAccessTokenDTO.Out> responseEntity = restTemplate.getForEntity(url, GetAccessTokenDTO.Out.class);
                if (responseEntity.getStatusCode()!= HttpStatus.OK){
                    result.setResult(Boolean.FALSE);
                    result.setMsg(String.valueOf(responseEntity.getStatusCode()));
                    break;
                }

                GetAccessTokenDTO.Out token = responseEntity.getBody();
                if (!"ok".equals(token.getErrMsg())){
                    result.setResult(Boolean.FALSE);
                    result.setMsg(token.getErrMsg());
                    break;
                }

                //成功获取正确的token 存入result
                result.setContent(token.getAccessToken());
            }catch (Exception e){
                result.setResult(Boolean.FALSE);
                result.setMsg(e.getMessage());
                log.error(String.format(ThirdConstant.GET_ACCESS_TOKEN_FAIL,e.getMessage()));
            }

        }while (false);

        return result;
    }

    @Override
    public ThirdResult sendMsg(Object noticeIn) {
        SendTaskMsgDTO.In in = JSON.parseObject(String.valueOf(noticeIn), SendTaskMsgDTO.In.class);

        String accessToken = (String) getAccessToken().getContent();

        String url = DingTalkConstant.SEND_TASK_MSG_URL + accessToken;

        ThirdResult result=new ThirdResult();
        do {
            result.setResult(Boolean.TRUE);
            result.setMsg("消息发送成功");
            try {
                ResponseEntity<SendTaskMsgDTO.Out> responseEntity = restTemplate.postForEntity(url, JSONObject.toJSONString(in), SendTaskMsgDTO.Out.class);
                if (responseEntity.getStatusCode()!= HttpStatus.OK){
                    result.setResult(Boolean.FALSE);
                    result.setMsg(String.valueOf(responseEntity.getStatusCode()));
                    break;
                }
                SendTaskMsgDTO.Out token = responseEntity.getBody();
                if (!"ok".equals(token.getErrMsg())){
                    result.setResult(Boolean.FALSE);
                    result.setMsg(token.getErrMsg());
                    break;
                }
            }catch (Exception e){
                result.setResult(Boolean.FALSE);
                result.setMsg(e.getMessage());
                log.error(String.format(ThirdConstant.SEND_MSG_FAIL,e.getMessage()));
            }

        }while (false);

        return result;
    }
}
