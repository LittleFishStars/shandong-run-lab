package com.fl.saas.adx.base.manager;

import android.app.Activity;
import com.fl.saas.AbstractC1405e;
import com.fl.saas.AbstractC1409g;
import com.fl.saas.AbstractC1411h;
import com.fl.saas.C1415j;
import com.fl.saas.E0;
import com.fl.saas.adx.base.base.AdapterAPI;
import com.fl.saas.adx.base.base.builder.InnerVideoBuilder;
import com.fl.saas.adx.base.bean.AdType;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdViewVideoCheckListener;
import com.fl.saas.adx.base.interfaces.AdViewVideoListener;
import com.fl.saas.adx.base.manager.manager.BuilderLoadManager;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewVideoManager extends BuilderLoadManager<InnerVideoBuilder<?>, AbstractC1411h, AdViewVideoListener> {
    private boolean isRequestAd;

    public AdViewVideoManager() {
        super(AdType.RewardVideo);
        this.isRequestAd = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isServerVerify() {
        C1415j adSource;
        AdapterAPI showAdapter = getShowAdapter();
        if (showAdapter == null || (adSource = showAdapter.getAdSource()) == null) {
            return false;
        }
        return adSource.p0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isServerVerifyShowLoad() {
        C1415j adSource;
        AdapterAPI showAdapter = getShowAdapter();
        return (showAdapter == null || (adSource = showAdapter.getAdSource()) == null || adSource.q0 != 1) ? false : true;
    }

    public boolean isReady() {
        try {
            AdapterAPI showAdapter = getShowAdapter();
            if (showAdapter instanceof AbstractC1411h) {
                return ((AbstractC1411h) showAdapter).b();
            }
            if (showAdapter instanceof AbstractC1405e) {
                return ((AbstractC1405e) showAdapter).isIntersReady();
            }
            if (showAdapter instanceof AbstractC1409g) {
                return ((AbstractC1409g) showAdapter).isAdReady();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Deprecated
    public void show() {
        show(null);
    }

    @Override // com.fl.saas.adx.base.manager.manager.BuilderLoadManager
    public AdViewVideoListener initProxyEventListener(final InnerVideoBuilder<?> innerVideoBuilder) {
        final AdViewVideoListener eventListener = innerVideoBuilder.getEventListener();
        final AdViewVideoCheckListener checkListener = innerVideoBuilder.getCheckListener();
        return new AdViewVideoListener() { // from class: com.fl.saas.adx.base.manager.AdViewVideoManager.1
            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onAdClick(String str) {
                LogcatUtil.d("FLSDK-Video", "onAdClick");
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onAdClick(str);
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onAdClose() {
                LogcatUtil.d("FLSDK-Video", "onAdClose");
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onAdClose();
            }

            @Override // com.fl.saas.adx.base.interfaces.AdViewListener
            public void onAdFailed(FLError fLError) {
                LogcatUtil.d("FLSDK-Video", "onAdFailed: " + fLError);
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onAdFailed(fLError);
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onAdShow() {
                LogcatUtil.d("FLSDK-Video", "onAdShow");
                AdapterAPI showAdapter = AdViewVideoManager.this.getShowAdapter();
                String userId = innerVideoBuilder.getUserId();
                if (AdViewVideoManager.this.isServerVerifyShowLoad() && AdViewVideoManager.this.isServerVerify() && showAdapter != null) {
                    LogcatUtil.d("FLSDK-Video", "reqVideoVerify");
                    C1415j adSource = showAdapter.getAdSource();
                    int i = adSource.i();
                    E0.a().a(userId, innerVideoBuilder.getCustomData(), DeviceUtil.appId, innerVideoBuilder.getKey(), adSource.g, i + "");
                }
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onAdShow();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onSkipVideo() {
                LogcatUtil.d("FLSDK-Video", "onSkipVideo");
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onSkipVideo();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onVideoCompleted() {
                LogcatUtil.d("FLSDK-Video", "onVideoCompleted");
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onVideoCompleted();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onVideoPrepared() {
                LogcatUtil.d("FLSDK-Video", "onVideoPrepared");
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onVideoPrepared();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onVideoReward(double d) {
                AdViewVideoCheckListener adViewVideoCheckListener;
                LogcatUtil.d("FLSDK-Video", "onVideoReward:" + d);
                AdapterAPI showAdapter = AdViewVideoManager.this.getShowAdapter();
                String userId = innerVideoBuilder.getUserId();
                if (!AdViewVideoManager.this.isServerVerifyShowLoad() && AdViewVideoManager.this.isServerVerify() && showAdapter != null) {
                    LogcatUtil.d("FLSDK-Video", "reqVideoVerify");
                    C1415j adSource = showAdapter.getAdSource();
                    int i = adSource.i();
                    E0.a().a(userId, innerVideoBuilder.getCustomData(), DeviceUtil.appId, innerVideoBuilder.getKey(), adSource.g, i + "");
                }
                if (AdViewVideoManager.this.isServerVerify() && (adViewVideoCheckListener = checkListener) != null) {
                    adViewVideoCheckListener.onVideoCheckReward(AdViewVideoManager.this.getReqId());
                }
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onVideoReward(d);
            }
        };
    }

    @Override // com.fl.saas.adx.base.manager.manager.BuilderLoadManager, com.fl.saas.adx.base.manager.api.ManagerAPI
    public void request(InnerVideoBuilder<?> innerVideoBuilder) {
        super.request(innerVideoBuilder);
        this.isRequestAd = true;
    }

    public void show(Activity activity) {
        if (!this.isRequestAd) {
            LogcatUtil.d("FLSDK-Video", "调用show()方法前，必须先调用requestAd()方法");
            onAdFailed(new FLError(20410, "未执行requestAd()方法"));
            return;
        }
        if (!isReady()) {
            LogcatUtil.d("FLSDK-Video", "调用show()方法前，必须先检查isReady()状态，或者在onVideoPrepared()回调后调用");
            onAdFailed(new FLError(20410, "调用show()方法前，必须先检查isReady()状态，或者在onVideoPrepared()回调后调用"));
            return;
        }
        try {
            AdapterAPI showAdapter = getShowAdapter();
            if (showAdapter instanceof AbstractC1411h) {
                AbstractC1411h abstractC1411h = (AbstractC1411h) showAdapter;
                if (activity == null) {
                    abstractC1411h.f();
                    return;
                } else {
                    abstractC1411h.b(activity);
                    return;
                }
            }
            if (showAdapter instanceof AbstractC1405e) {
                AbstractC1405e abstractC1405e = (AbstractC1405e) showAdapter;
                if (activity == null) {
                    activity = DeviceUtil.getTopActivity();
                }
                abstractC1405e.showInterstitialAd(activity);
                return;
            }
            if (showAdapter instanceof AbstractC1409g) {
                AbstractC1409g abstractC1409g = (AbstractC1409g) showAdapter;
                if (activity == null) {
                    activity = DeviceUtil.getTopActivity();
                }
                abstractC1409g.startActivityShow(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
