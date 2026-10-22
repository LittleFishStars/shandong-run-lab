package com.ltmb.gromoreadapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import com.ltmb.ltsdk.core.load.splash.LTAdSplashEventListener;
import com.ltmb.ltsdk.core.load.splash.LTAdSplashLoadListener;
import com.ltmb.ltsdk.core.load.splash.LTSplashAd;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class LTGroMoreSplashLoader extends MediationCustomSplashLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LTSplashAd f40282a;
    public Context b;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$load$0(MediationCustomServiceConfig mediationCustomServiceConfig) {
        LTAdSdk.getInstance().getLTAdSplashLoader(new LTAdSlot.Builder().setAdId(mediationCustomServiceConfig.getADNNetworkSlotId()).setRequestAdSize(getWidth(), getHeight()).build(), new LTAdSplashLoadListener() { // from class: com.ltmb.gromoreadapter.LTGroMoreSplashLoader.1
            public void onAdLoadFailed(int i, String str) {
                LTGroMoreSplashLoader.this.callLoadFail(i, str);
            }

            public void onLoaded(LTSplashAd lTSplashAd) {
                LTGroMoreSplashLoader.this.f40282a = lTSplashAd;
                if (lTSplashAd != null) {
                    if (lTSplashAd.getEcpm() >= AudioStats.AUDIO_AMPLITUDE_NONE) {
                        LTGroMoreSplashLoader.this.callLoadSuccess(lTSplashAd.getEcpm());
                    } else {
                        LTGroMoreSplashLoader.this.callLoadSuccess();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$1(ViewGroup viewGroup) {
        LTSplashAd lTSplashAd = this.f40282a;
        if (lTSplashAd == null || viewGroup == null) {
            return;
        }
        lTSplashAd.setLTAdEventListener(new LTAdSplashEventListener() { // from class: com.ltmb.gromoreadapter.LTGroMoreSplashLoader.2
            public void onAdClicked() {
                LTGroMoreSplashLoader.this.callSplashAdClicked();
            }

            public void onAdRenderFail(int i, String str) {
            }

            public void onAdShow() {
                LTGroMoreSplashLoader.this.callSplashAdShow();
            }

            public void onAdSkip() {
                LTGroMoreSplashLoader.this.callSplashAdSkip();
            }

            public void onClosed() {
                LTGroMoreSplashLoader.this.callSplashAdDismiss();
            }
        });
        viewGroup.removeAllViews();
        this.f40282a.showAd(viewGroup);
    }

    public int getHeight() {
        return this.b.getResources().getDisplayMetrics().heightPixels;
    }

    public int getWidth() {
        return this.b.getResources().getDisplayMetrics().widthPixels;
    }

    public boolean isClientBidding() {
        LTSplashAd lTSplashAd = this.f40282a;
        return lTSplashAd != null && lTSplashAd.getEcpm() > AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        try {
            MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) ThreadUtils.runOnThreadPool(new Callable<MediationConstant.AdIsReadyStatus>() { // from class: com.ltmb.gromoreadapter.LTGroMoreSplashLoader.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public MediationConstant.AdIsReadyStatus call() {
                    return (LTGroMoreSplashLoader.this.f40282a == null || LTGroMoreSplashLoader.this.f40282a.isExpired() || LTGroMoreSplashLoader.this.f40282a.isDestroy()) ? MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY : MediationConstant.AdIsReadyStatus.AD_IS_READY;
                }
            }).get(100L, TimeUnit.MILLISECONDS);
            return adIsReadyStatus != null ? adIsReadyStatus : MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        } catch (Exception e) {
            e.printStackTrace();
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        }
    }

    public boolean isServerBidding() {
        LTSplashAd lTSplashAd = this.f40282a;
        return lTSplashAd != null && lTSplashAd.getEcpm() > AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, final MediationCustomServiceConfig mediationCustomServiceConfig) {
        this.b = context;
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.nv4
            @Override // java.lang.Runnable
            public final void run() {
                this.f18516a.lambda$load$0(mediationCustomServiceConfig);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader
    public void showAd(final ViewGroup viewGroup) {
        ThreadUtils.runOnUIThreadByThreadPool(new Runnable() { // from class: com.zj.adlib.ov4
            @Override // java.lang.Runnable
            public final void run() {
                this.f18732a.lambda$showAd$1(viewGroup);
            }
        });
    }
}
