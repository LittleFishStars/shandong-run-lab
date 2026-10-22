package com.alibaba.triver.resource;

import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.ariver.resource.content.PluginResourcePackage;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends PluginResourcePackage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25164a = "TriverPluginResourcePac";
    private ResourceContext b;
    private PluginModel c;

    public f(@NonNull PluginModel pluginModel, @NonNull ResourceContext resourceContext) {
        super(pluginModel, resourceContext);
        this.b = resourceContext;
        this.c = pluginModel;
    }

    @Override // com.alibaba.ariver.resource.content.PluginResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        super.beforeParsePackage(parseContext);
        parseContext.needVerify = RVProxy.get(RVPluginResourceManager.class) instanceof BasicPluginResourceManager;
        try {
            if (this.c != null) {
                TriverLaunchPointer.Builder developerVersion = TriverLaunchPointer.build().setAppId(this.c.getAppId()).setVersion(this.c.getVersion()).setDeveloperVersion(this.c.getDeveloperVersion());
                ResourceContext resourceContext = this.b;
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(developerVersion.setStartParams(resourceContext != null ? resourceContext.getStartParams() : null).setStage(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_LOAD_START).setStatus(Double.valueOf(1.0d)).create());
            }
        } catch (Exception e) {
            RVLogger.e(f25164a, e);
        }
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onParsePackageSuccess(ParseContext parseContext) {
        super.onParsePackageSuccess(parseContext);
        try {
            if (this.c != null) {
                TriverLaunchPointer.Builder version = TriverLaunchPointer.build().setAppId(this.c.getAppId()).setVersion(this.c.getVersion());
                ResourceContext resourceContext = this.b;
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(version.setStartParams(resourceContext != null ? resourceContext.getStartParams() : null).setDeveloperVersion(this.c.getDeveloperVersion()).setStage(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_LOAD_FINISH).setStatus(Double.valueOf(1.0d)).create());
            }
        } catch (Exception e) {
            RVLogger.e(f25164a, e);
        }
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onVerifyError(ParseFailedException parseFailedException) {
        String message;
        String strValueOf;
        super.onVerifyError(parseFailedException);
        try {
            if (this.c != null) {
                if (parseFailedException != null) {
                    strValueOf = String.valueOf(parseFailedException.getCode());
                    message = parseFailedException.getMessage();
                } else {
                    message = null;
                    strValueOf = null;
                }
                TriverLaunchPointer.Builder version = TriverLaunchPointer.build().setAppId(this.c.getAppId()).setVersion(this.c.getVersion());
                ResourceContext resourceContext = this.b;
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(version.setStartParams(resourceContext != null ? resourceContext.getStartParams() : null).setDeveloperVersion(this.c.getDeveloperVersion()).setStage(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_LOAD_FINISH).setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).setErrorCode(strValueOf).setErrorMsg(message).create());
            }
        } catch (Exception e) {
            RVLogger.e(f25164a, e);
        }
    }
}
