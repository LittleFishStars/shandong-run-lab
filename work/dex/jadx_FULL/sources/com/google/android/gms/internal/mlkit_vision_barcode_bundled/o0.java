package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f31389a = new o0(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f5817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f5819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f5820a;
    public int b;

    public o0() {
        this(0, new int[8], new Object[8], true);
    }

    public o0(int i, int[] iArr, Object[] objArr, boolean z) {
        this.b = -1;
        this.f5817a = i;
        this.f5819a = iArr;
        this.f5820a = objArr;
        this.f5818a = z;
    }

    public static o0 c() {
        return f31389a;
    }

    public static o0 e(o0 o0Var, o0 o0Var2) {
        int i = o0Var.f5817a + o0Var2.f5817a;
        int[] iArrCopyOf = Arrays.copyOf(o0Var.f5819a, i);
        System.arraycopy(o0Var2.f5819a, 0, iArrCopyOf, o0Var.f5817a, o0Var2.f5817a);
        Object[] objArrCopyOf = Arrays.copyOf(o0Var.f5820a, i);
        System.arraycopy(o0Var2.f5820a, 0, objArrCopyOf, o0Var.f5817a, o0Var2.f5817a);
        return new o0(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static o0 f() {
        return new o0(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iB;
        int iA;
        int iA2;
        int i = this.b;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f5817a; i3++) {
            int i4 = this.f5819a[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.f5820a[i3]).longValue();
                    iA2 = zzdj.A(i5 << 3) + 8;
                } else if (i6 == 2) {
                    zzdb zzdbVar = (zzdb) this.f5820a[i3];
                    int i7 = zzdj.f31401a;
                    int iZzd = zzdbVar.zzd();
                    iA2 = zzdj.A(i5 << 3) + zzdj.A(iZzd) + iZzd;
                } else if (i6 == 3) {
                    int i8 = i5 << 3;
                    int i9 = zzdj.f31401a;
                    iB = ((o0) this.f5820a[i3]).a();
                    int iA3 = zzdj.A(i8);
                    iA = iA3 + iA3;
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(zzeo.zza());
                    }
                    ((Integer) this.f5820a[i3]).intValue();
                    iA2 = zzdj.A(i5 << 3) + 4;
                }
                i2 += iA2;
            } else {
                int i10 = i5 << 3;
                iB = zzdj.B(((Long) this.f5820a[i3]).longValue());
                iA = zzdj.A(i10);
            }
            iA2 = iA + iB;
            i2 += iA2;
        }
        this.b = i2;
        return i2;
    }

    public final int b() {
        int i = this.b;
        if (i != -1) {
            return i;
        }
        int iA = 0;
        for (int i2 = 0; i2 < this.f5817a; i2++) {
            int i3 = this.f5819a[i2] >>> 3;
            zzdb zzdbVar = (zzdb) this.f5820a[i2];
            int i4 = zzdj.f31401a;
            int iZzd = zzdbVar.zzd();
            int iA2 = zzdj.A(iZzd) + iZzd;
            int iA3 = zzdj.A(16);
            int iA4 = zzdj.A(i3);
            int iA5 = zzdj.A(8);
            iA += iA5 + iA5 + iA3 + iA4 + zzdj.A(24) + iA2;
        }
        this.b = iA;
        return iA;
    }

    public final o0 d(o0 o0Var) {
        if (o0Var.equals(f31389a)) {
            return this;
        }
        g();
        int i = this.f5817a + o0Var.f5817a;
        m(i);
        System.arraycopy(o0Var.f5819a, 0, this.f5819a, this.f5817a, o0Var.f5817a);
        System.arraycopy(o0Var.f5820a, 0, this.f5820a, this.f5817a, o0Var.f5817a);
        this.f5817a = i;
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        int i = this.f5817a;
        if (i == o0Var.f5817a) {
            int[] iArr = this.f5819a;
            int[] iArr2 = o0Var.f5819a;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.f5820a;
            Object[] objArr2 = o0Var.f5820a;
            int i3 = this.f5817a;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4].equals(objArr2[i4])) {
                }
            }
            return true;
        }
        return false;
    }

    public final void g() {
        if (!this.f5818a) {
            throw new UnsupportedOperationException();
        }
    }

    public final void h() {
        if (this.f5818a) {
            this.f5818a = false;
        }
    }

    public final int hashCode() {
        int i = this.f5817a;
        int i2 = i + 527;
        int[] iArr = this.f5819a;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 * 31) + i3;
        Object[] objArr = this.f5820a;
        int i6 = this.f5817a;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return (i5 * 31) + iHashCode;
    }

    public final void i(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f5817a; i2++) {
            d0.b(sb, i, String.valueOf(this.f5819a[i2] >>> 3), this.f5820a[i2]);
        }
    }

    public final void j(int i, Object obj) {
        g();
        m(this.f5817a + 1);
        int[] iArr = this.f5819a;
        int i2 = this.f5817a;
        iArr[i2] = i;
        this.f5820a[i2] = obj;
        this.f5817a = i2 + 1;
    }

    public final void k(zzhq zzhqVar) throws IOException {
        for (int i = 0; i < this.f5817a; i++) {
            zzhqVar.w(this.f5819a[i] >>> 3, this.f5820a[i]);
        }
    }

    public final void l(zzhq zzhqVar) throws IOException {
        if (this.f5817a != 0) {
            for (int i = 0; i < this.f5817a; i++) {
                int i2 = this.f5819a[i];
                Object obj = this.f5820a[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzhqVar.m(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzhqVar.e(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzhqVar.H(i4, (zzdb) obj);
                } else if (i3 == 3) {
                    zzhqVar.b(i4);
                    ((o0) obj).l(zzhqVar);
                    zzhqVar.v(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(zzeo.zza());
                    }
                    zzhqVar.g(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final void m(int i) {
        int[] iArr = this.f5819a;
        if (i > iArr.length) {
            int i2 = this.f5817a;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.f5819a = Arrays.copyOf(iArr, i);
            this.f5820a = Arrays.copyOf(this.f5820a, i);
        }
    }
}
