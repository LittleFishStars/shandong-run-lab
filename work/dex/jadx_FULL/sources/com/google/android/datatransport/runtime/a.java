package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.zj.adlib.t13;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends EventInternal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final t13 f1916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f1917a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1918a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, String> f1919a;
    public final long b;

    public static final class b extends EventInternal.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t13 f30421a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Integer f1920a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Long f1921a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1922a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map<String, String> f1923a;
        public Long b;

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal d() {
            String str = "";
            if (this.f1922a == null) {
                str = " transportName";
            }
            if (this.f30421a == null) {
                str = str + " encodedPayload";
            }
            if (this.f1921a == null) {
                str = str + " eventMillis";
            }
            if (this.b == null) {
                str = str + " uptimeMillis";
            }
            if (this.f1923a == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new a(this.f1922a, this.f1920a, this.f30421a, this.f1921a.longValue(), this.b.longValue(), this.f1923a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder e(Integer num) {
            this.f1920a = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder f(t13 t13Var) {
            if (t13Var == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f30421a = t13Var;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder g(long j) {
            this.f1921a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public Map<String, String> getAutoMetadata() {
            Map<String, String> map = this.f1923a;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder h(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f1922a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder i(long j) {
            this.b = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder setAutoMetadata(Map<String, String> map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f1923a = map;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    @Nullable
    public Integer c() {
        return this.f1917a;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public t13 d() {
        return this.f1916a;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public long e() {
        return this.f30420a;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        return this.f1918a.equals(eventInternal.k()) && ((num = this.f1917a) != null ? num.equals(eventInternal.c()) : eventInternal.c() == null) && this.f1916a.equals(eventInternal.d()) && this.f30420a == eventInternal.e() && this.b == eventInternal.l() && this.f1919a.equals(eventInternal.getAutoMetadata());
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public Map<String, String> getAutoMetadata() {
        return this.f1919a;
    }

    public int hashCode() {
        int iHashCode = (this.f1918a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f1917a;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f1916a.hashCode()) * 1000003;
        long j = this.f30420a;
        int i = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.b;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f1919a.hashCode();
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public String k() {
        return this.f1918a;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public long l() {
        return this.b;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f1918a + ", code=" + this.f1917a + ", encodedPayload=" + this.f1916a + ", eventMillis=" + this.f30420a + ", uptimeMillis=" + this.b + ", autoMetadata=" + this.f1919a + "}";
    }

    public a(String str, @Nullable Integer num, t13 t13Var, long j, long j2, Map<String, String> map) {
        this.f1918a = str;
        this.f1917a = num;
        this.f1916a = t13Var;
        this.f30420a = j;
        this.b = j2;
        this.f1919a = map;
    }
}
