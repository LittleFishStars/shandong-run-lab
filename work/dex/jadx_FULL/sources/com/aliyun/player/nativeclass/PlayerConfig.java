package com.aliyun.player.nativeclass;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PlayerConfig {
    public String mHttpProxy = "";
    public String mReferrer = "";
    public int mNetworkTimeout = 15000;
    public int mMaxDelayTime = 5000;
    public int mMaxBufferDuration = 50000;
    public int mHighBufferDuration = 3000;
    public int mStartBufferDuration = 500;
    public int mMaxProbeSize = -1;
    public boolean mClearFrameWhenStop = false;
    public boolean mEnableVideoTunnelRender = false;
    public boolean mEnableVideoBufferRender = false;
    public boolean mEnableSEI = false;
    public String mUserAgent = "";
    public int mNetworkRetryCount = 2;
    public int mLiveStartIndex = -3;
    public boolean mDisableAudio = false;
    public boolean mDisableVideo = false;
    public int mPositionTimerIntervalMs = 500;
    public long mMaxBackwardBufferDurationMs = 0;
    public boolean mPreferAudio = false;
    public boolean mEnableLocalCache = true;
    public int mEnableHttpDns = -1;
    public int mEnableEnhancedHttpDns = -1;
    public boolean mEnableHttp3 = false;
    public boolean mEnableStrictFlvHeader = false;
    public boolean mEnableLowLatencyMode = false;
    public boolean mEnableProjection = false;
    public boolean mEnableStrictAuthMode = false;
    public int mStartBufferLimit = 15000;
    public int mStopBufferLimit = 3000;
    private String[] mCustomHeaders = null;

    private PlayerConfig() {
    }

    public String[] getCustomHeaders() {
        return this.mCustomHeaders;
    }

    public void setCustomHeaders(String[] strArr) {
        this.mCustomHeaders = strArr;
    }
}
