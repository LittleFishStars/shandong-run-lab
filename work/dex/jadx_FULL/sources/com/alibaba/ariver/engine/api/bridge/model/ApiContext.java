package com.alibaba.ariver.engine.api.bridge.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ApiContext {
    void callBridgeApi(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback, boolean z);

    @Nullable
    Activity getActivity();

    Context getAppContext();

    String getAppId();

    Resource getContent(String str);

    String getContextId();

    @Nullable
    View getInternalView();

    int getPageId();

    @Nullable
    String getPluginId();

    @Nullable
    Render getRender();

    int getRenderId();

    String getSourceProcess();

    Bundle getStartParams();

    boolean isFromRemote();

    void sendEvent(String str, @Nullable JSONObject jSONObject, @Nullable SendToRenderCallback sendToRenderCallback);

    void startActivity(Intent intent);
}
