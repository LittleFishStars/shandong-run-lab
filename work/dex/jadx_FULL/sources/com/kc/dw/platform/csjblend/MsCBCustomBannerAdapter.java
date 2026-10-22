package com.kc.dw.platform.csjblend;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.banner.MediationCustomBannerLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.kc.dw.activity.a;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.banner.BannerAdEventLoader;
import com.kc.dw.core.ad.banner.BannerAdLoadListener;
import com.kc.dw.core.ad.banner.IBannerAd;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCBCustomBannerAdapter extends MediationCustomBannerLoader {
    private static final String TAG = "MsCBCustomBannerAdapter";
    private IBannerAd iBannerAd;
    private ViewGroup mBannerView;

    /* JADX INFO: renamed from: com.kc.dw.platform.csjblend.MsCBCustomBannerAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements BannerAdLoadListener {
        public final MsCBCustomBannerAdapter this$0;

        public AnonymousClass1(MsCBCustomBannerAdapter msCBCustomBannerAdapter) {
            this.this$0 = msCBCustomBannerAdapter;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(IBannerAd iBannerAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadFail(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(IBannerAd iBannerAd) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(IBannerAd iBannerAd) {
            double d;
            this.this$0.iBannerAd = iBannerAd;
            try {
                if (this.this$0.iBannerAd != null) {
                    this.this$0.iBannerAd.setInteractionListener(new InteractionListener(this) { // from class: com.kc.dw.platform.csjblend.MsCBCustomBannerAdapter.1.1
                        public final AnonymousClass1 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClicked() {
                            this.this$1.this$0.callBannerAdClick();
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClosed() {
                            this.this$1.this$0.callBannerAdClosed();
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdExposure() {
                            this.this$1.this$0.callBannerAdShow();
                        }
                    });
                    LogUtil.e(MsCBCustomBannerAdapter.TAG, "加载成功，onAdReady");
                    if (!this.this$0.isClientBidding()) {
                        this.this$0.callLoadSuccess();
                    } else if (this.this$0.iBannerAd.getData() != null) {
                        try {
                            d = Double.parseDouble(this.this$0.iBannerAd.getData().getEcpm());
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            d = AudioStats.AUDIO_AMPLITUDE_NONE;
                        }
                        this.this$0.callLoadSuccess(d);
                    } else {
                        d = AudioStats.AUDIO_AMPLITUDE_NONE;
                        this.this$0.callLoadSuccess(d);
                    }
                    this.this$0.iBannerAd.showAd(this.this$0.mBannerView);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void removeFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.banner.MediationCustomBannerLoader
    public View getAdView() {
        return this.mBannerView;
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        StringBuilder sbA = a.a("开始加载gromore自定义平台banner，pid=");
        sbA.append(mediationCustomServiceConfig.getADNNetworkSlotId());
        LogUtil.e(TAG, sbA.toString());
        try {
            if (context instanceof Activity) {
                BannerAdEventLoader bannerAdEventLoader = new BannerAdEventLoader((Activity) context, new SsdAdSlot.Builder().setPid(mediationCustomServiceConfig.getADNNetworkSlotId()).build(), new AnonymousClass1(this));
                this.mBannerView = new FrameLayout(context);
                bannerAdEventLoader.loadAd();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
