package com.kc.dw.gather.bd.feed;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BDFeedExpressAd extends MsCustomRecyclerExpressAd {
    private static final String TAG = "BDFeedExpressAd";
    private final ExpressResponse expressResponse;

    public BDFeedExpressAd(ExpressResponse expressResponse) {
        this.expressResponse = expressResponse;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public View getExpressView() {
        ExpressResponse expressResponse = this.expressResponse;
        if (expressResponse != null) {
            return expressResponse.getExpressAdView();
        }
        return null;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void render(Activity activity) {
        try {
            ExpressResponse expressResponse = this.expressResponse;
            if (expressResponse != null) {
                expressResponse.setInteractionListener(new ExpressResponse.ExpressInteractionListener(this) { // from class: com.kc.dw.gather.bd.feed.BDFeedExpressAd.1
                    public final BDFeedExpressAd this$0;

                    {
                        this.this$0 = this;
                    }

                    public void onAdClick() {
                        this.this$0.callAdClicked();
                    }

                    public void onAdExposed() {
                        this.this$0.callAdExposure();
                    }

                    public void onAdRenderFail(View view, String str, int i) {
                        this.this$0.callRenderError(i, str);
                    }

                    public void onAdRenderSuccess(View view, float f, float f2) {
                        this.this$0.callRenderSuccess();
                    }

                    public void onAdUnionClick() {
                    }
                });
                this.expressResponse.setAdCloseListener(new ExpressResponse.ExpressCloseListener(this) { // from class: com.kc.dw.gather.bd.feed.BDFeedExpressAd.2
                    public final BDFeedExpressAd this$0;

                    {
                        this.this$0 = this;
                    }

                    public void onAdClose(ExpressResponse expressResponse2) {
                        LogUtil.d(BDFeedExpressAd.TAG, "onAdClose");
                        this.this$0.callAdClosed();
                    }
                });
                this.expressResponse.setAdDislikeListener(new ExpressResponse.ExpressDislikeListener(this) { // from class: com.kc.dw.gather.bd.feed.BDFeedExpressAd.3
                    public final BDFeedExpressAd this$0;

                    {
                        this.this$0 = this;
                    }

                    public void onDislikeItemClick(String str) {
                        LogUtil.d(BDFeedExpressAd.TAG, "onDislikeItemClick");
                        try {
                            View expressAdView = this.this$0.expressResponse.getExpressAdView();
                            if (expressAdView != null && expressAdView.getParent() != null && (expressAdView.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.this$0.callAdClosed();
                    }

                    public void onDislikeWindowClose() {
                    }

                    public void onDislikeWindowShow() {
                    }
                });
                this.expressResponse.bindInteractionActivity(activity);
                this.expressResponse.render();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
