package com.fl.saas.adx.api;

import android.app.Activity;
import android.content.Context;
import com.fl.saas.adx.base.annotation.API;
import com.fl.saas.adx.base.base.BaseAPI;
import com.fl.saas.adx.base.base.builder.InnerInterstitialBuilder;
import com.fl.saas.adx.base.bean.AdType;
import com.fl.saas.adx.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.adx.base.manager.AdViewInterstitialManager;
import com.fl.saas.adx.util.LogcatUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@API(AdType.Interstitial)
public class FLInterstitial extends BaseAPI<InnerInterstitialBuilder<?>, AdViewInterstitialManager> {
    private boolean hasShow;

    public static class Builder extends InnerInterstitialBuilder.Builder<Builder, FLInterstitial> {
        /* JADX WARN: Multi-variable type inference failed */
        public Builder(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.adx.base.base.Build
        public FLInterstitial build() {
            return new FLInterstitial(this);
        }

        public Builder setInterstitialListener(AdViewInterstitialListener adViewInterstitialListener) {
            this.listener = adViewInterstitialListener;
            return this;
        }
    }

    public FLInterstitial(InnerInterstitialBuilder<?> innerInterstitialBuilder) {
        super(innerInterstitialBuilder);
        this.hasShow = false;
    }

    public boolean isReady() {
        S s = this.manager;
        if (s != 0) {
            return ((AdViewInterstitialManager) s).isReady();
        }
        return false;
    }

    public void requestInterstitial() {
        request();
    }

    @Deprecated
    public void show() {
        show(null);
    }

    public void show(Activity activity) {
        LogcatUtil.d("FLSDK--hasShow：" + this.hasShow + "--activity：" + activity);
        if (this.hasShow) {
            return;
        }
        this.hasShow = true;
        S s = this.manager;
        if (s != 0) {
            ((AdViewInterstitialManager) s).show(activity);
        }
    }
}
