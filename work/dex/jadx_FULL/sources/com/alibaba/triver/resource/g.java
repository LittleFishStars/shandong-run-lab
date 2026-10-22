package com.alibaba.triver.resource;

import android.util.Log;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f25165a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final String d = "UPDATE_PACK_RETURN_NULL";
    public static final String e = "ERROR_IS_NULL";
    public static final String f = "HTTP_FAILED";

    public static void a(PluginModel pluginModel, boolean z, boolean z2, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("miniAppId", (Object) pluginModel.getAppId());
        jSONObject.put("url", (Object) pluginModel.getPackageUrl());
        jSONObject.put("zCacheKey", (Object) str);
        jSONObject.put("zCacheInfo", (Object) str2);
        jSONObject.put("isPlugin", (Object) "true");
        if (z2) {
            jSONObject.put("source", (Object) "zCache");
            jSONObject.put("zCacheError", (Object) str3);
        } else {
            jSONObject.put("source", (Object) "http");
            jSONObject.put("zCacheError", (Object) str3);
        }
        JSONObject jSONObject2 = new JSONObject();
        if (z) {
            jSONObject2.put("successCount", (Object) Float.valueOf(1.0f));
            jSONObject2.put("failedCount", (Object) Float.valueOf(0.0f));
        } else {
            jSONObject2.put("successCount", (Object) Float.valueOf(0.0f));
            jSONObject2.put("failedCount", (Object) Float.valueOf(1.0f));
        }
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackStat(TriverLogProxyImpl.TLOG_MODULE, "Resource", jSONObject, jSONObject2);
    }

    public static void a(AppModel appModel, boolean z, boolean z2, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("miniAppId", (Object) appModel.getAppId());
        jSONObject.put("url", (Object) appModel.getAppInfoModel().getPackageUrl());
        if (appModel.getAppInfoModel().getTemplateConfig() != null) {
            jSONObject.put("templateId", (Object) appModel.getAppInfoModel().getTemplateConfig().getTemplateId());
        }
        try {
            jSONObject.put("deployVersion", (Object) appModel.getAppVersion());
            jSONObject.put("developVersion", (Object) appModel.getAppInfoModel().getDeveloperVersion());
            jSONObject.put("bizType", (Object) appModel.getExtendInfos().getString("bizType"));
            jSONObject.put(TRiverConstants.KEY_SUB_BIZ_TYPE, (Object) appModel.getExtendInfos().getString(TRiverConstants.KEY_SUB_BIZ_TYPE));
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
        HashMap<String, JSONObject> mapA = com.alibaba.triver.utils.d.a(appModel);
        if (mapA.size() != 0) {
            String next = mapA.keySet().iterator().next();
            jSONObject.put("zCacheKey", (Object) next);
            jSONObject.put("zCacheInfo", (Object) mapA.get(next).toString());
        }
        jSONObject.put("isPlugin", (Object) AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        if (z2) {
            jSONObject.put("source", (Object) "zCache");
            jSONObject.put("zCacheError", (Object) str);
        } else {
            jSONObject.put("source", (Object) "http");
            jSONObject.put("zCacheError", (Object) str);
        }
        JSONObject jSONObject2 = new JSONObject();
        if (z) {
            jSONObject2.put("successCount", (Object) Float.valueOf(1.0f));
            jSONObject2.put("failedCount", (Object) Float.valueOf(0.0f));
        } else {
            jSONObject2.put("successCount", (Object) Float.valueOf(0.0f));
            jSONObject2.put("failedCount", (Object) Float.valueOf(1.0f));
        }
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackStat(TriverLogProxyImpl.TLOG_MODULE, "Resource", jSONObject, jSONObject2);
    }
}
