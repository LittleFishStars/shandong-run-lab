package com.alibaba.ariver.integration.ipc.server;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements ApiContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24085a = "AriverInt:ServerSideApiContext";
    private long b;
    private String c;
    private Bundle d;
    private Render e;
    private String f;
    private String g;
    private String h;

    public d(Render render, long j, String str, Bundle bundle, String str2, String str3, String str4) {
        this.e = render;
        this.b = j;
        this.c = str;
        this.d = bundle;
        this.f = str2;
        this.g = str3;
        this.h = str4;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void callBridgeApi(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback, boolean z) {
        if (nativeCallContext == null) {
            RVLogger.e(f24085a, "callApi with nativeCallContext == null!!");
            return;
        }
        nativeCallContext.setPluginId(this.g);
        nativeCallContext.setContextId(this.h);
        e.a().a(this.b, nativeCallContext.getId(), sendToNativeCallback);
        Bundle bundle = new Bundle();
        bundle.putParcelable(IpcMessageConstants.EXTRA_REMOTE_CALL_CONTEXT, nativeCallContext);
        bundle.putBoolean(IpcMessageConstants.EXTRA_REMOTE_CALL_NEED_PERMISSION, z);
        RVLogger.d(f24085a, "sendToNative with context: " + nativeCallContext);
        IpcServerUtils.sendMsgToClient(this.c, this.b, 8, bundle);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Activity getActivity() {
        WeakReference<Activity> topActivity = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity();
        if (topActivity != null) {
            return topActivity.get();
        }
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Context getAppContext() {
        return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getAppId() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Resource getContent(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getContextId() {
        return this.h;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public View getInternalView() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public int getPageId() {
        return -1;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    @Nullable
    public String getPluginId() {
        return this.g;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Render getRender() {
        return this.e;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public int getRenderId() {
        return -1;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public String getSourceProcess() {
        return this.f;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public Bundle getStartParams() {
        return this.d;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public boolean isFromRemote() {
        return true;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void sendEvent(String str, @Nullable JSONObject jSONObject, @Nullable final SendToRenderCallback sendToRenderCallback) {
        String str2 = "serverEvent_" + System.currentTimeMillis();
        if (sendToRenderCallback != null) {
            e.a().a(this.b, str2, new SendToNativeCallback() { // from class: com.alibaba.ariver.integration.ipc.server.d.1
                @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                public void onCallback(JSONObject jSONObject2, boolean z) {
                    sendToRenderCallback.onCallBack(jSONObject2);
                }
            });
        }
        Bundle bundle = new Bundle();
        bundle.putString(IpcMessageConstants.EXTRA_EVENT, str);
        bundle.putString("clientId", str2);
        bundle.putByteArray("data", JSONUtils.marshallJSONObject(jSONObject));
        RVLogger.d(f24085a, "sendEvent by serverSide: " + str + ", data: " + jSONObject + ", eventCallId: " + str2);
        IpcServerUtils.sendMsgToClient(this.c, this.b, 9, bundle);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.model.ApiContext
    public void startActivity(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        RVLogger.d(f24085a, "startActivity by serverSide: " + intent);
        IpcServerUtils.sendMsgToClient(this.c, this.b, 11, bundle);
    }
}
