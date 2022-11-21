package com.ghc.springboot.notice.wecom.constant;

/**
 * @author 郭昊晨
 * @version 1.0
 * 2022/11/17 - 22:18
 */
public class WeComConstant {
    /**
     * 创建会话请求URL
     */
    public final static String CREATE_SESSION_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";

    /**
     * 获取访问权限码URL
     */
    public static final  String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";

    /**
     * 获取accessToken失败
     */
    public static final String GET_ACCESS_TOKEN_FAIL = "获取accessToken失败";

    /**
     * 发送消息失败
     */
    public static final String SEND_WECOM_MSG_FAIL = "发送消息失败：%s";
}
