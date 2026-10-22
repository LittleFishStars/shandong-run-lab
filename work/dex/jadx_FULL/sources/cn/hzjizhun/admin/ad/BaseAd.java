package cn.hzjizhun.admin.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.aaa;
import cn.hzjizhun.admin.ad.AdListener;
import cn.hzjizhun.admin.ad.bean.AdSize;
import cn.hzjizhun.admin.ad.impl.JZBannerAd;
import cn.hzjizhun.admin.ad.impl.JZRewardVideoAd;
import cn.hzjizhun.admin.ad.impl.JZSplashAd;
import cn.hzjizhun.admin.ad.loader.AdLoader;
import cn.hzjizhun.admin.api.ApiManager;
import cn.hzjizhun.admin.api.bean.PriceNoticeBean;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.kdsksdda;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.DeviceUtil;
import cn.hzjizhun.admin.util.LocationUtils;
import com.zj.adlib.ghb;
import com.zj.adlib.qqb;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseAd<T extends AdListener> implements kdsksdda {
    private int bidPrice;
    private HashSet<String> channelList;
    private boolean isLandingPageFlowSystem;
    private boolean isLandingVertical;
    protected boolean isLoadLocation;
    private int landingPageAlpha;
    protected Activity mActivity;
    protected T mAdListener;
    protected AdLoader mAdLoader;
    private AdSize mAdSize;
    private boolean mIsCallShow;
    private volatile boolean mIsReleased;
    protected boolean mIsShow;
    private aaa mLifecycleListener;
    protected String mPosId;
    private Map<String, String> mScenesMap;
    protected long mTimeOut;
    private String reqId;
    private boolean toggleFullLandingPage;

    public class a extends JZAdSdk.JZInitCallback {
        public a() {
        }

        @Override // cn.hzjizhun.admin.JZAdSdk.JZInitCallback
        public void onInitResult(boolean z) {
            ApiManager.removeInnerCallback(BaseAd.this.mPosId);
            if (z) {
                ALog.innerD(ALog.TAG_INIT, "初始化结束，准备请求广告");
                BaseAd.this.realLoadAd();
            } else if (BaseAd.this.getAdListener() != null) {
                BaseAd.this.getAdListener().onAdFailed(new JZAdError(100, "init error"));
            }
        }
    }

    public class b implements aaa {
        public b() {
        }

        @Override // cn.hzjizhun.admin.aaa
        public boolean a(Activity activity) {
            BaseAd baseAd = BaseAd.this;
            AdLoader adLoader = baseAd.mAdLoader;
            if (adLoader == null || activity != baseAd.mActivity) {
                return false;
            }
            adLoader.release();
            return true;
        }

        @Override // cn.hzjizhun.admin.aaa
        public void onActivityPaused(Activity activity) {
            BaseAd baseAd = BaseAd.this;
            AdLoader adLoader = baseAd.mAdLoader;
            if (adLoader == null || activity != baseAd.mActivity) {
                return;
            }
            adLoader.onPaused();
        }

        @Override // cn.hzjizhun.admin.aaa
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
        this(activity, true);
    }

    private void checkAdSettings() {
        if (TextUtils.isEmpty(this.mPosId)) {
            ALog.i(getClass().getSimpleName(), "posId为空（调用setAdId('广告位的posId')）");
        }
    }

    private void setNoticePrice(String str, int i) {
        ApiManager.noticeBinPrice(new PriceNoticeBean(this.mPosId, str, String.valueOf(i)));
    }

    public ghb createAdLoader() {
        return new ghb(this);
    }

    public String createReqId() {
        try {
            if (TextUtils.isEmpty(this.reqId)) {
                this.reqId = DeviceUtil.getReqId(getContext());
            }
            return this.reqId;
        } catch (Throwable unused) {
            return "";
        }
    }

    public void doNoShow() {
        if ((this instanceof JZBannerAd) || (this instanceof JZSplashAd) || (this instanceof JZRewardVideoAd)) {
            this.mIsShow = false;
        }
    }

    public T getAdListener() {
        return this.mAdListener;
    }

    public AdSize getAdSize() {
        return this.mAdSize;
    }

    public Context getContext() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return activity;
        }
        return null;
    }

    public int getJZBidPrice() {
        return this.bidPrice;
    }

    public String getJZReqId() {
        return this.reqId;
    }

    public int getLandingPageAlpha() {
        return this.landingPageAlpha;
    }

    public String getPosId() {
        return this.mPosId;
    }

    public Map<String, String> getScenes() {
        return this.mScenesMap;
    }

    public long getTimeout() {
        return this.mTimeOut;
    }

    public boolean getToggleFullLandingPage() {
        return this.toggleFullLandingPage;
    }

    public boolean hasContainsProduct() {
        return this.channelList.contains(Build.BRAND.toLowerCase());
    }

    public boolean isLandingPageFlowSystem() {
        return this.isLandingPageFlowSystem;
    }

    public boolean isLandingVertical() {
        return this.isLandingVertical;
    }

    public boolean isReleased() {
        return this.mIsReleased;
    }

    public boolean isShow() {
        return this.mIsShow;
    }

    public void loadJZAd() {
        if (ApiManager.checkAdSdkInitStatus()) {
            ALog.innerD(ALog.TAG_INIT, "初始化已经成功，开始请求广告");
            realLoadAd();
        } else if (ApiManager.isUninitialized()) {
            ALog.innerD(ALog.TAG_INIT, "初始化未结束，等待请求广告");
            ApiManager.reportError("10004", this.mPosId);
            ApiManager.putInnerCallback(this.mPosId, new a());
        } else {
            if (getAdListener() != null) {
                getAdListener().onAdFailed(new JZAdError(100, "init error"));
            }
            ApiManager.reportError("10003", this.mPosId);
        }
    }

    public void onDestroyed() {
        this.mIsReleased = true;
        if (this.mActivity != null) {
            this.mActivity = null;
        }
    }

    public void realLoadAd() {
        String str;
        try {
            LocationUtils.getInstance().setIsAdLoadLocation(this.isLoadLocation);
            checkAdSettings();
            AdLoader adLoader = this.mAdLoader;
            if (adLoader != null && (str = this.mPosId) != null) {
                adLoader.loadAd(str);
                return;
            }
            if (getAdListener() != null) {
                getAdListener().onAdFailed(new JZAdError(100, "do not support " + getClass().getSimpleName()));
            }
        } catch (Throwable unused) {
        }
    }

    public void release() {
        try {
            ALog.innerD("", "release......" + this.mIsReleased);
            if (this.mIsReleased) {
                return;
            }
            qqb.b().a(this.mLifecycleListener);
            this.mAdLoader.release();
        } catch (Throwable unused) {
        }
    }

    public void sendJZLossNotice(int i) {
        if (ApiManager.checkAdSdkInitStatus()) {
            setNoticePrice("loss", i);
        }
    }

    public void sendJZWinNotice(int i) {
        if (ApiManager.checkAdSdkInitStatus()) {
            setNoticePrice("win", i);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.mAdSize = adSize;
    }

    public void setBidPrice(int i) {
        this.bidPrice = i;
    }

    public void setJZAdId(String str) {
        this.mPosId = str;
    }

    public void setJZAdListener(T t) {
        this.mAdListener = t;
    }

    public void setJZChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.channelList.add(str.toLowerCase());
    }

    public void setJZScenes(Map<String, String> map) {
        this.mScenesMap = map;
    }

    public void setLandingPageAlpha(int i) {
        this.landingPageAlpha = Math.max(0, Math.min(100, i));
    }

    public void setLandingPageDirection(boolean z) {
        this.isLandingPageFlowSystem = false;
        this.isLandingVertical = z;
    }

    public void setTimeout(long j) {
        if (j > 0) {
            this.mTimeOut = Math.min(this.mTimeOut, j);
        }
    }

    public void setToggleFullLandingPage(boolean z) {
        this.toggleFullLandingPage = z;
    }

    public void shakeClick() {
        try {
            AdLoader adLoader = this.mAdLoader;
            if (adLoader != null) {
                adLoader.shakeClick();
            }
        } catch (Throwable unused) {
        }
    }

    public void showAd() {
        AdLoader adLoader;
        try {
            if (this.mIsShow) {
                return;
            }
            if (this.mIsCallShow) {
                ALog.d("", "广告素材只能展示一次");
                return;
            }
            this.mIsCallShow = true;
            if (((this instanceof JZBannerAd) || (this instanceof JZSplashAd) || (this instanceof JZRewardVideoAd)) && (adLoader = this.mAdLoader) != null && this.mPosId != null) {
                adLoader.showAd();
            } else if (getAdListener() != null) {
                getAdListener().onAdFailed(new JZAdError(101, "show ad error"));
            }
        } catch (Throwable unused) {
            if (getAdListener() != null) {
                getAdListener().onAdFailed(new JZAdError(101, "show ad error"));
            }
        }
    }

    public BaseAd(Activity activity, boolean z) {
        this.isLoadLocation = true;
        this.mTimeOut = 3000L;
        this.mIsShow = true;
        this.mIsCallShow = false;
        this.channelList = new HashSet<>();
        this.toggleFullLandingPage = true;
        this.landingPageAlpha = 0;
        this.isLandingPageFlowSystem = true;
        this.isLandingVertical = true;
        this.reqId = "";
        this.bidPrice = 0;
        this.mActivity = activity;
        this.mAdLoader = createAdLoader();
        this.mLifecycleListener = new b();
        if (z) {
            qqb.b().c(this.mLifecycleListener);
        }
    }
}
