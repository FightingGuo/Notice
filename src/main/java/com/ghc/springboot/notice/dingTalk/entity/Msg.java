package com.ghc.springboot.notice.dingTalk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2022/11/22 /15:12
 * @Author guohc
 * @Description
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * 设置发送消息类型的实体
 */
public class Msg {

    /**
     * 数据类型
     */
    private String msgType;

    /**
     * 文本类型
     */
    private String text;

    /**
     * 图片类型
     */
    private String image;

    /**
     * 链接类型
     */
    private String link;

    /**
     * 文件类型
     */
    private String file;

    /**
     * markDown格式
     */
    private String markDown;

    /**
     * OA类型
     */
    private String OA;

    /**
     * 音频类型
     */
    private String voice;

}
