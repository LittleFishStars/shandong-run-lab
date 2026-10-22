package com.alibaba.ariver.resource.api.prerun;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppxPrerunChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24434a = "AriverRes:AppxPrerunChecker";
    private static final String b = "ta_appxng_prerun_blacklist";
    private static final Set<String> c = new HashSet();
    private static final Set<String> d = new HashSet();
    private static final Set<String> e = new HashSet();
    private static final String f = "0";
    private static final String g = "1";

    static {
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@Nullable String str) {
        try {
            c.clear();
            d.clear();
            JSONObject object = JSONUtils.parseObject(str);
            if (object != null) {
                JSONArray jSONArray = object.getJSONArray("white_list");
                if (!CollectionUtils.isEmpty(jSONArray)) {
                    for (int i = 0; i < jSONArray.size(); i++) {
                        c.add(jSONArray.getString(i));
                    }
                }
                JSONArray jSONArray2 = object.getJSONArray("block_apis");
                if (CollectionUtils.isEmpty(jSONArray2)) {
                    return;
                }
                for (int i2 = 0; i2 < jSONArray2.size(); i2++) {
                    d.add(jSONArray2.getString(i2));
                }
            }
        } catch (Exception e2) {
            RVLogger.w(f24434a, "initPrerunConfig failed:\t", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@Nullable String str) {
        try {
            e.clear();
            JSONArray array = JSONUtils.parseArray(str);
            if (CollectionUtils.isEmpty(array)) {
                return;
            }
            for (int i = 0; i < array.size(); i++) {
                e.add(array.getString(i));
            }
        } catch (Exception e2) {
            RVLogger.w(f24434a, "initMessageQueueConfig failed:\t", e2);
        }
    }

    public static boolean isPrerunAction(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !d.contains(str);
    }

    public static boolean isPrerunWorkerApp(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || bundle == null) {
            return false;
        }
        if (!"YES".equalsIgnoreCase(BundleUtils.getString(bundle, RVParams.APPX_ROUTE_FRAMEWORK))) {
            return c.contains(str);
        }
        if (!d.isEmpty()) {
            JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray(b);
            return (CollectionUtils.isEmpty(configJSONArray) || !configJSONArray.contains(str)) && !"NO".equalsIgnoreCase(BundleUtils.getString(bundle, RVParams.PRE_RUN_WORKER));
        }
        return false;
    }

    public static boolean isRenderMessageQueue(String str) {
        String strB = b();
        if (strB.equals("0")) {
            return e.contains(str);
        }
        return strB.equals("1");
    }

    public static void tryInjectStartParams(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!isPrerunWorkerApp(str, bundle)) {
            if (BundleUtils.contains(bundle, RVParams.PRE_RUN_WORKER)) {
                bundle.remove(RVParams.PRE_RUN_WORKER);
                return;
            }
            return;
        }
        RVLogger.d(f24434a, str + " support prerun");
        bundle.putString(RVParams.PRE_RUN_WORKER, "YES");
        if (isRenderMessageQueue(str)) {
            RVLogger.d(f24434a, str + " support messagequeue");
            bundle.putString(RVParams.ENABLE_RENDER_MESSAGEQUEUE, "YES");
        }
    }

    private static String b() {
        return RVKernelUtils.isDebug() ? PreferenceManager.getDefaultSharedPreferences(ProcessUtils.getContext()).getString("prerun_dev_mode_settings", "0") : "0";
    }

    private static void a() {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService == null) {
            return;
        }
        try {
            a(rVConfigService.getConfig("ta_launch_prerunWorker", null, new RVConfigService.OnConfigChangeListener() { // from class: com.alibaba.ariver.resource.api.prerun.AppxPrerunChecker.1
                @Override // com.alibaba.ariver.kernel.common.service.RVConfigService.OnConfigChangeListener
                public void onChange(String str) {
                    RVLogger.d(AppxPrerunChecker.f24434a, "ta_launch_prerunWorker,onConfigChange:  " + str);
                    AppxPrerunChecker.a(str);
                }
            }));
        } catch (Exception e2) {
            RVLogger.e(f24434a, e2);
        }
        try {
            b(rVConfigService.getConfig("ta_v8Worker_messageQueue_whiteList", null, new RVConfigService.OnConfigChangeListener() { // from class: com.alibaba.ariver.resource.api.prerun.AppxPrerunChecker.2
                @Override // com.alibaba.ariver.kernel.common.service.RVConfigService.OnConfigChangeListener
                public void onChange(String str) {
                    RVLogger.d(AppxPrerunChecker.f24434a, "ta_v8Worker_messageQueue_whiteList,onConfigChange:  " + str);
                    AppxPrerunChecker.b(str);
                }
            }));
        } catch (Exception e3) {
            RVLogger.e(f24434a, e3);
        }
    }
}
