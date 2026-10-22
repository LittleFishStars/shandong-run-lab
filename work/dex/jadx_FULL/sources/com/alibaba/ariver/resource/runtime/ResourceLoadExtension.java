package com.alibaba.ariver.resource.runtime;

import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppLoadResult;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.point.app.AppCreatePoint;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadInterceptorPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadPoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint;
import com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint;
import com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeDecider;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.AppConfigModelInitPoint;
import com.alibaba.ariver.resource.api.extension.PackageQueryPoint;
import com.alibaba.ariver.resource.api.extension.ResourceInterceptPoint;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.ariver.resource.api.models.TemplateExtModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy;
import com.alibaba.ariver.resource.api.snapshot.ISnapshotProxy;
import com.alibaba.ariver.resource.api.snapshot.RVSnapshotUtils;
import com.alibaba.ariver.resource.api.storage.PluginStore;
import com.alibaba.ariver.resource.api.storage.TabBarDataStorage;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.content.MainResourcePackage;
import com.alibaba.ariver.resource.content.ResourcePackagePool;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class ResourceLoadExtension implements AppCreatePoint, AppDestroyPoint, AppLoadPoint, AppStartPoint, EngineInitSuccessPoint, TabBarInfoQueryPoint, ResourceLoadPoint, NodeAware<App> {
    public static final String APPX_WORKER_JS_URL = "https://appx/af-appx.worker.min.js";
    private static final String TAG = "AriverRes:ResourceLoadExtension";
    private ResourceInterceptPoint mInterceptPoint;
    private App mApp = null;
    private List<ResourcePackage> mLockingPackages = new CopyOnWriteArrayList();
    private ConditionVariable mContentProviderSyncLock = new ConditionVariable();

    private String acquireMainJsUrl(@NonNull Bundle bundle) {
        return FileUtils.combinePath(BundleUtils.getString(bundle, "onlineHost"), BundleUtils.contains(bundle, RVStartParams.KEY_BUNDLE_PATH) ? BundleUtils.getString(bundle, RVStartParams.KEY_BUNDLE_PATH) : "index.bundle.js");
    }

    private void addLauncherParamResourcePackage(final ResourceContext resourceContext) {
        RVLogger.d(TAG, "addLauncherParamResourcePackage for " + resourceContext.getAppId());
        final HashSet hashSet = new HashSet();
        JSONArray array = JSONUtils.parseArray(BundleUtils.getString(resourceContext.getStartParams(), RVStartParams.KEY_ACCPKG_RES));
        if (array != null && array.size() > 0) {
            int size = array.size();
            for (int i = 0; i < size; i++) {
                String string = array.getString(i);
                if (!string.equals(resourceContext.getAppId())) {
                    hashSet.add(string);
                }
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.ariver.resource.runtime.ResourceLoadExtension.2
            @Override // java.lang.Runnable
            public void run() {
                for (String str : hashSet) {
                    if (!RVConstants.TINY_WEB_COMMON_APPID.equalsIgnoreCase(str) && !RVConstants.TINY_APPX_NG_APPID.equalsIgnoreCase(str)) {
                        ResourcePackagePool.getInstance().attach(str, resourceContext);
                    }
                }
            }
        });
    }

    private void fillConfigWithIncludeFile(ResourceContext resourceContext, AppConfigModel appConfigModel) {
        Resource resource;
        ResourcePackage mainPackage = resourceContext.getMainPackage();
        if (mainPackage == null) {
            return;
        }
        String configVariable = ((RVResourceEnviromentProxy) RVProxy.get(RVResourceEnviromentProxy.class)).getConfigVariable();
        RVLogger.d(TAG, "fillConfigWithIncludeFile, configVar: " + configVariable + " includeFiles: " + appConfigModel.getIncludeFiles());
        if (appConfigModel.getIncludeFiles() == null || TextUtils.isEmpty(configVariable)) {
            return;
        }
        String str = "config/" + configVariable + ".json";
        RVLogger.d(TAG, "try fillConfigWithIncludeFile with resource: " + str);
        if (appConfigModel.getIncludeFiles().contains(str) && (resource = mainPackage.get(ResourceQuery.asUrl(str).setNeedAutoCompleteHost())) != null) {
            RVLogger.d(TAG, "try fillConfigWithIncludeFile hit");
            JSONObject object = JSONUtils.parseObject(resource.getBytes());
            JSONObject jSONObject = JSONUtils.getJSONObject(object, "window", null);
            if (jSONObject != null) {
                RVLogger.d(TAG, "try fillConfigWithIncludeFile hit window");
                appConfigModel.setAppLaunchParams(jSONObject);
            }
            JSONArray jSONArray = JSONUtils.getJSONArray(object, "pages", null);
            if (jSONArray != null) {
                RVLogger.d(TAG, "try fillConfigWithIncludeFile hit pages");
                ArrayList arrayList = new ArrayList();
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                appConfigModel.setPages(arrayList);
            }
            JSONObject jSONObject2 = JSONUtils.getJSONObject(object, "extPages", null);
            if (jSONObject2 != null) {
                RVLogger.d(TAG, "try fillConfigWithIncludeFile hit launchParams");
                if (appConfigModel.getPageLaunchParams() == null) {
                    appConfigModel.setPageLaunchParams(jSONObject2);
                } else {
                    appConfigModel.getPageLaunchParams().putAll(jSONObject2);
                }
                appConfigModel.setPageLaunchParams(jSONObject2);
            }
            String string = JSONUtils.getString(object, "tabBar", null);
            Resource resource2 = resourceContext.getMainPackage().get(ResourceQuery.asUrl(RVConstants.FILE_TABBAR).setNeedAutoCompleteHost());
            if (resource2 != null) {
                if (string == null) {
                    resourceContext.getMainPackage().remove(resource2.getUrl());
                } else {
                    RVLogger.d(TAG, "try fillConfigWithIncludeFile hit tabBar");
                    resource2.setBytes(string.getBytes());
                }
            }
        }
    }

    private void fillConfigWithTemplate(AppConfigModel appConfigModel) {
        AppModel appModel = (AppModel) this.mApp.getData(AppModel.class);
        if (appModel == null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getTemplateConfig() == null) {
            return;
        }
        TemplateConfigModel templateConfig = appModel.getAppInfoModel().getTemplateConfig();
        if (!templateConfig.isTemplateValid() || templateConfig.getExtModel() == null) {
            return;
        }
        TemplateExtModel extModel = templateConfig.getExtModel();
        if (extModel.getWindow() != null) {
            if (appConfigModel.getAppLaunchParams() == null) {
                appConfigModel.setAppLaunchParams(extModel.getWindow());
            } else {
                appConfigModel.getAppLaunchParams().putAll(extModel.getWindow());
            }
            if (appConfigModel.getPageLaunchParams() != null) {
                for (String str : appConfigModel.getPageLaunchParams().keySet()) {
                    JSONObject jSONObject = appConfigModel.getPageLaunchParams().getJSONObject(str);
                    if (jSONObject != null) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("window");
                        RVLogger.d(TAG, "fillConfigWithTemplate page " + str + " put ext.window " + extModel.getWindow());
                        jSONObject.putAll(extModel.getWindow());
                        if (jSONObject2 != null) {
                            RVLogger.d(TAG, "fillConfigWithTemplate page " + str + " put page.window " + jSONObject2);
                            jSONObject.putAll(jSONObject2);
                        }
                    }
                }
            }
        }
        if (extModel.getExtPages() != null) {
            if (appConfigModel.getPageLaunchParams() == null) {
                appConfigModel.setPageLaunchParams(extModel.getExtPages());
            } else {
                appConfigModel.getPageLaunchParams().putAll(extModel.getExtPages());
            }
        }
    }

    private byte[] getSnapshotIndex(App app, String str, String str2) {
        byte[] bArrLoadSnapshotFile;
        if (!str.endsWith("index.html")) {
            return null;
        }
        try {
            if (RVSnapshotUtils.isSnapshotEnabled(this.mApp) && (bArrLoadSnapshotFile = RVSnapshotUtils.loadSnapshotFile(this.mApp, str2)) != null) {
                ISnapshotProxy iSnapshotProxy = (ISnapshotProxy) RVProxy.get(ISnapshotProxy.class, true);
                if (iSnapshotProxy != null) {
                    iSnapshotProxy.snapshotHit(this.mApp);
                }
                RVLogger.d(TAG, "snapshot first page using local snapshotFile success! " + app);
                return bArrLoadSnapshotFile;
            }
        } catch (Throwable th) {
            RVLogger.e(TAG, "getSnapshotIndex error!", th);
        }
        return null;
    }

    private String getSnapshotTitleBar(App app, String str, String str2) {
        if (!str.endsWith("index.html")) {
            return null;
        }
        try {
            String strLoadTitleBarSnapshot = RVSnapshotUtils.loadTitleBarSnapshot(app, str2);
            if (!TextUtils.isEmpty(strLoadTitleBarSnapshot)) {
                RVLogger.d(TAG, "SnapshotProvider read titleBar snapshotFile success! " + app);
                return strLoadTitleBarSnapshot;
            }
        } catch (Throwable th) {
            RVLogger.e(TAG, "getSnapshotTitle error!", th);
        }
        return null;
    }

    private void removeInvalidParams(AppConfigModel appConfigModel) {
        if (appConfigModel != null) {
            if (appConfigModel.getAppLaunchParams() != null && appConfigModel.getAppLaunchParams().containsKey("usePresetPopmenu")) {
                appConfigModel.getAppLaunchParams().remove("usePresetPopmenu");
            }
            if (appConfigModel.getPageLaunchParams() == null || !appConfigModel.getPageLaunchParams().containsKey("usePresetPopmenu")) {
                return;
            }
            appConfigModel.getPageLaunchParams().remove("usePresetPopmenu");
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // com.alibaba.ariver.engine.api.resources.ResourceLoadPoint
    public Resource load(ResourceLoadContext resourceLoadContext) {
        Resource content;
        Resource resourceIntercept;
        ResourceContext resourceContext = ResourceContextManager.getInstance().get(this.mApp.getAppId());
        ResourceQuery canUseFallback = ResourceQuery.asUrl(resourceLoadContext.originUrl).setCanUseFallback(resourceLoadContext.canUseFallback);
        boolean zEqualsIgnoreCase = "YES".equalsIgnoreCase(BundleUtils.getString(this.mApp.getStartParams(), RVParams.APPX_ROUTE_FRAMEWORK));
        canUseFallback.setAppxNgRoute(zEqualsIgnoreCase);
        canUseFallback.setMainDoc(resourceLoadContext.isMainDoc);
        RVLogger.d(TAG, "load resource begin: " + resourceLoadContext.originUrl + " appx-ng: " + zEqualsIgnoreCase);
        boolean z = zEqualsIgnoreCase && resourceLoadContext.originUrl.startsWith(a.b);
        if (resourceContext.getContentProvider() != null) {
            content = resourceContext.getContentProvider().getContent(canUseFallback);
        } else if (z) {
            RVLogger.w(TAG, "appx-ng load resource error content provider null!!! Just find for global package! ");
            if (resourceLoadContext.originUrl.startsWith("https://appx/af-appx.worker.min.js")) {
                this.mApp.putBooleanValue("appxRouteWorker", canUseFallback.isAppxNgRoute());
                ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.mApp, "appxRoute", "yes");
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.mApp, TrackId.Stub_JS_WorkerFrameworkStart);
            }
            canUseFallback.pureUrl = canUseFallback.pureUrl.replace(a.b, a.c);
            content = GlobalPackagePool.getInstance().get(canUseFallback);
        } else {
            RVLogger.w(TAG, "load resource error content provider null!!! Just find for global package! ");
            if (resourceLoadContext.originUrl.startsWith("https://appx/af-appx.worker.min.js")) {
                ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.mApp, "appxRoute", "no");
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.mApp, TrackId.Stub_JS_WorkerFrameworkStart);
            }
            content = GlobalPackagePool.getInstance().get(canUseFallback);
        }
        if (content == null || (resourceIntercept = this.mInterceptPoint.intercept(content)) == null) {
            return content;
        }
        RVLogger.w(TAG, "load response " + canUseFallback.pureUrl + " intercepted to " + resourceIntercept);
        return resourceIntercept;
    }

    /* JADX WARN: Code duplicated, block: B:88:0x03ed  */
    @Override // com.alibaba.ariver.app.api.point.app.AppLoadPoint
    public void loadApp(String str, Bundle bundle, Bundle bundle2, AppLoadPoint.LoadResultCallback loadResultCallback) {
        ResourcePackage mainPackage;
        boolean z;
        TemplateExtModel templateExtModel;
        JSONArray jSONArray;
        String strCombinePath;
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_ResourceLoadExtension_loadApp_ + str);
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_ResourceLoadExtension_resourcePrepare_ + str);
        ResourceContext resourceContext = ResourceContextManager.getInstance().get(str);
        AppLoadResult appLoadResult = new AppLoadResult();
        AppModel appModel = (AppModel) BundleUtils.getParcelable(bundle2, "appInfo");
        String string = BundleUtils.getString(bundle, "url");
        if (TextUtils.isEmpty(string) && appModel != null && appModel.getAppInfoModel() != null) {
            string = appModel.getAppInfoModel().getMainUrl();
        }
        RVLogger.d(TAG, "loadApp: " + str + " on resourceContext: " + resourceContext + ", appModel: " + appModel);
        if (appModel == null) {
            RVLogger.d(TAG, "loadApp but not put appModel! get from DB now.");
            appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(str).scene(AppInfoScene.extractScene(bundle)));
            bundle2.putParcelable("appInfo", appModel);
        }
        if (appModel != null) {
            this.mApp.getStartParams().putString("onlineHost", appModel.getAppInfoModel().getVhost());
            appLoadResult.appVersion = appModel.getAppInfoModel().getVersion();
            String string2 = BundleUtils.getString(bundle, "page");
            if (!this.mApp.isTinyApp() || TextUtils.isEmpty(string2)) {
                if (string.startsWith(WVNativeCallbackUtil.SEPERATER)) {
                    strCombinePath = FileUtils.combinePath(appModel.getAppInfoModel().getVhost(), string);
                }
                appLoadResult.mainJsUrl = acquireMainJsUrl(bundle);
                resourceContext.setMainPackageInfo(appModel);
                this.mApp.setData(AppModel.class, appModel);
                this.mApp.setData(ResourceContext.class, resourceContext);
                this.mApp.getStartParams().putString("appVersion", appModel.getAppVersion());
                this.mApp.getStartParams().putString("version", appModel.getAppVersion());
            } else {
                strCombinePath = FileUtils.combinePath(appModel.getAppInfoModel().getVhost(), "index.html#" + string2);
            }
            string = strCombinePath;
            appLoadResult.mainJsUrl = acquireMainJsUrl(bundle);
            resourceContext.setMainPackageInfo(appModel);
            this.mApp.setData(AppModel.class, appModel);
            this.mApp.setData(ResourceContext.class, resourceContext);
            this.mApp.getStartParams().putString("appVersion", appModel.getAppVersion());
            this.mApp.getStartParams().putString("version", appModel.getAppVersion());
        }
        resourceContext.appType = this.mApp.getAppType();
        appLoadResult.appType = this.mApp.getAppType();
        AppLoadInterceptorPoint appLoadInterceptorPoint = (AppLoadInterceptorPoint) ExtensionPoint.as(AppLoadInterceptorPoint.class).node(this.mApp).create();
        if (appLoadInterceptorPoint != null) {
            appLoadInterceptorPoint.intercept(str, bundle, bundle2, appLoadResult);
        }
        appLoadResult.mainHtmlUrl = string;
        this.mApp.getStartParams().putString("url", appLoadResult.mainHtmlUrl);
        PackageQueryPoint packageQueryPoint = (PackageQueryPoint) ExtensionPoint.as(PackageQueryPoint.class).node(this.mApp).create();
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_ResourceLoadExtension_loadMainResource_ + str);
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.mApp, TrackId.Stub_LoadMainResource_Begin);
        if (appModel != null) {
            mainPackage = packageQueryPoint.getMainPackage(resourceContext);
            if (mainPackage == null) {
                mainPackage = new MainResourcePackage(resourceContext);
            }
            mainPackage.setup(false);
            if (mainPackage.needWaitForSetup()) {
                this.mLockingPackages.add(mainPackage);
            }
            resourceContext.setMainPackage(mainPackage);
        } else {
            mainPackage = null;
        }
        RVTraceUtils.traceEndSection(RVTraceKey.RV_ResourceLoadExtension_loadMainResource_ + str);
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.mApp, TrackId.Stub_LoadMainResource_End);
        Set<ResourcePackage> resourcePackages = packageQueryPoint.getResourcePackages(resourceContext);
        if (resourcePackages != null) {
            for (ResourcePackage resourcePackage : resourcePackages) {
                ResourcePackagePool.getInstance().attach(resourcePackage);
                if (resourcePackage.needWaitForSetup()) {
                    this.mLockingPackages.add(resourcePackage);
                }
                resourceContext.attachResourcePackage(resourcePackage.appId());
            }
        }
        if (appModel != null && appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getPlugins() != null) {
            List<PluginModel> plugins = appModel.getAppInfoModel().getPlugins();
            ArrayList<String> arrayList = new ArrayList<>();
            for (PluginModel pluginModel : plugins) {
                RVLogger.d(TAG, "attach plugin model package: " + pluginModel);
                ResourcePackage resourcePackageCreatePluginPackage = packageQueryPoint.createPluginPackage(pluginModel, resourceContext);
                resourcePackageCreatePluginPackage.setup(false);
                resourceContext.addPackage(resourcePackageCreatePluginPackage);
                arrayList.add(pluginModel.getAppId());
            }
            this.mApp.getStartParams().putStringArrayList(RVStartParams.KEY_APPX_PLUGINS, arrayList);
            ((PluginStore) this.mApp.getData(PluginStore.class, true)).batchPutStaticPluginModel(appModel);
        }
        resourceContext.setContentProvider(new a(resourceContext));
        RVLogger.d(TAG, "ContentProvider is ready");
        this.mContentProviderSyncLock.open();
        if (this.mApp.isTinyApp() && mainPackage != null) {
            if (mainPackage.needWaitForSetup()) {
                mainPackage.waitForSetup();
            }
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_ResourceLoadExtension_getAppConfig_ + str);
            Resource resource = mainPackage.get(ResourceQuery.asUrl(RVConstants.FILE_APP_CONFIG).setLanguageAware(true).setNeedAutoCompleteHost());
            RVTraceUtils.traceEndSection(RVTraceKey.RV_ResourceLoadExtension_getAppConfig_ + str);
            if (resource != null) {
                AppConfigModel fromJSON = AppConfigModel.parseFromJSON(resource.getBytes());
                ((AppConfigModelInitPoint) ExtensionPoint.as(AppConfigModelInitPoint.class).node(this.mApp).create()).onAppConfigModelInit(this.mApp, fromJSON);
                if (fromJSON != null) {
                    fillConfigWithIncludeFile(resourceContext, fromJSON);
                    fillConfigWithTemplate(fromJSON);
                    removeInvalidParams(fromJSON);
                    RVLogger.d(TAG, "put appConfig.json " + fromJSON);
                    this.mApp.setData(AppConfigModel.class, fromJSON);
                    this.mApp.getStartParams().putAll(JSONUtils.toBundle(fromJSON.getAppLaunchParams()));
                    this.mApp.setData(ColorSchemeDecider.class, new ColorSchemeDecider.DefaultDecider(JSONUtils.getJSONArray(fromJSON.getAppLaunchParams(), RVStartParams.KEY_SUPPORT_COLOR_SCHEME, null)));
                }
            }
            if (appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getTemplateConfig() == null) {
                z = false;
            } else {
                TemplateConfigModel templateConfig = appModel.getAppInfoModel().getTemplateConfig();
                if (templateConfig.isTemplateValid()) {
                    try {
                        templateExtModel = new com.alibaba.ariver.resource.template.a(appModel).get();
                        try {
                            templateConfig.setExtModel(templateExtModel);
                        } catch (Throwable th) {
                            th = th;
                            RVLogger.e(TAG, "prepare template Config error!", th);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        templateExtModel = null;
                    }
                    if (templateExtModel == null || templateExtModel.getTabBarObject() == null || (jSONArray = JSONUtils.getJSONArray(templateExtModel.getTabBarObject(), "items", null)) == null) {
                        z = false;
                    } else {
                        this.mApp.getStartParams().putString(RVStartParams.KEY_TEMPLATE_TABBAR, jSONArray.toJSONString());
                        resourceContext.tabBarDataStorage.onGetData(TabBarModel.inflateFromTemplate(templateExtModel.getTabBarObject(), (ColorSchemeDecider) this.mApp.getData(ColorSchemeDecider.class)));
                        z = true;
                    }
                    this.mApp.getStartParams().putBoolean(RVStartParams.KEY_TEMPLATE_FLAG, true);
                    this.mApp.getStartParams().putString(RVStartParams.KEY_TEMPLATE_ID, templateConfig.getTemplateId());
                } else {
                    z = false;
                }
            }
            if (!z) {
                Resource resource2 = mainPackage.get(ResourceQuery.asUrl(RVConstants.FILE_TABBAR).setNeedAutoCompleteHost().setLanguageAware(true));
                if (resource2 != null) {
                    RVLogger.d(TAG, "put tabBar.json for " + this.mApp.getAppId());
                    resourceContext.tabBarDataStorage.onGetData(TabBarModel.inflateFromResource(resource2, (ColorSchemeDecider) this.mApp.getData(ColorSchemeDecider.class)));
                } else {
                    RVLogger.w(TAG, "cannot find tabBar.json for " + this.mApp.getAppId());
                }
            }
        }
        if (RVSnapshotUtils.isSnapshotEnabled(this.mApp)) {
            this.mApp.getStartParams().putBoolean(RVStartParams.KEY_SNAPSHOT_ENABLED, true);
            if (this.mApp.isTinyApp() && this.mApp.getData(AppConfigModel.class) != null) {
                try {
                    byte[] snapshotIndex = getSnapshotIndex(this.mApp, UrlUtils.purifyUrl(string), string);
                    if (snapshotIndex != null) {
                        RVLogger.d(TAG, "SnapshotProvider read snapshot.html success! " + string);
                        resourceContext.setSnapshotIndex(string, snapshotIndex);
                        String snapshotTitleBar = getSnapshotTitleBar(this.mApp, UrlUtils.purifyUrl(string), string);
                        if (!TextUtils.isEmpty(snapshotTitleBar)) {
                            resourceContext.setSnapshotTitleBarParams(snapshotTitleBar);
                            RVLogger.d(TAG, "SnapshotProvider getSnapshotTitleBar param: " + snapshotTitleBar);
                        }
                    }
                } catch (Throwable th3) {
                    RVLogger.e(TAG, "prepare snapshot data error!", th3);
                }
            }
        }
        RVTraceUtils.traceEndSection(RVTraceKey.RV_ResourceLoadExtension_resourcePrepare_ + str);
        appLoadResult.waitLoadFuture = new Callable<Boolean>() { // from class: com.alibaba.ariver.resource.runtime.ResourceLoadExtension.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() {
                Iterator it = ResourceLoadExtension.this.mLockingPackages.iterator();
                boolean z2 = true;
                while (it.hasNext()) {
                    if (!((ResourcePackage) it.next()).isPrepareDone()) {
                        z2 = false;
                    }
                }
                RVLogger.d(ResourceLoadExtension.TAG, "waitLoadFuture isDone: " + z2);
                return Boolean.valueOf(z2);
            }
        };
        loadResultCallback.onResult(appLoadResult);
        addLauncherParamResourcePackage(resourceContext);
        RVTraceUtils.traceEndSection(RVTraceKey.RV_ResourceLoadExtension_loadApp_ + str);
    }

    @Override // com.alibaba.ariver.engine.api.resources.ResourceLoadPoint
    public Resource loadGlobalResource(String str) {
        return GlobalPackagePool.getInstance().get(ResourceQuery.asUrl(str));
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppCreatePoint
    public void onAppCreate(App app) {
        if (this.mInterceptPoint == null) {
            this.mInterceptPoint = (ResourceInterceptPoint) ExtensionPoint.as(ResourceInterceptPoint.class).node(app).create();
        }
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppDestroyPoint
    public void onAppDestroy(App app) {
        for (String str : ResourceContextManager.getInstance().get(app.getAppId()).getResourcePackages()) {
            if (!TextUtils.equals(RVConstants.TINY_WEB_COMMON_APPID, str)) {
                ResourcePackagePool.getInstance().detach(str);
            }
        }
        ResourceContextManager.getInstance().onAppDestroy(app.getAppId());
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
    public void onAppStart(App app) {
        ResourceContext resourceContextOnAppLoad = ResourceContextManager.getInstance().onAppLoad(app.getAppId());
        RVLogger.d(TAG, "onAppStart: " + app.getAppId() + " on resourceContext: " + resourceContextOnAppLoad);
        resourceContextOnAppLoad.setApp(app);
        resourceContextOnAppLoad.setAppId(app.getAppId());
        resourceContextOnAppLoad.setStartParams(app.getStartParams());
        resourceContextOnAppLoad.setSceneParams(app.getSceneParams());
        if (this.mInterceptPoint == null) {
            this.mInterceptPoint = (ResourceInterceptPoint) ExtensionPoint.as(ResourceInterceptPoint.class).node(resourceContextOnAppLoad.getApp()).create();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint
    public void onInitSuccess() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<ResourcePackage> it = this.mLockingPackages.iterator();
        while (it.hasNext()) {
            it.next().waitForSetup();
        }
        this.mLockingPackages.clear();
        RVLogger.d(TAG, "waitForSetup cost " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint
    public void queryTabBarInfo(final TabBarInfoQueryPoint.OnTabBarInfoQueryListener onTabBarInfoQueryListener) {
        ResourceContextManager.getInstance().get(this.mApp.getAppId()).tabBarDataStorage.retrieveData(new TabBarDataStorage.Listener() { // from class: com.alibaba.ariver.resource.runtime.ResourceLoadExtension.3
            @Override // com.alibaba.ariver.resource.api.storage.TabBarDataStorage.Listener
            public void onGetData(TabBarModel tabBarModel) {
                onTabBarInfoQueryListener.onTabInfoGot(tabBarModel);
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.mApp = weakReference.get();
    }
}
