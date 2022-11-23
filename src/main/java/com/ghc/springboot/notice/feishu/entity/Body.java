package com.ghc.springboot.notice.feishu.entity;

/**
 * @Date 2022/11/23 /11:01
 * @Author guohc
 * @Description 消息内容
 */
@entity.Data
public class Body {
    /**
     * 消息内容，json结构序列化后的字符串
     */
    private String content;
}
