package com.kc.dw.platform.csjblend;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd;
import com.kc.dw.activity.a;
import com.kc.dw.core.ad.recycler.FeedInteractionListener;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.ad.recycler.RecyclerAdData;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCBGMNativeAd extends MediationCustomNativeAd {
    private static final String TAG = "MsCBGMNativeAd";
    private RecyclerAdData adData;

    public MsCBGMNativeAd(RecyclerAdData recyclerAdData) {
        this.adData = recyclerAdData;
        try {
            setActionText(recyclerAdData.getActionText());
            setDescription(recyclerAdData.getDesc());
            setIconUrl(recyclerAdData.getIconUrl());
            setSource(recyclerAdData.getAppName());
            setTitle(recyclerAdData.getTitle());
            setExpressAd(false);
            if (recyclerAdData.getInteractionType() == 1) {
                setInteractionType(4);
            } else {
                setInteractionType(3);
            }
            String[] imgUrls = recyclerAdData.getImgUrls();
            if (imgUrls != null && imgUrls.length > 0) {
                if (recyclerAdData.getAdPatternType() == 12 || recyclerAdData.getAdPatternType() == 1 || recyclerAdData.getAdPatternType() == 11) {
                    setImageUrl(imgUrls[0]);
                } else if (recyclerAdData.getAdPatternType() == 13) {
                    setImageList(Arrays.asList(imgUrls));
                }
            }
            setAdImageMode(getAdImageMode());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getAdImageMode() {
        int adPatternType = this.adData.getAdPatternType();
        if (adPatternType == 2) {
            return 5;
        }
        if (adPatternType != 11) {
            return adPatternType != 13 ? 3 : 4;
        }
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd
    public View getVideoView() {
        RecyclerAdData recyclerAdData = this.adData;
        return recyclerAdData != null ? recyclerAdData.getMediaView() : super.getVideoView();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
        RecyclerAdData recyclerAdData = this.adData;
        if (recyclerAdData != null) {
            if (recyclerAdData.getAdPatternType() == 2) {
                this.adData.setNativeMediaListener(new NativeAdMediaListener(this) { // from class: com.kc.dw.platform.csjblend.MsCBGMNativeAd.1
                    public final MsCBGMNativeAd this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
                    public void onVideoCompleted() {
                        StringBuilder sbA = a.a("DEMO ADEVENT ");
                        sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                        LogUtil.d(MsCBGMNativeAd.TAG, sbA.toString());
                        this.this$0.callVideoCompleted();
                    }

                    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
                    public void onVideoError() {
                        LogUtil.d(MsCBGMNativeAd.TAG, "onVideoError");
                        this.this$0.callVideoError(-1, "video error");
                    }

                    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
                    public void onVideoLoaded() {
                        StringBuilder sbA = a.a("DEMO ADEVENT ");
                        sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                        LogUtil.d(MsCBGMNativeAd.TAG, sbA.toString());
                    }

                    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
                    public void onVideoPause() {
                        StringBuilder sbA = a.a("DEMO ADEVENT ");
                        sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                        LogUtil.d(MsCBGMNativeAd.TAG, sbA.toString());
                        this.this$0.callVideoPause();
                    }

                    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
                    public void onVideoResume() {
                        StringBuilder sbA = a.a("DEMO ADEVENT ");
                        sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                        LogUtil.d(MsCBGMNativeAd.TAG, sbA.toString());
                        this.this$0.callVideoResume();
                    }

                    @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
                    public void onVideoStart() {
                        StringBuilder sbA = a.a("DEMO ADEVENT ");
                        sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                        LogUtil.d(MsCBGMNativeAd.TAG, sbA.toString());
                        this.this$0.callVideoStart();
                    }
                });
            }
            this.adData.bindAdToView(activity, viewGroup, list, new FeedInteractionListener(this) { // from class: com.kc.dw.platform.csjblend.MsCBGMNativeAd.2
                public final MsCBGMNativeAd this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdClicked() {
                    this.this$0.callAdClick();
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdClosed() {
                    this.this$0.callDislikeSelected(-1, "自渲染关闭");
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdExposure() {
                    this.this$0.callAdShow();
                }
            });
            if (viewGroup == null || mediationViewBinder == null) {
                return;
            }
            try {
                View viewFindViewById = viewGroup.findViewById(mediationViewBinder.mediaViewId);
                if ((viewFindViewById instanceof ViewGroup) && this.adData.getMediaView().getParent() == null) {
                    ((ViewGroup) viewFindViewById).addView(this.adData.getMediaView());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
