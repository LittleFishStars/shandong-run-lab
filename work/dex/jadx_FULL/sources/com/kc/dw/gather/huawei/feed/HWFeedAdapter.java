package com.kc.dw.gather.huawei.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.AdCloseBtnClickListener;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdLoader;
import com.huawei.hms.ads.nativead.NativeView;
import com.kc.dw.core.ad.IAd;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.recycler.FeedAd;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HWFeedAdapter extends MsCustomRecyclerAdapter {
    private static final int TEMPLATE_AD = 99;
    private NativeAd mNativeAd;

    /* JADX INFO: renamed from: com.kc.dw.gather.huawei.feed.HWFeedAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements NativeAd.NativeAdLoadedListener {
        public final HWFeedAdapter this$0;
        public final Context val$context;
        public final List val$hwAdDatas;

        public AnonymousClass2(HWFeedAdapter hWFeedAdapter, Context context, List list) {
            this.this$0 = hWFeedAdapter;
            this.val$context = context;
            this.val$hwAdDatas = list;
        }

        public void onNativeAdLoaded(NativeAd nativeAd) {
            IAd hWNativeAd;
            this.this$0.mNativeAd = nativeAd;
            if (nativeAd != null) {
                BiddingInfo biddingInfo = nativeAd.getBiddingInfo();
                try {
                    if (this.this$0.getSdkAdInfo() != null && biddingInfo != null) {
                        this.this$0.getSdkAdInfo().setEcpm(String.valueOf((int) (biddingInfo.getPrice().floatValue() * 100.0f)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (nativeAd.getCreativeType() == 99) {
                    hWNativeAd = new HWExpressAd(nativeAd);
                    View nativeView = new NativeView(this.val$context);
                    nativeView.setAdCloseBtnClickListener(new AdCloseBtnClickListener(this) { // from class: com.kc.dw.gather.huawei.feed.HWFeedAdapter.2.1
                        public final AnonymousClass2 this$1;

                        {
                            this.this$1 = this;
                        }

                        public void onCloseBtnClick() {
                            HWExpressAd hWExpressAd = (HWExpressAd) this.this$1.val$hwAdDatas.get(0);
                            try {
                                View adView = hWExpressAd.getAdView();
                                if (adView != null && adView.getParent() != null) {
                                    ((ViewGroup) adView.getParent()).removeView(adView);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            hWExpressAd.callAdClosed();
                        }
                    });
                    nativeView.setNativeAd(nativeAd);
                    hWNativeAd.setAdView(nativeView);
                } else {
                    hWNativeAd = new HWNativeAd(nativeAd);
                }
                this.val$hwAdDatas.add(hWNativeAd);
                this.this$0.callLoadedSuccess(this.val$hwAdDatas);
            }
        }
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        NativeAdLoader.Builder builder = new NativeAdLoader.Builder(getContext(), getSdkAdInfo().getPid());
        ArrayList arrayList = new ArrayList();
        builder.setNativeAdLoadedListener(new AnonymousClass2(this, context, arrayList)).setAdListener(new AdListener(this, arrayList) { // from class: com.kc.dw.gather.huawei.feed.HWFeedAdapter.1
            public final HWFeedAdapter this$0;
            public final List val$hwAdDatas;

            {
                this.this$0 = this;
                this.val$hwAdDatas = arrayList;
            }

            public void onAdClicked() {
                if (this.val$hwAdDatas != null) {
                    for (int i = 0; i < this.val$hwAdDatas.size(); i++) {
                        FeedAd feedAd = (FeedAd) this.val$hwAdDatas.get(i);
                        if (feedAd instanceof HWExpressAd) {
                            ((HWExpressAd) feedAd).callAdClicked();
                        } else if (feedAd instanceof HWNativeAd) {
                            ((HWNativeAd) feedAd).callAdClicked();
                        }
                    }
                }
            }

            public void onAdClosed() {
            }

            public void onAdFailed(int i) {
                this.this$0.callLoadedError(i, "load error");
            }

            public void onAdImpression() {
                if (this.val$hwAdDatas != null) {
                    for (int i = 0; i < this.val$hwAdDatas.size(); i++) {
                        FeedAd feedAd = (FeedAd) this.val$hwAdDatas.get(i);
                        if (feedAd instanceof HWExpressAd) {
                            ((HWExpressAd) feedAd).callAdExposure();
                        } else if (feedAd instanceof HWNativeAd) {
                            ((HWNativeAd) feedAd).callAdExposure();
                        }
                    }
                }
            }

            public void onAdLoaded() {
            }
        });
        NativeAdLoader nativeAdLoaderBuild = builder.build();
        AdParam.Builder builder2 = new AdParam.Builder();
        if (this.sdkAdInfo.getIs_bidding() == 1) {
            try {
                builder2.addBiddingParamMap(getSdkAdInfo().getPid(), new BiddingParam.Builder().setBidFloor(Float.valueOf(getSdkAdInfo().getPrice() / 100.0f)).setBidFloorCur("CNY").build());
            } catch (Exception e) {
                e.printStackTrace();
            }
            builder2.setTMax(3000);
        }
        builder2.setSupportTemplate(true);
        nativeAdLoaderBuild.loadAd(builder2.build());
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        BiddingInfo biddingInfo;
        try {
            NativeAd nativeAd = this.mNativeAd;
            if (nativeAd != null && (biddingInfo = nativeAd.getBiddingInfo()) != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("SECOND_PRICE", Float.valueOf((s0.a((int) (biddingInfo.getPrice().floatValue() * 100.0f), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()) * 1.0f) / 100.0f));
                    map.put("AUCTION_CURRENCY", "CNY");
                    this.mNativeAd.sendBiddingSuccess(map, new ReportUrlListener(this) { // from class: com.kc.dw.gather.huawei.feed.HWFeedAdapter.3
                        public final HWFeedAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void reportFailed(String str, int i2) {
                        }

                        public void reportSuccess() {
                        }
                    });
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("AUCTION_PRICE", Float.valueOf((i * 1.0f) / 100.0f));
                    map2.put("AUCTION_CURRENCY", "CNY");
                    map2.put("AUCTION_LOSS", 102);
                    map2.put("AUCTION_CP_ID", "100");
                    this.mNativeAd.sendBiddingFailed(map2, new ReportUrlListener(this) { // from class: com.kc.dw.gather.huawei.feed.HWFeedAdapter.4
                        public final HWFeedAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void reportFailed(String str, int i2) {
                        }

                        public void reportSuccess() {
                        }
                    });
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
