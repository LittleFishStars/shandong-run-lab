package com.fl.saas.base.adapter;

import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerDrawVideoBuilder;
import com.fl.saas.base.interfaces.AdViewDrawVideoListener;
import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AdViewDrawVideoAdapter extends BuilderLoadAdapter<InnerDrawVideoBuilder<?>, AdViewDrawVideoListener> {
    private int adCount;
    private boolean isMute = false;
    protected boolean isVideoReady;
    private List<YdNativePojo> pojoList;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0(AdViewDrawVideoListener adViewDrawVideoListener) {
        adViewDrawVideoListener.onAdViewLoaded(this.pojoList);
    }

    public int getAdCount() {
        return this.adCount;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public boolean isCheckActivity() {
        return true;
    }

    public boolean isMute() {
        return this.isMute;
    }

    public void onClickedEvent(final int i) {
        super.onClickedEvent();
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.sw
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewDrawVideoListener) obj).onAdClick(i);
            }
        });
    }

    public void onLoadedEvent(List<YdNativePojo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.isVideoReady = true;
        this.pojoList = list;
        super.onLoadedEvent();
    }

    public void onShowEvent(final int i) {
        this.isVideoReady = false;
        super.onShowEvent();
        reportRequestShow();
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.rw
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewDrawVideoListener) obj).onAdShow(i);
            }
        });
    }

    @Override // com.fl.saas.base.adapter.base.BuilderLoadAdapter
    public AdViewDrawVideoAdapter setBuilder(InnerDrawVideoBuilder<?> innerDrawVideoBuilder) {
        super.setBuilder(innerDrawVideoBuilder);
        this.adCount = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.pw
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerDrawVideoBuilder) obj).getAdCount());
            }
        }).orElse(1)).intValue();
        this.isMute = ((Boolean) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.qw
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((InnerDrawVideoBuilder) obj).isMute());
            }
        }).orElse(Boolean.FALSE)).booleanValue();
        return this;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        if (this.pojoList == null) {
            onAdFailed(YdError.create(20407, "Exception: DrawVideo showAd, but pojoList is null"));
        } else {
            handleListenerEvent(new Consumer() { // from class: com.zj.adlib.ow
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    this.f43845a.lambda$showAd$0((AdViewDrawVideoListener) obj);
                }
            });
        }
    }
}
