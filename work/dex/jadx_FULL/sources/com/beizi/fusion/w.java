package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum w {
    INIT_DONE(1, "init success"),
    ALREADY_INIT(2, "already_init"),
    ERROR_CONFIG_PARSE_FAIL(1003, "config parse fail"),
    ERROR_CONFIG_RESPONSE_ERROR(1004, "config response error"),
    ERROR_CONFIG_APP_ID(1005, "config app id error"),
    ERROR_INIT_WITH_DIFFERENT_APP_ID(1006, "init with different app id"),
    ERROR_CONFIG_REQUEST_TIMEOUT(1007, "request timeout"),
    ERROR_UNEXPECTED(1009, "error unexpected"),
    ERROR_SDK_SUPPORT_CLASS_MISSED(9001, "sdk support class missed, please check all necessary aar has implemented...");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27887a;
    private final String b;

    w(int i, String str) {
        this.b = str;
        this.f27887a = i;
    }

    public int b() {
        return this.f27887a;
    }

    public String c() {
        return this.b;
    }
}
