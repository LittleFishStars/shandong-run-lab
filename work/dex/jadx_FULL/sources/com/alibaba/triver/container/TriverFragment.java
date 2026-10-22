package com.alibaba.triver.container;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.activity.ActivityHelper;
import com.alibaba.ariver.app.activity.DefaultFragmentManager;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.activity.AnimUtils;
import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.fragment.RVFragment;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.app.ipc.IpcClientUtils;
import com.alibaba.ariver.integration.RVInitializer;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.triver.R;
import com.alibaba.triver.app.TriverLoadingController;
import com.alibaba.triver.app.d;
import com.alibaba.triver.basic.api.RequestPermission;
import com.alibaba.triver.impl.InitializerPrinter;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IReloadable;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import com.alibaba.triver.point.TriverLifecyclePoint;
import com.alibaba.triver.trace.c;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverFragment extends Fragment {
    private static final String TAG = "TriverActivity";
    protected ActivityHelper activityHelper;
    private long attachElapsedRealtime;
    protected TriverContainerHelper containerHelper;
    private String mAppId;
    private int mLoadingType;
    private String mOrgUrl;
    private long onCreateElapsedRealtime;

    public class a extends d {
        public a(App app, SplashView splashView, ViewGroup viewGroup, ViewGroup viewGroup2) {
            super(app, splashView, viewGroup, viewGroup2, TriverFragment.this.getActivity());
        }

        @Override // com.alibaba.triver.app.d, com.alibaba.ariver.app.BaseAppContext
        public IFragmentManager createFragmentManager() {
            return new b(getApp(), R.id.trv_fragment_container, TriverFragment.this);
        }

        @Override // com.alibaba.triver.app.d, com.alibaba.ariver.app.BaseAppContext
        public void onDestroy() {
            Bundle bundle = new Bundle();
            bundle.putString("appId", getApp().getAppId());
            bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, getApp().getNodeId());
            IpcClientUtils.sendMsgToServerByApp(getApp(), 2, bundle);
            IFragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.release();
            }
            ClientMsgReceiver.getInstance().unRegisterAppHandler(getApp().getStartToken());
        }
    }

    public static class b extends DefaultFragmentManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f24770a;
        private Fragment b;

        public b(App app, int i, Fragment fragment) {
            super(app, i, fragment);
            this.f24770a = app.getStartParams().getInt(TRiverConstants.KEY_FRAGMENT_SUNPAGE_CONTAINER);
            this.b = fragment;
            this.mFragmentManager = fragment.getActivity().getSupportFragmentManager();
        }

        @Override // com.alibaba.ariver.app.activity.DefaultFragmentManager, com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
        public synchronized boolean exitPage(Page page, boolean z, boolean z2) {
            if (this.mApp.getAppContext() != null && !this.mActivity.isFinishing() && !this.mFragmentManager.isDestroyed()) {
                RVFragment rVFragmentRemove = this.mPageFragmentMap.remove(page);
                if (rVFragmentRemove == null) {
                    return false;
                }
                if (this.mFragmentStack.size() <= 1 && z2) {
                    return false;
                }
                FragmentActivity fragmentActivity = this.mActivity;
                if (fragmentActivity != null && fragmentActivity.isFinishing()) {
                    return true;
                }
                RVLogger.d(TriverFragment.TAG, "exitPage: " + page + " " + rVFragmentRemove + " fragmentStack: " + this.mFragmentStack.size());
                boolean z3 = rVFragmentRemove == this.mFragmentStack.peek();
                this.mFragmentStack.remove(rVFragmentRemove);
                FragmentTransaction fragmentTransactionBeginTransaction = this.mFragmentManager.beginTransaction();
                if (z) {
                    int animResId = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_OUT_RIGHT_ID);
                    if (animResId == 0) {
                        animResId = R.anim.ariver_fragment_translate_out_right_default;
                    }
                    int animResId2 = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_IN_RIGHT_ID);
                    if (animResId2 == 0) {
                        animResId2 = R.anim.ariver_fragment_translate_in_right_default;
                    }
                    fragmentTransactionBeginTransaction.setCustomAnimations(animResId2, animResId);
                }
                if (this.mFragmentStack.size() > 1) {
                    RVFragment rVFragmentPeek = this.mFragmentStack.peek();
                    if (z) {
                        rVFragmentPeek.setShouldResumeWebView(true);
                    }
                    fragmentTransactionBeginTransaction.attach(rVFragmentPeek);
                }
                fragmentTransactionBeginTransaction.remove(rVFragmentRemove);
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                Page activePage = this.mApp.getActivePage();
                if (activePage != null && z3 && !this.mFragmentStack.isEmpty()) {
                    checkTabBar(activePage);
                }
                return true;
            }
            RVLogger.d(TriverFragment.TAG, "activity is finishing");
            return false;
        }

        @Override // com.alibaba.ariver.app.activity.DefaultFragmentManager, com.alibaba.ariver.app.api.ui.fragment.IFragmentManager
        public synchronized void pushPage(Page page, RVFragment rVFragment, boolean z) {
            try {
                if (this.mApp.getAppContext() != null && !this.mActivity.isFinishing() && rVFragment != null && !this.mFragmentStack.contains(rVFragment)) {
                    if (this.b.isAdded() && !this.b.isDetached() && !this.b.isRemoving()) {
                        RVLogger.d(TriverFragment.TAG, "pushPage: " + page + " " + rVFragment);
                        this.mPageFragmentMap.put(page, rVFragment);
                        if (this.mFragmentStack.size() > 1) {
                            RVFragment rVFragmentPeek = this.mFragmentStack.peek();
                            rVFragmentPeek.pauseRender();
                            detachFragment(rVFragmentPeek, z);
                        }
                        if (!this.mFragmentStack.contains(rVFragment)) {
                            this.mFragmentStack.push(rVFragment);
                        }
                        if (this.mActivity.isFinishing()) {
                            return;
                        }
                        FragmentTransaction fragmentTransactionBeginTransaction = (this.mFragmentStack.size() > 1 ? this.mFragmentManager : this.mActivity.getSupportFragmentManager()).beginTransaction();
                        RVLogger.d(TriverFragment.TAG, "add fragment");
                        if (z) {
                            try {
                                RVLogger.d(TriverFragment.TAG, "fragment use translate anim.");
                                rVFragment.setShouldResumeWebView(true);
                                int animResId = AnimUtils.getAnimResId(this.mActivity, RVFragment.TRANSLATE_IN_LEFT_ID);
                                if (animResId == 0) {
                                    animResId = R.anim.ariver_fragment_translate_in_left_default;
                                }
                                fragmentTransactionBeginTransaction.setCustomAnimations(animResId, 0);
                            } catch (Throwable th) {
                                RVLogger.e(TriverFragment.TAG, "catch fragment exception ", th);
                            }
                        }
                        if (rVFragment.isAdded() || rVFragment.isAlreadyScheduleAdded()) {
                            fragmentTransactionBeginTransaction.show(rVFragment);
                        } else {
                            fragmentTransactionBeginTransaction.add(this.mFragmentStack.size() > 1 ? this.f24770a : this.mContentId, rVFragment);
                        }
                        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                        return;
                    }
                    RVLogger.d(TriverFragment.TAG, "pushPage when container fragment state goes wrong! isDetached:" + this.b.isDetached() + " isAdded: " + this.b.isAdded() + " isRemoving: " + this.b.isRemoving());
                    return;
                }
                RVLogger.e(TriverFragment.TAG, "pushPage with illegal state!!!");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public AppContext createAppContext(App app, SplashView splashView, ViewGroup viewGroup, ViewGroup viewGroup2) {
        return new a(app, splashView, viewGroup, null);
    }

    @Nullable
    public App getApp() {
        ActivityHelper activityHelper = this.activityHelper;
        if (activityHelper != null) {
            return activityHelper.getApp();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean getUserVisibleHint() {
        boolean userVisibleHint = super.getUserVisibleHint();
        if (getParentFragment() != null) {
            return getParentFragment().getUserVisibleHint() && userVisibleHint;
        }
        return userVisibleHint;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        TriverContainerHelper triverContainerHelper = this.containerHelper;
        if (triverContainerHelper != null) {
            triverContainerHelper.a(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.attachElapsedRealtime = SystemClock.elapsedRealtime();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        RVInitializer.setPrinter(new InitializerPrinter());
        RVInitializer.init(getContext().getApplicationContext());
        ((TriverLifecyclePoint) ExtensionPoint.as(TriverLifecyclePoint.class).create()).onCreate();
        Bundle arguments = getArguments();
        KVStorageProxy kVStorageProxy = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
        if (kVStorageProxy instanceof IReloadable) {
            ((IReloadable) kVStorageProxy).reload();
        }
        this.onCreateElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (arguments == null) {
                TriverToastUtils.showToast(getActivity(), getString(R.string.triver_system_error));
                return;
            }
            arguments.setClassLoader(getActivity().getClassLoader());
            StartClientBundle startClientBundle = (StartClientBundle) BundleUtils.getParcelable(arguments, RVConstants.EXTRA_ARIVER_START_BUNDLE);
            if (startClientBundle == null) {
                TriverToastUtils.showToast(getActivity(), getString(R.string.triver_system_error));
                return;
            }
            Bundle bundle2 = startClientBundle.startParams;
            if (bundle2 != null) {
                EntryInfo entryInfo = new EntryInfo();
                entryInfo.title = bundle2.getString(TRiverConstants.KEY_APP_NAME);
                entryInfo.iconUrl = bundle2.getString(TRiverConstants.KEY_APP_LOGO);
                if (startClientBundle.sceneParams == null) {
                    startClientBundle.sceneParams = new Bundle();
                }
                startClientBundle.sceneParams.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
                this.mLoadingType = "1".equals(bundle2.getString(TRiverConstants.KEY_LOADING_TYPE)) ? 1 : 0;
                this.mAppId = bundle2.getString(TRiverConstants.KEY_APP_ID);
                this.mOrgUrl = bundle2.getString(TRiverConstants.KEY_ORI_URL);
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(c.y, null, TrackId.Stub_AppStart, this.mAppId, null, null);
            }
            this.containerHelper = new TriverContainerHelper(getActivity());
        } catch (Exception e) {
            RVLogger.e(TAG, "onCreate fail:", e);
            TriverToastUtils.showToast(getActivity(), getString(R.string.triver_system_error));
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        final View viewInflate = layoutInflater.inflate(R.layout.triver_activity_main, viewGroup, false);
        this.activityHelper = new ActivityHelper(getActivity()) { // from class: com.alibaba.triver.container.TriverFragment.1
            @Override // com.alibaba.ariver.app.activity.ActivityHelper
            public AppContext createAppContext(App app, FragmentActivity fragmentActivity) {
                TriverLoadingController triverLoadingController = new TriverLoadingController(TriverFragment.this.getActivity(), app, false);
                triverLoadingController.a(TriverFragment.this.mLoadingType);
                triverLoadingController.a(viewInflate.findViewById(R.id.triver_loading_container));
                return TriverFragment.this.createAppContext(app, triverLoadingController, (ViewGroup) viewInflate.findViewById(R.id.trv_fragment_container), (ViewGroup) viewInflate.findViewById(R.id.trv_tab_container));
            }
        };
        Intent intent = new Intent();
        intent.putExtras(getArguments());
        this.activityHelper.setupParams(intent);
        this.activityHelper.onCreate();
        this.containerHelper.a(this.activityHelper.getApp());
        ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(this.activityHelper.getApp(), PerfId.attachContext, this.attachElapsedRealtime);
        ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(this.activityHelper.getApp(), PerfId.fragmentCreated, this.onCreateElapsedRealtime);
        ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(this.activityHelper.getApp(), PerfId.fragmentCreateViewed);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ActivityHelper activityHelper = this.activityHelper;
        if (activityHelper != null) {
            App app = activityHelper.getApp();
            this.activityHelper.doCommonDestroy();
            if (app != null && !app.isDestroyed()) {
                app.exit();
            }
            TriverContainerHelper triverContainerHelper = this.containerHelper;
            if (triverContainerHelper != null) {
                triverContainerHelper.a();
                this.containerHelper.b();
            }
            super.onDestroy();
        } else {
            super.onDestroy();
        }
        ((TriverLifecyclePoint) ExtensionPoint.as(TriverLifecyclePoint.class).create()).onDestroy(this.mAppId, this.mOrgUrl, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        List<Fragment> fragments;
        super.onHiddenChanged(z);
        FragmentManager childFragmentManager = getChildFragmentManager();
        if (childFragmentManager == null || (fragments = childFragmentManager.getFragments()) == null) {
            return;
        }
        for (Fragment fragment : fragments) {
            if (fragment.getUserVisibleHint() && fragment.isVisible()) {
                fragment.onHiddenChanged(z);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ActivityHelper activityHelper = this.activityHelper;
        if (activityHelper == null) {
            return false;
        }
        if (activityHelper.getApp() != null) {
            if (this.activityHelper.getApp().isFirstPage() || this.activityHelper.getApp().getAlivePageCount() <= 0) {
                return false;
            }
            if (this.activityHelper.getApp().getActivePage() != null && this.activityHelper.getApp().getIndexOfChild(this.activityHelper.getApp().getActivePage()) <= 0) {
                return false;
            }
        }
        return this.activityHelper.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ((TriverLifecyclePoint) ExtensionPoint.as(TriverLifecyclePoint.class).create()).onPause(this.mAppId, this.mOrgUrl, null);
        ActivityHelper activityHelper = this.activityHelper;
        if (activityHelper != null) {
            activityHelper.onPause();
        }
        TriverContainerHelper triverContainerHelper = this.containerHelper;
        if (triverContainerHelper != null) {
            triverContainerHelper.d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Intent intent = new Intent(RequestPermission.ACTION_REQUEST_PERMISSIONS_RESULT);
        intent.putExtra(RequestPermission.REQUEST_CODE, i);
        intent.putExtra(RequestPermission.GRANT_RESULTS, iArr);
        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((TriverLifecyclePoint) ExtensionPoint.as(TriverLifecyclePoint.class).create()).onResume(this.mAppId, this.mOrgUrl, null);
        ActivityHelper activityHelper = this.activityHelper;
        if (activityHelper != null) {
            activityHelper.onResume();
        }
        TriverContainerHelper triverContainerHelper = this.containerHelper;
        if (triverContainerHelper != null) {
            triverContainerHelper.c();
        }
    }

    public void onUserInteraction() {
        ActivityHelper activityHelper = this.activityHelper;
        if (activityHelper != null) {
            activityHelper.onUserInteraction();
        }
    }

    public void onUserLeaveHint() {
        ActivityHelper activityHelper = this.activityHelper;
        if (activityHelper != null) {
            activityHelper.onUserLeaveHint();
        }
    }
}
