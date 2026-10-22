package com.alibaba.ariver.integration.ipc.server.a;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.NativeBridge;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.integration.ipc.server.e;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements NativeBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24082a = "AriverInt:ServerSideBridge";
    private App b;

    public a(App app) {
        this.b = app;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public void bindEngineRouter(EngineRouter engineRouter) {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public void release() {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public boolean sendToNative(NativeCallContext nativeCallContext, @Nullable SendToNativeCallback sendToNativeCallback) {
        return sendToNative(nativeCallContext, sendToNativeCallback, true);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.NativeBridge
    public boolean sendToNative(NativeCallContext nativeCallContext, @Nullable SendToNativeCallback sendToNativeCallback, boolean z) {
        e.a().a(this.b.getStartToken(), nativeCallContext.getId(), sendToNativeCallback);
        Bundle bundle = new Bundle();
        bundle.putParcelable(IpcMessageConstants.EXTRA_REMOTE_CALL_CONTEXT, nativeCallContext);
        bundle.putBoolean(IpcMessageConstants.EXTRA_REMOTE_CALL_NEED_PERMISSION, z);
        RVLogger.d(f24082a, "sendToNative with context: " + nativeCallContext);
        IpcServerUtils.sendMsgToClient(this.b.getAppId(), this.b.getStartToken(), 8, bundle);
        return true;
    }
}
