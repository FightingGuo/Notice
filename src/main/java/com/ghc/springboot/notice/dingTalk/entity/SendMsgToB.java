package com.ghc.springboot.notice.dingTalk.entity;

/**
 * @Date 2022/11/22 /9:08
 * @Author guohc
 * @Description
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发送消息到企业群 （内部群、全员群、部门群、普通群、合作群）
 */
public class SendMsgToB {

    /**
     * 入参
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class In{
        /**
         * 群会话的ID
         */
        private String chatId;

        /**
         * 消息内容，最长不超过2048个字节
         */
        private Object msg;
    }

    /**
     * 出参
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Out{
        /**
         * 返回码 0:True 非0:False
         */
        private Number errCode;

        /**
         * 返回码描述
         */
        private String errMsg;

        /**
         * 加密的消息id
         */
        private String messageId;
    }
}
