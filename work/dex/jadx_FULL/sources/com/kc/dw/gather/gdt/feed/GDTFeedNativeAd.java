package com.kc.dw.gather.gdt.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kc.dw.activity.a;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GDTFeedNativeAd extends MsCustomRecyclerFeedAd {
    private static final String TAG = "GDTFeedNativeAd";
    private MediaView gdtMediaView;
    private final NativeUnifiedADData nativeUnifiedADData;

    public GDTFeedNativeAd(Context context, NativeUnifiedADData nativeUnifiedADData) {
        this.nativeUnifiedADData = nativeUnifiedADData;
        if (nativeUnifiedADData != null) {
            try {
                setTitle(nativeUnifiedADData.getTitle());
                setDesc(nativeUnifiedADData.getDesc());
                setActionText(nativeUnifiedADData.getButtonText());
                List<String> imageList = getImageList(nativeUnifiedADData);
                if (imageList != null && !imageList.isEmpty()) {
                    this.imgUrls = new String[imageList.size()];
                    Iterator<String> it = imageList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        this.imgUrls[i] = it.next();
                        i++;
                    }
                }
                int adPatternType = getAdPatternType(nativeUnifiedADData);
                setAdPatternType(adPatternType);
                setInteractionType(getInteractionType(nativeUnifiedADData));
                if (nativeUnifiedADData.getIconUrl() != null) {
                    setIconUrl(nativeUnifiedADData.getIconUrl());
                }
                if (nativeUnifiedADData.getAppMiitInfo() != null) {
                    setAppName(nativeUnifiedADData.getAppMiitInfo().getAppName());
                    setAppVersion(nativeUnifiedADData.getAppMiitInfo().getVersionName());
                    setDeveloper(nativeUnifiedADData.getAppMiitInfo().getAuthorName());
                    setPrivacyAgreement(nativeUnifiedADData.getAppMiitInfo().getPrivacyAgreement());
                    setAppPremissionUrl(nativeUnifiedADData.getAppMiitInfo().getPermissionsUrl());
                    setAppIntroUrl(nativeUnifiedADData.getAppMiitInfo().getDescriptionUrl());
                }
                if (adPatternType == 2) {
                    MediaView mediaView = new MediaView(context);
                    this.gdtMediaView = mediaView;
                    setMediaView(mediaView);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int getAdPatternType(NativeUnifiedADData nativeUnifiedADData) {
        try {
            int adPatternType = nativeUnifiedADData.getAdPatternType();
            if (adPatternType != 2) {
                return adPatternType != 3 ? 12 : 13;
            }
            return 2;
        } catch (Throwable th) {
            th.printStackTrace();
            return 12;
        }
    }

    private List<String> getImageList(NativeUnifiedADData nativeUnifiedADData) {
        ArrayList arrayList = new ArrayList();
        try {
            int adPatternType = nativeUnifiedADData.getAdPatternType();
            if (adPatternType == 1 || adPatternType == 4 || adPatternType == 2) {
                arrayList.add(nativeUnifiedADData.getImgUrl());
            } else if (adPatternType == 3) {
                arrayList.addAll(nativeUnifiedADData.getImgList());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    private int getInteractionType(NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData == null) {
            return 0;
        }
        try {
            return !nativeUnifiedADData.isAppAd() ? 1 : 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list) {
        try {
            NativeAdContainer nativeAdContainer = new NativeAdContainer(viewGroup.getContext());
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                int iIndexOfChild = viewGroup2.indexOfChild(viewGroup);
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
                viewGroup2.removeView(viewGroup);
                nativeAdContainer.setId(viewGroup.getId());
                nativeAdContainer.addView(viewGroup, layoutParams2);
                viewGroup2.addView((View) nativeAdContainer, iIndexOfChild, layoutParams);
            }
            this.nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener(this) { // from class: com.kc.dw.gather.gdt.feed.GDTFeedNativeAd.1
                public final GDTFeedNativeAd this$0;

                {
                    this.this$0 = this;
                }

                public void onADClicked() {
                    LogUtil.d(GDTFeedNativeAd.TAG, "onADClicked");
                    this.this$0.callAdClicked();
                }

                public void onADError(AdError adError) {
                    StringBuilder sbA = a.a("GDT onADError: code=");
                    sbA.append(adError.getErrorCode());
                    sbA.append(",msg=");
                    sbA.append(adError.getErrorMsg());
                    LogUtil.d(GDTFeedNativeAd.TAG, sbA.toString());
                }

                public void onADExposed() {
                    this.this$0.callAdExposure();
                }

                public void onADStatusChanged() {
                }
            });
            this.nativeUnifiedADData.bindAdToView(context, nativeAdContainer, (FrameLayout.LayoutParams) null, list);
            if (this.adPatternType == 2) {
                VideoOption.Builder builder = new VideoOption.Builder();
                builder.setAutoPlayMuted(true);
                builder.setNeedCoverImage(true);
                builder.setNeedProgressBar(true);
                builder.setEnableDetailPage(true);
                builder.setEnableUserControl(false);
                this.nativeUnifiedADData.bindMediaView(this.gdtMediaView, builder.build(), new NativeADMediaListener(this) { // from class: com.kc.dw.gather.gdt.feed.GDTFeedNativeAd.2
                    public final GDTFeedNativeAd this$0;

                    {
                        this.this$0 = this;
                    }

                    public void onVideoClicked() {
                    }

                    public void onVideoCompleted() {
                    }

                    public void onVideoError(AdError adError) {
                        StringBuilder sbA = a.a("onVideoError,code =");
                        sbA.append(adError.getErrorCode());
                        sbA.append(",msg=");
                        sbA.append(adError.getErrorMsg());
                        LogUtil.d(GDTFeedNativeAd.TAG, sbA.toString());
                    }

                    public void onVideoInit() {
                    }

                    public void onVideoLoaded(int i) {
                        LogUtil.d(GDTFeedNativeAd.TAG, "onVideoLoaded");
                    }

                    public void onVideoLoading() {
                    }

                    public void onVideoPause() {
                    }

                    public void onVideoReady() {
                        LogUtil.d(GDTFeedNativeAd.TAG, "onVideoReady");
                    }

                    public void onVideoResume() {
                    }

                    public void onVideoStart() {
                    }

                    public void onVideoStop() {
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
