package com.ghc.springboot.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 郭昊晨
 * @version 1.0
 * 2022/11/23 - 20:55
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThirdResult {
    /**
     * 信息
     */
    private String Msg;

    /**
     * 返回内容
     */
    private Object content;

    /**
     * 是否成功
     */
    private boolean result;
}
