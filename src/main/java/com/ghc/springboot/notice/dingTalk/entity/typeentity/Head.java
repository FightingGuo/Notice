package com.ghc.springboot.notice.dingTalk.entity.typeentity;

import lombok.Data;

/**
 * @author 郭昊晨
 * @version 1.0
 * 2022/11/24 - 21:18
 */

/**
 * oa消息实体 嵌套的头部实体
 */
@Data
public class Head {

    /**
     * 消息头部的背景颜色 长度限制为8个英文字符，其中前2为表示透明度，后6位表示颜色值。不要添加0x。
     */
    private String bgcolor;

    /**
     * 头部标题
     */
    private String text;
}
