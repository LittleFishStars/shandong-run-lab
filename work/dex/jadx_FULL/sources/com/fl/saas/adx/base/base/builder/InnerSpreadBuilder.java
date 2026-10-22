package com.fl.saas.adx.base.base.builder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fl.saas.adx.base.annotation.API;
import com.fl.saas.adx.base.base.BaseBuilder;
import com.fl.saas.adx.base.base.Build;
import com.fl.saas.adx.base.bean.AdType;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdLoadEvent;
import com.fl.saas.adx.base.interfaces.AdViewListener;
import com.fl.saas.adx.base.interfaces.AdViewSpreadListener;
import com.fl.saas.adx.base.interfaces.SpreadLoadListener;
import com.fl.saas.adx.util.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerSpreadBuilder<T> extends BaseBuilder<T> implements AdEventListener<AdViewSpreadListener>, AdLoadEvent {
    private static final int DEFAULT_SCREEN_PERCENTAGE = 1;
    private ViewGroup container;
    protected AdViewSpreadListener listener;
    private float screenPercentage;
    protected SpreadLoadListener spreadLoadListener;

    public static abstract class Builder<T, S> extends InnerSpreadBuilder<T> implements Build<S> {
        public Builder(Context context) {
            super(context);
        }

        @Override // com.fl.saas.adx.base.base.builder.InnerSpreadBuilder, com.fl.saas.adx.base.base.builder.AdEventListener
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    @API(AdType.Spread)
    public static class Default extends InnerSpreadBuilder<Default> {
        /* JADX WARN: Multi-variable type inference failed */
        public Default(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.adx.base.base.builder.InnerSpreadBuilder, com.fl.saas.adx.base.base.builder.AdEventListener
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    public InnerSpreadBuilder(Context context) {
        super(context);
        this.screenPercentage = 1.0f;
    }

    public ViewGroup getContainer() {
        return this.container;
    }

    public float getScreenPercentage() {
        float f = this.screenPercentage;
        if (0.75d > f || f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public SpreadLoadListener getSpreadLoadListener() {
        return this.spreadLoadListener;
    }

    @Override // com.fl.saas.adx.base.base.BaseBuilder, com.fl.saas.adx.base.interfaces.AdViewListener
    public void onAdFailed(FLError fLError) {
        AdViewSpreadListener adViewSpreadListener = this.listener;
        if (adViewSpreadListener != null) {
            adViewSpreadListener.onAdFailed(fLError);
        }
    }

    @Override // com.fl.saas.adx.base.interfaces.AdLoadEvent
    public void onLoadFailed(FLError fLError) {
        SpreadLoadListener spreadLoadListener = this.spreadLoadListener;
        if (spreadLoadListener == null || !(spreadLoadListener instanceof AdLoadEvent)) {
            onAdFailed(fLError);
        } else {
            ((AdLoadEvent) spreadLoadListener).onLoadFailed(fLError);
        }
    }

    @Deprecated
    public T setContainer(ViewGroup viewGroup) {
        this.container = viewGroup;
        return this.builder;
    }

    public T setScaleType(ImageView.ScaleType scaleType) {
        DeviceUtil.scaleType = scaleType;
        return this.builder;
    }

    public T setScreenPercentage(float f) {
        this.screenPercentage = f;
        return this.builder;
    }

    @Override // com.fl.saas.adx.base.base.builder.AdEventListener
    public AdViewSpreadListener getEventListener() {
        return this.listener;
    }
}
