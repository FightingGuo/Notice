package com.ghc.springboot.notice.dingTalk.entity.typeentity;

/**
 * @author 郭昊晨
 * @version 1.0
 * 2022/11/24 - 21:41
 */

import lombok.Data;

/**
 * oa消息实体嵌套的StatusBar实体  消息状态栏，只支持接收者的userid列表，userid最多不能超过5个人
 */
@Data
public class StatusBar {
    /**
     * 状态栏文案
     */
    private String status_value;

    /**
     * 状态栏背景色，默认为黑色，推荐0xFF加六位颜色值
     */
    private String status_bg;
}
