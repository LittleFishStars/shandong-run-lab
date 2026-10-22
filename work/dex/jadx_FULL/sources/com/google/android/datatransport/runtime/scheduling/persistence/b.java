package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.zj.adlib.xw6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements Factory<EventStoreConfig> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f30449a = new b();
    }

    public static b a() {
        return a.f30449a;
    }

    public static EventStoreConfig c() {
        return (EventStoreConfig) xw6.c(EventStoreModule.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public EventStoreConfig get() {
        return c();
    }
}
