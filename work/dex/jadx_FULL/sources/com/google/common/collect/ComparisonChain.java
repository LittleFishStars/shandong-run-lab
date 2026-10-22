package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ComparisonChain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComparisonChain f31693a = new a();
    public static final ComparisonChain b = new b(-1);
    public static final ComparisonChain c = new b(1);

    public class a extends ComparisonChain {
        public a() {
            super(null);
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain d(double d, double d2) {
            return o(Double.compare(d, d2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain e(float f, float f2) {
            return o(Float.compare(f, f2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain f(int i, int i2) {
            return o(Ints.e(i, i2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain g(long j, long j2) {
            return o(Longs.d(j, j2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain i(Comparable<?> comparable, Comparable<?> comparable2) {
            return o(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain j(@ParametricNullness T t, @ParametricNullness T t2, Comparator<T> comparator) {
            return o(comparator.compare(t, t2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain k(boolean z, boolean z2) {
            return o(Booleans.d(z, z2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain l(boolean z, boolean z2) {
            return o(Booleans.d(z2, z));
        }

        @Override // com.google.common.collect.ComparisonChain
        public int m() {
            return 0;
        }

        public ComparisonChain o(int i) {
            if (i < 0) {
                return ComparisonChain.b;
            }
            return i > 0 ? ComparisonChain.c : ComparisonChain.f31693a;
        }
    }

    public static final class b extends ComparisonChain {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31694a;

        public b(int i) {
            super(null);
            this.f31694a = i;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain d(double d, double d2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain e(float f, float f2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain f(int i, int i2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain g(long j, long j2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain i(Comparable<?> comparable, Comparable<?> comparable2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain j(@ParametricNullness T t, @ParametricNullness T t2, Comparator<T> comparator) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain k(boolean z, boolean z2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain l(boolean z, boolean z2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int m() {
            return this.f31694a;
        }
    }

    public /* synthetic */ ComparisonChain(a aVar) {
        this();
    }

    public static ComparisonChain n() {
        return f31693a;
    }

    public abstract ComparisonChain d(double d, double d2);

    public abstract ComparisonChain e(float f, float f2);

    public abstract ComparisonChain f(int i, int i2);

    public abstract ComparisonChain g(long j, long j2);

    @Deprecated
    public final ComparisonChain h(Boolean bool, Boolean bool2) {
        return k(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract ComparisonChain i(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> ComparisonChain j(@ParametricNullness T t, @ParametricNullness T t2, Comparator<T> comparator);

    public abstract ComparisonChain k(boolean z, boolean z2);

    public abstract ComparisonChain l(boolean z, boolean z2);

    public abstract int m();

    public ComparisonChain() {
    }
}
