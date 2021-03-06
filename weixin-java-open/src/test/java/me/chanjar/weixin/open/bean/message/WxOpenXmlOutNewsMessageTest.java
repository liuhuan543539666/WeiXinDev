package me.chanjar.weixin.open.bean.message;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class WxOpenXmlOutNewsMessageTest {

    public void test() {
        WxOpenXmlOutNewsMessage m = new WxOpenXmlOutNewsMessage();
        m.setCreateTime(1122l);
        m.setFromUserName("fromUser");
        m.setToUserName("toUser");

        WxOpenXmlOutNewsMessage.Item item = new WxOpenXmlOutNewsMessage.Item();
        item.setDescription("description");
        item.setPicUrl("picUrl");
        item.setTitle("title");
        item.setUrl("url");
        m.addArticle(item);
        m.addArticle(item);
        String expected = "<xml>"
                + "<ToUserName><![CDATA[toUser]]></ToUserName>"
                + "<FromUserName><![CDATA[fromUser]]></FromUserName>"
                + "<CreateTime>1122</CreateTime>"
                + "<MsgType><![CDATA[news]]></MsgType>"
                + "    <ArticleCount>2</ArticleCount>"
                + "    <Articles>"
                + "        <item>"
                + "            <Title><![CDATA[title]]></Title>"
                + "            <Description><![CDATA[description]]></Description>"
                + "            <PicUrl><![CDATA[picUrl]]></PicUrl>"
                + "            <Url><![CDATA[url]]></Url>"
                + "        </item>"
                + "        <item>"
                + "            <Title><![CDATA[title]]></Title>"
                + "            <Description><![CDATA[description]]></Description>"
                + "            <PicUrl><![CDATA[picUrl]]></PicUrl>"
                + "            <Url><![CDATA[url]]></Url>"
                + "        </item>"
                + "    </Articles>"
                + "</xml>";
        System.out.println(m.toXml());
        Assert.assertEquals(m.toXml().replaceAll("\\s", ""), expected.replaceAll("\\s", ""));
    }

    public void testBuild() {
        WxOpenXmlOutNewsMessage.Item item = new WxOpenXmlOutNewsMessage.Item();
        item.setDescription("description");
        item.setPicUrl("picUrl");
        item.setTitle("title");
        item.setUrl("url");

        WxOpenXmlOutNewsMessage m = WxOpenXmlOutMessage.NEWS()
                .fromUser("fromUser")
                .toUser("toUser")
                .addArticle(item)
                .addArticle(item)
                .build();
        String expected = "<xml>"
                + "<ToUserName><![CDATA[toUser]]></ToUserName>"
                + "<FromUserName><![CDATA[fromUser]]></FromUserName>"
                + "<CreateTime>1122</CreateTime>"
                + "<MsgType><![CDATA[news]]></MsgType>"
                + "    <ArticleCount>2</ArticleCount>"
                + "    <Articles>"
                + "        <item>"
                + "            <Title><![CDATA[title]]></Title>"
                + "            <Description><![CDATA[description]]></Description>"
                + "            <PicUrl><![CDATA[picUrl]]></PicUrl>"
                + "            <Url><![CDATA[url]]></Url>"
                + "        </item>"
                + "        <item>"
                + "            <Title><![CDATA[title]]></Title>"
                + "            <Description><![CDATA[description]]></Description>"
                + "            <PicUrl><![CDATA[picUrl]]></PicUrl>"
                + "            <Url><![CDATA[url]]></Url>"
                + "        </item>"
                + "    </Articles>"
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
