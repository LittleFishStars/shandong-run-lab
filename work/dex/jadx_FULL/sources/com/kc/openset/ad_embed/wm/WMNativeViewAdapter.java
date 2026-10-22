package com.kc.openset.ad_embed.wm;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.mcssdk.constant.MessageConstant;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.bw.appsdkdex.ads.WMAdNativePot;
import com.kc.bw.common.Ilistener.XAdNativePotListener;
import com.kc.bw.common.nativepot.AdBaseInfo;
import com.kc.bw.common.nativepot.NativeWMResponse;
import com.kc.openset.ad.base.ViewHolderManager;
import com.kc.openset.ad.base.bridge.BaseNativeViewBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.sdk.adv.OSETQDNativeViewAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WMNativeViewAdapter extends BaseNativeViewBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(873);
    private static final String FRONT = OSETSDKProtected.getString2(872);
    private static final String TAG = OSETSDKProtected.getString2(895);
    private WMAdNativePot mWMAdNativePot;
    private NativeWMResponse nativeWMAdResponse;
    private WeakReference<ViewGroup> sdkAdContainer;
    private WMNativeViewAdImp wmNativeViewAdImp;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMNativeViewAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements XAdNativePotListener {
        final WMNativeViewAdapter this$0;

        static {
            OSETSDKProtected.interface11(MessageConstant.MessageType.MESSAGE_STAT);
        }

        public AnonymousClass1(WMNativeViewAdapter wMNativeViewAdapter) {
            this.this$0 = wMNativeViewAdapter;
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

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMNativeViewAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements WMNativeViewAdImp.QDNativeViewInnerListener {
        final WMNativeViewAdapter this$0;

        /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMNativeViewAdapter$2$1, reason: invalid class name */
        @Keep
        public class AnonymousClass1 implements View.OnClickListener {
            final AnonymousClass2 this$1;
            final ViewGroup val$adContainer;

            static {
                OSETSDKProtected.interface11(4197);
            }

            public AnonymousClass1(AnonymousClass2 anonymousClass2, ViewGroup viewGroup) {
                this.this$1 = anonymousClass2;
                this.val$adContainer = viewGroup;
            }

            @Override // android.view.View.OnClickListener
            public native void onClick(View view);
        }

        static {
            OSETSDKProtected.interface11(4198);
        }

        public AnonymousClass2(WMNativeViewAdapter wMNativeViewAdapter) {
            this.this$0 = wMNativeViewAdapter;
        }

        @Override // com.kc.openset.ad_embed.wm.WMNativeViewAdImp.QDNativeViewInnerListener
        public native View getVideoView(Context context);

        @Override // com.kc.openset.ad_embed.wm.WMNativeViewAdImp.QDNativeViewInnerListener
        public native boolean isUsable();

        @Override // com.kc.openset.ad_embed.wm.WMNativeViewAdImp.QDNativeViewInnerListener
        public native void onRegisterView(ViewGroup viewGroup, List<View> list, View view);
    }

    static {
        OSETSDKProtected.interface11(4199);
    }

    public static native /* synthetic */ NativeWMResponse access$000(WMNativeViewAdapter wMNativeViewAdapter);

    public static native /* synthetic */ NativeWMResponse access$002(WMNativeViewAdapter wMNativeViewAdapter, NativeWMResponse nativeWMResponse);

    public static native /* synthetic */ void access$100(WMNativeViewAdapter wMNativeViewAdapter);

    public static native /* synthetic */ WeakReference access$200(WMNativeViewAdapter wMNativeViewAdapter);

    public static native /* synthetic */ void access$300(WMNativeViewAdapter wMNativeViewAdapter, View view);

    public static native /* synthetic */ WMNativeViewAdImp access$400(WMNativeViewAdapter wMNativeViewAdapter);

    public static native /* synthetic */ void access$500(WMNativeViewAdapter wMNativeViewAdapter, View view);

    public static native /* synthetic */ void access$600(WMNativeViewAdapter wMNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$700(WMNativeViewAdapter wMNativeViewAdapter, View view);

    private native WMNativeViewAdImp buildWmNativeViewAdImp();

    private native WMNativeViewAdData converNativeViewAdData(AdBaseInfo adBaseInfo);

    private native XAdNativePotListener getAdLoaderListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseNativeViewBridge, com.kc.openset.ad.base.bridge.AdBridge
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
    public native OSETQDNativeViewAd getQDNativeViewAd();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity, ViewHolderManager.ViewHolder viewHolder);
}
