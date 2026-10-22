package com.fl.saas.s2s.sdk.ad.video.fullscreen;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.widget.ShakeView;
import com.fl.saas.base.widget.VideoFingerSlidingView;
import com.fl.saas.base.widget.YdCommonDialog;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.YdImmersiveUtils;
import com.fl.saas.common.widget.h5.QuickAppHelper;
import com.fl.saas.common.widget.h5.YdH5Activity;
import com.fl.saas.config.http.HttpCallbackBytesListener;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.R;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CommJumpHelper;
import com.fl.saas.s2s.sdk.helper.CommReportHelper;
import com.fl.saas.s2s.videocache.VideoPreLoadModel;
import com.fl.saas.s2s.videocache.VideoProxyHelper;
import com.kwad.sdk.collector.AppStatusRules;
import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class S2SFullVideoActivity extends Activity implements View.OnClickListener {
    private static int currentTime = -1;
    private static S2SFullVideoADManager manager;
    private int autoClickStartTime;
    private int autoClickTime;
    private boolean canAutoClick;
    private int curPosition;
    private int getRewardTime;
    private boolean hasJump;
    private boolean hasRefuseJump;
    private LinearLayout ll_shake;
    private ImageView logoFinishImageView;
    private ImageView logoImageView;
    private RelativeLayout mADImgContainerRelativeLayout;
    private AdInfoPoJo mAdInfoPoJo;
    private TextView mAutoClickCloseView;
    private TextView mAutoClickTimeView;
    private LinearLayout mAutoClickView;
    private ImageView mCloseImageView;
    private TextView mDurationCountdownTextView;
    private RelativeLayout mFinishContainerRelativeLayout;
    private ImageView mImageView;
    private TextView mSkipTextView;
    private ImageView mSoundImageView;
    private SurfaceView mSurfaceView;
    private CountDownTimer mTimer;
    private MediaPlayer mediaPlayer;
    private ProgressBar progressDialog;
    private YdCommonDialog skipDialog;
    private int videoDuration;
    private ShakeView yd_shake_view;
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
    private boolean hasEndFrame = false;
    private boolean hasChangeSurfaceViewSize = false;

    public static /* synthetic */ int access$2912(S2SFullVideoActivity s2SFullVideoActivity, int i) {
        int i2 = s2SFullVideoActivity.curPosition + i;
        s2SFullVideoActivity.curPosition = i2;
        return i2;
    }

    public static /* synthetic */ int access$3410(S2SFullVideoActivity s2SFullVideoActivity) {
        int i = s2SFullVideoActivity.autoClickTime;
        s2SFullVideoActivity.autoClickTime = i - 1;
        return i;
    }

    private void changeSurfaceViewSize() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null && !this.hasChangeSurfaceViewSize) {
                int videoWidth = mediaPlayer.getVideoWidth();
                int videoHeight = this.mediaPlayer.getVideoHeight();
                int mobileWidth = DeviceUtil.getMobileWidth();
                int mobileHeight = DeviceUtil.getMobileHeight();
                if (videoWidth <= 0 || videoHeight <= 0 || mobileWidth <= 0 || mobileHeight <= 0) {
                    return;
                }
                this.hasChangeSurfaceViewSize = true;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mSurfaceView.getLayoutParams();
                int i = mobileHeight * videoWidth;
                int i2 = mobileWidth * videoHeight;
                if (i > i2) {
                    layoutParams.height = i2 / videoWidth;
                } else {
                    layoutParams.width = i / videoHeight;
                }
                this.mSurfaceView.setLayoutParams(layoutParams);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkShakeView() {
        try {
            AdInfoPoJo adInfoPoJo = this.mAdInfoPoJo;
            if (adInfoPoJo != null && adInfoPoJo.isHotArea() && this.mAdInfoPoJo.getHotType() == 2) {
                this.ll_shake.setVisibility(0);
                this.yd_shake_view.setVisibility(0);
                this.yd_shake_view.setCallback(false);
                this.yd_shake_view.setShakeListener(this.mAdInfoPoJo.getShakeSpeed(), new ShakeView.ShakeListener() { // from class: com.zj.adlib.uo7
                    @Override // com.fl.saas.base.widget.ShakeView.ShakeListener
                    public final void onShake(int i, int i2, int i3) {
                        this.f45194a.lambda$checkShakeView$0(i, i2, i3);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSlideView() {
        AdInfoPoJo adInfoPoJo;
        if (this.mADImgContainerRelativeLayout == null || (adInfoPoJo = this.mAdInfoPoJo) == null || !adInfoPoJo.isHotArea() || this.mAdInfoPoJo.getHotType() != 5) {
            return;
        }
        final VideoFingerSlidingView videoFingerSlidingView = new VideoFingerSlidingView(this);
        videoFingerSlidingView.setSlidingListener(this.mAdInfoPoJo.getShakeSpeed(), new VideoFingerSlidingView.SlidingListener() { // from class: com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoActivity.8
            @Override // com.fl.saas.base.widget.VideoFingerSlidingView.SlidingListener
            public void onSliding() {
                S2SFullVideoActivity.this.jump();
                ViewHelper.removeParent(videoFingerSlidingView);
            }
        });
        videoFingerSlidingView.createView();
        this.mADImgContainerRelativeLayout.addView(videoFingerSlidingView, ViewHelper.getMatchParent());
    }

    private void finishDelayed() {
        new Handler().postDelayed(new Runnable() { // from class: com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoActivity.10
            @Override // java.lang.Runnable
            public void run() {
                S2SFullVideoActivity.this.finish();
            }
        }, 2000L);
    }

    private void initDatas() {
        int i;
        try {
            S2SFullVideoADManager s2SFullVideoADManager = manager;
            if (s2SFullVideoADManager == null) {
                return;
            }
            AdInfoPoJo adInfoPoJo = s2SFullVideoADManager.getAdInfoPoJo();
            this.mAdInfoPoJo = adInfoPoJo;
            if (adInfoPoJo.rd_auto_type == 1 && adInfoPoJo.rd_auto_time > 0 && "A".equals(adInfoPoJo.rd_autoskip_sts)) {
                this.canAutoClick = true;
                int i2 = this.mAdInfoPoJo.rd_auto_time;
                if (i2 > 5) {
                    this.autoClickTime = 5;
                    this.autoClickStartTime = i2 - 5;
                } else {
                    this.autoClickTime = i2;
                    this.autoClickStartTime = 0;
                }
            }
            AdInfoPoJo adInfoPoJo2 = this.mAdInfoPoJo;
            if (adInfoPoJo2.rd_auto_type == 1 && (i = adInfoPoJo2.rd_auto_time) > 0) {
                this.getRewardTime = i * 1000;
            }
            if (manager.isReady()) {
                initVideoView();
            } else {
                manager.onError(0, "视频还没有准备好");
                finishDelayed();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void initVideoView() {
        String str;
        if (manager == null || this.mAdInfoPoJo == null) {
            return;
        }
        this.mIsSoundEnable = ConfigHelper.getInstance().getVideoSoundEnable(this.mAdInfoPoJo.place_id);
        currentTime = -1;
        CommReportHelper.getInstance().reportDisplay(this.mAdInfoPoJo, manager.isCache());
        this.mADImgContainerRelativeLayout.setVisibility(8);
        this.mFinishContainerRelativeLayout.setVisibility(8);
        CountDownTimer countDownTimer = new CountDownTimer(5000L, 5000L) { // from class: com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoActivity.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (S2SFullVideoActivity.this.progressDialog == null || S2SFullVideoActivity.this.progressDialog.getVisibility() != 0) {
                    return;
                }
                S2SFullVideoActivity.this.progressDialog.setVisibility(4);
                if (S2SFullVideoActivity.this.mCloseImageView != null) {
                    S2SFullVideoActivity.this.mCloseImageView.setVisibility(0);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        };
        this.mTimer = countDownTimer;
        countDownTimer.start();
        if (TextUtils.isEmpty(this.mAdInfoPoJo.video_url)) {
            this.isVideo = false;
            AdInfoPoJo adInfoPoJo = this.mAdInfoPoJo;
            this.getRewardTime = adInfoPoJo.rd_countdown * 1000;
            if (adInfoPoJo.rd_auto_type == 2 && "A".equals(adInfoPoJo.rd_autoskip_sts)) {
                this.canAutoClick = true;
                int i = this.mAdInfoPoJo.rd_countdown;
                if (i > 5) {
                    this.autoClickTime = 5;
                    this.autoClickStartTime = i - 5;
                } else {
                    this.autoClickTime = i;
                    this.autoClickStartTime = 0;
                }
            }
            if (!TextUtils.isEmpty(this.mAdInfoPoJo.img_url)) {
                AdHttpUtils.getInstance().doGet(this.mAdInfoPoJo.img_url, new HttpCallbackBytesListener() { // from class: com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoActivity.6
                    @Override // com.fl.saas.config.http.HttpCallbackBytesListener
                    public void onError(Exception exc) {
                        if (S2SFullVideoActivity.manager != null) {
                            S2SFullVideoActivity.manager.onError(0, "视频播放失败(" + exc.getMessage() + ")");
                        }
                        S2SFullVideoActivity.this.mCloseImageView.setVisibility(0);
                    }

                    @Override // com.fl.saas.config.http.HttpCallbackBytesListener
                    public void onSuccess(byte[] bArr) {
                        try {
                            S2SFullVideoActivity.this.mImageView.setImageBitmap(BitmapFactory.decodeStream(new ByteArrayInputStream(bArr)));
                            S2SFullVideoActivity.this.mImageView.setVisibility(0);
                            S2SFullVideoActivity.this.mSurfaceView.setVisibility(8);
                            S2SFullVideoActivity.this.mDurationCountdownTextView.setVisibility(8);
                            S2SFullVideoActivity.this.mSoundImageView.setVisibility(8);
                            S2SFullVideoActivity.this.mCloseImageView.setVisibility(8);
                            S2SFullVideoActivity.this.mSkipTextView.setVisibility(8);
                            S2SFullVideoActivity.this.mADImgContainerRelativeLayout.setVisibility(0);
                            S2SFullVideoActivity.this.checkShakeView();
                            S2SFullVideoActivity.this.checkSlideView();
                            S2SFullVideoActivity.this.mFinishContainerRelativeLayout.setVisibility(8);
                            if (S2SFullVideoActivity.this.progressDialog != null) {
                                S2SFullVideoActivity.this.progressDialog.setVisibility(4);
                            }
                            S2SFullVideoActivity.this.startDurationCountdown();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } else {
            this.isVideo = true;
            this.mImageView.setVisibility(8);
            this.mSurfaceView.setVisibility(0);
            final String proxyUrl = VideoProxyHelper.getInstance().getProxyUrl(this, new VideoPreLoadModel(AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE, this.mAdInfoPoJo.video_url));
            if (this.mediaPlayer == null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.mediaPlayer = mediaPlayer;
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoActivity.2
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer2) {
                        if (S2SFullVideoActivity.this.mIsVideoPrepared) {
                            S2SFullVideoActivity.this.playEnd(1);
                        }
                    }
                });
                this.mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoActivity.3
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer2, int i2, int i3) {
                        if (S2SFullVideoActivity.manager != null && !S2SFullVideoActivity.this.hasCallBackError) {
                            S2SFullVideoActivity.this.hasCallBackError = true;
                            S2SFullVideoActivity.manager.onError(i2, "视频播放失败(" + i3 + ")");
                        }
                        S2SFullVideoActivity.this.mCloseImageView.setVisibility(0);
                        return false;
                    }
                });
                this.mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoActivity.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer2) {
                        S2SFullVideoActivity.this.mIsVideoPrepared = true;
                        S2SFullVideoActivity s2SFullVideoActivity = S2SFullVideoActivity.this;
                        s2SFullVideoActivity.setSoundEnable(s2SFullVideoActivity.mIsSoundEnable);
                        if (S2SFullVideoActivity.this.mIsVideoCompleted || S2SFullVideoActivity.currentTime > 0) {
                            return;
                        }
                        S2SFullVideoActivity.this.startVideo();
                        S2SFullVideoActivity.this.mDurationCountdownTextView.setVisibility(8);
                        S2SFullVideoActivity.this.mSoundImageView.setVisibility(8);
                        S2SFullVideoActivity.this.mCloseImageView.setVisibility(8);
                        S2SFullVideoActivity.this.mSkipTextView.setVisibility(8);
                        S2SFullVideoActivity.this.mADImgContainerRelativeLayout.setVisibility(0);
                        S2SFullVideoActivity.this.mFinishContainerRelativeLayout.setVisibility(8);
                        S2SFullVideoActivity.this.checkShakeView();
                        S2SFullVideoActivity.this.checkSlideView();
                        CommReportHelper.getInstance().reportVideoStart(S2SFullVideoActivity.this.mAdInfoPoJo, S2SFullVideoActivity.this.mediaPlayer.getDuration());
                    }
                });
            }
            SurfaceView surfaceView = this.mSurfaceView;
            if (surfaceView != null) {
                surfaceView.setZOrderOnTop(false);
                this.mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoActivity.5
                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                        LogcatUtil.d("YdSDK-S2SVideoView", "surfaceCreated");
                        if (S2SFullVideoActivity.this.mediaPlayer != null) {
                            S2SFullVideoActivity.this.mediaPlayer.setDisplay(surfaceHolder);
                        }
                        if (!S2SFullVideoActivity.this.mIsFirstCreateSurfaceView) {
                            LogcatUtil.d("YdSDK-S2SVideoView", "restart");
                            if (S2SFullVideoActivity.this.mediaPlayer == null || !S2SFullVideoActivity.this.mIsVideoPrepared || S2SFullVideoActivity.this.mIsVideoCompleted) {
                                return;
                            }
                            if (S2SFullVideoActivity.currentTime > 0) {
                                S2SFullVideoActivity.this.mediaPlayer.seekTo(S2SFullVideoActivity.currentTime, 3);
                            }
                            S2SFullVideoActivity.this.mediaPlayer.start();
                            return;
                        }
                        S2SFullVideoActivity.this.mIsFirstCreateSurfaceView = false;
                        try {
                            LogcatUtil.d("YdSDK-S2SVideoView", "surfaceFirstCreate");
                            if (S2SFullVideoActivity.this.mediaPlayer != null) {
                                LogcatUtil.d("YdSDK-S2SVideoView", "beforePrepare");
                                S2SFullVideoActivity.this.mediaPlayer.setDataSource(proxyUrl);
                                S2SFullVideoActivity.this.mediaPlayer.prepareAsync();
                                LogcatUtil.d("YdSDK-S2SVideoView", "startPrepare");
                            }
                        } catch (Exception e) {
                            LogcatUtil.d("YdSDK-S2SVideoView", "setSourceError" + e.getMessage());
                            e.printStackTrace();
                        }
                    }

                    @Override // android.view.SurfaceHolder.Callback
                    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                        if (S2SFullVideoActivity.this.mediaPlayer == null || !S2SFullVideoActivity.this.mediaPlayer.isPlaying()) {
                            return;
                        }
                        int unused = S2SFullVideoActivity.currentTime = S2SFullVideoActivity.this.mediaPlayer.getCurrentPosition();
                        S2SFullVideoActivity.this.mediaPlayer.pause();
                    }
                });
            }
        }
        this.logoImageView = (ImageView) findViewById(R.id.s2s_activity_reward_video_adinfo_logo_imageview);
        TextView textView = (TextView) findViewById(R.id.s2s_activity_reward_video_adinfo_title_textview);
        TextView textView2 = (TextView) findViewById(R.id.s2s_activity_reward_video_adinfo_desc_textview);
        TextView textView3 = (TextView) findViewById(R.id.s2s_activity_reward_video_adinfo_button);
        this.logoFinishImageView = (ImageView) findViewById(R.id.s2s_activity_reward_video_finish_logo_imageview);
        TextView textView4 = (TextView) findViewById(R.id.s2s_activity_reward_video_finish_title_textview);
        TextView textView5 = (TextView) findViewById(R.id.s2s_activity_reward_video_finish_desc_textview);
        TextView textView6 = (TextView) findViewById(R.id.s2s_activity_reward_video_finish_button);
        ImageView imageView = (ImageView) findViewById(R.id.s2s_activity_reward_video_finish_close_imageview);
        if (TextUtils.isEmpty(this.mAdInfoPoJo.logo_icon)) {
            str = !TextUtils.isEmpty(this.mAdInfoPoJo.img_url) ? this.mAdInfoPoJo.img_url : null;
        } else {
            str = this.mAdInfoPoJo.logo_icon;
        }
        if (TextUtils.isEmpty(str)) {
            this.logoImageView.setVisibility(8);
            this.logoFinishImageView.setVisibility(8);
        } else {
            AdHttpUtils.getInstance().doGet(str, new HttpCallbackBytesListener() { // from class: com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoActivity.7
                @Override // com.fl.saas.config.http.HttpCallbackBytesListener
                public void onError(Exception exc) {
                }

                @Override // com.fl.saas.config.http.HttpCallbackBytesListener
                public void onSuccess(byte[] bArr) {
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(bArr));
                        if (S2SFullVideoActivity.this.logoImageView != null) {
                            S2SFullVideoActivity.this.logoImageView.setVisibility(0);
                            S2SFullVideoActivity.this.logoImageView.setImageBitmap(bitmapDecodeStream);
                        }
                        if (S2SFullVideoActivity.this.logoFinishImageView != null) {
                            S2SFullVideoActivity.this.logoFinishImageView.setVisibility(0);
                            S2SFullVideoActivity.this.logoFinishImageView.setImageBitmap(bitmapDecodeStream);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        textView.setText(this.mAdInfoPoJo.title);
        textView4.setText(this.mAdInfoPoJo.title);
        textView2.setText(this.mAdInfoPoJo.description);
        textView5.setText(this.mAdInfoPoJo.description);
        String str2 = this.mAdInfoPoJo.creative.button;
        if (TextUtils.isEmpty(str2)) {
            str2 = "查看详情";
        }
        textView3.setText(str2);
        textView6.setText(str2);
        ViewHelper.onSingleClickListener(textView6, this);
        imageView.setOnClickListener(this);
    }

    private void initViews() {
        try {
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.s2s_activity_progress_bar);
            this.progressDialog = progressBar;
            progressBar.setVisibility(0);
            this.mSurfaceView = (SurfaceView) findViewById(R.id.s2s_activity_reward_video_surfaceview);
            this.mImageView = (ImageView) findViewById(R.id.s2s_activity_reward_video_imageview);
            this.mAutoClickView = (LinearLayout) findViewById(R.id.s2s_activity_reward_video_auto_click);
            this.mAutoClickTimeView = (TextView) findViewById(R.id.s2s_activity_reward_video_auto_click_time);
            this.mAutoClickCloseView = (TextView) findViewById(R.id.s2s_activity_reward_video_auto_click_close);
            this.mCloseImageView = (ImageView) findViewById(R.id.s2s_activity_reward_video_close_imageview);
            this.mSkipTextView = (TextView) findViewById(R.id.s2s_activity_reward_video_skip_textview);
            this.mDurationCountdownTextView = (TextView) findViewById(R.id.s2s_activity_reward_video_duration_countdown_textview);
            this.mSoundImageView = (ImageView) findViewById(R.id.s2s_activity_reward_video_sound);
            this.mADImgContainerRelativeLayout = (RelativeLayout) findViewById(R.id.s2s_activity_reward_video_adinfo_container_relativelayout);
            this.mFinishContainerRelativeLayout = (RelativeLayout) findViewById(R.id.s2s_activity_reward_video_finish_container_relativelayout);
            this.ll_shake = (LinearLayout) findViewById(R.id.ll_shake);
            this.yd_shake_view = (ShakeView) findViewById(R.id.yd_shake_view);
            this.mSkipTextView.setOnClickListener(this);
            this.mSoundImageView.setOnClickListener(this);
            this.mCloseImageView.setOnClickListener(this);
            this.mAutoClickCloseView.setOnClickListener(this);
            ViewHelper.onSingleClickListener(this.mADImgContainerRelativeLayout, this);
            ViewHelper.onSingleClickListener(this.mFinishContainerRelativeLayout, this);
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
            this.hasJump = true;
            this.canAutoClick = false;
            this.hasRefuseJump = true;
            CommReportHelper.getInstance().reportClick(this.mAdInfoPoJo);
            CommJumpHelper.getInstance().jump(this, this.mAdInfoPoJo, manager.getAdSource());
            manager.onClick();
            LinearLayout linearLayout = this.mAutoClickView;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.ll_shake;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkShakeView$0(int i, int i2, int i3) {
        this.ll_shake.setVisibility(8);
        jump();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$1() {
        MediaPlayer mediaPlayer;
        if (this.isVideo && (mediaPlayer = this.mediaPlayer) != null) {
            mediaPlayer.stop();
        }
        this.mDurationCountdownTextView.setVisibility(8);
        this.mSoundImageView.setVisibility(8);
        this.mCloseImageView.setVisibility(0);
        this.mSkipTextView.setVisibility(8);
        CommReportHelper.getInstance().reportVideoSkip(this.mAdInfoPoJo, this.videoDuration);
        if (this.hasEndFrame) {
            playEnd(0);
        } else {
            finish();
        }
    }

    private void pauseDurationCountdown() {
        Handler handler = this.mDurationCountdownHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playEnd(int i) {
        try {
            YdCommonDialog ydCommonDialog = this.skipDialog;
            if (ydCommonDialog != null && ydCommonDialog.isShowing()) {
                this.skipDialog.dismiss();
            }
            this.mCloseImageView.setVisibility(0);
            this.mSkipTextView.setVisibility(8);
            if (this.hasEndFrame) {
                this.mFinishContainerRelativeLayout.setVisibility(0);
                this.mADImgContainerRelativeLayout.setVisibility(8);
                this.mAutoClickView.setVisibility(8);
            }
            this.mIsVideoCompleted = true;
            CommReportHelper.getInstance().reportVideoEnd(this.mAdInfoPoJo, this.videoDuration);
            AdInfoPoJo adInfoPoJo = this.mAdInfoPoJo;
            adInfoPoJo.VIDEO_TIME = this.videoDuration / 1000;
            adInfoPoJo.END_TIME = this.curPosition / 1000;
            adInfoPoJo.SCENE = 2;
            adInfoPoJo.PLAY_LAST_FRAME = i;
            CommReportHelper.getInstance().reportVideoInfo(this.mAdInfoPoJo);
            if (!this.hasJump && i == 1 && "A".equals(this.mAdInfoPoJo.rd_autoskip_sts) && !this.hasRefuseJump) {
                jump();
            }
            S2SFullVideoADManager s2SFullVideoADManager = manager;
            if (s2SFullVideoADManager != null) {
                s2SFullVideoADManager.onComplete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setAdInfo(S2SFullVideoADManager s2SFullVideoADManager) {
        manager = s2SFullVideoADManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationCountdown(long j) {
        if (j < 0) {
            j = 0;
        }
        TextView textView = this.mDurationCountdownTextView;
        if (textView != null) {
            textView.setText((j / 1000) + "");
            this.mDurationCountdownTextView.setVisibility(0);
        }
        ImageView imageView = this.mSoundImageView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDurationCountdown() {
        Handler handler = this.mDurationCountdownHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mDurationCountdownHandler.post(new Runnable() { // from class: com.fl.saas.s2s.sdk.ad.video.fullscreen.S2SFullVideoActivity.9
                /* JADX WARN: Code duplicated, block: B:26:0x008e  */
                /* JADX WARN: Code duplicated, block: B:27:0x00b8  */
                /* JADX WARN: Code duplicated, block: B:29:0x00c5  */
                /* JADX WARN: Code duplicated, block: B:32:0x00d6  */
                /* JADX WARN: Code duplicated, block: B:35:0x00ff  */
                /* JADX WARN: Code duplicated, block: B:41:0x0132  */
                /* JADX WARN: Code duplicated, block: B:42:0x013e  */
                /* JADX WARN: Code duplicated, block: B:45:0x0163  */
                /* JADX WARN: Code duplicated, block: B:71:0x020a  */
                /* JADX WARN: Code duplicated, block: B:72:0x0214  */
                /* JADX WARN: Code duplicated, block: B:74:0x021c  */
                /* JADX WARN: Code duplicated, block: B:77:0x0248  */
                /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Instruction removed from duplicated block: B:32:0x00d6, please report this as an issue */
                @Override // java.lang.Runnable
                public void run() {
                    S2SFullVideoActivity s2SFullVideoActivity;
                    int duration;
                    long j;
                    int i;
                    int i2;
                    if (S2SFullVideoActivity.this.mIsVideoCompleted) {
                        return;
                    }
                    if (!S2SFullVideoActivity.this.mIsCurrentPage) {
                        S2SFullVideoActivity.this.mDurationCountdownHandler.postDelayed(this, 1000L);
                        return;
                    }
                    if (S2SFullVideoActivity.this.isVideo) {
                        if (S2SFullVideoActivity.this.mediaPlayer != null && S2SFullVideoActivity.this.mediaPlayer.isPlaying()) {
                            S2SFullVideoActivity s2SFullVideoActivity2 = S2SFullVideoActivity.this;
                            s2SFullVideoActivity2.curPosition = s2SFullVideoActivity2.mediaPlayer.getCurrentPosition();
                            s2SFullVideoActivity = S2SFullVideoActivity.this;
                            duration = s2SFullVideoActivity.mediaPlayer.getDuration();
                        }
                        if (S2SFullVideoActivity.this.canAutoClick && !S2SFullVideoActivity.this.hasRefuseJump && S2SFullVideoActivity.this.curPosition > S2SFullVideoActivity.this.autoClickStartTime * 1000) {
                            if (S2SFullVideoActivity.this.autoClickTime <= 0) {
                                S2SFullVideoActivity.this.mDurationCountdownTextView.setVisibility(8);
                                S2SFullVideoActivity.this.mSoundImageView.setVisibility(8);
                                S2SFullVideoActivity.this.mCloseImageView.setVisibility(0);
                                S2SFullVideoActivity.this.mSkipTextView.setVisibility(8);
                                S2SFullVideoActivity.this.jump();
                            } else {
                                S2SFullVideoActivity.access$3410(S2SFullVideoActivity.this);
                                if (S2SFullVideoActivity.this.mAutoClickView != null) {
                                    S2SFullVideoActivity.this.mAutoClickView.setVisibility(0);
                                }
                                if (S2SFullVideoActivity.this.mAutoClickTimeView != null) {
                                    S2SFullVideoActivity.this.mAutoClickTimeView.setText("" + S2SFullVideoActivity.this.autoClickTime);
                                }
                            }
                        }
                        if (S2SFullVideoActivity.this.getRewardTime == 0) {
                            S2SFullVideoActivity s2SFullVideoActivity3 = S2SFullVideoActivity.this;
                            s2SFullVideoActivity3.getRewardTime = s2SFullVideoActivity3.videoDuration;
                            if (S2SFullVideoActivity.this.mAdInfoPoJo.rd_auto_type == 2 && "A".equals(S2SFullVideoActivity.this.mAdInfoPoJo.rd_autoskip_sts)) {
                                S2SFullVideoActivity.this.canAutoClick = true;
                                i2 = S2SFullVideoActivity.this.getRewardTime / 1000;
                                if (i2 > 5) {
                                    S2SFullVideoActivity.this.autoClickTime = 5;
                                    S2SFullVideoActivity.this.autoClickStartTime = i2 - 5;
                                } else {
                                    S2SFullVideoActivity.this.autoClickTime = i2;
                                    S2SFullVideoActivity.this.autoClickStartTime = 0;
                                }
                            }
                        }
                        j = S2SFullVideoActivity.this.getRewardTime - S2SFullVideoActivity.this.curPosition;
                        S2SFullVideoActivity.this.setDurationCountdown(j);
                        if (S2SFullVideoActivity.this.videoDuration != 0) {
                            i = (int) ((((double) S2SFullVideoActivity.this.curPosition) / ((double) S2SFullVideoActivity.this.videoDuration)) * 100.0d);
                            if (i >= 25 && !S2SFullVideoActivity.this.mIs25Preent) {
                                S2SFullVideoActivity.this.mIs25Preent = true;
                                CommReportHelper.getInstance().reportVideoFirst(S2SFullVideoActivity.this.mAdInfoPoJo);
                            }
                            if (i >= 50 && !S2SFullVideoActivity.this.mIs50Preent) {
                                S2SFullVideoActivity.this.mIs50Preent = true;
                                CommReportHelper.getInstance().reportVideomMidpoint(S2SFullVideoActivity.this.mAdInfoPoJo);
                            }
                            if (i >= 75 && !S2SFullVideoActivity.this.mIs75Preent) {
                                S2SFullVideoActivity.this.mIs75Preent = true;
                                CommReportHelper.getInstance().reportVideoThird(S2SFullVideoActivity.this.mAdInfoPoJo);
                            }
                        }
                        if (S2SFullVideoActivity.this.mAdInfoPoJo != null && S2SFullVideoActivity.this.mAdInfoPoJo.rd_skip_time >= 0 && S2SFullVideoActivity.this.curPosition > S2SFullVideoActivity.this.mAdInfoPoJo.rd_skip_time * 1000 && !S2SFullVideoActivity.this.mIsVideoCompleted) {
                            S2SFullVideoActivity.this.mSkipTextView.setVisibility(0);
                        }
                        if (j > 0) {
                            S2SFullVideoActivity.this.mDurationCountdownHandler.postDelayed(this, 1000L);
                            return;
                        }
                        if (S2SFullVideoActivity.this.mIsCurrentPage) {
                            S2SFullVideoActivity.this.mDurationCountdownTextView.setVisibility(8);
                            S2SFullVideoActivity.this.mSoundImageView.setVisibility(8);
                            S2SFullVideoActivity.this.mCloseImageView.setVisibility(0);
                            S2SFullVideoActivity.this.mSkipTextView.setVisibility(8);
                        }
                        if (S2SFullVideoActivity.this.isVideo) {
                        }
                        S2SFullVideoActivity.this.playEnd(1);
                    }
                    S2SFullVideoActivity.access$2912(S2SFullVideoActivity.this, 1000);
                    s2SFullVideoActivity = S2SFullVideoActivity.this;
                    duration = s2SFullVideoActivity.mAdInfoPoJo.rd_countdown * 1000;
                    s2SFullVideoActivity.videoDuration = duration;
                    if (S2SFullVideoActivity.this.canAutoClick) {
                        if (S2SFullVideoActivity.this.autoClickTime <= 0) {
                            S2SFullVideoActivity.this.mDurationCountdownTextView.setVisibility(8);
                            S2SFullVideoActivity.this.mSoundImageView.setVisibility(8);
                            S2SFullVideoActivity.this.mCloseImageView.setVisibility(0);
                            S2SFullVideoActivity.this.mSkipTextView.setVisibility(8);
                            S2SFullVideoActivity.this.jump();
                        } else {
                            S2SFullVideoActivity.access$3410(S2SFullVideoActivity.this);
                            if (S2SFullVideoActivity.this.mAutoClickView != null) {
                                S2SFullVideoActivity.this.mAutoClickView.setVisibility(0);
                            }
                            if (S2SFullVideoActivity.this.mAutoClickTimeView != null) {
                                S2SFullVideoActivity.this.mAutoClickTimeView.setText("" + S2SFullVideoActivity.this.autoClickTime);
                            }
                        }
                    }
                    if (S2SFullVideoActivity.this.getRewardTime == 0) {
                        S2SFullVideoActivity s2SFullVideoActivity4 = S2SFullVideoActivity.this;
                        s2SFullVideoActivity4.getRewardTime = s2SFullVideoActivity4.videoDuration;
                        if (S2SFullVideoActivity.this.mAdInfoPoJo.rd_auto_type == 2) {
                            S2SFullVideoActivity.this.canAutoClick = true;
                            i2 = S2SFullVideoActivity.this.getRewardTime / 1000;
                            if (i2 > 5) {
                                S2SFullVideoActivity.this.autoClickTime = 5;
                                S2SFullVideoActivity.this.autoClickStartTime = i2 - 5;
                            } else {
                                S2SFullVideoActivity.this.autoClickTime = i2;
                                S2SFullVideoActivity.this.autoClickStartTime = 0;
                            }
                        }
                    }
                    j = S2SFullVideoActivity.this.getRewardTime - S2SFullVideoActivity.this.curPosition;
                    S2SFullVideoActivity.this.setDurationCountdown(j);
                    if (S2SFullVideoActivity.this.videoDuration != 0) {
                        i = (int) ((((double) S2SFullVideoActivity.this.curPosition) / ((double) S2SFullVideoActivity.this.videoDuration)) * 100.0d);
                        if (i >= 25) {
                            S2SFullVideoActivity.this.mIs25Preent = true;
                            CommReportHelper.getInstance().reportVideoFirst(S2SFullVideoActivity.this.mAdInfoPoJo);
                        }
                        if (i >= 50) {
                            S2SFullVideoActivity.this.mIs50Preent = true;
                            CommReportHelper.getInstance().reportVideomMidpoint(S2SFullVideoActivity.this.mAdInfoPoJo);
                        }
                        if (i >= 75) {
                            S2SFullVideoActivity.this.mIs75Preent = true;
                            CommReportHelper.getInstance().reportVideoThird(S2SFullVideoActivity.this.mAdInfoPoJo);
                        }
                    }
                    if (S2SFullVideoActivity.this.mAdInfoPoJo != null) {
                        S2SFullVideoActivity.this.mSkipTextView.setVisibility(0);
                    }
                    if (j > 0) {
                        S2SFullVideoActivity.this.mDurationCountdownHandler.postDelayed(this, 1000L);
                        return;
                    }
                    if (S2SFullVideoActivity.this.mIsCurrentPage) {
                        S2SFullVideoActivity.this.mDurationCountdownTextView.setVisibility(8);
                        S2SFullVideoActivity.this.mSoundImageView.setVisibility(8);
                        S2SFullVideoActivity.this.mCloseImageView.setVisibility(0);
                        S2SFullVideoActivity.this.mSkipTextView.setVisibility(8);
                    }
                    if (S2SFullVideoActivity.this.isVideo) {
                        S2SFullVideoActivity.this.playEnd(1);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideo() {
        if (this.mediaPlayer != null) {
            changeSurfaceViewSize();
            ProgressBar progressBar = this.progressDialog;
            if (progressBar != null) {
                progressBar.setVisibility(4);
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
        AdInfoPoJo adInfoPoJo;
        super.onActivityResult(i, i2, intent);
        if (i != 10001 || i2 != 0 || (adInfoPoJo = this.mAdInfoPoJo) == null || TextUtils.isEmpty(adInfoPoJo.click_url)) {
            return;
        }
        AdInfoPoJo adInfoPoJo2 = this.mAdInfoPoJo;
        adInfoPoJo2.dp_result = 1;
        adInfoPoJo2.dp_reason = 1;
        CommReportHelper.getInstance().reportDeepLinkFail(this.mAdInfoPoJo);
        CommReportHelper commReportHelper = CommReportHelper.getInstance();
        AdInfoPoJo adInfoPoJo3 = this.mAdInfoPoJo;
        YdH5Activity.launchWithEnableQuickApp(this, commReportHelper.gdtReplac(adInfoPoJo3.click_url, adInfoPoJo3), QuickAppHelper.getInstance().enableQuickApp(this.mAdInfoPoJo.place_id));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.s2s_activity_reward_video_close_imageview || id == R.id.s2s_activity_reward_video_finish_close_imageview) {
            CommReportHelper.getInstance().reportVideoClose(this.mAdInfoPoJo, this.videoDuration);
            S2SFullVideoADManager s2SFullVideoADManager = manager;
            if (s2SFullVideoADManager != null) {
                s2SFullVideoADManager.onClose();
            }
            finish();
            return;
        }
        if (id == R.id.s2s_activity_reward_video_skip_textview) {
            if (this.skipDialog == null) {
                this.skipDialog = new YdCommonDialog(this).setContent("此时跳过将不会获得奖励，确认跳过吗？").setCanDismiss(false).setOnSubmitListener(new YdCommonDialog.OnSubmitListener() { // from class: com.zj.adlib.vo7
                    @Override // com.fl.saas.base.widget.YdCommonDialog.OnSubmitListener
                    public final void onClick() {
                        this.f45404a.lambda$onClick$1();
                    }
                });
            }
            this.skipDialog.show();
            return;
        }
        if (id == R.id.s2s_activity_reward_video_adinfo_container_relativelayout || id == R.id.s2s_activity_reward_video_finish_button || id == R.id.s2s_activity_reward_video_finish_container_relativelayout || id == R.id.ll_shake || id == R.id.s2s_activity_reward_video_reward_tips) {
            jump();
            return;
        }
        if (id == R.id.s2s_activity_reward_video_sound) {
            setSoundEnable(!getSoundEnableStatus());
            return;
        }
        if (id == R.id.s2s_activity_reward_video_auto_click_close) {
            LinearLayout linearLayout = this.mAutoClickView;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            this.canAutoClick = false;
            this.hasRefuseJump = true;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            if (getIntent().getIntExtra("draw_type", 0) == 0) {
                setRequestedOrientation(7);
            } else {
                setRequestedOrientation(6);
            }
            YdImmersiveUtils.setImmersiveStatusBar(this);
            YdImmersiveUtils.setStatusBarLightMode(this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onCreate(bundle);
        setContentView(R.layout.s2s_activity_full_video);
        initViews();
        initDatas();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.logoImageView = null;
        this.logoFinishImageView = null;
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mediaPlayer = null;
        }
        YdCommonDialog ydCommonDialog = this.skipDialog;
        if (ydCommonDialog != null) {
            if (ydCommonDialog.isShowing()) {
                this.skipDialog.dismiss();
            }
            this.skipDialog = null;
        }
        pauseDurationCountdown();
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIsCurrentPage = false;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsCurrentPage = true;
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
                if (imageView == null) {
                    return;
                } else {
                    i = R.drawable.yd_saas_volume_on;
                }
            } else {
                mediaPlayer.setVolume(0.0f, 0.0f);
                imageView = this.mSoundImageView;
                if (imageView == null) {
                    return;
                } else {
                    i = R.drawable.yd_saas_volume_off;
                }
            }
            imageView.setImageResource(i);
        } catch (Exception unused) {
        }
    }
}
