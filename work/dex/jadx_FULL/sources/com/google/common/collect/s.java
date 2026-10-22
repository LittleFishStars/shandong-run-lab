package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public class s<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f32007a = 4294967295L;
    public static final float b = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final long f6221b = -4294967296L;
    public static final int d = 1073741824;
    public static final int e = 3;
    public static final int f = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public transient float f6222a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public transient int f6223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public transient int[] f6224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public transient long[] f6225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public transient Object[] f6226a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public transient int f6227b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public transient int[] f6228b;
    public transient int c;

    public class a extends Multisets.AbstractEntry<K> {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @ParametricNullness
        public final K f6229a;

        public a(int i) {
            this.f6229a = (K) s.this.f6226a[i];
            this.K = i;
        }

        @CanIgnoreReturnValue
        public int a(int i) {
            f();
            int i2 = this.K;
            if (i2 == -1) {
                s.this.v(this.f6229a, i);
                return 0;
            }
            int[] iArr = s.this.f6224a;
            int i3 = iArr[i2];
            iArr[i2] = i;
            return i3;
        }

        public void f() {
            int i = this.K;
            if (i == -1 || i >= s.this.D() || !com.google.common.base.g.a(this.f6229a, s.this.f6226a[this.K])) {
                this.K = s.this.n(this.f6229a);
            }
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            f();
            int i = this.K;
            if (i == -1) {
                return 0;
            }
            return s.this.f6224a[i];
        }

        @Override // com.google.common.collect.Multiset.Entry
        @ParametricNullness
        public K getElement() {
            return this.f6229a;
        }
    }

    public s() {
        o(3, 1.0f);
    }

    public static long E(long j, int i) {
        return (j & f6221b) | (4294967295L & ((long) i));
    }

    public static <K> s<K> c() {
        return new s<>();
    }

    public static <K> s<K> d(int i) {
        return new s<>(i);
    }

    public static int i(long j) {
        return (int) (j >>> 32);
    }

    public static int k(long j) {
        return (int) j;
    }

    public static long[] r(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] s(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public final void A(int i) {
        int length = this.f6225a.length;
        if (i > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Integer.MAX_VALUE;
            }
            if (iMax != length) {
                z(iMax);
            }
        }
    }

    public final void B(int i) {
        if (this.f6228b.length >= 1073741824) {
            this.c = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.f6222a)) + 1;
        int[] iArrS = s(i);
        long[] jArr = this.f6225a;
        int length = iArrS.length - 1;
        for (int i3 = 0; i3 < this.f6223a; i3++) {
            int i4 = i(jArr[i3]);
            int i5 = i4 & length;
            int i6 = iArrS[i5];
            iArrS[i5] = i3;
            jArr[i3] = (((long) i4) << 32) | (((long) i6) & 4294967295L);
        }
        this.c = i2;
        this.f6228b = iArrS;
    }

    public void C(int i, int i2) {
        com.google.common.base.i.C(i, this.f6223a);
        this.f6224a[i] = i2;
    }

    public int D() {
        return this.f6223a;
    }

    public void a() {
        this.f6227b++;
        Arrays.fill(this.f6226a, 0, this.f6223a, (Object) null);
        Arrays.fill(this.f6224a, 0, this.f6223a, 0);
        Arrays.fill(this.f6228b, -1);
        Arrays.fill(this.f6225a, -1L);
        this.f6223a = 0;
    }

    public boolean b(@CheckForNull Object obj) {
        return n(obj) != -1;
    }

    public void e(int i) {
        if (i > this.f6225a.length) {
            z(i);
        }
        if (i >= this.c) {
            B(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    public int f() {
        return this.f6223a == 0 ? -1 : 0;
    }

    public int g(@CheckForNull Object obj) {
        int iN = n(obj);
        if (iN == -1) {
            return 0;
        }
        return this.f6224a[iN];
    }

    public Multiset.Entry<K> h(int i) {
        com.google.common.base.i.C(i, this.f6223a);
        return new a(i);
    }

    @ParametricNullness
    public K j(int i) {
        com.google.common.base.i.C(i, this.f6223a);
        return (K) this.f6226a[i];
    }

    public int l(int i) {
        com.google.common.base.i.C(i, this.f6223a);
        return this.f6224a[i];
    }

    public final int m() {
        return this.f6228b.length - 1;
    }

    public int n(@CheckForNull Object obj) {
        int iD = m.d(obj);
        int iK = this.f6228b[m() & iD];
        while (iK != -1) {
            long j = this.f6225a[iK];
            if (i(j) == iD && com.google.common.base.g.a(obj, this.f6226a[iK])) {
                return iK;
            }
            iK = k(j);
        }
        return -1;
    }

    public void o(int i, float f2) {
        com.google.common.base.i.e(i >= 0, "Initial capacity must be non-negative");
        com.google.common.base.i.e(f2 > 0.0f, "Illegal load factor");
        int iA = m.a(i, f2);
        this.f6228b = s(iA);
        this.f6222a = f2;
        this.f6226a = new Object[i];
        this.f6224a = new int[i];
        this.f6225a = r(i);
        this.c = Math.max(1, (int) (iA * f2));
    }

    public void p(int i, @ParametricNullness K k, int i2, int i3) {
        this.f6225a[i] = (((long) i3) << 32) | 4294967295L;
        this.f6226a[i] = k;
        this.f6224a[i] = i2;
    }

    public void q(int i) {
        int iD = D() - 1;
        if (i >= iD) {
            this.f6226a[i] = null;
            this.f6224a[i] = 0;
            this.f6225a[i] = -1;
            return;
        }
        Object[] objArr = this.f6226a;
        objArr[i] = objArr[iD];
        int[] iArr = this.f6224a;
        iArr[i] = iArr[iD];
        objArr[iD] = null;
        iArr[iD] = 0;
        long[] jArr = this.f6225a;
        long j = jArr[iD];
        jArr[i] = j;
        jArr[iD] = -1;
        int i2 = i(j) & m();
        int[] iArr2 = this.f6228b;
        int i3 = iArr2[i2];
        if (i3 == iD) {
            iArr2[i2] = i;
            return;
        }
        while (true) {
            long j2 = this.f6225a[i3];
            int iK = k(j2);
            if (iK == iD) {
                this.f6225a[i3] = E(j2, i);
                return;
            }
            i3 = iK;
        }
    }

    public int t(int i) {
        int i2 = i + 1;
        if (i2 < this.f6223a) {
            return i2;
        }
        return -1;
    }

    public int u(int i, int i2) {
        return i - 1;
    }

    @CanIgnoreReturnValue
    public int v(@ParametricNullness K k, int i) {
        com.google.common.collect.a.d(i, "count");
        long[] jArr = this.f6225a;
        Object[] objArr = this.f6226a;
        int[] iArr = this.f6224a;
        int iD = m.d(k);
        int iM = m() & iD;
        int i2 = this.f6223a;
        int[] iArr2 = this.f6228b;
        int i3 = iArr2[iM];
        if (i3 == -1) {
            iArr2[iM] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (i(j) == iD && com.google.common.base.g.a(k, objArr[i3])) {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return i4;
                }
                int iK = k(j);
                if (iK == -1) {
                    jArr[i3] = E(j, i2);
                    break;
                }
                i3 = iK;
            }
        }
        if (i2 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i5 = i2 + 1;
        A(i5);
        p(i2, k, i, iD);
        this.f6223a = i5;
        if (i2 >= this.c) {
            B(this.f6228b.length * 2);
        }
        this.f6227b++;
        return 0;
    }

    @CanIgnoreReturnValue
    public int w(@CheckForNull Object obj) {
        return x(obj, m.d(obj));
    }

    public final int x(@CheckForNull Object obj, int i) {
        int iM = m() & i;
        int i2 = this.f6228b[iM];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (i(this.f6225a[i2]) == i && com.google.common.base.g.a(obj, this.f6226a[i2])) {
                int i4 = this.f6224a[i2];
                if (i3 == -1) {
                    this.f6228b[iM] = k(this.f6225a[i2]);
                } else {
                    long[] jArr = this.f6225a;
                    jArr[i3] = E(jArr[i3], k(jArr[i2]));
                }
                q(i2);
                this.f6223a--;
                this.f6227b++;
                return i4;
            }
            int iK = k(this.f6225a[i2]);
            if (iK == -1) {
                return 0;
            }
            i3 = i2;
            i2 = iK;
        }
    }

    @CanIgnoreReturnValue
    public int y(int i) {
        return x(this.f6226a[i], i(this.f6225a[i]));
    }

    public void z(int i) {
        this.f6226a = Arrays.copyOf(this.f6226a, i);
        this.f6224a = Arrays.copyOf(this.f6224a, i);
        long[] jArr = this.f6225a;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(jArrCopyOf, length, i, -1L);
        }
        this.f6225a = jArrCopyOf;
    }

    public s(s<? extends K> sVar) {
        o(sVar.D(), 1.0f);
        int iF = sVar.f();
        while (iF != -1) {
            v(sVar.j(iF), sVar.l(iF));
            iF = sVar.t(iF);
        }
    }

    public s(int i) {
        this(i, 1.0f);
    }

    public s(int i, float f2) {
        o(i, f2);
    }
}
