package com.ali.auth.third.core.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Session {
    public String avatarUrl;
    public String havanaSsoToken;
    public String nick;
    public String openId;
    public String openSid;
    public String ssoToken;
    public String topAccessToken;
    public String topAuthCode;
    public String topExpireTime;
    public String userid;

    public String toString() {
        return "nick = " + this.nick + ", ava = " + this.avatarUrl + " , openId=" + this.openId + ", openSid=" + this.openSid + ", topAccessToken=" + this.topAccessToken + ", topAuthCode=" + this.topAuthCode + ",topExpireTime=" + this.topExpireTime;
    }
}
