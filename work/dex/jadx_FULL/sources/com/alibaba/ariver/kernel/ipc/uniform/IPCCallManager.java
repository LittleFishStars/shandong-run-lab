package com.alibaba.ariver.kernel.ipc.uniform;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IPCCallManager {
    <T> T getIpcProxy(Class<T> cls);

    void setIIPCManager(IIPCManager iIPCManager);

    void setIPCCallRetryHandler(IPCRetryHandler iPCRetryHandler);
}
