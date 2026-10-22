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
public abstract class BackGroundAudioBridgeExtension implements BridgeExtension {
    @ActionFilter
    public abstract void getAudioPlayStateRecord(@BindingParam({"src"}) String str, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract void getBackgroundAudioOption(@BindingParam({"optionName"}) String str, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract void getBackgroundAudioPlayerState(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @ActionFilter
    public abstract void pauseBackgroundAudio(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    public abstract void playBackgroundAudio(@BindingParam({"business"}) String str, @BindingParam({"playWithNoParam"}) boolean z, @BindingParam({"audioDataUrl"}) String str2, @BindingParam({"audioName"}) String str3, @BindingParam({"audioDescribe"}) String str4, @BindingParam({"singerName"}) String str5, @BindingParam({"audioLogoURL"}) String str6, @BindingParam({"coverImgUrl"}) String str7, @BindingParam({"appName"}) String str8, @BindingParam({"appLogoUrl"}) String str9, @BindingParam({"isRecordAudioPlayState"}) boolean z2, @BindingParam({"hideRemoteControl"}) boolean z3, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract void seekBackgroundAudio(@BindingParam({"position"}) int i, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract void setBackgroundAudioOption(@BindingParam({"option"}) String str, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract void startMonitorBackgroundAudio(@BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract void stopBackgroundAudio(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

    @ActionFilter
    public abstract void stopMonitorBackgroundAudio(@BindingCallback BridgeCallback bridgeCallback);
}
