package com.fl.saas.base.manager;

import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.AdViewNativeAdapter;
import com.fl.saas.base.base.builder.InnerNativeBuilder;
import com.fl.saas.base.interfaces.AdViewNativeListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewNativeManager extends BuilderLoadManager<InnerNativeBuilder<?>, AdViewNativeAdapter, AdViewNativeListener> {
    public AdViewNativeManager() {
        super(AdType.Native);
    }

    public List<YdNativePojo> getBottomAd() {
        selectBottomAd();
        return (List) getValidAdapter().map(new Function() { // from class: com.zj.adlib.my
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ((AdViewNativeAdapter) obj).loadBottomNativeAd();
            }
        }).orElse(null);
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewNativeListener initProxyEventListener(InnerNativeBuilder<?> innerNativeBuilder) {
        final AdViewNativeListener eventListener = innerNativeBuilder.getEventListener();
        return new AdViewNativeListener() { // from class: com.fl.saas.base.manager.AdViewNativeManager.1
            @Override // com.fl.saas.base.base.listener.InnerNativeListener
            public void onAdClick(int i) {
                AdViewNativeListener adViewNativeListener = eventListener;
                if (adViewNativeListener == null) {
                    return;
                }
                adViewNativeListener.onAdClick(i);
            }

            @Override // com.fl.saas.base.base.listener.InnerNativeLoaded.NativeDisplay
            public void onAdDisplay(List<YdNativePojo> list) {
                AdViewNativeListener adViewNativeListener = eventListener;
                if (adViewNativeListener == null) {
                    return;
                }
                adViewNativeListener.onAdDisplay(list);
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                AdViewNativeListener adViewNativeListener = eventListener;
                if (adViewNativeListener == null) {
                    return;
                }
                adViewNativeListener.onAdFailed(ydError);
            }

            @Override // com.fl.saas.base.base.listener.InnerNativeListener
            public void onAdShow(int i) {
                AdViewNativeListener adViewNativeListener = eventListener;
                if (adViewNativeListener == null) {
                    return;
                }
                adViewNativeListener.onAdShow(i);
            }
        };
    }

    public void pauseVideo() {
        getValidAdapter().ifPresent(new Consumer() { // from class: com.zj.adlib.ry
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeAdapter) obj).pauseVideo();
            }
        });
    }

    public void resume() {
        getValidAdapter().ifPresent(new Consumer() { // from class: com.zj.adlib.oy
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeAdapter) obj).resume();
            }
        });
    }

    public void resumeVideo() {
        getValidAdapter().ifPresent(new Consumer() { // from class: com.zj.adlib.py
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeAdapter) obj).resumeVideo();
            }
        });
    }

    public void setSoundEnable(final boolean z) {
        getValidAdapter().ifPresent(new Consumer() { // from class: com.zj.adlib.qy
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeAdapter) obj).soundControl(z);
            }
        });
    }

    public void startVideo() {
        getValidAdapter().ifPresent(new Consumer() { // from class: com.zj.adlib.sy
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeAdapter) obj).startVideo();
            }
        });
    }

    public void stopVideo() {
        getValidAdapter().ifPresent(new Consumer() { // from class: com.zj.adlib.ny
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeAdapter) obj).stopVideo();
            }
        });
    }
}
