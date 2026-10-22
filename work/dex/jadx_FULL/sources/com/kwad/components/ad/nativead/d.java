package com.kwad.components.ad.nativead;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.nativead.monitor.NativeAdMonitor;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KsLiveInfo;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.wrapper.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.components.core.internal.api.a {
    private Vibrator hw;
    private AdInfo mAdInfo;
    private final AdResultData mAdResultData;

    @NonNull
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private volatile bx mTimerHelper;
    private com.kwad.components.ad.nativead.c.a pA;
    private boolean pB;
    private b.c pl;
    private b.e pm;
    private boolean pr;

    @Nullable
    private KsNativeAd.AdInteractionListener ps;
    private f pt;
    private e pu;

    @Nullable
    private KsNativeAd.VideoPlayListener pv;
    private com.kwad.components.ad.nativead.e.a pz;
    private boolean pw = false;
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();
    private int px = 0;
    private int py = 0;
    private KsNativeAd.VideoPlayListener pC = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.components.ad.nativead.d.10
        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            if (d.this.pv != null) {
                d.this.pv.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i, int i2) {
            if (d.this.pv != null) {
                d.this.pv.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
            if (d.this.pv != null) {
                try {
                    d.this.pv.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
            if (d.this.pv != null) {
                try {
                    d.this.pv.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
            if (d.this.pv != null) {
                try {
                    d.this.pv.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            if (d.this.pv != null) {
                d.this.pv.onVideoPlayStart();
            }
        }
    };
    private a pD = new a() { // from class: com.kwad.components.ad.nativead.d.2
        @Override // com.kwad.components.ad.nativead.d.a
        public final void fy() {
            if (d.this.ps != null) {
                d.this.ps.onAdShow(d.this);
            }
        }

        @Override // com.kwad.components.ad.nativead.d.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (d.this.ps == null) {
                return false;
            }
            try {
                return d.this.ps.handleDownloadDialog(onClickListener);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                return false;
            }
        }

        @Override // com.kwad.components.ad.nativead.d.a
        public final void l(View view) {
            if (d.this.ps != null) {
                d.this.ps.onAdClicked(new FrameLayout(m.eP(view.getContext())), d.this);
            }
        }

        @Override // com.kwad.components.ad.nativead.d.a
        public final void onDownloadTipsDialogDismiss() {
            if (d.this.ps != null) {
                try {
                    d.this.ps.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.components.ad.nativead.d.a
        public final void onDownloadTipsDialogShow() {
            if (d.this.ps != null) {
                try {
                    d.this.ps.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }
    };

    public interface a {
        void fy();

        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        void l(View view);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public d(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        this.mAdTemplate = adTemplateR;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplateR);
        this.mAdInfo = adInfoEO;
        if (com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
            com.kwad.components.core.e.d.d dVar = new com.kwad.components.core.e.d.d(this.mAdTemplate);
            this.mApkDownloadHelper = dVar;
            dVar.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            this.mApkDownloadHelper.a(new com.kwad.components.core.e.d.d.a() { // from class: com.kwad.components.ad.nativead.d.1
                @Override // com.kwad.components.core.e.d.d.a
                public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return d.this.pD.handleDownloadDialog(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.helper.a.Q(this.mAdInfo), this.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator F(Context context) {
        if (this.hw == null) {
            this.hw = (Vibrator) context.getSystemService("vibrator");
        }
        return this.hw;
    }

    private static int[] ad(int i) {
        int i2;
        int i3;
        if (i == 3 || i == 4) {
            i2 = 1;
            i3 = 0;
        } else if (i == 5 || i == 6) {
            i3 = 1;
            i2 = 0;
        } else {
            i3 = 0;
            i2 = 0;
        }
        return new int[]{i % 2 == 0 ? 2 : 1, i3, i2};
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    /* JADX INFO: renamed from: fv, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.core.internal.api.d getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBb = com.kwad.sdk.core.response.helper.a.bb(this.mAdInfo);
        if (TextUtils.isEmpty(materialFeatureBb.coverUrl)) {
            return null;
        }
        return new com.kwad.components.core.internal.api.d(materialFeatureBb.width, materialFeatureBb.height, materialFeatureBb.coverUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw() {
        try {
            NativeAdExtraDataImpl nativeAdExtraDataImpl = this.mAdTemplate.mAdScene.nativeAdExtraData;
            this.px = nativeAdExtraDataImpl.showLiveStatus;
            this.py = nativeAdExtraDataImpl.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fx() {
        int i = this.mAdInfo.status;
        return (i == 2 || i == 3) ? false : true;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final boolean enableRotate() {
        AdMatrixInfo.RotateInfo rotateInfoDN = com.kwad.sdk.core.response.helper.b.dN(this.mAdTemplate);
        return rotateInfoDN != null && rotateInfoDN.enable;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getActionDescription() {
        return com.kwad.sdk.core.response.helper.a.aK(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdDescription() {
        return com.kwad.sdk.core.response.helper.a.aA(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSource() {
        return com.kwad.sdk.core.response.helper.a.aJ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSourceLogoUrl(int i) {
        AdInfo adInfo = this.mAdInfo;
        if (adInfo == null) {
            return null;
        }
        return i != 1 ? adInfo.adBaseInfo.adMarkIcon : adInfo.adBaseInfo.adGrayMarkIcon;
    }

    @Override // com.kwad.components.core.internal.api.a
    @NonNull
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.helper.a.aF(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppIconUrl() {
        return com.kwad.sdk.core.response.helper.a.cv(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppName() {
        return com.kwad.sdk.core.response.helper.a.aB(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPackageName() {
        return com.kwad.sdk.core.response.helper.a.aE(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final long getAppPackageSize() {
        return com.kwad.sdk.core.response.helper.a.bP(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.helper.a.bN(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final float getAppScore() {
        return com.kwad.sdk.core.response.helper.a.aG(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppVersion() {
        return com.kwad.sdk.core.response.helper.a.bO(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getCorporationName() {
        return com.kwad.sdk.core.response.helper.a.bI(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.helper.a.aX(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        int iBk = com.kwad.sdk.core.response.helper.a.bk(this.mAdInfo);
        if (iBk == 2 || iBk == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfoEO.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.components.core.internal.api.d(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.helper.a.aW(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getIntroductionInfo() {
        return com.kwad.sdk.core.response.helper.a.bL(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getIntroductionInfoUrl() {
        return com.kwad.sdk.core.response.helper.a.bM(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final KsLiveInfo getLiveInfo() {
        if (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPV)) {
            return com.kwad.sdk.core.response.helper.e.ff(this.mAdTemplate);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.helper.a.bk(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.e.JP()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfo() {
        return com.kwad.sdk.core.response.helper.a.bJ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfoUrl() {
        return com.kwad.sdk.core.response.helper.a.bK(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getProductName() {
        return com.kwad.sdk.core.response.helper.a.aD(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final View getRotateView(Context context) {
        if (this.pz == null) {
            com.kwad.components.ad.nativead.e.a aVar = new com.kwad.components.ad.nativead.e.a(context);
            this.pz = aVar;
            aVar.fY();
            NativeAdMonitor.fF();
            NativeAdMonitor.fE();
        }
        return this.pz;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final Bitmap getSdkLogo() {
        return BitmapFactory.decodeResource(ServiceProvider.getContext().getResources(), R.drawable.ksad_sdk_logo);
    }

    public final synchronized bx getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bx();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoDuration() {
        return com.kwad.sdk.core.response.helper.a.N(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoHeight() {
        if (com.kwad.sdk.core.response.helper.a.cY(this.mAdInfo)) {
            return 1280;
        }
        return com.kwad.sdk.core.response.helper.a.bb(this.mAdInfo).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getVideoUrl() {
        return com.kwad.sdk.core.response.helper.a.M(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, boolean z) {
        if (context == null || !o.Gs().Fx()) {
            return null;
        }
        return getVideoView2(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).build());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoWidth() {
        if (com.kwad.sdk.core.response.helper.a.cY(this.mAdInfo)) {
            return 720;
        }
        return com.kwad.sdk.core.response.helper.a.bb(this.mAdInfo).videoWidth;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.pD.onDownloadTipsDialogDismiss();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        a aVar = this.pD;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void pauseVideo() {
        f fVar = this.pt;
        if (fVar != null) {
            fVar.setPlayState(2);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        registerViewForInteraction((Activity) null, viewGroup, list, adInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayEnd() {
        com.kwad.sdk.core.adlog.c.cu(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayStart() {
        com.kwad.sdk.core.adlog.c.ct(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar == null || ksAppDownloadListener == null) {
            return;
        }
        dVar.b(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.pv = videoPlayListener;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void startVideo() {
        f fVar = this.pt;
        if (fVar != null) {
            fVar.setPlayState(1);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void stopVideo() {
        f fVar = this.pt;
        if (fVar != null) {
            fVar.setPlayState(3);
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    private void c(ViewGroup viewGroup) {
        AdTemplate adTemplate;
        try {
            Context contextWrapContextIfNeed = m.wrapContextIfNeed(viewGroup.getContext());
            if (!(viewGroup instanceof FrameLayout) || (adTemplate = this.mAdTemplate) == null || !com.kwad.sdk.core.response.helper.b.dE(adTemplate) || this.pB) {
                return;
            }
            com.kwad.components.ad.nativead.c.a aVar = new com.kwad.components.ad.nativead.c.a(contextWrapContextIfNeed);
            this.pA = aVar;
            aVar.setAdInteractionListener(this.pD);
            this.pA.a(this.mAdResultData, this.mApkDownloadHelper);
            viewGroup.addView(this.pA);
            this.pB = true;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static com.kwad.components.core.widget.c d(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.c) {
                return (com.kwad.components.core.widget.c) childAt;
            }
        }
        return null;
    }

    private static void e(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final View view) {
        if (com.kwad.sdk.core.response.helper.a.am(this.mAdInfo) || com.kwad.sdk.core.response.helper.b.dz(this.mAdTemplate)) {
            float fDA = com.kwad.sdk.core.response.helper.b.dA(this.mAdTemplate);
            if (fDA <= 0.0f) {
                fDA = com.kwad.sdk.core.response.helper.a.an(this.mAdInfo);
            }
            float f = fDA;
            this.pm = new b.e() { // from class: com.kwad.components.ad.nativead.d.8
                @Override // com.kwad.components.ad.nativead.b.e
                public final boolean b(final double d) {
                    if ((d.this.pA != null && d.this.pA.fS() && !d.this.pA.fR()) || !d.this.fx() || !b.ce()) {
                        return false;
                    }
                    com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(m.wrapContextIfNeed(view.getContext())).aJ(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).az(false).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.nativead.d.8.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().ec(157).j(d), (JSONObject) null);
                            d.this.pD.l(view);
                        }
                    }));
                    by.a(view.getContext(), d.this.F(view.getContext()));
                    return true;
                }
            };
            b.ft().a(com.kwad.sdk.core.response.helper.b.dz(this.mAdTemplate) || com.kwad.sdk.core.response.helper.a.am(this.mAdInfo), f, view, this.pm, com.kwad.sdk.core.response.helper.b.dK(this.mAdInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final View view) {
        AdMatrixInfo.RotateInfo rotateInfoDN = com.kwad.sdk.core.response.helper.b.dN(this.mAdTemplate);
        if (rotateInfoDN == null || !rotateInfoDN.enable) {
            return;
        }
        this.pl = new b.c() { // from class: com.kwad.components.ad.nativead.d.9
            @Override // com.kwad.components.ad.nativead.b.c
            public final boolean u(final String str) {
                if (d.this.pA != null && d.this.pA.fT() && !d.this.pA.fR()) {
                    return false;
                }
                if (!cb.r(view, (int) (com.kwad.sdk.core.config.e.Kd() * 100.0f)) || !d.this.fx() || !b.ce()) {
                    return false;
                }
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(m.wrapContextIfNeed(view.getContext())).aJ(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).az(false).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.nativead.d.9.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().ec(161).ef(str), (JSONObject) null);
                        d.this.pD.l(view);
                    }
                }));
                by.a(view.getContext(), d.this.F(view.getContext()));
                return true;
            }
        };
        b.ft().a(rotateInfoDN, view.getContext(), this.pl);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        NativeAdMonitor.a(viewGroup, 1);
        this.ps = adInteractionListener;
        b(viewGroup);
        a(activity, viewGroup, list);
        c(viewGroup);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.m(adTemplate, j2);
    }

    public static /* synthetic */ boolean b(d dVar, al.a aVar) {
        return c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(al.a aVar) {
        return com.kwad.sdk.utils.b.a(aVar, com.kwad.sdk.core.response.helper.a.X(this.mAdInfo));
    }

    private void b(final ViewGroup viewGroup) {
        if (!this.pr) {
            this.pr = true;
            com.kwad.sdk.commercial.convert.c.cg(this.mAdTemplate);
        }
        if (!com.kwad.sdk.core.config.e.Kg() && com.kwad.sdk.core.config.e.Kf() >= 0.0f) {
            e(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            NativeAdMonitor.a(viewGroup, 2);
            aVar.setViewCallback(new com.kwad.components.core.widget.a.InterfaceC1245a() { // from class: com.kwad.components.ad.nativead.d.6
                @Override // com.kwad.components.core.widget.a.InterfaceC1245a
                public final void aD() {
                    try {
                        if (d.this.mAdTemplate.mPvReported && d.this.pw) {
                            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, d.this.getTimerHelper().Xg(), (JSONObject) null);
                            d.this.pw = false;
                            b.ft().a(d.this.pm);
                            b.ft().a(d.this.pl);
                            b.ft().D(viewGroup.getContext());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC1245a
                public final void ae() {
                    com.kwad.components.ad.i.b.gd().a(d.this);
                    if (d.this.pA != null) {
                        d.this.pA.setVisibility(0);
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC1245a
                public final void af() {
                    try {
                        long jXg = d.this.getTimerHelper().Xg();
                        if (d.this.mAdTemplate.mPvReported && d.this.pw) {
                            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, jXg, (JSONObject) null);
                            d.this.pw = false;
                        }
                        if (com.kwad.sdk.core.response.helper.a.cZ(d.this.mAdInfo)) {
                            com.kwad.sdk.core.adlog.c.q(d.this.mAdTemplate, ((int) jXg) / 1000);
                        }
                        d.this.bz.i(d.this);
                        b.ft().a(d.this.pm);
                        b.ft().a(d.this.pl);
                        com.kwad.components.ad.i.b.gd().b(d.this);
                        if (d.this.pA != null) {
                            d.this.pA.setVisibility(8);
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC1245a
                public final void b(View view) {
                    if (!d.this.mAdTemplate.mPvReported) {
                        d.this.pD.fy();
                        d.this.fw();
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.z(viewGroup.getHeight(), viewGroup.getWidth());
                        if (com.kwad.sdk.core.response.helper.a.cY(d.this.mAdInfo)) {
                            com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
                            c1273a.showLiveStyle = d.this.py;
                            c1273a.showLiveStatus = d.this.px;
                            bVar.b(c1273a);
                        }
                        com.kwad.components.core.t.b.wF().a(d.this.mAdTemplate, null, bVar);
                        if (d.this.enableRotate()) {
                            com.kwad.sdk.core.adlog.c.b(d.this.mAdTemplate, 184, (JSONObject) null);
                        }
                        NativeAdMonitor.a(viewGroup, 4);
                    }
                    if (!d.this.pw) {
                        d.this.j(view);
                        d.this.k(view);
                        d.this.getTimerHelper().startTiming();
                        d.this.bz.h(d.this);
                    }
                    b.ft().N(viewGroup.getContext());
                    d.this.pw = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC1245a
                public final void onWindowFocusChanged(boolean z) {
                    ViewGroup viewGroup2;
                    if (!z || (viewGroup2 = viewGroup) == null) {
                        return;
                    }
                    viewGroup2.getWidth();
                }
            });
            viewGroup.addView(aVar);
            aVar.zM();
            return;
        }
        com.kwad.components.core.widget.c cVarD = d(viewGroup);
        if (cVarD == null) {
            cVarD = new com.kwad.components.core.widget.c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(cVarD);
        }
        cVarD.setViewCallback(new com.kwad.components.core.widget.c.a() { // from class: com.kwad.components.ad.nativead.d.7
            @Override // com.kwad.components.core.widget.c.a
            public final void fz() {
                if (!d.this.mAdTemplate.mPvReported) {
                    d.this.pD.fy();
                }
                d.this.fw();
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.z(viewGroup.getHeight(), viewGroup.getWidth());
                if (com.kwad.sdk.core.response.helper.a.cY(d.this.mAdInfo)) {
                    com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
                    c1273a.showLiveStyle = d.this.py;
                    c1273a.showLiveStatus = d.this.px;
                    bVar.b(c1273a);
                }
                com.kwad.components.core.t.b.wF().a(d.this.mAdTemplate, null, bVar);
                com.kwad.sdk.commercial.convert.c.ch(d.this.mAdTemplate);
            }
        });
        cVarD.setNeedCheckingShow(true);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public final View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl;
        if (context == null || !o.Gs().Fx()) {
            return null;
        }
        try {
            Context contextWrapContextIfNeed = m.wrapContextIfNeed(context);
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            } else {
                kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
            }
            if (com.kwad.sdk.core.response.helper.a.cY(this.mAdInfo)) {
                return a(contextWrapContextIfNeed, kSAdVideoPlayConfigImpl);
            }
            return b(contextWrapContextIfNeed, kSAdVideoPlayConfigImpl);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("getVideoView fail--context:" + context.getClass().getName() + "--classloader:" + context.getClassLoader().getClass().getName());
            if (o.Gs().Fu()) {
                runtimeException.addSuppressed(th);
                com.kwad.components.core.d.a.reportSdkCaughtException(runtimeException);
                return null;
            }
            throw th;
        }
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list) {
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            a(activity, viewGroup, 0, it.next(), false);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map, KsNativeAd.AdInteractionListener adInteractionListener) {
        NativeAdMonitor.a(viewGroup, 1);
        this.ps = adInteractionListener;
        b(viewGroup);
        a(activity, viewGroup, map);
        c(viewGroup);
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map) {
        for (View view : map.keySet()) {
            if (map.get(view) != null) {
                a(activity, viewGroup, map.get(view).intValue(), view, true);
            }
        }
    }

    private static boolean c(al.a aVar) {
        return (Math.abs(aVar.VE() - aVar.VG()) < 20) && (Math.abs(aVar.VF() - aVar.VH()) < 20);
    }

    private void a(final Activity activity, @NonNull final ViewGroup viewGroup, int i, final View view, final boolean z) {
        final al.a aVar = new al.a();
        if (view == null) {
            return;
        }
        final int[] iArrAd = ad(i);
        if (view instanceof f) {
            ((f) view).g(iArrAd[1], iArrAd[2]);
        } else {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.nativead.d.3
                private int[] pF = new int[2];

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        aVar.H(viewGroup.getWidth(), viewGroup.getHeight());
                        viewGroup.getLocationOnScreen(this.pF);
                        aVar.j(Math.abs(motionEvent.getRawX() - this.pF[0]), Math.abs(motionEvent.getRawY() - this.pF[1]));
                    } else if (action == 1) {
                        aVar.k(Math.abs(motionEvent.getRawX() - this.pF[0]), Math.abs(motionEvent.getRawY() - this.pF[1]));
                        if (com.kwad.sdk.utils.b.g(aVar)) {
                            if (iArrAd[2] != 1 && d.this.b(aVar)) {
                                view.setPressed(false);
                                d.this.a(activity, view2, aVar, iArrAd[0], z, 153);
                            }
                            return true;
                        }
                        if (iArrAd[1] != 1 && com.kwad.sdk.core.config.e.Jm()) {
                            if (d.b(d.this, aVar)) {
                                d.this.a(activity, view2, aVar, iArrAd[0], z, 0);
                            }
                            return true;
                        }
                    }
                    return false;
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.nativead.d.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int[] iArr = iArrAd;
                    if (iArr[1] != 0) {
                        return;
                    }
                    d.this.a(activity, view2, aVar, iArr[0], z, 0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable Activity activity, final View view, final al.a aVar, int i, boolean z, final int i2) {
        long playDuration;
        com.kwad.components.ad.nativead.d.a aVar2;
        IAdLivePlayModule iAdLivePlayModule;
        Context context = activity;
        if (activity == null) {
            context = view.getContext();
        }
        Context contextWrapContextIfNeed = m.wrapContextIfNeed(context);
        e eVar = this.pu;
        if (eVar != null && (iAdLivePlayModule = eVar.ir) != null) {
            playDuration = iAdLivePlayModule.getPlayDuration();
        } else {
            f fVar = this.pt;
            playDuration = (fVar == null || (aVar2 = fVar.pX) == null) ? 0L : aVar2.getPlayDuration();
        }
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(contextWrapContextIfNeed).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).aQ(i).as(true).D(playDuration).az(z).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.nativead.d.5
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(aVar).ec(i2), (JSONObject) null);
                d.this.pD.l(view);
            }
        }));
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    private View b(Context context, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.d.c.w("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.pt == null) {
            f fVar = new f(context);
            this.pt = fVar;
            fVar.setInnerAdInteractionListener(this.pD);
            this.pt.setVideoPlayListener(this.pC);
            this.pt.a(this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.pt;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    private View a(Context context, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        com.kwad.components.core.offline.a.c.a aVar = (com.kwad.components.core.offline.a.c.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.c.a.class);
        if (aVar == null || !aVar.tu()) {
            return null;
        }
        if (this.pu == null) {
            e eVar = new e(context);
            this.pu = eVar;
            eVar.setInnerAdInteractionListener(this.pD);
            this.pu.setVideoPlayListener(this.pC);
            this.pu.a(context, this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.pu;
    }
}
