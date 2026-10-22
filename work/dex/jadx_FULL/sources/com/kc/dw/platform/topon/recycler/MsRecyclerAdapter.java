package com.kc.dw.platform.topon.recycler;

import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.recycler.RecyclerAdData;
import com.kc.dw.core.ad.recycler.RecyclerAdLoadListener;
import com.kc.dw.core.ad.recycler.RecyclerMixAdEventLoader;
import com.kc.dw.core.ad.recycler.RecyclerMixCommonAdLoader;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.platform.topon.TopOnInitManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsRecyclerAdapter extends CustomNativeAdapter {
    private RecyclerAdData adData;
    private MsExpressAd hrExpressAd;
    private MsNativeAd hrNativeAd;
    private RecyclerMixCommonAdLoader recyclerMixAdLoader;
    private String slotId;

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, Object> map, ATBiddingListener aTBiddingListener) {
        String str = (String) map.get("app_id");
        this.slotId = (String) map.get("slot_id");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.slotId)) {
            RecyclerMixAdEventLoader recyclerMixAdEventLoader = new RecyclerMixAdEventLoader(context, new SsdAdSlot.Builder().setPid(this.slotId).build(), new RecyclerAdLoadListener(this, aTBiddingListener) { // from class: com.kc.dw.platform.topon.recycler.MsRecyclerAdapter.3
                public final MsRecyclerAdapter this$0;
                public final ATBiddingListener val$biddingListener;

                {
                    this.this$0 = this;
                    this.val$biddingListener = aTBiddingListener;
                }

                @Override // com.kc.dw.core.ad.recycler.RecyclerAdLoadListener
                public void onLoadFail(AdError adError) {
                    ATBiddingListener aTBiddingListener2 = this.val$biddingListener;
                    if (aTBiddingListener2 != null) {
                        aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail(adError.getMessage()), (BaseAd) null);
                    }
                    if (((CustomNativeAdapter) this.this$0).mLoadListener != null) {
                        ((CustomNativeAdapter) this.this$0).mLoadListener.onAdLoadError(String.valueOf(adError.getCode()), adError.getMessage());
                    }
                }

                @Override // com.kc.dw.core.ad.recycler.RecyclerAdLoadListener
                public void onLoadedSuccess(List<RecyclerAdData> list) {
                    ATBiddingListener aTBiddingListener2;
                    ATBiddingResult aTBiddingResultSuccess;
                    BaseAd baseAd;
                    if (list != null) {
                        try {
                            if (list.size() > 0) {
                                this.this$0.adData = list.get(0);
                                boolean zIsNativeExpress = this.this$0.adData.isNativeExpress();
                                double d = AudioStats.AUDIO_AMPLITUDE_NONE;
                                if (zIsNativeExpress) {
                                    this.this$0.hrExpressAd = new MsExpressAd(this.this$0.adData);
                                    if (this.this$0.adData.getData() == null) {
                                        return;
                                    }
                                    String string = UUID.randomUUID().toString();
                                    if (this.this$0.adData.getData() != null) {
                                        try {
                                            d = Double.parseDouble(this.this$0.adData.getData().getEcpm()) / 100.0d;
                                        } catch (NumberFormatException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (((CustomNativeAdapter) this.this$0).mLoadListener != null) {
                                        ((CustomNativeAdapter) this.this$0).mLoadListener.onAdCacheLoaded(new BaseAd[]{this.this$0.hrExpressAd});
                                    }
                                    aTBiddingListener2 = this.val$biddingListener;
                                    if (aTBiddingListener2 == null) {
                                        return;
                                    }
                                    aTBiddingResultSuccess = ATBiddingResult.success(d, string, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB);
                                    baseAd = this.this$0.hrExpressAd;
                                } else {
                                    this.this$0.hrNativeAd = new MsNativeAd(this.this$0.adData);
                                    if (this.this$0.adData.getData() == null) {
                                        return;
                                    }
                                    String string2 = UUID.randomUUID().toString();
                                    if (this.this$0.adData.getData() != null) {
                                        try {
                                            d = Double.parseDouble(this.this$0.adData.getData().getEcpm()) / 100.0d;
                                        } catch (NumberFormatException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (((CustomNativeAdapter) this.this$0).mLoadListener != null) {
                                        ((CustomNativeAdapter) this.this$0).mLoadListener.onAdCacheLoaded(new BaseAd[]{this.this$0.hrNativeAd});
                                    }
                                    aTBiddingListener2 = this.val$biddingListener;
                                    if (aTBiddingListener2 == null) {
                                        return;
                                    }
                                    aTBiddingResultSuccess = ATBiddingResult.success(d, string2, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB);
                                    baseAd = this.this$0.hrNativeAd;
                                }
                                aTBiddingListener2.onC2SBiddingResultWithCache(aTBiddingResultSuccess, baseAd);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
            this.recyclerMixAdLoader = recyclerMixAdEventLoader;
            recyclerMixAdEventLoader.loadAd();
        } else {
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
            }
            ATCustomLoadListener aTCustomLoadListener = ((CustomNativeAdapter) this).mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", " app_id or slot_id is empty!");
            }
        }
    }

    public void destory() {
        RecyclerMixCommonAdLoader recyclerMixCommonAdLoader = this.recyclerMixAdLoader;
        if (recyclerMixCommonAdLoader != null) {
            recyclerMixCommonAdLoader.destroy();
        }
    }

    public String getNetworkName() {
        return TopOnInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.slotId;
    }

    public String getNetworkSDKVersion() {
        return AdSdk.getVersionName();
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback(this, context, map) { // from class: com.kc.dw.platform.topon.recycler.MsRecyclerAdapter.1
            public final MsRecyclerAdapter this$0;
            public final Context val$context;
            public final Map val$serverExtra;

            {
                this.this$0 = this;
                this.val$context = context;
                this.val$serverExtra = map;
            }

            public void onFail(String str) {
            }

            public void onSuccess() {
                this.this$0.loadAd(this.val$context, this.val$serverExtra, null);
            }
        });
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback(this, context, map, aTBiddingListener) { // from class: com.kc.dw.platform.topon.recycler.MsRecyclerAdapter.2
            public final MsRecyclerAdapter this$0;
            public final ATBiddingListener val$biddingListener;
            public final Context val$context;
            public final Map val$serverExtra;

            {
                this.this$0 = this;
                this.val$context = context;
                this.val$serverExtra = map;
                this.val$biddingListener = aTBiddingListener;
            }

            public void onFail(String str) {
                ATBiddingListener aTBiddingListener2 = this.val$biddingListener;
                if (aTBiddingListener2 != null) {
                    aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail(str), (BaseAd) null);
                }
            }

            public void onSuccess() {
                this.this$0.loadAd(this.val$context, this.val$serverExtra, this.val$biddingListener);
            }
        });
        return true;
    }
}
