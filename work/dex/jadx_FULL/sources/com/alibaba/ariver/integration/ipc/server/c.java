package com.alibaba.ariver.integration.ipc.server;

import android.os.Bundle;
import android.os.Message;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.ariver.kernel.ipc.ShadowNodePool;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements IpcMessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24084a = "AriverInt:IpcServer";
    private final Bundle b = new Bundle();
    private g c;

    public c(ExtensionManager extensionManager) {
        this.c = null;
        this.c = new g(extensionManager);
    }

    @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
    public void handleMessage(IpcMessage ipcMessage) {
        RemoteCallArgs remoteCallArgs;
        Message message = ipcMessage.bizMsg;
        Bundle data = message.getData();
        if (data == null) {
            data = this.b;
        }
        int i = data.getInt(IpcMessageConstants.EXTRA_LPID);
        long j = data.getLong(RVConstants.EXTRA_START_TOKEN);
        long j2 = data.getLong(IpcMessageConstants.EXTRA_NODE_ID);
        boolean z = data.getBoolean(IpcMessageConstants.EXTRA_FROM_LITE_PROCESS);
        RVLogger.d("AriverInt:IpcServer", "ServerApiBizHandler received msg what: " + message.what + " lpid: " + i + " token: " + j);
        int i2 = message.what;
        if (i2 == 2) {
            if (z) {
                ShadowNodePool.getInstance().unBindStartToken(j);
                ShadowNodePool.getInstance().onNodeExit(j2);
                return;
            }
            return;
        }
        if (i2 == 3) {
            if (z) {
                ShadowNodePool.getInstance().bindStartToken(j, j2);
            }
        } else if (i2 == 4) {
            if (z) {
                ShadowNodePool.getInstance().bindStartToken(j, j2);
            }
        } else if (i2 == 5) {
            if (z) {
                ShadowNodePool.getInstance().onNodeExit(j2);
            }
        } else if (i2 == 6 && (remoteCallArgs = (RemoteCallArgs) BundleUtils.getParcelable(message.getData(), IpcMessageConstants.EXTRA_REMOTE_CALL_ARGS)) != null) {
            this.c.a(remoteCallArgs);
        }
    }
}
