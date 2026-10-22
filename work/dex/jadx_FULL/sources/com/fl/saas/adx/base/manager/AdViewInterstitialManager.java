package com.fl.saas.adx.base.manager;

import android.app.Activity;
import androidx.arch.core.util.Function;
import com.fl.saas.AbstractC1405e;
import com.fl.saas.AbstractC1409g;
import com.fl.saas.AbstractC1411h;
import com.fl.saas.J;
import com.fl.saas.adx.base.base.AdapterAPI;
import com.fl.saas.adx.base.base.builder.InnerInterstitialBuilder;
import com.fl.saas.adx.base.bean.AdType;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.adx.base.manager.manager.BuilderLoadManager;
import com.fl.saas.adx.util.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewInterstitialManager extends BuilderLoadManager<InnerInterstitialBuilder<?>, AbstractC1405e, AdViewInterstitialListener> {
    public AdViewInterstitialManager() {
        super(AdType.Interstitial);
    }

    @Override // com.fl.saas.adx.base.manager.manager.BuilderLoadManager
    public AdViewInterstitialListener initProxyEventListener(InnerInterstitialBuilder<?> innerInterstitialBuilder) {
        final AdViewInterstitialListener eventListener = innerInterstitialBuilder.getEventListener();
        return new AdViewInterstitialListener() { // from class: com.fl.saas.adx.base.manager.AdViewInterstitialManager.1
            @Override // com.fl.saas.adx.base.base.listener.InnerInterstitialListener
            public void onAdClick(String str) {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdClick(str);
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerInterstitialListener
            public void onAdClosed() {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdClosed();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerInterstitialListener
            public void onAdDisplay() {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdDisplay();
            }

            @Override // com.fl.saas.adx.base.interfaces.AdViewListener
            public void onAdFailed(FLError fLError) {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdFailed(fLError);
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerInterstitialListener
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
        if (showAdapter instanceof AbstractC1411h) {
            return ((AbstractC1411h) showAdapter).b();
        }
        if (showAdapter instanceof AbstractC1405e) {
            return ((AbstractC1405e) showAdapter).isIntersReady();
        }
        return showAdapter instanceof AbstractC1409g ? ((AbstractC1409g) showAdapter).isAdReady() : ((Boolean) getValidAdapter().a(new Function() { // from class: com.zj.adlib.qx
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((AbstractC1405e) obj).isIntersReady());
            }
        }).c(Boolean.FALSE)).booleanValue();
    }

    public void show(Activity activity) {
        try {
            AdapterAPI showAdapter = getShowAdapter();
            if (showAdapter instanceof AbstractC1411h) {
                AbstractC1411h abstractC1411h = (AbstractC1411h) showAdapter;
                if (activity == null) {
                    abstractC1411h.f();
                } else {
                    abstractC1411h.b(activity);
                }
            } else if (showAdapter instanceof AbstractC1405e) {
                AbstractC1405e abstractC1405e = (AbstractC1405e) showAdapter;
                if (activity == null) {
                    activity = DeviceUtil.getTopActivity();
                }
                abstractC1405e.showInterstitialAd(activity);
            } else if (showAdapter instanceof AbstractC1409g) {
                AbstractC1409g abstractC1409g = (AbstractC1409g) showAdapter;
                if (activity == null) {
                    activity = DeviceUtil.getTopActivity();
                }
                abstractC1409g.startActivityShow(activity);
            }
            if (activity == null || getShowAdapter().getAdSource().j0) {
                return;
            }
            J.b().a(activity.getComponentName().getClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
