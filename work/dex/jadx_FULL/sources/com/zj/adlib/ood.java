package com.zj.adlib;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ood {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static ood f43797a;

    public static synchronized ood a() {
        if (f43797a == null) {
            f43797a = new ood();
        }
        return f43797a;
    }

    public static void b() {
        mod.a();
    }
}
