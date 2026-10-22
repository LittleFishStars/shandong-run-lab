package com.alipay.sdk.m.n0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f25470a;
    public String b;
    public String c;
    public int d;

    public a(String str) {
        this.c = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.f25470a = j;
    }

    public void a(String str) {
        this.b = str;
    }

    public boolean a() {
        return this.f25470a > System.currentTimeMillis();
    }

    public void b() {
        this.f25470a = 0L;
    }
}
