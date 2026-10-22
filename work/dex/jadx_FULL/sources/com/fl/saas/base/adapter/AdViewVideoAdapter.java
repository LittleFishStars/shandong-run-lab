package com.fl.saas.base.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.base.base.builder.InnerVideoBuilder;
import com.fl.saas.base.interfaces.AdMaterial;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AdViewVideoAdapter extends BuilderLoadAdapter<InnerVideoBuilder<?>, AdViewVideoListener> {
    private boolean isVideoReady;

    public boolean isVideoReady() {
        return this.isVideoReady;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onClickedEvent() {
        super.onClickedEvent();
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onAdClick("");
        } else if (eventListener instanceof AdViewInterstitialListener) {
            ((AdViewInterstitialListener) eventListener).onAdClick("");
        } else if (eventListener instanceof AdViewSpreadListener) {
            ((AdViewSpreadListener) eventListener).onAdClick("");
        }
    }

    public void onClosedEvent() {
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onAdClose();
        } else if (eventListener instanceof AdViewInterstitialListener) {
            ((AdViewInterstitialListener) eventListener).onAdClosed();
        } else if (eventListener instanceof AdViewSpreadListener) {
            ((AdViewSpreadListener) eventListener).onAdClose();
        }
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onLoadedEvent() {
        this.isVideoReady = true;
        super.onLoadedEvent();
    }

    public void onRewardEvent() {
        double d = getAdSource().price > 0 ? getAdSource().price : getAdSource().bidfloor;
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onVideoReward(d);
        }
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onShowEvent() {
        this.isVideoReady = false;
        super.onShowEvent();
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onAdShow();
        } else if (eventListener instanceof AdViewInterstitialListener) {
            ((AdViewInterstitialListener) eventListener).onAdDisplay();
        } else if (eventListener instanceof AdViewSpreadListener) {
            ((AdViewSpreadListener) eventListener).onAdDisplay();
        }
    }

    public void onSkipEvent() {
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onSkipVideo();
        }
    }

    public void onVideoCompletedEvent() {
        AdViewListener eventListener = getEventListener();
        if (eventListener instanceof AdViewVideoListener) {
            ((AdViewVideoListener) eventListener).onVideoCompleted();
        }
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        String str;
        super.showAd();
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
                    spreadLoadListener.onADLoaded(new SpreadLoadListener.SpreadAd() { // from class: com.fl.saas.base.adapter.AdViewVideoAdapter.1
                        @Override // com.fl.saas.base.interfaces.AdMaterial
                        @Nullable
                        public AdMaterial.AdMaterialData getAdMaterialData() {
                            return null;
                        }

                        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
                        public int getEcpm() {
                            return AdViewVideoAdapter.this.getAdSource().getECPM();
                        }

                        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
                        public boolean isAdReady() {
                            return AdViewVideoAdapter.this.isVideoReady;
                        }

                        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
                        public boolean isSpread() {
                            return false;
                        }

                        @Override // com.fl.saas.base.interfaces.SpreadLoadListener.SpreadAd
                        public void show(Activity activity, ViewGroup viewGroup) {
                            if (activity == null) {
                                Activity activityOrNull = AdViewVideoAdapter.this.getActivityOrNull();
                                if (activityOrNull == null) {
                                    activityOrNull = DeviceUtil.getTopActivity();
                                }
                                AdViewVideoAdapter.this.showVideoAd(activityOrNull);
                            }
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

    public abstract void showRewardVideo();

    public void showVideoAd() {
        this.isVideoReady = false;
        reportRequestShow();
        showRewardVideo();
    }

    public void showVideoAd(Activity activity) {
        setContext((Context) activity);
        this.isVideoReady = false;
        reportRequestShow();
        showRewardVideo();
    }
}
