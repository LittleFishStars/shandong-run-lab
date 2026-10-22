package com.kc.cw.ad.c.e;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f38743a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public f(String str, int i) {
        this.f38743a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f38743a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
