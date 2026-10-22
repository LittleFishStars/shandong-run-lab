package com.alibaba.ariver.kernel.ipc.uniform;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface LocalCallRetryHandler {
    boolean retryLocalCall(IPCParameter iPCParameter, IPCResult iPCResult, ServiceBeanManager serviceBeanManager, int i);
}
