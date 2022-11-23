package com.ghc.springboot.notice.feishu.entity;

/**
 * @Date 2022/11/23 /11:11
 * @Author guohc
 * @Description  被@的用户或机器人的id列表
 */
@entity.Data
public class Mentions {
    /**
     * 被@的用户或机器人的序号。例如，第3个被@到的成员，值为“@_user_3”
     */
    private String key;

    /**
     * 被@的用户或者机器人的open_id
     */
    private String id;

    /**
     * 被@的用户或机器人 id 类型
     */
    private String idType;

    /**
     * 被@的用户或机器人的姓名
     */
    private String name;

    /**
     * 为租户在飞书上的唯一标识，用来换取对应的tenant_access_token，也可以用作租户在应用里面的唯一标识
     */
    private String tenantKey;

    /**
     * 合并转发消息中，上一层级的消息id message_id
     */
    private String upperMessageId;
}
