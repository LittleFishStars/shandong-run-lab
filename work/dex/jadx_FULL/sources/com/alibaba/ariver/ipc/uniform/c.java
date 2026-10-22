package com.alibaba.ariver.ipc.uniform;

import android.content.Context;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.IIPCManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCCallManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager;
import com.alibaba.ariver.kernel.ipc.uniform.LocalCallManager;
import com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements IPCContextManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24101a = "AriverKernel:RemoteCall";
    private IPCCallManager b;
    private ServiceBeanManager c;
    private LocalCallManager d;
    private IIPCManager e;
    private Context f;

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager
    public IPCCallManager getIpcCallManager() {
        IPCCallManager iPCCallManager = this.b;
        if (iPCCallManager != null) {
            return iPCCallManager;
        }
        synchronized (this) {
            IPCCallManager iPCCallManager2 = this.b;
            if (iPCCallManager2 != null) {
                return iPCCallManager2;
            }
            b bVar = new b();
            this.b = bVar;
            return bVar;
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager
    public LocalCallManager getLocalCallManager() {
        LocalCallManager localCallManager = this.d;
        if (localCallManager != null) {
            return localCallManager;
        }
        synchronized (this) {
            LocalCallManager localCallManager2 = this.d;
            if (localCallManager2 != null) {
                return localCallManager2;
            }
            LocalCallManagerImpl localCallManagerImpl = new LocalCallManagerImpl(getServiceBeanManager());
            this.d = localCallManagerImpl;
            return localCallManagerImpl;
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager
    public ServiceBeanManager getServiceBeanManager() {
        ServiceBeanManager serviceBeanManager = this.c;
        if (serviceBeanManager != null) {
            return serviceBeanManager;
        }
        synchronized (this) {
            ServiceBeanManager serviceBeanManager2 = this.c;
            if (serviceBeanManager2 != null) {
                return serviceBeanManager2;
            }
            ServiceBeanManagerImpl serviceBeanManagerImpl = new ServiceBeanManagerImpl();
            this.c = serviceBeanManagerImpl;
            return serviceBeanManagerImpl;
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager
    public void init(Context context, IIPCManager iIPCManager) {
        this.f = context;
        context.getClass();
        this.e = iIPCManager;
        getIpcCallManager().setIIPCManager(this.e);
        IIPCManager iIPCManager2 = this.e;
        if (iIPCManager2 instanceof IPCManagerService) {
            ((IPCManagerService) iIPCManager2).setLocalCallManager(getLocalCallManager());
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager
    public synchronized void resetIIPCManager() {
        RVLogger.d("AriverKernel:RemoteCall", "IPCContextManagerImpl resetIIPCManager !");
        this.e = null;
        getIpcCallManager().setIIPCManager(null);
        RVLogger.d("AriverKernel:RemoteCall", "IPCContextManagerImpl [resetIIPCManager] reset iIpcManager to null.");
    }
}
