package com.fl.saas;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import androidx.arch.core.util.Function;
import com.byazt.hv.TTDownloadField;
import com.fl.saas.AbstractC1405e;
import com.fl.saas.adx.base.base.builder.InnerInterstitialBuilder;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.adx.base.interfaces.AdViewListener;
import com.fl.saas.adx.base.widget.CountDownProgressView;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import com.fl.saas.adx.util.ViewHelper;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.fl.saas.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1405e extends AbstractC1425o {
    private static final String TAG = CommConstant.getClassTag(AbstractC1405e.class);
    private WeakReference<Activity> activityRef;
    private CountDownProgressView countDownTextView;
    private boolean hasCloseInterstitialAd;
    private boolean hasReturnCloseEvent;
    private boolean haveShowCloseView;
    private boolean isIntersReady;
    private long responseTime;
    private String showActivityName;
    private long showTime;
    private WeakReference<Activity> topActivityRef;
    private boolean canCallback = true;
    private boolean canCallbackClose = true;
    private boolean hasBackDisplay = false;

    private boolean a(String str, String str2) {
        WeakReference<Activity> weakReference;
        if ((this.showActivityName != null && (weakReference = this.topActivityRef) != null && weakReference.get() != null && this.showActivityName.equals(this.topActivityRef.get().getComponentName().getClassName())) || str == null || str2 == null || str.equals(str2)) {
            return true;
        }
        return str.substring(str.lastIndexOf(46) + 1).equals(str2.substring(str2.lastIndexOf(46) + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            CountDownProgressView countDownProgressView = this.countDownTextView;
            if (countDownProgressView != null) {
                if (countDownProgressView.getVisibilityState() == 0) {
                    closeInterstitialAd(this.topActivityRef.get());
                } else {
                    this.countDownTextView.setOnVisibilityChanged(new B() { // from class: com.zj.adlib.uza
                        @Override // com.fl.saas.B
                        public final void a(Object obj) {
                            this.f45258a.a((Integer) obj);
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
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
            String strD = d();
            LogcatUtil.d(str, "removeViewTopActivityName:" + strD);
            LogcatUtil.d(str, "removeViewShowActivityName:" + this.showActivityName);
            if (a(strD, this.showActivityName)) {
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

    private String d() {
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
    public /* synthetic */ void e() {
        closeInterstitialAd(this.topActivityRef.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (this.hasCloseInterstitialAd) {
            return;
        }
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        Activity activity;
        WeakReference<Activity> weakReference = this.activityRef;
        if (weakReference != null && weakReference.get() != null && !this.activityRef.get().isFinishing()) {
            activity = this.activityRef.get();
        } else {
            if (requiresActivityDetection()) {
                onAdFailed(FLError.create(20404, "request show but Activity is null or invalid"));
                return;
            }
            activity = null;
        }
        showInterstitial(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        if (requiresActivityDetection()) {
            onAdFailed(FLError.create(20404, "request show but Activity is null or invalid"));
        } else {
            showInterstitial(null);
        }
    }

    public void checkReRequest(Activity activity) {
        if (activity == null) {
            return;
        }
        if (changeReRequestCount()) {
            reRequest();
        } else if (!getAdSource().l()) {
            return;
        }
        closeInterstitialAd(activity);
    }

    public void closeInterstitialAd(Activity activity) {
        if (activity == null || this.hasCloseInterstitialAd) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            c();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.yza
                @Override // java.lang.Runnable
                public final void run() {
                    this.f46147a.c();
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

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        this.activityRef = null;
        this.topActivityRef = null;
        this.countDownTextView = null;
    }

    public final boolean isIntersReady() {
        try {
            return this.isIntersReady && ((((System.currentTimeMillis() - this.responseTime) / 1000) > ((long) getAdSource().D1) ? 1 : (((System.currentTimeMillis() - this.responseTime) / 1000) == ((long) getAdSource().D1) ? 0 : -1)) < 0);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.D0
    public void onClickedEvent() {
        super.onClickedEvent();
        this.haveShowCloseView = true;
        if (this.canCallback) {
            AdViewListener eventListener = getEventListener();
            if (eventListener instanceof AdViewInterstitialListener) {
                ((AdViewInterstitialListener) eventListener).onAdClick("");
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
            AdViewListener eventListener = getEventListener();
            if (eventListener instanceof AdViewInterstitialListener) {
                ((AdViewInterstitialListener) eventListener).onAdClosed();
            }
        }
    }

    @Override // com.fl.saas.AbstractC1423n
    public void onLoadedEvent() {
        this.isIntersReady = true;
        this.responseTime = System.currentTimeMillis();
        super.onLoadedEvent();
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.D0
    public void onShowEvent() {
        this.showTime = System.currentTimeMillis();
        this.isIntersReady = false;
        super.onShowEvent();
        if (this.canCallback && !this.hasBackDisplay) {
            this.hasBackDisplay = true;
            AdViewListener eventListener = getEventListener();
            if (eventListener instanceof AdViewInterstitialListener) {
                ((AdViewInterstitialListener) eventListener).onAdDisplay();
            }
        }
        a(false);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zj.adlib.wza
            @Override // java.lang.Runnable
            public final void run() {
                this.f45719a.f();
            }
        }, 500L);
    }

    public boolean requiresActivityDetection() {
        return true;
    }

    public abstract boolean selfCloseInterstitialAd();

    public void setCanCallBack(boolean z) {
        this.canCallback = z;
    }

    public void setCanCallBackClose(boolean z) {
        this.canCallbackClose = z;
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        if (isReRequest()) {
            showInterstitialAd(null);
            return;
        }
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewInterstitialListener) {
            ((AdViewInterstitialListener) eventListener).onAdReady();
        }
    }

    public void showAutoCloseView(Activity activity) {
        if (activity == null || activity.isFinishing() || this.haveShowCloseView) {
            return;
        }
        try {
            this.haveShowCloseView = true;
            int iE = getAdSource().e();
            boolean z = iE > 0;
            boolean zS = getAdSource().s();
            if (z || zS) {
                CountDownProgressView countDownProgressView = new CountDownProgressView(activity);
                this.countDownTextView = countDownProgressView;
                countDownProgressView.setCount(iE);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(DeviceUtil.dip2px(20.0f));
                gradientDrawable.setColor(Color.parseColor("#60000000"));
                gradientDrawable.setStroke(DeviceUtil.dip2px(2.0f), Color.parseColor("#D9D9D9"));
                this.countDownTextView.setBackground(gradientDrawable);
                this.countDownTextView.setElevation(20.0f);
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.flags = 8;
                layoutParams.format = 1;
                layoutParams.width = DeviceUtil.dip2px(160.0f);
                layoutParams.height = DeviceUtil.dip2px(32.0f);
                layoutParams.gravity = 81;
                layoutParams.y = DeviceUtil.dip2px(80.0f);
                activity.getWindowManager().addView(this.countDownTextView, layoutParams);
                if (!z) {
                    this.countDownTextView.setText("    点击关闭广告    ");
                    this.countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.nya
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f43632a.b(view);
                        }
                    });
                    return;
                }
                if (zS) {
                    this.countDownTextView.setOnTick(new Function() { // from class: com.zj.adlib.eya
                        @Override // androidx.arch.core.util.Function
                        public final Object apply(Object obj) {
                            return AbstractC1405e.b((Integer) obj);
                        }
                    });
                    this.countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.kya
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f42947a.a(view);
                        }
                    });
                } else {
                    this.countDownTextView.setOnTick(new Function() { // from class: com.zj.adlib.lya
                        @Override // androidx.arch.core.util.Function
                        public final Object apply(Object obj) {
                            return AbstractC1405e.c((Integer) obj);
                        }
                    });
                }
                this.countDownTextView.setFinish(new Runnable() { // from class: com.zj.adlib.mya
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f43412a.b();
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
        int iIntValue = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.tya
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerInterstitialBuilder) obj).getAutoCloseCountDown());
            }
        }).c(0)).intValue();
        if (iIntValue > 0 && getAdSource().e() == 0) {
            getAdSource().b(iIntValue);
        }
        this.isIntersReady = false;
        reportRequestShow();
        C1428p0.b(activity).a(new InterfaceC1444x0() { // from class: com.zj.adlib.bza
            @Override // com.fl.saas.InterfaceC1444x0
            public final boolean a(Object obj) {
                return AbstractC1405e.b((Activity) obj);
            }
        }).a(new b1() { // from class: com.zj.adlib.gza
            @Override // com.fl.saas.b1
            public final Object a() {
                return this.f42017a.getActivityValid();
            }
        }).a(new B() { // from class: com.zj.adlib.lza
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f43190a.c((Activity) obj);
            }
        }, new Runnable() { // from class: com.zj.adlib.oza
            @Override // java.lang.Runnable
            public final void run() {
                this.f43865a.h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Integer num) {
        if (num.intValue() == 0) {
            CountDownProgressView countDownProgressView = this.countDownTextView;
            if (countDownProgressView != null) {
                countDownProgressView.unOnVisibilityChanged();
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zj.adlib.dya
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41307a.e();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String b(Integer num) {
        return "点击关闭广告  " + num + "S";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String c(Integer num) {
        return num + "S后自动关闭";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Activity activity) {
        this.activityRef = new WeakReference<>(activity);
        try {
            this.showActivityName = activity.getComponentName().getClassName();
            LogcatUtil.d(TAG, "showActivityName:" + this.showActivityName);
            DeviceUtil.postUIDelayed(50L, new Runnable() { // from class: com.zj.adlib.rza
                @Override // java.lang.Runnable
                public final void run() {
                    this.f44571a.g();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(boolean z) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b(Activity activity) {
        return !activity.isFinishing();
    }
}
