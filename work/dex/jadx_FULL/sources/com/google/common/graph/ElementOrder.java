package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.Immutable;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable
@Beta
@ElementTypesAreNonnullByDefault
public final class ElementOrder<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f32070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public final Comparator<T> f6267a;

    public enum Type {
        UNORDERED,
        STABLE,
        INSERTION,
        SORTED
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32071a;

        static {
            int[] iArr = new int[Type.values().length];
            f32071a = iArr;
            try {
                iArr[Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32071a[Type.INSERTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32071a[Type.STABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32071a[Type.SORTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ElementOrder(Type type, @CheckForNull Comparator<T> comparator) {
        this.f32070a = (Type) com.google.common.base.i.E(type);
        this.f6267a = comparator;
        com.google.common.base.i.g0((type == Type.SORTED) == (comparator != null));
    }

    public static <S> ElementOrder<S> d() {
        return new ElementOrder<>(Type.INSERTION, null);
    }

    public static <S extends Comparable<? super S>> ElementOrder<S> e() {
        return new ElementOrder<>(Type.SORTED, Ordering.natural());
    }

    public static <S> ElementOrder<S> f(Comparator<S> comparator) {
        return new ElementOrder<>(Type.SORTED, (Comparator) com.google.common.base.i.E(comparator));
    }

    public static <S> ElementOrder<S> g() {
        return new ElementOrder<>(Type.STABLE, null);
    }

    public static <S> ElementOrder<S> i() {
        return new ElementOrder<>(Type.UNORDERED, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T1 extends T> ElementOrder<T1> a() {
        return this;
    }

    public Comparator<T> b() {
        Comparator<T> comparator = this.f6267a;
        if (comparator != null) {
            return comparator;
        }
        throw new UnsupportedOperationException("This ordering does not define a comparator.");
    }

    public <K extends T, V> Map<K, V> c(int i) {
        int i2 = a.f32071a[this.f32070a.ordinal()];
        if (i2 == 1) {
            return Maps.a0(i);
        }
        if (i2 == 2 || i2 == 3) {
            return Maps.e0(i);
        }
        if (i2 == 4) {
            return Maps.g0(b());
        }
        throw new AssertionError();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ElementOrder)) {
            return false;
        }
        ElementOrder elementOrder = (ElementOrder) obj;
        return this.f32070a == elementOrder.f32070a && com.google.common.base.g.a(this.f6267a, elementOrder.f6267a);
    }

    public Type h() {
        return this.f32070a;
    }

    public int hashCode() {
        return com.google.common.base.g.b(this.f32070a, this.f6267a);
    }

    public String toString() {
        com.google.common.base.e.b bVarF = com.google.common.base.e.c(this).f("type", this.f32070a);
        Comparator<T> comparator = this.f6267a;
        if (comparator != null) {
            bVarF.f("comparator", comparator);
        }
        return bVarF.toString();
    }
}
