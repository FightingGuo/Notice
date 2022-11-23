package com.ghc.springboot.notice.feishu.constant;

/**
 * @Date 2022/11/23 /11:39
 * @Author guohc
 * @Description
 */
public class FeiShuConstant {
    /**
     * 获取tenant_access_token  post
     */
    public static final String GET_TOKEN_RUL = "https://open.feishu.cn/open-apis/auth/v3/tenant_access_token/internal";

    /**
     * 飞书消息推送地址  post
     */
    public static final String SEND_MSG_RUL = "https://open.feishu.cn/open-apis/im/v1/messages";
}
