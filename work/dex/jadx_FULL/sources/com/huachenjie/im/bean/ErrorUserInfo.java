package com.huachenjie.im.bean;

import com.netease.nimlib.sdk.uinfo.constant.GenderEnum;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ErrorUserInfo implements NimUserInfo {
    private String account = "";
    private String name = "";
    private String avatar = "";

    public String getAccount() {
        return this.account;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getBirthday() {
        return "";
    }

    public String getEmail() {
        return "";
    }

    public String getExtension() {
        return "";
    }

    public Map<String, Object> getExtensionMap() {
        return new HashMap();
    }

    public GenderEnum getGenderEnum() {
        return GenderEnum.UNKNOWN;
    }

    public String getMobile() {
        return "";
    }

    public String getName() {
        return this.name;
    }

    public String getSignature() {
        return "";
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
