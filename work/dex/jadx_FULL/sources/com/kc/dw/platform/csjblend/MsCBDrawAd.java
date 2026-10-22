package com.kc.dw.platform.csjblend;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.draw.MediationCustomDrawAd;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.base.a;
import com.kc.dw.core.ad.draw.IDrawAd;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCBDrawAd extends MediationCustomDrawAd {
    private static final String TAG = "MsCBDrawAd";
    private FrameLayout frameLayout;
    private IDrawAd iDrawAd;

    public MsCBDrawAd(IDrawAd iDrawAd) {
        Context context;
        this.iDrawAd = iDrawAd;
        try {
            context = iDrawAd.getAdView().getContext();
        } catch (Exception unused) {
            context = null;
        }
        try {
            this.frameLayout = new FrameLayout(context == null ? a.getContext() : context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setExpressAd(true);
        setInteractionType(getInteractionType());
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        View adView = this.iDrawAd.getAdView();
        LogUtil.d(TAG, "getExpressView: " + adView);
        if (adView instanceof NormalMediaView) {
            ((NormalMediaView) adView).start();
        }
        return this.frameLayout;
    }

    public int getInteractionType() {
        return this.iDrawAd.getInteractionType() == 1 ? 4 : 2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
        super.render();
        View adView = this.iDrawAd.getAdView();
        if (adView != null) {
            callRenderSuccess(adView.getMeasuredWidth(), adView.getMeasuredHeight());
        } else {
            callRenderSuccess(-1.0f, -2.0f);
        }
        IDrawAd iDrawAd = this.iDrawAd;
        if (iDrawAd != null) {
            iDrawAd.showAd(this.frameLayout);
        }
    }
}
