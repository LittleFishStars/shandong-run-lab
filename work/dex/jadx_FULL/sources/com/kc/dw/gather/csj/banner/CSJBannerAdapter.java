package com.kc.dw.gather.csj.banner;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.banner.MsCustomBannerAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CSJBannerAdapter extends MsCustomBannerAdapter {
    private static final String TAG = "CsjBannerAdAdapter";
    private TTNativeExpressAd ttNativeExpressAd;

    /* JADX INFO: renamed from: com.kc.dw.gather.csj.banner.CSJBannerAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements TTAdNative.NativeExpressAdListener {
        public final CSJBannerAdapter this$0;

        public AnonymousClass2(CSJBannerAdapter cSJBannerAdapter) {
            this.this$0 = cSJBannerAdapter;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onError(int i, String str) {
            LogUtil.d(CSJBannerAdapter.TAG, "onError: code=" + i + ",msg=" + str);
            this.this$0.callLoadedError(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list != null) {
                try {
                    if (list.isEmpty()) {
                        return;
                    }
                    this.this$0.ttNativeExpressAd = list.get(0);
                    this.this$0.ttNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) { // from class: com.kc.dw.gather.csj.banner.CSJBannerAdapter.2.1
                        public final AnonymousClass2 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                        public void onAdClicked(View view, int i) {
                            this.this$1.this$0.callAdClicked();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                        public void onAdShow(View view, int i) {
                            this.this$1.this$0.callAdExposure();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                        public void onRenderFail(View view, String str, int i) {
                            this.this$1.this$0.callRenderError(i, str);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                        public void onRenderSuccess(View view, float f, float f2) {
                            LogUtil.d(CSJBannerAdapter.TAG, "csj onRenderSuccess");
                            this.this$1.this$0.callRenderSuccess();
                        }
                    });
                    this.this$0.callLoadedSuccess();
                    this.this$0.ttNativeExpressAd.render();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void destory() {
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
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
        TTAdSdk.getAdManager().createAdNative(context).loadBannerExpressAd(new AdSlot.Builder().setCodeId(customInfo.getPid()).setSupportDeepLink(true).setExpressViewAcceptedSize(width, height).build(), new AnonymousClass2(this));
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void showAd(ViewGroup viewGroup) {
        try {
            TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
            if (tTNativeExpressAd != null) {
                View expressAdView = tTNativeExpressAd.getExpressAdView();
                this.ttNativeExpressAd.setDislikeCallback((Activity) viewGroup.getContext(), new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.kc.dw.gather.csj.banner.CSJBannerAdapter.1
                    public final CSJBannerAdapter this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i, String str, boolean z) {
                        View expressAdView2 = this.this$0.ttNativeExpressAd.getExpressAdView();
                        if (expressAdView2 != null && expressAdView2.getParent() != null && (expressAdView2.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) expressAdView2.getParent()).removeView(expressAdView2);
                        }
                        this.this$0.ttNativeExpressAd.destroy();
                        this.this$0.callAdClosed();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onShow() {
                    }
                });
                if (expressAdView.getParent() != null && (expressAdView.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
                }
                viewGroup.removeAllViews();
                viewGroup.addView(expressAdView);
            }
        } catch (Exception e) {
            callRenderError(200002, "render error");
            e.printStackTrace();
        }
    }
}
