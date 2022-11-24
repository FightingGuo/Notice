package com.ghc.springboot.notice.dingTalk.entity.typeentity;

import lombok.Data;

/**
 * @author 郭昊晨
 * @version 1.0
 * 2022/11/24 - 21:27
 */

/**
 * oa消息实体嵌套的Rich实体  单行富文本信息
 */
@Data
public class Rich {
    /**
     * 单行富文本信息的数目
     */
    private String num;

    /**
     * 单行富文本信息的单位
     */
    private String unit;
}
