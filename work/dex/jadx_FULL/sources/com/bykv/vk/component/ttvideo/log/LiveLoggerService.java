package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.byazt.f.uj;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.ILiveListener;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.VideoLiveManager;
import com.bykv.vk.component.ttvideo.medialoader.MediaLoaderWrapper;
import com.bykv.vk.component.ttvideo.network.NetUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.ze1;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class LiveLoggerService implements Handler.Callback {
    private static final long INTERVAL = 60000;
    public static final String LIVE_SDK_VERSION = "1.4.6.31-lite";
    private static final String LOG_REPORT_VERSION = "5";
    public static final String MONITOR_LOG_TYPE = "live_client_monitor_log";
    private static final int MSG_DNS = 104;
    private static final int MSG_LOG_SCHEDULE = 101;
    private static final int MSG_NTP_TIME_SYNC = 103;
    private static final int MSG_SESSION_SERIES_SCHEDULE = 102;
    private static final String PRODUCT_LINE = "live";
    public static final String RTC_MONITOR_LOG_TYPE = "live_webrtc_monitor_log";
    private static final long SESSION_TIME_SERIES_INTERVAL = 5000;
    private static final String TAG = "com.bykv.vk.component.ttvideo.log.LiveLoggerService";
    private Context mContext;
    private boolean mHasNTP;
    private InetAddress mHostAddr;
    public String mHostNTPUrl;
    private final long mInterval;
    private VideoLiveManager mLiveEngine;
    private LogBundle mLogBundle;
    private ILiveListener mLogUploader;
    private MyNTPTask mNTPTask;
    public LogBundle mSessionLogBundle;
    public long mStallRetryTimeInterval;
    private long playerFromStartToRtsFrame;
    private boolean mStarted = false;
    public String mEnterMethod = "none";
    public String mEnterAction = "none";
    private String mCommonFlag = "none";
    private String mProjectKey = "none";
    private String mCdnPlayURL = "none";
    private String mCurrentPlayURL = "none";
    private String mCdnIp = "none";
    private boolean mIpIsFromPlayerCore = false;
    private String mPlayerVersion = "none";
    private boolean mIsPreview = false;
    private long mLogIndex = 0;
    private String mSdkParams = "none";
    private String mPushClientSDKVersion = "none";
    private String mPushClientPlatform = "none";
    private String mPushClientOSVersion = "none";
    private String mPushClientModel = "none";
    private String mPushClientStartTime = "none";
    private int mPushClientHardwareEncode = -1;
    private int mPushClientMinBitrate = -1;
    private int mPushClientMaxBitrate = -1;
    private int mPushClientDefaultBitrate = -1;
    private int mPushClientHitNodeOptimize = -1;
    private String mPushClientPushProtocal = "none";
    private String mPushClientQId = "none";
    private String mLinkInfo = "";
    private boolean mOpenNodeOptimizer = false;
    private String mEvaluatorSymbol = "none";
    private boolean mHitNodeOptimizer = false;
    private boolean mIsRemoteSorted = false;
    private boolean mIsHitCache = false;
    public String mCodecType = "none";
    public boolean mHardDecodeEnable = false;
    public String mCodecName = "none";
    public boolean mEnableHurry = false;
    public int mHurryTime = -1;
    public float mCatchSpeed = -1.0f;
    public int mSlowPlayTime = -1;
    public float mSlowSpeed = -1.0f;
    public int mSpeedSwitchCount = 0;
    public String mSpeedSwitchInfo = "none";
    public long mStartPlayBufferThres = 0;
    public int mFastOpenDuration = -1;
    public int mCheckBufferingEndIgnoreVideo = 0;
    public int mStartDirectAfterPrepared = 0;
    public int mCheckBufferingEndAdvanceEnable = 0;
    public int mAudioTimescaleEnable = -1;
    public String mRuleIds = "none";
    public String mSessionId = "none";
    private String mStreamFormat = LiveConfigKey.FLV;
    private boolean mHasFirstFrame = false;
    private long mFirstFrameTimestamp = 0;
    public long mLogTotalCount = 0;
    private int mErrorCode = 0;
    private int mRenderFailType = 0;
    private long mStallStartTime = 0;
    private long mPlayingStallStartTime = 0;
    private long mStallReason = -1;
    private long mStallTotalCount = 0;
    private long mStallTotalTime = 0;
    private long mVideoRenderStallTotalCount = 0;
    private long mVideoRenderStallTotalTime = 0;
    private long mAudioRenderStallTotalCount = 0;
    private long mAudioRenderStallTotalTime = 0;
    private boolean mIsStalling = false;
    private int mPlayingStallCount = 0;
    private int mPlayingStallTime = 0;
    private int mPlayingVideoRenderStallCount = 0;
    private int mPlayingVideoRenderStallTime = 0;
    private int mPlayingAudioRenderStallCount = 0;
    private int mPlayingAudioRenderStallTime = 0;
    private long mFirstStallStartTime = 0;
    private long mFirstStallEndTime = 0;
    private int mRetryCount = 0;
    private int mRetryTotalCount = 0;
    private boolean mEnableCheckSilenceInterval = false;
    public int mSilenceDetectedCount = -1;
    private boolean mEnableSharp = false;
    private boolean mEnableCheckSei = false;
    private boolean mIsInErrorRecovering = false;
    private long mErrorStartTime = 0;
    private long mErrorRecoverCount = 0;
    private long mErrorRecoverTime = 0;
    private com.byazt.f.c mNTPClient = null;
    private final long mNTPInterval = 300000;
    private int mCurNetType = -1;
    private String mCurNetExtraInfo = null;
    private boolean mNTPRunning = false;
    public int mEnableNTP = 0;
    public int mEnableNTPTask = 0;
    public long mTimeDiff = 0;
    public int mEnableOpenMDL = 0;
    public int mEnableP2P = 0;
    public int mUsedP2P = 0;
    public int mEnableLiveIOPlay = 0;
    public int mP2PLoaderType = -1;
    public String mMDLVersion = null;
    public int mEnableMdlProto = 0;
    public int mWidth = 0;
    public int mHeight = 0;
    private int mPreconnect = -1;
    private ArrayList<Long> mRenderFpsTimeSeries = null;
    private ArrayList<Long> mDownloadSpeedTimeSeries = null;
    private ArrayList<Long> mAudioBufferTimeSeries = null;
    private ArrayList<Long> mStallTimeSeries = null;
    private JSONObject mErrorTimeSeries = null;
    private ArrayList<Integer> mSeiBitrateTimeSeries = null;
    private ArrayList<Integer> mSeiFpsTimeSeries = null;
    private boolean mSeiHasBitrateAndFps = false;
    public boolean mEnableHttpDns = false;
    public int mMediaCodecAsyncInit = 0;
    public int mDefaultCodecID = -1;
    public String mUrlAbility = "none";
    public boolean mEnableUploadSessionSeries = false;
    public int mMaxCacheSeconds = -1;
    public int mEnableSplitStream = 0;
    public int mTslTimeShift = -1;
    public boolean mEnableSeiCheck = false;
    public int mEnableFastOpenStream = 0;
    public int mIsInMainLooper = 1;
    public long mSetSurfaceCost = 0;
    public long mSetSurfaceTime = 0;
    public String mStreamData = "none";
    public int mTextureRenderError = 0;
    public boolean mSRSuccess = false;
    public boolean mUseTextureRender = false;
    public float mContainerFps = -1.0f;
    public long mRenderStartNotifyTimeStamp = 0;
    private String mSuggestFormat = "none";
    private String mProtocol = LiveConfigKey.TCP;
    private String mSuggestProtocol = "none";
    private int mQuicFlag = -1;
    private String mOriginUrl = "none";
    private String mChipBoard = Build.BOARD;
    private String mChipHardware = Build.HARDWARE;
    public String mSettingsInfo = "none";
    public String mTTNetNQEInfo = "none";
    public boolean mEnableResolutionAutoDegrade = false;
    public String mAbrStrategy = LiveConfigKey.RAD;
    public boolean mHasAbrInfo = false;
    public String mResolution = "origin";
    public String mAutoUsingResolution = "origin";
    public String mLastResolution = "none";
    public long mResBitrate = -1;
    public int mDefaultResBitrate = -1;
    public int mAbrSwitchCount = 0;
    public String mAbrSwitchCountInfo = "none";
    public long mCurDownloadSpeed = -1;
    public long mCurAudioBufferTime = -1;
    public long mCurVideoBufferTime = -1;
    public long mAbrSwitchCost = -1;
    public String mAbrSwitchInfo = "none";
    public int mStallCountThresOfResolutionDegrade = 4;
    public boolean mHaveResetPlayer = false;
    public long mLastDownloadSizeDelta = 0;
    public long mLastTotalDownloadSize = 0;
    public long mFirstAudioPacketDTS = -1;
    public long mPreviousAudioPacketDTS = -1;
    private int mFirstFrameRetryCount = 0;
    private long mFirstFramePrepareTime = 0;
    public long mLastPrepareTime = 0;
    public int mNetworkTimeoutMs = -1;
    public int mQuicScfgConfig = -1;
    public int mQuicMtu = -1;
    public int mQuicPadHello = -1;
    public int mQuicTimerVersion = -1;
    public int mEnableTcpFastOpen = 0;
    public int mEnableLowLatencyFLV = 0;
    public List<String> mOptimizeBackupIps = null;
    private final int TYPE_DATA_LOST = 0;
    private final int TYPE_DATA_REPEAT = 1;
    private final int TYPE_SEI_NOT_AVAIL = 2;
    private final int TYPE_SEI_LOST = 3;
    private final int TYPE_SEI_INDEX_ROLLBACK = 4;
    private LinkedBlockingQueue<Long> mVideoDTSQueue = null;
    private final int VIDEO_DTS_QUEUE_MAX_SIZE = 600;
    private int mLastIndex = -1;
    private int mLastSentFrames = -1;
    private long mLastCheckDTS = -1;
    private int mLastSeiIndex = -1;
    private int mExpectedSeiCount = 0;
    private int mReceivedSeiCount = 0;
    private int mExpectedUniqueSeiCount = 0;
    private int mReceivedUniqueSeiCount = 0;
    public int mEnableLiveAbrCheckEnhance = 0;
    public int mEnableRtcPlay = 0;
    public int mEnableMiniSdp = 0;
    public int mRtcPlayFallBack = 0;
    public String mDnsIp = "none";
    public int mRtcUseSdkDns = -1;
    public long mRtcDnsTimeStamp = 0;
    public long mRtcTcpConnectTimeStamp = 0;
    public long mRtcTlsHandshakedTimeStamp = 0;
    public long mRtcTcpFirstPackageTimeStamp = 0;
    public int mFallbackType = 0;
    public String mRtcSessionId = "none";
    public String mRtcPlayStopStatInfo = "none";
    public int mBitRateAbnormalType = 0;
    public int mCodecNotSame = 0;
    public int mABRListMatch = 1;
    public boolean mIsCdnAbrSwitch = false;
    public int mCdnAbrSwitchCode = -1;
    public String mRequestUrl = "none";
    public Map<String, String> mRequestHeaders = null;
    public int mDisableVideoRender = 0;
    public int mMuteAudio = -1;
    public float mVolumeSetting = -1.0f;
    public float mPlayerVolumeSetting = -1.0f;
    public int mUseExpectBitrate = 0;
    public int mFCDNTranscodeMethod = -1;
    public long mTextureRenderFirstFrameTime = 0;
    public int mEnableReportSessionStop = 0;
    public boolean mSessionHasFirstFrame = false;
    public long mSessionStartTime = 0;
    public long mSessionVideoRenderStartTime = 0;
    public long mSessionAudioRenderStartTime = 0;
    private int mSessionNum = 0;
    private long mSessionStallTotalCount = 0;
    private long mSessionStallTotalTime = 0;
    private long mSessionVideoRenderStallTotalCount = 0;
    private long mSessionVideoRenderStallTotalTime = 0;
    private long mSessionAudioRenderStallTotalCount = 0;
    private long mSessionAudioRenderStallTotalTime = 0;
    private long mSessionFirstStallStartTime = 0;
    private long mSessionFirstStallEndTime = 0;
    private int mSessionRenderFailType = -1;
    private int mSessionErrorCode = -1;
    private String mSessionErrorMsg = "none";
    private long mVideoDecodeStallTotalCount = 0;
    private long mVideoDecodeStallTotalTime = 0;
    private long mAudioDecodeStallTotalCount = 0;
    private long mAudioDecodeStallTotalTime = 0;
    private long mVideoDemuxStallTotalCount = 0;
    private long mVideoDemuxStallTotalTime = 0;
    private long mAudioDemuxStallTotalCount = 0;
    private long mAudioDemuxStallTotalTime = 0;
    public int mLiveIOPlay = 0;
    public int mLiveIOP2P = 0;
    public String mLiveIOErrorMsg = "none";
    public long mFirstFrameView = 0;
    public String mLiveIOVersion = "none";
    private boolean mHasUsedSharpen = false;
    public long mNoSyncStartTime = 0;
    public long mNoSyncStartPts = 0;
    public int mNoSyncCount = 0;
    public int mNoSyncPlayingCount = 0;
    public long mNoSyncTimeDuration = 0;
    public long mNoSyncPlayingTimeDuration = 0;
    public long mNoSyncPtsDuration = 0;
    public long mNoSyncPlayingPtsDuration = 0;
    public int mNoSyncInfoLen = 4096;
    public int mNoSyncPlayingInfoLen = 512;
    public String mNoSyncInfoStr = "";
    public String mNoSyncPlayingInfoStr = "";
    private long mRtcPlayingLogInterval = 5000;
    public int mUseLiveThreadPool = 0;
    private Handler mHandler = new Handler(this);

    public static class MyNTPTask {
        private Handler mHandler;
        private HandlerThread mHandlerThread;

        public MyNTPTask(final LiveLoggerService liveLoggerService) {
            HandlerThread handlerThread = new HandlerThread("DnsHandlerThread");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.bykv.vk.component.ttvideo.log.LiveLoggerService.MyNTPTask.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    String str;
                    if (message == null || (str = liveLoggerService.mHostNTPUrl) == null || str.equals("null")) {
                        return;
                    }
                    if ((message.what == 104 && liveLoggerService.mCurNetType == -1) || liveLoggerService.isNetWorkChanged() || liveLoggerService.mHostAddr == null) {
                        try {
                            LiveLoggerService liveLoggerService2 = liveLoggerService;
                            liveLoggerService2.mHostAddr = InetAddress.getByName(liveLoggerService2.mHostNTPUrl);
                        } catch (UnknownHostException e) {
                            liveLoggerService.mHostAddr = null;
                            m.c(e);
                        }
                    }
                    if (message.what == 103) {
                        liveLoggerService.ntp();
                        if (liveLoggerService.mNTPRunning) {
                            MyNTPTask.this.mHandler.sendEmptyMessageDelayed(103, 300000L);
                        }
                    }
                }
            };
        }

        public void sendEmptyMessageDelayed(int i, long j) {
            Handler handler;
            if (this.mHandlerThread == null || (handler = this.mHandler) == null) {
                return;
            }
            if (j == 0) {
                handler.sendEmptyMessage(i);
            } else {
                handler.sendEmptyMessageDelayed(i, j);
            }
        }
    }

    public LiveLoggerService(VideoLiveManager videoLiveManager, ILiveListener iLiveListener, long j, long j2, Context context, int i) {
        this.mStallRetryTimeInterval = 10000L;
        this.mContext = context;
        this.mInterval = j <= 0 ? 60000L : j;
        this.mLogUploader = iLiveListener;
        this.mLiveEngine = videoLiveManager;
        this.mLogBundle = new LogBundle();
        this.mStallRetryTimeInterval = j2;
        MyLog.i(TAG, "enable report sessionstop: ".concat(String.valueOf(i)));
        if (i == 1) {
            this.mSessionLogBundle = new LogBundle();
        }
    }

    private JSONObject _createSessionTimeSeries() {
        updateSessionSeries();
        try {
            JSONObject jSONObjectPut = new JSONObject().put(CropKey.RESULT_KEY_START_TIME, this.mLogBundle.startPlayTime).put("duration", System.currentTimeMillis() - this.mLogBundle.startPlayTime).put("render_fps_series", new JSONArray((Collection) this.mRenderFpsTimeSeries)).put("download_bitrate_series", new JSONArray((Collection) this.mDownloadSpeedTimeSeries)).put("play_buffer_series", new JSONArray((Collection) this.mAudioBufferTimeSeries)).put("push_bitrate_series", this.mSeiBitrateTimeSeries == null ? new JSONArray() : new JSONArray((Collection) this.mSeiBitrateTimeSeries)).put("push_fps_series", this.mSeiFpsTimeSeries == null ? new JSONArray() : new JSONArray((Collection) this.mSeiFpsTimeSeries)).put("stall_series", this.mStallTimeSeries == null ? new JSONArray() : new JSONArray((Collection) this.mStallTimeSeries));
            JSONObject jSONObject = this.mErrorTimeSeries;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            return jSONObjectPut.put("error_series", jSONObject);
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    private void checkSeiIndex(int i) {
        this.mReceivedSeiCount++;
        this.mExpectedSeiCount++;
        int i2 = this.mLastSeiIndex;
        if (i2 >= 0) {
            if (i <= i2) {
                onStreamAbnormalSEI(4, i, i2);
                if (i == 1) {
                    this.mExpectedUniqueSeiCount++;
                    this.mReceivedUniqueSeiCount++;
                }
            } else {
                this.mExpectedUniqueSeiCount++;
                this.mReceivedUniqueSeiCount++;
                if (i - i2 > 1) {
                    onStreamAbnormalSEI(3, i, i2);
                    int i3 = this.mExpectedSeiCount;
                    int i4 = this.mLastSeiIndex;
                    this.mExpectedSeiCount = i3 + ((i - i4) - 1);
                    this.mExpectedUniqueSeiCount += (i - i4) - 1;
                }
            }
        }
        this.mLastSeiIndex = i;
    }

    private void checkVideoFrame(int i, int i2, long j) {
        LinkedBlockingQueue<Long> linkedBlockingQueue;
        if (i < 0 || i2 <= 0 || j < 0 || (linkedBlockingQueue = this.mVideoDTSQueue) == null) {
            return;
        }
        int i3 = this.mLastIndex;
        if (i3 == -1) {
            this.mLastIndex = i;
            this.mLastSentFrames = i2;
            this.mLastCheckDTS = j;
            return;
        }
        if (i == i3) {
            return;
        }
        long jLongValue = linkedBlockingQueue.size() > 0 ? this.mVideoDTSQueue.peek().longValue() : -1L;
        if (jLongValue > 0 && jLongValue <= this.mLastCheckDTS) {
            boolean z = false;
            int i4 = 0;
            while (this.mVideoDTSQueue.size() > 0) {
                long jLongValue2 = this.mVideoDTSQueue.peek().longValue();
                long j2 = this.mLastCheckDTS;
                if (jLongValue2 == j2) {
                    z = true;
                }
                if (z && jLongValue2 > j2 && jLongValue2 <= j) {
                    i4++;
                    if (jLongValue2 == j) {
                        break;
                    }
                }
                this.mVideoDTSQueue.poll().longValue();
            }
            if (i - this.mLastIndex == 1 && i4 > 0 && i4 != i2) {
                onStreamAbnormalFrame(i4 < i2 ? 0 : 1, i2, i4);
            }
        }
        int i5 = this.mLastIndex;
        if (i - i5 != 1) {
            onStreamAbnormalSEI(i <= i5 ? 1 : 0, i, i5);
        }
        this.mLastIndex = i;
        this.mLastSentFrames = i2;
        this.mLastCheckDTS = j;
    }

    private JSONObject createFirstFrameLog(LogBundle logBundle, long j, boolean z, long j2) throws JSONException {
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog == null) {
            return null;
        }
        JSONObject jSONObjectPut = jSONObjectCreateCommonLog.put("event_key", "first_frame").put("last_retry_end", j).put("hit_cache", z ? 1 : 0).put("start", logBundle.startPlayTime).put("sdk_dns_analysis_end", logBundle.SDKDNSTimeStamp).put("prepare_block_end", logBundle.callPrepareTime);
        long j3 = logBundle.tfoFallBackTime;
        if (j3 <= 0) {
            j3 = logBundle.playerDNSTimestamp;
        }
        jSONObjectPut.put("tfo_fall_back_time", j3).put("pre_connect", this.mPreconnect).put("http_req_finish_time", logBundle.httpReqFinishTimestamp).put("http_res_finish_time", logBundle.httpResFinishTimestamp).put("first_video_package_end", logBundle.videoPacketTimestamp).put("first_audio_package_end", logBundle.audioPacketTimestamp).put("first_video_frame_decode_end", logBundle.videoDecodeTimestamp).put("first_audio_frame_decode_end", logBundle.audioDecodeTimestamp).put("first_frame_from_player_core", logBundle.videoRenderTimeForPlayerCore).put("first_frame_render_end", logBundle.videoRenderTimestamp).put("video_param_send_outlet_time", logBundle.videoParamSendOutletTime).put("first_video_frame_send_outlet_time", logBundle.firstVideoFrameSendOutletTime).put("set_surface_time", this.mSetSurfaceTime).put("set_surface_cost", this.mSetSurfaceCost).put("video_render_type", logBundle.renderType).put("video_device_open_start", logBundle.videoDeviceOpenTime).put("video_device_open_end", logBundle.videoDeviceOpenedTime).put("audio_device_open_start", logBundle.audioDeviceOpenTime).put("audio_device_open_end", logBundle.audioDeviceOpenedTime).put("video_device_wait_start", logBundle.videoDeviceWaitStartTime).put("video_device_wait_end", logBundle.videoDeviceWaitEndTime).put("find_stream_info_start", logBundle.streamInfoFindTime).put("find_stream_info_end", logBundle.streamInfoFoundTime).put("video_first_pkt_pos", logBundle.videoFirstPacketPos).put("video_first_pkt_pts", logBundle.videoFirstPacketPts).put("audio_first_pkt_pos", logBundle.audioFirstPacketPos).put("audio_first_pkt_pts", logBundle.audioFirstPacketPts).put("video_buffer_time", this.mLogBundle.videoBufferTime).put("audio_buffer_time", this.mLogBundle.audioBufferTime).put("download_speed", this.mLogBundle.downloadSpeed).put("stall_time", j2).put("first_sei_delay", this.mLogBundle.delay).put("response_header_X-Server-IP", this.mLogBundle.headerXServerIP).put("response_header_Via", this.mLogBundle.headerVia).put("prepare_end", logBundle.prepareEndTimestamp).put("drop_audio_pts_diff", logBundle.dropAudioPts).put("drop_audio_cost", logBundle.dropAudioCostTime).put("enable_tcp_fast_open", this.mEnableTcpFastOpen).put("tfo_success", logBundle.tfoSuccess).put("abr_check_enhance", this.mEnableLiveAbrCheckEnhance).put("optimize_backup_ips", this.mOptimizeBackupIps == null ? new JSONArray() : new JSONArray((Collection) this.mOptimizeBackupIps)).put("suggest_format", this.mSuggestFormat).put("suggest_protocol", this.mSuggestProtocol).put("container_fps", this.mContainerFps);
        if (isRtcPlayAvailable()) {
            jSONObjectCreateCommonLog.put("player_dns_analysis_end", this.mRtcDnsTimeStamp);
            jSONObjectCreateCommonLog.put("rtc_use_sdk_dns", this.mRtcUseSdkDns);
            jSONObjectCreateCommonLog.put("tcp_connect_end", this.mRtcTcpConnectTimeStamp);
            jSONObjectCreateCommonLog.put("rtc_tls_handshake_end", this.mRtcTlsHandshakedTimeStamp);
            jSONObjectCreateCommonLog.put("tcp_first_package_end", this.mRtcTcpFirstPackageTimeStamp);
            jSONObjectCreateCommonLog.put("rtc_inited_end", logBundle.rtcInitedTime);
            jSONObjectCreateCommonLog.put("rtc_offer_send_end", logBundle.rtcOfferSendTime);
            jSONObjectCreateCommonLog.put("rtc_answer_recv_end", logBundle.rtcAnswerRecvTime);
            jSONObjectCreateCommonLog.put("rtc_start_end", logBundle.rtcStartTime);
        } else {
            jSONObjectCreateCommonLog.put("player_dns_analysis_end", logBundle.playerDNSTimestamp);
            jSONObjectCreateCommonLog.put("tcp_connect_end", this.mProtocol.equals(LiveConfigKey.KCP) ? logBundle.playerDNSTimestamp : logBundle.tcpConnectTimestamp);
            jSONObjectCreateCommonLog.put("tcp_first_package_end", logBundle.tcpFirstPacketTimestamp);
        }
        int i = this.mAudioTimescaleEnable;
        if (i != -1) {
            jSONObjectCreateCommonLog.put("audio_timescale_enable", i);
        }
        return jSONObjectCreateCommonLog;
    }

    private JSONObject createPlayingLog(LogBundle logBundle, long j, long j2, long j3, long j4, boolean z) throws JSONException {
        long j5;
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog == null) {
            return null;
        }
        long j6 = logBundle.playTime - j3;
        long j7 = logBundle.currentPosition - j4;
        long j8 = logBundle.playedSize - j2;
        long j9 = (j7 <= 0 || j8 <= 0) ? 0L : (j8 * 8) / j7;
        this.mLogIndex++;
        int i = this.mPlayingStallCount;
        int iCurrentTimeMillis = this.mPlayingStallTime;
        if (this.mIsStalling && this.mPlayingStallStartTime != 0) {
            i++;
            iCurrentTimeMillis = (int) (((long) iCurrentTimeMillis) + (System.currentTimeMillis() - this.mPlayingStallStartTime));
            this.mPlayingStallStartTime = System.currentTimeMillis();
        }
        long j10 = logBundle.downloadSize;
        long j11 = this.mLastTotalDownloadSize + j10;
        if (this.mHaveResetPlayer) {
            j5 = j10 + this.mLastDownloadSizeDelta;
            this.mLastDownloadSizeDelta = 0L;
        } else {
            j5 = j10 - j;
        }
        this.mHaveResetPlayer = false;
        jSONObjectCreateCommonLog.put("event_key", "playing").put("download_size_delta", j5).put("download_size", j11).put("video_play_size", logBundle.playedSize).put("render_fps", logBundle.fps).put("video_rate", j9).put("download_speed", this.mLogBundle.downloadSpeed).put("play_time", j6).put("retry_count", this.mRetryCount).put("stall_count", i).put("stall_time", iCurrentTimeMillis).put("audio_render_stall_count", this.mPlayingAudioRenderStallCount).put("audio_render_stall_time", this.mPlayingAudioRenderStallTime).put("video_render_stall_count", this.mPlayingVideoRenderStallCount).put("video_render_stall_time", this.mPlayingVideoRenderStallTime).put("silence_detected_count", this.mSilenceDetectedCount).put("is_last", z ? 1 : 0).put("index", this.mLogIndex).put("speed_switch_count", this.mSpeedSwitchCount).put("speed_switch_info", this.mSpeedSwitchInfo).put("video_buffer_time", this.mLogBundle.videoBufferTime).put("audio_buffer_time", this.mLogBundle.audioBufferTime).put("enable_sei_check", this.mEnableSeiCheck ? 1 : 0).put("ntp_sync", this.mHasNTP ? 1 : 0).put("rtc_stat_info", this.mLogBundle.rtcStatInfo).put("suggest_format", this.mSuggestFormat).put("suggest_protocol", this.mSuggestProtocol);
        int i2 = this.mNoSyncPlayingCount;
        if (i2 > 0) {
            jSONObjectCreateCommonLog.put("av_out_sync_count", i2).put("av_out_sync_duration", this.mNoSyncPlayingTimeDuration).put("av_out_sync_info", this.mNoSyncPlayingInfoStr);
        }
        this.mNoSyncPlayingCount = 0;
        this.mNoSyncPlayingTimeDuration = 0L;
        this.mNoSyncPlayingInfoStr = "";
        this.mRetryCount = 0;
        this.mPlayingStallCount = 0;
        this.mPlayingStallTime = 0;
        this.mPlayingAudioRenderStallCount = 0;
        this.mPlayingAudioRenderStallTime = 0;
        this.mPlayingVideoRenderStallCount = 0;
        this.mPlayingVideoRenderStallTime = 0;
        this.mSpeedSwitchCount = 0;
        this.mSpeedSwitchInfo = "none";
        this.mSilenceDetectedCount = this.mEnableCheckSilenceInterval ? 0 : -1;
        return jSONObjectCreateCommonLog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNetWorkChanged() {
        NetworkInfo networkInfo = NetUtils.getNetworkInfo(this.mContext);
        int type = (networkInfo == null || !networkInfo.isAvailable()) ? -1 : networkInfo.getType();
        if (type == -1) {
            return false;
        }
        if (type == this.mCurNetType) {
            return true;
        }
        this.mCurNetType = type;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ntp() {
        com.byazt.f.c cVar = this.mNTPClient;
        if (cVar == null) {
            return;
        }
        uj ujVarC = null;
        try {
            cVar.c();
            InetAddress inetAddress = this.mHostAddr;
            if (inetAddress != null) {
                ujVarC = this.mNTPClient.c(inetAddress);
            }
        } catch (SocketException e) {
            m.c(e);
            return;
        } catch (IOException e2) {
            m.c(e2);
        }
        if (ujVarC == null) {
            return;
        }
        long jTt = ujVarC.tt().t().tt();
        this.mTimeDiff = ((ujVarC.tt().u().tt() - jTt) + (ujVarC.tt().sl().tt() - System.currentTimeMillis())) / 2;
    }

    private void onLink(boolean z) {
        if (this.mEnableOpenMDL == 1) {
            MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(z ? 8013 : 8014, this.mSessionId, -1);
        }
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "link").put(AliyunLogCommon.LogLevel.INFO, z ? "start" : "end");
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j = this.mLogTotalCount;
                if (j > 0) {
                    this.mLogTotalCount = j + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    private void onStreamAbnormalFrame(int i, int i2, int i3) {
        JSONObject jSONObjectCreateCommonLog;
        if (this.mLiveEngine == null || (jSONObjectCreateCommonLog = createCommonLog()) == null) {
            return;
        }
        try {
            jSONObjectCreateCommonLog.put("event_key", "stream_abnormal").put("stream_type", "video").put("type", i).put("sent_frames", i2).put("received_frames", i3);
            this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
            long j = this.mLogTotalCount;
            if (j > 0) {
                this.mLogTotalCount = j + 1;
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    private void onStreamAbnormalSEI(int i, int i2, int i3) {
        JSONObject jSONObjectCreateCommonLog;
        if (this.mLiveEngine == null || (jSONObjectCreateCommonLog = createCommonLog()) == null) {
            return;
        }
        try {
            jSONObjectCreateCommonLog.put("event_key", "stream_abnormal").put("stream_type", "video").put("type", i).put("cur_index", i2).put("last_index", i3);
            this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
            long j = this.mLogTotalCount;
            if (j > 0) {
                this.mLogTotalCount = j + 1;
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    private void report(boolean z) {
        LogBundle logBundle;
        VideoLiveManager videoLiveManager = this.mLiveEngine;
        if (videoLiveManager == null || this.mLogUploader == null || (logBundle = this.mLogBundle) == null) {
            return;
        }
        try {
            long j = logBundle.downloadSize;
            long j2 = logBundle.playedSize;
            long j3 = logBundle.playTime;
            long j4 = logBundle.currentPosition;
            videoLiveManager.getLogInfo(logBundle, 1);
            this.mLogUploader.onMonitorLog(createPlayingLog(this.mLogBundle, j, j2, j3, j4, z), MONITOR_LOG_TYPE);
            long j5 = this.mLogTotalCount;
            if (j5 > 0) {
                this.mLogTotalCount = j5 + 1;
            }
        } catch (JSONException e) {
            m.c(e);
        }
        long j6 = this.mInterval;
        if (isRtcPlayAvailable()) {
            j6 = this.mRtcPlayingLogInterval;
        }
        if (this.mStarted) {
            this.mHandler.sendEmptyMessageDelayed(101, j6);
        }
    }

    private void reportQuicOpenResult(JSONObject jSONObject) throws JSONException {
        if (TextUtils.equals(this.mProtocol, LiveConfigKey.QUIC) || TextUtils.equals(this.mProtocol, LiveConfigKey.QUICU)) {
            jSONObject.put("quic_open_result", this.mLogBundle.quicOpenResult);
            MyLog.i(TAG, "quic_open_result = " + this.mLogBundle.quicOpenResult);
        }
    }

    private void reportUpdateSessionSeries() {
        updateSessionSeries();
        MyLog.i("zdh", "update session series");
        if (this.mStarted) {
            this.mHandler.sendEmptyMessageDelayed(102, 5000L);
        }
    }

    private void resetSessionInfo() {
        LogBundle logBundle;
        if (this.mEnableReportSessionStop == 0 || (logBundle = this.mSessionLogBundle) == null) {
            return;
        }
        this.mSessionHasFirstFrame = false;
        this.mSessionFirstStallStartTime = 0L;
        this.mSessionFirstStallEndTime = 0L;
        this.mSessionStallTotalCount = 0L;
        this.mSessionStallTotalTime = 0L;
        this.mSessionStartTime = 0L;
        this.mSessionVideoRenderStartTime = 0L;
        this.mSessionAudioRenderStartTime = 0L;
        this.mSessionVideoRenderStallTotalCount = 0L;
        this.mSessionVideoRenderStallTotalTime = 0L;
        this.mSessionAudioRenderStallTotalCount = 0L;
        this.mSessionAudioRenderStallTotalTime = 0L;
        this.mSessionRenderFailType = -1;
        this.mSessionErrorCode = 0;
        this.mSessionErrorMsg = "none";
        logBundle.reset();
    }

    private void updateRequestTimeFieldInRtcPlay(JSONObject jSONObject) {
        if (jSONObject.has("event_message")) {
            String strOptString = jSONObject.optString("event_message");
            String str = TAG;
            MyLog.i(str, "eventMessage:".concat(String.valueOf(strOptString)));
            if (TextUtils.isEmpty(strOptString) || !jSONObject.has("phase_timestamp")) {
                return;
            }
            if (TextUtils.equals("dns resolved", strOptString)) {
                if (jSONObject.has("request_ip")) {
                    String strOptString2 = jSONObject.optString("request_ip");
                    if (strOptString2.equals(this.mDnsIp)) {
                        this.mRtcUseSdkDns = 1;
                    } else {
                        this.mCdnIp = strOptString2;
                        this.mRtcUseSdkDns = 0;
                    }
                }
                this.mRtcDnsTimeStamp = Long.parseLong(jSONObject.optString("phase_timestamp"));
                MyLog.i(str, "mRtcDnsTimeStamp:" + this.mRtcDnsTimeStamp);
                return;
            }
            if (TextUtils.equals("tcp connected", strOptString) || TextUtils.equals("send request", strOptString)) {
                this.mRtcTcpConnectTimeStamp = Long.parseLong(jSONObject.optString("phase_timestamp"));
                MyLog.i(str, "mRtcTcpConnectTimeStamp:" + this.mRtcTcpConnectTimeStamp);
                return;
            }
            if (TextUtils.equals("tls handshaked", strOptString)) {
                this.mRtcTlsHandshakedTimeStamp = Long.parseLong(jSONObject.optString("phase_timestamp"));
                MyLog.i(str, "mRtcTlsHandshakedTimeStamp:" + this.mRtcTlsHandshakedTimeStamp);
                return;
            }
            if (TextUtils.equals("response received", strOptString) || TextUtils.equals("remote answer got", strOptString)) {
                this.mRtcTcpFirstPackageTimeStamp = Long.parseLong(jSONObject.optString("phase_timestamp"));
                MyLog.i(str, "mRtcTcpFirstPackageTimeStamp:" + this.mRtcTcpFirstPackageTimeStamp);
            }
        }
    }

    private void updateSessionSeries() {
        LogBundle logBundle;
        VideoLiveManager videoLiveManager = this.mLiveEngine;
        if (videoLiveManager == null || this.mLogUploader == null || (logBundle = this.mLogBundle) == null) {
            return;
        }
        videoLiveManager.getLogInfo(logBundle, 3);
        if (this.mRenderFpsTimeSeries == null) {
            this.mRenderFpsTimeSeries = new ArrayList<>();
            this.mAudioBufferTimeSeries = new ArrayList<>();
            this.mDownloadSpeedTimeSeries = new ArrayList<>();
        }
        this.mRenderFpsTimeSeries.add(Long.valueOf((long) this.mLogBundle.fps));
        this.mAudioBufferTimeSeries.add(Long.valueOf(this.mLogBundle.audioBufferTime));
        this.mDownloadSpeedTimeSeries.add(Long.valueOf(this.mLogBundle.downloadSpeed));
        if (this.mSeiHasBitrateAndFps) {
            if (this.mSeiFpsTimeSeries == null) {
                this.mSeiFpsTimeSeries = new ArrayList<>();
                this.mSeiBitrateTimeSeries = new ArrayList<>();
            }
            this.mSeiFpsTimeSeries.add(Integer.valueOf(this.mLogBundle.seiFps));
            this.mSeiBitrateTimeSeries.add(Integer.valueOf(this.mLogBundle.seiBitrate));
        }
    }

    public void calculateRenderFailType() {
        LogBundle logBundle = this.mLogBundle;
        long j = logBundle.audioRenderTimestamp;
        if (j > 0 && logBundle.videoRenderTimestamp > 0) {
            this.mRenderFailType = 0;
            return;
        }
        if (j > 0 && logBundle.videoRenderTimestamp <= 0) {
            this.mRenderFailType = 1;
        } else if (j > 0 || logBundle.videoRenderTimestamp <= 0) {
            this.mRenderFailType = 3;
        } else {
            this.mRenderFailType = 2;
        }
    }

    public void calculateSessionRenderFailType() {
        long j = this.mSessionAudioRenderStartTime;
        if (j > 0 && this.mSessionVideoRenderStartTime > 0) {
            this.mSessionRenderFailType = 0;
            return;
        }
        if (j > 0 && this.mSessionVideoRenderStartTime <= 0) {
            this.mSessionRenderFailType = 1;
        } else if (j > 0 || this.mSessionVideoRenderStartTime <= 0) {
            this.mSessionRenderFailType = 3;
        } else {
            this.mSessionRenderFailType = 2;
        }
    }

    public void close(String str) {
        if (this.mStarted) {
            this.mStarted = false;
            this.mHandler.removeCallbacksAndMessages(null);
            MyNTPTask myNTPTask = this.mNTPTask;
            if (myNTPTask != null) {
                myNTPTask.mHandler.removeCallbacksAndMessages(null);
            }
            this.mNTPRunning = false;
        }
        resetStreamCheckParams();
        onStop(str);
        reset();
    }

    public JSONObject createCommonLog() {
        this.mLiveEngine.getVideoCodecType();
        try {
            JSONObject jSONObjectPut = new JSONObject().put("report_version", "5").put("live_sdk_version", "1.4.6.31-lite").put("product_line", "live").put("client_timestamp", System.currentTimeMillis());
            String str = this.mPlayerVersion;
            String str2 = "-1";
            if (str == null) {
                str = "-1";
            }
            JSONObject jSONObjectPut2 = jSONObjectPut.put("player_sdk_version", str);
            String str3 = this.mProjectKey;
            if (str3 == null) {
                str3 = "-1";
            }
            JSONObject jSONObjectPut3 = jSONObjectPut2.put("project_key", str3);
            String str4 = this.mEnterMethod;
            if (str4 == null) {
                str4 = "none";
            }
            JSONObject jSONObjectPut4 = jSONObjectPut3.put("live_stream_enter_method", str4);
            String str5 = this.mEnterAction;
            if (str5 == null) {
                str5 = "none";
            }
            JSONObject jSONObjectPut5 = jSONObjectPut4.put("live_stream_enter_action", str5);
            String str6 = this.mCdnPlayURL;
            if (str6 != null) {
                str2 = str6;
            }
            JSONObject jSONObjectPut6 = jSONObjectPut5.put("cdn_play_url", str2);
            String str7 = this.mCdnIp;
            if (str7 == null) {
                str7 = "none";
            }
            JSONObject jSONObjectPut7 = jSONObjectPut6.put(AliyunLogKey.KEY_CDN_IP, str7).put("request_url", this.mRequestUrl).put("ip_from_player_core", this.mIpIsFromPlayerCore ? 1 : 0).put("is_preview", this.mIsPreview ? 1 : 0).put("push_client_sdk_version", this.mPushClientSDKVersion).put("push_client_platform", this.mPushClientPlatform).put("push_client_os_version", this.mPushClientOSVersion).put("push_client_model", this.mPushClientModel).put("push_client_start_time", this.mPushClientStartTime).put("push_client_is_hardware_encode", this.mPushClientHardwareEncode).put("push_client_min_bitrate", this.mPushClientMinBitrate).put("push_client_max_bitrate", this.mPushClientMaxBitrate).put("push_client_default_bitrate", this.mPushClientDefaultBitrate).put("push_client_push_protocol", this.mPushClientPushProtocal).put("push_client_qid", this.mPushClientQId).put("push_client_hit_node_optimize", this.mPushClientHitNodeOptimize).put("open_dns_optimizer", this.mOpenNodeOptimizer ? 1 : 0).put("hit_node_optimize", this.mHitNodeOptimizer ? 1 : 0).put("evaluator_symbol", this.mEvaluatorSymbol).put("remote_sorted", this.mIsRemoteSorted ? 1 : 0).put("common_tag", this.mCommonFlag).put("codec_type", this.mCodecType).put("codec_name", this.mCodecName).put("hardware_decode", this.mHardDecodeEnable ? 1 : 0).put("sharp", this.mEnableSharp ? 1 : 0).put("enable_hurry", this.mEnableHurry ? 1 : 0).put("hurry_time", this.mHurryTime).put("catch_speed", new DecimalFormat("0.00").format(this.mCatchSpeed)).put("slow_play_time", this.mSlowPlayTime).put("slow_speed", new DecimalFormat("0.00").format(this.mSlowSpeed)).put("first_screen", this.mHasFirstFrame ? 1 : 0).put("enable_httpDns", this.mEnableHttpDns ? 1 : 0).put("enable_ntp", this.mEnableNTP).put("enable_media_codec_async", this.mMediaCodecAsyncInit).put("default_codec_id", this.mDefaultCodecID).put("url_ability", this.mUrlAbility).put("max_cache_seconds", this.mMaxCacheSeconds).put("enable_fast_open", this.mEnableFastOpenStream).put("enable_mdl", this.mEnableOpenMDL).put("enable_p2p", this.mEnableP2P).put("p2p_loader_type", this.mP2PLoaderType).put("used_p2p", this.mUsedP2P);
            String str8 = this.mMDLVersion;
            if (str8 == null) {
                str8 = "none";
            }
            JSONObject jSONObjectPut8 = jSONObjectPut7.put("mdl_version", str8).put("enable_mdl_proto", this.mEnableMdlProto).put("enable_low_latency_flv", this.mEnableLowLatencyFLV);
            String str9 = this.mLogBundle.dnsIP;
            if (str9 == null) {
                str9 = "none";
            }
            JSONObject jSONObjectPut9 = jSONObjectPut8.put("dns_ip", str9).put("in_main_looper", this.mIsInMainLooper).put("start_play_buffer_threshold", this.mStartPlayBufferThres).put("fast_open_gop_cache", this.mFastOpenDuration).put("buffering_end_ignore_video", this.mCheckBufferingEndIgnoreVideo).put("start_direct_after_prepared", this.mStartDirectAfterPrepared).put("check_buffering_end_advance", this.mCheckBufferingEndAdvanceEnable).put("channel_id", this.mLogBundle.channelId);
            LogBundle logBundle = this.mSessionLogBundle;
            if (logBundle == null) {
                logBundle = this.mLogBundle;
            }
            JSONObject jSONObjectPut10 = jSONObjectPut9.put("sei_delay", logBundle.delay);
            LogBundle logBundle2 = this.mSessionLogBundle;
            if (logBundle2 == null) {
                logBundle2 = this.mLogBundle;
            }
            JSONObject jSONObjectPut11 = jSONObjectPut10.put("sei_source", logBundle2.seiSource).put("chip_board", this.mChipBoard).put("chip_hardware", this.mChipHardware).put("width", this.mWidth).put("height", this.mHeight).put("settings_info", this.mSettingsInfo).put("ttnet_nqe_info", this.mTTNetNQEInfo).put("play_format", this.mStreamFormat).put("play_protocol", this.mProtocol).put("url_set_method", this.mLiveEngine.getUrlSettingMethod()).put("enable_resolution_auto_degrade", this.mEnableResolutionAutoDegrade).put("has_abr_info", this.mHasAbrInfo).put("quic_load_succ", this.mQuicFlag).put("link_info", this.mLinkInfo).put("used_texturerender", this.mUseTextureRender ? 1 : 0).put("settings_res", this.mResolution).put("is_too_large_av_diff", this.mLogBundle.isTooLargeAVDiff).put("stall_retry_time_interval", this.mStallRetryTimeInterval).put("is_too_large_av_diff", this.mLogBundle.isTooLargeAVDiff).put("enable_rtc_play", this.mEnableRtcPlay).put("enable_mini_sdp", this.mEnableMiniSdp).put("rtc_play_fallback", this.mRtcPlayFallBack).put("fallback_type", this.mFallbackType).put("mute_audio", this.mMuteAudio).put("volume_setting", this.mVolumeSetting).put("player_volume_setting", this.mPlayerVolumeSetting).put("enable_liveio_play", this.mEnableLiveIOPlay).put("liveio_play", this.mLiveIOPlay).put("liveio_p2p", this.mLiveIOP2P);
            if (this.mEnableLiveIOPlay == 1) {
                jSONObjectPut11.put("liveio_error_msg", this.mLiveIOErrorMsg);
                jSONObjectPut11.put("liveio_version", this.mLiveIOVersion);
            }
            if (isRtcPlayAvailable()) {
                jSONObjectPut11.put("rtc_get_width", this.mLiveEngine.getVideoWidth());
                jSONObjectPut11.put("rtc_get_height", this.mLiveEngine.getVideoHeight());
            }
            if (this.mRtcSessionId.equals("none")) {
                jSONObjectPut11.put("live_stream_session_id", this.mSessionId);
            } else {
                jSONObjectPut11.put("live_stream_session_id", this.mRtcSessionId);
            }
            if (this.mResolution.equals("auto")) {
                jSONObjectPut11.put("auto_res", this.mAutoUsingResolution);
            }
            if (this.mLiveEngine.getEnableTexturerender() == 1) {
                jSONObjectPut11.put("texturerender_error", this.mTextureRenderError);
            }
            if (this.mLiveEngine.getEnableSR() == 1 && this.mLiveEngine.getEnableTexturerender() == 1) {
                if (this.mLiveEngine.isUsedSR()) {
                    jSONObjectPut11.put("sr_width", this.mWidth * 2).put("sr_height", this.mHeight * 2);
                    this.mSRSuccess = true;
                } else {
                    jSONObjectPut11.put("sr_width", this.mWidth).put("sr_height", this.mHeight);
                }
            }
            VideoLiveManager videoLiveManager = this.mLiveEngine;
            if (videoLiveManager.mEnableSharpen == 1 && videoLiveManager.getEnableTexturerender() == 1) {
                jSONObjectPut11.put("used_sharpen", this.mLiveEngine.isUsedSharpen() ? 1 : 0);
                if (!this.mHasUsedSharpen) {
                    this.mHasUsedSharpen = this.mLiveEngine.isUsedSharpen();
                }
            }
            if ((this.mEnableResolutionAutoDegrade || this.mHasAbrInfo) && jSONObjectPut11 != null) {
                jSONObjectPut11.put("abr_strategy", this.mAbrStrategy).put("defualt_res_bitrate", this.mDefaultResBitrate).put("stall_count_rad", this.mStallCountThresOfResolutionDegrade);
            }
            if (TextUtils.equals(this.mProtocol, LiveConfigKey.QUIC) || TextUtils.equals(this.mProtocol, LiveConfigKey.QUICU)) {
                jSONObjectPut11.put("quic_config_cached", this.mLogBundle.quicConfigCached).put("quic_CHLO_count", this.mLogBundle.quicCHLOCount);
            }
            if (this.mLiveEngine.mEnableRadioLiveDisableRender == 1) {
                jSONObjectPut11.put("disable_video_render", this.mDisableVideoRender);
            }
            int i = this.mTslTimeShift;
            if (i > 0) {
                jSONObjectPut11.put("tsl_timeshift", i);
            }
            Map<String, String> map = this.mRequestHeaders;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey().equals("Host")) {
                        jSONObjectPut11.put("headers_host", entry.getValue().replace(" ", ""));
                        break;
                    }
                }
            }
            int i2 = this.mFCDNTranscodeMethod;
            if (i2 != -1) {
                jSONObjectPut11.put("fcdn_res_type", i2);
            }
            return jSONObjectPut11;
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public void enableCheckSei() {
        this.mEnableCheckSei = true;
    }

    public void enableHardDecode(boolean z) {
        this.mHardDecodeEnable = z;
    }

    public void enableSharp() {
        this.mEnableSharp = true;
    }

    public void feedVideoDTS(long j) {
        if (this.mVideoDTSQueue == null) {
            this.mVideoDTSQueue = new LinkedBlockingQueue<>(600);
        }
        if (this.mVideoDTSQueue.remainingCapacity() == 0 && this.mVideoDTSQueue.size() > 0) {
            this.mVideoDTSQueue.poll();
        }
        this.mVideoDTSQueue.offer(Long.valueOf(j));
    }

    public void getABRStreamInfo() {
        LogBundle logBundle;
        VideoLiveManager videoLiveManager = this.mLiveEngine;
        if (videoLiveManager == null || (logBundle = this.mLogBundle) == null) {
            return;
        }
        videoLiveManager.getLogInfo(logBundle, 8);
    }

    public void getAVPHStreamInfo() {
        LogBundle logBundle;
        VideoLiveManager videoLiveManager = this.mLiveEngine;
        if (videoLiveManager == null || (logBundle = this.mLogBundle) == null) {
            return;
        }
        videoLiveManager.getLogInfo(logBundle, 9);
    }

    public long getInt64Value(int i, long j) {
        VideoLiveManager videoLiveManager;
        if (i != 0) {
            return i != 100 ? j : this.mLogBundle.delay;
        }
        int i2 = this.mPushClientMaxBitrate;
        return (i2 != -1 || (videoLiveManager = this.mLiveEngine) == null) ? i2 : videoLiveManager.getIntOption(i, j);
    }

    public JSONObject getLiveInfoItems() {
        Long lValueOf = 0L;
        ArrayList<Long> arrayList = this.mDownloadSpeedTimeSeries;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<Long> it = this.mDownloadSpeedTimeSeries.iterator();
            while (it.hasNext()) {
                lValueOf = Long.valueOf(lValueOf.longValue() + it.next().longValue());
            }
            lValueOf = Long.valueOf(lValueOf.longValue() / ((long) this.mDownloadSpeedTimeSeries.size()));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.mCdnPlayURL;
            if (str == null) {
                str = "-1";
            }
            JSONObject jSONObjectPut = jSONObject.put("cdn_play_url", str);
            String str2 = this.mCdnIp;
            if (str2 == null) {
                str2 = "none";
            }
            return jSONObjectPut.put(AliyunLogKey.KEY_CDN_IP, str2).put("pull_stream_bitrate", lValueOf);
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public long getPlayingDownloadSize() {
        return this.mLogBundle.downloadSize;
    }

    public int getRetryTotalCount() {
        return this.mRetryTotalCount;
    }

    public int getStallTotalCount() {
        return (int) this.mStallTotalCount;
    }

    public JSONObject getStaticLog() {
        String str;
        String str2;
        LogBundle logBundle = new LogBundle();
        this.mLiveEngine.getLogInfo(logBundle, 1);
        try {
            JSONObject jSONObjectPut = new JSONObject().put("playing_time:", System.currentTimeMillis() - this.mFirstFrameTimestamp).put("live_sdk_version:", "1.4.6.31-lite");
            String str3 = this.mPlayerVersion;
            String str4 = "-1";
            if (str3 == null) {
                str3 = "-1";
            }
            JSONObject jSONObjectPut2 = jSONObjectPut.put("player_sdk_version:", str3);
            String str5 = this.mCdnIp;
            if (str5 != null) {
                str4 = str5;
            }
            JSONObject jSONObjectPut3 = jSONObjectPut2.put("cdn_ip:", str4).put("push_client_sdk_version:", this.mPushClientSDKVersion).put("push_client_platform:", this.mPushClientPlatform).put("push_client_model:", this.mPushClientModel).put("push_client_os_version:", this.mPushClientOSVersion).put("push_client_is_hardware_encode:", this.mPushClientHardwareEncode).put("push_client_push_protocol:", this.mPushClientPushProtocal).put("push_client_qid:", this.mPushClientQId).put("push_client_bitrate:", this.mLogBundle.seiBitrate).put("push_client_fps:", this.mLogBundle.seiFps).put("Hit_Node_Optimizer:", this.mHitNodeOptimizer ? 1 : 0).put("Evaluator_Symbol:", this.mEvaluatorSymbol).put("Is_Remote_Sorted:", this.mIsRemoteSorted ? 1 : 0).put("Stall_Total_Count:", this.mStallTotalCount).put("Stall_Total_Time:", this.mStallTotalTime);
            long j = this.mStallReason;
            if (j == -1) {
                str = "no stall";
            } else {
                str = j == 0 ? "network stall" : "decode stall";
            }
            JSONObject jSONObjectPut4 = jSONObjectPut3.put("Stall_Reason:", str).put("audio_Render_Stall_Total_Count：", this.mAudioRenderStallTotalCount).put("audio_Render_Stall_Total_Time：", this.mAudioRenderStallTotalTime).put("video_Render_Stall_Total_Count：", this.mVideoRenderStallTotalCount).put("video_Render_Stall_Total_Time：", this.mVideoRenderStallTotalTime);
            LogBundle logBundle2 = this.mLogBundle;
            JSONObject jSONObjectPut5 = jSONObjectPut4.put("first_frame_time:", logBundle2.videoRenderTimestamp - logBundle2.startPlayTime).put("video_Buffer_Time:", logBundle.videoBufferTime).put("audio_Buffer_Time:", logBundle.audioBufferTime).put("delay:", this.mLogBundle.delay).put("render_fps:", logBundle.fps).put("sei_source:", this.mLogBundle.seiSource).put("download_Speed:", logBundle.downloadSpeed).put("Error_Code:", this.mErrorCode).put("HardDecode:", this.mHardDecodeEnable).put("Codec_Type:", this.mCodecType).put("Codec_Name:", this.mCodecName);
            if (this.mUsedP2P == 1) {
                str2 = "PCDN";
            } else {
                str2 = this.mEnableOpenMDL == 1 ? "Http-CDN" : "none";
            }
            return jSONObjectPut5.put("MDL_Vendor:", str2).put("audio_Buffer_Time_On_First_Frame:", this.mLogBundle.audioBufferTimeOnFirstFrame).put("waiting_Time_After_First_Frame:", this.mLogBundle.waitingTimeAfterFirstFrame).put("dns_ip:", this.mLogBundle.dnsIP).put("url:", this.mCdnPlayURL).put("width:", this.mWidth).put("height:", this.mHeight).put("resolution:", logBundle.resolution).put("play_format:", this.mStreamFormat).put("play_protocol:", this.mProtocol).put("settings_res:", this.mResolution).put("enable_resolution_auto_degrade:", this.mEnableResolutionAutoDegrade);
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (101 == i) {
            report(false);
        }
        if (102 != i) {
            return true;
        }
        reportUpdateSessionSeries();
        return true;
    }

    public boolean isInErrorRecovering() {
        return this.mIsInErrorRecovering;
    }

    public boolean isPreview() {
        return this.mIsPreview;
    }

    public boolean isRtcPlayAvailable() {
        return this.mEnableRtcPlay == 1 && this.mRtcPlayFallBack == 0;
    }

    public boolean isStalling() {
        return this.mIsStalling;
    }

    public void onAbrSwitch(long j, String str, boolean z) {
        if (this.mLiveEngine == null || this.mLogUploader == null) {
            return;
        }
        try {
            JSONObject jSONObjectCreateCommonLog = createCommonLog();
            jSONObjectCreateCommonLog.put("event_key", "abr_switch").put("auto_switch", z ? 1 : 0).put("target_resoultion", str).put("predict_bitrate", j).put("abr_switch_info", this.mAbrSwitchInfo).put("cur_download_speed", this.mCurDownloadSpeed).put("cur_audio_buffer_time", this.mCurAudioBufferTime).put("cur_video_buffer_time", this.mCurVideoBufferTime).put("stall_count", this.mStallTotalCount).put("switch_cost", this.mAbrSwitchCost).put("use_expect_bitrate", this.mUseExpectBitrate);
            this.mUseExpectBitrate = 0;
            this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
            long j2 = this.mLogTotalCount;
            if (j2 > 0) {
                this.mLogTotalCount = j2 + 1;
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public void onAudioDTSRollback(long j, long j2) {
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "timestamp_rollback").put("packet_type", "audio").put("timestamp_type", "dts").put("latest_ts", j2).put("previous_ts", j);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j3 = this.mLogTotalCount;
                if (j3 > 0) {
                    this.mLogTotalCount = j3 + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onAudioRenderStart(long j) {
        this.mLogBundle.audioRenderTimestamp = j;
        if (this.mEnableReportSessionStop == 1) {
            this.mSessionAudioRenderStartTime = j;
        }
    }

    public void onCallNotInMainThread(String str) {
        JSONObject jSONObjectCreateCommonLog;
        if (this.mLiveEngine == null || this.mLogUploader == null || (jSONObjectCreateCommonLog = createCommonLog()) == null) {
            return;
        }
        try {
            jSONObjectCreateCommonLog.put("event_key", "call_not_in_main_thread").put("api_name", str);
            this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
            long j = this.mLogTotalCount;
            if (j > 0) {
                this.mLogTotalCount = j + 1;
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public void onCallPrepare() {
        if (this.mHasFirstFrame) {
            return;
        }
        this.mLogBundle.callPrepareTime = System.currentTimeMillis();
        LogBundle logBundle = this.mSessionLogBundle;
        if (logBundle != null) {
            logBundle.callPrepareTime = System.currentTimeMillis();
        }
    }

    public void onDecoderStall(long j, int i, boolean z) {
        if (j > System.currentTimeMillis() - this.mLogBundle.startPlayTime || j <= i) {
            MyLog.i(TAG, "abnormal decode stall time".concat(String.valueOf(j)));
            return;
        }
        if (z) {
            this.mVideoDecodeStallTotalCount++;
            this.mVideoDecodeStallTotalTime += j;
        } else {
            this.mAudioDecodeStallTotalCount++;
            this.mAudioDecodeStallTotalTime += j;
        }
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "decode_stall").put("type", z ? "video" : "audio").put("decode_stall_time", j);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j2 = this.mLogTotalCount;
                if (j2 > 0) {
                    this.mLogTotalCount = j2 + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onDemuxerStall(long j, int i, boolean z) {
        if (j > System.currentTimeMillis() - this.mLogBundle.startPlayTime || j <= i) {
            MyLog.i(TAG, "abnormal demux stall time".concat(String.valueOf(j)));
            return;
        }
        if (z) {
            this.mVideoDemuxStallTotalCount++;
            this.mVideoDemuxStallTotalTime += j;
        } else {
            this.mAudioDemuxStallTotalCount++;
            this.mAudioDemuxStallTotalTime += j;
        }
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "demux_stall").put("type", z ? "video" : "audio").put("demux_stall_time", j);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j2 = this.mLogTotalCount;
                if (j2 > 0) {
                    this.mLogTotalCount = j2 + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onError(int i, String str) {
        if (this.mErrorTimeSeries == null) {
            this.mErrorTimeSeries = new JSONObject();
        }
        try {
            this.mErrorTimeSeries.put(Long.toString(System.currentTimeMillis() - this.mLogBundle.startPlayTime), i);
        } catch (JSONException e) {
            this.mErrorTimeSeries = null;
            m.c(e);
        }
        this.mLiveEngine.getLogInfo(this.mLogBundle, 2);
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "play_error").put("code", i).put(AliyunLogCommon.LogLevel.INFO, str);
                reportQuicOpenResult(jSONObjectCreateCommonLog);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j = this.mLogTotalCount;
                if (j > 0) {
                    this.mLogTotalCount = j + 1;
                }
                this.mErrorCode = i;
            } catch (JSONException e2) {
                m.c(e2);
            }
        }
    }

    public void onErrorRecovered() {
        this.mIsInErrorRecovering = false;
        m.c(TAG, "recover from error time ".concat(String.valueOf(System.currentTimeMillis() - this.mErrorStartTime)));
        if (this.mErrorStartTime != 0) {
            this.mErrorRecoverCount++;
            this.mErrorRecoverTime += System.currentTimeMillis() - this.mErrorStartTime;
        }
    }

    public void onFirstFrame(long j, long j2) {
        LogBundle logBundle;
        this.mHasFirstFrame = true;
        this.mFirstFrameRetryCount = this.mRetryTotalCount;
        this.mFirstFramePrepareTime = this.mLastPrepareTime;
        this.mFirstFrameTimestamp = System.currentTimeMillis();
        if (this.mLiveEngine == null || this.mLogUploader == null || (logBundle = this.mLogBundle) == null) {
            return;
        }
        try {
            logBundle.playTime = System.currentTimeMillis();
            this.mLiveEngine.getLogInfo(this.mLogBundle, 0);
            JSONObject jSONObjectCreateFirstFrameLog = createFirstFrameLog(this.mLogBundle, j, this.mIsHitCache, j2);
            this.mFirstFrameView = this.mFirstFrameTimestamp - this.mLogBundle.startPlayTime;
            String str = this.mStreamFormat;
            if (str != null && (str.equals(LiveConfigKey.CMAF) || this.mStreamFormat.equals(LiveConfigKey.AVPH))) {
                jSONObjectCreateFirstFrameLog.put("video_dns_analysis_end", this.mLogBundle.videoDNSTimestamp).put("audio_dns_analysis_end", this.mLogBundle.audioDNSTimestamp).put("video_tcp_connect_time", this.mLogBundle.videoTcpConnectTimestamp).put("audio_tcp_connect_time", this.mLogBundle.audioTcpConnectTimestamp).put("video_tcp_first_packet_time", this.mLogBundle.videoTcpFirstPacketTimestamp).put("audio_tcp_first_packet_time", this.mLogBundle.audioTcpFirstPacketTimestamp).put("video_http_req_finish_time", this.mLogBundle.videoHttpReqFinishTimestamp).put("audio_http_req_finish_time", this.mLogBundle.audioHttpReqFinishTimestamp).put("video_http_res_finish_time", this.mLogBundle.videoHttpResFinishTimestamp).put("audio_http_res_finish_time", this.mLogBundle.audioHttpResFinishTimestamp);
                if (this.mStreamFormat.equals(LiveConfigKey.CMAF)) {
                    jSONObjectCreateFirstFrameLog.put("cmaf_mpd_dns_analysis_end", this.mLogBundle.cmafMpdDNSTimestamp).put("cmaf_mpd_tcp_connect_time", this.mLogBundle.cmafMpdTcpConntectTimestamp).put("cmaf_mpd_tcp_first_package_end", this.mLogBundle.cmafMdpTcpFirstPacketTimestamp).put("cmaf_mpd_http_req_finish_time", this.mLogBundle.cmafMdpHttpReqFinishTimestamp).put("cmaf_mpd_http_res_finish_time", this.mLogBundle.cmafMdpHttpResFinishTimestamp).put("cmaf_audio_firstseg_connect_time", this.mLogBundle.cmafAudioFirstSegConntectTimestamp).put("cmaf_video_firstseg_connect_time", this.mLogBundle.cmafVideoFirstSegConntectTimestamp).put("cmaf_mpd_connect_time", this.mLogBundle.cmafMpdConntectTimestamp);
                }
                reportQuicOpenResult(jSONObjectCreateFirstFrameLog);
            }
            this.mLogUploader.onMonitorLog(jSONObjectCreateFirstFrameLog, MONITOR_LOG_TYPE);
            long j3 = this.mLogTotalCount;
            if (j3 > 0) {
                this.mLogTotalCount = j3 + 1;
            }
            this.mSpeedSwitchInfo = "1.0:" + this.mFirstFrameTimestamp;
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public void onFirstFrameFail(int i) {
        VideoLiveManager videoLiveManager;
        if (this.mHasFirstFrame || (videoLiveManager = this.mLiveEngine) == null || this.mLogUploader == null) {
            return;
        }
        videoLiveManager.getLogInfo(this.mLogBundle, 2);
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "first_frame_failed").put(CropKey.RESULT_KEY_START_TIME, System.currentTimeMillis()).put(MediationConstant.KEY_REASON, i);
                reportQuicOpenResult(jSONObjectCreateCommonLog);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j = this.mLogTotalCount;
                if (j > 0) {
                    this.mLogTotalCount = j + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onIllegalAPICall(String str) {
        VideoLiveManager videoLiveManager = this.mLiveEngine;
        if (videoLiveManager == null || this.mLogUploader == null) {
            return;
        }
        videoLiveManager.getLogInfo(this.mLogBundle, 2);
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "illegal_call").put("api_name", str);
                reportQuicOpenResult(jSONObjectCreateCommonLog);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j = this.mLogTotalCount;
                if (j > 0) {
                    this.mLogTotalCount = j + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onLoaderError(int i, String str) {
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "p2p_error").put("error_msg", str).put("code", i);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j = this.mLogTotalCount;
                if (j > 0) {
                    this.mLogTotalCount = j + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onLoaderSwitch(int i, String str) {
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                if (str.equals("cdn_to_p2p")) {
                    this.mUsedP2P = 1;
                }
                jSONObjectCreateCommonLog.put("event_key", "p2p_switch").put("switch_info", str).put("p2p_vendor", "none").put(MediationConstant.KEY_REASON, i);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j = this.mLogTotalCount;
                if (j > 0) {
                    this.mLogTotalCount = j + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onPlay(String str, String str2) {
        if (this.mSessionLogBundle != null) {
            this.mSessionStartTime = System.currentTimeMillis();
        }
        this.mLogBundle.startPlayTime = System.currentTimeMillis();
        this.mLogBundle.dnsIP = str2;
        this.mCdnPlayURL = str;
        this.mCurrentPlayURL = str;
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        this.mLogTotalCount = 0L;
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "start_play").put("rule_ids", this.mRuleIds).put("set_surface_cost", this.mSetSurfaceCost).put("start_play_time", this.mLogBundle.startPlayTime).put("stream_data", this.mStreamData).put("suggest_format", this.mSuggestFormat).put("play_format", this.mStreamFormat).put("suggest_protocol", this.mSuggestProtocol).put("origin_url", this.mOriginUrl).put("log_total_count_when_playing", this.mLogTotalCount);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                this.mLogTotalCount++;
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    public void onPrepare(int i) {
        boolean z;
        if (this.mLiveEngine == null) {
            return;
        }
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        this.mLiveEngine.getLogInfo(this.mLogBundle, 7);
        String str = "none";
        int i2 = 1;
        if (this.mEnableReportSessionStop == 1) {
            this.mSessionErrorCode = i;
            this.mSessionErrorMsg = i != 0 ? this.mLiveEngine.getPlayerErrorInfo() : "none";
        }
        if (jSONObjectCreateCommonLog != null) {
            try {
                long j = this.mFirstAudioPacketDTS;
                if (j > 0) {
                    long j2 = this.mPreviousAudioPacketDTS;
                    if (j2 <= 0 || j >= j2) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    z = false;
                }
                JSONObject jSONObjectPut = jSONObjectCreateCommonLog.put("event_key", "prepare_result").put("error_msg", i != 0 ? this.mLiveEngine.getPlayerErrorInfo() : "none").put("result", i);
                String str2 = this.mSdkParams;
                if (str2 != null) {
                    str = str2;
                }
                JSONObject jSONObjectPut2 = jSONObjectPut.put("sdk_params", str).put("first_audio_packet_dts_rollback", z ? 1 : 0).put("first_audio_packet_dts", this.mFirstAudioPacketDTS).put("previous_audio_packet_dts", this.mPreviousAudioPacketDTS).put("stream_type", this.mLogBundle.mStreamType).put("suggest_format", this.mSuggestFormat).put("suggest_protocol", this.mSuggestProtocol);
                if (!this.mLiveEngine.getSRState() && !this.mLiveEngine.getSharpenState()) {
                    i2 = 0;
                }
                jSONObjectPut2.put("nnsr_enabled", i2);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j3 = this.mLogTotalCount;
                if (j3 > 0) {
                    this.mLogTotalCount = j3 + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onPrepareEnd() {
        LogBundle logBundle = this.mSessionLogBundle;
        if (logBundle != null) {
            logBundle.prepareEndTimestamp = System.currentTimeMillis();
        }
        if (this.mHasFirstFrame) {
            return;
        }
        this.mLogBundle.prepareEndTimestamp = System.currentTimeMillis();
    }

    public void onPtsBack(long j, boolean z) {
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "pts_back").put("type", z ? "video" : "audio").put("pts_back_diff", j);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onRecvRtcEventNotify(String str) {
        if (this.mLiveEngine == null || this.mLogUploader == null || str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            MyLog.i(TAG, "recv event notify: ".concat(String.valueOf(jSONObject)));
            updateRequestTimeFieldInRtcPlay(jSONObject);
        } catch (Exception e) {
            MyLog.e(TAG, "recv event notify error occurs error:" + e.toString());
        }
    }

    public void onRecvedRtcTraceInfo(String str) {
        if (this.mLiveEngine == null || this.mLogUploader == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                jSONObject.put("product_line", "rts");
                jSONObject.put("rtc_trace_info", str);
                if (!str.isEmpty() && str.contains("rts_play_stop")) {
                    this.mRtcPlayStopStatInfo = new JSONObject(str).optString("event_message");
                }
            }
            this.mLogUploader.onMonitorLog(jSONObject, RTC_MONITOR_LOG_TYPE);
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public void onRecvedSPSPPS(String str) {
        if (this.mLiveEngine == null || this.mLogUploader == null) {
            return;
        }
        try {
            JSONObject jSONObjectCreateCommonLog = createCommonLog();
            jSONObjectCreateCommonLog.put("event_key", "recved_spspps").put("spspps", str);
            this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
            long j = this.mLogTotalCount;
            if (j > 0) {
                this.mLogTotalCount = j + 1;
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public void onRenderStall(long j, int i, boolean z, boolean z2) {
        if (j > System.currentTimeMillis() - this.mLogBundle.startPlayTime || j <= i) {
            MyLog.i(TAG, "abnormal render stall time".concat(String.valueOf(j)));
            return;
        }
        if (z) {
            MyLog.i(TAG, "video render stall time ".concat(String.valueOf(j)));
            this.mPlayingVideoRenderStallCount++;
            this.mVideoRenderStallTotalCount++;
            this.mPlayingVideoRenderStallTime = (int) (((long) this.mPlayingVideoRenderStallTime) + j);
            this.mVideoRenderStallTotalTime += j;
            if (this.mEnableReportSessionStop == 1) {
                this.mSessionVideoRenderStallTotalCount++;
                this.mSessionVideoRenderStallTotalTime += j;
            }
        } else {
            MyLog.i(TAG, "audio render stall time ".concat(String.valueOf(j)));
            this.mPlayingAudioRenderStallCount++;
            this.mAudioRenderStallTotalCount++;
            this.mPlayingAudioRenderStallTime = (int) (((long) this.mPlayingAudioRenderStallTime) + j);
            this.mAudioRenderStallTotalTime += j;
            if (this.mEnableReportSessionStop == 1) {
                this.mSessionAudioRenderStallTotalCount++;
                this.mSessionAudioRenderStallTotalTime += j;
            }
        }
        if (z2) {
            JSONObject jSONObjectCreateCommonLog = createCommonLog();
            this.mLiveEngine.getLogInfo(this.mLogBundle, 4);
            if (jSONObjectCreateCommonLog != null) {
                try {
                    jSONObjectCreateCommonLog.put("event_key", "render_stall").put("type", z ? "video" : "audio").put("render_stall_time", j).put("video_buffer_time", this.mLogBundle.videoBufferTime).put("audio_buffer_time", this.mLogBundle.audioBufferTime);
                    this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                    long j2 = this.mLogTotalCount;
                    if (j2 > 0) {
                        this.mLogTotalCount = j2 + 1;
                    }
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        }
    }

    public void onRetry(int i) {
        this.mRetryCount++;
        this.mRetryTotalCount++;
        this.mLiveEngine.getLogInfo(this.mLogBundle, 2);
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        calculateRenderFailType();
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "retry").put(MediationConstant.KEY_REASON, this.mErrorCode).put("code", i).put("render_fail_type", this.mRenderFailType);
                reportQuicOpenResult(jSONObjectCreateCommonLog);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j = this.mLogTotalCount;
                if (j > 0) {
                    this.mLogTotalCount = j + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onRtcDecoderStall(long j, boolean z) {
        if (j > System.currentTimeMillis() - this.mLogBundle.startPlayTime) {
            MyLog.i(TAG, "abnormal rtc decode stall time".concat(String.valueOf(j)));
            return;
        }
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "rtc_decode_stall").put("type", z ? "video" : "audio").put("decode_stall_time", j);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j2 = this.mLogTotalCount;
                if (j2 > 0) {
                    this.mLogTotalCount = j2 + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onSDKDNSComplete(boolean z, boolean z2) {
        this.mLogBundle.SDKDNSTimeStamp = System.currentTimeMillis();
        LogBundle logBundle = this.mSessionLogBundle;
        if (logBundle != null) {
            logBundle.SDKDNSTimeStamp = System.currentTimeMillis();
        }
        this.mHitNodeOptimizer = z2;
        this.mIsHitCache = z;
    }

    public void onSDKDNSError(LiveError liveError) {
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                JSONObject jSONObjectPut = jSONObjectCreateCommonLog.put("event_key", "prepare_result").put("error_msg", liveError.getInfoJSON()).put("result", liveError.code);
                String str = this.mSdkParams;
                if (str == null) {
                    str = "none";
                }
                jSONObjectPut.put("sdk_params", str).put("stream_type", this.mLogBundle.mStreamType).put("suggest_format", this.mSuggestFormat).put("suggest_protocol", this.mSuggestProtocol).put("nnsr_enabled", (this.mLiveEngine.getSRState() || this.mLiveEngine.getSharpenState()) ? 1 : 0);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j = this.mLogTotalCount;
                if (j > 0) {
                    this.mLogTotalCount = j + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onSessionStop() {
        LogBundle logBundle;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2;
        long j;
        long j2;
        if (this.mEnableReportSessionStop == 0 || (logBundle = this.mSessionLogBundle) == null) {
            return;
        }
        this.mLiveEngine.getSessionlogInfo(logBundle);
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (this.mSessionHasFirstFrame) {
            jCurrentTimeMillis2 = System.currentTimeMillis() - this.mSessionVideoRenderStartTime;
            jCurrentTimeMillis = 0;
        } else {
            jCurrentTimeMillis = System.currentTimeMillis() - this.mSessionStartTime;
            jCurrentTimeMillis2 = 0;
        }
        this.mSessionNum++;
        long j3 = this.mSessionFirstStallStartTime;
        if (j3 > 0) {
            j = j3 - this.mSessionVideoRenderStartTime;
            j2 = this.mSessionFirstStallEndTime - j3;
        } else {
            j = 0;
            j2 = 0;
        }
        if (isStalling()) {
            this.mSessionStallTotalCount++;
            this.mSessionStallTotalTime += System.currentTimeMillis() - this.mStallStartTime;
        }
        calculateSessionRenderFailType();
        long j4 = this.mSessionLogBundle.downloadSize;
        if (jSONObjectCreateCommonLog != null) {
            try {
                JSONObject jSONObjectPut = jSONObjectCreateCommonLog.put("event_key", "session_stop").put("index", this.mSessionNum).put("stop_time", System.currentTimeMillis()).put("play_time", jCurrentTimeMillis2).put("is_stream_received", this.mSessionHasFirstFrame ? 1 : 0).put("render_fail_type", this.mSessionRenderFailType).put("code", this.mSessionErrorCode).put("stall_count", this.mSessionStallTotalCount).put("stall_time", this.mSessionStallTotalTime).put("audio_render_stall_count", this.mSessionAudioRenderStallTotalCount).put("audio_render_stall_time", this.mSessionAudioRenderStallTotalTime).put("video_render_stall_count", this.mSessionVideoRenderStallTotalCount).put("video_render_stall_time", this.mSessionVideoRenderStallTotalTime).put("start", this.mSessionStartTime).put("sdk_dns_analysis_end", this.mSessionLogBundle.SDKDNSTimeStamp).put("player_dns_analysis_end", this.mLogBundle.playerDNSTimestamp).put("http_req_finish_time", this.mSessionLogBundle.httpReqFinishTimestamp).put("http_res_finish_time", this.mSessionLogBundle.httpResFinishTimestamp).put("tcp_first_package_end", this.mLogBundle.tcpFirstPacketTimestamp).put("first_video_package_end", this.mSessionLogBundle.videoPacketTimestamp).put("first_audio_package_end", this.mSessionLogBundle.audioPacketTimestamp).put("first_video_frame_decode_end", this.mSessionLogBundle.videoDecodeTimestamp).put("first_audio_frame_decode_end", this.mSessionLogBundle.audioDecodeTimestamp).put("video_device_open_start", this.mSessionLogBundle.videoDeviceOpenTime).put("video_device_open_end", this.mSessionLogBundle.videoDeviceOpenedTime).put("audio_device_open_start", this.mSessionLogBundle.audioDeviceOpenTime).put("audio_device_open_end", this.mSessionLogBundle.audioDeviceOpenedTime).put("video_device_wait_start", this.mSessionLogBundle.videoDeviceWaitStartTime).put("video_device_wait_end", this.mSessionLogBundle.videoDeviceWaitEndTime).put("find_stream_info_start", this.mSessionLogBundle.streamInfoFindTime).put("find_stream_info_end", this.mSessionLogBundle.streamInfoFoundTime).put("video_param_send_outlet_time", this.mSessionLogBundle.videoParamSendOutletTime).put("first_video_frame_send_outlet_time", this.mSessionLogBundle.firstVideoFrameSendOutletTime).put("first_frame_render_end", this.mSessionVideoRenderStartTime).put("first_audio_frame_end", this.mSessionAudioRenderStartTime).put("prepare_end", this.mSessionLogBundle.prepareEndTimestamp).put("prepare_block_end", this.mSessionLogBundle.callPrepareTime).put("video_first_pkt_pos", this.mSessionLogBundle.videoFirstPacketPos).put("video_first_pkt_pts", this.mSessionLogBundle.videoFirstPacketPts).put("audio_first_pkt_pos", this.mSessionLogBundle.audioFirstPacketPos).put("audio_first_pkt_pts", this.mSessionLogBundle.audioFirstPacketPts).put("video_render_type", this.mSessionLogBundle.renderType).put("download_speed", this.mSessionLogBundle.downloadSpeedOnFirstFrame).put("video_buffer_time", this.mSessionLogBundle.videoBufferTimeOnFirstFrame).put("audio_buffer_time", this.mSessionLogBundle.audioBufferTimeOnFirstFrame).put("wait_time", this.mSessionLogBundle.waitingTimeAfterFirstFrame > 0 ? this.mLogBundle.waitingTimeAfterFirstFrame : -this.mLogBundle.waitingTimeAfterFirstFrame).put("is_waiting", this.mSessionLogBundle.waitingTimeAfterFirstFrame >= 0 ? 0 : 1).put("first_stall_time", j).put("first_stall_duration", j2).put("play_time_on_no_frame", jCurrentTimeMillis);
                String str = this.mSdkParams;
                if (str == null) {
                    str = "none";
                }
                jSONObjectPut.put("sdk_params", str).put("total_download_size", j4).put("drop_audio_pts_diff", this.mSessionLogBundle.dropAudioPts).put("drop_audio_cost", this.mSessionLogBundle.dropAudioCostTime).put("sr_used", this.mSRSuccess ? 1 : 0).put("sharpen_used", this.mHasUsedSharpen ? 1 : 0).put("network_timeout", this.mNetworkTimeoutMs).put("suggest_format", this.mSuggestFormat).put("suggest_protocol", this.mSuggestProtocol).put("error_msg", this.mSessionErrorMsg);
                if (this.mCdnPlayURL == null) {
                    jSONObjectCreateCommonLog.put("tcp_connect_end", this.mSessionLogBundle.tcpConnectTimestamp);
                } else {
                    jSONObjectCreateCommonLog.put("tcp_connect_end", this.mProtocol.equals(LiveConfigKey.KCP) ? this.mSessionLogBundle.playerDNSTimestamp : this.mSessionLogBundle.tcpConnectTimestamp);
                }
                this.mLogTotalCount++;
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
            } catch (JSONException e) {
                m.c(e);
            }
        }
        resetSessionInfo();
    }

    public void onStallEnd(int i) {
        if (this.mErrorCode == -100015) {
            this.mErrorCode = 0;
        }
        if (this.mIsStalling) {
            this.mIsStalling = false;
            JSONObject jSONObjectCreateCommonLog = createCommonLog();
            if (this.mStallTimeSeries == null) {
                this.mStallTimeSeries = new ArrayList<>();
            }
            this.mStallTimeSeries.add(Long.valueOf(-(System.currentTimeMillis() - this.mLogBundle.startPlayTime)));
            if (this.mFirstStallEndTime == 0) {
                this.mFirstStallEndTime = System.currentTimeMillis();
            }
            if (this.mEnableReportSessionStop == 1 && this.mSessionFirstStallEndTime == 0) {
                this.mSessionFirstStallEndTime = System.currentTimeMillis();
            }
            this.mLiveEngine.getLogInfo(this.mLogBundle, 6);
            if (jSONObjectCreateCommonLog == null || this.mStallStartTime == 0) {
                return;
            }
            try {
                if (this.mPlayingStallStartTime != 0) {
                    this.mPlayingStallCount++;
                    this.mPlayingStallTime = (int) (((long) this.mPlayingStallTime) + (System.currentTimeMillis() - this.mPlayingStallStartTime));
                }
                this.mStallTotalCount++;
                this.mStallTotalTime += System.currentTimeMillis() - this.mStallStartTime;
                if (this.mEnableReportSessionStop == 1) {
                    this.mSessionStallTotalCount++;
                    this.mSessionStallTotalTime += System.currentTimeMillis() - this.mStallStartTime;
                }
                jSONObjectCreateCommonLog.put("event_key", "stall").put("stall_start", this.mStallStartTime).put("stall_end", System.currentTimeMillis()).put("video_buffer_time_stall_start", this.mLogBundle.videoBufferTimeOnStallStart).put("audio_buffer_time_stall_start", this.mLogBundle.audioBufferTimeOnStallStart).put("video_buffer_time_stall_end", this.mLogBundle.videoBufferTimeOnStallEnd).put("audio_buffer_time_stall_end", this.mLogBundle.audioBufferTimeOnStallEnd).put("last_res", this.mLastResolution).put(MediationConstant.KEY_REASON, this.mStallReason).put("recover_reason", i);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j = this.mLogTotalCount;
                if (j > 0) {
                    this.mLogTotalCount = j + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onStallStart(int i, boolean z) {
        this.mErrorCode = LiveError.PLAYER_STALL;
        if (z) {
            this.mLiveEngine.getLogInfo(this.mLogBundle, 5);
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.mStallStartTime = jCurrentTimeMillis;
            if (this.mFirstStallStartTime == 0) {
                this.mFirstStallStartTime = jCurrentTimeMillis;
            }
            if (this.mEnableReportSessionStop == 1) {
                if (this.mSessionFirstStallStartTime == 0) {
                    this.mSessionFirstStallStartTime = jCurrentTimeMillis;
                }
                this.mSessionErrorCode = this.mErrorCode;
            }
            this.mPlayingStallStartTime = jCurrentTimeMillis;
            this.mStallReason = i;
            this.mIsStalling = true;
            if (this.mStallTimeSeries == null) {
                this.mStallTimeSeries = new ArrayList<>();
            }
            this.mStallTimeSeries.add(Long.valueOf(this.mStallStartTime - this.mLogBundle.startPlayTime));
        }
    }

    public void onStop(String str) {
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2;
        long j;
        long j2;
        int i;
        if (this.mHasFirstFrame) {
            report(true);
        } else {
            this.mLiveEngine.getLogInfo(this.mLogBundle, 2);
            this.mFirstFrameRetryCount = this.mRetryTotalCount;
            this.mFirstFramePrepareTime = this.mLastPrepareTime;
        }
        onSessionStop();
        resetSessionInfo();
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                if (this.mHasFirstFrame) {
                    jCurrentTimeMillis = System.currentTimeMillis() - this.mFirstFrameTimestamp;
                    jCurrentTimeMillis2 = 0;
                } else if (this.mErrorCode != 0 || this.mLogBundle.startPlayTime == 0) {
                    jCurrentTimeMillis = 0;
                    jCurrentTimeMillis2 = 0;
                } else {
                    jCurrentTimeMillis2 = System.currentTimeMillis() - this.mLogBundle.startPlayTime;
                    jCurrentTimeMillis = 0;
                }
                long j3 = this.mFirstStallStartTime;
                if (j3 > 0) {
                    j2 = j3 - this.mLogBundle.videoRenderTimestamp;
                    j = this.mFirstStallEndTime - j3;
                } else {
                    j = 0;
                    j2 = 0;
                }
                if (isStalling()) {
                    this.mStallTotalCount++;
                    this.mStallTotalTime += System.currentTimeMillis() - this.mStallStartTime;
                }
                if (isInErrorRecovering() && this.mErrorStartTime != 0) {
                    this.mErrorRecoverCount++;
                    this.mErrorRecoverTime += System.currentTimeMillis() - this.mErrorStartTime;
                }
                calculateRenderFailType();
                long j4 = this.mLastTotalDownloadSize + this.mLogBundle.downloadSize;
                JSONObject jSONObjectPut = jSONObjectCreateCommonLog.put("event_key", "play_stop").put("stop_time", System.currentTimeMillis()).put("play_time", jCurrentTimeMillis).put("is_stream_received", this.mHasFirstFrame ? 1 : 0).put("render_fail_type", this.mRenderFailType).put("code", this.mErrorCode).put("stall_count", this.mStallTotalCount).put("stall_time", this.mStallTotalTime).put("audio_render_stall_count", this.mAudioRenderStallTotalCount).put("audio_render_stall_time", this.mAudioRenderStallTotalTime).put("video_render_stall_count", this.mVideoRenderStallTotalCount).put("video_render_stall_time", this.mVideoRenderStallTotalTime).put("video_decode_stall_count", this.mVideoDecodeStallTotalCount).put("video_decode_stall_time", this.mVideoDecodeStallTotalTime).put("audio_decode_stall_count", this.mAudioDecodeStallTotalCount).put("audio_decode_stall_time", this.mAudioDecodeStallTotalTime).put("video_demux_stall_count", this.mVideoDemuxStallTotalCount).put("video_demux_stall_time", this.mVideoDemuxStallTotalTime).put("audio_demux_stall_count", this.mAudioDemuxStallTotalCount).put("audio_demux_stall_time", this.mAudioDemuxStallTotalTime).put("error_recover_count", this.mErrorRecoverCount).put("error_recover_time", this.mErrorRecoverTime).put("start", this.mLogBundle.startPlayTime).put("sdk_dns_analysis_end", this.mLogBundle.SDKDNSTimeStamp).put("http_req_finish_time", this.mLogBundle.httpReqFinishTimestamp).put("http_res_finish_time", this.mLogBundle.httpResFinishTimestamp).put("first_video_package_end", this.mLogBundle.videoPacketTimestamp).put("first_audio_package_end", this.mLogBundle.audioPacketTimestamp).put("first_video_frame_decode_end", this.mLogBundle.videoDecodeTimestamp).put("first_audio_frame_decode_end", this.mLogBundle.audioDecodeTimestamp).put("first_frame_render_end", this.mLogBundle.videoRenderTimestamp).put("first_audio_frame_end", this.mLogBundle.audioRenderTimestamp).put("video_device_open_start", this.mLogBundle.videoDeviceOpenTime).put("video_device_open_end", this.mLogBundle.videoDeviceOpenedTime).put("audio_device_open_start", this.mLogBundle.audioDeviceOpenTime).put("audio_device_open_end", this.mLogBundle.audioDeviceOpenedTime).put("video_device_wait_start", this.mLogBundle.videoDeviceWaitStartTime).put("video_device_wait_end", this.mLogBundle.videoDeviceWaitEndTime).put("find_stream_info_start", this.mLogBundle.streamInfoFindTime).put("find_stream_info_end", this.mLogBundle.streamInfoFoundTime).put("video_param_send_outlet_time", this.mLogBundle.videoParamSendOutletTime).put("first_video_frame_send_outlet_time", this.mLogBundle.firstVideoFrameSendOutletTime).put("video_first_pkt_pos", this.mLogBundle.videoFirstPacketPos).put("video_first_pkt_pts", this.mLogBundle.videoFirstPacketPts).put("audio_first_pkt_pos", this.mLogBundle.audioFirstPacketPos).put("audio_first_pkt_pts", this.mLogBundle.audioFirstPacketPts).put("set_surface_time", this.mSetSurfaceTime).put("set_surface_cost", this.mSetSurfaceCost).put("video_render_type", this.mLogBundle.renderType).put("prepare_block_end", this.mLogBundle.callPrepareTime).put("prepare_end", this.mLogBundle.prepareEndTimestamp).put("retry_count", this.mRetryTotalCount).put("download_speed", this.mLogBundle.downloadSpeedOnFirstFrame).put("video_buffer_time", this.mLogBundle.videoBufferTimeOnFirstFrame).put("audio_buffer_time", this.mLogBundle.audioBufferTimeOnFirstFrame);
                long j5 = this.mLogBundle.waitingTimeAfterFirstFrame;
                if (j5 <= 0) {
                    j5 = -j5;
                }
                JSONObject jSONObjectPut2 = jSONObjectPut.put("wait_time", j5).put("is_waiting", this.mLogBundle.waitingTimeAfterFirstFrame >= 0 ? 0 : 1).put("first_stall_time", j2).put("first_stall_duration", j).put("call_api_name", str).put("play_time_on_no_frame", jCurrentTimeMillis2).put("abr_switch_count", this.mAbrSwitchCount).put("abr_switch_count_info", this.mAbrSwitchCountInfo);
                String str2 = this.mSdkParams;
                if (str2 == null) {
                    str2 = "none";
                }
                jSONObjectPut2.put("sdk_params", str2).put("total_download_size", j4).put("drop_audio_pts_diff", this.mLogBundle.dropAudioPts).put("drop_audio_cost", this.mLogBundle.dropAudioCostTime).put("first_frame_retry_count", this.mFirstFrameRetryCount).put("first_frame_retry_duration", this.mFirstFramePrepareTime).put("abr_check_enhance", this.mEnableLiveAbrCheckEnhance).put("sr_used", this.mSRSuccess ? 1 : 0).put("sharpen_used", this.mHasUsedSharpen ? 1 : 0).put("network_timeout", this.mNetworkTimeoutMs).put("suggest_format", this.mSuggestFormat).put("suggest_protocol", this.mSuggestProtocol).put("session_num", this.mSessionNum).put("use_live_threadpool", this.mUseLiveThreadPool);
                JSONArray jSONArray = this.mLogBundle.mABRStreamInfo;
                if (jSONArray != null) {
                    jSONObjectCreateCommonLog.put("abr_stream_info", jSONArray);
                }
                int i2 = this.mAudioTimescaleEnable;
                if (i2 != -1) {
                    jSONObjectCreateCommonLog.put("audio_timescale_enable", i2);
                }
                JSONArray jSONArray2 = this.mLogBundle.avphStreamInfo;
                if (jSONArray2 != null) {
                    jSONObjectCreateCommonLog.put("avph_stream_info", jSONArray2);
                }
                if (this.mLiveEngine.getEnableTexturerender() == 1) {
                    jSONObjectCreateCommonLog.put("render_start_timestamp", this.mRenderStartNotifyTimeStamp);
                    jSONObjectCreateCommonLog.put("texturerender_renderstart_timestamp", this.mTextureRenderFirstFrameTime);
                }
                int i3 = this.mNoSyncCount;
                if (i3 > 0) {
                    jSONObjectCreateCommonLog.put("av_out_sync_count", i3).put("av_out_sync_duration", this.mNoSyncTimeDuration).put("av_out_sync_info", this.mNoSyncInfoStr);
                }
                reportQuicOpenResult(jSONObjectCreateCommonLog);
                if (isRtcPlayAvailable()) {
                    jSONObjectCreateCommonLog.put("player_dns_analysis_end", this.mRtcDnsTimeStamp);
                    jSONObjectCreateCommonLog.put("rtc_use_sdk_dns", this.mRtcUseSdkDns);
                    jSONObjectCreateCommonLog.put("tcp_connect_end", this.mRtcTcpConnectTimeStamp);
                    jSONObjectCreateCommonLog.put("rtc_tls_handshake_end", this.mRtcTlsHandshakedTimeStamp);
                    jSONObjectCreateCommonLog.put("tcp_first_package_end", this.mRtcTcpFirstPackageTimeStamp);
                    jSONObjectCreateCommonLog.put("rtc_inited_end", this.mLogBundle.rtcInitedTime);
                    jSONObjectCreateCommonLog.put("rtc_offer_send_end", this.mLogBundle.rtcOfferSendTime);
                    jSONObjectCreateCommonLog.put("rtc_answer_recv_end", this.mLogBundle.rtcAnswerRecvTime);
                    jSONObjectCreateCommonLog.put("rtc_start_end", this.mLogBundle.rtcStartTime);
                    jSONObjectCreateCommonLog.put("rtc_playstop_info", this.mRtcPlayStopStatInfo);
                } else {
                    jSONObjectCreateCommonLog.put("tcp_first_package_end", this.mLogBundle.tcpFirstPacketTimestamp);
                    jSONObjectCreateCommonLog.put("player_dns_analysis_end", this.mLogBundle.playerDNSTimestamp);
                    if (this.mCdnPlayURL == null) {
                        jSONObjectCreateCommonLog.put("tcp_connect_end", this.mLogBundle.tcpConnectTimestamp);
                    } else {
                        jSONObjectCreateCommonLog.put("tcp_connect_end", this.mProtocol.equals(LiveConfigKey.KCP) ? this.mLogBundle.playerDNSTimestamp : this.mLogBundle.tcpConnectTimestamp);
                    }
                }
                String str3 = this.mStreamFormat;
                if (str3 != null && (str3.equals(LiveConfigKey.CMAF) || this.mStreamFormat.equals(LiveConfigKey.AVPH))) {
                    jSONObjectCreateCommonLog.put("video_dns_analysis_end", this.mLogBundle.videoDNSTimestamp).put("audio_dns_analysis_end", this.mLogBundle.audioDNSTimestamp).put("video_tcp_connect_time", this.mLogBundle.videoTcpConnectTimestamp).put("audio_tcp_connect_time", this.mLogBundle.audioTcpConnectTimestamp).put("video_tcp_first_packet_time", this.mLogBundle.videoTcpFirstPacketTimestamp).put("audio_tcp_first_packet_time", this.mLogBundle.audioTcpFirstPacketTimestamp).put("video_http_req_finish_time", this.mLogBundle.videoHttpReqFinishTimestamp).put("audio_http_req_finish_time", this.mLogBundle.audioHttpReqFinishTimestamp).put("video_http_res_finish_time", this.mLogBundle.videoHttpResFinishTimestamp).put("audio_http_res_finish_time", this.mLogBundle.audioHttpResFinishTimestamp);
                    if (this.mStreamFormat.equals(LiveConfigKey.CMAF)) {
                        jSONObjectCreateCommonLog.put("cmaf_mpd_dns_analysis_end", this.mLogBundle.cmafMpdDNSTimestamp).put("cmaf_mpd_tcp_connect_time", this.mLogBundle.cmafMpdTcpConntectTimestamp).put("cmaf_mpd_tcp_first_package_end", this.mLogBundle.cmafMdpTcpFirstPacketTimestamp).put("cmaf_mpd_http_req_finish_time", this.mLogBundle.cmafMdpHttpReqFinishTimestamp).put("cmaf_mpd_http_res_finish_time", this.mLogBundle.cmafMdpHttpResFinishTimestamp).put("cmaf_audio_firstseg_connect_time", this.mLogBundle.cmafAudioFirstSegConntectTimestamp).put("cmaf_video_firstseg_connect_time", this.mLogBundle.cmafVideoFirstSegConntectTimestamp).put("cmaf_mpd_connect_time", this.mLogBundle.cmafMpdConntectTimestamp);
                    }
                }
                if (this.mEnableUploadSessionSeries) {
                    jSONObjectCreateCommonLog.put("session_time_series", _createSessionTimeSeries());
                }
                if (this.mEnableCheckSei) {
                    jSONObjectCreateCommonLog.put("expected_sei_count", this.mExpectedSeiCount);
                    jSONObjectCreateCommonLog.put("received_sei_count", this.mReceivedSeiCount);
                    jSONObjectCreateCommonLog.put("expected_unique_sei_count", this.mExpectedUniqueSeiCount);
                    jSONObjectCreateCommonLog.put("received_unique_sei_count", this.mReceivedUniqueSeiCount);
                }
                int i4 = this.mBitRateAbnormalType;
                if (i4 != 0) {
                    jSONObjectCreateCommonLog.put("bitrate_amnormal", i4);
                }
                int i5 = this.mCodecNotSame;
                if (i5 != 0) {
                    jSONObjectCreateCommonLog.put("abr_codec_not_same", i5);
                }
                if (this.mABRListMatch == 0) {
                    i = 1;
                    jSONObjectCreateCommonLog.put("abr_list_not_match", 1);
                } else {
                    i = 1;
                }
                if (TextUtils.equals(this.mProtocol, LiveConfigKey.QUIC) || TextUtils.equals(this.mProtocol, LiveConfigKey.QUICU)) {
                    jSONObjectCreateCommonLog.put("scfg", this.mQuicScfgConfig).put("mtu", this.mQuicMtu).put("pad_hello", this.mQuicPadHello).put("timer_version", this.mQuicTimerVersion);
                }
                boolean z = this.mIsCdnAbrSwitch;
                if (z) {
                    if (!z) {
                        i = 0;
                    }
                    jSONObjectCreateCommonLog.put("cdn_abr_switch_performed", i).put("cdn_abr_switch_code", this.mCdnAbrSwitchCode);
                }
                long j6 = this.mLogTotalCount + 1;
                this.mLogTotalCount = j6;
                jSONObjectCreateCommonLog.put("log_total_count_when_playing", j6);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                this.mLogTotalCount = 0L;
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void onSwitch(String str, String str2, String str3, int i) {
        if (this.mLiveEngine == null || this.mLogUploader == null) {
            return;
        }
        try {
            JSONObject jSONObjectCreateCommonLog = createCommonLog();
            JSONObject jSONObjectPut = jSONObjectCreateCommonLog.put("event_key", "switch_url");
            if (str == null) {
                str = "null";
            }
            JSONObject jSONObjectPut2 = jSONObjectPut.put("last_cdn_play_url", str);
            if (str2 == null) {
                str2 = "null";
            }
            jSONObjectPut2.put("next_cdn_play_url", str2).put("res_bitrate", this.mResBitrate).put("last_res", this.mLastResolution).put("code", i).put(MediationConstant.KEY_REASON, str3);
            this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
            long j = this.mLogTotalCount;
            if (j > 0) {
                this.mLogTotalCount = j + 1;
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public void onSwitchURL(String str) {
        this.mCurrentPlayURL = str;
    }

    public void onUpdateMetaData(String str) {
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("sdk_version")) {
                this.mPushClientSDKVersion = jSONObject.getString("sdk_version");
            }
            if (jSONObject.has("platform")) {
                this.mPushClientPlatform = jSONObject.getString("platform");
            }
            if (jSONObject.has("os_version")) {
                this.mPushClientOSVersion = jSONObject.getString("os_version");
            }
            if (jSONObject.has(ze1.k)) {
                this.mPushClientModel = jSONObject.getString(ze1.k);
            }
            if (jSONObject.has(CropKey.RESULT_KEY_START_TIME)) {
                this.mPushClientStartTime = jSONObject.getString(CropKey.RESULT_KEY_START_TIME);
            }
            if (jSONObject.has("is_hardware_encode")) {
                this.mPushClientHardwareEncode = jSONObject.getInt("is_hardware_encode");
            }
            if (jSONObject.has("min_bitrate")) {
                this.mPushClientMinBitrate = jSONObject.getInt("min_bitrate");
            }
            if (jSONObject.has("max_bitrate")) {
                this.mPushClientMaxBitrate = jSONObject.getInt("max_bitrate");
            }
            if (jSONObject.has("default_bitrate")) {
                this.mPushClientDefaultBitrate = jSONObject.getInt("default_bitrate");
            }
            if (jSONObject.has("hit_node_optimize")) {
                this.mPushClientHitNodeOptimize = jSONObject.getInt("hit_node_optimize");
            }
            if (jSONObject.has("push_protocol")) {
                this.mPushClientPushProtocal = jSONObject.getString("push_protocol");
            }
            if (jSONObject.has("qId")) {
                this.mPushClientQId = jSONObject.getString("qId");
            }
            if (jSONObject.has("link_info")) {
                this.mLinkInfo = jSONObject.getString("link_info");
            }
            if (jSONObject.has("h_id")) {
                this.mFCDNTranscodeMethod = jSONObject.getInt("h_id");
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public void onUpdateSeiInfo(String str) {
        String str2;
        String str3;
        boolean z;
        MyNTPTask myNTPTask;
        if (TextUtils.isEmpty(str) || this.mLogBundle == null || this.mLiveEngine == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("ts")) {
                long j = jSONObject.getLong("ts");
                str2 = "real_video_framerate";
                str3 = "channel_id";
                long j2 = 0;
                if (this.mEnableNTPTask == 1 && jSONObject.has("tt_ntp") && jSONObject.getInt("tt_ntp") == 1) {
                    if (!this.mNTPRunning && (myNTPTask = this.mNTPTask) != null) {
                        myNTPTask.sendEmptyMessageDelayed(103, 0L);
                        this.mNTPRunning = true;
                    }
                    j2 = this.mTimeDiff;
                    this.mHasNTP = true;
                } else {
                    if (!this.mNTPRunning || jSONObject.has("tt_ntp")) {
                        z = false;
                    } else {
                        MyNTPTask myNTPTask2 = this.mNTPTask;
                        if (myNTPTask2 != null) {
                            myNTPTask2.mHandler.removeCallbacksAndMessages(null);
                        }
                        z = false;
                        this.mNTPRunning = false;
                    }
                    this.mHasNTP = z;
                }
                if (this.mEnableNTP == 1 && jSONObject.has("tt_ntp") && jSONObject.getInt("tt_ntp") == 1) {
                    VideoLiveManager videoLiveManager = this.mLiveEngine;
                    if (videoLiveManager != null) {
                        this.mTimeDiff = videoLiveManager.getNtpTimeDiff();
                    }
                    j2 = this.mTimeDiff;
                    this.mHasNTP = true;
                }
                this.mLogBundle.delay = (System.currentTimeMillis() - j) + j2;
                LogBundle logBundle = this.mSessionLogBundle;
                if (logBundle != null) {
                    logBundle.delay = (System.currentTimeMillis() - j) + j2;
                }
            } else {
                str2 = "real_video_framerate";
                str3 = "channel_id";
            }
            String str4 = this.mLogBundle.seiSource;
            if (jSONObject.has("source")) {
                this.mLogBundle.seiSource = jSONObject.getString("source");
            } else if (jSONObject.has("app_data")) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("app_data"));
                if (jSONObject2.has("vendor")) {
                    this.mLogBundle.seiSource = jSONObject2.getString("vendor");
                }
            }
            LogBundle logBundle2 = this.mSessionLogBundle;
            if (logBundle2 != null) {
                logBundle2.seiSource = this.mLogBundle.seiSource;
            }
            if (!str4.equals("none") && !this.mLogBundle.seiSource.equals(str4)) {
                if (str4.startsWith("TTLiveSDK")) {
                    onLink(true);
                } else {
                    onLink(false);
                }
            }
            if (jSONObject.has("app_data")) {
                JSONObject jSONObject3 = new JSONObject(jSONObject.optString("app_data"));
                String str5 = str3;
                if (jSONObject3.has(str5)) {
                    this.mLogBundle.channelId = jSONObject3.getString(str5);
                }
            } else {
                this.mLogBundle.channelId = "none";
            }
            if (jSONObject.has("real_bitrate")) {
                this.mLogBundle.seiBitrate = jSONObject.getInt("real_bitrate");
                this.mSeiHasBitrateAndFps = true;
            }
            if (jSONObject.has(str2)) {
                this.mLogBundle.seiFps = jSONObject.getInt(str2);
                this.mSeiHasBitrateAndFps = true;
            }
            if (jSONObject.has("trans_info") || jSONObject.has("tans_info")) {
                JSONObject jSONObject4 = jSONObject.has("trans_info") ? jSONObject.getJSONObject("trans_info") : jSONObject.getJSONObject("tans_info");
                if (jSONObject4 != null) {
                    checkVideoFrame(jSONObject4.getInt("index"), jSONObject4.getInt("sent_frames"), jSONObject4.getInt("checked_dts"));
                }
            }
            if (this.mEnableCheckSei && jSONObject.has("sei_index")) {
                checkSeiIndex(jSONObject.getInt("sei_index"));
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public void onVideoSizeChanged(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void onVideoStallCounter(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        JSONObject jSONObjectCreateCommonLog = createCommonLog();
        if (jSONObjectCreateCommonLog != null) {
            try {
                jSONObjectCreateCommonLog.put("event_key", "stall_counter").put("type", "video").put("render_stall_200_duration", j / 1000).put("render_stall_200_count", j % 1000).put("render_stall_300_duration", j2 / 1000).put("render_stall_300_count", j2 % 1000).put("render_stall_400_duration", j3 / 1000).put("render_stall_400_count", j3 % 1000).put("render_stall_500_duration", j4 / 1000).put("render_stall_500_count", j4 % 1000).put("demuxer_stall_500_duration", j5 / 1000).put("demuxer_stall_500_count", j5 % 1000).put("decode_pre_stall_500_duration", j6 / 1000).put("decode_pre_stall_500_count", j6 % 1000).put("decode_post_stall_500_duration", j7 / 1000).put("decode_post_stall_500_count", j7 % 1000);
                this.mLogUploader.onMonitorLog(jSONObjectCreateCommonLog, MONITOR_LOG_TYPE);
                long j8 = this.mLogTotalCount;
                if (j8 > 0) {
                    this.mLogTotalCount = j8 + 1;
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public void openNTP() {
        this.mEnableNTPTask = 1;
        this.mEnableNTP = 1;
        if (this.mNTPTask == null) {
            MyNTPTask myNTPTask = new MyNTPTask(this);
            this.mNTPTask = myNTPTask;
            myNTPTask.sendEmptyMessageDelayed(104, 0L);
        }
    }

    public void openNodeOptimizer(boolean z) {
        this.mOpenNodeOptimizer = z;
    }

    public void reset() {
        this.mCdnPlayURL = "none";
        this.mCurrentPlayURL = "none";
        this.mCdnIp = "none";
        this.mIpIsFromPlayerCore = false;
        this.mLogIndex = 0L;
        this.mPushClientSDKVersion = "none";
        this.mPushClientPlatform = "none";
        this.mPushClientOSVersion = "none";
        this.mPushClientModel = "none";
        this.mPushClientStartTime = "none";
        this.mPushClientHardwareEncode = -1;
        this.mPushClientMinBitrate = -1;
        this.mPushClientMaxBitrate = -1;
        this.mPushClientDefaultBitrate = -1;
        this.mPushClientHitNodeOptimize = -1;
        this.mPushClientPushProtocal = "none";
        this.mPushClientQId = "none";
        this.mEvaluatorSymbol = "none";
        this.mHitNodeOptimizer = false;
        this.mIsRemoteSorted = false;
        this.mIsHitCache = false;
        this.mHaveResetPlayer = false;
        this.mPreconnect = -1;
        this.mEnableHurry = false;
        this.mHurryTime = -1;
        this.mCatchSpeed = -1.0f;
        this.mSlowPlayTime = -1;
        this.mSlowSpeed = -1.0f;
        this.mSpeedSwitchCount = 0;
        this.mSpeedSwitchInfo = "none";
        this.mStartPlayBufferThres = 0L;
        this.mFastOpenDuration = -1;
        this.mCheckBufferingEndIgnoreVideo = 0;
        this.mStartDirectAfterPrepared = 0;
        this.mCheckBufferingEndAdvanceEnable = 0;
        this.mDefaultCodecID = -1;
        this.mMediaCodecAsyncInit = 0;
        this.mHasFirstFrame = false;
        this.mFirstFrameTimestamp = 0L;
        this.mErrorCode = 0;
        this.mStallStartTime = 0L;
        this.mStallReason = -1L;
        this.mStallTotalCount = 0L;
        this.mStallTotalTime = 0L;
        this.mVideoRenderStallTotalTime = 0L;
        this.mVideoRenderStallTotalCount = 0L;
        this.mAudioRenderStallTotalTime = 0L;
        this.mAudioRenderStallTotalCount = 0L;
        this.mErrorRecoverCount = 0L;
        this.mErrorRecoverTime = 0L;
        this.mIsInErrorRecovering = false;
        this.mIsStalling = false;
        this.mPlayingStallCount = 0;
        this.mPlayingStallTime = 0;
        this.mPlayingAudioRenderStallCount = 0;
        this.mPlayingAudioRenderStallTime = 0;
        this.mPlayingVideoRenderStallCount = 0;
        this.mPlayingVideoRenderStallTime = 0;
        this.mPlayingStallStartTime = 0L;
        this.mFirstStallStartTime = 0L;
        this.mFirstStallEndTime = 0L;
        this.mRetryCount = 0;
        this.mRetryTotalCount = 0;
        this.mSilenceDetectedCount = -1;
        this.mHasNTP = false;
        this.mTimeDiff = 0L;
        this.mEnableNTP = 0;
        this.mEnableNTPTask = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mMaxCacheSeconds = -1;
        this.mSRSuccess = false;
        this.mTextureRenderError = 0;
        this.mUseTextureRender = false;
        this.mContainerFps = -1.0f;
        this.mRenderStartNotifyTimeStamp = 0L;
        this.mTextureRenderFirstFrameTime = 0L;
        this.mRenderFpsTimeSeries = null;
        this.mDownloadSpeedTimeSeries = null;
        this.mAudioBufferTimeSeries = null;
        this.mSeiBitrateTimeSeries = null;
        this.mSeiFpsTimeSeries = null;
        this.mErrorTimeSeries = null;
        this.mStallTimeSeries = null;
        LogBundle logBundle = this.mLogBundle;
        if (logBundle != null) {
            logBundle.reset();
        }
        this.mCodecName = "none";
        this.mCodecType = "none";
        this.mIsInMainLooper = 1;
        this.mRuleIds = "none";
        this.mSessionId = "none";
        this.mSettingsInfo = "none";
        this.mTTNetNQEInfo = "none";
        this.mEnableP2P = 0;
        this.mEnableOpenMDL = 0;
        this.mUsedP2P = 0;
        this.mP2PLoaderType = -1;
        this.mLastTotalDownloadSize = 0L;
        this.mLastDownloadSizeDelta = 0L;
        this.mEnableResolutionAutoDegrade = false;
        this.mHasAbrInfo = false;
        this.mAbrStrategy = LiveConfigKey.RAD;
        this.mResolution = "origin";
        this.mAutoUsingResolution = "origin";
        this.mLastResolution = "none";
        this.mDefaultResBitrate = -1;
        this.mResBitrate = -1L;
        this.mAbrSwitchCount = 0;
        this.mAbrSwitchCountInfo = "none";
        this.mAbrSwitchInfo = "none";
        this.mCurDownloadSpeed = -1L;
        this.mCurAudioBufferTime = -1L;
        this.mCurVideoBufferTime = -1L;
        this.mAbrSwitchCost = -1L;
        this.mStallCountThresOfResolutionDegrade = 4;
        this.mNetworkTimeoutMs = -1;
        this.mQuicMtu = -1;
        this.mQuicScfgConfig = -1;
        this.mQuicPadHello = -1;
        this.mQuicTimerVersion = -1;
        this.mFirstFrameRetryCount = 0;
        this.mFirstFramePrepareTime = 0L;
        this.mLastPrepareTime = 0L;
        this.mEnableTcpFastOpen = 0;
        this.mEnableLowLatencyFLV = 0;
        this.mOptimizeBackupIps = null;
        this.mEnableLiveAbrCheckEnhance = 0;
        this.mRtcTcpConnectTimeStamp = 0L;
        this.mRtcTcpFirstPackageTimeStamp = 0L;
        this.mRtcTlsHandshakedTimeStamp = 0L;
        this.mRtcPlayFallBack = 0;
        this.mFallbackType = 0;
        this.mRtcSessionId = "none";
        this.mRtcPlayStopStatInfo = "none";
        this.mDisableVideoRender = 0;
        this.mRequestUrl = "none";
        this.mRequestHeaders = null;
        this.mUseExpectBitrate = 0;
        this.mFCDNTranscodeMethod = -1;
        this.mEnableReportSessionStop = 0;
        this.mSessionNum = 0;
        this.mVideoDecodeStallTotalCount = 0L;
        this.mVideoDecodeStallTotalTime = 0L;
        this.mAudioDecodeStallTotalCount = 0L;
        this.mAudioDecodeStallTotalTime = 0L;
        this.mVideoDemuxStallTotalCount = 0L;
        this.mVideoDemuxStallTotalTime = 0L;
        this.mAudioDemuxStallTotalCount = 0L;
        this.mAudioDemuxStallTotalTime = 0L;
        this.mNoSyncCount = 0;
        this.mNoSyncPlayingCount = 0;
        this.mNoSyncTimeDuration = 0L;
        this.mNoSyncPlayingTimeDuration = 0L;
        this.mNoSyncPtsDuration = 0L;
        this.mNoSyncPlayingPtsDuration = 0L;
        this.mNoSyncPlayingInfoStr = "";
        this.mNoSyncInfoStr = "";
        this.mEnableLiveIOPlay = 0;
        this.mLiveIOPlay = 0;
        this.mLiveIOP2P = 0;
        this.mLiveIOErrorMsg = "none";
        this.mFirstFrameView = 0L;
        this.mLiveIOVersion = "none";
        this.mUseLiveThreadPool = 0;
    }

    public void resetLog() {
    }

    public void resetStreamCheckParams() {
        LinkedBlockingQueue<Long> linkedBlockingQueue = this.mVideoDTSQueue;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
            this.mVideoDTSQueue = null;
        }
        this.mLastSentFrames = -1;
        this.mLastCheckDTS = -1L;
        this.mLastSeiIndex = -1;
        this.mLastIndex = -1;
    }

    public void setCdnIp(String str, boolean z) {
        this.mCdnIp = str;
        this.mIpIsFromPlayerCore = z;
    }

    public void setCheckSilenceInterval(int i) {
        this.mEnableCheckSilenceInterval = i > 0;
        this.mSilenceDetectedCount = i <= 0 ? -1 : 0;
    }

    public void setCodecType(String str) {
        this.mCodecType = str;
    }

    public void setCommonFlag(String str) {
        if (str != null) {
            this.mCommonFlag = str;
        }
    }

    public void setEvaluatorSymbol(String str) {
        if (str != null) {
            this.mEvaluatorSymbol = str;
        }
    }

    public void setFormatInfo(String str, String str2) {
        this.mSuggestFormat = str;
        this.mStreamFormat = str2;
    }

    public void setInErrorRecovering() {
        this.mIsInErrorRecovering = true;
        this.mErrorStartTime = System.currentTimeMillis();
    }

    public void setOriginUrl(String str) {
        this.mOriginUrl = str;
    }

    public void setPlayerSdkVersion(String str) {
        this.mPlayerVersion = str;
    }

    public void setPreconnect(int i) {
        this.mPreconnect = i;
    }

    public void setPreviewFlag(boolean z) {
        this.mIsPreview = z;
    }

    public void setProjectKey(String str) {
        this.mProjectKey = str;
    }

    public void setProtocolInfo(String str, String str2) {
        this.mSuggestProtocol = str;
        this.mProtocol = str2;
    }

    public void setQuicLibLoader(int i) {
        this.mQuicFlag = i;
    }

    public void setRemoteSorted(boolean z) {
        this.mIsRemoteSorted = z;
    }

    public void setRtcPlayLogInterval(long j) {
        if (j >= 1000) {
            this.mRtcPlayingLogInterval = j;
        }
    }

    public void setSdkParams(String str) {
        this.mSdkParams = str;
    }

    public void setWaitTime(long j) {
        LogBundle logBundle = this.mLogBundle;
        if (logBundle != null) {
            logBundle.waitingTimeAfterFirstFrame = j;
        }
        LogBundle logBundle2 = this.mSessionLogBundle;
        if (logBundle2 != null) {
            logBundle2.waitingTimeAfterFirstFrame = j;
        }
    }

    public void start() {
        MyNTPTask myNTPTask;
        if (this.mStarted) {
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(101, this.mInterval);
        if (this.mEnableUploadSessionSeries) {
            this.mHandler.sendEmptyMessageDelayed(102, 5000L);
        }
        if (this.mEnableNTPTask == 1 && !this.mNTPRunning && (myNTPTask = this.mNTPTask) != null) {
            myNTPTask.sendEmptyMessageDelayed(103, 0L);
            this.mNTPRunning = true;
        }
        this.mStarted = true;
    }
}
