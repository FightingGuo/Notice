package com.ghc.springboot.notice.dingTalk.entity.typeentity;

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
public class ActionCard {
    /**
     * 透出到会话列表和通知的文案
     */
    private String title;

    /**
     * 消息内容，支持markdown，语法参考标准markdown语法。建议1000个字符以内
     */
    private MarkDown markdown;

    /**
     * 使用整体跳转ActionCard样式时的标题。必须与single_url同时设置，最长20个字符
     */
    private String single_title;

    /**
     * 消息点击链接地址，当发送消息为小程序时支持小程序跳转链接，最长500个字符
     */
    private String single_url;

    /**
     * 消息点击链接地址，当发送消息为小程序时支持小程序跳转链接，最长500个字符
     */
    private String btn_orientation;
}
