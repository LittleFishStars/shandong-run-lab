package com.fl.saas.base.adapter;

import android.view.View;
import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerTemplateBuilder;
import com.fl.saas.base.interfaces.AdViewTemplateListener;
import com.fl.saas.common.util.feature.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AdViewTemplateAdapter extends BuilderLoadAdapter<InnerTemplateBuilder<?>, AdViewTemplateListener> {
    private int adCount;
    private int height;
    private List<View> viewList;
    private int width;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0(AdViewTemplateListener adViewTemplateListener) {
        adViewTemplateListener.onReceived(this.viewList);
    }

    public int getAdCount() {
        return this.adCount;
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

    public void onClickedEvent(final int i) {
        super.onClickedEvent();
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.jz
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewTemplateListener) obj).onAdClick(i, "");
            }
        });
    }

    public void onClosedEvent(final View view) {
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.ez
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewTemplateListener) obj).onClosed(view);
            }
        });
    }

    public void onLoadedEvent(List<View> list) {
        this.viewList = list;
        super.onLoadedEvent();
    }

    public void onShowEvent(final int i) {
        super.onShowEvent();
        handleListenerEvent(new Consumer() { // from class: com.zj.adlib.dz
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewTemplateListener) obj).onAdShow(i);
            }
        });
    }

    @Override // com.fl.saas.base.adapter.base.BuilderLoadAdapter
    public AdViewTemplateAdapter setBuilder(InnerTemplateBuilder<?> innerTemplateBuilder) {
        super.setBuilder(innerTemplateBuilder);
        this.adCount = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.fz
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerTemplateBuilder) obj).getAdCount());
            }
        }).orElse(1)).intValue();
        this.width = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.gz
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerTemplateBuilder) obj).getWidth());
            }
        }).orElse(300)).intValue();
        this.height = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.hz
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerTemplateBuilder) obj).getHeight());
            }
        }).orElse(300)).intValue();
        return this;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        if (this.viewList != null) {
            handleListenerEvent(new Consumer() { // from class: com.zj.adlib.iz
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    this.f42469a.lambda$showAd$0((AdViewTemplateListener) obj);
                }
            });
        }
    }
}
