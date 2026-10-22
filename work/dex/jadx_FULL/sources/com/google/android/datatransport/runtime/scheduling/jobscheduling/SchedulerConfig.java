package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@AutoValue
public abstract class SchedulerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f30439a = 86400000;
    public static final long b = 30000;
    public static final long c = 1000;
    public static final long d = 10000;

    @AutoValue
    public static abstract class ConfigValue {

        @AutoValue.Builder
        public static abstract class Builder {
            public abstract ConfigValue a();

            public abstract Builder b(long j);

            public abstract Builder c(Set<Flag> set);

            public abstract Builder d(long j);
        }

        public static Builder a() {
            return new b.C0671b().c(Collections.emptySet());
        }

        public abstract long b();

        public abstract Set<Flag> c();

        public abstract long d();
    }

    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Clock f30440a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map<Priority, ConfigValue> f1948a = new HashMap();

        public a a(Priority priority, ConfigValue configValue) {
            this.f1948a.put(priority, configValue);
            return this;
        }

        public SchedulerConfig b() {
            if (this.f30440a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f1948a.keySet().size() < Priority.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map<Priority, ConfigValue> map = this.f1948a;
            this.f1948a = new HashMap();
            return SchedulerConfig.d(this.f30440a, map);
        }

        public a c(Clock clock) {
            this.f30440a = clock;
            return this;
        }
    }

    public static a b() {
        return new a();
    }

    public static SchedulerConfig d(Clock clock, Map<Priority, ConfigValue> map) {
        return new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(clock, map);
    }

    public static SchedulerConfig f(Clock clock) {
        return b().a(Priority.DEFAULT, ConfigValue.a().b(30000L).d(86400000L).a()).a(Priority.HIGHEST, ConfigValue.a().b(1000L).d(86400000L).a()).a(Priority.VERY_LOW, ConfigValue.a().b(86400000L).d(86400000L).c(j(Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE)).a()).c(clock).b();
    }

    public static <T> Set<T> j(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    public final long a(int i, long j) {
        int i2 = i - 1;
        return (long) (Math.pow(3.0d, i2) * j * Math.max(1.0d, Math.log(10000.0d) / Math.log((j > 1 ? j : 2L) * ((long) i2))));
    }

    @RequiresApi(api = 21)
    public JobInfo.Builder c(JobInfo.Builder builder, Priority priority, long j, int i) {
        builder.setMinimumLatency(h(priority, j, i));
        k(builder, i().get(priority).c());
        return builder;
    }

    public abstract Clock e();

    public Set<Flag> g(Priority priority) {
        return i().get(priority).c();
    }

    public long h(Priority priority, long j, int i) {
        long time = j - e().getTime();
        ConfigValue configValue = i().get(priority);
        return Math.min(Math.max(a(i, configValue.b()), time), configValue.d());
    }

    public abstract Map<Priority, ConfigValue> i();

    @RequiresApi(api = 21)
    public final void k(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }
}
