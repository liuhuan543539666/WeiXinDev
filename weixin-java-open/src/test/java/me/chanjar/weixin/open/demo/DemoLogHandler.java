package me.chanjar.weixin.open.demo;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.open.api.WxOpenMessageHandler;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.bean.message.WxOpenXmlMessage;
import me.chanjar.weixin.open.bean.message.WxOpenXmlOutMessage;

import java.util.Map;

/**
 * Created by qianjia on 15/1/22.
 */
public class DemoLogHandler implements WxOpenMessageHandler {
    @Override
    public WxOpenXmlOutMessage handle(WxOpenXmlMessage wxMessage, Map<String, Object> context, WxOpenService wxOpenService,
                                      WxSessionManager sessionManager) {
        System.out.println(wxMessage.toString());
        return null;
    }
}