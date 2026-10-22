package com.huachenjie.im.bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class UserInfoBean {
    private Boolean isMyFriend;
    private String appUserCode = "";
    private String accid = "";
    private String avatar = "";
    private String avatarFrameImgUrl = "";
    private String nickName = "";
    private String remarkNickname = "";

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

    public String getNickName() {
        return this.nickName;
    }

    public String getRemarkNickname() {
        return this.remarkNickname;
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

    public void setMyFriend(Boolean bool) {
        this.isMyFriend = bool;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setRemarkNickname(String str) {
        this.remarkNickname = str;
    }
}
