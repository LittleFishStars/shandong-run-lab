package com.kc.dw.gather.ks.feed;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd;
import com.kwad.sdk.api.KsFeedAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class KSFeedExpressAd extends MsCustomRecyclerExpressAd {
    private final Context context;
    private final KsFeedAd ksFeedAd;

    public KSFeedExpressAd(Context context, KsFeedAd ksFeedAd) {
        this.context = context;
        this.ksFeedAd = ksFeedAd;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public View getExpressView() {
        try {
            KsFeedAd ksFeedAd = this.ksFeedAd;
            if (ksFeedAd != null) {
                return ksFeedAd.getFeedView(this.context);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void render(Activity activity) {
        try {
            KsFeedAd ksFeedAd = this.ksFeedAd;
            if (ksFeedAd != null) {
                ksFeedAd.setAdInteractionListener(new KsFeedAd.AdInteractionListener(this) { // from class: com.kc.dw.gather.ks.feed.KSFeedExpressAd.1
                    public final KSFeedExpressAd this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onAdClicked() {
                        this.this$0.callAdClicked();
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onAdShow() {
                        this.this$0.callAdExposure();
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onDislikeClicked() {
                        try {
                            View feedView = this.this$0.ksFeedAd.getFeedView(this.this$0.context);
                            if (feedView != null && feedView.getParent() != null && (feedView.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) feedView.getParent()).removeView(feedView);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.this$0.callAdClosed();
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                    public void onDownloadTipsDialogShow() {
                    }
                });
                this.ksFeedAd.render(new KsFeedAd.AdRenderListener(this) { // from class: com.kc.dw.gather.ks.feed.KSFeedExpressAd.2
                    public final KSFeedExpressAd this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
                    public void onAdRenderFailed(int i, String str) {
                        this.this$0.callRenderError(i, str);
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
                    public void onAdRenderSuccess(View view) {
                        this.this$0.callRenderSuccess();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
