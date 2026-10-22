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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements StepInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PrepareContext f25162a;

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean after(PrepareStep prepareStep, PrepareController prepareController) {
        if (prepareStep.getType() == StepType.SETUP && this.f25162a.getAppId().equals("3000000000000103")) {
            this.f25162a.setupAppInfo((AppModel) JSON.parseObject(IOUtils.readAsset(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null), "3000000000000103.appinfo.json"), AppModel.class));
            this.f25162a.setOriginHasAppInfo(false);
            this.f25162a.updateMode = UpdateMode.ASYNC;
        }
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean before(PrepareStep prepareStep, PrepareController prepareController) {
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void init(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        this.f25162a = prepareContext;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean onError(PrepareException prepareException, PrepareController prepareController) {
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void onGetAppInfo(AppModel appModel) {
    }
}
