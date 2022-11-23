package com.ghc.springboot.notice.dingTalk.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2022/11/22 /11:11
 * @Author guohc
 * @Description
 */

/**
 * 链接消息实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    /**
     * 消息点击链接地址，当发送消息为小程序时支持小程序跳转链接
     */
    private String messageUrl;

    /**
     * 企业内部应用通过上传媒体文件接口获取
     */
    private String picUrl;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息描述
     */
    private String text;
}
