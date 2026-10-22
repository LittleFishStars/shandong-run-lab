package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public class t<K> extends s<K> {
    public static final int i = -2;

    @VisibleForTesting
    public transient long[] b;
    public transient int g;
    public transient int h;

    public t() {
        this(3);
    }

    public static <K> t<K> F() {
        return new t<>();
    }

    public static <K> t<K> G(int i2) {
        return new t<>(i2);
    }

    public final int H(int i2) {
        return (int) (this.b[i2] >>> 32);
    }

    public final int I(int i2) {
        return (int) this.b[i2];
    }

    public final void J(int i2, int i3) {
        long[] jArr = this.b;
        jArr[i2] = (jArr[i2] & 4294967295L) | (((long) i3) << 32);
    }

    public final void K(int i2, int i3) {
        if (i2 == -2) {
            this.g = i3;
        } else {
            L(i2, i3);
        }
        if (i3 == -2) {
            this.h = i2;
        } else {
            J(i3, i2);
        }
    }

    public final void L(int i2, int i3) {
        long[] jArr = this.b;
        jArr[i2] = (jArr[i2] & s.f6221b) | (((long) i3) & 4294967295L);
    }

    @Override // com.google.common.collect.s
    public void a() {
        super.a();
        this.g = -2;
        this.h = -2;
    }

    @Override // com.google.common.collect.s
    public int f() {
        int i2 = this.g;
        if (i2 == -2) {
            return -1;
        }
        return i2;
    }

    @Override // com.google.common.collect.s
    public void o(int i2, float f) {
        super.o(i2, f);
        this.g = -2;
        this.h = -2;
        long[] jArr = new long[i2];
        this.b = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.s
    public void p(int i2, @ParametricNullness K k, int i3, int i4) {
        super.p(i2, k, i3, i4);
        K(this.h, i2);
        K(i2, -2);
    }

    @Override // com.google.common.collect.s
    public void q(int i2) {
        int iD = D() - 1;
        K(H(i2), I(i2));
        if (i2 < iD) {
            K(H(iD), i2);
            K(i2, I(iD));
        }
        super.q(i2);
    }

    @Override // com.google.common.collect.s
    public int t(int i2) {
        int I = I(i2);
        if (I == -2) {
            return -1;
        }
        return I;
    }

    @Override // com.google.common.collect.s
    public int u(int i2, int i3) {
        return i2 == D() ? i3 : i2;
    }

    @Override // com.google.common.collect.s
    public void z(int i2) {
        super.z(i2);
        long[] jArr = this.b;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i2);
        this.b = jArrCopyOf;
        Arrays.fill(jArrCopyOf, length, i2, -1L);
    }

    public t(int i2) {
        this(i2, 1.0f);
    }

    public t(int i2, float f) {
        super(i2, f);
    }

    public t(s<K> sVar) {
        o(sVar.D(), 1.0f);
        int iF = sVar.f();
        while (iF != -1) {
            v(sVar.j(iF), sVar.l(iF));
            iF = sVar.t(iF);
        }
    }
}
