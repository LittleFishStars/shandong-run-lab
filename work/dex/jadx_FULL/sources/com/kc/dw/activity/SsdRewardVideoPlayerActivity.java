package com.kc.dw.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.kc.dw.ad.a0;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.reward.CircleProcessBar;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.IAd;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.safe.SafeAppCompatActivity;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.DownloadDialogBean;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.h;
import com.kc.dw.core.utils.h0;
import com.kc.dw.core.utils.s1;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.utils.z;
import com.kc.dw.core.utils.z0;
import com.kc.dw.core.view.NoNavigationDialog;
import com.kc.dw.core.view.TouchAdContainer;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.dw.core.view.gif.GifImageView;
import com.kc.dw.core.webview.i;
import com.kc.dw.core.webview.l;
import com.kc.dw.core.webview.n;
import com.kc.dw.platform.ad_adapter.c;
import com.kc.dw.platform.ad_adapter.splash.ShakeResult;
import com.kc.dw.platform.ad_adapter.splash.ShakeUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdRewardVideoPlayerActivity extends SafeAppCompatActivity {
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
    public static final String Is_showWebDialog = "is_show_web_dialog";
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
    private static c ad = null;
    private static b adWrapper = null;
    private static DownloadDialogBean downloadBean = null;
    public static final String local_ad_id_key = "local_ad_id_key";
    private static NormalMediaView mediaView = null;
    public static final String orientation_key = "orientation_key";
    private static a0 rewardMediaView;
    private String actionText;
    private int adType;
    private d bQuery;
    private volatile boolean calledRewardError;
    private int clkActType;
    private int clkPower;
    private int clk_type;
    private String[] eventUrl;
    private boolean hasExposed;
    private int imageHeight;
    private int imageWidth;
    private String image_src;
    private int interaction_type;
    private boolean isAdExposed;
    private boolean isHideShakeView;
    private volatile Boolean isImgSuccess;
    private volatile boolean isRewardComplete;
    private volatile boolean isRewardTimeOver;
    private boolean isShake;
    private boolean isShakeInit;
    private boolean isShowWebDialog;
    private boolean isStarted;
    private boolean isWebStarted;
    private volatile boolean keepTimeFinish;
    private String localAdId;
    private Handler mHandler;
    private int mImageCurrentTime;
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
    private n rewardTmpWrapper;
    private int shakeId;
    private GifImageView shakeImageView;
    private ShakeResult shakeResult;
    private boolean threeQuarterPerformed;
    private TouchAdContainer touchContainer;
    private volatile boolean videoLoaded;
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
    private RelativeLayout webviewContainer;
    private static List<IAd> baseFullScreenVideoAdList = new ArrayList();
    private static boolean isMute = false;
    private int close_btn = 1;
    private int totalTime = 15000;
    private Runnable updateTime = new j(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.13
        public final SsdRewardVideoPlayerActivity this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                SsdRewardVideoPlayerActivity.access$4512(this.this$0, 100);
                this.this$0.processBar.a(this.this$0.mImageCurrentTime);
                if (this.this$0.mImageCurrentTime >= this.this$0.totalTime) {
                    this.this$0.onReward = true;
                    this.this$0.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
                    this.this$0.bQuery.b(R.id.ms_reward_skip_button).d(8);
                    this.this$0.processBar.setVisibility(8);
                    this.this$0.rewardBroadcast();
                    this.this$0.onImageComplete();
                    this.this$0.mHandler.removeCallbacks(this.this$0.updateTime);
                    return;
                }
                int unused = this.this$0.totalTime;
                int unused2 = this.this$0.mImageCurrentTime;
                double d = (this.this$0.mImageCurrentTime * 1.0f) / this.this$0.totalTime;
                if (d < 0.25d || d >= 0.5d) {
                    if (d < 0.5d || d >= 0.75d) {
                        if (d >= 0.75d && d < 1.0d && !this.this$0.threeQuarterPerformed) {
                            this.this$0.ThreeQuarterReport();
                            this.this$0.threeQuarterPerformed = true;
                        }
                    } else if (!this.this$0.oneHalfPerformed) {
                        this.this$0.OneHalfReport();
                        this.this$0.oneHalfPerformed = true;
                    }
                } else if (!this.this$0.oneQuarterPerformed) {
                    this.this$0.OneQuarterReport();
                    this.this$0.oneQuarterPerformed = true;
                }
                this.this$0.mHandler.postDelayed(this.this$0.updateTime, 100L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    public a0.b timeFinishListener = new a0.b(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.14
        public final SsdRewardVideoPlayerActivity this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.ad.a0.b
        public void onKeepTimeFinished() {
            if (this.this$0.keepTimeFinish) {
                return;
            }
            this.this$0.keepTimeFinish = true;
            this.this$0.onReward = true;
            this.this$0.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
            this.this$0.bQuery.b(R.id.ms_reward_skip_button).d(8);
            this.this$0.processBar.setVisibility(8);
            this.this$0.rewardBroadcast();
        }
    };
    private Runnable updateProcessRunnable = new j(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.20
        public final SsdRewardVideoPlayerActivity this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            if (this.this$0.onCompletedInvoked || SsdRewardVideoPlayerActivity.mediaView == null) {
                return;
            }
            this.this$0.processBar.a(SsdRewardVideoPlayerActivity.mediaView.getCurrentPosition());
            SsdRewardVideoPlayerActivity.mediaView.postDelayed(this, 100L);
        }
    };

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdRewardVideoPlayerActivity$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 extends m {
        public final SsdRewardVideoPlayerActivity this$0;

        public AnonymousClass1(SsdRewardVideoPlayerActivity ssdRewardVideoPlayerActivity) {
            this.this$0 = ssdRewardVideoPlayerActivity;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            try {
                if (!this.this$0.onReward && this.this$0.adType == AdType.REWARD.value()) {
                    if (SsdRewardVideoPlayerActivity.mediaView != null && SsdRewardVideoPlayerActivity.mediaView.d()) {
                        SsdRewardVideoPlayerActivity.mediaView.pause();
                    }
                    this.this$0.eventUrlReport(18);
                    NoNavigationDialog noNavigationDialog = new NoNavigationDialog(this.this$0);
                    noNavigationDialog.setTitle("观看完成即可获得奖励");
                    noNavigationDialog.setButton(-1, "继续观看", new com.kc.dw.core.safe.a(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.1.1
                        public final AnonymousClass1 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.safe.a
                        public void safeOnClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.this$1.this$0.eventUrlReport(20);
                            if (SsdRewardVideoPlayerActivity.mediaView == null || !SsdRewardVideoPlayerActivity.mediaView.d()) {
                                return;
                            }
                            SsdRewardVideoPlayerActivity.mediaView.resume();
                        }
                    });
                    noNavigationDialog.setButton(-2, "放弃奖励", new com.kc.dw.core.safe.a(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.1.2
                        public final AnonymousClass1 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.safe.a
                        public void safeOnClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.this$1.this$0.eventUrlReport(19);
                            SsdRewardVideoPlayerActivity ssdRewardVideoPlayerActivity = this.this$1.this$0;
                            ssdRewardVideoPlayerActivity.jumpEndCover(ssdRewardVideoPlayerActivity.actionText);
                        }
                    });
                    noNavigationDialog.show();
                    return;
                }
                SsdRewardVideoPlayerActivity ssdRewardVideoPlayerActivity = this.this$0;
                ssdRewardVideoPlayerActivity.jumpEndCover(ssdRewardVideoPlayerActivity.actionText);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdRewardVideoPlayerActivity$17, reason: invalid class name */
    @Keep
    public class AnonymousClass17 implements NativeAdMediaListener {
        public final SsdRewardVideoPlayerActivity this$0;
        public final long val$keepTime;

        public AnonymousClass17(SsdRewardVideoPlayerActivity ssdRewardVideoPlayerActivity, long j) {
            this.this$0 = ssdRewardVideoPlayerActivity;
            this.val$keepTime = j;
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onProgressUpdate(long j, long j2) {
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoCompleted() {
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoError() {
            if (this.this$0.isRewardTimeOver) {
                return;
            }
            this.this$0.sendBroadcast("broadcast_on_video_error", false);
            for (int i = 0; i < SsdRewardVideoPlayerActivity.baseFullScreenVideoAdList.size(); i++) {
                try {
                    if (((com.kc.dw.platform.ad_adapter.a) SsdRewardVideoPlayerActivity.baseFullScreenVideoAdList.get(i)) != null) {
                        SsdRewardVideoPlayerActivity.clearRewardMediaView();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.this$0.finish();
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoLoaded() {
            if (this.this$0.isRewardTimeOver) {
                return;
            }
            this.this$0.videoLoaded = true;
            this.this$0.startVideo(SsdRewardVideoPlayerActivity.rewardMediaView);
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoPause() {
            this.this$0.sendBroadcast("broadcast_on_video_pause", false);
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoResume() {
            this.this$0.sendBroadcast("broadcast_on_video_resume", false);
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoStart() {
            int duration;
            if (this.this$0.isRewardTimeOver || SsdRewardVideoPlayerActivity.mediaView == null) {
                return;
            }
            long j = this.val$keepTime;
            if (j <= 0 || j >= SsdRewardVideoPlayerActivity.mediaView.getDuration()) {
                duration = SsdRewardVideoPlayerActivity.mediaView.getDuration() > 0 ? SsdRewardVideoPlayerActivity.mediaView.getDuration() : 15000;
            } else {
                duration = (int) this.val$keepTime;
            }
            if (this.this$0.rewardTmpType == 2 && this.this$0.adType == AdType.REWARD.value()) {
                this.this$0.initWebView(duration);
            }
            this.this$0.processBar.setmTotalTime(duration);
            this.this$0.processBar.setOnSkipListener(new CircleProcessBar.a(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.17.1
                public final AnonymousClass17 this$1;

                {
                    this.this$1 = this;
                }

                @Override // com.kc.dw.ad.reward.CircleProcessBar.a
                public void onSkip() {
                    if (this.this$1.this$0.keepTimeFinish) {
                        return;
                    }
                    this.this$1.this$0.keepTimeFinish = true;
                    this.this$1.this$0.onReward = true;
                    this.this$1.this$0.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
                    this.this$1.this$0.bQuery.b(R.id.ms_reward_skip_button).d(8);
                    this.this$1.this$0.processBar.setVisibility(8);
                    this.this$1.this$0.rewardBroadcast();
                }
            });
            this.this$0.onAdExposed();
            this.this$0.rewardEventUrlReport(16);
            LogUtil.e(SsdRewardVideoPlayerActivity.TAG, "onVideoStart,isWebStarted=" + this.this$0.isWebStarted + ",mediaView=" + SsdRewardVideoPlayerActivity.mediaView);
            if (this.this$0.isWebStarted) {
                this.this$0.pauseVideo();
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdRewardVideoPlayerActivity$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 extends m {
        public final SsdRewardVideoPlayerActivity this$0;

        public AnonymousClass2(SsdRewardVideoPlayerActivity ssdRewardVideoPlayerActivity) {
            this.this$0 = ssdRewardVideoPlayerActivity;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            try {
                if (!this.this$0.onReward && this.this$0.adType == AdType.REWARD.value() && this.this$0.close_btn != 1) {
                    if (SsdRewardVideoPlayerActivity.mediaView != null && SsdRewardVideoPlayerActivity.mediaView.d()) {
                        SsdRewardVideoPlayerActivity.mediaView.pause();
                    }
                    this.this$0.eventUrlReport(18);
                    NoNavigationDialog noNavigationDialog = new NoNavigationDialog(this.this$0);
                    noNavigationDialog.setTitle("观看完成即可获得奖励");
                    noNavigationDialog.setButton(-1, "继续观看", new com.kc.dw.core.safe.a(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.2.1
                        public final AnonymousClass2 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.safe.a
                        public void safeOnClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.this$1.this$0.eventUrlReport(20);
                            if (SsdRewardVideoPlayerActivity.mediaView == null || !SsdRewardVideoPlayerActivity.mediaView.d()) {
                                return;
                            }
                            SsdRewardVideoPlayerActivity.mediaView.resume();
                        }
                    });
                    noNavigationDialog.setButton(-2, "放弃奖励", new com.kc.dw.core.safe.a(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.2.2
                        public final AnonymousClass2 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.safe.a
                        public void safeOnClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.this$1.this$0.eventUrlReport(19);
                            this.this$1.this$0.sendBroadcast("broadcast_onclosed", false);
                            this.this$1.this$0.finish();
                        }
                    });
                    noNavigationDialog.show();
                    return;
                }
                this.this$0.sendBroadcast("broadcast_onclosed", false);
                this.this$0.finish();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdRewardVideoPlayerActivity$8, reason: invalid class name */
    @Keep
    public class AnonymousClass8 implements i {
        public final SsdRewardVideoPlayerActivity this$0;

        public AnonymousClass8(SsdRewardVideoPlayerActivity ssdRewardVideoPlayerActivity) {
            this.this$0 = ssdRewardVideoPlayerActivity;
        }

        @Override // com.kc.dw.core.webview.i
        public void onClosePage() {
            this.this$0.webviewContainer.post(new Runnable(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.8.2
                public final AnonymousClass8 this$1;

                {
                    this.this$1 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!this.this$1.this$0.isShakeInit) {
                        this.this$1.this$0.initShakeAndTurn();
                    }
                    this.this$1.this$0.resumeVideo();
                    this.this$1.this$0.webviewContainer.removeAllViews();
                    this.this$1.this$0.webviewContainer.setVisibility(8);
                    if (this.this$1.this$0.onReward) {
                        SsdRewardVideoPlayerActivity ssdRewardVideoPlayerActivity = this.this$1.this$0;
                        ssdRewardVideoPlayerActivity.jumpEndCover(ssdRewardVideoPlayerActivity.actionText);
                    }
                }
            });
        }

        @Override // com.kc.dw.core.webview.i
        public void onRewardSuccess() {
            this.this$0.onReward = true;
            SsdRewardVideoPlayerActivity ssdRewardVideoPlayerActivity = this.this$0;
            ssdRewardVideoPlayerActivity.rewardBroadcast(1, ssdRewardVideoPlayerActivity.rewardTmpId);
        }

        @Override // com.kc.dw.core.webview.i
        public void onWebClicked() {
        }

        @Override // com.kc.dw.core.webview.i
        public void onWebError(int i, String str) {
        }

        @Override // com.kc.dw.core.webview.i
        public void onWebReady(boolean z) {
            if (this.this$0.isShakeInit) {
                this.this$0.rewardTmpLoadRes = Boolean.FALSE;
                return;
            }
            if (this.this$0.rewardTmpLoadRes != null) {
                return;
            }
            this.this$0.rewardTmpLoadRes = Boolean.valueOf(z);
            WebView webView = this.this$0.rewardTmpWrapper != null ? this.this$0.rewardTmpWrapper.f39449a : null;
            if (webView == null) {
                this.this$0.rewardTmpLoadRes = Boolean.FALSE;
                this.this$0.onLoadRewardTmpRes(false);
            } else if (z) {
                this.this$0.isWebStarted = true;
                this.this$0.webviewContainer.post(new Runnable(this, webView) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.8.1
                    public final AnonymousClass8 this$1;
                    public final WebView val$webView;

                    {
                        this.this$1 = this;
                        this.val$webView = webView;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (this.val$webView.getParent() != null) {
                            return;
                        }
                        this.this$1.this$0.pauseVideo();
                        this.this$1.this$0.showProgressBar();
                        this.this$1.this$0.hideShakeView();
                        this.this$1.this$0.webviewContainer.setVisibility(0);
                        this.this$1.this$0.webviewContainer.addView(this.val$webView, -1, -1);
                        this.this$1.this$0.onLoadRewardTmpRes(true);
                    }
                });
            } else {
                SsdRewardVideoPlayerActivity ssdRewardVideoPlayerActivity = this.this$0;
                ssdRewardVideoPlayerActivity.onLoadRewardTmpRes(ssdRewardVideoPlayerActivity.rewardTmpLoadRes.booleanValue());
            }
        }
    }

    public static /* synthetic */ int access$4512(SsdRewardVideoPlayerActivity ssdRewardVideoPlayerActivity, int i) {
        int i2 = ssdRewardVideoPlayerActivity.mImageCurrentTime + i;
        ssdRewardVideoPlayerActivity.mImageCurrentTime = i2;
        return i2;
    }

    public static void clearRewardMediaView() {
        NormalMediaView normalMediaView = mediaView;
        if (normalMediaView != null) {
            normalMediaView.c();
            mediaView = null;
        }
        rewardMediaView = null;
    }

    private void clearRewardTmp() {
        try {
            n nVar = this.rewardTmpWrapper;
            if (nVar != null) {
                l.a(nVar.f39449a);
                try {
                    this.rewardTmpWrapper.b.g = null;
                } catch (Exception unused) {
                }
                try {
                    this.rewardTmpWrapper.c.a((com.kc.dw.core.webview.listener.a) null);
                } catch (Exception unused2) {
                }
            }
            this.rewardTmpWrapper = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void closeWebView() {
        try {
            RelativeLayout relativeLayout = this.webviewContainer;
            if (relativeLayout != null) {
                WebView webView = (WebView) relativeLayout.getChildAt(0);
                this.webviewContainer.removeAllViews();
                this.webviewContainer.setVisibility(8);
                l.a(webView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eventUrlReport(int i) {
        try {
            if (this.adType != AdType.REWARD.value()) {
                return;
            }
            s1.a(this.eventUrl, i, 0, z0.a(this.image_src != null ? 1 : 2, ""));
        } catch (Exception e) {
            e.printStackTrace();
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

    private void handleDownloadView(int i) {
        if (i == 1) {
            try {
                if (downloadBean == null) {
                    return;
                }
                TextView textView = (TextView) findViewById(R.id.ssd_download_layer_textview);
                textView.setVisibility(0);
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(downloadBean.getApp_name())) {
                    sb.append("应用名称：");
                    sb.append(downloadBean.getApp_name());
                    sb.append(" | ");
                }
                if (!TextUtils.isEmpty(downloadBean.getApp_ver())) {
                    sb.append("应用版本：");
                    sb.append(downloadBean.getApp_ver());
                    sb.append(" | ");
                }
                if (!TextUtils.isEmpty(downloadBean.getApp_size())) {
                    sb.append("应用大小：");
                    sb.append(downloadBean.getApp_size());
                    sb.append(" | ");
                }
                if (!TextUtils.isEmpty(downloadBean.getDeveloper())) {
                    sb.append("开发者：");
                    sb.append(downloadBean.getDeveloper());
                    sb.append(" | ");
                }
                if (!TextUtils.isEmpty(downloadBean.getApp_permission_url()) || downloadBean.getApp_permission() != null) {
                    sb.append(" 权限详情>");
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(downloadBean.getApp_private_agreement())) {
                    sb.append(" 隐私协议 > ");
                    sb.append(" |");
                }
                if (!TextUtils.isEmpty(downloadBean.getApp_intor_url()) || !TextUtils.isEmpty(downloadBean.getApp_intro())) {
                    sb.append(" 功能介绍>");
                }
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    textView.setVisibility(8);
                } else if (string.endsWith("|")) {
                    string.substring(0, string.length() - 1);
                }
                textView.setText(string);
                textView.setOnClickListener(new m(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.21
                    public final SsdRewardVideoPlayerActivity this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // com.kc.dw.core.safe.m
                    public void safeOnClick(View view) {
                        try {
                            if (SsdRewardVideoPlayerActivity.downloadBean != null) {
                                SsdDownloadDetailActivity.startActivity(this.this$0, SsdRewardVideoPlayerActivity.downloadBean);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNotReady() {
        try {
            if (this.rewardTmpLoadRes == null) {
                this.rewardTmpLoadRes = Boolean.FALSE;
                onLoadRewardTmpRes(false);
            } else if (this.rewardTmpLoadRes.booleanValue()) {
                return;
            }
            if (this.rewardTmpType == 1 && this.rewardTmpId != 0 && this.adType == AdType.REWARD.value()) {
                try {
                    if (TextUtils.isEmpty(this.image_src)) {
                        ((NormalMediaView) rewardMediaView.getVideoView()).start();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.adType == AdType.REWARD.value()) {
                    this.processBar.setVisibility(0);
                }
                if (!this.isShakeInit) {
                    initShakeAndTurn();
                }
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.post(this.updateTime);
                }
                NormalMediaView normalMediaView = mediaView;
                if (normalMediaView != null) {
                    normalMediaView.setRewardWeb(false);
                }
                RelativeLayout relativeLayout = this.webviewContainer;
                if (relativeLayout != null) {
                    relativeLayout.removeAllViews();
                    this.webviewContainer.setVisibility(8);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideShakeView() {
        LogUtil.e(TAG, "showRewardWeb, pauseVideo");
        this.isHideShakeView = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0066 A[Catch: Exception -> 0x00b9, TryCatch #0 {Exception -> 0x00b9, blocks: (B:2:0x0000, B:4:0x0022, B:6:0x002b, B:9:0x0032, B:17:0x004e, B:19:0x0066, B:21:0x0074, B:23:0x0077, B:24:0x0081, B:26:0x0085, B:27:0x008f, B:11:0x003a, B:13:0x0042), top: B:32:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0085 A[Catch: Exception -> 0x00b9, TryCatch #0 {Exception -> 0x00b9, blocks: (B:2:0x0000, B:4:0x0022, B:6:0x002b, B:9:0x0032, B:17:0x004e, B:19:0x0066, B:21:0x0074, B:23:0x0077, B:24:0x0081, B:26:0x0085, B:27:0x008f, B:11:0x003a, B:13:0x0042), top: B:32:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:35:? A[RETURN, SYNTHETIC] */
    public void initShakeAndTurn() {
        String str;
        int iA;
        byte[] imageBytes;
        try {
            TextView textView = (TextView) findViewById(R.id.ms_shake_text_bottom);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ms_shake_root_view);
            int i = this.adType;
            AdType adType = AdType.REWARD;
            if (i == adType.value()) {
                if (!h.d(this.clk_type)) {
                    if (h.e(this.clk_type)) {
                        str = this.interaction_type == 1 ? "扭一扭或点击下载三方应用" : "扭一扭或点击查看详情";
                    }
                    adType.value();
                    h.a();
                    iA = h.a(this.clk_type, adType.value());
                    this.clk_type = iA;
                    if (h.c(iA)) {
                        this.isShake = true;
                        linearLayout.setVisibility(0);
                        imageBytes = getImageBytes(this, R.raw.ssd_new_shake);
                        if (imageBytes != null && imageBytes.length > 0) {
                            this.shakeImageView.setBytes(imageBytes, 1);
                            this.shakeImageView.startAnimation();
                        }
                        if (this.shakeId == 0) {
                            this.shakeId = ShakeUtil.getInstance().b();
                        }
                        ShakeUtil.getInstance().a(this.power_index2, this.power_index, h.b(this.clk_type), this.power_delay, this.power_count, this.shakeId, 0, new ShakeUtil.c(this, System.currentTimeMillis(), linearLayout) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.10
                            public final SsdRewardVideoPlayerActivity this$0;
                            public final LinearLayout val$shakeRootView;
                            public final long val$startShakeTime;

                            {
                                this.this$0 = this;
                                this.val$startShakeTime = j;
                                this.val$shakeRootView = linearLayout;
                            }

                            @Override // com.kc.dw.platform.ad_adapter.splash.ShakeUtil.c
                            public void onShake(int i2, boolean z, int i3, ShakeResult shakeResult) {
                                try {
                                    this.this$0.clkActType = i2;
                                    this.this$0.clkPower = i3;
                                    if (shakeResult != null) {
                                        shakeResult.setTotalTurnTime(System.currentTimeMillis() - this.val$startShakeTime);
                                    }
                                    this.this$0.shakeResult = shakeResult;
                                    this.this$0.onClick();
                                    if (this.this$0.shakeImageView != null) {
                                        this.this$0.shakeImageView.clear();
                                        this.val$shakeRootView.setVisibility(8);
                                    }
                                    ShakeUtil.getInstance().a(this.this$0.shakeId);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        ShakeUtil.getInstance().a(true);
                    }
                }
                str = this.interaction_type == 1 ? "摇一摇或点击下载三方应用" : "摇一摇或点击查看详情";
                textView.setText(str);
                adType.value();
                h.a();
                iA = h.a(this.clk_type, adType.value());
                this.clk_type = iA;
                if (h.c(iA)) {
                    this.isShake = true;
                    linearLayout.setVisibility(0);
                    imageBytes = getImageBytes(this, R.raw.ssd_new_shake);
                    if (imageBytes != null) {
                        this.shakeImageView.setBytes(imageBytes, 1);
                        this.shakeImageView.startAnimation();
                    }
                    if (this.shakeId == 0) {
                        this.shakeId = ShakeUtil.getInstance().b();
                    }
                    ShakeUtil.getInstance().a(this.power_index2, this.power_index, h.b(this.clk_type), this.power_delay, this.power_count, this.shakeId, 0, new ShakeUtil.c(this, System.currentTimeMillis(), linearLayout) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.10
                        public final SsdRewardVideoPlayerActivity this$0;
                        public final LinearLayout val$shakeRootView;
                        public final long val$startShakeTime;

                        {
                            this.this$0 = this;
                            this.val$startShakeTime = j;
                            this.val$shakeRootView = linearLayout;
                        }

                        @Override // com.kc.dw.platform.ad_adapter.splash.ShakeUtil.c
                        public void onShake(int i2, boolean z, int i3, ShakeResult shakeResult) {
                            try {
                                this.this$0.clkActType = i2;
                                this.this$0.clkPower = i3;
                                if (shakeResult != null) {
                                    shakeResult.setTotalTurnTime(System.currentTimeMillis() - this.val$startShakeTime);
                                }
                                this.this$0.shakeResult = shakeResult;
                                this.this$0.onClick();
                                if (this.this$0.shakeImageView != null) {
                                    this.this$0.shakeImageView.clear();
                                    this.val$shakeRootView.setVisibility(8);
                                }
                                ShakeUtil.getInstance().a(this.this$0.shakeId);
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
    public void initWebView(long j) {
        boolean z = this.isShowWebDialog;
        if (!z) {
            this.rewardTmpLoadRes = Boolean.FALSE;
            return;
        }
        if (z && this.rewardTmpType == 2) {
            if (((long) this.rewardTmpTime) * 1000 > j) {
                this.rewardTmpLoadRes = Boolean.FALSE;
                return;
            }
        }
        SdkHandler.getInstance().postDelay(new j(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.7
            public final SsdRewardVideoPlayerActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                super.safeRun();
                this.this$0.handleNotReady();
            }
        }, 3000L);
        l lVar = new l();
        lVar.g = new AnonymousClass8(this);
        this.rewardTmpWrapper = lVar.a(this, this.rewardTmpUrl, ad, true, new com.kc.dw.core.webview.listener.c(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.9
            public final SsdRewardVideoPlayerActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.webview.listener.c
            public boolean onPageFinished(String str, boolean z2, boolean z3, int i) {
                return false;
            }

            @Override // com.kc.dw.core.webview.listener.c
            public void onPageStarted(String str) {
            }
        });
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

    private boolean isShowedRewardTemp() {
        RelativeLayout relativeLayout = this.webviewContainer;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpEndCover(String str) {
        NormalMediaView normalMediaView = mediaView;
        if (normalMediaView != null) {
            normalMediaView.N = true;
            normalMediaView.j();
            normalMediaView.e();
        }
        this.onCompletedInvoked = true;
        this.onReward = true;
        this.bQuery.b(R.id.ms_video_playing_ad_info_container).d(8);
        this.bQuery.b(R.id.ms_ad_info_container).d(0);
        View view = this.bQuery.b(R.id.ms_download_button).d;
        if (view instanceof TextView) {
            ((TextView) view).setText(str);
        }
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
    public void loadImageError() {
        this.isImgSuccess = Boolean.FALSE;
        this.videoLoaded = false;
        if ((this.isShowWebDialog && this.rewardTmpType == 1 && (this.rewardTmpLoadRes == null || Boolean.TRUE.equals(this.rewardTmpLoadRes))) || this.calledRewardError) {
            return;
        }
        this.calledRewardError = true;
        sendBroadcast("broadcast_on_video_error", false);
        for (int i = 0; i < baseFullScreenVideoAdList.size(); i++) {
            try {
                if (((com.kc.dw.platform.ad_adapter.a) baseFullScreenVideoAdList.get(i)) != null) {
                    clearRewardMediaView();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        finish();
    }

    private void loadRewardImage() {
        try {
            this.rewardImageview = (GifImageView) findViewById(R.id.ms_reward_ad_image);
            findViewById(R.id.ms_reward_voice_button).setVisibility(8);
            SdkHandler.getInstance().postDelay(new Runnable(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.11
                public final SsdRewardVideoPlayerActivity this$0;

                {
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.this$0.isRewardTimeOver = true;
                    if (this.this$0.isImgSuccess.booleanValue()) {
                        return;
                    }
                    this.this$0.loadImageError();
                }
            }, 3000L);
            c0.a(this.image_src, new x(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.12
                public final SsdRewardVideoPlayerActivity this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.dw.core.utils.x
                public void onFailure(IOException iOException) {
                    this.this$0.loadImageError();
                }

                @Override // com.kc.dw.core.utils.x
                public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                    byte[] responseBody;
                    int gifWidth;
                    int gifHeight;
                    try {
                        if (!httpResponse.isSuccessful() || (responseBody = httpResponse.getResponseBody()) == null || responseBody.length <= 0 || responseBody.length >= h0.a()) {
                            this.this$0.loadImageError();
                            return;
                        }
                        this.this$0.isImgSuccess = Boolean.TRUE;
                        if (this.this$0.isRewardTimeOver) {
                            return;
                        }
                        if (!this.this$0.isGif(responseBody)) {
                            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                            if (bitmapDecodeByteArray == null) {
                                this.this$0.loadImageError();
                                return;
                            }
                            int width = bitmapDecodeByteArray.getWidth();
                            int height = bitmapDecodeByteArray.getHeight();
                            this.this$0.rewardImageview.setImageBitmap(bitmapDecodeByteArray);
                            gifWidth = width;
                            gifHeight = height;
                        } else if (this.this$0.rewardImageview != null) {
                            this.this$0.rewardImageview.setBytes(responseBody);
                            gifWidth = this.this$0.rewardImageview.getGifWidth();
                            gifHeight = this.this$0.rewardImageview.getGifHeight();
                            this.this$0.rewardImageview.startAnimation();
                        } else {
                            gifWidth = 0;
                            gifHeight = 0;
                        }
                        this.this$0.imageWidth = gifWidth;
                        this.this$0.imageHeight = gifHeight;
                        DisplayMetrics displayMetrics = this.this$0.getResources().getDisplayMetrics();
                        ViewGroup.LayoutParams layoutParams = this.this$0.rewardImageview.getLayoutParams();
                        int i = displayMetrics.widthPixels;
                        layoutParams.width = i;
                        if (gifWidth <= 0 || gifHeight <= 0) {
                            layoutParams.height = displayMetrics.heightPixels - 100;
                        } else {
                            layoutParams.height = Math.min((i * gifHeight) / gifWidth, displayMetrics.heightPixels - 100);
                        }
                        this.this$0.rewardImageview.setLayoutParams(layoutParams);
                        long j = this.this$0.video_keep_time * 1000;
                        if (j > 0) {
                            this.this$0.totalTime = (int) j;
                        } else {
                            this.this$0.totalTime = 15000;
                        }
                        if (this.this$0.rewardTmpType == 2 && this.this$0.adType == AdType.REWARD.value()) {
                            SsdRewardVideoPlayerActivity ssdRewardVideoPlayerActivity = this.this$0;
                            ssdRewardVideoPlayerActivity.initWebView(ssdRewardVideoPlayerActivity.totalTime);
                        }
                        this.this$0.processBar.setmTotalTime(this.this$0.totalTime);
                        if (this.this$0.adType == AdType.REWARD.value()) {
                            this.this$0.processBar.setVisibility(0);
                        }
                        com.kc.dw.core.service.logrecord.a.a(5, "e7", SsdRewardVideoPlayerActivity.adWrapper);
                        this.this$0.onAdExposed();
                        this.this$0.startUpdateProcess();
                    } catch (Throwable unused) {
                        this.this$0.loadImageError();
                    }
                }
            });
        } catch (Throwable th) {
            loadImageError();
            th.printStackTrace();
        }
    }

    private void loadRewardVideo() {
        try {
            this.mediaViewContainer = (ViewGroup) findViewById(R.id.ms_media_video);
            a0 a0Var = rewardMediaView;
            if (a0Var == null) {
                loadImageError();
                return;
            }
            NormalMediaView normalMediaView = (NormalMediaView) a0Var.getVideoView();
            mediaView = normalMediaView;
            normalMediaView.setActivityForLifecycle(this);
            try {
                if (mediaView != null) {
                    if (isMute) {
                        this.bQuery.b(R.id.ms_reward_voice_button).c(R.drawable.ssd_voice_closed);
                        mediaView.f();
                    } else {
                        this.bQuery.b(R.id.ms_reward_voice_button).c(R.drawable.ssd_voice_open);
                        mediaView.i();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            mediaView.post(this.updateProcessRunnable);
            mediaView.setVideoCover(this.video_cover);
            mediaView.setVideoEndCover(this.video_endcover);
            mediaView.setVideoCoverScaleType(ImageView.ScaleType.CENTER_CROP);
            mediaView.post(new j(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.15
                public final SsdRewardVideoPlayerActivity this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.dw.core.safe.j
                public void safeRun() {
                    SsdRewardVideoPlayerActivity.mediaView.b();
                }
            });
            if (this.isShowWebDialog && this.rewardTmpType == 1) {
                mediaView.setProgressLoadingVisible(false);
            } else {
                mediaView.setProgressLoadingVisible(true);
            }
            long j = this.video_keep_time * 1000;
            rewardMediaView.a(this.timeFinishListener, j);
            rewardMediaView.a(new a0.a(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.16
                public final SsdRewardVideoPlayerActivity this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.dw.ad.a0.a
                public void onCompleted() {
                    this.this$0.onCompletedInvoked = true;
                    this.this$0.onReward = true;
                    this.this$0.bQuery.b(R.id.ms_video_playing_ad_info_container).d(8);
                    this.this$0.bQuery.b(R.id.ms_ad_info_container).d(0);
                    this.this$0.bQuery.b(R.id.ms_download_button).a((CharSequence) this.this$0.actionText);
                    this.this$0.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
                    this.this$0.bQuery.b(R.id.ms_reward_skip_button).d(8);
                    this.this$0.bQuery.b(R.id.ms_include_ad_tag).d(8);
                    this.this$0.bQuery.b(R.id.ms_include_ad_tag_end).d(0);
                    this.this$0.sendBroadcast("broadcast_on_video_complete", false);
                    this.this$0.processBar.setVisibility(8);
                    this.this$0.rewardBroadcast();
                }
            });
            this.mediaViewContainer.removeAllViews();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            if (mediaView.getParent() != null && (mediaView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) mediaView.getParent()).removeView(mediaView);
            }
            this.mediaViewContainer.addView(mediaView, layoutParams);
            com.kc.dw.ad.nativ.i iVar = new com.kc.dw.ad.nativ.i();
            new com.kc.dw.ad.nativ.i.a(iVar);
            iVar.j = this.video_start;
            iVar.k = this.video_one_quarter;
            iVar.l = this.video_one_half;
            iVar.m = this.video_three_quarter;
            iVar.n = this.video_complete;
            iVar.o = this.video_pause;
            iVar.p = this.video_resume;
            iVar.t = this.video_skip;
            iVar.u = this.video_close;
            iVar.q = this.video_mute;
            iVar.r = this.video_unmute;
            iVar.s = this.video_replay;
            try {
                c cVar = ad;
                if (cVar != null && (cVar.a() instanceof BaseAdSlot)) {
                    iVar.setAppendInfo(((BaseAdSlot) ad.a()).getAppendInfo());
                }
            } catch (Exception unused) {
            }
            rewardMediaView.setNativeAdMediaListener(new com.kc.dw.platform.ad_adapter.recycler.d(iVar, new AnonymousClass17(this, j)));
            com.kc.dw.core.service.logrecord.a.a(5, "e7", adWrapper);
            if (!rewardMediaView.a()) {
                SdkHandler.getInstance().postDelay(new Runnable(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.18
                    public final SsdRewardVideoPlayerActivity this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (this.this$0.videoLoaded) {
                            return;
                        }
                        this.this$0.isRewardTimeOver = true;
                        this.this$0.loadImageError();
                    }
                }, 3000L);
            } else {
                startVideo(rewardMediaView);
                this.videoLoaded = true;
            }
        } catch (Throwable unused2) {
            loadImageError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdExposed() {
        if (this.isAdExposed) {
            return;
        }
        this.isAdExposed = true;
        sendBroadcast("broadcast_on_video_start", false);
        if (this.rewardTmpType == 0) {
            initShakeAndTurn();
        } else {
            this.webviewContainer.postDelayed(new Runnable(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.19
                public final SsdRewardVideoPlayerActivity this$0;

                {
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.this$0.isWebStarted || this.this$0.isShakeInit) {
                        return;
                    }
                    this.this$0.isShakeInit = true;
                    this.this$0.initShakeAndTurn();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick() {
        if (this.image_src != null) {
            new SoftReference(this);
        } else {
            NormalMediaView normalMediaView = mediaView;
            if (normalMediaView == null || !normalMediaView.b.j) {
                return;
            } else {
                new SoftReference(this);
            }
        }
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
                return;
            }
        } else if (this.videoLoaded) {
            return;
        }
        loadImageError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        StringBuilder sbA = a.a("showRewardWeb, pauseVideo,video_keep_time=");
        sbA.append(this.video_keep_time);
        LogUtil.e(TAG, sbA.toString());
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.updateTime);
        }
        NormalMediaView normalMediaView = mediaView;
        if (normalMediaView != null) {
            normalMediaView.setRewardWeb(true);
            if (mediaView.d()) {
                mediaView.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeVideo() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(this.updateTime);
        }
        NormalMediaView normalMediaView = mediaView;
        if (normalMediaView != null) {
            normalMediaView.resume();
            mediaView.setRewardWeb(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewardBroadcast() {
        rewardBroadcast(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewardBroadcast(int i, int i2) {
        if (this.isRewardComplete) {
            return;
        }
        this.isRewardComplete = true;
        rewardTimeEndReport(i, i2);
        sendBroadcast("broadcast_onreward", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewardEventUrlReport(int i) {
        try {
            if (this.adType != AdType.REWARD.value()) {
                return;
            }
            s1.a(this.eventUrl, i, 0, z0.a(this.image_src != null ? 1 : 2, ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void rewardTimeEndReport(int i, int i2) {
        try {
            if (this.adType != AdType.REWARD.value()) {
                return;
            }
            s1.a(this.eventUrl, 17, 0, z0.a(this.image_src != null ? 1 : 2, i, i2, ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBroadcast(String str, boolean z) {
        Intent intent = new Intent();
        intent.setAction(str);
        if (z) {
            intent.putExtra("clk_act_type", this.clkActType);
            intent.putExtra("clk_power", this.clkPower);
            ShakeResult shakeResult = this.shakeResult;
            if (shakeResult != null) {
                intent.putExtra("shake_result", shakeResult);
            }
            intent.putExtra("image_width", this.imageWidth);
            intent.putExtra("image_height", this.imageHeight);
            intent.putExtra("click_reward_tmp_id", isShowedRewardTemp() ? this.rewardTmpId : 0);
        }
        if ("broadcast_on_video_start".equals(str) && this.isShowWebDialog && this.rewardTmpType == 1) {
            intent.putExtra("report_exposure", true);
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public static void setAdWrapper(b bVar) {
        adWrapper = bVar;
    }

    public static void setDownloadDialogBean(DownloadDialogBean downloadDialogBean) {
        downloadBean = downloadDialogBean;
    }

    public static void setFullScreenAd(IAd iAd) {
        try {
            baseFullScreenVideoAdList.add(iAd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFullScreenAd(c cVar) {
        try {
            ad = cVar;
            baseFullScreenVideoAdList.add(cVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setMediaView(a0 a0Var) {
        rewardMediaView = a0Var;
    }

    public static void setVideoMute(boolean z) {
        isMute = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressBar() {
        if (this.rewardTmpType != 1 || this.rewardTmpId == 0) {
            return;
        }
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

    private void showWebView() {
    }

    private void startReport() {
        try {
            c cVar = ad;
            AdSlot adSlotA = cVar != null ? cVar.a() : null;
            if (com.kc.dw.core.utils.a.b(adSlotA)) {
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
                        z.a(this, g0.a(str), new com.kc.dw.core.utils.j());
                    }
                }
            }
            rewardEventUrlReport(16);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpdateProcess() {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        startReport();
        this.mHandler.post(this.updateTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideo(a0 a0Var) {
        if (this.rewardTmpType == 1 && this.rewardTmpId != 0 && this.adType == AdType.REWARD.value()) {
            return;
        }
        ((NormalMediaView) a0Var.getVideoView()).start();
        if (this.adType == AdType.REWARD.value()) {
            this.processBar.setVisibility(0);
        }
    }

    public void OneHalfReport() {
        try {
            LogUtil.d(TAG, "send onVideoOneHalf");
            String[] strArr = this.video_one_half;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this, g0.a(str), new com.kc.dw.core.utils.j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void OneQuarterReport() {
        try {
            LogUtil.d(TAG, "send onVideoOneQuarter");
            String[] strArr = this.video_one_quarter;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this, g0.a(str), new com.kc.dw.core.utils.j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ThreeQuarterReport() {
        try {
            LogUtil.d(TAG, "send onVideoThreeQuarter");
            String[] strArr = this.video_three_quarter;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this, g0.a(str), new com.kc.dw.core.utils.j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    public void onImageComplete() {
        this.bQuery.b(R.id.ms_video_playing_ad_info_container).d(8);
        this.bQuery.b(R.id.ms_ad_info_container).d(0);
        this.bQuery.b(R.id.ms_download_button).a((CharSequence) this.actionText);
        this.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
        this.bQuery.b(R.id.ms_reward_skip_button).d(8);
        this.bQuery.b(R.id.ms_include_ad_tag).d(8);
        this.bQuery.b(R.id.ms_include_ad_tag_end).d(0);
        sendBroadcast("broadcast_on_video_complete", false);
        try {
            LogUtil.d(TAG, "send onVideoComplete");
            String[] strArr = this.video_complete;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this, g0.a(str), new com.kc.dw.core.utils.j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnAttachedToWindow() {
        super.safeOnAttachedToWindow();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0179  */
    /* JADX WARN: Code duplicated, block: B:17:0x018f  */
    /* JADX WARN: Code duplicated, block: B:20:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:23:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:25:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:27:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:28:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:30:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:32:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:34:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:35:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:42:0x0219  */
    /* JADX WARN: Code duplicated, block: B:45:0x0220 A[Catch: Exception -> 0x0277, TryCatch #0 {Exception -> 0x0277, blocks: (B:43:0x021a, B:45:0x0220, B:46:0x0233, B:48:0x0239, B:50:0x024f, B:51:0x0263), top: B:89:0x021a }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0237  */
    /* JADX WARN: Code duplicated, block: B:56:0x027d  */
    /* JADX WARN: Code duplicated, block: B:59:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:62:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:64:0x0309  */
    /* JADX WARN: Code duplicated, block: B:68:0x0320  */
    /* JADX WARN: Code duplicated, block: B:70:0x0331 A[PHI: r2 r15
      0x0331: PHI (r2v6 com.kc.dw.core.safe.m) = (r2v5 com.kc.dw.core.safe.m), (r2v10 com.kc.dw.core.safe.m) binds: [B:69:0x032f, B:66:0x031d] A[DONT_GENERATE, DONT_INLINE]
      0x0331: PHI (r15v41 android.view.View) = (r15v40 android.view.View), (r15v66 android.view.View) binds: [B:69:0x032f, B:66:0x031d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:73:0x033a  */
    /* JADX WARN: Code duplicated, block: B:76:0x034d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0389  */
    /* JADX WARN: Code duplicated, block: B:87:0x038d  */
    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnCreate(Bundle bundle) {
        int i;
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        String stringExtra4;
        int intExtra;
        int intExtra2;
        int i2;
        AnonymousClass1 anonymousClass1;
        View view;
        int i3;
        AnonymousClass2 anonymousClass2;
        View view2;
        m mVar;
        View view3;
        TextView textView;
        int i4;
        AdType adType;
        int i5;
        d dVar;
        m mVar2;
        View view4;
        m mVar3;
        View view5;
        int i6;
        d dVarB;
        String str;
        super.safeOnCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(3330);
        ShakeUtil.getInstance().e();
        Intent intent = getIntent();
        int intExtra3 = intent.getIntExtra("orientation_key", 1);
        try {
            if (intExtra3 != 1) {
                if (intExtra3 == 2) {
                    i = R.layout.ssd_activity_reward_landscape_video;
                }
                this.touchContainer = (TouchAdContainer) findViewById(R.id.ms_activity_reward_video_touch_ad_container);
                this.bQuery = new d((Activity) this);
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
                stringExtra = intent.getStringExtra("Ad_title");
                stringExtra2 = intent.getStringExtra("Ad_content");
                stringExtra3 = intent.getStringExtra("Ad_icon_url");
                stringExtra4 = intent.getStringExtra("From_logo");
                intExtra = intent.getIntExtra("Clickable_range", -1);
                intExtra2 = intent.getIntExtra("Close_btn", 1);
                this.close_btn = intExtra2;
                if (intExtra2 != 0 && intExtra2 != 2) {
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
                this.isShowWebDialog = intent.getBooleanExtra(Is_showWebDialog, false);
                handleDownloadView(this.interaction_type);
                this.adType = intent.getIntExtra("Ad_type", -1);
                d dVar2 = this.bQuery;
                i2 = R.id.ms_reward_skip_button;
                d dVarB2 = dVar2.b(i2);
                anonymousClass1 = new AnonymousClass1(this);
                view = dVarB2.d;
                if (view != null) {
                    view.setOnClickListener(anonymousClass1);
                }
                d dVar3 = this.bQuery;
                i3 = R.id.ms_reward_close_button_parent;
                d dVarB3 = dVar3.b(i3);
                anonymousClass2 = new AnonymousClass2(this);
                view2 = dVarB3.d;
                if (view2 != null) {
                    view2.setOnClickListener(anonymousClass2);
                }
                d dVarB4 = this.bQuery.b(R.id.ms_reward_voice_button);
                mVar = new m(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.3
                    public final SsdRewardVideoPlayerActivity this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // com.kc.dw.core.safe.m
                    public void safeOnClick(View view6) {
                        try {
                            if (SsdRewardVideoPlayerActivity.mediaView != null && SsdRewardVideoPlayerActivity.mediaView.d()) {
                                if (SsdRewardVideoPlayerActivity.isMute) {
                                    boolean unused = SsdRewardVideoPlayerActivity.isMute = false;
                                    this.this$0.bQuery.b(R.id.ms_reward_voice_button).c(R.drawable.ssd_voice_open);
                                    SsdRewardVideoPlayerActivity.mediaView.i();
                                } else {
                                    boolean unused2 = SsdRewardVideoPlayerActivity.isMute = true;
                                    this.this$0.bQuery.b(R.id.ms_reward_voice_button).c(R.drawable.ssd_voice_closed);
                                    SsdRewardVideoPlayerActivity.mediaView.f();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                view3 = dVarB4.d;
                if (view3 != null) {
                    view3.setOnClickListener(mVar);
                }
                this.shakeImageView = (GifImageView) findViewById(R.id.ms_shake_img);
                textView = (TextView) findViewById(R.id.ms_shake_text_bottom);
                i4 = this.adType;
                adType = AdType.REWARD;
                if (i4 == adType.value()) {
                    if (h.d(this.clk_type)) {
                        if (h.e(this.clk_type)) {
                            if (this.interaction_type == 1) {
                                str = "扭一扭或点击下载三方应用";
                            } else {
                                str = "扭一扭或点击查看详情";
                            }
                        }
                        adType.value();
                        h.a();
                        this.clk_type = h.a(this.clk_type, adType.value());
                    } else if (this.interaction_type == 1) {
                        str = "摇一摇或点击下载三方应用";
                    } else {
                        str = "摇一摇或点击查看详情";
                    }
                    textView.setText(str);
                    adType.value();
                    h.a();
                    this.clk_type = h.a(this.clk_type, adType.value());
                }
                if (intExtra != 2 && intExtra != 1) {
                    intExtra = -1;
                }
                if (intExtra == -1) {
                    intExtra = 1;
                }
                i6 = this.close_btn;
                if (i6 == 0) {
                    this.bQuery.b(i2).d(8);
                    dVarB = this.bQuery.b(i3);
                } else if (i6 == 1 && i6 == 2) {
                    this.bQuery.b(i2).d(0);
                    dVarB = this.bQuery.b(i3);
                } else {
                    this.bQuery.b(i3).d(0);
                    dVarB = this.bQuery.b(i2);
                }
                dVarB.d(8);
                if (stringExtra4 != null) {
                    d dVarA = this.bQuery.a(R.id.ms_include_ad_tag);
                    int i7 = R.id.ssd_img_ad_tag;
                    dVarA.b(i7).a(stringExtra4, false);
                    this.bQuery.a(R.id.ms_include_ad_tag_end).b(i7).a(stringExtra4, false);
                }
                this.bQuery.b(R.id.ms_video_playing_reward_ad_title).a((CharSequence) stringExtra);
                this.bQuery.b(R.id.ms_video_playing_reward_ad_content).a((CharSequence) stringExtra2);
                d dVar4 = this.bQuery;
                i5 = R.id.ms_video_playing_download_button;
                dVar4.b(i5).a((CharSequence) this.actionText);
                if (stringExtra3 != null) {
                    this.bQuery.b(R.id.ms_reward_ad_icon).a(stringExtra3, false).d(0);
                    this.bQuery.b(R.id.ms_reward_ad_icon_end).a(stringExtra3, false).d(0);
                }
                dVar = this.bQuery;
                if (intExtra == 1) {
                    d dVarB5 = dVar.b(i5);
                    mVar3 = new m(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.4
                        public final SsdRewardVideoPlayerActivity this$0;

                        {
                            this.this$0 = this;
                        }

                        @Override // com.kc.dw.core.safe.m
                        public void safeOnClick(View view6) {
                            LogUtil.e(SsdRewardVideoPlayerActivity.TAG, "video_playing_download_button  clicked");
                            this.this$0.clkActType = 2;
                            this.this$0.clkPower = 0;
                            this.this$0.onClick();
                        }
                    };
                    view5 = dVarB5.d;
                    if (view5 != null) {
                        view5.setOnClickListener(mVar3);
                    }
                    d dVarB6 = this.bQuery.b(R.id.ms_download_button);
                    mVar2 = new m(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.5
                        public final SsdRewardVideoPlayerActivity this$0;

                        {
                            this.this$0 = this;
                        }

                        @Override // com.kc.dw.core.safe.m
                        public void safeOnClick(View view6) {
                            LogUtil.e(SsdRewardVideoPlayerActivity.TAG, "download_button  clicked");
                            this.this$0.clkActType = 2;
                            this.this$0.clkPower = 0;
                            this.this$0.onClick();
                        }
                    };
                    view4 = dVarB6.d;
                    if (view4 != null) {
                        view4.setOnClickListener(mVar2);
                    }
                } else {
                    d dVarB7 = dVar.b(R.id.ms_fullscreen_clickable_range);
                    mVar2 = new m(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.6
                        public final SsdRewardVideoPlayerActivity this$0;

                        {
                            this.this$0 = this;
                        }

                        @Override // com.kc.dw.core.safe.m
                        public void safeOnClick(View view6) {
                            this.this$0.clkActType = 1;
                            this.this$0.clkPower = 0;
                            this.this$0.onClick();
                        }
                    };
                    view4 = dVarB7.d;
                    if (view4 != null) {
                        view4.setOnClickListener(mVar2);
                    }
                }
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.bQuery.b(R.id.ms_reward_ad_title).a((CharSequence) stringExtra);
                }
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.bQuery.b(R.id.ms_reward_ad_content).a((CharSequence) stringExtra2);
                }
                this.processBar = (CircleProcessBar) findViewById(R.id.ms_process_bar);
                this.webviewContainer = (RelativeLayout) findViewById(R.id.ms_reward_webview_container);
                if (this.rewardTmpType == 1 && this.rewardTmpId != 0 && this.adType == AdType.REWARD.value()) {
                    initWebView(this.video_keep_time);
                }
                if (this.image_src != null) {
                    loadRewardImage();
                } else {
                    loadRewardVideo();
                }
            }
            i = R.layout.ssd_activity_reward_portrait_video;
            i6 = this.close_btn;
            if (i6 == 0) {
                this.bQuery.b(i2).d(8);
                dVarB = this.bQuery.b(i3);
            } else if (i6 == 1) {
                this.bQuery.b(i3).d(0);
                dVarB = this.bQuery.b(i2);
            } else {
                this.bQuery.b(i2).d(0);
                dVarB = this.bQuery.b(i3);
            }
            dVarB.d(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setContentView(i);
        this.touchContainer = (TouchAdContainer) findViewById(R.id.ms_activity_reward_video_touch_ad_container);
        this.bQuery = new d((Activity) this);
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
        stringExtra = intent.getStringExtra("Ad_title");
        stringExtra2 = intent.getStringExtra("Ad_content");
        stringExtra3 = intent.getStringExtra("Ad_icon_url");
        stringExtra4 = intent.getStringExtra("From_logo");
        intExtra = intent.getIntExtra("Clickable_range", -1);
        intExtra2 = intent.getIntExtra("Close_btn", 1);
        this.close_btn = intExtra2;
        if (intExtra2 != 0) {
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
        this.isShowWebDialog = intent.getBooleanExtra(Is_showWebDialog, false);
        handleDownloadView(this.interaction_type);
        this.adType = intent.getIntExtra("Ad_type", -1);
        d dVar5 = this.bQuery;
        i2 = R.id.ms_reward_skip_button;
        d dVarB8 = dVar5.b(i2);
        anonymousClass1 = new AnonymousClass1(this);
        view = dVarB8.d;
        if (view != null) {
            view.setOnClickListener(anonymousClass1);
        }
        d dVar6 = this.bQuery;
        i3 = R.id.ms_reward_close_button_parent;
        d dVarB9 = dVar6.b(i3);
        anonymousClass2 = new AnonymousClass2(this);
        view2 = dVarB9.d;
        if (view2 != null) {
            view2.setOnClickListener(anonymousClass2);
        }
        d dVarB10 = this.bQuery.b(R.id.ms_reward_voice_button);
        mVar = new m(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.3
            public final SsdRewardVideoPlayerActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.m
            public void safeOnClick(View view6) {
                try {
                    if (SsdRewardVideoPlayerActivity.mediaView != null && SsdRewardVideoPlayerActivity.mediaView.d()) {
                        if (SsdRewardVideoPlayerActivity.isMute) {
                            boolean unused = SsdRewardVideoPlayerActivity.isMute = false;
                            this.this$0.bQuery.b(R.id.ms_reward_voice_button).c(R.drawable.ssd_voice_open);
                            SsdRewardVideoPlayerActivity.mediaView.i();
                        } else {
                            boolean unused2 = SsdRewardVideoPlayerActivity.isMute = true;
                            this.this$0.bQuery.b(R.id.ms_reward_voice_button).c(R.drawable.ssd_voice_closed);
                            SsdRewardVideoPlayerActivity.mediaView.f();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
        view3 = dVarB10.d;
        if (view3 != null) {
            view3.setOnClickListener(mVar);
        }
        this.shakeImageView = (GifImageView) findViewById(R.id.ms_shake_img);
        textView = (TextView) findViewById(R.id.ms_shake_text_bottom);
        i4 = this.adType;
        adType = AdType.REWARD;
        if (i4 == adType.value()) {
            if (h.d(this.clk_type)) {
                if (h.e(this.clk_type)) {
                    if (this.interaction_type == 1) {
                        str = "扭一扭或点击下载三方应用";
                    } else {
                        str = "扭一扭或点击查看详情";
                    }
                }
                adType.value();
                h.a();
                this.clk_type = h.a(this.clk_type, adType.value());
            } else if (this.interaction_type == 1) {
                str = "摇一摇或点击下载三方应用";
            } else {
                str = "摇一摇或点击查看详情";
            }
            textView.setText(str);
            adType.value();
            h.a();
            this.clk_type = h.a(this.clk_type, adType.value());
        }
        if (intExtra != 2) {
            intExtra = -1;
        }
        if (intExtra == -1) {
            intExtra = 1;
        }
        if (stringExtra4 != null) {
            d dVarA2 = this.bQuery.a(R.id.ms_include_ad_tag);
            int i8 = R.id.ssd_img_ad_tag;
            dVarA2.b(i8).a(stringExtra4, false);
            this.bQuery.a(R.id.ms_include_ad_tag_end).b(i8).a(stringExtra4, false);
        }
        this.bQuery.b(R.id.ms_video_playing_reward_ad_title).a((CharSequence) stringExtra);
        this.bQuery.b(R.id.ms_video_playing_reward_ad_content).a((CharSequence) stringExtra2);
        d dVar7 = this.bQuery;
        i5 = R.id.ms_video_playing_download_button;
        dVar7.b(i5).a((CharSequence) this.actionText);
        if (stringExtra3 != null) {
            this.bQuery.b(R.id.ms_reward_ad_icon).a(stringExtra3, false).d(0);
            this.bQuery.b(R.id.ms_reward_ad_icon_end).a(stringExtra3, false).d(0);
        }
        dVar = this.bQuery;
        if (intExtra == 1) {
            d dVarB11 = dVar.b(i5);
            mVar3 = new m(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.4
                public final SsdRewardVideoPlayerActivity this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.dw.core.safe.m
                public void safeOnClick(View view6) {
                    LogUtil.e(SsdRewardVideoPlayerActivity.TAG, "video_playing_download_button  clicked");
                    this.this$0.clkActType = 2;
                    this.this$0.clkPower = 0;
                    this.this$0.onClick();
                }
            };
            view5 = dVarB11.d;
            if (view5 != null) {
                view5.setOnClickListener(mVar3);
            }
            d dVarB12 = this.bQuery.b(R.id.ms_download_button);
            mVar2 = new m(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.5
                public final SsdRewardVideoPlayerActivity this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.dw.core.safe.m
                public void safeOnClick(View view6) {
                    LogUtil.e(SsdRewardVideoPlayerActivity.TAG, "download_button  clicked");
                    this.this$0.clkActType = 2;
                    this.this$0.clkPower = 0;
                    this.this$0.onClick();
                }
            };
            view4 = dVarB12.d;
            if (view4 != null) {
                view4.setOnClickListener(mVar2);
            }
        } else {
            d dVarB13 = dVar.b(R.id.ms_fullscreen_clickable_range);
            mVar2 = new m(this) { // from class: com.kc.dw.activity.SsdRewardVideoPlayerActivity.6
                public final SsdRewardVideoPlayerActivity this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.dw.core.safe.m
                public void safeOnClick(View view6) {
                    this.this$0.clkActType = 1;
                    this.this$0.clkPower = 0;
                    this.this$0.onClick();
                }
            };
            view4 = dVarB13.d;
            if (view4 != null) {
                view4.setOnClickListener(mVar2);
            }
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            this.bQuery.b(R.id.ms_reward_ad_title).a((CharSequence) stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            this.bQuery.b(R.id.ms_reward_ad_content).a((CharSequence) stringExtra2);
        }
        this.processBar = (CircleProcessBar) findViewById(R.id.ms_process_bar);
        this.webviewContainer = (RelativeLayout) findViewById(R.id.ms_reward_webview_container);
        if (this.rewardTmpType == 1) {
            initWebView(this.video_keep_time);
        }
        if (this.image_src != null) {
            loadRewardImage();
        } else {
            loadRewardVideo();
        }
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnDestroy() {
        super.safeOnDestroy();
        GifImageView gifImageView = this.shakeImageView;
        if (gifImageView != null) {
            gifImageView.clear();
        }
        eventUrlReport(21);
        baseFullScreenVideoAdList.clear();
        clearRewardMediaView();
        adWrapper = null;
        this.timeFinishListener = null;
        ViewGroup viewGroup = this.mediaViewContainer;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ad = null;
        ShakeUtil.getInstance().a(this.shakeId);
        clearRewardTmp();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.updateTime);
            this.mHandler = null;
        }
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnPause() {
        super.safeOnPause();
        if (this.isShake) {
            ShakeUtil.getInstance().e();
        }
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnResume() {
        super.safeOnResume();
        if (this.isShake) {
            ShakeUtil.getInstance().f();
        }
        for (int i = 0; i < baseFullScreenVideoAdList.size(); i++) {
            IAd iAd = baseFullScreenVideoAdList.get(i);
            if (iAd != null) {
                this.touchContainer.setTouchPositionListener(new TouchPositionListener(iAd));
            }
        }
    }
}
