package com.alibaba.ariver.kernel.ipc;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IpcClientKernelUtils {
    public static final String LOG_TAG = "AriverInt:IpcClient";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<IpcMessage> f24289a = new ArrayList();
    private static final AtomicBoolean b = new AtomicBoolean(false);

    private static void a(IpcMessage ipcMessage) {
        if (!b.getAndSet(true)) {
            RVLogger.d("AriverInt:IpcClient", "registerServerReadyListener");
            IpcChannelManager.getInstance().registerServerReadyListener(new IpcChannelManager.ServerReadyListener() { // from class: com.alibaba.ariver.kernel.ipc.IpcClientKernelUtils.1
                @Override // com.alibaba.ariver.kernel.ipc.IpcChannelManager.ServerReadyListener
                public void onServerReady() {
                    RVLogger.d("AriverInt:IpcClient", "onServerReady");
                    IIpcChannel serverChannel = IpcChannelManager.getInstance().getServerChannel();
                    if (serverChannel == null) {
                        RVLogger.e("AriverInt:IpcClient", "onServerReady but server channel == null!!");
                        return;
                    }
                    synchronized (IpcClientKernelUtils.f24289a) {
                        Iterator it = IpcClientKernelUtils.f24289a.iterator();
                        while (it.hasNext()) {
                            try {
                                serverChannel.sendMessage((IpcMessage) it.next());
                            } catch (RemoteException e) {
                                RVLogger.w("AriverInt:IpcClient", "sendMessage to server exception!", e);
                            }
                        }
                    }
                    IpcChannelManager.getInstance().unRegisterServerReadyListener(this);
                }
            });
        }
        f24289a.add(ipcMessage);
    }

    public static void sendMsgToServer(String str, int i, Bundle bundle) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        if (bundle == null) {
            bundle = new Bundle();
        }
        int lpid = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getLpid();
        bundle.putBoolean(IpcMessageConstants.EXTRA_FROM_LITE_PROCESS, !ProcessUtils.isMainProcess());
        bundle.putInt(IpcMessageConstants.EXTRA_LPID, lpid);
        messageObtain.setData(bundle);
        IpcMessage ipcMessage = new IpcMessage();
        ipcMessage.biz = str;
        ipcMessage.bizMsg = messageObtain;
        ipcMessage.clientId = ProcessUtils.getProcessName();
        ipcMessage.pid = ProcessUtils.getPid();
        ipcMessage.lpid = lpid;
        try {
            synchronized (f24289a) {
                try {
                    IIpcChannel serverChannel = IpcChannelManager.getInstance().getServerChannel();
                    if (serverChannel != null) {
                        serverChannel.sendMessage(ipcMessage);
                    } else {
                        a(ipcMessage);
                        RVLogger.w("AriverInt:IpcClient", "sendMsgToServer but cannot find serverProxy!");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (RemoteException e) {
            RVLogger.w("AriverInt:IpcClient", "sendMsgToServer exception!", e);
        }
    }
}
