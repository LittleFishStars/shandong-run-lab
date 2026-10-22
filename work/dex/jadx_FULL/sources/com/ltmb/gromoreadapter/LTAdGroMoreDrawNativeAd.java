package com.ltmb.gromoreadapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd;
import com.ltmb.ltsdk.core.load.data.DrawAdData;
import com.ltmb.ltsdk.core.load.draw.LTAdDrawNativeEventListener;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class LTAdGroMoreDrawNativeAd extends MediationCustomNativeAd {
    public LTAdGroMoreDrawNativeAd(Context context, DrawAdData drawAdData) {
        Log.i("LTAdGroMoreDrawNativeAd", "KsFeedNativeAd init");
        MediationNativeAdAppInfo mediationNativeAdAppInfo = new MediationNativeAdAppInfo();
        mediationNativeAdAppInfo.setAppName("app info app name");
        mediationNativeAdAppInfo.setAuthorName("app info author name");
        mediationNativeAdAppInfo.setPackageSizeBytes(100L);
        mediationNativeAdAppInfo.setPermissionsUrl("app info permissionsUrl");
        HashMap map = new HashMap();
        map.put("key1", "app info permission value1");
        map.put("key2", "app info permission value2");
        mediationNativeAdAppInfo.setPermissionsMap(map);
        mediationNativeAdAppInfo.setPrivacyAgreement("app info privacy agreement");
        HashMap map2 = new HashMap();
        map2.put("key1", "app info extra value1");
        map2.put("key2", "app info extra value2");
        mediationNativeAdAppInfo.setAppInfoExtra(map2);
        mediationNativeAdAppInfo.setVersionName("version Name");
        setNativeAdAppInfo(mediationNativeAdAppInfo);
        setActionText("查看详情");
        setDescription(drawAdData.getDrawAdDataSource().getDesc());
        setIconUrl(drawAdData.getDrawAdDataSource().getIconUrl());
        setTitle(drawAdData.getDrawAdDataSource().getTitle());
        setExpressAd(false);
        setStarRating(5.0d);
        if (drawAdData.getDrawAdDataSource().getAdType() == 3) {
            setInteractionType(4);
        } else if (drawAdData.getDrawAdDataSource().getAdType() == 2) {
            setInteractionType(3);
        } else {
            setInteractionType(-1);
        }
        if (drawAdData.getDrawAdDataSource().getVideoUrl() == null || drawAdData.getDrawAdDataSource().getVideoUrl().isEmpty()) {
            setAdImageMode(3);
        } else {
            setAdImageMode(5);
        }
        if (drawAdData.getDrawAdDataSource().getVideoCoverUrl() != null) {
            setImageUrl(drawAdData.getDrawAdDataSource().getVideoCoverUrl());
        } else if (drawAdData.getDrawAdDataSource().getImageUrl() != null) {
            setImageUrl(drawAdData.getDrawAdDataSource().getImageUrl());
        } else {
            setAdImageMode(-1);
        }
        setImageHeight(drawAdData.getDrawAdDataSource().getImageHeight());
        setImageWidth(drawAdData.getDrawAdDataSource().getImageWidth());
        drawAdData.setAdEventListener(new LTAdDrawNativeEventListener(this) { // from class: com.ltmb.gromoreadapter.LTAdGroMoreDrawNativeAd.1
            public void onAdClicked() {
            }

            public void onAdRenderFail(int i, String str) {
            }

            public void onAdShow() {
            }

            public void onClosed() {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public TTFeedAd.CustomizeVideo getNativeCustomVideoReporter() {
        return new TTFeedAd.CustomizeVideo(this) { // from class: com.ltmb.gromoreadapter.LTAdGroMoreDrawNativeAd.2
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
            public String getVideoUrl() {
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
            public void reportVideoAutoStart() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
            public void reportVideoBreak(long j) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
            public void reportVideoContinue(long j) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
            public void reportVideoError(long j, int i, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
            public void reportVideoFinish() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
            public void reportVideoPause(long j) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
            public void reportVideoStart() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
            public void reportVideoStartError(int i, int i2) {
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public String getVideoUrl() {
        return "video url";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean hasDislike() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onPause() {
        super.onPause();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onResume() {
        super.onResume();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
        super.registerView(activity, viewGroup, list, list2, list3, mediationViewBinder);
        if (list == null || list2 == null) {
            return;
        }
        list.addAll(list2);
    }

    public void removeSelfFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
