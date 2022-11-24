package com.ghc.springboot.notice.dingTalk.entity;

/**
 * @Date 2022/11/21 /17:23
 * @Author guohc
 * @Description
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工作通知消息DTO（获取工作通知消息发送进度/结果  撤回工作通知消息）
 */
public class TaskMsgDTO {

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
        private Number agentId;

        /**
         * 发送消息时钉钉返回的任务ID
         */
        private Number taskId;

        /**
         * 发送消息时钉钉返回的任务ID (用来撤回消息)
         */
        private Number msgTaskId;
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
         * 返回码 0:True 非0:False
         */
        private Number errCode;

        /**
         * 返回描述
         */
        private String errMsg;

        /**
         * 返回进度     返回示例：progress": {"progress_in_percent": 100, "status": 2 },
         */
        private Object progress;

        /**
         * 返回结果   返回示例："send_result": {"failed_user_id_list": [],"forbidden_list": [],"invalid_dept_id_list": [],"invalid_user_id_list": [],
         * "read_user_id_list": [],"unread_user_id_list": []
         */
        private Object sendResult;


    }
}
