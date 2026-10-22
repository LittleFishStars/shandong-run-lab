package com.zj.adlib;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class oi0 extends PersistedEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f43754a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EventInternal f18641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TransportContext f18642a;

    public oi0(long j, TransportContext transportContext, EventInternal eventInternal) {
        this.f43754a = j;
        if (transportContext == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f18642a = transportContext;
        if (eventInternal == null) {
            throw new NullPointerException("Null event");
        }
        this.f18641a = eventInternal;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public EventInternal b() {
        return this.f18641a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public long c() {
        return this.f43754a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public TransportContext d() {
        return this.f18642a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        return this.f43754a == persistedEvent.c() && this.f18642a.equals(persistedEvent.d()) && this.f18641a.equals(persistedEvent.b());
    }

    public int hashCode() {
        long j = this.f43754a;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f18642a.hashCode()) * 1000003) ^ this.f18641a.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f43754a + ", transportContext=" + this.f18642a + ", event=" + this.f18641a + "}";
    }
}
