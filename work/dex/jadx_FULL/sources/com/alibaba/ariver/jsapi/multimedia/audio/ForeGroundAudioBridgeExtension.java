package com.alibaba.ariver.jsapi.multimedia.audio;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class ForeGroundAudioBridgeExtension implements BridgeExtension {
    @ActionFilter
    public abstract JSONObject destroyForegroundAudio(@BindingParam({"audioPlayerID"}) String str, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract JSONObject getForegroundAudioOption(@BindingParam({"audioPlayerID"}) String str, @BindingParam({"optionName"}) String str2, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @ActionFilter
    public abstract JSONObject pauseForegroundAudio(@BindingParam({"audioPlayerID"}) String str, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    public abstract JSONObject playForegroundAudio(@BindingParam({"audioPlayerID"}) String str, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract JSONObject seekForegroundAudio(@BindingParam({"audioPlayerID"}) String str, @BindingParam({"position"}) int i, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract JSONObject setForegroundAudioOption(@BindingParam({"audioPlayerID"}) String str, @BindingParam({"option"}) String str2, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract JSONObject startMonitorForegroundAudio(@BindingParam({"audioPlayerID"}) String str, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract JSONObject stopForegroundAudio(@BindingParam({"audioPlayerID"}) String str, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract JSONObject stopMonitorForegroundAudio(@BindingParam({"audioPlayerID"}) String str, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);
}
