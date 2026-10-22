package com.kc.dw.gather.csj.feed;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CSJFeedExpressAd extends MsCustomRecyclerExpressAd {
    private static final String TAG = "CSJFeedExpressAd";
    private final TTNativeExpressAd ttNativeExpressAd;

    public CSJFeedExpressAd(TTNativeExpressAd tTNativeExpressAd) {
        this.ttNativeExpressAd = tTNativeExpressAd;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public View getExpressView() {
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            return tTNativeExpressAd.getExpressAdView();
        }
        return null;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void render(Activity activity) {
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.kc.dw.gather.csj.feed.CSJFeedExpressAd.1
                public final CSJFeedExpressAd this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i, String str, boolean z) {
                    try {
                        if (this.this$0.ttNativeExpressAd != null) {
                            View expressAdView = this.this$0.ttNativeExpressAd.getExpressAdView();
                            if (expressAdView != null && expressAdView.getParent() != null && (expressAdView.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
                            }
                            this.this$0.ttNativeExpressAd.destroy();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.this$0.callAdClosed();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                }
            });
            this.ttNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) { // from class: com.kc.dw.gather.csj.feed.CSJFeedExpressAd.2
                public final CSJFeedExpressAd this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i) {
                    LogUtil.d(CSJFeedExpressAd.TAG, "onAdClicked");
                    this.this$0.callAdClicked();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i) {
                    LogUtil.d(CSJFeedExpressAd.TAG, "onAdShow");
                    this.this$0.callAdExposure();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i) {
                    this.this$0.callRenderError(i, str);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f, float f2) {
                    LogUtil.d(CSJFeedExpressAd.TAG, "CSJ onRenderSuccess,view=" + view);
                    this.this$0.callRenderSuccess();
                }
            });
            this.ttNativeExpressAd.render();
        }
    }
}
