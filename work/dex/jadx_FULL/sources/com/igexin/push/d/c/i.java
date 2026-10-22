package com.igexin.push.d.c;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38103a = 4;
    public long b;
    public byte c;
    public int d;
    public String e;
    public List<j> f;

    public i() {
        this.m = 4;
        this.n = com.google.common.base.a.x;
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
        this.c = bArr[8];
        this.d = com.igexin.c.a.b.g.c(bArr, 9) & (-1);
        int i = 13;
        if (bArr.length > 13) {
            int i2 = bArr[13] & 255;
            i = 14;
            if (i2 > 0) {
                this.f = new ArrayList();
                int i3 = i2 + 14;
                while (i < i3) {
                    j jVar = new j();
                    this.f.add(jVar);
                    int i4 = i + 1;
                    int i5 = bArr[i] & 255 & 255;
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255 & 255;
                    jVar.f38104a = (byte) i5;
                    if ((i5 == 1 || i5 == 4) && i7 > 0) {
                        try {
                            jVar.b = new String(bArr, i6, i7, "UTF-8");
                        } catch (Exception e) {
                            com.igexin.c.a.c.a.a(e);
                        }
                    }
                    i = i6 + i7;
                }
            }
        }
        if (bArr.length > i) {
            this.e = a(bArr, i + 1, bArr[i] & 255);
        }
    }

    @Override // com.igexin.push.d.c.c
    public final byte[] b() {
        int length;
        int i;
        List<j> list = this.f;
        byte[] byteArray = null;
        if (list != null && list.size() > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterator<j> it = this.f.iterator();
            while (it.hasNext()) {
                try {
                    byteArrayOutputStream.write(it.next().b());
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (IOException e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        if (byteArray != null) {
            length = byteArray.length;
            i = length + 1;
        } else {
            length = 0;
            i = 1;
        }
        byte[] bArr = new byte[i + 12 + this.e.getBytes().length + 1];
        com.igexin.c.a.b.g.a(this.b, bArr, 0);
        com.igexin.c.a.b.g.a(((this.c & 255) << 24) | this.d, bArr, 8);
        bArr[12] = (byte) length;
        int iA = length > 0 ? 13 + com.igexin.c.a.b.g.a(byteArray, bArr, 13, length) : 13;
        byte[] bytes = this.e.getBytes();
        bArr[iA] = (byte) bytes.length;
        System.arraycopy(bytes, 0, bArr, iA + 1, bytes.length);
        return bArr;
    }
}
