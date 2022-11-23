package com.ghc.springboot.notice.dingTalk.entity;

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
    private String messageUrl;

    /**
     * PC端点击消息时跳转到的地址
     */
    private String PcMessageUrl;

    /**
     * 消息头部内容。
     */
    private String head;

    /**
     * 消息头部的背景颜色。长度限制为8个英文字符，其中前2为表示透明度，后6位表示颜色值。不要添加0x
     */
    private String headBgColor;

    /**
     * 消息的头部标题。企业内部应用:如果是发送工作通知消息，该参数会被替换为当前应用名称。 如果是发送消息到企业群或者发送普通消息，该参数有效，长度限制为最多10个字符
     */
    private String headText;

    /**
     * 消息状态栏，只支持接收者的userid列表，userid最多不能超过5个人
     */
    private JSONObject statusBar;

    /**
     * 状态栏文案
     */
    private String statusBarStatusValue;

    /**
     * 状态栏背景色，默认为黑色，推荐0xFF加六位颜色值
     */
    private String statusBarStatusBg;

    /**
     * 消息体
     */
    private JSONObject body;

    /**
     * 消息体的标题，建议50个字符以内
     */
    private String bodyTitle;

    /**
     * 消息体的表单，最多显示6个，超过会被隐藏
     */
    private List<JSONObject> bodyForm;

    /**
     * 消息体的关键字
     */
    private String bodyFormKey;

    /**
     * 消息体的关键字对应的值
     */
    private String bodyFormValue;

    /**
     * 单行富文本信息
     */
    private JSONObject bodyRich;

    /**
     * 单行富文本信息的数目
     */
    private String bodyRichNum;

    /**
     * 单行富文本信息的单位
     */
    private String bodyRichUnit;

    /**
     * 消息体的内容，最多显示3行
     */
    private String bodyRichContent;

    /**
     * 消息体中的图片，支持图片资源@mediaId。建议宽600像素 x 400像素，宽高比3 : 2  企业内部应用通过上传媒体文件接口获取
     */
    private String bodyImage;

    /**
     * 自定义的附件数目。此数字仅供显示，钉钉不作验证
     */
    private String StringFileCount;

    /**
     * 自定义的作者名字
     */
    private String bodyAuthor;
}
