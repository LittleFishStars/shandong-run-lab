package com.igexin.push.d.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38101a = 96;
    public String b;
    private byte[] c;
    private byte d;
    private String e;

    public g() {
        this.m = 96;
        this.n = (byte) 4;
        this.o = (byte) (this.o | com.google.common.base.a.r);
    }

    private static String a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        try {
            this.d = bArr[0];
            int i = bArr[1] & 255;
            this.b = a(bArr, 2, i);
            int i2 = i + 2;
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            byte[] bArr2 = new byte[i4];
            this.c = bArr2;
            System.arraycopy(bArr, i3, bArr2, 0, i4);
            int i5 = i3 + i4;
            this.e = a(bArr, i5 + 1, bArr[i5] & 255);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        byte[] bytes = this.b.getBytes();
        byte[] bArrB = com.igexin.push.g.g.b(com.igexin.c.a.b.g.b((int) (System.currentTimeMillis() / 1000)));
        byte[] bArrB2 = com.igexin.push.g.g.b();
        byte[] bArr = new byte[bytes.length + 2 + 2 + bArrB2.length + 1 + bArrB.length];
        bArr[0] = 0;
        bArr[1] = (byte) bytes.length;
        int iA = com.igexin.c.a.b.g.a(bytes, bArr, 2, bytes.length) + 2;
        int iB = iA + com.igexin.c.a.b.g.b((short) bArrB2.length, bArr, iA);
        int iA2 = iB + com.igexin.c.a.b.g.a(bArrB2, bArr, iB, bArrB2.length);
        bArr[iA2] = (byte) bArrB.length;
        com.igexin.c.a.b.g.a(bArrB, bArr, iA2 + 1, bArrB.length);
        return bArr;
    }
}
