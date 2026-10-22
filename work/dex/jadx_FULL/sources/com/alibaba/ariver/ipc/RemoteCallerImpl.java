package com.alibaba.ariver.ipc;

import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.RVRemoteCallerProxy;
import com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RemoteCallerImpl implements RVRemoteCallerProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24097a = "AriverKernel:RemoteCall";

    @Override // com.alibaba.ariver.kernel.ipc.RVRemoteCallerProxy
    public <T> T getRemoteCaller(Class<T> cls) {
        try {
            return (T) RemoteCallClient.getIpcProxy(cls);
        } catch (Throwable th) {
            RVLogger.e("AriverKernel:RemoteCall", "getRemoteCaller " + cls + " exception!", th);
            return null;
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.RVRemoteCallerProxy
    public <T> void registerServiceBean(Class<T> cls, T t) {
        try {
            RVLogger.d("AriverKernel:RemoteCall", "RemoteCallerImpl registerServiceBean interfaceClassName " + cls + " object " + t);
            ServiceBeanManager serviceBeanManager = UniformIpcUtils.getServiceBeanManager();
            if (serviceBeanManager != null) {
                serviceBeanManager.register(cls.getName(), t);
            }
        } catch (Exception e) {
            RVLogger.e("AriverKernel:RemoteCall", Log.getStackTraceString(e));
        }
    }
}
