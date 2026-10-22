package com.zj.adlib;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r53 implements Factory<Integer> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r53 f44375a = new r53();
    }

    public static r53 a() {
        return a.f44375a;
    }

    public static int c() {
        return EventStoreModule.c();
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer get() {
        return Integer.valueOf(c());
    }
}
