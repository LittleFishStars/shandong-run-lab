package com.kc.openset.third.custom.tobid;

import android.app.Activity;
import android.content.Context;
import androidx.camera.video.AudioStats;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.kc.openset.ad.bid.BidAdInfo;
import com.kc.openset.ad.intestitial.OSETInterstitial;
import com.kc.openset.ad.intestitial.OSETInterstitialAd;
import com.kc.openset.ad.listener.OSETInterstitialAdLoadListener;
import com.kc.openset.ad.listener.OSETInterstitialListener;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomInterstitialAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class OSETCustomToBidInterstitialAdapter extends WMCustomInterstitialAdapter {
    private OSETInterstitialAd mInterstitialAd;

    public void destroyAd() {
        OSETInterstitialAd oSETInterstitialAd = this.mInterstitialAd;
        if (oSETInterstitialAd != null) {
            oSETInterstitialAd.destroy();
            this.mInterstitialAd = null;
        }
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    public boolean isReady() {
        OSETInterstitialAd oSETInterstitialAd = this.mInterstitialAd;
        return oSETInterstitialAd != null && oSETInterstitialAd.isUsable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadAd(Activity activity, Map<String, Object> map, Map<String, Object> map2) {
        if (activity == null) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
            return;
        }
        try {
            ((OSETInterstitial) ((OSETInterstitial) OSETInterstitial.getInstance().setContext(activity)).setPosId((String) map2.get(TradPlusInitManager.PLACEMENTID))).loadAd(new OSETInterstitialAdLoadListener() { // from class: com.kc.openset.third.custom.tobid.OSETCustomToBidInterstitialAdapter.1
                @Override // com.kc.openset.ad.listener.BaseAdLoadListener
                public void onLoadFail(String str, String str2) {
                    try {
                        OSETCustomToBidInterstitialAdapter.this.callLoadFail(new WMAdapterError(Integer.parseInt(str), str2));
                    } catch (Exception unused) {
                        OSETCustomToBidInterstitialAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), str2));
                    }
                }

                @Override // com.kc.openset.ad.listener.OSETInterstitialAdLoadListener
                public void onLoadSuccess(OSETInterstitialAd oSETInterstitialAd) {
                    if (oSETInterstitialAd == null) {
                        OSETCustomToBidInterstitialAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "ADN插屏广告数据为空！"));
                        return;
                    }
                    OSETCustomToBidInterstitialAdapter.this.mInterstitialAd = oSETInterstitialAd;
                    if (OSETCustomToBidInterstitialAdapter.this.isClientBidding()) {
                        OSETCustomToBidInterstitialAdapter.this.callLoadBiddingSuccess(new BidPrice(String.valueOf(OSETCustomToBidInterstitialAdapter.this.mInterstitialAd.getECPM())));
                    }
                    OSETCustomToBidInterstitialAdapter.this.callLoadSuccess();
                }
            });
        } catch (Exception e) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e.getMessage()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (!(context instanceof Activity)) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "context not instance Activity"));
            return;
        }
        try {
            ((OSETInterstitial) ((OSETInterstitial) OSETInterstitial.getInstance().setContext((Activity) context)).setPosId((String) map2.get(TradPlusInitManager.PLACEMENTID))).loadAd(new OSETInterstitialAdLoadListener() { // from class: com.kc.openset.third.custom.tobid.OSETCustomToBidInterstitialAdapter.2
                @Override // com.kc.openset.ad.listener.BaseAdLoadListener
                public void onLoadFail(String str, String str2) {
                    try {
                        OSETCustomToBidInterstitialAdapter.this.callLoadFail(new WMAdapterError(Integer.parseInt(str), str2));
                    } catch (Exception unused) {
                        OSETCustomToBidInterstitialAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), str2));
                    }
                }

                @Override // com.kc.openset.ad.listener.OSETInterstitialAdLoadListener
                public void onLoadSuccess(OSETInterstitialAd oSETInterstitialAd) {
                    if (oSETInterstitialAd == null) {
                        OSETCustomToBidInterstitialAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "ADN插屏广告数据为空！"));
                        return;
                    }
                    OSETCustomToBidInterstitialAdapter.this.mInterstitialAd = oSETInterstitialAd;
                    if (OSETCustomToBidInterstitialAdapter.this.isClientBidding()) {
                        OSETCustomToBidInterstitialAdapter.this.callLoadBiddingSuccess(new BidPrice(String.valueOf(OSETCustomToBidInterstitialAdapter.this.mInterstitialAd.getECPM())));
                    }
                    OSETCustomToBidInterstitialAdapter.this.callLoadSuccess();
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
        double d;
        if (this.mInterstitialAd != null) {
            try {
                BidAdInfo bidAdInfo = new BidAdInfo();
                String string5 = "";
                if (map != null) {
                    Object obj = map.get("bidding_channel");
                    string = obj != null ? obj.toString() : "";
                    Object obj2 = map.get("bidding_ecpm");
                    string2 = obj2 != null ? obj2.toString() : "";
                    Object obj3 = map.get("waterfall_ecpm");
                    string3 = obj3 != null ? obj3.toString() : "";
                    Object obj4 = map.get("waterfall_channel");
                    string4 = obj4 != null ? obj4.toString() : "";
                    Object obj5 = map.get("winner_ecpm");
                    string5 = obj5 != null ? obj5.toString() : "";
                    Object obj6 = map.get("winner_channel");
                    if (obj6 != null) {
                        obj6.toString();
                    }
                } else {
                    string = "";
                    string2 = string;
                    string3 = string2;
                    string4 = string3;
                }
                if (!z) {
                    try {
                        bidAdInfo.setPrice(Double.parseDouble(string5));
                    } catch (Exception unused) {
                    }
                    bidAdInfo.setAdnName(string5);
                    this.mInterstitialAd.bidFail(bidAdInfo);
                    return;
                }
                double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
                try {
                    d = Double.parseDouble(string3);
                } catch (Exception unused2) {
                    d = 0.0d;
                }
                try {
                    d2 = Double.parseDouble(string2);
                } catch (Exception unused3) {
                }
                if (d > d2) {
                    bidAdInfo.setBidding(false);
                    bidAdInfo.setPrice(d);
                    string = string4;
                } else {
                    bidAdInfo.setBidding(true);
                    bidAdInfo.setPrice(d2);
                }
                bidAdInfo.setAdnName(string);
                this.mInterstitialAd.bidSuccess(bidAdInfo);
            } catch (Exception unused4) {
            }
        }
    }

    public void showAd(Activity activity, HashMap<String, String> map, Map<String, Object> map2) {
        try {
            if (isReady()) {
                this.mInterstitialAd.showAd(activity, new OSETInterstitialListener() { // from class: com.kc.openset.third.custom.tobid.OSETCustomToBidInterstitialAdapter.3
                    @Override // com.kc.openset.ad.listener.OSETInterstitialListener
                    public void onClick() {
                        OSETCustomToBidInterstitialAdapter.this.callVideoAdClick();
                    }

                    @Override // com.kc.openset.ad.listener.OSETInterstitialListener
                    public void onClose() {
                        OSETCustomToBidInterstitialAdapter.this.callVideoAdClosed();
                    }

                    @Override // com.kc.openset.ad.listener.OSETBaseListener
                    public void onError(String str, String str2) {
                        try {
                            OSETCustomToBidInterstitialAdapter.this.callVideoAdPlayError(new WMAdapterError(Integer.parseInt(str), str2));
                        } catch (Exception unused) {
                            OSETCustomToBidInterstitialAdapter.this.callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), str2));
                        }
                    }

                    @Override // com.kc.openset.ad.listener.OSETInterstitialListener
                    public void onShow() {
                        OSETCustomToBidInterstitialAdapter.this.callVideoAdShow();
                    }
                });
            } else {
                callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "mInterstitialAd is null or not Usable"));
            }
        } catch (Exception e) {
            callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), e.getMessage()));
        }
    }
}
