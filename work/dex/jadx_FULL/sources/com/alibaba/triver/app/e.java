package com.alibaba.triver.app;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.app.AppUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarItemModel;
import com.alibaba.ariver.app.view.EmbedAppContext;
import com.alibaba.ariver.console.DebugConsolePoint;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.TriverActivity;
import com.alibaba.triver.container.TriverSubActivity;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.TinyApp;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.utils.CommonUtils;
import com.alibaba.triver.utils.PageUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e implements c, TinyApp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24621a = "TriverAppWrapper";
    private b b;
    private App c;

    public e(App app) {
        this.c = app;
    }

    private String c() {
        TabBarItemModel tabBarItemModel;
        AppModel appModel = (AppModel) this.c.getData(AppModel.class);
        if (appModel != null && appModel.getAppInfoModel() != null) {
            if (!TextUtils.isEmpty(appModel.getAppInfoModel().getMainUrl())) {
                return FileUtils.combinePath(appModel.getAppInfoModel().getVhost(), appModel.getAppInfoModel().getMainUrl());
            }
            if (this.c.getAppContext() != null && this.c.getAppContext().getTabBar() != null && this.c.getAppContext().getTabBar().getTabbarModel() != null && this.c.getAppContext().getTabBar().getTabbarModel().getItems() != null && !this.c.getAppContext().getTabBar().getTabbarModel().getItems().isEmpty() && (tabBarItemModel = this.c.getAppContext().getTabBar().getTabbarModel().getItems().get(0)) != null && !TextUtils.isEmpty(tabBarItemModel.getUrl())) {
                return FileUtils.combinePath(appModel.getAppInfoModel().getVhost(), tabBarItemModel.getUrl());
            }
            AppConfigModel appConfigModel = (AppConfigModel) this.c.getData(AppConfigModel.class);
            if (appConfigModel != null && appConfigModel.getPages() != null && !appConfigModel.getPages().isEmpty()) {
                return FileUtils.combinePath(appModel.getAppInfoModel().getVhost(), "index.html#" + appConfigModel.getPages().get(0));
            }
        }
        return null;
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public <T> void addData(Class<T> cls, T t) {
        if (this.c.getAppContext() == null || !(this.c.getAppContext() instanceof d)) {
            return;
        }
        ((d) this.c.getAppContext()).a(cls, t);
    }

    public App b() {
        return this.c;
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public boolean backPressed() {
        if (!this.c.isFirstPage()) {
            return this.c.backPressed();
        }
        exit();
        return true;
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public void exit() {
        App app;
        if (isEmbedApp()) {
            for (int childCount = this.c.getChildCount() - 1; childCount > 0; childCount--) {
                this.c.getPageByIndex(childCount).exit(false);
            }
            return;
        }
        if (CommonUtils.enableKeepAlive(this.c) && this.c.getAppContext() != null && this.c.getAppContext().getContext() != null) {
            Activity activity = (Activity) this.c.getAppContext().getContext();
            if ((activity instanceof TriverSubActivity.TriverSubActivityX) && activity.isTaskRoot()) {
                activity.moveTaskToBack(false);
                return;
            }
        }
        if (!CommonUtils.downgradePreventCloseChange() && (app = this.c) != null && (app.getActivePage() == null || !this.c.getActivePage().isPageLoaded())) {
            this.c.exit();
            return;
        }
        if (this.c.isFirstPage() && this.c.getActivePage() != null && TRiverUtils.isAuthPage(this.c.getActivePage().getPageURI())) {
            this.c.exit();
            return;
        }
        if (this.b == null) {
            this.b = new b(this.c) { // from class: com.alibaba.triver.app.e.1
                @Override // com.alibaba.triver.app.b
                public void b(GoBackCallback goBackCallback) {
                    e.this.c.exit();
                    if (goBackCallback != null) {
                        goBackCallback.afterProcess(true);
                    }
                }
            };
        }
        this.b.a((GoBackCallback) null);
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public Page getActivePage() {
        return new g(this.c.getActivePage(), this);
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public String getAppDesc() {
        AppModel appModelA = a();
        if (appModelA == null || appModelA.getAppInfoModel() == null) {
            return null;
        }
        return appModelA.getAppInfoModel().getDesc();
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public String getAppFrameType() {
        return com.alibaba.triver.kit.api.utils.CommonUtils.getAppFrameType(this.c);
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public String getAppId() {
        return this.c.getAppId();
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public String getAppKey() {
        AppModel appModelA = a();
        if (appModelA == null || appModelA.getAppInfoModel() == null) {
            return null;
        }
        return appModelA.getAppInfoModel().getAppKey();
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public String getAppLogo() {
        AppModel appModelA = a();
        if (appModelA == null || appModelA.getAppInfoModel() == null) {
            return null;
        }
        return appModelA.getAppInfoModel().getLogo();
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public String getAppName() {
        AppModel appModelA = a();
        if (appModelA == null || appModelA.getAppInfoModel() == null) {
            return null;
        }
        return !TextUtils.isEmpty(appModelA.getAppInfoModel().getAlias()) ? appModelA.getAppInfoModel().getAlias() : appModelA.getAppInfoModel().getName();
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public String getAppSubType() {
        String string;
        if (!CommonUtils.isApkDebug() || this.c.getStartParams() == null) {
            string = null;
        } else {
            string = this.c.getStartParams().getString(TRiverConstants.KEY_SUB_BIZ_TYPE);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        AppModel appModelA = a();
        if (appModelA != null && appModelA.getExtendInfos() != null) {
            string = appModelA.getExtendInfos().getString(TRiverConstants.KEY_SUB_BIZ_TYPE);
        }
        return (!TextUtils.isEmpty(string) || this.c.getStartParams() == null) ? string : this.c.getStartParams().getString(TRiverConstants.KEY_SUB_BIZ_TYPE);
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public String getAppType() {
        AppModel appModelA = a();
        String string = (appModelA == null || appModelA.getExtendInfos() == null) ? null : appModelA.getExtendInfos().getString("bizType");
        return (!TextUtils.isEmpty(string) || this.c.getStartParams() == null) ? string : this.c.getStartParams().getString("bizType");
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public String getAppVersion() {
        AppModel appModelA = a();
        if (appModelA != null) {
            return appModelA.getAppVersion();
        }
        return null;
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public <T> T getData(Class<T> cls) {
        if (cls == AppModel.class) {
            return (T) a();
        }
        if (this.c.getAppContext() == null || !(this.c.getAppContext() instanceof d)) {
            return null;
        }
        return (T) ((d) this.c.getAppContext()).a(cls);
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public int getPageCount() {
        return this.c.getAlivePageCount();
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public Bundle getSceneParams() {
        return this.c.getSceneParams();
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public Bundle getStartParams() {
        return this.c.getStartParams();
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public long getStartToken() {
        return this.c.getStartToken();
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public String getStartUrl() {
        App app = this.c;
        if (app == null || app.getStartParams() == null) {
            return null;
        }
        return this.c.getStartParams().getString(TRiverConstants.KEY_ORI_URL);
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public String getTemplateAppKey() {
        AppModel appModelA = a();
        if (appModelA == null || appModelA.getAppInfoModel() == null || appModelA.getAppInfoModel().getTemplateConfig() == null) {
            return null;
        }
        return appModelA.getAppInfoModel().getTemplateConfig().getAppKey();
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public String getTemplateId() {
        AppModel appModelA = a();
        if (appModelA == null || appModelA.getAppInfoModel() == null || appModelA.getAppInfoModel().getTemplateConfig() == null) {
            return null;
        }
        return appModelA.getAppInfoModel().getTemplateConfig().getTemplateId();
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public boolean hasAuth() {
        List<PluginModel> pluginModels;
        try {
            App app = this.c;
            if (app == null) {
                return false;
            }
            DynamicPluginInfo dynamicPluginInfo = (DynamicPluginInfo) app.getData(DynamicPluginInfo.class);
            AppModel appModel = (AppModel) this.c.getData(AppModel.class);
            if (!"true".equals(((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroupAndName("triver_common_config", TRiverConstants.ORANGE_KEY_SUBSCRIBE_SWITCH, "true"))) {
                return !com.alibaba.triver.support.ui.auth.settings.c.a(appModel, dynamicPluginInfo, false).isEmpty();
            }
            if (appModel.getPermissionModel() != null) {
                return true;
            }
            if (dynamicPluginInfo != null && (pluginModels = dynamicPluginInfo.getPluginModels()) != null) {
                Iterator<PluginModel> it = pluginModels.iterator();
                while (it.hasNext()) {
                    if (it.next().getPermission() != null) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            RVLogger.e(f24621a, e);
        }
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public boolean isEmbedApp() {
        App app = this.c;
        if (app == null || app.getAppContext() == null) {
            return false;
        }
        return !(this.c.getAppContext().getContext() instanceof TriverActivity);
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public boolean isEmbedView() {
        App app = this.c;
        if (app != null) {
            return app.getAppContext() instanceof EmbedAppContext;
        }
        return false;
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public boolean isFavorEnable() {
        AppModel appModelA = a();
        if (appModelA == null || appModelA.getExtendInfos() == null) {
            return false;
        }
        return appModelA.getExtendInfos().getBooleanValue("favorEnable");
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public boolean isSpecialFavor() {
        AppModel appModelA = a();
        if (appModelA == null || appModelA.getExtendInfos() == null) {
            return false;
        }
        return appModelA.getExtendInfos().getBooleanValue("specialFavor");
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public boolean isWindmillApp() {
        return false;
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public void openPage(String str, Bundle bundle) {
        App app = this.c;
        if (app == null || app.getActivePage() == null) {
            return;
        }
        PageUtils.pushPage(this.c.getActivePage(), str, bundle);
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public void pop(JSONObject jSONObject) {
        if (this.c.getChildCount() > 1) {
            this.c.popPage(jSONObject);
        } else if (!CommonUtils.enableKeepAlive(this.c) || this.c.getAppContext() == null || this.c.getAppContext().getContext() == null) {
            this.c.popPage(jSONObject);
        } else {
            ((Activity) this.c.getAppContext().getContext()).moveTaskToBack(false);
        }
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public void popToHome() {
        try {
            String strC = c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            com.alibaba.ariver.app.api.Page pageByIndex = this.c.getPageByIndex(0);
            if (pageByIndex != null && TextUtils.equals(UrlUtils.getHash(strC), UrlUtils.getHash(pageByIndex.getPageURI()))) {
                App app = this.c;
                app.popTo((-app.getChildCount()) + 1, false, null);
            } else if (pageByIndex == null || !TRiverUtils.isAuthPage(pageByIndex.getPageURI())) {
                AppUtils.sendToApp(this.c, "onBackHomeClick", null, null);
            } else {
                this.c.relaunchToUrl(strC, getStartParams(), getSceneParams());
            }
        } catch (Exception e) {
            RVLogger.e(f24621a, "popToHome error", e);
        }
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public void restart() {
        if (this.c == null || isEmbedApp()) {
            return;
        }
        App app = this.c;
        app.restartFromServer(app.getStartParams());
    }

    @Override // com.alibaba.triver.kit.api.TinyApp
    public void sendGlobalEvent(String str, JSONObject jSONObject) {
        App app = this.c;
        if (app == null || app.getActivePage() == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            jSONObject2.put("data", (Object) jSONObject);
        }
        EngineUtils.sendToRender(this.c.getActivePage().getRender(), EngineUtils.getWorker(this.c.getEngineProxy()), str, jSONObject2, null);
    }

    public AppModel a() {
        return (AppModel) this.c.getData(AppModel.class);
    }

    @Override // com.alibaba.triver.app.c
    public void a(boolean z) {
        try {
            if (z) {
                ((DebugConsolePoint) ExtensionPoint.as(DebugConsolePoint.class).node(this.c).create()).showToggleButton(true);
            } else {
                ((DebugConsolePoint) ExtensionPoint.as(DebugConsolePoint.class).node(this.c).create()).showToggleButton(false);
            }
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
    }
}
