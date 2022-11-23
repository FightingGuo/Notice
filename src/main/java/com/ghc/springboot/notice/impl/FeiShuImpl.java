package com.ghc.springboot.notice.impl;

import com.alibaba.fastjson.JSON;
import com.ghc.springboot.notice.Notice;
import com.ghc.springboot.notice.constant.ThirdConstant;
import com.ghc.springboot.notice.entity.ThirdResult;
import com.ghc.springboot.notice.feishu.constant.FeiShuConstant;
import com.ghc.springboot.notice.feishu.entity.FeiShuGetAccessToken;
import com.ghc.springboot.notice.feishu.entity.FeiShuSendMsgDTO;
import com.ghc.springboot.notice.wecom.entity.SendMsgDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Date 2022/11/23 /10:17
 * @Author guohc
 * @Description
 */
@Slf4j
@Component(ThirdConstant.FEI_SHU_DING_TALK)
public class FeiShuImpl implements Notice {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Resource
    private RestTemplate restTemplate;

    @Value("${notice.dingTalk.appId:}")
    private String appId;

    @Value("${notice.dingTalk.appSecret}")
    private String appSecret;

    /**
     * 获取token
     *
     * @return
     */
    @Override
    public ThirdResult getAccessToken() {
        ThirdResult result=new ThirdResult();
        do {
            result.setResult(Boolean.TRUE);
            result.setMsg("获取token成功");
            HttpHeaders headers = new HttpHeaders();
            //请求头
            headers.add("Content-Type","application/json; charset=utf-8");

            //请求体
            Map<String,String> requestBody = new HashMap<>();
            requestBody.put("app_id",appId);
            requestBody.put("app_secret",appSecret);

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

            try {
                ResponseEntity<FeiShuGetAccessToken.Out> respToken = restTemplate.exchange(FeiShuConstant.GET_TOKEN_RUL,HttpMethod.POST,requestEntity, FeiShuGetAccessToken.Out.class);
                if (respToken.getStatusCode()!= HttpStatus.OK){
                    result.setResult(Boolean.FALSE);
                    result.setMsg(String.valueOf(respToken.getStatusCode()));
                    break;
                }

                FeiShuGetAccessToken.Out token = respToken.getBody();
                if (0!=token.getCode()){
                    result.setResult(Boolean.FALSE);
                    result.setMsg(token.getMsg());
                    break;
                }

                //成功获取正确的token 存入result
                result.setContent(token.getTenantAccessToken());
            }catch (Exception e){
                result.setResult(Boolean.FALSE);
                result.setMsg(e.getMessage());
                log.error(String.format(ThirdConstant.GET_ACCESS_TOKEN_FAIL,e.getMessage()));

            }

        }while (false);

        return result;
    }

    /**
     * 发送消息
     * @param noticeIn
     * @return
     */
    @Override
    public ThirdResult sendMsg(Object noticeIn) {
        FeiShuSendMsgDTO.In in = JSON.parseObject(String.valueOf(noticeIn), FeiShuSendMsgDTO.In.class);

        String tenantAccessToken = (String) getAccessToken().getContent();

        //请求头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");
        headers.add("Authorization ","Bearer "+tenantAccessToken);

        String uuid = UUID.randomUUID().toString();

        //请求体
        HashMap<String,String> reqMap = new HashMap<>();
        reqMap.put("receive_id",in.getReceiveId());
        reqMap.put("msg_type",in.getMsgType());
        reqMap.put("content",in.getContent());
        reqMap.put("uuid",uuid);

        HttpEntity<HashMap<String, String>> requestHttpEntity = new HttpEntity<>(reqMap, headers);

        ThirdResult result=new ThirdResult();
        do {
            result.setResult(Boolean.TRUE);
            result.setMsg("消息发送成功");
            try {
                ResponseEntity<SendMsgDTO.Out> responseEntity = restTemplate.exchange(FeiShuConstant.SEND_MSG_RUL,HttpMethod.POST,requestHttpEntity,SendMsgDTO.Out.class);
                if (responseEntity.getStatusCode()!= HttpStatus.OK){
                    result.setResult(Boolean.FALSE);
                    result.setMsg(String.valueOf(responseEntity.getStatusCode()));
                    break;
                }
                SendMsgDTO.Out resultData = responseEntity.getBody();
                result.setContent(resultData);
                if (0 != resultData.getErrCode()){
                    result.setResult(Boolean.FALSE);
                    result.setMsg(resultData.getErrMsg());
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
