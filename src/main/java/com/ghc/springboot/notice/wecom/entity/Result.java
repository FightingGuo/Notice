package com.ghc.springboot.notice.wecom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 郭昊晨
 * @version 1.0
 * 2022/11/17 - 22:45
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    /**
     * 信息
     */
    private String Msg;

    /**
     * 返回内容
     */
    private String content;

    /**
     * 是否成功
     */
    private boolean result;
}