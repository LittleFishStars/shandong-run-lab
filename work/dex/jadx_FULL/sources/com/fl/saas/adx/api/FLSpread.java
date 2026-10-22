package com.fl.saas.adx.api;

import android.content.Context;
import com.fl.saas.adx.base.annotation.API;
import com.fl.saas.adx.base.base.BaseAPI;
import com.fl.saas.adx.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.adx.base.bean.AdType;
import com.fl.saas.adx.base.interfaces.AdViewSpreadListener;
import com.fl.saas.adx.base.interfaces.SpreadLoadListener;
import com.fl.saas.adx.base.manager.AdViewSpreadManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@API(AdType.Spread)
public class FLSpread extends BaseAPI<InnerSpreadBuilder<?>, AdViewSpreadManager> {

    public static class Builder extends InnerSpreadBuilder.Builder<Builder, FLSpread> {
        /* JADX WARN: Multi-variable type inference failed */
        public Builder(Context context) {
            super(context);
            this.builder = this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.fl.saas.adx.base.base.Build
        public FLSpread build() {
            return new FLSpread((InnerSpreadBuilder) this.builder);
        }

        public Builder setSpreadListener(AdViewSpreadListener adViewSpreadListener) {
            this.listener = adViewSpreadListener;
            return this;
        }

        public Builder setSpreadLoadListener(SpreadLoadListener spreadLoadListener) {
            this.spreadLoadListener = spreadLoadListener;
            return this;
        }
    }

    public FLSpread(InnerSpreadBuilder<?> innerSpreadBuilder) {
        super(innerSpreadBuilder);
    }

    public void requestSpread() {
        request();
    }
}
