package com.zj.adlib;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ftd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static ftd f41757a;

    public static synchronized ftd a() {
        if (f41757a == null) {
            f41757a = new ftd();
        }
        return f41757a;
    }
}
