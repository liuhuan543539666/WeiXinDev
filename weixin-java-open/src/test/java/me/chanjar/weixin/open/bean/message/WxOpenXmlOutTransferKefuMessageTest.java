package me.chanjar.weixin.open.bean.message;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ben on 2015/12/29.
 */
public class WxOpenXmlOutTransferKefuMessageTest {
    @Test
    public void test() {
        WxOpenXmlOutTransferKefuMessage m = new WxOpenXmlOutTransferKefuMessage();
        m.setCreateTime(1399197672L);
        m.setFromUserName("fromuser");
        m.setToUserName("touser");

        String expected = "<xml>" +
                "<ToUserName><![CDATA[touser]]></ToUserName>" +
                "<FromUserName><![CDATA[fromuser]]></FromUserName>" +
                "<CreateTime>1399197672</CreateTime>" +
                "<MsgType><![CDATA[transfer_customer_service]]></MsgType>" +
                "</xml>";
        System.out.println(m.toXml());
        Assert.assertEquals(m.toXml().replaceAll("\\s", ""), expected.replaceAll("\\s", ""));

        expected = " <xml>" +
                "<ToUserName><![CDATA[touser]]></ToUserName>" +
                "<FromUserName><![CDATA[fromuser]]></FromUserName>" +
                "<CreateTime>1399197672</CreateTime>" +
                "<MsgType><![CDATA[transfer_customer_service]]></MsgType>" +
                "<TransInfo>" +
                "<KfAccount><![CDATA[test1@test]]></KfAccount>" +
                "</TransInfo>" +
                "</xml>";
        WxOpenXmlOutTransferKefuMessage.TransInfo transInfo = new WxOpenXmlOutTransferKefuMessage.TransInfo();
        transInfo.setKfAccount("test1@test");
        m.setTransInfo(transInfo);
        System.out.println(m.toXml());
        Assert.assertEquals(m.toXml().replaceAll("\\s", ""), expected.replaceAll("\\s", ""));
    }

    @Test
    public void testBuild() {
        WxOpenXmlOutTransferKefuMessage m = WxOpenXmlOutMessage.TRANSFER_CUSTOMER_SERVICE().fromUser("fromuser").toUser("touser").build();
        m.setCreateTime(1399197672L);
        String expected = "<xml>" +
                "<ToUserName><![CDATA[touser]]></ToUserName>" +
                "<FromUserName><![CDATA[fromuser]]></FromUserName>" +
                "<CreateTime>1399197672</CreateTime>" +
                "<MsgType><![CDATA[transfer_customer_service]]></MsgType>" +
                "</xml>";
        System.out.println(m.toXml());
        Assert.assertEquals(m.toXml().replaceAll("\\s", ""), expected.replaceAll("\\s", ""));


        expected = " <xml>" +
                "<ToUserName><![CDATA[touser]]></ToUserName>" +
                "<FromUserName><![CDATA[fromuser]]></FromUserName>" +
                "<CreateTime>1399197672</CreateTime>" +
                "<MsgType><![CDATA[transfer_customer_service]]></MsgType>" +
                "<TransInfo>" +
                "<KfAccount><![CDATA[test1@test]]></KfAccount>" +
                "</TransInfo>" +
                "</xml>";
        m = WxOpenXmlOutMessage.TRANSFER_CUSTOMER_SERVICE().kfAccount("test1@test").fromUser("fromuser").toUser("touser").build();
        m.setCreateTime(1399197672L);
        System.out.println(m.toXml());
        Assert.assertEquals(m.toXml().replaceAll("\\s", ""), expected.replaceAll("\\s", ""));
    }
}
