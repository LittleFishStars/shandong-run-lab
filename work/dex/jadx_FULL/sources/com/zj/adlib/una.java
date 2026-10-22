package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.amap.api.col.p0003l.gx(a = "update_item_download_info")
public class una {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.amap.api.col.p0003l.gy(a = "splitter", b = 2)
    public int f45190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @com.amap.api.col.p0003l.gy(a = "fileLength", b = 5)
    public long f20112a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @com.amap.api.col.p0003l.gy(a = "mAdcode", b = 6)
    public String f20113a;

    @com.amap.api.col.p0003l.gy(a = "startPos", b = 5)
    public long b;

    @com.amap.api.col.p0003l.gy(a = "endPos", b = 5)
    public long c;

    public una() {
        this.f20113a = "";
        this.f20112a = 0L;
        this.f45190a = 0;
        this.b = 0L;
        this.c = 0L;
    }

    public static String a(String str) {
        return "mAdcode='" + str + "'";
    }

    public una(String str, long j, int i, long j2, long j3) {
        this.f20113a = str;
        this.f20112a = j;
        this.f45190a = i;
        this.b = j2;
        this.c = j3;
    }
}
