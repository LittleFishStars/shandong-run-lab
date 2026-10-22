package com.alibaba.ariver.app.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class ServerMsgReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23834a = "AriverInt:IpcServer";
    private static ServerMsgReceiver b;
    private final Bundle c = new Bundle();
    private final Map<String, List<IpcMessageHandler>> d = new HashMap();

    private ServerMsgReceiver() {
        IpcChannelManager.getInstance().registerClientListener(new IpcChannelManager.ClientListener() { // from class: com.alibaba.ariver.app.ipc.ServerMsgReceiver.1
            @Override // com.alibaba.ariver.kernel.ipc.IpcChannelManager.ClientListener
            public void onRegister(long j, IIpcChannel iIpcChannel) {
                RVLogger.d("AriverInt:IpcServer", "ServerMsgReceiver onRegister startToken " + j);
                IpcServerUtils.flushMessages(j);
            }

            @Override // com.alibaba.ariver.kernel.ipc.IpcChannelManager.ClientListener
            public void onUnRegister(long j) {
                IpcServerUtils.removeToken(j);
            }
        });
    }

    public static ServerMsgReceiver getInstance() {
        if (b == null) {
            synchronized (ServerMsgReceiver.class) {
                b = new ServerMsgReceiver();
            }
        }
        return b;
    }

    public void handleMessage(IpcMessage ipcMessage) {
        Bundle data = ipcMessage.bizMsg.getData();
        if (data == null) {
            data = this.c;
        }
        data.setClassLoader(ServerMsgReceiver.class.getClassLoader());
        String str = ipcMessage.biz;
        if (TextUtils.isEmpty(str)) {
            RVLogger.e("AriverInt:IpcServer", "ServerMsgReceiver biz empty!");
            return;
        }
        synchronized (this.d) {
            List<IpcMessageHandler> list = this.d.get(str);
            if (list != null) {
                Iterator<IpcMessageHandler> it = list.iterator();
                while (it.hasNext()) {
                    it.next().handleMessage(ipcMessage);
                }
            } else {
                RVLogger.w("AriverInt:IpcServer", "ServerMsgReceiver biz " + str + " has not register handler");
            }
        }
    }

    public void registerBizHandler(String str, IpcMessageHandler ipcMessageHandler) {
        RVLogger.d("AriverInt:IpcServer", "ServerMsgReceiver registerBiz: " + str);
        synchronized (this.d) {
            List<IpcMessageHandler> arrayList = this.d.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.d.put(str, arrayList);
            }
            arrayList.add(ipcMessageHandler);
        }
    }

    public void unRegisterBizHandler(String str, IpcMessageHandler ipcMessageHandler) {
        RVLogger.d("AriverInt:IpcServer", "ServerMsgReceiver unRegisterBizHandler: " + str + " and " + ipcMessageHandler);
        if (ipcMessageHandler == null) {
            return;
        }
        synchronized (this.d) {
            List<IpcMessageHandler> list = this.d.get(str);
            if (list == null) {
                return;
            }
            list.remove(ipcMessageHandler);
            if (list.size() == 0) {
                this.d.remove(str);
            }
        }
    }
}
