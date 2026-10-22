package com.alibaba.ariver.resource.prepare.steps;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTracePhase;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.resource.api.PackageDownloadCallback;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.PluginDownloadCallback;
import com.alibaba.ariver.resource.api.PluginInstallCallback;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.fastjson.JSONArray;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DownloadStep extends BasePrepareStep {
    public static final String SPLIT = "|";
    public static final String STAGE_PLUGIN = "Plugin";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f24459a = new AtomicInteger(1);

    public class MyPackageDownloadCallback implements PackageDownloadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrepareContext f24460a;
        private final PrepareController b;
        private final int c;
        private final String d;

        public MyPackageDownloadCallback(PrepareContext prepareContext, PrepareController prepareController, String str, int i) {
            this.f24460a = prepareContext;
            this.b = prepareController;
            this.d = str;
            this.c = i;
        }

        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
        public void onCancel(String str) {
        }

        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
        public void onFailed(String str, int i, String str2) {
            RVLogger.d(DownloadStep.this.LOG_TAG, "downloadPackage " + i + " " + str2);
            this.f24460a.getPrepareData().setDownloadEndTime(System.currentTimeMillis());
            this.b.moveToError(new PrepareException("4", i + "|" + str2));
        }

        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
        public void onFinish(@Nullable String str) {
            RVLogger.d(DownloadStep.this.LOG_TAG, "downloadPackage onFinish");
            RVTraceUtils.asyncTraceEnd(this.d, this.c);
            DownloadStep.this.onDownloadFinish(this.f24460a);
            this.f24460a.getPrepareData().setDownloadEndTime(System.currentTimeMillis());
            this.f24460a.getPrepareData().setInstallTime(System.currentTimeMillis());
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.MyPackageDownloadCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    MyPackageDownloadCallback myPackageDownloadCallback = MyPackageDownloadCallback.this;
                    DownloadStep.this.onInstallStart(myPackageDownloadCallback.f24460a);
                    MyPackageDownloadCallback myPackageDownloadCallback2 = MyPackageDownloadCallback.this;
                    DownloadStep.this.resourceManager.installApp(myPackageDownloadCallback2.f24460a.getAppModel(), new PackageInstallCallback() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.MyPackageDownloadCallback.1.1
                        @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
                        public void onResult(boolean z, String str2) {
                            MyPackageDownloadCallback.this.f24460a.getPrepareData().setInstallEndTime(System.currentTimeMillis());
                            RVLogger.d(DownloadStep.this.LOG_TAG, "downloadPackage installResult " + z);
                            if (!z) {
                                MyPackageDownloadCallback.this.b.moveToError(new PrepareException("5", "unzip exception"));
                                return;
                            }
                            MyPackageDownloadCallback myPackageDownloadCallback3 = MyPackageDownloadCallback.this;
                            DownloadStep.this.onInstallFinish(myPackageDownloadCallback3.f24460a);
                            MyPackageDownloadCallback myPackageDownloadCallback4 = MyPackageDownloadCallback.this;
                            DownloadStep.this.unlockAndMoveToNext(myPackageDownloadCallback4.b);
                        }
                    });
                }
            });
        }

        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
        public void onPrepare(String str) {
        }

        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
        public void onProgress(String str, int i) {
        }
    }

    public class MyPluginDownloadCallback implements PluginDownloadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrepareContext f24461a;
        private final PrepareController b;
        private final List<PluginModel> c;

        public MyPluginDownloadCallback(List<PluginModel> list, PrepareContext prepareContext, PrepareController prepareController) {
            this.c = list;
            this.f24461a = prepareContext;
            this.b = prepareController;
        }

        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
        public void onFailed(int i, String str) {
            this.f24461a.getPrepareData().setDownloadEndTime(System.currentTimeMillis());
            RVLogger.w(DownloadStep.this.LOG_TAG, "onFailed " + i + " " + str);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("|");
            sb.append(str);
            PrepareException prepareException = new PrepareException("4", sb.toString());
            prepareException.setStage(StepType.OFFLINE.name() + "Plugin");
            this.b.moveToError(prepareException);
        }

        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
        public void onSingleFailed(PluginModel pluginModel, int i, String str) {
        }

        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
        public void onSuccess() {
            this.f24461a.getPrepareData().setDownloadEndTime(System.currentTimeMillis());
            this.f24461a.getPrepareData().setInstallTime(System.currentTimeMillis());
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.MyPluginDownloadCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    ((RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class)).installPlugins(MyPluginDownloadCallback.this.c, new PluginInstallCallback() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.MyPluginDownloadCallback.1.1
                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onFailed(int i, String str) {
                            RVLogger.w(DownloadStep.this.LOG_TAG, "installPlugins onFailed " + i + ", " + str);
                            PrepareException prepareException = new PrepareException("5", "unzip exception");
                            StringBuilder sb = new StringBuilder();
                            sb.append(StepType.OFFLINE.name());
                            sb.append("Plugin");
                            prepareException.setStage(sb.toString());
                            MyPluginDownloadCallback.this.b.moveToError(prepareException);
                        }

                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onSingleFailed(PluginModel pluginModel, int i, String str) {
                        }

                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onSuccess(List<Pair<PluginModel, String>> list) {
                            RVLogger.d(DownloadStep.this.LOG_TAG, "installPlugins onSuccess");
                            MyPluginDownloadCallback.this.f24461a.getPrepareData().setInstallEndTime(System.currentTimeMillis());
                            MyPluginDownloadCallback myPluginDownloadCallback = MyPluginDownloadCallback.this;
                            DownloadStep.this.unlockAndMoveToNext(myPluginDownloadCallback.b);
                        }
                    });
                }
            });
        }
    }

    private void a(final PrepareController prepareController, final PrepareContext prepareContext, final PrepareCallback prepareCallback) {
        final AppModel appModel = prepareContext.getAppModel();
        if (appModel == null) {
            unlockAndMoveToNext(prepareController);
            return;
        }
        if (appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getPlugins() == null || appModel.getAppInfoModel().getPlugins().size() <= 0) {
            RVLogger.d(this.LOG_TAG, "doSyncOffline without plugins!");
            checkMainPackage(prepareController, prepareContext, prepareCallback);
            return;
        }
        this.f24459a.addAndGet(1);
        RVLogger.d(this.LOG_TAG, "doSyncOffline with plugins!");
        ExecutorType executorType = ExecutorType.URGENT;
        ExecutorUtils.execute(executorType, new Runnable() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadStep.this.checkMainPackage(prepareController, prepareContext, prepareCallback);
            }
        });
        ExecutorUtils.execute(executorType, new Runnable() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadStep.this.a(appModel.getAppInfoModel().getPlugins(), prepareController, prepareContext, prepareCallback);
            }
        });
    }

    public void checkMainPackage(final PrepareController prepareController, final PrepareContext prepareContext, PrepareCallback prepareCallback) {
        if (this.resourceManager.isAvailable(prepareContext.getAppModel())) {
            unlockAndMoveToNext(prepareController);
            return;
        }
        boolean zIsDownloaded = this.resourceManager.isDownloaded(prepareContext.getAppModel());
        RVLogger.d(this.LOG_TAG, "offlineMode " + prepareContext.offlineMode + " isDownloaded " + zIsDownloaded);
        if (zIsDownloaded) {
            prepareContext.getPrepareData().setInstallTime(System.currentTimeMillis());
            onInstallStart(prepareContext);
            this.resourceManager.installApp(prepareContext.getAppModel(), new PackageInstallCallback() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.3
                @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
                public void onResult(boolean z, String str) {
                    prepareContext.getPrepareData().setInstallEndTime(System.currentTimeMillis());
                    RVLogger.d(DownloadStep.this.LOG_TAG, "install result:" + z);
                    if (!z) {
                        prepareController.moveToError(new PrepareException("5", "unzip exception"));
                    } else {
                        DownloadStep.this.onInstallFinish(prepareContext);
                        DownloadStep.this.unlockAndMoveToNext(prepareController);
                    }
                }
            });
            return;
        }
        AppModel appModel = prepareContext.getAppModel();
        if (a(prepareContext.getStartParams(), appModel)) {
            prepareContext.getSceneParams().putBoolean(RVConstants.EXTRA_USING_FALLBACK_START, true);
            Bundle bundle = new Bundle();
            bundle.putParcelable(IpcMessageConstants.EXTRA_FALLBACK_APP_MODEL, appModel);
            IpcServerUtils.sendMsgToClient(prepareContext.getAppId(), prepareContext.getStartToken(), 14, bundle);
            unlockAndMoveToNext(prepareController);
            return;
        }
        prepareController.postTimeOut(prepareContext.getTimeout());
        prepareCallback.showLoading(true, prepareContext.getEntryInfo());
        prepareContext.getPrepareData().setDownloadTime(System.currentTimeMillis());
        onDownloadStart(prepareContext);
        String str = RVTraceKey.RV_Download_App_ + prepareContext.getAppModel().getAppId();
        int i = RVTracePhase.cookieSeed;
        RVTracePhase.cookieSeed = i + 1;
        RVTraceUtils.asyncTraceBegin(str, i);
        this.resourceManager.downloadApp(prepareContext.getAppModel(), true, new MyPackageDownloadCallback(prepareContext, prepareController, str, i));
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) throws PrepareException {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Prepare_Execute_ + getType());
        super.execute(prepareController, prepareContext, prepareCallback);
        prepareContext.getPrepareData().setOfflineMode(prepareContext.offlineMode);
        if (prepareContext.offlineMode.isSync()) {
            prepareController.lock(this);
            a(prepareController, prepareContext, prepareCallback);
            return;
        }
        RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare_Execute_ + getType());
        RVLogger.e(this.LOG_TAG, "offlineMode is not Sync!");
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareStep
    public StepType getType() {
        return StepType.OFFLINE;
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public /* bridge */ /* synthetic */ boolean isFinished() {
        return super.isFinished();
    }

    public void onDownloadFinish(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState("prepare 5 ").setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }

    public void onDownloadStart(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState("prepare 4 ").setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }

    public void onInstallFinish(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState("prepare 7 ").setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }

    public void onInstallStart(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState("prepare 6 ").setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }

    public void unlockAndMoveToNext(PrepareController prepareController) {
        RVLogger.d(this.LOG_TAG, "unLockAndMoveToNext with countDownTime: " + this.f24459a);
        if (this.f24459a.decrementAndGet() == 0) {
            prepareController.unlock(this);
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare_Execute_ + getType());
            prepareController.moveToNext();
        }
    }

    private boolean a(Bundle bundle, AppModel appModel) {
        if (appModel == null || appModel.getAppInfoModel() == null) {
            return false;
        }
        if ((appModel.getAppInfoModel().getTemplateConfig() != null && appModel.getAppInfoModel().getTemplateConfig().isTemplateValid()) || TextUtils.isEmpty(appModel.getAppInfoModel().getFallbackBaseUrl())) {
            return false;
        }
        if ("YES".equalsIgnoreCase(BundleUtils.getString(bundle, RVStartParams.KEY_CAN_FALLBACK))) {
            return true;
        }
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ariver_enableFallbackList");
        if (configJSONArray == null) {
            return false;
        }
        return configJSONArray.contains("*") || configJSONArray.contains(appModel.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<PluginModel> list, PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) {
        RVPluginResourceManager rVPluginResourceManager = (RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class);
        if (rVPluginResourceManager.isAvailable(list)) {
            a(prepareContext);
            unlockAndMoveToNext(prepareController);
            return;
        }
        RVLogger.d(this.LOG_TAG, "checkPlugins plugin not all available!");
        prepareController.postTimeOut(prepareContext.getTimeout());
        prepareCallback.showLoading(true, prepareContext.getEntryInfo());
        prepareContext.getPrepareData().setDownloadTime(System.currentTimeMillis());
        rVPluginResourceManager.downloadPlugins(list, new MyPluginDownloadCallback(list, prepareContext, prepareController));
    }

    private void a(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_DOWNGRADE).setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }
}
