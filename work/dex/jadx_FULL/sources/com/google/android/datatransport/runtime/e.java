package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.zj.adlib.xw6;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e implements Factory<Executor> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f30435a = new e();
    }

    public static e a() {
        return a.f30435a;
    }

    public static Executor b() {
        return (Executor) xw6.c(ExecutionModule.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
