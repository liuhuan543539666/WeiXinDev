package me.chanjar.weixin.common.bean.menu;

import me.chanjar.weixin.common.util.ToStringUtils;

import java.io.Serializable;

public class WxMenuRule implements Serializable {
    private static final long serialVersionUID = -4587181819499286670L;

    private String tagId;
    private String sex;
    private String country;
    private String province;
    private String city;
    private String clientPlatformType;
    private String language;


    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    public String getTagId() {
        return tagId;
    }

    public WxMenuRule setTagId(String tagId) {
        this.tagId = tagId;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public WxMenuRule setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public WxMenuRule setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public WxMenuRule setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public WxMenuRule setCity(String city) {
        this.city = city;
        return this;
    }

    public String getClientPlatformType() {
        return clientPlatformType;
    }

    public WxMenuRule setClientPlatformType(String clientPlatformType) {
        this.clientPlatformType = clientPlatformType;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public WxMenuRule setLanguage(String language) {
        this.language = language;
        return this;
    }
}
