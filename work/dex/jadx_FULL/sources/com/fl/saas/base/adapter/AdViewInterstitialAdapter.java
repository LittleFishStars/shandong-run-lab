package com.fl.saas.base.adapter;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.byazt.hv.TTDownloadField;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.base.builder.InnerInterstitialBuilder;
import com.fl.saas.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Predicate;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.common.widget.CountDownProgressView;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AdViewInterstitialAdapter extends BuilderLoadAdapter<InnerInterstitialBuilder<?>, AdViewInterstitialListener> {
    private static final String TAG = CommConstant.getClassTag(AdViewInterstitialAdapter.class);
    private WeakReference<Activity> activityRef;
    private CountDownProgressView countDownTextView;
    private boolean hasCloseInterstitialAd;
    private boolean hasReturnCloseEvent;
    private boolean haveShowCloseView;
    private boolean isIntersReady;
    private String showActivityName;
    private long showTime;
    private WeakReference<Activity> topActivityRef;
    private boolean canCallback = true;
    private boolean canCallbackClose = true;
    private boolean hasBackDisplay = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void closeInterstitialListener() {
        try {
            CountDownProgressView countDownProgressView = this.countDownTextView;
            if (countDownProgressView != null) {
                if (countDownProgressView.getVisibilityState() == 0) {
                    closeInterstitialAd(this.topActivityRef.get());
                } else {
                    this.countDownTextView.setOnVisibilityChanged(new Consumer() { // from class: com.zj.adlib.kx
                        @Override // com.fl.saas.common.util.feature.Consumer
                        public final void accept(Object obj) {
                            this.f42935a.lambda$closeInterstitialListener$10((Integer) obj);
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeView() {
        WeakReference<Activity> weakReference;
        if (this.showTime <= 0 || System.currentTimeMillis() - this.showTime < 500 || (weakReference = this.topActivityRef) == null) {
            return;
        }
        try {
            Activity activity = weakReference.get();
            String str = TAG;
            LogcatUtil.d(str, "removeViewActivity:" + activity);
            if (this.countDownTextView != null && activity != null && !activity.isFinishing()) {
                activity.getWindowManager().removeViewImmediate(this.countDownTextView);
            }
            if (selfCloseInterstitialAd()) {
                return;
            }
            String topActivityName = getTopActivityName();
            LogcatUtil.d(str, "removeViewTopActivityName:" + topActivityName);
            LogcatUtil.d(str, "removeViewShowActivityName:" + this.showActivityName);
            if (compareActivity(topActivityName, this.showActivityName)) {
                View topView = ViewHelper.getTopView();
                if (topView != null && activity != null && !activity.isFinishing()) {
                    activity.getWindowManager().removeView(topView);
                }
            } else {
                Activity topActivity = DeviceUtil.getTopActivity();
                if (topActivity != null) {
                    activity = topActivity;
                }
                if (activity != null && !this.showActivityName.equals(activity.getComponentName().getClassName()) && !activity.isFinishing()) {
                    activity.finish();
                }
            }
            onClosedEvent();
            this.countDownTextView = null;
            this.topActivityRef = null;
            this.activityRef = null;
        } catch (Throwable th) {
            th.printStackTrace();
            this.countDownTextView = null;
            this.topActivityRef = null;
            this.activityRef = null;
        }
    }

    private boolean compareActivity(String str, String str2) {
        WeakReference<Activity> weakReference;
        if ((this.showActivityName != null && (weakReference = this.topActivityRef) != null && weakReference.get() != null && this.showActivityName.equals(this.topActivityRef.get().getComponentName().getClassName())) || str == null || str2 == null || str.equals(str2)) {
            return true;
        }
        return str.substring(str.lastIndexOf(46) + 1).equals(str2.substring(str2.lastIndexOf(46) + 1));
    }

    private String getTopActivityName() {
        ComponentName componentName;
        try {
            WeakReference<Activity> weakReference = this.activityRef;
            return (weakReference == null || weakReference.get().isFinishing() || (componentName = ((ActivityManager) this.activityRef.get().getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(1).get(0).topActivity) == null) ? "" : componentName.getClassName();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeInterstitialListener$10(Integer num) {
        if (num.intValue() == 0) {
            CountDownProgressView countDownProgressView = this.countDownTextView;
            if (countDownProgressView != null) {
                countDownProgressView.unOnVisibilityChanged();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zj.adlib.dx
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41298a.lambda$closeInterstitialListener$9();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeInterstitialListener$9() {
        closeInterstitialAd(this.topActivityRef.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onShowEvent$4() {
        if (this.hasCloseInterstitialAd) {
            return;
        }
        setTopActivityRef(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$showAutoCloseView$5(Integer num) {
        return "点击关闭广告  " + num + "S";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAutoCloseView$6(View view) {
        closeInterstitialListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$showAutoCloseView$7(Integer num) {
        return num + "S后自动关闭";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAutoCloseView$8(View view) {
        closeInterstitialListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$showInterstitialAd$0(Activity activity) {
        return !activity.isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInterstitialAd$1() {
        Activity activity;
        WeakReference<Activity> weakReference = this.activityRef;
        if (weakReference != null && weakReference.get() != null && !this.activityRef.get().isFinishing()) {
            activity = this.activityRef.get();
        } else {
            if (requiresActivityDetection()) {
                onAdFailed(YdError.create(20404, "request show but Activity is null or invalid"));
                return;
            }
            activity = null;
        }
        showInterstitial(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInterstitialAd$2(Activity activity) {
        this.activityRef = new WeakReference<>(activity);
        try {
            this.showActivityName = activity.getComponentName().getClassName();
            LogcatUtil.d(TAG, "showActivityName:" + this.showActivityName);
            DeviceUtil.postUIDelayed(50L, new Runnable() { // from class: com.zj.adlib.ex
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41542a.lambda$showInterstitialAd$1();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInterstitialAd$3() {
        if (requiresActivityDetection()) {
            onAdFailed(YdError.create(20404, "request show but Activity is null or invalid"));
        } else {
            showInterstitial(null);
        }
    }

    private void setTopActivityRef(boolean z) {
        WeakReference<Activity> weakReference;
        Activity topActivity = DeviceUtil.getTopActivity();
        if (topActivity == null && (weakReference = this.activityRef) != null) {
            topActivity = weakReference.get();
        }
        if (topActivity == null || topActivity.isFinishing()) {
            return;
        }
        this.topActivityRef = new WeakReference<>(topActivity);
        LogcatUtil.d(TAG, "addAutoCloseViewTopActivity:" + topActivity);
        if (z) {
            showAutoCloseView(topActivity);
        }
    }

    public void checkReRequest(Activity activity) {
        if (activity == null) {
            return;
        }
        if (changeReRequestCount()) {
            reRequest();
        } else if (!getAdSource().isAutoClose()) {
            return;
        }
        closeInterstitialAd(activity);
    }

    public void closeInterstitialAd(Activity activity) {
        if (activity == null || this.hasCloseInterstitialAd) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            closeView();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.fx
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41774a.closeView();
                }
            });
        }
    }

    public void closeTopCountDownView() {
        this.hasCloseInterstitialAd = true;
        LogcatUtil.d(TAG, "closeTopCountDownView");
        try {
            WeakReference<Activity> weakReference = this.topActivityRef;
            if (weakReference != null) {
                Activity activity = weakReference.get();
                if (this.countDownTextView != null && activity != null && !activity.isFinishing()) {
                    activity.getWindowManager().removeView(this.countDownTextView);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.countDownTextView = null;
        this.topActivityRef = null;
        this.activityRef = null;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        this.activityRef = null;
        this.topActivityRef = null;
        this.countDownTextView = null;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public boolean isCheckActivity() {
        return true;
    }

    public final boolean isIntersReady() {
        return this.isIntersReady;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onClickedEvent() {
        super.onClickedEvent();
        this.haveShowCloseView = true;
        if (this.canCallback) {
            AdViewListener eventListener = getEventListener();
            if (eventListener instanceof AdViewVideoListener) {
                AdViewVideoListener adViewVideoListener = (AdViewVideoListener) eventListener;
                adViewVideoListener.onAdClick("");
                if (getAdSource().reward_callback_option == 2) {
                    adViewVideoListener.onVideoReward(getAdSource().getECPM());
                }
            } else if (eventListener instanceof AdViewInterstitialListener) {
                ((AdViewInterstitialListener) eventListener).onAdClick("");
            } else if (eventListener instanceof AdViewSpreadListener) {
                ((AdViewSpreadListener) eventListener).onAdClick("");
            }
        }
        AdapterAPI interstitialAdapter = AdCacheManager.getInstance().getInterstitialAdapter();
        if (interstitialAdapter instanceof AdViewInterstitialAdapter) {
            try {
                this.canCallback = false;
                this.canCallbackClose = false;
                if (!selfCloseInterstitialAd()) {
                    this.canCallback = true;
                    this.canCallbackClose = true;
                    return;
                }
                if (interstitialAdapter instanceof BiddingResult) {
                    ((BiddingResult) interstitialAdapter).biddingResult(true, interstitialAdapter.getAdSource().getPrice(), 0, 0);
                }
                ((AdViewInterstitialAdapter) interstitialAdapter).setCanCallBack(false);
                ((AdViewInterstitialAdapter) interstitialAdapter).setCanCallBackClose(true);
                ((AdViewInterstitialAdapter) interstitialAdapter).showInterstitialAd(getActivityOrNull());
                AdCacheManager.getInstance().clearInterstitialAdapter(false);
            } catch (Exception e) {
                this.canCallback = true;
                this.canCallbackClose = true;
                e.printStackTrace();
            }
        }
    }

    public void onClosedEvent() {
        this.hasCloseInterstitialAd = true;
        if (this.hasReturnCloseEvent) {
            return;
        }
        this.hasReturnCloseEvent = true;
        closeTopCountDownView();
        if (this.canCallbackClose) {
            AdCacheManager.getInstance().clearInterstitialAdapter(true);
            AdViewListener eventListener = getEventListener();
            if (eventListener instanceof AdViewVideoListener) {
                AdViewVideoListener adViewVideoListener = (AdViewVideoListener) eventListener;
                adViewVideoListener.onAdClose();
                if (getAdSource().reward_callback_option == 1) {
                    adViewVideoListener.onVideoReward(getAdSource().getECPM());
                    return;
                }
                return;
            }
            if (eventListener instanceof AdViewInterstitialListener) {
                ((AdViewInterstitialListener) eventListener).onAdClosed();
            } else if (eventListener instanceof AdViewSpreadListener) {
                ((AdViewSpreadListener) eventListener).onAdClose();
            }
        }
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onLoadedEvent() {
        this.isIntersReady = true;
        super.onLoadedEvent();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onShowEvent() {
        this.showTime = System.currentTimeMillis();
        this.isIntersReady = false;
        super.onShowEvent();
        if (this.canCallback && !this.hasBackDisplay) {
            this.hasBackDisplay = true;
            AdViewListener eventListener = getEventListener();
            if (eventListener instanceof AdViewVideoListener) {
                ((AdViewVideoListener) eventListener).onAdShow();
            } else if (eventListener instanceof AdViewInterstitialListener) {
                ((AdViewInterstitialListener) eventListener).onAdDisplay();
            } else if (eventListener instanceof AdViewSpreadListener) {
                ((AdViewSpreadListener) eventListener).onAdDisplay();
            }
        }
        setTopActivityRef(false);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zj.adlib.lx
            @Override // java.lang.Runnable
            public final void run() {
                this.f43177a.lambda$onShowEvent$4();
            }
        }, 500L);
    }

    public boolean requiresActivityDetection() {
        return true;
    }

    public boolean selfCloseInterstitialAd() {
        return false;
    }

    public void setCanCallBack(boolean z) {
        this.canCallback = z;
    }

    public void setCanCallBackClose(boolean z) {
        this.canCallbackClose = z;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        String str;
        super.showAd();
        if (isReRequest()) {
            showInterstitialAd(null);
            return;
        }
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onVideoPrepared();
            return;
        }
        if (eventListener instanceof AdViewInterstitialListener) {
            ((AdViewInterstitialListener) eventListener).onAdReady();
            return;
        }
        if (eventListener instanceof AdViewSpreadListener) {
            AdViewListener builder = getBuilder();
            if (builder instanceof InnerSpreadBuilder) {
                SpreadLoadListener spreadLoadListener = ((InnerSpreadBuilder) builder).getSpreadLoadListener();
                if (spreadLoadListener != null) {
                    spreadLoadListener.onADLoaded(new SpreadLoadListener.SpreadAd() { // from class: com.fl.saas.base.adapter.AdViewInterstitialAdapter.1
                        @Override // com.fl.saas.base.interfaces.AdMaterial
                        @Nullable
                        public AdMaterial.AdMaterialData getAdMaterialData() {
                            return null;
                        }

                        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
                        public int getEcpm() {
                            return AdViewInterstitialAdapter.this.getAdSource().getECPM();
                        }

                        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
                        public boolean isAdReady() {
                            return AdViewInterstitialAdapter.this.isIntersReady;
                        }

                        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
                        public boolean isSpread() {
                            return false;
                        }

                        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
                        public void show(Activity activity, ViewGroup viewGroup) {
                            if (activity == null && (activity = AdViewInterstitialAdapter.this.getActivityOrNull()) == null) {
                                activity = DeviceUtil.getTopActivity();
                            }
                            AdViewInterstitialAdapter.this.showInterstitial(activity);
                        }

                        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
                        public void show(ViewGroup viewGroup) {
                            show(null, viewGroup);
                        }
                    });
                    return;
                }
                str = "没有回调监听";
            } else {
                str = "Builder类型不匹配";
            }
            onAdFailed(YdError.create(20405, str));
        }
    }

    public void showAutoCloseView(Activity activity) {
        if (activity == null || activity.isFinishing() || this.haveShowCloseView) {
            return;
        }
        int iDip2px = 1;
        try {
            this.haveShowCloseView = true;
            int closeCountdown = getAdSource().getCloseCountdown();
            boolean z = closeCountdown > 0;
            boolean zIsUnifiedCloseButtonShow = getAdSource().isUnifiedCloseButtonShow();
            if (z || zIsUnifiedCloseButtonShow) {
                CountDownProgressView countDownProgressView = new CountDownProgressView(activity);
                this.countDownTextView = countDownProgressView;
                countDownProgressView.setCount(closeCountdown);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(DeviceUtil.dip2px(20.0f));
                gradientDrawable.setColor(Color.parseColor("#60000000"));
                gradientDrawable.setStroke(DeviceUtil.dip2px(2.0f), Color.parseColor("#D9D9D9"));
                this.countDownTextView.setBackground(gradientDrawable);
                this.countDownTextView.setElevation(20.0f);
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.flags = 8;
                layoutParams.format = 1;
                if (!z || zIsUnifiedCloseButtonShow || getAdSource().isDisplayCountDown()) {
                    layoutParams.width = DeviceUtil.dip2px(160.0f);
                    iDip2px = DeviceUtil.dip2px(32.0f);
                } else {
                    layoutParams.width = 1;
                }
                layoutParams.height = iDip2px;
                layoutParams.gravity = 81;
                layoutParams.y = DeviceUtil.dip2px(80.0f);
                activity.getWindowManager().addView(this.countDownTextView, layoutParams);
                if (!z) {
                    this.countDownTextView.setText("    点击关闭广告    ");
                    this.countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.cx
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f41059a.lambda$showAutoCloseView$8(view);
                        }
                    });
                    return;
                }
                if (zIsUnifiedCloseButtonShow) {
                    this.countDownTextView.setOnTick(new Function() { // from class: com.zj.adlib.mx
                        @Override // androidx.arch.core.util.Function
                        public final Object apply(Object obj) {
                            return AdViewInterstitialAdapter.lambda$showAutoCloseView$5((Integer) obj);
                        }
                    });
                    this.countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.nx
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f43623a.lambda$showAutoCloseView$6(view);
                        }
                    });
                } else {
                    this.countDownTextView.setOnTick(new Function() { // from class: com.zj.adlib.ox
                        @Override // androidx.arch.core.util.Function
                        public final Object apply(Object obj) {
                            return AdViewInterstitialAdapter.lambda$showAutoCloseView$7((Integer) obj);
                        }
                    });
                }
                this.countDownTextView.setFinish(new Runnable() { // from class: com.zj.adlib.bx
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f40855a.closeInterstitialListener();
                    }
                });
                this.countDownTextView.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void showInterstitial(Activity activity);

    public final void showInterstitialAd(Activity activity) {
        int iIntValue = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.ax
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerInterstitialBuilder) obj).getAutoCloseCountDown());
            }
        }).orElse(0)).intValue();
        if (iIntValue > 0 && getAdSource().getCloseCountdown() == 0) {
            getAdSource().setCloseCountdown(iIntValue);
            getAdSource().cp_display_countdown = 1;
        }
        this.isIntersReady = false;
        reportRequestShow();
        Optional.ofNullable(activity).filter(new Predicate() { // from class: com.zj.adlib.gx
            @Override // com.fl.saas.common.util.feature.Predicate
            public final boolean test(Object obj) {
                return AdViewInterstitialAdapter.lambda$showInterstitialAd$0((Activity) obj);
            }
        }).or(new Supplier() { // from class: com.zj.adlib.hx
            @Override // com.fl.saas.common.util.feature.Supplier
            public final Object get() {
                return this.f42224a.getActivityValid();
            }
        }).ifPresentOrElse(new Consumer() { // from class: com.zj.adlib.ix
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f42460a.lambda$showInterstitialAd$2((Activity) obj);
            }
        }, new Runnable() { // from class: com.zj.adlib.jx
            @Override // java.lang.Runnable
            public final void run() {
                this.f42692a.lambda$showInterstitialAd$3();
            }
        });
    }
}
