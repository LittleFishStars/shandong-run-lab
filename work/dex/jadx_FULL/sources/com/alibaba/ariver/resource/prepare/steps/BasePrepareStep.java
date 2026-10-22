package com.alibaba.ariver.resource.prepare.steps;

import androidx.annotation.CallSuper;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.PrepareStep;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
abstract class BasePrepareStep implements PrepareStep {
    String LOG_TAG;
    RVAppInfoManager appInfoManager;
    RVResourceManager resourceManager;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24458a = false;
    private boolean b = false;

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareStep
    @CallSuper
    public void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) throws PrepareException {
        this.appInfoManager = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
        this.resourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
        if (this.appInfoManager == null) {
            throw new PrepareException("0", "ERROR_UNKNOWN with appInfoManager == null");
        }
        if (prepareContext == null) {
            throw new PrepareException("0", "ERROR_UNKNOWN with context == null");
        }
        if (this.f24458a) {
            return;
        }
        this.f24458a = true;
        this.LOG_TAG = "AriverRes:PrepareStep_" + prepareContext.getAppId() + LoginConstants.UNDER_LINE + getType();
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareStep
    public void finish() {
        this.b = true;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareStep
    public boolean isFinished() {
        return this.b;
    }
}
