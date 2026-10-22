package com.fl.saas.adx.api;

import android.content.Context;
import com.fl.saas.adx.base.annotation.API;
import com.fl.saas.adx.base.base.BaseAPI;
import com.fl.saas.adx.base.base.builder.InnerBannerBuilder;
import com.fl.saas.adx.base.bean.AdType;
import com.fl.saas.adx.base.interfaces.AdViewBannerListener;
import com.fl.saas.adx.base.manager.AdViewBannerManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@API(AdType.Banner)
public class FLBanner extends BaseAPI<InnerBannerBuilder<?>, AdViewBannerManager> {

    public static final class Builder extends InnerBannerBuilder.Builder<Builder, FLBanner> {
        /* JADX WARN: Multi-variable type inference failed */
        public Builder(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.adx.base.base.Build
        public FLBanner build() {
            return new FLBanner(this);
        }

        public Builder setBannerListener(AdViewBannerListener adViewBannerListener) {
            this.listener = adViewBannerListener;
            return this;
        }
    }

    public FLBanner(InnerBannerBuilder<?> innerBannerBuilder) {
        super(innerBannerBuilder);
    }

    public boolean isReady() {
        S s = this.manager;
        if (s != 0) {
            return ((AdViewBannerManager) s).isReady();
        }
        return false;
    }

    public void requestBanner() {
        request();
    }
}
