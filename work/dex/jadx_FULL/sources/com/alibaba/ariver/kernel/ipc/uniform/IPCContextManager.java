package com.alibaba.ariver.kernel.ipc.uniform;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IPCContextManager {
    IPCCallManager getIpcCallManager();

    LocalCallManager getLocalCallManager();

    ServiceBeanManager getServiceBeanManager();

    void init(Context context, IIPCManager iIPCManager);

    void resetIIPCManager();
}
