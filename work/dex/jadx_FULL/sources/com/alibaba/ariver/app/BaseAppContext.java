package com.alibaba.ariver.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint;
import com.alibaba.ariver.app.api.ui.FontBar;
import com.alibaba.ariver.app.api.ui.RVViewFactory;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.fragment.RVFragment;
import com.alibaba.ariver.app.api.ui.loading.SplashUtils;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.app.ipc.IpcClientUtils;
import com.alibaba.ariver.app.ui.DefaultViewSpecProvider;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.byazt.hv.TTDownloadField;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseAppContext implements AppContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23813a = "AriverInt:BaseAppContext";
    private FragmentActivity b;
    private TabBar c;
    private ViewSpecProvider d;
    private boolean e;
    private boolean f = false;
    protected App mApp;
    protected IFragmentManager mFragmentManager;

    public class InitTabBarListener implements TabBarInfoQueryPoint.OnTabBarInfoQueryListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Page f23814a;

        @Override // com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint.OnTabBarInfoQueryListener
        public void onTabInfoGot(TabBarModel tabBarModel) {
            RVLogger.d(BaseAppContext.f23813a, "onTabInfoGot data " + tabBarModel);
            BaseAppContext.this.a(this.f23814a, tabBarModel);
        }

        private InitTabBarListener(Page page) {
            this.f23814a = page;
        }
    }

    public BaseAppContext(App app, FragmentActivity fragmentActivity) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppContext_constructor);
        this.mApp = app;
        this.b = fragmentActivity;
        this.mFragmentManager = createFragmentManager();
        this.d = new DefaultViewSpecProvider(fragmentActivity);
        Bundle bundle = new Bundle();
        bundle.putString("appId", app.getAppId());
        bundle.putString(RVConstants.EXTRA_ACTIVITY_CLZ, fragmentActivity.getClass().getName());
        bundle.putBundle(RVConstants.EXTRA_START_PARAMS, BundleUtils.clone(app.getStartParams()));
        IpcClientUtils.sendMsgToServerByApp(app, 1, bundle);
        RVTraceUtils.traceEndSection(RVTraceKey.RV_AppContext_constructor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Page page, final TabBarModel tabBarModel) {
        if (this.b.isFinishing() || this.e) {
            return;
        }
        this.e = true;
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.BaseAppContext.1
            @Override // java.lang.Runnable
            public void run() {
                BaseAppContext.this.getTabBarContainer().setVisibility(0);
                BaseAppContext.this.c.init(tabBarModel);
                if (BaseAppContext.this.c.isTabPage(page)) {
                    page.getStartParams().putString(RVStartParams.KEY_FRAGMENT_TYPE, RVStartParams.FRAGMENT_TYPE_SUB_TAB);
                    BaseAppContext.this.c.create(page);
                    BaseAppContext.this.c.show(page, null);
                } else {
                    BaseAppContext.this.c.hide(null);
                    RVLogger.d(BaseAppContext.f23813a, "init with " + page + " not tabPage!");
                }
            }
        });
    }

    public abstract IFragmentManager createFragmentManager();

    @Override // com.alibaba.ariver.app.api.AppContext
    public void createTabBar(Page page) {
        this.c = ((RVViewFactory) RVProxy.get(RVViewFactory.class)).createTabBar(this.b, this.mApp, this.mFragmentManager, getTabBarContainer());
        ((TabBarInfoQueryPoint) ExtensionPoint.as(TabBarInfoQueryPoint.class).node(this.mApp).create()).queryTabBarInfo(new InitTabBarListener(page));
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public synchronized void destroy() {
        if (this.f) {
            return;
        }
        this.f = true;
        onDestroy();
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void exitPage(Page page, boolean z) {
        RVLogger.d(f23813a, "exitPage " + page);
        IFragmentManager iFragmentManager = this.mFragmentManager;
        if (iFragmentManager == null) {
            RVLogger.d(f23813a, "exitPage but already exited");
            return;
        }
        if (iFragmentManager.findFragmentForPage(page) != null) {
            this.mFragmentManager.exitPage(page, (!BundleUtils.getBoolean(page.getStartParams(), RVParams.LONG_PUSHWINDOW_WITH_TRANS_ANIM, true) || this.mApp.isExited() || ((Page.AnimStore) page.getData(Page.AnimStore.class, true)).disableExit) ? false : true, z);
        } else {
            RVLogger.d(f23813a, "exitPage but fragment already exited!");
        }
        Bundle bundle = new Bundle();
        bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, page.getNodeId());
        IpcClientUtils.sendMsgToServerByApp(getApp(), 5, bundle);
    }

    public FragmentActivity getActivity() {
        return this.b;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public Intent getActivityStartIntent() {
        return this.b.getIntent();
    }

    public App getApp() {
        return this.mApp;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public Context getContext() {
        return this.b;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public FontBar getFontBar() {
        return null;
    }

    public IFragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public TabBar getTabBar() {
        return this.c;
    }

    public abstract ViewGroup getTabBarContainer();

    @Override // com.alibaba.ariver.app.api.AppContext
    public ViewSpecProvider getViewSpecProvider() {
        return this.d;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean isTaskRoot() {
        return this.b.isTaskRoot();
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean moveToBackground() {
        return false;
    }

    public void onDestroy() {
        Bundle bundle = new Bundle();
        bundle.putString("appId", getApp().getAppId());
        bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, getApp().getNodeId());
        bundle.putBundle(RVConstants.EXTRA_START_PARAMS, getApp().getStartParams());
        IpcClientUtils.sendMsgToServerByApp(getApp(), 2, bundle);
        FragmentActivity fragmentActivity = this.b;
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            RVLogger.w(f23813a, "NebulaActivity finish by AppContext.destroy()");
            if (!this.b.isTaskRoot()) {
                this.b.finish();
            } else if (a(this.b)) {
                RVLogger.w(f23813a, "NebulaActivity finishAndRemoveTask by Activity API");
                this.b.finishAndRemoveTask();
            } else {
                RVLogger.w(f23813a, "NebulaActivity removeFromRecentTasksList by LiteProcess");
                this.b.finish();
            }
            this.b = null;
        }
        IFragmentManager iFragmentManager = this.mFragmentManager;
        if (iFragmentManager != null) {
            iFragmentManager.release();
            this.mFragmentManager = null;
        }
        ClientMsgReceiver.getInstance().unRegisterAppHandler(this.mApp.getStartToken());
        this.mApp = null;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean pushPage(Page page) {
        if (!ExecutorUtils.isMainThread()) {
            throw new IllegalStateException("pushPage can only invoked in main thread!");
        }
        RVLogger.d(f23813a, "pushPage with page: " + page + " with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        if (this.mFragmentManager == null || page.isExited()) {
            RVLogger.w(f23813a, "pushPage but is exited!");
            return false;
        }
        RVFragment readyFragment = this.mFragmentManager.getReadyFragment();
        if (readyFragment.isAdded()) {
            readyFragment.setPage(page);
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong(RVConstants.EXTRA_APP_INSTANCE_ID, this.mApp.getNodeId());
            bundle.putLong(RVConstants.EXTRA_PAGE_INSTANCE_ID, page.getNodeId());
            readyFragment.setArguments(bundle);
        }
        Bundle startParams = page.getStartParams();
        boolean zEquals = "pushWindow".equals(BundleUtils.getString(startParams, RVStartParams.KEY_FROM_TYPE, ""));
        boolean z = BundleUtils.getBoolean(startParams, RVStartParams.KEY_FROM_RELAUNCH, false);
        boolean z2 = BundleUtils.getBoolean(startParams, RVParams.LONG_PUSHWINDOW_WITH_TRANS_ANIM, true);
        RVLogger.d(f23813a, "pushPage useTranslateAnim : " + z2 + " fromRelaunch: " + z + " fromPushWindow: " + zEquals);
        if (z || !z2 || !zEquals || ((Page.AnimStore) page.getData(Page.AnimStore.class, true)).disableEnter) {
            this.mFragmentManager.pushPage(page, readyFragment, false);
        } else {
            this.mFragmentManager.pushPage(page, readyFragment, true);
        }
        TabBar tabBar = this.c;
        if (tabBar != null && !tabBar.isCreated() && this.c.isTabPage(page)) {
            this.c.create(page);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(IpcMessageConstants.EXTRA_NODE_ID, page.getNodeId());
        IpcClientUtils.sendMsgToServerByApp(getApp(), 4, bundle2);
        return true;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void start(Page page) {
        try {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppContext_start);
            if (!ExecutorUtils.isMainThread()) {
                throw new IllegalStateException("pushPage can only invoked in main thread!");
            }
            RVLogger.d(f23813a, "startPage with page: " + page);
            Bundle bundle = new Bundle();
            bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, getApp().getNodeId());
            IpcClientUtils.sendMsgToServerByApp(getApp(), 3, bundle);
            a(page);
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppContext_pushPage);
            pushPage(page);
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppContext_pushPage);
            ExecutorUtils.postMain(new Runnable() { // from class: com.alibaba.ariver.app.BaseAppContext.2
                @Override // java.lang.Runnable
                public void run() {
                    App app = BaseAppContext.this.mApp;
                    if (app == null || app.isExited() || BaseAppContext.this.mApp.isDestroyed()) {
                        RVLogger.d(BaseAppContext.f23813a, "when splashView exit,mapp has destroy");
                        return;
                    }
                    boolean zUseSuperSplash = SplashUtils.useSuperSplash(BaseAppContext.this.mApp.getStartParams());
                    SplashView splashView = BaseAppContext.this.mApp.getAppContext() == null ? null : BaseAppContext.this.mApp.getAppContext().getSplashView();
                    StringBuilder sb = new StringBuilder();
                    sb.append("splashView exit. delaySplashHide= ");
                    sb.append(zUseSuperSplash);
                    sb.append(", splashView_is_null=");
                    sb.append(splashView == null);
                    RVLogger.d(BaseAppContext.f23813a, sb.toString());
                    if (zUseSuperSplash || splashView == null) {
                        return;
                    }
                    splashView.exit(null);
                }
            });
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppContext_start);
        } catch (Throwable th) {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppContext_start);
            throw th;
        }
    }

    private void a(Page page) {
        if (TextUtils.equals("YES", BundleUtils.getString(this.mApp.getStartParams(), "enableTabBar"))) {
            createTabBar(page);
        }
    }

    private boolean a(Activity activity) {
        ActivityManager activityManager = (ActivityManager) ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return true;
        }
        for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(Integer.MAX_VALUE)) {
            if (runningTaskInfo.baseActivity != null && TextUtils.equals(activity.getClass().getName(), runningTaskInfo.baseActivity.getClassName())) {
                RVLogger.d(f23813a, "canRemoveTask found RunningTaskInfo: " + runningTaskInfo);
                if (runningTaskInfo.numActivities <= 1) {
                    break;
                }
                RVLogger.d(f23813a, "canRemoveTask remove task because have another activity!");
                return false;
            }
        }
        return true;
    }
}
