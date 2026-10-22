package com.fl.saas.base.manager;

import com.fl.saas.base.adapter.AdViewDrawVideoAdapter;
import com.fl.saas.base.base.builder.InnerDrawVideoBuilder;
import com.fl.saas.base.interfaces.AdViewDrawVideoListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewDrawVideoManager extends BuilderLoadManager<InnerDrawVideoBuilder<?>, AdViewDrawVideoAdapter, AdViewDrawVideoListener> {
    public AdViewDrawVideoManager() {
        super(AdType.DrawVideo);
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewDrawVideoListener initProxyEventListener(InnerDrawVideoBuilder<?> innerDrawVideoBuilder) {
        final AdViewDrawVideoListener eventListener = innerDrawVideoBuilder.getEventListener();
        return new AdViewDrawVideoListener() { // from class: com.fl.saas.base.manager.AdViewDrawVideoManager.1
            @Override // com.fl.saas.base.base.listener.InnerDrawVideoListener
            public void onAdClick(int i) {
                LogcatUtil.d("YdSDK-DrawVideo", "onAdClick");
                AdViewDrawVideoListener adViewDrawVideoListener = eventListener;
                if (adViewDrawVideoListener == null) {
                    return;
                }
                adViewDrawVideoListener.onAdClick(i);
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d("YdSDK-DrawVideo", "onAdFailed: " + ydError);
                AdViewDrawVideoListener adViewDrawVideoListener = eventListener;
                if (adViewDrawVideoListener == null) {
                    return;
                }
                adViewDrawVideoListener.onAdFailed(ydError);
            }

            @Override // com.fl.saas.base.base.listener.InnerDrawVideoListener
            public void onAdShow(int i) {
                LogcatUtil.d("YdSDK-DrawVideo", "onAdShow");
                AdViewDrawVideoListener adViewDrawVideoListener = eventListener;
                if (adViewDrawVideoListener == null) {
                    return;
                }
                adViewDrawVideoListener.onAdShow(i);
            }

            @Override // com.fl.saas.base.base.listener.InnerNativeLoaded.DrawVideoLoaded
            public void onAdViewLoaded(List<YdNativePojo> list) {
                LogcatUtil.d("YdSDK-DrawVideo", "onVideoPrepared");
                AdViewDrawVideoListener adViewDrawVideoListener = eventListener;
                if (adViewDrawVideoListener == null) {
                    return;
                }
                adViewDrawVideoListener.onAdViewLoaded(list);
            }
        };
    }
}
