package com.alibaba.triver.resource;

import androidx.camera.video.AudioStats;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.content.MainResourcePackage;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h extends MainResourcePackage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25166a = "TriverResourcePackage";
    private ResourceContext b;
    private App c;

    public h(ResourceContext resourceContext) {
        super(resourceContext);
        this.b = resourceContext;
        if (resourceContext != null) {
            this.c = resourceContext.getApp();
        }
    }

    @Override // com.alibaba.ariver.resource.content.MainResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        String templateId;
        String appVersion;
        String developerVersion;
        LaunchMonitorData subMonitorData;
        super.beforeParsePackage(parseContext);
        parseContext.needVerify = RVProxy.get(RVResourceManager.class) instanceof BasicResourceManager;
        try {
            AppModel appModel = getAppModel();
            if (appModel != null) {
                appVersion = appModel.getAppVersion();
                developerVersion = appModel.getAppInfoModel().getDeveloperVersion();
                templateId = appModel.getAppInfoModel().getTemplateConfig() != null ? appModel.getAppInfoModel().getTemplateConfig().getTemplateId() : null;
            } else {
                templateId = null;
                appVersion = null;
                developerVersion = null;
            }
            TriverLaunchPointer.Builder templateId2 = TriverLaunchPointer.build().setAppId(appId()).setVersion(appVersion).setDeveloperVersion(developerVersion).setTemplateId(templateId);
            ResourceContext resourceContext = this.b;
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(templateId2.setStartParams(resourceContext != null ? resourceContext.getStartParams() : null).setStage(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_LOAD_START).setStatus(Double.valueOf(1.0d)).create());
            App app = this.c;
            if (app == null || (subMonitorData = LaunchMonitorUtils.getSubMonitorData(app)) == null) {
                return;
            }
            subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_LOAD_START);
        } catch (Exception e) {
            RVLogger.w(f25166a, e.getMessage());
        }
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onParsePackageSuccess(ParseContext parseContext) {
        String templateId;
        String appVersion;
        String developerVersion;
        LaunchMonitorData subMonitorData;
        super.onParsePackageSuccess(parseContext);
        try {
            AppModel appModel = getAppModel();
            if (appModel != null) {
                appVersion = appModel.getAppVersion();
                developerVersion = appModel.getAppInfoModel().getDeveloperVersion();
                templateId = appModel.getAppInfoModel().getTemplateConfig() != null ? appModel.getAppInfoModel().getTemplateConfig().getTemplateId() : null;
            } else {
                templateId = null;
                appVersion = null;
                developerVersion = null;
            }
            TriverLaunchPointer.Builder version = TriverLaunchPointer.build().setAppId(appId()).setVersion(appVersion);
            ResourceContext resourceContext = this.b;
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(version.setStartParams(resourceContext != null ? resourceContext.getStartParams() : null).setDeveloperVersion(developerVersion).setTemplateId(templateId).setStage(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_LOAD_FINISH).setStatus(Double.valueOf(1.0d)).create());
            App app = this.c;
            if (app == null || (subMonitorData = LaunchMonitorUtils.getSubMonitorData(app)) == null) {
                return;
            }
            subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_LOAD_FINISH);
        } catch (Exception e) {
            RVLogger.w(f25166a, e.getMessage());
        }
    }

    @Override // com.alibaba.ariver.resource.content.MainResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onVerifyError(ParseFailedException parseFailedException) {
        String templateId;
        String appVersion;
        String developerVersion;
        String message;
        String strValueOf;
        super.onVerifyError(parseFailedException);
        try {
            AppModel appModel = getAppModel();
            if (appModel != null) {
                appVersion = appModel.getAppVersion();
                developerVersion = appModel.getAppInfoModel().getDeveloperVersion();
                templateId = appModel.getAppInfoModel().getTemplateConfig() != null ? appModel.getAppInfoModel().getTemplateConfig().getTemplateId() : null;
            } else {
                templateId = null;
                appVersion = null;
                developerVersion = null;
            }
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(appId()).setVersion(appVersion).setDeveloperVersion(developerVersion).setTemplateId(templateId).setStage("package").setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).create());
            if (parseFailedException != null) {
                strValueOf = String.valueOf(parseFailedException.getCode());
                message = parseFailedException.getMessage();
            } else {
                message = null;
                strValueOf = null;
            }
            TriverLaunchPointer.Builder templateId2 = TriverLaunchPointer.build().setAppId(appId()).setVersion(appVersion).setDeveloperVersion(developerVersion).setTemplateId(templateId);
            ResourceContext resourceContext = this.b;
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(templateId2.setStartParams(resourceContext != null ? resourceContext.getStartParams() : null).setStage(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_LOAD_FINISH).setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).setErrorCode(strValueOf).setErrorMsg(message).create());
        } catch (Exception e) {
            RVLogger.w(f25166a, e.getMessage());
        }
    }

    @Override // com.alibaba.ariver.resource.content.MainResourcePackage, com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public void setup(boolean z) {
        super.setup(z);
    }
}
