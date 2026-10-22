package com.kc.dw.gather.huawei.banner;

import android.content.Context;
import android.view.ViewGroup;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.banner.BannerView;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.banner.BannerCommonAdLoader;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.banner.MsCustomBannerAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HWBannerAdapter extends MsCustomBannerAdapter {
    private BannerView bannerView;

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void destory() {
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        BannerView bannerView = new BannerView(((BannerCommonAdLoader) this.adLoader).getContext());
        this.bannerView = bannerView;
        bannerView.setAdId(getSdkAdInfo().getPid());
        this.bannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_360_57);
        this.bannerView.setBannerRefresh(0L);
        AdParam adParamBuild = new AdParam.Builder().build();
        this.bannerView.setAdListener(new AdListener(this) { // from class: com.kc.dw.gather.huawei.banner.HWBannerAdapter.1
            public final HWBannerAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onAdClicked() {
                this.this$0.callAdClicked();
            }

            public void onAdClosed() {
                this.this$0.callAdClosed();
            }

            public void onAdFailed(int i) {
                this.this$0.callLoadedError(i, "load err");
            }

            public void onAdImpression() {
                this.this$0.callAdExposure();
            }

            public void onAdLeave() {
            }

            public void onAdLoaded() {
                this.this$0.callLoadedSuccess();
            }

            public void onAdOpened() {
            }
        });
        this.bannerView.loadAd(adParamBuild);
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void showAd(ViewGroup viewGroup) {
        BannerView bannerView = this.bannerView;
        if (bannerView == null) {
            return;
        }
        if (bannerView.getParent() != null && (this.bannerView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.bannerView.getParent()).removeView(this.bannerView);
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(this.bannerView);
        }
    }
}
