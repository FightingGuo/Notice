package com.ghc.springboot.notice.dingTalk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发送普通消息对象（员工个人在使用应用时，可以通过界面操作的方式往群或其他人的会话里推送消息，例如发送日志的场景）
 * 群会话或者个人会话的id，通过JSAPI接口唤起联系人界面选择会话获取会话cid。企业内部应用  小程序获取会话信息  微应用获取会话信息
 */
public class SendCommonMsgDTO {

    /**
     * 普通消息传入参数
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class In{
        /**
         * 消息发送者的userid
         */
        private String sender;

        /**
         * 群会话或者个人会话的id，通过JSAPI接口唤起联系人界面选择会话获取会话cid
         */
        private String cid;

        /**
         * 消息内容，最长不超过2048个字节
         */
        private Object msg;
    }

    /**
     * 普通消息传出参数
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Out{

        /**
         * 有效接收消息的员工的userid
         */
        private String receiver;

        /**
         * 返回码描述
         */
        private String errMsg;

        /**
         * 返回码  0:True 非0:False
         */
        private Number errCode;
    }
}
