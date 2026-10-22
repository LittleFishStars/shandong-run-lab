package com.fl.saas.adx.base.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.fl.saas.C1415j;
import com.fl.saas.C1443x;
import com.fl.saas.R;
import com.fl.saas.adx.base.inner.interstitial.coustomView.VideoSoundControlListener;
import com.fl.saas.adx.base.interfaces.S2SVideoPlayListener;
import com.fl.saas.adx.base.interfaces.VolumeChangeObserver;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.FLImageLoader;
import com.fl.saas.adx.util.LogcatUtil;
import com.fl.saas.adx.util.ViewHelper;
import com.fl.saas.c1;
import com.fl.saas.f1;
import com.fl.saas.g1;
import com.kwad.sdk.collector.AppStatusRules;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class S2SVideoView extends FrameLayout implements VideoSoundControlListener {
    public static final int MSG_AD_VISIBLE_CHECK = 11000;
    private int currentTime;
    private RelativeLayout endFrameView;
    private ImageView firstFrameView;
    private boolean hasChangeTextureViewSize;
    private boolean isDestroyed;
    private boolean isPlayError;
    private C1415j mAdxInfo;
    private final Context mContext;
    private final Handler mDurationCountdownHandler;
    private SafeHandler mHandler;
    private boolean mIs25Preent;
    private boolean mIs50Preent;
    private boolean mIs75Preent;
    private boolean mIsCallPlay;
    private boolean mIsFirstCreateTextureView;
    private boolean mIsSoundEnable;
    private boolean mIsTextureViewAvailable;
    private boolean mIsVideoCompleted;
    private boolean mIsVideoPrepared;
    private S2SVideoPlayListener mPlayListener;
    private MediaMetadataRetriever mediaMetadataRetriever;
    private MediaPlayer mediaPlayer;
    private ProgressBar progressBar;
    private int soundBottom;
    private ImageView soundControlImageView;
    private int soundHeight;
    private boolean soundImageGone;
    private int soundLeft;
    private int soundRight;
    private int soundTop;
    private int soundWidth;
    private boolean systemMute;
    private TextView textView;
    private TextureView textureView;
    private TextView tvBtn;
    private VideoSoundControlListener.SoundControlViewStateChangeListener viewStateChangeListener;
    private VolumeChangeObserver volumeObserver;

    public static class SafeHandler extends Handler {
        private final WeakReference<S2SVideoView> mVideoViewRef;

        public SafeHandler(S2SVideoView s2SVideoView) {
            super(Looper.getMainLooper());
            this.mVideoViewRef = new WeakReference<>(s2SVideoView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            S2SVideoView s2SVideoView = this.mVideoViewRef.get();
            if (s2SVideoView == null || s2SVideoView.isDestroyed || message.what != 11000) {
                return;
            }
            if (s2SVideoView.checkViewVisible()) {
                s2SVideoView.startVideo((s2SVideoView.mAdxInfo == null || s2SVideoView.mAdxInfo.a()) ? false : true);
            } else {
                sendEmptyMessageDelayed(11000, 500L);
            }
        }
    }

    public S2SVideoView(@NonNull Context context) {
        super(context);
        this.hasChangeTextureViewSize = false;
        this.currentTime = -1;
        this.mIsCallPlay = false;
        this.mIsVideoPrepared = false;
        this.mIsVideoCompleted = false;
        this.mIsTextureViewAvailable = false;
        this.mIsFirstCreateTextureView = true;
        this.soundImageGone = false;
        this.mIsSoundEnable = false;
        this.mIs25Preent = false;
        this.mIs50Preent = false;
        this.mIs75Preent = false;
        this.isPlayError = false;
        this.isDestroyed = false;
        this.systemMute = false;
        this.soundWidth = 30;
        this.soundHeight = 30;
        this.soundTop = 5;
        this.soundLeft = 5;
        this.soundRight = 5;
        this.soundBottom = 5;
        this.mContext = context;
        this.mHandler = new SafeHandler(this);
        this.mDurationCountdownHandler = new Handler(Looper.getMainLooper());
        setBackgroundColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeTextureViewSize(boolean z) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || this.isDestroyed || this.textureView == null) {
            return;
        }
        if (z && this.hasChangeTextureViewSize) {
            return;
        }
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = this.mediaPlayer.getVideoHeight();
        int width = getWidth();
        int height = getHeight();
        LogcatUtil.d("FLSDK-S2SVideoView", "changeSize----width:" + videoWidth + "height:" + videoHeight + "viewWidth:" + width + "viewHeight:" + height);
        if (videoWidth <= 0 || videoHeight <= 0 || width <= 0 || height <= 0) {
            return;
        }
        this.hasChangeTextureViewSize = true;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textureView.getLayoutParams();
        int i = videoWidth * height;
        int i2 = videoHeight * width;
        if (i > i2) {
            layoutParams.height = i2 / videoWidth;
            layoutParams.width = width;
        } else {
            layoutParams.width = i / videoHeight;
            layoutParams.height = height;
        }
        this.textureView.setLayoutParams(layoutParams);
    }

    private boolean checkAreaEffective(Rect rect) {
        int width = getWidth();
        int height = getHeight();
        return width > 0 && height > 0 && ((double) (rect.width() * rect.height())) > ((double) (width * height)) * 0.7d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkViewVisible() {
        if (this.isDestroyed) {
            return false;
        }
        Rect rect = new Rect();
        return getGlobalVisibleRect(rect) && checkAreaEffective(rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createMediaView() {
        if (this.isDestroyed) {
            return;
        }
        this.mIsVideoCompleted = false;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.fl.saas.adx.base.widget.S2SVideoView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer2) {
                if (S2SVideoView.this.isDestroyed) {
                    return;
                }
                S2SVideoView.this.mIsVideoCompleted = true;
                S2SVideoView.this.showEndFrame();
                S2SVideoView.this.mAdxInfo.Z1 = mediaPlayer2.getDuration() / 1000;
                C1443x.a().b(S2SVideoView.this.mAdxInfo, mediaPlayer2.getDuration());
                C1443x.a().j(S2SVideoView.this.mAdxInfo);
                if (S2SVideoView.this.mPlayListener != null) {
                    S2SVideoView.this.mPlayListener.onVideoPlayComplete();
                }
                S2SVideoView.this.releaseSource();
            }
        });
        this.mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.fl.saas.adx.base.widget.S2SVideoView.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                if (!S2SVideoView.this.isDestroyed && !S2SVideoView.this.isPlayError) {
                    ViewHelper.removeParent(S2SVideoView.this.progressBar);
                    S2SVideoView.this.isPlayError = true;
                    S2SVideoView.this.mAdxInfo.Z1 = mediaPlayer2.getDuration() / 1000;
                    S2SVideoView.this.mAdxInfo.f2 = 2;
                    C1443x.a().j(S2SVideoView.this.mAdxInfo);
                    if (S2SVideoView.this.mPlayListener != null) {
                        S2SVideoView.this.mPlayListener.onVideoPlayError(i, i2);
                    }
                    S2SVideoView.this.showEndFrame();
                }
                return true;
            }
        });
        this.mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.fl.saas.adx.base.widget.S2SVideoView.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer2) {
                if (S2SVideoView.this.isDestroyed) {
                    if (mediaPlayer2 != null) {
                        mediaPlayer2.release();
                        return;
                    }
                    return;
                }
                LogcatUtil.d("FLSDK-S2SVideoView", "prepared");
                if (S2SVideoView.this.mPlayListener != null) {
                    S2SVideoView.this.mPlayListener.onVideoPrepare();
                }
                S2SVideoView.this.mIsVideoPrepared = true;
                S2SVideoView.this.mAdxInfo.b2 = 1;
                if (mediaPlayer2 != null && mediaPlayer2.getDuration() > 0) {
                    S2SVideoView.this.mAdxInfo.X1 = mediaPlayer2.getDuration() / 1000;
                }
                S2SVideoView s2SVideoView = S2SVideoView.this;
                s2SVideoView.setSoundEnable(s2SVideoView.mIsSoundEnable);
                if (S2SVideoView.this.mIsVideoCompleted || S2SVideoView.this.mIsCallPlay) {
                    return;
                }
                S2SVideoView s2SVideoView2 = S2SVideoView.this;
                s2SVideoView2.startVideo((s2SVideoView2.mAdxInfo == null || S2SVideoView.this.mAdxInfo.a()) ? false : true);
            }
        });
        this.mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.fl.saas.adx.base.widget.S2SVideoView.4
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer2, int i, int i2) {
                if (S2SVideoView.this.isDestroyed) {
                    return;
                }
                int videoWidth = mediaPlayer2.getVideoWidth();
                int videoHeight = mediaPlayer2.getVideoHeight();
                if (videoWidth == 0 || videoHeight == 0) {
                    return;
                }
                S2SVideoView.this.changeTextureViewSize(false);
            }
        });
        if (DeviceUtil.filling_timing == 1) {
            try {
                this.mediaPlayer.setDataSource(g1.a().a(this.mContext, new f1(AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE, this.mAdxInfo.t1)));
                this.mediaPlayer.prepareAsync();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerSound$3(boolean z) {
        ImageView imageView;
        ImageView imageView2;
        VideoSoundControlListener.SoundControlViewStateChangeListener soundControlViewStateChangeListener = this.viewStateChangeListener;
        if (soundControlViewStateChangeListener != null) {
            soundControlViewStateChangeListener.changeSystemSound(z);
        }
        if (!z) {
            this.systemMute = false;
            if (!this.mIsSoundEnable || (imageView = this.soundControlImageView) == null) {
                return;
            }
            imageView.setImageResource(R.drawable.fl_adx_volume_on);
            return;
        }
        this.systemMute = true;
        if (!this.mIsSoundEnable || (imageView2 = this.soundControlImageView) == null) {
            return;
        }
        imageView2.setImageResource(R.drawable.fl_adx_volume_off);
        C1443x.a().k(this.mAdxInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerSound$4(int i, final boolean z) {
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.sq7
            @Override // java.lang.Runnable
            public final void run() {
                this.f44754a.lambda$registerSound$3(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resumeVideo$5() {
        if (this.isDestroyed) {
            return;
        }
        C1415j c1415j = this.mAdxInfo;
        startVideo((c1415j == null || c1415j.a()) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideo$0(View view) {
        if (this.systemMute) {
            return;
        }
        setSoundEnable(!this.mIsSoundEnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideo$1(Bitmap bitmap) {
        ImageView imageView;
        if (this.isDestroyed) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
            return;
        }
        if (bitmap == null || (imageView = this.firstFrameView) == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideo$2(C1415j c1415j) {
        if (this.isDestroyed) {
            return;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            this.mediaMetadataRetriever = mediaMetadataRetriever;
            mediaMetadataRetriever.setDataSource(c1415j.t1, new HashMap());
            final Bitmap frameAtTime = this.mediaMetadataRetriever.getFrameAtTime();
            DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.oq7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18708a.lambda$setVideo$1(frameAtTime);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startVideo$6(View view) {
        C1415j c1415j = this.mAdxInfo;
        if (c1415j != null) {
            c1415j.e2 = 2;
        }
        ViewHelper.removeParent(view);
        startVideo(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startVideo$7() {
        ImageView imageView = this.firstFrameView;
        if (imageView != null) {
            ViewHelper.removeParent(imageView);
            this.firstFrameView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.currentTime = this.mediaPlayer.getCurrentPosition();
        this.mediaPlayer.pause();
        C1443x.a().l(this.mAdxInfo);
    }

    private void registerSound() {
        if (this.volumeObserver == null) {
            VolumeChangeObserver volumeChangeObserver = new VolumeChangeObserver(this.mContext);
            this.volumeObserver = volumeChangeObserver;
            volumeChangeObserver.start(new VolumeChangeObserver.VolumeChangeListener() { // from class: com.zj.adlib.mq7
                @Override // com.fl.saas.adx.base.interfaces.VolumeChangeObserver.VolumeChangeListener
                public final void onVolumeChanged(int i, boolean z) {
                    this.f43366a.lambda$registerSound$4(i, z);
                }
            });
        }
    }

    private void releaseMedia() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.mediaPlayer.stop();
                }
                this.mediaPlayer.setSurface(null);
                this.mediaPlayer.release();
                this.mediaPlayer = null;
            }
            MediaMetadataRetriever mediaMetadataRetriever = this.mediaMetadataRetriever;
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mediaMetadataRetriever = null;
            }
            this.mPlayListener = null;
            this.viewStateChangeListener = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseSource() {
        try {
            Handler handler = this.mDurationCountdownHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            SafeHandler safeHandler = this.mHandler;
            if (safeHandler != null) {
                safeHandler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeVideo() {
        C1415j c1415j = this.mAdxInfo;
        if (c1415j == null || c1415j.a() || (this.mAdxInfo.K0 != 3 && "1".equals(DeviceUtil.getNetworkType()))) {
            boolean z = this.mIsVideoCompleted;
            if (!z && !this.mIsCallPlay && this.mIsVideoPrepared) {
                DeviceUtil.postUIDelayed(200L, new Runnable() { // from class: com.zj.adlib.qq7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f44279a.lambda$resumeVideo$5();
                    }
                });
                return;
            }
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer == null || !this.mIsVideoPrepared) {
                return;
            }
            if (z) {
                int duration = mediaPlayer.getDuration();
                if (duration > 0) {
                    this.mediaPlayer.seekTo(duration);
                    this.mediaPlayer.pause();
                    return;
                }
                return;
            }
            int i = this.currentTime;
            if (i > 0) {
                mediaPlayer.seekTo(i, 3);
            }
            this.mediaPlayer.start();
            registerSound();
            C1415j c1415j2 = this.mAdxInfo;
            if (c1415j2 != null) {
                c1415j2.d2 = 2;
            }
            C1443x.a().h(this.mAdxInfo);
        }
    }

    private void setTextureView() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        if (this.textureView == null) {
            TextureView textureView = new TextureView(this.mContext);
            this.textureView = textureView;
            textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.fl.saas.adx.base.widget.S2SVideoView.5
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    if (S2SVideoView.this.isDestroyed) {
                        return;
                    }
                    LogcatUtil.d("FLSDK-S2SVideoView", "onSurfaceTextureAvailable");
                    S2SVideoView.this.mIsTextureViewAvailable = true;
                    if (S2SVideoView.this.mediaPlayer == null) {
                        S2SVideoView.this.createMediaView();
                    }
                    if (S2SVideoView.this.mediaPlayer != null && surfaceTexture != null) {
                        S2SVideoView.this.mediaPlayer.setSurface(new Surface(surfaceTexture));
                    }
                    if (!S2SVideoView.this.mIsFirstCreateTextureView) {
                        LogcatUtil.d("FLSDK-S2SVideoView", "restart");
                        S2SVideoView.this.resumeVideo();
                        return;
                    }
                    S2SVideoView.this.mIsFirstCreateTextureView = false;
                    try {
                        LogcatUtil.d("FLSDK-S2SVideoView", "surfaceFirstCreate");
                        if (S2SVideoView.this.mediaPlayer != null) {
                            LogcatUtil.d("FLSDK-S2SVideoView", "beforePrepare");
                            if (DeviceUtil.filling_timing == 0) {
                                S2SVideoView.this.mediaPlayer.setDataSource(g1.a().a(S2SVideoView.this.mContext, new f1(AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE, S2SVideoView.this.mAdxInfo.t1)));
                                S2SVideoView.this.mediaPlayer.prepareAsync();
                            }
                            LogcatUtil.d("FLSDK-S2SVideoView", "startPrepare");
                        }
                    } catch (Exception e) {
                        LogcatUtil.d("FLSDK-S2SVideoView", "setSourceError" + e.getMessage());
                        e.printStackTrace();
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    if (S2SVideoView.this.mediaPlayer != null) {
                        S2SVideoView.this.mediaPlayer.setSurface(null);
                    }
                    S2SVideoView.this.mIsTextureViewAvailable = false;
                    S2SVideoView.this.pauseVideo();
                    return true;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }
            });
            addView(this.textureView, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEndFrame() {
        RelativeLayout relativeLayout;
        if (this.isDestroyed || (relativeLayout = this.endFrameView) == null || this.tvBtn == null) {
            return;
        }
        relativeLayout.setVisibility(0);
        this.tvBtn.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.adx.base.widget.S2SVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                S2SVideoView.this.mIsVideoCompleted = false;
                S2SVideoView.this.endFrameView.setVisibility(8);
                if (S2SVideoView.this.soundControlImageView != null && !S2SVideoView.this.soundImageGone) {
                    S2SVideoView.this.soundControlImageView.setVisibility(0);
                }
                if (S2SVideoView.this.viewStateChangeListener != null) {
                    S2SVideoView.this.viewStateChangeListener.changeViewVisible(true);
                }
                if (S2SVideoView.this.mediaPlayer != null) {
                    S2SVideoView.this.mediaPlayer.seekTo(0);
                    S2SVideoView.this.mediaPlayer.start();
                }
            }
        });
        ImageView imageView = this.soundControlImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        VideoSoundControlListener.SoundControlViewStateChangeListener soundControlViewStateChangeListener = this.viewStateChangeListener;
        if (soundControlViewStateChangeListener != null) {
            soundControlViewStateChangeListener.changeViewVisible(false);
        }
        ViewHelper.removeParent(this.endFrameView);
        addView(this.endFrameView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideo(boolean z) {
        if (this.isDestroyed) {
            return;
        }
        LogcatUtil.d("FLSDK-S2SVideoView", "startPlayVideo");
        if (checkViewVisible() && this.mIsTextureViewAvailable) {
            changeTextureViewSize(true);
            if (z && (this.mAdxInfo.K0 == 3 || !"1".equals(DeviceUtil.getNetworkType()))) {
                if (this.textView == null) {
                    TextView textView = new TextView(getContext());
                    this.textView = textView;
                    textView.setText("播放");
                    this.textView.setTextSize(12.0f);
                    this.textView.setPadding(DeviceUtil.dip2px(10.0f), DeviceUtil.dip2px(5.0f), DeviceUtil.dip2px(10.0f), DeviceUtil.dip2px(5.0f));
                    this.textView.setBackground(this.mContext.getDrawable(R.drawable.fl_adx_reward_video_adinfo_btn));
                    this.textView.setTypeface(Typeface.DEFAULT_BOLD);
                    this.textView.setTextColor(Color.parseColor("#ffffff"));
                    this.textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.iq7
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f42421a.lambda$startVideo$6(view);
                        }
                    });
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    addView(this.textView, layoutParams);
                    return;
                }
                return;
            }
            if (this.progressBar == null) {
                this.progressBar = new ProgressBar(getContext());
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 17;
                addView(this.progressBar, layoutParams2);
            }
            if (this.mediaPlayer == null || this.mIsCallPlay || !this.mIsVideoPrepared || this.mIsVideoCompleted) {
                return;
            }
            ViewHelper.removeParent(this.progressBar);
            this.mIsCallPlay = true;
            LogcatUtil.d("FLSDK-S2SVideoView", "playVideo");
            C1443x.a().d(this.mAdxInfo, this.mediaPlayer.getDuration());
            int i = this.currentTime;
            if (i > 0) {
                this.mediaPlayer.seekTo(i, 3);
            }
            this.mediaPlayer.start();
            registerSound();
            S2SVideoPlayListener s2SVideoPlayListener = this.mPlayListener;
            if (s2SVideoPlayListener != null) {
                s2SVideoPlayListener.onVideoPlayStart();
            }
            DeviceUtil.postUIDelayed(200L, new Runnable() { // from class: com.zj.adlib.kq7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42888a.lambda$startVideo$7();
                }
            });
            this.mDurationCountdownHandler.removeCallbacksAndMessages(null);
            this.mDurationCountdownHandler.post(new Runnable() { // from class: com.fl.saas.adx.base.widget.S2SVideoView.7
                @Override // java.lang.Runnable
                public void run() {
                    long duration;
                    if (S2SVideoView.this.isDestroyed || S2SVideoView.this.mediaPlayer == null) {
                        S2SVideoView.this.mDurationCountdownHandler.removeCallbacksAndMessages(null);
                        return;
                    }
                    try {
                        if (S2SVideoView.this.mediaPlayer == null || S2SVideoView.this.mediaPlayer.getDuration() == 0) {
                            duration = 0;
                        } else {
                            duration = S2SVideoView.this.mediaPlayer.getDuration() - S2SVideoView.this.mediaPlayer.getCurrentPosition();
                            int currentPosition = (int) ((((double) S2SVideoView.this.mediaPlayer.getCurrentPosition()) / ((double) S2SVideoView.this.mediaPlayer.getDuration())) * 100.0d);
                            if (currentPosition >= 25 && !S2SVideoView.this.mIs25Preent) {
                                S2SVideoView.this.mIs25Preent = true;
                                C1443x.a().i(S2SVideoView.this.mAdxInfo);
                            }
                            if (currentPosition >= 50 && !S2SVideoView.this.mIs50Preent) {
                                S2SVideoView.this.mIs50Preent = true;
                                C1443x.a().n(S2SVideoView.this.mAdxInfo);
                            }
                            if (currentPosition >= 75 && !S2SVideoView.this.mIs75Preent) {
                                S2SVideoView.this.mIs75Preent = true;
                                C1443x.a().m(S2SVideoView.this.mAdxInfo);
                            }
                        }
                        if (duration > 0) {
                            S2SVideoView.this.mDurationCountdownHandler.postDelayed(this, 1000L);
                        } else {
                            S2SVideoView.this.mDurationCountdownHandler.removeCallbacksAndMessages(null);
                        }
                    } catch (Throwable unused) {
                        S2SVideoView.this.mDurationCountdownHandler.removeCallbacksAndMessages(null);
                    }
                }
            });
        }
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.VideoSoundControlListener
    public void changeSoundEnable(boolean z) {
        setSoundEnable(z);
    }

    public long getProgress() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return -1L;
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.VideoSoundControlListener
    public boolean getSoundEnable() {
        return this.mIsSoundEnable;
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    public void onDestroy() {
        if (this.isDestroyed) {
            return;
        }
        this.isDestroyed = true;
        releaseSource();
        releaseMedia();
        try {
            VolumeChangeObserver volumeChangeObserver = this.volumeObserver;
            if (volumeChangeObserver != null) {
                volumeChangeObserver.stop();
                this.volumeObserver = null;
            }
            TextureView textureView = this.textureView;
            if (textureView != null) {
                removeView(textureView);
                this.textureView = null;
            }
            ImageView imageView = this.firstFrameView;
            if (imageView != null) {
                removeView(imageView);
                this.firstFrameView = null;
            }
            RelativeLayout relativeLayout = this.endFrameView;
            if (relativeLayout != null) {
                removeView(relativeLayout);
                this.endFrameView = null;
            }
            ImageView imageView2 = this.soundControlImageView;
            if (imageView2 != null) {
                removeView(imageView2);
                this.soundControlImageView = null;
            }
            TextView textView = this.textView;
            if (textView != null) {
                removeView(textView);
                this.textView = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VolumeChangeObserver volumeChangeObserver = this.volumeObserver;
        if (volumeChangeObserver != null) {
            volumeChangeObserver.stop();
            this.volumeObserver = null;
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        MediaPlayer mediaPlayer;
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            if (this.isDestroyed || (mediaPlayer = this.mediaPlayer) == null || !mediaPlayer.isPlaying()) {
                return;
            }
            pauseVideo();
            return;
        }
        changeTextureViewSize(true);
        if (this.isDestroyed || this.mediaPlayer == null || !this.mIsVideoPrepared) {
            return;
        }
        resumeVideo();
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.VideoSoundControlListener
    public void setSoundControlViewStateChangeListener(VideoSoundControlListener.SoundControlViewStateChangeListener soundControlViewStateChangeListener) {
        this.soundImageGone = true;
        ImageView imageView = this.soundControlImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.viewStateChangeListener = soundControlViewStateChangeListener;
    }

    public void setSoundEnable(boolean z) {
        if (this.isDestroyed) {
            return;
        }
        this.mIsSoundEnable = z;
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        try {
            if (z) {
                mediaPlayer.setVolume(1.0f, 1.0f);
                ImageView imageView = this.soundControlImageView;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.fl_adx_volume_on);
                }
            } else {
                mediaPlayer.setVolume(0.0f, 0.0f);
                ImageView imageView2 = this.soundControlImageView;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.fl_adx_volume_off);
                }
                C1443x.a().k(this.mAdxInfo);
            }
            if (((AudioManager) this.mContext.getSystemService("audio")).getStreamVolume(3) == 0) {
                this.systemMute = true;
                ImageView imageView3 = this.soundControlImageView;
                if (imageView3 != null) {
                    imageView3.setImageResource(R.drawable.fl_adx_volume_off);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSoundSize(int i, int i2, int i3, int i4, int i5, int i6) {
        this.soundWidth = i;
        this.soundHeight = i2;
        this.soundTop = i4;
        this.soundLeft = i3;
        this.soundRight = i5;
        this.soundBottom = i6;
    }

    public void setVideo(final C1415j c1415j) {
        if (this.isDestroyed) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.mIsSoundEnable = c1415j.O0 == 2;
        this.mAdxInfo = c1415j;
        setTextureView();
        ImageView imageView = new ImageView(this.mContext);
        this.soundControlImageView = imageView;
        imageView.setPadding(DeviceUtil.dip2px(this.soundLeft), DeviceUtil.dip2px(this.soundTop), DeviceUtil.dip2px(this.soundRight), DeviceUtil.dip2px(this.soundBottom));
        addView(this.soundControlImageView, new FrameLayout.LayoutParams(DeviceUtil.dip2px(this.soundWidth), DeviceUtil.dip2px(this.soundHeight)));
        this.soundControlImageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.bq7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f40815a.lambda$setVideo$0(view);
            }
        });
        registerSound();
        if (this.mediaPlayer != null) {
            SafeHandler safeHandler = this.mHandler;
            if (safeHandler != null) {
                safeHandler.sendEmptyMessage(11000);
                return;
            }
            return;
        }
        createMediaView();
        if (this.firstFrameView == null) {
            ImageView imageView2 = new ImageView(this.mContext);
            this.firstFrameView = imageView2;
            imageView2.setBackgroundColor(-16777216);
            this.firstFrameView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            addView(this.firstFrameView, layoutParams);
        }
        if (TextUtils.isEmpty(c1415j.p1)) {
            c1.a().b(new Runnable() { // from class: com.zj.adlib.gq7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41969a.lambda$setVideo$2(c1415j);
                }
            });
        } else {
            FLImageLoader.getInstance(this.mContext).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage(this.firstFrameView, c1415j.p1);
        }
        SafeHandler safeHandler2 = this.mHandler;
        if (safeHandler2 != null) {
            safeHandler2.sendEmptyMessageDelayed(11000, 500L);
        }
        String str = !TextUtils.isEmpty(c1415j.x1) ? c1415j.x1 : "";
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(c1415j.p1)) {
            str = c1415j.p1;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.fl_adx_video_view_end_frame, (ViewGroup) null);
        this.endFrameView = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.s2s_video_view_finish_button);
        this.tvBtn = textView;
        textView.setText("重播");
    }

    public void setVideoPlayListener(S2SVideoPlayListener s2SVideoPlayListener) {
        this.mPlayListener = s2SVideoPlayListener;
    }

    public S2SVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hasChangeTextureViewSize = false;
        this.currentTime = -1;
        this.mIsCallPlay = false;
        this.mIsVideoPrepared = false;
        this.mIsVideoCompleted = false;
        this.mIsTextureViewAvailable = false;
        this.mIsFirstCreateTextureView = true;
        this.soundImageGone = false;
        this.mIsSoundEnable = false;
        this.mIs25Preent = false;
        this.mIs50Preent = false;
        this.mIs75Preent = false;
        this.isPlayError = false;
        this.isDestroyed = false;
        this.systemMute = false;
        this.soundWidth = 30;
        this.soundHeight = 30;
        this.soundTop = 5;
        this.soundLeft = 5;
        this.soundRight = 5;
        this.soundBottom = 5;
        this.mContext = context;
        this.mHandler = new SafeHandler(this);
        this.mDurationCountdownHandler = new Handler(Looper.getMainLooper());
        setBackgroundColor(-16777216);
    }

    public S2SVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hasChangeTextureViewSize = false;
        this.currentTime = -1;
        this.mIsCallPlay = false;
        this.mIsVideoPrepared = false;
        this.mIsVideoCompleted = false;
        this.mIsTextureViewAvailable = false;
        this.mIsFirstCreateTextureView = true;
        this.soundImageGone = false;
        this.mIsSoundEnable = false;
        this.mIs25Preent = false;
        this.mIs50Preent = false;
        this.mIs75Preent = false;
        this.isPlayError = false;
        this.isDestroyed = false;
        this.systemMute = false;
        this.soundWidth = 30;
        this.soundHeight = 30;
        this.soundTop = 5;
        this.soundLeft = 5;
        this.soundRight = 5;
        this.soundBottom = 5;
        this.mContext = context;
        this.mHandler = new SafeHandler(this);
        this.mDurationCountdownHandler = new Handler(Looper.getMainLooper());
        setBackgroundColor(-16777216);
    }
}
