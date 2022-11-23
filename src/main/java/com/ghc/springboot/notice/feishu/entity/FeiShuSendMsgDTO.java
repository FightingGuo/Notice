package com.ghc.springboot.notice.feishu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @Date 2022/11/23 /10:53
 * @Author guohc
 * @Description 飞书消息发送实体
 */

public class FeiShuSendMsgDTO {

    @lombok.Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class In{
        /**
         * 接收者id
         */
        private String receiveId;

        /**
         * 消息类型
         */
        private String msgType;

        /**
         * 消息内容
         */
        private String content;

        /**
         * 唯一字符串序列  (后端随机生成)
         */
//        private String uuid;
    }

    @lombok.Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Out{
        /**
         * 错误码，非 0 取值表示失败
         */
        private Integer code;

        /**
         * 错误描述
         */
        private String msg;

        /**
         * 消息内容
         */
        private Data data;

        /**
         *
         */
        private Sender sender;

        /**
         *
         */
        private Body body;

        /**
         *
         */
        private Mentions mentions;
    }

}
