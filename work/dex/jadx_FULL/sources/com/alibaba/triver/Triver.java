package com.alibaba.triver;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.taobao.windvane.WindVaneSDK;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.app.ActivityOptionsCompat;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.integration.RVInitializer;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcClientKernelUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.core.PluginInfoCenter;
import com.alibaba.triver.container.ContainerAnimModel;
import com.alibaba.triver.container.TriverProxyActivity;
import com.alibaba.triver.extensions.DefOpenModeExtension;
import com.alibaba.triver.impl.InitializerPrinter;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.event.TriverEventCenter;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.proxy.ITriverToolsProxy;
import com.alibaba.triver.kit.api.proxy.IUserTrackProxy;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import com.alibaba.triver.point.TriverAnalyticsPoint;
import com.alibaba.triver.point.TriverLifecyclePoint;
import com.alibaba.triver.point.TriverOpenModeProxy;
import com.alibaba.triver.resource.debug.DebugInfo;
import com.alibaba.triver.trace.c;
import com.alibaba.triver.utils.CommonUtils;
import com.alipay.mobile.jsengine.JSEngine2;
import com.aliyun.tea.logging.DefaultLogger;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Triver {
    public static final String TAG = "AriverTriver:AppStarter";
    public static volatile AppModel currentAppxModel = null;
    private static volatile boolean dataSynced = false;
    private static volatile boolean isInitNecessary = false;
    private static Boolean isLiteProcess;
    private static Boolean isMainProcess;
    private static String utdid;

    @WorkerThread
    public static void clearTriverCache() {
        com.alibaba.triver.appinfo.core.b.c();
        PluginInfoCenter.a();
    }

    public static void createFragment(Context context, Uri uri, Bundle bundle, int i, RVMain.a aVar) {
        if (uri != null) {
            String appId = TRiverUtils.getAppId(uri);
            if (TextUtils.isEmpty(appId)) {
                return;
            }
            startAnalyzerTools(context, uri, appId);
            Bundle bundle2 = new Bundle();
            bundle2.putString(TRiverConstants.KEY_ORI_URL, uri.toString());
            bundle2.putString(RVStartParams.KEY_ENABLE_POLYFILL_WORKER, "true");
            bundle2.putInt(TRiverConstants.KEY_FRAGMENT_SUNPAGE_CONTAINER, i);
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (CommonUtils.isApkDebug(context)) {
                bundle2.putString(AliyunLogCommon.LogLevel.DEBUG, "framework");
            }
            for (String str : uri.getQueryParameterNames()) {
                if (!TextUtils.isEmpty(str)) {
                    String queryParameter = uri.getQueryParameter(str);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bundle2.putString(str, queryParameter.trim());
                    }
                }
            }
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(appId).setStage("appStart").setStatus(Double.valueOf(1.0d)).setStartParams(bundle2).create());
            Bundle bundle3 = new Bundle();
            bundle3.putLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP, bundle.getLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP, 0L));
            RVMain.createFragment(context, appId, bundle2, bundle3, aVar);
        }
    }

    private static RVAppRecord findFirstRecord(List<RVAppRecord> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = list.size();
        int i = 0;
        if (size == 1) {
            return list.get(0);
        }
        long startToken = list.get(0).getStartToken();
        for (int i2 = 1; i2 < size; i2++) {
            RVAppRecord rVAppRecord = list.get(i2);
            if (rVAppRecord.getStartToken() < startToken) {
                startToken = rVAppRecord.getStartToken();
                i = i2;
            }
        }
        return list.get(i);
    }

    private static RVAppRecord findValidRecord(String str, List<RVAppRecord> list) {
        for (RVAppRecord rVAppRecord : list) {
            if (rVAppRecord != null && rVAppRecord.getActivityClz() != null && rVAppRecord.getRunningTaskInfo() != null) {
                return rVAppRecord;
            }
        }
        return null;
    }

    private static RVAppRecord getAppRecord(String str, Uri uri) {
        if (TRiverUrlUtils.isShop(uri.toString()) && !TBShopOrangeController.openShopSingleInstance()) {
            return null;
        }
        RVAppRecord appRecord = RVMain.getAppRecord(str);
        RVLogger.d("AriverInt:Main", "getAppRecord: " + appRecord);
        return appRecord;
    }

    public static String getUtdid() {
        if (TextUtils.isEmpty(utdid)) {
            try {
                utdid = ((IUserTrackProxy) RVProxy.get(IUserTrackProxy.class)).getUtdid(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
            } catch (Exception e) {
                RVLogger.e(TAG, "get utdid error", e);
            }
        }
        return utdid;
    }

    public static synchronized void initNecessary(Application application) {
        if (!isInitNecessary) {
            RVInitializer.setPrinter(new InitializerPrinter());
            RVInitializer.init(application);
            TriverEventCenter.init();
            isInitNecessary = true;
        }
    }

    private static boolean isAppxHotChange(Uri uri) {
        return "true".equals(uri.getQueryParameter(TRiverConstants.KEY_HOT_CHANGE));
    }

    private static boolean isClearCache(Uri uri) {
        return "true".equals(uri.getQueryParameter(TRiverConstants.KEY_CLEAR_CACHE));
    }

    public static boolean isDataSynced() {
        return dataSynced;
    }

    public static boolean isDebug(Uri uri) {
        return "true".equals(uri.getQueryParameter(TRiverConstants.KEY_LOCAL_DEBUG));
    }

    public static synchronized boolean isInitUCJSEngine() {
        boolean z;
        z = false;
        try {
            if (WindVaneSDK.isInitialized() && JSEngine2.isInitialized()) {
                z = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public static boolean isMainProcess(Context context) {
        if (isMainProcess == null) {
            isMainProcess = Boolean.valueOf(TextUtils.equals(ProcessUtils.getProcessName(), context.getPackageName()));
        }
        return isMainProcess.booleanValue();
    }

    private static boolean isNewInstance(RVAppRecord rVAppRecord, Uri uri) {
        Bundle startParams;
        if (uri == null) {
            return false;
        }
        if ("true".equals(uri.getQueryParameter("newInstance")) || rVAppRecord == null || (startParams = rVAppRecord.getStartParams()) == null) {
            return true;
        }
        return (TextUtils.equals(startParams.getString(AppInfoScene.PARAM_SOURCE), uri.getQueryParameter(AppInfoScene.PARAM_SOURCE)) && TextUtils.equals(startParams.getString(AppInfoScene.PARAM_SCENE_VERSION), uri.getQueryParameter(AppInfoScene.PARAM_SCENE_VERSION))) ? false : true;
    }

    public static boolean isProcessAlive(Context context, String str) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (!TextUtils.isEmpty(runningAppProcessInfo.processName) && runningAppProcessInfo.processName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTinyProcess() {
        if (isLiteProcess == null) {
            String processName = ProcessUtils.getProcessName();
            isLiteProcess = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.contains(":wml"));
        }
        return isLiteProcess.booleanValue();
    }

    public static boolean isTriverUrl(Uri uri) {
        return TRiverUtils.isTriverUrl(uri);
    }

    public static boolean openApp(Context context, Uri uri, Bundle bundle, int i) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(TRiverConstants.KEY_REQUEST_CODE, i);
        return openApp(context, uri, bundle);
    }

    private static Bundle parseParams(Uri uri) {
        Bundle bundle = new Bundle();
        for (String str : uri.getQueryParameterNames()) {
            if (!TextUtils.isEmpty(str) && !"url".equals(str.toLowerCase())) {
                String queryParameter = uri.getQueryParameter(str);
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString(str, queryParameter.trim());
                }
            }
        }
        return bundle;
    }

    public static boolean reShowAppTask(Context context, RVAppRecord rVAppRecord) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return false;
        }
        activityManager.moveTaskToFront(rVAppRecord.getRunningTaskInfo().id, 0, ActivityOptionsCompat.makeCustomAnimation(context, R.anim.ariver_fragment_translate_in_right, R.anim.ariver_fragment_translate_out_right).toBundle());
        return true;
    }

    public static boolean releaseAllApp() {
        List<Long> listJ = com.alibaba.triver.container.a.a().j();
        if (listJ == null) {
            return false;
        }
        for (Long l : listJ) {
            if (l != null) {
                try {
                    RVAppRecord appRecord = RVMain.getAppRecord(l.longValue());
                    if (appRecord != null) {
                        com.alibaba.triver.container.a.d(appRecord.getAppId());
                        appRecord.finishClient();
                        RVLogger.d(TAG, "close app instance:" + appRecord.getAppId());
                    }
                } catch (Exception e) {
                    RVLogger.e(TAG, "releaseAllApp error", e);
                }
            }
        }
        return true;
    }

    public static boolean releaseApp(String str) {
        long jC = com.alibaba.triver.container.a.a().c(str);
        if (jC <= -1) {
            return false;
        }
        try {
            RVAppRecord appRecord = RVMain.getAppRecord(jC);
            if (appRecord == null) {
                return false;
            }
            com.alibaba.triver.container.a.d(appRecord.getAppId());
            appRecord.finishClient();
            RVLogger.d(TAG, "close app instance:" + appRecord.getAppId());
            return true;
        } catch (Exception e) {
            RVLogger.e(TAG, "releaseApp error：" + str, e);
            return false;
        }
    }

    public static boolean restartApp(Context context, RVAppRecord rVAppRecord, Bundle bundle, boolean z) {
        Serializable serializable;
        if (rVAppRecord == null) {
            return false;
        }
        Integer numValueOf = null;
        com.alibaba.triver.trace.b.a(c.d, c.z, TRiverUtils.getSessionId(bundle), rVAppRecord.getAppId(), (JSONObject) null);
        RVInitializer.init(context);
        Intent intent = new Intent();
        intent.addFlags(603979776);
        if (rVAppRecord.isTaskRoot()) {
            intent.addFlags(268435456);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(RVConstants.EXTRA_START_PARAMS, bundle);
        bundle2.putParcelable(RVConstants.EXTRA_SCENE_PARAMS, new Bundle());
        intent.putExtras(bundle2);
        intent.putExtra("record_id", rVAppRecord.getAppId());
        intent.putExtra("record_token", rVAppRecord.getStartToken());
        ContainerAnimModel containerAnimModel = new ContainerAnimModel();
        containerAnimModel.frontEnterAnim = R.anim.triver_pri_enter_up_in;
        containerAnimModel.backgroundEnterAnim = R.anim.triver_pri_enter_scale;
        containerAnimModel.frontExitAnim = R.anim.triver_pri_exit_scale;
        containerAnimModel.backgroundExitAnim = R.anim.triver_pri_exit_down_out;
        Bundle sceneParams = rVAppRecord.getSceneParams();
        if (sceneParams != null && (serializable = sceneParams.getSerializable(TRiverConstants.KEY_CONTAINER_ANIM)) != null) {
            containerAnimModel = (ContainerAnimModel) serializable;
        }
        ActivityOptionsCompat activityOptionsCompatMakeCustomAnimation = z ? ActivityOptionsCompat.makeCustomAnimation(context, R.anim.ariver_fragment_translate_in_right, R.anim.ariver_fragment_translate_out_right) : ActivityOptionsCompat.makeCustomAnimation(context, containerAnimModel.frontEnterAnim, containerAnimModel.backgroundEnterAnim);
        if (context == null) {
            context = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        }
        intent.setClass(context, rVAppRecord.getActivityClz());
        if (bundle != null && bundle.containsKey(TRiverConstants.KEY_REQUEST_CODE)) {
            numValueOf = Integer.valueOf(bundle.getInt(TRiverConstants.KEY_REQUEST_CODE));
        }
        if (numValueOf == null || !(context instanceof Activity)) {
            intent.addFlags(268435456);
            context.startActivity(intent, activityOptionsCompatMakeCustomAnimation.toBundle());
        } else {
            ((Activity) context).startActivityForResult(intent, numValueOf.intValue(), activityOptionsCompatMakeCustomAnimation.toBundle());
        }
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Launch", "End create activity");
        return true;
    }

    public static void setDataSynced(boolean z) {
        dataSynced = z;
    }

    private static void startAnalyzerTools(Context context, Uri uri, String str) {
        try {
            if (!CommonUtils.closeAnalyzerTools()) {
                if (CommonUtils.isApkDebug()) {
                    ((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).startAnalyzerTools(context, str);
                } else if (!CommonUtils.closeToolsInRelease()) {
                    if (DefaultLogger.DEBUG.equalsIgnoreCase(uri.getQueryParameter(AppInfoScene.PARAM_SCENE))) {
                        ((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).startAnalyzerTools(context, str);
                    } else {
                        ((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).stopAnalyzerTools();
                    }
                }
            }
        } catch (Throwable th) {
            RVLogger.w(TAG, "startAnalyzerTools: ", th);
        }
    }

    private static boolean startAppByUri(Context context, Uri uri, Bundle bundle) {
        if (uri == null) {
            return false;
        }
        String appId = TRiverUtils.getAppId(uri);
        if (TextUtils.isEmpty(appId)) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", (Object) uri.toString());
        com.alibaba.triver.trace.b.a(c.d, c.x, TRiverUtils.getSessionId(bundle), appId, jSONObject);
        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(c.x, null, TrackId.Stub_AppStart, appId, null, jSONObject);
        Bundle bundle2 = new Bundle();
        bundle2.putString(TRiverConstants.KEY_ORI_URL, uri.toString());
        bundle2.putString(RVStartParams.KEY_ENABLE_POLYFILL_WORKER, "true");
        bundle2.putBoolean(RVParams.isTinyApp, true);
        if (CommonUtils.isApkDebug(context)) {
            bundle2.putString(AliyunLogCommon.LogLevel.DEBUG, "framework");
        }
        Bundle params = parseParams(uri);
        if (params != null) {
            bundle2.putAll(params);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(appId).setStage("appStart").setStatus(Double.valueOf(1.0d)).setStartParams(bundle2).create());
        Bundle bundle3 = new Bundle();
        if (!CommonUtils.isApkDebug(context)) {
            bundle2.remove(TRiverConstants.KEY_LOCAL_DEBUG);
        } else if (isDebug(uri)) {
            bundle3.putSerializable(TRiverConstants.KEY_LOCAL_DEBUG_INFO, new DebugInfo(uri.toString()));
            appId = AliyunLogCommon.LogLevel.DEBUG + appId;
        }
        if (((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).isToolsOpen()) {
            bundle3.putBoolean(ITriverToolsProxy.IS_TOOLS_OPEN, true);
        }
        bundle3.putLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP, bundle.getLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP, 0L));
        if ("YES".equals(bundle2.getString(RVStartParams.KEY_SUPER_SPLASH)) && CommonUtils.closeSuperSplash()) {
            bundle2.putString(RVStartParams.KEY_SUPER_SPLASH, "NO");
        }
        try {
            if (CommonUtils.isApkDebug(context) && isMainProcess(context) && bundle.getBoolean(TRiverConstants.KEY_ANALYTICS_ENABLE, true)) {
                TriverAnalyticsPoint triverAnalyticsPoint = (TriverAnalyticsPoint) ExtensionPoint.as(TriverAnalyticsPoint.class).nullable().create();
                RVProxy.getPrinter();
                if (triverAnalyticsPoint == null || triverAnalyticsPoint.onStart(context, bundle2)) {
                    RVMain.startApp(context, appId, bundle2, bundle3);
                    RVLogger.d("AriverTriverTriverNavHooker", "nav to triver app appId:" + appId);
                } else {
                    RVLogger.d("AriverTriverTriverNavHooker", "RVInitializer failed" + appId);
                }
                return true;
            }
        } catch (Throwable th) {
            RVLogger.e(TAG, "analytics error", th);
        }
        RVMain.startApp(context, appId, bundle2, bundle3);
        RVLogger.d("AriverTriverTriverNavHooker", "nav to triver app appId:" + appId);
        return true;
    }

    private static boolean startClearCache(final Context context, Uri uri, Bundle bundle) {
        final String appId = TRiverUtils.getAppId(uri);
        if (TextUtils.isEmpty(appId)) {
            return false;
        }
        new AsyncTask<Void, Void, Void>() { // from class: com.alibaba.triver.Triver.1
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                if ("all".equals(appId)) {
                    Triver.clearTriverCache();
                    return null;
                }
                com.alibaba.triver.appinfo.storage.b.a().a(appId);
                return null;
            }

            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r2) {
                Context context2 = context;
                TriverToastUtils.showToast(context2, context2.getString(R.string.triver_clear_cache));
            }
        }.execute(new Void[0]);
        return true;
    }

    private static boolean startDebugByUri(Context context, Uri uri, Bundle bundle) {
        RVInitializer.init(context);
        String appId = TRiverUtils.getAppId(uri);
        if (TextUtils.isEmpty(appId)) {
            return false;
        }
        Intent intent = new Intent("com.alibaba.triver.tools.debug.hotchange");
        intent.putExtra("url", uri.toString());
        intent.putExtra("type", "hotChange");
        intent.putExtra("appId", appId);
        if (context instanceof Application) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
        return true;
    }

    public static void startTargetWithProxy(Context context, String str, Intent intent, ContainerAnimModel containerAnimModel, Integer num) {
        Intent intent2 = new Intent(context, (Class<?>) TriverProxyActivity.class);
        intent2.addFlags(65536);
        intent2.putExtra("appId", str);
        intent2.putExtra("targetIntent", intent);
        intent2.putExtra(TRiverConstants.KEY_CONTAINER_ANIM, containerAnimModel);
        if (!(context instanceof Activity)) {
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        } else if (num != null) {
            ((Activity) context).startActivityForResult(intent2, num.intValue());
        } else {
            context.startActivity(intent2);
        }
        RVLogger.d(TAG, "new task mode, add proxy to main task");
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Launch", "End create activity");
    }

    public static boolean openApp(Context context, Uri uri, Bundle bundle) {
        RVAppRecord rVAppRecordFindFirstRecord;
        if (context != null && (context.getApplicationContext() instanceof Application)) {
            initNecessary((Application) context.getApplicationContext());
        } else {
            RVInitializer.init(context);
        }
        if (TextUtils.isEmpty(utdid)) {
            try {
                utdid = ((IUserTrackProxy) RVProxy.get(IUserTrackProxy.class)).getUtdid(context);
            } catch (Exception e) {
                RVLogger.e(TAG, "get utdid error", e);
            }
        }
        if (!isMainProcess(context)) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("openUri", uri);
            bundle2.putBundle("openParams", bundle);
            IpcClientKernelUtils.sendMsgToServer(IpcMessageConstants.BIZ_APP, 103, bundle2);
            return true;
        }
        if (uri != null) {
            String appId = TRiverUtils.getAppId(uri);
            startAnalyzerTools(context, uri, appId);
            if (TextUtils.isEmpty(appId)) {
                com.alibaba.triver.trace.b.a(c.d, c.B, TRiverUtils.getSessionId(bundle), appId, (JSONObject) null);
                return false;
            }
            if (ExtensionPoint.as(TriverLifecyclePoint.class).create() != null) {
                ((TriverLifecyclePoint) ExtensionPoint.as(TriverLifecyclePoint.class).create()).onStartApp(context, uri, bundle);
            }
            if (CommonUtils.isApkDebug() && isAppxHotChange(uri)) {
                startDebugByUri(context, uri, bundle);
                return true;
            }
            if (isClearCache(uri) && !CommonUtils.closeClearCacheByUrl()) {
                startClearCache(context, uri, bundle);
                return true;
            }
            RVLogger.d("AriverInt:Main", "openApp: " + appId);
            if (!TROrangeController.downgradeInstanceOptimization()) {
                List<RVAppRecord> appRecords = RVMain.getAppRecords(appId);
                if (appRecords != null && !appRecords.isEmpty()) {
                    TriverOpenModeProxy defOpenModeExtension = (TriverOpenModeProxy) RVProxy.get(TriverOpenModeProxy.class, true);
                    if (defOpenModeExtension == null) {
                        defOpenModeExtension = new DefOpenModeExtension();
                    }
                    if (defOpenModeExtension.getOpenMode(appId, uri, appRecords) == TriverOpenModeProxy.OpenMode.MULTI_INSTANCE) {
                        if (appRecords.size() >= defOpenModeExtension.getMaxInstanceCount(appId, uri) && (rVAppRecordFindFirstRecord = findFirstRecord(appRecords)) != null) {
                            rVAppRecordFindFirstRecord.finishClient();
                        }
                        return startAppByUri(context, uri, bundle);
                    }
                    RVAppRecord rVAppRecordFindValidRecord = findValidRecord(appId, appRecords);
                    if (rVAppRecordFindValidRecord != null) {
                        if (defOpenModeExtension.getSingleMode(appId, uri) == TriverOpenModeProxy.SingleMode.NEW_INSTANCE) {
                            rVAppRecordFindValidRecord.finishClient();
                            return startAppByUri(context, uri, bundle);
                        }
                        if (isNewInstance(rVAppRecordFindValidRecord, uri)) {
                            rVAppRecordFindValidRecord.finishClient();
                            return startAppByUri(context, uri, bundle);
                        }
                        Bundle params = parseParams(uri);
                        if (bundle != null) {
                            params.putAll(bundle);
                        }
                        return restartApp(context, rVAppRecordFindValidRecord, params, false);
                    }
                    startAppByUri(context, uri, bundle);
                } else {
                    return startAppByUri(context, uri, bundle);
                }
            } else {
                RVAppRecord appRecord = getAppRecord(appId, uri);
                if (appRecord != null && appRecord.getActivityClz() != null && appRecord.getRunningTaskInfo() != null) {
                    if (isNewInstance(appRecord, uri)) {
                        appRecord.finishClient();
                        return startAppByUri(context, uri, bundle);
                    }
                    Bundle params2 = parseParams(uri);
                    if (bundle != null) {
                        params2.putAll(bundle);
                    }
                    return restartApp(context, appRecord, params2, false);
                }
                return startAppByUri(context, uri, bundle);
            }
        }
        return false;
    }
}
