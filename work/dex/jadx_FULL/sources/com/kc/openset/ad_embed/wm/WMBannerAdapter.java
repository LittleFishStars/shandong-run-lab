package com.kc.openset.ad_embed.wm;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.bw.appsdkdex.ads.WMAdNativePot;
import com.kc.bw.common.Ilistener.IWMAppDownloadListener;
import com.kc.bw.common.Ilistener.XAdNativePotListener;
import com.kc.bw.common.nativepot.AdBaseInfo;
import com.kc.bw.common.nativepot.NativeWMResponse;
import com.kc.bw.common.nativepot.WMVideoListener;
import com.kc.openset.ad.base.bridge.BaseBannerBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WMBannerAdapter extends BaseBannerBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(873);
    private static final String FRONT = OSETSDKProtected.getString2(872);
    private static final String TAG = OSETSDKProtected.getString2(TTAdConstant.VALUE_CLICK_AREA_OTHER);
    private WeakReference<Button> mBtnActWeakReference;
    private WeakReference<ViewGroup> mContainerWeakReference;
    private WMAdNativePot mWMAdNativePot;
    private NativeWMResponse nativeWMAdResponse;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMBannerAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements XAdNativePotListener {
        final WMBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4178);
        }

        public AnonymousClass1(WMBannerAdapter wMBannerAdapter) {
            this.this$0 = wMBannerAdapter;
        }

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onAdRequest();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onClick();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onExposure();

        @Override // com.kc.bw.common.Ilistener.XAdNativePotListener
        public native void onNativePresent(NativeWMResponse nativeWMResponse);

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onNoAd(String str);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMBannerAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements WMVideoListener {
        final WMBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4179);
        }

        public AnonymousClass2(WMBannerAdapter wMBannerAdapter) {
            this.this$0 = wMBannerAdapter;
        }

        @Override // com.kc.bw.common.nativepot.WMVideoListener
        public native void onComplete();

        @Override // com.kc.bw.common.nativepot.WMVideoListener
        public native void onError(String str);

        @Override // com.kc.bw.common.nativepot.WMVideoListener
        public native void onStart();

        @Override // com.kc.bw.common.nativepot.WMVideoListener
        public native void onStop();
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMBannerAdapter$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements View.OnClickListener {
        final WMBannerAdapter this$0;
        final ViewGroup val$sdkAdContainer;

        static {
            OSETSDKProtected.interface11(4180);
        }

        public AnonymousClass3(WMBannerAdapter wMBannerAdapter, ViewGroup viewGroup) {
            this.this$0 = wMBannerAdapter;
            this.val$sdkAdContainer = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMBannerAdapter$4, reason: invalid class name */
    @Keep
    public class AnonymousClass4 implements IWMAppDownloadListener {
        final WMBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4181);
        }

        public AnonymousClass4(WMBannerAdapter wMBannerAdapter) {
            this.this$0 = wMBannerAdapter;
        }

        @Override // com.kc.bw.common.Ilistener.IWMAppDownloadListener
        public native void handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        @Override // com.kc.bw.common.Ilistener.IWMAppDownloadListener
        public native void onDownloadDialogDismiss();

        @Override // com.kc.bw.common.Ilistener.IWMAppDownloadListener
        public native void onDownloadDialogShow();

        @Override // com.kc.bw.common.Ilistener.IWMAppDownloadListener
        public native void onDownloadFailed();

        @Override // com.kc.bw.common.Ilistener.IWMAppDownloadListener
        public native void onDownloadFinished();

        @Override // com.kc.bw.common.Ilistener.IWMAppDownloadListener
        public native void onDownloadPaused();

        @Override // com.kc.bw.common.Ilistener.IWMAppDownloadListener
        public native void onDownloadResumed();

        @Override // com.kc.bw.common.Ilistener.IWMAppDownloadListener
        public native void onDownloadStarted();

        @Override // com.kc.bw.common.Ilistener.IWMAppDownloadListener
        public native void onProgressUpdate(int i);
    }

    static {
        OSETSDKProtected.interface11(4182);
    }

    public static native /* synthetic */ NativeWMResponse access$002(WMBannerAdapter wMBannerAdapter, NativeWMResponse nativeWMResponse);

    public static native /* synthetic */ void access$100(WMBannerAdapter wMBannerAdapter);

    public static native /* synthetic */ WeakReference access$200(WMBannerAdapter wMBannerAdapter);

    public static native /* synthetic */ void access$300(WMBannerAdapter wMBannerAdapter, View view);

    public static native /* synthetic */ void access$400(WMBannerAdapter wMBannerAdapter, View view);

    public static native /* synthetic */ void access$500(WMBannerAdapter wMBannerAdapter, String str, String str2);

    public static native /* synthetic */ void access$600(WMBannerAdapter wMBannerAdapter, View view);

    public static native /* synthetic */ WeakReference access$700(WMBannerAdapter wMBannerAdapter);

    private native void createNativeAd(Activity activity);

    private native XAdNativePotListener getAdLoaderListener();

    private native void setAppDownloadListener(NativeWMResponse nativeWMResponse, AdBaseInfo.WMDownloadAppInfo wMDownloadAppInfo);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseBannerBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native Object getAdObj();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdTitle();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdUserName();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdvertisers();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native int getEcpm();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getLogTag();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getParentAdId();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
