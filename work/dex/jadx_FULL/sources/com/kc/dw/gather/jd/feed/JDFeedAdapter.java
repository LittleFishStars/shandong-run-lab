package com.kc.dw.gather.jd.feed;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.feed.JADFeed;
import com.jd.ad.sdk.feed.JADFeedListener;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeLoadListener;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.recycler.RecyclerMixCommonAdLoader;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class JDFeedAdapter extends MsCustomRecyclerAdapter {
    private static final String TAG = "JDFeedAdapter";
    private JDFeedExpressAd jdFeedExpressAd;

    private void loadExpressAd() {
        DisplayMetrics displayMetrics = this.context.getApplicationContext().getResources().getDisplayMetrics();
        JADFeed jADFeed = new JADFeed(((RecyclerMixCommonAdLoader) this.adLoader).getContext(), new JADSlot.Builder().setSlotID(getSdkAdInfo().getPid()).setSize(((getAdLoader().getAccept_ad_width() == null || getAdLoader().getAccept_ad_width().intValue() <= 0) ? displayMetrics.widthPixels : getAdLoader().getAccept_ad_width().intValue()) / displayMetrics.density, (getAdLoader().getAccept_ad_height() == null || getAdLoader().getAccept_ad_height().intValue() <= 0) ? 0.0f : getAdLoader().getAccept_ad_height().intValue() / displayMetrics.density).build());
        jADFeed.loadAd(new JADFeedListener(this, jADFeed) { // from class: com.kc.dw.gather.jd.feed.JDFeedAdapter.1
            public final JDFeedAdapter this$0;
            public final JADFeed val$jadFeed;

            {
                this.this$0 = this;
                this.val$jadFeed = jADFeed;
            }

            public void onClick() {
                if (this.this$0.jdFeedExpressAd != null) {
                    this.this$0.jdFeedExpressAd.callAdClicked();
                }
            }

            public void onClose() {
                if (this.this$0.jdFeedExpressAd != null) {
                    this.this$0.jdFeedExpressAd.callAdClosed();
                }
            }

            public void onExposure() {
                if (this.this$0.jdFeedExpressAd != null) {
                    this.this$0.jdFeedExpressAd.callAdExposure();
                }
            }

            public void onLoadFailure(int i, String str) {
                this.this$0.callLoadedError(i, str);
            }

            public void onLoadSuccess() {
                if (this.val$jadFeed.getExtra() != null) {
                    this.this$0.setEcpm(this.val$jadFeed.getExtra().getPrice());
                }
                this.this$0.jdFeedExpressAd = new JDFeedExpressAd(this.val$jadFeed);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.this$0.jdFeedExpressAd);
                this.this$0.callLoadedSuccess(arrayList);
            }

            public void onRenderFailure(int i, String str) {
                if (this.this$0.jdFeedExpressAd != null) {
                    this.this$0.jdFeedExpressAd.callRenderError(i, str);
                }
            }

            public void onRenderSuccess(View view) {
                if (this.this$0.jdFeedExpressAd != null) {
                    this.this$0.jdFeedExpressAd.setAdView(view);
                    this.this$0.jdFeedExpressAd.callRenderSuccess();
                }
            }
        });
    }

    private void loadNativeAd(SsdAdSlot ssdAdSlot) {
        float height;
        float f;
        DisplayMetrics displayMetrics = this.context.getApplicationContext().getResources().getDisplayMetrics();
        float width = (ssdAdSlot.getWidth() > 0 ? ssdAdSlot.getWidth() : displayMetrics.widthPixels) / displayMetrics.density;
        if (ssdAdSlot.getHeight() > 0) {
            height = ssdAdSlot.getHeight();
            f = displayMetrics.density;
        } else {
            height = 9.0f * width;
            f = 16.0f;
        }
        JADNative jADNative = new JADNative(new JADSlot.Builder().setSlotID(getSdkAdInfo().getPid()).setImageSize(width, height / f).setAdType(2).build());
        jADNative.loadAd(new JADNativeLoadListener(this, jADNative) { // from class: com.kc.dw.gather.jd.feed.JDFeedAdapter.2
            public final JDFeedAdapter this$0;
            public final JADNative val$jadNative;

            {
                this.this$0 = this;
                this.val$jadNative = jADNative;
            }

            public void onLoadFailure(int i, String str) {
                LogUtil.e(JDFeedAdapter.TAG, "onNoAD, code: " + i + ", msg: " + str);
                this.this$0.callLoadedError(i, str);
            }

            public void onLoadSuccess() {
                List dataList = this.val$jadNative.getDataList();
                this.this$0.setEcpm(this.val$jadNative.getJADExtra().getPrice());
                ArrayList arrayList = new ArrayList();
                Iterator it = dataList.iterator();
                if (it.hasNext()) {
                    arrayList.add(new JDFeedNativeAd(this.val$jadNative, (JADMaterialData) it.next()));
                }
                this.this$0.callLoadedSuccess(arrayList);
            }
        });
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        if (customInfo.isExpress()) {
            loadExpressAd();
        } else {
            loadNativeAd(ssdAdSlot);
        }
    }
}
