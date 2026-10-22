package com.alibaba.triver.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.core.AppInfoCenterInternal;
import com.alibaba.triver.appinfo.core.AppInfoStrategy;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.TinyApp;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.error.TriverErrors;
import com.alibaba.triver.kit.api.model.FrameType;
import com.alibaba.triver.kit.api.model.WindowInfoModel;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IABTestProxy;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.kit.api.proxy.ITriverToolsProxy;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.ut.mini.UTAnalytics;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CommonUtils {
    private static final String MTOP_ERROR = "ANDROID_SYS";
    private static final String TAG = "TriverCommonUtils";
    private static float density = -1.0f;

    public enum DeviceLevel {
        Level0,
        Level1,
        Level2,
        Level3,
        Level4,
        Level5,
        UNKNOWN
    }

    public static String MD5(String str) {
        try {
            return toHex(MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String appInfoPreload() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        return configsByGroup != null ? configsByGroup.get("appinfoPreloadList") : "";
    }

    public static void changeAppInfoVHost(AppInfoModel appInfoModel) {
        if (appInfoModel != null) {
            if (TROrangeController.enableRenderPreload(appInfoModel.getAppId(), appInfoModel.getTemplateConfig() != null ? appInfoModel.getTemplateConfig().getTemplateId() : null)) {
                Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
                if (configsByGroup == null || !"true".equals(configsByGroup.get("closeChangeVHost"))) {
                    appInfoModel.setVhost(TROrangeController.RENDER_PRELOAD_V_HOST);
                }
            }
        }
    }

    public static boolean checkIsBase64(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Pattern.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$", str);
        } catch (Exception e) {
            RVLogger.e(TAG, e);
            return false;
        }
    }

    public static boolean closeAlive() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return true;
        }
        String str = configsByGroup.get(TRiverConstants.KEY_TRIVER_CLOSE_ALIVE);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return "true".equals(str);
    }

    public static boolean closeAnalyzerTools() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get("closeAnalyzerTools");
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Boolean.parseBoolean(str);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "closeAnalyzerTools error", e);
                }
            }
        }
        return false;
    }

    public static boolean closeAppInfoManagerDeepClone() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeAppInfoManagerDeepClone");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean closeAppInfoPreload() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeAppInfoPreload");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean closeAppInfoRouter() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeAppInfoRouter");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean closeAppxForceUndate() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeAppxForceUndate");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean closeAppxForceUndateError() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeAppxForceUndateError");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean closeAppxPreload() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            return "true".equals(configsByGroup.get("closeAppxPreload"));
        }
        return false;
    }

    public static boolean closeClearCacheByUrl() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            return "true".equals(configsByGroup.get("closeClearCacheByUrl"));
        }
        return false;
    }

    public static boolean closeCollectTransferFollowBar() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get("closeCollectTransferFollowBar");
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Boolean.parseBoolean(str);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "closeCollectTransferFollowBar error", e);
                }
            }
        }
        return false;
    }

    public static boolean closeDetailRecentApp() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeDetailRecentApp");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean closeHideAppLoading() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return true;
        }
        String str = configsByGroup.get("closeHideAppLoading");
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return Boolean.parseBoolean(str);
        } catch (Exception e) {
            RVLogger.e(TRiverConstants.TAG, "closeHideAppLoading error", e);
            return true;
        }
    }

    public static boolean closeMenuAuthSettingEntrance() {
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            if (configsByGroup == null) {
                return false;
            }
            String str = configsByGroup.get("closeMenuAuthSettingEntrance");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Boolean.parseBoolean(str);
        } catch (Exception e) {
            RVLogger.e(TRiverConstants.TAG, "closeMenuAuthSettingEntrance error ", e);
            return false;
        }
    }

    public static boolean closeMiaoBiLogic() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get("closeMiaoBiLogic");
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Boolean.parseBoolean(str);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "closeMiaoBiLogic error", e);
                }
            }
        }
        return true;
    }

    public static boolean closeOfflineOpen() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            return "true".equals(configsByGroup.get("closeOfflineOpen"));
        }
        return false;
    }

    public static boolean closePreloadBrandZone() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            return "true".equals(configsByGroup.get("closePreloadBrandZone"));
        }
        return false;
    }

    public static boolean closePreventBackPressInLoading() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return true;
        }
        String str = configsByGroup.get("closePreventBackPressInLoading");
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return "true".equals(str);
    }

    public static boolean closeRemoteLogWhite() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get("closeRemoteLogWhite");
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Boolean.parseBoolean(str);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "closeRemoteLogWhite error", e);
                }
            }
        }
        return false;
    }

    public static boolean closeSuperSplash() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            return "true".equals(configsByGroup.get("closeSuperSplash"));
        }
        return false;
    }

    public static boolean closeToolsInRelease() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get("closeToolsInRelease");
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Boolean.parseBoolean(str);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "closeToolsInRelease error", e);
                }
            }
        }
        return true;
    }

    private static Boolean convertBoolean(Bundle bundle, String str, Boolean bool) {
        Object obj = bundle.get(str);
        if (obj != null) {
            return AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(obj.toString()) ? Boolean.FALSE : Boolean.valueOf("true".equals(obj.toString()));
        }
        return bool;
    }

    private static String convertColor(Bundle bundle, String str) {
        try {
            String string = bundle.getString(str);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            return (BundleUtils.getInt(bundle, str) | (-16777216)) + "";
        } catch (Exception e) {
            RVLogger.e("Triver:CommonUtils", "color convert error", e);
            return null;
        }
    }

    public static WindowInfoModel convertWindowModel(Bundle bundle) {
        WindowInfoModel windowInfoModel = new WindowInfoModel();
        if (bundle != null) {
            if (bundle.containsKey(RVParams.LONG_TITLE_BAR_COLOR)) {
                windowInfoModel.titleBarColor = convertColor(bundle, RVParams.LONG_TITLE_BAR_COLOR);
            } else {
                windowInfoModel.titleBarColor = null;
            }
            windowInfoModel.backgroundImageResize = bundle.getString("backgroundImageResize");
            windowInfoModel.backgroundImageUrl = bundle.getString(RVStartParams.KEY_BACKGROUND_IMAGE_URL);
            windowInfoModel.defaultTitle = bundle.getString(RVParams.LONG_DEFAULT_TITLE);
            windowInfoModel.navigationBarBackgroundBg = bundle.getString("navigationBarBackgroundBg");
            windowInfoModel.navigationBarForceEnable = convertBoolean(bundle, "navigationBarForceEnable", Boolean.FALSE).booleanValue();
            windowInfoModel.navigationBarTag = bundle.getString("navigationBarTag");
            windowInfoModel.navigationBarTitleBg = bundle.getString(RVParams.LONG_TITLE_IMAGE);
            windowInfoModel.showNavigationBarLogo = convertBoolean(bundle, "showNavigationBarLogo", null);
            Boolean bool = Boolean.TRUE;
            windowInfoModel.showNavigationBarTitle = convertBoolean(bundle, "showNavigationBarTitle", bool).booleanValue();
            windowInfoModel.showNavigationBar = convertBoolean(bundle, "showNavigationBar", bool).booleanValue();
            String string = bundle.getString(RVParams.PULL_INTERCEPT_DISTANCE);
            if (!TextUtils.isEmpty(string)) {
                try {
                    windowInfoModel.pullInterceptDistance = Integer.parseInt(string);
                } catch (Exception e) {
                    RVLogger.e("Triver:CommonUtils", "convertWindowModel parseInt error", e);
                }
            }
            String string2 = bundle.getString("transparentTitle");
            windowInfoModel.translucent = (TextUtils.isEmpty(string2) || "none".equals(string2)) ? false : true;
            String string3 = bundle.getString("navigationBarTextStyle");
            if ("white".equals(string3)) {
                string3 = "light";
            } else if ("black".equals(string3)) {
                string3 = "dark";
            }
            windowInfoModel.navigationBarTextStyle = string3;
        }
        return windowInfoModel;
    }

    public static boolean disableDetailRecentAppCache() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("disableDetailRecentAppCache");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean downgradePreventCloseChange() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("downgradePreventCloseChange");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean downgradeRecentAppRequest() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("downgradeRecentAppRequest");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static int dp2px(int i) {
        return (int) (getDensity() * i);
    }

    public static boolean enableActivityForRecentApp(String str) {
        JSONObject object;
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            if (configsByGroup == null) {
                return false;
            }
            String str2 = configsByGroup.get("recentAppUrlKeyMap");
            if (TextUtils.isEmpty(str2) || (object = JSON.parseObject(str2)) == null) {
                return false;
            }
            return object.containsKey(str);
        } catch (Exception e) {
            RVLogger.e(TAG, "getKeyFromNameForRecent " + e.getMessage());
            return false;
        }
    }

    public static boolean enableKeepAlive(App app) {
        Object obj;
        if (app.getActivePage() == null || !app.getActivePage().isPageLoaded()) {
            return false;
        }
        Bundle sceneParams = app.getSceneParams();
        Bundle startParams = app.getStartParams();
        return ((sceneParams != null && sceneParams.getBoolean(TRiverConstants.KEY_FORCE_CLOSE_KEEP_ALIVE_WHEN_EXIT, false)) || startParams == null || (obj = startParams.get(RVStartParams.KEY_ENABLE_KEEP_ALIVE)) == null || !"YES".equals(obj.toString()) || closeAlive()) ? false : true;
    }

    public static long getAppInfoPreloadCheckTime() {
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            if (configsByGroup == null) {
                return AppInfoCenterInternal.f24637a;
            }
            String str = configsByGroup.get("appInfoPreloadCheckTime");
            return !TextUtils.isEmpty(str) ? Long.parseLong(str) : AppInfoCenterInternal.f24637a;
        } catch (Exception e) {
            RVLogger.e(TriverLogProxyImpl.TLOG_MODULE, "getAppInfoPreloadCheckTime error", e);
            return AppInfoCenterInternal.f24637a;
        }
    }

    private static Application getApplicationContext() {
        return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
    }

    public static long getCacheClearCheckTime() {
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            if (configsByGroup == null) {
                return 604800L;
            }
            String str = configsByGroup.get("clear_check_time");
            if (TextUtils.isEmpty(str)) {
                return 604800L;
            }
            return Long.parseLong(str);
        } catch (Exception e) {
            RVLogger.e(TriverLogProxyImpl.TLOG_MODULE, "getCacheClearCheckTime error", e);
            return 604800L;
        }
    }

    public static int getDelayTimeSec() {
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            if (configsByGroup == null) {
                return 1;
            }
            String str = configsByGroup.get("appInfoDelayTimeSec");
            if (TextUtils.isEmpty(str)) {
                return 1;
            }
            return Integer.parseInt(str);
        } catch (Exception e) {
            RVLogger.e(TAG, "getDelayTime error ", e);
            return 1;
        }
    }

    private static float getDensity() {
        if (density < 0.0f) {
            density = getApplicationContext().getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static long getKeepAliveSeconds() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get(TRiverConstants.KEY_TRIVER_KEEP_ALIVE_SECONDS);
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Long.parseLong(str);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "getKeepAliveSeconds error", e);
                }
            }
        }
        return 300L;
    }

    public static Pair<String, String> getMyTaoBaoGuideText() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null && !configsByGroup.isEmpty()) {
            try {
                String str = configsByGroup.get(TRiverConstants.ORANGE_KEY_MY_TAOBAO_GUIDE_TEXT);
                if (str == null) {
                    return null;
                }
                String[] strArrSplit = str.split(",");
                return new Pair<>(strArrSplit[0], strArrSplit[1]);
            } catch (Exception e) {
                RVLogger.e(TRiverConstants.TAG, "getSubscriptionGuideText error ", e);
            }
        }
        return null;
    }

    public static String[] getPushWindowParamsFilterList() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return null;
        }
        String str = configsByGroup.get("pushWindowParamsFilterList");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(",");
    }

    public static String getRecentAppMoreUrl() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.ORANGE_GROUP_WINDMILL_COMMON);
        return (configsByGroup == null || TextUtils.isEmpty(configsByGroup.get(TRiverConstants.ORANGE_KEY_WINDMILL_MORE_URL))) ? "https://market.m.taobao.com/app/tb-source-app/miniapp-ground/pages/index2?wh_weex=true" : configsByGroup.get(TRiverConstants.ORANGE_KEY_WINDMILL_MORE_URL);
    }

    public static int getScreenHeight() {
        return getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static Uri getSharedUrl(TinyApp tinyApp, String str, JSONObject jSONObject) {
        Uri.Builder builderPath = Uri.parse(tinyApp.getStartUrl()).buildUpon().authority("m.duanqu.com").path("");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(TRiverConstants.KEY_APP_ID, (Object) tinyApp.getAppId());
        jSONObject2.put("_ariver_ua", (Object) ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("appName"));
        if (!TextUtils.isEmpty(str)) {
            jSONObject2.put("page", (Object) str);
        }
        Uri.Builder builderBuildUpon = com.alibaba.triver.kit.api.utils.CommonUtils.appUrlQuery(builderPath.build(), jSONObject2).buildUpon();
        return jSONObject != null ? com.alibaba.triver.kit.api.utils.CommonUtils.appUrlQuery(builderBuildUpon.build(), jSONObject) : builderBuildUpon.build();
    }

    public static long getShowMiaoBiIntervalSecond() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get("showMiaoBiIntervalSecond");
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Long.parseLong(str);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "showMiaoBiIntervalSecond error", e);
                }
            }
        }
        return -1L;
    }

    public static String getSpm(@Nullable Activity activity, String str) {
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("spm");
            return (!TextUtils.isEmpty(queryParameter) || activity == null) ? queryParameter : UTAnalytics.getInstance().getDefaultTracker().getPageSpmUrl(activity);
        } catch (Throwable th) {
            RVLogger.e(TAG, th);
            return "";
        }
    }

    public static int getStatusBarHeight(Context context) {
        int iDp2px = dp2px(25);
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField(com.gyf.immersionbar.b.f6802a).get(cls.newInstance()).toString()));
        } catch (Exception e) {
            RVLogger.e("CommonUtils", "getStatusBarHeight error", e);
            return iDp2px;
        }
    }

    public static Pair<String, String> getSubscriptionTabGuideText() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null && !configsByGroup.isEmpty()) {
            try {
                String str = configsByGroup.get(TRiverConstants.ORANGE_KEY_SUBSCRIPTION_GUIDE_TEXT);
                if (str == null) {
                    return null;
                }
                String[] strArrSplit = str.split(",");
                return new Pair<>(strArrSplit[0], strArrSplit[1]);
            } catch (Exception e) {
                RVLogger.e(TRiverConstants.TAG, "getSubscriptionGuideText error ", e);
            }
        }
        return null;
    }

    public static String getUrlKeyForRecentApp(String str) {
        JSONObject object;
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            if (configsByGroup == null) {
                return null;
            }
            String str2 = configsByGroup.get("recentAppUrlKeyMapNew");
            if (TextUtils.isEmpty(str2) || (object = JSON.parseObject(str2)) == null) {
                return null;
            }
            return (String) object.get(str);
        } catch (Exception e) {
            RVLogger.e(TAG, "getKeyFromNameForRecent " + e.getMessage());
            return null;
        }
    }

    public static String getVhost(App app) {
        AppModel appModel;
        AppInfoModel appInfoModel;
        if (app == null || (appModel = (AppModel) app.getData(AppModel.class)) == null || (appInfoModel = appModel.getAppInfoModel()) == null) {
            return null;
        }
        return appInfoModel.getVhost();
    }

    public static boolean hasMyTaobaoCard(String str) {
        String str2;
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.ORANGE_GROUP_WINDMILL_COMMON);
        if (configsByGroup != null && !configsByGroup.isEmpty()) {
            try {
                if (!TextUtils.isEmpty(str) && (str2 = configsByGroup.get(TRiverConstants.ORANGE_KEY_WINDMILL_CUSTOM_FIRST_FAVOR_ANIMATION_RES_APPIDS)) != null) {
                    JSONArray array = JSON.parseArray(str2);
                    for (int i = 0; i < array.size(); i++) {
                        if (TextUtils.equals(str, array.getString(i))) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Exception e) {
                RVLogger.e(TRiverConstants.TAG, "hasMyTaobaoCard error ", e);
            }
        }
        return false;
    }

    public static boolean isApkDebug() {
        try {
            Application applicationContext = getApplicationContext();
            return (applicationContext == null || (applicationContext.getApplicationInfo().flags & 2) == 0) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isCatchToolsLogForRelease() {
        if (isApkDebug() || closeToolsInRelease()) {
            return false;
        }
        return ((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).isToolsOpen();
    }

    public static boolean isDownGradeFeedBack() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get("downgradeFeedbackApp");
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Boolean.parseBoolean(str);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "isDownGradeFeedBack error", e);
                }
            }
        }
        return false;
    }

    public static boolean isDowngradePullDownRefresh() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get("downgradePullDownRefresh");
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Boolean.parseBoolean(str);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "isDowngradePullDownRefresh error", e);
                }
            }
        }
        return false;
    }

    public static boolean isInSubscriptionTab(String str) {
        String str2;
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null && !configsByGroup.isEmpty()) {
            try {
                if (!TextUtils.isEmpty(str) && (str2 = configsByGroup.get(TRiverConstants.ORANGE_KEY_SUBSCRIPTION_APPIDS)) != null) {
                    JSONArray array = JSON.parseArray(str2);
                    for (int i = 0; i < array.size(); i++) {
                        if (TextUtils.equals(str, array.getString(i))) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Exception e) {
                RVLogger.e(TRiverConstants.TAG, "isInSubscriptionTab error ", e);
            }
        }
        return false;
    }

    public static boolean isOfficial(AppModel appModel) {
        return (appModel == null || appModel.getAppInfoModel() == null || appModel.getPermissionModel() != null) ? false : true;
    }

    public static boolean isRrenderPreloadVHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(str.trim(), TROrangeController.RENDER_PRELOAD_V_HOST);
    }

    public static boolean isShowDetailRecentApp() {
        try {
            return Boolean.parseBoolean(((IABTestProxy) RVProxy.get(IABTestProxy.class)).getABTestValue("triver", "pubAreaRecentApp", "showDetailRecentApp", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
        } catch (Exception e) {
            RVLogger.e(TAG, e);
            return false;
        }
    }

    public static boolean isShowFlowViewForRelease() {
        if (closeToolsInRelease()) {
            return false;
        }
        return ((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).isToolsOpen();
    }

    public static boolean isShowPubAccountPop() {
        try {
            return Boolean.parseBoolean(((IABTestProxy) RVProxy.get(IABTestProxy.class)).getABTestValue("triver", FrameType.PUBAREA, "showPubAccountPop", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
        } catch (Exception e) {
            RVLogger.e(TAG, e);
            return false;
        }
    }

    public static void monitorApp(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        HashMap map = new HashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("trv_appid", (Object) str3);
        map.put("trv_appid", str3);
        if (!TextUtils.isEmpty(str4)) {
            map.put(TRiverConstants.KEY_SPM_ORIGIN_URL, str4);
        }
        ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).customAdvance(UserTrackConstant.CLICK_EVENT, str, str2, "", "", map, new HashMap());
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackCounter(str, str2, 1, jSONObject.toJSONString());
    }

    public static void monitorPluginModelRequest(String str, String str2, App app, HashMap<String, String> map, PluginModel pluginModel, long j, AppInfoStrategy appInfoStrategy) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pluginId", (Object) str);
        jSONObject.put("pluginVersion", (Object) str2);
        jSONObject.putAll(com.alibaba.triver.kit.api.utils.CommonUtils.getBasicAppMonitorData(app));
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

    public static boolean mtopErrorCheck(String str) {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        String str2 = MTOP_ERROR;
        if (configsByGroup != null && configsByGroup.get("mtopErrorCheck") != null) {
            str2 = configsByGroup.get("mtopErrorCheck");
        }
        for (String str3 : str2.split(",")) {
            if (TriverErrors.isMtopErrorCodeMatch(str, str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean openServerGuideText() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("openServerGuideText");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static int parseColor(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Color.parseColor(str);
            } catch (Exception e) {
                RVLogger.e("", "", e);
            }
        }
        return 0;
    }

    public static int px2dp(int i) {
        return (int) (i / getDensity());
    }

    public static Map<String, String> queryToMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length > 1) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        } catch (Exception e) {
            RVLogger.e("Triver:CommonUtils", "queryToMap error", e);
        }
        return map;
    }

    private static String toHex(byte[] bArr) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(charArray[(bArr[i] >> 4) & 15]);
            sb.append(charArray[bArr[i] & com.google.common.base.a.q]);
        }
        return sb.toString();
    }

    public static boolean unableCloseWindowEventIntercept() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
        if (configsByGroup != null) {
            return "true".equals(configsByGroup.get("unableCloseWindowEventIntercept"));
        }
        return false;
    }

    public static boolean useDeveloperVersionForDB() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get("useDeveloperVersionForDB");
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Boolean.parseBoolean(str);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "useDeveloperVersionForDB error", e);
                }
            }
        }
        return false;
    }

    public static boolean useProxy() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null) {
            return true;
        }
        String str = configsByGroup.get("useAppxProxy");
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return "true".equals(str);
    }

    public static boolean isApkDebug(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getSpm(@Nullable Activity activity, Page page) {
        try {
            String queryParameter = Uri.parse(page.getApp().getStartUrl()).getQueryParameter("spm");
            return (!TextUtils.isEmpty(queryParameter) || activity == null) ? queryParameter : UTAnalytics.getInstance().getDefaultTracker().getPageSpmUrl(activity);
        } catch (Throwable th) {
            RVLogger.e(TAG, th);
            return "";
        }
    }
}
