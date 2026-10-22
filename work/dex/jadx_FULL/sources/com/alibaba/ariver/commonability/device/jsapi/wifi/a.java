package com.alibaba.ariver.commonability.device.jsapi.wifi;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.huawei.hms.push.AttributionReporter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24004a = "WifiAnalyser";

    public static void a(Page page, String str, int i, int i2, String str2) {
        try {
            HashMap map = new HashMap();
            map.put("source_appid", page.getApp().getAppId());
            map.put("ssid", str);
            map.put("in_whitelist", String.valueOf(i));
            map.put("error", String.valueOf(i2));
            map.put("error_msg", str2);
            if (a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext())) {
                map.put(AttributionReporter.SYSTEM_PERMISSION, "lbs");
            }
            a("1010191", map);
        } catch (Exception e) {
            RVLogger.e(f24004a, e);
        }
    }

    public static boolean a(Context context) {
        return a(context, "android.permission.ACCESS_COARSE_LOCATION") || a(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    public static boolean a(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static void a(Page page, String str, int i, String str2) {
        try {
            HashMap map = new HashMap();
            map.put("source_appid", page.getApp().getAppId());
            map.put("ssid", str);
            map.put("error", String.valueOf(i));
            map.put("error_msg", str2);
            a("1010192", map);
        } catch (Exception e) {
            RVLogger.e(f24004a, e);
        }
    }

    public static void a(Page page, int i, String str) {
        try {
            HashMap map = new HashMap();
            map.put("source_appid", page.getApp().getAppId());
            map.put("error", String.valueOf(i));
            map.put("error_msg", str);
            a("1010188", map);
        } catch (Exception e) {
            RVLogger.e(f24004a, e);
        }
    }

    public static void a(Page page, int i, int i2, String str) {
        try {
            HashMap map = new HashMap();
            map.put("source_appid", page.getApp().getAppId());
            map.put("count", String.valueOf(i));
            map.put("error", String.valueOf(i2));
            map.put("error_msg", str);
            a("1010193", map);
        } catch (Exception e) {
            RVLogger.e(f24004a, e);
        }
    }

    private static void a(String str, Map<String, String> map) {
        RVMonitor rVMonitor = (RVMonitor) RVProxy.get(RVMonitor.class);
        if (rVMonitor == null) {
            return;
        }
        rVMonitor.event(str, RVCommonAbilityProxy.MIDDLE, 2, map);
    }
}
