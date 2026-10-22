package com.alibaba.ariver.resource.prepare.steps;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppParam;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.ariver.resource.api.preset.PresetUtils;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UpdateStep extends BasePrepareStep {
    private void a(final PrepareController prepareController, final PrepareContext prepareContext, final PrepareCallback prepareCallback) {
        a(prepareContext);
        final boolean z = prepareContext.getAppModel() != null;
        prepareContext.getPrepareData().setRequestBeginTime(System.currentTimeMillis());
        UpdateAppCallback updateAppCallback = new UpdateAppCallback() { // from class: com.alibaba.ariver.resource.prepare.steps.UpdateStep.1
            private AppModel a(List<AppModel> list) {
                if (list == null) {
                    return null;
                }
                for (AppModel appModel : list) {
                    if (TextUtils.equals(appModel.getAppInfoModel().getAppId(), prepareContext.getAppId())) {
                        return appModel;
                    }
                }
                return null;
            }

            @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
            public void onError(UpdateAppException updateAppException) {
                PrepareException prepareException;
                RVLogger.w(UpdateStep.this.LOG_TAG, "updateApp onError!", updateAppException);
                AppModel presetAppModel = PresetUtils.getPresetAppModel(prepareContext.getAppId());
                if (presetAppModel != null) {
                    RVLogger.d(UpdateStep.this.LOG_TAG, "updateApp onError but hit preset!");
                    prepareContext.setupAppInfo(presetAppModel);
                    prepareController.onGetAppInfo(presetAppModel);
                    UpdateStep.this.b(prepareContext);
                    prepareController.unlock(UpdateStep.this);
                    prepareController.moveToNext();
                    return;
                }
                if (z) {
                    PrepareContext prepareContext2 = prepareContext;
                    if (prepareContext2.updateMode != UpdateMode.SYNC_FORCE) {
                        UpdateStep.this.b(prepareContext2);
                        prepareController.unlock(UpdateStep.this);
                        prepareController.moveToNext();
                        return;
                    }
                }
                if (updateAppException == null || TextUtils.isEmpty(updateAppException.getCode())) {
                    prepareException = new PrepareException("2", "", updateAppException);
                } else {
                    prepareException = new PrepareException(updateAppException.getCode(), updateAppException.getMessage(), updateAppException);
                    prepareException.setNeedShowFail(updateAppException.isNeedShowError());
                }
                prepareController.unlock(UpdateStep.this);
                prepareController.moveToError(prepareException);
            }

            @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
            public void onSuccess(List<AppModel> list) {
                RVLogger.d(UpdateStep.this.LOG_TAG, "updateAppInfo result: " + list);
                AppModel appModelA = a(list);
                boolean z2 = appModelA != null;
                RVLogger.d(UpdateStep.this.LOG_TAG, "updateAppInfo onSuccess find target: " + z2);
                prepareContext.getPrepareData().setRequestEndTime(System.currentTimeMillis());
                if (!z2) {
                    UpdateAppException updateAppException = new UpdateAppException("1", "no app info");
                    updateAppException.setNeedShowError(true);
                    onError(updateAppException);
                } else {
                    prepareContext.setupAppInfo(appModelA);
                    prepareController.onGetAppInfo(appModelA);
                    prepareCallback.updateLoading(prepareContext.getEntryInfo());
                    prepareController.unlock(UpdateStep.this);
                    UpdateStep.this.b(prepareContext);
                    prepareController.moveToNext();
                }
            }
        };
        UpdateAppParam updateAppParam = new UpdateAppParam(prepareContext.getAppId(), null);
        updateAppParam.setForce(true);
        updateAppParam.setUpdateMode(prepareContext.updateMode);
        updateAppParam.setQueryScene(prepareContext.getAppInfoQuery().getScene());
        updateAppParam.setExtras(prepareContext.getStartParams());
        HashMap map = new HashMap();
        if (prepareContext.getAppInfoQuery().isOnlineScene()) {
            map.put(prepareContext.getAppId(), "*");
        } else {
            map.put(prepareContext.getAppId(), prepareContext.getAppInfoQuery().getVersion());
        }
        updateAppParam.setRequestApps(map);
        IAppUpdater iAppUpdaterCreateUpdater = AppUpdaterFactory.createUpdater(prepareContext.getAppId(), prepareContext.getStartParams());
        if (iAppUpdaterCreateUpdater != null) {
            iAppUpdaterCreateUpdater.updateApp(updateAppParam, updateAppCallback);
            return;
        }
        RVLogger.w(this.LOG_TAG, "cannot find IAppUpdater for " + prepareContext.getAppId() + " and param: " + prepareContext.getStartParams());
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find updater for ");
        sb.append(prepareContext.getAppId());
        prepareController.moveToError(new PrepareException("0", sb.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState("prepare 3 ").setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) throws PrepareException {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Prepare_Execute_ + getType());
        super.execute(prepareController, prepareContext, prepareCallback);
        RVLogger.d(this.LOG_TAG, "update with " + prepareContext);
        AppModel appModel = prepareContext.getAppModel();
        String version = appModel == null ? null : appModel.getAppInfoModel().getVersion();
        String string = BundleUtils.getString(prepareContext.getStartParams(), RVStartParams.LONG_NB_VERSION);
        JSONObject configJSONObject = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("h5_nbversionCfg");
        if (configJSONObject != null && configJSONObject.containsKey(prepareContext.getAppId())) {
            String string2 = configJSONObject.getString(prepareContext.getAppId());
            if (!TextUtils.isEmpty(string2) && RVResourceUtils.compareVersion(string2, string) > 0) {
                RVLogger.d(this.LOG_TAG, "wantNebulaVersion update from config: " + string2);
                prepareContext.updateMode = UpdateMode.SYNC_TRY;
                prepareContext.getStartParams().putString(RVStartParams.LONG_NB_VERSION, string2);
                string = string2;
            }
        }
        boolean z = false;
        boolean z2 = TextUtils.isEmpty(string) || RVResourceUtils.compareVersion(version, string) < 0;
        if (appModel == null || (prepareContext.updateMode.isSync() && z2)) {
            z = true;
        }
        prepareContext.getPrepareData().setRequestMode(prepareContext.updateMode);
        if (z) {
            RVLogger.d(this.LOG_TAG, "enter force updateLoadingInfo step");
            prepareCallback.showLoading(true, prepareContext.getEntryInfo());
            prepareController.postTimeOut(prepareContext.getTimeout());
            prepareController.lock(this);
            a(prepareController, prepareContext, prepareCallback);
        }
        RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare_Execute_ + getType());
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareStep
    public StepType getType() {
        return StepType.UPDATE;
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public /* bridge */ /* synthetic */ boolean isFinished() {
        return super.isFinished();
    }

    private void a(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState("prepare 2 ").setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }
}
