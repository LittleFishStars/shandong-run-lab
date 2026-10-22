package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class f1 extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f26617a;

    public f1(byte[] bArr) {
        this.f26617a = bArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f26617a, 12);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof f1) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f26617a, ((f1) rVar).f26617a);
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        return u1.a(this.f26617a.length) + 1 + this.f26617a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f26617a);
    }

    public final String toString() {
        char c;
        byte[] bArr = this.f26617a;
        int i = com.baidu.mapauto.auth.org.spongycastle.util.d.f26659a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            i4++;
            byte b = bArr[i3];
            if ((b & 240) == 240) {
                i4++;
                i3 += 4;
            } else if ((b & 224) == 224) {
                i3 += 3;
            } else {
                i3 = (b & com.ipd.dsp.internal.q.u.n7) == 192 ? i3 + 2 : i3 + 1;
            }
        }
        char[] cArr = new char[i4];
        int i5 = 0;
        while (i2 < bArr.length) {
            byte b2 = bArr[i2];
            if ((b2 & 240) == 240) {
                int i6 = (((((b2 & 3) << 18) | ((bArr[i2 + 1] & 63) << 12)) | ((bArr[i2 + 2] & 63) << 6)) | (bArr[i2 + 3] & 63)) - 65536;
                char c2 = (char) ((i6 >> 10) | 55296);
                c = (char) ((i6 & 1023) | 56320);
                cArr[i5] = c2;
                i2 += 4;
                i5++;
            } else if ((b2 & 224) == 224) {
                c = (char) (((b2 & com.google.common.base.a.q) << 12) | ((bArr[i2 + 1] & 63) << 6) | (bArr[i2 + 2] & 63));
                i2 += 3;
            } else if ((b2 & 208) == 208 || (b2 & com.ipd.dsp.internal.q.u.n7) == 192) {
                int i7 = (b2 & 31) << 6;
                byte b3 = bArr[i2 + 1];
                c = (char) (i7 | (b3 & 63));
                i2 += 2;
            } else {
                c = (char) (b2 & 255);
                i2++;
            }
            cArr[i5] = c;
            i5++;
        }
        return new String(cArr);
    }
}
