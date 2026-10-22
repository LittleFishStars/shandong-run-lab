package com.igexin.push.d.c;

import com.ipd.dsp.internal.q.u;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class n extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38108a = 26;
    private static final String j = "com.igexin.push.d.c.n";
    public int b;
    public int c;
    public long d;
    public String e;
    public Object f;
    public Object g;
    public String h;
    public String i = "UTF-8";

    public n() {
        this.m = 26;
    }

    private boolean e() {
        return this.c == 64;
    }

    private boolean f() {
        return this.c == 192;
    }

    private void g() {
        this.c = 128;
    }

    private void h() {
        this.c = 64;
    }

    private void i() {
        this.c = 192;
    }

    @Override // com.igexin.push.d.c.c, com.igexin.c.a.d.a.a
    public final void a() {
        this.e = null;
        this.g = null;
        this.f = null;
        this.i = null;
    }

    @Override // com.igexin.push.d.c.c
    public final void a(byte[] bArr) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        this.b = com.igexin.c.a.b.g.b(bArr, 0);
        byte b = bArr[2];
        this.c = b & u.n7;
        this.i = c.a(b);
        this.d = com.igexin.c.a.b.g.d(bArr, 3);
        int i7 = bArr[11] & 255;
        try {
            this.e = new String(bArr, 12, i7, this.i);
            while (true) {
                int i8 = bArr[i];
                i3 = i2 | (i8 & 127);
                if ((i8 & 128) == 0) {
                    break;
                }
                i2 = i3 << 7;
                i++;
            }
            while (true) {
                int i9 = bArr[i4];
                i6 = i5 | (i9 & 127);
                if ((i9 & 128) == 0) {
                    break;
                }
                i5 = i6 << 7;
                i4++;
            }
        } catch (Exception e) {
            this.e = "";
            com.igexin.c.a.c.a.a(e);
        }
        i = i7 + 12;
        i2 = 0;
        int i10 = i + 1;
        if (i3 > 0) {
            if (this.c == 192) {
                byte[] bArr2 = new byte[i3];
                this.f = bArr2;
                System.arraycopy(bArr, i10, bArr2, 0, i3);
            } else {
                try {
                    this.f = new String(bArr, i10, i3, this.i);
                } catch (Exception e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
            }
        }
        i4 = i10 + i3;
        i5 = 0;
        int i11 = i4 + 1;
        if (i6 > 0) {
            byte[] bArr3 = new byte[i6];
            this.g = bArr3;
            System.arraycopy(bArr, i11, bArr3, 0, i6);
        }
        int i12 = i11 + i6;
        if (bArr.length > i12) {
            try {
                this.h = new String(bArr, i12 + 1, bArr[i12] & 255, this.i);
            } catch (Exception e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        byte[] bytes;
        byte[] bArr = null;
        try {
            byte[] bytes2 = this.e.getBytes(this.i);
            byte[] bytes3 = this.h.getBytes(this.i);
            if ("".equals(this.f)) {
                bytes = null;
            } else {
                bytes = this.c == 192 ? (byte[]) this.f : ((String) this.f).getBytes(this.i);
            }
            Object obj = this.g;
            byte[] bArr2 = obj != null ? (byte[]) obj : null;
            int length = bytes == null ? 0 : bytes.length;
            int length2 = bArr2 == null ? 0 : bArr2.length;
            byte[] bArrA = com.igexin.c.a.b.g.a(length);
            byte[] bArrA2 = com.igexin.c.a.b.g.a(length2);
            bArr = new byte[bytes2.length + 13 + bArrA.length + length + bArrA2.length + length2 + bytes3.length];
            com.igexin.c.a.b.g.b(this.b, bArr, 0);
            bArr[2] = (byte) (this.c | c.a(this.i));
            com.igexin.c.a.b.g.a(this.d, bArr, 3);
            bArr[11] = (byte) bytes2.length;
            int iA = com.igexin.c.a.b.g.a(bytes2, bArr, 12, bytes2.length) + 12;
            int iA2 = iA + com.igexin.c.a.b.g.a(bArrA, bArr, iA, bArrA.length);
            if (length > 0) {
                iA2 += com.igexin.c.a.b.g.a(bytes, bArr, iA2, length);
            }
            int iA3 = iA2 + com.igexin.c.a.b.g.a(bArrA2, bArr, iA2, bArrA2.length);
            if (length2 > 0) {
                iA3 += com.igexin.c.a.b.g.a(bArr2, bArr, iA3, length2);
            }
            bArr[iA3] = (byte) bytes3.length;
            com.igexin.c.a.b.g.a(bytes3, bArr, iA3 + 1, bytes3.length);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        return bArr;
    }

    public final boolean d() {
        return this.c == 128;
    }

    public String toString() {
        return "{\"msgID\":" + this.b + ", \"msgType\":" + this.c + ", \"msgDate\":" + this.d + ", \"msgAddress\":\"" + this.e + "\", \"msgContent\":" + this.f + ", \"msgExtra\":" + this.g + ", \"msgCID\":\"" + this.h + "\", \"charset\":\"" + this.i + "\", \"command\":" + this.m + ", \"property\":" + ((int) this.n) + ", \"expandProperty\":" + ((int) this.o) + ", \"tag\":\"" + this.y + "\"}";
    }
}
