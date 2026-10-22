package com.kc.dw.gather.csj.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CSJFeedNativeAd extends MsCustomRecyclerFeedAd {
    private static final String TAG = "CSJFeedNativeAd";
    private final TTFeedAd ttFeedAd;

    public CSJFeedNativeAd(TTFeedAd tTFeedAd) {
        this.ttFeedAd = tTFeedAd;
        if (tTFeedAd != null) {
            try {
                setTitle(tTFeedAd.getTitle());
                setDesc(tTFeedAd.getDescription());
                setActionText(tTFeedAd.getButtonText());
                setFrom(tTFeedAd.getSource());
                List<TTImage> imageList = tTFeedAd.getImageList();
                if (imageList != null && !imageList.isEmpty()) {
                    this.imgUrls = new String[imageList.size()];
                    Iterator<TTImage> it = imageList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        this.imgUrls[i] = it.next().getImageUrl();
                        i++;
                    }
                    TTImage tTImage = imageList.get(0);
                    setWidth(tTImage.getWidth());
                    setHeight(tTImage.getHeight());
                }
                setAdPatternType(getAdPatternType(tTFeedAd));
                setInteractionType(getInteractionType(tTFeedAd));
                setFromLogoBitmap(tTFeedAd.getAdLogo());
                if (tTFeedAd.getIcon() != null) {
                    setIconUrl(tTFeedAd.getIcon().getImageUrl());
                }
                if (tTFeedAd.getComplianceInfo() != null) {
                    ComplianceInfo complianceInfo = tTFeedAd.getComplianceInfo();
                    setAppName(complianceInfo.getAppName());
                    setAppVersion(complianceInfo.getAppVersion());
                    setDeveloper(complianceInfo.getDeveloperName());
                    setPrivacyAgreement(complianceInfo.getPrivacyUrl());
                    setAppPremissionUrl(complianceInfo.getPermissionUrl());
                    setAppIntroUrl(complianceInfo.getFunctionDescUrl());
                }
                setMediaView(tTFeedAd.getAdView());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static int getAdPatternType(TTFeedAd tTFeedAd) {
        int imageMode = tTFeedAd.getImageMode();
        if (imageMode == 15) {
            return 2;
        }
        if (imageMode == 2) {
            return 11;
        }
        if (imageMode != 4) {
            return imageMode != 5 ? 12 : 2;
        }
        return 13;
    }

    private static List<String> getImgList(List<TTImage> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            try {
                TTImage tTImage = list.get(i);
                if (tTImage != null) {
                    arrayList.add(tTImage.getImageUrl());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private static int getInteractionType(TTFeedAd tTFeedAd) {
        return tTFeedAd.getInteractionType() != 4 ? 0 : 1;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list) {
        TTFeedAd tTFeedAd = this.ttFeedAd;
        if (tTFeedAd != null) {
            tTFeedAd.registerViewForInteraction(viewGroup, list, null, new TTNativeAd.AdInteractionListener(this) { // from class: com.kc.dw.gather.csj.feed.CSJFeedNativeAd.1
                public final CSJFeedNativeAd this$0;

                {
                    this.this$0 = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                    LogUtil.d(CSJFeedNativeAd.TAG, "CSJ onAdClicked");
                    this.this$0.callAdClicked();
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                    onAdClicked(view, tTNativeAd);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdShow(TTNativeAd tTNativeAd) {
                    LogUtil.d(CSJFeedNativeAd.TAG, "CSJ onAdShow");
                    this.this$0.callAdExposure();
                }
            });
        }
    }
}
