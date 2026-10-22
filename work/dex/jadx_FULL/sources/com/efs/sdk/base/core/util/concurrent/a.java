package com.efs.sdk.base.core.util.concurrent;

import android.os.HandlerThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HandlerThread f29618a;

    static {
        HandlerThread handlerThread = new HandlerThread("efs-base", 10);
        f29618a = handlerThread;
        handlerThread.start();
    }
}
