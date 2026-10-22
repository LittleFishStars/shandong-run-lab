package com.bykv.vk.component.ttvideo.mediakit.net;

import com.byazt.nr.m;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class AVMDLDNSManager {
    public static Map<Integer, CreateConstructor> dnsMap;
    private static AVMDLDNSManager mInstance;

    private AVMDLDNSManager() throws Exception {
        dnsMap = new HashMap();
        initDnsMap();
    }

    public static AVMDLDNSManager getInstance() {
        if (mInstance == null) {
            synchronized (AVMDLDNSManager.class) {
                if (mInstance == null) {
                    try {
                        mInstance = new AVMDLDNSManager();
                    } catch (Exception e) {
                        m.c(e);
                        mInstance = null;
                    }
                }
            }
        }
        return mInstance;
    }

    private void initDnsMap() throws Exception {
        DefaultConstructor defaultConstructor = new DefaultConstructor();
        dnsMap.put(1, defaultConstructor);
        dnsMap.put(2, defaultConstructor);
        dnsMap.put(3, defaultConstructor);
    }

    public synchronized CreateConstructor getCreateConstructor(int i) throws Exception {
        if (!dnsMap.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return dnsMap.get(Integer.valueOf(i));
    }

    public synchronized void registerDnsConstructor(int i, CreateConstructor createConstructor) {
        try {
            dnsMap.put(Integer.valueOf(i), createConstructor);
        } catch (Exception e) {
            m.c(e);
        }
    }
}
