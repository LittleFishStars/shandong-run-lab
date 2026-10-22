package com.fl.saas;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import com.fl.saas.adx.base.base.BaseBuilder;
import com.fl.saas.adx.base.base.builder.InnerBannerBuilder;
import com.fl.saas.adx.base.interfaces.AdViewBannerListener;

/* JADX INFO: renamed from: com.fl.saas.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1403d extends AbstractC1425o {
    private int height;
    private boolean isBannerReady;
    private long responseTime;
    private View view;
    private int width;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AdViewBannerListener adViewBannerListener) {
        adViewBannerListener.onReceived(this.view);
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isBannerReady() {
        try {
            return this.isBannerReady && ((((System.currentTimeMillis() - this.responseTime) / 1000) > ((long) getAdSource().D1) ? 1 : (((System.currentTimeMillis() - this.responseTime) / 1000) == ((long) getAdSource().D1) ? 0 : -1)) < 0);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.D0
    public void onClickedEvent() {
        super.onClickedEvent();
        handleListenerEvent(new B() { // from class: com.zj.adlib.jua
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                ((AdViewBannerListener) obj).onAdClick("");
            }
        });
    }

    public void onClosedEvent() {
        handleListenerEvent(new B() { // from class: com.zj.adlib.rta
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                ((AdViewBannerListener) obj).onClosed();
            }
        });
    }

    public void onLoadedEvent(@NonNull View view) {
        this.isBannerReady = true;
        this.responseTime = System.currentTimeMillis();
        this.view = view;
        super.onLoadedEvent();
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.D0
    public void onShowEvent() {
        super.onShowEvent();
        this.isBannerReady = false;
        reportRequestShow();
        handleListenerEvent(new B() { // from class: com.zj.adlib.zta
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                ((AdViewBannerListener) obj).onAdExposure();
            }
        });
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        if (this.view != null) {
            handleListenerEvent(new B() { // from class: com.zj.adlib.kua
                @Override // com.fl.saas.B
                public final void a(Object obj) {
                    this.f42915a.b((AdViewBannerListener) obj);
                }
            });
        }
    }

    @Override // com.fl.saas.AbstractC1425o
    public AbstractC1425o setBuilder(InnerBannerBuilder<?> innerBannerBuilder) {
        super.setBuilder((BaseBuilder<?>) innerBannerBuilder);
        this.width = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.fua
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerBannerBuilder) obj).getWidth());
            }
        }).c(0)).intValue();
        this.height = ((Integer) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.hua
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((InnerBannerBuilder) obj).getHeight());
            }
        }).c(0)).intValue();
        return this;
    }
}
