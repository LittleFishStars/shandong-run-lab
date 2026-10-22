package com.fl.saas.s2s.mixNative;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.bean.MediaReturnMaterialBean;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.innterNative.ActionView;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.json.Yson;
import com.fl.saas.s2s.mixNative.S2SNative;
import com.fl.saas.s2s.sdk.ad.S2STemplateViewHelper;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class S2SNativeExpress extends BaseNativeAd<S2SNative> implements BiddingResult, AdChangeCacheData {
    private int clickType;
    private final S2STemplateViewHelper helper;
    private final AdInfoPoJo mPoJo;
    private final NativeAdView nativeAdView;

    public S2SNativeExpress(@NonNull Context context, S2SNative s2SNative, int i, int i2) {
        super(context, s2SNative);
        AdInfoPoJo adInfoPoJo = s2SNative.getNativeAdOpt().get();
        this.mPoJo = adInfoPoJo;
        int iDip2px = DeviceUtil.dip2px(adInfoPoJo.left_right_margin);
        int iDip2px2 = DeviceUtil.dip2px(adInfoPoJo.top_bottom_margin);
        NativeAdView nativeAdView = new NativeAdView(getContext());
        this.nativeAdView = nativeAdView;
        nativeAdView.setLayoutParams(ViewHelper.getWrapParent());
        S2STemplateViewHelper s2STemplateViewHelper = new S2STemplateViewHelper(context, S2STemplateViewHelper.Type.parse(adInfoPoJo.template_type_id));
        this.helper = s2STemplateViewHelper;
        NativeMaterial adMaterial = s2SNative.getAdMaterial();
        s2STemplateViewHelper.setTitle(adMaterial.getTitle()).setDes(adMaterial.getDescription()).setAction(adMaterial.getCallToAction()).setSize(i, i2).setMedia(adInfoPoJo).setPadding(iDip2px, iDip2px2).setAdLogo(adMaterial.getAdLogo()).setLogo(adMaterial.getIconUrl()).addCloseView().setOnClosedListener(new Runnable() { // from class: com.zj.adlib.hp7
            @Override // java.lang.Runnable
            public final void run() {
                this.f42176a.onAdCloseEvent();
            }
        });
    }

    private boolean isOnlyButton() {
        int i;
        int i2 = this.clickType;
        if (i2 == 1 && ((i = this.mPoJo.creative.ctype) == 1 || i == 3)) {
            return true;
        }
        if (i2 == 2 && this.mPoJo.creative.ctype == 2) {
            return true;
        }
        if (i2 != 3) {
            return false;
        }
        int i3 = this.mPoJo.creative.ctype;
        return i3 > 3 || i3 < 1;
    }

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(final boolean z, final int i, final int i2, final int i3) {
        getNativeAdOpt().ifPresent(new Consumer() { // from class: com.zj.adlib.ip7
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((S2SNative) obj).biddingResult(z, i, i2, i3);
            }
        });
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    public NativeMaterial createNativeMaterial(@NonNull S2SNative s2SNative) {
        return S2SMixNativeHandler.adInfoToNativeMaterial(this.mPoJo, this.nativeAdView);
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd, com.fl.saas.api.mixNative.NativeAd
    public void destroy() {
        super.destroy();
        if (getNativeAd() != null) {
            getNativeAd().destroy();
        }
        S2STemplateViewHelper s2STemplateViewHelper = this.helper;
        if (s2STemplateViewHelper != null) {
            s2STemplateViewHelper.destroy();
        }
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public String getMaterialJson() {
        if (this.mPoJo == null) {
            return "";
        }
        MediaReturnMaterialBean mediaReturnMaterialBean = new MediaReturnMaterialBean();
        mediaReturnMaterialBean.setImageUrl(this.mPoJo.img_url);
        mediaReturnMaterialBean.setVideoUrl(this.mPoJo.video_url);
        mediaReturnMaterialBean.setWidth(this.mPoJo.width);
        mediaReturnMaterialBean.setHeight(this.mPoJo.height);
        mediaReturnMaterialBean.setIcon(this.mPoJo.logo_icon);
        mediaReturnMaterialBean.setTitle(this.mPoJo.title);
        mediaReturnMaterialBean.setDesc(this.mPoJo.description);
        mediaReturnMaterialBean.setDeeplinkUrl(this.mPoJo.deep_url);
        mediaReturnMaterialBean.setLandingPageUrl(this.mPoJo.click_url);
        mediaReturnMaterialBean.setDownloadUrl(this.mPoJo.download_url);
        return new Yson().toJson(mediaReturnMaterialBean);
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    public void init(@NonNull S2SNative s2SNative) {
        s2SNative.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.s2s.mixNative.S2SNativeExpress.1
            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                S2SNativeExpress.this.onAdClickedEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                S2SNativeExpress.this.onAdFailedEvent(ydError);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                S2SNativeExpress.this.onAdImpressedEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoEnd(NativeAdView nativeAdView) {
                S2SNativeExpress.this.onAdVideoEndEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
                S2SNativeExpress.this.onAdVideoProgress(j);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoStart(NativeAdView nativeAdView) {
                S2SNativeExpress.this.onAdVideoStartEvent();
            }
        });
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public boolean isNativeExpress() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    /* JADX INFO: renamed from: render, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void lambda$prepare$0(S2SNative s2SNative, NativePrepareInfo nativePrepareInfo) {
        boolean z;
        View viewLoad = this.helper.load();
        if (viewLoad != null) {
            ViewParent parent = viewLoad.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewLoad);
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z) {
            if (this.mPoJo.getHotType() == 8) {
                this.helper.addFillActionView(s2SNative.bindActionView(ActionView.Type.Template));
            } else {
                this.helper.addActionView(s2SNative.bindActionView(ActionView.Type.Template));
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.nativeAdView.addView(viewLoad, layoutParams);
        s2SNative.renderAdContainer(this.nativeAdView, viewLoad);
        NativePrepareInfo nativePrepareInfo2 = new NativePrepareInfo();
        nativePrepareInfo2.setActivity(nativePrepareInfo.getActivity());
        if (!isOnlyButton()) {
            nativePrepareInfo2.setClickView(viewLoad);
        }
        nativePrepareInfo2.setCtaView((View[]) nativePrepareInfo.getCtaViewList().toArray(new View[0]));
        s2SNative.prepare(nativePrepareInfo2);
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        AdInfoPoJo adInfoPoJo = this.mPoJo;
        if (adInfoPoJo != null) {
            adInfoPoJo.trackId = str;
            String str2 = adSource.place_id;
            adInfoPoJo.place_id = str2;
            adInfoPoJo.global_group_id = adSource.group_id;
            adInfoPoJo.global_place_id = str2;
            adInfoPoJo.global_test_id = adSource.test_id;
        }
    }

    public S2SNativeExpress setClickType(int i) {
        this.clickType = i;
        return this;
    }
}
