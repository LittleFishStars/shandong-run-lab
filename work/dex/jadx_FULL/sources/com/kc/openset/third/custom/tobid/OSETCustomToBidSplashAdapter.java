package com.kc.openset.third.custom.tobid;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.kc.openset.ad.bid.BidAdInfo;
import com.kc.openset.ad.listener.OSETSplashAdLoadListener;
import com.kc.openset.ad.listener.OSETSplashListener;
import com.kc.openset.ad.splash.OSETSplash;
import com.kc.openset.ad.splash.OSETSplashAd;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomSplashAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class OSETCustomToBidSplashAdapter extends WMCustomSplashAdapter {
    private static final Handler sHandler = new Handler(Looper.getMainLooper());
    private OSETSplashAd mSplashAd;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: toLoadAd, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$loadAd$1(Context context, Map<String, Object> map) {
        try {
            ((OSETSplash) ((OSETSplash) OSETSplash.getInstance().setContext((Activity) context)).setPosId((String) map.get(TradPlusInitManager.PLACEMENTID))).loadAd(new OSETSplashAdLoadListener() { // from class: com.kc.openset.third.custom.tobid.OSETCustomToBidSplashAdapter.1
                @Override // com.kc.openset.ad.listener.BaseAdLoadListener
                public void onLoadFail(String str, String str2) {
                    try {
                        OSETCustomToBidSplashAdapter.this.callLoadFail(new WMAdapterError(Integer.parseInt(str), str2));
                    } catch (Exception unused) {
                        OSETCustomToBidSplashAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), str2));
                    }
                }

                @Override // com.kc.openset.ad.listener.OSETSplashAdLoadListener
                public void onLoadSuccess(OSETSplashAd oSETSplashAd) {
                    if (oSETSplashAd == null) {
                        OSETCustomToBidSplashAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "ADN开屏广告数据为空！"));
                        return;
                    }
                    OSETCustomToBidSplashAdapter.this.mSplashAd = oSETSplashAd;
                    if (OSETCustomToBidSplashAdapter.this.isClientBidding()) {
                        OSETCustomToBidSplashAdapter.this.callLoadBiddingSuccess(new BidPrice(String.valueOf(OSETCustomToBidSplashAdapter.this.mSplashAd.getECPM())));
                    }
                    OSETCustomToBidSplashAdapter.this.callLoadSuccess();
                }
            });
        } catch (Exception e) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e.getMessage()));
        }
    }

    public void destroyAd() {
        OSETSplashAd oSETSplashAd = this.mSplashAd;
        if (oSETSplashAd != null) {
            oSETSplashAd.destroy();
            this.mSplashAd = null;
        }
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    public boolean isReady() {
        OSETSplashAd oSETSplashAd = this.mSplashAd;
        return oSETSplashAd != null && oSETSplashAd.isUsable();
    }

    public void loadAd(final Activity activity, ViewGroup viewGroup, Map<String, Object> map, final Map<String, Object> map2) {
        if (activity == null) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
        } else {
            sHandler.post(new Runnable() { // from class: com.zj.adlib.i66
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17160a.lambda$loadAd$0(activity, map2);
                }
            });
        }
    }

    public void loadAd(final Context context, ViewGroup viewGroup, Map<String, Object> map, final Map<String, Object> map2) {
        if (context instanceof Activity) {
            sHandler.post(new Runnable() { // from class: com.zj.adlib.j66
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17335a.lambda$loadAd$1(context, map2);
                }
            });
        } else {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is not instance Activity"));
        }
    }

    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        double d;
        if (this.mSplashAd != null) {
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
                    this.mSplashAd.bidFail(bidAdInfo);
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
                this.mSplashAd.bidSuccess(bidAdInfo);
            } catch (Exception unused4) {
            }
        }
    }

    public void showAd(Activity activity, ViewGroup viewGroup, Map<String, Object> map) {
        try {
            if (!isReady() || viewGroup == null) {
                callSplashAdShowError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "mSplashAd is null or not Usable，viewGroup=" + viewGroup));
            } else {
                viewGroup.removeAllViews();
                this.mSplashAd.showAd(activity, viewGroup, new OSETSplashListener() { // from class: com.kc.openset.third.custom.tobid.OSETCustomToBidSplashAdapter.2
                    @Override // com.kc.openset.ad.listener.OSETSplashListener
                    public void onAdDetailViewClosed() {
                    }

                    @Override // com.kc.openset.ad.listener.OSETSplashListener
                    public void onClick() {
                        OSETCustomToBidSplashAdapter.this.callSplashAdClick();
                    }

                    @Override // com.kc.openset.ad.listener.OSETSplashListener
                    public void onClose() {
                        OSETCustomToBidSplashAdapter.this.callSplashAdClosed();
                    }

                    @Override // com.kc.openset.ad.listener.OSETBaseListener
                    public void onError(String str, String str2) {
                        try {
                            OSETCustomToBidSplashAdapter.this.callSplashAdShowError(new WMAdapterError(Integer.parseInt(str), str2));
                        } catch (Exception unused) {
                            OSETCustomToBidSplashAdapter.this.callSplashAdShowError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), str2));
                        }
                    }

                    @Override // com.kc.openset.ad.listener.OSETSplashListener
                    public void onShow() {
                        OSETCustomToBidSplashAdapter.this.callSplashAdShow();
                    }
                });
            }
        } catch (Exception e) {
            callSplashAdShowError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), e.getMessage()));
        }
    }
}
