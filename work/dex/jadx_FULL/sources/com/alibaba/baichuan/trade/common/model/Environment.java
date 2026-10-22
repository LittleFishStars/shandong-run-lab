package com.alibaba.baichuan.trade.common.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum Environment {
    SANDBOX(0, "沙箱环境"),
    TEST(1, "测试环境"),
    PRE(2, "预发环境"),
    ONLINE(3, "线上环境");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24547a;
    private String b;

    Environment(int i, String str) {
        this.f24547a = i;
        this.b = str;
    }

    public static Environment valueOfStatus(int i) {
        for (Environment environment : values()) {
            if (i == environment.f24547a) {
                return environment;
            }
        }
        return null;
    }

    public final String getDesc() {
        return this.b;
    }

    public final int getStatus() {
        return this.f24547a;
    }

    public final void setDesc(String str) {
        this.b = str;
    }

    public final void setStatus(int i) {
        this.f24547a = i;
    }
}
