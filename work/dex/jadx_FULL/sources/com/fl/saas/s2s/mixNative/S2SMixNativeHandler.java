package com.fl.saas.s2s.mixNative;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.fl.saas.api.mixNative.NativeAdAppInfo;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.base.adapter.MixNativeAPI;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.annotation.MixNativeLoad;
import com.fl.saas.base.innterNative.AdAppInfo;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.feature.Size;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.OnYqAdListener;
import com.fl.saas.s2s.sdk.helper.S2SAdLoadListener;
import com.fl.saas.s2s.sdk.helper.S2sRequestHelper;
import com.fl.spi.SPI;
import com.ipd.dsp.internal.b1.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Advertiser(5)
@SPI({MixNativeAPI.class})
public class S2SMixNativeHandler extends MixNativeHandler {
    private static final String TAG = CommConstant.getClassTag("S2S", S2SMixNativeHandler.class);
    private S2SNative sNative;

    /* JADX INFO: renamed from: com.fl.saas.s2s.mixNative.S2SMixNativeHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements OnYqAdListener {
        final /* synthetic */ AdSource val$source;

        public AnonymousClass1(AdSource adSource) {
            this.val$source = adSource;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNativeAdReceived$0(AdSource adSource) {
            if (S2SMixNativeHandler.this.sNative == null) {
                S2SMixNativeHandler.this.onAdFailed(new YdError(20403, "onLoadFailed, native is empty"));
                return;
            }
            if (S2SMixNativeHandler.this.getAdStyle() != NativeStyle.EXPRESS) {
                S2SMixNativeHandler s2SMixNativeHandler = S2SMixNativeHandler.this;
                s2SMixNativeHandler.onNativeAdLoaded(s2SMixNativeHandler.sNative);
            } else {
                int iDip2px = DeviceUtil.dip2px(S2SMixNativeHandler.this.getAdParams().getExpressWidth());
                int iDip2px2 = DeviceUtil.dip2px(S2SMixNativeHandler.this.getAdParams().getExpressHeight());
                S2SMixNativeHandler s2SMixNativeHandler2 = S2SMixNativeHandler.this;
                s2SMixNativeHandler2.onNativeAdLoaded(new S2SNativeExpress(s2SMixNativeHandler2.getContext(), S2SMixNativeHandler.this.sNative, iDip2px, iDip2px2).setClickType(adSource.only_button));
            }
        }

        @Override // com.fl.saas.s2s.sdk.helper.OnYqAdListener
        public void onAdFailed(YdError ydError) {
            S2SMixNativeHandler.this.onAdFailed(ydError);
        }

        @Override // com.fl.saas.s2s.sdk.helper.OnYqAdListener
        public void onNativeAdReceived(List<AdInfoPoJo> list) {
            AdInfoPoJo adInfoPoJo = (AdInfoPoJo) Check.findFirstNonNull(list);
            if (adInfoPoJo == null || S2SMixNativeHandler.this.getContext() == null) {
                S2SMixNativeHandler.this.onAdFailed(YdError.create(20401, "onNativeAdReceived but pojoList is empty"));
                return;
            }
            S2SMixNativeHandler s2SMixNativeHandler = S2SMixNativeHandler.this;
            Context context = S2SMixNativeHandler.this.getContext();
            final AdSource adSource = this.val$source;
            s2SMixNativeHandler.sNative = new S2SNative(context, adInfoPoJo, adSource, adSource.isCacheAd, new S2SAdLoadListener() { // from class: com.fl.saas.s2s.mixNative.a
                @Override // com.fl.saas.s2s.sdk.helper.S2SAdLoadListener
                public final void onLoadedSuccess() {
                    this.f1760a.lambda$onNativeAdReceived$0(adSource);
                }
            });
            S2SMixNativeHandler.this.sNative.init();
        }
    }

    public static NativeMaterial adInfoToNativeMaterial(@NonNull final AdInfoPoJo adInfoPoJo, final View view) {
        return new NativeMaterial() { // from class: com.fl.saas.s2s.mixNative.S2SMixNativeHandler.2
            Bitmap adLogo;
            Bitmap adLogoBitmap;
            private List<String> imgs;
            private NativeAdAppInfo mAdAppInfo;

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public NativeAdAppInfo getAdAppInfo() {
                if (this.mAdAppInfo == null) {
                    this.mAdAppInfo = new AdAppInfo() { // from class: com.fl.saas.s2s.mixNative.S2SMixNativeHandler.2.1
                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getAppName() {
                            return adInfoPoJo.app_name;
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getAppPermissionUrl() {
                            return adInfoPoJo.permissions_url;
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getAppPrivacyUrl() {
                            return adInfoPoJo.privacy_agreement;
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getAppVersion() {
                            return adInfoPoJo.app_version;
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getFunctionUrl() {
                            return adInfoPoJo.app_intro_url;
                        }

                        @Override // com.fl.saas.api.mixNative.NativeAdAppInfo
                        public String getPublisher() {
                            return adInfoPoJo.advertiser_name;
                        }
                    };
                }
                return this.mAdAppInfo;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public Bitmap getAdLogo() {
                if (this.adLogo == null) {
                    try {
                        AdInfoPoJo adInfoPoJo2 = adInfoPoJo;
                        this.adLogo = (adInfoPoJo2.adv_id == 0 || "广告".equals(adInfoPoJo2.advName)) ? ImageUtils.convertMipmapToBitmap(DeviceUtil.getContext(), R.mipmap.yd_saas_icon_logo) : ImageUtils.textToAdLogo(adInfoPoJo.advName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return this.adLogo;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public Bitmap getAdLogoBitmap() {
                if (this.adLogoBitmap == null) {
                    try {
                        AdInfoPoJo adInfoPoJo2 = adInfoPoJo;
                        this.adLogoBitmap = (adInfoPoJo2.adv_id == 0 || "广告".equals(adInfoPoJo2.advName)) ? ImageUtils.convertMipmapToBitmap(DeviceUtil.getContext(), R.mipmap.yd_saas_icon_no_text_logo) : ImageUtils.textToAdLogo(adInfoPoJo.advName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return this.adLogoBitmap;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getAdLogoUrl() {
                return null;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public View getAdMediaView() {
                return view;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public int getAdType() {
                int i = adInfoPoJo.creative.ctype;
                if (i != 1) {
                    if (i == 2) {
                        return 3;
                    }
                    if (i != 3) {
                        return 0;
                    }
                }
                return 1;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getCallToAction() {
                return TextUtils.equals("1", adInfoPoJo.ac_type) ? b.a.l : "查看详情";
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getDescription() {
                return adInfoPoJo.description;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getIconUrl() {
                return adInfoPoJo.logo_icon;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public List<String> getImageUrlList() {
                if (this.imgs == null) {
                    ArrayList arrayList = new ArrayList();
                    this.imgs = arrayList;
                    arrayList.add(adInfoPoJo.img_url);
                }
                return this.imgs;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getMainImageUrl() {
                return adInfoPoJo.img_url;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public Size getSize() {
                AdInfoPoJo.Video video;
                AdInfoPoJo adInfoPoJo2 = adInfoPoJo;
                AdInfoPoJo.Creative creative = adInfoPoJo2.creative;
                return (creative.ctype != 2 || (video = creative.video) == null) ? new Size(adInfoPoJo2.width, adInfoPoJo2.height) : new Size(video.width, video.height);
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getTitle() {
                return adInfoPoJo.title;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public double getVideoDuration() {
                return adInfoPoJo.VIDEO_TIME * 1000;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public String getVideoUrl() {
                return adInfoPoJo.video_url;
            }

            @Override // com.fl.saas.api.mixNative.NativeMaterial
            public boolean isNativeAppAd() {
                return !TextUtils.isEmpty(adInfoPoJo.download_url);
            }
        };
    }

    @MixNativeLoad
    private void loadNative(Activity activity, AdSource adSource) {
        S2sRequestHelper.getInstance().requestAd(1, adSource, new AnonymousClass1(adSource));
    }

    @Override // com.fl.saas.base.adapter.MixNativeHandler
    public void init() {
    }
}
