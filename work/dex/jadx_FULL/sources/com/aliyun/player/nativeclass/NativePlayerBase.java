package com.aliyun.player.nativeclass;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.view.Surface;
import com.aliyun.aio_stat.AioStat;
import com.aliyun.player.FilterConfig;
import com.aliyun.player.IPlayer;
import com.aliyun.player.bean.ErrorCode;
import com.aliyun.player.bean.ErrorInfo;
import com.aliyun.player.bean.InfoBean;
import com.aliyun.player.bean.InfoCode;
import com.aliyun.player.videoview.AliDisplayView;
import com.aliyun.player.videoview.a.a;
import com.aliyun.utils.DeviceInfoUtils;
import com.aliyun.utils.f;
import com.cicada.player.utils.FrameInfo;
import com.cicada.player.utils.Logger;
import com.cicada.player.utils.NativeUsed;
import com.cicada.player.utils.media.DrmCallback;
import com.zj.adlib.u15;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NativePlayerBase {
    private static final String TAG = "NativePlayerBase";
    private static final int UPDATE_CURRENT_POSITION = 1000;
    private static final int VIDEO_TYPE_FAIRPLAY = 16;
    private static final int VIDEO_TYPE_HDR10 = 2;
    private static final int VIDEO_TYPE_NONE = 0;
    private static final int VIDEO_TYPE_SDR = 1;
    private static final int VIDEO_TYPE_WIDEVINE_L1 = 4;
    private static final int VIDEO_TYPE_WIDEVINE_L3 = 8;
    private static String libPath;
    private static Context mContext;
    private static IPlayer.ConvertURLCallback sConvertURLCallback;
    private MainHandler mCurrentThreadHandler;
    private long mNativeContext;
    private boolean mSurfaceFromUser = false;
    private boolean mEnableTunnelMode = false;
    private IPlayer.OnRenderFrameCallback mRenderFrameCallback = null;
    private IPlayer.OnPreRenderFrameCallback mPreRenderFrameCallback = null;
    private IPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = null;
    private IPlayer.OnVideoRenderedListener mOnVideoRenderedListener = null;
    private IPlayer.OnInfoListener mOnInfoListener = null;
    private IPlayer.OnTrackReadyListener mOnTrackReadyListener = null;
    private IPlayer.OnChooseTrackIndexListener mOnChooseTrackIndexListener = null;
    private IPlayer.OnPreparedListener mOnPreparedListener = null;
    private IPlayer.OnCompletionListener mOnCompletionListener = null;
    private IPlayer.OnErrorListener mOnErrorListener = null;
    private IPlayer.OnRenderingStartListener mOnRenderingStartListener = null;
    private IPlayer.OnStreamSwitchedListener mOnStreamSwitchedListener = null;
    private IPlayer.OnTrackChangedListener mOnTrackChangedListener = null;
    private IPlayer.OnSeiDataListener mOnSeiDataListener = null;
    private IPlayer.OnLoadingStatusListener mOnLoadingStatusListener = null;
    private IPlayer.OnSeekCompleteListener mOnSeekCompleteListener = null;
    private IPlayer.OnSubtitleDisplayListener mOnSubtitleDisplayListener = null;
    private IPlayer.OnStateChangedListener mOnStateChangedListener = null;
    private IPlayer.OnSnapShotListener mOnSnapShotListener = null;
    private IPlayer.OnReportEventListener mOnEventReportListner = null;
    private DrmCallback mDrmCallback = null;
    private boolean mDirectRender = false;
    private int mVideoType = 0;
    private AliDisplayView mAliDisplayView = null;
    private DisplayViewHelper mDisplayViewHelper = null;

    public static class MainHandler extends Handler {
        private WeakReference<NativePlayerBase> playerWeakReference;

        public MainHandler(NativePlayerBase nativePlayerBase, Looper looper) {
            super(looper);
            this.playerWeakReference = new WeakReference<>(nativePlayerBase);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            NativePlayerBase nativePlayerBase = this.playerWeakReference.get();
            if (nativePlayerBase != null) {
                nativePlayerBase.handleMessage(message);
            }
            super.handleMessage(message);
        }
    }

    static {
        f.b();
        mContext = null;
        sConvertURLCallback = null;
    }

    public NativePlayerBase(Context context) {
        mContext = context;
        if (libPath == null) {
            libPath = getUserNativeLibPath(context);
            loadPlugins();
        }
        DeviceInfoUtils.setSDKContext(context);
        AioStat.init(context);
        this.mCurrentThreadHandler = new MainHandler(this, Looper.getMainLooper());
        construct(context);
    }

    private void construct(Context context) {
        nConstruct();
    }

    public static Context getContext() {
        return mContext;
    }

    public static String getSdkVersion() {
        return nGetSdkVersion();
    }

    private static String getUserNativeLibPath(Context context) {
        String packageName = context.getPackageName();
        String str = "/data/data/" + packageName + "/lib/";
        try {
            str = context.getPackageManager().getPackageInfo(packageName, 0).applicationInfo.dataDir + "/lib/";
        } catch (PackageManager.NameNotFoundException unused) {
        }
        File file = new File(str);
        if (file.exists() && file.listFiles() != null) {
            return str;
        }
        try {
            return context.getPackageManager().getPackageInfo(packageName, 0).applicationInfo.nativeLibraryDir + WVNativeCallbackUtil.SEPERATER;
        } catch (PackageManager.NameNotFoundException unused2) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessage(Message message) {
        if (message.what != 1000 || this.mOnInfoListener == null) {
            return;
        }
        InfoBean infoBean = new InfoBean();
        infoBean.setCode(InfoCode.CurrentPosition);
        infoBean.setExtraValue(message.arg1);
        this.mOnInfoListener.onInfo(infoBean);
    }

    public static void loadClass() {
    }

    private void loadPlugins() {
        File[] fileArrListFiles;
        if (TextUtils.isEmpty(libPath)) {
            return;
        }
        File file = new File(libPath);
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            String name = file2.getName();
            if (name.contains("cicada_plugin_")) {
                try {
                    System.loadLibrary(name.substring(name.indexOf("lib") + 3, name.lastIndexOf(".so")));
                } catch (Exception e) {
                    Logger.e("NativePlayerBase", e.getMessage());
                }
            }
        }
    }

    public static String nConvertURLCallback(String str, String str2) {
        IPlayer.ConvertURLCallback convertURLCallback = sConvertURLCallback;
        if (convertURLCallback != null) {
            return convertURLCallback.convertURL(str, str2);
        }
        return null;
    }

    public static native String nGetSdkVersion();

    public static native void nSetBlackType(int i);

    @NativeUsed
    private boolean nUpdateViewCallback(int i) {
        String str = TAG;
        Logger.i(str, "nUpdateViewCallback videoType = " + i);
        this.mDirectRender = false;
        this.mVideoType = i;
        if (this.mSurfaceFromUser) {
            return false;
        }
        this.mDirectRender = this.mEnableTunnelMode;
        final AliDisplayView.DisplayViewType displayViewType = AliDisplayView.DisplayViewType.Either;
        if ((i & 2) == 2 || (i & 4) == 4 || (i & 8) == 8) {
            displayViewType = AliDisplayView.DisplayViewType.SurfaceView;
            this.mDirectRender = true;
        }
        Logger.i(str, "mDirectRender  = " + this.mDirectRender);
        if (this.mAliDisplayView == null) {
            Logger.e(str, "nCreateViewCallback but view is null");
            return false;
        }
        boolean zNeedUpdateView = this.mDisplayViewHelper.needUpdateView(displayViewType);
        this.mAliDisplayView.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.31
            @Override // java.lang.Runnable
            public void run() {
                NativePlayerBase.this.mDisplayViewHelper.createDisplayView(displayViewType, NativePlayerBase.this.mDirectRender);
                NativePlayerBase.this.mDisplayViewHelper.setVideoSize(NativePlayerBase.this.getVideoWidth(), NativePlayerBase.this.getVideoHeight(), (int) NativePlayerBase.this.getVideoRotation());
            }
        });
        return zNeedUpdateView;
    }

    @NativeUsed
    private void native_onEventReport(Object obj) {
        Map<String, String> map = (Map) obj;
        IPlayer.OnReportEventListener onReportEventListener = this.mOnEventReportListner;
        if (onReportEventListener != null) {
            onReportEventListener.onEventParam(map);
        }
    }

    @NativeUsed
    private boolean native_onPreRenderFrameCallback(Object obj) {
        IPlayer.OnPreRenderFrameCallback onPreRenderFrameCallback = this.mPreRenderFrameCallback;
        if (onPreRenderFrameCallback != null) {
            return onPreRenderFrameCallback.onPreRenderFrame((FrameInfo) obj);
        }
        return false;
    }

    @NativeUsed
    private boolean native_onRenderFrameCallback(Object obj) {
        IPlayer.OnRenderFrameCallback onRenderFrameCallback = this.mRenderFrameCallback;
        if (onRenderFrameCallback != null) {
            return onRenderFrameCallback.onRenderFrame((FrameInfo) obj);
        }
        return false;
    }

    public static void setBlackType(int i) {
        nSetBlackType(i);
    }

    public static void setConvertURLCb(IPlayer.ConvertURLCallback convertURLCallback) {
        sConvertURLCallback = convertURLCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSurfaceInner(Surface surface, boolean z) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Logger.w(TAG, "set surface not at main thread");
        }
        this.mSurfaceFromUser = z;
        nSetSurface(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trySetProjectionExtraInfo() {
        PlayerConfig config = getConfig();
        if (config == null || !config.mEnableProjection) {
            return;
        }
        String propertyString = getPropertyString(1000);
        try {
            if (!new JSONObject(propertyString).getBoolean("projectionLicenseEnable")) {
                Logger.w(TAG, "projection config enabled but license not activated");
                return;
            }
            try {
                Method declaredMethod = Class.forName("com.aliyun.player.aliplayerscreenprojection.AliPlayerScreenProjectionHelper").getDeclaredMethod("setExtraInfo", String.class, String.class);
                declaredMethod.setAccessible(true);
                String userData = getUserData();
                declaredMethod.invoke(null, userData, propertyString);
                Logger.i(TAG, "setExtraInfo to projection sdk success, userData:" + userData);
            } catch (Exception e) {
                Logger.e(TAG, "setExtraInfo to projection sdk failed, seems projection sdk is not integrated. Error:" + e.getMessage());
            }
        } catch (JSONException unused) {
            Logger.e(TAG, "Invalid prepared info:" + propertyString);
        }
    }

    public void addExtSubtitle(String str) {
        nAddExtSubtitle(str);
    }

    public synchronized void clearScreen() {
        nClearScreen();
    }

    public void clearScreenIfNeed() {
        PlayerConfig config = getConfig();
        if (config == null || !config.mClearFrameWhenStop) {
            return;
        }
        this.mDisplayViewHelper.clearScreen();
    }

    public synchronized void enableHardwareDecoder(boolean z) {
        nEnableHardwareDecoder(z);
    }

    public synchronized long getBufferedPosition() {
        return nGetBufferedPosition();
    }

    public String getCacheFilePath(String str) {
        return nGetCacheFilePath(str);
    }

    public String getCacheFilePath(String str, String str2, String str3, int i) {
        return nGetCacheFilePath(str, str2, str3, i);
    }

    public synchronized PlayerConfig getConfig() {
        Object objNGetConfig = nGetConfig();
        if (objNGetConfig == null) {
            return null;
        }
        return (PlayerConfig) objNGetConfig;
    }

    public synchronized long getCurrentPosition() {
        return nGetCurrentPosition();
    }

    public synchronized TrackInfo getCurrentTrackInfo(int i) {
        return (TrackInfo) nGetCurrentStreamInfo(i);
    }

    public synchronized long getDuration() {
        return nGetDuration();
    }

    public synchronized IPlayer.MirrorMode getMirrorMode() {
        int iNGetMirrorMode = nGetMirrorMode();
        IPlayer.MirrorMode mirrorMode = IPlayer.MirrorMode.MIRROR_MODE_NONE;
        if (iNGetMirrorMode == mirrorMode.getValue()) {
            return mirrorMode;
        }
        IPlayer.MirrorMode mirrorMode2 = IPlayer.MirrorMode.MIRROR_MODE_HORIZONTAL;
        if (iNGetMirrorMode == mirrorMode2.getValue()) {
            return mirrorMode2;
        }
        IPlayer.MirrorMode mirrorMode3 = IPlayer.MirrorMode.MIRROR_MODE_VERTICAL;
        return iNGetMirrorMode == mirrorMode3.getValue() ? mirrorMode3 : mirrorMode;
    }

    public long getNativeContext() {
        return this.mNativeContext;
    }

    public synchronized Object getOption(IPlayer.Option option) {
        String strNGetOption = nGetOption(option.getValue());
        if (strNGetOption == null) {
            return null;
        }
        if (option != IPlayer.Option.RenderFPS && option != IPlayer.Option.DownloadBitrate && option != IPlayer.Option.VideoBitrate && option != IPlayer.Option.AudioBitrate) {
            return strNGetOption;
        }
        try {
            return Float.valueOf(strNGetOption);
        } catch (Exception unused) {
            return Float.valueOf("0");
        }
    }

    public String getPlayerName() {
        return nGetPlayerName();
    }

    public synchronized String getPropertyString(int i) {
        return nGetPropertyString(i);
    }

    public synchronized IPlayer.RotateMode getRotateMode() {
        int iNGetRotateMode = nGetRotateMode();
        IPlayer.RotateMode rotateMode = IPlayer.RotateMode.ROTATE_0;
        if (iNGetRotateMode == rotateMode.getValue()) {
            return rotateMode;
        }
        IPlayer.RotateMode rotateMode2 = IPlayer.RotateMode.ROTATE_90;
        if (iNGetRotateMode == rotateMode2.getValue()) {
            return rotateMode2;
        }
        IPlayer.RotateMode rotateMode3 = IPlayer.RotateMode.ROTATE_180;
        if (iNGetRotateMode == rotateMode3.getValue()) {
            return rotateMode3;
        }
        IPlayer.RotateMode rotateMode4 = IPlayer.RotateMode.ROTATE_270;
        return iNGetRotateMode == rotateMode4.getValue() ? rotateMode4 : rotateMode;
    }

    public synchronized IPlayer.ScaleMode getScaleMode() {
        int iNGetScaleMode = nGetScaleMode();
        IPlayer.ScaleMode scaleMode = IPlayer.ScaleMode.SCALE_TO_FILL;
        if (iNGetScaleMode == scaleMode.getValue()) {
            return scaleMode;
        }
        IPlayer.ScaleMode scaleMode2 = IPlayer.ScaleMode.SCALE_ASPECT_FIT;
        if (iNGetScaleMode == scaleMode2.getValue()) {
            return scaleMode2;
        }
        IPlayer.ScaleMode scaleMode3 = IPlayer.ScaleMode.SCALE_ASPECT_FILL;
        return iNGetScaleMode == scaleMode3.getValue() ? scaleMode3 : scaleMode;
    }

    public synchronized float getSpeed() {
        return nGetSpeed();
    }

    public synchronized String getUserData() {
        return nGetUserData();
    }

    public synchronized int getVideoHeight() {
        return nGetVideoHeight();
    }

    public synchronized float getVideoRotation() {
        return nGetVideoRotation();
    }

    public synchronized int getVideoWidth() {
        return nGetVideoWidth();
    }

    public synchronized float getVolume() {
        return nGetVolume();
    }

    public int invokeComponent(String str) {
        return nInvokeComponent(str);
    }

    public synchronized boolean isAutoPlay() {
        return nIsAutoPlay();
    }

    public synchronized boolean isLoop() {
        return nIsLoop();
    }

    public synchronized boolean isMuted() {
        return nIsMuted();
    }

    public native void nAddExtSubtitle(String str);

    public native void nClearScreen();

    public native void nConstruct();

    public native void nEnableFrameCb(boolean z);

    public native void nEnableHardwareDecoder(boolean z);

    public native void nEnablePreFrameCb(boolean z);

    public native void nEnableVideoRenderedCallback(boolean z);

    public native long nGetBufferedPosition();

    public native String nGetCacheFilePath(String str);

    public native String nGetCacheFilePath(String str, String str2, String str3, int i);

    public native Object nGetConfig();

    public native long nGetCurrentPosition();

    public native Object nGetCurrentStreamInfo(int i);

    public native long nGetDuration();

    public native int nGetMirrorMode();

    public native String nGetOption(String str);

    public native String nGetPlayerName();

    public native String nGetPropertyString(int i);

    public native int nGetRotateMode();

    public native int nGetScaleMode();

    public native float nGetSpeed();

    public native String nGetUserData();

    public native int nGetVideoHeight();

    public native int nGetVideoRotation();

    public native int nGetVideoWidth();

    public native float nGetVolume();

    public native int nInvokeComponent(String str);

    public native boolean nIsAutoPlay();

    public native boolean nIsLoop();

    public native boolean nIsMuted();

    public native void nPause();

    public native void nPrepare();

    public native void nRelease();

    public native void nReload();

    public native void nSeekTo(long j, int i);

    public native void nSelectExtSubtitle(int i, boolean z);

    public native void nSelectTrack(int i);

    public native void nSelectTrackA(int i, boolean z);

    public native void nSendCustomEvent(String str);

    public native void nSetAutoPlay(boolean z);

    public native void nSetCacheConfig(Object obj);

    public native void nSetConfig(Object obj);

    public native void nSetConnectivityManager(Object obj);

    public native void nSetDefaultBandWidth(int i);

    public native void nSetFastStart(boolean z);

    public native void nSetFilterConfig(String str);

    public native void nSetFilterInvalid(String str, boolean z);

    public native void nSetFrameCbConfig(boolean z, boolean z2);

    public native void nSetIPResolveType(int i);

    public native void nSetLoop(boolean z);

    public native void nSetMaxAccurateSeekDelta(int i);

    public native void nSetMirrorMode(int i);

    public native void nSetMute(boolean z);

    public native void nSetOption(String str, String str2);

    public native void nSetOutputAudioChannel(int i);

    public native void nSetPreferPlayerName(String str);

    public native void nSetRotateMode(int i);

    public native void nSetScaleMode(int i);

    public native void nSetSpeed(float f);

    public native void nSetStreamDelayTime(int i, int i2);

    public native void nSetSurface(Surface surface);

    public native void nSetTraceID(String str);

    public native void nSetUserData(String str);

    public native void nSetVideoBackgroundColor(int i);

    public native void nSetVideoTag(int[] iArr);

    public native void nSetVolume(float f);

    public native void nSnapShot();

    public native void nStart();

    public native void nStop();

    public native void nSurfaceChanged();

    public native void nSwitchStream(String str);

    public native void nUpdateFilterConfig(String str, String str2);

    public void onAutoPlayStart() {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.6
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnInfoListener != null) {
                    InfoBean infoBean = new InfoBean();
                    infoBean.setCode(InfoCode.AutoPlayStart);
                    NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
                }
            }
        });
    }

    public void onBufferedPositionUpdate(final long j) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.18
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnInfoListener != null) {
                    InfoBean infoBean = new InfoBean();
                    infoBean.setCode(InfoCode.BufferedPosition);
                    infoBean.setExtraValue(j);
                    NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
                }
            }
        });
    }

    public void onCaptureScreen(final int i, final int i2, byte[] bArr) {
        final Bitmap bitmapCreateBitmap = null;
        if (i > 0 && i2 > 0 && bArr != null && bArr.length > 0) {
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
            } catch (Exception unused) {
            }
        }
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.30
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnSnapShotListener != null) {
                    NativePlayerBase.this.mOnSnapShotListener.onSnapShot(bitmapCreateBitmap, i, i2);
                }
            }
        });
    }

    public int onChooseTrackIndex(TrackInfo[] trackInfoArr) {
        IPlayer.OnChooseTrackIndexListener onChooseTrackIndexListener = this.mOnChooseTrackIndexListener;
        if (onChooseTrackIndexListener != null) {
            return onChooseTrackIndexListener.onChooseTrackIndex(trackInfoArr);
        }
        return -1;
    }

    public void onCircleStart() {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.5
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnInfoListener != null) {
                    InfoBean infoBean = new InfoBean();
                    infoBean.setCode(InfoCode.LoopingStart);
                    NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
                }
            }
        });
    }

    public void onCompletion() {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.4
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnCompletionListener != null) {
                    NativePlayerBase.this.mOnCompletionListener.onCompletion();
                }
            }
        });
    }

    public void onCurrentDownloadSpeed(final long j) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.21
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnInfoListener != null) {
                    InfoBean infoBean = new InfoBean();
                    infoBean.setCode(InfoCode.CurrentDownloadSpeed);
                    infoBean.setExtraValue(j);
                    NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
                }
            }
        });
    }

    public void onCurrentPositionUpdate(long j) {
        this.mCurrentThreadHandler.sendMessage(this.mCurrentThreadHandler.obtainMessage(1000, (int) j, 0));
    }

    public void onError(int i, final String str, final String str2) {
        final ErrorCode errorCode = ErrorCode.ERROR_UNKNOWN;
        for (ErrorCode errorCode2 : ErrorCode.values()) {
            if (errorCode2.getValue() == i) {
                errorCode = errorCode2;
                break;
            }
        }
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.7
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnErrorListener != null) {
                    ErrorInfo errorInfo = new ErrorInfo();
                    errorInfo.setCode(errorCode);
                    errorInfo.setMsg(str);
                    errorInfo.setExtra(str2);
                    NativePlayerBase.this.mOnErrorListener.onError(errorInfo);
                }
            }
        });
    }

    public void onEvent(int i, final String str, Object obj) {
        final InfoCode infoCode = InfoCode.Unknown;
        for (InfoCode infoCode2 : InfoCode.values()) {
            if (infoCode2.getValue() == i) {
                infoCode = infoCode2;
                break;
            }
        }
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.8
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnInfoListener != null) {
                    InfoBean infoBean = new InfoBean();
                    infoBean.setCode(infoCode);
                    infoBean.setExtraMsg(str);
                    NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
                }
            }
        });
    }

    public void onFirstFrameShow() {
        if (this.mAliDisplayView != null) {
            this.mDisplayViewHelper.firstFrameRender(getVideoWidth() > 0);
        }
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.9
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnRenderingStartListener != null) {
                    NativePlayerBase.this.mOnRenderingStartListener.onRenderingStart();
                }
            }
        });
    }

    public void onHideSubtitle(final int i, final long j) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.28
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnSubtitleDisplayListener != null) {
                    NativePlayerBase.this.mOnSubtitleDisplayListener.onSubtitleHide(i, j);
                }
            }
        });
    }

    public void onLoadingEnd() {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.24
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnLoadingStatusListener != null) {
                    NativePlayerBase.this.mOnLoadingStatusListener.onLoadingEnd();
                }
            }
        });
    }

    public void onLoadingProgress(final float f) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.20
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnLoadingStatusListener != null) {
                    NativePlayerBase.this.mOnLoadingStatusListener.onLoadingProgress((int) f, 0.0f);
                }
            }
        });
    }

    public void onLoadingStart() {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.19
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnLoadingStatusListener != null) {
                    NativePlayerBase.this.mOnLoadingStatusListener.onLoadingBegin();
                }
            }
        });
    }

    public void onLocalCacheLoad(final long j) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.23
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnInfoListener != null) {
                    InfoBean infoBean = new InfoBean();
                    infoBean.setCode(InfoCode.LocalCacheLoaded);
                    infoBean.setExtraValue(j);
                    NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
                }
            }
        });
    }

    public void onPrepared() {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.3
            @Override // java.lang.Runnable
            public void run() {
                NativePlayerBase.this.trySetProjectionExtraInfo();
                if (NativePlayerBase.this.mOnPreparedListener != null) {
                    NativePlayerBase.this.mOnPreparedListener.onPrepared();
                }
            }
        });
    }

    public void onSeekEnd() {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.25
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnSeekCompleteListener != null) {
                    NativePlayerBase.this.mOnSeekCompleteListener.onSeekComplete();
                }
            }
        });
    }

    public void onSeiDataCallback(final int i, final byte[] bArr) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.15
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnSeiDataListener != null) {
                    NativePlayerBase.this.mOnSeiDataListener.onSeiData(i, bArr);
                }
            }
        });
    }

    public void onShowSubtitle(final int i, final long j, final String str, Object obj) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.26
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnSubtitleDisplayListener != null) {
                    NativePlayerBase.this.mOnSubtitleDisplayListener.onSubtitleShow(i, j, str);
                }
            }
        });
    }

    public void onStatusChanged(final int i, int i2) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.17
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnStateChangedListener != null) {
                    NativePlayerBase.this.mOnStateChangedListener.onStateChanged(i);
                }
            }
        });
    }

    public void onStreamInfoGet(final MediaInfo mediaInfo) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.12
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnTrackReadyListener != null) {
                    NativePlayerBase.this.mOnTrackReadyListener.onTrackReady(mediaInfo);
                }
            }
        });
    }

    public void onSubtitleExtAdded(final int i, final String str) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.27
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnSubtitleDisplayListener != null) {
                    NativePlayerBase.this.mOnSubtitleDisplayListener.onSubtitleExtAdded(i, str);
                }
            }
        });
    }

    public void onSubtitleHeader(final int i, final String str) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.29
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnSubtitleDisplayListener != null) {
                    NativePlayerBase.this.mOnSubtitleDisplayListener.onSubtitleHeader(i, str);
                }
            }
        });
    }

    public void onSwitchStreamFail(final TrackInfo trackInfo, final int i, final String str) {
        final ErrorCode errorCode;
        ErrorCode errorCode2 = ErrorCode.ERROR_UNKNOWN;
        for (ErrorCode errorCode3 : ErrorCode.values()) {
            if (errorCode3.getValue() == i) {
                errorCode = errorCode3;
                this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativePlayerBase.this.mOnTrackChangedListener != null) {
                            ErrorInfo errorInfo = new ErrorInfo();
                            errorInfo.setCode(errorCode);
                            errorInfo.setMsg(i + u15.f19942b + str);
                            NativePlayerBase.this.mOnTrackChangedListener.onChangedFail(trackInfo, errorInfo);
                        }
                    }
                });
            }
        }
        errorCode = errorCode2;
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.16
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnTrackChangedListener != null) {
                    ErrorInfo errorInfo = new ErrorInfo();
                    errorInfo.setCode(errorCode);
                    errorInfo.setMsg(i + u15.f19942b + str);
                    NativePlayerBase.this.mOnTrackChangedListener.onChangedFail(trackInfo, errorInfo);
                }
            }
        });
    }

    public void onSwitchStreamSuccess(final TrackInfo trackInfo) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.14
            @Override // java.lang.Runnable
            public void run() {
                NativePlayerBase.this.trySetProjectionExtraInfo();
                if (NativePlayerBase.this.mOnTrackChangedListener != null) {
                    NativePlayerBase.this.mOnTrackChangedListener.onChangedSuccess(trackInfo);
                }
            }
        });
    }

    public void onSwitchStreamUrlResult(final String str, final int i, final String str2) {
        final ErrorCode errorCode;
        ErrorCode errorCode2 = ErrorCode.ERROR_UNKNOWN;
        for (ErrorCode errorCode3 : ErrorCode.values()) {
            if (errorCode3.getValue() == i) {
                errorCode = errorCode3;
                this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativePlayerBase.this.mOnStreamSwitchedListener != null) {
                            if (i == 0) {
                                NativePlayerBase.this.mOnStreamSwitchedListener.onSwitchedSuccess(str);
                                return;
                            }
                            ErrorInfo errorInfo = new ErrorInfo();
                            errorInfo.setCode(errorCode);
                            errorInfo.setMsg(i + u15.f19942b + str2);
                            NativePlayerBase.this.mOnStreamSwitchedListener.onSwitchedFail(str, errorInfo);
                        }
                    }
                });
            }
        }
        errorCode = errorCode2;
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.13
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnStreamSwitchedListener != null) {
                    if (i == 0) {
                        NativePlayerBase.this.mOnStreamSwitchedListener.onSwitchedSuccess(str);
                        return;
                    }
                    ErrorInfo errorInfo = new ErrorInfo();
                    errorInfo.setCode(errorCode);
                    errorInfo.setMsg(i + u15.f19942b + str2);
                    NativePlayerBase.this.mOnStreamSwitchedListener.onSwitchedFail(str, errorInfo);
                }
            }
        });
    }

    public void onUtcTimeUpdate(final long j) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.22
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnInfoListener != null) {
                    InfoBean infoBean = new InfoBean();
                    infoBean.setCode(InfoCode.UtcTime);
                    infoBean.setExtraValue(j);
                    NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
                }
            }
        });
    }

    public void onVideoRendered(final long j, final long j2) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.11
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnVideoRenderedListener != null) {
                    NativePlayerBase.this.mOnVideoRenderedListener.onVideoRendered(j, j2);
                }
            }
        });
    }

    public void onVideoSizeChanged(final int i, final int i2) {
        this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.10
            @Override // java.lang.Runnable
            public void run() {
                if (NativePlayerBase.this.mOnVideoSizeChangedListener != null) {
                    NativePlayerBase.this.mOnVideoSizeChangedListener.onVideoSizeChanged(i, i2);
                }
            }
        });
    }

    public synchronized void pause() {
        nPause();
    }

    public synchronized void prepare() {
        nPrepare();
    }

    public synchronized void release() {
        nRelease();
        mContext = null;
    }

    public synchronized void reload() {
        nReload();
    }

    @NativeUsed
    public byte[] requestKey(String str, byte[] bArr) {
        DrmCallback drmCallback = this.mDrmCallback;
        if (drmCallback == null) {
            return null;
        }
        return drmCallback.requestKey(str, bArr);
    }

    @NativeUsed
    public byte[] requestProvision(String str, byte[] bArr) {
        DrmCallback drmCallback = this.mDrmCallback;
        if (drmCallback == null) {
            return null;
        }
        return drmCallback.requestProvision(str, bArr);
    }

    public synchronized void seekTo(long j) {
        this.mCurrentThreadHandler.removeMessages(1000);
        nSeekTo(j, 16);
    }

    public synchronized void seekTo(long j, int i) {
        this.mCurrentThreadHandler.removeMessages(1000);
        nSeekTo(j, i);
    }

    public void selectExtSubtitle(int i, boolean z) {
        nSelectExtSubtitle(i, z);
    }

    public synchronized void selectTrack(int i) {
        nSelectTrack(i);
    }

    public synchronized void selectTrack(int i, boolean z) {
        nSelectTrackA(i, z);
    }

    public void sendCustomEvent(String str) {
        nSendCustomEvent(str);
    }

    public synchronized void setAutoPlay(boolean z) {
        nSetAutoPlay(z);
    }

    public synchronized void setCacheConfig(CacheConfig cacheConfig) {
        nSetCacheConfig(cacheConfig);
    }

    public synchronized void setConfig(PlayerConfig playerConfig) {
        this.mEnableTunnelMode = playerConfig.mEnableVideoTunnelRender;
        nSetConfig(playerConfig);
    }

    public synchronized void setDefaultBandWidth(int i) {
        nSetDefaultBandWidth(i);
    }

    public void setDisplayView(AliDisplayView aliDisplayView) {
        this.mAliDisplayView = aliDisplayView;
        if (aliDisplayView == null) {
            this.mDisplayViewHelper = null;
            return;
        }
        DisplayViewHelper displayViewHelper = aliDisplayView.getDisplayViewHelper();
        this.mDisplayViewHelper = displayViewHelper;
        displayViewHelper.setOnViewStatusListener(new a.h() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.32
            @Override // com.aliyun.player.videoview.a.a.h
            public void onSurfaceCreated(Surface surface) {
                NativePlayerBase.this.setSurfaceInner(surface, false);
            }

            @Override // com.aliyun.player.videoview.a.a.h
            public void onSurfaceDestroy() {
                NativePlayerBase.this.setSurfaceInner(null, false);
            }

            @Override // com.aliyun.player.videoview.a.a.h
            public void onSurfaceSizeChanged() {
                NativePlayerBase.this.surfaceChanged();
            }

            @Override // com.aliyun.player.videoview.a.a.h
            public void onViewCreated(AliDisplayView.DisplayViewType displayViewType) {
            }
        });
        if (nGetVideoWidth() > 0 || nGetVideoHeight() > 0) {
            nUpdateViewCallback(this.mVideoType);
        }
    }

    public void setDrmCallback(DrmCallback drmCallback) {
        this.mDrmCallback = drmCallback;
    }

    public synchronized void setFastStart(boolean z) {
        nSetFastStart(z);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        nSetFilterConfig(filterConfig == null ? null : filterConfig.toString());
    }

    public void setFilterInvalid(String str, boolean z) {
        nSetFilterInvalid(str, z);
    }

    public synchronized void setIPResolveType(IPlayer.IPResolveType iPResolveType) {
        nSetIPResolveType(iPResolveType.ordinal());
    }

    public synchronized void setLoop(boolean z) {
        nSetLoop(z);
    }

    public void setMaxAccurateSeekDelta(int i) {
        nSetMaxAccurateSeekDelta(i);
    }

    public synchronized void setMirrorMode(IPlayer.MirrorMode mirrorMode) {
        if (this.mAliDisplayView != null && this.mDirectRender) {
            this.mDisplayViewHelper.setMirrorMode(mirrorMode);
        }
        nSetMirrorMode(mirrorMode.getValue());
    }

    public synchronized void setMute(boolean z) {
        nSetMute(z);
    }

    public void setNativeContext(long j) {
        this.mNativeContext = j;
    }

    public void setOnChooseTrackIndexListener(IPlayer.OnChooseTrackIndexListener onChooseTrackIndexListener) {
        this.mOnChooseTrackIndexListener = onChooseTrackIndexListener;
    }

    public void setOnCompletionListener(IPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(IPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(IPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnLoadingStatusListener(IPlayer.OnLoadingStatusListener onLoadingStatusListener) {
        this.mOnLoadingStatusListener = onLoadingStatusListener;
    }

    public void setOnPreRenderFrameCallback(IPlayer.OnPreRenderFrameCallback onPreRenderFrameCallback) {
        this.mPreRenderFrameCallback = onPreRenderFrameCallback;
        nEnablePreFrameCb(onPreRenderFrameCallback != null);
    }

    public void setOnPreparedListener(IPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnRenderFrameCallback(IPlayer.OnRenderFrameCallback onRenderFrameCallback) {
        this.mRenderFrameCallback = onRenderFrameCallback;
        nEnableFrameCb(onRenderFrameCallback != null);
    }

    public void setOnRenderingStartListener(IPlayer.OnRenderingStartListener onRenderingStartListener) {
        this.mOnRenderingStartListener = onRenderingStartListener;
    }

    public void setOnReportEventListener(IPlayer.OnReportEventListener onReportEventListener) {
        this.mOnEventReportListner = onReportEventListener;
    }

    public void setOnSeekCompleteListener(IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setOnSeiDataListener(IPlayer.OnSeiDataListener onSeiDataListener) {
        this.mOnSeiDataListener = onSeiDataListener;
    }

    public void setOnSnapShotListener(IPlayer.OnSnapShotListener onSnapShotListener) {
        this.mOnSnapShotListener = onSnapShotListener;
    }

    public void setOnStateChangedListener(IPlayer.OnStateChangedListener onStateChangedListener) {
        this.mOnStateChangedListener = onStateChangedListener;
    }

    public void setOnStreamSwitchedListener(IPlayer.OnStreamSwitchedListener onStreamSwitchedListener) {
        this.mOnStreamSwitchedListener = onStreamSwitchedListener;
    }

    public void setOnSubtitleDisplayListener(IPlayer.OnSubtitleDisplayListener onSubtitleDisplayListener) {
        this.mOnSubtitleDisplayListener = onSubtitleDisplayListener;
    }

    public void setOnTrackInfoGetListener(IPlayer.OnTrackReadyListener onTrackReadyListener) {
        this.mOnTrackReadyListener = onTrackReadyListener;
    }

    public void setOnTrackSelectRetListener(IPlayer.OnTrackChangedListener onTrackChangedListener) {
        this.mOnTrackChangedListener = onTrackChangedListener;
    }

    public void setOnVideoRenderedListener(IPlayer.OnVideoRenderedListener onVideoRenderedListener) {
        this.mOnVideoRenderedListener = onVideoRenderedListener;
        nEnableVideoRenderedCallback(onVideoRenderedListener != null);
    }

    public void setOnVideoSizeChangedListener(IPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    public synchronized void setOption(String str, String str2) {
        nSetOption(str, str2);
    }

    public synchronized void setOutputAudioChannel(int i) {
        nSetOutputAudioChannel(i);
    }

    public void setPreferPlayerName(String str) {
        nSetPreferPlayerName(str);
    }

    public void setRenderFrameCallbackConfig(IPlayer.RenderFrameCallbackConfig renderFrameCallbackConfig) {
        nSetFrameCbConfig(!renderFrameCallbackConfig.mVideoDataAddr, !renderFrameCallbackConfig.mAudioDataAddr);
    }

    public synchronized void setRotateMode(IPlayer.RotateMode rotateMode) {
        if (this.mAliDisplayView != null && this.mDirectRender) {
            this.mDisplayViewHelper.setRotateMode(rotateMode);
        }
        nSetRotateMode(rotateMode.getValue());
    }

    public synchronized void setScaleMode(final IPlayer.ScaleMode scaleMode) {
        AliDisplayView aliDisplayView = this.mAliDisplayView;
        if (aliDisplayView != null && this.mDirectRender) {
            aliDisplayView.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.1
                @Override // java.lang.Runnable
                public void run() {
                    NativePlayerBase.this.mDisplayViewHelper.setScaleMode(scaleMode);
                }
            });
        }
        nSetScaleMode(scaleMode.ordinal());
    }

    public synchronized void setSpeed(float f) {
        nSetSpeed(f);
    }

    public void setStreamDelayTime(int i, int i2) {
        nSetStreamDelayTime(i, i2);
    }

    public synchronized void setSurface(Surface surface) {
        if (this.mAliDisplayView != null) {
            return;
        }
        this.mAliDisplayView = null;
        this.mDisplayViewHelper = null;
        setSurfaceInner(surface, true);
    }

    public synchronized void setTraceId(String str) {
        nSetTraceID(str);
    }

    public synchronized void setUserData(String str) {
        nSetUserData(str);
    }

    public synchronized void setVideoBackgroundColor(int i) {
        if (this.mAliDisplayView != null && this.mDirectRender) {
            this.mDisplayViewHelper.setBackgroundColor(i);
        }
        nSetVideoBackgroundColor(i);
    }

    public void setVideoTag(int[] iArr) {
        nSetVideoTag(iArr);
    }

    public synchronized void setVolume(float f) {
        nSetVolume(f);
    }

    public synchronized void snapShot() {
        AliDisplayView aliDisplayView = this.mAliDisplayView;
        if (aliDisplayView == null || !this.mDirectRender) {
            nSnapShot();
        } else {
            aliDisplayView.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.2
                @Override // java.lang.Runnable
                public void run() {
                    final int width;
                    final int height;
                    final Bitmap bitmapSnapshot = NativePlayerBase.this.mDisplayViewHelper.snapshot();
                    if (bitmapSnapshot != null) {
                        width = bitmapSnapshot.getWidth();
                        height = bitmapSnapshot.getHeight();
                    } else {
                        width = 0;
                        height = 0;
                    }
                    NativePlayerBase.this.mCurrentThreadHandler.post(new Runnable() { // from class: com.aliyun.player.nativeclass.NativePlayerBase.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NativePlayerBase.this.mOnSnapShotListener != null) {
                                NativePlayerBase.this.mOnSnapShotListener.onSnapShot(bitmapSnapshot, width, height);
                            }
                        }
                    });
                }
            });
        }
    }

    public synchronized void start() {
        nStart();
    }

    public synchronized void stop() {
        if (this.mAliDisplayView != null && this.mDirectRender) {
            clearScreenIfNeed();
        }
        nStop();
    }

    public void surfaceChanged() {
        nSurfaceChanged();
    }

    public synchronized void switchStream(String str) {
        nSwitchStream(str);
    }

    public void updateFilterConfig(String str, FilterConfig.FilterOptions filterOptions) {
        nUpdateFilterConfig(str, filterOptions == null ? null : filterOptions.toString());
    }
}
