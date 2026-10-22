package com.zj.adlib;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class g30 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g30 f41807a = new g30();

    public static Runnable b() {
        return f41807a;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlarmManagerSchedulerBroadcastReceiver.a();
    }
}
