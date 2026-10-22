package com.kc.dw.platform.tradplus.recycler;

import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.recycler.RecyclerAdData;
import com.kc.dw.core.ad.recycler.RecyclerAdLoadListener;
import com.kc.dw.core.ad.recycler.RecyclerMixAdEventLoader;
import com.kc.dw.core.ad.recycler.RecyclerMixCommonAdLoader;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.tradplus.ads.base.adapter.TPBaseAdapter;
import com.tradplus.ads.base.adapter.TPLoadAdapterListener;
import com.tradplus.ads.base.adapter.nativead.TPNativeAdapter;
import com.tradplus.ads.base.bean.TPBaseAd;
import com.tradplus.ads.base.common.TPError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsRecyclerAdapter extends TPNativeAdapter {
    private RecyclerAdData adData;
    private boolean isBiddingLoaded;
    private MsExpressAd msExpressAd;
    private MsNativeAd msNativeAd;
    private TPBaseAdapter.OnC2STokenListener onC2STokenListener;
    private String placementId;
    private RecyclerMixCommonAdLoader recyclerMixAdLoader;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isC2SBidding() {
        return this.onC2STokenListener != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, String> map, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        if (isC2SBidding() && this.isBiddingLoaded) {
            TPLoadAdapterListener tPLoadAdapterListener = ((TPNativeAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener != null) {
                RecyclerAdData recyclerAdData = this.adData;
                tPLoadAdapterListener.loadAdapterLoaded((recyclerAdData == null || !recyclerAdData.isNativeExpress()) ? this.msNativeAd : this.msExpressAd);
                return;
            }
            return;
        }
        String str = map.containsKey("appId") ? map.get("appId") : null;
        this.placementId = map.containsKey(TradPlusInitManager.PLACEMENTID) ? map.get(TradPlusInitManager.PLACEMENTID) : null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.placementId)) {
            RecyclerMixAdEventLoader recyclerMixAdEventLoader = new RecyclerMixAdEventLoader(context, new SsdAdSlot.Builder().setPid(this.placementId).build(), new RecyclerAdLoadListener(this, onC2STokenListener, context) { // from class: com.kc.dw.platform.tradplus.recycler.MsRecyclerAdapter.2
                public final MsRecyclerAdapter this$0;
                public final Context val$context;
                public final TPBaseAdapter.OnC2STokenListener val$onC2STokenListener;

                {
                    this.this$0 = this;
                    this.val$onC2STokenListener = onC2STokenListener;
                    this.val$context = context;
                }

                @Override // com.kc.dw.core.ad.recycler.RecyclerAdLoadListener
                public void onLoadFail(AdError adError) {
                    TPBaseAdapter.OnC2STokenListener onC2STokenListener2 = this.val$onC2STokenListener;
                    if (onC2STokenListener2 != null) {
                        onC2STokenListener2.onC2SBiddingFailed(String.valueOf(adError.getCode()), adError.getMessage());
                    }
                    if (((TPNativeAdapter) this.this$0).mLoadAdapterListener != null) {
                        TPError tPError = new TPError("Third-party network failed to provide an ad.");
                        tPError.setErrorCode(String.valueOf(adError.getCode()));
                        tPError.setErrorMessage(adError.getMessage());
                        ((TPNativeAdapter) this.this$0).mLoadAdapterListener.loadAdapterLoadFailed(tPError);
                    }
                }

                @Override // com.kc.dw.core.ad.recycler.RecyclerAdLoadListener
                public void onLoadedSuccess(List<RecyclerAdData> list) {
                    TPLoadAdapterListener tPLoadAdapterListener2;
                    TPBaseAd tPBaseAd;
                    if (list != null) {
                        try {
                            if (list.isEmpty()) {
                                return;
                            }
                            this.this$0.adData = list.get(0);
                            boolean zIsNativeExpress = this.this$0.adData.isNativeExpress();
                            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
                            if (zIsNativeExpress) {
                                this.this$0.msExpressAd = new MsExpressAd(this.this$0.adData);
                                if (this.this$0.adData.getData() == null) {
                                    return;
                                }
                                UUID.randomUUID().toString();
                                if (this.this$0.adData.getData() != null) {
                                    try {
                                        d = Double.parseDouble(this.this$0.adData.getData().getEcpm()) / 100.0d;
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (this.val$onC2STokenListener != null) {
                                    HashMap map2 = new HashMap();
                                    map2.put("ecpm", Double.valueOf(d));
                                    this.val$onC2STokenListener.onC2SBiddingResult(map2);
                                }
                                this.this$0.isBiddingLoaded = true;
                                if (this.this$0.isC2SBidding()) {
                                    return;
                                }
                                MsRecyclerAdapter msRecyclerAdapter = this.this$0;
                                tPLoadAdapterListener2 = ((TPNativeAdapter) msRecyclerAdapter).mLoadAdapterListener;
                                if (tPLoadAdapterListener2 == null) {
                                    return;
                                } else {
                                    tPBaseAd = msRecyclerAdapter.msExpressAd;
                                }
                            } else {
                                this.this$0.msNativeAd = new MsNativeAd(this.val$context, this.this$0.adData);
                                if (this.this$0.adData.getData() == null) {
                                    return;
                                }
                                UUID.randomUUID().toString();
                                if (this.this$0.adData.getData() != null) {
                                    try {
                                        d = Double.parseDouble(this.this$0.adData.getData().getEcpm()) / 100.0d;
                                    } catch (NumberFormatException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (this.val$onC2STokenListener != null) {
                                    HashMap map3 = new HashMap();
                                    map3.put("ecpm", Double.valueOf(d));
                                    this.val$onC2STokenListener.onC2SBiddingResult(map3);
                                }
                                this.this$0.isBiddingLoaded = true;
                                if (this.this$0.isC2SBidding()) {
                                    return;
                                }
                                MsRecyclerAdapter msRecyclerAdapter2 = this.this$0;
                                tPLoadAdapterListener2 = ((TPNativeAdapter) msRecyclerAdapter2).mLoadAdapterListener;
                                if (tPLoadAdapterListener2 == null) {
                                    return;
                                } else {
                                    tPBaseAd = msRecyclerAdapter2.msNativeAd;
                                }
                            }
                            tPLoadAdapterListener2.loadAdapterLoaded(tPBaseAd);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
            this.recyclerMixAdLoader = recyclerMixAdEventLoader;
            recyclerMixAdEventLoader.loadAd();
        } else {
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed("", "appId or placementId is empty!");
            }
            TPLoadAdapterListener tPLoadAdapterListener2 = ((TPNativeAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener2 != null) {
                tPLoadAdapterListener2.loadAdapterLoadFailed(new TPError("", "appId or placementId is empty!"));
            }
        }
    }

    public void clean() {
        MsExpressAd msExpressAd = this.msExpressAd;
        if (msExpressAd != null) {
            msExpressAd.clean();
            this.msExpressAd = null;
        }
        MsNativeAd msNativeAd = this.msNativeAd;
        if (msNativeAd != null) {
            msNativeAd.clean();
            this.msNativeAd = null;
        }
        RecyclerMixCommonAdLoader recyclerMixCommonAdLoader = this.recyclerMixAdLoader;
        if (recyclerMixCommonAdLoader != null) {
            recyclerMixCommonAdLoader.destroy();
            this.recyclerMixAdLoader = null;
        }
    }

    public void getC2SBidding(Context context, Map<String, Object> map, Map<String, String> map2, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        this.onC2STokenListener = onC2STokenListener;
        loadCustomAd(context, map, map2);
    }

    public String getNetworkName() {
        return TradPlusInitManager.getInstance().getNetworkName();
    }

    public String getNetworkVersion() {
        return AdSdk.getVersionName();
    }

    public void loadCustomAd(Context context, Map<String, Object> map, Map<String, String> map2) {
        TradPlusInitManager.getInstance().initSDK(context, map2, new TradPlusInitManager.InitCallback(this, context, map2) { // from class: com.kc.dw.platform.tradplus.recycler.MsRecyclerAdapter.1
            public final MsRecyclerAdapter this$0;
            public final Context val$context;
            public final Map val$tpParams;

            {
                this.this$0 = this;
                this.val$context = context;
                this.val$tpParams = map2;
            }

            @Override // com.kc.dw.platform.tradplus.TradPlusInitManager.InitCallback
            public void onError() {
                if (this.this$0.onC2STokenListener != null) {
                    this.this$0.onC2STokenListener.onC2SBiddingFailed("", "Configuration Error Occurred. Please check your appID and placementIDs.");
                }
                TPLoadAdapterListener tPLoadAdapterListener = ((TPNativeAdapter) this.this$0).mLoadAdapterListener;
                if (tPLoadAdapterListener != null) {
                    tPLoadAdapterListener.loadAdapterLoadFailed(new TPError("", "Configuration Error Occurred. Please check your appID and placementIDs."));
                }
            }

            @Override // com.kc.dw.platform.tradplus.TradPlusInitManager.InitCallback
            public void onSuccess() {
                MsRecyclerAdapter msRecyclerAdapter = this.this$0;
                msRecyclerAdapter.loadAd(this.val$context, this.val$tpParams, msRecyclerAdapter.onC2STokenListener);
            }
        });
    }
}
