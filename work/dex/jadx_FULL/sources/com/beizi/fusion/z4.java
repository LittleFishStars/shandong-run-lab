package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class z4 extends y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28098a;
    private String b;
    private String c;
    private String d;

    public long a() {
        return po.d(this.b);
    }

    public void b(String str) {
        this.f28098a = str;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.f28098a;
    }

    public String toString() {
        return "{\"spaceId\":\"" + this.f28098a + "\",\"cacheTime\":\"" + this.b + "\",\"expireTime\":\"" + this.c + "\",\"requestId\":\"" + this.d + "\"}";
    }

    public void a(long j) {
        this.b = String.valueOf(j);
    }

    public long b() {
        return po.d(this.c);
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(long j) {
        this.c = String.valueOf(j);
    }
}
