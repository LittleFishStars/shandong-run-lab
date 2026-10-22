package com.igexin.push.d.c;

import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class k extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38105a = 5;
    public boolean b;
    public boolean c;
    public String d;
    public String e;
    public long f;

    public k() {
        this.m = 5;
    }

    @Override // com.igexin.push.d.c.c, com.igexin.c.a.d.a.a
    public final void a() {
        this.e = null;
        this.d = null;
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        byte b = bArr[0];
        int i = 1;
        this.b = (b & SignedBytes.f32242a) != 0;
        boolean z = (b & UnsignedBytes.f32243a) != 0;
        this.c = z;
        if (z) {
            this.d = c.a(b);
            int iB = com.igexin.c.a.b.g.b(bArr, 1);
            i = 1 + iB + 2;
            try {
                this.e = new String(bArr, 3, iB, this.d);
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        if (bArr.length > i) {
            this.f = com.igexin.c.a.b.g.d(bArr, i);
            com.igexin.c.a.c.a.a("LoginResult|session = " + this.f, new Object[0]);
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        int length;
        int i;
        byte bA = this.b ? SignedBytes.f32242a : (byte) 0;
        int iB = 1;
        byte[] bytes = null;
        if (this.c) {
            byte b = (byte) (bA | UnsignedBytes.f32243a);
            try {
                bytes = this.e.getBytes(this.d);
                length = bytes.length;
                i = length + 3;
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
                i = 3;
                length = 0;
            }
            bA = (byte) (b | c.a(this.d));
        } else {
            length = 0;
            i = 1;
        }
        byte[] bArr = new byte[i + 8];
        bArr[0] = bA;
        if (this.c) {
            iB = com.igexin.c.a.b.g.b(length, bArr, 1);
            if (bytes != null) {
                iB = com.igexin.c.a.b.g.a(bytes, bArr, 2, length) + 2;
            }
        }
        com.igexin.c.a.b.g.a(this.f, bArr, iB);
        return bArr;
    }
}
