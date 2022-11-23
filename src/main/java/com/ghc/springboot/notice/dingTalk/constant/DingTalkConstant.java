package com.ghc.springboot.notice.dingTalk.constant;

/**
 * 钉钉消息推送常量
 */
public class DingTalkConstant {


    /**
     * 获取accessToken                   GetAccessToken
     */
    public static final String GET_ACCESS_TOKEN_URL = "https://oapi.dingtalk.com/gettoken";


    /**
     * 发送普通消息接口地址                 SendMsgByEmpDTO
     */
    public static final String SEND_COMMON_MSG_URL = "https://oapi.dingtalk.com/message/send_to_conversation?access_token=";

    /**
     * 发送工作通知消息接口地址              SendTaskMsgDTO
     */
    public static final String SEND_TASK_MSG_URL = "https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2?access_token=";

    /**
     * 更新工作通知状态栏消息接口地址         UpdateTaskStatusDTO
     */
    public static final String UPDATE_TASK_STATUS_URL = "https://oapi.dingtalk.com/topapi/message/corpconversation/status_bar/update?access_token=";

    /**
     * 获取工作通知消息的发送进度接口地址      TaskMsgDTO
     */
    public static final String GTE_TASK_MSG_PROGRESS_URL = "https://oapi.dingtalk.com/topapi/message/corpconversation/getsendprogress?access_token=";

    /**
     * 获取工作通知消息的发送结果接口地址      TaskMsgDTO
     */
    public static final String GTE_TASK_MSG_RESULT_URL = "https://oapi.dingtalk.com/topapi/message/corpconversation/getsendresult?access_token=";


    /**
     * 撤回工作消息                        TaskMsgDTO
     */
    public static final String RECALL_TASK_MSG_URL = "https://oapi.dingtalk.com/topapi/message/corpconversation/recall?access_token=";

    /**
     * 发送消息到企业内部群                  SendMsgToB
     */
    public static final String SEND_MSG_TO_BUSINESS_URL = "https://oapi.dingtalk.com/chat/send?access_token=";

    /**
     * 查询群消息已读人员                    QueryReadMsgCount
     */
    public static final String QUERY_READ_MSG_COUNT_URL = "https://oapi.dingtalk.com/chat/getReadList?access_token=";
}
