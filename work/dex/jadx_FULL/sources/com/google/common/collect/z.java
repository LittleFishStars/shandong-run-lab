package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public T f6230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Comparator<? super T> f6231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final T[] f6232a;
    public int b;

    public z(Comparator<? super T> comparator, int i) {
        this.f6231a = (Comparator) com.google.common.base.i.F(comparator, "comparator");
        this.f32011a = i;
        com.google.common.base.i.k(i >= 0, "k (%s) must be >= 0", i);
        com.google.common.base.i.k(i <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i);
        this.f6232a = (T[]) new Object[com.google.common.math.e.d(i, 2)];
        this.b = 0;
        this.f6230a = null;
    }

    public static <T extends Comparable<? super T>> z<T> a(int i) {
        return b(i, Ordering.natural());
    }

    public static <T> z<T> b(int i, Comparator<? super T> comparator) {
        return new z<>(Ordering.from(comparator).reverse(), i);
    }

    public static <T extends Comparable<? super T>> z<T> c(int i) {
        return d(i, Ordering.natural());
    }

    public static <T> z<T> d(int i, Comparator<? super T> comparator) {
        return new z<>(comparator, i);
    }

    public void e(@ParametricNullness T t) {
        int i = this.f32011a;
        if (i == 0) {
            return;
        }
        int i2 = this.b;
        if (i2 == 0) {
            this.f6232a[0] = t;
            this.f6230a = t;
            this.b = 1;
            return;
        }
        if (i2 < i) {
            T[] tArr = this.f6232a;
            this.b = i2 + 1;
            tArr[i2] = t;
            if (this.f6231a.compare(t, (Object) q.a(this.f6230a)) > 0) {
                this.f6230a = t;
                return;
            }
            return;
        }
        if (this.f6231a.compare(t, (Object) q.a(this.f6230a)) < 0) {
            T[] tArr2 = this.f6232a;
            int i3 = this.b;
            int i4 = i3 + 1;
            this.b = i4;
            tArr2[i3] = t;
            if (i4 == this.f32011a * 2) {
                k();
            }
        }
    }

    public void f(Iterable<? extends T> iterable) {
        g(iterable.iterator());
    }

    public void g(Iterator<? extends T> it) {
        while (it.hasNext()) {
            e(it.next());
        }
    }

    public final int h(int i, int i2, int i3) {
        Object objA = q.a(this.f6232a[i3]);
        T[] tArr = this.f6232a;
        tArr[i3] = tArr[i2];
        int i4 = i;
        while (i < i2) {
            if (this.f6231a.compare((Object) q.a(this.f6232a[i]), objA) < 0) {
                i(i4, i);
                i4++;
            }
            i++;
        }
        T[] tArr2 = this.f6232a;
        tArr2[i2] = tArr2[i4];
        tArr2[i4] = objA;
        return i4;
    }

    public final void i(int i, int i2) {
        T[] tArr = this.f6232a;
        T t = tArr[i];
        tArr[i] = tArr[i2];
        tArr[i2] = t;
    }

    public List<T> j() {
        Arrays.sort(this.f6232a, 0, this.b, this.f6231a);
        int i = this.b;
        int i2 = this.f32011a;
        if (i > i2) {
            T[] tArr = this.f6232a;
            Arrays.fill(tArr, i2, tArr.length, (Object) null);
            int i3 = this.f32011a;
            this.b = i3;
            this.f6230a = this.f6232a[i3 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.f6232a, this.b)));
    }

    public final void k() {
        int i = (this.f32011a * 2) - 1;
        int iP = com.google.common.math.e.p(i + 0, RoundingMode.CEILING) * 3;
        int iMax = 0;
        int i2 = 0;
        int i3 = 0;
        while (iMax < i) {
            int iH = h(iMax, i, ((iMax + i) + 1) >>> 1);
            int i4 = this.f32011a;
            if (iH <= i4) {
                if (iH >= i4) {
                    break;
                }
                iMax = Math.max(iH, iMax + 1);
                i3 = iH;
            } else {
                i = iH - 1;
            }
            i2++;
            if (i2 >= iP) {
                Arrays.sort(this.f6232a, iMax, i + 1, this.f6231a);
                break;
            }
        }
        this.b = this.f32011a;
        this.f6230a = (T) q.a(this.f6232a[i3]);
        while (true) {
            i3++;
            if (i3 >= this.f32011a) {
                return;
            }
            if (this.f6231a.compare((Object) q.a(this.f6232a[i3]), (Object) q.a(this.f6230a)) > 0) {
                this.f6230a = this.f6232a[i3];
            }
        }
    }
}
