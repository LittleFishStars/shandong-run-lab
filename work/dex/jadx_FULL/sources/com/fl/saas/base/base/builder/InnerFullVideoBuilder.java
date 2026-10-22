package com.fl.saas.base.base.builder;

import android.content.Context;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.base.Build;
import com.fl.saas.base.interfaces.AdViewFullVideoListener;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.type.AdType;
import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerFullVideoBuilder<T> extends BaseBuilder<T> implements AdEventListener<AdViewFullVideoListener> {
    private boolean isMute;
    protected AdViewFullVideoListener listener;

    public static abstract class Builder<T, S> extends InnerFullVideoBuilder<T> implements Build<S> {
        public Builder(Context context) {
            super(context);
        }

        @Override // com.fl.saas.base.base.builder.InnerFullVideoBuilder, com.fl.saas.base.base.builder.AdEventListener
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    @API(AdType.FullVideo)
    public static class Default extends InnerFullVideoBuilder<Default> {
        /* JADX WARN: Multi-variable type inference failed */
        public Default(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.base.base.builder.InnerFullVideoBuilder, com.fl.saas.base.base.builder.AdEventListener
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    public InnerFullVideoBuilder(Context context) {
        super(context);
        this.isMute = false;
    }

    @Override // com.fl.saas.base.base.builder.AdEventListener
    public AdViewFullVideoListener getEventListener() {
        return this.listener;
    }

    public boolean isMute() {
        return this.isMute;
    }

    @Override // com.fl.saas.base.base.BaseBuilder, com.fl.saas.base.interfaces.AdViewListener
    public void onAdFailed(YdError ydError) {
        AdViewFullVideoListener adViewFullVideoListener = this.listener;
        if (adViewFullVideoListener != null) {
            adViewFullVideoListener.onAdFailed(ydError);
        }
    }

    public T setMute(boolean z) {
        this.isMute = z;
        return this.builder;
    }
}
