package com.ghc.springboot.notice.dingTalk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2022/11/22 /11:21
 * @Author guohc
 * @Description
 */

/**
 * 文件实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class File {
    /**
     * 媒体文件id
     */
    private String mediaId;

}
