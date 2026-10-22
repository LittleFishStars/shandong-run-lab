package com.bykv.vk.component.ttvideo.retry;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.component.ttvideo.log.LiveLoggerService;
import com.bykv.vk.component.ttvideo.log.MyLog;
import com.bykv.vk.component.ttvideo.network.IPCache;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public final class RetryProcessor {
    private static final int ACTION_NEXT_URL = 1;
    private static final int ACTION_REPORT_OUTSIDE = -1;
    private static final int ACTION_RESET_LATER = 3;
    private static final int ACTION_RESET_PLAYER = 2;
    private static final int ACTION_RTC_FALLBACK = 4;
    private static final int DNS_CACHE_RETRY_COUNT_LIMIT = 3;
    private static final int ERROR_LOG_COUNT = 7;
    private static final int MSG_ERROR_AGAIN_RETRY = 10002;
    private static final int MSG_STALL_RETRY = 10001;
    private static final int RETRY_COUNT_LIMIT = 700;
    private static final String TAG = "RetryProcessor";
    private static final long UPLOAD_LOG_TIME_INTERVAL = 1000;
    private static final SparseArray<String> sPlayerNetworkError;
    private static final SparseArray<String> sPlayerProcessingError;
    private static final SparseArray<String> sRetryStrategyMap;
    private static final SparseIntArray sStrategyMap;
    private LiveLoggerService mLogService;
    private final RetryListener mRetryListener;
    private final long mRetryTimeLimit;
    private long mStallRetryTimeInterval;
    private long mStallStartTime;
    private AtomicInteger mRetryCount = new AtomicInteger(0);
    private int mLogErrorCount = 7;
    private String mCurHostName = null;
    private boolean mIsHasUploadLog = false;
    private long mLastUploadLogTime = 0;
    private boolean mIsErroring = false;
    private boolean mStarted = false;
    private final Handler mHandler = new Handler(Looper.myLooper()) { // from class: com.bykv.vk.component.ttvideo.retry.RetryProcessor.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 10001) {
                if (i != 10002) {
                    return;
                }
                RetryProcessor.this.handleRetryForError(2, null);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - RetryProcessor.this.mStallStartTime < RetryProcessor.this.mRetryTimeLimit) {
                RetryProcessor.this.uploadRetryLog(LiveError.PLAYER_STALL);
                RetryProcessor.this.mRetryListener.onRetryResetPlayer(false);
                RetryProcessor.this.mHandler.sendEmptyMessageDelayed(10001, RetryProcessor.this.mStallRetryTimeInterval);
            } else {
                HashMap map = new HashMap();
                map.put("stallTime", Long.valueOf(jCurrentTimeMillis - RetryProcessor.this.mStallStartTime));
                RetryProcessor.this.handleRetryForError(-1, new LiveError(LiveError.STALL_RETRY_TIMEOUT, "Stall retry timeout", map));
            }
        }
    };

    public interface RetryListener {
        void onRTCFallBack();

        void onReportOutToApplication(LiveError liveError);

        void onRetryNextPlayURL();

        void onRetryResetPlayer(boolean z);
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sStrategyMap = sparseIntArray;
        SparseArray<String> sparseArray = new SparseArray<>();
        sPlayerNetworkError = sparseArray;
        SparseArray<String> sparseArray2 = new SparseArray<>();
        sPlayerProcessingError = sparseArray2;
        SparseArray<String> sparseArray3 = new SparseArray<>();
        sRetryStrategyMap = sparseArray3;
        sparseIntArray.put(-100002, 3);
        sparseIntArray.put(LiveError.LIVE_API_URL_INVALID, 3);
        sparseIntArray.put(LiveError.STALL_RETRY_TIMEOUT, 3);
        sparseIntArray.put(LiveError.NETWORK_IO_ERROR, 3);
        sparseIntArray.put(LiveError.STREAM_DRYUP, 3);
        sparseIntArray.put(LiveError.PLAY_DNS_ERROR, 3);
        sparseIntArray.put(LiveError.AGAIN_ERROR, 3);
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_SETTING_URI_IS_NULL_ERROR, "media player: setting uri is null error");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_SETTING_URI_IS_ERROR, "media player: setting uri is error");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_URL_IS_NOT_MP4_ERROR, "media player: url is not mp4 error");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_INVALID_INPUT_DATA_ERROR, "media player: invalid data error");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_HTTP_BAD_REQUEST_ERROR, "media player: http bad request error");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_HTTP_UNAUTHORIZED_ERROR, "media player: http unauthorized error");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_HTTP_FORBIDEN_ERROR, "media player: http forbidden error");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_HTTP_NOT_FOUND_ERROR, "media player: http not found error");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_HTTP_OTHER_4xx_ERROR, "media player: http other 4xx error");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_HTTP_SERVER_ERROR_ERROR, "media player: http server error");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_HTTP_CONTENT_TYPE_IS_NOT_VALID_ERROR, "media player: http content type invalid");
        sparseArray.put(MediaPlayer.MEDIA_INFO_HTTP_REDIRECT, "media info http redirect");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_TCP_FAILED_TO_RESOLVE_HOSTNAME_ERROR, "media player: tcp failed to resolve hostname");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_TCP_SEND_DATA_FAILED_ERROR, "media player: tcp send data failed");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_TCP_RECEIVE_DATA_FAILED_ERROR, "media player: tcp receive data failed");
        sparseArray.put(-499793, "media player: tcp read network timeout");
        sparseArray.put(MediaPlayer.MEDIA_PLAYER_TCP_WRITE_NETWORK_TIMEOUT_ERROR, "media player: tcp write network timeout");
        sparseArray2.put(MediaPlayer.MEDIA_PLAYER_SETTING_IS_NULL_ERROR, "media player setting is null");
        sparseArray2.put(MediaPlayer.MEDIA_PLAYER_START_DECODER_ERROR, "media player start decoder error");
        sparseArray2.put(MediaPlayer.MEDIA_PLAYER_OPEN_DECODER_ERROR, "media player open decoder error");
        sparseArray2.put(MediaPlayer.MEDIA_PLAYER_OPEN_OUTLET_ERROR, "media player open outlet error");
        sparseArray2.put(MediaPlayer.MEDIA_PLAYER_START_OUTPUTER_ERROR, "media player start outputer error");
        sparseArray2.put(MediaPlayer.MEDIA_PLAYER_START_OUTLET_ERROR, "media player start outlet error");
        sparseArray2.put(MediaPlayer.MEDIA_PLAYER_OPEN_DEVICE_ERROR, "media player open device error");
        sparseArray2.put(1, "android media player unknown");
        sparseArray3.put(-1, "not retry, report to application");
        sparseArray3.put(1, "try next url from live info");
        sparseArray3.put(2, "reset player");
    }

    public RetryProcessor(RetryListener retryListener, int i, long j, LiveLoggerService liveLoggerService) {
        this.mStallRetryTimeInterval = 10000L;
        this.mRetryListener = retryListener;
        this.mRetryTimeLimit = i * 1000;
        this.mStallRetryTimeInterval = j;
        this.mRetryCount.set(0);
        this.mLogService = liveLoggerService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRetryForError(int i, LiveError liveError) {
        MyLog.i(TAG, "handleRetryForError action=".concat(String.valueOf(i)));
        if (i == -1) {
            this.mRetryListener.onReportOutToApplication(liveError);
            return;
        }
        if (i == 1) {
            this.mRetryListener.onRetryNextPlayURL();
            return;
        }
        if (i == 2) {
            MyLog.i(TAG, "ACTION_RESET_PLAYER");
            this.mRetryListener.onRetryResetPlayer(false);
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            MyLog.i(TAG, "ACTION_RTC_FALLBACK");
            this.mRetryListener.onRTCFallBack();
            return;
        }
        if (this.mHandler.hasMessages(10002)) {
            return;
        }
        MyLog.i("RETRY", "start " + this.mRetryCount);
        this.mHandler.sendEmptyMessageDelayed(10002, this.mRetryCount.get() > 3 ? this.mStallRetryTimeInterval : this.mRetryCount.get() * this.mRetryCount.get() * 1000);
    }

    private void upLoadErrorLog(LiveError liveError) {
        int i = this.mLogErrorCount - 1;
        this.mLogErrorCount = i;
        if (i >= 0) {
            this.mLogService.onError(liveError.code, liveError.getInfoJSON());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadRetryLog(int i) {
        boolean z = this.mIsHasUploadLog;
        if (!z || (z && System.currentTimeMillis() - this.mLastUploadLogTime >= 1000)) {
            this.mLogService.onRetry(i);
            this.mLogService.onFirstFrameFail(i);
            this.mIsHasUploadLog = true;
            this.mLastUploadLogTime = System.currentTimeMillis();
        }
    }

    public int getRetryCount() {
        return this.mRetryCount.get();
    }

    public void onError(LiveError liveError, boolean z) {
        int iIntValue;
        int i;
        MyLog.i(TAG, "onError error=".concat(String.valueOf(liveError)));
        if (this.mStarted) {
            if (this.mIsErroring && liveError.code == -100016) {
                return;
            }
            this.mRetryCount.incrementAndGet();
            if (liveError.code != -100016) {
                this.mIsErroring = true;
            }
            Map map = liveError.info;
            if (this.mRetryCount.get() > 700) {
                i = -1;
            } else if (liveError.code == -100003) {
                try {
                    iIntValue = ((Integer) map.get("internalCode")).intValue();
                    try {
                        liveError.code = iIntValue;
                    } catch (NumberFormatException unused) {
                        map.put("retryError", "error while get player internal error code");
                    }
                } catch (NumberFormatException unused2) {
                    iIntValue = 0;
                }
                SparseArray<String> sparseArray = sPlayerNetworkError;
                if (sparseArray.indexOfKey(iIntValue) >= 0) {
                    map.put("playErrorReason", sparseArray.get(iIntValue));
                    i = 1;
                } else {
                    i = 3;
                }
                LiveLoggerService liveLoggerService = this.mLogService;
                if (liveLoggerService.mEnableRtcPlay == 1 && liveLoggerService.mRtcPlayFallBack == 0) {
                    i = 4;
                }
            } else {
                i = 3;
            }
            if (this.mRetryCount.get() > 3 && this.mCurHostName != null) {
                IPCache.getInstance().disableIpAddress(this.mCurHostName);
            }
            this.mLogService.setInErrorRecovering();
            if (this.mRetryCount.get() == 1) {
                this.mLogService.onStallStart(liveError.code, z);
            }
            handleRetryForError(i, liveError);
            upLoadErrorLog(liveError);
            uploadRetryLog(liveError.code);
        }
    }

    public void onStall(boolean z, boolean z2) {
        MyLog.i(TAG, "onStall ".concat(String.valueOf(z)));
        if (!z) {
            reset();
            return;
        }
        this.mStallStartTime = System.currentTimeMillis();
        if (z2) {
            this.mRetryListener.onRetryResetPlayer(true);
            uploadRetryLog(LiveError.IO_BLOCKED);
        }
        if (this.mHandler.hasMessages(10001)) {
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(10001, this.mStallRetryTimeInterval);
    }

    public void reset() {
        this.mRetryCount.set(0);
        this.mStallStartTime = 0L;
        this.mLogErrorCount = 7;
        this.mIsHasUploadLog = false;
        this.mLastUploadLogTime = 0L;
        this.mIsErroring = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void setHost(String str) {
        this.mCurHostName = str;
    }

    public void setStallRetryTimeInterval(long j) {
        this.mStallRetryTimeInterval = j;
    }

    public void start() {
        this.mStarted = true;
    }

    public void stop() {
        this.mStarted = false;
    }
}
