package com.kc.dw.platform.custom.banner;

import android.view.ViewGroup;
import com.kc.dw.core.ad.banner.BannerAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCustomBannerAd extends BannerAd {
    private final MsCustomBannerAdapter bannerLoader;

    public MsCustomBannerAd(MsCustomBannerAdapter msCustomBannerAdapter, String str) {
        super(msCustomBannerAdapter, str);
        this.bannerLoader = msCustomBannerAdapter;
    }

    @Override // com.kc.dw.core.ad.a
    public HashMap<String, Object> getExtraMap() {
        MsCustomBannerAdapter msCustomBannerAdapter = this.bannerLoader;
        if (msCustomBannerAdapter != null) {
            return msCustomBannerAdapter.getExtraMap();
        }
        return null;
    }

    @Override // com.kc.dw.core.ad.banner.BannerAd, com.kc.dw.core.ad.banner.IBannerAd
    public void render() {
        if (!isMSPlatform() || isAutoRender()) {
            return;
        }
        super.render();
        MsCustomBannerAdapter msCustomBannerAdapter = this.bannerLoader;
        if (msCustomBannerAdapter != null) {
            msCustomBannerAdapter.render();
        }
    }

    @Override // com.kc.dw.core.ad.banner.BannerAd, com.kc.dw.core.ad.banner.IBannerAd
    public void showAd(ViewGroup viewGroup) {
        super.showAd(viewGroup);
        MsCustomBannerAdapter msCustomBannerAdapter = this.bannerLoader;
        if (msCustomBannerAdapter != null) {
            msCustomBannerAdapter.setAdShowStatus(true);
            this.bannerLoader.showAd(viewGroup);
        }
    }
}
