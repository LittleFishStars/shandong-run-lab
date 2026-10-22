package com.kc.cw.ad.c.e;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f38739a;
    String b;
    String c;
    int d;

    public b(String str) {
        this.c = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.f38739a = j;
    }

    public void a(String str) {
        this.b = str;
    }

    public boolean a() {
        return this.f38739a > System.currentTimeMillis();
    }

    public void b() {
        this.f38739a = 0L;
    }
}
