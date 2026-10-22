package com.kc.openset.ad_embed.wm;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.bw.appsdkdex.ads.WMAdNativeExpress;
import com.kc.bw.common.Ilistener.XAdNativeExpressListener;
import com.kc.openset.ad.base.bridge.BaseNativeBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WMNativeAdapter extends BaseNativeBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(873);
    private static final String FRONT = OSETSDKProtected.getString2(872);
    private static final String TAG = OSETSDKProtected.getString2(893);
    private WeakReference<View> adView;
    private WMAdNativeExpress mWMAdNativeExpress;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMNativeAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements XAdNativeExpressListener {
        final WMNativeAdapter this$0;

        /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMNativeAdapter$1$1, reason: invalid class name and collision with other inner class name */
        @Keep
        public class ViewOnClickListenerC11061 implements View.OnClickListener {
            final AnonymousClass1 this$1;

            static {
                OSETSDKProtected.interface11(4189);
            }

            public ViewOnClickListenerC11061(AnonymousClass1 anonymousClass1) {
                this.this$1 = anonymousClass1;
            }

            @Override // android.view.View.OnClickListener
            public native void onClick(View view);
        }

        static {
            OSETSDKProtected.interface11(4190);
        }

        public AnonymousClass1(WMNativeAdapter wMNativeAdapter) {
            this.this$0 = wMNativeAdapter;
        }

        private native View createCustomClose(Context context);

        @Override // com.kc.bw.common.Ilistener.XAdNativeExpressListener
        public native void onADIsVideo(boolean z);

        @Override // com.kc.bw.common.Ilistener.XAdNativeExpressListener
        public native void onAdClose();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onAdRequest();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onClick();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onExposure();

        @Override // com.kc.bw.common.Ibase.XAdBaseListener
        public native void onNoAd(String str);

        @Override // com.kc.bw.common.Ilistener.XAdNativeExpressListener
        public native void onRenderSuccess(View view, int i, int i2);
    }

    static {
        OSETSDKProtected.interface11(4191);
    }

    public static native /* synthetic */ WeakReference access$000(WMNativeAdapter wMNativeAdapter);

    public static native /* synthetic */ WeakReference access$002(WMNativeAdapter wMNativeAdapter, WeakReference weakReference);

    public static native /* synthetic */ void access$100(WMNativeAdapter wMNativeAdapter, View view);

    public static native /* synthetic */ void access$200(WMNativeAdapter wMNativeAdapter, View view);

    public static native /* synthetic */ void access$300(WMNativeAdapter wMNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(WMNativeAdapter wMNativeAdapter, View view);

    public static native /* synthetic */ Context access$500(WMNativeAdapter wMNativeAdapter);

    public static native /* synthetic */ Context access$600(WMNativeAdapter wMNativeAdapter);

    public static native /* synthetic */ void access$700(WMNativeAdapter wMNativeAdapter);

    public static native /* synthetic */ void access$800(WMNativeAdapter wMNativeAdapter, int i, String str);

    public static native /* synthetic */ void access$900(WMNativeAdapter wMNativeAdapter, View view);

    private native XAdNativeExpressListener getAdLoaderListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseNativeBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native Object getAdObj();

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
