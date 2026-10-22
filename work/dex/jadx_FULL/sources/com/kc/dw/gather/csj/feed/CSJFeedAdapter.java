package com.kc.dw.gather.csj.feed;

import android.content.Context;
import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CSJFeedAdapter extends MsCustomRecyclerAdapter {
    private static final String TAG = "CSJFeedAdapter";

    private void loadExpress(Context context, AdSlot adSlot) {
        TTAdSdk.getAdManager().createAdNative(context.getApplicationContext()).loadNativeExpressAd(adSlot, new TTAdNative.NativeExpressAdListener(this) { // from class: com.kc.dw.gather.csj.feed.CSJFeedAdapter.2
            public final CSJFeedAdapter this$0;

            {
                this.this$0 = this;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                LogUtil.d(CSJFeedAdapter.TAG, "CSJ onError: code=" + i + ",msg=" + str);
                this.this$0.callLoadedError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                if (list != null) {
                    try {
                        if (list.isEmpty()) {
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < list.size(); i++) {
                            arrayList.add(new CSJFeedExpressAd(list.get(i)));
                        }
                        this.this$0.callLoadedSuccess(arrayList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void loadNative(Context context, AdSlot adSlot) {
        TTAdSdk.getAdManager().createAdNative(context.getApplicationContext()).loadFeedAd(adSlot, new TTAdNative.FeedAdListener(this) { // from class: com.kc.dw.gather.csj.feed.CSJFeedAdapter.1
            public final CSJFeedAdapter this$0;

            {
                this.this$0 = this;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int i, String str) {
                LogUtil.d(CSJFeedAdapter.TAG, "CSJ native onError,code=" + i + ",msg=" + str);
                this.this$0.callLoadedError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (list == null || list.isEmpty()) {
                    return;
                }
                LogUtil.d(CSJFeedAdapter.TAG, "onFeedAdLoad");
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add(new CSJFeedNativeAd(list.get(i)));
                }
                this.this$0.callLoadedSuccess(arrayList);
            }
        });
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        int width = ssdAdSlot.getWidth();
        int height = ssdAdSlot.getHeight();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (width <= 0) {
            width = (int) (displayMetrics.widthPixels / displayMetrics.density);
        }
        if (height < 0) {
            height = 0;
        }
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(customInfo.getPid()).setSupportDeepLink(true).setImageAcceptedSize(720, 1080).setExpressViewAcceptedSize(width, height).setAdCount(ssdAdSlot.getFetchCount()).build();
        if (customInfo.isExpress()) {
            loadExpress(context, adSlotBuild);
        } else {
            loadNative(context, adSlotBuild);
        }
    }
}
