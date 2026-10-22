package com.fl.saas.s2s.topon;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.fl.saas.base.interfaces.AdViewVideoCheckListener;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdVideo;
import com.igexin.assist.sdk.AssistPushConsts;
import com.kc.aw.lib.constants.PtgRewardConstant;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLTopOnRewardVideoAdapter extends CustomRewardVideoAdapter implements ATBiddingNotice {
    private static final String TAG = CommConstant.getClassTag("FL", FLTopOnRewardVideoAdapter.class);
    private String extra;
    private long loadSuccessTime;
    private Context mContext;
    private String slotId;
    private String userId;
    private YdVideo ydVideo;

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad(final ATBiddingListener aTBiddingListener) {
        LogcatUtil.d(TAG, "startLoad");
        YdVideo.Builder mute = new YdVideo.Builder(this.mContext).setKey(this.slotId).setMute(false);
        if (!TextUtils.isEmpty(this.userId)) {
            mute.setUserId(this.userId).setCustomData(this.extra).setAdViewVideoCheckListener(new AdViewVideoCheckListener() { // from class: com.fl.saas.s2s.topon.FLTopOnRewardVideoAdapter.2
                @Override // com.fl.saas.base.interfaces.AdViewVideoCheckListener
                public void onVideoCheckReward(String str) {
                }
            });
        }
        YdVideo ydVideoBuild = mute.setVideoListener(new AdViewVideoListener() { // from class: com.fl.saas.s2s.topon.FLTopOnRewardVideoAdapter.3
            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdClick(String str) {
                LogcatUtil.d(FLTopOnRewardVideoAdapter.TAG, "onAdClick");
                if (FLTopOnRewardVideoAdapter.this.mImpressionListener != null) {
                    FLTopOnRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdClose() {
                LogcatUtil.d(FLTopOnRewardVideoAdapter.TAG, "onAdClose");
                if (FLTopOnRewardVideoAdapter.this.mImpressionListener != null) {
                    FLTopOnRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
                }
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                if (FLTopOnRewardVideoAdapter.this.mLoadListener != null) {
                    FLTopOnRewardVideoAdapter.this.mLoadListener.onAdLoadError("", ydError.toString());
                }
                ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                if (aTBiddingListener2 != null) {
                    aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail(ydError.toString()), (BaseAd) null);
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdShow() {
                LogcatUtil.d(FLTopOnRewardVideoAdapter.TAG, "onAdShow");
                if (FLTopOnRewardVideoAdapter.this.mImpressionListener != null) {
                    FLTopOnRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onSkipVideo() {
                LogcatUtil.d(FLTopOnRewardVideoAdapter.TAG, "onSkipVideo");
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoCompleted() {
                LogcatUtil.d(FLTopOnRewardVideoAdapter.TAG, "onVideoCompleted");
                if (FLTopOnRewardVideoAdapter.this.mImpressionListener != null) {
                    FLTopOnRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoPrepared() {
                LogcatUtil.d(FLTopOnRewardVideoAdapter.TAG, "onVideoPrepared");
                FLTopOnRewardVideoAdapter.this.loadSuccessTime = System.currentTimeMillis();
                if (aTBiddingListener != null) {
                    String str = System.currentTimeMillis() + "";
                    FLTopOnInitManager.getInstance().putBidAdObject(str, FLTopOnRewardVideoAdapter.this.ydVideo);
                    aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(FLTopOnRewardVideoAdapter.this.ydVideo.getECPM() == 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : ((double) FLTopOnRewardVideoAdapter.this.ydVideo.getECPM()) / 100.0d, str, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                }
                if (FLTopOnRewardVideoAdapter.this.mLoadListener != null) {
                    FLTopOnRewardVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoReward(double d) {
                LogcatUtil.d(FLTopOnRewardVideoAdapter.TAG, "onVideoReward, ecpm:" + d);
                if (FLTopOnRewardVideoAdapter.this.mImpressionListener != null) {
                    FLTopOnRewardVideoAdapter.this.mImpressionListener.onReward();
                }
            }
        }).build();
        this.ydVideo = ydVideoBuild;
        ydVideoBuild.requestRewardVideo();
    }

    public void destory() {
        YdVideo ydVideo = this.ydVideo;
        if (ydVideo != null) {
            ydVideo.destroy();
            this.ydVideo = null;
        }
    }

    public String getNetworkName() {
        return FLTopOnInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.slotId;
    }

    public String getNetworkSDKVersion() {
        return FLTopOnInitManager.getInstance().getNetworkVersion();
    }

    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB;
    }

    public boolean isAdReady() {
        YdVideo ydVideo;
        if (System.currentTimeMillis() - this.loadSuccessTime <= 1800000 && (ydVideo = this.ydVideo) != null) {
            return ydVideo.isReady();
        }
        return false;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        ATCustomLoadListener aTCustomLoadListener;
        String str;
        LogcatUtil.d(TAG, "loadCustomNetworkAd");
        this.mContext = context;
        this.slotId = (String) map.get("slot_id");
        if (map2 != null) {
            this.userId = (String) map2.get(PtgRewardConstant.REWARD_PARAMS.USER_ID);
            this.extra = (String) map2.get("user_custom_data");
        }
        if (TextUtils.isEmpty(this.slotId)) {
            if (this.mLoadListener == null) {
                return;
            }
            aTCustomLoadListener = this.mLoadListener;
            str = "slot_id is empty!";
        } else {
            if (!map.containsKey(AssistPushConsts.MSG_TYPE_PAYLOAD)) {
                FLTopOnInitManager.getInstance().initSDK(context, map, new FLTopOnInitManager.InitCallback() { // from class: com.fl.saas.s2s.topon.FLTopOnRewardVideoAdapter.4
                    @Override // com.fl.saas.s2s.topon.FLTopOnInitManager.InitCallback
                    public void onFinish() {
                        FLTopOnRewardVideoAdapter.this.startLoad(null);
                    }
                });
                return;
            }
            String str2 = (String) map.get(AssistPushConsts.MSG_TYPE_PAYLOAD);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Object objPopBidAdObject = FLTopOnInitManager.getInstance().popBidAdObject(str2);
            if (objPopBidAdObject instanceof YdVideo) {
                if (this.ydVideo == null) {
                    this.ydVideo = (YdVideo) objPopBidAdObject;
                }
                if (this.mLoadListener != null) {
                    this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    return;
                }
                return;
            }
            if (this.mLoadListener == null) {
                return;
            }
            aTCustomLoadListener = this.mLoadListener;
            str = "FL: Bidding Cache is empty.";
        }
        aTCustomLoadListener.onAdLoadError("", str);
    }

    public void notifyBidDisplay(boolean z, double d) {
    }

    public void notifyBidLoss(String str, double d, Map<String, Object> map) {
        YdVideo ydVideo = this.ydVideo;
        if (ydVideo != null) {
            ydVideo.biddingResultUpload(false, (int) (d * 100.0d), 0);
        }
    }

    public void notifyBidWin(double d, double d2, Map<String, Object> map) {
        YdVideo ydVideo = this.ydVideo;
        if (ydVideo != null) {
            ydVideo.biddingResultUpload(true, (int) (d * 100.0d), (int) (d2 * 100.0d));
        }
    }

    public void show(Activity activity) {
        YdVideo ydVideo = this.ydVideo;
        if (ydVideo != null) {
            ydVideo.show(activity);
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, final ATBiddingListener aTBiddingListener) {
        String str = TAG;
        LogcatUtil.d(str, "startBiddingRequest");
        this.mContext = context;
        this.slotId = (String) map.get("slot_id");
        if (map2 != null) {
            this.userId = (String) map2.get(PtgRewardConstant.REWARD_PARAMS.USER_ID);
            this.extra = (String) map2.get("user_custom_data");
        }
        if (!TextUtils.isEmpty(this.slotId)) {
            FLTopOnInitManager.getInstance().initSDK(context, map, new FLTopOnInitManager.InitCallback() { // from class: com.fl.saas.s2s.topon.FLTopOnRewardVideoAdapter.1
                @Override // com.fl.saas.s2s.topon.FLTopOnInitManager.InitCallback
                public void onFinish() {
                    FLTopOnRewardVideoAdapter.this.startLoad(aTBiddingListener);
                }
            });
            return true;
        }
        LogcatUtil.d(str, "slot_id is empty!");
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdLoadError("", "slot_id is empty!");
        }
        if (aTBiddingListener == null) {
            return true;
        }
        aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("slot_id is empty!"), (BaseAd) null);
        return true;
    }
}
