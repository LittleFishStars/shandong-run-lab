package com.fl.saas.base.base.builder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.base.Build;
import com.fl.saas.base.interfaces.AdLoadEvent;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.base.type.AdType;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerSpreadBuilder<T> extends BaseBuilder<T> implements AdEventListener<AdViewSpreadListener>, AdLoadEvent {
    private static final int DEFAULT_SCREEN_PERCENTAGE = 1;
    private ViewGroup container;
    private int height;
    protected AdViewSpreadListener listener;
    private Map<String, Object> locationMap;
    private float screenPercentage;
    protected SpreadLoadListener spreadLoadListener;
    private int width;

    public static abstract class Builder<T, S> extends InnerSpreadBuilder<T> implements Build<S> {
        public Builder(Context context) {
            super(context);
        }

        @Override // com.fl.saas.base.base.builder.InnerSpreadBuilder, com.fl.saas.base.base.builder.AdEventListener
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

        @Override // com.fl.saas.base.base.builder.InnerSpreadBuilder, com.fl.saas.base.base.builder.AdEventListener
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

    @Override // com.fl.saas.base.base.builder.AdEventListener
    public AdViewSpreadListener getEventListener() {
        return this.listener;
    }

    public int getHeight() {
        return this.height;
    }

    public Map<String, Object> getLocationMap() {
        return this.locationMap;
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

    public int getWidth() {
        return this.width;
    }

    @Override // com.fl.saas.base.base.BaseBuilder, com.fl.saas.base.interfaces.AdViewListener
    public void onAdFailed(YdError ydError) {
        AdViewSpreadListener adViewSpreadListener = this.listener;
        if (adViewSpreadListener != null) {
            adViewSpreadListener.onAdFailed(ydError);
        }
    }

    @Override // com.fl.saas.base.interfaces.AdLoadEvent
    public void onLoadFailed(YdError ydError) {
        SpreadLoadListener spreadLoadListener = this.spreadLoadListener;
        if (spreadLoadListener == null || !(spreadLoadListener instanceof AdLoadEvent)) {
            onAdFailed(ydError);
        } else {
            ((AdLoadEvent) spreadLoadListener).onLoadFailed(ydError);
        }
    }

    public T setAcceptedSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        return this.builder;
    }

    @Deprecated
    public T setContainer(ViewGroup viewGroup) {
        this.container = viewGroup;
        return this.builder;
    }

    public T setLocalExtra(Map<String, Object> map) {
        this.locationMap = map;
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
}
