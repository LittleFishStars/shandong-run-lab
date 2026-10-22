package com.ali.auth.third.ut;

import android.app.Application;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.zj.adlib.ze1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UserTrackerImpl implements UserTrackerService {
    public UserTrackerImpl() {
        try {
            UTAnalytics.getInstance().setContext(KernelContext.context);
            UTAnalytics.getInstance().setAppApplicationInstance((Application) KernelContext.context.getApplicationContext());
            UTAnalytics.getInstance().setRequestAuthentication(new UTSecuritySDKRequestAuthentication(KernelContext.getAppKey(), ""));
            a();
        } catch (Throwable unused) {
        }
    }

    private void a() {
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder("80001");
        HashMap map = new HashMap();
        map.put(ze1.k, "auth");
        map.put("version", ConfigManager.SDK_VERSION.toString());
        uTCustomHitBuilder.setProperties(map);
        UTAnalytics.getInstance().getTracker("25").send(uTCustomHitBuilder.build());
    }

    private static Map<String, String> b() {
        return new HashMap();
    }

    @Override // com.ali.auth.third.core.service.UserTrackerService
    public void send(String str, Map<String, String> map) {
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str);
        Map<String, String> mapB = b();
        if (map != null) {
            mapB.putAll(map);
        }
        uTCustomHitBuilder.setProperties(mapB);
        UTAnalytics.getInstance().getTracker("onesdk").send(uTCustomHitBuilder.build());
    }
}
