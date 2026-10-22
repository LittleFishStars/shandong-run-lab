package com.alibaba.ariver.ipc.uniform;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ServiceBeanManagerImpl implements ServiceBeanManager {
    private static final String TAG = "AriverKernel:RemoteCall";
    private Map<String, Object> objMap = new ConcurrentHashMap();

    @Override // com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager
    public Object getServiceBean(String str) {
        Object obj = this.objMap.get(str);
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceBeanManagerImpl getServiceBean className=");
        sb.append(str);
        sb.append(",obj is ");
        sb.append(obj == null ? "null" : "not null");
        RVLogger.debug("AriverKernel:RemoteCall", sb.toString());
        return obj;
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager
    public int getServiceBeanCount() {
        return this.objMap.size();
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager
    public void register(String str, Object obj) {
        if (this.objMap.get(str) != null) {
            return;
        }
        this.objMap.put(str, obj);
        RVLogger.d("AriverKernel:RemoteCall", "ServiceBeanManagerImpl ihashcode=[" + hashCode() + "]   register className=" + str);
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager
    public void registerAndOverride(String str, Object obj) {
        this.objMap.put(str, obj);
        RVLogger.d("AriverKernel:RemoteCall", "ServiceBeanManagerImpl ihashcode=[" + hashCode() + "]  registerAndOverride className=" + str);
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager
    public void unregister(String str) {
        this.objMap.remove(str);
        RVLogger.d("AriverKernel:RemoteCall", "ServiceBeanManagerImpl unregister className=" + str);
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager
    public void unregisterAll() {
        this.objMap.clear();
        RVLogger.d("AriverKernel:RemoteCall", "ServiceBeanManagerImpl unregisterAll");
    }
}
