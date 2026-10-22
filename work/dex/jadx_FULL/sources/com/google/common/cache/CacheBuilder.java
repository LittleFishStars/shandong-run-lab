package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.base.e;
import com.google.common.base.i;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class CacheBuilder<K, V> {
    public static final int c = 16;
    public static final int d = 4;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Equivalence<Object> f5964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Ticker f5966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LocalCache.Strength f5967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RemovalListener<? super K, ? super V> f5968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Weigher<? super K, ? super V> f5969a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Equivalence<Object> f5973b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public LocalCache.Strength f5974b;
    public static final Supplier<? extends AbstractCache.StatsCounter> b = Suppliers.d(new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.common.cache.a f31609a = new com.google.common.cache.a(0, 0, 0, 0, 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final Supplier<AbstractCache.StatsCounter> f5961c = new b();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Ticker f5960b = new c();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f5959a = Logger.getLogger(CacheBuilder.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5970a = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f5962a = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f5971b = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f5963a = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f5972b = -1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f5975c = -1;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f5976d = -1;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f5977e = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Supplier<? extends AbstractCache.StatsCounter> f5965a = b;

    public enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    public enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.Weigher
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    public class a implements AbstractCache.StatsCounter {
        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public com.google.common.cache.a a() {
            return CacheBuilder.f31609a;
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void b() {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void c(long j) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void d(long j) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void e(int i) {
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void f(int i) {
        }
    }

    public class b implements Supplier<AbstractCache.StatsCounter> {
        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractCache.StatsCounter get() {
            return new AbstractCache.a();
        }
    }

    public class c extends Ticker {
        @Override // com.google.common.base.Ticker
        public long a() {
            return 0L;
        }
    }

    @CheckReturnValue
    public static CacheBuilder<Object, Object> D() {
        return new CacheBuilder<>();
    }

    @CheckReturnValue
    @GwtIncompatible
    public static CacheBuilder<Object, Object> h(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.f().A();
    }

    @CheckReturnValue
    @GwtIncompatible
    public static CacheBuilder<Object, Object> i(String str) {
        return h(CacheBuilderSpec.e(str));
    }

    @GwtIncompatible
    public CacheBuilder<K, V> A() {
        this.f5970a = false;
        return this;
    }

    public CacheBuilder<K, V> B(long j) {
        long j2 = this.f5963a;
        i.s0(j2 == -1, "maximum size was already set to %s", j2);
        long j3 = this.f5972b;
        i.s0(j3 == -1, "maximum weight was already set to %s", j3);
        i.h0(this.f5969a == null, "maximum size can not be combined with weigher");
        i.e(j >= 0, "maximum size must not be negative");
        this.f5963a = j;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> C(long j) {
        long j2 = this.f5972b;
        i.s0(j2 == -1, "maximum weight was already set to %s", j2);
        long j3 = this.f5963a;
        i.s0(j3 == -1, "maximum size was already set to %s", j3);
        i.e(j >= 0, "maximum weight must not be negative");
        this.f5972b = j;
        return this;
    }

    public CacheBuilder<K, V> E() {
        this.f5965a = f5961c;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> F(long j, TimeUnit timeUnit) {
        i.E(timeUnit);
        long j2 = this.f5977e;
        i.s0(j2 == -1, "refresh was already set to %s ns", j2);
        i.t(j > 0, "duration must be positive: %s %s", j, timeUnit);
        this.f5977e = timeUnit.toNanos(j);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> G(RemovalListener<? super K1, ? super V1> removalListener) {
        i.g0(this.f5968a == null);
        this.f5968a = (RemovalListener) i.E(removalListener);
        return this;
    }

    public CacheBuilder<K, V> H(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.f5967a;
        i.x0(strength2 == null, "Key strength was already set to %s", strength2);
        this.f5967a = (LocalCache.Strength) i.E(strength);
        return this;
    }

    public CacheBuilder<K, V> I(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.f5974b;
        i.x0(strength2 == null, "Value strength was already set to %s", strength2);
        this.f5974b = (LocalCache.Strength) i.E(strength);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> J() {
        return I(LocalCache.Strength.SOFT);
    }

    public CacheBuilder<K, V> K(Ticker ticker) {
        i.g0(this.f5966a == null);
        this.f5966a = (Ticker) i.E(ticker);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> L(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f5973b;
        i.x0(equivalence2 == null, "value equivalence was already set to %s", equivalence2);
        this.f5973b = (Equivalence) i.E(equivalence);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> M() {
        return H(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    public CacheBuilder<K, V> N() {
        return I(LocalCache.Strength.WEAK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> O(Weigher<? super K1, ? super V1> weigher) {
        i.g0(this.f5969a == null);
        if (this.f5970a) {
            long j = this.f5963a;
            i.s0(j == -1, "weigher can not be combined with maximum size", j);
        }
        this.f5969a = (Weigher) i.E(weigher);
        return this;
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> Cache<K1, V1> a() {
        d();
        c();
        return new LocalCache.LocalManualCache(this);
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> b(CacheLoader<? super K1, V1> cacheLoader) {
        d();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public final void c() {
        i.h0(this.f5977e == -1, "refreshAfterWrite requires a LoadingCache");
    }

    public final void d() {
        if (this.f5969a == null) {
            i.h0(this.f5972b == -1, "maximumWeight requires weigher");
        } else if (this.f5970a) {
            i.h0(this.f5972b != -1, "weigher requires maximumWeight");
        } else if (this.f5972b == -1) {
            f5959a.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public CacheBuilder<K, V> e(int i) {
        int i2 = this.f5971b;
        i.n0(i2 == -1, "concurrency level was already set to %s", i2);
        i.d(i > 0);
        this.f5971b = i;
        return this;
    }

    public CacheBuilder<K, V> f(long j, TimeUnit timeUnit) {
        long j2 = this.f5976d;
        i.s0(j2 == -1, "expireAfterAccess was already set to %s ns", j2);
        i.t(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.f5976d = timeUnit.toNanos(j);
        return this;
    }

    public CacheBuilder<K, V> g(long j, TimeUnit timeUnit) {
        long j2 = this.f5975c;
        i.s0(j2 == -1, "expireAfterWrite was already set to %s ns", j2);
        i.t(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.f5975c = timeUnit.toNanos(j);
        return this;
    }

    public int j() {
        int i = this.f5971b;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public long k() {
        long j = this.f5976d;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public long l() {
        long j = this.f5975c;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public int m() {
        int i = this.f5962a;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public Equivalence<Object> n() {
        return (Equivalence) e.a(this.f5964a, o().defaultEquivalence());
    }

    public LocalCache.Strength o() {
        return (LocalCache.Strength) e.a(this.f5967a, LocalCache.Strength.STRONG);
    }

    public long p() {
        if (this.f5975c == 0 || this.f5976d == 0) {
            return 0L;
        }
        return this.f5969a == null ? this.f5963a : this.f5972b;
    }

    public long q() {
        long j = this.f5977e;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> r() {
        return (RemovalListener) e.a(this.f5968a, NullListener.INSTANCE);
    }

    public Supplier<? extends AbstractCache.StatsCounter> s() {
        return this.f5965a;
    }

    public Ticker t(boolean z) {
        Ticker ticker = this.f5966a;
        if (ticker != null) {
            return ticker;
        }
        return z ? Ticker.b() : f5960b;
    }

    public String toString() {
        e.b bVarC = e.c(this);
        int i = this.f5962a;
        if (i != -1) {
            bVarC.d("initialCapacity", i);
        }
        int i2 = this.f5971b;
        if (i2 != -1) {
            bVarC.d("concurrencyLevel", i2);
        }
        long j = this.f5963a;
        if (j != -1) {
            bVarC.e("maximumSize", j);
        }
        long j2 = this.f5972b;
        if (j2 != -1) {
            bVarC.e("maximumWeight", j2);
        }
        long j3 = this.f5975c;
        if (j3 != -1) {
            StringBuilder sb = new StringBuilder(22);
            sb.append(j3);
            sb.append("ns");
            bVarC.f("expireAfterWrite", sb.toString());
        }
        long j4 = this.f5976d;
        if (j4 != -1) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append(j4);
            sb2.append("ns");
            bVarC.f("expireAfterAccess", sb2.toString());
        }
        LocalCache.Strength strength = this.f5967a;
        if (strength != null) {
            bVarC.f("keyStrength", com.google.common.base.a.g(strength.toString()));
        }
        LocalCache.Strength strength2 = this.f5974b;
        if (strength2 != null) {
            bVarC.f("valueStrength", com.google.common.base.a.g(strength2.toString()));
        }
        if (this.f5964a != null) {
            bVarC.s("keyEquivalence");
        }
        if (this.f5973b != null) {
            bVarC.s("valueEquivalence");
        }
        if (this.f5968a != null) {
            bVarC.s("removalListener");
        }
        return bVarC.toString();
    }

    public Equivalence<Object> u() {
        return (Equivalence) e.a(this.f5973b, v().defaultEquivalence());
    }

    public LocalCache.Strength v() {
        return (LocalCache.Strength) e.a(this.f5974b, LocalCache.Strength.STRONG);
    }

    public <K1 extends K, V1 extends V> Weigher<K1, V1> w() {
        return (Weigher) e.a(this.f5969a, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> x(int i) {
        int i2 = this.f5962a;
        i.n0(i2 == -1, "initial capacity was already set to %s", i2);
        i.d(i >= 0);
        this.f5962a = i;
        return this;
    }

    public boolean y() {
        return this.f5965a == f5961c;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> z(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f5964a;
        i.x0(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f5964a = (Equivalence) i.E(equivalence);
        return this;
    }
}
