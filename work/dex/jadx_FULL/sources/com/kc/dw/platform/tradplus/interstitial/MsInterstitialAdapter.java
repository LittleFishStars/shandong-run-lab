package com.kc.dw.platform.tradplus.interstitial;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.kc.dw.ad.w;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.interstitial.InterstitialAd;
import com.kc.dw.core.ad.interstitial.InterstitialAdEventLoader;
import com.kc.dw.core.ad.interstitial.InterstitialAdLoadListener;
import com.kc.dw.core.ad.interstitial.InterstitialCommonAdLoader;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.tradplus.ads.base.adapter.TPBaseAdapter;
import com.tradplus.ads.base.adapter.TPLoadAdapterListener;
import com.tradplus.ads.base.adapter.TPShowAdapterListener;
import com.tradplus.ads.base.adapter.interstitial.TPInterstitialAdapter;
import com.tradplus.ads.base.bean.TPBaseAd;
import com.tradplus.ads.base.common.TPError;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsInterstitialAdapter extends TPInterstitialAdapter {
    private static final String TAG = w.a("TradPlus_", "MsBannerAdapter");
    private Context context;
    private InterstitialAd interstitialAd;
    private InterstitialCommonAdLoader interstitialAdLoader;
    private boolean isBiddingLoaded;
    private TPBaseAdapter.OnC2STokenListener onC2STokenListener;
    private String placementId;

    /* JADX INFO: renamed from: com.kc.dw.platform.tradplus.interstitial.MsInterstitialAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements InterstitialAdLoadListener {
        public final MsInterstitialAdapter this$0;
        public final TPBaseAdapter.OnC2STokenListener val$onC2STokenListener;

        public AnonymousClass2(MsInterstitialAdapter msInterstitialAdapter, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
            this.this$0 = msInterstitialAdapter;
            this.val$onC2STokenListener = onC2STokenListener;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(InterstitialAd interstitialAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            TPBaseAdapter.OnC2STokenListener onC2STokenListener = this.val$onC2STokenListener;
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed(String.valueOf(adError.getCode()), adError.getMessage());
            }
            if (((TPInterstitialAdapter) this.this$0).mLoadAdapterListener != null) {
                TPError tPError = new TPError("Third-party network failed to provide an ad.");
                tPError.setErrorCode(String.valueOf(adError.getCode()));
                tPError.setErrorMessage(adError.getMessage());
                ((TPInterstitialAdapter) this.this$0).mLoadAdapterListener.loadAdapterLoadFailed(tPError);
            }
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(InterstitialAd interstitialAd) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(InterstitialAd interstitialAd) {
            TPLoadAdapterListener tPLoadAdapterListener;
            try {
                this.this$0.interstitialAd = interstitialAd;
                if (this.this$0.interstitialAd != null) {
                    if (this.this$0.interstitialAd.getData() != null) {
                        UUID.randomUUID().toString();
                        ResultBean data = this.this$0.interstitialAd.getData();
                        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
                        if (data != null) {
                            try {
                                d = Double.parseDouble(this.this$0.interstitialAd.getData().getEcpm()) / 100.0d;
                                LogUtil.d(MsInterstitialAdapter.TAG, "price=" + d);
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                        if (this.val$onC2STokenListener != null) {
                            HashMap map = new HashMap();
                            map.put("ecpm", Double.valueOf(d));
                            this.val$onC2STokenListener.onC2SBiddingResult(map);
                        }
                    }
                    this.this$0.interstitialAd.setInteractionListener(new InteractionListener(this) { // from class: com.kc.dw.platform.tradplus.interstitial.MsInterstitialAdapter.2.1
                        public final AnonymousClass2 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClicked() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPInterstitialAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdClicked();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClosed() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPInterstitialAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdClosed();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdExposure() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPInterstitialAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdShown();
                            }
                        }
                    });
                    this.this$0.isBiddingLoaded = true;
                    if (this.this$0.isC2SBidding() || (tPLoadAdapterListener = ((TPInterstitialAdapter) this.this$0).mLoadAdapterListener) == null) {
                        return;
                    }
                    tPLoadAdapterListener.loadAdapterLoaded((TPBaseAd) null);
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
            TPLoadAdapterListener tPLoadAdapterListener = ((TPInterstitialAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener != null) {
                tPLoadAdapterListener.loadAdapterLoaded((TPBaseAd) null);
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
            TPLoadAdapterListener tPLoadAdapterListener2 = ((TPInterstitialAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener2 != null) {
                tPLoadAdapterListener2.loadAdapterLoadFailed(new TPError("", "appId or placementId is empty!"));
                return;
            }
            return;
        }
        if (context instanceof Activity) {
            InterstitialAdEventLoader interstitialAdEventLoader = new InterstitialAdEventLoader((Activity) context, new SsdAdSlot.Builder().setPid(this.placementId).setIsClickToClose(false).build(), new AnonymousClass2(this, onC2STokenListener));
            this.interstitialAdLoader = interstitialAdEventLoader;
            interstitialAdEventLoader.loadAd();
        } else {
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed("", "load error");
            }
            TPLoadAdapterListener tPLoadAdapterListener3 = ((TPInterstitialAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener3 != null) {
                tPLoadAdapterListener3.loadAdapterLoadFailed(new TPError("", "Context must be activity."));
            }
        }
    }

    public void clean() {
        super.clean();
        this.interstitialAd = null;
        InterstitialCommonAdLoader interstitialCommonAdLoader = this.interstitialAdLoader;
        if (interstitialCommonAdLoader != null) {
            interstitialCommonAdLoader.destroy();
            this.interstitialAdLoader = null;
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
        return this.interstitialAd != null;
    }

    public void loadCustomAd(Context context, Map<String, Object> map, Map<String, String> map2) {
        this.context = context;
        TradPlusInitManager.getInstance().initSDK(context, map2, new TradPlusInitManager.InitCallback(this, context, map2) { // from class: com.kc.dw.platform.tradplus.interstitial.MsInterstitialAdapter.1
            public final MsInterstitialAdapter this$0;
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
                TPLoadAdapterListener tPLoadAdapterListener = ((TPInterstitialAdapter) this.this$0).mLoadAdapterListener;
                if (tPLoadAdapterListener != null) {
                    tPLoadAdapterListener.loadAdapterLoadFailed(new TPError("", "Configuration Error Occurred. Please check your appID and placementIDs."));
                }
            }

            @Override // com.kc.dw.platform.tradplus.TradPlusInitManager.InitCallback
            public void onSuccess() {
                MsInterstitialAdapter msInterstitialAdapter = this.this$0;
                msInterstitialAdapter.loadAd(this.val$context, this.val$tpParams, msInterstitialAdapter.onC2STokenListener);
            }
        });
    }

    public void showAd() {
        try {
            InterstitialAd interstitialAd = this.interstitialAd;
            if (interstitialAd != null) {
                interstitialAd.showAd((Activity) this.context);
            } else {
                TPShowAdapterListener tPShowAdapterListener = ((TPInterstitialAdapter) this).mShowListener;
                if (tPShowAdapterListener != null) {
                    tPShowAdapterListener.onAdVideoError(new TPError("Didn't find valid adv.Show Failed"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
