package com.kc.dw.gather.ks.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class KSSplashAdapter extends MsCustomSplashAdapter {
    private static final String TAG = "KSSplashAdapter";
    private KsSplashScreenAd splashAd;

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(Long.parseLong(customInfo.getPid())).build(), new KsLoadManager.SplashScreenAdListener(this) { // from class: com.kc.dw.gather.ks.splash.KSSplashAdapter.2
            public final KSSplashAdapter this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onError(int i, String str) {
                LogUtil.d(KSSplashAdapter.TAG, "KS onError code=" + i + ",msg=" + str);
                this.this$0.callLoadedError(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onRequestResult(int i) {
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
                LogUtil.d(KSSplashAdapter.TAG, "KS onSplashScreenAdLoad");
                try {
                    int ecpm = ksSplashScreenAd.getECPM();
                    if (ecpm > 0) {
                        this.this$0.setEcpm(ecpm);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.this$0.splashAd = ksSplashScreenAd;
                this.this$0.callLoadedSuccess();
                this.this$0.callRenderSuccess();
            }
        });
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            KsSplashScreenAd ksSplashScreenAd = this.splashAd;
            if (ksSplashScreenAd != null) {
                if (z) {
                    ksSplashScreenAd.setBidEcpm(ksSplashScreenAd.getECPM(), s0.a(this.splashAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()));
                } else {
                    AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                    adExposureFailedReason.setAdnType(3);
                    adExposureFailedReason.setWinEcpm(i);
                    this.splashAd.reportAdExposureFailed(2, adExposureFailedReason);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void showAd(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                KsSplashScreenAd ksSplashScreenAd = this.splashAd;
                if (ksSplashScreenAd != null) {
                    View view = ksSplashScreenAd.getView(viewGroup.getContext(), new KsSplashScreenAd.SplashScreenAdInteractionListener(this) { // from class: com.kc.dw.gather.ks.splash.KSSplashAdapter.1
                        public final KSSplashAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                        public void onAdClicked() {
                            this.this$0.callAdClicked();
                        }

                        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                        public void onAdShowEnd() {
                            this.this$0.callAdClosed();
                        }

                        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                        public void onAdShowError(int i, String str) {
                            this.this$0.callRenderError(i, str);
                        }

                        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                        public void onAdShowStart() {
                            this.this$0.callAdExposure();
                        }

                        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                        public void onDownloadTipsDialogCancel() {
                        }

                        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                        public void onDownloadTipsDialogDismiss() {
                        }

                        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                        public void onDownloadTipsDialogShow() {
                        }

                        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                        public void onSkippedAd() {
                            this.this$0.callAdClosed();
                        }
                    });
                    if (view != null) {
                        viewGroup.removeAllViews();
                        viewGroup.addView(view, -1, -1);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                callRenderError(200002, "container is null");
                e.printStackTrace();
                return;
            }
        }
        callRenderError(200002, "container is null");
    }
}
