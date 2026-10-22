package com.bykv.vk.component.ttvideo.mediakit.net;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class IPCache {
    private static final String TAG = "AVMDLIPCache";
    private static IPCache mInstance = null;
    private static String mNetExtraInfo = null;
    private static int mNetType = -1;
    private ConcurrentHashMap<String, AVMDLDNSInfo> mDNSRecord = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, AVMDLDNSInfo> mBackUps = new ConcurrentHashMap<>();
    private Lock lock = new ReentrantLock();
    private Lock backUplock = new ReentrantLock();

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

    public static void setCurNetExtraInfo(String str) {
        mNetExtraInfo = str;
    }

    public void clear() {
        this.lock.lock();
        try {
            ConcurrentHashMap<String, AVMDLDNSInfo> concurrentHashMap = this.mDNSRecord;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
        } finally {
            this.lock.unlock();
        }
    }

    public AVMDLDNSInfo get(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.lock.lock();
        try {
            ConcurrentHashMap<String, AVMDLDNSInfo> concurrentHashMap = this.mDNSRecord;
            AVMDLDNSInfo aVMDLDNSInfo = concurrentHashMap != null ? concurrentHashMap.get(str) : null;
            if (aVMDLDNSInfo != null && !TextUtils.isEmpty(aVMDLDNSInfo.mIpList) && AVMDLDNSParser.mGlobalEnableBackUpIp > 0) {
                String.format("enable backup try get backup ip for:%s", str);
                AVMDLDNSInfo backUpIp = getBackUpIp(str);
                if (backUpIp != null && !TextUtils.isEmpty(backUpIp.mIpList)) {
                    String.format("succ get backup ip:%s", backUpIp.mIpList);
                    aVMDLDNSInfo.mIpList += "," + backUpIp.mIpList;
                }
            }
            return aVMDLDNSInfo;
        } finally {
            this.lock.unlock();
        }
    }

    public AVMDLDNSInfo getBackUpIp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.backUplock.lock();
        try {
            return this.mBackUps.get(str);
        } finally {
            this.backUplock.unlock();
        }
    }

    public String getCurNetExtraInfo() {
        return mNetExtraInfo;
    }

    public int getCurNetType() {
        return mNetType;
    }

    public int getRecordSize() {
        this.lock.lock();
        try {
            ConcurrentHashMap<String, AVMDLDNSInfo> concurrentHashMap = this.mDNSRecord;
            return concurrentHashMap != null ? concurrentHashMap.size() : -1;
        } finally {
            this.lock.unlock();
        }
    }

    @SuppressLint({"CI_DefaultLocale"})
    public void put(String str, AVMDLDNSInfo aVMDLDNSInfo) {
        int i;
        if (aVMDLDNSInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.lock.lock();
        try {
            ConcurrentHashMap<String, AVMDLDNSInfo> concurrentHashMap = this.mDNSRecord;
            if (concurrentHashMap != null) {
                AVMDLDNSInfo aVMDLDNSInfo2 = concurrentHashMap.get(str);
                if (AVMDLDNSParser.mGlobalEnableParallel > 0 && aVMDLDNSInfo2 != null && (i = aVMDLDNSInfo.mType) == 0 && aVMDLDNSInfo2.mType > i && aVMDLDNSInfo2.mExpiredTime > System.currentTimeMillis()) {
                    String.format("put for host:%s enable parallel info.type:%d info.expiredT:%d cache.type:%d cache.expiredT:%d curT:%d info can not replace cache", str, Integer.valueOf(aVMDLDNSInfo.mType), Long.valueOf(aVMDLDNSInfo.mExpiredTime), Integer.valueOf(aVMDLDNSInfo2.mType), Long.valueOf(aVMDLDNSInfo2.mExpiredTime), Long.valueOf(System.currentTimeMillis()));
                    this.lock.unlock();
                    return;
                } else {
                    String.format("put for host:%s type:%d ip:%s", aVMDLDNSInfo.mHost, Integer.valueOf(aVMDLDNSInfo.mType), aVMDLDNSInfo.mIpList);
                    this.mDNSRecord.put(str, aVMDLDNSInfo);
                }
            }
            this.lock.unlock();
            AVMDLDataLoader.getInstance().updateDNSInfo(str, aVMDLDNSInfo.mIpList, aVMDLDNSInfo.mExpiredTime, null, aVMDLDNSInfo.mType);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public void putBackUpIp(String str, AVMDLDNSInfo aVMDLDNSInfo) {
        if (aVMDLDNSInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.backUplock.lock();
        try {
            String.format("put backupip for host:%s type:%d ip:%s", aVMDLDNSInfo.mHost, Integer.valueOf(aVMDLDNSInfo.mType), aVMDLDNSInfo.mIpList);
            this.mBackUps.put(str, aVMDLDNSInfo);
        } finally {
            this.backUplock.unlock();
        }
    }

    public void setCurNetType(int i) {
        mNetType = i;
    }
}
