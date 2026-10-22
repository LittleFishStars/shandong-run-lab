package cn.hzjizhun.admin.h5;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import cn.hzjizhun.admin.R;
import cn.hzjizhun.admin.custom_ad.http.CustomAdPosResult;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.image.ImageLoaderImp;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.DialogUtils;
import com.gyf.immersionbar.b;
import com.zj.adlib.wgb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VideoPlayActivity extends Activity {
    private static final String TAG = "VideoPlayActivity11111111";
    private CustomAdPosResult mAdObject;
    private ImageView mCoverView;
    private boolean mIsComplete;
    private boolean mIsError;
    private boolean mIsMute;
    private boolean mIsPrepare;
    private boolean mIsReward;
    private FrameLayout mLayoutClick;
    private LinearLayout mLayoutJump;
    private ImageView mLogoView;
    private MediaPlayer mMediaPlayer;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceView mSurfaceView;
    private TextView mTvCloseTime;
    private TextView mTvSkip;
    private ImageView mVoiceView;
    private int currentPosition = 0;
    private ImageLoaderImp imageLoaderImp = new ImageLoaderImp(this, TAG);
    private Handler mTimeHandler = new Handler(Looper.getMainLooper()) { // from class: cn.hzjizhun.admin.h5.VideoPlayActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            VideoPlayActivity.this.updataTime();
            VideoPlayActivity.this.mTimeHandler.sendEmptyMessageDelayed(1, 1000L);
        }
    };
    private boolean isPause = false;

    private void changeMute() {
        try {
            if (this.mIsMute) {
                unmuteVideo();
            } else {
                wgb.c().a().playMuteReport();
                muteVideo();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickCloseView() {
        if (this.mTvSkip.getVisibility() != 8 || this.mIsComplete) {
            if (!this.mIsComplete) {
                pauseVideo();
            }
            DialogUtils.show(this, "是否关闭广告", new AdSdkH5Helper.DialogCallback() { // from class: cn.hzjizhun.admin.h5.VideoPlayActivity.4
                @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
                public void cancel() {
                    if (VideoPlayActivity.this.mIsComplete) {
                        return;
                    }
                    VideoPlayActivity.this.videoResume();
                }

                @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
                public void sure() {
                    try {
                        if (!VideoPlayActivity.this.mIsComplete && VideoPlayActivity.this.mTvSkip.getVisibility() == 0) {
                            wgb.c().a().playSkipReport();
                        }
                        VideoPlayActivity.this.finish();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private int getStatusBarHeightWithWindowInsets() {
        int identifier = getResources().getIdentifier(b.f6802a, "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMediaPlayer() {
        try {
            if (this.mMediaPlayer != null) {
                return;
            }
            ALog.innerD(TAG, "initMediaPlayer.....");
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mMediaPlayer = mediaPlayer;
            mediaPlayer.setDataSource(this.mAdObject.video.url);
            this.mMediaPlayer.prepareAsync();
            this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: cn.hzjizhun.admin.h5.VideoPlayActivity.6
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer2) {
                    ALog.innerD(VideoPlayActivity.TAG, "onPrepared.........." + VideoPlayActivity.this.currentPosition);
                    VideoPlayActivity.this.mCoverView.setVisibility(8);
                    VideoPlayActivity.this.mIsPrepare = true;
                    if (VideoPlayActivity.this.isPause) {
                        return;
                    }
                    VideoPlayActivity.this.videoPrepared();
                    VideoPlayActivity.this.mMediaPlayer.start();
                }
            });
            this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() { // from class: cn.hzjizhun.admin.h5.VideoPlayActivity.7
                @Override // android.media.MediaPlayer.OnSeekCompleteListener
                public void onSeekComplete(MediaPlayer mediaPlayer2) {
                    if (VideoPlayActivity.this.mMediaPlayer.isPlaying()) {
                        return;
                    }
                    VideoPlayActivity.this.mMediaPlayer.start();
                }
            });
            this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: cn.hzjizhun.admin.h5.VideoPlayActivity.8
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                    ALog.d(VideoPlayActivity.TAG, "视频播放失败" + i + "===" + i2);
                    VideoPlayActivity.this.onAdError(new JZAdError(-1, "video player fail"));
                    VideoPlayActivity.this.mIsError = true;
                    VideoPlayActivity.this.finish();
                    return false;
                }
            });
            this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: cn.hzjizhun.admin.h5.VideoPlayActivity.9
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer2) {
                    ALog.innerD(VideoPlayActivity.TAG, "onCompletion..........");
                    VideoPlayActivity.this.mIsComplete = true;
                    VideoPlayActivity.this.mCoverView.setVisibility(0);
                    VideoPlayActivity.this.mVoiceView.setVisibility(8);
                    VideoPlayActivity.this.mTimeHandler.removeCallbacksAndMessages(null);
                    VideoPlayActivity.this.mTvSkip.setVisibility(8);
                    VideoPlayActivity.this.mTvCloseTime.setText("关闭");
                    if (VideoPlayActivity.this.mAdObject.video.min_time == 0) {
                        VideoPlayActivity.this.onAdReward();
                    }
                    wgb.c().a().playEndReport();
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void initVideoView() {
        SurfaceHolder holder = this.mSurfaceView.getHolder();
        this.mSurfaceHolder = holder;
        holder.addCallback(new SurfaceHolder.Callback() { // from class: cn.hzjizhun.admin.h5.VideoPlayActivity.5
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                try {
                    if (VideoPlayActivity.this.mIsComplete) {
                        return;
                    }
                    VideoPlayActivity.this.initMediaPlayer();
                    VideoPlayActivity.this.mMediaPlayer.setDisplay(surfaceHolder);
                    VideoPlayActivity.this.videoResume();
                } catch (Throwable unused) {
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        });
    }

    private void initView() {
        this.mSurfaceView = (SurfaceView) findViewById(R.id.videoView);
        this.mCoverView = (ImageView) findViewById(R.id.ivCover);
        this.mVoiceView = (ImageView) findViewById(R.id.iv_voice);
        this.mLogoView = (ImageView) findViewById(R.id.ivLogo);
        this.mTvCloseTime = (TextView) findViewById(R.id.tv_close_time);
        this.mTvSkip = (TextView) findViewById(R.id.tvSkip);
        this.mLayoutJump = (LinearLayout) findViewById(R.id.layoutJump);
        this.mLayoutClick = (FrameLayout) findViewById(R.id.layoutClick);
        this.mSurfaceView.setVisibility(0);
        this.mVoiceView.setVisibility(0);
        this.mLayoutJump.setOnClickListener(new View.OnClickListener() { // from class: cn.hzjizhun.admin.h5.VideoPlayActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayActivity.this.clickCloseView();
            }
        });
        setCoverView();
        initVideoView();
        initVoiceView();
        this.mLayoutClick.setOnClickListener(new View.OnClickListener() { // from class: cn.hzjizhun.admin.h5.VideoPlayActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayActivity.this.onAdClick();
            }
        });
    }

    private void initVoiceView() {
        setMuteIcon();
        this.mVoiceView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.yn9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46079a.lambda$initVoiceView$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVoiceView$0(View view) {
        changeMute();
        setMuteIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdClick() {
        try {
            if (wgb.c().b() != null) {
                wgb.c().b().onAdClick();
            }
        } catch (Throwable unused) {
        }
    }

    private void onAdClose() {
        try {
            if (wgb.c().b() != null) {
                wgb.c().b().onAdClose();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdError(JZAdError jZAdError) {
        try {
            if (wgb.c().b() != null) {
                wgb.c().b().onAdError(jZAdError);
            }
        } catch (Throwable unused) {
        }
    }

    private void onAdExpose() {
        try {
            wgb.c().a().startPlayReport();
            if (wgb.c().b() != null) {
                wgb.c().b().onAdExpose();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdReward() {
        try {
            if (this.mIsReward) {
                return;
            }
            this.mIsReward = true;
            wgb.c().a().rewardReport();
            if (wgb.c().b() != null) {
                wgb.c().b().onAdReward();
            }
        } catch (Throwable unused) {
        }
    }

    private void pauseVideo() {
        MediaPlayer mediaPlayer;
        try {
            if (!this.mIsPrepare || this.mIsComplete || (mediaPlayer = this.mMediaPlayer) == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.mTimeHandler.removeCallbacksAndMessages(null);
            this.mMediaPlayer.pause();
            this.currentPosition = this.mMediaPlayer.getCurrentPosition();
            ALog.innerD(TAG, "pause position:    " + this.currentPosition);
            wgb.c().a().playPauseReport();
            this.isPause = true;
        } catch (Throwable th) {
            ALog.innerE(TAG, th.getMessage());
        }
    }

    private void releaseMediaPlayer() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    private void setCoverView() {
        try {
            this.imageLoaderImp.loadImage(this.mAdObject.video.cover, this.mCoverView);
        } catch (Throwable unused) {
        }
    }

    private void setMuteIcon() {
        if (this.mIsMute) {
            this.mVoiceView.setImageDrawable(AppCompatResources.getDrawable(this, R.mipmap.ad_sdk_volume_close));
        } else {
            this.mVoiceView.setImageDrawable(AppCompatResources.getDrawable(this, R.mipmap.ad_sdk_volume_open));
        }
    }

    private void setSkipView() {
        try {
            CustomAdPosResult.VideoBean videoBean = this.mAdObject.video;
            int currentPosition = this.mMediaPlayer.getCurrentPosition() / 1000;
            int i = videoBean.min_time;
            if (i > 0 && currentPosition >= i) {
                onAdReward();
            }
            if (!videoBean.isCanSkip() || currentPosition <= videoBean.min_time) {
                this.mTvSkip.setVisibility(8);
            } else {
                this.mTvSkip.setVisibility(0);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public void updataTime() {
        try {
            if (this.mMediaPlayer == null) {
                return;
            }
            setSkipView();
            int duration = this.mMediaPlayer.getDuration();
            int currentPosition = this.mMediaPlayer.getCurrentPosition();
            int i = duration - currentPosition;
            if (i < 0) {
                i = 0;
            }
            this.mTvCloseTime.setText(String.format("%d 秒", Integer.valueOf(i / 1000)));
            setSkipView();
            float f = (currentPosition / duration) * 100.0f;
            if (f >= 75.0f) {
                wgb.c().a().play75Report();
            } else if (f >= 50.0f) {
                wgb.c().a().play50Report();
            } else if (f >= 25.0f) {
                wgb.c().a().play25Report();
            }
        } catch (Throwable unused) {
        }
    }

    private void updateLogo() {
        try {
            this.imageLoaderImp.loadIcon(this.mAdObject.getIconUrl(), this.mLogoView);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void videoResume() {
        try {
            if (!this.mIsPrepare || this.mIsComplete || this.mMediaPlayer == null || !this.isPause) {
                return;
            }
            ALog.innerD(TAG, "resume position:    " + this.currentPosition);
            this.mTimeHandler.sendEmptyMessage(1);
            this.mMediaPlayer.start();
            this.isPause = false;
            wgb.c().a().playResumeReport();
        } catch (Throwable unused) {
        }
    }

    public void muteVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            this.mIsMute = true;
            mediaPlayer.setVolume(0.0f, 0.0f);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.jz_activity_ad_rc_videoplay);
        this.mAdObject = wgb.c().d();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layoutTop);
        if (Build.VERSION.SDK_INT >= 35) {
            relativeLayout.setPadding(0, getStatusBarHeightWithWindowInsets(), 0, 0);
        }
        initView();
        updateLogo();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            wgb.c().a().playCloseReport();
            this.mTimeHandler.removeCallbacksAndMessages(null);
            if (!this.mIsError) {
                onAdClose();
            }
            releaseMediaPlayer();
            this.mTimeHandler = null;
            super.onDestroy();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        pauseVideo();
    }

    public void unmuteVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            this.mIsMute = false;
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    public void videoPrepared() {
        try {
            this.mTimeHandler.sendEmptyMessage(1);
            onAdExpose();
            this.mCoverView.setVisibility(8);
        } catch (Throwable unused) {
        }
    }
}
