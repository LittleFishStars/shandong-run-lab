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
public abstract class AudioRecordBridgeExtension implements BridgeExtension {
    @ActionFilter
    public abstract void getAvailableAudioSources(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @ActionFilter
    public abstract void pauseAudioRecord(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    public abstract void resumeAudioRecord(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract void startMonitorBackgroundAudio(@BindingParam({"duration"}) int i, @BindingParam({"maxRecordTime"}) int i2, @BindingParam({"minRecordTime"}) int i3, @BindingParam({"business"}) String str, @BindingParam({"sampleRate"}) int i4, @BindingParam({"numberOfChannels"}) int i5, @BindingParam({"encodeBitRate"}) int i6, @BindingParam({"frameSize"}) int i7, @BindingParam({"format"}) String str2, @BindingParam({"audioSource"}) String str3, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract void stopAudioRecord(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);
}
