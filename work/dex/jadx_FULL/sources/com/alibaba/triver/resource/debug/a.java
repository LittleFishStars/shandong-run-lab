package com.alibaba.triver.resource.debug;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.PrepareStep;
import com.alibaba.ariver.resource.api.prepare.StepInterceptor;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.fastjson.JSON;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.utils.CommonUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements StepInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PrepareContext f25160a;
    private DebugInfo b;

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean after(PrepareStep prepareStep, PrepareController prepareController) throws Throwable {
        if (prepareStep.getType() == StepType.SETUP && this.b != null) {
            String asset = IOUtils.readAsset(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null), "triver.mock.appinfo.json");
            String downloadUrl = this.b.getDownloadUrl();
            AppModel appModel = (AppModel) JSON.parseObject(asset.replace("<id>", this.f25160a.getAppId()), AppModel.class);
            appModel.getAppInfoModel().setPackageUrl(downloadUrl);
            this.f25160a.setupAppInfo(appModel);
            this.f25160a.setOriginHasAppInfo(false);
            PrepareContext prepareContext = this.f25160a;
            prepareContext.updateMode = UpdateMode.ASYNC;
            prepareContext.getSceneParams().putBoolean(TRiverConstants.KEY_DELETE_FILE_WHEN_EXIT, true);
        }
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean before(PrepareStep prepareStep, PrepareController prepareController) {
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void init(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        this.f25160a = prepareContext;
        if (!CommonUtils.isApkDebug() || this.f25160a.getSceneParams() == null) {
            return;
        }
        this.b = (DebugInfo) this.f25160a.getSceneParams().getSerializable(TRiverConstants.KEY_LOCAL_DEBUG_INFO);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean onError(PrepareException prepareException, PrepareController prepareController) {
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void onGetAppInfo(AppModel appModel) {
    }
}
