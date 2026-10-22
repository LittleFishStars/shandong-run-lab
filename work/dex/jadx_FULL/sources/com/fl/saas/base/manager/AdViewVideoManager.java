package com.fl.saas.base.manager;

import android.app.Activity;
import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.adapter.AdViewSpreadAdapter;
import com.fl.saas.base.adapter.AdViewVideoAdapter;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.base.builder.InnerVideoBuilder;
import com.fl.saas.base.interfaces.AdViewVideoCheckListener;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.base.manager.AdViewVideoManager;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewVideoManager extends BuilderLoadManager<InnerVideoBuilder<?>, AdViewVideoAdapter, AdViewVideoListener> {
    private boolean isRequestAd;

    public AdViewVideoManager() {
        super(AdType.RewardVideo);
        this.isRequestAd = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isServerVerify() {
        return ((Boolean) Optional.ofNullable(getAdPlace()).map(new Function() { // from class: com.zj.adlib.mz
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return AdViewVideoManager.lambda$isServerVerify$0((AdPlace) obj);
            }
        }).orElse(Boolean.FALSE)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isServerVerifyShowLoad() {
        return ((Boolean) Optional.ofNullable(getAdPlace()).map(new Function() { // from class: com.zj.adlib.lz
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return AdViewVideoManager.lambda$isServerVerifyShowLoad$1((AdPlace) obj);
            }
        }).orElse(Boolean.FALSE)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isServerVerify$0(AdPlace adPlace) {
        return Boolean.valueOf(adPlace.server_verify);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isServerVerifyShowLoad$1(AdPlace adPlace) {
        return Boolean.valueOf(adPlace.server_verify_time == 1);
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewVideoListener initProxyEventListener(final InnerVideoBuilder<?> innerVideoBuilder) {
        final AdViewVideoListener eventListener = innerVideoBuilder.getEventListener();
        final AdViewVideoCheckListener checkListener = innerVideoBuilder.getCheckListener();
        return new AdViewVideoListener() { // from class: com.fl.saas.base.manager.AdViewVideoManager.1
            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdClick(String str) {
                LogcatUtil.d("YdSDK-Video", "onAdClick");
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onAdClick(str);
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdClose() {
                LogcatUtil.d("YdSDK-Video", "onAdClose");
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onAdClose();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d("YdSDK-Video", "onAdFailed: " + ydError);
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onAdFailed(ydError);
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdShow() {
                LogcatUtil.d("YdSDK-Video", "onAdShow");
                AdapterAPI showAdapter = AdViewVideoManager.this.getShowAdapter();
                String userId = innerVideoBuilder.getUserId();
                if (AdViewVideoManager.this.isServerVerifyShowLoad() && AdViewVideoManager.this.isServerVerify() && showAdapter != null) {
                    LogcatUtil.d("YdSDK-Video", "reqVideoVerify");
                    AdSource adSource = showAdapter.getAdSource();
                    int price = adSource.getPrice();
                    ConfigHelper.getInstance().reqVideoVerify(userId, innerVideoBuilder.getCustomData(), DeviceUtil.appId, innerVideoBuilder.getKey(), adSource.req_id, price + "");
                }
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onAdShow();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onSkipVideo() {
                LogcatUtil.d("YdSDK-Video", "onSkipVideo");
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onSkipVideo();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoCompleted() {
                LogcatUtil.d("YdSDK-Video", "onVideoCompleted");
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onVideoCompleted();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoPrepared() {
                LogcatUtil.d("YdSDK-Video", "onVideoPrepared");
                AdViewVideoListener adViewVideoListener = eventListener;
                if (adViewVideoListener == null) {
                    return;
                }
                adViewVideoListener.onVideoPrepared();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoReward(double d) {
                AdViewVideoCheckListener adViewVideoCheckListener;
                LogcatUtil.d("YdSDK-Video", "onVideoReward:" + d);
                AdapterAPI showAdapter = AdViewVideoManager.this.getShowAdapter();
                String userId = innerVideoBuilder.getUserId();
                if (!AdViewVideoManager.this.isServerVerifyShowLoad() && AdViewVideoManager.this.isServerVerify() && showAdapter != null) {
                    LogcatUtil.d("YdSDK-Video", "reqVideoVerify");
                    AdSource adSource = showAdapter.getAdSource();
                    int price = adSource.getPrice();
                    ConfigHelper.getInstance().reqVideoVerify(userId, innerVideoBuilder.getCustomData(), DeviceUtil.appId, innerVideoBuilder.getKey(), adSource.req_id, price + "");
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

    public boolean isReady() {
        try {
            AdapterAPI showAdapter = getShowAdapter();
            if (showAdapter instanceof AdViewVideoAdapter) {
                return ((AdViewVideoAdapter) showAdapter).isVideoReady();
            }
            if (showAdapter instanceof AdViewInterstitialAdapter) {
                return ((AdViewInterstitialAdapter) showAdapter).isIntersReady();
            }
            if (showAdapter instanceof AdViewSpreadAdapter) {
                return ((AdViewSpreadAdapter) showAdapter).isAdReady();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager, com.fl.saas.base.manager.api.ManagerAPI
    public void request(InnerVideoBuilder<?> innerVideoBuilder) {
        super.request(innerVideoBuilder);
        this.isRequestAd = true;
    }

    @Deprecated
    public void show() {
        show(null);
    }

    public void show(Activity activity) {
        if (!this.isRequestAd) {
            LogcatUtil.d("YdSDK-Video", "调用show()方法前，必须先调用requestAd()方法");
            onAdFailed(new YdError(20410, "未执行requestAd()方法"));
            return;
        }
        if (!isReady()) {
            LogcatUtil.d("YdSDK-Video", "调用show()方法前，必须先检查isReady()状态，或者在onVideoPrepared()回调后调用");
            onAdFailed(new YdError(20410, "调用show()方法前，必须先检查isReady()状态，或者在onVideoPrepared()回调后调用"));
            return;
        }
        try {
            AdapterAPI showAdapter = getShowAdapter();
            if (showAdapter instanceof AdViewVideoAdapter) {
                AdViewVideoAdapter adViewVideoAdapter = (AdViewVideoAdapter) showAdapter;
                if (activity == null) {
                    adViewVideoAdapter.showVideoAd();
                    return;
                } else {
                    adViewVideoAdapter.showVideoAd(activity);
                    return;
                }
            }
            if (showAdapter instanceof AdViewInterstitialAdapter) {
                AdViewInterstitialAdapter adViewInterstitialAdapter = (AdViewInterstitialAdapter) showAdapter;
                if (activity == null) {
                    activity = DeviceUtil.getTopActivity();
                }
                adViewInterstitialAdapter.showInterstitialAd(activity);
                return;
            }
            if (showAdapter instanceof AdViewSpreadAdapter) {
                AdViewSpreadAdapter adViewSpreadAdapter = (AdViewSpreadAdapter) showAdapter;
                if (activity == null) {
                    activity = DeviceUtil.getTopActivity();
                }
                adViewSpreadAdapter.startActivityShow(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
