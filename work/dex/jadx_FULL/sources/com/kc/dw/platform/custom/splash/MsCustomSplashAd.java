package com.kc.dw.platform.custom.splash;

import android.view.ViewGroup;
import com.kc.dw.core.ad.splash.SplashAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCustomSplashAd extends SplashAd {
    private final MsCustomSplashAdapter splashAdLoader;

    public MsCustomSplashAd(MsCustomSplashAdapter msCustomSplashAdapter, String str) {
        super(msCustomSplashAdapter, str);
        this.splashAdLoader = msCustomSplashAdapter;
    }

    @Override // com.kc.dw.core.ad.a
    public HashMap<String, Object> getExtraMap() {
        MsCustomSplashAdapter msCustomSplashAdapter = this.splashAdLoader;
        if (msCustomSplashAdapter != null) {
            return msCustomSplashAdapter.getExtraMap();
        }
        return null;
    }

    @Override // com.kc.dw.core.ad.splash.SplashAd, com.kc.dw.core.ad.splash.ISplashAd
    public void render() {
        if (!isMSPlatform() || isAutoRender()) {
            return;
        }
        super.render();
        MsCustomSplashAdapter msCustomSplashAdapter = this.splashAdLoader;
        if (msCustomSplashAdapter != null) {
            msCustomSplashAdapter.render();
        }
    }

    @Override // com.kc.dw.core.ad.splash.SplashAd, com.kc.dw.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        super.showAd(viewGroup);
        MsCustomSplashAdapter msCustomSplashAdapter = this.splashAdLoader;
        if (msCustomSplashAdapter != null) {
            msCustomSplashAdapter.setAdShowStatus(true);
            this.splashAdLoader.showAd(viewGroup);
        }
    }
}
