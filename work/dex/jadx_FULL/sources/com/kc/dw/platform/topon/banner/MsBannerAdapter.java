package com.kc.dw.platform.topon.banner;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.camera.video.AudioStats;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.banner.BannerAdEventLoader;
import com.kc.dw.core.ad.banner.BannerAdLoadListener;
import com.kc.dw.core.ad.banner.BannerCommonAdLoader;
import com.kc.dw.core.ad.banner.IBannerAd;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.topon.TopOnInitManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsBannerAdapter extends CustomBannerAdapter {
    private static final String TAG = "MsBannerAdapter";
    private BannerCommonAdLoader bannerAdLoader;
    private IBannerAd iBannerAd;
    private RelativeLayout mBannerView;
    private String slotId;

    /* JADX INFO: renamed from: com.kc.dw.platform.topon.banner.MsBannerAdapter$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements BannerAdLoadListener {
        public final MsBannerAdapter this$0;
        public final ATBiddingListener val$biddingListener;
        public final Context val$context;

        public AnonymousClass3(MsBannerAdapter msBannerAdapter, ATBiddingListener aTBiddingListener, Context context) {
            this.this$0 = msBannerAdapter;
            this.val$biddingListener = aTBiddingListener;
            this.val$context = context;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(IBannerAd iBannerAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            ATBiddingListener aTBiddingListener = this.val$biddingListener;
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
            }
            if (((CustomBannerAdapter) this.this$0).mLoadListener != null) {
                ((CustomBannerAdapter) this.this$0).mLoadListener.onAdLoadError(String.valueOf(adError.getCode()), adError.getMessage());
            }
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(IBannerAd iBannerAd) {
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0035 A[Catch: all -> 0x0071, TryCatch #0 {all -> 0x0071, blocks: (B:2:0x0000, B:4:0x0007, B:6:0x000d, B:8:0x001b, B:13:0x0031, B:15:0x0035, B:11:0x002c, B:16:0x003f, B:18:0x0064), top: B:23:0x0000, inners: #1 }] */
        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(IBannerAd iBannerAd) {
            double d;
            ATBiddingListener aTBiddingListener;
            try {
                this.this$0.iBannerAd = iBannerAd;
                if (iBannerAd != null) {
                    if (iBannerAd.getData() != null) {
                        String string = UUID.randomUUID().toString();
                        if (iBannerAd.getData() != null) {
                            try {
                                d = Double.parseDouble(iBannerAd.getData().getEcpm()) / 100.0d;
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                d = AudioStats.AUDIO_AMPLITUDE_NONE;
                            }
                            aTBiddingListener = this.val$biddingListener;
                            if (aTBiddingListener != null) {
                                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, string, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                            }
                        } else {
                            d = AudioStats.AUDIO_AMPLITUDE_NONE;
                            aTBiddingListener = this.val$biddingListener;
                            if (aTBiddingListener != null) {
                                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d, string, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), (BaseAd) null);
                            }
                        }
                    }
                    iBannerAd.setInteractionListener(new InteractionListener(this) { // from class: com.kc.dw.platform.topon.banner.MsBannerAdapter.3.1
                        public final AnonymousClass3 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClicked() {
                            if (((CustomBannerAdapter) this.this$1.this$0).mImpressionEventListener != null) {
                                ((CustomBannerAdapter) this.this$1.this$0).mImpressionEventListener.onBannerAdClicked();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClosed() {
                            if (((CustomBannerAdapter) this.this$1.this$0).mImpressionEventListener != null) {
                                ((CustomBannerAdapter) this.this$1.this$0).mImpressionEventListener.onBannerAdClose();
                            }
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdExposure() {
                            if (((CustomBannerAdapter) this.this$1.this$0).mImpressionEventListener != null) {
                                ((CustomBannerAdapter) this.this$1.this$0).mImpressionEventListener.onBannerAdShow();
                            }
                        }
                    });
                    this.this$0.mBannerView = new RelativeLayout(this.val$context);
                    iBannerAd.showAd(this.this$0.mBannerView);
                    if (((CustomBannerAdapter) this.this$0).mLoadListener != null) {
                        ((CustomBannerAdapter) this.this$0).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context, Map<String, Object> map, ATBiddingListener aTBiddingListener) {
        String str = (String) map.get("app_id");
        this.slotId = (String) map.get("slot_id");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.slotId)) {
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
            }
            ATCustomLoadListener aTCustomLoadListener = ((CustomBannerAdapter) this).mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", "app_id or slot_id is empty!");
                return;
            }
            return;
        }
        if (context instanceof Activity) {
            BannerAdEventLoader bannerAdEventLoader = new BannerAdEventLoader((Activity) context, new SsdAdSlot.Builder().setPid(this.slotId).build(), new AnonymousClass3(this, aTBiddingListener, context));
            this.bannerAdLoader = bannerAdEventLoader;
            bannerAdEventLoader.loadAd();
            return;
        }
        if (aTBiddingListener != null) {
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("load error"), (BaseAd) null);
        }
        ATCustomLoadListener aTCustomLoadListener2 = ((CustomBannerAdapter) this).mLoadListener;
        if (aTCustomLoadListener2 != null) {
            aTCustomLoadListener2.onAdLoadError("", "Context must be activity.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBid(Context context, Map<String, Object> map, ATBiddingListener aTBiddingListener) {
        LogUtil.d(TAG, "startBid");
        loadAd(context, map, aTBiddingListener);
    }

    public void destory() {
        this.mBannerView = null;
        BannerCommonAdLoader bannerCommonAdLoader = this.bannerAdLoader;
        if (bannerCommonAdLoader != null) {
            bannerCommonAdLoader.destroy();
            this.iBannerAd = null;
        }
    }

    public View getBannerView() {
        return this.mBannerView;
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

    public boolean isAdReady() {
        IBannerAd iBannerAd = this.iBannerAd;
        return iBannerAd != null && iBannerAd.isAdValid();
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback(this, context, map) { // from class: com.kc.dw.platform.topon.banner.MsBannerAdapter.1
            public final MsBannerAdapter this$0;
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
        TopOnInitManager.getInstance().initSDK(context, map, new MediationInitCallback(this, context, map, aTBiddingListener) { // from class: com.kc.dw.platform.topon.banner.MsBannerAdapter.2
            public final MsBannerAdapter this$0;
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
                this.this$0.startBid(this.val$context, this.val$serverExtra, this.val$biddingListener);
            }
        });
        return true;
    }
}
