package com.fl.saas.base.manager;

import android.app.Activity;
import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.adapter.AdViewSpreadAdapter;
import com.fl.saas.base.adapter.AdViewVideoAdapter;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.base.builder.InnerInterstitialBuilder;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.YdAppBackgroundUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewInterstitialManager extends BuilderLoadManager<InnerInterstitialBuilder<?>, AdViewInterstitialAdapter, AdViewInterstitialListener> {
    public AdViewInterstitialManager() {
        super(AdType.Interstitial);
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewInterstitialListener initProxyEventListener(InnerInterstitialBuilder<?> innerInterstitialBuilder) {
        final AdViewInterstitialListener eventListener = innerInterstitialBuilder.getEventListener();
        return new AdViewInterstitialListener() { // from class: com.fl.saas.base.manager.AdViewInterstitialManager.1
            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClick(String str) {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdClick(str);
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClosed() {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdDisplay() {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdDisplay();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdFailed(ydError);
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdReady() {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdReady();
            }
        };
    }

    public boolean isReady() {
        AdapterAPI showAdapter = getShowAdapter();
        if (showAdapter instanceof AdViewVideoAdapter) {
            return ((AdViewVideoAdapter) showAdapter).isVideoReady();
        }
        if (showAdapter instanceof AdViewInterstitialAdapter) {
            return ((AdViewInterstitialAdapter) showAdapter).isIntersReady();
        }
        return showAdapter instanceof AdViewSpreadAdapter ? ((AdViewSpreadAdapter) showAdapter).isAdReady() : ((Boolean) getValidAdapter().map(new Function() { // from class: com.zj.adlib.px
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((AdViewInterstitialAdapter) obj).isIntersReady());
            }
        }).orElse(Boolean.FALSE)).booleanValue();
    }

    public void show(Activity activity) {
        try {
            AdapterAPI showAdapter = getShowAdapter();
            if (showAdapter instanceof AdViewVideoAdapter) {
                AdViewVideoAdapter adViewVideoAdapter = (AdViewVideoAdapter) showAdapter;
                if (activity == null) {
                    adViewVideoAdapter.showVideoAd();
                } else {
                    adViewVideoAdapter.showVideoAd(activity);
                }
            } else if (showAdapter instanceof AdViewInterstitialAdapter) {
                AdViewInterstitialAdapter adViewInterstitialAdapter = (AdViewInterstitialAdapter) showAdapter;
                if (activity == null) {
                    activity = DeviceUtil.getTopActivity();
                }
                adViewInterstitialAdapter.showInterstitialAd(activity);
            } else if (showAdapter instanceof AdViewSpreadAdapter) {
                AdViewSpreadAdapter adViewSpreadAdapter = (AdViewSpreadAdapter) showAdapter;
                if (activity == null) {
                    activity = DeviceUtil.getTopActivity();
                }
                adViewSpreadAdapter.startActivityShow(activity);
            }
            if (getBuilder() == null || !YdAppBackgroundUtil.getInstance().checkInterstitialPlaceId(getBuilder().getKey()) || activity == null || getShowAdapter().getAdSource().isHot) {
                return;
            }
            YdAppBackgroundUtil.getInstance().setShowActivityName(activity.getComponentName().getClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
