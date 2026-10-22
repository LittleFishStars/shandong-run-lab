package com.kc.dw.gather.ks.feed;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class KSFeedNativeAd extends MsCustomRecyclerFeedAd {
    private final Context context;
    private final KsNativeAd ksNativeAd;

    public KSFeedNativeAd(Context context, KsNativeAd ksNativeAd) {
        this.context = context;
        this.ksNativeAd = ksNativeAd;
        if (ksNativeAd != null) {
            try {
                setTitle(ksNativeAd.getAppName());
                setDesc(ksNativeAd.getAdDescription());
                setActionText(ksNativeAd.getActionDescription());
                setFrom(ksNativeAd.getAdSource());
                List<String> imgList = getImgList(ksNativeAd);
                if (imgList != null && !imgList.isEmpty()) {
                    this.imgUrls = new String[imgList.size()];
                    Iterator<String> it = imgList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        this.imgUrls[i] = it.next();
                        i++;
                    }
                }
                setAdPatternType(getAdPatternType(ksNativeAd));
                setInteractionType(getInteractionType(ksNativeAd));
                setFromLogo(ksNativeAd.getAdSourceLogoUrl(0));
                if (ksNativeAd.getAppIconUrl() != null) {
                    setIconUrl(ksNativeAd.getAppIconUrl());
                }
                setAppName(ksNativeAd.getAppName());
                setAppVersion(ksNativeAd.getAppVersion());
                setDeveloper(ksNativeAd.getCorporationName());
                setPrivacyAgreement(ksNativeAd.getAppPrivacyUrl());
                setAppPremissionUrl(ksNativeAd.getPermissionInfoUrl());
                setAppIntroUrl(ksNativeAd.getIntroductionInfo());
                setMediaView(ksNativeAd.getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int getAdPatternType(KsNativeAd ksNativeAd) {
        try {
            int materialType = ksNativeAd.getMaterialType();
            if (materialType != 1) {
                return materialType != 3 ? 12 : 13;
            }
            return 2;
        } catch (Exception e) {
            e.printStackTrace();
            return 12;
        }
    }

    private List<String> getImgList(KsNativeAd ksNativeAd) {
        ArrayList arrayList = new ArrayList();
        try {
            List<KsImage> imageList = ksNativeAd.getImageList();
            KsImage videoCoverImage = ksNativeAd.getVideoCoverImage();
            if (videoCoverImage != null && !TextUtils.isEmpty(videoCoverImage.getImageUrl())) {
                arrayList.add(videoCoverImage.getImageUrl());
            }
            if (imageList != null && !imageList.isEmpty()) {
                for (int i = 0; i < imageList.size(); i++) {
                    KsImage ksImage = imageList.get(i);
                    if (ksImage != null) {
                        arrayList.add(ksImage.getImageUrl());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private int getInteractionType(KsNativeAd ksNativeAd) {
        try {
            return ksNativeAd.getInteractionType() == 1 ? 1 : 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list) {
        try {
            KsNativeAd ksNativeAd = this.ksNativeAd;
            if (ksNativeAd != null) {
                ksNativeAd.registerViewForInteraction((Activity) context, viewGroup, list, new KsNativeAd.AdInteractionListener(this) { // from class: com.kc.dw.gather.ks.feed.KSFeedNativeAd.1
                    public final KSFeedNativeAd this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                        return false;
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdClicked(View view, KsNativeAd ksNativeAd2) {
                        this.this$0.callAdClicked();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdShow(KsNativeAd ksNativeAd2) {
                        this.this$0.callAdExposure();
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogShow() {
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
