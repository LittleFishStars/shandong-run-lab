package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class MapMaker {
    public static final int c = 16;
    public static final int d = 4;
    public static final int e = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public Equivalence<Object> f6101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public MapMakerInternalMap.Strength f6102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6103a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @CheckForNull
    public MapMakerInternalMap.Strength f6104b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31782a = -1;
    public int b = -1;

    public enum Dummy {
        VALUE
    }

    @CanIgnoreReturnValue
    public MapMaker a(int i) {
        int i2 = this.b;
        com.google.common.base.i.n0(i2 == -1, "concurrency level was already set to %s", i2);
        com.google.common.base.i.d(i > 0);
        this.b = i;
        return this;
    }

    public int b() {
        int i = this.b;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public int c() {
        int i = this.f31782a;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public Equivalence<Object> d() {
        return (Equivalence) com.google.common.base.e.a(this.f6101a, e().defaultEquivalence());
    }

    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) com.google.common.base.e.a(this.f6102a, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) com.google.common.base.e.a(this.f6104b, MapMakerInternalMap.Strength.STRONG);
    }

    @CanIgnoreReturnValue
    public MapMaker g(int i) {
        int i2 = this.f31782a;
        com.google.common.base.i.n0(i2 == -1, "initial capacity was already set to %s", i2);
        com.google.common.base.i.d(i >= 0);
        this.f31782a = i;
        return this;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker h(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f6101a;
        com.google.common.base.i.x0(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f6101a = (Equivalence) com.google.common.base.i.E(equivalence);
        this.f6103a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        return !this.f6103a ? new ConcurrentHashMap(c(), 0.75f, b()) : MapMakerInternalMap.create(this);
    }

    public MapMaker j(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f6102a;
        com.google.common.base.i.x0(strength2 == null, "Key strength was already set to %s", strength2);
        this.f6102a = (MapMakerInternalMap.Strength) com.google.common.base.i.E(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f6103a = true;
        }
        return this;
    }

    public MapMaker k(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f6104b;
        com.google.common.base.i.x0(strength2 == null, "Value strength was already set to %s", strength2);
        this.f6104b = (MapMakerInternalMap.Strength) com.google.common.base.i.E(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f6103a = true;
        }
        return this;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker l() {
        return j(MapMakerInternalMap.Strength.WEAK);
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker m() {
        return k(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        com.google.common.base.e.b bVarC = com.google.common.base.e.c(this);
        int i = this.f31782a;
        if (i != -1) {
            bVarC.d("initialCapacity", i);
        }
        int i2 = this.b;
        if (i2 != -1) {
            bVarC.d("concurrencyLevel", i2);
        }
        MapMakerInternalMap.Strength strength = this.f6102a;
        if (strength != null) {
            bVarC.f("keyStrength", com.google.common.base.a.g(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f6104b;
        if (strength2 != null) {
            bVarC.f("valueStrength", com.google.common.base.a.g(strength2.toString()));
        }
        if (this.f6101a != null) {
            bVarC.s("keyEquivalence");
        }
        return bVarC.toString();
    }
}
