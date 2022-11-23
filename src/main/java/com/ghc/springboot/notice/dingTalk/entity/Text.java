package com.ghc.springboot.notice.dingTalk.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2022/11/22 /11:06
 * @Author guohc
 * @Description
 */

/**
 * 文本消息实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Text {
    /**
     * 文本内容
     */
    private String content;

}
