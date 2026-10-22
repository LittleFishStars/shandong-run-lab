package com.zj.adlib;

import android.media.metrics.LogSessionId;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class at6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final at6 f40608a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final a f15394a;

    @RequiresApi(31)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f40609a = new a(LogSessionId.LOG_SESSION_ID_NONE);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final LogSessionId f15395a;

        public a(LogSessionId logSessionId) {
            this.f15395a = logSessionId;
        }
    }

    static {
        f40608a = gj9.f41922a < 31 ? new at6() : new at6(a.f40609a);
    }

    public at6() {
        this((a) null);
        sb0.i(gj9.f41922a < 31);
    }

    @RequiresApi(31)
    public LogSessionId a() {
        return ((a) sb0.g(this.f15394a)).f15395a;
    }

    @RequiresApi(31)
    public at6(LogSessionId logSessionId) {
        this(new a(logSessionId));
    }

    public at6(@Nullable a aVar) {
        this.f15394a = aVar;
    }
}
