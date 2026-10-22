package com.zj.adlib;

import com.fl.saas.config.utils.SensorUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class g58 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SensorUtil f41824a;

    public /* synthetic */ g58(SensorUtil sensorUtil) {
        this.f41824a = sensorUtil;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f41824a.unRegisterAccelerometer();
    }
}
