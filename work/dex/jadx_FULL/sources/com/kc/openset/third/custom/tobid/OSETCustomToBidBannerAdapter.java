package com.kc.openset.third.custom.tobid;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.kc.openset.ad.banner.OSETBanner;
import com.kc.openset.ad.banner.OSETBannerAd;
import com.kc.openset.ad.bid.BidAdInfo;
import com.kc.openset.ad.listener.OSETBannerAdLoadListener;
import com.kc.openset.ad.listener.OSETBannerListener;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomBannerAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class OSETCustomToBidBannerAdapter extends WMCustomBannerAdapter {
    private OSETBannerAd mBannerAd;
    private View mBannerView;

    /* JADX INFO: Access modifiers changed from: private */
    public void bindAdListener(Activity activity) {
        OSETBannerAd oSETBannerAd = this.mBannerAd;
        if (oSETBannerAd == null) {
            return;
        }
        oSETBannerAd.render(activity, new OSETBannerListener() { // from class: com.kc.openset.third.custom.tobid.OSETCustomToBidBannerAdapter.3
            @Override // com.kc.openset.ad.listener.OSETBannerListener
            public void onClick(View view) {
                OSETCustomToBidBannerAdapter.this.callBannerAdClick();
            }

            @Override // com.kc.openset.ad.listener.OSETBannerListener
            public void onClose(View view) {
                OSETCustomToBidBannerAdapter.this.callBannerAdClosed();
            }

            @Override // com.kc.openset.ad.listener.OSETBaseListener
            public void onError(String str, String str2) {
                try {
                    OSETCustomToBidBannerAdapter.this.callBannerAdShowError(new WMAdapterError(Integer.parseInt(str), "奇点banner广告渲染失败:" + str2));
                } catch (Exception unused) {
                    OSETCustomToBidBannerAdapter.this.callBannerAdShowError(new WMAdapterError(WindMillError.ERROR_AD_PLAY.getErrorCode(), "奇点banner广告渲染失败:" + str2));
                }
            }

            @Override // com.kc.openset.ad.listener.OSETBannerListener
            public void onRenderSuccess(View view) {
                Log.d("TbManager", "价格：" + OSETCustomToBidBannerAdapter.this.mBannerAd.getECPM() + ", 是否客户端竞价：" + OSETCustomToBidBannerAdapter.this.isClientBidding());
                OSETCustomToBidBannerAdapter.this.mBannerView = view;
                if (OSETCustomToBidBannerAdapter.this.isClientBidding()) {
                    OSETCustomToBidBannerAdapter.this.callLoadBiddingSuccess(new BidPrice(String.valueOf(OSETCustomToBidBannerAdapter.this.mBannerAd.getECPM())));
                }
                OSETCustomToBidBannerAdapter.this.callLoadSuccess();
            }

            @Override // com.kc.openset.ad.listener.OSETBannerListener
            public void onShow(View view) {
                OSETCustomToBidBannerAdapter.this.callBannerAdShow();
            }
        });
    }

    public void destroyAd() {
        OSETBannerAd oSETBannerAd = this.mBannerAd;
        if (oSETBannerAd != null) {
            oSETBannerAd.destroy();
            this.mBannerAd = null;
        }
    }

    public View getBannerView() {
        return this.mBannerView;
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    public boolean isReady() {
        OSETBannerAd oSETBannerAd = this.mBannerAd;
        return oSETBannerAd != null && oSETBannerAd.isUsable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadAd(final Activity activity, Map<String, Object> map, Map<String, Object> map2) {
        if (activity == null) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
            return;
        }
        try {
            ((OSETBanner) ((OSETBanner) OSETBanner.getInstance().setPosId((String) map2.get(TradPlusInitManager.PLACEMENTID))).setContext(activity)).loadAd(new OSETBannerAdLoadListener() { // from class: com.kc.openset.third.custom.tobid.OSETCustomToBidBannerAdapter.1
                @Override // com.kc.openset.ad.listener.BaseAdLoadListener
                public void onLoadFail(String str, String str2) {
                    try {
                        OSETCustomToBidBannerAdapter.this.callLoadFail(new WMAdapterError(Integer.parseInt(str), str2));
                    } catch (Exception unused) {
                        OSETCustomToBidBannerAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), str2));
                    }
                }

                @Override // com.kc.openset.ad.listener.OSETBannerAdLoadListener
                public void onLoadSuccess(OSETBannerAd oSETBannerAd) {
                    if (oSETBannerAd == null) {
                        OSETCustomToBidBannerAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "奇点Banner广告数据为空！"));
                    } else {
                        OSETCustomToBidBannerAdapter.this.mBannerAd = oSETBannerAd;
                        OSETCustomToBidBannerAdapter.this.bindAdListener(activity);
                    }
                }
            });
        } catch (Exception e) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e.getMessage()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (!(context instanceof Activity)) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "context is not instance Activity"));
            return;
        }
        try {
            ((OSETBanner) ((OSETBanner) OSETBanner.getInstance().setPosId((String) map2.get(TradPlusInitManager.PLACEMENTID))).setContext((Activity) context)).loadAd(new OSETBannerAdLoadListener() { // from class: com.kc.openset.third.custom.tobid.OSETCustomToBidBannerAdapter.2
                @Override // com.kc.openset.ad.listener.BaseAdLoadListener
                public void onLoadFail(String str, String str2) {
                    try {
                        OSETCustomToBidBannerAdapter.this.callLoadFail(new WMAdapterError(Integer.parseInt(str), str2));
                    } catch (Exception unused) {
                        OSETCustomToBidBannerAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), str2));
                    }
                }

                @Override // com.kc.openset.ad.listener.OSETBannerAdLoadListener
                public void onLoadSuccess(OSETBannerAd oSETBannerAd) {
                    if (oSETBannerAd == null) {
                        OSETCustomToBidBannerAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "奇点Banner广告数据为空！"));
                    } else {
                        OSETCustomToBidBannerAdapter.this.mBannerAd = oSETBannerAd;
                        OSETCustomToBidBannerAdapter.this.bindAdListener((Activity) context);
                    }
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
        if (this.mBannerAd != null) {
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
                    this.mBannerAd.bidFail(bidAdInfo);
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
                this.mBannerAd.bidSuccess(bidAdInfo);
            } catch (Exception unused4) {
            }
        }
    }
}
