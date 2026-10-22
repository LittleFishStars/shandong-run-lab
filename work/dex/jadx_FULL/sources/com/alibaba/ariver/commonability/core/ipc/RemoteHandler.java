package com.alibaba.ariver.commonability.core.ipc;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public abstract class RemoteHandler implements IpcMessageHandler {
    protected Bundle mParams;

    @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
    public void handleMessage(IpcMessage ipcMessage) {
        try {
            this.mParams = ipcMessage.bizMsg.getData();
        } catch (Throwable th) {
            RVLogger.e(RVRemoteUtils.TAG, th);
        }
    }

    public void replay(Bundle bundle) {
        if (this.mParams == null) {
            RVLogger.e(RVRemoteUtils.TAG, "params is null");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        long j = this.mParams.getLong(RVRemoteUtils.PARAM_REMOTE_TOKEN);
        if (this.mParams.getBoolean(RVRemoteUtils.PARAM_CALL_BY_MAIN_PROCESS, false)) {
            RemoteCallback remoteCallbackRemove = b.f23946a.c.remove(Long.valueOf(j));
            if (remoteCallbackRemove != null) {
                remoteCallbackRemove.callback(bundle2);
                return;
            }
            return;
        }
        String string = this.mParams.getString("appId");
        bundle2.putString("appId", string);
        bundle2.putLong(RVRemoteUtils.PARAM_REMOTE_TOKEN, j);
        IpcServerUtils.sendMsgToClient(string, this.mParams.getLong(RVConstants.EXTRA_START_TOKEN), RVRemoteUtils.WHAT_REMOTE, RVRemoteUtils.BIZ_COMMON_ABILITY, bundle2);
    }
}
