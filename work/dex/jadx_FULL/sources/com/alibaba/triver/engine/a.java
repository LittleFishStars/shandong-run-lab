package com.alibaba.triver.engine;

import com.alibaba.ariver.app.api.App;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Timer f24914a;

    public void a(final App app) {
        if (app == null || app.isDestroyed() || !TRiverUrlUtils.isShop(app)) {
            return;
        }
        this.f24914a = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.alibaba.triver.engine.a.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LaunchMonitorData subMonitorData;
                App app2 = app;
                if (app2 == null || (subMonitorData = LaunchMonitorUtils.getSubMonitorData(app2)) == null || subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_LOAD_FINISH)) {
                    return;
                }
                c.a(app, null);
            }
        };
        int iA = c.a();
        if (this.f24914a != null) {
            this.f24914a.schedule(timerTask, TBShopOrangeController.getResourceTimeOutDowngradeWeexShopDuration(iA) * 1000);
        }
    }

    public void a() {
        if (this.f24914a != null) {
            this.f24914a.cancel();
            this.f24914a = null;
        }
    }
}
