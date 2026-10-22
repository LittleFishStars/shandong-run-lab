package com.alibaba.ariver.kernel.ipc.uniform;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ServiceBeanManager {
    Object getServiceBean(String str);

    int getServiceBeanCount();

    void register(String str, Object obj);

    void registerAndOverride(String str, Object obj);

    void unregister(String str);

    void unregisterAll();
}
