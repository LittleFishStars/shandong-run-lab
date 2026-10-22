package com.fl.saas.fl.mixNative;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import com.fl.saas.adx.api.mixNative.NativeAd;
import com.fl.saas.adx.api.mixNative.NativeAdView;
import com.fl.saas.adx.api.mixNative.NativeEventListener;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.api.mixNative.NativeAdAppInfo;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.bidding.C2SBiddingECPM;
import com.fl.saas.base.innterNative.AdAppInfo;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Size;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FlNative extends BaseNativeAd<NativeAd> implements C2SBiddingECPM, BiddingResult {
    private static final String TAG = CommConstant.getClassTag("FL", FlNative.class);
    private final boolean isExpress;

    public FlNative(@NonNull Context context, @NonNull NativeAd nativeAd) {
        super(context, nativeAd);
        this.isExpress = nativeAd.isNativeExpress();
    }

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(final boolean z, final int i, final int i2, int i3) {
        Optional.ofNullable(getNativeAd()).ifPresent(new Consumer() { // from class: com.zj.adlib.bi3
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((NativeAd) obj).biddingResultUpload(z, i, i2);
            }
        });
    }

    @Override // com.fl.saas.base.bidding.C2SBiddingECPM
    public int getC2SBiddingECPM() {
        return ((Integer) getNativeAdOpt().map(new Function() { // from class: com.zj.adlib.ci3
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((NativeAd) obj).getECPM());
            }
        }).orElse(0)).intValue();
    }

    @Override // com.fl.saas.api.mixNative.NativeAd
    public boolean isNativeExpress() {
        return this.isExpress;
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    public NativeMaterial createNativeMaterial(@NonNull final NativeAd nativeAd) {
        return new NativeMaterial() { // from class: com.fl.saas.fl.mixNative.FlNative.2
            Bitmap adlogo;
            private NativeAdAppInfo mAdAppInfo;
            private View mediaVide;

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public NativeAdAppInfo getAdAppInfo() {
                final com.fl.saas.adx.api.mixNative.NativeAdAppInfo adAppInfo = nativeAd.getAdMaterial().getAdAppInfo();
                if (adAppInfo == null) {
                    return null;
                }
                if (this.mAdAppInfo == null) {
                    this.mAdAppInfo = new AdAppInfo() { // from class: com.fl.saas.fl.mixNative.FlNative.2.1
                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getAppName() {
                            return adAppInfo.getAppName();
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getAppPermissionUrl() {
                            return adAppInfo.getAppPermissionUrl();
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getAppPrivacyUrl() {
                            return adAppInfo.getAppPrivacyUrl();
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getAppVersion() {
                            return adAppInfo.getAppVersion();
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getFunctionUrl() {
                            return adAppInfo.getFunctionUrl();
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getPublisher() {
                            return adAppInfo.getPublisher();
                        }
                    };
                }
                return this.mAdAppInfo;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public Bitmap getAdLogo() {
                return nativeAd.getAdMaterial().getAdLogo();
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public Bitmap getAdLogoBitmap() {
                return nativeAd.getAdMaterial().getAdLogo();
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getAdLogoUrl() {
                return nativeAd.getAdMaterial().getAdLogoUrl();
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public View getAdMediaView() {
                if (this.mediaVide == null) {
                    this.mediaVide = nativeAd.getAdMaterial().getAdMediaView();
                }
                return this.mediaVide;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public int getAdType() {
                int adType = nativeAd.getAdMaterial().getAdType();
                if (adType == 1) {
                    return 1;
                }
                if (adType == 2) {
                    return 2;
                }
                return adType == 3 ? 3 : 0;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getCallToAction() {
                return nativeAd.getAdMaterial().getCallToAction();
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getDescription() {
                return nativeAd.getAdMaterial().getDescription();
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getIconUrl() {
                return nativeAd.getAdMaterial().getIconUrl();
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public List<String> getImageUrlList() {
                return nativeAd.getAdMaterial().getImageUrlList();
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getMainImageUrl() {
                return null;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public Size getSize() {
                return new Size(0, 0);
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getTitle() {
                return nativeAd.getAdMaterial().getTitle();
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public double getVideoDuration() {
                return nativeAd.getAdMaterial().getVideoDuration();
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getVideoUrl() {
                return nativeAd.getAdMaterial().getVideoUrl();
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public boolean isNativeAppAd() {
                return nativeAd.getAdMaterial().isNativeAppAd();
            }
        };
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    public void init(@NonNull NativeAd nativeAd) {
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.fl.mixNative.FlNative.1
            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                LogcatUtil.d(FlNative.TAG, "onAdClicked");
                FlNative.this.onAdClickedEvent();
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                LogcatUtil.d(FlNative.TAG, "onAdClose");
                FlNative.this.onAdCloseEvent();
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, FLError fLError) {
                LogcatUtil.d(FlNative.TAG, "onAdFailed");
                FlNative.this.onAdFailedEvent(YdError.create(fLError.getCode(), fLError.getMsg()));
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                LogcatUtil.d(FlNative.TAG, "onAdImpressed");
                FlNative.this.onAdImpressedEvent();
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdVideoEnd(NativeAdView nativeAdView) {
                LogcatUtil.d(FlNative.TAG, "onAdVideoEnd");
                FlNative.this.onAdVideoEndEvent();
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
                LogcatUtil.d(FlNative.TAG, "onAdVideoProgress");
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdVideoStart(NativeAdView nativeAdView) {
                LogcatUtil.d(FlNative.TAG, "onAdVideoStart");
                FlNative.this.onAdVideoStartEvent();
            }
        });
    }

    @Override // com.fl.saas.base.innterNative.BaseNativeAd
    /* JADX INFO: renamed from: render, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void lambda$prepare$0(NativeAd nativeAd, NativePrepareInfo nativePrepareInfo) {
        NativeAdView nativeAdView = new NativeAdView(getContext());
        if (this.isExpress) {
            nativeAd.renderAdContainer(nativeAdView, null);
            com.fl.saas.adx.api.mixNative.NativePrepareInfo nativePrepareInfo2 = new com.fl.saas.adx.api.mixNative.NativePrepareInfo();
            nativePrepareInfo2.setActivity(nativePrepareInfo.getActivity());
            nativeAd.prepare(nativePrepareInfo2);
            return;
        }
        nativeAd.renderAdContainer(nativeAdView, getNativeAdView());
        com.fl.saas.adx.api.mixNative.NativePrepareInfo nativePrepareInfo3 = new com.fl.saas.adx.api.mixNative.NativePrepareInfo();
        nativePrepareInfo3.setActivity(nativePrepareInfo.getActivity());
        nativePrepareInfo3.setCloseView(nativePrepareInfo.getCloseView());
        List<View> ctaViewList = nativePrepareInfo.getCtaViewList();
        List<View> clickViewList = nativePrepareInfo.getClickViewList();
        nativePrepareInfo3.setCtaView((View[]) ctaViewList.toArray(new View[0]));
        nativePrepareInfo3.setClickView((View[]) clickViewList.toArray(new View[0]));
        nativeAd.prepare(nativePrepareInfo3);
    }
}
