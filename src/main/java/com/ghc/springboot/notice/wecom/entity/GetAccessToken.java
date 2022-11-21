package com.ghc.springboot.notice.wecom.entity;

/**
 * @author 郭昊晨
 * @version 1.0
 * 2022/11/17 - 22:40
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取企业的access_token
 */
public class GetAccessToken {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Out{
        /**
         * 获取token
         */
        private String accessToken;

        /**
         * 过期时间
         */
        private String expireIn;

        /**
         * 返回码
         */
        private int errCode;

        /**
         * 对返回码的文本描述内容
         */
        private String errMsg;
    }
}
