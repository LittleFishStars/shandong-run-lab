package com.bykv.vk.component.ttvideo.network;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class IPCache {
    private static IPCache mInstance = null;
    private static String mNetExtraInfo = null;
    private static int mNetType = -1;
    private ConcurrentHashMap<String, IpInfo> mIpRecord = new ConcurrentHashMap<>();

    public static class IpInfo {
        public int count;
        public String ipaddr;
        public long iptime;
        public boolean needUpdate;
    }

    private IPCache() {
    }

    public static IPCache getInstance() {
        if (mInstance == null) {
            synchronized (IPCache.class) {
                if (mInstance == null) {
                    mInstance = new IPCache();
                }
            }
        }
        return mInstance;
    }

    public void clear() {
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public void disableIpAddress(String str) {
        if (str == null) {
            return;
        }
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        IpInfo ipInfo = concurrentHashMap != null ? concurrentHashMap.get(str) : null;
        if (ipInfo != null) {
            ipInfo.needUpdate = true;
        }
    }

    public IpInfo get(String str) {
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    public String getCurNetExtraInfo() {
        return mNetExtraInfo;
    }

    public int getCurNetType() {
        return mNetType;
    }

    public int getRecordSize() {
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            return concurrentHashMap.size();
        }
        return -1;
    }

    public void put(String str, IpInfo ipInfo) {
        ConcurrentHashMap<String, IpInfo> concurrentHashMap = this.mIpRecord;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, ipInfo);
        }
    }

    public void setCurNetExtraInfo(String str) {
        mNetExtraInfo = str;
    }

    public void setCurNetType(int i) {
        mNetType = i;
    }
}
