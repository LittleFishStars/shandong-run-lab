package com.fl.saas.base.inner.nativead;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdAppInfo;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.adapter.AdViewNativeAdapter;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.bidding.C2SBiddingECPM;
import com.fl.saas.base.inner.InnerNativeAdapter;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.base.widget.AdInfo;
import com.fl.saas.base.widget.WinAdInfo;
import com.fl.saas.common.pojo.NativeADAppMiitInfo;
import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.zj.adlib.p94;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerNativeAdAdapter extends AdViewNativeAdapter implements InnerNativeAdapter, AdChangeCacheData {
    private final String TAG = CommConstant.getObjTag(this);
    private MixNativeHandler handler;
    private NativeAd mNativeAd;

    /* JADX INFO: renamed from: com.fl.saas.base.inner.nativead.InnerNativeAdAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(C2SBiddingECPM.getC2SBiddingECPM(nativeAd, InnerNativeAdAdapter.this.handler));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ int lambda$onNativeAdLoaded$1() {
            return InnerNativeAdAdapter.this.getAdSource().getECPM();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ WinAdInfo lambda$onNativeAdLoaded$2() {
            return InnerNativeAdAdapter.this.getWinInfo();
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(YdError ydError) {
            InnerNativeAdAdapter.this.disposeError(ydError);
        }

        @Override // com.fl.saas.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            InnerNativeAdAdapter.this.bindC2SBidECPM(new Supplier() { // from class: com.fl.saas.base.inner.nativead.a
                @Override // com.fl.saas.common.util.feature.Supplier
                public final Object get() {
                    return this.f1748a.lambda$onNativeAdLoaded$0(nativeAd);
                }
            });
            BaseNativeAd baseNativeAd = (BaseNativeAd) nativeAd;
            baseNativeAd.setEcpmMapper(new BaseNativeAd.EcpmMapper() { // from class: com.fl.saas.base.inner.nativead.b
                @Override // com.fl.saas.base.innterNative.BaseNativeAd.EcpmMapper
                public final int getECPM() {
                    return this.f30126a.lambda$onNativeAdLoaded$1();
                }
            });
            baseNativeAd.setAdInfoMapper(new BaseNativeAd.AdInfoMapper() { // from class: com.fl.saas.base.inner.nativead.InnerNativeAdAdapter.1.1
                @Override // com.fl.saas.base.innterNative.BaseNativeAd.AdInfoMapper
                public AdInfo getAdInfo() {
                    return AdInfo.create(InnerNativeAdAdapter.this.getAdSource().mAdv_id, InnerNativeAdAdapter.this.getAdSource().mTagid, InnerNativeAdAdapter.this.getAdSource().test_id, InnerNativeAdAdapter.this.getAdSource().is_contrast);
                }

                @Override // com.fl.saas.base.innterNative.BaseNativeAd.AdInfoMapper
                public AdSource getSource() {
                    return InnerNativeAdAdapter.this.getAdSource();
                }
            });
            baseNativeAd.setWinAdInfoMapper(new BaseNativeAd.WinAdInfoMapper() { // from class: com.fl.saas.base.inner.nativead.c
                @Override // com.fl.saas.base.innterNative.BaseNativeAd.WinAdInfoMapper
                public final WinAdInfo getAdInfo() {
                    return this.f30127a.lambda$onNativeAdLoaded$2();
                }
            });
            InnerNativeAdAdapter.this.mNativeAd = nativeAd;
            InnerNativeAdAdapter.this.render(nativeAd);
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.base.inner.nativead.InnerNativeAdAdapter$4, reason: invalid class name */
    public class AnonymousClass4 implements NativeEventListener {
        private boolean isReportExposure = false;
        final /* synthetic */ YdNativePojo val$pojo;
        final /* synthetic */ Optional val$pojoOptional;

        public AnonymousClass4(Optional optional, YdNativePojo ydNativePojo) {
            this.val$pojoOptional = optional;
            this.val$pojo = ydNativePojo;
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdClicked(NativeAdView nativeAdView) {
            InnerNativeAdAdapter.this.onClickedEvent(0);
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdClose(NativeAdView nativeAdView) {
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
            InnerNativeAdAdapter.this.onAdFailed(ydError);
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdImpressed(NativeAdView nativeAdView) {
            if (this.isReportExposure) {
                return;
            }
            this.isReportExposure = true;
            InnerNativeAdAdapter.this.onShowEvent(0);
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdVideoEnd(NativeAdView nativeAdView) {
            Optional map = this.val$pojoOptional.map(new p94());
            final YdNativePojo ydNativePojo = this.val$pojo;
            map.ifPresent(new Consumer() { // from class: com.fl.saas.base.inner.nativead.e
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    ((YdNativePojo.VideoEventListener) obj).onVideoComplete(ydNativePojo);
                }
            });
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
        }

        @Override // com.fl.saas.api.mixNative.NativeEventListener
        public void onAdVideoStart(NativeAdView nativeAdView) {
            Optional map = this.val$pojoOptional.map(new p94());
            final YdNativePojo ydNativePojo = this.val$pojo;
            map.ifPresent(new Consumer() { // from class: com.fl.saas.base.inner.nativead.d
                @Override // com.fl.saas.common.util.feature.Consumer
                public final void accept(Object obj) {
                    ((YdNativePojo.VideoEventListener) obj).onVideoStart(ydNativePojo);
                }
            });
        }
    }

    private void bindEvent(NativeAd nativeAd, YdNativePojo ydNativePojo) {
        nativeAd.setNativeEventListener(new AnonymousClass4(Optional.ofNullable(ydNativePojo), ydNativePojo));
    }

    private YdNativePojo createPojo(final NativeAd nativeAd) {
        return new YdNativePojo() { // from class: com.fl.saas.base.inner.nativead.InnerNativeAdAdapter.3
            private List<View> clicks;
            public NativeAdView nativeAdView;

            @Override // com.fl.saas.common.pojo.InnerNativePoJo
            public void bindClickViews(List<View> list) {
                this.clicks = list;
            }

            @Override // com.fl.saas.common.pojo.InnerNativePoJo
            public void bindViewGroup(ViewGroup viewGroup) {
                ViewParent parent = viewGroup.getParent();
                if (parent instanceof NativeAdView) {
                    NativeAdView nativeAdView = (NativeAdView) parent;
                    this.nativeAdView = nativeAdView;
                    nativeAd.renderAdContainer(nativeAdView, viewGroup);
                } else {
                    this.nativeAdView = new NativeAdView(InnerNativeAdAdapter.this.getContext());
                    handleBindView(InnerNativeAdAdapter.this.getContext(), viewGroup, this.nativeAdView);
                    nativeAd.renderAdContainer(this.nativeAdView, viewGroup);
                }
            }

            @Override // com.fl.saas.common.pojo.InnerNativePoJo
            public void closeAd() {
                super.closeAd();
                ViewHelper.removeParent(this.nativeAdView);
            }

            @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
            public AdInfo getAdInfo() {
                return nativeAd.getAdInfo();
            }

            @Override // com.fl.saas.common.pojo.InnerNativePoJo
            public View getAdView() {
                return nativeAd.getAdMaterial().getAdMediaView();
            }

            @Override // com.fl.saas.common.pojo.YdNativePojo
            public YdNativePojo.CustomizeVideo getCustomVideo() {
                return nativeAd.getCustomizeVideo();
            }

            @Override // com.fl.saas.common.pojo.InnerNativePoJo
            public void render() {
                NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
                nativePrepareInfo.setActivity(InnerNativeAdAdapter.this.getActivityOrNull());
                List<View> list = this.clicks;
                if (list != null) {
                    Iterator<View> it = list.iterator();
                    while (it.hasNext()) {
                        nativePrepareInfo.setClickView(it.next());
                    }
                }
                nativeAd.prepare(nativePrepareInfo);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(NativeAd nativeAd) {
        if (nativeAd.isNativeExpress()) {
            LogcatUtil.d(this.TAG, "native but is express ad");
            disposeError(YdError.create(20405, "native but is express ad"));
            return;
        }
        NativeMaterial adMaterial = nativeAd.getAdMaterial();
        ArrayList arrayList = new ArrayList();
        YdNativePojo ydNativePojoCreatePojo = createPojo(nativeAd);
        ydNativePojoCreatePojo.setTitle(adMaterial.getTitle());
        ydNativePojoCreatePojo.setDesc(adMaterial.getDescription());
        ydNativePojoCreatePojo.setBtnText(adMaterial.getCallToAction());
        ydNativePojoCreatePojo.setIconUrl(adMaterial.getIconUrl());
        String mainImageUrl = adMaterial.getMainImageUrl();
        List<String> imageUrlList = adMaterial.getImageUrlList();
        if (TextUtils.isEmpty(mainImageUrl) && imageUrlList != null && !imageUrlList.isEmpty()) {
            for (String str : imageUrlList) {
                if (!TextUtils.isEmpty(str)) {
                    mainImageUrl = str;
                    break;
                }
            }
        }
        ydNativePojoCreatePojo.setImgUrl(mainImageUrl);
        ydNativePojoCreatePojo.setImgList(imageUrlList);
        ydNativePojoCreatePojo.setECPM(getAdSource().getPrice());
        ydNativePojoCreatePojo.setVideoDuration(adMaterial.getVideoDuration());
        ydNativePojoCreatePojo.setCornerMark(adMaterial.getAdLogo());
        ydNativePojoCreatePojo.setAdLogoBitmap(adMaterial.getAdLogoBitmap());
        ydNativePojoCreatePojo.setAdLogoUrl(adMaterial.getAdLogoUrl());
        final NativeAdAppInfo adAppInfo = adMaterial.getAdAppInfo();
        if (adAppInfo != null) {
            ydNativePojoCreatePojo.setAppInfo(new NativeADAppMiitInfo() { // from class: com.fl.saas.base.inner.nativead.InnerNativeAdAdapter.2
                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public String getAppName() {
                    return adAppInfo.getAppName();
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public String getAuthorName() {
                    return adAppInfo.getPublisher();
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public String getFunctionUrl() {
                    return adAppInfo.getFunctionUrl();
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public long getPackageSizeBytes() {
                    return 0L;
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public Map<String, String> getPermissionsMap() {
                    return null;
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public String getPermissionsUrl() {
                    return adAppInfo.getAppPermissionUrl();
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public String getPrivacyAgreement() {
                    return adAppInfo.getAppPrivacyUrl();
                }

                @Override // com.fl.saas.common.pojo.NativeADAppMiitInfo
                public String getVersionName() {
                    return adAppInfo.getAppVersion();
                }
            });
        }
        arrayList.add(ydNativePojoCreatePojo);
        onLoadedEvent(arrayList);
        bindEvent(nativeAd, ydNativePojoCreatePojo);
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        innerDestroy(this.handler, this.mNativeAd);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter
    @Nullable
    public NativeAd getNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        this.handler = loadNativeHandler();
        this.handler.setContext(getContext()).setAdId(getAppId(), getPosId()).setAdSource(getAdSource()).setAdParams(new AdParams.Builder(getKey()).setImageAcceptedWidth(getWidth()).setImageAcceptedHeight(getHeight()).build()).setLoadListener(new AnonymousClass1());
        this.handler.setAdStyle(NativeStyle.NATIVE);
        this.handler.init();
        this.handler.load(activity);
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof AdChangeCacheData) {
            ((AdChangeCacheData) nativeAd).setCacheData(str, adSource);
        }
    }
}
