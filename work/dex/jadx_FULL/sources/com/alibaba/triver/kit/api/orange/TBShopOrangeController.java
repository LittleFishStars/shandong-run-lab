package com.alibaba.triver.kit.api.orange;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.utils.NativeSwitchController;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBShopOrangeController {
    private static final String SHOP_CONFIG_GROUP = "shop_triver_common_config";

    public static boolean enableNSR(App app) {
        AppModel appModel;
        if (TROrangeController.isBadBucket()) {
            return false;
        }
        if (NativeSwitchController.isEnableNative()) {
            return NativeSwitchController.enableRenderTemplateSnapshotInRender();
        }
        if (app == null || app.isExited() || TextUtils.isEmpty(app.getAppId()) || (appModel = (AppModel) app.getData(AppModel.class)) == null) {
            return false;
        }
        TemplateConfigModel templateConfig = appModel.getAppInfoModel() != null ? appModel.getAppInfoModel().getTemplateConfig() : null;
        String appId = appModel.getAppId();
        String templateId = templateConfig != null ? templateConfig.getTemplateId() : "";
        JSONArray arrayConfigReturnNoNullArray = getArrayConfigReturnNoNullArray("ta_nsrWhiteList");
        JSONArray arrayConfigReturnNoNullArray2 = getArrayConfigReturnNoNullArray("ta_nsrWhiteListTemplateId");
        if (arrayConfigReturnNoNullArray == null || !arrayConfigReturnNoNullArray.contains(appId)) {
            return arrayConfigReturnNoNullArray2 != null && arrayConfigReturnNoNullArray2.contains(templateId);
        }
        return true;
    }

    public static boolean enableNSRRenderPreload() {
        if (TROrangeController.isBadBucket()) {
            return false;
        }
        return NativeSwitchController.isEnableNative() ? NativeSwitchController.enableNSRPreload() : getBooleanConfig("enableNSRRenderPreload", Boolean.TRUE);
    }

    public static boolean enableOfficialPluginPreload() {
        if (TROrangeController.isBadBucket()) {
            return false;
        }
        return getBooleanConfig("openOfficialPluginPreload", Boolean.TRUE);
    }

    public static boolean enablePluginResourceCheck() {
        return getBooleanConfig("enablePluginResourceCheck", Boolean.TRUE);
    }

    public static boolean enableShopFetchSendShopNavi() {
        try {
            return getBooleanConfig("enableShopFetchSendShopNavi", Boolean.TRUE);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return true;
        }
    }

    public static boolean enableShopIndexJsPreExe() {
        if (TROrangeController.isBadBucket()) {
            return false;
        }
        return NativeSwitchController.isEnableNative() ? NativeSwitchController.enableIndexJsPreExecute() : getBooleanConfig("enableShopIndexJsPreExe", Boolean.FALSE);
    }

    public static boolean enableShopPkgPreload() {
        try {
            return getBooleanConfig("enableShopPkgPreload", Boolean.TRUE);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return true;
        }
    }

    public static boolean enableShopRenderPreload() {
        if (TROrangeController.isBadBucket()) {
            return false;
        }
        return getBooleanConfig("enableShopRenderPreload", Boolean.TRUE);
    }

    public static boolean enableShopWorkerPreload() {
        if (TROrangeController.isBadBucket()) {
            return false;
        }
        return NativeSwitchController.isEnableNative() ? NativeSwitchController.enableShopWorkerPreload() : getBooleanConfig("enableShopWorkerPreload", Boolean.TRUE);
    }

    public static boolean enableSnapshotRenderPreload() {
        if (TROrangeController.isBadBucket()) {
            return false;
        }
        return getBooleanConfig("enableSnapshotRenderPreload", Boolean.TRUE);
    }

    public static boolean enableTemplateJs() {
        if (TROrangeController.isBadBucket()) {
            return false;
        }
        return getBooleanConfig("openTemplateJs", Boolean.TRUE);
    }

    public static boolean enableWorkerOfficialPluginPreload() {
        if (TROrangeController.isBadBucket()) {
            return false;
        }
        return NativeSwitchController.isEnableNative() ? NativeSwitchController.enableShopWorkerPreloadOfficialPlugin() : getBooleanConfig("enableWorkerOfficialPluginPreload", Boolean.TRUE);
    }

    public static boolean enablepreShopFetchAndWeexViewSnapshot() {
        try {
            return getBooleanConfig("enablepreShopFetchAndWeexViewSnapshot", Boolean.TRUE);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return true;
        }
    }

    @NonNull
    private static JSONArray getArrayConfigReturnNoNullArray(String str) {
        JSONArray array;
        try {
            array = JSON.parseArray(getConfig(str, ""));
        } catch (Exception e) {
            e.printStackTrace();
            array = null;
        }
        return ifArrayNullReturnEmptyArray(array);
    }

    private static boolean getBooleanConfig(String str, @NonNull Boolean bool) {
        try {
            return Boolean.parseBoolean(getConfig(str, bool.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return bool.booleanValue();
        }
    }

    private static String getConfig(String str, String str2) {
        try {
            return ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroupAndName(SHOP_CONFIG_GROUP, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String getDowngradeShopUrl() {
        try {
            return getConfig("downgradeShopUrl", TRiverConstants.DOWNGRADE_WEEX_SHOP_ROOT_URL);
        } catch (Exception e) {
            e.printStackTrace();
            return TRiverConstants.DOWNGRADE_WEEX_SHOP_ROOT_URL;
        }
    }

    private static int getIntConfig(String str, @NonNull Integer num) {
        int iIntValue = num.intValue();
        try {
            return Integer.parseInt(getConfig(str, num.toString()), 10);
        } catch (Exception e) {
            e.printStackTrace();
            return iIntValue;
        }
    }

    @NonNull
    private static JSONObject getJSONObjectConfig(String str) {
        JSONObject object;
        try {
            object = JSON.parseObject(getConfig(str, ""));
        } catch (Exception e) {
            e.printStackTrace();
            object = null;
        }
        return ifObjectNullReturnEmptyObject(object);
    }

    private static long getLongConfig(String str, @NonNull Long l) {
        long jLongValue = l.longValue();
        try {
            return Long.parseLong(getConfig(str, l.toString()), 10);
        } catch (Exception e) {
            e.printStackTrace();
            return jLongValue;
        }
    }

    public static int getResourceTimeOutDowngradeWeexShopDuration(int i) {
        int iIntValue = Integer.valueOf(TRiverConstants.DOWNGRADE_WEEX_SHOP_DURATION_RESOURCE_TIMEOUT.split(WVNativeCallbackUtil.SEPERATER)[i]).intValue();
        try {
            return Integer.valueOf(getConfig("downgradeWeexShopDurationResourceTimeout", TRiverConstants.DOWNGRADE_WEEX_SHOP_DURATION_RESOURCE_TIMEOUT).split(WVNativeCallbackUtil.SEPERATER)[i]).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return iIntValue;
        }
    }

    public static int getRuntimeTimeOutDowngradeWeexShopDuration(int i) {
        int iIntValue = Integer.valueOf(TRiverConstants.DOWNGRADE_WEEX_SHOP_DURATION_RUNTIME_TIMEOUT.split(WVNativeCallbackUtil.SEPERATER)[i]).intValue();
        try {
            return Integer.valueOf(getConfig("downgradeWeexShopDurationRuntimeTimeout", TRiverConstants.DOWNGRADE_WEEX_SHOP_DURATION_RUNTIME_TIMEOUT).split(WVNativeCallbackUtil.SEPERATER)[i]).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return iIntValue;
        }
    }

    public static int getShopFetchCacheTimeByMinute() {
        if (TROrangeController.isBadBucket()) {
            return 0;
        }
        try {
            int intConfig = getIntConfig("shopFetchCacheTime", 4320);
            if (intConfig >= 0) {
                return intConfig;
            }
            return 4320;
        } catch (Exception e) {
            e.printStackTrace();
            return 4320;
        }
    }

    public static int getShopPageDataAndWeexModuleCacheTimeByMinute() {
        if (TROrangeController.isBadBucket()) {
            return 0;
        }
        try {
            int intConfig = getIntConfig("shopPageDataAndWeexModuleCacheTime", 10);
            if (intConfig >= 0) {
                return intConfig;
            }
            return 10;
        } catch (Exception e) {
            e.printStackTrace();
            return 10;
        }
    }

    public static JSONArray getShopPkgPreloadList() {
        return getArrayConfigReturnNoNullArray("shopPkgPreloadList");
    }

    public static JSONObject getShopTemplateConfig() {
        try {
            return getJSONObjectConfig("shopTemplateConfig");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONArray getShopUrlHashParam() {
        return getArrayConfigReturnNoNullArray("shopUrlHashParam");
    }

    public static JSONArray getShopWeexPreloadShopNaviList() {
        if (TROrangeController.isBadBucket()) {
            return new JSONArray();
        }
        JSONArray arrayConfigReturnNoNullArray = getArrayConfigReturnNoNullArray("ShopWeexPreloadShopNaviList");
        if (arrayConfigReturnNoNullArray.isEmpty()) {
            arrayConfigReturnNoNullArray.add("shopindex");
            arrayConfigReturnNoNullArray.add("allitems");
        }
        return arrayConfigReturnNoNullArray;
    }

    public static JSONArray getTemplatePreloadPluginList() {
        if (TROrangeController.isBadBucket()) {
            return new JSONArray();
        }
        JSONObject shopTemplateConfig = getShopTemplateConfig();
        if (shopTemplateConfig == null) {
            return null;
        }
        return shopTemplateConfig.getJSONArray("preloadPlugin");
    }

    public static int getTemplateShopFetchRetryCount() {
        return getIntConfig("shopFetchRetryCount", 26);
    }

    @NonNull
    private static JSONArray ifArrayNullReturnEmptyArray(JSONArray jSONArray) {
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    @NonNull
    private static JSONObject ifObjectNullReturnEmptyObject(JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    public static boolean isComponentJsPreRelease() {
        try {
            return getBooleanConfig("isComponentJsPreRelease", Boolean.FALSE);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return false;
        }
    }

    public static boolean openMtopShopFetchCache() {
        if (TROrangeController.isBadBucket()) {
            return false;
        }
        return getBooleanConfig("openMtopShopFetchCache", Boolean.TRUE);
    }

    public static boolean openShopSingleInstance() {
        try {
            return getBooleanConfig("openShopSingleInstance", Boolean.TRUE);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return true;
        }
    }

    public static int shopBackWaitTime() {
        if (TROrangeController.isBadBucket()) {
            return 0;
        }
        try {
            return getIntConfig("shopBackWaitTime", 2000);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return 2000;
        }
    }

    public static boolean shopCanDowngrade() {
        if (TROrangeController.isBadBucket()) {
            return false;
        }
        try {
            return getBooleanConfig("shopCanDowngrade", Boolean.TRUE);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return true;
        }
    }

    public static boolean shopForceUseJSI(App app) {
        if (TRiverUrlUtils.isShop(app)) {
            return getBooleanConfig("shopForceUseJSI", Boolean.TRUE);
        }
        return false;
    }
}
