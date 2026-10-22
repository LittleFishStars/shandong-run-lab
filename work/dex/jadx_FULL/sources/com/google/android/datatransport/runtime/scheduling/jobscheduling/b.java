package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends SchedulerConfig.ConfigValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set<SchedulerConfig.Flag> f1950a;
    public final long b;

    /* JADX INFO: renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.b$b, reason: collision with other inner class name */
    public static final class C0671b extends SchedulerConfig.ConfigValue.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f30443a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Set<SchedulerConfig.Flag> f1951a;
        public Long b;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue a() {
            String str = "";
            if (this.f30443a == null) {
                str = " delta";
            }
            if (this.b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f1951a == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new b(this.f30443a.longValue(), this.b.longValue(), this.f1951a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder b(long j) {
            this.f30443a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder c(Set<SchedulerConfig.Flag> set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f1951a = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder d(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    public long b() {
        return this.f30442a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    public Set<SchedulerConfig.Flag> c() {
        return this.f1950a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    public long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.ConfigValue)) {
            return false;
        }
        SchedulerConfig.ConfigValue configValue = (SchedulerConfig.ConfigValue) obj;
        return this.f30442a == configValue.b() && this.b == configValue.d() && this.f1950a.equals(configValue.c());
    }

    public int hashCode() {
        long j = this.f30442a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.b;
        return ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f1950a.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f30442a + ", maxAllowedDelay=" + this.b + ", flags=" + this.f1950a + "}";
    }

    public b(long j, long j2, Set<SchedulerConfig.Flag> set) {
        this.f30442a = j;
        this.b = j2;
        this.f1950a = set;
    }
}
