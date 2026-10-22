package com.aliyun.svideosdk.editor.pplayer;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f25765a;
    private long b;
    private long c;
    private long d;
    private long e;
    private int f;
    private long g;

    public a(long j, long j2, long j3, long j4, int i) {
        this.f25765a = j;
        this.b = j2;
        this.d = j3;
        this.e = j4;
        this.f = i;
        long j5 = j2 - j;
        this.c = j5;
        this.g = j5;
    }

    public long a() {
        return this.e;
    }

    public long a(long j) {
        long j2 = this.c;
        if (j2 == 0) {
            return 0L;
        }
        if (this.g >= j2) {
            long j3 = this.f25765a + (j % j2);
            long j4 = this.b;
            return j3 > j4 ? j4 : j3;
        }
        if (this.f == 0) {
            long j5 = this.f25765a + (j % j2);
            long j6 = this.b;
            return j5 > j6 ? j6 : j5;
        }
        Log.i("AnimationBlock", "faster");
        long j7 = this.c;
        long j8 = this.f25765a + (((long) ((j * (j7 * 1.0d)) / this.g)) % j7);
        long j9 = this.b;
        return j8 > j9 ? j9 : j8;
    }

    public long b() {
        return this.d;
    }

    public void b(long j) {
        long j2 = this.e;
        if (j2 == 0 || j <= j2) {
            this.g = j;
        } else {
            this.g = j2;
        }
    }

    public long c() {
        return this.g;
    }
}
