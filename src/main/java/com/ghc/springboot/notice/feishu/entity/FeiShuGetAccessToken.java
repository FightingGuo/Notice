package com.ghc.springboot.notice.feishu.entity;

import lombok.Data;

/**
 * @Date 2022/11/23 /11:53
 * @Author guohc
 * @Description
 */
public class FeiShuGetAccessToken {
    @Data
    public static class Out{
        /**
         * 错误描述
         */
        private String msg;

        /**
         * 错误码，非 0 取值表示失败
         */
        private Integer code;

        /**
         *
         * 租户访问凭证
         */
        private String tenantAccessToken;

        /**
         * 凭证的过期时间，单位为秒
         */
        private String expire;
    }
}
