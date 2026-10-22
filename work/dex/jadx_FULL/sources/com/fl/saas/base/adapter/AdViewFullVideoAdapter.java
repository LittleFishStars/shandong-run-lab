package com.fl.saas.base.adapter;

import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerFullVideoBuilder;
import com.fl.saas.base.interfaces.AdViewFullVideoListener;
import com.fl.saas.common.util.feature.Consumer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AdViewFullVideoAdapter extends BuilderLoadAdapter<InnerFullVideoBuilder<?>, AdViewFullVideoListener> {
    private boolean isMute = false;
    private boolean isVideoReady;

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public boolean isCheckActivity() {
        return true;
    }

    public boolean isMute() {
        return this.isMute;
    }

    public boolean isVideoReady() {
        return this.isVideoReady;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onClickedEvent() {
        super.onClickedEvent();
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.uw
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewFullVideoListener) obj).onAdClicked();
            }
        });
    }

    public void onClosedEvent() {
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.xw
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewFullVideoListener) obj).onPageDismiss();
            }
        });
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onLoadedEvent() {
        this.isVideoReady = true;
        super.onLoadedEvent();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onShowEvent() {
        this.isVideoReady = false;
        super.onShowEvent();
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.ww
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewFullVideoListener) obj).onVideoPlayStart();
            }
        });
    }

    @Override // com.fl.saas.base.adapter.base.BuilderLoadAdapter
    public AdViewFullVideoAdapter setBuilder(InnerFullVideoBuilder<?> innerFullVideoBuilder) {
        super.setBuilder(innerFullVideoBuilder);
        this.isMute = ((Boolean) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.vw
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((InnerFullVideoBuilder) obj).isMute());
            }
        }).orElse(Boolean.FALSE)).booleanValue();
        return this;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.tw
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewFullVideoListener) obj).onVideoPrepared();
            }
        });
    }

    public void showRewardVideo() {
        this.isVideoReady = false;
        reportRequestShow();
    }
}
