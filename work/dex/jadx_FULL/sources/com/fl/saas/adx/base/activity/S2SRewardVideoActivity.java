package com.fl.saas.adx.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.fl.saas.AbstractC1399b;
import com.fl.saas.C1415j;
import com.fl.saas.C1439v;
import com.fl.saas.C1443x;
import com.fl.saas.J;
import com.fl.saas.K;
import com.fl.saas.N0;
import com.fl.saas.R;
import com.fl.saas.adx.base.activity.h5.FLH5Activity;
import com.fl.saas.adx.base.activity.h5.QuickAppHelper;
import com.fl.saas.adx.base.activity.h5.SignUrlWebView;
import com.fl.saas.adx.base.interfaces.VolumeChangeObserver;
import com.fl.saas.adx.base.widget.FLCommonDialog;
import com.fl.saas.adx.base.widget.ShakeView;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.FLImageLoader;
import com.fl.saas.adx.util.LogcatUtil;
import com.fl.saas.adx.util.ViewHelper;
import com.fl.saas.f1;
import com.fl.saas.g1;
import com.kwad.sdk.collector.AppStatusRules;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class S2SRewardVideoActivity extends Activity implements View.OnClickListener {
    private static int currentTime = -1;
    private static N0 manager;
    private int autoClickStartTime;
    private double autoClickTime;
    private boolean canAutoClick;
    private boolean canClickReward;
    private ProgressBar complete_progressBar;
    private int curPosition;
    private FrameLayout fl_media_view;
    private int getRewardTime;
    private boolean hasClick;
    private boolean hasJump;
    private boolean hasRefuseJump;
    private boolean hasReward;
    private LinearLayout ll_countdown;
    private LinearLayout ll_shake;
    private LinearLayout ll_watch_tips;
    private ImageView logoImageView;
    private RelativeLayout mADImgContainerRelativeLayout;
    private C1415j mAdxInfo;
    private TextView mAutoClickCloseView;
    private TextView mAutoClickTimeView;
    private ViewGroup mAutoClickView;
    private ImageView mCloseImageView;
    private TextView mDurationCountdownTextView;
    private ImageView mImageView;
    private LinearLayout mRewardTipsView;
    private TextView mSkipTextView;
    private ImageView mSoundImageView;
    private SurfaceView mSurfaceView;
    private CountDownTimer mTimer;
    private MediaPlayer mediaPlayer;
    private ProgressBar progressDialog;
    private RelativeLayout rl_progress;
    private SignUrlWebView signUrlWebView;
    private FLCommonDialog skipDialog;
    private int skipPosition;
    private TextView tv_has_reward;
    private TextView tv_progress_tips;
    private TextView tv_watch_tips;
    private int videoDuration;
    private VolumeChangeObserver volumeObserver;
    private int watchTime;
    private ShakeView yd_shake_view;
    private boolean isPreviewMode = false;
    private boolean isWatchMode = false;
    private boolean mCanScroll = false;
    private boolean previewCanContinue = true;
    private Handler mDurationCountdownHandler = new Handler();
    private boolean mIsVideoCompleted = false;
    private boolean mIsCurrentPage = false;
    private boolean mIs25Preent = false;
    private boolean mIs50Preent = false;
    private boolean mIs75Preent = false;
    private boolean mIsSoundEnable = true;
    private boolean isVideo = true;
    private boolean mIsVideoPrepared = false;
    private boolean mIsFirstCreateSurfaceView = true;
    private boolean hasCallBackError = false;
    private boolean skipDialogIsShow = false;
    private boolean systemMute = false;
    private boolean isPlaying = true;
    private boolean hasRewardEnd = false;

    /* JADX INFO: renamed from: com.fl.saas.adx.base.activity.S2SRewardVideoActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements SignUrlWebView.WebViewStatus {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onEndScroll$0() {
            if (S2SRewardVideoActivity.this.hasReward) {
                return;
            }
            S2SRewardVideoActivity.this.previewCanContinue = false;
            S2SRewardVideoActivity.this.tv_progress_tips.setText("继续滑动\n得奖励");
        }

        @Override // com.fl.saas.adx.base.activity.h5.SignUrlWebView.WebViewStatus
        public void onEndScroll() {
            if (S2SRewardVideoActivity.this.isPreviewMode && S2SRewardVideoActivity.this.mCanScroll && !S2SRewardVideoActivity.this.hasReward) {
                DeviceUtil.postUIDelayed(500L, new Runnable() { // from class: com.fl.saas.adx.base.activity.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30101a.lambda$onEndScroll$0();
                    }
                });
            }
        }

        @Override // com.fl.saas.adx.base.activity.h5.SignUrlWebView.WebViewStatus
        public void onLoadFailed() {
            S2SRewardVideoActivity.this.isPreviewMode = false;
            if (!S2SRewardVideoActivity.this.isVideo) {
                S2SRewardVideoActivity s2SRewardVideoActivity = S2SRewardVideoActivity.this;
                s2SRewardVideoActivity.getRewardTime = s2SRewardVideoActivity.mAdxInfo.S * 1000;
            }
            S2SRewardVideoActivity.this.previewCanContinue = true;
            S2SRewardVideoActivity.this.fl_media_view.setVisibility(0);
            S2SRewardVideoActivity.this.signUrlWebView.setVisibility(8);
            S2SRewardVideoActivity.this.rl_progress.setVisibility(8);
            S2SRewardVideoActivity.this.ll_countdown.setVisibility(0);
            S2SRewardVideoActivity.this.changeSurfaceViewSize();
        }

        @Override // com.fl.saas.adx.base.activity.h5.SignUrlWebView.WebViewStatus
        public void onLoadSuccess() {
        }

        @Override // com.fl.saas.adx.base.activity.h5.SignUrlWebView.WebViewStatus
        public void onStartScroll() {
            S2SRewardVideoActivity.this.previewCanContinue = true;
        }

        @Override // com.fl.saas.adx.base.activity.h5.SignUrlWebView.WebViewStatus
        public void onTitle(String str) {
        }
    }

    public static /* synthetic */ int access$2812(S2SRewardVideoActivity s2SRewardVideoActivity, int i) {
        int i2 = s2SRewardVideoActivity.curPosition + i;
        s2SRewardVideoActivity.curPosition = i2;
        return i2;
    }

    public static /* synthetic */ int access$4012(S2SRewardVideoActivity s2SRewardVideoActivity, int i) {
        int i2 = s2SRewardVideoActivity.skipPosition + i;
        s2SRewardVideoActivity.skipPosition = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSurfaceViewSize() {
        FrameLayout frameLayout;
        try {
            if (this.mediaPlayer != null && (frameLayout = this.fl_media_view) != null) {
                frameLayout.post(new Runnable() { // from class: com.zj.adlib.sp7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f44745a.lambda$changeSurfaceViewSize$5();
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkReward() {
        N0 n0;
        if (this.hasReward || this.isWatchMode || (n0 = manager) == null) {
            return;
        }
        this.hasReward = true;
        n0.h();
        this.tv_progress_tips.setText("恭喜任务\n已完成");
        this.tv_has_reward.setVisibility(0);
        this.mRewardTipsView.setVisibility(8);
        this.mSkipTextView.setVisibility(8);
        this.mCloseImageView.setVisibility(0);
        this.mDurationCountdownTextView.setVisibility(8);
        this.mAutoClickView.setVisibility(8);
        setDurationCountdown(this.getRewardTime - this.curPosition);
    }

    private void checkShakeView() {
        try {
            C1415j c1415j = this.mAdxInfo;
            if (c1415j != null && c1415j.o() && this.mAdxInfo.g() == 2) {
                this.ll_shake.setVisibility(0);
                this.yd_shake_view.setVisibility(0);
                this.yd_shake_view.setCallback(false);
                this.yd_shake_view.setNeedVibrator(false);
                this.yd_shake_view.setShakeListener(this.mAdxInfo.j(), new ShakeView.ShakeListener() { // from class: com.zj.adlib.np7
                    @Override // com.fl.saas.adx.base.widget.ShakeView.ShakeListener
                    public final void onShake(int i, int i2, int i3) {
                        this.f43583a.lambda$checkShakeView$7(i, i2, i3);
                    }
                });
            } else {
                this.yd_shake_view.setCallback(true);
                this.ll_shake.setVisibility(8);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void finishDelayed() {
        new Handler().postDelayed(new Runnable() { // from class: com.fl.saas.adx.base.activity.S2SRewardVideoActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (S2SRewardVideoActivity.manager != null) {
                    S2SRewardVideoActivity.manager.f();
                }
                S2SRewardVideoActivity.this.finish();
            }
        }, 2000L);
    }

    private void initDatas() {
        int i;
        try {
            N0 n0 = manager;
            if (n0 == null) {
                finishDelayed();
                return;
            }
            C1415j c1415jB = n0.b();
            this.mAdxInfo = c1415jB;
            this.isWatchMode = c1415jB.R == 2 && (!TextUtils.isEmpty(c1415jB.y0) || (this.mAdxInfo.w0.equals("7") && !TextUtils.isEmpty(this.mAdxInfo.B1)));
            C1415j c1415j = this.mAdxInfo;
            this.watchTime = c1415j.W;
            if (!TextUtils.isEmpty(c1415j.x0) && (!TextUtils.isEmpty(this.mAdxInfo.z0) || !TextUtils.isEmpty(this.mAdxInfo.y0))) {
                C1415j c1415j2 = this.mAdxInfo;
                if (c1415j2.q2 == 1) {
                    this.isPreviewMode = true;
                    this.getRewardTime = c1415j2.W * 1000;
                }
            }
            if (this.isPreviewMode) {
                this.ll_countdown.setVisibility(8);
                this.rl_progress.setVisibility(0);
            }
            C1415j c1415j3 = this.mAdxInfo;
            if (c1415j3.V == 1 && c1415j3.W > 0 && "A".equals(c1415j3.X)) {
                this.canAutoClick = true;
                int i2 = this.mAdxInfo.W;
                if (i2 > 5) {
                    this.autoClickTime = 5.0d;
                    this.autoClickStartTime = i2 - 5;
                } else {
                    this.autoClickTime = i2;
                    this.autoClickStartTime = 0;
                }
            }
            C1415j c1415j4 = this.mAdxInfo;
            if (c1415j4.V == 1 && (i = c1415j4.W) > 0) {
                this.getRewardTime = i * 1000;
            }
            if (manager.d()) {
                initVideoView();
                VolumeChangeObserver volumeChangeObserver = new VolumeChangeObserver(this);
                this.volumeObserver = volumeChangeObserver;
                volumeChangeObserver.start(new VolumeChangeObserver.VolumeChangeListener() { // from class: com.zj.adlib.kp7
                    @Override // com.fl.saas.adx.base.interfaces.VolumeChangeObserver.VolumeChangeListener
                    public final void onVolumeChanged(int i3, boolean z) {
                        this.f42880a.lambda$initDatas$1(i3, z);
                    }
                });
            } else {
                manager.a(0, "视频还没有准备好");
                finishDelayed();
            }
            if (this.isWatchMode) {
                this.rl_progress.setVisibility(8);
                this.ll_countdown.setVisibility(8);
                this.ll_watch_tips.setVisibility(0);
                this.tv_watch_tips.setText("点击跳转，浏览满" + this.watchTime + "秒即可领奖");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            finishDelayed();
        }
    }

    private void initVideoView() {
        String str;
        if (manager == null || this.mAdxInfo == null) {
            finishDelayed();
            return;
        }
        this.mADImgContainerRelativeLayout.setVisibility(0);
        checkShakeView();
        this.signUrlWebView.setEnableQuickApp(QuickAppHelper.getInstance().enableQuickApp(this.mAdxInfo.i));
        this.signUrlWebView.setStatusListener(new AnonymousClass1());
        this.mIsSoundEnable = this.mAdxInfo.O0 == 2;
        currentTime = -1;
        C1443x.a().a(this.mAdxInfo, manager.c());
        CountDownTimer countDownTimer = new CountDownTimer(2000L, 2000L) { // from class: com.fl.saas.adx.base.activity.S2SRewardVideoActivity.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (S2SRewardVideoActivity.this.progressDialog == null || S2SRewardVideoActivity.this.progressDialog.getVisibility() != 0) {
                    return;
                }
                if (S2SRewardVideoActivity.this.mCloseImageView != null) {
                    S2SRewardVideoActivity.this.mCloseImageView.setVisibility(0);
                }
                if (S2SRewardVideoActivity.manager != null) {
                    S2SRewardVideoActivity.manager.a(0, "视频资源加载超时");
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        };
        this.mTimer = countDownTimer;
        countDownTimer.start();
        if (TextUtils.isEmpty(this.mAdxInfo.t1)) {
            ProgressBar progressBar = this.progressDialog;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (this.isPreviewMode) {
                this.fl_media_view.setVisibility(8);
                this.signUrlWebView.setVisibility(0);
                this.signUrlWebView.loadUrl(this.mAdxInfo.x0);
            }
            this.isVideo = false;
            if (!this.isPreviewMode) {
                this.getRewardTime = this.mAdxInfo.S * 1000;
            }
            if ("A".equals(this.mAdxInfo.X)) {
                this.canAutoClick = true;
                int i = this.mAdxInfo.S;
                if (i > 5) {
                    this.autoClickTime = 5.0d;
                    this.autoClickStartTime = i - 5;
                } else {
                    this.autoClickTime = i;
                    this.autoClickStartTime = 0;
                }
            }
            if (TextUtils.isEmpty(this.mAdxInfo.p1)) {
                N0 n0 = manager;
                if (n0 != null) {
                    n0.a(0, "视频播放失败(地址为空)");
                }
                this.mCloseImageView.setVisibility(0);
            } else {
                FLImageLoader.getInstance(this).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage(this.mImageView, this.mAdxInfo.p1);
                try {
                    this.mImageView.setVisibility(0);
                    this.mSurfaceView.setVisibility(8);
                    this.mDurationCountdownTextView.setVisibility(8);
                    this.mSoundImageView.setVisibility(8);
                    this.mCloseImageView.setVisibility(8);
                    this.mSkipTextView.setVisibility(8);
                    startDurationCountdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            if (this.isPreviewMode) {
                this.fl_media_view.setVisibility(0);
                this.signUrlWebView.setVisibility(0);
                this.signUrlWebView.loadUrl(this.mAdxInfo.x0);
            }
            this.isVideo = true;
            this.mImageView.setVisibility(8);
            this.mSurfaceView.setVisibility(0);
            final String strA = g1.a().a(this, new f1(AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE, this.mAdxInfo.t1));
            if (this.mediaPlayer == null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.mediaPlayer = mediaPlayer;
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.zj.adlib.op7
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer2) {
                        this.f43803a.lambda$initVideoView$2(mediaPlayer2);
                    }
                });
                this.mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.zj.adlib.pp7
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public final boolean onError(MediaPlayer mediaPlayer2, int i2, int i3) {
                        return this.f44038a.lambda$initVideoView$3(mediaPlayer2, i2, i3);
                    }
                });
                this.mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.zj.adlib.qp7
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer2) {
                        this.f44272a.lambda$initVideoView$4(mediaPlayer2);
                    }
                });
            }
            SurfaceView surfaceView = this.mSurfaceView;
            if (surfaceView != null) {
                surfaceView.setZOrderOnTop(false);
                this.mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.fl.saas.adx.base.activity.S2SRewardVideoActivity.3
                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                        LogcatUtil.d("FLSDK", "surfaceCreated");
                        if (S2SRewardVideoActivity.this.mediaPlayer != null && surfaceHolder != null) {
                            S2SRewardVideoActivity.this.mediaPlayer.setSurface(surfaceHolder.getSurface());
                            S2SRewardVideoActivity.this.mediaPlayer.setDisplay(surfaceHolder);
                        }
                        if (!S2SRewardVideoActivity.this.mIsFirstCreateSurfaceView) {
                            LogcatUtil.d("FLSDK", "restart");
                            S2SRewardVideoActivity.this.resumeVideo();
                            return;
                        }
                        S2SRewardVideoActivity.this.mIsFirstCreateSurfaceView = false;
                        try {
                            LogcatUtil.d("FLSDK", "surfaceFirstCreate");
                            if (S2SRewardVideoActivity.this.mediaPlayer != null) {
                                LogcatUtil.d("FLSDK", "beforePrepare");
                                S2SRewardVideoActivity.this.mediaPlayer.setDataSource(strA);
                                S2SRewardVideoActivity.this.mediaPlayer.prepareAsync();
                                LogcatUtil.d("FLSDK", "startPrepare");
                            }
                        } catch (Exception e2) {
                            LogcatUtil.d("FLSDK", "setSourceError" + e2.getMessage());
                            e2.printStackTrace();
                        }
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                        if (S2SRewardVideoActivity.this.mediaPlayer != null) {
                            S2SRewardVideoActivity.this.mediaPlayer.setSurface(null);
                            S2SRewardVideoActivity.this.mediaPlayer.setDisplay(null);
                        }
                        S2SRewardVideoActivity.this.pauseVideo();
                    }
                });
            }
        }
        this.logoImageView = (ImageView) findViewById(R.id.fl_activity_reward_video_adinfo_logo_imageview);
        TextView textView = (TextView) findViewById(R.id.fl_activity_reward_video_adinfo_title_textview);
        TextView textView2 = (TextView) findViewById(R.id.fl_activity_reward_video_adinfo_desc_textview);
        TextView textView3 = (TextView) findViewById(R.id.fl_activity_reward_video_adinfo_button);
        if (TextUtils.isEmpty(this.mAdxInfo.x1)) {
            str = !TextUtils.isEmpty(this.mAdxInfo.p1) ? this.mAdxInfo.p1 : null;
        } else {
            str = this.mAdxInfo.x1;
        }
        if (TextUtils.isEmpty(str)) {
            this.logoImageView.setVisibility(8);
        } else {
            FLImageLoader.getInstance(this).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage(this.logoImageView, str, new FLImageLoader.OnImageLoadListener() { // from class: com.fl.saas.adx.base.activity.S2SRewardVideoActivity.4
                @Override // com.fl.saas.adx.util.FLImageLoader.OnImageLoadListener
                public void onError(String str2, String str3) {
                }

                @Override // com.fl.saas.adx.util.FLImageLoader.OnImageLoadListener
                public void onSuccess(String str2, Bitmap bitmap, boolean z) {
                    try {
                        if (S2SRewardVideoActivity.this.logoImageView != null) {
                            S2SRewardVideoActivity.this.logoImageView.setVisibility(0);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
        textView.setText(this.mAdxInfo.o0);
        textView2.setText(this.mAdxInfo.s1);
        String str2 = this.mAdxInfo.P0.e;
        if (TextUtils.isEmpty(str2)) {
            str2 = "查看详情";
        }
        textView3.setText(str2);
    }

    private void initViews() {
        try {
            this.tv_has_reward = (TextView) findViewById(R.id.tv_has_reward);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.s2s_activity_progress_bar);
            this.progressDialog = progressBar;
            progressBar.setVisibility(0);
            this.mSurfaceView = (SurfaceView) findViewById(R.id.fl_activity_reward_video_surfaceview);
            this.fl_media_view = (FrameLayout) findViewById(R.id.fl_media_view);
            this.signUrlWebView = (SignUrlWebView) findViewById(R.id.fl_webview);
            this.rl_progress = (RelativeLayout) findViewById(R.id.rl_progress);
            this.complete_progressBar = (ProgressBar) findViewById(R.id.complete_progressBar);
            this.tv_progress_tips = (TextView) findViewById(R.id.tv_progress_tips);
            this.ll_countdown = (LinearLayout) findViewById(R.id.ll_countdown);
            this.ll_watch_tips = (LinearLayout) findViewById(R.id.ll_watch_tips);
            this.tv_watch_tips = (TextView) findViewById(R.id.tv_watch_tips);
            this.mImageView = (ImageView) findViewById(R.id.fl_activity_reward_video_imageview);
            this.mRewardTipsView = (LinearLayout) findViewById(R.id.fl_activity_reward_video_reward_tips);
            this.mAutoClickView = (ViewGroup) findViewById(R.id.fl_activity_reward_video_auto_click);
            this.mAutoClickTimeView = (TextView) findViewById(R.id.fl_activity_reward_video_auto_click_time);
            this.mAutoClickCloseView = (TextView) findViewById(R.id.fl_activity_reward_video_auto_click_close);
            this.mCloseImageView = (ImageView) findViewById(R.id.fl_activity_reward_video_close_imageview);
            this.mSkipTextView = (TextView) findViewById(R.id.fl_activity_reward_video_skip_textview);
            this.mDurationCountdownTextView = (TextView) findViewById(R.id.fl_activity_reward_video_duration_countdown_textview);
            this.mSoundImageView = (ImageView) findViewById(R.id.fl_activity_reward_video_sound);
            this.mADImgContainerRelativeLayout = (RelativeLayout) findViewById(R.id.fl_activity_reward_video_adinfo_container_relativelayout);
            this.ll_shake = (LinearLayout) findViewById(R.id.ll_shake);
            this.yd_shake_view = (ShakeView) findViewById(R.id.yd_shake_view);
            this.mSkipTextView.setOnClickListener(this);
            this.mSoundImageView.setOnClickListener(this);
            this.mCloseImageView.setOnClickListener(this);
            this.mAutoClickCloseView.setOnClickListener(this);
            ViewHelper.onSingleClickListener(this.mADImgContainerRelativeLayout, this);
            ViewHelper.onSingleClickListener(this.mRewardTipsView, this);
            ViewHelper.onSingleClickListener(this.ll_shake, this);
            this.mCloseImageView.setVisibility(8);
            this.mSkipTextView.setVisibility(8);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jump() {
        if (manager != null) {
            if (this.isWatchMode) {
                this.hasClick = true;
                J.b().a(0L);
            }
            this.hasJump = true;
            this.canAutoClick = false;
            this.hasRefuseJump = true;
            C1415j c1415j = this.mAdxInfo;
            c1415j.q1 = AbstractC1399b.a(c1415j);
            C1443x.a().c(this.mAdxInfo);
            C1439v.b().b(this, this.mAdxInfo);
            manager.e();
            if (this.canClickReward) {
                checkReward();
            }
            LinearLayout linearLayout = this.mRewardTipsView;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            ViewGroup viewGroup = this.mAutoClickView;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.ll_shake;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            ShakeView shakeView = this.yd_shake_view;
            if (shakeView != null) {
                shakeView.setCallback(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeSurfaceViewSize$5() {
        int videoWidth = this.mediaPlayer.getVideoWidth();
        int videoHeight = this.mediaPlayer.getVideoHeight();
        int width = this.fl_media_view.getWidth();
        int height = this.fl_media_view.getHeight();
        if (videoWidth <= 0 || videoHeight <= 0 || width <= 0 || height <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mSurfaceView.getLayoutParams();
        int i = height * videoWidth;
        int i2 = width * videoHeight;
        if (i > i2) {
            layoutParams.height = i2 / videoWidth;
        } else {
            layoutParams.width = i / videoHeight;
        }
        this.mSurfaceView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkShakeView$7(int i, int i2, int i3) {
        if (this.skipDialogIsShow) {
            this.yd_shake_view.setCallback(false);
            return;
        }
        try {
            ((Vibrator) getApplicationContext().getSystemService("vibrator")).vibrate(500L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.yd_shake_view.setCallback(true);
        this.ll_shake.setVisibility(8);
        jump();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDatas$0(boolean z) {
        ImageView imageView;
        int i;
        if (z) {
            this.systemMute = true;
            if (!this.mIsSoundEnable || this.mSoundImageView == null) {
                return;
            }
            C1443x.a().k(this.mAdxInfo);
            imageView = this.mSoundImageView;
            i = R.drawable.fl_adx_volume_off;
        } else {
            this.systemMute = false;
            if (!this.mIsSoundEnable || (imageView = this.mSoundImageView) == null) {
                return;
            } else {
                i = R.drawable.fl_adx_volume_on;
            }
        }
        imageView.setImageResource(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDatas$1(int i, final boolean z) {
        runOnUiThread(new Runnable() { // from class: com.zj.adlib.mp7
            @Override // java.lang.Runnable
            public final void run() {
                this.f43358a.lambda$initDatas$0(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVideoView$2(MediaPlayer mediaPlayer) {
        if (this.mIsVideoPrepared) {
            playEnd((this.isPreviewMode || this.isWatchMode) ? 0 : 1);
        }
        this.mSoundImageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initVideoView$3(MediaPlayer mediaPlayer, int i, int i2) {
        ProgressBar progressBar = this.progressDialog;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        N0 n0 = manager;
        if (n0 != null && !this.hasCallBackError) {
            this.hasCallBackError = true;
            n0.a(i, "视频播放失败(" + i2 + ")");
        }
        this.mCloseImageView.setVisibility(0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVideoView$4(MediaPlayer mediaPlayer) {
        this.mIsVideoPrepared = true;
        setSoundEnable(this.mIsSoundEnable);
        if (this.mIsVideoCompleted || currentTime > 0) {
            return;
        }
        startVideo();
        this.mDurationCountdownTextView.setVisibility(8);
        this.mSoundImageView.setVisibility(0);
        this.mCloseImageView.setVisibility(8);
        this.mSkipTextView.setVisibility(8);
        C1443x.a().d(this.mAdxInfo, this.mediaPlayer.getDuration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$6() {
        MediaPlayer mediaPlayer;
        this.skipDialogIsShow = false;
        if (this.isVideo && (mediaPlayer = this.mediaPlayer) != null) {
            mediaPlayer.stop();
        }
        this.mDurationCountdownTextView.setVisibility(8);
        this.mSoundImageView.setVisibility(8);
        this.mCloseImageView.setVisibility(0);
        this.mSkipTextView.setVisibility(8);
        C1443x.a().c(this.mAdxInfo, this.videoDuration);
        N0 n0 = manager;
        if (n0 != null) {
            n0.f();
        }
        finish();
    }

    private void pauseDurationCountdown() {
        Handler handler = this.mDurationCountdownHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            currentTime = mediaPlayer.getCurrentPosition();
            this.mediaPlayer.pause();
            if (this.isPlaying) {
                this.isPlaying = false;
                C1443x.a().l(this.mAdxInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playEnd(int i) {
        try {
            FLCommonDialog fLCommonDialog = this.skipDialog;
            if (fLCommonDialog != null && fLCommonDialog.isShowing()) {
                this.skipDialog.dismiss();
            }
            this.mIsVideoCompleted = true;
            if (i == 1) {
                checkReward();
            }
            C1415j c1415j = this.mAdxInfo;
            c1415j.X1 = this.videoDuration / 1000;
            c1415j.Z1 = this.curPosition / 1000;
            c1415j.c2 = 2;
            c1415j.b2 = i;
            C1443x.a().j(this.mAdxInfo);
            C1443x.a().b(this.mAdxInfo, this.videoDuration);
            if (!this.isWatchMode && !this.isPreviewMode && !this.hasJump && i == 1 && "A".equals(this.mAdxInfo.X) && !this.hasRefuseJump) {
                jump();
            }
            N0 n0 = manager;
            if (n0 != null) {
                n0.g();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeVideo() {
        MediaPlayer mediaPlayer;
        int duration;
        if (this.mIsVideoCompleted && (mediaPlayer = this.mediaPlayer) != null && this.mIsVideoPrepared && (duration = mediaPlayer.getDuration()) > 0) {
            this.mediaPlayer.seekTo(duration);
            this.mediaPlayer.pause();
        }
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 == null || !this.mIsVideoPrepared || this.mIsVideoCompleted) {
            return;
        }
        if (this.skipDialogIsShow) {
            mediaPlayer2.seekTo(currentTime);
            this.mediaPlayer.pause();
            return;
        }
        if (currentTime > 0) {
            mediaPlayer2.seekTo(currentTime, 3);
        }
        changeSurfaceViewSize();
        this.mediaPlayer.start();
        C1415j c1415j = this.mAdxInfo;
        if (c1415j != null) {
            c1415j.d2 = 2;
        }
        if (this.isPlaying) {
            return;
        }
        this.isPlaying = true;
        C1443x.a().h(this.mAdxInfo);
    }

    public static void setAdInfo(N0 n0) {
        manager = n0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationCountdown(long j) {
        int i;
        String str;
        if (j < 0) {
            j = 0;
        }
        int intExact = Math.toIntExact(j / 1000);
        TextView textView = this.mDurationCountdownTextView;
        if (textView != null) {
            if (this.hasReward) {
                textView.setVisibility(8);
            } else {
                if (intExact == 0) {
                    checkReward();
                    textView = this.mDurationCountdownTextView;
                    str = "已获得奖励";
                } else {
                    str = intExact + "秒后获取奖励";
                }
                textView.setText(str);
                this.mDurationCountdownTextView.setVisibility(0);
            }
        }
        if (this.tv_progress_tips != null) {
            if (this.hasReward) {
                this.complete_progressBar.setProgress(100);
                this.tv_progress_tips.setText("恭喜任务\n已完成");
                this.tv_has_reward.setVisibility(0);
                this.mRewardTipsView.setVisibility(8);
                this.mSkipTextView.setVisibility(8);
                this.mCloseImageView.setVisibility(0);
                this.mDurationCountdownTextView.setVisibility(8);
                this.mAutoClickView.setVisibility(8);
            } else if (intExact == 0) {
                this.complete_progressBar.setProgress(100);
            } else {
                if (this.complete_progressBar != null && (i = this.getRewardTime) > 0) {
                    this.complete_progressBar.setProgress(100 - Math.toIntExact((j * 100) / ((long) i)));
                }
                this.tv_progress_tips.setText("滑动浏览\n" + intExact + "S得奖励");
            }
        }
        ImageView imageView = this.mSoundImageView;
        if (imageView != null && this.isVideo && !this.mIsVideoCompleted) {
            imageView.setVisibility(0);
        }
        if (this.isPreviewMode && !this.mCanScroll && this.signUrlWebView.canScroll()) {
            this.mCanScroll = true;
            this.previewCanContinue = false;
            this.tv_progress_tips.setText("继续滑动\n得奖励");
        }
    }

    private void startDurationCountdown() {
        Handler handler = this.mDurationCountdownHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mDurationCountdownHandler.post(new Runnable() { // from class: com.fl.saas.adx.base.activity.S2SRewardVideoActivity.5
                /* JADX WARN: Code duplicated, block: B:129:0x032b  */
                /* JADX WARN: Code duplicated, block: B:154:0x03c4  */
                /* JADX WARN: Code duplicated, block: B:155:0x03ce  */
                /* JADX WARN: Code restructure failed: missing block: B:198:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:75:0x01de, code lost:
                
                    if (r13.this$0.hasReward != false) goto L81;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:80:0x01ef, code lost:
                
                    if (r13.this$0.hasReward != false) goto L81;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:81:0x01f1, code lost:
                
                    r13.this$0.mCloseImageView.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:82:0x01fb, code lost:
                
                    r13.this$0.mSkipTextView.setVisibility(0);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:83:0x0204, code lost:
                
                    return;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    S2SRewardVideoActivity s2SRewardVideoActivity;
                    int i;
                    S2SRewardVideoActivity s2SRewardVideoActivity2;
                    int duration;
                    int currentPosition;
                    if (S2SRewardVideoActivity.this.isPreviewMode) {
                        if (S2SRewardVideoActivity.this.hasReward && (!S2SRewardVideoActivity.this.isVideo || S2SRewardVideoActivity.this.mIsVideoCompleted)) {
                            return;
                        }
                    } else if (S2SRewardVideoActivity.this.mIsVideoCompleted) {
                        return;
                    }
                    if (!S2SRewardVideoActivity.this.mIsCurrentPage) {
                        S2SRewardVideoActivity.this.mDurationCountdownHandler.postDelayed(this, 100L);
                        return;
                    }
                    if (!S2SRewardVideoActivity.this.isWatchMode && !S2SRewardVideoActivity.this.isPreviewMode && S2SRewardVideoActivity.this.canAutoClick && !S2SRewardVideoActivity.this.skipDialogIsShow && !S2SRewardVideoActivity.this.hasRefuseJump && S2SRewardVideoActivity.this.curPosition > S2SRewardVideoActivity.this.autoClickStartTime * 1000) {
                        if (S2SRewardVideoActivity.this.autoClickTime <= 0.5d) {
                            S2SRewardVideoActivity.this.mDurationCountdownTextView.setVisibility(8);
                            S2SRewardVideoActivity.this.mCloseImageView.setVisibility(0);
                            S2SRewardVideoActivity.this.mSkipTextView.setVisibility(8);
                            S2SRewardVideoActivity.this.jump();
                        } else {
                            S2SRewardVideoActivity.this.autoClickTime -= 0.1d;
                            if (S2SRewardVideoActivity.this.mAutoClickView != null) {
                                S2SRewardVideoActivity.this.mAutoClickView.setVisibility(0);
                            }
                            if (S2SRewardVideoActivity.this.mAutoClickTimeView != null) {
                                S2SRewardVideoActivity.this.mAutoClickTimeView.setText(((int) S2SRewardVideoActivity.this.autoClickTime) + "s后自动跳转");
                            }
                        }
                    }
                    if (S2SRewardVideoActivity.this.isVideo) {
                        if (S2SRewardVideoActivity.this.mediaPlayer == null || !S2SRewardVideoActivity.this.mediaPlayer.isPlaying()) {
                            currentPosition = 0;
                        } else {
                            currentPosition = S2SRewardVideoActivity.this.mediaPlayer.getCurrentPosition();
                            S2SRewardVideoActivity s2SRewardVideoActivity3 = S2SRewardVideoActivity.this;
                            s2SRewardVideoActivity3.videoDuration = s2SRewardVideoActivity3.mediaPlayer.getDuration();
                        }
                        if (S2SRewardVideoActivity.this.videoDuration != 0) {
                            int i2 = (int) ((((double) currentPosition) / ((double) S2SRewardVideoActivity.this.videoDuration)) * 100.0d);
                            if (i2 >= 25 && !S2SRewardVideoActivity.this.mIs25Preent) {
                                S2SRewardVideoActivity.this.mIs25Preent = true;
                                C1443x.a().i(S2SRewardVideoActivity.this.mAdxInfo);
                            }
                            if (i2 >= 50 && !S2SRewardVideoActivity.this.mIs50Preent) {
                                S2SRewardVideoActivity.this.mIs50Preent = true;
                                C1443x.a().n(S2SRewardVideoActivity.this.mAdxInfo);
                            }
                            if (i2 >= 75 && !S2SRewardVideoActivity.this.mIs75Preent) {
                                S2SRewardVideoActivity.this.mIs75Preent = true;
                                C1443x.a().m(S2SRewardVideoActivity.this.mAdxInfo);
                            }
                        }
                    }
                    if (S2SRewardVideoActivity.this.previewCanContinue) {
                        if (S2SRewardVideoActivity.this.isVideo) {
                            if (!S2SRewardVideoActivity.this.isPreviewMode) {
                                if (S2SRewardVideoActivity.this.mediaPlayer != null && S2SRewardVideoActivity.this.mediaPlayer.isPlaying()) {
                                    S2SRewardVideoActivity s2SRewardVideoActivity4 = S2SRewardVideoActivity.this;
                                    s2SRewardVideoActivity4.curPosition = s2SRewardVideoActivity4.mediaPlayer.getCurrentPosition();
                                    s2SRewardVideoActivity2 = S2SRewardVideoActivity.this;
                                    duration = s2SRewardVideoActivity2.mediaPlayer.getCurrentPosition();
                                } else if (S2SRewardVideoActivity.this.mediaPlayer != null && S2SRewardVideoActivity.this.mIsVideoCompleted) {
                                    S2SRewardVideoActivity s2SRewardVideoActivity5 = S2SRewardVideoActivity.this;
                                    s2SRewardVideoActivity5.curPosition = s2SRewardVideoActivity5.mediaPlayer.getDuration();
                                    s2SRewardVideoActivity2 = S2SRewardVideoActivity.this;
                                    duration = s2SRewardVideoActivity2.mediaPlayer.getDuration();
                                }
                                s2SRewardVideoActivity2.skipPosition = duration;
                            } else if (!S2SRewardVideoActivity.this.skipDialogIsShow) {
                                S2SRewardVideoActivity.access$2812(S2SRewardVideoActivity.this, 100);
                                S2SRewardVideoActivity.access$4012(S2SRewardVideoActivity.this, 100);
                            }
                        } else if (!S2SRewardVideoActivity.this.skipDialogIsShow) {
                            S2SRewardVideoActivity.access$2812(S2SRewardVideoActivity.this, 100);
                            S2SRewardVideoActivity.access$4012(S2SRewardVideoActivity.this, 100);
                            S2SRewardVideoActivity s2SRewardVideoActivity6 = S2SRewardVideoActivity.this;
                            s2SRewardVideoActivity6.videoDuration = s2SRewardVideoActivity6.mAdxInfo.S * 1000;
                        }
                        if (S2SRewardVideoActivity.this.getRewardTime == 0 || S2SRewardVideoActivity.this.getRewardTime > S2SRewardVideoActivity.this.videoDuration) {
                            if (S2SRewardVideoActivity.this.getRewardTime > S2SRewardVideoActivity.this.videoDuration && S2SRewardVideoActivity.this.mAdxInfo.V == 1 && S2SRewardVideoActivity.this.mAdxInfo.W > 0 && "A".equals(S2SRewardVideoActivity.this.mAdxInfo.X)) {
                                S2SRewardVideoActivity.this.canAutoClick = true;
                                int i3 = S2SRewardVideoActivity.this.videoDuration / 1000;
                                S2SRewardVideoActivity s2SRewardVideoActivity7 = S2SRewardVideoActivity.this;
                                if (i3 > 5) {
                                    s2SRewardVideoActivity7.autoClickTime = 5.0d;
                                    S2SRewardVideoActivity.this.autoClickStartTime = i3 - 5;
                                } else {
                                    s2SRewardVideoActivity7.autoClickTime = i3;
                                    S2SRewardVideoActivity.this.autoClickStartTime = 0;
                                }
                            }
                            if (!S2SRewardVideoActivity.this.isPreviewMode) {
                                s2SRewardVideoActivity = S2SRewardVideoActivity.this;
                                i = s2SRewardVideoActivity.videoDuration;
                                s2SRewardVideoActivity.getRewardTime = i;
                            } else if (S2SRewardVideoActivity.this.getRewardTime == 0) {
                                if (S2SRewardVideoActivity.this.videoDuration != 0) {
                                    s2SRewardVideoActivity = S2SRewardVideoActivity.this;
                                    i = s2SRewardVideoActivity.videoDuration;
                                } else {
                                    s2SRewardVideoActivity = S2SRewardVideoActivity.this;
                                    i = 15000;
                                }
                                s2SRewardVideoActivity.getRewardTime = i;
                            }
                            if (S2SRewardVideoActivity.this.mAdxInfo.V == 2 && "A".equals(S2SRewardVideoActivity.this.mAdxInfo.X)) {
                                S2SRewardVideoActivity.this.canAutoClick = true;
                                int i4 = S2SRewardVideoActivity.this.getRewardTime / 1000;
                                S2SRewardVideoActivity s2SRewardVideoActivity8 = S2SRewardVideoActivity.this;
                                if (i4 > 5) {
                                    s2SRewardVideoActivity8.autoClickTime = 5.0d;
                                    S2SRewardVideoActivity.this.autoClickStartTime = i4 - 5;
                                } else {
                                    s2SRewardVideoActivity8.autoClickTime = i4;
                                    S2SRewardVideoActivity.this.autoClickStartTime = 0;
                                }
                            }
                        }
                        long j = S2SRewardVideoActivity.this.getRewardTime - S2SRewardVideoActivity.this.curPosition;
                        if (S2SRewardVideoActivity.this.mAdxInfo != null && S2SRewardVideoActivity.this.mAdxInfo.T >= 0 && S2SRewardVideoActivity.this.skipPosition >= S2SRewardVideoActivity.this.mAdxInfo.T * 1000) {
                            if (S2SRewardVideoActivity.this.isPreviewMode) {
                                if (S2SRewardVideoActivity.this.hasReward) {
                                    S2SRewardVideoActivity.this.mCloseImageView.setVisibility(0);
                                } else {
                                    S2SRewardVideoActivity.this.mSkipTextView.setVisibility(0);
                                }
                            } else if (!S2SRewardVideoActivity.this.mIsVideoCompleted) {
                                if (S2SRewardVideoActivity.this.hasReward) {
                                    S2SRewardVideoActivity.this.mCloseImageView.setVisibility(0);
                                } else {
                                    S2SRewardVideoActivity.this.mSkipTextView.setVisibility(0);
                                }
                            }
                        }
                        if (S2SRewardVideoActivity.this.isWatchMode) {
                            if (j > 0 || S2SRewardVideoActivity.this.isVideo) {
                                S2SRewardVideoActivity.this.mDurationCountdownHandler.postDelayed(this, 100L);
                                return;
                            }
                            return;
                        }
                        S2SRewardVideoActivity.this.setDurationCountdown(j);
                        if (!S2SRewardVideoActivity.this.isPreviewMode && !S2SRewardVideoActivity.this.canClickReward && S2SRewardVideoActivity.this.mAdxInfo.R == 0 && S2SRewardVideoActivity.this.mAdxInfo.U >= 0 && S2SRewardVideoActivity.this.curPosition > S2SRewardVideoActivity.this.mAdxInfo.U * 1000) {
                            S2SRewardVideoActivity.this.canClickReward = true;
                            if (S2SRewardVideoActivity.this.mRewardTipsView != null) {
                                S2SRewardVideoActivity.this.mRewardTipsView.setVisibility(0);
                            }
                        }
                        if (j <= 0 && !S2SRewardVideoActivity.this.hasRewardEnd) {
                            S2SRewardVideoActivity.this.hasRewardEnd = true;
                            if (S2SRewardVideoActivity.this.mIsCurrentPage) {
                                S2SRewardVideoActivity.this.mDurationCountdownTextView.setVisibility(8);
                                S2SRewardVideoActivity.this.mCloseImageView.setVisibility(0);
                                S2SRewardVideoActivity.this.mSkipTextView.setVisibility(8);
                            }
                            if (S2SRewardVideoActivity.this.isVideo) {
                                S2SRewardVideoActivity.this.checkReward();
                            } else {
                                S2SRewardVideoActivity.this.playEnd(1);
                            }
                        }
                        if (j > 0 || S2SRewardVideoActivity.this.isVideo) {
                            S2SRewardVideoActivity.this.mDurationCountdownHandler.postDelayed(this, 100L);
                            return;
                        }
                        return;
                    }
                    S2SRewardVideoActivity.this.mDurationCountdownHandler.postDelayed(this, 100L);
                    S2SRewardVideoActivity.access$4012(S2SRewardVideoActivity.this, 100);
                    if (S2SRewardVideoActivity.this.mAdxInfo == null || S2SRewardVideoActivity.this.mAdxInfo.T < 0 || S2SRewardVideoActivity.this.skipPosition < S2SRewardVideoActivity.this.mAdxInfo.T * 1000) {
                        return;
                    }
                    if (!S2SRewardVideoActivity.this.isPreviewMode) {
                        if (S2SRewardVideoActivity.this.mIsVideoCompleted) {
                        }
                    }
                }
            });
        }
    }

    private void startVideo() {
        if (this.mediaPlayer != null) {
            changeSurfaceViewSize();
            ProgressBar progressBar = this.progressDialog;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            this.mediaPlayer.start();
            startDurationCountdown();
        }
    }

    public boolean getSoundEnableStatus() {
        return this.mIsSoundEnable;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        C1415j c1415j;
        super.onActivityResult(i, i2, intent);
        if (i != 10001 || i2 != 0 || (c1415j = this.mAdxInfo) == null || TextUtils.isEmpty(c1415j.x0)) {
            return;
        }
        C1415j c1415j2 = this.mAdxInfo;
        c1415j2.h2 = 1;
        c1415j2.i2 = 1;
        C1443x.a().f(this.mAdxInfo);
        C1443x c1443xA = C1443x.a();
        C1415j c1415j3 = this.mAdxInfo;
        FLH5Activity.launchWithEnableQuickApp(this, c1443xA.a(c1415j3.x0, c1415j3), QuickAppHelper.getInstance().enableQuickApp(this.mAdxInfo.i));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MediaPlayer mediaPlayer;
        int id = view.getId();
        if (id == R.id.fl_activity_reward_video_close_imageview) {
            C1443x.a().a(this.mAdxInfo, this.videoDuration);
            N0 n0 = manager;
            if (n0 != null) {
                n0.f();
            }
            finish();
            return;
        }
        if (id == R.id.fl_activity_reward_video_skip_textview) {
            if (!this.hasReward) {
                if (this.skipDialog == null) {
                    this.skipDialog = new FLCommonDialog(this).setContent("此时跳过将不会获得奖励，确认跳过吗？").setCanDismiss(false).setOnCancleListener(new FLCommonDialog.OnCancleListener() { // from class: com.fl.saas.adx.base.activity.S2SRewardVideoActivity.7
                        @Override // com.fl.saas.adx.base.widget.FLCommonDialog.OnCancleListener
                        public void onClick() {
                            S2SRewardVideoActivity.this.skipDialogIsShow = false;
                            S2SRewardVideoActivity.this.resumeVideo();
                        }
                    }).setOnSubmitListener(new FLCommonDialog.OnSubmitListener() { // from class: com.zj.adlib.rp7
                        @Override // com.fl.saas.adx.base.widget.FLCommonDialog.OnSubmitListener
                        public final void onClick() {
                            this.f44506a.lambda$onClick$6();
                        }
                    });
                }
                pauseVideo();
                this.skipDialog.show();
                this.skipDialogIsShow = true;
                return;
            }
            if (this.isVideo && (mediaPlayer = this.mediaPlayer) != null) {
                mediaPlayer.stop();
            }
            this.mDurationCountdownTextView.setVisibility(8);
            this.mCloseImageView.setVisibility(0);
            this.mSkipTextView.setVisibility(8);
            C1443x.a().c(this.mAdxInfo, this.videoDuration);
            playEnd(0);
            return;
        }
        if (id == R.id.fl_activity_reward_video_adinfo_container_relativelayout || id == R.id.ll_shake || id == R.id.fl_activity_reward_video_reward_tips) {
            jump();
            return;
        }
        if (id == R.id.fl_activity_reward_video_sound) {
            if (this.systemMute) {
                return;
            }
            setSoundEnable(!getSoundEnableStatus());
        } else if (id == R.id.fl_activity_reward_video_auto_click_close) {
            ViewGroup viewGroup = this.mAutoClickView;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.canAutoClick = false;
            this.hasRefuseJump = true;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra = 0;
        try {
            K.a(this);
            K.a(this, false);
            intExtra = getIntent().getIntExtra("draw_type", 0);
            if (intExtra == 1) {
                setRequestedOrientation(6);
            } else {
                setRequestedOrientation(7);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onCreate(bundle);
        setContentView(intExtra == 1 ? R.layout.fl_adx_activity_land_reward_video : R.layout.fl_adx_activity_reward_video);
        initViews();
        initDatas();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        VolumeChangeObserver volumeChangeObserver = this.volumeObserver;
        if (volumeChangeObserver != null) {
            volumeChangeObserver.stop();
        }
        this.logoImageView = null;
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(null);
            this.mediaPlayer.setDisplay(null);
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        FLCommonDialog fLCommonDialog = this.skipDialog;
        if (fLCommonDialog != null) {
            if (fLCommonDialog.isShowing()) {
                this.skipDialog.dismiss();
            }
            this.skipDialog = null;
        }
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        pauseDurationCountdown();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        SignUrlWebView signUrlWebView = this.signUrlWebView;
        if (signUrlWebView == null || !signUrlWebView.canGoBack()) {
            return true;
        }
        this.signUrlWebView.goBack();
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIsCurrentPage = false;
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mediaPlayer.pause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsCurrentPage = true;
        if (!this.mIsFirstCreateSurfaceView) {
            resumeVideo();
        }
        if (this.isWatchMode && this.hasClick) {
            int intExact = Math.toIntExact(J.b().a() / 1000);
            J.b().a(0L);
            if (intExact <= 0) {
                Toast.makeText(this, "需在推广应用中浏览满" + this.watchTime + "秒才可获得奖励", 0).show();
                return;
            }
            int i = this.watchTime;
            if (intExact >= i) {
                this.isWatchMode = false;
                this.tv_watch_tips.setText("恭喜任务已完成");
                checkReward();
                return;
            }
            this.watchTime = i - intExact;
            Toast.makeText(this, "再浏览" + this.watchTime + "秒才可获得奖励", 0).show();
            this.tv_watch_tips.setText("点击跳转，再浏览" + this.watchTime + "秒即可领奖");
        }
    }

    public void setSoundEnable(boolean z) {
        ImageView imageView;
        int i;
        this.mIsSoundEnable = z;
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        try {
            if (z) {
                mediaPlayer.setVolume(1.0f, 1.0f);
                imageView = this.mSoundImageView;
                if (imageView != null) {
                    i = R.drawable.fl_adx_volume_on;
                    imageView.setImageResource(i);
                }
            } else {
                mediaPlayer.setVolume(0.0f, 0.0f);
                if (this.mSoundImageView != null) {
                    C1443x.a().k(this.mAdxInfo);
                    imageView = this.mSoundImageView;
                    i = R.drawable.fl_adx_volume_off;
                    imageView.setImageResource(i);
                }
            }
            if (((AudioManager) getSystemService("audio")).getStreamVolume(3) == 0) {
                this.systemMute = true;
                ImageView imageView2 = this.mSoundImageView;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.fl_adx_volume_off);
                }
            }
        } catch (Exception unused) {
        }
    }
}
