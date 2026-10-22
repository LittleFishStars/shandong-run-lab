package com.kc.dw.gather.ks.feed;

import android.content.Context;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class KSFeedAdapter extends MsCustomRecyclerAdapter {
    private static final String TAG = "KSFeedAdapter";
    private List<KsFeedAd> expressList;
    private boolean isPreRender;
    private List<KsNativeAd> nativeList;

    private void loadExpress(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        KsAdSDK.getLoadManager().loadConfigFeedAd(new KsScene.Builder(Long.parseLong(customInfo.getPid())).adNum(ssdAdSlot.getFetchCount()).build(), new KsLoadManager.FeedAdListener(this, context) { // from class: com.kc.dw.gather.ks.feed.KSFeedAdapter.2
            public final KSFeedAdapter this$0;
            public final Context val$context;

            {
                this.this$0 = this;
                this.val$context = context;
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onError(int i, String str) {
                LogUtil.d(KSFeedAdapter.TAG, "KS onError: code=" + i + ",msg=" + str);
                this.this$0.callLoadedError(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onFeedAdLoad(List<KsFeedAd> list) {
                if (list != null) {
                    try {
                        if (list.isEmpty()) {
                            return;
                        }
                        try {
                            int ecpm = list.get(0).getECPM();
                            if (ecpm > 0) {
                                this.this$0.setEcpm(ecpm);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < list.size(); i++) {
                            arrayList.add(new KSFeedExpressAd(this.val$context, list.get(i)));
                        }
                        this.this$0.callLoadedSuccess(arrayList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    private void loadNative(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(Long.parseLong(customInfo.getPid())).adNum(ssdAdSlot.getFetchCount()).build(), new KsLoadManager.NativeAdListener(this, context) { // from class: com.kc.dw.gather.ks.feed.KSFeedAdapter.1
            public final KSFeedAdapter this$0;
            public final Context val$context;

            {
                this.this$0 = this;
                this.val$context = context;
            }

            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i, String str) {
                LogUtil.d(KSFeedAdapter.TAG, "KS onError: code=" + i + ",msg=" + str);
                this.this$0.callLoadedError(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(List<KsNativeAd> list) {
                if (list != null) {
                    try {
                        if (list.isEmpty()) {
                            return;
                        }
                        try {
                            int ecpm = list.get(0).getECPM();
                            if (ecpm > 0) {
                                this.this$0.setEcpm(ecpm);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < list.size(); i++) {
                            arrayList.add(new KSFeedNativeAd(this.val$context, list.get(i)));
                        }
                        this.this$0.callLoadedSuccess(arrayList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void destroy() {
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        if (!customInfo.isExpress()) {
            loadNative(context, ssdAdSlot, customInfo);
        } else {
            this.isPreRender = true;
            loadExpress(context, ssdAdSlot, customInfo);
        }
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.isPreRender) {
                List<KsFeedAd> list = this.expressList;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (KsFeedAd ksFeedAd : this.expressList) {
                    if (z) {
                        ksFeedAd.setBidEcpm(ksFeedAd.getECPM(), s0.a(ksFeedAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()));
                    } else {
                        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                        adExposureFailedReason.setAdnType(3);
                        adExposureFailedReason.setWinEcpm(i);
                        ksFeedAd.reportAdExposureFailed(2, adExposureFailedReason);
                    }
                }
                return;
            }
            List<KsNativeAd> list2 = this.nativeList;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            for (KsNativeAd ksNativeAd : this.nativeList) {
                if (z) {
                    ksNativeAd.setBidEcpm(ksNativeAd.getECPM(), s0.a(ksNativeAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()));
                } else {
                    AdExposureFailedReason adExposureFailedReason2 = new AdExposureFailedReason();
                    adExposureFailedReason2.setAdnType(3);
                    adExposureFailedReason2.setWinEcpm(i);
                    ksNativeAd.reportAdExposureFailed(2, adExposureFailedReason2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
