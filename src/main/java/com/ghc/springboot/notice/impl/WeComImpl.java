package com.ghc.springboot.notice.impl;

import com.alibaba.fastjson.JSONObject;
import com.ghc.springboot.notice.Notice;
import com.ghc.springboot.notice.constant.ThirdConstant;
import com.ghc.springboot.notice.entity.ThirdResult;
import com.ghc.springboot.notice.wecom.constant.WeComConstant;
import com.ghc.springboot.notice.wecom.entity.GetAccessToken;
import com.ghc.springboot.notice.wecom.entity.SendMsgDTO;
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
 * 2022/11/17 - 22:48
 */
@Slf4j
@Component(ThirdConstant.WE_COM_DING_TALK)
public class WeComImpl implements Notice {


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Resource
    public RestTemplate restTemplate;

    /**
     * 发送消息的类型
     */
    @Value("${notice.qywx.msgType:}")
    private String msgType;

    /**
     * 获取企业微信的企业号
     */
    @Value("${notice.qywx.corpId:}")
    private static final String corpId = "xxx";

    /**
     * 获取企业应用的密钥
     */
    @Value("${notice.qywx.corpSecret:}")
    private static final String corpSecret="xxx" ;

    /**
     * 企业id
     */
    @Value("${notice.qywx.agentId:}")
    private String agentId;

    /**
     * 获取access_token
     * @return
     */
    @Override
    public ThirdResult getAccessToken(){
        //访问微信服务器
        String url = WeComConstant.ACCESS_TOKEN_URL + "?corpid=" + corpId + "&corpsecret=" + corpSecret;

        ThirdResult result=new ThirdResult();

        do {
            result.setResult(Boolean.TRUE);
            result.setMsg("获取accessToken成功");
            try {
                ResponseEntity<GetAccessToken.Out> responseEntity = restTemplate.getForEntity(url, GetAccessToken.Out.class);
                //服务器是否异常
                if (responseEntity.getStatusCode()!=HttpStatus.OK) {
                    result.setResult(Boolean.FALSE);
                    result.setMsg(String.valueOf(responseEntity.getStatusCode()));
                    break;
                }
                GetAccessToken.Out body = responseEntity.getBody();
                //token获取是否异常
                if (0!=body.getErrCode()){
                    result.setResult(Boolean.FALSE);
                    result.setMsg(body.getErrMsg());
                    break;
                }
                //存入token
                result.setContent(body.getAccessToken());
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
        SendMsgDTO.In in = JSONObject.parseObject(String.valueOf(noticeIn), SendMsgDTO.In.class);

        //从对象中提取凭证
        String ACCESS_TOKEN = (String) getAccessToken().getContent();

        //把拿到的授权token拼接到请求串
        String url = WeComConstant.CREATE_SESSION_URL + ACCESS_TOKEN;

        HashMap<String,Object> map=new HashMap<>();
        HashMap<String,String> contentMap=new HashMap<>();

//        try {
        map.put("touser",in.getToUser());
        map.put("toparty",in.getToParty());
        map.put("totag",in.getToTag());
        map.put("msgtype",msgType);
        map.put("text",contentMap);
        contentMap.put("content",in.getContent());
        map.put("safe",in.getSafe());
        map.put("agentid",agentId);

        ThirdResult result=new ThirdResult();

        do {
            result.setResult(Boolean.TRUE);
            result.setMsg("发送信息成功");
            try {
                ResponseEntity<SendMsgDTO.Out> resultEntity = restTemplate.postForEntity(url, map,SendMsgDTO.Out.class);
                //判断服务器返回的请求 200  500
                if(resultEntity.getStatusCode()!= HttpStatus.OK){
                    result.setResult(Boolean.FALSE);
                    //错误信息放入result
                    result.setMsg(String.valueOf(resultEntity.getStatusCode()));
                    //返回结果
                    break;
                }
                SendMsgDTO.Out body = resultEntity.getBody();
                //下面是判断具体业务请求是否成功
                if (0!=body.getErrCode()){
                    //错误信息放入
                    result.setContent(body.getErrMsg());
                    result.setResult(Boolean.FALSE);
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
