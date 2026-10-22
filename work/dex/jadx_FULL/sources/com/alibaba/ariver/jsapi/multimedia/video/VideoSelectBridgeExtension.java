package com.alibaba.ariver.jsapi.multimedia.video;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.triver.embed.video.video.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class VideoSelectBridgeExtension implements BridgeExtension {
    @ActionFilter
    public abstract void chooseVideo(@BindingParam({"sourceType"}) String[] strArr, @BindingParam({h.d}) String[] strArr2, @BindingParam({"enableEdit"}) boolean z, @BindingParam({"compressed"}) boolean z2, @BindingParam({h.p}) int i, @BindingParam({"isShowVideoTimeIndicator"}) boolean z3, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

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
