package com.kc.dw.gather.bd.feed;

import android.content.Context;
import android.util.DisplayMetrics;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BDFeedAdapter extends MsCustomRecyclerAdapter {
    private static final String TAG = "BDFeedAdapter";
    private List<ExpressResponse> expressList;
    private boolean isPreRender;
    private List<NativeResponse> nativeList;

    private void expressBiddingResult(boolean z, int i, ExpressResponse expressResponse) {
        int i2 = 1;
        try {
            Class<?> cls = Class.forName("com.baidu.mobads.sdk.api.ExpressResponse");
            if (z) {
                cls.getDeclaredMethod("biddingSuccess", String.class).invoke(expressResponse, String.valueOf(s0.a(Integer.parseInt(expressResponse.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
            } else {
                cls.getDeclaredMethod("biddingFail", String.class).invoke(expressResponse, "203");
            }
        } catch (Throwable unused) {
            try {
                if (z) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("ecpm", Integer.valueOf(s0.a(Integer.parseInt(expressResponse.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap.put("bid_t", 1);
                    expressResponse.biddingSuccess(linkedHashMap, new BiddingListener(this) { // from class: com.kc.dw.gather.bd.feed.BDFeedAdapter.3
                        public final BDFeedAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("ecpm", Integer.valueOf(i));
                    int iNextInt = new Random().nextInt(10);
                    if (iNextInt != 0) {
                        i2 = iNextInt;
                    }
                    linkedHashMap2.put("adn", Integer.valueOf(i2));
                    linkedHashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap2.put("bid_t", 3);
                    linkedHashMap2.put(MediationConstant.KEY_REASON, "203");
                    expressResponse.biddingFail(linkedHashMap2, new BiddingListener(this) { // from class: com.kc.dw.gather.bd.feed.BDFeedAdapter.4
                        public final BDFeedAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private void loadExpress(Context context, CustomInfo customInfo) {
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        new BaiduNativeManager(context.getApplicationContext(), customInfo.getPid()).loadExpressAd(new RequestParameters.Builder().setWidth((int) ((((getAdLoader().getAccept_ad_width() == null || getAdLoader().getAccept_ad_width().intValue() <= 0) ? displayMetrics.widthPixels : getAdLoader().getAccept_ad_width().intValue()) / displayMetrics.density) * displayMetrics.density)).setHeight((int) (((getAdLoader().getAccept_ad_height() == null || getAdLoader().getAccept_ad_height().intValue() <= 0) ? 0.0f : getAdLoader().getAccept_ad_height().intValue() / displayMetrics.density) * displayMetrics.density)).downloadAppConfirmPolicy(2).build(), new BaiduNativeManager.ExpressAdListener(this) { // from class: com.kc.dw.gather.bd.feed.BDFeedAdapter.1
            public final BDFeedAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onLpClosed() {
            }

            public void onNativeFail(int i, String str, ExpressResponse expressResponse) {
                LogUtil.d(BDFeedAdapter.TAG, "i=" + i + ",s=" + str);
                this.this$0.callLoadedError(i, str);
            }

            public void onNativeLoad(List<ExpressResponse> list) {
                this.this$0.expressList = list;
                if (list != null) {
                    try {
                        if (list.isEmpty()) {
                            return;
                        }
                        try {
                            int i = Integer.parseInt(list.get(0).getECPMLevel());
                            if (i > 0) {
                                this.this$0.setEcpm(i);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            arrayList.add(new BDFeedExpressAd(list.get(i2)));
                        }
                        this.this$0.callLoadedSuccess(arrayList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void onNoAd(int i, String str, ExpressResponse expressResponse) {
                this.this$0.callLoadedError(i, str);
            }

            public void onVideoDownloadFailed() {
            }

            public void onVideoDownloadSuccess() {
            }
        });
    }

    private void loadNative(Context context, CustomInfo customInfo) {
        new BaiduNativeManager(context.getApplicationContext(), customInfo.getPid()).loadFeedAd(new RequestParameters.Builder().build(), new BaiduNativeManager.FeedAdListener(this, context) { // from class: com.kc.dw.gather.bd.feed.BDFeedAdapter.2
            public final BDFeedAdapter this$0;
            public final Context val$context;

            {
                this.this$0 = this;
                this.val$context = context;
            }

            public void onLpClosed() {
            }

            public void onNativeFail(int i, String str, NativeResponse nativeResponse) {
                LogUtil.d(BDFeedAdapter.TAG, "onNativeFail: code=" + i + ",msg=" + str);
                this.this$0.callLoadedError(i, str);
            }

            public void onNativeLoad(List<NativeResponse> list) {
                this.this$0.nativeList = list;
                try {
                    LogUtil.d(BDFeedAdapter.TAG, "BD onNativeLoad");
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    try {
                        int i = Integer.parseInt(list.get(0).getECPMLevel());
                        if (i > 0) {
                            this.this$0.setEcpm(i);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        arrayList.add(new BDFeedNativeAd(this.val$context, list.get(i2)));
                    }
                    this.this$0.callLoadedSuccess(arrayList);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            public void onNoAd(int i, String str, NativeResponse nativeResponse) {
                LogUtil.d(BDFeedAdapter.TAG, "onNoAd: code=" + i + ",msg=" + str);
                this.this$0.callLoadedError(i, str);
            }

            public void onVideoDownloadFailed() {
            }

            public void onVideoDownloadSuccess() {
            }
        });
    }

    private void nativeBiddingResult(boolean z, int i, NativeResponse nativeResponse) {
        int i2 = 1;
        try {
            Class<?> cls = Class.forName("com.baidu.mobads.sdk.api.NativeResponse");
            if (z) {
                cls.getDeclaredMethod("biddingSuccess", String.class).invoke(nativeResponse, String.valueOf(s0.a(Integer.parseInt(nativeResponse.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
            } else {
                cls.getDeclaredMethod("biddingFail", String.class).invoke(nativeResponse, "203");
            }
        } catch (Throwable unused) {
            try {
                if (z) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("ecpm", Integer.valueOf(s0.a(Integer.parseInt(nativeResponse.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap.put("bid_t", 1);
                    nativeResponse.biddingSuccess(linkedHashMap, new BiddingListener(this) { // from class: com.kc.dw.gather.bd.feed.BDFeedAdapter.5
                        public final BDFeedAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("ecpm", Integer.valueOf(i));
                    int iNextInt = new Random().nextInt(10);
                    if (iNextInt != 0) {
                        i2 = iNextInt;
                    }
                    linkedHashMap2.put("adn", Integer.valueOf(i2));
                    linkedHashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap2.put("bid_t", 3);
                    linkedHashMap2.put(MediationConstant.KEY_REASON, "203");
                    nativeResponse.biddingFail(linkedHashMap2, new BiddingListener(this) { // from class: com.kc.dw.gather.bd.feed.BDFeedAdapter.6
                        public final BDFeedAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                }
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        if (!customInfo.isExpress()) {
            loadNative(context, customInfo);
        } else {
            this.isPreRender = true;
            loadExpress(context, customInfo);
        }
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.isPreRender) {
                List<ExpressResponse> list = this.expressList;
                if (list != null) {
                    Iterator<ExpressResponse> it = list.iterator();
                    while (it.hasNext()) {
                        expressBiddingResult(z, i, it.next());
                    }
                    return;
                }
                return;
            }
            List<NativeResponse> list2 = this.nativeList;
            if (list2 != null) {
                Iterator<NativeResponse> it2 = list2.iterator();
                while (it2.hasNext()) {
                    nativeBiddingResult(z, i, it2.next());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
