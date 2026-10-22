package com.meishu.sdk.activity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.meishu.sdk.R;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.bquery.e;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.safe.SafeAppCompatActivity;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.ReflectUtil;
import com.meishu.sdk.core.utils.a0;
import com.meishu.sdk.core.utils.b1;
import com.meishu.sdk.core.utils.i0;
import com.meishu.sdk.core.utils.t1;
import com.meishu.sdk.core.view.MSDialog;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.core.webview.g;
import com.meishu.sdk.core.webview.q;
import com.meishu.sdk.core.webview.s;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.nativ.d;
import com.meishu.sdk.meishu_ad.nativ.f;
import com.meishu.sdk.platform.ms.splash.ShakeUtil;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class MeishuRewardH5Activity extends SafeAppCompatActivity {
    private static final int DEFAULT_TOTAL_TIME = 15000;
    private static final String TAG = "MeishuRewardH5Activity";
    private static f adSlot;
    private static d nativeAdData;
    private static s wrapper;
    private boolean attachWindow;
    private i bQuery;
    private volatile String curWebUrl;
    private t1 h5ClickChecker;
    private boolean isStarted;
    private Handler mHandler;
    private int mImageCurrentTime;
    private boolean onReward;
    private boolean oneHalfPerformed;
    private boolean oneQuarterPerformed;
    private boolean threeQuarterPerformed;
    private TouchAdContainer touchContainer;
    private int totalTime = DEFAULT_TOTAL_TIME;
    private final Runnable updateTime = new l() { // from class: com.meishu.sdk.activity.MeishuRewardH5Activity.6
        public void safeRun() {
            try {
                MeishuRewardH5Activity.access$1012(MeishuRewardH5Activity.this, 100);
                if (MeishuRewardH5Activity.this.mImageCurrentTime >= MeishuRewardH5Activity.this.totalTime) {
                    MeishuRewardH5Activity.this.onReward = true;
                    MeishuRewardH5Activity.this.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
                    MeishuRewardH5Activity.this.runOnUiThread(new l() { // from class: com.meishu.sdk.activity.MeishuRewardH5Activity.6.1
                        public void safeRun() {
                            super.safeRun();
                            View view = ((e) MeishuRewardH5Activity.this.bQuery.b(R.id.ms_reward_content_txt)).d;
                            if (view instanceof TextView) {
                                ((TextView) view).setText("恭喜已获得奖励");
                            }
                        }
                    });
                    b1.a(MeishuRewardH5Activity.adSlot, 17);
                    b1.a(MeishuRewardH5Activity.adSlot, 31);
                    MeishuRewardH5Activity.this.sendBroadcast("broadcast_onreward");
                    MeishuRewardH5Activity.this.onImageComplete();
                    MeishuRewardH5Activity.this.mHandler.removeCallbacks(MeishuRewardH5Activity.this.updateTime);
                    return;
                }
                final int i = MeishuRewardH5Activity.this.totalTime - MeishuRewardH5Activity.this.mImageCurrentTime;
                MeishuRewardH5Activity.this.runOnUiThread(new l() { // from class: com.meishu.sdk.activity.MeishuRewardH5Activity.6.2
                    public void safeRun() {
                        super.safeRun();
                        MeishuRewardH5Activity.this.updateCountDownText(Math.max(0, (i + 999) / 1000));
                    }
                });
                double d = (MeishuRewardH5Activity.this.mImageCurrentTime * 1.0f) / MeishuRewardH5Activity.this.totalTime;
                if (d < 0.25d || d >= 0.5d) {
                    if (d < 0.5d || d >= 0.75d) {
                        if (d >= 0.75d && d < 1.0d && !MeishuRewardH5Activity.this.threeQuarterPerformed) {
                            MeishuRewardH5Activity.this.ThreeQuarterReport();
                            MeishuRewardH5Activity.this.threeQuarterPerformed = true;
                        }
                    } else if (!MeishuRewardH5Activity.this.oneHalfPerformed) {
                        MeishuRewardH5Activity.this.OneHalfReport();
                        MeishuRewardH5Activity.this.oneHalfPerformed = true;
                    }
                } else if (!MeishuRewardH5Activity.this.oneQuarterPerformed) {
                    MeishuRewardH5Activity.this.OneQuarterReport();
                    MeishuRewardH5Activity.this.oneQuarterPerformed = true;
                }
                MeishuRewardH5Activity.this.mHandler.postDelayed(MeishuRewardH5Activity.this.updateTime, 100L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    public static /* synthetic */ int access$1012(MeishuRewardH5Activity meishuRewardH5Activity, int i) {
        int i2 = meishuRewardH5Activity.mImageCurrentTime + i;
        meishuRewardH5Activity.mImageCurrentTime = i2;
        return i2;
    }

    public static void clear() {
        s sVar = wrapper;
        if (sVar != null) {
            q.a(sVar.a);
            try {
                wrapper.b.g = null;
            } catch (Exception unused) {
            }
            try {
                g gVar = wrapper.c;
                gVar.getClass();
                try {
                    gVar.a.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception unused2) {
            }
        }
        wrapper = null;
        adSlot = null;
        nativeAdData = null;
    }

    private void initClickEvent(@NotNull i iVar) {
        i iVarB = iVar.b(R.id.ms_reward_close_button_parent);
        View.OnClickListener onClickListener = new o() { // from class: com.meishu.sdk.activity.MeishuRewardH5Activity.1
            public void safeOnClick(View view) {
                try {
                    if (MeishuRewardH5Activity.this.onReward) {
                        MeishuRewardH5Activity.this.sendBroadcast("broadcast_onclosed");
                        MeishuRewardH5Activity.this.finish();
                    } else {
                        b1.a(MeishuRewardH5Activity.adSlot, 18);
                        new MSDialog.Builder(MeishuRewardH5Activity.this).setTitle("完整观看即可获得奖励\n确认要离开吗？").setShowCloseBtn(true).setCanceledOnTouchOutside(false).setNegativeButton("放弃领取", new o() { // from class: com.meishu.sdk.activity.MeishuRewardH5Activity.1.2
                            public void safeOnClick(View view2) {
                                super.safeOnClick(view2);
                                b1.a(MeishuRewardH5Activity.adSlot, 19);
                                MeishuRewardH5Activity.this.sendBroadcast("broadcast_onclosed");
                                MeishuRewardH5Activity.this.finish();
                            }
                        }).setPositiveButton("继续浏览", new o() { // from class: com.meishu.sdk.activity.MeishuRewardH5Activity.1.1
                            public void safeOnClick(View view2) {
                                super.safeOnClick(view2);
                                b1.a(MeishuRewardH5Activity.adSlot, 20);
                            }
                        }).build().show();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        View view = ((e) iVarB).d;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        i iVarB2 = iVar.b(R.id.ms_reward_back_layout);
        View.OnClickListener onClickListener2 = new o() { // from class: com.meishu.sdk.activity.MeishuRewardH5Activity.2
            public void safeOnClick(View view2) {
                super.safeOnClick(view2);
                if (MeishuRewardH5Activity.wrapper == null || MeishuRewardH5Activity.wrapper.a == null || !MeishuRewardH5Activity.wrapper.a.canGoBack()) {
                    return;
                }
                if (!q.a(MeishuRewardH5Activity.wrapper.a.getUrl())) {
                    MeishuRewardH5Activity.wrapper.a.goBack();
                    return;
                }
                MeishuRewardH5Activity.wrapper.a.goBack();
                try {
                    MeishuRewardH5Activity.wrapper.a.goBack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        View view2 = ((e) iVarB2).d;
        if (view2 != null) {
            view2.setOnClickListener(onClickListener2);
        }
        this.touchContainer.setTouchPositionListener(new TouchPositionListener(nativeAdData) { // from class: com.meishu.sdk.activity.MeishuRewardH5Activity.3
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                if (MeishuRewardH5Activity.wrapper != null && MeishuRewardH5Activity.wrapper.b != null) {
                    MeishuRewardH5Activity.wrapper.b.f = true;
                }
                try {
                    return super.onTouch(view3, motionEvent);
                } finally {
                    if (motionEvent != null && motionEvent.getAction() == 1 && !q.a(MeishuRewardH5Activity.this.curWebUrl)) {
                        LogUtil.dev(MeishuRewardH5Activity.TAG, "touchContainer onClick");
                        if (isClickEvent(motionEvent.getX(), motionEvent.getY()) && MeishuRewardH5Activity.this.h5ClickChecker != null && MeishuRewardH5Activity.this.h5ClickChecker.a(motionEvent.getX(), motionEvent.getY())) {
                            com.meishu.sdk.core.utils.f.a(MeishuRewardH5Activity.nativeAdData, MeishuRewardH5Activity.adSlot);
                            MeishuRewardH5Activity.this.sendBroadcast("broadcast_onclick", true);
                        }
                    }
                }
            }
        });
        wrapper.b.g = new com.meishu.sdk.core.webview.listener.f() { // from class: com.meishu.sdk.activity.MeishuRewardH5Activity.4
            public void onDPStart() {
                com.meishu.sdk.core.utils.f.b(MeishuRewardH5Activity.adSlot, MeishuRewardH5Activity.nativeAdData);
                try {
                    b1.a(MeishuRewardH5Activity.adSlot, 22, 0, "dp_start");
                } catch (Exception unused) {
                }
            }

            public void onJumpDPRes(boolean z, boolean z2) {
                LogUtil.dev(MeishuRewardH5Activity.TAG, "onJumpDPRes:" + z + " showedSysDialog:" + z2);
                if (z) {
                    com.meishu.sdk.core.utils.f.a(MeishuRewardH5Activity.adSlot, MeishuRewardH5Activity.this, MeishuRewardH5Activity.nativeAdData, z2);
                    try {
                        b1.a(MeishuRewardH5Activity.adSlot, 23, 0, "dp_start");
                    } catch (Exception unused) {
                    }
                }
            }
        };
    }

    private void initStateByWebView() {
        g gVar;
        s sVar = wrapper;
        if (sVar != null && (gVar = sVar.c) != null) {
            gVar.a(new com.meishu.sdk.core.webview.listener.g() { // from class: com.meishu.sdk.activity.MeishuRewardH5Activity.5
                public boolean onPageFinished(String str, boolean z, boolean z2, int i) {
                    LogUtil.dev(MeishuRewardH5Activity.TAG, "onPageFinished: " + str + " code:" + i);
                    MeishuRewardH5Activity.this.curWebUrl = str;
                    return true;
                }

                public void onPageStarted(String str) {
                    MeishuRewardH5Activity.this.runOnUiThread(new l() { // from class: com.meishu.sdk.activity.MeishuRewardH5Activity.5.1
                        public void safeRun() {
                            super.safeRun();
                            MeishuRewardH5Activity.this.bQuery.b(R.id.ms_reward_back_layout).d(MeishuRewardH5Activity.wrapper.a.canGoBack() ? 0 : 8);
                        }
                    });
                }
            });
        }
        this.bQuery.b(R.id.ms_reward_back_layout).d(wrapper.a.canGoBack() ? 0 : 8);
    }

    public static boolean isValid(String str) {
        try {
            s sVar = wrapper;
            return (sVar == null || sVar.a == null || sVar.b == null || sVar.c == null || adSlot == null || nativeAdData == null || TextUtils.isEmpty(str) || !str.equals(adSlot.getReq_id())) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void pause() {
        try {
            this.mHandler.removeCallbacks(this.updateTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resume() {
        try {
            pause();
            if (this.onReward) {
                return;
            }
            this.mHandler.post(this.updateTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBroadcast(String str) {
        sendBroadcast(str, false);
    }

    public static void setRewardH5Data(s sVar, d dVar) {
        wrapper = sVar;
        nativeAdData = dVar;
        adSlot = dVar != null ? dVar.i : null;
        updateWebViewContext(AdSdk.getContext() != null ? AdSdk.getContext().getApplicationContext() : null);
        updateMediaViewContext(AdSdk.getContext() != null ? AdSdk.getContext().getApplicationContext() : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void startReport() {
        try {
            LogUtil.d(TAG, "send onVideoStart");
            if (this.isStarted) {
                return;
            }
            String[] strArr = adSlot.j;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        a0.a(this, i0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
            this.isStarted = true;
            b1.a(adSlot, 16);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void startUpdateProcess() {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        startReport();
        this.mHandler.post(this.updateTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCountDownText(int i) {
        this.bQuery.b(R.id.ms_reward_content_txt).a("奖励将于 " + i + " 秒后发放");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000d  */
    private static void updateMediaViewContext(Context context) {
        NormalMediaView normalMediaView;
        try {
            d dVar = nativeAdData;
            if (dVar != null) {
                NormalMediaView normalMediaView2 = dVar.h;
                if (normalMediaView2 instanceof NormalMediaView) {
                    normalMediaView = normalMediaView2;
                } else {
                    normalMediaView = null;
                }
            } else {
                normalMediaView = null;
            }
            if (normalMediaView != null && (normalMediaView.getContext() instanceof ContextWrapper)) {
                ReflectUtil.setValue(ContextWrapper.class, "mBase", normalMediaView.getContext(), context);
                LogUtil.d(TAG, "update m context");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateWebViewContext(Context context) {
        WebView webView;
        try {
            s sVar = wrapper;
            if (sVar == null || (webView = sVar.a) == null || !(webView.getContext() instanceof ContextWrapper)) {
                return;
            }
            ReflectUtil.setValue(ContextWrapper.class, "mBase", wrapper.a.getContext(), context);
            LogUtil.d(TAG, "update w context");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void OneHalfReport() {
        try {
            LogUtil.d(TAG, "send onVideoOneHalf");
            String[] strArr = adSlot.l;
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
            String[] strArr = adSlot.k;
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
            String[] strArr = adSlot.m;
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
        sendBroadcast("broadcast_on_video_complete");
        try {
            LogUtil.d(TAG, "send onVideoComplete");
            String[] strArr = adSlot.n;
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
    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        LogUtil.dev(TAG, "onWindowFocusChanged hasWindowFocus:" + z + " attachWindow:" + this.attachWindow);
        boolean z2 = this.attachWindow;
        if (z2 && z) {
            resume();
        } else {
            if (!z2 || z) {
                return;
            }
            pause();
        }
    }

    public void safeOnAttachedToWindow() {
        super.safeOnAttachedToWindow();
        this.attachWindow = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void safeOnCreate(Bundle bundle) {
        boolean z;
        super.safeOnCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(3330);
        ShakeUtil.getInstance().e();
        setContentView(R.layout.ms_activity_meishu_reward_h5);
        this.touchContainer = findViewById(R.id.ms_activity_reward_h5_touch_ad_container);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ms_reward_h5_container);
        this.h5ClickChecker = new t1(viewGroup);
        this.bQuery = new i(this);
        try {
            z = (getResources().getConfiguration().uiMode & 48) == 32;
        } catch (Exception unused) {
        }
        if (z) {
            View view = ((e) this.bQuery.b(R.id.ms_reward_h5_bg)).d;
            if (view != null) {
                view.setBackgroundColor(-16777216);
            }
            this.bQuery.b(R.id.ms_reward_back).c(R.drawable.ms_ic_back_white);
        } else {
            View view2 = ((e) this.bQuery.b(R.id.ms_reward_h5_bg)).d;
            if (view2 != null) {
                view2.setBackgroundColor(-1);
            }
            this.bQuery.b(R.id.ms_reward_back).c(R.drawable.ms_ic_back_black);
        }
        initClickEvent(this.bQuery);
        this.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
        i iVar = this.bQuery;
        int i = R.id.ms_include_ad_tag;
        i iVarA = iVar.a(i);
        int i2 = R.id.ms_img_meishu_ad_tag;
        i iVarB = iVarA.b(i2);
        int i3 = R.drawable.ms_bg_alpha_rect_40_radius4;
        View view3 = ((e) iVarB).d;
        if (view3 != null) {
            if (i3 != 0) {
                view3.setBackgroundResource(i3);
            } else {
                view3.setBackgroundDrawable(null);
            }
        }
        f fVar = adSlot;
        if (fVar != null && !TextUtils.isEmpty(fVar.getFromLogo())) {
            this.bQuery.a(i).b(i2).a(adSlot.getFromLogo(), false);
            this.bQuery.a(R.id.ms_include_ad_tag_end).b(i2).a(adSlot.getFromLogo(), false);
        }
        updateWebViewContext(this);
        initStateByWebView();
        viewGroup.addView(wrapper.a, new RelativeLayout.LayoutParams(-1, -1));
        long j = adSlot.i * 1000;
        if (j > 0) {
            this.totalTime = (int) j;
        } else {
            this.totalTime = DEFAULT_TOTAL_TIME;
        }
        updateCountDownText(this.totalTime / 1000);
        sendBroadcast("broadcast_on_video_start");
        startUpdateProcess();
    }

    public void safeOnDestroy() {
        super.safeOnDestroy();
        b1.a(adSlot, 21);
        clear();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.updateTime);
            this.mHandler = null;
        }
    }

    public void safeOnDetachedFromWindow() {
        super.safeOnDetachedFromWindow();
        this.attachWindow = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void sendBroadcast(String str, boolean z) {
        Intent intent = new Intent();
        intent.setAction(str);
        if (z) {
            intent.putExtra("clk_act_type", 1);
            intent.putExtra("clk_power", 0);
            intent.putExtra("image_width", 0);
            intent.putExtra("image_height", 0);
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
