package com.fl.saas.base.manager;

import android.view.View;
import com.fl.saas.base.adapter.AdViewTemplateAdapter;
import com.fl.saas.base.base.builder.InnerTemplateBuilder;
import com.fl.saas.base.interfaces.AdViewTemplateListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewTemplateManager extends BuilderLoadManager<InnerTemplateBuilder<?>, AdViewTemplateAdapter, AdViewTemplateListener> {
    private boolean isShow;

    public AdViewTemplateManager() {
        super(AdType.Template);
        this.isShow = false;
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewTemplateListener initProxyEventListener(InnerTemplateBuilder<?> innerTemplateBuilder) {
        final AdViewTemplateListener eventListener = innerTemplateBuilder.getEventListener();
        return new AdViewTemplateListener() { // from class: com.fl.saas.base.manager.AdViewTemplateManager.1
            @Override // com.fl.saas.base.base.listener.InnerTemplateListener
            public void onAdClick(int i, String str) {
                AdViewTemplateListener adViewTemplateListener = eventListener;
                if (adViewTemplateListener == null) {
                    return;
                }
                adViewTemplateListener.onAdClick(i, str);
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                AdViewTemplateListener adViewTemplateListener = eventListener;
                if (adViewTemplateListener == null) {
                    return;
                }
                adViewTemplateListener.onAdFailed(ydError);
            }

            @Override // com.fl.saas.base.base.listener.InnerTemplateListener
            public void onAdShow(int i) {
                LogcatUtil.d("YdSDK-TemplateManager", "onAdShow");
                if (AdViewTemplateManager.this.isShow) {
                    return;
                }
                AdViewTemplateManager.this.isShow = true;
                AdViewTemplateManager.this.getValidAdapter().ifPresent(new Consumer() { // from class: com.zj.adlib.kz
                    @Override // com.fl.saas.common.util.feature.Consumer
                    public final void accept(Object obj) {
                        ((AdViewTemplateAdapter) obj).reportRequestShow();
                    }
                });
                AdViewTemplateListener adViewTemplateListener = eventListener;
                if (adViewTemplateListener == null) {
                    return;
                }
                adViewTemplateListener.onAdShow(i);
            }

            @Override // com.fl.saas.base.base.listener.InnerTemplateListener
            public void onClosed(View view) {
                AdViewTemplateListener adViewTemplateListener = eventListener;
                if (adViewTemplateListener == null) {
                    return;
                }
                adViewTemplateListener.onClosed(view);
            }

            @Override // com.fl.saas.base.base.listener.InnerTemplateListener
            public void onReceived(List<View> list) {
                AdViewTemplateListener adViewTemplateListener = eventListener;
                if (adViewTemplateListener == null) {
                    return;
                }
                adViewTemplateListener.onReceived(list);
            }
        };
    }
}
