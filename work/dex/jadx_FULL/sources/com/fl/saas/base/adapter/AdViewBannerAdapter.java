package com.fl.saas.base.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerBannerBuilder;
import com.fl.saas.base.interfaces.AdViewBannerListener;
import com.fl.saas.common.util.feature.Consumer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AdViewBannerAdapter extends BuilderLoadAdapter<InnerBannerBuilder<?>, AdViewBannerListener> {
    private int autoSlideInterval;
    private int height;
    private View view;
    private int width;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0(AdViewBannerListener adViewBannerListener) {
        adViewBannerListener.onReceived(this.view);
    }

    public int getAutoSlideInterval() {
        return this.autoSlideInterval;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public boolean isCheckActivity() {
        return true;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onClickedEvent() {
        super.onClickedEvent();
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.fw
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewBannerListener) obj).onAdClick("");
            }
        });
    }

    public void onClosedEvent() {
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.iw
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewBannerListener) obj).onClosed();
            }
        });
    }

    public void onLoadedEvent(@NonNull View view) {
        this.view = view;
        super.onLoadedEvent();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onShowEvent() {
        super.onShowEvent();
        reportRequestShow();
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.hw
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewBannerListener) obj).onAdExposure();
            }
        });
    }

    @Override // com.fl.saas.base.adapter.base.BuilderLoadAdapter
    public BuilderLoadAdapter<InnerBannerBuilder<?>, AdViewBannerListener> setBuilder(InnerBannerBuilder<?> innerBannerBuilder) {
        super.setBuilder(innerBannerBuilder);
        this.width = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.jw
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerBannerBuilder) obj).getWidth());
            }
        }).orElse(0)).intValue();
        this.height = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.kw
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerBannerBuilder) obj).getHeight());
            }
        }).orElse(0)).intValue();
        this.autoSlideInterval = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.lw
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerBannerBuilder) obj).getAutoSlideInterval());
            }
        }).orElse(0)).intValue();
        return this;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        if (this.view != null) {
            handleListenerEvent(new Consumer() { // from class: com.zj.adlib.gw
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    this.f41999a.lambda$showAd$0((AdViewBannerListener) obj);
                }
            });
        }
    }
}
