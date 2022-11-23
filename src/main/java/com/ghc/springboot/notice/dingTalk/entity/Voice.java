package com.ghc.springboot.notice.dingTalk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2022/11/22 /11:08
 * @Author guohc
 * @Description
 */

/**
 * 音频消息实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Voice {
    /**
     * 媒体文件id
     */
    private String mediaId;

    /**
     * 正整数，小于60，表示音频时长
     */
    private String duration;
}
