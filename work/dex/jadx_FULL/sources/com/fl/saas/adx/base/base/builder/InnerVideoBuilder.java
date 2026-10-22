package com.fl.saas.adx.base.base.builder;

import android.content.Context;
import com.fl.saas.adx.base.annotation.API;
import com.fl.saas.adx.base.base.BaseBuilder;
import com.fl.saas.adx.base.base.Build;
import com.fl.saas.adx.base.bean.AdType;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdViewListener;
import com.fl.saas.adx.base.interfaces.AdViewVideoCheckListener;
import com.fl.saas.adx.base.interfaces.AdViewVideoListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerVideoBuilder<T> extends BaseBuilder<T> implements AdEventListener<AdViewVideoListener> {
    protected AdViewVideoCheckListener checkListener;
    private String customData;
    private boolean isExpress;
    private boolean isMute;
    protected AdViewVideoListener listener;
    private String userId;

    public static abstract class Builder<T, S> extends InnerVideoBuilder<T> implements Build<S> {
        public Builder(Context context) {
            super(context);
        }

        @Override // com.fl.saas.adx.base.base.builder.InnerVideoBuilder, com.fl.saas.adx.base.base.builder.AdEventListener
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    @API(AdType.RewardVideo)
    public static class Default extends InnerVideoBuilder<Default> {
        /* JADX WARN: Multi-variable type inference failed */
        public Default(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.adx.base.base.builder.InnerVideoBuilder, com.fl.saas.adx.base.base.builder.AdEventListener
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    public InnerVideoBuilder(Context context) {
        super(context);
        this.isExpress = true;
        this.isMute = false;
    }

    public AdViewVideoCheckListener getCheckListener() {
        return this.checkListener;
    }

    public String getCustomData() {
        return this.customData;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isExpress() {
        return this.isExpress;
    }

    public boolean isMute() {
        return this.isMute;
    }

    @Override // com.fl.saas.adx.base.base.BaseBuilder, com.fl.saas.adx.base.interfaces.AdViewListener
    public void onAdFailed(FLError fLError) {
        AdViewVideoListener adViewVideoListener = this.listener;
        if (adViewVideoListener != null) {
            adViewVideoListener.onAdFailed(fLError);
        }
    }

    public T setCustomData(String str) {
        this.customData = str;
        return this.builder;
    }

    public T setIsExpress(boolean z) {
        this.isExpress = z;
        return this.builder;
    }

    public T setMute(boolean z) {
        this.isMute = z;
        return this.builder;
    }

    public T setUserId(String str) {
        this.userId = str;
        return this.builder;
    }

    @Override // com.fl.saas.adx.base.base.builder.AdEventListener
    public AdViewVideoListener getEventListener() {
        return this.listener;
    }
}
