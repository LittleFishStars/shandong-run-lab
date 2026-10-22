package com.igexin.push.d.c;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class p extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38109a = 9;
    public long b;
    public String c = "";
    public String d = "";
    public String e = "";

    public p() {
        this.m = 9;
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
        this.b = com.igexin.c.a.b.g.d(bArr, 0);
        int i = 8;
        if (bArr.length > 8) {
            int i2 = bArr[8] & 255;
            i = 9;
            if (i2 > 0) {
                this.c = a(bArr, 9, i2);
                i = 9 + i2;
            }
        }
        if (bArr.length > i) {
            int i3 = i + 1;
            int i4 = bArr[i] & 255;
            if (i4 > 0) {
                this.d = a(bArr, i3, i4);
                i = i4 + i3;
            } else {
                i = i3;
            }
        }
        if (bArr.length > i) {
            int i5 = i + 1;
            int i6 = bArr[i] & 255;
            if (i6 > 0) {
                this.e = a(bArr, i5, i6);
            }
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        if (TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e)) {
            byte[] bytes = this.c.getBytes();
            byte[] bArr = new byte[bytes.length + 8 + 1];
            com.igexin.c.a.b.g.a(this.b, bArr, 0);
            bArr[8] = (byte) bytes.length;
            System.arraycopy(bytes, 0, bArr, 9, bytes.length);
            return bArr;
        }
        byte[] bytes2 = this.c.getBytes();
        byte[] bytes3 = this.d.getBytes();
        byte[] bytes4 = this.e.getBytes();
        byte[] bArr2 = new byte[bytes2.length + 8 + bytes3.length + bytes4.length + 3];
        com.igexin.c.a.b.g.a(this.b, bArr2, 0);
        bArr2[8] = (byte) bytes2.length;
        System.arraycopy(bytes2, 0, bArr2, 9, bytes2.length);
        int length = bytes2.length + 9;
        int i = length + 1;
        bArr2[length] = (byte) bytes3.length;
        System.arraycopy(bytes3, 0, bArr2, i, bytes3.length);
        int length2 = i + bytes3.length;
        bArr2[length2] = (byte) bytes4.length;
        System.arraycopy(bytes4, 0, bArr2, length2 + 1, bytes4.length);
        return bArr2;
    }
}
