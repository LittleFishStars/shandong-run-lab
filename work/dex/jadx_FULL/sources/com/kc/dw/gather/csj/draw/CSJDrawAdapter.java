package com.kc.dw.gather.csj.draw;

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
import com.kc.dw.core.ad.draw.DrawCommonAdLoader;
import com.kc.dw.core.utils.DimensionUtils;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.draw.MsCustomDrawAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CSJDrawAdapter extends MsCustomDrawAdapter {
    private static final String TAG = "CSJDrawAdapter";
    private TTNativeExpressAd drawAd;
    private TTAdNative ttAdNative;

    /* JADX INFO: renamed from: com.kc.dw.gather.csj.draw.CSJDrawAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements TTAdNative.NativeExpressAdListener {
        public final CSJDrawAdapter this$0;

        public AnonymousClass2(CSJDrawAdapter cSJDrawAdapter) {
            this.this$0 = cSJDrawAdapter;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onError(int i, String str) {
            this.this$0.callLoadedError(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            this.this$0.drawAd = list.get(0);
            this.this$0.drawAd.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener(this) { // from class: com.kc.dw.gather.csj.draw.CSJDrawAdapter.2.1
                public final AnonymousClass2 this$1;

                {
                    this.this$1 = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onClickRetry() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onProgressUpdate(long j, long j2) {
                    this.this$1.this$0.onProgressUpdate(j, j2);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoAdComplete() {
                    this.this$1.this$0.onVideoCompleted();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoAdContinuePlay() {
                    this.this$1.this$0.onVideoResume();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoAdPaused() {
                    this.this$1.this$0.onVideoPause();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoAdStartPlay() {
                    this.this$1.this$0.onVideoStart();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoError(int i, int i2) {
                    this.this$1.this$0.onVideoError(i, "视频加载错误：" + i2);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoLoad() {
                    this.this$1.this$0.onVideoLoaded();
                }
            });
            this.this$0.drawAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) { // from class: com.kc.dw.gather.csj.draw.CSJDrawAdapter.2.2
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
                    this.this$1.this$0.callRenderSuccess();
                }
            });
            this.this$0.callLoadedSuccess();
            this.this$0.drawAd.render();
        }
    }

    private void loadExpressAd(SsdAdSlot ssdAdSlot, int i, int i2) {
        try {
            this.ttAdNative.loadExpressDrawFeedAd(new AdSlot.Builder().setCodeId(ssdAdSlot.getPid()).setSupportDeepLink(true).setImageAcceptedSize(i, i2).setExpressViewAcceptedSize(DimensionUtils.px2dip(((DrawCommonAdLoader) this.adLoader).getContext(), i), DimensionUtils.px2dip(((DrawCommonAdLoader) this.adLoader).getContext(), i2)).build(), new AnonymousClass2(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.draw.MsCustomDrawAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        try {
            this.ttAdNative = TTAdSdk.getAdManager().createAdNative(((DrawCommonAdLoader) this.adLoader).getContext());
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            int width = displayMetrics.widthPixels;
            int height = displayMetrics.heightPixels;
            if (ssdAdSlot.getWidth() > 0 && ssdAdSlot.getHeight() > 0) {
                width = ssdAdSlot.getWidth();
                height = ssdAdSlot.getHeight();
            }
            loadExpressAd(ssdAdSlot, width, height);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.draw.MsCustomDrawAdapter
    public void showAd(ViewGroup viewGroup) {
        try {
            this.drawAd.setDislikeCallback((Activity) viewGroup.getContext(), new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.kc.dw.gather.csj.draw.CSJDrawAdapter.1
                public final CSJDrawAdapter this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i, String str, boolean z) {
                    this.this$0.callAdClosed();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                }
            });
            viewGroup.removeAllViews();
            View expressAdView = this.drawAd.getExpressAdView();
            if (expressAdView == null) {
                return;
            }
            if (expressAdView.getParent() != null && (expressAdView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
            }
            viewGroup.addView(expressAdView);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
