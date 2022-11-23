package com.ghc.springboot.notice.feishu.entity;

/**
 * @Date 2022/11/23 /11:01
 * @Author guohc
 * @Description
 */
@lombok.Data
public class Data {

    /**
     * 消息id
     */
    private String messageId;

    /**
     * 根消息id，用于回复消息场景
     */
    private String rootId;

    /**
     * 父消息的id，用于回复消息场景
     */
    private String parentId;

    /**
     * 消息类型
     */
    private String msgType;

    /**
     * 消息生成的时间戳
     */
    private String createTime;

    /**
     * 消息更新的时间戳
     */
    private String updateTime;

    /**
     * 消息是否被撤回
     */
    private Boolean deleted;

    /**
     * 消息是否被更新
     */
    private Boolean updated;

    /**
     * 所属的群
     */
    private String chatId;
}
