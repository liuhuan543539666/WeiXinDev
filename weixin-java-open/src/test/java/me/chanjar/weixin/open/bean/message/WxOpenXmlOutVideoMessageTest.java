package me.chanjar.weixin.open.bean.message;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class WxOpenXmlOutVideoMessageTest {

    public void test() {
        WxOpenXmlOutVideoMessage m = new WxOpenXmlOutVideoMessage();
        m.setMediaId("media_id");
        m.setTitle("title");
        m.setDescription("ddfff");
        m.setCreateTime(1122l);
        m.setFromUserName("fromUser");
        m.setToUserName("toUser");

        String expected = "<xml>"
                + "<ToUserName><![CDATA[toUser]]></ToUserName>"
                + "<FromUserName><![CDATA[fromUser]]></FromUserName>"
                + "<CreateTime>1122</CreateTime>"
                + "<MsgType><![CDATA[video]]></MsgType>"
                + "<Video>"
                + "<MediaId><![CDATA[media_id]]></MediaId>"
                + "<Title><![CDATA[title]]></Title>"
                + "<Description><![CDATA[ddfff]]></Description>"
                + "</Video> "
                + "</xml>";
        System.out.println(m.toXml());
        Assert.assertEquals(m.toXml().replaceAll("\\s", ""), expected.replaceAll("\\s", ""));
    }

    public void testBuild() {
        WxOpenXmlOutVideoMessage m = WxOpenXmlOutMessage.VIDEO()
                .mediaId("media_id")
                .fromUser("fromUser")
                .toUser("toUser")
                .title("title")
                .description("ddfff")
                .build();
        String expected = "<xml>"
                + "<ToUserName><![CDATA[toUser]]></ToUserName>"
                + "<FromUserName><![CDATA[fromUser]]></FromUserName>"
                + "<CreateTime>1122</CreateTime>"
                + "<MsgType><![CDATA[video]]></MsgType>"
                + "<Video>"
                + "<MediaId><![CDATA[media_id]]></MediaId>"
                + "<Title><![CDATA[title]]></Title>"
                + "<Description><![CDATA[ddfff]]></Description>"
                + "</Video> "
                + "</xml>";
        System.out.println(m.toXml());
        Assert.assertEquals(
                m
                        .toXml()
                        .replaceAll("\\s", "")
                        .replaceAll("<CreateTime>.*?</CreateTime>", ""),
                expected
                        .replaceAll("\\s", "")
                        .replaceAll("<CreateTime>.*?</CreateTime>", "")
        );
    }

}
