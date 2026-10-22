package com.zj.adlib;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.TimeModule;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d79 implements Factory<Clock> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d79 f41118a = new d79();
    }

    public static d79 a() {
        return a.f41118a;
    }

    public static Clock c() {
        return (Clock) xw6.c(TimeModule.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Clock get() {
        return c();
    }
}
