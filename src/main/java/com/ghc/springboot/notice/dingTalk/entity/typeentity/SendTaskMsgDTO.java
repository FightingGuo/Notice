package com.ghc.springboot.notice.dingTalk.entity.typeentity;

/**
 * @Date 2022/11/21 /16:17
 * @Author guohc
 * @Description
 */

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发送工作通知消息对象
 */
public class SendTaskMsgDTO {

    /**
     * 传入参数
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class In{
        /**
         * 发送消息时使用的微应用的AgentID
         */
        private Long agentId;

        /**
         * 接收者的userid列表，最大用户列表长度100
         */
        private String userIdList;

        /**
         * 接收者的部门id列表，最大列表长度20 接收者是部门ID时，包括子部门下的所有用户
         */
        private String deptIdList;

        /**
         * 是否发送给企业全部用户
         */
        private Boolean toAllUser;

        /**
         * 消息内容，最长不超过2048个字节，支持以下消息类型：文本消息 图文消息 语音消息 文件消息 链接消息 OA消息 Markdown消息 卡片消息
         */
        private JSONObject msg;
    }

    /**
     * 传出参数
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Out{
        /**
         * 请求ID
         */
        private String requestId;

        /**
         * 返回码描述
         */
        private String errMsg;

        /**
         * 返回码 0:True 非0:False
         */
        private Number errCode;

        /**
         * 创建的异步发送任务ID
         */
        private Number taskId;
    }
}
