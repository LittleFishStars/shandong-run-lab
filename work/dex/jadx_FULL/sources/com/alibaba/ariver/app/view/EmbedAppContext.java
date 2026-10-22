package com.alibaba.ariver.app.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.FontBar;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.fragment.RVFragment;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.app.ipc.IpcClientUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class EmbedAppContext implements AppContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23840a = "AriverInt:BaseAppContext";
    private FragmentActivity b;
    private App c;
    private IFragmentManager d;
    private boolean e = false;

    public EmbedAppContext(App app, FragmentActivity fragmentActivity) {
        this.b = fragmentActivity;
        this.c = app;
        Bundle bundle = new Bundle();
        bundle.putString("appId", app.getAppId());
        bundle.putString(RVConstants.EXTRA_ACTIVITY_CLZ, this.b.getClass().getName());
        bundle.putBundle(RVConstants.EXTRA_START_PARAMS, BundleUtils.clone(app.getStartParams()));
        IpcClientUtils.sendMsgToServerByApp(app, 1, bundle);
    }

    public abstract IFragmentManager createFragmentManager();

    public abstract EmbedPageContext createPageContext();

    @Override // com.alibaba.ariver.app.api.AppContext
    public void createTabBar(Page page) {
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public synchronized void destroy() {
        if (this.e) {
            return;
        }
        this.e = true;
        onDestroy();
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void exitPage(Page page, boolean z) {
        RVLogger.d(f23840a, "exitPage " + page);
        if (getFragmentManager() == null) {
            RVLogger.d(f23840a, "exitPage but already exited");
            return;
        }
        if (getFragmentManager().findFragmentForPage(page) != null) {
            getFragmentManager().exitPage(page, !this.c.isExited(), false);
        } else {
            RVLogger.d(f23840a, "exitPage but fragment already exited!");
            if (this.c.getAlivePageCount() == 0) {
                page.exit(z);
            }
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
        return this.c;
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
        if (this.d == null) {
            this.d = createFragmentManager();
        }
        return this.d;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public TabBar getTabBar() {
        return null;
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
        this.b = null;
        ClientMsgReceiver.getInstance().unRegisterAppHandler(this.c.getStartToken());
        this.c = null;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public boolean pushPage(Page page) {
        if (!ExecutorUtils.isMainThread()) {
            throw new IllegalStateException("pushPage can only invoked in main thread!");
        }
        if (page.isExited()) {
            return false;
        }
        RVLogger.d(f23840a, "pushPage with page: " + page + " with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        RVFragment readyFragment = getFragmentManager().getReadyFragment();
        if (readyFragment.isAdded()) {
            readyFragment.setPage(page);
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong(RVConstants.EXTRA_APP_INSTANCE_ID, this.c.getNodeId());
            bundle.putLong(RVConstants.EXTRA_PAGE_INSTANCE_ID, page.getNodeId());
            readyFragment.setArguments(bundle);
        }
        Bundle startParams = page.getStartParams();
        boolean zEquals = "pushWindow".equals(BundleUtils.getString(startParams, RVStartParams.KEY_FROM_TYPE, ""));
        boolean z = BundleUtils.getBoolean(startParams, RVParams.LONG_PUSHWINDOW_WITH_TRANS_ANIM, true);
        RVLogger.d(f23840a, "pushPage useTranslateAnim : " + z + " fromPushWindow: " + zEquals);
        if (z && zEquals) {
            getFragmentManager().pushPage(page, readyFragment, true);
        } else {
            getFragmentManager().pushPage(page, readyFragment, false);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(IpcMessageConstants.EXTRA_NODE_ID, page.getNodeId());
        IpcClientUtils.sendMsgToServerByApp(getApp(), 4, bundle2);
        return true;
    }

    @Override // com.alibaba.ariver.app.api.AppContext
    public void start(Page page) {
        if (!ExecutorUtils.isMainThread()) {
            throw new IllegalStateException("pushPage can only invoked in main thread!");
        }
        RVLogger.d(f23840a, "startPage with page: " + page);
        Bundle bundle = new Bundle();
        bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, getApp().getNodeId());
        IpcClientUtils.sendMsgToServerByApp(getApp(), 3, bundle);
        if (page.isExited()) {
            return;
        }
        createPageContext().renderPage(page);
        Bundle bundle2 = new Bundle();
        bundle2.putLong(IpcMessageConstants.EXTRA_NODE_ID, page.getNodeId());
        IpcClientUtils.sendMsgToServerByApp(getApp(), 4, bundle2);
    }
}
