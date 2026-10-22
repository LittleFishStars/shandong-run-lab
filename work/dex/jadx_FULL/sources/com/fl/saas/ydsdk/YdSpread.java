package com.fl.saas.ydsdk;

import android.content.Context;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseAPI;
import com.fl.saas.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.SpreadLoadEventListener;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.base.manager.AdViewSpreadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@API(AdType.Spread)
public class YdSpread extends BaseAPI<InnerSpreadBuilder<?>, AdViewSpreadManager> {

    public static class Builder extends InnerSpreadBuilder.Builder<Builder, YdSpread> {
        /* JADX WARN: Multi-variable type inference failed */
        public Builder(Context context) {
            super(context);
            this.builder = this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.fl.saas.base.base.Build
        public YdSpread build() {
            return new YdSpread((InnerSpreadBuilder) this.builder);
        }

        public Builder setSpreadListener(AdViewSpreadListener adViewSpreadListener) {
            this.listener = adViewSpreadListener;
            return this;
        }

        public Builder setSpreadLoadEventListener(SpreadLoadEventListener spreadLoadEventListener) {
            this.spreadLoadListener = spreadLoadEventListener;
            return this;
        }

        public Builder setSpreadLoadListener(SpreadLoadListener spreadLoadListener) {
            this.spreadLoadListener = spreadLoadListener;
            return this;
        }
    }

    public YdSpread(InnerSpreadBuilder<?> innerSpreadBuilder) {
        super(innerSpreadBuilder);
    }

    public void getBottomAd() {
        S s = this.manager;
        if (s != 0) {
            ((AdViewSpreadManager) s).getBottomAd();
            return;
        }
        T t = this.builder;
        if (!(t instanceof Builder) || ((InnerSpreadBuilder) t).getEventListener() == null) {
            return;
        }
        ((InnerSpreadBuilder) this.builder).getEventListener().onAdFailed(new YdError("load splash is null"));
    }

    @Deprecated
    public SpreadLoadListener.SpreadAd getSplashAd() {
        S s = this.manager;
        if (s != 0) {
            return ((AdViewSpreadManager) s).getSplashAd();
        }
        return null;
    }

    public void requestSpread() {
        request();
    }

    public void setListener(SpreadLoadListener spreadLoadListener, AdViewSpreadListener adViewSpreadListener) {
        T t = this.builder;
        if (t instanceof Builder) {
            ((Builder) t).setSpreadListener(adViewSpreadListener);
            ((Builder) this.builder).setSpreadLoadListener(spreadLoadListener);
        }
    }

    public void setSoundEnable(boolean z) {
        S s = this.manager;
        if (s != 0) {
            ((AdViewSpreadManager) s).setSoundEnable(z);
        }
    }

    public void setSpreadListener(AdViewSpreadListener adViewSpreadListener) {
        T t = this.builder;
        if (t instanceof Builder) {
            ((Builder) t).setSpreadListener(adViewSpreadListener);
        }
    }
}
