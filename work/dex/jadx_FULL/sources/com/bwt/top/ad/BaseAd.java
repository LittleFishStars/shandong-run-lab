package com.bwt.top.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bwt.top.BannerAd;
import com.bwt.top.SplashAd;
import com.bwt.top.ad.AdListener;
import com.bwt.top.ad.loader.AdLoader;
import com.bwt.top.api.ApiManager;
import com.bwt.top.api.FunctionConfig;
import com.bwt.top.api.bean.PriceNoticeBean;
import com.bwt.top.exception.AdError;
import com.bwt.top.kdsksdda.ddksa;
import com.bwt.top.util.ALog;
import com.zj.adlib.iwa;
import com.zj.adlib.ygb;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class BaseAd<T extends AdListener> implements kdsksdda {
    protected Activity mActivity;
    protected T mAdListener;
    protected AdLoader mAdLoader;
    protected String mPosId;
    private Map<String, String> mScenesMap;
    protected long mTimeOut = 3000;
    protected boolean mIsShow = true;
    private ddksa mLifecycleListener = new a();

    public class a implements ddksa {
        public a() {
        }

        @Override // com.bwt.top.kdsksdda.ddksa
        public boolean a(Activity activity) {
            BaseAd baseAd = BaseAd.this;
            AdLoader adLoader = baseAd.mAdLoader;
            if (adLoader == null || activity != baseAd.mActivity) {
                return false;
            }
            adLoader.release();
            return true;
        }

        @Override // com.bwt.top.kdsksdda.ddksa
        public void onActivityPaused(Activity activity) {
            BaseAd baseAd = BaseAd.this;
            AdLoader adLoader = baseAd.mAdLoader;
            if (adLoader == null || activity != baseAd.mActivity) {
                return;
            }
            adLoader.onPaused();
        }

        @Override // com.bwt.top.kdsksdda.ddksa
        public void onActivityResumed(Activity activity) {
            BaseAd baseAd = BaseAd.this;
            AdLoader adLoader = baseAd.mAdLoader;
            if (adLoader == null || activity != baseAd.mActivity) {
                return;
            }
            adLoader.onResumed();
        }
    }

    public BaseAd(Activity activity) {
        this.mActivity = activity;
        initAdLoader();
        iwa.a().b(this.mLifecycleListener);
    }

    private void checkAdSettings() {
        if (TextUtils.isEmpty(this.mPosId)) {
            ALog.i(getClass().getSimpleName(), "posId为空（调用setAdId('广告位的posId')）");
        }
    }

    private void initAdLoader() {
        this.mAdLoader = new ygb(this);
    }

    private void setNoticePrice(String str, int i) {
        ApiManager.noticeBinPrice(new PriceNoticeBean(this.mPosId, str, String.valueOf(i)));
    }

    public void doNoShow() {
        if ((this instanceof BannerAd) || (this instanceof SplashAd)) {
            this.mIsShow = false;
        }
    }

    public T getAdListener() {
        return this.mAdListener;
    }

    public int getBidPrice() {
        if (ApiManager.checkAdSdkInitStatus()) {
            return FunctionConfig.instance().getFirstPosInfoPrice(this.mPosId);
        }
        return -1;
    }

    public Context getContext() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return activity;
        }
        return null;
    }

    public Map<String, String> getScenes() {
        return this.mScenesMap;
    }

    public long getTimeout() {
        return this.mTimeOut;
    }

    public boolean isShow() {
        return this.mIsShow;
    }

    public void loadAd() {
        AdListener adListener;
        AdError adError;
        String str;
        if (ApiManager.checkAdSdkInitStatus()) {
            checkAdSettings();
            AdLoader adLoader = this.mAdLoader;
            if (adLoader != null && (str = this.mPosId) != null) {
                adLoader.loadAd(str);
                return;
            } else {
                if (getAdListener() == null) {
                    return;
                }
                adListener = getAdListener();
                adError = new AdError(100, "do not support " + getClass().getSimpleName());
            }
        } else {
            if (getAdListener() == null) {
                return;
            }
            adListener = getAdListener();
            adError = new AdError(100, "init error");
        }
        adListener.onAdFailed(adError);
    }

    public void release() {
        if (this.mActivity != null) {
            this.mActivity = null;
        }
    }

    public void sendLossNotice(int i) {
        if (ApiManager.checkAdSdkInitStatus()) {
            setNoticePrice("loss", i);
        }
    }

    public void sendWinNotice(int i) {
        if (ApiManager.checkAdSdkInitStatus()) {
            setNoticePrice("win", i);
        }
    }

    public void setAdId(String str) {
        this.mPosId = str;
    }

    public void setAdListener(T t) {
        this.mAdListener = t;
    }

    public void setScenes(Map<String, String> map) {
        this.mScenesMap = map;
    }

    public void setTimeout(long j) {
        if (j > 0) {
            this.mTimeOut = Math.min(this.mTimeOut, j);
        }
    }

    public void showAd() {
        AdLoader adLoader;
        try {
            if (((this instanceof BannerAd) || (this instanceof SplashAd)) && !this.mIsShow && (adLoader = this.mAdLoader) != null && this.mPosId != null) {
                adLoader.showAd();
            } else if (getAdListener() != null) {
                getAdListener().onAdFailed(new AdError(101, "show ad error"));
            }
        } catch (Throwable unused) {
            if (getAdListener() != null) {
                getAdListener().onAdFailed(new AdError(101, "show ad error"));
            }
        }
    }
}
