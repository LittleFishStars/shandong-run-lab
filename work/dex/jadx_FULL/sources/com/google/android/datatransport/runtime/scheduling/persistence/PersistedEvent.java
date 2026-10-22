package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.auto.value.AutoValue;
import com.zj.adlib.oi0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@AutoValue
public abstract class PersistedEvent {
    public static PersistedEvent a(long j, TransportContext transportContext, EventInternal eventInternal) {
        return new oi0(j, transportContext, eventInternal);
    }

    public abstract EventInternal b();

    public abstract long c();

    public abstract TransportContext d();
}
