package com.kc.dw.activity;

import android.app.Activity;
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
import com.kc.dw.ad.a0;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.nativ.g;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.bquery.d;
import com.kc.dw.core.safe.SafeAppCompatActivity;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.ReflectUtil;
import com.kc.dw.core.utils.f;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.y1;
import com.kc.dw.core.utils.z;
import com.kc.dw.core.utils.z0;
import com.kc.dw.core.view.MSDialog;
import com.kc.dw.core.view.TouchAdContainer;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.dw.core.webview.e;
import com.kc.dw.core.webview.l;
import com.kc.dw.core.webview.listener.b;
import com.kc.dw.core.webview.listener.c;
import com.kc.dw.core.webview.n;
import com.kc.dw.platform.ad_adapter.splash.ShakeUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdRewardH5Activity extends SafeAppCompatActivity {
    private static final int DEFAULT_TOTAL_TIME = 15000;
    private static final String TAG = "SsdRewardH5Activity";
    private static i adSlot;
    private static g nativeAdData;
    private static n wrapper;
    private boolean attachWindow;
    private d bQuery;
    private volatile String curWebUrl;
    private y1 h5ClickChecker;
    private boolean isStarted;
    private Handler mHandler;
    private int mImageCurrentTime;
    private boolean onReward;
    private boolean oneHalfPerformed;
    private boolean oneQuarterPerformed;
    private boolean threeQuarterPerformed;
    private TouchAdContainer touchContainer;
    private int totalTime = DEFAULT_TOTAL_TIME;
    private final Runnable updateTime = new AnonymousClass6(this);

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdRewardH5Activity$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 extends m {
        public final SsdRewardH5Activity this$0;

        public AnonymousClass1(SsdRewardH5Activity ssdRewardH5Activity) {
            this.this$0 = ssdRewardH5Activity;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            try {
                if (this.this$0.onReward) {
                    this.this$0.sendBroadcast("broadcast_onclosed");
                    this.this$0.finish();
                } else {
                    z0.a(SsdRewardH5Activity.adSlot, 18);
                    new MSDialog.Builder(this.this$0).setTitle("完整观看即可获得奖励\n确认要离开吗？").setShowCloseBtn(true).setCanceledOnTouchOutside(false).setNegativeButton("放弃领取", new m(this) { // from class: com.kc.dw.activity.SsdRewardH5Activity.1.2
                        public final AnonymousClass1 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.safe.m
                        public void safeOnClick(View view2) {
                            super.safeOnClick(view2);
                            z0.a(SsdRewardH5Activity.adSlot, 19);
                            this.this$1.this$0.sendBroadcast("broadcast_onclosed");
                            this.this$1.this$0.finish();
                        }
                    }).setPositiveButton("继续浏览", new m(this) { // from class: com.kc.dw.activity.SsdRewardH5Activity.1.1
                        public final AnonymousClass1 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.safe.m
                        public void safeOnClick(View view2) {
                            super.safeOnClick(view2);
                            z0.a(SsdRewardH5Activity.adSlot, 20);
                        }
                    }).build().show();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdRewardH5Activity$5, reason: invalid class name */
    @Keep
    public class AnonymousClass5 implements c {
        public final SsdRewardH5Activity this$0;

        public AnonymousClass5(SsdRewardH5Activity ssdRewardH5Activity) {
            this.this$0 = ssdRewardH5Activity;
        }

        @Override // com.kc.dw.core.webview.listener.c
        public boolean onPageFinished(String str, boolean z, boolean z2, int i) {
            LogUtil.dev(SsdRewardH5Activity.TAG, "onPageFinished: " + str + " code:" + i);
            this.this$0.curWebUrl = str;
            return true;
        }

        @Override // com.kc.dw.core.webview.listener.c
        public void onPageStarted(String str) {
            this.this$0.runOnUiThread(new j(this) { // from class: com.kc.dw.activity.SsdRewardH5Activity.5.1
                public final AnonymousClass5 this$1;

                {
                    this.this$1 = this;
                }

                @Override // com.kc.dw.core.safe.j
                public void safeRun() {
                    super.safeRun();
                    this.this$1.this$0.bQuery.b(R.id.ms_reward_back_layout).d(SsdRewardH5Activity.wrapper.f39449a.canGoBack() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.activity.SsdRewardH5Activity$6, reason: invalid class name */
    @Keep
    public class AnonymousClass6 extends j {
        public final SsdRewardH5Activity this$0;

        public AnonymousClass6(SsdRewardH5Activity ssdRewardH5Activity) {
            this.this$0 = ssdRewardH5Activity;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                SsdRewardH5Activity.access$1012(this.this$0, 100);
                if (this.this$0.mImageCurrentTime >= this.this$0.totalTime) {
                    this.this$0.onReward = true;
                    this.this$0.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
                    this.this$0.runOnUiThread(new j(this) { // from class: com.kc.dw.activity.SsdRewardH5Activity.6.1
                        public final AnonymousClass6 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.safe.j
                        public void safeRun() {
                            super.safeRun();
                            View view = this.this$1.this$0.bQuery.b(R.id.ms_reward_content_txt).d;
                            if (view instanceof TextView) {
                                ((TextView) view).setText("恭喜已获得奖励");
                            }
                        }
                    });
                    z0.a(SsdRewardH5Activity.adSlot, 17);
                    this.this$0.sendBroadcast("broadcast_onreward");
                    this.this$0.onImageComplete();
                    this.this$0.mHandler.removeCallbacks(this.this$0.updateTime);
                    return;
                }
                this.this$0.runOnUiThread(new j(this, this.this$0.totalTime - this.this$0.mImageCurrentTime) { // from class: com.kc.dw.activity.SsdRewardH5Activity.6.2
                    public final AnonymousClass6 this$1;
                    public final int val$leftMillisecond;

                    {
                        this.this$1 = this;
                        this.val$leftMillisecond = i;
                    }

                    @Override // com.kc.dw.core.safe.j
                    public void safeRun() {
                        super.safeRun();
                        this.this$1.this$0.updateCountDownText(Math.max(0, (this.val$leftMillisecond + 999) / 1000));
                    }
                });
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
    }

    public static /* synthetic */ int access$1012(SsdRewardH5Activity ssdRewardH5Activity, int i) {
        int i2 = ssdRewardH5Activity.mImageCurrentTime + i;
        ssdRewardH5Activity.mImageCurrentTime = i2;
        return i2;
    }

    public static void clear() {
        n nVar = wrapper;
        if (nVar != null) {
            l.a(nVar.f39449a);
            try {
                wrapper.b.g = null;
            } catch (Exception unused) {
            }
            try {
                wrapper.c.a((com.kc.dw.core.webview.listener.a) null);
            } catch (Exception unused2) {
            }
        }
        wrapper = null;
        adSlot = null;
        nativeAdData = null;
    }

    private void initClickEvent(d dVar) {
        d dVarB = dVar.b(R.id.ms_reward_close_button_parent);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this);
        View view = dVarB.d;
        if (view != null) {
            view.setOnClickListener(anonymousClass1);
        }
        d dVarB2 = dVar.b(R.id.ms_reward_back_layout);
        m mVar = new m(this) { // from class: com.kc.dw.activity.SsdRewardH5Activity.2
            public final SsdRewardH5Activity this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.safe.m
            public void safeOnClick(View view2) {
                super.safeOnClick(view2);
                if (SsdRewardH5Activity.wrapper == null || SsdRewardH5Activity.wrapper.f39449a == null || !SsdRewardH5Activity.wrapper.f39449a.canGoBack()) {
                    return;
                }
                if (!l.a(SsdRewardH5Activity.wrapper.f39449a.getUrl())) {
                    SsdRewardH5Activity.wrapper.f39449a.goBack();
                    return;
                }
                SsdRewardH5Activity.wrapper.f39449a.goBack();
                try {
                    SsdRewardH5Activity.wrapper.f39449a.goBack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        View view2 = dVarB2.d;
        if (view2 != null) {
            view2.setOnClickListener(mVar);
        }
        this.touchContainer.setTouchPositionListener(new TouchPositionListener(this, nativeAdData) { // from class: com.kc.dw.activity.SsdRewardH5Activity.3
            public final SsdRewardH5Activity this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.view.TouchPositionListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                if (SsdRewardH5Activity.wrapper != null && SsdRewardH5Activity.wrapper.b != null) {
                    SsdRewardH5Activity.wrapper.b.f = true;
                }
                try {
                    return super.onTouch(view3, motionEvent);
                } finally {
                    if (motionEvent != null && motionEvent.getAction() == 1 && !l.a(this.this$0.curWebUrl)) {
                        LogUtil.dev(SsdRewardH5Activity.TAG, "touchContainer onClick");
                        if (isClickEvent(motionEvent.getX(), motionEvent.getY()) && this.this$0.h5ClickChecker != null && this.this$0.h5ClickChecker.a(motionEvent.getX(), motionEvent.getY())) {
                            f.a(SsdRewardH5Activity.nativeAdData, SsdRewardH5Activity.adSlot);
                            this.this$0.sendBroadcast("broadcast_onclick", true);
                        }
                    }
                }
            }
        });
        wrapper.b.g = new b(this) { // from class: com.kc.dw.activity.SsdRewardH5Activity.4
            public final SsdRewardH5Activity this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.webview.listener.b
            public void onDPStart() {
                f.a(this.this$0, SsdRewardH5Activity.adSlot, SsdRewardH5Activity.nativeAdData);
                try {
                    z0.a(SsdRewardH5Activity.adSlot, 22, 0, "dp_start");
                } catch (Exception unused) {
                }
            }

            @Override // com.kc.dw.core.webview.listener.b
            public void onJumpDPRes(boolean z, boolean z2) {
                LogUtil.dev(SsdRewardH5Activity.TAG, "onJumpDPRes:" + z + " showedSysDialog:" + z2);
                if (z) {
                    f.a(SsdRewardH5Activity.adSlot, this.this$0, SsdRewardH5Activity.nativeAdData, z2);
                    try {
                        z0.a(SsdRewardH5Activity.adSlot, 23, 0, "dp_start");
                    } catch (Exception unused) {
                    }
                }
            }
        };
    }

    private void initStateByWebView() {
        e eVar;
        n nVar = wrapper;
        if (nVar != null && (eVar = nVar.c) != null) {
            eVar.a(new AnonymousClass5(this));
        }
        this.bQuery.b(R.id.ms_reward_back_layout).d(wrapper.f39449a.canGoBack() ? 0 : 8);
    }

    public static boolean isValid(String str) {
        try {
            n nVar = wrapper;
            return (nVar == null || nVar.f39449a == null || nVar.b == null || nVar.c == null || adSlot == null || nativeAdData == null || TextUtils.isEmpty(str) || !str.equals(adSlot.getReq_id())) ? false : true;
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

    /* JADX INFO: Access modifiers changed from: private */
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

    public static void setRewardH5Data(n nVar, g gVar) {
        wrapper = nVar;
        nativeAdData = gVar;
        adSlot = gVar != null ? gVar.h : null;
        updateWebViewContext(com.kc.dw.base.a.getContext() != null ? com.kc.dw.base.a.getContext().getApplicationContext() : null);
        updateMediaViewContext(com.kc.dw.base.a.getContext() != null ? com.kc.dw.base.a.getContext().getApplicationContext() : null);
    }

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
                        z.a(this, g0.a(str), new com.kc.dw.core.utils.j());
                    }
                }
            }
            this.isStarted = true;
            z0.a(adSlot, 16);
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
        this.bQuery.b(R.id.ms_reward_content_txt).a((CharSequence) ("奖励将于 " + i + " 秒后发放"));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000d  */
    private static void updateMediaViewContext(Context context) {
        NormalMediaView normalMediaView;
        try {
            g gVar = nativeAdData;
            if (gVar != null) {
                a0 a0Var = gVar.g;
                if (a0Var instanceof NormalMediaView) {
                    normalMediaView = (NormalMediaView) a0Var;
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
            n nVar = wrapper;
            if (nVar == null || (webView = nVar.f39449a) == null || !(webView.getContext() instanceof ContextWrapper)) {
                return;
            }
            ReflectUtil.setValue(ContextWrapper.class, "mBase", wrapper.f39449a.getContext(), context);
            LogUtil.d(TAG, "update w context");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OneHalfReport() {
        try {
            LogUtil.d(TAG, "send onVideoOneHalf");
            String[] strArr = adSlot.l;
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
            String[] strArr = adSlot.k;
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
            String[] strArr = adSlot.m;
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
        sendBroadcast("broadcast_on_video_complete");
        try {
            LogUtil.d(TAG, "send onVideoComplete");
            String[] strArr = adSlot.n;
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

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
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

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnAttachedToWindow() {
        super.safeOnAttachedToWindow();
        this.attachWindow = true;
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnCreate(Bundle bundle) {
        boolean z;
        d dVarB;
        int i;
        super.safeOnCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(3330);
        ShakeUtil.getInstance().e();
        setContentView(R.layout.ssd_activity_reward_h5);
        this.touchContainer = (TouchAdContainer) findViewById(R.id.ms_activity_reward_h5_touch_ad_container);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ms_reward_h5_container);
        this.h5ClickChecker = new y1(viewGroup);
        this.bQuery = new d((Activity) this);
        try {
            z = (getResources().getConfiguration().uiMode & 48) == 32;
        } catch (Exception unused) {
        }
        if (z) {
            View view = this.bQuery.b(R.id.ms_reward_h5_bg).d;
            if (view != null) {
                view.setBackgroundColor(-16777216);
            }
            dVarB = this.bQuery.b(R.id.ms_reward_back);
            i = R.drawable.ssd_ic_back_white;
        } else {
            View view2 = this.bQuery.b(R.id.ms_reward_h5_bg).d;
            if (view2 != null) {
                view2.setBackgroundColor(-1);
            }
            dVarB = this.bQuery.b(R.id.ms_reward_back);
            i = R.drawable.ssd_ic_back_black;
        }
        dVarB.c(i);
        initClickEvent(this.bQuery);
        this.bQuery.b(R.id.ms_reward_close_button_parent).d(0);
        d dVar = this.bQuery;
        int i2 = R.id.ms_include_ad_tag;
        d dVarA = dVar.a(i2);
        int i3 = R.id.ssd_img_ad_tag;
        d dVarB2 = dVarA.b(i3);
        int i4 = R.drawable.ssd_bg_alpha_rect_40_radius4;
        View view3 = dVarB2.d;
        if (view3 != null) {
            if (i4 != 0) {
                view3.setBackgroundResource(i4);
            } else {
                view3.setBackgroundDrawable(null);
            }
        }
        i iVar = adSlot;
        if (iVar != null && !TextUtils.isEmpty(iVar.getFromLogo())) {
            this.bQuery.a(i2).b(i3).a(adSlot.getFromLogo(), false);
            this.bQuery.a(R.id.ms_include_ad_tag_end).b(i3).a(adSlot.getFromLogo(), false);
        }
        updateWebViewContext(this);
        initStateByWebView();
        viewGroup.addView(wrapper.f39449a, new RelativeLayout.LayoutParams(-1, -1));
        long j = adSlot.i * 1000;
        this.totalTime = j > 0 ? (int) j : DEFAULT_TOTAL_TIME;
        updateCountDownText(this.totalTime / 1000);
        sendBroadcast("broadcast_on_video_start");
        startUpdateProcess();
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnDestroy() {
        super.safeOnDestroy();
        z0.a(adSlot, 21);
        clear();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.updateTime);
            this.mHandler = null;
        }
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnDetachedFromWindow() {
        super.safeOnDetachedFromWindow();
        this.attachWindow = false;
    }
}
