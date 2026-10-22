package com.fl.saas.ydsdk;

import android.content.Context;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseAPI;
import com.fl.saas.base.base.builder.InnerFullVideoBuilder;
import com.fl.saas.base.interfaces.AdViewFullVideoListener;
import com.fl.saas.base.manager.AdViewFullVideoManager;
import com.fl.saas.base.type.AdType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@API(AdType.FullVideo)
public class YdFullVideo extends BaseAPI<InnerFullVideoBuilder<?>, AdViewFullVideoManager> {

    public static class Builder extends InnerFullVideoBuilder.Builder<Builder, YdFullVideo> {
        /* JADX WARN: Multi-variable type inference failed */
        public Builder(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.base.base.Build
        public YdFullVideo build() {
            return new YdFullVideo(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setVideoListener(AdViewFullVideoListener adViewFullVideoListener) {
            this.listener = adViewFullVideoListener;
            return (Builder) this.builder;
        }
    }

    public YdFullVideo(InnerFullVideoBuilder<?> innerFullVideoBuilder) {
        super(innerFullVideoBuilder);
    }

    public boolean isReady() {
        S s = this.manager;
        if (s != 0) {
            return ((AdViewFullVideoManager) s).isReady();
        }
        return false;
    }

    public void requestFullVideo() {
        request();
    }

    public void show() {
        S s = this.manager;
        if (s != 0) {
            ((AdViewFullVideoManager) s).show();
        }
    }
}
