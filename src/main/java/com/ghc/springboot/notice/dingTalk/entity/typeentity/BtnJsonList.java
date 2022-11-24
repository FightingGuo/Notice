package com.ghc.springboot.notice.dingTalk.entity.typeentity;

import lombok.Data;

/**
 * @author 郭昊晨
 * @version 1.0
 * 2022/11/24 - 21:50
 */

/**
 * ActionCard卡片消息嵌套实体
 */
@Data
public class BtnJsonList {
    /**
     * 消息点击链接地址，当发送消息为小程序时支持小程序跳转链接，最长500个字符
     */
    private String title;

    /**
     * 使用独立跳转ActionCard样式时的跳转链接，最长700个字符
     */
    private String action_url;
}
