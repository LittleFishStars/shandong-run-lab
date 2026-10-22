package com.alibaba.triver.ipc.a;

import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements IpcMessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f25002a = new Bundle();

    @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
    public void handleMessage(IpcMessage ipcMessage) {
        Message message = ipcMessage.bizMsg;
        message.getData();
        if (message.what != 201) {
            return;
        }
        com.alibaba.triver.ipc.a.a();
        Process.killProcess(ProcessUtils.getPid());
    }
}
