package com.ghc.springboot.notice.dingTalk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2022/11/22 /11:13
 * @Author guohc
 * @Description
 */

/**
 * MarkDown格式消息实体
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarkDown {
    /**
     * 首屏会话透出的展示内容
     */
    private String title;

    /**
     * markdown格式的消息，最大不超过5000字符
     */
    private String text;
}
