package com.ghc.springboot.notice.dingTalk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取钉钉应用的accessToken
 */
public class GetAccessTokenDTO {

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
         *
         * 返回码描述
         */
        private String errMsg;

        /**
         * access_token的过期时间，单位秒
         */
        private Number expiresIn;

        /**
         * access_token
         */
        private String accessToken;
    }
}
