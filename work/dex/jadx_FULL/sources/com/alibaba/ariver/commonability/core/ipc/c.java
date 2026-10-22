package com.alibaba.ariver.commonability.core.ipc;

import com.alibaba.ariver.app.ipc.ServerMsgReceiver;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements IpcMessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f23947a = new c();
    protected boolean b;

    private c() {
    }

    public void a() {
        if (this.b) {
            return;
        }
        this.b = true;
        ServerMsgReceiver.getInstance().registerBizHandler(RVRemoteUtils.BIZ_COMMON_ABILITY, f23947a);
    }

    @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
    public void handleMessage(IpcMessage ipcMessage) {
        RVLogger.d(RVRemoteUtils.TAG, "RVServerMsgHandler handleMessage");
        try {
            Object objNewInstance = Class.forName(ipcMessage.bizMsg.getData().getString(RVRemoteUtils.PARAM_REMOTE_HANDLER)).newInstance();
            if (objNewInstance instanceof RemoteHandler) {
                ((RemoteHandler) objNewInstance).handleMessage(ipcMessage);
            }
        } catch (Throwable th) {
            RVLogger.e(RVRemoteUtils.TAG, th);
        }
    }
}
