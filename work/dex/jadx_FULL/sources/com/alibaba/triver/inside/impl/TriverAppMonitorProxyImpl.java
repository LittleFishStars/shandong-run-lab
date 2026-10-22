package com.alibaba.triver.inside.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.mtop.monitor.TRVMonitor;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.Dimension;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.triver.Triver;
import com.alibaba.triver.extensions.AppLifecycleExtension;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.monitor.d;
import com.alibaba.triver.utils.CommonUtils;
import com.zj.adlib.xh9;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverAppMonitorProxyImpl implements TRVMonitor, ITriverAppMonitorProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24990a = "TriverAppMonitorProxy";

    private JSONObject a(TriverLaunchPointer triverLaunchPointer, double d) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", (Object) triverLaunchPointer.status);
        HashMap map = triverLaunchPointer.extra;
        if (map != null && map.get("timeCost") != null) {
            try {
                d = Double.parseDouble(triverLaunchPointer.extra.get("timeCost").toString());
            } catch (Exception unused) {
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
            }
        }
        jSONObject.put("status", (Object) triverLaunchPointer.status);
        jSONObject.put("costTime", (Object) Double.valueOf(d));
        jSONObject.put("timeCost", (Object) Double.valueOf(d));
        a(triverLaunchPointer, jSONObject);
        return jSONObject;
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitMajorAPIAlarm(boolean z, App app, String str, String str2, String str3, JSONObject jSONObject) {
        AppInfoModel appInfoModel;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("apiName", (Object) str);
            jSONObject2.put("timeStep", (Object) Long.valueOf(System.currentTimeMillis()));
            if (app != null) {
                jSONObject2.put("miniAppId", (Object) app.getAppId());
                AppModel appModel = (AppModel) app.getData(AppModel.class);
                if (appModel != null && (appInfoModel = appModel.getAppInfoModel()) != null) {
                    jSONObject2.put("miniAppKey", (Object) appInfoModel.getAppKey());
                    jSONObject2.put("deployVersion", (Object) appInfoModel.getVersion());
                    jSONObject2.put("developVersion", (Object) appInfoModel.getDeveloperVersion());
                    TemplateConfigModel templateConfig = appInfoModel.getTemplateConfig();
                    if (templateConfig != null) {
                        jSONObject2.put("templateId", (Object) templateConfig.getTemplateId());
                    }
                }
            }
            jSONObject2.put("req_raw_data", (Object) jSONObject);
            if (z) {
                AppMonitor.Alarm.commitSuccess(TriverLogProxyImpl.TLOG_MODULE, "APIMajor", jSONObject2.toJSONString());
            } else {
                AppMonitor.Alarm.commitFail(TriverLogProxyImpl.TLOG_MODULE, "APIMajor", jSONObject2.toJSONString(), str2, str3);
            }
            if (CommonUtils.isApkDebug()) {
                RVLogger.d(d.f25020a, "AppMonitor.trackAlarm ----module:" + TriverLogProxyImpl.TLOG_MODULE + ", monitorPoint:APIMajor, errorCode:" + str2 + ",errorMsg:" + str3 + ",args:" + jSONObject);
            }
        } catch (Throwable th) {
            RVLogger.e(f24990a, th);
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitTRiverPreloadPerf(TriverLaunchPointer triverLaunchPointer, String str, boolean z, long j, int i) {
        try {
            JSONObject jSONObjectA = a(triverLaunchPointer, null, null, null);
            jSONObjectA.put("preloadType", (Object) str);
            jSONObjectA.put("errorCode", (Object) Integer.valueOf(i));
            JSONObject jSONObjectA2 = a(triverLaunchPointer, j);
            jSONObjectA2.put("preloadResult", (Object) Integer.valueOf(z ? 1 : 0));
            trackStat(TriverLogProxyImpl.TLOG_MODULE, "PreloadResult", jSONObjectA, jSONObjectA2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitTriverComponent(TriverLaunchPointer triverLaunchPointer, String str, String str2) {
        try {
            JSONObject jSONObjectA = a(triverLaunchPointer);
            jSONObjectA.put("componentName", (Object) str);
            jSONObjectA.put("componentInfo", (Object) str2);
            trackStat(TriverLogProxyImpl.TLOG_MODULE, "Component", jSONObjectA, new JSONObject());
        } catch (Throwable th) {
            RVLogger.w(f24990a, th.getMessage());
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitTriverDownLoadResource(AppModel appModel, String str, String str2, boolean z, boolean z2, boolean z3) {
        try {
            JSONObject jSONObjectA = a(appModel);
            jSONObjectA.put("zCacheKey", (Object) str);
            jSONObjectA.put("zCacheInfo", (Object) str2);
            jSONObjectA.put("isPlugin", (Object) Boolean.valueOf(z));
            if (z2) {
                jSONObjectA.put("source", "zCache");
            } else {
                jSONObjectA.put("source", "http");
            }
            JSONObject jSONObject = new JSONObject();
            if (z3) {
                jSONObject.put("successCount", (Object) 1);
                jSONObject.put("failedCount", (Object) 0);
            } else {
                jSONObject.put("successCount", (Object) 0);
                jSONObject.put("failedCount", (Object) 1);
            }
            trackStat(TriverLogProxyImpl.TLOG_MODULE, "Resource", jSONObjectA, jSONObject);
        } catch (Throwable th) {
            RVLogger.w(f24990a, th.getMessage());
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitTriverJSAPI(TriverLaunchPointer triverLaunchPointer, String str, Double d, String str2) {
        try {
            JSONObject jSONObjectA = a(triverLaunchPointer);
            jSONObjectA.put("apiName", (Object) str);
            jSONObjectA.put("error", (Object) d);
            jSONObjectA.put(SendToNativeCallback.KEY_MESSAGE, (Object) str2);
            try {
                jSONObjectA.put("pluginId", triverLaunchPointer.extra.get("pluginId"));
                jSONObjectA.put("pluginVersion", triverLaunchPointer.extra.get("pluginVersion"));
            } catch (Exception e) {
                Log.e(f24990a, "commitTriverJSAPI getPluginId error", e);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", (Object) triverLaunchPointer.status);
            trackStat(TriverLogProxyImpl.TLOG_MODULE, "API", jSONObjectA, jSONObject);
        } catch (Throwable th) {
            RVLogger.w(f24990a, th.getMessage());
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitTriverLaunch(TriverLaunchPointer triverLaunchPointer) {
        try {
            trackStat(TriverLogProxyImpl.TLOG_MODULE, "Launch", a(triverLaunchPointer, null, null, null), a(triverLaunchPointer, AudioStats.AUDIO_AMPLITUDE_NONE));
        } catch (Throwable th) {
            RVLogger.w(f24990a, th.getMessage());
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitTriverPageLaunch(TriverLaunchPointer triverLaunchPointer) {
        try {
            JSONObject jSONObjectA = a(triverLaunchPointer, null, null, null);
            try {
                jSONObjectA.put("pluginId", triverLaunchPointer.extra.get("pluginId"));
                jSONObjectA.put("pluginVersion", triverLaunchPointer.extra.get("pluginVersion"));
            } catch (Exception e) {
                Log.e(f24990a, "commitTriverJSAPI getPluginId error", e);
            }
            trackStat(TriverLogProxyImpl.TLOG_MODULE, "PageLaunch", jSONObjectA, a(triverLaunchPointer, AudioStats.AUDIO_AMPLITUDE_NONE));
        } catch (Throwable th) {
            RVLogger.w(f24990a, th.getMessage());
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitTriverPerf(TriverLaunchPointer triverLaunchPointer) {
        try {
            trackStat(TriverLogProxyImpl.TLOG_MODULE, "Launch", a(triverLaunchPointer, null, null, null), a(triverLaunchPointer, AudioStats.AUDIO_AMPLITUDE_NONE));
        } catch (Throwable th) {
            RVLogger.w(f24990a, th.getMessage());
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitTriverPluginResourceCache(PluginModel pluginModel, String str, String str2, boolean z, boolean z2, boolean z3) {
        try {
            JSONObject jSONObjectA = a(pluginModel);
            jSONObjectA.put("zCacheKey", (Object) str);
            jSONObjectA.put("zCacheInfo", (Object) str2);
            jSONObjectA.put("isPlugin", (Object) Boolean.valueOf(z));
            if (z2) {
                jSONObjectA.put("source", "zCache");
            } else {
                jSONObjectA.put("source", "http");
            }
            JSONObject jSONObject = new JSONObject();
            if (z3) {
                jSONObject.put("successCount", (Object) 1);
                jSONObject.put("failedCount", (Object) 0);
            } else {
                jSONObject.put("successCount", (Object) 0);
                jSONObject.put("failedCount", (Object) 1);
            }
            trackStat(TriverLogProxyImpl.TLOG_MODULE, "ResourceCache", jSONObjectA, jSONObject);
        } catch (Throwable th) {
            RVLogger.w(f24990a, th.getMessage());
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitTriverResourceCache(AppModel appModel, String str, String str2, boolean z, boolean z2, boolean z3) {
        try {
            JSONObject jSONObjectA = a(appModel);
            jSONObjectA.put("zCacheKey", (Object) str);
            jSONObjectA.put("zCacheInfo", (Object) str2);
            jSONObjectA.put("isPlugin", (Object) Boolean.valueOf(z));
            if (z2) {
                jSONObjectA.put("source", "zCache");
            } else {
                jSONObjectA.put("source", "http");
            }
            JSONObject jSONObject = new JSONObject();
            if (z3) {
                jSONObject.put("successCount", (Object) 1);
                jSONObject.put("failedCount", (Object) 0);
            } else {
                jSONObject.put("successCount", (Object) 0);
                jSONObject.put("failedCount", (Object) 1);
            }
            trackStat(TriverLogProxyImpl.TLOG_MODULE, "ResourceCache", jSONObjectA, jSONObject);
        } catch (Throwable th) {
            RVLogger.w(f24990a, th.getMessage());
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitTriverShopPerf(TriverLaunchPointer triverLaunchPointer, String str, String str2, String str3, double d) {
        try {
            JSONObject jSONObjectA = a(triverLaunchPointer, str, str2, str3);
            jSONObjectA.put("tabKey", (Object) str);
            jSONObjectA.put("renderType", (Object) str2);
            JSONObject jSONObjectA2 = a(triverLaunchPointer, AudioStats.AUDIO_AMPLITUDE_NONE);
            jSONObjectA2.put("shopPageRenderTime", (Object) Double.valueOf(d));
            trackStat(TriverLogProxyImpl.TLOG_MODULE, "ShopPerformance", jSONObjectA, jSONObjectA2);
        } catch (Throwable th) {
            RVLogger.w(f24990a, th.getMessage());
        }
    }

    @Override // com.alibaba.ariver.mtop.monitor.TRVMonitor, com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void trackAlarm(boolean z, String str, String str2, String str3, String str4, String str5) {
        try {
            if (z) {
                AppMonitor.Alarm.commitSuccess(str, str2, str5);
            } else {
                AppMonitor.Alarm.commitFail(str, str2, str5, str3, str4);
            }
            if (CommonUtils.isApkDebug()) {
                RVLogger.d(d.f25020a, "AppMonitor.trackAlarm ----module:" + str + ", success: " + z + ", monitorPoint:" + str2 + ", errorCode:" + str3 + ",errorMsg:" + str4 + ",args:" + str5);
            }
        } catch (Throwable th) {
            RVLogger.e(f24990a, th);
        }
    }

    @Override // com.alibaba.ariver.mtop.monitor.TRVMonitor, com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void trackCounter(String str, String str2, int i, String str3) {
        try {
            AppMonitor.Counter.commit(str, str2, str3, i);
        } catch (Throwable th) {
            RVLogger.e(f24990a, th);
        }
    }

    @Override // com.alibaba.ariver.mtop.monitor.TRVMonitor, com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void trackStat(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                if (jSONObject.size() >= 1 && jSONObject2 != null) {
                    DimensionSet dimensionSetCreate = DimensionSet.create();
                    DimensionValueSet dimensionValueSetCreate = DimensionValueSet.create();
                    for (String str3 : jSONObject.keySet()) {
                        dimensionSetCreate.addDimension(new Dimension(str3));
                        dimensionValueSetCreate.setValue(str3, jSONObject.getString(str3));
                    }
                    MeasureSet measureSetCreate = MeasureSet.create();
                    MeasureValueSet measureValueSetCreate = MeasureValueSet.create();
                    for (String str4 : jSONObject2.keySet()) {
                        measureSetCreate.addMeasure(new Measure(str4));
                        measureValueSetCreate.setValue(str4, jSONObject2.getDoubleValue(str4));
                    }
                    AppMonitor.register(str, str2, measureSetCreate, dimensionSetCreate, true);
                    AppMonitor.Stat.commit(str, str2, dimensionValueSetCreate, measureValueSetCreate);
                    RVLogger.d(d.f25020a, "AppMonitor.trackStat---- module:" + str + ", monitorPoint:" + str2 + ", dim:" + jSONObject.toString() + ",measure:" + jSONObject2.toString());
                }
            } catch (Throwable th) {
                RVLogger.e(f24990a, th);
            }
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitTriverLaunch(TriverLaunchPointer triverLaunchPointer, String str) {
        try {
            JSONObject jSONObjectA = a(triverLaunchPointer, str, null, null);
            jSONObjectA.put("tabKey", (Object) TRiverUrlUtils.getShopTabKey(str));
            trackStat(TriverLogProxyImpl.TLOG_MODULE, "Launch", jSONObjectA, a(triverLaunchPointer, AudioStats.AUDIO_AMPLITUDE_NONE));
        } catch (Throwable th) {
            RVLogger.w(f24990a, th.getMessage());
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void commitTriverPerf(TriverLaunchPointer triverLaunchPointer, double d) {
        try {
            trackStat(TriverLogProxyImpl.TLOG_MODULE, "Launch", a(triverLaunchPointer, null, null, null), a(triverLaunchPointer, d));
        } catch (Throwable th) {
            RVLogger.w(f24990a, th.getMessage());
        }
    }

    private void a(TriverLaunchPointer triverLaunchPointer, JSONObject jSONObject) {
        HashMap map;
        if (jSONObject == null || (map = triverLaunchPointer.extra) == null) {
            return;
        }
        if (map.containsKey(TriverAppMonitorConstants.KEY_START_MEM)) {
            jSONObject.put(TriverAppMonitorConstants.KEY_START_MEM, triverLaunchPointer.extra.get(TriverAppMonitorConstants.KEY_START_MEM));
        }
        if (triverLaunchPointer.extra.containsKey(TriverAppMonitorConstants.KEY_HIGH_MEM)) {
            jSONObject.put(TriverAppMonitorConstants.KEY_HIGH_MEM, triverLaunchPointer.extra.get(TriverAppMonitorConstants.KEY_HIGH_MEM));
        }
    }

    private JSONObject a(TriverLaunchPointer triverLaunchPointer, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("miniAppId", triverLaunchPointer.appId);
        jSONObject.put("bucketId", Integer.valueOf(TROrangeController.bucketId));
        jSONObject.put("miniAppPage", triverLaunchPointer.page);
        jSONObject.put("errorCode", triverLaunchPointer.errorCode);
        jSONObject.put("errorMsg", triverLaunchPointer.errorMsg);
        jSONObject.put("isFirstPage", triverLaunchPointer.isFirstPage);
        jSONObject.put("bizType", (Object) null);
        jSONObject.put(TRiverConstants.KEY_SUB_BIZ_TYPE, (Object) null);
        jSONObject.put("tabKey", (Object) str);
        HashMap map = triverLaunchPointer.extra;
        if (map != null && map.containsKey(TriverAppMonitorConstants.KEY_AB_WORKER_TEST)) {
            jSONObject.put(TriverAppMonitorConstants.KEY_AB_WORKER_TEST, triverLaunchPointer.extra.get(TriverAppMonitorConstants.KEY_AB_WORKER_TEST));
        }
        HashMap map2 = triverLaunchPointer.extra;
        if (map2 != null && map2.containsKey(TriverAppMonitorConstants.KEY_STAGE_PROCESS_MODEL)) {
            jSONObject.put(TriverAppMonitorConstants.KEY_STAGE_PROCESS_MODEL, triverLaunchPointer.extra.get(TriverAppMonitorConstants.KEY_STAGE_PROCESS_MODEL).toString());
        } else {
            jSONObject.put(TriverAppMonitorConstants.KEY_STAGE_PROCESS_MODEL, TriverAppMonitorConstants.KEY_STAGE_SUB_PROCESS_PRELOAD_MISS);
        }
        if (!TextUtils.isEmpty(str3) && TRiverUrlUtils.isShop(str3)) {
            if (str3.indexOf("pages/index_v2/index_v2") > 0) {
                jSONObject.put("shopVersion", "4.0");
            } else {
                jSONObject.put("shopVersion", "3.0");
            }
        }
        HashMap map3 = triverLaunchPointer.extra;
        if (map3 != null && map3.containsKey(TRiverConstants.KEY_OPEN_MODEL)) {
            jSONObject.put(TRiverConstants.KEY_OPEN_MODEL, triverLaunchPointer.extra.get(TRiverConstants.KEY_OPEN_MODEL).toString());
        } else {
            jSONObject.put(TRiverConstants.KEY_OPEN_MODEL, TRiverConstants.KEY_NORMAL_LINK);
        }
        if (Triver.currentAppxModel != null) {
            jSONObject.put("appxVersion", Triver.currentAppxModel.getAppVersion());
        } else {
            jSONObject.put("appxVersion", (Object) null);
        }
        jSONObject.put("miniSdkVersion", com.alibaba.triver.inside.a.f);
        HashMap map4 = triverLaunchPointer.extra;
        if (map4 != null && map4.containsKey("monitorTime")) {
            jSONObject.put("monitorTime", triverLaunchPointer.extra.get("monitorTime"));
        } else {
            jSONObject.put("monitorTime", Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        }
        HashMap map5 = triverLaunchPointer.extra;
        if (map5 != null && map5.containsKey("currentStage")) {
            jSONObject.put("currentStage", triverLaunchPointer.extra.get("currentStage"));
        } else {
            jSONObject.put("currentStage", (Object) null);
        }
        HashMap map6 = triverLaunchPointer.extra;
        if (map6 != null && map6.containsKey("channelName")) {
            jSONObject.put("channelName", triverLaunchPointer.extra.get("channelName"));
        } else {
            jSONObject.put("channelName", (Object) null);
        }
        jSONObject.put(TriverAppMonitorConstants.KEY_STAGE_NEW_STAGE, triverLaunchPointer.newStage);
        a(jSONObject, (AppModel) null);
        String appVersion = triverLaunchPointer.version;
        String developerVersion = triverLaunchPointer.developerVersion;
        String templateId = triverLaunchPointer.templateId;
        String templateVersion = triverLaunchPointer.templateVersion;
        Page currentPage = AppLifecycleExtension.getCurrentPage();
        if (currentPage != null) {
            App app = currentPage.getApp();
            if (app != null) {
                jSONObject.put("tabKey", TRiverUrlUtils.getShopTabKey(app));
            }
            if (app != null && app.getSceneParams() != null) {
                AppModel appModel = (AppModel) app.getSceneParams().get("appInfo");
                if (appModel != null && appModel.getExtendInfos() != null && appModel.getExtendInfos().containsKey("bizType") && appModel.getExtendInfos().containsKey(TRiverConstants.KEY_SUB_BIZ_TYPE)) {
                    jSONObject.put("bizType", appModel.getExtendInfos().getInteger("bizType").toString());
                    jSONObject.put(TRiverConstants.KEY_SUB_BIZ_TYPE, appModel.getExtendInfos().getInteger(TRiverConstants.KEY_SUB_BIZ_TYPE).toString());
                }
                Bundle startParams = app.getStartParams();
                if (startParams != null && startParams.containsKey(TRiverConstants.KEY_ENABLE_SKIA)) {
                    jSONObject.put(TRiverConstants.KEY_ENABLE_SKIA, "1");
                } else {
                    jSONObject.put(TRiverConstants.KEY_ENABLE_SKIA, "0");
                }
                a(jSONObject, appModel);
                if (appModel != null && TextUtils.isEmpty(appVersion)) {
                    appVersion = appModel.getAppVersion();
                }
                if (appModel != null && TextUtils.isEmpty(developerVersion) && appModel.getAppInfoModel() != null) {
                    developerVersion = appModel.getAppInfoModel().getDeveloperVersion();
                }
                if (appModel != null && TextUtils.isEmpty(templateId) && appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getTemplateConfig() != null) {
                    templateId = appModel.getAppInfoModel().getTemplateConfig().getTemplateId();
                }
                if (appModel != null && TextUtils.isEmpty(templateVersion) && appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getTemplateConfig() != null) {
                    templateVersion = appModel.getAppInfoModel().getTemplateConfig().getTemplateVersion();
                }
            }
        }
        jSONObject.put("deployVersion", (Object) appVersion);
        jSONObject.put("developVersion", (Object) developerVersion);
        jSONObject.put("templateId", (Object) templateId);
        jSONObject.put("templateVersion", (Object) templateVersion);
        jSONObject.put("stage", triverLaunchPointer.stage);
        jSONObject.put("renderType", (Object) str2);
        jSONObject.put("url", (Object) str3);
        return jSONObject;
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy
    public void trackStat(String str, TriverLaunchPointer triverLaunchPointer) {
        try {
            JSONObject jSONObjectA = a(triverLaunchPointer, null, null, null);
            HashMap map = triverLaunchPointer.extra;
            if (map != null && map.containsKey("pluginId")) {
                jSONObjectA.put("pluginId", (Object) triverLaunchPointer.extra.get("pluginId").toString());
            } else {
                jSONObjectA.put("pluginId", (Object) null);
            }
            trackStat(TriverLogProxyImpl.TLOG_MODULE, str, jSONObjectA, a(triverLaunchPointer, AudioStats.AUDIO_AMPLITUDE_NONE));
        } catch (Throwable th) {
            RVLogger.w(f24990a, th.getMessage());
        }
    }

    private JSONObject a(TriverLaunchPointer triverLaunchPointer) {
        App app;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("miniAppId", triverLaunchPointer.appId);
        jSONObject.put("miniAppPage", triverLaunchPointer.page);
        jSONObject.put("errorCode", triverLaunchPointer.errorCode);
        jSONObject.put("errorMsg", triverLaunchPointer.errorMsg);
        jSONObject.put("isFirstPage", triverLaunchPointer.isFirstPage);
        jSONObject.put("bizType", (Object) null);
        jSONObject.put(TRiverConstants.KEY_SUB_BIZ_TYPE, (Object) null);
        if (Triver.currentAppxModel != null) {
            jSONObject.put("appxVersion", Triver.currentAppxModel.getAppVersion());
        } else {
            jSONObject.put("appxVersion", (Object) null);
        }
        jSONObject.put("miniSdkVersion", com.alibaba.triver.inside.a.f);
        HashMap map = triverLaunchPointer.extra;
        if (map != null && map.containsKey("monitorTime")) {
            jSONObject.put("monitorTime", triverLaunchPointer.extra.get("monitorTime"));
        } else {
            jSONObject.put("monitorTime", Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        }
        HashMap map2 = triverLaunchPointer.extra;
        if (map2 != null && map2.containsKey("currentStage")) {
            jSONObject.put("currentStage", triverLaunchPointer.extra.get("currentStage"));
        } else {
            jSONObject.put("currentStage", (Object) null);
        }
        HashMap map3 = triverLaunchPointer.extra;
        if (map3 != null && map3.containsKey(xh9.WEBSITE_PARAMS_CHANNEL)) {
            jSONObject.put(xh9.WEBSITE_PARAMS_CHANNEL, triverLaunchPointer.extra.get(xh9.WEBSITE_PARAMS_CHANNEL));
        } else {
            jSONObject.put(xh9.WEBSITE_PARAMS_CHANNEL, (Object) null);
        }
        jSONObject.put(TriverAppMonitorConstants.KEY_STAGE_NEW_STAGE, triverLaunchPointer.newStage);
        a(jSONObject, (AppModel) null);
        String appVersion = triverLaunchPointer.version;
        String developerVersion = triverLaunchPointer.developerVersion;
        String templateId = triverLaunchPointer.templateId;
        String templateVersion = triverLaunchPointer.templateVersion;
        Page currentPage = AppLifecycleExtension.getCurrentPage();
        if (currentPage != null && (app = currentPage.getApp()) != null && app.getSceneParams() != null) {
            AppModel appModel = (AppModel) app.getSceneParams().get("appInfo");
            if (appModel != null && appModel.getExtendInfos() != null) {
                Object string = appModel.getExtendInfos().getString("bizType");
                Object string2 = appModel.getExtendInfos().getString(TRiverConstants.KEY_SUB_BIZ_TYPE);
                if (string != null) {
                    jSONObject.put("bizType", string);
                }
                if (string2 != null) {
                    jSONObject.put(TRiverConstants.KEY_SUB_BIZ_TYPE, string2);
                }
            }
            a(jSONObject, appModel);
            if (TextUtils.isEmpty(appVersion)) {
                appVersion = appModel.getAppVersion();
            }
            if (TextUtils.isEmpty(developerVersion) && appModel.getAppInfoModel() != null) {
                developerVersion = appModel.getAppInfoModel().getDeveloperVersion();
            }
            if (TextUtils.isEmpty(templateId) && appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getTemplateConfig() != null) {
                templateId = appModel.getAppInfoModel().getTemplateConfig().getTemplateId();
            }
            if (TextUtils.isEmpty(templateVersion) && appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getTemplateConfig() != null) {
                templateVersion = appModel.getAppInfoModel().getTemplateConfig().getTemplateVersion();
            }
        }
        jSONObject.put("deployVersion", (Object) appVersion);
        jSONObject.put("developVersion", (Object) developerVersion);
        jSONObject.put("templateId", (Object) templateId);
        jSONObject.put("templateVersion", (Object) templateVersion);
        return jSONObject;
    }

    private void a(JSONObject jSONObject, AppModel appModel) {
        if (appModel != null && appModel.getPermissionModel() != null) {
            jSONObject.put("needPermission", (Object) 1);
        } else {
            jSONObject.put("needPermission", (Object) 0);
        }
    }

    private JSONObject a(AppModel appModel) {
        if (appModel == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        AppInfoModel appInfoModel = appModel.getAppInfoModel();
        jSONObject.put("miniAppId", (Object) appInfoModel.getAppId());
        jSONObject.put("deployVersion", (Object) appInfoModel.getVersion());
        jSONObject.put("developVersion", (Object) appInfoModel.getDeveloperVersion());
        if (appInfoModel.getTemplateConfig() != null) {
            jSONObject.put("templateId", (Object) appInfoModel.getTemplateConfig().getTemplateId());
        }
        a(jSONObject, appModel);
        return jSONObject;
    }

    private JSONObject a(PluginModel pluginModel) {
        if (pluginModel == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("miniAppId", (Object) pluginModel.getAppId());
        jSONObject.put("deployVersion", (Object) pluginModel.getVersion());
        jSONObject.put("developVersion", (Object) pluginModel.getDeveloperVersion());
        return jSONObject;
    }
}
