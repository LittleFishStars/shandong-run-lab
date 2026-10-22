package com.alibaba.ariver.kernel.ipc.uniform;

import com.alibaba.ariver.ipc.uniform.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class IPCApiFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24292a = "com.alibaba.ariver.ipc.uniform.IPCManagerService";
    private static final String b = "com.alibaba.ariver.ipc.uniform.c";
    private static IPCContextManager c;
    private static IIPCManager d;

    public static final IPCContextManager getIPCContextManager() {
        return (IPCContextManager) c.class.newInstance();
    }

    public static final IIPCManager getIPCManager() {
        return (IIPCManager) Class.forName(f24292a).newInstance();
    }

    public static final IPCContextManager getSingletonIPCContextManager() {
        IPCContextManager iPCContextManager = c;
        if (iPCContextManager != null) {
            return iPCContextManager;
        }
        synchronized (IPCApiFactory.class) {
            IPCContextManager iPCContextManager2 = c;
            if (iPCContextManager2 != null) {
                return iPCContextManager2;
            }
            IPCContextManager iPCContextManager3 = (IPCContextManager) c.class.newInstance();
            c = iPCContextManager3;
            return iPCContextManager3;
        }
    }

    public static final IIPCManager getSingletonIPCManager() {
        IIPCManager iIPCManager = d;
        if (iIPCManager != null) {
            return iIPCManager;
        }
        synchronized (IIPCManager.class) {
            IIPCManager iIPCManager2 = d;
            if (iIPCManager2 != null) {
                return iIPCManager2;
            }
            IIPCManager iIPCManager3 = (IIPCManager) Class.forName(f24292a).newInstance();
            d = iIPCManager3;
            return iIPCManager3;
        }
    }

    public static final ServiceBeanManager getSingletonServiceBeanManager() {
        try {
            return getSingletonIPCContextManager().getServiceBeanManager();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
