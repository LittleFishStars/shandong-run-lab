package com.bykv.vk.component.ttvideo.mediakit.medialoader;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class AVMDLDataLoaderConfigure {
    public static final int ALLOW_PRELOAD_WHEN_PLAY = 0;
    public static final int DEFAULT_CHECK_SUM_LEVEL = 0;
    public static final int DEFAULT_MAX_CACHE_AGE = 1209600;
    public static final int DEFAULT_MAX_CACHE_SIZE = 314572800;
    public static final int DEFAULT_MAX_FACTORY_CACHE_SIZE = 209715200;
    public static final int DEFAULT_MAX_FACTORY_MEMORY_SIZE = 5242880;
    public static final int DEFAULT_P2P_PREDOWN_PEER_COUNT = 5;
    public static final int DEFAULT_PRELOAD_PARALLEL_NUM = 1;
    public static final int DEFAULT_SOCKET_IDLE_TIMEOUT = 120;
    public static final int DISABLE_EXTERN_DNS = 0;
    public static final int DISABLE_SOCKET_REUSE = 0;
    public static final int ENABLE_EXTERN_DNS = 1;
    public static final int ENABLE_SOCKET_REUSE = 1;
    public static final int ENCRYPT_VERSION_0 = 0;
    public static final int ENCRYPT_VERSION_1 = 1;
    public static final int IsCheckAfterAll = 1;
    public static final int IsCheckAfterPreloadTask = 0;
    public static final int NOT_ALLOW_PLAY_TASK_KEY_PRELOAD = 1;
    public static final int NOT_ALLOW_PRELOAD_WHEN_PLAY = 2;
    private static final String TAG = "AVMDLDataLoaderConfigure";
    public static final int TEST_SPEED_TYPE_VERSION_1 = 1;
    public static final int TEST_SPEED_TYPE_VERSION_2 = 2;
    public static final int WAIT_LIST_IS_QUEUE = 1;
    public static final int WAIT_LIST_IS_STACK = 0;
    public static final int XY_DY_LIB = 1;
    public static final int XY_XG_LIB = 0;
    public String mCacheDir;
    public int mMaxCacheSize;
    public int mOpenTimeOut;
    public int mRWTimeOut;
    public int mTryCount;
    public int mAlogEnable = 0;
    public int mMaxIPV6Num = Integer.MAX_VALUE;
    public int mMaxIPV4Num = Integer.MAX_VALUE;
    public int mEnablePlayLog = 0;
    public int mEnableNetScheduler = 0;
    public int mEnableCacheReqRange = 0;
    public int mEnableTTNetLoader = 0;
    public int mTTNetLoaderCronetBufSizeKB = 0;
    public int mNetSchedulerBlockAllNetErr = 0;
    public int mNetSchedulerBlockErrCount = 0;
    public int mNetSchedulerBlockHostIpErrCount = 0;
    public int mNetSChedulerBlockDurationMs = 0;
    public int mFirstRangeLeftThreshold = 0;
    public int mP2PPreDownPeerCount = 5;
    public int mP2PFirstRangeLoaderType = 1;
    public int mEnableStorageModule = 0;
    public int mStoPlayDldWinSizeKBNM = 0;
    public int mStoPlayDldWinSizeKBLS = 0;
    public int mStoRingBufferSizeKB = 0;
    public int mStoIoWriteLimitKBTh1 = 0;
    public int mStoIoWriteLimitKBTh2 = 0;
    public int mStoMaxIdleTimeSec = 0;
    public int mLoaderType = 0;
    public String mLoaderFactoryDir = null;
    public int mLoaderFactoryMaxCacheSize = DEFAULT_MAX_FACTORY_CACHE_SIZE;
    public int mLoaderFactoryMaxMemorySize = 5242880;
    public int mPreloadParallelNum = 1;
    public int mMaxCacheAge = DEFAULT_MAX_CACHE_AGE;
    public int mPreloadStrategy = 1;
    public int mPreloadWaitListType = 1;
    public int mEnablePreloadReUse = 0;
    public int mEnableExternDNS = 0;
    public int mEnableSocketReuse = 0;
    public int mControlCDNRangeType = 0;
    public int mIsCloseFileCache = 0;
    public int mSocketIdleTimeOut = 120;
    public int mDNSMainType = 0;
    public int mDNSBackType = 2;
    public int mMainToBackUpDelayedTime = 0;
    public int mLoaderFactoryP2PLevel = 3;
    public int mTestSpeedTypeVersion = 1;
    public int mCheckSumLevel = 0;
    public int mDefaultExpiredTime = 120;
    public String mAppInfo = null;
    public int mEncryptVersion = 0;
    public int mSpeedCoefficientValue = 0;
    public int mEnableBenchMarkIOSpeed = 0;
    public int mMaxIpCountEachDomain = 0;
    public int mEnableIpBucket = 0;
    public int mErrorStateTrustTime = 0;
    public int mOnlyUseCdn = 0;
    public int mSocketSendBufferKB = -1;
    public int mRingBufferSizeKB = -1;
    public int mEnableFileCacheV2 = 0;
    public String mVdpABTestId = null;
    public String mVdpGroupId = null;
    public int mEnableReportTaskLog = 0;
    public int mFileExtendSizeKB = 8192;
    public int mLiveP2pAllow = 0;
    public int mLiveLoaderType = 10000;
    public int mLiveLoaderEnable = 0;
    public int mLiveWatchDurationThreshold = 20000;
    public int mLiveCacheThresholdHttpToP2p = 3500;
    public int mLiveCacheThresholdP2pToHttp = 1000;
    public int mLiveMaxTrySwitchP2pTimes = 3;
    public int mLiveWaitP2pReadyThreshold = 60000;
    public int mLiveMobileUploadAllow = 0;
    public int mLiveMobileDownloadAllow = 0;
    public int mLiveRecvDataTimeout = 5000;
    public String mLiveContainerString = null;
    public int mLiveEnableMdlProto = 0;
    public int mEnablePreconnect = 0;
    public int mPreconnectNum = 3;
    public int mEnableLoaderPreempt = 0;
    public int mNextDownloadThreshold = 0;
    public int mAccessCheckLevel = 0;
    public int mEnableP2PPreDown = 0;
    public String mNetCacheDir = null;
    public int mMaxTlsVersion = 2;
    public int mEnableSessionReuse = 0;
    public int mEnableSyncDnsForPcdn = 0;
    public int mIgnorePlayInfo = 0;
    public String mSettingsDomain = null;
    public String mDmDomain = null;
    public String mForesightDomain = null;
    public String mDomains = null;
    public int mCheckPreloadLevel = 0;
    public int mXYLibValue = 1;
    public int mWriteFileNotifyIntervalMS = 500;
    public int mEnableFileRingBuffer = 0;
    public int mEnableLazyBufferpool = 0;
    public int mEnableNewBufferpool = 0;
    public int mNewBufferPoolBlockSize = 0;
    public int mNewBufferPoolResidentSize = 0;
    public int mNewBufferPoolGrowBlockCount = 0;
    public int mEnableUseFileExtendLoaderBuffer = 0;
    public int mMaxFileMemCacheSize = 0;
    public int mMaxFileMemCacheNum = 0;
    public String mDownloadDir = null;
    public String mKeyDomain = null;
    public String mKeyToken = null;
    public int mForbidByPassCookie = 0;
    public int mSessionTimeout = 3600;
    public int mEnablePlayInfoCache = 0;
    public int mEnableDownloaderLog = 0;
    public int mIsAllowTryTheLastUrl = 0;
    public int mSpeedSampleInterval = 0;
    public int mEnableIOManager = 0;
    public int mEnableLoaderSeek = 0;
    public int mGlobalSpeedSampleInterval = 0;
    public int mEnableDynamicTimeout = 0;
    public int mSocketInitialTimeout = 3;
    public int mMaxSocketReuseCount = 0;
    public long mP2PStragetyLevel = 0;
    public long mConnectPoolStragetyValue = 0;
    public int mMaxAliveHostNum = 0;
    public int mMinAllowSpeed = 0;
    public int mEnableOwnVDPPreloadNotify = 1;
    public long mMonitorTimeInternal = 0;
    public long mMonitorMinAllowLoadSize = 0;
    public String mSocketTraingCenterConfigStr = null;
    public int mEnableEventInfo = 0;
    public String mCacheDirListsStr = null;
    public int mEnableEarlyData = 0;

    public AVMDLDataLoaderConfigure(int i, int i2, int i3, int i4, String str) {
        this.mMaxCacheSize = i;
        this.mOpenTimeOut = i2;
        this.mRWTimeOut = i3;
        this.mTryCount = i4;
        this.mCacheDir = str;
    }

    public static AVMDLDataLoaderConfigure getDefaultonfigure() {
        return new AVMDLDataLoaderConfigure(DEFAULT_MAX_CACHE_SIZE, 5, 5, 0, null);
    }

    public void ParseJsonConfig() {
        try {
            if (this.mLiveContainerString != null) {
                JSONObject jSONObject = new JSONObject(this.mLiveContainerString);
                if (jSONObject.isNull("enable_mdl_proto")) {
                    return;
                }
                this.mLiveEnableMdlProto = jSONObject.getInt("enable_mdl_proto");
                AVMDLLog.w("ttmn", "mdl live json enable_mdl_proto:" + this.mLiveEnableMdlProto);
            }
        } catch (Exception e) {
            AVMDLLog.e("ttmn", "parse json config fail:" + e.toString());
        }
    }

    public void setCacheInfoList(String[] strArr, long[] jArr) {
        if (strArr.length == 0 || jArr.length == 0 || strArr.length != jArr.length) {
            return;
        }
        this.mCacheDirListsStr = null;
        for (int i = 0; i < strArr.length; i++) {
            if (!TextUtils.isEmpty(strArr[i])) {
                if (this.mCacheDirListsStr == null) {
                    this.mCacheDirListsStr = strArr[i] + "$" + Long.toString(jArr[i]);
                } else {
                    this.mCacheDirListsStr += "|" + strArr[i] + "$" + Long.toString(jArr[i]);
                }
            }
        }
        if (TextUtils.isEmpty(this.mCacheDirListsStr)) {
            AVMDLLog.e(TAG, "cache dir list str is null");
        }
    }
}
