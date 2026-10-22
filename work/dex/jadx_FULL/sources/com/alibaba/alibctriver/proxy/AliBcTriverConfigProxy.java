package com.alibaba.alibctriver.proxy;

import com.alibaba.alibctriver.b.a;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcCommonUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AliBcTriverConfigProxy implements IConfigProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23688a = "AliBcTriverConfigProxy";
    private static final String b = "preload_appkey";
    private static final String c = "triver_common_config";
    private static final String d = "jsi_worker_appkey";
    private static final String e = "jsiWorkerAppIdList";
    private static final String f = "openPreload";

    @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy
    public Map<String, String> getConfigsByGroup(String str) {
        String appKey = AlibcBaseTradeCommon.getAppKey();
        HashMap map = new HashMap(16);
        JSONObject jSONObjectA = a.a();
        boolean zB = a.b(b);
        if (jSONObjectA != null) {
            try {
                JSONObject jSONObject = jSONObjectA.getJSONObject(str);
                if (jSONObject != null) {
                    for (String str2 : jSONObject.keySet()) {
                        map.put(str2, String.valueOf(jSONObject.get(str2)));
                    }
                }
                if (TRiverConstants.GROUP_ARIVER_COMMON_CONFIG.equals(str)) {
                    JSONArray jSONArray = jSONObjectA.getJSONArray(d);
                    if (jSONArray != null) {
                        if (JSON.parseArray((String) map.get(e)) == null) {
                            if (jSONArray.contains(appKey) || jSONArray.contains("all")) {
                                map.put(e, "[\"all\"]");
                            }
                        } else if (!jSONArray.contains(appKey) && !jSONArray.contains("all")) {
                            map.remove(e);
                        }
                    }
                } else if ("triver_common_config".equals(str) && !map.containsKey("appInfoPreloadCheckTime")) {
                    map.put("appInfoPreloadCheckTime", "0");
                }
                if (zB && "triver_common_config".equals(str) && "true".equals(map.get(f))) {
                    try {
                        if (AlibcCommonUtils.isApkDebug(AlibcBaseTradeCommon.context) || AlibcCommonUtils.compileVersion("5.0.2.5", "4.9.3.0") > 0) {
                            map.put("needClosedPreloadSchedulerPoints", "");
                        }
                    } catch (Exception e2) {
                        AlibcLogger.e(f23688a, e2.getMessage());
                    }
                }
                return map;
            } catch (Exception e3) {
                AlibcLogger.e(f23688a, "data parse exception: " + e3.getMessage());
            }
        }
        return map;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy
    public String getConfigsByGroupAndName(String str, String str2, String str3) {
        Map<String, String> configsByGroup = getConfigsByGroup(str);
        return (configsByGroup == null || !configsByGroup.containsKey(str2)) ? str3 : configsByGroup.get(str2);
    }

    @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy
    public String getCustomConfigsByGroup(String str) {
        return null;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy
    public void registerListener(String str, IConfigProxy.ConfigListener configListener) {
    }

    @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy
    public void unregisterListener(String str, IConfigProxy.ConfigListener configListener) {
    }
}
