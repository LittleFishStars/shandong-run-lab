package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends SchedulerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Clock f30441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<Priority, SchedulerConfig.ConfigValue> f1949a;

    public a(Clock clock, Map<Priority, SchedulerConfig.ConfigValue> map) {
        if (clock == null) {
            throw new NullPointerException("Null clock");
        }
        this.f30441a = clock;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f1949a = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public Clock e() {
        return this.f30441a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        return this.f30441a.equals(schedulerConfig.e()) && this.f1949a.equals(schedulerConfig.i());
    }

    public int hashCode() {
        return ((this.f30441a.hashCode() ^ 1000003) * 1000003) ^ this.f1949a.hashCode();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public Map<Priority, SchedulerConfig.ConfigValue> i() {
        return this.f1949a;
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f30441a + ", values=" + this.f1949a + "}";
    }
}
