package com.alibaba.ariver.kernel.api.remote.internal;

import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.remote.IRemoteCaller;
import com.alibaba.ariver.kernel.api.remote.RemoteControlManagement;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.ipc.RVRemoteCallerProxy;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultRemoteControlManagement implements RemoteControlManagement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Map<Method, Boolean>> f24218a = new ConcurrentHashMap();

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteControlManagement
    public IRemoteCaller getRemoteCallerProxy() {
        return (IRemoteCaller) ((RVRemoteCallerProxy) RVProxy.get(RVRemoteCallerProxy.class)).getRemoteCaller(IRemoteCaller.class);
    }

    public boolean hasRemoteAnnotation(Extension extension, Method method) {
        Map<Method, Boolean> concurrentHashMap = this.f24218a.get(extension.getClass().getName());
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.f24218a.put(extension.getClass().getName(), concurrentHashMap);
        } else if (concurrentHashMap.get(method) != null) {
            return concurrentHashMap.get(method).booleanValue();
        }
        try {
            if (method.getDeclaringClass().getAnnotation(Remote.class) != null) {
                concurrentHashMap.put(method, Boolean.TRUE);
                return true;
            }
            if (extension.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes()).getAnnotation(Remote.class) != null) {
                concurrentHashMap.put(method, Boolean.TRUE);
                return true;
            }
            concurrentHashMap.put(method, Boolean.FALSE);
            return false;
        } catch (NoSuchMethodException unused) {
            concurrentHashMap.put(method, Boolean.FALSE);
            return false;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteControlManagement
    public boolean isRemoteExtension(Extension extension, Method method) {
        if (ProcessUtils.isMainProcess()) {
            return false;
        }
        return hasRemoteAnnotation(extension, method);
    }
}
