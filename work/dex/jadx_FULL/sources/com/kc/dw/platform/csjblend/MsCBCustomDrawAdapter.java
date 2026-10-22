package com.kc.dw.platform.csjblend;

import android.content.Context;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.draw.MediationCustomDrawLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.kc.dw.activity.a;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.draw.DrawAdEventLoader;
import com.kc.dw.core.ad.draw.DrawAdLoadListener;
import com.kc.dw.core.ad.draw.IDrawAd;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCBCustomDrawAdapter extends MediationCustomDrawLoader {
    private static final String TAG = "MsCBCCustomDrawAdapter";
    private MsCBDrawAd msgmDrawAd;

    /* JADX INFO: renamed from: com.kc.dw.platform.csjblend.MsCBCustomDrawAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements DrawAdLoadListener {
        public final MsCBCustomDrawAdapter this$0;

        public AnonymousClass1(MsCBCustomDrawAdapter msCBCustomDrawAdapter) {
            this.this$0 = msCBCustomDrawAdapter;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(IDrawAd iDrawAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadFail(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(IDrawAd iDrawAd) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(IDrawAd iDrawAd) {
            double d;
            if (iDrawAd != null) {
                iDrawAd.setInteractionListener(new InteractionListener(this) { // from class: com.kc.dw.platform.csjblend.MsCBCustomDrawAdapter.1.1
                    public final AnonymousClass1 this$1;

                    {
                        this.this$1 = this;
                    }

                    @Override // com.kc.dw.core.loader.InteractionListener
                    public void onAdClicked() {
                        if (this.this$1.this$0.msgmDrawAd != null) {
                            this.this$1.this$0.msgmDrawAd.callAdClick();
                        }
                    }

                    @Override // com.kc.dw.core.loader.InteractionListener
                    public void onAdClosed() {
                    }

                    @Override // com.kc.dw.core.loader.InteractionListener
                    public void onAdExposure() {
                        if (this.this$1.this$0.msgmDrawAd != null) {
                            this.this$1.this$0.msgmDrawAd.callAdShow();
                        }
                    }
                });
                this.this$0.msgmDrawAd = new MsCBDrawAd(iDrawAd);
                if (this.this$0.isClientBidding()) {
                    if (iDrawAd.getData() != null) {
                        try {
                            d = Double.parseDouble(iDrawAd.getData().getEcpm());
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            d = AudioStats.AUDIO_AMPLITUDE_NONE;
                        }
                    } else {
                        d = AudioStats.AUDIO_AMPLITUDE_NONE;
                    }
                    this.this$0.msgmDrawAd.setBiddingPrice(d);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.this$0.msgmDrawAd);
                this.this$0.callLoadSuccess(arrayList);
            }
        }
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        StringBuilder sbA = a.a("开始加载gromore自定义平台draw，pid=");
        sbA.append(mediationCustomServiceConfig.getADNNetworkSlotId());
        LogUtil.e(TAG, sbA.toString());
        try {
            new DrawAdEventLoader(context, new SsdAdSlot.Builder().setPid(mediationCustomServiceConfig.getADNNetworkSlotId()).build(), new AnonymousClass1(this)).loadAd();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
