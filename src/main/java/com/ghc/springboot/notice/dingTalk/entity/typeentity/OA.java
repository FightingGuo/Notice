package com.ghc.springboot.notice.dingTalk.entity.typeentity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Date 2022/11/22 /11:11
 * @Author guohc
 * @Description
 */

/**
 * OA消息实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OA {
    /**
     * 消息点击链接地址，当发送消息为小程序时支持小程序跳转链接
     */
    private String message_url;

    /**
     * PC端点击消息时跳转到的地址
     */
    private String pc_message_url;

    /**
     * 消息头部内容。
     */
    private Head head;

    /**
     * 消息体
     */
    private Body body;
}
