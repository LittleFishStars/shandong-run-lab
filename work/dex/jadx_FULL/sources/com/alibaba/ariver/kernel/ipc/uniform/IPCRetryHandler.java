package com.alibaba.ariver.kernel.ipc.uniform;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IPCRetryHandler {
    boolean retryIPCCall(Method method, Object[] objArr, IPCException iPCException, int i);
}
