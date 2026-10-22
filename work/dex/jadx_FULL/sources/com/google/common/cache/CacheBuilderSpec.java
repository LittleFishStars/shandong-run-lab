package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Splitter;
import com.google.common.base.l;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class CacheBuilderSpec {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ImmutableMap<String, ValueParser> f5978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public long f5979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @CheckForNull
    public LocalCache.Strength f5980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @CheckForNull
    public Boolean f5981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @CheckForNull
    public Integer f5982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @CheckForNull
    public Long f5983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @CheckForNull
    public TimeUnit f5985a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public long f5986b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    @CheckForNull
    public LocalCache.Strength f5987b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    @CheckForNull
    public Integer f5988b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    @CheckForNull
    public Long f5989b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    @CheckForNull
    public TimeUnit f5990b;

    @VisibleForTesting
    public long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @VisibleForTesting
    @CheckForNull
    public TimeUnit f5991c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Splitter f31610a = Splitter.h(',').q();
    public static final Splitter b = Splitter.h(com.alipay.sdk.m.p.a.h).q();

    public static abstract class DurationParser implements ValueParser {
        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            TimeUnit timeUnit;
            if (l.d(str2)) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
                sb.append("value of key ");
                sb.append(str);
                sb.append(" omitted");
                throw new IllegalArgumentException(sb.toString());
            }
            try {
                char cCharAt = str2.charAt(str2.length() - 1);
                if (cCharAt == 'd') {
                    timeUnit = TimeUnit.DAYS;
                } else if (cCharAt == 'h') {
                    timeUnit = TimeUnit.HOURS;
                } else if (cCharAt == 'm') {
                    timeUnit = TimeUnit.MINUTES;
                } else {
                    if (cCharAt != 's') {
                        throw new IllegalArgumentException(CacheBuilderSpec.d("key %s invalid unit: was %s, must end with one of [dhms]", str, str2));
                    }
                    timeUnit = TimeUnit.SECONDS;
                }
                parseDuration(cacheBuilderSpec, Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(CacheBuilderSpec.d("key %s value set to %s, must be integer", str, str2));
            }
        }

        public abstract void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit);
    }

    public static abstract class IntegerParser implements ValueParser {
        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            if (!l.d(str2)) {
                try {
                    parseInteger(cacheBuilderSpec, Integer.parseInt(str2));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(CacheBuilderSpec.d("key %s value set to %s, must be integer", str, str2), e);
                }
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
                sb.append("value of key ");
                sb.append(str);
                sb.append(" omitted");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        public abstract void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i);
    }

    public static abstract class LongParser implements ValueParser {
        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            if (!l.d(str2)) {
                try {
                    parseLong(cacheBuilderSpec, Long.parseLong(str2));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(CacheBuilderSpec.d("key %s value set to %s, must be integer", str, str2), e);
                }
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
                sb.append("value of key ");
                sb.append(str);
                sb.append(" omitted");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        public abstract void parseLong(CacheBuilderSpec cacheBuilderSpec, long j);
    }

    public interface ValueParser {
        void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2);
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31611a;

        static {
            int[] iArr = new int[LocalCache.Strength.values().length];
            f31611a = iArr;
            try {
                iArr[LocalCache.Strength.WEAK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31611a[LocalCache.Strength.SOFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class b extends DurationParser {
        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        public void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
            com.google.common.base.i.e(cacheBuilderSpec.f5990b == null, "expireAfterAccess already set");
            cacheBuilderSpec.f5986b = j;
            cacheBuilderSpec.f5990b = timeUnit;
        }
    }

    public static class c extends IntegerParser {
        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        public void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i) {
            Integer num = cacheBuilderSpec.f5988b;
            com.google.common.base.i.u(num == null, "concurrency level was already set to ", num);
            cacheBuilderSpec.f5988b = Integer.valueOf(i);
        }
    }

    public static class d extends IntegerParser {
        @Override // com.google.common.cache.CacheBuilderSpec.IntegerParser
        public void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i) {
            Integer num = cacheBuilderSpec.f5982a;
            com.google.common.base.i.u(num == null, "initial capacity was already set to ", num);
            cacheBuilderSpec.f5982a = Integer.valueOf(i);
        }
    }

    public static class e implements ValueParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LocalCache.Strength f31612a;

        public e(LocalCache.Strength strength) {
            this.f31612a = strength;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            com.google.common.base.i.u(str2 == null, "key %s does not take values", str);
            LocalCache.Strength strength = cacheBuilderSpec.f5980a;
            com.google.common.base.i.y(strength == null, "%s was already set to %s", str, strength);
            cacheBuilderSpec.f5980a = this.f31612a;
        }
    }

    public static class f extends LongParser {
        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        public void parseLong(CacheBuilderSpec cacheBuilderSpec, long j) {
            Long l = cacheBuilderSpec.f5983a;
            com.google.common.base.i.u(l == null, "maximum size was already set to ", l);
            Long l2 = cacheBuilderSpec.f5989b;
            com.google.common.base.i.u(l2 == null, "maximum weight was already set to ", l2);
            cacheBuilderSpec.f5983a = Long.valueOf(j);
        }
    }

    public static class g extends LongParser {
        @Override // com.google.common.cache.CacheBuilderSpec.LongParser
        public void parseLong(CacheBuilderSpec cacheBuilderSpec, long j) {
            Long l = cacheBuilderSpec.f5989b;
            com.google.common.base.i.u(l == null, "maximum weight was already set to ", l);
            Long l2 = cacheBuilderSpec.f5983a;
            com.google.common.base.i.u(l2 == null, "maximum size was already set to ", l2);
            cacheBuilderSpec.f5989b = Long.valueOf(j);
        }
    }

    public static class h implements ValueParser {
        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            com.google.common.base.i.e(str2 == null, "recordStats does not take values");
            com.google.common.base.i.e(cacheBuilderSpec.f5981a == null, "recordStats already set");
            cacheBuilderSpec.f5981a = Boolean.TRUE;
        }
    }

    public static class i extends DurationParser {
        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        public void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
            com.google.common.base.i.e(cacheBuilderSpec.f5991c == null, "refreshAfterWrite already set");
            cacheBuilderSpec.c = j;
            cacheBuilderSpec.f5991c = timeUnit;
        }
    }

    public static class j implements ValueParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LocalCache.Strength f31613a;

        public j(LocalCache.Strength strength) {
            this.f31613a = strength;
        }

        @Override // com.google.common.cache.CacheBuilderSpec.ValueParser
        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            com.google.common.base.i.u(str2 == null, "key %s does not take values", str);
            LocalCache.Strength strength = cacheBuilderSpec.f5987b;
            com.google.common.base.i.y(strength == null, "%s was already set to %s", str, strength);
            cacheBuilderSpec.f5987b = this.f31613a;
        }
    }

    public static class k extends DurationParser {
        @Override // com.google.common.cache.CacheBuilderSpec.DurationParser
        public void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
            com.google.common.base.i.e(cacheBuilderSpec.f5985a == null, "expireAfterWrite already set");
            cacheBuilderSpec.f5979a = j;
            cacheBuilderSpec.f5985a = timeUnit;
        }
    }

    static {
        ImmutableMap.b bVarF = ImmutableMap.builder().f("initialCapacity", new d()).f("maximumSize", new f()).f("maximumWeight", new g()).f("concurrencyLevel", new c());
        LocalCache.Strength strength = LocalCache.Strength.WEAK;
        f5978a = bVarF.f("weakKeys", new e(strength)).f("softValues", new j(LocalCache.Strength.SOFT)).f("weakValues", new j(strength)).f("recordStats", new h()).f("expireAfterAccess", new b()).f("expireAfterWrite", new k()).f("refreshAfterWrite", new i()).f("refreshInterval", new i()).a();
    }

    public CacheBuilderSpec(String str) {
        this.f5984a = str;
    }

    public static CacheBuilderSpec b() {
        return e("maximumSize=0");
    }

    @CheckForNull
    public static Long c(long j2, @CheckForNull TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j2));
    }

    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CacheBuilderSpec e(String str) {
        CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(str);
        if (!str.isEmpty()) {
            for (String str2 : f31610a.n(str)) {
                ImmutableList immutableListCopyOf = ImmutableList.copyOf(b.n(str2));
                com.google.common.base.i.e(!immutableListCopyOf.isEmpty(), "blank key-value pair");
                com.google.common.base.i.u(immutableListCopyOf.size() <= 2, "key-value pair %s with more than one equals sign", str2);
                String str3 = (String) immutableListCopyOf.get(0);
                ValueParser valueParser = f5978a.get(str3);
                com.google.common.base.i.u(valueParser != null, "unknown key %s", str3);
                valueParser.a(cacheBuilderSpec, str3, immutableListCopyOf.size() == 1 ? null : (String) immutableListCopyOf.get(1));
            }
        }
        return cacheBuilderSpec;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        return com.google.common.base.g.a(this.f5982a, cacheBuilderSpec.f5982a) && com.google.common.base.g.a(this.f5983a, cacheBuilderSpec.f5983a) && com.google.common.base.g.a(this.f5989b, cacheBuilderSpec.f5989b) && com.google.common.base.g.a(this.f5988b, cacheBuilderSpec.f5988b) && com.google.common.base.g.a(this.f5980a, cacheBuilderSpec.f5980a) && com.google.common.base.g.a(this.f5987b, cacheBuilderSpec.f5987b) && com.google.common.base.g.a(this.f5981a, cacheBuilderSpec.f5981a) && com.google.common.base.g.a(c(this.f5979a, this.f5985a), c(cacheBuilderSpec.f5979a, cacheBuilderSpec.f5985a)) && com.google.common.base.g.a(c(this.f5986b, this.f5990b), c(cacheBuilderSpec.f5986b, cacheBuilderSpec.f5990b)) && com.google.common.base.g.a(c(this.c, this.f5991c), c(cacheBuilderSpec.c, cacheBuilderSpec.f5991c));
    }

    public CacheBuilder<Object, Object> f() {
        CacheBuilder<Object, Object> cacheBuilderD = CacheBuilder.D();
        Integer num = this.f5982a;
        if (num != null) {
            cacheBuilderD.x(num.intValue());
        }
        Long l = this.f5983a;
        if (l != null) {
            cacheBuilderD.B(l.longValue());
        }
        Long l2 = this.f5989b;
        if (l2 != null) {
            cacheBuilderD.C(l2.longValue());
        }
        Integer num2 = this.f5988b;
        if (num2 != null) {
            cacheBuilderD.e(num2.intValue());
        }
        LocalCache.Strength strength = this.f5980a;
        if (strength != null) {
            if (a.f31611a[strength.ordinal()] != 1) {
                throw new AssertionError();
            }
            cacheBuilderD.M();
        }
        LocalCache.Strength strength2 = this.f5987b;
        if (strength2 != null) {
            int i2 = a.f31611a[strength2.ordinal()];
            if (i2 == 1) {
                cacheBuilderD.N();
            } else {
                if (i2 != 2) {
                    throw new AssertionError();
                }
                cacheBuilderD.J();
            }
        }
        Boolean bool = this.f5981a;
        if (bool != null && bool.booleanValue()) {
            cacheBuilderD.E();
        }
        TimeUnit timeUnit = this.f5985a;
        if (timeUnit != null) {
            cacheBuilderD.g(this.f5979a, timeUnit);
        }
        TimeUnit timeUnit2 = this.f5990b;
        if (timeUnit2 != null) {
            cacheBuilderD.f(this.f5986b, timeUnit2);
        }
        TimeUnit timeUnit3 = this.f5991c;
        if (timeUnit3 != null) {
            cacheBuilderD.F(this.c, timeUnit3);
        }
        return cacheBuilderD;
    }

    public String g() {
        return this.f5984a;
    }

    public int hashCode() {
        return com.google.common.base.g.b(this.f5982a, this.f5983a, this.f5989b, this.f5988b, this.f5980a, this.f5987b, this.f5981a, c(this.f5979a, this.f5985a), c(this.f5986b, this.f5990b), c(this.c, this.f5991c));
    }

    public String toString() {
        return com.google.common.base.e.c(this).s(g()).toString();
    }
}
