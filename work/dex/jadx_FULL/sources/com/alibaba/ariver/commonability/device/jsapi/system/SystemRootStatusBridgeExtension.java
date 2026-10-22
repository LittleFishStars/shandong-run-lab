package com.alibaba.ariver.commonability.device.jsapi.system;

import com.alibaba.ariver.commonability.core.util.a;
import com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SystemRootStatusBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23986a = "SystemRootStatusBridgeExtension";
    private static final String b = "isSystemRoot";
    private static final String c = "unknow";

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse isSystemRoot(@BindingApiContext ApiContext apiContext) {
        String str = AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
        RVCommonAbilityProxy rVCommonAbilityProxy = (RVCommonAbilityProxy) RVProxy.get(RVCommonAbilityProxy.class);
        if (rVCommonAbilityProxy == null || !rVCommonAbilityProxy.hasRootStatusPermission(apiContext.getAppId())) {
            return new BridgeResponse.NamedValue(b, c);
        }
        try {
            if (a.a()) {
                str = "true";
            }
        } catch (Exception e) {
            RVLogger.e(f23986a, e);
        }
        return new BridgeResponse.NamedValue(b, str);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
