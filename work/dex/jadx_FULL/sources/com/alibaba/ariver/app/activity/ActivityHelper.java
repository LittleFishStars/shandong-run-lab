package com.alibaba.ariver.app.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.activity.ActivityAnimBean;
import com.alibaba.ariver.app.api.activity.StartAction;
import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.app.api.point.activity.ActivityHelperOnCreateFinishedPoint;
import com.alibaba.ariver.app.api.point.activity.ActivityResultPoint;
import com.alibaba.ariver.app.api.point.app.BackKeyDownPoint;
import com.alibaba.ariver.app.api.ui.StatusBarUtils;
import com.alibaba.ariver.app.api.ui.loading.SplashUtils;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.jsapi.logging.RVPerformanceTrackerImpl;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public abstract class ActivityHelper {
    private static final String LOG_TAG = "AriverApp:ActivityHelper";
    private FragmentActivity mActivity;
    private ActivityAnimBean mActivityAnimBean;
    private boolean mAlreadyDoDestroyed = false;
    protected AppNode mApp;
    protected AppContext mAppContext;
    private boolean mCloseAllAnim;
    private boolean mOnCreateWithIllegalState;
    private StartClientBundle mStartClientBundle;
    private long mStartToken;

    /* JADX INFO: renamed from: com.alibaba.ariver.app.activity.ActivityHelper$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$app$api$activity$StartAction;

        static {
            int[] iArr = new int[StartAction.values().length];
            $SwitchMap$com$alibaba$ariver$app$api$activity$StartAction = iArr;
            try {
                iArr[StartAction.SHOW_LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$activity$StartAction[StartAction.SHOW_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$activity$StartAction[StartAction.DIRECT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ActivityHelper(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
    }

    private void handleStartParams() {
        RVLogger.d(LOG_TAG, "NebulaActivity.onCreate handleStartParams start");
        try {
            this.mActivity.requestWindowFeature(1);
        } catch (Throwable th) {
            RVLogger.w(LOG_TAG, "requestWindowFeature error: ", th);
        }
        String string = BundleUtils.getString(this.mStartClientBundle.startParams, RVStartParams.KEY_ENABLE_SNAPSHOT);
        if ("NO".equalsIgnoreCase(string)) {
            RVLogger.d(LOG_TAG, "not allowed to task snapshot " + string);
            this.mActivity.getWindow().addFlags(8192);
        }
        if (BundleUtils.getBoolean(this.mStartClientBundle.startParams, "fullscreen", false)) {
            this.mActivity.getWindow().setFlags(1024, 1024);
        }
        String string2 = BundleUtils.getString(this.mStartClientBundle.startParams, "landscape");
        if (string2.equals("landscape")) {
            if (this.mActivity.getRequestedOrientation() != 0) {
                this.mActivity.setRequestedOrientation(0);
            }
        } else if (string2.equals("auto") && this.mActivity.getRequestedOrientation() != -1) {
            this.mActivity.setRequestedOrientation(-1);
        }
        boolean z = BundleUtils.getBoolean(this.mStartClientBundle.startParams, RVStartParams.KEY_RESTART, false);
        this.mCloseAllAnim = BundleUtils.getBoolean(this.mStartClientBundle.startParams, RVStartParams.KEY_CLOSE_ALL_ACTIVITY_ANIMATION, false);
        this.mActivityAnimBean = (ActivityAnimBean) BundleUtils.getParcelable(this.mStartClientBundle.sceneParams, RVConstants.EXTRA_ACTIVITY_ANIM_BEAN);
        RVLogger.d(LOG_TAG, "onCreate with animBean: " + this.mActivityAnimBean);
        if (z) {
            RVLogger.d(LOG_TAG, "onCreate disable animBean fromRestart.");
            ActivityAnimBean activityAnimBean = this.mActivityAnimBean;
            if (activityAnimBean != null) {
                activityAnimBean.enter = 0;
            } else {
                this.mActivity.overridePendingTransition(0, 0);
            }
        }
        if (this.mCloseAllAnim || this.mOnCreateWithIllegalState) {
            this.mActivity.overridePendingTransition(0, 0);
        } else {
            ActivityAnimBean activityAnimBean2 = this.mActivityAnimBean;
            if (activityAnimBean2 != null) {
                this.mActivity.overridePendingTransition(activityAnimBean2.enter, activityAnimBean2.exit);
            }
        }
        RVLogger.d(LOG_TAG, "onCreate handleStartParams done.");
    }

    public abstract AppContext createAppContext(App app, FragmentActivity fragmentActivity);

    public synchronized void doCommonDestroy() {
        if (this.mAlreadyDoDestroyed) {
            return;
        }
        this.mAlreadyDoDestroyed = true;
        if (this.mApp == null) {
            RVLogger.w(LOG_TAG, "doCommonDestroy but mApp == null!");
            return;
        }
        if (this.mCloseAllAnim) {
            this.mActivity.overridePendingTransition(0, 0);
        } else {
            ActivityAnimBean activityAnimBean = this.mActivityAnimBean;
            if (activityAnimBean != null && activityAnimBean.needPopAnim) {
                this.mActivity.overridePendingTransition(activityAnimBean.popEnter, activityAnimBean.popExit);
            }
        }
        IpcChannelManager.getInstance().unRegisterClientChannel(this.mStartToken);
        AppNode appNode = this.mApp;
        if (appNode == null || appNode.isDestroyed()) {
            this.mAppContext.destroy();
        } else {
            int childCount = this.mApp.getChildCount();
            RVLogger.w(LOG_TAG, "doCommonDestroy force mApp.destroy with count: " + childCount);
            if (childCount == 0) {
                this.mApp.exit();
            }
        }
    }

    public void finish() {
        doCommonDestroy();
    }

    public void finishAndRemoveTask() {
        doCommonDestroy();
    }

    public App getApp() {
        return this.mApp;
    }

    public StartClientBundle getStartClientBundle() {
        return this.mStartClientBundle;
    }

    public boolean handleStartClientBundleNull() {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ((ActivityResultPoint) ExtensionPoint.as(ActivityResultPoint.class).node(this.mApp).create()).onActivityResult(i, i2, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        RVLogger.d(LOG_TAG, "onConfigurationChanged: " + configuration);
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.onConfigurationChanged(configuration);
        }
    }

    public void onCreate() {
        if (this.mStartClientBundle == null) {
            RVLogger.w(LOG_TAG, "onCreate but mStartClientBundle == null! do nothing!");
            return;
        }
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_ActivityHelper_onCreate);
        AppNode appNode = (AppNode) ((AppManager) RVProxy.get(AppManager.class)).findAppByToken(this.mStartToken);
        this.mApp = appNode;
        if (appNode == null || !appNode.isInited()) {
            AppManager appManager = (AppManager) RVProxy.get(AppManager.class);
            StartClientBundle startClientBundle = this.mStartClientBundle;
            this.mApp = (AppNode) appManager.startApp(startClientBundle.appId, startClientBundle.startParams, startClientBundle.sceneParams);
        } else {
            RVLogger.d(LOG_TAG, "onCreate find quickStarted app! " + this.mApp + " appId from Param: " + BundleUtils.getString(this.mApp.getStartParams(), "appId"));
        }
        this.mAppContext = createAppContext(this.mApp, this.mActivity);
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).init(RVPerformanceTrackerImpl.RV_PERFORMANCE_APP_STARTUP_TYPE, this.mApp.getAppId(), Long.valueOf(this.mStartToken), this.mApp.getStartUrl());
        this.mApp.bindContext(this.mAppContext);
        EntryInfo entryInfo = (EntryInfo) BundleUtils.getParcelable(this.mApp.getSceneParams(), RVConstants.EXTRA_ENTRY_INFO);
        int i = AnonymousClass2.$SwitchMap$com$alibaba$ariver$app$api$activity$StartAction[this.mStartClientBundle.startAction.ordinal()];
        if (i != 1) {
            if (i == 2) {
                String string = BundleUtils.getString(this.mApp.getSceneParams(), RVConstants.EXTRA_PREPARE_EXCEPTION_CODE);
                String string2 = BundleUtils.getString(this.mApp.getSceneParams(), RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE);
                String string3 = BundleUtils.getString(this.mApp.getSceneParams(), RVConstants.EXTRA_PREPARE_EXCEPTION_STAGE);
                if (this.mAppContext.getSplashView() != null) {
                    HashMap map = new HashMap();
                    map.put(RVConstants.EXTRA_PREPARE_EXCEPTION_STAGE, string3);
                    Bundle bundle = this.mApp.getSceneParams().getBundle(RVConstants.EXTRA_PREPARE_EXCEPTION_EXTRAS);
                    if (bundle != null) {
                        for (String str : bundle.keySet()) {
                            if (str != null) {
                                map.put(str, bundle.getString(str));
                            }
                        }
                    }
                    this.mAppContext.getSplashView().showError(string, string2, map);
                }
            } else if (i == 3) {
                if (SplashUtils.useSuperSplash(this.mStartClientBundle.startParams)) {
                    RVLogger.d(LOG_TAG, " showLoading by superSplash!");
                    this.mAppContext.getSplashView().showLoading(entryInfo);
                }
                this.mApp.start();
            }
        } else if (this.mAppContext.getSplashView() != null) {
            this.mAppContext.getSplashView().showLoading(entryInfo);
        }
        if (ProcessUtils.isMainProcess()) {
            IpcChannelManager.getInstance().registerClientChannel(getApp().getStartToken(), new IIpcChannel.Stub() { // from class: com.alibaba.ariver.app.activity.ActivityHelper.1
                @Override // com.alibaba.ariver.kernel.api.IIpcChannel
                public boolean isFinishing() {
                    AppNode appNode2;
                    return ActivityHelper.this.mAlreadyDoDestroyed || (appNode2 = ActivityHelper.this.mApp) == null || appNode2.isExited() || ActivityHelper.this.mActivity.isFinishing();
                }

                @Override // com.alibaba.ariver.kernel.api.IIpcChannel
                public void sendMessage(final IpcMessage ipcMessage) {
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.activity.ActivityHelper.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ClientMsgReceiver.getInstance().handleMessage(ipcMessage);
                        }
                    });
                }
            });
        }
        ((ActivityHelperOnCreateFinishedPoint) ExtensionPoint.as(ActivityHelperOnCreateFinishedPoint.class).node(this.mApp).create()).onActivityHelperOnCreateFinished(this.mApp, this.mActivity, this.mStartClientBundle);
        RVTraceUtils.traceEndSection(RVTraceKey.RV_ActivityHelper_onCreate);
    }

    public void onDestroy() {
        doCommonDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        RVLogger.d(LOG_TAG, "onKeyDown " + i);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.mApp != null) {
                Boolean boolIntercept = ((BackKeyDownPoint) ExtensionPoint.as(BackKeyDownPoint.class).node(this.mApp).defaultValue(Boolean.FALSE).create()).intercept(this.mApp);
                if (boolIntercept == null || !boolIntercept.booleanValue()) {
                    return this.mApp.backPressed();
                }
                return true;
            }
            FragmentActivity fragmentActivity = this.mActivity;
            if (fragmentActivity != null) {
                fragmentActivity.finish();
                return true;
            }
        }
        return false;
    }

    public void onNewIntent(Intent intent) {
        ActivityAnimBean activityAnimBean;
        RVLogger.d(LOG_TAG, "onNewIntent with intent: " + intent);
        if (this.mApp == null) {
            return;
        }
        if (intent.getBooleanExtra(RVConstants.EXTRA_NEED_START_ANIM, true) && (activityAnimBean = this.mActivityAnimBean) != null && activityAnimBean.needRestartAnim) {
            this.mActivity.overridePendingTransition(activityAnimBean.enterFast, activityAnimBean.exitFast);
        }
        Bundle extras = intent.getExtras();
        if (extras == null || intent.getBooleanExtra("IS_LITE_MOVE_TASK", false)) {
            return;
        }
        Bundle bundle = (Bundle) BundleUtils.getParcelable(extras, RVConstants.EXTRA_START_PARAMS);
        Bundle bundle2 = (Bundle) BundleUtils.getParcelable(extras, RVConstants.EXTRA_SCENE_PARAMS);
        if (bundle != null) {
            this.mApp.restart(bundle, bundle2);
        }
    }

    public void onPause() {
        RVLogger.d(LOG_TAG, "onPause");
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        AppNode appNode = this.mApp;
        if (appNode != null && !appNode.isDestroyed()) {
            int childCount = this.mApp.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                Page pageByIndex = this.mApp.getPageByIndex(i2);
                if (pageByIndex.getPageContext() != null) {
                    pageByIndex.getPageContext().getEmbedViewManager().onRequestPermissionResult(i, strArr, iArr);
                }
            }
        }
        ((RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class)).onRequestPermissionResult(i, strArr, iArr);
    }

    public void onResume() {
        RVLogger.d(LOG_TAG, "onResume");
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.resume();
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.mApp, TrackId.Stub_Activity_OnResume);
        }
    }

    public void onStop() {
        RVLogger.d(LOG_TAG, "onStop");
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.pause();
        }
    }

    public void onUserInteraction() {
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.onUserInteraction();
        }
    }

    public void onUserLeaveHint() {
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.onUserLeaveHint();
        }
    }

    public void setupParams(Intent intent) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_ActivityHelper_setupParams);
        if (intent != null) {
            try {
                if (intent.getExtras() != null) {
                    intent.getExtras().setClassLoader(ActivityHelper.class.getClassLoader());
                    this.mStartClientBundle = (StartClientBundle) BundleUtils.getParcelable(intent.getExtras(), RVConstants.EXTRA_ARIVER_START_BUNDLE);
                    this.mOnCreateWithIllegalState = (intent.getFlags() & 1048576) != 0;
                    RVLogger.d(LOG_TAG, "onCreate " + this.mActivity.getClass().getName() + " with " + this.mStartClientBundle);
                    if (this.mStartClientBundle == null) {
                        if (!handleStartClientBundleNull()) {
                            throw new IllegalStateException("onCreate start bundle null!!");
                        }
                        RVLogger.d(LOG_TAG, "onCreate mStartClientBundle == null, handle by handleStartClientBundleNull!");
                        RVTraceUtils.traceEndSection(RVTraceKey.RV_ActivityHelper_setupParams);
                        return;
                    }
                    if (StatusBarUtils.isSupport() && StatusBarUtils.isConfigSupport() && BundleUtils.getBoolean(this.mStartClientBundle.startParams, RVStartParams.KEY_SUPPORT_STATUS_BAR, true)) {
                        StatusBarUtils.setTransparentColor(this.mActivity, 855638016);
                    }
                    handleStartParams();
                    this.mStartToken = this.mStartClientBundle.startToken;
                    RVTraceUtils.traceEndSection(RVTraceKey.RV_ActivityHelper_setupParams);
                    return;
                }
            } catch (Throwable th) {
                RVTraceUtils.traceEndSection(RVTraceKey.RV_ActivityHelper_setupParams);
                throw th;
            }
        }
        throw new IllegalStateException("onCreate intent null!!");
    }
}
