package com.igexin.push.d.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class q extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38110a = 20;
    public int b;

    public q() {
        this.m = 20;
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        if (bArr.length == 1) {
            this.b = bArr[0] & 255;
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        return null;
    }
}
