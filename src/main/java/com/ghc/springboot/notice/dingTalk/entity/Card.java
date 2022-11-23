package com.ghc.springboot.notice.dingTalk.entity;

import com.alibaba.fastjson.JSONArray;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2022/11/22 /11:15
 * @Author guohc
 * @Description
 */

/**
 * 卡片消息实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    /**
     * 消息内容，支持markdown，语法参考标准markdown语法。建议1000个字符以内
     */
    private String actionCardMarkDown;

    /**
     * 透出到会话列表和通知的文案
     */
    private String actionCardTitle;

    /**
     * 使用整体跳转ActionCard样式时的标题。必须与single_url同时设置，最长20个字符
     */
    private String actionCardSingleTitle;

    /**
     * 消息点击链接地址，当发送消息为小程序时支持小程序跳转链接，最长500个字符
     */
    private String actionSingleUrl;

    /**
     * 使用独立跳转ActionCard样式时的按钮排列方式 0：竖直排列 1：横向排列  必须与btn_json_list同时设置
     */
    private String actionCardBtnOrientation;

    /**
     * 使用独立跳转ActionCard样式时的按钮列表；必须与btn_orientation同时设置，且长度不超过1000字符
     */
    private JSONArray actionCardBtnJsonList;

    /**
     * 使用独立跳转ActionCard样式时的按钮的标题，最长20个字符
     */
    private String actionCardBtnJsonListTitle;

    /**
     * 使用独立跳转ActionCard样式时的跳转链接，最长700个字符
     */
    private String actionCardBtnJsonListActionUrl;
}
