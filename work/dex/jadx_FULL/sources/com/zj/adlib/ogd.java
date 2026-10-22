package com.zj.adlib;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ogd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static ogd f43743a;

    public static synchronized ogd a() {
        if (f43743a == null) {
            f43743a = new ogd();
        }
        return f43743a;
    }

    public static final boolean b() {
        return lgd.a("mlkit-dev-profiling");
    }
}
