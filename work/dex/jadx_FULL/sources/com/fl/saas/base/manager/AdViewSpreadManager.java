package com.fl.saas.base.manager;

import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.adapter.AdViewSpreadAdapter;
import com.fl.saas.base.adapter.AdViewVideoAdapter;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.zj.adlib.zy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdViewSpreadManager extends BuilderLoadManager<InnerSpreadBuilder<?>, AdViewSpreadAdapter, AdViewSpreadListener> {

    /* JADX INFO: renamed from: com.fl.saas.base.manager.AdViewSpreadManager$1, reason: invalid class name */
    public class AnonymousClass1 implements AdViewSpreadListener {
        final /* synthetic */ InnerSpreadBuilder val$builder;

        public AnonymousClass1(InnerSpreadBuilder innerSpreadBuilder) {
            this.val$builder = innerSpreadBuilder;
        }

        public Optional<AdViewSpreadListener> getSpreadListenerOpt() {
            return Optional.ofNullable(this.val$builder.getEventListener());
        }

        @Override // com.fl.saas.base.base.listener.InnerSpreadListener
        public void onAdClick(final String str) {
            LogcatUtil.d("YdSDK-Spread", "adViewAdInterface onAdClick");
            getSpreadListenerOpt().ifPresent(new Consumer() { // from class: com.fl.saas.base.manager.b
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    ((AdViewSpreadListener) obj).onAdClick(str);
                }
            });
        }

        @Override // com.fl.saas.base.base.listener.InnerSpreadListener
        public void onAdClose() {
            LogcatUtil.d("YdSDK-Spread", "adViewAdInterface onAdClose");
            getSpreadListenerOpt().ifPresent(new zy());
        }

        @Override // com.fl.saas.base.base.listener.InnerSpreadListener
        public void onAdDisplay() {
            LogcatUtil.d("YdSDK-Spread", "adViewAdInterface onAdDisplay");
            getSpreadListenerOpt().ifPresent(new Consumer() { // from class: com.zj.adlib.bz
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    ((AdViewSpreadListener) obj).onAdDisplay();
                }
            });
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(final YdError ydError) {
            LogcatUtil.d("YdSDK-Spread", "adViewAdInterface onAdFailed," + ydError.toString());
            getSpreadListenerOpt().ifPresent(new Consumer() { // from class: com.fl.saas.base.manager.a
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    ((AdViewSpreadListener) obj).onAdFailed(ydError);
                }
            });
        }
    }

    public AdViewSpreadManager() {
        super(AdType.Spread);
    }

    public void getBottomAd() {
        selectBottomAd();
    }

    @Deprecated
    public SpreadLoadListener.SpreadAd getSplashAd() {
        AdapterAPI showAdapter = getShowAdapter();
        if (showAdapter instanceof AdViewSpreadAdapter) {
            return ((AdViewSpreadAdapter) showAdapter).loadSpreadAd();
        }
        return null;
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewSpreadListener initProxyEventListener(InnerSpreadBuilder<?> innerSpreadBuilder) {
        return new AnonymousClass1(innerSpreadBuilder);
    }

    public void setSoundEnable(boolean z) {
        AdapterAPI showAdapter = getShowAdapter();
        if (showAdapter instanceof AdViewVideoAdapter) {
        } else if (showAdapter instanceof AdViewInterstitialAdapter) {
        } else if (showAdapter instanceof AdViewSpreadAdapter) {
            ((AdViewSpreadAdapter) showAdapter).setSoundEnable(z);
        }
    }
}
