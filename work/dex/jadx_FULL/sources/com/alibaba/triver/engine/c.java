package com.alibaba.triver.engine;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.triver.app.TriverLoadingController;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.proxy.IDeviceInfoProxy;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.ipd.dsp.internal.e1.f;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {
    public static int a() {
        HashMap<String, Integer> map = new HashMap<String, Integer>() { // from class: com.alibaba.triver.engine.ShopEngineDowngrader$1
            {
                put(f.l, 0);
                put("medium", 1);
                put(f.n, 2);
            }
        };
        try {
            int deviceScore = ((IDeviceInfoProxy) RVProxy.get(IDeviceInfoProxy.class)).getDeviceScore();
            if (deviceScore >= 80) {
                return map.get(f.l).intValue();
            }
            return deviceScore >= 60 ? map.get("medium").intValue() : map.get(f.n).intValue();
        } catch (Throwable unused) {
            return map.get("medium").intValue();
        }
    }

    public static void a(final App app, String str) {
        if (app != null && TRiverUrlUtils.isShop(app) && TBShopOrangeController.shopCanDowngrade()) {
            LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(app);
            if (subMonitorData == null || !(subMonitorData.containsKey(TriverAppMonitorConstants.KEY_SHOP_ON_DOWNGRADE) || app.isDestroyed())) {
                if (subMonitorData != null) {
                    subMonitorData.addPoint(TriverAppMonitorConstants.KEY_SHOP_ON_DOWNGRADE);
                }
                if (TextUtils.isEmpty(str)) {
                    str = TBShopOrangeController.getDowngradeShopUrl() + TRiverUrlUtils.getUrlParams(app);
                }
                ((TriverLoadingController.DowngradePoint) ExtensionPoint.as(TriverLoadingController.DowngradePoint.class).node(app).create()).downgradeTo(str.replace(TRiverConstants.KEY_APP_ID, "ariver_appid"));
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alibaba.triver.engine.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        App app2 = app;
                        if (app2 == null || app2.isDestroyed()) {
                            return;
                        }
                        app.exit();
                    }
                }, 500L);
            }
        }
    }
}
