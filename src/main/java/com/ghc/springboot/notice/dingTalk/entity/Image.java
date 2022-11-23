package com.ghc.springboot.notice.dingTalk.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @Date 2022/11/22 /11:10
 * @Author guohc
 * @Description
 */


/**
 * 图片消息实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    /**
     * 媒体文件mediaid，建议宽600像素 x 400像素，宽高比3 : 2
     */
    private String mediaId;

}
