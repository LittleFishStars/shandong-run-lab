package com.zj.adlib;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class q82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer f19025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f19026a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f19027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<byte[]> f19028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f19029a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Integer f19030b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f19031b;
    public final int c;
    public final int d;

    public q82(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1, 0);
    }

    public List<byte[]> a() {
        return this.f19028a;
    }

    public String b() {
        return this.f19031b;
    }

    public Integer c() {
        return this.f19030b;
    }

    public Integer d() {
        return this.f19025a;
    }

    public int e() {
        return this.f44148a;
    }

    public Object f() {
        return this.f19026a;
    }

    public byte[] g() {
        return this.f19029a;
    }

    public int h() {
        return this.b;
    }

    public int i() {
        return this.c;
    }

    public int j() {
        return this.d;
    }

    public String k() {
        return this.f19027a;
    }

    public boolean l() {
        return this.b >= 0 && this.c >= 0;
    }

    public void m(Integer num) {
        this.f19030b = num;
    }

    public void n(Integer num) {
        this.f19025a = num;
    }

    public void o(int i) {
        this.f44148a = i;
    }

    public void p(Object obj) {
        this.f19026a = obj;
    }

    public q82(byte[] bArr, String str, List<byte[]> list, String str2, int i) {
        this(bArr, str, list, str2, -1, -1, i);
    }

    public q82(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this(bArr, str, list, str2, i, i2, 0);
    }

    public q82(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2, int i3) {
        this.f19029a = bArr;
        this.f44148a = bArr == null ? 0 : bArr.length * 8;
        this.f19027a = str;
        this.f19028a = list;
        this.f19031b = str2;
        this.b = i2;
        this.c = i;
        this.d = i3;
    }
}
