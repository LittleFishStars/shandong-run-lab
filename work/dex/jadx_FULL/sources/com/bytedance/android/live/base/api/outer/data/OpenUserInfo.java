package com.bytedance.android.live.base.api.outer.data;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class OpenUserInfo {
    public String avatar;
    private String nickName;

    public OpenUserInfo() {
    }

    public OpenUserInfo(String str, String str2) {
        this.nickName = str;
        this.avatar = str2;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNickName() {
        return this.nickName;
    }
}
