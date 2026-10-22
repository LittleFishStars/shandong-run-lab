package com.kc.dw.platform.tradplus.recycler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kc.dw.ad.w;
import com.kc.dw.core.ad.recycler.FeedInteractionListener;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.ad.recycler.RecyclerAdData;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.tradplus.ads.base.adapter.nativead.TPNativeAdView;
import com.tradplus.ads.base.bean.TPBaseAd;
import com.tradplus.ads.base.common.TPError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsNativeAd extends TPBaseAd {
    private static final String TAG = w.a("TradPlus_", "MsNativeAd");
    private RecyclerAdData adData;
    private TPNativeAdView tpNativeAdView;
    private FrameLayout videoViewGroup;

    public MsNativeAd(Context context, RecyclerAdData recyclerAdData) {
        this.adData = recyclerAdData;
        setAdData(context);
    }

    private long parseLong(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.parseLong(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    private void setAdData(Context context) {
        try {
            TPNativeAdView tPNativeAdView = new TPNativeAdView();
            this.tpNativeAdView = tPNativeAdView;
            tPNativeAdView.setTitle(this.adData.getTitle());
            this.tpNativeAdView.setSubTitle(this.adData.getDesc());
            this.tpNativeAdView.setIconImageUrl(this.adData.getIconUrl());
            this.tpNativeAdView.setAdChoiceUrl(this.adData.getFromLogo());
            String[] imgUrls = this.adData.getImgUrls();
            if (imgUrls != null && imgUrls.length > 0) {
                String str = imgUrls[0];
                if (this.adData.getAdPatternType() == 2) {
                    this.tpNativeAdView.setVideoUrl(str);
                    if (context == null) {
                        context = this.adData.getAdView().getContext();
                    }
                    FrameLayout frameLayout = new FrameLayout(context);
                    this.videoViewGroup = frameLayout;
                    this.tpNativeAdView.setMediaView(frameLayout);
                } else {
                    this.tpNativeAdView.setMainImageUrl(str);
                    this.tpNativeAdView.setPicUrls(Arrays.asList(imgUrls));
                }
            }
            this.tpNativeAdView.setCallToAction(this.adData.getActionText());
            this.tpNativeAdView.setAppName(this.adData.getAppName());
            this.tpNativeAdView.setAuthorName(this.adData.getDeveloper());
            this.tpNativeAdView.setVersionName(this.adData.getAppVersion());
            this.tpNativeAdView.setPermissionsUrl(this.adData.getAppPremissionUrl());
            this.tpNativeAdView.setPrivacyAgreement(this.adData.getPrivacyAgreement());
            this.tpNativeAdView.setPackageSizeBytes(parseLong(this.adData.getAppSize()));
            if (this.adData.getInteractionType() == 1) {
                TPNativeAdView.AppNativeInfo appNativeInfo = new TPNativeAdView.AppNativeInfo();
                appNativeInfo.setAppName(this.adData.getAppName());
                appNativeInfo.setAuthorName(this.adData.getDeveloper());
                appNativeInfo.setAppVrsion(this.adData.getAppVersion());
                appNativeInfo.setAppDetailUrl(this.adData.getAppIntroUrl());
                appNativeInfo.setAppPrivacyUrl(this.adData.getPrivacyAgreement());
                appNativeInfo.setAppPermissionUrl(this.adData.getAppPremissionUrl());
                this.tpNativeAdView.setAppNativeInfo(appNativeInfo);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
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
        return 0;
    }

    public Object getNetworkObj() {
        return null;
    }

    public View getRenderView() {
        return null;
    }

    public TPNativeAdView getTPNativeView() {
        return this.tpNativeAdView;
    }

    public void registerClickView(ViewGroup viewGroup, ArrayList<View> arrayList) {
        LogUtil.d(TAG, "registerClickView");
        this.adData.bindAdToView(viewGroup.getContext(), viewGroup, arrayList, new FeedInteractionListener(this) { // from class: com.kc.dw.platform.tradplus.recycler.MsNativeAd.1
            public final MsNativeAd this$0;

            {
                this.this$0 = this;
            }

            @Override // com.kc.dw.core.loader.InteractionListener
            public void onAdClicked() {
                if (((TPBaseAd) this.this$0).mShowListener != null) {
                    ((TPBaseAd) this.this$0).mShowListener.onAdClicked();
                }
            }

            @Override // com.kc.dw.core.loader.InteractionListener
            public void onAdClosed() {
                if (((TPBaseAd) this.this$0).mShowListener != null) {
                    ((TPBaseAd) this.this$0).mShowListener.onAdClosed();
                }
            }

            @Override // com.kc.dw.core.loader.InteractionListener
            public void onAdExposure() {
                if (((TPBaseAd) this.this$0).mShowListener != null) {
                    ((TPBaseAd) this.this$0).mShowListener.onAdShown();
                }
            }
        });
        if (this.videoViewGroup != null) {
            this.adData.setNativeMediaListener(new NativeAdMediaListener(this) { // from class: com.kc.dw.platform.tradplus.recycler.MsNativeAd.2
                public final MsNativeAd this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
                public void onVideoCompleted() {
                    if (((TPBaseAd) this.this$0).mShowListener != null) {
                        ((TPBaseAd) this.this$0).mShowListener.onAdVideoEnd();
                    }
                }

                @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
                public void onVideoError() {
                    if (((TPBaseAd) this.this$0).mShowListener != null) {
                        ((TPBaseAd) this.this$0).mShowListener.onAdVideoError(new TPError());
                    }
                }

                @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
                public void onVideoPause() {
                }

                @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
                public void onVideoResume() {
                }

                @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
                public void onVideoStart() {
                    if (((TPBaseAd) this.this$0).mShowListener != null) {
                        ((TPBaseAd) this.this$0).mShowListener.onAdVideoStart();
                    }
                }
            });
            this.videoViewGroup.addView(this.adData.getMediaView());
        }
    }
}
