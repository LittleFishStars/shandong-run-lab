package com.kc.dw.platform.tradplus.recycler;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.ad.w;
import com.kc.dw.core.ad.recycler.ExpressMediaListener;
import com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener;
import com.kc.dw.core.ad.recycler.RecyclerAdData;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.tradplus.ads.base.adapter.nativead.TPNativeAdView;
import com.tradplus.ads.base.bean.TPBaseAd;
import com.tradplus.ads.base.common.TPError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsExpressAd extends TPBaseAd {
    private static final String TAG = w.a("TradPlus_", "MsExpressAd");
    private RecyclerAdData adData;

    public MsExpressAd(RecyclerAdData recyclerAdData) {
        this.adData = recyclerAdData;
        setExpressMediaListener();
    }

    private void setExpressMediaListener() {
        RecyclerAdData recyclerAdData = this.adData;
        if (recyclerAdData == null) {
            return;
        }
        recyclerAdData.setExpressMediaListener(new ExpressMediaListener(this) { // from class: com.kc.dw.platform.tradplus.recycler.MsExpressAd.2
            public final MsExpressAd this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
            public void onVideoCompleted() {
                if (((TPBaseAd) this.this$0).mShowListener != null) {
                    ((TPBaseAd) this.this$0).mShowListener.onAdVideoEnd();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
            public void onVideoError(int i, String str) {
                if (((TPBaseAd) this.this$0).mShowListener != null) {
                    ((TPBaseAd) this.this$0).mShowListener.onAdVideoError(new TPError(String.valueOf(i), str));
                }
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
                if (((TPBaseAd) this.this$0).mShowListener != null) {
                    ((TPBaseAd) this.this$0).mShowListener.onAdVideoStart();
                }
            }
        });
    }

    public void clean() {
        RecyclerAdData recyclerAdData = this.adData;
        if (recyclerAdData != null) {
            recyclerAdData.destroy();
            this.adData = null;
        }
    }

    public ViewGroup getCustomAdContainer() {
        return null;
    }

    public List<View> getMediaViews() {
        return null;
    }

    public int getNativeAdType() {
        return 1;
    }

    public Object getNetworkObj() {
        return null;
    }

    public View getRenderView() {
        return this.adData.getAdView();
    }

    public TPNativeAdView getTPNativeView() {
        return null;
    }

    public void registerClickAfterRender(ViewGroup viewGroup, ArrayList<View> arrayList) {
        LogUtil.d(TAG, "registerClickAfterRender");
        RecyclerAdData recyclerAdData = this.adData;
        if (recyclerAdData == null || viewGroup == null) {
            return;
        }
        recyclerAdData.setExpressAdInteractionListener(new FeedExpressAdInteractionListener(this, viewGroup) { // from class: com.kc.dw.platform.tradplus.recycler.MsExpressAd.1
            public final MsExpressAd this$0;
            public final ViewGroup val$viewGroup;

            {
                this.this$0 = this;
                this.val$viewGroup = viewGroup;
            }

            @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
            public void onAdClicked() {
                if (((TPBaseAd) this.this$0).mShowListener != null) {
                    ((TPBaseAd) this.this$0).mShowListener.onAdClicked();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
            public void onAdClosed() {
                if (((TPBaseAd) this.this$0).mShowListener != null) {
                    ((TPBaseAd) this.this$0).mShowListener.onAdClosed();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
            public void onAdExposure() {
                if (((TPBaseAd) this.this$0).mShowListener != null) {
                    ((TPBaseAd) this.this$0).mShowListener.onAdShown();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener
            public void onRenderError(int i, String str) {
            }

            @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener
            public void onRenderSuccess() {
                this.val$viewGroup.removeAllViews();
                this.val$viewGroup.addView(this.this$0.adData.getExpressView());
            }
        });
        if (viewGroup.getContext() instanceof Activity) {
            this.adData.render((Activity) viewGroup.getContext());
        }
    }

    public void registerClickView(ViewGroup viewGroup, ArrayList<View> arrayList) {
    }
}
