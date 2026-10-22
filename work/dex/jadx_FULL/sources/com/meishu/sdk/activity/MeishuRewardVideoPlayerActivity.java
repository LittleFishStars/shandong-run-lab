package com.meishu.sdk.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.ad.IAd;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.bquery.e;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.safe.SafeAppCompatActivity;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.service.d;
import com.meishu.sdk.core.utils.DownloadDialogBean;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.a0;
import com.meishu.sdk.core.utils.b1;
import com.meishu.sdk.core.utils.h;
import com.meishu.sdk.core.utils.i0;
import com.meishu.sdk.core.utils.j0;
import com.meishu.sdk.core.utils.m;
import com.meishu.sdk.core.utils.p1;
import com.meishu.sdk.core.utils.v;
import com.meishu.sdk.core.utils.y;
import com.meishu.sdk.core.utils.y0;
import com.meishu.sdk.core.view.DownloadView;
import com.meishu.sdk.core.view.NoNavigationDialog;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.core.view.gif.GifImageView;
import com.meishu.sdk.core.webview.g;
import com.meishu.sdk.core.webview.j;
import com.meishu.sdk.core.webview.jsbridge.bean.GetDeviceInfoResBean;
import com.meishu.sdk.core.webview.listener.b;
import com.meishu.sdk.core.webview.n;
import com.meishu.sdk.core.webview.o;
import com.meishu.sdk.core.webview.p;
import com.meishu.sdk.core.webview.q;
import com.meishu.sdk.core.webview.s;
import com.meishu.sdk.meishu_ad.n0;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.nativ.f;
import com.meishu.sdk.meishu_ad.reward.CircleProcessBar;
import com.meishu.sdk.platform.ms.c;
import com.meishu.sdk.platform.ms.splash.ShakeResult;
import com.meishu.sdk.platform.ms.splash.ShakeUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class MeishuRewardVideoPlayerActivity extends SafeAppCompatActivity {
    public static final String Action_text = "Action_text";
    public static final String Ad_content = "Ad_content";
    public static final String Ad_icon_url = "Ad_icon_url";
    public static final String Ad_title = "Ad_title";
    public static final String Ad_type = "Ad_type";
    public static final String Clickable_range = "Clickable_range";
    public static final String Clk_type = "clk_type";
    public static final String Close_btn = "Close_btn";
    public static final String Event_url = "event_url";
    public static final String From_logo = "From_logo";
    public static final String Image_src = "Image_src";
    public static final String Interaction_type = "Interaction_type";
    public static final String Power_count = "power_count";
    public static final String Power_delay = "power_delay";
    public static final String Power_index = "power_index";
    public static final String Power_index2 = "Power_index2";
    public static final String Reward_tmp_id = "reward_tmp_id";
    public static final String Reward_tmp_time = "reward_tmp_time";
    public static final String Reward_tmp_type = "reward_tmp_type";
    public static final String Reward_tmp_url = "reward_tmp_url";
    private static final String TAG = "MeishuRewardVideoPlayer";
    public static final String Video_complete_key = "Video_complete_key";
    public static final String Video_cover = "Video_cover";
    public static final String Video_endcover = "Video_endcover";
    public static final String Video_keep_time = "Video_keep_time";
    public static final String Video_mute_key = "Video_mute_key";
    public static final String Video_one_half_key = "Video_one_half_key";
    public static final String Video_one_quarter_key = "Video_one_quarter_key";
    public static final String Video_pause_key = "Video_pause_key";
    public static final String Video_replay_key = "Video_replay_key";
    public static final String Video_resume_key = "Video_resume_key";
    public static final String Video_start_key = "Video_start_key";
    public static final String Video_three_quarter_key = "Video_three_quarter_key";
    public static final String Video_unmute_key = "Video_unmute_key";
    public static final String Web_temp_id = "web_temp_id";
    public static final String Web_temp_url = "web_temp_url";
    private static c ad = null;
    private static DownloadDialogBean downloadBean = null;
    public static final String local_ad_id_key = "local_ad_id_key";
    public static final String orientation_key = "orientation_key";
    public static n0 rewardMediaView;
    private String actionText;
    private int adType;
    private i bQuery;
    private volatile boolean calledRewardError;
    private boolean canDisplayNewRewardTemp;
    private boolean canDisplayRewardTemp;
    private int clkActType;
    private int clkPower;
    private int clk_type;
    private String[] eventUrl;
    private boolean hasExposed;
    private int imageHeight;
    private int imageWidth;
    private String image_src;
    private int interaction_type;
    private boolean isActivityPause;
    private boolean isHideShakeView;
    private volatile Boolean isImgSuccess;
    private volatile boolean isRewardComplete;
    private volatile boolean isRewardTimeOver;
    private boolean isShake;
    private boolean isShakeInit;
    private volatile boolean isStarted;
    private boolean isWebStarted;
    private volatile boolean keepTimeFinish;
    private String localAdId;
    private Handler mHandler;
    private int mImageCurrentTime;
    private long mVideoTotalTime;
    private NormalMediaView mediaView;
    private ViewGroup mediaViewContainer;
    private boolean onCompletedInvoked;
    private boolean onReward;
    private boolean oneHalfPerformed;
    private boolean oneQuarterPerformed;
    private int power_count;
    private int power_delay;
    private int power_index;
    private int power_index2;
    private CircleProcessBar processBar;
    private GifImageView rewardImageview;
    private int rewardTmpId;
    private volatile Boolean rewardTmpLoadRes;
    private int rewardTmpTime;
    private int rewardTmpType;
    private String rewardTmpUrl;
    private s rewardTmpWrapper;
    private int shakeId;
    private GifImageView shakeImageView;
    private ShakeResult shakeResult;
    private boolean threeQuarterPerformed;
    private TouchAdContainer touchContainer;
    private volatile Boolean videoLoaded;
    private String[] video_close;
    private String[] video_complete;
    private String video_cover;
    private String video_endcover;
    private long video_keep_time;
    private String[] video_mute;
    private String[] video_one_half;
    private String[] video_one_quarter;
    private String[] video_pause;
    private String[] video_replay;
    private String[] video_resume;
    private String[] video_skip;
    private String[] video_start;
    private String[] video_three_quarter;
    private String[] video_unmute;
    private int webTempId;
    private String webTempUrl;
    private RelativeLayout webviewContainer;
    private static List<IAd> baseFullScreenVideoAdList = new ArrayList();
    private static boolean isMute = false;
    private int close_btn = 1;
    private boolean isAdExposed = false;
    private boolean isFirstInitClkType = true;
    private volatile boolean isCalledStartRender = false;
    private boolean hasImageComplete = false;
    private volatile boolean receiveShakeOrderFromJs = false;
    private int totalTime = 15000;
    private Runnable updateTime = new l() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.14
        public void safeRun() {
            try {
                MeishuRewardVideoPlayerActivity.access$5412(MeishuRewardVideoPlayerActivity.this, 100);
                MeishuRewardVideoPlayerActivity.this.processBar.a(MeishuRewardVideoPlayerActivity.this.mImageCurrentTime);
                MeishuRewardVideoPlayerActivity meishuRewardVideoPlayerActivity = MeishuRewardVideoPlayerActivity.this;
                meishuRewardVideoPlayerActivity.notifyVideoProgress(meishuRewardVideoPlayerActivity.totalTime, MeishuRewardVideoPlayerActivity.this.mImageCurrentTime);
                if (MeishuRewardVideoPlayerActivity.this.mImageCurrentTime >= MeishuRewardVideoPlayerActivity.this.totalTime) {
                    if (!MeishuRewardVideoPlayerActivity.this.canDisplayNewRewardTemp || !MeishuRewardVideoPlayerActivity.this.isShowedRewardTemp()) {
                        MeishuRewardVideoPlayerActivity.this.onReward = true;
                        MeishuRewardVideoPlayerActivity.this.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
                        MeishuRewardVideoPlayerActivity.this.bQuery.b(R.id.ms_reward_skip_button).d(8);
                        MeishuRewardVideoPlayerActivity.this.processBar.setVisibility(8);
                        MeishuRewardVideoPlayerActivity.this.rewardBroadcast();
                    }
                    MeishuRewardVideoPlayerActivity.this.onImageComplete();
                    MeishuRewardVideoPlayerActivity.this.mHandler.removeCallbacks(MeishuRewardVideoPlayerActivity.this.updateTime);
                    return;
                }
                int unused = MeishuRewardVideoPlayerActivity.this.totalTime;
                int unused2 = MeishuRewardVideoPlayerActivity.this.mImageCurrentTime;
                double d = (MeishuRewardVideoPlayerActivity.this.mImageCurrentTime * 1.0f) / MeishuRewardVideoPlayerActivity.this.totalTime;
                if (d < 0.25d || d >= 0.5d) {
                    if (d < 0.5d || d >= 0.75d) {
                        if (d >= 0.75d && d < 1.0d && !MeishuRewardVideoPlayerActivity.this.threeQuarterPerformed) {
                            MeishuRewardVideoPlayerActivity.this.ThreeQuarterReport();
                            MeishuRewardVideoPlayerActivity.this.threeQuarterPerformed = true;
                        }
                    } else if (!MeishuRewardVideoPlayerActivity.this.oneHalfPerformed) {
                        MeishuRewardVideoPlayerActivity.this.OneHalfReport();
                        MeishuRewardVideoPlayerActivity.this.oneHalfPerformed = true;
                    }
                } else if (!MeishuRewardVideoPlayerActivity.this.oneQuarterPerformed) {
                    MeishuRewardVideoPlayerActivity.this.OneQuarterReport();
                    MeishuRewardVideoPlayerActivity.this.oneQuarterPerformed = true;
                }
                MeishuRewardVideoPlayerActivity.this.mHandler.postDelayed(MeishuRewardVideoPlayerActivity.this.updateTime, 100L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    public n0.b keepTimeFinishListener = new n0.b() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.19
        public void onKeepTimeFinished() {
            MeishuRewardVideoPlayerActivity meishuRewardVideoPlayerActivity = MeishuRewardVideoPlayerActivity.this;
            meishuRewardVideoPlayerActivity.notifyVideoProgress(meishuRewardVideoPlayerActivity.mVideoTotalTime, MeishuRewardVideoPlayerActivity.this.mVideoTotalTime);
            if ((MeishuRewardVideoPlayerActivity.this.canDisplayNewRewardTemp && MeishuRewardVideoPlayerActivity.this.isShowedRewardTemp()) || MeishuRewardVideoPlayerActivity.this.keepTimeFinish) {
                return;
            }
            MeishuRewardVideoPlayerActivity.this.keepTimeFinish = true;
            MeishuRewardVideoPlayerActivity.this.onReward = true;
            MeishuRewardVideoPlayerActivity.this.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
            MeishuRewardVideoPlayerActivity.this.bQuery.b(R.id.ms_reward_skip_button).d(8);
            MeishuRewardVideoPlayerActivity.this.processBar.setVisibility(8);
            MeishuRewardVideoPlayerActivity.this.rewardBroadcast();
        }
    };
    private Runnable updateProcessRunnable = new l() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.20
        /* JADX WARN: Multi-variable type inference failed */
        public void safeRun() {
            if (MeishuRewardVideoPlayerActivity.this.onCompletedInvoked || MeishuRewardVideoPlayerActivity.this.mediaView == null) {
                return;
            }
            int currentPosition = MeishuRewardVideoPlayerActivity.this.mediaView.getCurrentPosition();
            MeishuRewardVideoPlayerActivity.this.processBar.a(currentPosition);
            MeishuRewardVideoPlayerActivity meishuRewardVideoPlayerActivity = MeishuRewardVideoPlayerActivity.this;
            meishuRewardVideoPlayerActivity.notifyVideoProgress(meishuRewardVideoPlayerActivity.mVideoTotalTime, currentPosition);
            MeishuRewardVideoPlayerActivity.this.mHandler.postDelayed(this, 100L);
        }
    };
    private final b jsEventListener = new b() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.22
        public void dismissAd() {
            MeishuRewardVideoPlayerActivity.this.closeAdOrActivity();
        }

        public String getActivityState() {
            return MeishuRewardVideoPlayerActivity.this.isActivityPause ? "pause" : "resume";
        }

        public String getDeviceInfo() {
            int iB;
            try {
                SafeAppCompatActivity safeAppCompatActivity = MeishuRewardVideoPlayerActivity.this;
                iB = (int) m.b(safeAppCompatActivity, y0.m(safeAppCompatActivity));
            } catch (Exception unused) {
                iB = 0;
            }
            MeishuRewardVideoPlayerActivity.this.initClkType();
            return v.a.toJson(GetDeviceInfoResBean.make(iB, h.d(MeishuRewardVideoPlayerActivity.this.clk_type), h.e(MeishuRewardVideoPlayerActivity.this.clk_type), (GetDeviceInfoResBean.AdConfig) null));
        }

        public boolean isAppBackground() {
            return !d.a();
        }

        public boolean isSoundsOpen() {
            if (MeishuRewardVideoPlayerActivity.this.image_src == null && MeishuRewardVideoPlayerActivity.this.mediaView != null) {
                return !MeishuRewardVideoPlayerActivity.this.mediaView.w;
            }
            return false;
        }

        public void notifyRewarded() {
            MeishuRewardVideoPlayerActivity.this.mNotifyRewarded();
        }

        public boolean setShakeOrTurnState(boolean z) {
            MeishuRewardVideoPlayerActivity.this.receiveShakeOrderFromJs = true;
            MeishuRewardVideoPlayerActivity.this.bQuery.b(R.id.ms_shake_root_view).d(8);
            if (MeishuRewardVideoPlayerActivity.this.shakeResult == null && h.c(MeishuRewardVideoPlayerActivity.this.clk_type)) {
                MeishuRewardVideoPlayerActivity.this.initClkType();
                if (z) {
                    MeishuRewardVideoPlayerActivity.this.startShakeAndTurn(true);
                    return MeishuRewardVideoPlayerActivity.this.isShake;
                }
                ShakeUtil.getInstance().e();
            }
            return false;
        }

        public void setSoundsOpen(boolean z) {
            if (MeishuRewardVideoPlayerActivity.this.image_src == null && MeishuRewardVideoPlayerActivity.this.mediaView != null) {
                if (z) {
                    MeishuRewardVideoPlayerActivity.this.mediaView.j();
                } else {
                    MeishuRewardVideoPlayerActivity.this.mediaView.g();
                }
            }
        }

        public void setVideoPlayState(boolean z) {
            if (z) {
                MeishuRewardVideoPlayerActivity.this.resumeCountDown(true);
            } else {
                MeishuRewardVideoPlayerActivity.this.removeCountDown();
            }
            if (MeishuRewardVideoPlayerActivity.this.mediaView == null) {
                return;
            }
            if (!z) {
                MeishuRewardVideoPlayerActivity.this.mediaView.pause();
            } else if (MeishuRewardVideoPlayerActivity.this.mediaView.getPlayState() == 0) {
                MeishuRewardVideoPlayerActivity.this.mediaView.start();
            } else {
                MeishuRewardVideoPlayerActivity.this.mediaView.resume();
            }
        }
    };
    private final com.meishu.sdk.core.service.a appStateListener = new com.meishu.sdk.core.service.a() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.23
        public boolean onAppStateUpdate(boolean z) {
            try {
                if (!MeishuRewardVideoPlayerActivity.this.isShowedRewardTemp() || !MeishuRewardVideoPlayerActivity.this.isCalledStartRender) {
                    return true;
                }
                WebView webView = MeishuRewardVideoPlayerActivity.this.rewardTmpWrapper != null ? MeishuRewardVideoPlayerActivity.this.rewardTmpWrapper.a : null;
                if (webView == null) {
                    return true;
                }
                if (z) {
                    com.meishu.sdk.core.webview.jsbridge.util.a.a(webView, "notifyH5EnterForeground", "");
                } else {
                    com.meishu.sdk.core.webview.jsbridge.util.a.a(webView, "notifyH5EnterBackground", "");
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    public static /* synthetic */ int access$5412(MeishuRewardVideoPlayerActivity meishuRewardVideoPlayerActivity, int i) {
        int i2 = meishuRewardVideoPlayerActivity.mImageCurrentTime + i;
        meishuRewardVideoPlayerActivity.mImageCurrentTime = i2;
        return i2;
    }

    private void applyCloseBtnVisibility() {
        int i = this.close_btn;
        if (i == 0) {
            this.bQuery.b(R.id.ms_reward_skip_button).d(8);
            this.bQuery.b(R.id.ms_reward_close_button_parent).d(8);
        } else if (i == 2) {
            this.bQuery.b(R.id.ms_reward_skip_button).d(0);
            this.bQuery.b(R.id.ms_reward_close_button_parent).d(8);
        } else {
            this.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
            this.bQuery.b(R.id.ms_reward_skip_button).d(8);
        }
    }

    public static void clearRewardMediaView() {
        rewardMediaView = null;
    }

    private void clearRewardTmp() {
        try {
            s sVar = this.rewardTmpWrapper;
            if (sVar != null) {
                q.a(sVar.a);
                try {
                    this.rewardTmpWrapper.b.g = null;
                } catch (Exception unused) {
                }
                try {
                    g gVar = this.rewardTmpWrapper.c;
                    gVar.getClass();
                    try {
                        gVar.a.clear();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception unused2) {
                }
            }
            this.rewardTmpWrapper = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void closeAdOrActivity() {
        sendBroadcast("broadcast_onclosed", false);
        finish();
    }

    private void closeWebView() {
        try {
            RelativeLayout relativeLayout = this.webviewContainer;
            if (relativeLayout != null) {
                WebView webView = (WebView) relativeLayout.getChildAt(0);
                this.webviewContainer.removeAllViews();
                this.webviewContainer.setVisibility(8);
                q.a(webView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private byte[] getImageBytes(Context context, int i) {
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = inputStreamOpenRawResource.read(bArr);
                if (-1 == i2) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private int getTempId() {
        return this.canDisplayNewRewardTemp ? this.webTempId : this.rewardTmpId;
    }

    private String getTempUrl() {
        return this.canDisplayNewRewardTemp ? this.webTempUrl : this.rewardTmpUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0015 A[Catch: Exception -> 0x0025, TryCatch #0 {Exception -> 0x0025, blocks: (B:4:0x0008, B:6:0x0013, B:7:0x0015, B:9:0x001d), top: B:15:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x001d A[Catch: Exception -> 0x0025, TRY_LEAVE, TryCatch #0 {Exception -> 0x0025, blocks: (B:4:0x0008, B:6:0x0013, B:7:0x0015, B:9:0x001d), top: B:15:0x0008 }] */
    public int getVideoRewardTotalTime(long j) {
        int duration = 15000;
        if (j > 0) {
            try {
                if (j < this.mediaView.getDuration()) {
                    duration = (int) j;
                } else if (this.mediaView.getDuration() > 0) {
                    duration = this.mediaView.getDuration();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.mediaView.getDuration() > 0) {
            duration = this.mediaView.getDuration();
        }
        return duration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleDownloadView(int i) {
        if (i != 1) {
            return;
        }
        try {
            if (downloadBean == null) {
                return;
            }
            TextView textView = (TextView) findViewById(R.id.ms_download_layer_textview);
            textView.setVisibility(0);
            DownloadView.bindClickableDownloadInfo(textView, downloadBean);
            textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.21
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return !MeishuRewardVideoPlayerActivity.this.isAdExposed;
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNonCreativeElements() {
        this.bQuery.b(R.id.ms_reward_skip_button).d(8);
        this.bQuery.b(R.id.ms_reward_close_button_parent).d(8);
        this.bQuery.b(R.id.ms_reward_voice_button).d(8);
        this.bQuery.b(R.id.ms_video_playing_ad_info_container).d(8);
        this.bQuery.b(R.id.ms_ad_info_container).d(8);
        this.bQuery.b(R.id.ms_include_ad_tag).d(8);
        this.bQuery.b(R.id.ms_include_ad_tag_end).d(8);
        this.bQuery.b(R.id.ms_download_layer_textview).d(8);
        this.bQuery.b(R.id.ms_shake_root_view).d(8);
        CircleProcessBar circleProcessBar = this.processBar;
        if (circleProcessBar != null) {
            circleProcessBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideShakeView() {
        LogUtil.e(TAG, "showRewardWeb, pauseVideo");
        this.isHideShakeView = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initClkType() {
        if (this.isFirstInitClkType) {
            this.isFirstInitClkType = false;
            h.a();
            this.clk_type = h.a(this.clk_type, this.adType);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initShakeAndTurn(boolean z) {
        try {
            TextView textView = (TextView) findViewById(R.id.ms_shake_text_bottom);
            final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ms_shake_root_view);
            int i = this.adType;
            AdType adType = AdType.REWARD;
            if (i == adType.value()) {
                if (h.d(this.clk_type)) {
                    if (this.interaction_type == 1) {
                        textView.setText("摇一摇或点击下载三方应用");
                    } else {
                        textView.setText("摇一摇或点击查看详情");
                    }
                } else if (h.e(this.clk_type)) {
                    if (this.interaction_type == 1) {
                        textView.setText("扭一扭或点击下载三方应用");
                    } else {
                        textView.setText("扭一扭或点击查看详情");
                    }
                }
                adType.value();
                h.a();
                int iA = h.a(this.clk_type, adType.value());
                this.clk_type = iA;
                if (h.c(iA)) {
                    this.isShake = true;
                    if (!z) {
                        linearLayout.setVisibility(0);
                    }
                    byte[] imageBytes = getImageBytes(this, R.raw.ms_new_shake);
                    if (imageBytes != null && imageBytes.length > 0) {
                        this.shakeImageView.setBytes(imageBytes, 1);
                        this.shakeImageView.startAnimation();
                    }
                    if (this.shakeId == 0) {
                        this.shakeId = ShakeUtil.getInstance().b();
                    }
                    int iB = h.b(this.clk_type);
                    final long jCurrentTimeMillis = System.currentTimeMillis();
                    ShakeUtil.getInstance().a(this.power_index2, this.power_index, iB, this.power_delay, this.power_count, this.shakeId, 0, new ShakeUtil.c() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.11
                        public void onShake(int i2, boolean z2, int i3, ShakeResult shakeResult) {
                            try {
                                MeishuRewardVideoPlayerActivity.this.clkActType = i2;
                                MeishuRewardVideoPlayerActivity.this.clkPower = i3;
                                if (shakeResult != null) {
                                    shakeResult.setTotalTurnTime(System.currentTimeMillis() - jCurrentTimeMillis);
                                }
                                MeishuRewardVideoPlayerActivity.this.shakeResult = shakeResult;
                                MeishuRewardVideoPlayerActivity.this.onClick();
                                if (MeishuRewardVideoPlayerActivity.this.shakeImageView != null) {
                                    MeishuRewardVideoPlayerActivity.this.shakeImageView.clear();
                                    linearLayout.setVisibility(8);
                                }
                                ShakeUtil.getInstance().a(MeishuRewardVideoPlayerActivity.this.shakeId);
                                MeishuRewardVideoPlayerActivity.this.notifyH5ActionShakeOrTurn();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    ShakeUtil.getInstance().a(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void initWebView(long j) {
        boolean z = this.canDisplayRewardTemp;
        if (!z && !this.canDisplayNewRewardTemp) {
            this.rewardTmpLoadRes = Boolean.FALSE;
            return;
        }
        if (z && this.rewardTmpType == 2) {
            if (((long) this.rewardTmpTime) * 1000 > j) {
                this.rewardTmpLoadRes = Boolean.FALSE;
                return;
            }
        }
        SdkHandler.getInstance().postDelay(new l() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.7
            public void safeRun() {
                super.safeRun();
                if (MeishuRewardVideoPlayerActivity.this.rewardTmpLoadRes == null) {
                    MeishuRewardVideoPlayerActivity.this.rewardTmpLoadRes = Boolean.FALSE;
                    MeishuRewardVideoPlayerActivity.this.onLoadRewardTmpRes(false);
                }
            }
        }, this.canDisplayNewRewardTemp ? 2000L : 3000L);
        q qVar = new q();
        qVar.g = new j() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.8
            public void onCloseWebView() {
                MeishuRewardVideoPlayerActivity.this.resumeUI();
            }

            public void onRewardSuccess() {
                MeishuRewardVideoPlayerActivity.this.mNotifyRewarded();
            }

            public void onWebClicked() {
            }

            public void onWebReady(boolean z2) {
                if (MeishuRewardVideoPlayerActivity.this.rewardTmpLoadRes != null) {
                    return;
                }
                final WebView webView = MeishuRewardVideoPlayerActivity.this.rewardTmpWrapper != null ? MeishuRewardVideoPlayerActivity.this.rewardTmpWrapper.a : null;
                if (webView == null) {
                    MeishuRewardVideoPlayerActivity.this.rewardTmpLoadRes = Boolean.FALSE;
                    MeishuRewardVideoPlayerActivity.this.onLoadRewardTmpRes(false);
                    return;
                }
                if (MeishuRewardVideoPlayerActivity.this.onReward) {
                    MeishuRewardVideoPlayerActivity.this.rewardTmpLoadRes = Boolean.FALSE;
                    MeishuRewardVideoPlayerActivity.this.onLoadRewardTmpRes(false);
                    return;
                }
                MeishuRewardVideoPlayerActivity.this.rewardTmpLoadRes = Boolean.valueOf(z2);
                if (z2) {
                    MeishuRewardVideoPlayerActivity.this.isWebStarted = true;
                    MeishuRewardVideoPlayerActivity.this.webviewContainer.post(new l() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.8.1
                        public void safeRun() {
                            if (webView.getParent() != null) {
                                return;
                            }
                            MeishuRewardVideoPlayerActivity.this.webviewContainer.setVisibility(0);
                            if (!MeishuRewardVideoPlayerActivity.this.canDisplayNewRewardTemp) {
                                MeishuRewardVideoPlayerActivity.this.pauseVideo();
                                MeishuRewardVideoPlayerActivity.this.showProgressBar();
                                MeishuRewardVideoPlayerActivity.this.hideShakeView();
                            }
                            if (MeishuRewardVideoPlayerActivity.this.isShake && MeishuRewardVideoPlayerActivity.this.canDisplayRewardTemp) {
                                MeishuRewardVideoPlayerActivity.this.bQuery.b(R.id.ms_shake_root_view).d(8);
                                ShakeUtil.getInstance().e();
                            }
                            if (MeishuRewardVideoPlayerActivity.this.canDisplayNewRewardTemp) {
                                MeishuRewardVideoPlayerActivity.this.hideNonCreativeElements();
                            }
                            MeishuRewardVideoPlayerActivity.this.webviewContainer.addView(webView, -1, -1);
                            MeishuRewardVideoPlayerActivity.this.notifyH5StartRender();
                            MeishuRewardVideoPlayerActivity.this.onLoadRewardTmpRes(true);
                        }
                    });
                } else {
                    MeishuRewardVideoPlayerActivity meishuRewardVideoPlayerActivity = MeishuRewardVideoPlayerActivity.this;
                    meishuRewardVideoPlayerActivity.onLoadRewardTmpRes(meishuRewardVideoPlayerActivity.rewardTmpLoadRes.booleanValue());
                }
            }
        };
        d.a(this.appStateListener);
        String tempUrl = getTempUrl();
        c cVar = ad;
        com.meishu.sdk.core.webview.listener.g gVar = new com.meishu.sdk.core.webview.listener.g() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.9
            public boolean onPageFinished(String str, boolean z2, boolean z3, int i) {
                return false;
            }

            public void onPageStarted(String str) {
            }
        };
        b bVar = this.jsEventListener;
        s sVar = null;
        try {
            n nVar = new n();
            nVar.a = 0;
            s sVarA = o.a(tempUrl) ? o.a(this, tempUrl, cVar, nVar, gVar, new p(qVar, bVar, cVar, this)) : null;
            if (sVarA != null) {
                qVar.a = sVarA.a;
            }
            sVar = sVarA;
        } catch (Throwable th) {
            th.printStackTrace();
            gVar.onPageFinished(tempUrl, true, false, -1);
        }
        this.rewardTmpWrapper = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isGif(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            return new BigInteger(1, bArr2).toString(16).startsWith("47494638");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLoadingRes() {
        if (this.image_src != null) {
            return this.isImgSuccess == null;
        }
        return this.videoLoaded == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNewRewardTempDisplay() {
        return this.canDisplayNewRewardTemp && isShowedRewardTemp();
    }

    private boolean isNewRewardTempLoadingOrSuccess() {
        return (!this.canDisplayNewRewardTemp || this.rewardTmpWrapper == null || Boolean.FALSE.equals(this.rewardTmpLoadRes)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowedRewardTemp() {
        RelativeLayout relativeLayout = this.webviewContainer;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpEndCover(String str) {
        NormalMediaView normalMediaView = this.mediaView;
        if (normalMediaView != null) {
            normalMediaView.O = true;
            normalMediaView.l();
            normalMediaView.f();
        }
        this.onCompletedInvoked = true;
        this.onReward = true;
        showEndCoverUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void loadImageError() {
        Boolean bool = Boolean.FALSE;
        this.isImgSuccess = bool;
        this.videoLoaded = bool;
        if ((this.canDisplayRewardTemp && this.rewardTmpType == 1 && (this.rewardTmpLoadRes == null || Boolean.TRUE.equals(this.rewardTmpLoadRes))) || this.calledRewardError) {
            return;
        }
        this.calledRewardError = true;
        sendBroadcast("broadcast_on_video_error", false);
        for (int i = 0; i < baseFullScreenVideoAdList.size(); i++) {
            try {
                com.meishu.sdk.platform.ms.a aVar = baseFullScreenVideoAdList.get(i);
                if (aVar != null) {
                    clearRewardMediaView();
                    aVar.a = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void loadRewardImage() {
        try {
            this.rewardImageview = findViewById(R.id.ms_reward_ad_image);
            findViewById(R.id.ms_reward_voice_button).setVisibility(8);
            SdkHandler.getInstance().postDelay(new l() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.12
                public void safeRun() {
                    if (MeishuRewardVideoPlayerActivity.this.isImgSuccess == null) {
                        MeishuRewardVideoPlayerActivity.this.isRewardTimeOver = true;
                        MeishuRewardVideoPlayerActivity.this.loadImageError();
                    }
                }
            }, 3000L);
            com.meishu.sdk.core.cache.a.a(this.image_src, new y() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.13
                public void onFailure(@NotNull IOException iOException) {
                    MeishuRewardVideoPlayerActivity.this.loadImageError();
                }

                public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                    int gifWidth;
                    int gifHeight;
                    try {
                        if (!httpResponse.isSuccessful()) {
                            MeishuRewardVideoPlayerActivity.this.loadImageError();
                            return;
                        }
                        byte[] bArr = (byte[]) httpResponse.getResponseBody();
                        if (bArr == null || bArr.length <= 0) {
                            MeishuRewardVideoPlayerActivity.this.loadImageError();
                            return;
                        }
                        if (bArr.length >= j0.a()) {
                            MeishuRewardVideoPlayerActivity.this.loadImageError();
                            return;
                        }
                        if (MeishuRewardVideoPlayerActivity.this.isRewardTimeOver) {
                            return;
                        }
                        MeishuRewardVideoPlayerActivity.this.isImgSuccess = Boolean.TRUE;
                        if (!MeishuRewardVideoPlayerActivity.this.isGif(bArr)) {
                            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                            if (bitmapDecodeByteArray == null) {
                                MeishuRewardVideoPlayerActivity.this.loadImageError();
                                return;
                            }
                            int width = bitmapDecodeByteArray.getWidth();
                            int height = bitmapDecodeByteArray.getHeight();
                            MeishuRewardVideoPlayerActivity.this.rewardImageview.setImageBitmap(bitmapDecodeByteArray);
                            gifWidth = width;
                            gifHeight = height;
                        } else if (MeishuRewardVideoPlayerActivity.this.rewardImageview != null) {
                            MeishuRewardVideoPlayerActivity.this.rewardImageview.setBytes(bArr);
                            gifWidth = MeishuRewardVideoPlayerActivity.this.rewardImageview.getGifWidth();
                            gifHeight = MeishuRewardVideoPlayerActivity.this.rewardImageview.getGifHeight();
                            MeishuRewardVideoPlayerActivity.this.rewardImageview.startAnimation();
                        } else {
                            gifWidth = 0;
                            gifHeight = 0;
                        }
                        MeishuRewardVideoPlayerActivity.this.imageWidth = gifWidth;
                        MeishuRewardVideoPlayerActivity.this.imageHeight = gifHeight;
                        DisplayMetrics displayMetrics = MeishuRewardVideoPlayerActivity.this.getResources().getDisplayMetrics();
                        ViewGroup.LayoutParams layoutParams = MeishuRewardVideoPlayerActivity.this.rewardImageview.getLayoutParams();
                        int i = displayMetrics.widthPixels;
                        layoutParams.width = i;
                        if (gifWidth <= 0 || gifHeight <= 0) {
                            layoutParams.height = displayMetrics.heightPixels - 100;
                        } else {
                            layoutParams.height = Math.min((i * gifHeight) / gifWidth, displayMetrics.heightPixels - 100);
                        }
                        MeishuRewardVideoPlayerActivity.this.rewardImageview.setLayoutParams(layoutParams);
                        long j = MeishuRewardVideoPlayerActivity.this.video_keep_time * 1000;
                        if (j > 0) {
                            MeishuRewardVideoPlayerActivity.this.totalTime = (int) j;
                        } else {
                            MeishuRewardVideoPlayerActivity.this.totalTime = 15000;
                        }
                        if (MeishuRewardVideoPlayerActivity.this.rewardTmpType == 2 && MeishuRewardVideoPlayerActivity.this.canDisplayRewardTemp) {
                            MeishuRewardVideoPlayerActivity meishuRewardVideoPlayerActivity = MeishuRewardVideoPlayerActivity.this;
                            meishuRewardVideoPlayerActivity.initWebView(meishuRewardVideoPlayerActivity.totalTime);
                        }
                        MeishuRewardVideoPlayerActivity.this.processBar.setmTotalTime(MeishuRewardVideoPlayerActivity.this.totalTime);
                        if (MeishuRewardVideoPlayerActivity.this.adType == AdType.REWARD.value() && !MeishuRewardVideoPlayerActivity.this.isNewRewardTempDisplay()) {
                            MeishuRewardVideoPlayerActivity.this.processBar.setVisibility(0);
                        }
                        MeishuRewardVideoPlayerActivity.this.onAdExposed();
                        MeishuRewardVideoPlayerActivity.this.startUpdateProcess();
                    } catch (Throwable unused) {
                        MeishuRewardVideoPlayerActivity.this.loadImageError();
                    }
                }
            }, true);
        } catch (Throwable th) {
            loadImageError();
            th.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void loadRewardVideo() {
        try {
            this.mediaViewContainer = (ViewGroup) findViewById(R.id.ms_media_video);
            n0 n0Var = rewardMediaView;
            if (n0Var == null) {
                loadImageError();
                return;
            }
            NormalMediaView videoView = n0Var.getVideoView();
            this.mediaView = videoView;
            videoView.setActivityForLifecycle(this);
            try {
                if (this.mediaView != null) {
                    if (isMute) {
                        this.bQuery.b(R.id.ms_reward_voice_button).c(R.drawable.ms_voice_closed);
                        this.mediaView.g();
                    } else {
                        this.bQuery.b(R.id.ms_reward_voice_button).c(R.drawable.ms_voice_open);
                        this.mediaView.j();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mediaView.setVideoCover(this.video_cover);
            this.mediaView.setVideoEndCover(this.video_endcover);
            final long j = this.video_keep_time * 1000;
            this.mediaView.setVideoCoverScaleType(ImageView.ScaleType.CENTER_CROP);
            this.mediaView.post(new l() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.15
                public void safeRun() {
                    MeishuRewardVideoPlayerActivity.this.mediaView.b();
                }
            });
            if (this.canDisplayRewardTemp && this.rewardTmpType == 1) {
                this.mediaView.setProgressLoadingVisible(false);
            } else {
                this.mediaView.setProgressLoadingVisible(true);
            }
            rewardMediaView.a(this.keepTimeFinishListener, j);
            rewardMediaView.a(new n0.a() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.16
                public void onCompleted() {
                    MeishuRewardVideoPlayerActivity.this.onCompletedInvoked = true;
                    MeishuRewardVideoPlayerActivity meishuRewardVideoPlayerActivity = MeishuRewardVideoPlayerActivity.this;
                    meishuRewardVideoPlayerActivity.notifyVideoProgress(meishuRewardVideoPlayerActivity.mVideoTotalTime, MeishuRewardVideoPlayerActivity.this.mVideoTotalTime);
                    if (!MeishuRewardVideoPlayerActivity.this.canDisplayNewRewardTemp || !MeishuRewardVideoPlayerActivity.this.isShowedRewardTemp()) {
                        MeishuRewardVideoPlayerActivity.this.onReward = true;
                        MeishuRewardVideoPlayerActivity.this.showEndCoverUI();
                        MeishuRewardVideoPlayerActivity.this.rewardBroadcast();
                    }
                    MeishuRewardVideoPlayerActivity.this.sendBroadcast("broadcast_on_video_complete", false);
                }
            });
            this.mediaViewContainer.removeAllViews();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            if (this.mediaView.getParent() != null && (this.mediaView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.mediaView.getParent()).removeView(this.mediaView);
            }
            this.mediaViewContainer.addView((View) this.mediaView, (ViewGroup.LayoutParams) layoutParams);
            f fVar = new f();
            new f.a(fVar);
            fVar.j = this.video_start;
            fVar.k = this.video_one_quarter;
            fVar.l = this.video_one_half;
            fVar.m = this.video_three_quarter;
            fVar.n = this.video_complete;
            fVar.o = this.video_pause;
            fVar.p = this.video_resume;
            fVar.q = this.video_skip;
            fVar.u = this.video_close;
            fVar.r = this.video_mute;
            fVar.s = this.video_unmute;
            fVar.t = this.video_replay;
            try {
                c cVar = ad;
                if (cVar != null && (cVar.a() instanceof BaseAdSlot)) {
                    fVar.setAppendInfo(ad.a().getAppendInfo());
                }
            } catch (Exception unused) {
            }
            rewardMediaView.setNativeAdMediaListener(new com.meishu.sdk.platform.ms.recycler.b(fVar, new RecyclerAdMediaListener() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.17
                public void onProgressUpdate(long j2, long j3) {
                }

                public void onVideoCompleted() {
                }

                public void onVideoError() {
                    if (MeishuRewardVideoPlayerActivity.this.isRewardTimeOver) {
                        return;
                    }
                    MeishuRewardVideoPlayerActivity.this.loadImageError();
                }

                public void onVideoLoaded() {
                    if (MeishuRewardVideoPlayerActivity.this.isRewardTimeOver) {
                        return;
                    }
                    MeishuRewardVideoPlayerActivity.this.videoLoaded = Boolean.TRUE;
                    MeishuRewardVideoPlayerActivity.this.startVideo(MeishuRewardVideoPlayerActivity.rewardMediaView);
                }

                public void onVideoPause() {
                    MeishuRewardVideoPlayerActivity.this.sendBroadcast("broadcast_on_video_pause", false);
                }

                public void onVideoResume() {
                    MeishuRewardVideoPlayerActivity.this.sendBroadcast("broadcast_on_video_resume", false);
                }

                public void onVideoStart() {
                    if (MeishuRewardVideoPlayerActivity.this.isRewardTimeOver || MeishuRewardVideoPlayerActivity.this.mediaView == null) {
                        return;
                    }
                    int videoRewardTotalTime = MeishuRewardVideoPlayerActivity.this.getVideoRewardTotalTime(j);
                    if (MeishuRewardVideoPlayerActivity.this.rewardTmpType == 2 && MeishuRewardVideoPlayerActivity.this.adType == AdType.REWARD.value()) {
                        MeishuRewardVideoPlayerActivity.this.initWebView(videoRewardTotalTime);
                    }
                    MeishuRewardVideoPlayerActivity.this.mVideoTotalTime = videoRewardTotalTime;
                    MeishuRewardVideoPlayerActivity.this.processBar.setmTotalTime(videoRewardTotalTime);
                    MeishuRewardVideoPlayerActivity.this.processBar.setOnSkipListener(new CircleProcessBar.a() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.17.1
                        public void onSkip() {
                            if ((MeishuRewardVideoPlayerActivity.this.canDisplayNewRewardTemp && MeishuRewardVideoPlayerActivity.this.isShowedRewardTemp()) || MeishuRewardVideoPlayerActivity.this.keepTimeFinish) {
                                return;
                            }
                            MeishuRewardVideoPlayerActivity.this.keepTimeFinish = true;
                            MeishuRewardVideoPlayerActivity.this.onReward = true;
                            MeishuRewardVideoPlayerActivity.this.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
                            MeishuRewardVideoPlayerActivity.this.bQuery.b(R.id.ms_reward_skip_button).d(8);
                            MeishuRewardVideoPlayerActivity.this.processBar.setVisibility(8);
                            MeishuRewardVideoPlayerActivity.this.rewardBroadcast();
                        }
                    });
                    MeishuRewardVideoPlayerActivity.this.onAdExposed();
                    MeishuRewardVideoPlayerActivity.this.mediaView.post(new l() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.17.2
                        public void safeRun() {
                            if (MeishuRewardVideoPlayerActivity.this.mHandler == null) {
                                MeishuRewardVideoPlayerActivity.this.mHandler = new Handler();
                            }
                            MeishuRewardVideoPlayerActivity.this.resumeCountDown();
                        }
                    });
                    MeishuRewardVideoPlayerActivity.this.rewardEventUrlReport(16);
                    LogUtil.e(MeishuRewardVideoPlayerActivity.TAG, "onVideoStart,isWebStarted=" + MeishuRewardVideoPlayerActivity.this.isWebStarted + ",mediaView=" + MeishuRewardVideoPlayerActivity.this.mediaView);
                    if (MeishuRewardVideoPlayerActivity.this.isWebStarted && MeishuRewardVideoPlayerActivity.this.canDisplayRewardTemp) {
                        MeishuRewardVideoPlayerActivity.this.pauseVideo();
                    }
                }
            }));
            if (!rewardMediaView.a()) {
                SdkHandler.getInstance().postDelay(new l() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.18
                    public void safeRun() {
                        if (MeishuRewardVideoPlayerActivity.this.videoLoaded == null) {
                            MeishuRewardVideoPlayerActivity.this.isRewardTimeOver = true;
                            MeishuRewardVideoPlayerActivity.this.loadImageError();
                        }
                    }
                }, 3000L);
            } else {
                startVideo(rewardMediaView);
                this.videoLoaded = Boolean.TRUE;
            }
        } catch (Throwable unused2) {
            loadImageError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mNotifyRewarded() {
        if (this.keepTimeFinish) {
            return;
        }
        this.keepTimeFinish = true;
        this.onReward = true;
        rewardBroadcast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyH5ActionShakeOrTurn() {
        try {
            s sVar = this.rewardTmpWrapper;
            WebView webView = sVar != null ? sVar.a : null;
            if (webView == null) {
                return;
            }
            com.meishu.sdk.core.webview.jsbridge.util.a.a(webView, "notifyH5ActionShakeOrTurn", "");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void notifyH5ActivityState(String str) {
        try {
            s sVar = this.rewardTmpWrapper;
            WebView webView = sVar != null ? sVar.a : null;
            if (webView != null && this.isCalledStartRender) {
                com.meishu.sdk.core.webview.jsbridge.util.a.a(webView, "notifyH5ActivityState", "\"{'state':'" + str + "'}\"");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyH5StartRender() {
        try {
            s sVar = this.rewardTmpWrapper;
            WebView webView = sVar != null ? sVar.a : null;
            if (webView != null && isShowedRewardTemp() && this.isAdExposed && !this.isCalledStartRender) {
                this.isCalledStartRender = true;
                com.meishu.sdk.core.webview.jsbridge.util.a.a(webView, "startRender", "");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyVideoProgress(long j, long j2) {
        try {
            if (isShowedRewardTemp()) {
                s sVar = this.rewardTmpWrapper;
                WebView webView = sVar != null ? sVar.a : null;
                if (webView == null) {
                    return;
                }
                com.meishu.sdk.core.webview.jsbridge.util.a.a(webView, "notifyH5VideoProgress", j + "," + j2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdExposed() {
        if (this.isAdExposed) {
            return;
        }
        this.isAdExposed = true;
        sendBroadcast("broadcast_on_video_start", false);
        if (!this.canDisplayRewardTemp && !this.canDisplayNewRewardTemp) {
            if (this.isActivityPause) {
                return;
            }
            startShakeAndTurn();
        } else {
            if (!this.isActivityPause && !this.receiveShakeOrderFromJs && (!this.canDisplayRewardTemp || !isShowedRewardTemp())) {
                startShakeAndTurn();
            }
            notifyH5StartRender();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick() {
        if (this.image_src != null) {
            new SoftReference(this);
            sendBroadcast("broadcast_onclick", true);
            return;
        }
        NormalMediaView normalMediaView = this.mediaView;
        if (normalMediaView == null || !normalMediaView.b.g) {
            return;
        }
        new SoftReference(this);
        sendBroadcast("broadcast_onclick", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadRewardTmpRes(boolean z) {
        if (z) {
            if (this.rewardTmpType == 1) {
                startReport();
                onAdExposed();
                return;
            }
            return;
        }
        if (this.image_src != null) {
            if (this.isImgSuccess == null || this.isImgSuccess.booleanValue()) {
                resumeUI();
            } else {
                loadImageError();
            }
        } else if (this.videoLoaded == null || this.videoLoaded.booleanValue()) {
            resumeUI();
        } else {
            loadImageError();
        }
        clearRewardTmp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        StringBuilder sbA = a.a("showRewardWeb, pauseVideo,video_keep_time=");
        sbA.append(this.video_keep_time);
        LogUtil.e(TAG, sbA.toString());
        removeCountDown();
        NormalMediaView normalMediaView = this.mediaView;
        if (normalMediaView != null) {
            normalMediaView.setRewardWeb(true);
            if (this.mediaView.e()) {
                this.mediaView.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCountDown() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.updateTime);
            this.mHandler.removeCallbacks(this.updateProcessRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreNonCreativeElements() {
        try {
            applyCloseBtnVisibility();
            if (this.image_src == null) {
                this.bQuery.b(R.id.ms_reward_voice_button).d(0);
            }
            this.bQuery.b(R.id.ms_video_playing_ad_info_container).d(0);
            this.bQuery.b(R.id.ms_include_ad_tag).d(0);
            if (this.interaction_type == 1) {
                this.bQuery.b(R.id.ms_download_layer_textview).d(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeCountDown() {
        resumeCountDown(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeUI() {
        RelativeLayout relativeLayout = this.webviewContainer;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.post(new l() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.10
            public void notifyRunnableCatch(Throwable th) {
                MeishuRewardVideoPlayerActivity.this.loadImageError();
            }

            public void safeRun() {
                MeishuRewardVideoPlayerActivity.this.webviewContainer.removeAllViews();
                MeishuRewardVideoPlayerActivity.this.webviewContainer.setVisibility(8);
                if (MeishuRewardVideoPlayerActivity.this.canDisplayNewRewardTemp) {
                    MeishuRewardVideoPlayerActivity.this.restoreNonCreativeElements();
                }
                if (MeishuRewardVideoPlayerActivity.this.isLoadingRes()) {
                    LogUtil.e(MeishuRewardVideoPlayerActivity.TAG, "isloadingRes. return");
                    return;
                }
                if (MeishuRewardVideoPlayerActivity.this.adType == AdType.REWARD.value() && MeishuRewardVideoPlayerActivity.this.processBar != null && !MeishuRewardVideoPlayerActivity.this.keepTimeFinish) {
                    MeishuRewardVideoPlayerActivity.this.processBar.setVisibility(0);
                }
                if (!MeishuRewardVideoPlayerActivity.this.isActivityPause) {
                    MeishuRewardVideoPlayerActivity.this.startShakeAndTurn();
                    MeishuRewardVideoPlayerActivity.this.resumeVideo();
                } else if (MeishuRewardVideoPlayerActivity.this.mediaView != null) {
                    MeishuRewardVideoPlayerActivity.this.mediaView.setRewardWeb(false);
                }
                if (MeishuRewardVideoPlayerActivity.this.onReward) {
                    MeishuRewardVideoPlayerActivity meishuRewardVideoPlayerActivity = MeishuRewardVideoPlayerActivity.this;
                    meishuRewardVideoPlayerActivity.jumpEndCover(meishuRewardVideoPlayerActivity.actionText);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeVideo() {
        resumeCountDown();
        NormalMediaView normalMediaView = this.mediaView;
        if (normalMediaView != null) {
            normalMediaView.setRewardWeb(false);
            if (this.mediaView.getPlayState() == 0) {
                this.mediaView.start();
            } else {
                this.mediaView.resume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewardBroadcast() {
        int tempId;
        if (this.isRewardComplete) {
            return;
        }
        int i = 1;
        this.isRewardComplete = true;
        if (isShowedRewardTemp()) {
            tempId = getTempId();
        } else {
            i = 0;
            tempId = 0;
        }
        if (!isNewRewardTempDisplay()) {
            rewardTimeEndReport(i, tempId);
        }
        sendBroadcast("broadcast_onreward", false);
        rewardEdReport(i, tempId);
    }

    private void rewardEdReport(int i, int i2) {
        try {
            if (this.adType != AdType.REWARD.value()) {
                return;
            }
            p1.a(this.eventUrl, 31, 0, b1.a(this.image_src != null ? 1 : 2, i, i2, ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewardEventUrlReport(int i) {
        try {
            if (this.adType != AdType.REWARD.value()) {
                return;
            }
            p1.a(this.eventUrl, i, 0, b1.a(this.image_src != null ? 1 : 2, ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void rewardTimeEndReport(int i, int i2) {
        try {
            if (this.adType != AdType.REWARD.value()) {
                return;
            }
            p1.a(this.eventUrl, 17, 0, b1.a(this.image_src != null ? 1 : 2, i, i2, ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void sendBroadcast(String str, boolean z) {
        Intent intent = new Intent();
        intent.setAction(str);
        if (z) {
            intent.putExtra("clk_act_type", this.clkActType);
            intent.putExtra("clk_power", this.clkPower);
            ShakeResult shakeResult = this.shakeResult;
            if (shakeResult != null) {
                intent.putExtra("shake_result", (Serializable) shakeResult);
            }
            intent.putExtra("image_width", this.imageWidth);
            intent.putExtra("image_height", this.imageHeight);
            intent.putExtra("click_reward_tmp_id", isShowedRewardTemp() ? getTempId() : 0);
        }
        if ("broadcast_on_video_start".equals(str) && this.canDisplayRewardTemp && this.rewardTmpType == 1) {
            intent.putExtra("report_exposure", true);
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public static void setDownloadDialogBean(DownloadDialogBean downloadDialogBean) {
        downloadBean = downloadDialogBean;
    }

    public static void setFullScreenAd(c cVar) {
        try {
            ad = cVar;
            baseFullScreenVideoAdList.add(cVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setMediaView(n0 n0Var) {
        rewardMediaView = n0Var;
    }

    public static void setVideoMute(boolean z) {
        isMute = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEndCoverUI() {
        this.bQuery.b(R.id.ms_video_playing_ad_info_container).d(8);
        this.bQuery.b(R.id.ms_ad_info_container).d(0);
        this.bQuery.b(R.id.ms_download_button).a(this.actionText);
        this.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
        this.bQuery.b(R.id.ms_reward_skip_button).d(8);
        this.bQuery.b(R.id.ms_include_ad_tag).d(8);
        this.bQuery.b(R.id.ms_include_ad_tag_end).d(0);
        CircleProcessBar circleProcessBar = this.processBar;
        if (circleProcessBar != null) {
            circleProcessBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressBar() {
        if (this.rewardTmpType == 1) {
            long j = this.video_keep_time;
            int i = j > 0 ? (int) (j * 1000) : 25000;
            LogUtil.e(TAG, "showRewardWeb, pauseVideo,time=" + i);
            CircleProcessBar circleProcessBar = this.processBar;
            if (circleProcessBar != null) {
                circleProcessBar.setVisibility(0);
                this.processBar.setmTotalTime(i);
                this.processBar.invalidate();
            }
        }
    }

    private void showWebView() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void startReport() {
        try {
            c cVar = ad;
            AdSlot adSlotA = cVar != null ? cVar.a() : null;
            if (com.meishu.sdk.core.utils.a.b(adSlotA)) {
                LogUtil.dev(TAG, "has video start. return");
                return;
            }
            if (this.isStarted) {
                return;
            }
            this.isStarted = true;
            LogUtil.d(TAG, "send onVideoStart");
            if (adSlotA instanceof BaseAdSlot) {
                ((BaseAdSlot) adSlotA).setHasVideoStart(true);
            }
            String[] strArr = this.video_start;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        a0.a(this, i0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
            rewardEventUrlReport(16);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startShakeAndTurn() {
        startShakeAndTurn(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpdateProcess() {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        startReport();
        resumeCountDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideo(n0 n0Var) {
        this.mVideoTotalTime = getVideoRewardTotalTime(this.video_keep_time * 1000);
        if (this.rewardTmpType == 1 && this.rewardTmpId != 0 && this.adType == AdType.REWARD.value() && this.canDisplayRewardTemp && !Boolean.FALSE.equals(this.rewardTmpLoadRes)) {
            return;
        }
        n0Var.getVideoView().start();
        if (this.adType != AdType.REWARD.value() || isNewRewardTempDisplay()) {
            return;
        }
        this.processBar.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void OneHalfReport() {
        try {
            LogUtil.d(TAG, "send onVideoOneHalf");
            String[] strArr = this.video_one_half;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        a0.a(this, i0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void OneQuarterReport() {
        try {
            LogUtil.d(TAG, "send onVideoOneQuarter");
            String[] strArr = this.video_one_quarter;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        a0.a(this, i0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ThreeQuarterReport() {
        try {
            LogUtil.d(TAG, "send onVideoThreeQuarter");
            String[] strArr = this.video_three_quarter;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        a0.a(this, i0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onBackPressed() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onImageComplete() {
        if (this.hasImageComplete) {
            return;
        }
        this.hasImageComplete = true;
        if (!this.canDisplayNewRewardTemp || !isShowedRewardTemp()) {
            showEndCoverUI();
        }
        sendBroadcast("broadcast_on_video_complete", false);
        try {
            LogUtil.d(TAG, "send onVideoComplete");
            String[] strArr = this.video_complete;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        a0.a(this, i0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void safeOnAttachedToWindow() {
        super.safeOnAttachedToWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void safeOnCreate(Bundle bundle) {
        super.safeOnCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(3330);
        ShakeUtil.getInstance().e();
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("orientation_key", 1);
        if (intExtra == 1) {
            setContentView(R.layout.ms_activity_meishu_reward_portrait_video);
        } else if (intExtra == 2) {
            setContentView(R.layout.ms_activity_meishu_reward_landscape_video);
        }
        this.touchContainer = findViewById(R.id.ms_activity_reward_video_touch_ad_container);
        this.bQuery = new i(this);
        this.actionText = intent.getStringExtra("Action_text");
        this.localAdId = intent.getStringExtra("local_ad_id_key");
        this.image_src = intent.getStringExtra("Image_src");
        this.video_start = intent.getStringArrayExtra("Video_start_key");
        this.video_one_quarter = intent.getStringArrayExtra("Video_one_quarter_key");
        this.video_one_half = intent.getStringArrayExtra("Video_one_half_key");
        this.video_three_quarter = intent.getStringArrayExtra("Video_three_quarter_key");
        this.video_complete = intent.getStringArrayExtra("Video_complete_key");
        this.video_pause = intent.getStringArrayExtra("Video_pause_key");
        this.video_resume = intent.getStringArrayExtra("Video_resume_key");
        this.video_mute = intent.getStringArrayExtra("Video_mute_key");
        this.video_unmute = intent.getStringArrayExtra("Video_unmute_key");
        this.video_replay = intent.getStringArrayExtra("Video_replay_key");
        this.video_cover = intent.getStringExtra("Video_cover");
        this.video_endcover = intent.getStringExtra("Video_endcover");
        this.video_keep_time = intent.getLongExtra("Video_keep_time", -1L);
        this.eventUrl = intent.getStringArrayExtra("event_url");
        String stringExtra = intent.getStringExtra("Ad_title");
        String stringExtra2 = intent.getStringExtra("Ad_content");
        String stringExtra3 = intent.getStringExtra("Ad_icon_url");
        String stringExtra4 = intent.getStringExtra("From_logo");
        int intExtra2 = intent.getIntExtra("Clickable_range", -1);
        int intExtra3 = intent.getIntExtra("Close_btn", 1);
        this.close_btn = intExtra3;
        if (intExtra3 != 0 && intExtra3 != 2) {
            this.close_btn = 1;
        }
        this.clk_type = intent.getIntExtra("clk_type", -1);
        this.power_count = intent.getIntExtra("power_count", 1);
        this.power_delay = intent.getIntExtra("power_delay", 500);
        this.power_index = intent.getIntExtra("power_index", 15);
        this.power_index2 = intent.getIntExtra("Power_index2", 15);
        this.interaction_type = intent.getIntExtra("Interaction_type", 0);
        this.rewardTmpUrl = intent.getStringExtra("reward_tmp_url");
        this.rewardTmpType = intent.getIntExtra("reward_tmp_type", 0);
        this.rewardTmpTime = intent.getIntExtra("reward_tmp_time", 0);
        this.rewardTmpId = intent.getIntExtra("reward_tmp_id", 0);
        if (!TextUtils.isEmpty(this.rewardTmpUrl) && this.rewardTmpType > 0 && this.rewardTmpId > 0) {
            this.canDisplayRewardTemp = true;
        }
        this.webTempUrl = intent.getStringExtra(Web_temp_url);
        this.webTempId = intent.getIntExtra(Web_temp_id, 0);
        if (!TextUtils.isEmpty(this.webTempUrl) && this.webTempId > 0) {
            this.canDisplayNewRewardTemp = true;
            this.canDisplayRewardTemp = false;
            this.rewardTmpUrl = null;
            this.rewardTmpType = 0;
            this.rewardTmpTime = 0;
            this.rewardTmpId = 0;
        }
        handleDownloadView(this.interaction_type);
        this.adType = intent.getIntExtra("Ad_type", -1);
        i iVarB = this.bQuery.b(R.id.ms_reward_skip_button);
        View.OnClickListener onClickListener = new com.meishu.sdk.core.safe.o() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.1
            public void safeOnClick(View view) {
                try {
                    if (!MeishuRewardVideoPlayerActivity.this.onReward && MeishuRewardVideoPlayerActivity.this.adType == AdType.REWARD.value()) {
                        if (MeishuRewardVideoPlayerActivity.this.mediaView != null && MeishuRewardVideoPlayerActivity.this.mediaView.e()) {
                            MeishuRewardVideoPlayerActivity.this.mediaView.pause();
                        }
                        MeishuRewardVideoPlayerActivity.this.rewardEventUrlReport(18);
                        NoNavigationDialog noNavigationDialog = new NoNavigationDialog(MeishuRewardVideoPlayerActivity.this);
                        noNavigationDialog.setTitle("观看完成即可获得奖励");
                        noNavigationDialog.setButton(-1, "继续观看", new com.meishu.sdk.core.safe.b() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.1.1
                            public void safeOnClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                MeishuRewardVideoPlayerActivity.this.rewardEventUrlReport(20);
                                if (MeishuRewardVideoPlayerActivity.this.mediaView == null || !MeishuRewardVideoPlayerActivity.this.mediaView.e()) {
                                    return;
                                }
                                MeishuRewardVideoPlayerActivity.this.mediaView.resume();
                            }
                        });
                        noNavigationDialog.setButton(-2, "放弃奖励", new com.meishu.sdk.core.safe.b() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.1.2
                            public void safeOnClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                MeishuRewardVideoPlayerActivity.this.rewardEventUrlReport(19);
                                MeishuRewardVideoPlayerActivity meishuRewardVideoPlayerActivity = MeishuRewardVideoPlayerActivity.this;
                                meishuRewardVideoPlayerActivity.jumpEndCover(meishuRewardVideoPlayerActivity.actionText);
                            }
                        });
                        noNavigationDialog.show();
                        return;
                    }
                    MeishuRewardVideoPlayerActivity meishuRewardVideoPlayerActivity = MeishuRewardVideoPlayerActivity.this;
                    meishuRewardVideoPlayerActivity.jumpEndCover(meishuRewardVideoPlayerActivity.actionText);
                } catch (Throwable unused) {
                }
            }
        };
        View view = ((e) iVarB).d;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        i iVarB2 = this.bQuery.b(R.id.ms_reward_close_button_parent);
        View.OnClickListener onClickListener2 = new com.meishu.sdk.core.safe.o() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.2
            public void safeOnClick(View view2) {
                try {
                    if (!MeishuRewardVideoPlayerActivity.this.onReward && MeishuRewardVideoPlayerActivity.this.adType == AdType.REWARD.value() && MeishuRewardVideoPlayerActivity.this.close_btn != 1) {
                        if (MeishuRewardVideoPlayerActivity.this.mediaView != null && MeishuRewardVideoPlayerActivity.this.mediaView.e()) {
                            MeishuRewardVideoPlayerActivity.this.mediaView.pause();
                        }
                        MeishuRewardVideoPlayerActivity.this.rewardEventUrlReport(18);
                        NoNavigationDialog noNavigationDialog = new NoNavigationDialog(MeishuRewardVideoPlayerActivity.this);
                        noNavigationDialog.setTitle("观看完成即可获得奖励");
                        noNavigationDialog.setButton(-1, "继续观看", new com.meishu.sdk.core.safe.b() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.2.1
                            public void safeOnClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                MeishuRewardVideoPlayerActivity.this.rewardEventUrlReport(20);
                                if (MeishuRewardVideoPlayerActivity.this.mediaView == null || !MeishuRewardVideoPlayerActivity.this.mediaView.e()) {
                                    return;
                                }
                                MeishuRewardVideoPlayerActivity.this.mediaView.resume();
                            }
                        });
                        noNavigationDialog.setButton(-2, "放弃奖励", new com.meishu.sdk.core.safe.b() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.2.2
                            public void safeOnClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                MeishuRewardVideoPlayerActivity.this.rewardEventUrlReport(19);
                                MeishuRewardVideoPlayerActivity.this.closeAdOrActivity();
                            }
                        });
                        noNavigationDialog.show();
                        return;
                    }
                    MeishuRewardVideoPlayerActivity.this.closeAdOrActivity();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        View view2 = ((e) iVarB2).d;
        if (view2 != null) {
            view2.setOnClickListener(onClickListener2);
        }
        i iVarB3 = this.bQuery.b(R.id.ms_reward_voice_button);
        View.OnClickListener onClickListener3 = new com.meishu.sdk.core.safe.o() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.3
            public void safeOnClick(View view3) {
                try {
                    if (MeishuRewardVideoPlayerActivity.this.mediaView != null && MeishuRewardVideoPlayerActivity.this.mediaView.e()) {
                        if (MeishuRewardVideoPlayerActivity.isMute) {
                            boolean unused = MeishuRewardVideoPlayerActivity.isMute = false;
                            MeishuRewardVideoPlayerActivity.this.bQuery.b(R.id.ms_reward_voice_button).c(R.drawable.ms_voice_open);
                            MeishuRewardVideoPlayerActivity.this.mediaView.j();
                        } else {
                            boolean unused2 = MeishuRewardVideoPlayerActivity.isMute = true;
                            MeishuRewardVideoPlayerActivity.this.bQuery.b(R.id.ms_reward_voice_button).c(R.drawable.ms_voice_closed);
                            MeishuRewardVideoPlayerActivity.this.mediaView.g();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        View view3 = ((e) iVarB3).d;
        if (view3 != null) {
            view3.setOnClickListener(onClickListener3);
        }
        this.shakeImageView = findViewById(R.id.ms_shake_img);
        if (intExtra2 != 2 && intExtra2 != 1) {
            intExtra2 = -1;
        }
        if (intExtra2 == -1) {
            intExtra2 = 1;
        }
        applyCloseBtnVisibility();
        if (stringExtra4 != null) {
            i iVarA = this.bQuery.a(R.id.ms_include_ad_tag);
            int i = R.id.ms_img_meishu_ad_tag;
            iVarA.b(i).a(stringExtra4, false);
            this.bQuery.a(R.id.ms_include_ad_tag_end).b(i).a(stringExtra4, false);
        }
        this.bQuery.b(R.id.ms_video_playing_reward_ad_title).a(stringExtra);
        this.bQuery.b(R.id.ms_video_playing_reward_ad_content).a(stringExtra2);
        i iVar = this.bQuery;
        int i2 = R.id.ms_video_playing_download_button;
        iVar.b(i2).a(this.actionText);
        if (stringExtra3 != null) {
            this.bQuery.b(R.id.ms_reward_ad_icon).a(stringExtra3, false).d(0);
            this.bQuery.b(R.id.ms_reward_ad_icon_end).a(stringExtra3, false).d(0);
        }
        if (intExtra2 == 1) {
            i iVarB4 = this.bQuery.b(i2);
            View.OnClickListener onClickListener4 = new com.meishu.sdk.core.safe.o() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.4
                public void safeOnClick(View view4) {
                    if (MeishuRewardVideoPlayerActivity.this.isAdExposed) {
                        LogUtil.e(MeishuRewardVideoPlayerActivity.TAG, "video_playing_download_button  clicked");
                        MeishuRewardVideoPlayerActivity.this.clkActType = 2;
                        MeishuRewardVideoPlayerActivity.this.clkPower = 0;
                        MeishuRewardVideoPlayerActivity.this.onClick();
                    }
                }
            };
            View view4 = ((e) iVarB4).d;
            if (view4 != null) {
                view4.setOnClickListener(onClickListener4);
            }
            i iVarB5 = this.bQuery.b(R.id.ms_download_button);
            View.OnClickListener onClickListener5 = new com.meishu.sdk.core.safe.o() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.5
                public void safeOnClick(View view5) {
                    if (MeishuRewardVideoPlayerActivity.this.isAdExposed) {
                        LogUtil.e(MeishuRewardVideoPlayerActivity.TAG, "download_button  clicked");
                        MeishuRewardVideoPlayerActivity.this.clkActType = 2;
                        MeishuRewardVideoPlayerActivity.this.clkPower = 0;
                        MeishuRewardVideoPlayerActivity.this.onClick();
                    }
                }
            };
            View view5 = ((e) iVarB5).d;
            if (view5 != null) {
                view5.setOnClickListener(onClickListener5);
            }
        } else {
            i iVarB6 = this.bQuery.b(R.id.ms_fullscreen_clickable_range);
            View.OnClickListener onClickListener6 = new com.meishu.sdk.core.safe.o() { // from class: com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity.6
                public void safeOnClick(View view6) {
                    if (MeishuRewardVideoPlayerActivity.this.isAdExposed) {
                        MeishuRewardVideoPlayerActivity.this.clkActType = 1;
                        MeishuRewardVideoPlayerActivity.this.clkPower = 0;
                        MeishuRewardVideoPlayerActivity.this.onClick();
                    }
                }
            };
            View view6 = ((e) iVarB6).d;
            if (view6 != null) {
                view6.setOnClickListener(onClickListener6);
            }
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            this.bQuery.b(R.id.ms_reward_ad_title).a(stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            this.bQuery.b(R.id.ms_reward_ad_content).a(stringExtra2);
        }
        this.processBar = findViewById(R.id.ms_process_bar);
        this.webviewContainer = (RelativeLayout) findViewById(R.id.ms_reward_webview_container);
        if ((this.rewardTmpType == 1 && this.canDisplayRewardTemp) || this.canDisplayNewRewardTemp) {
            initWebView(this.video_keep_time);
        }
        if (this.image_src != null) {
            loadRewardImage();
        } else {
            loadRewardVideo();
        }
    }

    public void safeOnDestroy() {
        super.safeOnDestroy();
        GifImageView gifImageView = this.shakeImageView;
        if (gifImageView != null) {
            gifImageView.clear();
        }
        rewardEventUrlReport(21);
        baseFullScreenVideoAdList.clear();
        ad = null;
        clearRewardMediaView();
        this.keepTimeFinishListener = null;
        ShakeUtil.getInstance().a(this.shakeId);
        clearRewardTmp();
        d.b(this.appStateListener);
        removeCountDown();
        this.mHandler = null;
    }

    public void safeOnPause() {
        super.safeOnPause();
        this.isActivityPause = true;
        removeCountDown();
        notifyH5ActivityState("pause");
        if (this.isShake) {
            ShakeUtil.getInstance().e();
            ShakeUtil shakeUtil = ShakeUtil.getInstance();
            shakeUtil.getClass();
            try {
                float[] fArr = shakeUtil.f;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                shakeUtil.e = 0.0f;
                shakeUtil.x.clear();
                shakeUtil.y.clear();
                shakeUtil.z.clear();
                float[] fArr2 = shakeUtil.v;
                fArr2[0] = 0.0f;
                fArr2[1] = 0.0f;
                fArr2[2] = 0.0f;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void safeOnResume() {
        super.safeOnResume();
        this.isActivityPause = false;
        resumeCountDown();
        notifyH5ActivityState("resume");
        if (!isShowedRewardTemp() && this.isAdExposed) {
            startShakeAndTurn(false);
        }
        for (int i = 0; i < baseFullScreenVideoAdList.size(); i++) {
            IAd iAd = baseFullScreenVideoAdList.get(i);
            if (iAd != null) {
                this.touchContainer.setTouchPositionListener(new TouchPositionListener(iAd));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeCountDown(boolean z) {
        Handler handler;
        if ((!z && this.canDisplayRewardTemp && isShowedRewardTemp()) || (handler = this.mHandler) == null) {
            return;
        }
        if (this.image_src != null) {
            handler.removeCallbacks(this.updateTime);
            this.mHandler.post(this.updateTime);
        } else {
            handler.removeCallbacks(this.updateProcessRunnable);
            this.mHandler.post(this.updateProcessRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startShakeAndTurn(boolean z) {
        if (!this.isShakeInit) {
            this.isShakeInit = true;
            initShakeAndTurn(z);
        } else if (this.isShake && this.shakeResult == null) {
            if (z) {
                this.bQuery.b(R.id.ms_shake_root_view).d(8);
            } else {
                this.bQuery.b(R.id.ms_shake_root_view).d(0);
            }
            ShakeUtil.getInstance().f();
        }
    }
}
