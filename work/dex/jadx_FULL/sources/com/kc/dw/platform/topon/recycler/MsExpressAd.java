package com.kc.dw.platform.topon.recycler;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.kc.dw.core.ad.recycler.ExpressMediaListener;
import com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener;
import com.kc.dw.core.ad.recycler.RecyclerAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsExpressAd extends CustomNativeAd {
    private RecyclerAdData adData;
    private RelativeLayout expressContainer;

    public MsExpressAd(RecyclerAdData recyclerAdData) {
        this.adData = recyclerAdData;
    }

    public void destroy() {
        RecyclerAdData recyclerAdData = this.adData;
        if (recyclerAdData != null) {
            recyclerAdData.destroy();
        }
    }

    public View getAdMediaView(Object... objArr) {
        return this.expressContainer;
    }

    public boolean isNativeExpress() {
        return true;
    }

    public boolean isValid() {
        RecyclerAdData recyclerAdData = this.adData;
        return recyclerAdData != null && recyclerAdData.isAdValid();
    }

    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        try {
            if (this.adData != null && view != null) {
                new ArrayList().add(view);
                this.expressContainer = new RelativeLayout(view.getContext());
                this.adData.setExpressMediaListener(new ExpressMediaListener(this) { // from class: com.kc.dw.platform.topon.recycler.MsExpressAd.1
                    public final MsExpressAd this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
                    public void onVideoCompleted() {
                        this.this$0.notifyAdVideoEnd();
                    }

                    @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
                    public void onVideoError(int i, String str) {
                        this.this$0.notifyAdVideoVideoPlayFail(String.valueOf(i), str);
                    }

                    @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
                    public void onVideoLoaded() {
                    }

                    @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
                    public void onVideoPause() {
                    }

                    @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
                    public void onVideoResume() {
                    }

                    @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
                    public void onVideoStart() {
                        this.this$0.notifyAdVideoStart();
                    }
                });
                this.adData.setExpressAdInteractionListener(new FeedExpressAdInteractionListener(this, view) { // from class: com.kc.dw.platform.topon.recycler.MsExpressAd.2
                    public final MsExpressAd this$0;
                    public final View val$view;

                    {
                        this.this$0 = this;
                        this.val$view = view;
                    }

                    @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
                    public void onAdClicked() {
                        this.this$0.notifyAdClicked();
                    }

                    @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
                    public void onAdClosed() {
                        this.this$0.notifyAdDislikeClick();
                    }

                    @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
                    public void onAdExposure() {
                        this.this$0.notifyAdImpression();
                    }

                    @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener
                    public void onRenderError(int i, String str) {
                    }

                    @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener
                    public void onRenderSuccess() {
                        try {
                            if (this.this$0.expressContainer != null) {
                                this.this$0.expressContainer.removeAllViews();
                                this.this$0.expressContainer.addView(this.this$0.adData.getExpressView());
                                if ((this.val$view instanceof ViewGroup) && this.this$0.expressContainer.getParent() == null) {
                                    ((ViewGroup) this.val$view).addView(this.this$0.expressContainer);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                if (view.getContext() instanceof Activity) {
                    this.adData.render((Activity) view.getContext());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
