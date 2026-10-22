package com.fl.saas.base.base.builder;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.base.Build;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.base.interfaces.AdViewNativeListener;
import com.fl.saas.base.type.AdType;
import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Deprecated
public abstract class InnerNativeBuilder<T> extends BaseBuilder<T> implements AdEventListener<AdViewNativeListener> {
    private int adCount;
    private int height;
    private boolean isManualReport;
    private boolean isStreamAd;
    protected AdViewNativeListener listener;
    private int maxTimeoutSeconds;
    private boolean showLogo;
    private boolean soundEnable;
    private int width;

    @Deprecated
    public static abstract class Builder<T, S> extends InnerNativeBuilder<T> implements Build<S> {
        @Deprecated
        public Builder(Context context) {
            super(context);
        }

        @Override // com.fl.saas.base.base.builder.InnerNativeBuilder, com.fl.saas.base.base.builder.AdEventListener
        @Deprecated
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    @Deprecated
    @API(AdType.Native)
    public static class Default extends InnerNativeBuilder<Default> {
        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated
        public Default(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.base.base.builder.InnerNativeBuilder, com.fl.saas.base.base.builder.AdEventListener
        @Deprecated
        public /* bridge */ /* synthetic */ AdViewListener getEventListener() {
            return super.getEventListener();
        }
    }

    @Deprecated
    public InnerNativeBuilder(Context context) {
        super(context);
        this.adCount = 1;
        this.soundEnable = true;
    }

    @Deprecated
    public int getAdCount() {
        return this.adCount;
    }

    @Override // com.fl.saas.base.base.builder.AdEventListener
    @Deprecated
    public AdViewNativeListener getEventListener() {
        return this.listener;
    }

    @Deprecated
    public int getHeight() {
        int i = this.height;
        return i == 0 ? MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT : i;
    }

    @Deprecated
    public int getMaxTimeoutSeconds() {
        return this.maxTimeoutSeconds;
    }

    @Deprecated
    public int getWidth() {
        int i = this.width;
        if (i == 0) {
            return 690;
        }
        return i;
    }

    @Deprecated
    public boolean isManualReport() {
        return this.isManualReport;
    }

    @Deprecated
    public boolean isShowLogo() {
        return this.showLogo;
    }

    @Deprecated
    public boolean isSoundEnable() {
        return this.soundEnable;
    }

    @Deprecated
    public boolean isStreamAd() {
        return this.isStreamAd;
    }

    @Override // com.fl.saas.base.base.BaseBuilder, com.fl.saas.base.interfaces.AdViewListener
    @Deprecated
    public void onAdFailed(YdError ydError) {
        AdViewNativeListener adViewNativeListener = this.listener;
        if (adViewNativeListener != null) {
            adViewNativeListener.onAdFailed(ydError);
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
    public T setManualReport(boolean z) {
        this.isManualReport = z;
        return this.builder;
    }

    @Deprecated
    public T setMaxTimeoutSeconds(int i) {
        this.maxTimeoutSeconds = i;
        return this.builder;
    }

    @Deprecated
    public T setSoundEnable(boolean z) {
        this.soundEnable = z;
        return this.builder;
    }

    @Deprecated
    public T setTTStreamAd(boolean z) {
        this.isStreamAd = z;
        return this.builder;
    }

    @Deprecated
    public T setWidth(int i) {
        this.width = i;
        return this.builder;
    }

    @Deprecated
    public T showLogo(boolean z) {
        this.showLogo = z;
        return this.builder;
    }
}
