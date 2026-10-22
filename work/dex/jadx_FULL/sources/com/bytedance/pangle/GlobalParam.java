package com.bytedance.pangle;

import androidx.annotation.Keep;
import com.byazt.blh.c;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public class GlobalParam {
    public static GlobalParam mInstance;
    public boolean mCheckPermission;
    public boolean mCloseCrashMonitor;
    public boolean mCloseFlipped;
    public boolean mCloseHookHuaweiOnInit;
    public String mDid;
    public File mDownloadDir;
    public boolean mFastDex2oat;
    public String mHostUrl;
    public IZeusLogger mLogger;
    public boolean hasInit = false;
    public boolean mDebug = true;
    public c mReporter = new c() { // from class: com.bytedance.pangle.GlobalParam.1
        @Override // com.byazt.blh.c
        public void c(String str, String str2) {
        }

        @Override // com.byazt.blh.c
        public void c(String str, JSONObject jSONObject) {
        }
    };
    public int mInstallThreads = 1;
    public boolean mCheckMatchHostAbi = true;
    public final Map<String, String> mRequestHeader = new HashMap();
    public final Map<String, Boolean> unInstallPluginWhenHostChange = new HashMap();
    public final Map<String, Map<String, String>> mCustomTag = new HashMap();
    public final Map<String, String> mSignature = new HashMap();
    public long mDexOptDelayTime = 15000;
    public boolean mPostBgDexOptByInit = true;
    public boolean mAutoFetch = true;
    public final Map<String, Integer> mRemoveApkEntry = new HashMap();
    public boolean mCloseBgDex2oat = false;

    private void ensureInit() {
        if (this.hasInit) {
            throw new RuntimeException();
        }
    }

    public static GlobalParam getInstance() {
        if (mInstance == null) {
            synchronized (GlobalParam.class) {
                if (mInstance == null) {
                    mInstance = new GlobalParam();
                }
            }
        }
        return mInstance;
    }

    public void addRequestHeader(String str, String str2) {
        ensureInit();
        this.mRequestHeader.put(str, str2);
    }

    public boolean autoFetch() {
        return this.mAutoFetch;
    }

    public boolean checkMatchHostAbi() {
        return this.mCheckMatchHostAbi;
    }

    public boolean checkPermission() {
        return this.mCheckPermission;
    }

    public void closeBgDex2oat(boolean z) {
        ensureInit();
        this.mCloseBgDex2oat = z;
    }

    public void closeCrashMonitor(boolean z) {
        ensureInit();
        this.mCloseCrashMonitor = z;
    }

    public void closeHookHuaweiOnInit(boolean z) {
        ensureInit();
        this.mCloseHookHuaweiOnInit = z;
    }

    public Map<String, String> getCustomTag(String str) {
        return this.mCustomTag.get(str);
    }

    public long getDexOptDelayTime() {
        return this.mDexOptDelayTime;
    }

    public String getDid() {
        return this.mDid;
    }

    public File getDownloadDir() {
        return this.mDownloadDir;
    }

    public String getHostUrl() {
        return this.mHostUrl;
    }

    public int getInstallThreads() {
        return this.mInstallThreads;
    }

    public IZeusLogger getLogger() {
        return this.mLogger;
    }

    public int getRemoveApkEntryFlag(String str) {
        Integer num = this.mRemoveApkEntry.get(str);
        if (num == null) {
            num = 0;
        }
        return num.intValue();
    }

    public c getReporter() {
        return this.mReporter;
    }

    public Map<String, String> getRequestHeader() {
        return this.mRequestHeader;
    }

    public String getSignature(String str) {
        return this.mSignature.get(str);
    }

    public void init() {
        this.hasInit = true;
    }

    public boolean isCloseBgDex2oat() {
        return this.mCloseBgDex2oat;
    }

    public boolean isCloseCrashMonitor() {
        return this.mCloseCrashMonitor;
    }

    public boolean isCloseFlipped() {
        return this.mCloseFlipped;
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public boolean isFastDex2oat() {
        return this.mFastDex2oat;
    }

    public boolean isPostBgDexOptByInit() {
        return this.mPostBgDexOptByInit;
    }

    public void postBgDexOptByInit(boolean z) {
        ensureInit();
        this.mPostBgDexOptByInit = this.mPostBgDexOptByInit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeApkEntry(String str, boolean z, boolean z2) {
        ensureInit();
        int i = z;
        if (z2) {
            i = (z ? 1 : 0) | 2;
        }
        this.mRemoveApkEntry.put(str, Integer.valueOf(i));
    }

    public void setAutoFetch(boolean z) {
        ensureInit();
        this.mAutoFetch = z;
    }

    public void setCheckMatchHostAbi(boolean z) {
        this.mCheckMatchHostAbi = z;
    }

    public void setCheckPermission(boolean z) {
        this.mCheckPermission = z;
    }

    public void setCloseFlipped(boolean z) {
        ensureInit();
        this.mCloseFlipped = z;
    }

    public void setCustomTag(String str, Map<String, String> map) {
        this.mCustomTag.put(str, map);
    }

    public void setDebug(boolean z) {
        ensureInit();
        this.mDebug = z;
    }

    public void setDexOptDelayTime(long j) {
        ensureInit();
        this.mDexOptDelayTime = j;
    }

    public void setDid(String str) {
        this.mDid = str;
    }

    public void setDownloadDir(File file) {
        ensureInit();
        this.mDownloadDir = file;
    }

    public void setFastDex2oat(boolean z) {
        this.mFastDex2oat = z;
    }

    public void setHostUrl(String str) {
        ensureInit();
        this.mHostUrl = str;
    }

    public void setInstallThreads(int i) {
        ensureInit();
        this.mInstallThreads = i;
    }

    public void setLogger(IZeusLogger iZeusLogger) {
        ensureInit();
        this.mLogger = iZeusLogger;
    }

    public void setReporter(c cVar) {
        ensureInit();
        if (cVar != null) {
            this.mReporter = cVar;
        }
    }

    public void setSignature(String str, String str2) {
        ensureInit();
        Plugin pluginOnly = PluginManager.getInstance().getPluginOnly(str);
        if (pluginOnly != null) {
            pluginOnly.mSignature = str2;
        } else {
            this.mSignature.put(str, str2);
        }
    }

    public void setUnInstallPluginWhenHostChange(String str, boolean z) {
        ensureInit();
        this.unInstallPluginWhenHostChange.put(str, Boolean.valueOf(z));
    }

    public boolean unInstallPluginWhenHostChange(String str) {
        Boolean bool = this.unInstallPluginWhenHostChange.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean closeHookHuaweiOnInit() {
        return this.mCloseHookHuaweiOnInit;
    }
}
