package com.google.android.datatransport.runtime.scheduling.persistence;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import java.io.Closeable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@WorkerThread
public interface EventStore extends Closeable {
    void F0(Iterable<PersistedEvent> iterable);

    @Nullable
    PersistedEvent I(TransportContext transportContext, EventInternal eventInternal);

    int O();

    Iterable<PersistedEvent> T(TransportContext transportContext);

    void e0(Iterable<PersistedEvent> iterable);

    void h0(TransportContext transportContext, long j);

    Iterable<TransportContext> l0();

    boolean n0(TransportContext transportContext);

    long t(TransportContext transportContext);
}
