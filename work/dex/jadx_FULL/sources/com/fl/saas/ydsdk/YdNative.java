package com.fl.saas.ydsdk;

import android.content.Context;
import com.fl.saas.base.annotation.API;
import com.fl.saas.base.base.BaseAPI;
import com.fl.saas.base.base.builder.InnerNativeBuilder;
import com.fl.saas.base.interfaces.AdViewNativeListener;
import com.fl.saas.base.manager.AdViewNativeManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.feature.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@API(AdType.Native)
@Deprecated
public class YdNative extends BaseAPI<InnerNativeBuilder<?>, AdViewNativeManager> {

    @Deprecated
    public static class Builder extends InnerNativeBuilder.Builder<Builder, YdNative> {
        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated
        public Builder(Context context) {
            super(context);
            this.builder = this;
        }

        @Override // com.fl.saas.base.base.Build
        @Deprecated
        public YdNative build() {
            return new YdNative(this);
        }

        @Deprecated
        public Builder setNativeListener(AdViewNativeListener adViewNativeListener) {
            this.listener = adViewNativeListener;
            return this;
        }
    }

    @Deprecated
    public YdNative(InnerNativeBuilder<?> innerNativeBuilder) {
        super(innerNativeBuilder);
    }

    @Deprecated
    public List<YdNativePojo> getBottomAd() {
        S s = this.manager;
        if (s != 0) {
            return ((AdViewNativeManager) s).getBottomAd();
        }
        return null;
    }

    @Deprecated
    public void pauseVideo() {
        Check.checkNull((AdViewNativeManager) this.manager, (Consumer<AdViewNativeManager>) new Consumer() { // from class: com.zj.adlib.v7a
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeManager) obj).pauseVideo();
            }
        });
    }

    @Deprecated
    public void requestNative() {
        request();
    }

    @Deprecated
    public void resume() {
        Check.checkNull((AdViewNativeManager) this.manager, (Consumer<AdViewNativeManager>) new Consumer() { // from class: com.zj.adlib.u7a
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeManager) obj).resume();
            }
        });
    }

    @Deprecated
    public void resumeVideo() {
        Check.checkNull((AdViewNativeManager) this.manager, (Consumer<AdViewNativeManager>) new Consumer() { // from class: com.zj.adlib.x7a
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeManager) obj).resumeVideo();
            }
        });
    }

    @Deprecated
    public void setSoundEnable(final boolean z) {
        Check.checkNull((AdViewNativeManager) this.manager, (Consumer<AdViewNativeManager>) new Consumer() { // from class: com.zj.adlib.y7a
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeManager) obj).setSoundEnable(z);
            }
        });
    }

    @Deprecated
    public void startVideo() {
        Check.checkNull((AdViewNativeManager) this.manager, (Consumer<AdViewNativeManager>) new Consumer() { // from class: com.zj.adlib.w7a
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeManager) obj).startVideo();
            }
        });
    }

    @Deprecated
    public void stopVideo() {
        Check.checkNull((AdViewNativeManager) this.manager, (Consumer<AdViewNativeManager>) new Consumer() { // from class: com.zj.adlib.t7a
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewNativeManager) obj).stopVideo();
            }
        });
    }
}
