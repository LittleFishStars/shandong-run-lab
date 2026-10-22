package com.alibaba.sdk.android.oss.common;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum HttpProtocol {
    HTTP("http"),
    HTTPS("https");

    private final String httpProtocol;

    HttpProtocol(String str) {
        this.httpProtocol = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.httpProtocol;
    }
}
