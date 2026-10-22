package com.kc.openset.third.custom.tobid;

import android.app.Activity;
import android.content.Context;
import androidx.camera.video.AudioStats;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.kc.openset.ad.bid.BidAdInfo;
import com.kc.openset.ad.listener.OSETRewardAdLoadListener;
import com.kc.openset.ad.listener.OSETRewardListener;
import com.kc.openset.ad.reward.OSETRewardAd;
import com.kc.openset.ad.reward.OSETRewardVideo;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomRewardAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class OSETCustomToBidRewardAdapter extends WMCustomRewardAdapter {
    private OSETRewardAd mRewardAd;

    public void destroyAd() {
        OSETRewardAd oSETRewardAd = this.mRewardAd;
        if (oSETRewardAd != null) {
            oSETRewardAd.destroy();
            this.mRewardAd = null;
        }
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    public boolean isReady() {
        OSETRewardAd oSETRewardAd = this.mRewardAd;
        return oSETRewardAd != null && oSETRewardAd.isUsable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadAd(Activity activity, Map<String, Object> map, Map<String, Object> map2) {
        if (activity == null) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
            return;
        }
        try {
            ((OSETRewardVideo) ((OSETRewardVideo) OSETRewardVideo.getInstance().setContext(activity)).setPosId((String) map2.get(TradPlusInitManager.PLACEMENTID))).loadAd(new OSETRewardAdLoadListener() { // from class: com.kc.openset.third.custom.tobid.OSETCustomToBidRewardAdapter.1
                @Override // com.kc.openset.ad.listener.BaseAdLoadListener
                public void onLoadFail(String str, String str2) {
                    try {
                        OSETCustomToBidRewardAdapter.this.callLoadFail(new WMAdapterError(Integer.parseInt(str), str2));
                    } catch (Exception unused) {
                        OSETCustomToBidRewardAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), str2));
                    }
                }

                @Override // com.kc.openset.ad.listener.OSETRewardAdLoadListener
                public void onLoadSuccess(OSETRewardAd oSETRewardAd) {
                    if (oSETRewardAd == null) {
                        OSETCustomToBidRewardAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "ADN激励广告数据为空！"));
                        return;
                    }
                    OSETCustomToBidRewardAdapter.this.mRewardAd = oSETRewardAd;
                    if (OSETCustomToBidRewardAdapter.this.isClientBidding()) {
                        OSETCustomToBidRewardAdapter.this.callLoadBiddingSuccess(new BidPrice(String.valueOf(OSETCustomToBidRewardAdapter.this.mRewardAd.getECPM())));
                    }
                    OSETCustomToBidRewardAdapter.this.callLoadSuccess();
                }
            });
        } catch (Exception e) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e.getMessage()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (!(context instanceof Activity)) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is not instance Activity"));
            return;
        }
        try {
            ((OSETRewardVideo) ((OSETRewardVideo) OSETRewardVideo.getInstance().setContext((Activity) context)).setPosId((String) map2.get(TradPlusInitManager.PLACEMENTID))).loadAd(new OSETRewardAdLoadListener() { // from class: com.kc.openset.third.custom.tobid.OSETCustomToBidRewardAdapter.2
                @Override // com.kc.openset.ad.listener.BaseAdLoadListener
                public void onLoadFail(String str, String str2) {
                    try {
                        OSETCustomToBidRewardAdapter.this.callLoadFail(new WMAdapterError(Integer.parseInt(str), str2));
                    } catch (Exception unused) {
                        OSETCustomToBidRewardAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), str2));
                    }
                }

                @Override // com.kc.openset.ad.listener.OSETRewardAdLoadListener
                public void onLoadSuccess(OSETRewardAd oSETRewardAd) {
                    if (oSETRewardAd == null) {
                        OSETCustomToBidRewardAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "ADN激励广告数据为空！"));
                        return;
                    }
                    OSETCustomToBidRewardAdapter.this.mRewardAd = oSETRewardAd;
                    if (OSETCustomToBidRewardAdapter.this.isClientBidding()) {
                        OSETCustomToBidRewardAdapter.this.callLoadBiddingSuccess(new BidPrice(String.valueOf(OSETCustomToBidRewardAdapter.this.mRewardAd.getECPM())));
                    }
                    OSETCustomToBidRewardAdapter.this.callLoadSuccess();
                }
            });
        } catch (Exception e) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e.getMessage()));
        }
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        double d;
        if (this.mRewardAd != null) {
            try {
                BidAdInfo bidAdInfo = new BidAdInfo();
                String str2 = "";
                if (map != null) {
                    Object obj = map.get("bidding_channel");
                    string2 = obj != null ? obj.toString() : "";
                    Object obj2 = map.get("bidding_ecpm");
                    string3 = obj2 != null ? obj2.toString() : "";
                    Object obj3 = map.get("waterfall_ecpm");
                    string4 = obj3 != null ? obj3.toString() : "";
                    Object obj4 = map.get("waterfall_channel");
                    string5 = obj4 != null ? obj4.toString() : "";
                    Object obj5 = map.get("winner_ecpm");
                    String string6 = obj5 != null ? obj5.toString() : "";
                    Object obj6 = map.get("winner_channel");
                    string = obj6 != null ? obj6.toString() : "";
                    str2 = string6;
                } else {
                    string = "";
                    string2 = string;
                    string3 = string2;
                    string4 = string3;
                    string5 = string4;
                }
                if (!z) {
                    try {
                        bidAdInfo.setPrice(Double.parseDouble(str2));
                    } catch (Exception unused) {
                    }
                    bidAdInfo.setAdnName(string);
                    this.mRewardAd.bidFail(bidAdInfo);
                    return;
                }
                double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                try {
                    d = Double.parseDouble(string4);
                } catch (Exception unused2) {
                    d = 0.0d;
                }
                try {
                    d2 = Double.parseDouble(string3);
                } catch (Exception unused3) {
                }
                if (d > d2) {
                    bidAdInfo.setBidding(false);
                    bidAdInfo.setPrice(d);
                    string2 = string5;
                } else {
                    bidAdInfo.setBidding(true);
                    bidAdInfo.setPrice(d2);
                }
                bidAdInfo.setAdnName(string2);
                this.mRewardAd.bidSuccess(bidAdInfo);
            } catch (Exception unused4) {
            }
        }
    }

    public void showAd(Activity activity, HashMap<String, String> map, Map<String, Object> map2) {
        try {
            if (isReady()) {
                this.mRewardAd.showAd(activity, new OSETRewardListener() { // from class: com.kc.openset.third.custom.tobid.OSETCustomToBidRewardAdapter.3
                    @Override // com.kc.openset.ad.listener.OSETRewardListener
                    public void onClick() {
                        OSETCustomToBidRewardAdapter.this.callVideoAdClick();
                    }

                    @Override // com.kc.openset.ad.listener.OSETRewardListener
                    public void onClose() {
                        OSETCustomToBidRewardAdapter.this.callVideoAdClosed();
                    }

                    @Override // com.kc.openset.ad.listener.OSETBaseListener
                    public void onError(String str, String str2) {
                        try {
                            OSETCustomToBidRewardAdapter.this.callVideoAdPlayError(new WMAdapterError(Integer.parseInt(str), str2));
                        } catch (Exception unused) {
                            OSETCustomToBidRewardAdapter.this.callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), str2));
                        }
                    }

                    @Override // com.kc.openset.ad.listener.OSETRewardListener
                    public void onReward() {
                        OSETCustomToBidRewardAdapter.this.callVideoAdReward(true);
                    }

                    @Override // com.kc.openset.ad.listener.OSETRewardListener
                    public void onServiceResponse(int i) {
                    }

                    @Override // com.kc.openset.ad.listener.OSETRewardListener
                    public void onShow() {
                        OSETCustomToBidRewardAdapter.this.callVideoAdShow();
                    }

                    @Override // com.kc.openset.ad.listener.OSETRewardListener
                    public void onVideoEnd() {
                        OSETCustomToBidRewardAdapter.this.callVideoAdPlayComplete();
                    }

                    @Override // com.kc.openset.ad.listener.OSETRewardListener
                    public void onVideoStart() {
                    }
                });
            } else {
                callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "mRewardAd is null or not Usable"));
            }
        } catch (Exception e) {
            callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), e.getMessage()));
        }
    }
}
