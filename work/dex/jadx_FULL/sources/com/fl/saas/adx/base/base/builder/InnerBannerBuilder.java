package com.fl.saas.adx.base.base.builder;

import android.content.Context;
import com.fl.saas.adx.base.annotation.API;
import com.fl.saas.adx.base.base.BaseBuilder;
import com.fl.saas.adx.base.base.Build;
import com.fl.saas.adx.base.bean.AdType;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdViewBannerListener;
import com.fl.saas.adx.base.interfaces.AdViewListener;
import com.fl.saas.adx.util.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerBannerBuilder<T> extends BaseBuilder<T> implements AdEventListener<AdViewBannerListener> {
    private int autoSlideInterval;
    private int height;
    protected AdViewBannerListener listener;
    private int width;

    public static abstract class Builder<T, S> extends InnerBannerBuilder<T> implements Build<S> {
        public Builder(Context context) {
            super(context);
        }

        @Override // com.fl.saas.adx.base.base.builder.InnerBannerBuilder, com.fl.saas.adx.base.base.builder.AdEventListener
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    @API(AdType.Banner)
    public static class Default extends InnerBannerBuilder<Default> {
        /* JADX WARN: Multi-variable type inference failed */
        public Default(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.adx.base.base.builder.InnerBannerBuilder, com.fl.saas.adx.base.base.builder.AdEventListener
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    public InnerBannerBuilder(Context context) {
        super(context);
    }

    public int getAutoSlideInterval() {
        return this.autoSlideInterval;
    }

    @Override // com.fl.saas.adx.base.base.builder.AdEventListener
    public AdViewBannerListener getEventListener() {
        return this.listener;
    }

    public int getHeight() {
        if (this.height <= 0) {
            this.height = Math.round(this.width / 6.4f);
        }
        return this.height;
    }

    public int getWidth() {
        if (this.width <= 0) {
            this.width = DeviceUtil.px2dip(DeviceUtil.getMobileWidth());
        }
        return this.width;
    }

    @Override // com.fl.saas.adx.base.base.BaseBuilder, com.fl.saas.adx.base.interfaces.AdViewListener
    public void onAdFailed(FLError fLError) {
        AdViewBannerListener adViewBannerListener = this.listener;
        if (adViewBannerListener != null) {
            adViewBannerListener.onAdFailed(fLError);
        }
    }

    public T setAutoSlideInterval(int i) {
        this.autoSlideInterval = i;
        return this.builder;
    }

    public T setExpressHeight(int i) {
        this.height = i;
        return this.builder;
    }

    public T setExpressWidth(int i) {
        this.width = i;
        return this.builder;
    }
}
