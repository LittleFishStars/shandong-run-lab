package com.fl.saas.s2s.tobid;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.base.interfaces.AdViewVideoCheckListener;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdVideo;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomRewardAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLToBidVideoAdapter extends WMCustomRewardAdapter {
    private static final String TAG = CommConstant.getClassTag("FLToBid", FLToBidVideoAdapter.class);
    private boolean hasBackFail;
    private String mTransID;
    private YdVideo ydVideo;

    public void destroyAd() {
        YdVideo ydVideo = this.ydVideo;
        if (ydVideo != null) {
            ydVideo.destroy();
            this.ydVideo = null;
        }
    }

    public boolean isReady() {
        YdVideo ydVideo = this.ydVideo;
        return ydVideo != null && ydVideo.isReady();
    }

    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        String string;
        String str;
        String str2 = (String) map2.get(TradPlusInitManager.PLACEMENTID);
        String string2 = "";
        if (map != null) {
            try {
                string = map.containsKey("userId") ? map.get("userId").toString() : "";
                try {
                    if (map.containsKey("extra")) {
                        string2 = map.get("extra").toString();
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
                string = "";
            }
            str = string2;
            string2 = string;
        } else {
            str = "";
        }
        YdVideo.Builder mute = new YdVideo.Builder(context).setKey(str2).setMute(false);
        if (!TextUtils.isEmpty(string2)) {
            mute.setUserId(string2).setCustomData(str).setAdViewVideoCheckListener(new AdViewVideoCheckListener() { // from class: com.fl.saas.s2s.tobid.FLToBidVideoAdapter.1
                @Override // com.fl.saas.base.interfaces.AdViewVideoCheckListener
                public void onVideoCheckReward(String str3) {
                    FLToBidVideoAdapter.this.mTransID = str3;
                }
            });
        }
        this.hasBackFail = false;
        YdVideo ydVideoBuild = mute.setVideoListener(new AdViewVideoListener() { // from class: com.fl.saas.s2s.tobid.FLToBidVideoAdapter.2
            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdClick(String str3) {
                LogcatUtil.d(FLToBidVideoAdapter.TAG, "onAdClick");
                FLToBidVideoAdapter.this.callVideoAdClick();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdClose() {
                LogcatUtil.d(FLToBidVideoAdapter.TAG, "onAdClose");
                FLToBidVideoAdapter.this.callVideoAdClosed();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d(FLToBidVideoAdapter.TAG, "onAdFailed:" + ydError);
                if (FLToBidVideoAdapter.this.hasBackFail) {
                    return;
                }
                FLToBidVideoAdapter.this.hasBackFail = true;
                FLToBidVideoAdapter.this.callLoadFail(new WMAdapterError(ydError.getCode(), ydError.getMsg()));
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onAdShow() {
                LogcatUtil.d(FLToBidVideoAdapter.TAG, "onAdShow");
                FLToBidVideoAdapter.this.callVideoAdShow();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onSkipVideo() {
                LogcatUtil.d(FLToBidVideoAdapter.TAG, "onSkipVideo");
                FLToBidVideoAdapter.this.callVideoAdSkipped();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoCompleted() {
                LogcatUtil.d(FLToBidVideoAdapter.TAG, "onVideoCompleted");
                FLToBidVideoAdapter.this.callVideoAdPlayComplete();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoPrepared() {
                LogcatUtil.d(FLToBidVideoAdapter.TAG, "onVideoPrepared");
                if (FLToBidVideoAdapter.this.getBiddingType() == 1 && FLToBidVideoAdapter.this.ydVideo != null) {
                    FLToBidVideoAdapter.this.callLoadBiddingSuccess(new BidPrice(String.valueOf(FLToBidVideoAdapter.this.ydVideo.getECPM())));
                }
                FLToBidVideoAdapter.this.callLoadSuccess();
            }

            @Override // com.fl.saas.base.base.listener.InnerVideoListener
            public void onVideoReward(double d) {
                LogcatUtil.d(FLToBidVideoAdapter.TAG, "onVideoReward");
                if (TextUtils.isEmpty(FLToBidVideoAdapter.this.mTransID)) {
                    FLToBidVideoAdapter.this.callVideoAdReward(true);
                    return;
                }
                HashMap map3 = new HashMap();
                map3.put("transID", FLToBidVideoAdapter.this.mTransID);
                FLToBidVideoAdapter.this.callVideoAdRewardWithData(true, map3);
            }
        }).build();
        this.ydVideo = ydVideoBuild;
        ydVideoBuild.requestRewardVideo();
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        super/*com.windmill.sdk.custom.WMAdBaseAdapter*/.notifyBiddingResult(z, str, map);
        try {
            YdVideo ydVideo = this.ydVideo;
            if (ydVideo != null) {
                ydVideo.biddingResultUpload(z, (int) Float.parseFloat(str), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAd(Activity activity, HashMap<String, String> map, Map<String, Object> map2) {
        YdVideo ydVideo = this.ydVideo;
        if (ydVideo != null) {
            ydVideo.show(activity);
        }
    }
}
