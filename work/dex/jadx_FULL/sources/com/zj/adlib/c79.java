package com.zj.adlib;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.TimeModule;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c79 implements Factory<Clock> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c79 f40915a = new c79();
    }

    public static c79 a() {
        return a.f40915a;
    }

    public static Clock b() {
        return (Clock) xw6.c(TimeModule.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Clock get() {
        return b();
    }
}
