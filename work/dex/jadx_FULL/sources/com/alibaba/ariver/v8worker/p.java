package com.alibaba.ariver.v8worker;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24530a = "WorkerInitInjector";

    public static boolean a() {
        return "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ta_v8InitInjectJSON", "yes"));
    }

    public static void a(JSONObject jSONObject) {
        String strA = a((RVConfigService) RVProxy.get(RVConfigService.class));
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        jSONObject.put("__appxFrameworkConfig", (Object) strA);
    }

    private static String a(RVConfigService rVConfigService) {
        String configWithProcessCache = rVConfigService.getConfigWithProcessCache("ta_appxStartupConfigKeys", "");
        if (TextUtils.isEmpty(configWithProcessCache)) {
            return "";
        }
        HashMap map = new HashMap();
        try {
            for (Object obj : JSON.parseArray(configWithProcessCache)) {
                if (obj != null) {
                    String string = obj.toString();
                    String configWithProcessCache2 = rVConfigService.getConfigWithProcessCache(string, null);
                    if (configWithProcessCache2 == null) {
                        configWithProcessCache2 = "";
                    }
                    map.put(string, configWithProcessCache2);
                }
            }
            String jSONString = JSON.toJSONString(map);
            RVLogger.d(f24530a, "getAppxFrameworkSwitch intercept start params: " + jSONString);
            return jSONString;
        } catch (Exception e) {
            RVLogger.e(f24530a, "getAppxFrameworkSwitch error:", e);
            return "";
        }
    }
}
