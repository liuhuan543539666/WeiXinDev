package me.chanjar.weixin.open.util.xml;

import com.thoughtworks.xstream.XStream;
import me.chanjar.weixin.common.util.xml.XStreamInitializer;
import me.chanjar.weixin.open.bean.message.*;

import java.io.InputStream;
import java.util.*;

public class XStreamTransformer {
    private static final Map<Class<?>, XStream> CLASS_2_XSTREAM_INSTANCE = new HashMap<>();

    static {
//    registerClass(WxOpenXmlMessage.class);
        registerClass(WxOpenXmlOutMusicMessage.class);
        registerClass(WxOpenXmlOutNewsMessage.class);
        registerClass(WxOpenXmlOutTextMessage.class);
        registerClass(WxOpenXmlOutImageMessage.class);
        registerClass(WxOpenXmlOutVideoMessage.class);
        registerClass(WxOpenXmlOutVoiceMessage.class);
        registerClass(WxOpenXmlOutTransferKefuMessage.class);
        registerClass(WxOpenXmlAuthorizeMessage.class);
        registerClass(WxOpenXmlMessage.class);
        registerClass(WxOpenXmlOutMessage.class);
    }

    /**
     * xml -&gt; pojo
     */
    @SuppressWarnings("unchecked")
    public static <T> T fromXml(Class<T> clazz, String xml) {
        T object = (T) CLASS_2_XSTREAM_INSTANCE.get(clazz).fromXML(xml);
        return object;
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromXml(Class<T> clazz, InputStream is) {
        T object = (T) CLASS_2_XSTREAM_INSTANCE.get(clazz).fromXML(is);
        return object;
    }

    /**
     * pojo -&gt; xml
     */
    public static <T> String toXml(Class<T> clazz, T object) {
        return CLASS_2_XSTREAM_INSTANCE.get(clazz).toXML(object);
    }

    /**
     * 注册扩展消息的解析器
     *
     * @param clz     类型
     * @param xStream xml解析器
     */
    public static void register(Class<?> clz, XStream xStream) {
        CLASS_2_XSTREAM_INSTANCE.put(clz, xStream);
    }

    /**
     * 会自动注册该类及其子类
     *
     * @param clz 要注册的类
     */
    public static void registerClass(Class<?> clz) {
        XStream xstream = XStreamInitializer.getInstance();
        xstream.setClassLoader(clz.getClassLoader());
        xstream.processAnnotations(clz);
        xstream.processAnnotations(getInnerClasses(clz));
        register(clz, xstream);
    }

    private static Class<?>[] getInnerClasses(Class<?> clz) {
        Class<?>[] innerClasses = clz.getClasses();
        if (innerClasses == null) {
            return null;
        }

        List<Class<?>> result = new ArrayList<>();
        result.addAll(Arrays.asList(innerClasses));
        for (Class<?> inner : innerClasses) {
            Class<?>[] innerClz = getInnerClasses(inner);
            if (innerClz == null) {
                continue;
            }

            result.addAll(Arrays.asList(innerClz));
        }

        return result.toArray(new Class<?>[0]);
    }
}
