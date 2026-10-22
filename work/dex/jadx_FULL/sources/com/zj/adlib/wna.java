package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.amap.api.col.p0003l.gx(a = "update_item")
public class wna {

    @com.amap.api.col.p0003l.gy(a = "mCompleteCode", b = 2)
    public int b;

    @com.amap.api.col.p0003l.gy(a = "mState", b = 2)
    public int c;

    @com.amap.api.col.p0003l.gy(a = "localPath", b = 6)
    public String f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @com.amap.api.col.p0003l.gy(a = "title", b = 6)
    public String f20477a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @com.amap.api.col.p0003l.gy(a = "url", b = 6)
    public String f20479b = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @com.amap.api.col.p0003l.gy(a = "mAdcode", b = 6)
    public String f20480c = null;

    @com.amap.api.col.p0003l.gy(a = "fileName", b = 6)
    public String d = null;

    @com.amap.api.col.p0003l.gy(a = "version", b = 6)
    public String e = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @com.amap.api.col.p0003l.gy(a = "lLocalLength", b = 5)
    public long f20476a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @com.amap.api.col.p0003l.gy(a = "lRemoteLength", b = 5)
    public long f20478b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.amap.api.col.p0003l.gy(a = "isProvince", b = 2)
    public int f45641a = 0;

    @com.amap.api.col.p0003l.gy(a = "mCityCode", b = 6)
    public String g = "";

    @com.amap.api.col.p0003l.gy(a = "mPinyin", b = 6)
    public String h = "";

    public static String f(String str) {
        return "mAdcode='" + str + "'";
    }

    public static String h(String str) {
        return "mPinyin='" + str + "'";
    }

    public final String a() {
        return this.f20477a;
    }

    public final void b(String str) {
        this.f20480c = str;
    }

    public final String c() {
        return this.e;
    }

    public final void d(String str) {
        this.g = str;
    }

    public final String e() {
        return this.f20480c;
    }

    public final String g() {
        return this.f20479b;
    }

    public final int i() {
        return this.b;
    }

    public final String j() {
        return this.h;
    }
}
