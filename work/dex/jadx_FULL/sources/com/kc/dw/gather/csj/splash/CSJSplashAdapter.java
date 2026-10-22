package com.kc.dw.gather.csj.splash;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.kc.dw.activity.a;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.splash.SplashCommonAdLoader;
import com.kc.dw.core.utils.DimensionUtils;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CSJSplashAdapter extends MsCustomSplashAdapter {
    private static final String TAG = "CSJSplashAdapter";
    private CSJSplashAd splashAd;

    /* JADX INFO: renamed from: com.kc.dw.gather.csj.splash.CSJSplashAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements TTAdNative.CSJSplashAdListener {
        public final CSJSplashAdapter this$0;

        public AnonymousClass1(CSJSplashAdapter cSJSplashAdapter) {
            this.this$0 = cSJSplashAdapter;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadFail(CSJAdError cSJAdError) {
            try {
                LogUtil.d(CSJSplashAdapter.TAG, "csj onSplashLoadFail,code=" + cSJAdError.getCode() + ",msg=" + cSJAdError.getMsg());
                this.this$0.callLoadedError(cSJAdError.getCode(), cSJAdError.getMsg());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
            try {
                this.this$0.splashAd = cSJSplashAd;
                LogUtil.d(CSJSplashAdapter.TAG, "CSJ load success,csjSplashAd=" + cSJSplashAd);
                this.this$0.callLoadedSuccess();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
            try {
                LogUtil.d(CSJSplashAdapter.TAG, "csj onSplashRenderFail,code=" + cSJAdError.getCode() + ",msg=" + cSJAdError.getMsg());
                this.this$0.callRenderError(cSJAdError.getCode(), cSJAdError.getMsg());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
            LogUtil.d(CSJSplashAdapter.TAG, "CSJ onSplashRenderSuccess,csjSplashAd=" + cSJSplashAd);
            try {
                this.this$0.callRenderSuccess();
                if (cSJSplashAd != null) {
                    cSJSplashAd.setSplashAdListener(new CSJSplashAd.SplashAdListener(this) { // from class: com.kc.dw.gather.csj.splash.CSJSplashAdapter.1.1
                        public final AnonymousClass1 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClick(CSJSplashAd cSJSplashAd2) {
                            this.this$1.this$0.callAdClicked();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClose(CSJSplashAd cSJSplashAd2, int i) {
                            this.this$1.this$0.callAdClosed();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdShow(CSJSplashAd cSJSplashAd2) {
                            this.this$1.this$0.callAdExposure();
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        int width;
        int height;
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(context);
        if (ssdAdSlot.getWidth() <= 0 || ssdAdSlot.getHeight() <= 0) {
            try {
                DisplayMetrics displayMetrics = ((SplashCommonAdLoader) this.adLoader).getContext().getResources().getDisplayMetrics();
                width = displayMetrics.widthPixels;
                if (width <= 0 || (height = displayMetrics.heightPixels) <= 0) {
                    width = 1080;
                    height = 1920;
                }
            } catch (Exception unused) {
            }
        } else {
            width = ssdAdSlot.getWidth();
            height = ssdAdSlot.getHeight();
        }
        tTAdNativeCreateAdNative.loadSplashAd(new AdSlot.Builder().setCodeId(customInfo.getPid()).setSupportDeepLink(true).setImageAcceptedSize(width, height).setExpressViewAcceptedSize(DimensionUtils.px2dip(context, width), DimensionUtils.px2dip(context, height)).build(), new AnonymousClass1(this), 3500);
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void showAd(ViewGroup viewGroup) {
        StringBuilder sbA = a.a("Csj showAd,splashAd=");
        sbA.append(this.splashAd);
        sbA.append("container=");
        sbA.append(viewGroup);
        LogUtil.d(TAG, sbA.toString());
        CSJSplashAd cSJSplashAd = this.splashAd;
        if (cSJSplashAd != null) {
            cSJSplashAd.showSplashView(viewGroup);
        }
    }
}
