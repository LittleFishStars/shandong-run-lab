package com.fl.saas.s2s.gromore;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem;
import com.fl.saas.base.interfaces.AdViewVideoCheckListener;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdVideo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLGromoreRewardVideoLoader extends MediationCustomRewardVideoLoader {
    private static final String TAG = CommConstant.getClassTag("FLGromore", FLGromoreRewardVideoLoader.class);
    private boolean hasBackDisplay = false;
    private boolean hasBackFail;
    private String mTransID;
    private YdVideo ydVideo;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0(Activity activity) {
        YdVideo ydVideo = this.ydVideo;
        if (ydVideo != null) {
            ydVideo.show(activity);
        }
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        YdVideo ydVideo = this.ydVideo;
        return (ydVideo == null || !ydVideo.isReady()) ? MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        String userID;
        String str;
        String aDNNetworkSlotId = mediationCustomServiceConfig.getADNNetworkSlotId();
        String userData = "";
        if (adSlot != null) {
            try {
                userID = adSlot.getUserID();
                try {
                    userData = adSlot.getUserData();
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
                userID = "";
            }
            str = userData;
            userData = userID;
        } else {
            str = "";
        }
        YdVideo.Builder mute = new YdVideo.Builder(context).setKey(aDNNetworkSlotId).setMute(false);
        if (!TextUtils.isEmpty(userData)) {
            mute.setUserId(userData).setCustomData(str).setAdViewVideoCheckListener(new AdViewVideoCheckListener() { // from class: com.fl.saas.s2s.gromore.FLGromoreRewardVideoLoader.1
                @Override // com.fl.saas.base.interfaces.AdViewVideoCheckListener
                public void onVideoCheckReward(String str2) {
                    FLGromoreRewardVideoLoader.this.mTransID = str2;
                }
            });
        }
        YdVideo ydVideoBuild = mute.setVideoListener(new AdViewVideoListener() { // from class: com.fl.saas.s2s.gromore.FLGromoreRewardVideoLoader.2
            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdClick(String str2) {
                LogcatUtil.d(FLGromoreRewardVideoLoader.TAG, "onAdClick");
                FLGromoreRewardVideoLoader.this.callRewardVideoAdClick();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdClose() {
                LogcatUtil.d(FLGromoreRewardVideoLoader.TAG, "onAdClose");
                FLGromoreRewardVideoLoader.this.callRewardVideoAdClosed();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d(FLGromoreRewardVideoLoader.TAG, "onAdFailed:" + ydError);
                if (FLGromoreRewardVideoLoader.this.hasBackFail) {
                    return;
                }
                FLGromoreRewardVideoLoader.this.hasBackFail = true;
                FLGromoreRewardVideoLoader.this.callLoadFail(ydError.getCode(), ydError.getMsg());
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdShow() {
                LogcatUtil.d(FLGromoreRewardVideoLoader.TAG, "onAdShow");
                if (FLGromoreRewardVideoLoader.this.hasBackDisplay) {
                    return;
                }
                FLGromoreRewardVideoLoader.this.hasBackDisplay = true;
                FLGromoreRewardVideoLoader.this.callRewardVideoAdShow();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onSkipVideo() {
                LogcatUtil.d(FLGromoreRewardVideoLoader.TAG, "onSkipVideo");
                FLGromoreRewardVideoLoader.this.callRewardVideoSkippedVideo();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoCompleted() {
                LogcatUtil.d(FLGromoreRewardVideoLoader.TAG, "onVideoCompleted");
                FLGromoreRewardVideoLoader.this.callRewardVideoComplete();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoPrepared() {
                LogcatUtil.d(FLGromoreRewardVideoLoader.TAG, "onVideoPrepared");
                if (FLGromoreRewardVideoLoader.this.isClientBidding()) {
                    double ecpm = FLGromoreRewardVideoLoader.this.ydVideo.getECPM();
                    if (ecpm < AudioStats.AUDIO_AMPLITUDE_NONE) {
                        ecpm = 0.0d;
                    }
                    FLGromoreRewardVideoLoader.this.callLoadSuccess(ecpm);
                } else {
                    FLGromoreRewardVideoLoader.this.callLoadSuccess();
                }
                FLGromoreRewardVideoLoader.this.callAdVideoCache();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoReward(double d) {
                LogcatUtil.d(FLGromoreRewardVideoLoader.TAG, "onVideoReward");
                FLGromoreRewardVideoLoader.this.callRewardVideoRewardVerify(new MediationRewardItem() { // from class: com.fl.saas.s2s.gromore.FLGromoreRewardVideoLoader.2.1
                    @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                    public float getAmount() {
                        return 0.0f;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                    public Map<String, Object> getCustomData() {
                        if (TextUtils.isEmpty(FLGromoreRewardVideoLoader.this.mTransID)) {
                            return null;
                        }
                        HashMap map = new HashMap();
                        map.put("transID", FLGromoreRewardVideoLoader.this.mTransID);
                        return map;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                    public String getRewardName() {
                        return "";
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                    public boolean rewardVerify() {
                        return true;
                    }
                });
            }
        }).build();
        this.ydVideo = ydVideoBuild;
        ydVideoBuild.requestRewardVideo();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onDestroy() {
        YdVideo ydVideo = this.ydVideo;
        if (ydVideo != null) {
            ydVideo.destroy();
            this.ydVideo = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
        super.receiveBidResult(z, d, i, map);
        try {
            YdVideo ydVideo = this.ydVideo;
            if (ydVideo != null) {
                ydVideo.biddingResultUpload(z, (int) d, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader
    public void showAd(final Activity activity) {
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.mc3
            @Override // java.lang.Runnable
            public final void run() {
                this.f18176a.lambda$showAd$0(activity);
            }
        });
    }
}
