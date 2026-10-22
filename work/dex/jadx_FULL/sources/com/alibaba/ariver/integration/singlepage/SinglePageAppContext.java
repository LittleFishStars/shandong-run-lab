package com.alibaba.ariver.integration.singlepage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.FontBar;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class SinglePageAppContext implements AppContext {
    private Activity mActivity;
    private App mApp;

    public SinglePageAppContext(App app, Activity activity) {
        this.mActivity = activity;
        this.mApp = app;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void createTabBar(Page page) {
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void destroy() {
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void exitPage(Page page, boolean z) {
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public Intent getActivityStartIntent() {
        return this.mActivity.getIntent();
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public Context getContext() {
        return this.mActivity;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public FontBar getFontBar() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public SplashView getSplashView() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public TabBar getTabBar() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public ViewSpecProvider getViewSpecProvider() {
        return null;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean isTaskRoot() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean moveToBackground() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean pushPage(Page page) {
        RVMain.startApp(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), page.getApp().getAppId(), page.getStartParams(), page.getSceneParams());
        page.exit(true);
        return true;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void start(Page page) {
        if (page.getPageContext() == null) {
            page.bindContext(new SinglePageContext(this.mApp, this.mActivity));
        }
        page.enter();
    }
}
