package com.igexin.push.d.c;

import com.ipd.dsp.internal.q.u;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38099a = 1944742139;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public byte h;
    public byte i;
    public byte j;
    public byte k;
    public byte l;
    public byte m;
    public byte n;
    public byte[] o;
    public int p;
    public int q;
    public int r;

    private int a() {
        int i = this.e | this.h | this.i | this.j;
        this.e = i;
        return i;
    }

    private int b() {
        int i = this.g | this.k | this.l | this.m | this.n;
        this.g = i;
        return i;
    }

    private void b(byte b) {
        this.g = b & 255;
        this.k = (byte) (b & 3);
        this.l = (byte) (b & 4);
        this.m = (byte) (b & 8);
        this.n = (byte) (b & com.google.common.base.a.r);
    }

    public final void a(byte b) {
        this.e = b & 255;
        this.h = (byte) (b & u.n7);
        this.i = (byte) (b & com.alibaba.ariver.resource.parser.a.e.i);
        this.j = (byte) (b & com.google.common.base.a.q);
    }
}
