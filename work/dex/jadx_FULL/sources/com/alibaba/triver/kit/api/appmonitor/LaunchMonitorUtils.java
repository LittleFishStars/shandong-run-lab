package com.alibaba.triver.kit.api.appmonitor;

import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.point.FirstScreenLoadedPoint;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.b;
import com.ipd.dsp.internal.i.q;
import com.zj.adlib.c49;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LaunchMonitorUtils {
    public static final String CUSTOM_MONITOR_KEY = "triverOpenAppCustomLaunchInfoKey";
    public static final String KEY_APP_MAIN_MONITOR_DATA = "appMainMonitorData";
    public static final String KEY_APP_MONITOR_DATA_REPORT_FINISH = "monitorDataReportFinish";
    private static final String TAG = "LaunchMonitor";

    private static void addCustomMonitorStat(LaunchMonitorData launchMonitorData, Bundle bundle) {
        if (bundle != null) {
            try {
                HashMap map = (HashMap) bundle.getSerializable(CUSTOM_MONITOR_KEY);
                if (map != null) {
                    for (String str : map.keySet()) {
                        launchMonitorData.addPoint(str, (Long) map.get(str));
                    }
                }
            } catch (Exception e) {
                RVLogger.e("LaunchMonitor addCustomMonitorKey", e);
            }
        }
    }

    public static boolean canReportOnPause(App app) {
        LaunchMonitorData mergedMonitorData = getMergedMonitorData(app);
        if (mergedMonitorData == null) {
            return false;
        }
        try {
            if (mergedMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_PAGE_LOADED)) {
                return true;
            }
            String str = mergedMonitorData.get("appStart");
            if (!TextUtils.isEmpty(str)) {
                return System.currentTimeMillis() - Long.parseLong(str) >= ((long) (TROrangeController.whiteScreenTime() + 2000));
            }
            String str2 = mergedMonitorData.get(TriverAppMonitorConstants.KEY_STAGE_CONTAINER_FINISH);
            if (!TextUtils.isEmpty(str2)) {
                return System.currentTimeMillis() - Long.parseLong(str2) >= ((long) (TROrangeController.whiteScreenTime() + 2000));
            }
            return false;
        } catch (Exception e) {
            RVLogger.e(TAG, "canReportOnPause error", e);
        }
    }

    public static boolean canReportPageOnPause(Page page) {
        LaunchMonitorData pageMonitorData = getPageMonitorData(page);
        if (pageMonitorData == null) {
            return false;
        }
        try {
            if (pageMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_PAGE_LOADED)) {
                return true;
            }
            String str = pageMonitorData.get("pageStart");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return System.currentTimeMillis() - Long.parseLong(str) >= ((long) (TROrangeController.whiteScreenTime() + 2000));
        } catch (Exception e) {
            RVLogger.e(TAG, "canReportPageOnPause error", e);
            return false;
        }
    }

    public static void commitApmCanvas(String str, String str2, AppInfoModel appInfoModel, String str3) {
        if (appInfoModel != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("miniAppKey", (Object) appInfoModel.getAppKey());
            jSONObject.put("deployVersion", (Object) appInfoModel.getVersion());
            jSONObject.put("developVersion", (Object) appInfoModel.getDeveloperVersion());
            jSONObject.put("miniappName", (Object) appInfoModel.getName());
            jSONObject.put("componentName", (Object) b.f25229a);
            jSONObject.put("miniAppId", (Object) appInfoModel.getAppId());
            jSONObject.put("canvasType", (Object) str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "canvas2d";
            }
            jSONObject.put("contextType", (Object) str2);
            jSONObject.put("miniappURL", (Object) str3);
            try {
                jSONObject.put("os_version", (Object) Build.VERSION.RELEASE);
                jSONObject.put("os_arch", (Object) (Process.is64Bit() ? "64" : "32"));
            } catch (Throwable unused) {
            }
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackStat(TriverLogProxyImpl.TLOG_MODULE, "Canvas", jSONObject, new JSONObject());
        }
    }

    private static void commitMonitor(String str, App app, String str2, LaunchMonitorData launchMonitorData, Bundle bundle, Bundle bundle2) {
        TriverLaunchPointer triverLaunchPointerCreate;
        String str3;
        if (!launchMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_RENDER_HIT) && !launchMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_SNAPSHOT_HIT) && TextUtils.isEmpty(launchMonitorData.getErrorCode()) && TextUtils.isEmpty(launchMonitorData.getErrorMessage()) && !launchMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_PAGE_LOADED)) {
            String str4 = TRiverUrlUtils.isShop(app) ? "店铺" : "小程序";
            String str5 = !launchMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_LOAD_FINISH) ? "网络" : "非网络";
            if (getStartTime(launchMonitorData) > TROrangeController.whiteScreenTime()) {
                launchMonitorData.addPoint("whiteScreen");
                str3 = "白屏";
            } else {
                launchMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_USER_CANCEL);
                str3 = "跳失";
            }
            HashMap map = new HashMap();
            map.put("traceLog", com.alibaba.triver.trace.b.b());
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, str4 + c49.f40900a + str3 + c49.f40900a + str5, "页面白屏/跳失", new HashMap(), map);
        }
        if (!launchMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_SNAPSHOT_HIT) && TextUtils.isEmpty(launchMonitorData.getErrorCode()) && TextUtils.isEmpty(launchMonitorData.getErrorMessage()) && !launchMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_PAGE_LOADED)) {
            if (getStartTime(launchMonitorData) > TROrangeController.whiteScreenTime()) {
                launchMonitorData.addPoint(TriverAppMonitorConstants.KEY_WHITE_SCREEN_V2);
            } else {
                launchMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_USER_CANCEL_V2);
            }
        }
        addCustomMonitorStat(launchMonitorData, bundle);
        String string = launchMonitorData.toString();
        Map<String, String> memDetail = launchMonitorData.getMemDetail();
        RVLogger.d(TAG, "commoitLaunchMonitor:" + str + q.a.i + string);
        String string2 = (bundle == null || !bundle.containsKey(TRiverConstants.KEY_OPEN_MODEL)) ? TRiverConstants.KEY_NORMAL_LINK : bundle.getString(TRiverConstants.KEY_OPEN_MODEL);
        String string3 = (bundle2 == null || !bundle2.containsKey(TriverAppMonitorConstants.KEY_STAGE_PROCESS_MODEL)) ? TriverAppMonitorConstants.KEY_STAGE_SUB_PROCESS_PRELOAD_MISS : bundle2.getString(TriverAppMonitorConstants.KEY_STAGE_PROCESS_MODEL);
        if (launchMonitorData.getData().containsKey(TriverAppMonitorConstants.KEY_STAGE_USER_CANCEL)) {
            triverLaunchPointerCreate = TriverLaunchPointer.build().setAppId(str).setApp(app).setTemplateId(str2).setErrorCode(TriverAppMonitorConstants.KEY_STAGE_USER_CANCEL).setStage(TriverAppMonitorConstants.KEY_STAGE_NEW_STAGE).setErrorMsg(TriverAppMonitorConstants.KEY_STAGE_USER_CANCEL).setNewStage(string).setStartParams(bundle).setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).putExtra(TRiverConstants.KEY_OPEN_MODEL, string2).putExtra(TriverAppMonitorConstants.KEY_STAGE_PROCESS_MODEL, string3).setMemInfo(memDetail).create();
        } else {
            triverLaunchPointerCreate = TriverLaunchPointer.build().setAppId(str).setApp(app).setTemplateId(str2).setStage(TriverAppMonitorConstants.KEY_STAGE_NEW_STAGE).setErrorCode(launchMonitorData.getErrorCode()).setErrorMsg(launchMonitorData.getErrorMessage()).setNewStage(string).setStartParams(bundle).setStatus(Double.valueOf(TextUtils.isEmpty(launchMonitorData.getErrorCode()) && TextUtils.isEmpty(launchMonitorData.getErrorMessage()) ? 1.0d : 0.0d)).putExtra(TRiverConstants.KEY_OPEN_MODEL, string2).putExtra(TriverAppMonitorConstants.KEY_STAGE_PROCESS_MODEL, string3).setMemInfo(memDetail).create();
        }
        if (RVProxy.get(ITriverAppMonitorProxy.class) != null) {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(triverLaunchPointerCreate, TRiverUrlUtils.getUrl(bundle));
        }
        try {
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfV2(string);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (getStartTime(launchMonitorData) >= TROrangeController.whiteScreenTime() || launchMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_RENDER_HIT) || launchMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_SNAPSHOT_HIT)) {
            if (RVProxy.get(ITriverAppMonitorProxy.class) != null) {
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(true, TriverLogProxyImpl.TLOG_MODULE, "LauncherNew", null, null, string);
                return;
            }
            return;
        }
        if (launchMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_USER_CANCEL)) {
            String str6 = "lastStage_" + launchMonitorData.findLastStage(TriverAppMonitorConstants.KEY_STAGE_USER_CANCEL);
            if (RVProxy.get(ITriverAppMonitorProxy.class) != null) {
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(false, TriverLogProxyImpl.TLOG_MODULE, "LauncherNew", "ERROR_USER_CANCEL", str6, string);
                return;
            }
            return;
        }
        String str7 = "lastStage_" + launchMonitorData.findLastStage(null) + LoginConstants.UNDER_LINE + launchMonitorData.getErrorCode();
        String errorMessage = launchMonitorData.getErrorMessage();
        if (RVProxy.get(ITriverAppMonitorProxy.class) != null) {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(false, TriverLogProxyImpl.TLOG_MODULE, "LauncherNew", str7, errorMessage, string);
        }
    }

    public static void commitMonitorInMain(String str, Bundle bundle, Bundle bundle2) {
        if (bundle == null || bundle.getBoolean(KEY_APP_MONITOR_DATA_REPORT_FINISH, false)) {
            return;
        }
        String str2 = null;
        if (TextUtils.isEmpty(null) && TRiverUrlUtils.isShop(bundle2)) {
            str2 = "3000000002110464";
        }
        String str3 = str2;
        LaunchMonitorData launchMonitorData = (LaunchMonitorData) bundle.getParcelable(KEY_APP_MAIN_MONITOR_DATA);
        if (launchMonitorData == null) {
            return;
        }
        commitMonitor(str, null, str3, launchMonitorData, bundle2, bundle);
        bundle.putBoolean(KEY_APP_MONITOR_DATA_REPORT_FINISH, true);
    }

    public static void commitMonitorInSub(App app) {
        Bundle sceneParams;
        if (app == null || (sceneParams = app.getSceneParams()) == null) {
            return;
        }
        ((FirstScreenLoadedPoint) ExtensionPoint.as(FirstScreenLoadedPoint.class).node(app).create()).onScreenAppLoaded(app);
        if (sceneParams.getBoolean(KEY_APP_MONITOR_DATA_REPORT_FINISH, false)) {
            return;
        }
        String appId = app.getAppId();
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        String templateId = (appModel == null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getTemplateConfig() == null) ? null : appModel.getAppInfoModel().getTemplateConfig().getTemplateId();
        if (TextUtils.isEmpty(templateId) && TRiverUrlUtils.isShop(app)) {
            templateId = "3000000002110464";
        }
        String str = templateId;
        LaunchMonitorData mergedMonitorData = getMergedMonitorData(app);
        if (mergedMonitorData == null) {
            return;
        }
        try {
            commitMonitor(appId, app, str, mergedMonitorData, app.getStartParams(), sceneParams);
        } catch (Exception e) {
            RVLogger.e(TAG, "commitMonitor error", e);
        }
        sceneParams.putBoolean(KEY_APP_MONITOR_DATA_REPORT_FINISH, true);
    }

    public static void commitPageMonitor(Page page) {
        App app;
        if (page == null) {
            return;
        }
        boolean zOnScreenPageLoaded = ((FirstScreenLoadedPoint) ExtensionPoint.as(FirstScreenLoadedPoint.class).node(page).create()).onScreenPageLoaded(page);
        try {
            Bundle sceneParams = page.getSceneParams();
            if ((zOnScreenPageLoaded || sceneParams == null || !sceneParams.getBoolean(KEY_APP_MONITOR_DATA_REPORT_FINISH, false)) && (app = page.getApp()) != null) {
                String appId = app.getAppId();
                AppModel appModel = (AppModel) app.getData(AppModel.class);
                String templateId = (appModel == null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getTemplateConfig() == null) ? null : appModel.getAppInfoModel().getTemplateConfig().getTemplateId();
                LaunchMonitorData launchMonitorData = (LaunchMonitorData) page.getData(LaunchMonitorData.class);
                if (launchMonitorData == null) {
                    return;
                }
                if (zOnScreenPageLoaded) {
                    launchMonitorData.mergeAppend(getMergedMonitorData(app));
                    RVLogger.e("AriverPerformance", "上报的性能数据: " + launchMonitorData.toString());
                }
                commitPageMonitor(appId, page, page.getOriginalURI(), templateId, launchMonitorData);
                if (sceneParams != null) {
                    sceneParams.putBoolean(KEY_APP_MONITOR_DATA_REPORT_FINISH, true);
                }
            }
        } catch (Exception e) {
            RVLogger.e(TAG, "commitPageMonitor error", e);
        }
    }

    public static LaunchMonitorData getMainMonitorData(Bundle bundle) {
        if (bundle != null) {
            return (LaunchMonitorData) bundle.getParcelable(KEY_APP_MAIN_MONITOR_DATA);
        }
        return null;
    }

    public static LaunchMonitorData getMergedMonitorData(App app) {
        Bundle sceneParams;
        if (app == null || (sceneParams = app.getSceneParams()) == null) {
            return null;
        }
        try {
            LaunchMonitorData launchMonitorData = (LaunchMonitorData) app.getData(LaunchMonitorData.class);
            LaunchMonitorData launchMonitorData2 = (LaunchMonitorData) sceneParams.getParcelable(KEY_APP_MAIN_MONITOR_DATA);
            if (launchMonitorData2 == null) {
                return launchMonitorData;
            }
            if (launchMonitorData != null) {
                if (launchMonitorData2.containsKey(TriverAppMonitorConstants.KEY_STAGE_APP_INFO_FINISH)) {
                    launchMonitorData.remove(TriverAppMonitorConstants.KEY_STAGE_APP_INFO_FINISH);
                }
                if (launchMonitorData2.containsKey(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_REQUEST_START)) {
                    launchMonitorData.remove(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_REQUEST_START);
                }
            }
            launchMonitorData2.merge(launchMonitorData);
            return launchMonitorData2;
        } catch (Exception e) {
            RVLogger.e(TAG, "getMergedMonitorData error", e);
            return null;
        }
    }

    public static LaunchMonitorData getPageMonitorData(Page page) {
        if (page != null) {
            return (LaunchMonitorData) page.getData(LaunchMonitorData.class);
        }
        return null;
    }

    private static long getStartTime(LaunchMonitorData launchMonitorData) {
        try {
            long j = Long.parseLong(launchMonitorData.get("appStart"));
            if (j > 0) {
                return System.currentTimeMillis() - j;
            }
            return 0L;
        } catch (Exception e) {
            Log.e(TAG, "commitMonitorInSub error", e);
            return 0L;
        }
    }

    public static LaunchMonitorData getSubMonitorData(App app) {
        if (app != null) {
            return (LaunchMonitorData) app.getData(LaunchMonitorData.class);
        }
        return null;
    }

    public static LaunchMonitorData getSubMonitorData(Page page) {
        if (page == null || page.getApp() == null) {
            return null;
        }
        return (LaunchMonitorData) page.getApp().getData(LaunchMonitorData.class);
    }

    private static void commitPageMonitor(String str, Page page, String str2, String str3, LaunchMonitorData launchMonitorData) {
        long j;
        String pluginIdFromPageUrl;
        String pluginVersion;
        TriverLaunchPointer triverLaunchPointerCreate;
        if (launchMonitorData == null) {
            return;
        }
        try {
            j = Long.parseLong(launchMonitorData.get("pageStart"));
        } catch (Exception e) {
            Log.e(TAG, "commitMonitorInSub error", e);
            j = -1;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (!launchMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_PAGE_LOADED)) {
            if (jCurrentTimeMillis > TROrangeController.whiteScreenTime()) {
                launchMonitorData.addPoint("whiteScreen");
            } else {
                launchMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_USER_CANCEL);
            }
        }
        String string = launchMonitorData.toString();
        RVLogger.d(TAG, "commoitPageMonitor:" + str2 + q.a.i + string);
        try {
            pluginIdFromPageUrl = CommonUtils.getPluginIdFromPageUrl(str2);
            try {
                pluginVersion = !TextUtils.isEmpty(pluginIdFromPageUrl) ? CommonUtils.getPluginVersion(pluginIdFromPageUrl, page) : null;
            } catch (Exception e2) {
                e = e2;
                RVLogger.e(TAG, "getPluginIdFromPage error", e);
            }
        } catch (Exception e3) {
            e = e3;
            pluginIdFromPageUrl = null;
        }
        boolean zContainsKey = launchMonitorData.getData().containsKey(TriverAppMonitorConstants.KEY_STAGE_USER_CANCEL);
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (zContainsKey) {
            triverLaunchPointerCreate = TriverLaunchPointer.build().setAppId(str).setApp(page != null ? page.getApp() : null).setTemplateId(str3).setErrorCode(TriverAppMonitorConstants.KEY_STAGE_USER_CANCEL).setStage(TriverAppMonitorConstants.KEY_STAGE_PAGE_STAGE).setErrorMsg(TriverAppMonitorConstants.KEY_STAGE_USER_CANCEL).setNewStage(string).setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).putExtra("pageName", str2).putExtra("pluginId", pluginIdFromPageUrl).putExtra("pluginVersion", pluginVersion).create();
        } else {
            boolean z = TextUtils.isEmpty(launchMonitorData.getErrorCode()) && TextUtils.isEmpty(launchMonitorData.getErrorMessage());
            TriverLaunchPointer.Builder newStage = TriverLaunchPointer.build().setAppId(str).setApp(page != null ? page.getApp() : null).setTemplateId(str3).setStage(TriverAppMonitorConstants.KEY_STAGE_PAGE_STAGE).setErrorCode(launchMonitorData.getErrorCode()).setErrorMsg(launchMonitorData.getErrorMessage()).setNewStage(string);
            if (z) {
                d = 1.0d;
            }
            triverLaunchPointerCreate = newStage.setStatus(Double.valueOf(d)).putExtra("pageName", str2).putExtra("pluginId", pluginIdFromPageUrl).putExtra("pluginVersion", pluginVersion).create();
        }
        if (RVProxy.get(ITriverAppMonitorProxy.class) != null) {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverPageLaunch(triverLaunchPointerCreate);
        }
    }
}
