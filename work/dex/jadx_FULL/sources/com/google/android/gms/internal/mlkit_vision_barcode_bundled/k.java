package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k extends zzdj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f31382a;
    public final int b;
    public int c;

    public k(byte[] bArr, int i, int i2) {
        super(null);
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.f31382a = bArr;
        this.c = 0;
        this.b = i2;
    }

    public final void C(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, i, this.f31382a, this.c, i2);
            this.c += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzdh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.c), Integer.valueOf(this.b), Integer.valueOf(i2)), e);
        }
    }

    public final void D(String str) throws IOException {
        int i = this.c;
        try {
            int iA = zzdj.A(str.length() * 3);
            int iA2 = zzdj.A(str.length());
            if (iA2 != iA) {
                s(u0.e(str));
                byte[] bArr = this.f31382a;
                int i2 = this.c;
                this.c = u0.d(str, bArr, i2, this.b - i2);
                return;
            }
            int i3 = i + iA2;
            this.c = i3;
            int iD = u0.d(str, this.f31382a, i3, this.b - i3);
            this.c = i;
            s((iD - i) - iA2);
            this.c = iD;
        } catch (zzhm e) {
            this.c = i;
            c(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzdh(e2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final int e() {
        return this.b - this.c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void f(byte b) throws IOException {
        try {
            byte[] bArr = this.f31382a;
            int i = this.c;
            this.c = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzdh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.c), Integer.valueOf(this.b), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void g(int i, boolean z) throws IOException {
        s(i << 3);
        f(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void h(int i, zzdb zzdbVar) throws IOException {
        s((i << 3) | 2);
        s(zzdbVar.zzd());
        zzdbVar.zzm(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void i(int i, int i2) throws IOException {
        s((i << 3) | 5);
        j(i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void j(int i) throws IOException {
        try {
            byte[] bArr = this.f31382a;
            int i2 = this.c;
            int i3 = i2 + 1;
            bArr[i2] = (byte) (i & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.c = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzdh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.c), Integer.valueOf(this.b), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void k(int i, long j) throws IOException {
        s((i << 3) | 1);
        l(j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void l(long j) throws IOException {
        try {
            byte[] bArr = this.f31382a;
            int i = this.c;
            int i2 = i + 1;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i2 + 1;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.c = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzdh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.c), Integer.valueOf(this.b), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void m(int i, int i2) throws IOException {
        s(i << 3);
        n(i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void n(int i) throws IOException {
        if (i >= 0) {
            s(i);
        } else {
            u(i);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void o(byte[] bArr, int i, int i2) throws IOException {
        C(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void p(int i, String str) throws IOException {
        s((i << 3) | 2);
        D(str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void q(int i, int i2) throws IOException {
        s((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void r(int i, int i2) throws IOException {
        s(i << 3);
        s(i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void s(int i) throws IOException {
        while ((i & com.alipay.sdk.m.p.a.g) != 0) {
            try {
                byte[] bArr = this.f31382a;
                int i2 = this.c;
                this.c = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzdh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.c), Integer.valueOf(this.b), 1), e);
            }
        }
        byte[] bArr2 = this.f31382a;
        int i3 = this.c;
        this.c = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void t(int i, long j) throws IOException {
        s(i << 3);
        u(j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdj
    public final void u(long j) throws IOException {
        if (zzdj.f5834a && this.b - this.c >= 10) {
            while ((j & (-128)) != 0) {
                byte[] bArr = this.f31382a;
                int i = this.c;
                this.c = i + 1;
                s0.s(bArr, i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr2 = this.f31382a;
            int i2 = this.c;
            this.c = i2 + 1;
            s0.s(bArr2, i2, (byte) j);
            return;
        }
        while ((j & (-128)) != 0) {
            try {
                byte[] bArr3 = this.f31382a;
                int i3 = this.c;
                this.c = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzdh(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.c), Integer.valueOf(this.b), 1), e);
            }
        }
        byte[] bArr4 = this.f31382a;
        int i4 = this.c;
        this.c = i4 + 1;
        bArr4[i4] = (byte) j;
    }
}
