package com.kc.openset.third.custom.tobid;

import android.app.Activity;
import androidx.camera.video.AudioStats;
import com.kc.openset.ad._native.OSETNative;
import com.kc.openset.ad._native.OSETNativeAd;
import com.kc.openset.ad.bid.BidAdInfo;
import com.kc.openset.ad.listener.OSETNativeAdLoadListener;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.natives.WMNativeAdData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class OSETToBidNativeExpressAd extends OSETToBidNativeAd {
    private final WeakReference<Activity> activityWeakReference;
    private final WMCustomNativeAdapter adAdapter;
    private final OSETToBidNativeAd.AdListener adListener;
    private final List<WMNativeAdData> nativeAdDataList = new ArrayList();

    public OSETToBidNativeExpressAd(Activity activity, WMCustomNativeAdapter wMCustomNativeAdapter, OSETToBidNativeAd.AdListener adListener) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.adAdapter = wMCustomNativeAdapter;
        this.adListener = adListener;
    }

    @Override // com.kc.openset.third.custom.tobid.OSETToBidNativeAd
    public void destroy() {
        Iterator<WMNativeAdData> it = this.nativeAdDataList.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    @Override // com.kc.openset.third.custom.tobid.OSETToBidNativeAd
    public List<WMNativeAdData> getNativeAdDataList() {
        return this.nativeAdDataList;
    }

    @Override // com.kc.openset.third.custom.tobid.OSETToBidNativeAd
    public boolean isReady() {
        return !this.nativeAdDataList.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kc.openset.third.custom.tobid.OSETToBidNativeAd
    public void loadAd(final String str, Map<String, Object> map, Map<String, Object> map2) {
        try {
            if (this.activityWeakReference.get() != null) {
                ((OSETNative) ((OSETNative) OSETNative.getInstance().setContext(this.activityWeakReference.get())).setPosId(str)).loadAd(new OSETNativeAdLoadListener() { // from class: com.kc.openset.third.custom.tobid.OSETToBidNativeExpressAd.1
                    @Override // com.kc.openset.ad.listener.BaseAdLoadListener
                    public void onLoadFail(String str2, String str3) {
                        try {
                            if (OSETToBidNativeExpressAd.this.adListener != null) {
                                OSETToBidNativeExpressAd.this.adListener.onNativeAdFailToLoad(new WMAdapterError(Integer.parseInt(str2), str3));
                            }
                        } catch (Exception unused) {
                            OSETToBidNativeExpressAd.this.adListener.onNativeAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), str3));
                        }
                    }

                    @Override // com.kc.openset.ad.listener.OSETNativeAdLoadListener
                    public void onLoadSuccess(OSETNativeAd oSETNativeAd) {
                        if (oSETNativeAd == null) {
                            if (OSETToBidNativeExpressAd.this.adListener != null) {
                                OSETToBidNativeExpressAd.this.adListener.onNativeAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "ads is null or size be 0 " + str));
                                return;
                            }
                            return;
                        }
                        if (OSETToBidNativeExpressAd.this.activityWeakReference.get() == null) {
                            if (OSETToBidNativeExpressAd.this.adListener != null) {
                                OSETToBidNativeExpressAd.this.adListener.onNativeAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null " + str));
                                return;
                            }
                            return;
                        }
                        Iterator it = OSETToBidNativeExpressAd.this.nativeAdDataList.iterator();
                        while (it.hasNext()) {
                            ((WMNativeAdData) it.next()).destroy();
                        }
                        OSETToBidNativeExpressAd.this.nativeAdDataList.clear();
                        int ecpm = oSETNativeAd.getECPM();
                        OSETToBidNativeExpressAd.this.nativeAdDataList.add(new OSETToBidExpressAdData((Activity) OSETToBidNativeExpressAd.this.activityWeakReference.get(), oSETNativeAd, OSETToBidNativeExpressAd.this.adAdapter));
                        if (OSETToBidNativeExpressAd.this.adListener != null) {
                            OSETToBidNativeExpressAd.this.adListener.onNativeAdLoadSuccess(OSETToBidNativeExpressAd.this.nativeAdDataList, ecpm);
                        }
                    }
                });
                return;
            }
            OSETToBidNativeAd.AdListener adListener = this.adListener;
            if (adListener != null) {
                adListener.onNativeAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity空，加载失败"));
            }
        } catch (Exception e) {
            OSETToBidNativeAd.AdListener adListener2 = this.adListener;
            if (adListener2 != null) {
                adListener2.onNativeAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e.getMessage()));
            }
        }
    }

    @Override // com.kc.openset.third.custom.tobid.OSETToBidNativeAd
    public void notifyBiddingResult(boolean z, String str, Map<String, Object> map) {
        OSETNativeAd nativeExpressAd;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        double d;
        if (this.nativeAdDataList.isEmpty()) {
            return;
        }
        WMNativeAdData wMNativeAdData = this.nativeAdDataList.get(0);
        if ((wMNativeAdData instanceof OSETToBidExpressAdData) && (nativeExpressAd = ((OSETToBidExpressAdData) wMNativeAdData).getNativeExpressAd()) != null) {
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
                    nativeExpressAd.bidFail(bidAdInfo);
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
                nativeExpressAd.bidSuccess(bidAdInfo);
            } catch (Exception unused4) {
            }
        }
    }
}
