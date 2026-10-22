package com.igexin.push.d.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38096a;
    public byte b;
    public byte c;
    public byte d;
    public byte[] e;
    public int f;
    public byte g;

    private byte[] a() {
        if (this.e == null) {
            return null;
        }
        byte[] bArr = new byte[this.f38096a + 11];
        com.igexin.c.a.b.g.a(com.igexin.push.g.g.e(), bArr, 0);
        com.igexin.c.a.b.g.a((int) (System.currentTimeMillis() / 1000), bArr, 4);
        com.igexin.c.a.b.g.b(this.f38096a, bArr, 8);
        bArr[10] = this.b;
        byte[] bArr2 = this.e;
        com.igexin.c.a.b.g.a(bArr2, bArr, 11, bArr2.length);
        return bArr;
    }

    public final void a(byte[] bArr) {
        int length;
        if (bArr == null) {
            length = 0;
        } else {
            this.e = bArr;
            length = bArr.length;
        }
        this.f38096a = length;
    }
}
