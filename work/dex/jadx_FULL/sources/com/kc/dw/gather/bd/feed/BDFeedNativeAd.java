package com.kc.dw.gather.bd.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BDFeedNativeAd extends MsCustomRecyclerFeedAd {
    private final NativeResponse nativeResponse;

    /* JADX INFO: renamed from: com.kc.dw.gather.bd.feed.BDFeedNativeAd$3, reason: invalid class name */
    @Keep
    public static /* synthetic */ class AnonymousClass3 {
        public static final int[] $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType;

        static {
            int[] iArr = new int[NativeResponse.MaterialType.values().length];
            $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType = iArr;
            try {
                iArr[NativeResponse.MaterialType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType[NativeResponse.MaterialType.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public BDFeedNativeAd(Context context, NativeResponse nativeResponse) {
        this.nativeResponse = nativeResponse;
        if (nativeResponse != null) {
            try {
                setTitle(nativeResponse.getTitle());
                setDesc(nativeResponse.getDesc());
                setActionText(nativeResponse.getActButtonString());
                List<String> imgList = getImgList(nativeResponse);
                if (imgList != null && !imgList.isEmpty()) {
                    this.imgUrls = new String[imgList.size()];
                    Iterator<String> it = imgList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        this.imgUrls[i] = it.next();
                        i++;
                    }
                }
                setAdPatternType(getAdPatternType(nativeResponse));
                setInteractionType(getInteractionType(nativeResponse));
                setFromLogo(nativeResponse.getBaiduLogoUrl());
                if (nativeResponse.getIconUrl() != null) {
                    setIconUrl(nativeResponse.getIconUrl());
                }
                setAppVersion(nativeResponse.getAppVersion());
                setDeveloper(nativeResponse.getPublisher());
                setPrivacyAgreement(nativeResponse.getAppPrivacyLink());
                setAppPremissionUrl(nativeResponse.getAppPermissionLink());
                setAppIntroUrl(nativeResponse.getAppFunctionLink());
                setMediaView(getVideoView(context, nativeResponse));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int getAdPatternType(NativeResponse nativeResponse) {
        int i = AnonymousClass3.$SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType[nativeResponse.getMaterialType().ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return 12;
        }
        if (nativeResponse.getMultiPicUrls() != null) {
            return 13;
        }
        return (nativeResponse.getIconUrl() != null ? nativeResponse.getIconUrl() : "").equals(nativeResponse.getImageUrl()) ? 11 : 12;
    }

    private List<String> getImgList(NativeResponse nativeResponse) {
        ArrayList arrayList = new ArrayList();
        if (nativeResponse != null) {
            try {
                if (!TextUtils.isEmpty(nativeResponse.getImageUrl())) {
                    arrayList.add(nativeResponse.getImageUrl());
                }
                List multiPicUrls = nativeResponse.getMultiPicUrls();
                if (multiPicUrls != null && !multiPicUrls.isEmpty()) {
                    arrayList.addAll(multiPicUrls);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    private int getInteractionType(NativeResponse nativeResponse) {
        int adActionType = nativeResponse.getAdActionType();
        return (adActionType == 1 || adActionType != 2) ? 0 : 1;
    }

    private View getVideoView(Context context, NativeResponse nativeResponse) {
        XNativeView xNativeView = new XNativeView(context);
        xNativeView.setNativeItem(nativeResponse);
        xNativeView.setVideoMute(true);
        xNativeView.post(new Runnable(this, xNativeView) { // from class: com.kc.dw.gather.bd.feed.BDFeedNativeAd.1
            public final BDFeedNativeAd this$0;
            public final XNativeView val$xNativeView;

            {
                this.this$0 = this;
                this.val$xNativeView = xNativeView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$xNativeView.render();
            }
        });
        return xNativeView;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list) {
        NativeResponse nativeResponse = this.nativeResponse;
        if (nativeResponse != null) {
            nativeResponse.registerViewForInteraction(viewGroup, list, (List) null, new NativeResponse.AdInteractionListener(this) { // from class: com.kc.dw.gather.bd.feed.BDFeedNativeAd.2
                public final BDFeedNativeAd this$0;

                {
                    this.this$0 = this;
                }

                public void onADExposed() {
                    this.this$0.callAdExposure();
                }

                public void onADExposureFailed(int i) {
                }

                public void onADStatusChanged() {
                }

                public void onAdClick() {
                    this.this$0.callAdClicked();
                }

                public void onAdUnionClick() {
                }
            });
        }
    }
}
