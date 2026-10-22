package com.kc.dw.platform.tradplus.splash;

import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.kc.dw.ad.w;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.splash.ISplashAd;
import com.kc.dw.core.ad.splash.SplashAdEventLoader;
import com.kc.dw.core.ad.splash.SplashAdLoadListener;
import com.kc.dw.core.ad.splash.SplashCommonAdLoader;
import com.kc.dw.core.ad.splash.SplashInteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.platform.tradplus.TradPlusInitManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.tradplus.ads.base.adapter.TPBaseAdapter;
import com.tradplus.ads.base.adapter.TPLoadAdapterListener;
import com.tradplus.ads.base.adapter.TPShowAdapterListener;
import com.tradplus.ads.base.adapter.splash.TPSplashAdapter;
import com.tradplus.ads.base.bean.TPBaseAd;
import com.tradplus.ads.base.common.TPError;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsSplashAdapter extends TPSplashAdapter {
    private static final String TAG = w.a("TradPlus_", "MsSplashAdapter");
    private boolean isBiddingLoaded;
    private TPBaseAdapter.OnC2STokenListener onC2STokenListener;
    private String placementId;
    private ISplashAd splashAd;
    private SplashCommonAdLoader splashAdLoader;

    /* JADX INFO: renamed from: com.kc.dw.platform.tradplus.splash.MsSplashAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements SplashAdLoadListener {
        public final MsSplashAdapter this$0;
        public final TPBaseAdapter.OnC2STokenListener val$onC2STokenListener;

        public AnonymousClass2(MsSplashAdapter msSplashAdapter, TPBaseAdapter.OnC2STokenListener onC2STokenListener) {
            this.this$0 = msSplashAdapter;
            this.val$onC2STokenListener = onC2STokenListener;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(ISplashAd iSplashAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            TPBaseAdapter.OnC2STokenListener onC2STokenListener = this.val$onC2STokenListener;
            if (onC2STokenListener != null) {
                onC2STokenListener.onC2SBiddingFailed(String.valueOf(adError.getCode()), adError.getMessage());
            }
            if (((TPSplashAdapter) this.this$0).mLoadAdapterListener != null) {
                TPError tPError = new TPError("Third-party network failed to provide an ad.");
                tPError.setErrorCode(String.valueOf(adError.getCode()));
                tPError.setErrorMessage(adError.getMessage());
                ((TPSplashAdapter) this.this$0).mLoadAdapterListener.loadAdapterLoadFailed(tPError);
            }
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(ISplashAd iSplashAd) {
        }

        /* JADX WARN: Code duplicated, block: B:14:0x002f A[Catch: all -> 0x0068, TryCatch #1 {all -> 0x0068, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0015, B:12:0x002b, B:14:0x002f, B:10:0x0026, B:15:0x0042, B:17:0x005d, B:19:0x0063), top: B:26:0x0002, inners: #0 }] */
        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(ISplashAd iSplashAd) {
            TPLoadAdapterListener tPLoadAdapterListener;
            double d;
            if (iSplashAd != null) {
                try {
                    if (iSplashAd.getData() != null) {
                        UUID.randomUUID().toString();
                        if (iSplashAd.getData() != null) {
                            try {
                                d = Double.parseDouble(iSplashAd.getData().getEcpm()) / 100.0d;
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
                    iSplashAd.setInteractionListener(new SplashInteractionListener(this) { // from class: com.kc.dw.platform.tradplus.splash.MsSplashAdapter.2.1
                        public final AnonymousClass2 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClicked() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPSplashAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdClicked();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClosed() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPSplashAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdClosed();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdExposure() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPSplashAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdShown();
                            }
                        }

                        @Override // com.kc.dw.core.ad.splash.SplashInteractionListener
                        public void onSkip() {
                            TPShowAdapterListener tPShowAdapterListener = ((TPSplashAdapter) this.this$1.this$0).mShowListener;
                            if (tPShowAdapterListener != null) {
                                tPShowAdapterListener.onAdSkiped();
                            }
                        }

                        @Override // com.kc.dw.core.ad.splash.SplashInteractionListener
                        public void onTick(long j) {
                        }

                        @Override // com.kc.dw.core.ad.splash.SplashInteractionListener
                        public void onTimeOver() {
                        }
                    });
                    this.this$0.splashAd = iSplashAd;
                    this.this$0.isBiddingLoaded = true;
                    if (this.this$0.isC2SBidding() || (tPLoadAdapterListener = ((TPSplashAdapter) this.this$0).mLoadAdapterListener) == null) {
                        return;
                    }
                    tPLoadAdapterListener.loadAdapterLoaded((TPBaseAd) null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
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
            TPLoadAdapterListener tPLoadAdapterListener = ((TPSplashAdapter) this).mLoadAdapterListener;
            if (tPLoadAdapterListener != null) {
                tPLoadAdapterListener.loadAdapterLoaded((TPBaseAd) null);
                return;
            }
            return;
        }
        String str = map.containsKey("appId") ? map.get("appId") : null;
        this.placementId = map.containsKey(TradPlusInitManager.PLACEMENTID) ? map.get(TradPlusInitManager.PLACEMENTID) : null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.placementId)) {
            context.getResources().getDisplayMetrics();
            SplashAdEventLoader splashAdEventLoader = new SplashAdEventLoader(context, new SsdAdSlot.Builder().setPid(this.placementId).setFetchCount(1).build(), new AnonymousClass2(this, onC2STokenListener), 5000);
            this.splashAdLoader = splashAdEventLoader;
            splashAdEventLoader.loadAd();
            return;
        }
        if (onC2STokenListener != null) {
            onC2STokenListener.onC2SBiddingFailed("", "appId or placementId is empty!");
        }
        TPLoadAdapterListener tPLoadAdapterListener2 = ((TPSplashAdapter) this).mLoadAdapterListener;
        if (tPLoadAdapterListener2 != null) {
            tPLoadAdapterListener2.loadAdapterLoadFailed(new TPError("", "appId or placementId is empty!"));
        }
    }

    public void clean() {
        this.splashAd = null;
        SplashCommonAdLoader splashCommonAdLoader = this.splashAdLoader;
        if (splashCommonAdLoader != null) {
            splashCommonAdLoader.destroy();
            this.splashAdLoader = null;
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
        return this.splashAd != null;
    }

    public void loadCustomAd(Context context, Map<String, Object> map, Map<String, String> map2) {
        TradPlusInitManager.getInstance().initSDK(context, map2, new TradPlusInitManager.InitCallback(this, context, map2) { // from class: com.kc.dw.platform.tradplus.splash.MsSplashAdapter.1
            public final MsSplashAdapter this$0;
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
                TPLoadAdapterListener tPLoadAdapterListener = ((TPSplashAdapter) this.this$0).mLoadAdapterListener;
                if (tPLoadAdapterListener != null) {
                    tPLoadAdapterListener.loadAdapterLoadFailed(new TPError("", "Configuration Error Occurred. Please check your appID and placementIDs."));
                }
            }

            @Override // com.kc.dw.platform.tradplus.TradPlusInitManager.InitCallback
            public void onSuccess() {
                MsSplashAdapter msSplashAdapter = this.this$0;
                msSplashAdapter.loadAd(this.val$context, this.val$tpParams, msSplashAdapter.onC2STokenListener);
            }
        });
    }

    public void showAd() {
        ISplashAd iSplashAd = this.splashAd;
        if (iSplashAd != null) {
            iSplashAd.showAd(((TPSplashAdapter) this).mAdContainerView);
            return;
        }
        TPShowAdapterListener tPShowAdapterListener = ((TPSplashAdapter) this).mShowListener;
        if (tPShowAdapterListener != null) {
            tPShowAdapterListener.onAdVideoError(new TPError("Didn't find valid adv.Show Failed"));
        }
    }
}
