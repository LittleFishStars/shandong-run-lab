package com.alibaba.ariver.resource.prepare.steps;

import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.OfflineMode;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SetupStep extends BasePrepareStep {
    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) throws PrepareException {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Prepare_Execute_ + getType());
        prepareContext.getPrepareData().setBeginTime(SystemClock.elapsedRealtime());
        super.execute(prepareController, prepareContext, prepareCallback);
        String appId = prepareContext.getAppId();
        AppLogger.log(new AppLog.Builder().setState("prepare 1 ").setAppId(appId).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
        prepareContext.getStartParams().putString("appId", appId);
        AppInfoQuery appInfoQuery = new AppInfoQuery(appId);
        if (AppInfoScene.isDevSource(prepareContext.getStartParams())) {
            appInfoQuery.scene(AppInfoScene.extractScene(prepareContext.getStartParams()));
            appInfoQuery.version(AppInfoScene.extractSceneVersion(prepareContext.getStartParams()));
        }
        prepareContext.setAppInfoQuery(appInfoQuery);
        AppModel appModel = this.appInfoManager.getAppModel(appInfoQuery);
        boolean z = appModel != null;
        RVLogger.d(this.LOG_TAG, "syncApp for " + appId + " " + prepareContext.getOriginStartParams() + " " + z);
        if (z) {
            prepareContext.setOriginHasAppInfo(true);
            prepareContext.setupAppInfo(appModel);
            prepareController.onGetAppInfo(appModel);
        }
        Bundle startParams = prepareContext.getStartParams();
        prepareContext.offlineMode = OfflineMode.fromString(BundleUtils.getString(startParams, RVStartParams.LONG_NB_OFFLINE), BundleUtils.getString(startParams, RVParams.LONG_NB_OFFMODE));
        prepareContext.updateMode = UpdateMode.fromString(BundleUtils.getString(startParams, RVStartParams.LONG_NB_UPDATE));
        prepareContext.degradeUrl = BundleUtils.getString(startParams, RVStartParams.LONG_NB_URL);
        prepareContext.getPrepareData().setNbUrl(prepareContext.degradeUrl);
        if (!z) {
            prepareContext.setOriginHasAppInfo(false);
            prepareContext.updateMode = UpdateMode.SYNC_FORCE;
        }
        prepareContext.getPrepareData().setAppId(appId);
        prepareContext.getPrepareData().setAppType(prepareContext.appType);
        RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare_Execute_ + getType());
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareStep
    public StepType getType() {
        return StepType.SETUP;
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public /* bridge */ /* synthetic */ boolean isFinished() {
        return super.isFinished();
    }
}
