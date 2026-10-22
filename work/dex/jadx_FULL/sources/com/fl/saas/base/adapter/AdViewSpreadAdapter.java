package com.fl.saas.base.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.base.inner.YdAdTempHelper;
import com.fl.saas.base.inner.spread.YdSpreadActivity;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.huachenjie.shandong_school.splash.SplashActivity;
import com.zj.adlib.ty;
import com.zj.adlib.uy;
import com.zj.adlib.zy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AdViewSpreadAdapter extends BuilderLoadAdapter<InnerSpreadBuilder<?>, AdViewSpreadListener> {
    private boolean hasCallbackClose;
    private boolean isShow;
    private AdViewLoadListener mAdViewLoadListener;
    private View mView;
    private SpreadLoadListener.SpreadAd spreadAd;
    private final String TAG = CommConstant.getObjTag(this);
    private long adFillingTime = 0;
    private boolean hasBackDisplay = false;
    private final int renderWidth = DeviceUtil.getMobileWidth();
    private int renderHeight = -1;

    public interface AdViewLoadListener {
        void AdViewLoad(ViewGroup viewGroup);
    }

    public class SpreadLoadAd implements SpreadLoadListener.SpreadAd {
        public SpreadLoadAd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$show$0() {
            if (AdViewSpreadAdapter.this.hasCallbackClose) {
                return;
            }
            AdViewSpreadAdapter.this.hasCallbackClose = true;
            AdViewSpreadAdapter.this.handleListenerEvent(new zy());
        }

        @Override // com.fl.saas.base.interfaces.AdMaterial
        public AdMaterial.AdMaterialData getAdMaterialData() {
            AdViewSpreadAdapter adViewSpreadAdapter = AdViewSpreadAdapter.this;
            return adViewSpreadAdapter instanceof AdMaterial ? adViewSpreadAdapter.getMaterialData() : AdMaterial.AdMaterialData.createEmpty(adViewSpreadAdapter.getAdSource().adv_id);
        }

        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
        public int getEcpm() {
            return AdViewSpreadAdapter.this.getAdSource().getECPM();
        }

        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
        public boolean isAdReady() {
            return (AdViewSpreadAdapter.this.isShow || AdViewSpreadAdapter.this.adFillingTime == 0 || DeviceUtil.getBootTime() - AdViewSpreadAdapter.this.adFillingTime >= 1800000) ? false : true;
        }

        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
        public boolean isSpread() {
            return true;
        }

        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
        public void show(Activity activity, ViewGroup viewGroup) {
            if (AdViewSpreadAdapter.this.isHasDestroy()) {
                AdViewSpreadAdapter.this.onAdFailed(YdError.create(20405, "已经调用过销毁方法，无法展示"));
                return;
            }
            if (AdViewSpreadAdapter.this.isShow) {
                return;
            }
            if (AdViewSpreadAdapter.this.getEventListener() instanceof AdViewSpreadListener) {
                DeviceUtil.postUIDelayed(SplashActivity.f36053a, new Runnable() { // from class: com.fl.saas.base.adapter.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30118a.lambda$show$0();
                    }
                });
            }
            AdViewSpreadAdapter.this.reportRequestShow();
            boolean z = true;
            AdViewSpreadAdapter.this.isShow = true;
            if (activity != null) {
                try {
                    AdViewSpreadAdapter.this.setContext((Context) activity);
                } catch (Exception e) {
                    e.printStackTrace();
                    AdViewSpreadAdapter.this.onAdFailed(new YdError(20405, e.getMessage()));
                    return;
                }
            }
            String str = AdViewSpreadAdapter.this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("spreadLoadListener show:");
            if (viewGroup != null) {
                z = false;
            }
            sb.append(z);
            LogcatUtil.d(str, sb.toString());
            AdViewSpreadAdapter.this.loadAdView(viewGroup);
        }

        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
        public void show(ViewGroup viewGroup) {
            Activity activityOrNull = AdViewSpreadAdapter.this.getActivityOrNull();
            if (activityOrNull == null) {
                activityOrNull = DeviceUtil.getTopActivity();
            }
            LogcatUtil.d(AdViewSpreadAdapter.this.TAG, "spreadLoadListener show:" + activityOrNull + AdViewSpreadAdapter.this.isShow);
            show(activityOrNull, viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0(SpreadLoadListener spreadLoadListener) {
        spreadLoadListener.onADLoaded(loadSpreadAd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$1() {
        loadAdView((ViewGroup) getBuilderFieldOptional(new ty()).orElse(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdView(ViewGroup viewGroup) {
        LogcatUtil.d(this.TAG, "loadAdView");
        if (viewGroup == null) {
            onAdFailed(new YdError(20409, "container is null"));
            return;
        }
        View view = this.mView;
        if (view == null) {
            AdViewLoadListener adViewLoadListener = this.mAdViewLoadListener;
            if (adViewLoadListener == null) {
                onAdFailed(new YdError(20405, "Ad filling Exception"));
                return;
            } else {
                adViewLoadListener.AdViewLoad(viewGroup);
                LogcatUtil.d(this.TAG, "viewGroup AdViewLoad");
                return;
            }
        }
        viewGroup.addView(view, ViewHelper.getMatchParent());
        LogcatUtil.d(this.TAG, "viewGroup getWidth" + viewGroup.getWidth());
        LogcatUtil.d(this.TAG, "viewGroup getHeight" + viewGroup.getHeight());
        LogcatUtil.d(this.TAG, "viewGroup addView");
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
    }

    public ViewGroup getContainer() {
        return (ViewGroup) getBuilderFieldOptional(new ty()).orElse(null);
    }

    public int getHeightDP() {
        return DeviceUtil.px2dip(getHeightPX());
    }

    public int getHeightPX() {
        int i = this.renderHeight;
        if (i > 0) {
            return i;
        }
        float fFloatValue = ((Float) getBuilderFieldOptional(new uy()).orElse(Float.valueOf(1.0f))).floatValue();
        int iIntValue = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.vy
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerSpreadBuilder) obj).getHeight());
            }
        }).orElse(0)).intValue();
        this.renderHeight = iIntValue <= 0 ? (int) (DeviceUtil.getMobileHeight() * fFloatValue) : DeviceUtil.dip2px(iIntValue);
        return this.renderHeight;
    }

    public float getScreenPercentage() {
        try {
            return ((Float) getBuilderFieldOptional(new uy()).orElse(Float.valueOf(1.0f))).floatValue();
        } catch (Exception unused) {
            return 1.0f;
        }
    }

    public int getWidthDP() {
        return DeviceUtil.px2dip(this.renderWidth);
    }

    public int getWidthPX() {
        return this.renderWidth;
    }

    public boolean isAdReady() {
        return (this.isShow || this.adFillingTime == 0 || DeviceUtil.getBootTime() - this.adFillingTime >= 1800000) ? false : true;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public boolean isCheckActivity() {
        return true;
    }

    public SpreadLoadListener.SpreadAd loadSpreadAd() {
        LogcatUtil.d(this.TAG, "loadSpreadAd");
        if (this.spreadAd == null) {
            this.spreadAd = new SpreadLoadAd();
        }
        return this.spreadAd;
    }

    @Override // com.fl.saas.base.adapter.base.BuilderLoadAdapter, com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.interfaces.AdViewListener
    public void onAdFailed(YdError ydError) {
        super.onAdFailed(ydError);
        this.hasCallbackClose = true;
        if (getEventListener() instanceof AdViewVideoListener) {
            YdAdTempHelper.getInstance().closeSpreadSpread(getAdSource().req_id);
        }
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onClickedEvent() {
        super.onClickedEvent();
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            AdViewVideoListener adViewVideoListener = (AdViewVideoListener) eventListener;
            adViewVideoListener.onAdClick("");
            if (getAdSource().reward_callback_option == 2) {
                adViewVideoListener.onVideoReward(getAdSource().getECPM());
                return;
            }
            return;
        }
        if (eventListener instanceof AdViewInterstitialListener) {
            ((AdViewInterstitialListener) eventListener).onAdClick("");
        } else if (eventListener instanceof AdViewSpreadListener) {
            ((AdViewSpreadListener) eventListener).onAdClick("");
        }
    }

    public void onClickedEvent(String str) {
        super.onClickedEvent();
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            AdViewVideoListener adViewVideoListener = (AdViewVideoListener) eventListener;
            adViewVideoListener.onAdClick(str);
            if (getAdSource().reward_callback_option == 2) {
                adViewVideoListener.onVideoReward(getAdSource().getECPM());
                return;
            }
            return;
        }
        if (eventListener instanceof AdViewInterstitialListener) {
            ((AdViewInterstitialListener) eventListener).onAdClick("");
        } else if (eventListener instanceof AdViewSpreadListener) {
            ((AdViewSpreadListener) eventListener).onAdClick(str);
        }
    }

    public void onClosedEvent() {
        if (!this.isSelect || this.hasCallbackClose) {
            return;
        }
        this.hasCallbackClose = true;
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            AdViewVideoListener adViewVideoListener = (AdViewVideoListener) eventListener;
            adViewVideoListener.onAdClose();
            if (getAdSource().reward_callback_option == 1) {
                adViewVideoListener.onVideoReward(getAdSource().getECPM());
            }
        } else {
            if (!(eventListener instanceof AdViewInterstitialListener)) {
                if (eventListener instanceof AdViewSpreadListener) {
                    ((AdViewSpreadListener) eventListener).onAdClose();
                    return;
                }
                return;
            }
            ((AdViewInterstitialListener) eventListener).onAdClosed();
        }
        YdAdTempHelper.getInstance().closeSpreadSpread(getAdSource().req_id);
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onShowEvent() {
        super.onShowEvent();
        if (this.hasBackDisplay) {
            return;
        }
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

    public void onSpreadLoadedEvent(View view) {
        onSpreadLoadedEvent(view, null);
    }

    public void onSpreadLoadedEvent(View view, AdViewLoadListener adViewLoadListener) {
        this.adFillingTime = DeviceUtil.getBootTime();
        this.mView = view;
        this.mAdViewLoadListener = adViewLoadListener;
        super.onLoadedEvent();
    }

    public void setSoundEnable(boolean z) {
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        LogcatUtil.d(this.TAG, "show");
        super.showAd();
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            loadSpreadAd();
            ((AdViewVideoListener) eventListener).onVideoPrepared();
        } else if (eventListener instanceof AdViewInterstitialListener) {
            loadSpreadAd();
            ((AdViewInterstitialListener) eventListener).onAdReady();
        } else if (eventListener instanceof AdViewSpreadListener) {
            getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.wy
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((InnerSpreadBuilder) obj).getSpreadLoadListener();
                }
            }).ifPresentOrElse(new Consumer() { // from class: com.zj.adlib.xy
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    this.f45917a.lambda$showAd$0((SpreadLoadListener) obj);
                }
            }, new Runnable() { // from class: com.zj.adlib.yy
                @Override // java.lang.Runnable
                public final void run() {
                    this.f46138a.lambda$showAd$1();
                }
            });
        }
    }

    public void startActivityShow(Activity activity) {
        LogcatUtil.d(this.TAG, "startActivityShow");
        if (this.spreadAd == null || activity == null) {
            onAdFailed(new YdError(20407, "展示广告失败"));
            return;
        }
        YdAdTempHelper.getInstance().setSpreadAd(this.spreadAd);
        Intent intent = new Intent(activity, (Class<?>) YdSpreadActivity.class);
        intent.putExtra("id", getAdSource().req_id);
        activity.startActivity(intent);
    }
}
