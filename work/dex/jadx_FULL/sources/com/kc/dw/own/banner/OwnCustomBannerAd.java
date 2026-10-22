package com.kc.dw.own.banner;

import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.platform.ad_adapter.banner.a;
import com.kc.dw.platform.custom.banner.MsCustomBannerAd;
import com.kc.dw.platform.custom.banner.MsCustomBannerAdapter;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnCustomBannerAd extends MsCustomBannerAd {
    private a bannerAd;

    public OwnCustomBannerAd(MsCustomBannerAdapter msCustomBannerAdapter, String str, a aVar) {
        super(msCustomBannerAdapter, str);
        this.bannerAd = aVar;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        a aVar = this.bannerAd;
        return aVar != null ? aVar.getData() : super.getData();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        a aVar = this.bannerAd;
        if (aVar != null) {
            return aVar.isAdValid();
        }
        return true;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        a aVar = this.bannerAd;
        if (aVar != null) {
            com.kc.dw.core.s2s.a.a(aVar.getContext(), aVar.b.getLossUrl(), map);
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        a aVar = this.bannerAd;
        if (aVar != null) {
            com.kc.dw.core.s2s.a.b(aVar.getContext(), aVar.b.getWinUrl(), map);
        }
    }

    @Override // com.kc.dw.core.ad.banner.BannerAd, com.kc.dw.core.ad.banner.IBannerAd
    public void setCloseButtonVisible(boolean z) {
        try {
            a aVar = this.bannerAd;
            if (aVar != null) {
                aVar.adView.findViewById(R.id.ms_banner_close_button).setVisibility(z ? 0 : 4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.ad.banner.BannerAd, com.kc.dw.core.ad.banner.IBannerAd
    public void setWidthAndHeight(int i, int i2) {
        try {
            a aVar = this.bannerAd;
            if (aVar != null) {
                aVar.setWidthAndHeight(i, i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
