package com.fl.saas.base.base.builder;

import android.content.Context;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.base.Build;
import com.fl.saas.base.interfaces.AdViewDrawVideoListener;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.type.AdType;
import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerDrawVideoBuilder<T> extends BaseBuilder<T> implements AdEventListener<AdViewDrawVideoListener> {
    private int adCount;
    private boolean isMute;
    protected AdViewDrawVideoListener listener;

    public static abstract class Builder<T, S> extends InnerDrawVideoBuilder<T> implements Build<S> {
        public Builder(Context context) {
            super(context);
        }

        @Override // com.fl.saas.base.base.builder.InnerDrawVideoBuilder, com.fl.saas.base.base.builder.AdEventListener
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    @API(AdType.DrawVideo)
    public static class Default extends InnerDrawVideoBuilder<Default> {
        /* JADX WARN: Multi-variable type inference failed */
        public Default(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.base.base.builder.InnerDrawVideoBuilder, com.fl.saas.base.base.builder.AdEventListener
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    public InnerDrawVideoBuilder(Context context) {
        super(context);
        this.isMute = false;
        this.adCount = 1;
    }

    public int getAdCount() {
        int i = this.adCount;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    @Override // com.fl.saas.base.base.builder.AdEventListener
    public AdViewDrawVideoListener getEventListener() {
        return this.listener;
    }

    public boolean isMute() {
        return this.isMute;
    }

    @Override // com.fl.saas.base.base.BaseBuilder, com.fl.saas.base.interfaces.AdViewListener
    public void onAdFailed(YdError ydError) {
        AdViewDrawVideoListener adViewDrawVideoListener = this.listener;
        if (adViewDrawVideoListener != null) {
            adViewDrawVideoListener.onAdFailed(ydError);
        }
    }

    public T setAdCount(int i) {
        this.adCount = i;
        return this.builder;
    }

    public T setMute(boolean z) {
        this.isMute = z;
        return this.builder;
    }
}
