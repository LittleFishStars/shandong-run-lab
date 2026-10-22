package com.alibaba.triver.extensions;

import android.os.Bundle;
import android.os.Parcelable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppLoadResult;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.api.snapshot.RVSnapshotUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.Triver;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.kit.api.proxy.ITriverToolsProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.point.CrashInfoPoint;
import com.alibaba.triver.point.OnPreloadPoint;
import com.alibaba.triver.resource.AppPrepareChecker;
import com.alibaba.triver.trace.b;
import com.alibaba.triver.trace.c;
import com.alibaba.triver.utils.d;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.ut.device.UTDevice;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverOnLoadResultExtension implements AppOnLoadResultPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24958a = "TriverOnLoadResultExten";

    private void a(App app) {
        try {
            Bundle startParams = app.getStartParams();
            if (startParams != null) {
                String string = startParams.getString(TRiverConstants.KEY_PRE_PAGE_NAME);
                if (string != null) {
                    ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(app, TRiverConstants.KEY_PRE_PAGE_NAME, string);
                }
                String string2 = startParams.getString(TRiverConstants.KEY_SPM_ORIGIN_URL);
                if (string2 != null) {
                    ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(app, "spmUri", string2);
                }
            }
        } catch (Exception e) {
            RVLogger.e(f24958a, "addAppInfoPerfToLaunchModel: ", e);
        }
    }

    private void b(App app) {
        try {
            AppModel appModel = Triver.currentAppxModel;
            if (appModel != null) {
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(app, TRiverConstants.KEY_MONITOR_APPX_DEVELOPER_VERSION, String.valueOf(appModel.getAppInfoModel().getDeveloperVersion()));
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(app, "appxVersion", String.valueOf(appModel.getAppInfoModel().getVersion()));
                if (appModel.getExtendInfos() == null || !appModel.getExtendInfos().containsKey("grey")) {
                    return;
                }
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(app, TRiverConstants.KEY_MONITOR_APPX_GREY_PACKAGE, String.valueOf(appModel.getExtendInfos().getString("grey")));
            }
        } catch (Exception e) {
            RVLogger.e(f24958a, "addAppxVersionToLaunchModel", e);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint
    public void onLoadResult(App app, AppLoadResult appLoadResult) {
        String str;
        JSONObject jSONObject;
        Bundle bundle;
        HashMap map = new HashMap();
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        app.getStartParams().putString("hostAppName", ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("appName"));
        if (appModel != null) {
            if (appModel.getAppInfoModel() != null) {
                app.getStartParams().putString("developerVersion", appModel.getAppInfoModel().getDeveloperVersion());
            }
            if (appModel.getExtendInfos() != null && (jSONObject = appModel.getExtendInfos().getJSONObject("customLaunchParams")) != null && (bundle = JSONUtils.toBundle(jSONObject)) != null) {
                app.getStartParams().putAll(bundle);
            }
        }
        if (appModel != null) {
            CrashInfoPoint crashInfoPoint = (CrashInfoPoint) ExtensionPoint.as(CrashInfoPoint.class).create();
            crashInfoPoint.setMiniVersion(appModel.getAppVersion());
            map.put("appId", appModel.getAppId());
            map.put("appVersion", appModel.getAppVersion());
            if (appModel.getAppInfoModel() != null) {
                map.put("developVersion", appModel.getAppInfoModel().getDeveloperVersion());
                map.put("appKey", appModel.getAppInfoModel().getAppKey());
            }
            if (appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getTemplateConfig() != null) {
                crashInfoPoint.setTemplateId(appModel.getAppInfoModel().getTemplateConfig().getTemplateId());
                map.put("templateId", appModel.getAppInfoModel().getTemplateConfig().getTemplateId());
            }
        }
        a(app, map);
        a(app, appModel);
        b(app);
        a(app);
        if (map.containsKey("templateId") && (str = (String) map.get("templateId")) != null) {
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(app, "templateId", str);
        }
        app.getStartParams().putString(RVStartParams.KEY_ENABLE_API_CLIENT_CACHE_SYSTEMINFO, "YES");
        if (TROrangeController.hasGpuAccelerate(app.getStartParams())) {
            RVLogger.d(f24958a, "has native");
            app.getStartParams().putString("hasNativeCanvas", "hasNative");
            app.getStartParams().putString("nativeCanvasCompactProtocol", "true");
            if (TROrangeController.isUseBatchMode(app)) {
                app.getStartParams().putString("nativeCanvasUseCommandBuffer", "true");
            } else {
                app.getStartParams().putString("nativeCanvasUseCommandBuffer", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
            }
        }
        if (RVSnapshotUtils.isSnapshotEnabled(app)) {
            app.getStartParams().putBoolean(RVStartParams.KEY_SNAPSHOT_ENABLED, true);
        } else {
            app.getStartParams().putBoolean(RVStartParams.KEY_SNAPSHOT_ENABLED, false);
        }
        app.getStartParams().putBoolean("isAutoSnapshot", false);
        try {
            app.getStartParams().putString("appxUtdid", UTDevice.getUtdid(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TROrangeController.useNativeInput(app)) {
            app.getStartParams().putString("enableNativeInput", "YES");
        }
        app.getStartParams().putString("inPageRenderType", "map|video|canvas|ALL");
        if (((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).isToolsOpen()) {
            map.put("allInfo", appModel.toString());
            a(app, map, appModel);
        }
        ((OnPreloadPoint) ExtensionPoint.as(OnPreloadPoint.class).create()).createAppContext(app);
        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(c.L, null, "AppInfo", app.getAppId(), null, map);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putAll(map);
        b.a(c.e, c.L, TRiverUtils.getSessionId(app), app, jSONObject2);
    }

    private void a(App app, Map<String, Object> map) {
        Parcelable parcelable;
        try {
            Bundle sceneParams = app.getSceneParams();
            if (sceneParams == null || (parcelable = sceneParams.getParcelable(TRiverConstants.KEY_APP_INFO_PERFORMANCE)) == null) {
                return;
            }
            AppPrepareChecker.AppPerformance appPerformance = (AppPrepareChecker.AppPerformance) parcelable;
            map.put("appInfoStrategy", appPerformance.d);
            map.put("appxStrategy", appPerformance.e);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(app, TriverAppMonitorConstants.KEY_STAGE_APP_INFO_START, appPerformance.f25143a);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(app, "appInfoStartStub", System.currentTimeMillis());
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(app, "appInfoEnd", appPerformance.b);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(app, "resourceReady", appPerformance.c);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(app, "appInfoStrategy", String.valueOf(appPerformance.d));
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(app, "appxStrategy", String.valueOf(appPerformance.e));
        } catch (Exception e) {
            RVLogger.e(f24958a, "addAppInfoPerfToLaunchModel: ", e);
        }
    }

    private void a(final App app, final AppModel appModel) {
        if (appModel != null) {
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(app, "appVersion", String.valueOf(appModel.getAppInfoModel().getVersion()));
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(app, TRiverConstants.KEY_MONITOR_APP_DEVELOPER_VERSION, String.valueOf(appModel.getAppInfoModel().getDeveloperVersion()));
            if (appModel.getExtendInfos() != null && appModel.getExtendInfos().containsKey("grey")) {
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(app, TRiverConstants.KEY_MONITOR_APP_GREY_PACKAGE, String.valueOf(appModel.getExtendInfos().getString("grey")));
            }
        }
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.triver.extensions.TriverOnLoadResultExtension.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                try {
                    String str = FileUtils.read(FileUtils.combinePath(((RVResourceManager) RVProxy.get(RVResourceManager.class)).getInstallPath(appModel), "Manifest.xml"));
                    if (str == null || !str.contains("<appVersion>")) {
                        return;
                    }
                    ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(app, TRiverConstants.KEY_MONITOR_PACKAGE_DEVELOPER_VERSION, str.substring(str.indexOf("<appVersion>") + 12, str.indexOf("</appVersion>")));
                } catch (Exception e) {
                    RVLogger.e(TriverOnLoadResultExtension.f24958a, "addAppVersionToLaunchModel: ", e);
                }
            }
        });
    }

    private void a(final App app, final Map<String, Object> map, final AppModel appModel) {
        try {
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.triver.extensions.TriverOnLoadResultExtension.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HashMap map2 = new HashMap();
                        map2.put("appId", appModel.getAppId());
                        map2.put("appName", appModel.getAppInfoModel().getName());
                        map2.put("appDesc", appModel.getAppInfoModel().getDesc());
                        map2.put("appVersion", appModel.getAppInfoModel().getVersion());
                        map2.put(TRiverConstants.KEY_MONITOR_APP_DEVELOPER_VERSION, appModel.getAppInfoModel().getDeveloperVersion());
                        map2.put("appInfoStrategy", (String) map.get("appInfoStrategy"));
                        map2.put("appxStrategy", (String) map.get("appxStrategy"));
                        if (appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getTemplateConfig() != null) {
                            map2.put("templateId", appModel.getAppInfoModel().getTemplateConfig().getTemplateId());
                        }
                        if (appModel.getExtendInfos() != null && appModel.getExtendInfos().containsKey("bizType")) {
                            map2.put("bizType", appModel.getExtendInfos().getInteger("bizType").toString());
                        }
                        if (appModel.getExtendInfos() != null && appModel.getExtendInfos().containsKey(TRiverConstants.KEY_SUB_BIZ_TYPE)) {
                            map2.put(TRiverConstants.KEY_SUB_BIZ_TYPE, appModel.getExtendInfos().getInteger(TRiverConstants.KEY_SUB_BIZ_TYPE).toString());
                        }
                        if (appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getPlugins() != null) {
                            StringBuilder sb = new StringBuilder();
                            for (PluginModel pluginModel : appModel.getAppInfoModel().getPlugins()) {
                                sb.append("pluginId = ");
                                sb.append(pluginModel.getAppId());
                                sb.append("\n");
                                sb.append("pluginVersion = ");
                                sb.append(pluginModel.getDeveloperVersion());
                                sb.append("\n");
                            }
                            map2.put("pluginInfo", sb.toString());
                        }
                        HashMap<String, JSONObject> mapA = d.a(appModel);
                        if (mapA.size() != 0) {
                            map2.put("zCachePackageName", mapA.keySet().iterator().next());
                        }
                        String str = FileUtils.read(FileUtils.combinePath(((RVResourceManager) RVProxy.get(RVResourceManager.class)).getInstallPath(appModel), "Manifest.xml"));
                        if (str != null && str.contains("<appVersion>")) {
                            map2.put("packageVersion", str.substring(str.indexOf("<appVersion>") + 12, str.indexOf("</appVersion>")));
                        }
                        ((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).saveAnalyzerToolsAppInfo(app.getAppContext().getContext(), map2);
                    } catch (Throwable th) {
                        RVLogger.w(TriverOnLoadResultExtension.f24958a, th.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            RVLogger.w(f24958a, e.getMessage());
        }
    }
}
