package com.fl.saas.base.manager;

import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.AdViewFullVideoAdapter;
import com.fl.saas.base.base.builder.InnerFullVideoBuilder;
import com.fl.saas.base.interfaces.AdViewFullVideoListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewFullVideoManager extends BuilderLoadManager<InnerFullVideoBuilder<?>, AdViewFullVideoAdapter, AdViewFullVideoListener> {
    private boolean isRequestAd;

    public AdViewFullVideoManager() {
        super(AdType.FullVideo);
        this.isRequestAd = false;
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewFullVideoListener initProxyEventListener(InnerFullVideoBuilder<?> innerFullVideoBuilder) {
        final AdViewFullVideoListener eventListener = innerFullVideoBuilder.getEventListener();
        return new AdViewFullVideoListener() { // from class: com.fl.saas.base.manager.AdViewFullVideoManager.1
            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onAdClicked() {
                LogcatUtil.d("YdSDK-FullVideo", "onAdClick");
                AdViewFullVideoListener adViewFullVideoListener = eventListener;
                if (adViewFullVideoListener == null) {
                    return;
                }
                adViewFullVideoListener.onAdClicked();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d("YdSDK-FullVideo", "onAdFailed: " + ydError);
                AdViewFullVideoListener adViewFullVideoListener = eventListener;
                if (adViewFullVideoListener == null) {
                    return;
                }
                adViewFullVideoListener.onAdFailed(ydError);
            }

            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onPageDismiss() {
                LogcatUtil.d("YdSDK-FullVideo", "onAdClose");
                AdViewFullVideoListener adViewFullVideoListener = eventListener;
                if (adViewFullVideoListener == null) {
                    return;
                }
                adViewFullVideoListener.onPageDismiss();
            }

            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onVideoPlayStart() {
                LogcatUtil.d("YdSDK-FullVideo", "onAdShow");
                AdViewFullVideoListener adViewFullVideoListener = eventListener;
                if (adViewFullVideoListener == null) {
                    return;
                }
                adViewFullVideoListener.onVideoPlayStart();
            }

            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onVideoPrepared() {
                LogcatUtil.d("YdSDK-FullVideo", "onVideoPrepared");
                AdViewFullVideoListener adViewFullVideoListener = eventListener;
                if (adViewFullVideoListener == null) {
                    return;
                }
                adViewFullVideoListener.onVideoPrepared();
            }
        };
    }

    public boolean isReady() {
        return ((Boolean) getValidAdapter().map(new Function() { // from class: com.zj.adlib.yw
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((AdViewFullVideoAdapter) obj).isVideoReady());
            }
        }).orElse(Boolean.FALSE)).booleanValue();
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager, com.fl.saas.base.manager.api.ManagerAPI
    public void request(InnerFullVideoBuilder<?> innerFullVideoBuilder) {
        super.request(innerFullVideoBuilder);
        this.isRequestAd = true;
    }

    public void show() {
        if (!this.isRequestAd) {
            LogcatUtil.d("YdSDK-Video", "调用show()方法前，必须先调用requestAd()方法");
            onAdFailed(new YdError(20410, "未执行requestAd()方法"));
        } else if (isReady()) {
            getValidAdapter().ifPresent(new Consumer() { // from class: com.zj.adlib.zw
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    ((AdViewFullVideoAdapter) obj).showRewardVideo();
                }
            });
        } else {
            LogcatUtil.d("YdSDK-Video", "调用show()方法前，必须先检查isReady()状态，或者在onVideoPrepared()回调后调用");
            onAdFailed(new YdError(20410, "调用show()方法前，必须先检查isReady()状态，或者在onVideoPrepared()回调后调用"));
        }
    }
}
