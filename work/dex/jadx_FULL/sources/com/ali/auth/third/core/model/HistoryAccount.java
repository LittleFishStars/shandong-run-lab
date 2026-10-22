package com.ali.auth.third.core.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HistoryAccount {
    public String autologinToken;
    public String email;
    public String headImg;
    public String mobile;
    public String nick;
    public String tokenKey;
    public String userId;

    public HistoryAccount() {
    }

    public HistoryAccount(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.userId = str;
        this.tokenKey = str2;
        this.nick = str3;
        this.mobile = str4;
        this.email = str5;
        this.autologinToken = str6;
        this.headImg = str7;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String toString() {
        return "" + this.nick;
    }
}
