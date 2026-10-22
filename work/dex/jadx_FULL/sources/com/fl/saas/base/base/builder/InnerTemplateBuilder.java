package com.fl.saas.base.base.builder;

import android.content.Context;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.base.Build;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.interfaces.AdViewTemplateListener;
import com.fl.saas.base.type.AdType;
import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Deprecated
public abstract class InnerTemplateBuilder<T> extends BaseBuilder<T> implements AdEventListener<AdViewTemplateListener> {
    private int adCount;
    private int height;
    private int layoutType;
    protected AdViewTemplateListener listener;
    private int width;

    @Deprecated
    public static abstract class Builder<T, S> extends InnerTemplateBuilder<T> implements Build<S> {
        @Deprecated
        public Builder(Context context) {
            super(context);
        }

        @Override // com.fl.saas.base.base.builder.InnerTemplateBuilder, com.fl.saas.base.base.builder.AdEventListener
        @Deprecated
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    @Deprecated
    @API(AdType.Template)
    public static class Default extends InnerTemplateBuilder<Default> {
        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated
        public Default(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.base.base.builder.InnerTemplateBuilder, com.fl.saas.base.base.builder.AdEventListener
        @Deprecated
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    @Deprecated
    public InnerTemplateBuilder(Context context) {
        super(context);
    }

    @Deprecated
    public int getAdCount() {
        return this.adCount;
    }

    @Override // com.fl.saas.base.base.builder.AdEventListener
    @Deprecated
    public AdViewTemplateListener getEventListener() {
        return this.listener;
    }

    @Deprecated
    public int getHeight() {
        return this.height;
    }

    @Deprecated
    public int getLayoutType() {
        return this.layoutType;
    }

    @Deprecated
    public int getWidth() {
        return this.width;
    }

    @Override // com.fl.saas.base.base.BaseBuilder, com.fl.saas.base.interfaces.AdViewListener
    @Deprecated
    public void onAdFailed(YdError ydError) {
        AdViewTemplateListener adViewTemplateListener = this.listener;
        if (adViewTemplateListener != null) {
            adViewTemplateListener.onAdFailed(ydError);
        }
    }

    @Deprecated
    public T setAdCount(int i) {
        this.adCount = i;
        return this.builder;
    }

    @Deprecated
    public T setHeight(int i) {
        this.height = i;
        return this.builder;
    }

    @Deprecated
    public T setLayoutType(int i) {
        this.layoutType = i;
        return this.builder;
    }

    @Deprecated
    public T setWidth(int i) {
        this.width = i;
        return this.builder;
    }
}
