package com.alibaba.ariver.app.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.activity.StartAction;
import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.app.api.point.activity.ActivityHelperOnCreateFinishedPoint;
import com.alibaba.ariver.app.api.point.activity.ActivityResultPoint;
import com.alibaba.ariver.app.api.point.app.BackKeyDownPoint;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.jsapi.logging.RVPerformanceTrackerImpl;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareCallbackParam;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareData;
import com.alibaba.ariver.resource.api.prepare.PrepareException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class EmbedViewHelper implements PrepareCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23842a = "AriverApp:ActivityHelper";
    private FragmentActivity b;
    private AppNode c;
    private AppContext d;
    private boolean e;
    private PrepareContext f;
    private StartClientBundle g;
    private boolean h = false;

    /* JADX INFO: renamed from: com.alibaba.ariver.app.view.EmbedViewHelper$2, reason: invalid class name */
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

    public EmbedViewHelper(FragmentActivity fragmentActivity) {
        this.b = fragmentActivity;
    }

    public abstract AppContext createAppContext(App app, FragmentActivity fragmentActivity);

    public abstract PrepareController createPrepareController(PrepareContext prepareContext, PrepareCallback prepareCallback);

    public StartClientBundle createStartClient(PrepareCallbackParam prepareCallbackParam) {
        Bundle sceneParams = this.f.getSceneParams();
        AppModel appModel = prepareCallbackParam.appInfo;
        if (appModel != null) {
            sceneParams.putParcelable("appInfo", appModel);
        }
        if (!TextUtils.isEmpty(this.f.appType)) {
            sceneParams.putString("appType", this.f.appType);
        }
        EntryInfo entryInfo = this.f.getEntryInfo();
        if (entryInfo != null) {
            sceneParams.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        }
        sceneParams.putLong(RVConstants.EXTRA_PREPARE_START_CLIENT_TIME, SystemClock.elapsedRealtime());
        sceneParams.putBoolean(RVConstants.EXTRA_PREPARE_NEED_WAIT_IPC, prepareCallbackParam.needWaitIpc);
        Bundle startParams = this.f.getStartParams();
        ParamUtils.unify(startParams, "url", false);
        ParamUtils.parseMagicOptions(startParams, BundleUtils.getString(startParams, "url"));
        ParamUtils.unifyAll(this.f.getStartParams(), false);
        StartClientBundle startClientBundle = new StartClientBundle();
        startClientBundle.appId = this.f.getAppId();
        PrepareContext prepareContext = this.f;
        startClientBundle.appType = prepareContext.appType;
        startClientBundle.startToken = prepareContext.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN);
        startClientBundle.startParams = startParams;
        startClientBundle.sceneParams = sceneParams;
        startClientBundle.needWaitIpc = prepareCallbackParam.needWaitIpc;
        StartAction startAction = prepareCallbackParam.action;
        if (startAction != null) {
            startClientBundle.startAction = startAction;
        } else {
            startClientBundle.startAction = StartAction.DIRECT_START;
        }
        sceneParams.putLong(RVConstants.EXTRA_SETUP_END_TIMESTAMP, SystemClock.elapsedRealtime());
        return startClientBundle;
    }

    public synchronized void doCommonDestroy() {
        if (this.h) {
            return;
        }
        this.h = true;
        IpcChannelManager.getInstance().unRegisterClientChannel(this.f.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN));
        AppNode appNode = this.c;
        if (appNode == null || appNode.isDestroyed()) {
            AppContext appContext = this.d;
            if (appContext != null) {
                appContext.destroy();
            }
        } else {
            RVLogger.w(f23842a, "doCommonDestroy force mApp.destroy with count: " + this.c.getChildCount());
            this.c.exit();
        }
    }

    public void finish() {
        doCommonDestroy();
    }

    public void finishAndRemoveTask() {
        doCommonDestroy();
    }

    public StartClientBundle getStartClientBundle() {
        return this.g;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.c != null) {
            ((ActivityResultPoint) ExtensionPoint.as(ActivityResultPoint.class).node(this.c).create()).onActivityResult(i, i2, intent);
        }
    }

    public boolean onBackPressed() {
        AppNode appNode = this.c;
        if (appNode == null) {
            return false;
        }
        if (appNode.isFirstPage()) {
            RVLogger.d(f23842a, "first page onBackPressed");
            return false;
        }
        Boolean boolIntercept = ((BackKeyDownPoint) ExtensionPoint.as(BackKeyDownPoint.class).node(this.c).defaultValue(Boolean.FALSE).create()).intercept(this.c);
        if (boolIntercept == null || !boolIntercept.booleanValue()) {
            return this.c.backPressed();
        }
        return true;
    }

    public void onDestroy() {
        doCommonDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        RVLogger.d(f23842a, "onKeyDown " + i);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.c.isFirstPage()) {
                RVLogger.d(f23842a, "first page onBackPressed");
                return false;
            }
            if (this.c != null) {
                Boolean boolIntercept = ((BackKeyDownPoint) ExtensionPoint.as(BackKeyDownPoint.class).node(this.c).defaultValue(Boolean.FALSE).create()).intercept(this.c);
                if (boolIntercept == null || !boolIntercept.booleanValue()) {
                    return this.c.backPressed();
                }
                return true;
            }
            FragmentActivity fragmentActivity = this.b;
            if (fragmentActivity != null) {
                fragmentActivity.finish();
                return true;
            }
        }
        return false;
    }

    public void onPause() {
        RVLogger.d(f23842a, "onResume");
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        AppNode appNode = this.c;
        if (appNode != null && !appNode.isDestroyed()) {
            int childCount = this.c.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                Page pageByIndex = this.c.getPageByIndex(i2);
                if (pageByIndex.getPageContext() != null) {
                    pageByIndex.getPageContext().getEmbedViewManager().onRequestPermissionResult(i, strArr, iArr);
                }
            }
        }
        ((RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class)).onRequestPermissionResult(i, strArr, iArr);
    }

    public void onResume() {
        RVLogger.d(f23842a, "onResume");
        AppNode appNode = this.c;
        if (appNode != null) {
            appNode.resume();
        }
    }

    public void onStop() {
        RVLogger.d(f23842a, "onStop");
        AppNode appNode = this.c;
        if (appNode != null) {
            appNode.pause();
        }
    }

    public void onUserInteraction() {
        AppNode appNode = this.c;
        if (appNode != null) {
            appNode.onUserInteraction();
        }
    }

    public void onUserLeaveHint() {
        AppNode appNode = this.c;
        if (appNode != null) {
            appNode.onUserLeaveHint();
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareAbort() {
        RVLogger.d(f23842a, "forceFinish from stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        Bundle bundle = new Bundle();
        bundle.putString(RVConstants.EXTRA_PREPARE_ABORT_REASON, "Finish from mStartToken!");
        IpcServerUtils.sendMsgToClient(this.f.getAppId(), this.f.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN), 4, bundle);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareFail(PrepareData prepareData, PrepareException prepareException) {
        RVLogger.e(f23842a, "prepareFail!", prepareException);
        if (!this.e) {
            PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(this.f);
            prepareCallbackParam.action = StartAction.SHOW_ERROR;
            prepareCallbackParam.needWaitIpc = false;
            if (prepareCallbackParam.sceneParams == null) {
                prepareCallbackParam.sceneParams = new Bundle();
            }
            prepareCallbackParam.sceneParams.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_CODE, prepareException.getCode());
            prepareCallbackParam.sceneParams.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE, prepareException.getMessage());
            prepareCallbackParam.sceneParams.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_STAGE, prepareException.getStage());
            startApp(prepareCallbackParam);
        }
        Bundle bundle = new Bundle();
        bundle.setClassLoader(EmbedViewHelper.class.getClassLoader());
        if (prepareException != null) {
            bundle.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_CODE, prepareException.getCode());
            bundle.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE, prepareException.getMessage());
            Bundle bundle2 = new Bundle();
            bundle2.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_STAGE, prepareException.getStage());
            bundle.putBundle(RVConstants.EXTRA_PREPARE_EXCEPTION_EXTRAS, bundle2);
        }
        bundle.putParcelable(RVConstants.EXTRA_PREPARE_DATA, prepareData);
        IpcServerUtils.sendMsgToClient(this.f.getAppId(), this.f.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN), 3, bundle);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareFinish(PrepareData prepareData, @Nullable AppModel appModel, @Nullable Bundle bundle, @Nullable Bundle bundle2) {
        RVLogger.d(f23842a, "prepareFinish");
        if (!this.e) {
            PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(this.f);
            prepareCallbackParam.needWaitIpc = false;
            prepareCallbackParam.action = StartAction.DIRECT_START;
            prepareCallbackParam.startParams = bundle;
            prepareCallbackParam.sceneParams = bundle2;
            startApp(prepareCallbackParam);
        }
        Bundle bundle3 = new Bundle();
        if (bundle != null) {
            bundle3.putParcelable(RVConstants.EXTRA_START_PARAMS, bundle);
        }
        if (bundle2 != null) {
            bundle3.putParcelable(RVConstants.EXTRA_SCENE_PARAMS, bundle2);
        }
        if (appModel != null) {
            bundle3.putParcelable("appInfo", appModel);
        }
        bundle3.putParcelable(RVConstants.EXTRA_PREPARE_DATA, prepareData);
        IpcServerUtils.sendMsgToClient(this.f.getAppId(), this.f.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN), 2, bundle3);
    }

    public void renderView(String str, Bundle bundle, @Nullable Bundle bundle2) {
        Bundle bundleClone = BundleUtils.clone(bundle);
        Bundle bundleClone2 = BundleUtils.clone(bundle2);
        bundleClone.putString(RVConstants.EXTRA_LAUNCH_URL, BundleUtils.getString(bundleClone, "url"));
        bundleClone.putString("appId", str);
        bundleClone2.putLong(RVConstants.EXTRA_SETUP_TIMESTAMP, SystemClock.elapsedRealtime());
        bundleClone2.putLong(RVConstants.EXTRA_START_TOKEN, System.currentTimeMillis());
        PrepareContext prepareContext = new PrepareContext(this.b, str, bundleClone, bundleClone2);
        this.f = prepareContext;
        createPrepareController(prepareContext, this).moveToNext();
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void showLoading(boolean z, EntryInfo entryInfo) {
        RVLogger.d(f23842a, "updateLoading: " + entryInfo);
        if (!this.e) {
            PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(this.f);
            prepareCallbackParam.action = StartAction.SHOW_LOADING;
            prepareCallbackParam.needWaitIpc = true;
            startApp(prepareCallbackParam);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        bundle.putBoolean(RVConstants.EXTRA_NEED_WAIT_LOADING_ANIM, z);
        IpcServerUtils.sendMsgToClient(this.f.getAppId(), this.f.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN), 0, bundle);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void startApp(PrepareCallbackParam prepareCallbackParam) {
        if (this.e) {
            return;
        }
        this.e = true;
        this.g = createStartClient(prepareCallbackParam);
        AppNode appNode = (AppNode) ((AppManager) RVProxy.get(AppManager.class)).findAppByToken(this.g.startToken);
        this.c = appNode;
        if (appNode != null) {
            RVLogger.d(f23842a, "onCreate find quickStarted app! " + this.c);
            this.c.getStartParams().putAll(this.g.startParams);
            this.c.getSceneParams().putAll(this.g.sceneParams);
        } else {
            AppManager appManager = (AppManager) RVProxy.get(AppManager.class);
            StartClientBundle startClientBundle = this.g;
            this.c = (AppNode) appManager.startApp(startClientBundle.appId, startClientBundle.startParams, startClientBundle.sceneParams);
        }
        this.d = createAppContext(this.c, this.b);
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).init(RVPerformanceTrackerImpl.RV_PERFORMANCE_APP_STARTUP_TYPE, this.c.getAppId(), Long.valueOf(this.g.startToken), this.c.getStartUrl());
        this.c.bindContext(this.d);
        int i = AnonymousClass2.$SwitchMap$com$alibaba$ariver$app$api$activity$StartAction[this.g.startAction.ordinal()];
        if (i == 1) {
            EntryInfo entryInfo = (EntryInfo) BundleUtils.getParcelable(this.c.getSceneParams(), RVConstants.EXTRA_ENTRY_INFO);
            if (this.d.getSplashView() != null) {
                this.d.getSplashView().showLoading(entryInfo);
            }
        } else if (i == 2) {
            String string = BundleUtils.getString(this.c.getSceneParams(), RVConstants.EXTRA_PREPARE_EXCEPTION_CODE);
            String string2 = BundleUtils.getString(this.c.getSceneParams(), RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE);
            if (this.d.getSplashView() != null) {
                this.d.getSplashView().showError(string, string2, null);
            }
        } else if (i == 3) {
            this.c.start();
        }
        IpcChannelManager.getInstance().registerClientChannel(this.c.getStartToken(), new IIpcChannel.Stub() { // from class: com.alibaba.ariver.app.view.EmbedViewHelper.1
            @Override // com.alibaba.ariver.kernel.api.IIpcChannel
            public boolean isFinishing() {
                return EmbedViewHelper.this.b.isFinishing();
            }

            @Override // com.alibaba.ariver.kernel.api.IIpcChannel
            public void sendMessage(IpcMessage ipcMessage) {
                ClientMsgReceiver.getInstance().handleMessage(ipcMessage);
            }
        });
        ((ActivityHelperOnCreateFinishedPoint) ExtensionPoint.as(ActivityHelperOnCreateFinishedPoint.class).node(this.c).create()).onActivityHelperOnCreateFinished(this.c, this.b, this.g);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void updateLoading(EntryInfo entryInfo) {
        RVLogger.d(f23842a, "updateLoading: " + entryInfo);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        IpcServerUtils.sendMsgToClient(this.f.getAppId(), this.f.getSceneParams().getLong(RVConstants.EXTRA_START_TOKEN), 1, bundle);
    }
}
