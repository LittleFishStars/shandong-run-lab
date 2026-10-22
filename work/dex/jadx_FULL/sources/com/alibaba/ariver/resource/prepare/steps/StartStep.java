package com.alibaba.ariver.resource.prepare.steps;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.StepType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StartStep extends BasePrepareStep {
    private void a(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState("prepare 8 ").setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) throws PrepareException {
        AppModel appModel;
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Prepare_Execute_ + getType());
        super.execute(prepareController, prepareContext, prepareCallback);
        RVLogger.d(this.LOG_TAG, "prepareFinish " + prepareContext.getAppId() + " with appModel:" + prepareContext.getAppModel());
        String string = BundleUtils.getString(prepareContext.getStartParams(), "url");
        String string2 = BundleUtils.getString(prepareContext.getStartParams(), "page");
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && (appModel = prepareContext.getAppModel()) != null && appModel.getContainerInfo() != null && TextUtils.isEmpty(JSONUtils.getString(appModel.getContainerInfo().getLaunchParams(), "page"))) {
            RVLogger.d(this.LOG_TAG, "url and page both null! prepare fail!");
            PrepareException prepareException = new PrepareException("6", "url and page both null!");
            prepareException.setStage(StepType.START.name());
            prepareCallback.prepareFail(prepareContext.getPrepareData(), prepareException);
            return;
        }
        prepareContext.getPrepareData().setEndTime(SystemClock.elapsedRealtime());
        a(prepareContext);
        prepareCallback.prepareFinish(prepareContext.getPrepareData(), prepareContext.getAppModel(), prepareContext.getStartParams(), prepareContext.getSceneParams());
        RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare_Execute_ + getType());
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareStep
    public StepType getType() {
        return StepType.START;
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public /* bridge */ /* synthetic */ boolean isFinished() {
        return super.isFinished();
    }
}
