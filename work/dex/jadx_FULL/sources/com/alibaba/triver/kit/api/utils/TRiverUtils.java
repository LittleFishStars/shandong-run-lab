package com.alibaba.triver.kit.api.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarItemModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.ContainerModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.igexin.assist.sdk.AssistPushConsts;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRiverUtils {
    public static void alertInDebug(final Activity activity, final String str, final String str2) {
        Application applicationContext;
        RVExecutorService rVExecutorService;
        Executor executor;
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null || (applicationContext = rVEnvironmentService.getApplicationContext()) == null || !CommonUtils.isApkDebug(applicationContext) || (rVExecutorService = (RVExecutorService) RVProxy.get(RVExecutorService.class)) == null || (executor = rVExecutorService.getExecutor(ExecutorType.UI)) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: com.alibaba.triver.kit.api.utils.TRiverUtils.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    new AlertDialog.Builder(activity).setMessage(str).setTitle(str2).setCancelable(true).create().show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static boolean canGoBack(Page page) {
        return (page == null || page.getApp() == null || page.getApp().getIndexOfChild(page) <= 0) ? false : true;
    }

    public static String getAboutUrl() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.ORANGE_GROUP_WINDMILL_COMMON);
        return (configsByGroup == null || TextUtils.isEmpty(configsByGroup.get(TRiverConstants.ORANGE_KEY_WINDMILL_ABOUT_URL_FOR_WEB))) ? "http://market.m.taobao.com/app/mtb/taobao-app-more/pages/about" : configsByGroup.get(TRiverConstants.ORANGE_KEY_WINDMILL_ABOUT_URL_FOR_WEB);
    }

    public static App getAppByNode(Node node) {
        try {
            if (node instanceof App) {
                return (App) node;
            }
            if (node instanceof Page) {
                return ((Page) node).getApp();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAppId(Uri uri) {
        if (uri.isHierarchical()) {
            return uri.getQueryParameter(TRiverConstants.KEY_APP_ID);
        }
        return null;
    }

    public static JSONObject getAppLaunchParams(App app) {
        AppConfigModel appConfigModel;
        if (app == null || (appConfigModel = (AppConfigModel) app.getData(AppConfigModel.class)) == null) {
            return null;
        }
        return appConfigModel.getAppLaunchParams();
    }

    public static String getAppTemplateId(App app) {
        AppModel appModel;
        TemplateConfigModel templateConfig;
        if (app == null || (appModel = (AppModel) app.getData(AppModel.class)) == null || (templateConfig = appModel.getAppInfoModel().getTemplateConfig()) == null) {
            return null;
        }
        return templateConfig.getTemplateId();
    }

    public static Context getApplicationContextNullable() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            return null;
        }
        return rVEnvironmentService.getApplicationContext();
    }

    public static String getAuthUrl() {
        return "trvNative://authorize/settings";
    }

    public static String getAuthUrl(String str) {
        return Uri.parse("https://m.duanqu.com").buildUpon().appendQueryParameter(TRiverConstants.KEY_APP_ID, str).appendQueryParameter("page", getAuthUrl()).build().toString();
    }

    public static boolean getBooleanConfigFromAppJSON(String str, boolean z, App app) {
        JSONObject appLaunchParams = getAppLaunchParams(app);
        if (appLaunchParams == null) {
            return z;
        }
        try {
            return appLaunchParams.getBoolean(str).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public static long getLongConfigFromAppJSON(String str, long j, App app) {
        JSONObject appLaunchParams = getAppLaunchParams(app);
        if (appLaunchParams == null) {
            return j;
        }
        try {
            return appLaunchParams.getLong(str).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static PluginModel getPluginModelByPluginId(App app, String str) {
        AppModel appModel;
        AppInfoModel appInfoModel;
        List<PluginModel> plugins;
        List<PluginModel> pluginModels;
        if (app == null || str == null || (appModel = (AppModel) app.getData(AppModel.class)) == null || (appInfoModel = appModel.getAppInfoModel()) == null || (plugins = appInfoModel.getPlugins()) == null) {
            return null;
        }
        for (PluginModel pluginModel : plugins) {
            if (str.equals(pluginModel.getAppId())) {
                return pluginModel;
            }
        }
        DynamicPluginInfo dynamicPluginInfo = (DynamicPluginInfo) app.getData(DynamicPluginInfo.class);
        if (dynamicPluginInfo == null || (pluginModels = dynamicPluginInfo.getPluginModels()) == null) {
            return null;
        }
        for (PluginModel pluginModel2 : pluginModels) {
            if (str.equals(pluginModel2.getAppId())) {
                return pluginModel2;
            }
        }
        return null;
    }

    public static JSONObject getPluginZCacheInfoFromApp(App app, String str) {
        AppModel appModel;
        AppInfoModel appInfoModel;
        List<PluginModel> plugins;
        if (app == null || str == null || (appModel = (AppModel) app.getData(AppModel.class)) == null || (appInfoModel = appModel.getAppInfoModel()) == null || (plugins = appInfoModel.getPlugins()) == null) {
            return null;
        }
        for (PluginModel pluginModel : plugins) {
            if (str.equals(pluginModel.getAppId())) {
                JSONObject extendInfo = pluginModel.getExtendInfo();
                if (extendInfo == null) {
                    return null;
                }
                return extendInfo.getJSONObject("cacheInfo");
            }
        }
        return null;
    }

    public static String getSessionId(Bundle bundle) {
        return bundle != null ? bundle.getString(RVParams.SESSION_ID) : "";
    }

    public static int getShopBucket(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return JSON.parseObject(str).getJSONObject("data").getJSONObject("components").getJSONObject("header_4").getJSONObject(AssistPushConsts.MSG_TYPE_PAYLOAD).getIntValue("bucket");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getStringConfigFromAppJSON(String str, String str2, App app) {
        JSONObject appLaunchParams = getAppLaunchParams(app);
        if (appLaunchParams == null) {
            return null;
        }
        try {
            return appLaunchParams.getString(str);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String getStringMD5(String str) {
        return com.alibaba.ariver.kernel.common.utils.FileUtils.getMD5(str);
    }

    public static String getWmlCode(Uri uri) {
        if (uri.isHierarchical()) {
            return uri.getQueryParameter("_wml_code");
        }
        return null;
    }

    public static boolean isARProcess() {
        String processName = ProcessUtils.getProcessName();
        return processName != null && processName.endsWith("wml5");
    }

    public static boolean isAboutPage(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return getAboutUrl().contains(Uri.parse(str).buildUpon().clearQuery().build().toString());
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isAuthPage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(getAuthUrl()) || TextUtils.equals(getAuthUrl(), UrlUtils.getHash(str));
    }

    public static boolean isBadShopBucket() {
        return TROrangeController.isBadBucket();
    }

    public static boolean isCanalApp(App app) {
        if (app == null) {
            return false;
        }
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        return TextUtils.equals((appModel == null || appModel.getExtendInfos() == null) ? null : appModel.getExtendInfos().getString("bizType"), "10");
    }

    public static boolean isDebugControlPanelApp(App app) {
        if (app == null) {
            return false;
        }
        return "68687029".equals(app.getAppId());
    }

    public static boolean isFastMode(App app) {
        Bundle startParams;
        if (app == null || (startParams = app.getStartParams()) == null) {
            return false;
        }
        if (startParams.containsKey("fastMode")) {
            return startParams.getBoolean("fastMode");
        }
        Map<String, String> allUrlParam = TRiverUrlUtils.getAllUrlParam(app);
        if (allUrlParam == null) {
            startParams.putBoolean("fastMode", false);
            return false;
        }
        if (!allUrlParam.containsKey("fastMode")) {
            startParams.putBoolean("fastMode", false);
            return false;
        }
        String str = allUrlParam.get("fastMode");
        startParams.putBoolean("fastMode", "true".equals(str));
        return "true".equals(str);
    }

    public static boolean isFirstPage(AppConfigModel appConfigModel, String str) {
        if (appConfigModel == null || appConfigModel.getPages() == null || appConfigModel.getPages().get(0) == null) {
            return false;
        }
        return appConfigModel.getPages().get(0).equals(UrlUtils.getHash(str));
    }

    public static boolean isFirstTab(TabBarModel tabBarModel, String str) {
        TabBarItemModel tabBarItemModel;
        return (tabBarModel == null || tabBarModel.getItems() == null || (tabBarItemModel = tabBarModel.getItems().get(0)) == null || tabBarItemModel.getUrl() == null || !UrlUtils.getHash(tabBarItemModel.getUrl()).equals(UrlUtils.getHash(str))) ? false : true;
    }

    public static boolean isHomePage(Page page) {
        if (page == null || page.getApp() == null) {
            return true;
        }
        if (page.getApp().getAppContext() == null || page.getApp().getAppContext().getTabBar() == null || !page.getApp().getAppContext().getTabBar().isTabPage(page)) {
            return isFirstPage((AppConfigModel) page.getApp().getData(AppConfigModel.class), page.getPageURI()) && !canGoBack(page);
        }
        return true;
    }

    public static boolean isMainProcess() {
        return TextUtils.equals(ProcessUtils.getProcessName(), ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getPackageName());
    }

    public static boolean isOpenPerfLog(Uri uri) {
        if (uri != null && uri.isHierarchical() && uri.toString().contains("openPerfLog")) {
            return uri.getBooleanQueryParameter("openPerfLog", false);
        }
        return false;
    }

    public static boolean isOutLink(Uri uri) {
        return uri != null && uri.isHierarchical() && TextUtils.equals(uri.getQueryParameter("_afc_link"), "1");
    }

    public static boolean isPluginInvokeThisApi(String str) {
        return (TextUtils.isEmpty(str) || NativeCallContext.DOMAIN_APP.equals(str) || NativeCallContext.DOMAIN_APPX.equals(str)) ? false : true;
    }

    public static boolean isSecondPartyPlugin(PluginModel pluginModel) {
        return pluginModel != null && pluginModel.getPermission() == null;
    }

    public static boolean isStartPage(Page page) {
        try {
            String queryParameter = Uri.parse(page.getApp().getStartParams().getString(TRiverConstants.KEY_ORI_URL)).getQueryParameter("page");
            return !TextUtils.isEmpty(queryParameter) && TextUtils.equals(pageNameFilter(queryParameter), pageNameFilter(UrlUtils.getHash(page.getPageURI())));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isTaobaoApp() {
        String processName = ProcessUtils.getProcessName();
        return processName != null && processName.startsWith(AlibcProtocolConstant.APPLINK_PACKAGE_NAME);
    }

    public static boolean isTriverUrl(Uri uri) {
        return !TextUtils.isEmpty(getAppId(uri));
    }

    public static boolean isUrlInPreloadConfig(App app, String str) {
        AppModel appModel;
        ContainerModel containerInfo;
        JSONObject launchParams;
        JSONArray jSONArray;
        JSONObject jSONObject;
        if (app == null || str == null || (appModel = (AppModel) app.getData(AppModel.class)) == null || (containerInfo = appModel.getContainerInfo()) == null || (launchParams = containerInfo.getLaunchParams()) == null || (jSONArray = launchParams.getJSONArray("preloadConfig")) == null) {
            return false;
        }
        for (Object obj : jSONArray) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) obj;
                if ("http".equals(jSONObject2.getString("type")) && (jSONObject = jSONObject2.getJSONObject("params")) != null && str.equals(jSONObject.getString("url"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWindmillUrl(Uri uri) {
        return !TextUtils.isEmpty(getWmlCode(uri));
    }

    public static boolean needAuthentication(App app) {
        if (app == null) {
            return false;
        }
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        return appModel == null || appModel.getPermissionModel() != null;
    }

    public static String pageNameFilter(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri uriBuild = Uri.parse(str);
        String query = uriBuild.getQuery();
        String scheme = uriBuild.getScheme();
        if (!TextUtils.isEmpty(query)) {
            uriBuild = uriBuild.buildUpon().clearQuery().build();
            str = uriBuild.toString();
        }
        return (TextUtils.isEmpty(scheme) || "plugin".equals(scheme)) ? str : uriBuild.buildUpon().scheme("").build().toString().replaceFirst("://", "").replaceFirst(":/", "");
    }

    public static void toastInDebug(final String str) {
        final Application applicationContext;
        RVExecutorService rVExecutorService;
        Executor executor;
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null || (applicationContext = rVEnvironmentService.getApplicationContext()) == null || !CommonUtils.isApkDebug(applicationContext) || (rVExecutorService = (RVExecutorService) RVProxy.get(RVExecutorService.class)) == null || (executor = rVExecutorService.getExecutor(ExecutorType.UI)) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: com.alibaba.triver.kit.api.utils.TRiverUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Toast.makeText(applicationContext, str + "", 0).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static boolean verifyAppXResource(ResourcePackage resourcePackage, String str) {
        if (resourcePackage == null) {
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog(str, "resourcePkg = " + resourcePackage + " , resource pkg is null");
            return false;
        }
        Set<String> setKeySet = resourcePackage.keySet();
        if (setKeySet == null) {
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog(str, "resourcePkg = " + resourcePackage + " , resource pkg has no resource");
            return false;
        }
        for (String str2 : setKeySet) {
            Resource resource = resourcePackage.get(new ResourceQuery(str2));
            if (resource == null) {
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog(str, "resourcePkg = " + resourcePackage + " , is empty , cancel preload.");
                return false;
            }
            byte[] bytes = resource.getBytes();
            if (bytes == null || bytes.length < 100) {
                IPerformanceAndErrorTracker iPerformanceAndErrorTracker = (IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class);
                StringBuilder sb = new StringBuilder();
                sb.append("resource = ");
                sb.append(str2);
                sb.append(" , is not Ok , cancel preload , size = ");
                sb.append(bytes == null ? null : Integer.valueOf(bytes.length));
                iPerformanceAndErrorTracker.sendPerfStageLog(str, sb.toString());
                return false;
            }
        }
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog(str, "resourcePkg = " + resourcePackage + " , is Ok");
        return true;
    }

    public static String getSessionId(App app) {
        Bundle startParams;
        return (app == null || (startParams = app.getStartParams()) == null) ? "" : startParams.getString(RVParams.SESSION_ID);
    }

    public static boolean needAuthentication(Page page) {
        if (page == null) {
            return false;
        }
        return needAuthentication(page.getApp());
    }

    public static String getSessionId(Page page) {
        Bundle startParams;
        return (page == null || page.getApp() == null || (startParams = page.getApp().getStartParams()) == null) ? "" : startParams.getString(RVParams.SESSION_ID);
    }

    public static boolean isFirstTab(Page page) {
        if (page == null || page.getApp() == null) {
            return false;
        }
        if (page.getApp().getAppContext() != null && page.getApp().getAppContext().getTabBar() != null) {
            return isFirstTab(page.getApp().getAppContext().getTabBar().getTabbarModel(), page.getPageURI());
        }
        return isHomePage(page);
    }

    public static boolean isFastMode(Page page) {
        if (page == null) {
            return false;
        }
        return isFastMode(page.getApp());
    }
}
