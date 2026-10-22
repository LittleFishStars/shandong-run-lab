package com.igexin.push.d.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class h extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38102a = 97;
    public byte b;
    public byte c;

    public h() {
        this.m = 97;
    }

    @Override // com.igexin.push.d.c.c, com.igexin.c.a.d.a.a
    public final void a() {
        this.b = (byte) 0;
        this.c = (byte) 0;
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        this.b = bArr[0];
        this.c = bArr[1];
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        return new byte[]{this.b, this.c};
    }
}
