package com.kc.dw.platform.tradplus.banner;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.kc.dw.ad.w;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.banner.BannerAdEventLoader;
import com.kc.dw.core.ad.banner.BannerAdLoadListener;
import com.kc.dw.core.ad.banner.BannerCommonAdLoader;
import com.kc.dw.core.ad.banner.IBannerAd;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.platform.ad_adapter.banner.a;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.tradplus.ads.base.adapter.TPBaseAdapter;
import com.tradplus.ads.base.adapter.TPLoadAdapterListener;
import com.tradplus.ads.base.adapter.banner.TPBannerAdapter;
import com.tradplus.ads.base.common.TPError;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsBannerAdapter extends TPBannerAdapter {
    private static final String TAG = w.a("TradPlus_", "MsBannerAdapter");
    private BannerCommonAdLoader bannerAdLoader;
    private IBannerAd iBannerAd;
    private boolean isBiddingLoaded;
    private FrameLayout mBannerView;
    private MSBannerAdImpl mTpBannerAd;
    private TPBaseAdapter.OnC2STokenListener onC2STokenListener;
    private String placementId;

    /* JADX INFO: renamed from: com.kc.dw.platform.tradplus.banner.MsBannerAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements BannerAdLoadListener {
        public final MsBannerAdapter this$0;
        public final TPBaseAdapter.OnC2STokenListener val$onC2STokenListener;

        public AnonymousClass2(MsBannerAdapter msBannerAdapter, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
            this.this$0 = msBannerAdapter;
            this.val$onC2STokenListener = onC2STokenListener;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(IBannerAd iBannerAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            TPBaseAdapter.OnC2STokenListener onC2STokenListener = this.val$onC2STokenListener;
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed(String.valueOf(adError.getCode()), adError.getMessage());
            }
            if (((TPBannerAdapter) this.this$0).mLoadAdapterListener != null) {
                TPError tPError = new TPError("Third-party network failed to provide an ad.");
                tPError.setErrorCode(String.valueOf(adError.getCode()));
                tPError.setErrorMessage(adError.getMessage());
                ((TPBannerAdapter) this.this$0).mLoadAdapterListener.loadAdapterLoadFailed(tPError);
            }
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(IBannerAd iBannerAd) {
        }

        /* JADX WARN: Code duplicated, block: B:15:0x004c A[Catch: all -> 0x00ae, TryCatch #1 {all -> 0x00ae, blocks: (B:2:0x0000, B:4:0x000d, B:6:0x0019, B:8:0x002c, B:13:0x0048, B:15:0x004c, B:11:0x0043, B:16:0x005f, B:18:0x00a0, B:20:0x00a6), top: B:27:0x0000, inners: #0 }] */
        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(IBannerAd iBannerAd) {
            double d;
            try {
                this.this$0.iBannerAd = iBannerAd;
                if (this.this$0.iBannerAd != null) {
                    if (this.this$0.iBannerAd.getData() != null) {
                        UUID.randomUUID().toString();
                        if (this.this$0.iBannerAd.getData() != null) {
                            try {
                                d = Double.parseDouble(this.this$0.iBannerAd.getData().getEcpm()) / 100.0d;
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                d = AudioStats.AUDIO_AMPLITUDE_NONE;
                            }
                            if (this.val$onC2STokenListener != null) {
                                HashMap map = new HashMap();
                                map.put("ecpm", Double.valueOf(d));
                                this.val$onC2STokenListener.onC2SBiddingResult(map);
                            }
                        } else {
                            d = AudioStats.AUDIO_AMPLITUDE_NONE;
                            if (this.val$onC2STokenListener != null) {
                                HashMap map2 = new HashMap();
                                map2.put("ecpm", Double.valueOf(d));
                                this.val$onC2STokenListener.onC2SBiddingResult(map2);
                            }
                        }
                    }
                    this.this$0.mTpBannerAd = new MSBannerAdImpl(null, this.this$0.mBannerView);
                    this.this$0.iBannerAd.showAd(this.this$0.mBannerView);
                    this.this$0.setMsData();
                    this.this$0.iBannerAd.setInteractionListener(new InteractionListener(this) { // from class: com.kc.dw.platform.tradplus.banner.MsBannerAdapter.2.1
                        public final AnonymousClass2 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClicked() {
                            if (this.this$1.this$0.mTpBannerAd != null) {
                                this.this$1.this$0.mTpBannerAd.adClicked();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClosed() {
                            if (this.this$1.this$0.mTpBannerAd != null) {
                                this.this$1.this$0.mTpBannerAd.adClosed();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdExposure() {
                            if (this.this$1.this$0.mTpBannerAd != null) {
                                this.this$1.this$0.mTpBannerAd.adShown();
                            }
                        }
                    });
                    this.this$0.isBiddingLoaded = true;
                    if (this.this$0.isC2SBidding()) {
                        return;
                    }
                    MsBannerAdapter msBannerAdapter = this.this$0;
                    TPLoadAdapterListener tPLoadAdapterListener = ((TPBannerAdapter) msBannerAdapter).mLoadAdapterListener;
                    if (tPLoadAdapterListener != null) {
                        tPLoadAdapterListener.loadAdapterLoaded(msBannerAdapter.mTpBannerAd);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isC2SBidding() {
        return this.onC2STokenListener != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, String> map, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
        if (isC2SBidding() && this.isBiddingLoaded) {
            TPLoadAdapterListener tPLoadAdapterListener = ((TPBannerAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener != null) {
                tPLoadAdapterListener.loadAdapterLoaded(this.mTpBannerAd);
                return;
            }
            return;
        }
        String str = map.containsKey("appId") ? map.get("appId") : null;
        this.placementId = map.containsKey(TradPlusInitManager.PLACEMENTID) ? map.get(TradPlusInitManager.PLACEMENTID) : null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.placementId)) {
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed("", "appId or placementId is empty!");
            }
            TPLoadAdapterListener tPLoadAdapterListener2 = ((TPBannerAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener2 != null) {
                tPLoadAdapterListener2.loadAdapterLoadFailed(new TPError("", "appId or placementId is empty!"));
                return;
            }
            return;
        }
        if (context instanceof Activity) {
            this.mBannerView = new FrameLayout(context);
            BannerAdEventLoader bannerAdEventLoader = new BannerAdEventLoader((Activity) context, new SsdAdSlot.Builder().setPid(this.placementId).build(), new AnonymousClass2(this, onC2STokenListener));
            this.bannerAdLoader = bannerAdEventLoader;
            bannerAdEventLoader.loadAd();
            return;
        }
        if (onC2STokenListener != null) {
            onC2STokenListener.onC2SBiddingFailed("", "load error");
        }
        TPLoadAdapterListener tPLoadAdapterListener3 = ((TPBannerAdapter) this).mLoadAdapterListener;
        if (tPLoadAdapterListener3 != null) {
            tPLoadAdapterListener3.loadAdapterLoadFailed(new TPError("", "Context must be activity."));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMsData() {
        try {
            IBannerAd iBannerAd = this.iBannerAd;
            if (iBannerAd instanceof a) {
                AdSlot adSlot = ((a) iBannerAd).f39452a;
                if (adSlot instanceof BaseAdSlot) {
                    this.mTpBannerAd.setMsData(((BaseAdSlot) adSlot).getPosId(), ((BaseAdSlot) adSlot).getLoadedTime(), ((BaseAdSlot) adSlot).getEventUrl());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clean() {
        this.mBannerView = null;
        this.iBannerAd = null;
        BannerCommonAdLoader bannerCommonAdLoader = this.bannerAdLoader;
        if (bannerCommonAdLoader != null) {
            bannerCommonAdLoader.destroy();
            this.bannerAdLoader = null;
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

    public boolean isReady() {
        return this.iBannerAd != null;
    }

    public void loadCustomAd(Context context, Map<String, Object> map, Map<String, String> map2) {
        TradPlusInitManager.getInstance().initSDK(context, map2, new TradPlusInitManager.InitCallback(this, context, map2) { // from class: com.kc.dw.platform.tradplus.banner.MsBannerAdapter.1
            public final MsBannerAdapter this$0;
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
                TPLoadAdapterListener tPLoadAdapterListener = ((TPBannerAdapter) this.this$0).mLoadAdapterListener;
                if (tPLoadAdapterListener != null) {
                    tPLoadAdapterListener.loadAdapterLoadFailed(new TPError("", "Configuration Error Occurred. Please check your appID and placementIDs."));
                }
            }

            @Override // com.kc.dw.platform.tradplus.TradPlusInitManager.InitCallback
            public void onSuccess() {
                MsBannerAdapter msBannerAdapter = this.this$0;
                msBannerAdapter.loadAd(this.val$context, this.val$tpParams, msBannerAdapter.onC2STokenListener);
            }
        });
    }
}
