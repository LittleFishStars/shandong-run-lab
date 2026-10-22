package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface TransportBackend {
    BackendResponse a(BackendRequest backendRequest);

    EventInternal b(EventInternal eventInternal);
}
