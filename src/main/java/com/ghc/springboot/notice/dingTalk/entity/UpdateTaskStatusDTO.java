package com.ghc.springboot.notice.dingTalk.entity;

/**
 * @Date 2022/11/21 /17:03
 * @Author guohc
 * @Description
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新工作通知状态栏对象
 */
public class UpdateTaskStatusDTO {

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
         * 工作通知任务ID
         */
        private Number taskId;

        /**
         *
         * 状态栏值
         */
        private String statusValue;

        /**
         * 状态栏背景色，推荐0xFF加六位颜色值  非必要参数
         */
        private String statusBg;
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
    }
}
