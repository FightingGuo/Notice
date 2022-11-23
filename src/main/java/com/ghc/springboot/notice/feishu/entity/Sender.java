package com.ghc.springboot.notice.feishu.entity;

/**
 * @Date 2022/11/23 /11:08
 * @Author guohc
 * @Description 发送者，可以是用户或应用
 */
@entity.Data
public class Sender {
    /**
     * 发送者的id
     */
    private String id;

    /**
     * 发送者的id类型
     */
    private String idType;

    /**
     * 发送者的类型
     */
    private String senderType;

    /**
     * 为租户在飞书上的唯一标识，用来换取对应的tenant_access_token，也可以用作租户在应用里面的唯一标识
     */
    private String tenantKey;
}
