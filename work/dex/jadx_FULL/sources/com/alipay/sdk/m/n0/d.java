package com.alipay.sdk.m.n0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25473a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public d(String str, int i) {
        this.f25473a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f25473a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
