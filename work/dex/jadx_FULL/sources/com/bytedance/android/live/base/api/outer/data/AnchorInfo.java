package com.bytedance.android.live.base.api.outer.data;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class AnchorInfo {
    String avatar;
    long fansCount;
    String nickname;
    String openId;

    public AnchorInfo() {
    }

    public AnchorInfo(String str, String str2, String str3, long j) {
        this.openId = str;
        this.nickname = str2;
        this.avatar = str3;
        this.fansCount = j;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getFansCount() {
        return this.fansCount;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setFansCount(long j) {
        this.fansCount = j;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }
}
