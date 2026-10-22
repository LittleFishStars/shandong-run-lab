package com.huawei.hms.push.ups.entity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class TokenResult extends CodeResult {
    private String c;

    public TokenResult() {
    }

    public String getToken() {
        return this.c;
    }

    public void setToken(String str) {
        this.c = str;
    }

    public TokenResult(int i) {
        super(i);
    }

    public TokenResult(int i, String str) {
        super(i, str);
    }

    public TokenResult(String str) {
        this.c = str;
    }
}
