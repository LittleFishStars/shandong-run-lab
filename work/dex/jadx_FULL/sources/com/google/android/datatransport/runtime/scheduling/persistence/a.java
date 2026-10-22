package com.google.android.datatransport.runtime.scheduling.persistence;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends EventStoreConfig {
    public final long c;
    public final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final long f1960d;
    public final int e;
    public final int f;

    public static final class b extends EventStoreConfig.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f30448a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Long f1961a;
        public Integer b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Long f1962b;
        public Integer c;

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        public EventStoreConfig a() {
            String str = "";
            if (this.f1961a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f30448a == null) {
                str = str + " loadBatchSize";
            }
            if (this.b == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f1962b == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.c == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f1961a.longValue(), this.f30448a.intValue(), this.b.intValue(), this.f1962b.longValue(), this.c.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        public EventStoreConfig.Builder b(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        public EventStoreConfig.Builder c(long j) {
            this.f1962b = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        public EventStoreConfig.Builder d(int i) {
            this.f30448a = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        public EventStoreConfig.Builder e(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig.Builder
        public EventStoreConfig.Builder f(long j) {
            this.f1961a = Long.valueOf(j);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public int b() {
        return this.e;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public long c() {
        return this.f1960d;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public int d() {
        return this.d;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public int e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventStoreConfig)) {
            return false;
        }
        EventStoreConfig eventStoreConfig = (EventStoreConfig) obj;
        return this.c == eventStoreConfig.f() && this.d == eventStoreConfig.d() && this.e == eventStoreConfig.b() && this.f1960d == eventStoreConfig.c() && this.f == eventStoreConfig.e();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig
    public long f() {
        return this.c;
    }

    public int hashCode() {
        long j = this.c;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003;
        long j2 = this.f1960d;
        return ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.c + ", loadBatchSize=" + this.d + ", criticalSectionEnterTimeoutMs=" + this.e + ", eventCleanUpAge=" + this.f1960d + ", maxBlobByteSizePerRow=" + this.f + "}";
    }

    public a(long j, int i, int i2, long j2, int i3) {
        this.c = j;
        this.d = i;
        this.e = i2;
        this.f1960d = j2;
        this.f = i3;
    }
}
