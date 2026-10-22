package com.fl.saas.ydsdk;

import android.app.Activity;
import android.content.Context;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseAPI;
import com.fl.saas.base.base.builder.InnerVideoBuilder;
import com.fl.saas.base.interfaces.AdViewVideoCheckListener;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.base.manager.AdViewVideoManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.config.utils.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@API(AdType.RewardVideo)
public class YdVideo extends BaseAPI<InnerVideoBuilder<?>, AdViewVideoManager> {

    public static class Builder extends InnerVideoBuilder.Builder<Builder, YdVideo> {
        /* JADX WARN: Multi-variable type inference failed */
        public Builder(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.base.base.Build
        public YdVideo build() {
            return new YdVideo(this);
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

    public YdVideo(InnerVideoBuilder<?> innerVideoBuilder) {
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
