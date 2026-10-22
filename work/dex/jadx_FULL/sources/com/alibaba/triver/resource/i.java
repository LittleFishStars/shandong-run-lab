package com.alibaba.triver.resource;

import androidx.camera.video.AudioStats;
import com.alibaba.ariver.integration.resource.interceptor.TinyCheckAppXInterceptor;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.utils.CommonUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i extends TinyCheckAppXInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PrepareContext f25167a;

    @Override // com.alibaba.ariver.integration.resource.interceptor.TinyCheckAppXInterceptor
    public boolean checkAppxMinVersion(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return false;
        }
        LaunchMonitorData mainMonitorData = LaunchMonitorUtils.getMainMonitorData(prepareContext.getSceneParams());
        if (mainMonitorData != null) {
            mainMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_APPX_CHECK_START);
        }
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(prepareContext.getAppId()).setStartParams(prepareContext.getStartParams()).setStage(TriverAppMonitorConstants.KEY_STAGE_APPX_CHECK_START).setStatus(Double.valueOf(1.0d)).create());
        boolean zCheckAppxMinVersion = super.checkAppxMinVersion(prepareContext);
        if (zCheckAppxMinVersion) {
            if (mainMonitorData != null) {
                mainMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_APPX_CHECK_FINISH);
            }
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(prepareContext.getAppId()).setStage(TriverAppMonitorConstants.KEY_STAGE_APPX_CHECK_FINISH).setStartParams(prepareContext.getStartParams()).setStatus(Double.valueOf(1.0d)).create());
        }
        return zCheckAppxMinVersion;
    }

    @Override // com.alibaba.ariver.integration.resource.interceptor.TinyCheckAppXInterceptor, com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void init(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        super.init(prepareContext, prepareCallback);
        this.f25167a = prepareContext;
    }

    @Override // com.alibaba.ariver.integration.resource.interceptor.TinyCheckAppXInterceptor
    public void onUpdateFail(boolean z) {
        PrepareContext prepareContext = this.f25167a;
        if (prepareContext != null) {
            LaunchMonitorData mainMonitorData = LaunchMonitorUtils.getMainMonitorData(prepareContext.getSceneParams());
            if (mainMonitorData != null) {
                mainMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_APPX_CHECK_FINISH);
            }
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(this.f25167a.getAppId()).setStage(TriverAppMonitorConstants.KEY_STAGE_APPX_CHECK_FINISH).setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).setStartParams(this.f25167a.getStartParams()).setErrorCode("7").setErrorMsg("appx check failed").create());
        }
        if (!CommonUtils.closeAppxForceUndateError()) {
            super.onUpdateFail(false);
        } else {
            if (z) {
                return;
            }
            super.onUpdateFail(false);
        }
    }

    @Override // com.alibaba.ariver.integration.resource.interceptor.TinyCheckAppXInterceptor
    public void onUpdateSuccess(boolean z) {
        PrepareContext prepareContext = this.f25167a;
        if (prepareContext != null) {
            LaunchMonitorData mainMonitorData = LaunchMonitorUtils.getMainMonitorData(prepareContext.getSceneParams());
            if (mainMonitorData != null) {
                mainMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_APPX_CHECK_FINISH);
            }
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(this.f25167a.getAppId()).setStartParams(this.f25167a.getStartParams()).setStage(TriverAppMonitorConstants.KEY_STAGE_APPX_CHECK_FINISH).setStatus(Double.valueOf(1.0d)).create());
        }
        super.onUpdateSuccess(z);
    }
}
