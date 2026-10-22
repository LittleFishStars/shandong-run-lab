package com.alibaba.triver.appinfo.a;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.core.AppInfoStrategy;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24630a = "AppInfoCenter";

    public static void a(String str, String str2, String str3, long j, long j2, Bundle bundle) {
        long j3 = j2 - j;
        try {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(str).setVersion(str2).setStage("appInfo").setStatus(Double.valueOf(1.0d)).setStartParams(bundle).putExtra("channelName", str3).putExtra("timeCost", Long.valueOf(j3)).create());
            RVLogger.d("AppInfoCenter", str + " channel " + str3 + " request success cost " + j3 + "ms.");
        } catch (Exception e) {
            RVLogger.w("AppInfoCenter", e.toString());
        }
    }

    public static void a(String str, String str2, String str3, long j, long j2, String str4, String str5, Bundle bundle) {
        long j3 = j2 - j;
        try {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(str).setVersion(str2).setStage("appInfo").setErrorCode(str4).setErrorMsg(str5).setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).setStartParams(bundle).putExtra("channelName", str3).putExtra("timeCost", Long.valueOf(j3)).create());
            RVLogger.d("AppInfoCenter", str + " channel " + str3 + " request error cost " + j3 + "ms.");
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", e.toString());
        }
    }

    public static void a(String str, String str2, App app, HashMap<String, String> map, PluginModel pluginModel, long j, AppInfoStrategy appInfoStrategy) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pluginId", (Object) str);
        jSONObject.put("pluginVersion", (Object) str2);
        jSONObject.putAll(CommonUtils.getBasicAppMonitorData(app));
        if (j > 0) {
            jSONObject.put("timeCost", (Object) Long.valueOf(j));
            if (pluginModel == null) {
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(false, TriverLogProxyImpl.TLOG_MODULE, "DynamicPluginInfo", map.get("errorCode"), map.get("errorMsg"), jSONObject.toString());
            } else {
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(true, TriverLogProxyImpl.TLOG_MODULE, "DynamicPluginInfo", null, null, jSONObject.toString());
            }
        }
        if (appInfoStrategy == AppInfoStrategy.NONE) {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(true, TriverLogProxyImpl.TLOG_MODULE, "DynamicPluginInfoCache", null, null, jSONObject.toString());
        } else if (appInfoStrategy == AppInfoStrategy.SYNC_LOAD) {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(false, TriverLogProxyImpl.TLOG_MODULE, "DynamicPluginInfoCache", null, null, jSONObject.toString());
        }
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pluginId", (Object) str);
        jSONObject.put("pluginVersion", (Object) str2);
        jSONObject.put("mainAppId", (Object) str3);
        if (z) {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(true, TriverLogProxyImpl.TLOG_MODULE, "DynamicPluginInfoBackUp", null, null, jSONObject.toString());
        } else {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(false, TriverLogProxyImpl.TLOG_MODULE, "DynamicPluginInfoBackUp", str4, str5, jSONObject.toString());
        }
    }

    public static void a(String str, String str2, long j) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackStat("DynamicPlugin", TriverLaunchPointer.build().setAppId(str).setStage(TriverAppMonitorConstants.KEY_STAGE_PLUGIN_SIGN_STAGE).setStatus(Double.valueOf(1.0d)).putExtra("timeCost", Long.valueOf(jCurrentTimeMillis)).putExtra("pluginId", str2).create());
            RVLogger.d("AppInfoCenter", str + " require plugin " + str2 + " sign check success. cost " + jCurrentTimeMillis + "ms.");
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", e);
        }
    }

    public static void a(String str, String str2, long j, String str3, String str4) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackStat("DynamicPlugin", TriverLaunchPointer.build().setAppId(str).setStage(TriverAppMonitorConstants.KEY_STAGE_PLUGIN_SIGN_STAGE).setErrorCode(str3).setErrorMsg(str4).setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).putExtra("timeCost", Long.valueOf(jCurrentTimeMillis)).putExtra("pluginId", str2).create());
            RVLogger.d("AppInfoCenter", str + " require plugin " + str2 + " sign check error. cost " + jCurrentTimeMillis + "ms.");
        } catch (Exception e) {
            RVLogger.e("AppInfoCenter", e);
        }
    }

    public static void a(boolean z, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("miniAppId", (Object) str);
        jSONObject.put("appInfoStrategy", (Object) str4);
        if (z) {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(true, TriverLogProxyImpl.TLOG_MODULE, "AppInfoPreload", null, null, jSONObject.toString());
        } else {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(false, TriverLogProxyImpl.TLOG_MODULE, "AppInfoPreload", str2, str3, jSONObject.toString());
        }
    }

    public static void a(Boolean bool, String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("miniAppId", (Object) str);
        jSONObject.put("miniAppUrl", (Object) str2);
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("templateId", (Object) str3);
        }
        if (bool.booleanValue()) {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(true, TriverLogProxyImpl.TLOG_MODULE, "SimpleAppInfo", null, null, jSONObject.toString());
        } else {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(false, TriverLogProxyImpl.TLOG_MODULE, "SimpleAppInfo", str4, str5, jSONObject.toString());
        }
    }
}
