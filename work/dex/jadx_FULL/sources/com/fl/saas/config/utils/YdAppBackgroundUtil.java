package com.fl.saas.config.utils;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.fl.saas.base.inner.YdAdTempHelper;
import com.fl.saas.base.inner.spread.YdSpreadActivity;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.ydsdk.YdInterstitial;
import com.fl.saas.ydsdk.YdSpread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class YdAppBackgroundUtil {
    private WeakReference<Activity> activityRef;
    private long backgroundTime;
    private int brtr;
    private AdSource clickAdSource;
    private String foregroundName;
    private boolean hasInit;
    private final AtomicInteger mActivityCounter;
    private boolean mIsAppInBackground;
    private boolean reportBackground;
    private String showActivityName;
    private WParams wParamsInterstitial;
    private WParams wParamsSpread;
    private YdInterstitial ydInterstitial;
    private YdSpread ydSpread;

    public class AppLifecycleTracker implements Application.ActivityLifecycleCallbacks {
        private AppLifecycleTracker() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            try {
                if (!YdAppBackgroundUtil.this.isDialogOrTranslucentTheme(activity) && YdAppBackgroundUtil.this.mActivityCounter.incrementAndGet() == 1 && YdAppBackgroundUtil.this.mIsAppInBackground) {
                    YdAppBackgroundUtil.this.mIsAppInBackground = false;
                    YdAppBackgroundUtil.this.onAppForeground(activity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            try {
                if (YdAppBackgroundUtil.this.isDialogOrTranslucentTheme(activity) || YdAppBackgroundUtil.this.mActivityCounter.decrementAndGet() != 0) {
                    return;
                }
                YdAppBackgroundUtil.this.mIsAppInBackground = true;
                YdAppBackgroundUtil.this.onAppBackground();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static final class Holder {
        private static final YdAppBackgroundUtil INSTANCE = new YdAppBackgroundUtil();

        private Holder() {
        }
    }

    private YdAppBackgroundUtil() {
        this.mActivityCounter = new AtomicInteger(0);
        this.mIsAppInBackground = false;
        this.hasInit = false;
        this.backgroundTime = 0L;
        this.showActivityName = "";
        this.foregroundName = "";
        this.reportBackground = false;
        this.brtr = 0;
    }

    private boolean checkDialogTheme(Activity activity) {
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsFloating});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkInterstitial() {
        WeakReference<Activity> weakReference = this.activityRef;
        if (weakReference == null || weakReference.get() == null || this.activityRef.get().isFinishing() || !needWakeUpInterstitialAd() || System.currentTimeMillis() - this.backgroundTime <= this.wParamsInterstitial.getWakeUpTime() || !this.showActivityName.equals(this.activityRef.get().getComponentName().getClassName())) {
            return;
        }
        YdInterstitial ydInterstitialBuild = new YdInterstitial.Builder(this.activityRef.get()).setKey(this.wParamsInterstitial.getPlaceId()).setIsHot(true).setInterstitialListener(new AdViewInterstitialListener() { // from class: com.fl.saas.config.utils.YdAppBackgroundUtil.2
            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClick(String str) {
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClosed() {
                if (YdAppBackgroundUtil.this.ydInterstitial != null) {
                    YdAppBackgroundUtil.this.ydInterstitial.destroy();
                    YdAppBackgroundUtil.this.ydInterstitial = null;
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdDisplay() {
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                if (YdAppBackgroundUtil.this.ydInterstitial != null) {
                    YdAppBackgroundUtil.this.ydInterstitial.destroy();
                    YdAppBackgroundUtil.this.ydInterstitial = null;
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdReady() {
                if (YdAppBackgroundUtil.this.activityRef != null && YdAppBackgroundUtil.this.activityRef.get() != null && !((Activity) YdAppBackgroundUtil.this.activityRef.get()).isFinishing()) {
                    Activity topActivity = DeviceUtil.getTopActivity();
                    if (topActivity != null) {
                        YdAppBackgroundUtil.this.foregroundName = topActivity.getComponentName().getClassName();
                    }
                    if (YdAppBackgroundUtil.this.ydInterstitial != null && YdAppBackgroundUtil.this.showActivityName.equals(YdAppBackgroundUtil.this.foregroundName)) {
                        YdAppBackgroundUtil.this.ydInterstitial.show((Activity) YdAppBackgroundUtil.this.activityRef.get());
                        return;
                    } else if (YdAppBackgroundUtil.this.ydInterstitial == null) {
                        return;
                    }
                } else if (YdAppBackgroundUtil.this.ydInterstitial == null) {
                    return;
                }
                YdAppBackgroundUtil.this.ydInterstitial.destroy();
                YdAppBackgroundUtil.this.ydInterstitial = null;
            }
        }).build();
        this.ydInterstitial = ydInterstitialBuild;
        ydInterstitialBuild.requestInterstitial();
    }

    private void checkSpread(Activity activity) {
        if (!needWakeUpSpreadAd()) {
            checkInterstitial();
        } else {
            if (this.ydSpread != null) {
                checkInterstitial();
                return;
            }
            YdSpread ydSpreadBuild = new YdSpread.Builder(activity).setIsHot(true).setKey(this.wParamsSpread.getPlaceId()).setSpreadLoadListener(new SpreadLoadListener() { // from class: com.zj.adlib.i7a
                @Override // com.fl.saas.base.interfaces.SpreadLoadListener
                public final void onADLoaded(SpreadLoadListener.SpreadAd spreadAd) {
                    this.f42296a.lambda$checkSpread$1(spreadAd);
                }
            }).setSpreadListener(new AdViewSpreadListener() { // from class: com.fl.saas.config.utils.YdAppBackgroundUtil.1
                @Override // com.fl.saas.base.base.listener.InnerSpreadListener
                public void onAdClick(String str) {
                }

                @Override // com.fl.saas.base.base.listener.InnerSpreadListener
                public void onAdClose() {
                    if (YdAppBackgroundUtil.this.ydSpread != null) {
                        YdAdTempHelper.getInstance().closeSpreadSpread(YdAppBackgroundUtil.this.ydSpread.getReqId());
                        YdAppBackgroundUtil.this.ydSpread.destroy();
                        YdAppBackgroundUtil.this.ydSpread = null;
                        YdAppBackgroundUtil.this.checkInterstitial();
                    }
                }

                @Override // com.fl.saas.base.base.listener.InnerSpreadListener
                public void onAdDisplay() {
                }

                @Override // com.fl.saas.base.interfaces.AdViewListener
                public void onAdFailed(YdError ydError) {
                    if (YdAppBackgroundUtil.this.ydSpread != null) {
                        YdAdTempHelper.getInstance().closeSpreadSpread(YdAppBackgroundUtil.this.ydSpread.getReqId());
                        YdAppBackgroundUtil.this.ydSpread.destroy();
                        YdAppBackgroundUtil.this.ydSpread = null;
                        YdAppBackgroundUtil.this.checkInterstitial();
                    }
                }
            }).build();
            this.ydSpread = ydSpreadBuild;
            ydSpreadBuild.requestSpread();
        }
    }

    private boolean checkTranslucentTheme(Activity activity) {
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    public static YdAppBackgroundUtil getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkSpread$1(SpreadLoadListener.SpreadAd spreadAd) {
        WeakReference<Activity> weakReference;
        if (this.ydSpread == null || (weakReference = this.activityRef) == null || weakReference.get() == null || this.activityRef.get().isFinishing()) {
            return;
        }
        YdAdTempHelper.getInstance().setSpreadAd(spreadAd);
        Intent intent = new Intent(this.activityRef.get(), (Class<?>) YdSpreadActivity.class);
        intent.putExtra("id", this.ydSpread.getReqId());
        this.activityRef.get().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClickAdSource$0() {
        if (!this.reportBackground || this.clickAdSource == null) {
            return;
        }
        ReportHelper.getInstance().reportDpEffect(this.clickAdSource, "0", 0L);
        this.clickAdSource = null;
    }

    private boolean needWakeUpInterstitialAd() {
        WParams wParams = this.wParamsInterstitial;
        return (wParams == null || wParams.getWakeUpTime() <= 0 || TextUtils.isEmpty(this.wParamsInterstitial.getPlaceId()) || TextUtils.isEmpty(this.showActivityName) || System.currentTimeMillis() - this.backgroundTime <= this.wParamsInterstitial.getWakeUpTime()) ? false : true;
    }

    private boolean needWakeUpSpreadAd() {
        WParams wParams = this.wParamsSpread;
        return wParams != null && wParams.getWakeUpTime() > 0 && !TextUtils.isEmpty(this.wParamsSpread.getPlaceId()) && System.currentTimeMillis() - this.backgroundTime > this.wParamsSpread.getWakeUpTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppBackground() {
        Log.d("YdSDK-API", "onAppBackground");
        this.reportBackground = false;
        this.backgroundTime = System.currentTimeMillis();
        reportShowAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppForeground(@NonNull Activity activity) {
        this.foregroundName = activity.getComponentName().getClassName();
        Log.d("YdSDK-API", "onAppForeground" + this.foregroundName + this.showActivityName);
        this.activityRef = new WeakReference<>(activity);
        if (this.clickAdSource != null) {
            this.reportBackground = false;
            ReportHelper.getInstance().reportDpEffect(this.clickAdSource, "1", System.currentTimeMillis() - this.backgroundTime);
            this.clickAdSource = null;
        }
        checkSpread(activity);
    }

    private void reportShowAd() {
        List<AdSource> showAd;
        try {
            if (this.brtr <= 0 || (showAd = ReportHelper.getInstance().getShowAd()) == null || showAd.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator<AdSource> it = showAd.iterator();
            while (it.hasNext()) {
                AdSource next = it.next();
                if (next != null) {
                    long j = jCurrentTimeMillis - next.showTime;
                    if (j < ((long) this.brtr) * 1000) {
                        next.distanceFromShowTime = j;
                        arrayList.add(next);
                    }
                    it.remove();
                    ReportHelper.getInstance().removeShowAd(next);
                }
            }
            ReportHelper.getInstance().reportShowAd(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkInterstitialPlaceId(String str) {
        if (this.wParamsInterstitial == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(this.wParamsInterstitial.getPlaceId());
    }

    public boolean isDialogOrTranslucentTheme(Activity activity) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            return (attributes.width == -2) || (attributes.height == -2) || ((attributes.flags & 2) != 0) || checkTranslucentTheme(activity) || checkDialogTheme(activity);
        } catch (Exception unused) {
            return true;
        }
    }

    public void registerActivityLifecycleCallbacks(Context context) {
        if (context != null) {
            try {
                if (this.hasInit) {
                    return;
                }
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new AppLifecycleTracker());
                this.hasInit = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setBrtr(int i) {
        this.brtr = i;
    }

    public void setClickAdSource(AdSource adSource) {
        this.clickAdSource = adSource;
        if (adSource != null) {
            this.reportBackground = true;
            DeviceUtil.postUIDelayed(5000L, new Runnable() { // from class: com.zj.adlib.h7a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42067a.lambda$setClickAdSource$0();
                }
            });
        }
    }

    public void setShowActivityName(String str) {
        this.showActivityName = str;
    }

    public void setWakeUpParamsInterstitial(WParams wParams) {
        this.wParamsInterstitial = wParams;
    }

    public void setWakeUpParamsSpread(WParams wParams) {
        this.wParamsSpread = wParams;
    }
}
