package com.huachenjie.im.bean;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ContactUserBean {
    private String accid;
    private String appUserCode;
    private String avatar;
    private String avatarFrameImgUrl;
    private Boolean isMyFriend;
    private String nickName;
    private String remarkNickname = "";
    private int unreadCount = 0;
    private long time = 0;
    private String content = "";

    public String getAccid() {
        return this.accid;
    }

    public String getAppUserCode() {
        return this.appUserCode;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getAvatarFrameImgUrl() {
        return this.avatarFrameImgUrl;
    }

    public String getContent() {
        return this.content;
    }

    public String getNickName() {
        if (TextUtils.isEmpty(this.remarkNickname)) {
            return !TextUtils.isEmpty(this.nickName) ? this.nickName : "";
        }
        return this.remarkNickname;
    }

    public String getRemarkNickname() {
        return this.remarkNickname;
    }

    public long getTime() {
        return this.time;
    }

    public int getUnreadCount() {
        return this.unreadCount;
    }

    public Boolean isMyFriend() {
        return this.isMyFriend;
    }

    public void setAccid(String str) {
        this.accid = str;
    }

    public void setAppUserCode(String str) {
        this.appUserCode = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setAvatarFrameImgUrl(String str) {
        this.avatarFrameImgUrl = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setMyFriend(Boolean bool) {
        this.isMyFriend = bool;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setRemarkNickname(String str) {
        this.remarkNickname = str;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setUnreadCount(int i) {
        this.unreadCount = i;
    }
}
