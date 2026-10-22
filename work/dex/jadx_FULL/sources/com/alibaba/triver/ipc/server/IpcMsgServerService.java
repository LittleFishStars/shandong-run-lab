package com.alibaba.triver.ipc.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.ipc.ServerMsgReceiver;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessage;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IpcMsgServerService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25012a = "AriverInt:IpcMsgServerService";
    private static boolean b = false;
    private IIpcChannel c;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        RVLogger.d(f25012a, "onBind " + intent);
        return this.c.asBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        RVLogger.d(f25012a, "onCreate");
        this.c = new IIpcChannel.Stub() { // from class: com.alibaba.triver.ipc.server.IpcMsgServerService.1
            @Override // com.alibaba.ariver.kernel.api.IIpcChannel
            public boolean isFinishing() {
                return false;
            }

            @Override // com.alibaba.ariver.kernel.api.IIpcChannel
            public void sendMessage(IpcMessage ipcMessage) {
                ServerMsgReceiver.getInstance().handleMessage(ipcMessage);
            }
        };
    }
}
