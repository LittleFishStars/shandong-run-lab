package com.alibaba.ariver.commonability.core.ipc;

import android.os.Bundle;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements IpcMessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23945a = new a();

    private a() {
    }

    @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
    public void handleMessage(IpcMessage ipcMessage) {
        RVLogger.d(RVRemoteUtils.TAG, "RVClientMsgHandler handleMessage");
        try {
            Bundle data = ipcMessage.bizMsg.getData();
            RemoteCallback remoteCallbackRemove = b.f23946a.c.remove(Long.valueOf(data.getLong(RVRemoteUtils.PARAM_REMOTE_TOKEN)));
            if (remoteCallbackRemove != null) {
                remoteCallbackRemove.callback(data);
            }
        } catch (Throwable th) {
            RVLogger.e(RVRemoteUtils.TAG, th);
        }
    }
}
