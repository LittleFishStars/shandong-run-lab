package com.alibaba.ariver.integration.resource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.activity.StartAction;
import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.integration.proxy.RVClientStarter;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareCallbackParam;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareData;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.content.ResourceUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements PrepareCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final String f24090a = "AriverInt:PrepareCallback";
    protected final RVAppRecord b;
    protected boolean c;
    protected PrepareContext d;

    public a(RVAppRecord rVAppRecord, PrepareContext prepareContext) {
        this(rVAppRecord, prepareContext, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PrepareData prepareData, PrepareException prepareException) {
        if (!this.c) {
            PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(this.d);
            prepareCallbackParam.action = StartAction.SHOW_ERROR;
            prepareCallbackParam.needWaitIpc = false;
            if (prepareCallbackParam.sceneParams == null) {
                prepareCallbackParam.sceneParams = new Bundle();
            }
            prepareCallbackParam.sceneParams.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_CODE, prepareException.getCode());
            prepareCallbackParam.sceneParams.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE, prepareException.getMessage());
            prepareCallbackParam.sceneParams.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_STAGE, prepareException.getStage());
            Bundle bundle = new Bundle();
            if (prepareException.getCause() instanceof UpdateAppException) {
                UpdateAppException updateAppException = (UpdateAppException) prepareException.getCause();
                if (updateAppException.getExtras() != null) {
                    for (String str : updateAppException.getExtras().keySet()) {
                        if (str != null) {
                            bundle.putString(str, updateAppException.getExtras().get(str));
                        }
                    }
                }
            }
            prepareCallbackParam.sceneParams.putBundle(RVConstants.EXTRA_PREPARE_EXCEPTION_EXTRAS, bundle);
            startApp(prepareCallbackParam);
        }
        a(prepareData, prepareException);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareAbort() {
        RVLogger.d(f24090a, "forceFinish from stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        Bundle bundle = new Bundle();
        bundle.putString(RVConstants.EXTRA_PREPARE_ABORT_REASON, "Finish from mStartToken!");
        IpcServerUtils.sendMsgToClient(this.b.getAppId(), this.b.getStartToken(), 4, bundle);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareFail(final PrepareData prepareData, final PrepareException prepareException) {
        RVLogger.e(f24090a, "prepareFail!", prepareException);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.integration.resource.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(prepareData, prepareException);
            }
        });
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public synchronized void prepareFinish(PrepareData prepareData, @Nullable AppModel appModel, @Nullable Bundle bundle, @Nullable Bundle bundle2) {
        RVLogger.d(f24090a, "prepareFinish");
        IpcServerUtils.addStubToClient(this.d.getAppId(), this.d.getStartToken(), "PrepareStep_Finish", SystemClock.elapsedRealtime());
        a(bundle);
        if (!this.c) {
            PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(this.d);
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
            bundle2.putString("appType", this.d.appType);
            bundle3.putParcelable(RVConstants.EXTRA_SCENE_PARAMS, bundle2);
        }
        if (appModel != null) {
            bundle3.putParcelable("appInfo", appModel);
        }
        bundle3.putParcelable(RVConstants.EXTRA_PREPARE_DATA, prepareData);
        IpcServerUtils.sendMsgToClient(this.b.getAppId(), this.b.getStartToken(), 2, bundle3);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void showLoading(final boolean z, final EntryInfo entryInfo) {
        RVLogger.d(f24090a, "updateLoading: " + entryInfo);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.integration.resource.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(z, entryInfo);
            }
        });
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public synchronized void startApp(PrepareCallbackParam prepareCallbackParam) {
        if (this.c) {
            return;
        }
        this.c = true;
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Prepare_StartClient);
        Intent intent = new Intent();
        intent.putExtra(RVConstants.EXTRA_ARIVER_START_BUNDLE, a(prepareCallbackParam));
        this.b.setLastStartClientTimeStamp(SystemClock.elapsedRealtime());
        Class<? extends Activity> clsStartClient = ((RVClientStarter) RVProxy.get(RVClientStarter.class)).startClient(this.d.getStartContext(), this.b, intent);
        RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare_StartClient);
        this.b.setActivityClz(clsStartClient);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void updateLoading(EntryInfo entryInfo) {
        RVLogger.d(f24090a, "updateLoading: " + entryInfo);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        IpcServerUtils.sendMsgToClient(this.b.getAppId(), this.b.getStartToken(), 1, bundle);
    }

    public a(RVAppRecord rVAppRecord, PrepareContext prepareContext, boolean z) {
        this.d = prepareContext;
        this.b = rVAppRecord;
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, EntryInfo entryInfo) {
        if (!this.c) {
            PrepareCallbackParam prepareCallbackParam = new PrepareCallbackParam(this.d);
            prepareCallbackParam.action = StartAction.SHOW_LOADING;
            prepareCallbackParam.needWaitIpc = true;
            startApp(prepareCallbackParam);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        bundle.putBoolean(RVConstants.EXTRA_NEED_WAIT_LOADING_ANIM, z);
        IpcServerUtils.sendMsgToClient(this.b.getAppId(), this.b.getStartToken(), 0, bundle);
    }

    public void a(PrepareData prepareData, PrepareException prepareException) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(a.class.getClassLoader());
        if (prepareException != null) {
            bundle.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_CODE, prepareException.getCode());
            bundle.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE, prepareException.getMessage());
            Bundle bundle2 = new Bundle();
            if (prepareException.getCause() instanceof UpdateAppException) {
                UpdateAppException updateAppException = (UpdateAppException) prepareException.getCause();
                if (updateAppException.getExtras() != null) {
                    for (String str : updateAppException.getExtras().keySet()) {
                        if (str != null) {
                            bundle2.putString(str, updateAppException.getExtras().get(str));
                        }
                    }
                }
            }
            bundle2.putString(RVConstants.EXTRA_PREPARE_EXCEPTION_STAGE, prepareException.getStage());
            bundle.putBundle(RVConstants.EXTRA_PREPARE_EXCEPTION_EXTRAS, bundle2);
        }
        bundle.putParcelable(RVConstants.EXTRA_PREPARE_DATA, prepareData);
        if (this.d.getAppModel() != null) {
            bundle.putParcelable("appInfo", this.d.getAppModel());
        }
        IpcServerUtils.sendMsgToClient(this.b.getAppId(), this.b.getStartToken(), 3, bundle);
    }

    public StartClientBundle a(PrepareCallbackParam prepareCallbackParam) {
        Bundle sceneParams = this.b.getSceneParams();
        AppModel appModel = prepareCallbackParam.appInfo;
        if (appModel != null) {
            sceneParams.putParcelable("appInfo", appModel);
            this.b.setAppModel(prepareCallbackParam.appInfo);
        }
        if (!TextUtils.isEmpty(this.d.appType)) {
            sceneParams.putString("appType", this.d.appType);
        }
        EntryInfo entryInfo = this.d.getEntryInfo();
        if (entryInfo == null) {
            entryInfo = ResourceUtils.getEntryInfo(prepareCallbackParam.appInfo);
        }
        if (entryInfo != null) {
            sceneParams.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        }
        sceneParams.putLong(RVConstants.EXTRA_PREPARE_START_CLIENT_TIME, SystemClock.elapsedRealtime());
        sceneParams.putBoolean(RVConstants.EXTRA_PREPARE_NEED_WAIT_IPC, prepareCallbackParam.needWaitIpc);
        Bundle startParams = this.d.getStartParams();
        ParamUtils.unify(startParams, "url", false);
        ParamUtils.parseMagicOptions(startParams, BundleUtils.getString(startParams, "url"));
        ParamUtils.unifyAll(this.b.getStartParams(), false);
        ParamUtils.unifyAll(startParams, false);
        StartClientBundle startClientBundle = new StartClientBundle();
        startClientBundle.appId = this.b.getAppId();
        startClientBundle.appType = this.d.appType;
        startClientBundle.startToken = this.b.getStartToken();
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

    private void a(Bundle bundle) {
        AppInfoModel appInfoModel;
        if (bundle == null) {
            return;
        }
        try {
            AppModel appModel = this.d.getAppModel();
            if (appModel == null || (appInfoModel = appModel.getAppInfoModel()) == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(appModel.getAppId());
            sb.append("(name:");
            sb.append(appInfoModel.getName());
            sb.append(" version:");
            sb.append(appModel.getAppVersion());
            if (!"WEB_H5".equals(this.d.appType)) {
                ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage(RVConstants.TINY_WEB_COMMON_APPID);
                String strVersion = resourcePackage != null ? resourcePackage.version() : null;
                if (!TextUtils.isEmpty(strVersion)) {
                    sb.append(" appx:");
                    sb.append(strVersion);
                }
            }
            sb.append(")");
            AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_PREPARE_FINISH).setAppId(sb.toString()).setParentId(BundleUtils.getString(bundle, RVParams.START_APP_SESSION_ID)).setDesc(appModel.toString()).build());
        } catch (Exception e) {
            RVLogger.e(f24090a, "onPkgPrepareFinish error ", e);
        }
    }
}
