package com.alibaba.triver.kit.api.orange;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.utils.NativeSwitchController;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.ut.device.UTDevice;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TROrangeController {
    public static final String RENDER_PRELOAD_V_HOST = "https://hybrid.miniapp.taobao.com";
    private static final String TAG = "TROrangeController";
    public static final int ORANGE_JSI_WORKER_PRECENT_NUMBER = getRandomNumber(100);
    public static String deviceId = "";
    public static int bucketId = -1;

    public static boolean allUseSubProcess() {
        try {
            return "true".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("allUseSubProcess", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean brandZoneInMainProcess() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("brandZoneInMainProcess");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static int bucketCount() {
        try {
            return Integer.parseInt(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("bucketCount", "100"));
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return 100;
        }
    }

    public static int bucketPrimeNumber() {
        try {
            return Integer.parseInt(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("bucketPrimeNumber", "49993"));
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return 49993;
        }
    }

    public static boolean closeAppInfoForceUpdate() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeAppInfoForceUpdate");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean closeAppInfoParamsOptimization() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeAppInfoParamsOptimization");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean closeAppInfoUpdateOptimization() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeAppInfoUpdateOptimization");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean closeAppLimit() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeAppLimit");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean closeAppxUpdate() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeAppxUpdate");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean closeCdnRequestDowngrade() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeCdnRequestDowngrade");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean closeRevertHttpCookie() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeRevertHttpCookie");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean downgradeInstanceOptimization() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("downgradeInstanceOptimization");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean drowngradeSyncCdnRequest() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("drowngradeSyncCdnRequest");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean enableACLeakFix() {
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableACLeakFix", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean enableActivityBackKeyIntercept() {
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableActivityBackKeyIntercept", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean enableAllItemsWeexPreload() {
        try {
            return "true".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableAllItemWeexPreload", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean enableAr() {
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableAr", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
            RVLogger.e("Triver enableAr : " + config);
            return "true".equals(config);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean enableBackGroundAduioPlay(String str, String str2) {
        if (str == null && str2 == null) {
            return false;
        }
        if ("19764305".equals(str)) {
            return true;
        }
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("enableBackGroundPlayList");
        JSONArray configJSONArray2 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("enableBackGroundPlayTemplateList");
        if (configJSONArray == null && configJSONArray2 == null) {
            return false;
        }
        if (configJSONArray == null || !configJSONArray.contains(str)) {
            return configJSONArray2 != null && configJSONArray2.contains(str2);
        }
        return true;
    }

    public static boolean enableBasicRenderPreload() {
        return readBooleanConfig("enableBasicRenderPreload", Boolean.TRUE);
    }

    public static boolean enableBasicWorkerPreload() {
        return readBooleanConfig("enableBasicWorkerPreload", Boolean.TRUE);
    }

    public static boolean enableCloseNavAnim() {
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableCloseNavAnim", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean enableCustomUT(App app) {
        if (app == null) {
            return false;
        }
        try {
            return ifArrayNullReturnEmptyArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("enableCustomUTAppList")).contains(app.getAppId()) || ifArrayNullReturnEmptyArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("enableCustomUTTemplateList")).contains(TRiverUtils.getAppTemplateId(app));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean enableDataPreload() {
        if (NativeSwitchController.isEnableNative()) {
            return NativeSwitchController.enableStaticDataPreload();
        }
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableDataPreload", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean enableIDEPush() {
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableIDEPush", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean enableJSIWorker() {
        if (NativeSwitchController.isEnableNative()) {
            return NativeSwitchController.enableJSIWorker();
        }
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableJSIWorker", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean enableJSIWorkerByAppIdAndTemplateId(App app) {
        int i;
        if (NativeSwitchController.isEnableNative()) {
            return NativeSwitchController.enableJSIWorker();
        }
        if (!enableJSIWorker() || app == null) {
            return false;
        }
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("jsiWorkerAppIdList");
        JSONArray configJSONArray2 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("jsiWorkerTemplateList");
        JSONArray configJSONArray3 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("jsiWorkerAppIdBlackList");
        JSONArray configJSONArray4 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("jsiWorkerTemplateBlackList");
        JSONArray jSONArrayIfArrayNullReturnEmptyArray = ifArrayNullReturnEmptyArray(configJSONArray);
        JSONArray jSONArrayIfArrayNullReturnEmptyArray2 = ifArrayNullReturnEmptyArray(configJSONArray2);
        JSONArray jSONArrayIfArrayNullReturnEmptyArray3 = ifArrayNullReturnEmptyArray(configJSONArray3);
        JSONArray jSONArrayIfArrayNullReturnEmptyArray4 = ifArrayNullReturnEmptyArray(configJSONArray4);
        String appId = app.getAppId();
        String appTemplateId = TRiverUtils.getAppTemplateId(app);
        if (jSONArrayIfArrayNullReturnEmptyArray3.contains(appId) || jSONArrayIfArrayNullReturnEmptyArray4.contains(appTemplateId)) {
            return false;
        }
        String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("jsiWorkerPercent", null);
        if (config != null) {
            try {
                i = Integer.parseInt(config);
            } catch (Exception e) {
                e.printStackTrace();
                i = -1;
            }
            if (ORANGE_JSI_WORKER_PRECENT_NUMBER < i) {
                return true;
            }
        }
        return jSONArrayIfArrayNullReturnEmptyArray.contains(appId) || jSONArrayIfArrayNullReturnEmptyArray2.contains(appTemplateId) || jSONArrayIfArrayNullReturnEmptyArray.contains("all") || jSONArrayIfArrayNullReturnEmptyArray2.contains("all");
    }

    public static boolean enableJSSandbox(String str) {
        try {
            return true ^ readArrayConfigReturnNoNullArray("disableJSSandboxList").contains(str);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean enableMiniDetailTransition() {
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableMiniDetailTransition", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean enableMtopCache(App app) {
        if (app == null) {
            return false;
        }
        String appTemplateId = TRiverUtils.getAppTemplateId(app);
        String appId = app.getAppId();
        JSONArray arrayConfigReturnNoNullArray = readArrayConfigReturnNoNullArray("enableMtopCacheAppIdList");
        JSONArray arrayConfigReturnNoNullArray2 = readArrayConfigReturnNoNullArray("enableMtopCacheTemplateList");
        if (arrayConfigReturnNoNullArray.contains(appId) || arrayConfigReturnNoNullArray2.contains(appTemplateId)) {
            return true;
        }
        return enablePrefetchJs(app);
    }

    public static boolean enableOpenFromShopPageSubProcess() {
        try {
            return "true".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableOpenFromShopPageSubProcess", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean enablePkgPreload() {
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enablePkgPreload", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean enablePluginAppStorageIsolation() {
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enablePluginAppStorageIsolation", "true");
            RVLogger.e("Triver enablePluginAppStorageIsolation : " + config);
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(config);
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean enablePrefetchJs(String str) {
        if (NativeSwitchController.isEnableNative()) {
            return NativeSwitchController.enablePrefetchJs();
        }
        try {
            JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("enablePrefetchJsAppList");
            return configJSONArray != null && configJSONArray.contains(str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean enableRenderPreload(String str, String str2) {
        String str3 = "0";
        if (isBadBucket()) {
            return false;
        }
        if (NativeSwitchController.isEnableNative()) {
            return NativeSwitchController.enableRenderPreload();
        }
        if ((str == null && str2 == null) || thisAppIdInRenderPreloadBlackList(str)) {
            return false;
        }
        try {
            JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("enableRenderPreloadAppIdList");
            JSONArray configJSONArray2 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("enableRenderPreloadTemplateList");
            if (configJSONArray2 != null && (configJSONArray2.contains(str2) || configJSONArray2.contains("all"))) {
                return true;
            }
            if (configJSONArray != null && (configJSONArray.contains(str) || configJSONArray.contains("all"))) {
                return true;
            }
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("renderPreloadRate", "0");
            if (!TextUtils.isEmpty(config)) {
                str3 = config;
            }
            if (Integer.valueOf(str3).intValue() >= new Random().nextInt(100) + 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean enableSecondaryPagePreload(App app) {
        if (app == null) {
            return false;
        }
        String appId = app.getAppId();
        JSONArray arrayConfigReturnNoNullArray = readArrayConfigReturnNoNullArray("secondaryPagePreloadAppIDList");
        if (arrayConfigReturnNoNullArray == null || arrayConfigReturnNoNullArray.size() <= 0) {
            arrayConfigReturnNoNullArray = new JSONArray();
            arrayConfigReturnNoNullArray.add("11509317");
        }
        return arrayConfigReturnNoNullArray.contains(appId);
    }

    public static boolean enableSubProcess(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return ifArrayNullReturnEmptyArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("enableSubProcessAppList")).contains(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean enableTraceLog() {
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableTraceLog", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean enableUseMainProcessWhenSubProcessNotReady() {
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableUseMainProcessWhenSubProcessNotReady", "true");
            RVLogger.e("Triver enableUseMainProcessWhenSubProcessNotReady : " + config);
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(config);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean enableUseResourceManagerV2() {
        if (isBadBucket()) {
            return false;
        }
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableUseResourceManagerV2", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean enableVConsole() {
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableVConsole", "true");
            RVLogger.e("Triver enableVConsole: ", config);
            return "true".equalsIgnoreCase(config);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return false;
        }
    }

    public static boolean enableWVJSBridgeEnable() {
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableWVJSBridgeEnable", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
            RVLogger.e("Triver enableWVJSBridgeEnable : " + config);
            return "true".equals(config);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean enableWorkerCodePreload() {
        if (isBadBucket()) {
            return false;
        }
        if (NativeSwitchController.isEnableNative()) {
            return NativeSwitchController.enableWorkerCodePreload();
        }
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("enableWorkerCodePreload", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean forbidZCacheIPC() {
        if (isBadBucket()) {
            return false;
        }
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("forbidZCacheIPC_v2", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static int getAppLimitWaitMillis() {
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            if (configsByGroup == null) {
                return 500;
            }
            String str = configsByGroup.get("appLimitWaitMillis");
            if (TextUtils.isEmpty(str)) {
                return 500;
            }
            return Integer.parseInt(str);
        } catch (Exception e) {
            RVLogger.e(TAG, "getAppLimitWaitMillis error", e);
            return 500;
        }
    }

    @NonNull
    private static JSONArray getArrayConfigReturnNoNullArray(String str) {
        JSONArray array = null;
        try {
            String config = getConfig(str, "");
            if (!TextUtils.isEmpty(config)) {
                array = JSON.parseArray(config);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ifArrayNullReturnEmptyArray(array);
    }

    private static String getConfig(String str, String str2) {
        try {
            return ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static long getMtopCacheTimeoutBySecond() {
        return readLongConfig("mtopCacheTimeBySecond", 60L);
    }

    public static JSONArray getNativeInputWhiteList() {
        try {
            return ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("nativeInputWhiteList");
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return null;
        }
    }

    public static JSONArray getPkgPreloadList() {
        return getArrayConfigReturnNoNullArray("pkgPreloadList");
    }

    private static int getRandomNumber(int i) {
        int iNextInt = new Random().nextInt(i);
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Orange", "getRandom Number : " + iNextInt);
        return iNextInt;
    }

    public static JSONArray getResourceDomainNameWhiteList() {
        try {
            return ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("resourceDomainWhiteList");
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return null;
        }
    }

    public static int getShopFetchCacheTimeByMinute() {
        try {
            int i = Integer.parseInt(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("shopFetchCacheTime", "4320"), 10);
            if (i >= 0) {
                return i;
            }
            return 4320;
        } catch (Exception e) {
            e.printStackTrace();
            return 4320;
        }
    }

    public static String[] getWasmDEPS(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            if (bundle.containsKey(TRiverConstants.KEY_WASM_DEPS)) {
                String string = bundle.get(TRiverConstants.KEY_WASM_DEPS).toString();
                if (!TextUtils.isEmpty(string)) {
                    return string.trim().split(",");
                }
            }
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0041  */
    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    public static boolean hasGpuAccelerate(Bundle bundle) {
        boolean zBooleanValue;
        boolean z = false;
        if (bundle == null) {
            return false;
        }
        try {
            if (!bundle.containsKey(TRiverConstants.KEY_GPU_ACCELERATE)) {
                if (bundle.containsKey(TRiverConstants.KEY_ENABLE_SKIA)) {
                    zBooleanValue = Boolean.valueOf(bundle.get(TRiverConstants.KEY_ENABLE_SKIA).toString()).booleanValue();
                }
                if (z) {
                    RVLogger.e("Triver Use Native Canvas");
                } else {
                    RVLogger.e("Triver Use Web Canvas");
                }
                return z;
            }
            zBooleanValue = Boolean.valueOf(bundle.get(TRiverConstants.KEY_GPU_ACCELERATE).toString()).booleanValue();
            z = zBooleanValue;
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
        if (z) {
            RVLogger.e("Triver Use Native Canvas");
        } else {
            RVLogger.e("Triver Use Web Canvas");
        }
        return z;
    }

    public static boolean hasWasmEnable(Bundle bundle) {
        boolean zBooleanValue = false;
        if (bundle == null) {
            return false;
        }
        try {
            if (bundle.containsKey(TRiverConstants.KEY_ENABLE_WASM)) {
                zBooleanValue = Boolean.valueOf(bundle.get(TRiverConstants.KEY_ENABLE_WASM).toString()).booleanValue();
            }
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
        if (zBooleanValue) {
            RVLogger.e("Triver Use Wasm");
        }
        return zBooleanValue;
    }

    @NonNull
    public static JSONArray ifArrayNullReturnEmptyArray(JSONArray jSONArray) {
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public static boolean inTBVideoSDKBlackList(App app) {
        if (app == null) {
            return false;
        }
        String appId = app.getAppId();
        String appTemplateId = TRiverUtils.getAppTemplateId(app);
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("tbVideoSDKBlackListAppId");
        JSONArray configJSONArray2 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("tbVideoSDKBlackListTemplateId");
        JSONArray jSONArrayIfArrayNullReturnEmptyArray = ifArrayNullReturnEmptyArray(configJSONArray);
        JSONArray jSONArrayIfArrayNullReturnEmptyArray2 = ifArrayNullReturnEmptyArray(configJSONArray2);
        if (jSONArrayIfArrayNullReturnEmptyArray.isEmpty()) {
            jSONArrayIfArrayNullReturnEmptyArray.add("19764305");
        }
        return jSONArrayIfArrayNullReturnEmptyArray.contains(appId) || jSONArrayIfArrayNullReturnEmptyArray2.contains(appTemplateId);
    }

    private static boolean isAppIdInPrefetchJsBlackList(App app) {
        if (isBadBucket() || app == null) {
            return false;
        }
        return readArrayConfigReturnNoNullArray("prefetchJsAppIdBlackList").contains(app.getAppId()) || readArrayConfigReturnNoNullArray("prefetchJsTemplateIdList").contains(TRiverUtils.getAppTemplateId(app));
    }

    public static boolean isAppInJSIWorkerBlackList(App app) {
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("jsiWorkerAppIdBlackList");
        JSONArray configJSONArray2 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("jsiWorkerTemplateBlackList");
        return ifArrayNullReturnEmptyArray(configJSONArray).contains(app.getAppId()) || ifArrayNullReturnEmptyArray(configJSONArray2).contains(TRiverUtils.getAppTemplateId(app));
    }

    public static boolean isBadBucket() {
        JSONArray arrayConfigReturnNoNullArray;
        try {
            return (TextUtils.isEmpty(deviceId) || (arrayConfigReturnNoNullArray = getArrayConfigReturnNoNullArray("badBucketList")) == null || !arrayConfigReturnNoNullArray.contains(String.valueOf(bucketId))) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isSnapshotEnable(App app) {
        AppModel appModel;
        if (isBadBucket() || app == null || app.isExited() || TextUtils.isEmpty(app.getAppId()) || (appModel = (AppModel) app.getData(AppModel.class)) == null) {
            return false;
        }
        TemplateConfigModel templateConfig = appModel.getAppInfoModel().getTemplateConfig();
        String appId = appModel.getAppId();
        String templateId = templateConfig != null ? templateConfig.getTemplateId() : "";
        if ("YES".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), RVParams.APPX_ROUTE_FRAMEWORK))) {
            JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshotWhiteList_appxng");
            if (configJSONArray != null && (configJSONArray.contains("all") || configJSONArray.contains(appId))) {
                RVLogger.d(TAG, "ta_snapshotWhiteList_appxng hit, appId: " + appId);
                return true;
            }
        } else {
            JSONArray configJSONArray2 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshotWhiteList");
            JSONArray configJSONArray3 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshotWhiteListTemplateId");
            JSONArray configJSONArray4 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_snapshotBlackList");
            if (configJSONArray4 != null && configJSONArray4.contains(appId)) {
                RVLogger.d(TAG, "ta_snapshotBlackList hit, appId: " + appId);
                return false;
            }
            if (configJSONArray2 != null && configJSONArray2.contains(appId)) {
                RVLogger.d(TAG, "ta_snapshotWhiteList hit, appId: " + appId);
                return true;
            }
            if (configJSONArray3 != null && configJSONArray3.contains(templateId)) {
                RVLogger.d(TAG, "ta_snapshotWhiteListTemplateId hit, appId: " + templateId);
                return true;
            }
        }
        return false;
    }

    public static boolean isThisDeviceInPreloadBlackList() {
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("preloadDeviceBlackList");
        return ifArrayNullReturnEmptyArray(configJSONArray).contains(Build.MODEL);
    }

    public static boolean isUseBatchMode(App app) {
        if (app == null) {
            return false;
        }
        try {
            JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("tiny_nativeCanvasUseCommandBuffer");
            if (configJSONArray != null && configJSONArray.size() > 0) {
                for (int i = 0; i < configJSONArray.size(); i++) {
                    if ((configJSONArray.get(i) instanceof String) && ((String) configJSONArray.get(i)).equals(app.getAppId())) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        return false;
    }

    public static void makeBucketId(Context context) {
        try {
            String utdid = UTDevice.getUtdid(context);
            deviceId = utdid;
            if (TextUtils.isEmpty(utdid)) {
                return;
            }
            int iBucketPrimeNumber = bucketPrimeNumber();
            int iBucketCount = bucketCount();
            if (iBucketPrimeNumber <= 0) {
                bucketId = Math.abs(deviceId.hashCode() % iBucketCount);
            } else {
                bucketId = Math.abs((deviceId.hashCode() % iBucketPrimeNumber) % iBucketCount);
            }
            Log.e("Triver makeBucketId", "bucketPrimeNumber: " + iBucketPrimeNumber + ", bucketCount: " + iBucketCount);
            StringBuilder sb = new StringBuilder();
            sb.append("BucketId: ");
            sb.append(bucketId);
            Log.e("Triver makeBucketId", sb.toString());
        } catch (Throwable th) {
            RVLogger.e(TAG, th);
        }
    }

    public static int miniAppBackWaitTime() {
        if (isBadBucket()) {
            return 0;
        }
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("miniAppBackWaitTime", "0");
            RVLogger.e("Triver miniAppBackWaitTime: ", config);
            return Integer.parseInt(config);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return 0;
        }
    }

    public static boolean needForceUseV8Worker(App app) {
        if (app == null || hasGpuAccelerate(app.getStartParams())) {
            return true;
        }
        return hasWasmEnable(app.getStartParams());
    }

    public static boolean openSrcDomainCheck() {
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("openSrcDomainCheckNew", "true");
            RVLogger.e("Triver openSrcDomainCheck : " + config);
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(config);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return true;
        }
    }

    private static JSONArray readArrayConfigReturnNoNullArray(String str) {
        JSONArray configJSONArray;
        try {
            configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray(str);
        } catch (Exception e) {
            e.printStackTrace();
            configJSONArray = null;
        }
        return ifArrayNullReturnEmptyArray(configJSONArray);
    }

    private static boolean readBooleanConfig(String str, Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        try {
            return !bool.toString().equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig(str, bool.toString())) ? !bool.booleanValue() : zBooleanValue;
        } catch (Exception e) {
            e.printStackTrace();
            return zBooleanValue;
        }
    }

    private static int readIntConfig(String str, Integer num) {
        String string = num.toString();
        int iIntValue = num.intValue();
        try {
            return Integer.parseInt(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig(str, string), 10);
        } catch (Exception e) {
            e.printStackTrace();
            return iIntValue;
        }
    }

    private static long readLongConfig(String str, Long l) {
        String string = l.toString();
        long jLongValue = l.longValue();
        try {
            return Long.parseLong(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig(str, string), 10);
        } catch (Exception e) {
            e.printStackTrace();
            return jLongValue;
        }
    }

    public static boolean subProcessEnableRenderWorkerPreload() {
        try {
            return "true".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("subProcessEnableRenderWorkerPreload", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean thisAppIdInRenderPreloadBlackList(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("renderPreloadBlackList");
            if (configJSONArray != null) {
                jSONArray.add(configJSONArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray.contains(str);
    }

    public static boolean useDownloaderV2() {
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("useDownloaderV2", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean useNativeInput(App app) {
        boolean zEqualsIgnoreCase = false;
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("nativeInput", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
            RVLogger.e("Triver nativeInput: ", config);
            zEqualsIgnoreCase = "true".equalsIgnoreCase(config);
            if (zEqualsIgnoreCase) {
                return zEqualsIgnoreCase;
            }
            JSONArray nativeInputWhiteList = getNativeInputWhiteList();
            String appId = app.getAppId();
            if (nativeInputWhiteList == null || !nativeInputWhiteList.contains(appId)) {
                return zEqualsIgnoreCase;
            }
            return true;
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return zEqualsIgnoreCase;
        }
    }

    public static boolean useNewSystemInfo() {
        try {
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("useNewSystemInfo", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean useTBVideoSDK(App app) {
        if (NativeSwitchController.isEnableNative()) {
            return NativeSwitchController.enableTBVideo();
        }
        if (readBooleanConfig("forceDisableTBVideoSDK", Boolean.FALSE)) {
            return false;
        }
        boolean zEqualsIgnoreCase = true;
        if (TRiverUtils.getBooleanConfigFromAppJSON("useTBVideoSDK", false, app)) {
            return true;
        }
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("useTBVideoSDK", "true");
            RVLogger.e("Triver useTBVideoSDK: ", config);
            zEqualsIgnoreCase = true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equalsIgnoreCase(config);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
        if (inTBVideoSDKBlackList(app)) {
            return false;
        }
        return zEqualsIgnoreCase;
    }

    public static boolean useTbStylePicker() {
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("useTbStylePicker", "true");
            RVLogger.e("Triver useTbStylePicker : " + config);
            return true ^ AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(config);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static int waitUCInitTime() {
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("waitUCInitTime", "10000");
            RVLogger.e("Triver waitUCInitTime: ", config);
            return Integer.parseInt(config);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return 10000;
        }
    }

    public static int whiteScreenTime() {
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("whiteScreenTime", "10000");
            RVLogger.e("Triver whiteScreenTime: ", config);
            return Integer.parseInt(config);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return 10000;
        }
    }

    public static boolean enablePrefetchJs(App app) {
        if (NativeSwitchController.isEnableNative()) {
            return NativeSwitchController.enablePrefetchJs();
        }
        if (isBadBucket() || readBooleanConfig("forceDisableEnablePrefetchJs", Boolean.FALSE)) {
            return false;
        }
        boolean booleanConfigFromAppJSON = TRiverUtils.getBooleanConfigFromAppJSON("enablePrefetchJs", false, app);
        if (isAppIdInPrefetchJsBlackList(app)) {
            return false;
        }
        return booleanConfigFromAppJSON;
    }
}
