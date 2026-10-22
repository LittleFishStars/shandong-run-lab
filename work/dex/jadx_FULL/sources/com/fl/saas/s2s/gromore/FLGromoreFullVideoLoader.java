package com.fl.saas.s2s.gromore;

import android.app.Activity;
import android.content.Context;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.fullvideo.MediationCustomFullVideoLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.fl.saas.base.interfaces.AdViewFullVideoListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdFullVideo;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLGromoreFullVideoLoader extends MediationCustomFullVideoLoader {
    private static final String TAG = CommConstant.getClassTag("FLGromore", FLGromoreFullVideoLoader.class);
    private YdFullVideo ydFullVideo;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0() {
        YdFullVideo ydFullVideo = this.ydFullVideo;
        if (ydFullVideo != null) {
            ydFullVideo.show();
        }
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.fullvideo.MediationCustomFullVideoLoader
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        YdFullVideo ydFullVideo = this.ydFullVideo;
        return (ydFullVideo == null || !ydFullVideo.isReady()) ? MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        YdFullVideo ydFullVideoBuild = new YdFullVideo.Builder(context).setKey(mediationCustomServiceConfig.getADNNetworkSlotId()).setMute(false).setVideoListener(new AdViewFullVideoListener() { // from class: com.fl.saas.s2s.gromore.FLGromoreFullVideoLoader.1
            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onAdClicked() {
                LogcatUtil.d(FLGromoreFullVideoLoader.TAG, "onAdClicked");
                FLGromoreFullVideoLoader.this.callFullVideoAdClick();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d(FLGromoreFullVideoLoader.TAG, "onAdFailed:" + ydError);
                FLGromoreFullVideoLoader.this.callLoadFail(ydError.getCode(), ydError.getMsg());
            }

            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onPageDismiss() {
                LogcatUtil.d(FLGromoreFullVideoLoader.TAG, "onPageDismiss");
                FLGromoreFullVideoLoader.this.callFullVideoAdClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onVideoPlayStart() {
                LogcatUtil.d(FLGromoreFullVideoLoader.TAG, "onVideoPlayStart");
            }

            @Override // com.fl.saas.base.base.listener.InnerFullVideoListener
            public void onVideoPrepared() {
                LogcatUtil.d(FLGromoreFullVideoLoader.TAG, "onVideoPrepared");
                if (FLGromoreFullVideoLoader.this.isClientBidding()) {
                    double ecpm = FLGromoreFullVideoLoader.this.ydFullVideo.getECPM();
                    if (ecpm < AudioStats.AUDIO_AMPLITUDE_NONE) {
                        ecpm = 0.0d;
                    }
                    FLGromoreFullVideoLoader.this.callLoadSuccess(ecpm);
                } else {
                    FLGromoreFullVideoLoader.this.callLoadSuccess();
                }
                FLGromoreFullVideoLoader.this.callAdVideoCache();
            }
        }).build();
        this.ydFullVideo = ydFullVideoBuild;
        ydFullVideoBuild.requestFullVideo();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onDestroy() {
        YdFullVideo ydFullVideo = this.ydFullVideo;
        if (ydFullVideo != null) {
            ydFullVideo.destroy();
            this.ydFullVideo = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
        super.receiveBidResult(z, d, i, map);
        try {
            YdFullVideo ydFullVideo = this.ydFullVideo;
            if (ydFullVideo != null) {
                ydFullVideo.biddingResultUpload(z, (int) d, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.fullvideo.MediationCustomFullVideoLoader
    public void showAd(Activity activity) {
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.kc3
            @Override // java.lang.Runnable
            public final void run() {
                this.f42786a.lambda$showAd$0();
            }
        });
    }
}
