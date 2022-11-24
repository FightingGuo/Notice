package com.ghc.springboot.notice.dingTalk.entity.typeentity;

import lombok.Data;

import java.util.Map;

/**
 * @author 郭昊晨
 * @version 1.0
 * 2022/11/24 - 21:17
 */

/**
 * oa消息嵌套实体
 */
@Data
public class Body {
    /**
     * 消息体的标题，建议50个字符以内
     */
    private String title;

    /**
     * 消息体的表单，最多显示6个，超过会被隐藏
     */
    private Map<String,String> form;

    /**
     * 单行富文本信息
     */
    private Rich rich;

    /**
     * 消息体的内容，最多显示3行
     */
    private String content;

    /**
     * 消息体中的图片，支持图片资源@mediaId。建议宽600像素 x 400像素，宽高比3 : 2 企业内部应用通过上传媒体文件接口获取
     */
    private String image;

    /**
     * 自定义的附件数目。此数字仅供显示，钉钉不作验证
     */
    private String file_count;

    /**
     * 自定义的作者名字
     */
    private String author;

}
