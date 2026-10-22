package com.kc.openset.ad_embed.zy;

import android.app.Activity;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.cw.ad.NativeAd;
import com.kc.cw.ad.NativeAdListener;
import com.kc.cw.ad.NativeAdResponse;
import com.kc.cw.ad.internal.nativead.NativeAdEventListener;
import com.kc.openset.ad.base.bridge.BaseNativeBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ZYNativeAdapter extends BaseNativeBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(904);
    private static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE);
    private static final String TAG = OSETSDKProtected.getString2(940);
    private NativeAd mNativeAd;
    private NativeAdResponse mNativeAdResponse;
    private WeakReference<View> mNdContainer;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.zy.ZYNativeAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements NativeAdListener {
        final ZYNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(4216);
        }

        public AnonymousClass1(ZYNativeAdapter zYNativeAdapter) {
            this.this$0 = zYNativeAdapter;
        }

        @Override // com.kc.cw.ad.NativeAdListener
        public native void onAdFailed(int i);

        @Override // com.kc.cw.ad.NativeAdListener
        public native void onAdLoaded(NativeAdResponse nativeAdResponse);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.zy.ZYNativeAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements NativeAdEventListener {
        final ZYNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(4217);
        }

        public AnonymousClass2(ZYNativeAdapter zYNativeAdapter) {
            this.this$0 = zYNativeAdapter;
        }

        @Override // com.kc.cw.ad.internal.nativead.NativeAdEventListener
        public native void onADExposed();

        @Override // com.kc.cw.ad.internal.nativead.NativeAdEventListener
        public native void onAdClick();

        @Override // com.kc.cw.ad.internal.nativead.NativeAdEventListener
        public native void onAdClose();

        @Override // com.kc.cw.ad.internal.nativead.NativeAdEventListener
        public native void onAdRenderFailed(int i);
    }

    static {
        OSETSDKProtected.interface11(4218);
    }

    public static native /* synthetic */ void access$000(ZYNativeAdapter zYNativeAdapter, String str, String str2);

    public static native /* synthetic */ NativeAdResponse access$102(ZYNativeAdapter zYNativeAdapter, NativeAdResponse nativeAdResponse);

    public static native /* synthetic */ void access$200(ZYNativeAdapter zYNativeAdapter);

    public static native /* synthetic */ void access$300(ZYNativeAdapter zYNativeAdapter, String str, String str2);

    public static native /* synthetic */ WeakReference access$400(ZYNativeAdapter zYNativeAdapter);

    public static native /* synthetic */ void access$500(ZYNativeAdapter zYNativeAdapter, View view);

    public static native /* synthetic */ void access$600(ZYNativeAdapter zYNativeAdapter, View view);

    public static native /* synthetic */ void access$700(ZYNativeAdapter zYNativeAdapter, View view, String str, String str2);

    public static native /* synthetic */ void access$800(ZYNativeAdapter zYNativeAdapter, View view);

    private native NativeAdListener createAndSetAdAllListener();

    private native NativeAdEventListener getNativeAdEventListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

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
