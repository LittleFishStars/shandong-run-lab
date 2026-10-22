package com.fl.saas.base.base.builder;

import android.content.Context;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.base.Build;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.type.AdType;
import com.fl.saas.config.exception.YdError;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerInterstitialBuilder<T> extends BaseBuilder<T> implements AdEventListener<AdViewInterstitialListener> {
    private int autoCloseCountDown;
    private int height;
    protected AdViewInterstitialListener listener;
    private Map<String, Object> locationMap;
    private int width;

    public static abstract class Builder<T, S> extends InnerInterstitialBuilder<T> implements Build<S> {
        public Builder(Context context) {
            super(context);
        }

        @Override // com.fl.saas.base.base.builder.InnerInterstitialBuilder, com.fl.saas.base.base.builder.AdEventListener
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    @API(AdType.Interstitial)
    public static class Default extends InnerInterstitialBuilder<Default> {
        /* JADX WARN: Multi-variable type inference failed */
        public Default(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.base.base.builder.InnerInterstitialBuilder, com.fl.saas.base.base.builder.AdEventListener
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    public InnerInterstitialBuilder(Context context) {
        super(context);
    }

    public int getAutoCloseCountDown() {
        return this.autoCloseCountDown;
    }

    @Override // com.fl.saas.base.base.builder.AdEventListener
    public AdViewInterstitialListener getEventListener() {
        return this.listener;
    }

    public int getHeight() {
        int i = this.height;
        if (i > 0) {
            return i;
        }
        return 300;
    }

    public Map<String, Object> getLocationMap() {
        return this.locationMap;
    }

    public int getWidth() {
        int i = this.width;
        if (i > 0) {
            return i;
        }
        return 300;
    }

    @Override // com.fl.saas.base.base.BaseBuilder, com.fl.saas.base.interfaces.AdViewListener
    public void onAdFailed(YdError ydError) {
        AdViewInterstitialListener adViewInterstitialListener = this.listener;
        if (adViewInterstitialListener != null) {
            adViewInterstitialListener.onAdFailed(ydError);
        }
    }

    public T setAutoCloseCountDown(int i) {
        this.autoCloseCountDown = i;
        return this.builder;
    }

    public T setHeight(int i) {
        this.height = i;
        return this.builder;
    }

    public T setLocalExtra(Map<String, Object> map) {
        this.locationMap = map;
        return this.builder;
    }

    public T setWidth(int i) {
        this.width = i;
        return this.builder;
    }
}
