package com.fl.saas.adx.api;

import android.app.Activity;
import android.content.Context;
import com.fl.saas.adx.base.annotation.API;
import com.fl.saas.adx.base.base.BaseAPI;
import com.fl.saas.adx.base.base.builder.InnerVideoBuilder;
import com.fl.saas.adx.base.bean.AdType;
import com.fl.saas.adx.base.interfaces.AdViewVideoCheckListener;
import com.fl.saas.adx.base.interfaces.AdViewVideoListener;
import com.fl.saas.adx.base.manager.AdViewVideoManager;
import com.fl.saas.adx.util.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@API(AdType.RewardVideo)
public class FLVideo extends BaseAPI<InnerVideoBuilder<?>, AdViewVideoManager> {

    public static class Builder extends InnerVideoBuilder.Builder<Builder, FLVideo> {
        /* JADX WARN: Multi-variable type inference failed */
        public Builder(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.adx.base.base.Build
        public FLVideo build() {
            return new FLVideo(this);
        }

        public Builder setAdViewVideoCheckListener(AdViewVideoCheckListener adViewVideoCheckListener) {
            this.checkListener = adViewVideoCheckListener;
            return this;
        }

        public Builder setVideoListener(AdViewVideoListener adViewVideoListener) {
            this.listener = adViewVideoListener;
            return this;
        }
    }

    public FLVideo(InnerVideoBuilder<?> innerVideoBuilder) {
        super(innerVideoBuilder);
    }

    public boolean isReady() {
        S s = this.manager;
        if (s != 0) {
            return ((AdViewVideoManager) s).isReady();
        }
        return false;
    }

    public void requestRewardVideo() {
        request();
    }

    @Deprecated
    public void show() {
        S s = this.manager;
        if (s != 0) {
            ((AdViewVideoManager) s).show();
        }
    }

    public void show(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            activity = DeviceUtil.getTopActivity();
        }
        S s = this.manager;
        if (s != 0) {
            ((AdViewVideoManager) s).show(activity);
        }
    }
}
