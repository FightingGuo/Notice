package com.ghc.springboot.notice;

/**
 * @author 郭昊晨
 * @version 1.0
 * 2022/11/17 - 22:44
 */

import com.ghc.springboot.notice.entity.ThirdResult;

/**
 * 消息推送接口
 */
public interface Notice {

    /**
     * 获取access_token
     */
    ThirdResult getAccessToken();

    /**
     * 发送消息
     */
    ThirdResult sendMsg(Object noticeIn);
}
