package com.kc.dw.platform.topon.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdAppInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.kc.dw.core.ad.recycler.FeedInteractionListener;
import com.kc.dw.core.ad.recycler.RecyclerAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsNativeAd extends CustomNativeAd {
    private RecyclerAdData adData;

    public MsNativeAd(RecyclerAdData recyclerAdData) {
        this.adData = recyclerAdData;
        setAdData();
    }

    private void setAdData() {
        setTitle(this.adData.getTitle());
        setDescriptionText(this.adData.getDesc());
        setIconImageUrl(this.adData.getIconUrl());
        setAdChoiceIconUrl(this.adData.getFromLogo());
        String[] imgUrls = this.adData.getImgUrls();
        if (imgUrls != null && imgUrls.length > 0) {
            setMainImageUrl(imgUrls[0]);
            setImageUrlList(Arrays.asList(imgUrls));
        }
        setCallToActionText(this.adData.getActionText());
        setMainImageWidth(this.adData.getWidth());
        setMainImageHeight(this.adData.getHeight());
        ((CustomNativeAd) this).mAdSourceType = this.adData.getAdPatternType() == 2 ? "1" : "2";
        setVideoDuration(this.adData.getDuration());
        if (this.adData.getInteractionType() == 1) {
            setNativeInteractionType(1);
            setAdAppInfo(new ATAdAppInfo(this) { // from class: com.kc.dw.platform.topon.recycler.MsNativeAd.1
                public final MsNativeAd this$0;

                {
                    this.this$0 = this;
                }

                public String getAppName() {
                    return this.this$0.adData.getAppName();
                }

                public String getAppPackageName() {
                    return this.this$0.adData.getPackageName();
                }

                public String getAppPermissonUrl() {
                    return this.this$0.adData.getAppPremissionUrl();
                }

                public String getAppPrivacyUrl() {
                    return this.this$0.adData.getPrivacyAgreement();
                }

                public long getAppSize() {
                    try {
                        return Long.parseLong(this.this$0.adData.getAppSize());
                    } catch (Throwable unused) {
                        return 0L;
                    }
                }

                public String getAppVersion() {
                    return this.this$0.adData.getAppVersion();
                }

                public String getDownloadCount() {
                    return "";
                }

                public String getFunctionUrl() {
                    return this.this$0.adData.getAppIntroUrl();
                }

                public String getPublisher() {
                    return this.this$0.adData.getDeveloper();
                }
            });
        }
    }

    public void destroy() {
        RecyclerAdData recyclerAdData = this.adData;
        if (recyclerAdData != null) {
            recyclerAdData.destroy();
        }
    }

    public View getAdMediaView(Object... objArr) {
        RecyclerAdData recyclerAdData = this.adData;
        return (recyclerAdData == null || recyclerAdData.getAdPatternType() != 2) ? super.getAdMediaView(objArr) : this.adData.getMediaView();
    }

    public ViewGroup getCustomAdContainer() {
        return super.getCustomAdContainer();
    }

    public boolean isNativeExpress() {
        return false;
    }

    public boolean isValid() {
        RecyclerAdData recyclerAdData = this.adData;
        return recyclerAdData != null && recyclerAdData.isAdValid();
    }

    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (view instanceof ViewGroup) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(view);
            this.adData.bindAdToView(view.getContext(), (ViewGroup) view, arrayList, new FeedInteractionListener(this) { // from class: com.kc.dw.platform.topon.recycler.MsNativeAd.2
                public final MsNativeAd this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdClicked() {
                    this.this$0.notifyAdClicked();
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdClosed() {
                    this.this$0.notifyAdDislikeClick();
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdExposure() {
                    this.this$0.notifyAdImpression();
                }
            });
        }
    }
}
