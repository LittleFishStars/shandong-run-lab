package com.kc.dw.gather.ks.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.banner.MsCustomBannerAdapter;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class KSBannerAdapter extends MsCustomBannerAdapter {
    private static final String TAG = "KSBannerAdapter";
    private KsBannerAd ksBannerAd;

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void destory() {
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        try {
            KsAdSDK.getLoadManager().loadBannerAd(new KsScene.Builder(Long.parseLong(this.sdkAdInfo.getPid())).build(), new KsLoadManager.BannerAdListener(this) { // from class: com.kc.dw.gather.ks.banner.KSBannerAdapter.2
                public final KSBannerAdapter this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
                public void onBannerAdLoad(KsBannerAd ksBannerAd) {
                    this.this$0.ksBannerAd = ksBannerAd;
                    try {
                        try {
                            this.this$0.setEcpm(ksBannerAd.getECPM());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.this$0.callLoadedSuccess();
                        this.this$0.callRenderSuccess();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
                public void onError(int i, String str) {
                    this.this$0.callLoadedError(i, str);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void showAd(ViewGroup viewGroup) {
        if (this.ksBannerAd != null) {
            View view = this.ksBannerAd.getView(this.context, new KsBannerAd.BannerAdInteractionListener(this) { // from class: com.kc.dw.gather.ks.banner.KSBannerAdapter.1
                public final KSBannerAdapter this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
                public void onAdClicked() {
                    this.this$0.callAdClicked();
                }

                @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
                public void onAdClose() {
                    this.this$0.callAdClosed();
                }

                @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
                public void onAdShow() {
                    this.this$0.callAdExposure();
                }

                @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
                public void onAdShowError(int i, String str) {
                    this.this$0.callRenderError(i, str);
                }
            }, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build());
            if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -2));
            }
        }
    }
}
