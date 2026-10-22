package com.kc.openset.ad_embed.zy;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.cw.ad.NativeAd;
import com.kc.cw.ad.NativeAdListener;
import com.kc.cw.ad.NativeAdResponse;
import com.kc.cw.ad.internal.nativead.NativeAdEventListener;
import com.kc.openset.ad.base.bridge.BaseBannerBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ZYBannerAdapter extends BaseBannerBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(904);
    private static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE);
    private static final String TAG = OSETSDKProtected.getString2(915);
    private NativeAd mNativeAd;
    private NativeAdResponse mNativeAdResponse;
    private WeakReference<View> mWeakReferenceContainer;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.zy.ZYBannerAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements NativeAdListener {
        final ZYBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4208);
        }

        public AnonymousClass1(ZYBannerAdapter zYBannerAdapter) {
            this.this$0 = zYBannerAdapter;
        }

        @Override // com.kc.cw.ad.NativeAdListener
        public native void onAdFailed(int i);

        @Override // com.kc.cw.ad.NativeAdListener
        public native void onAdLoaded(NativeAdResponse nativeAdResponse);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.zy.ZYBannerAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements NativeAdEventListener {
        final ZYBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4209);
        }

        public AnonymousClass2(ZYBannerAdapter zYBannerAdapter) {
            this.this$0 = zYBannerAdapter;
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
        OSETSDKProtected.interface11(4210);
    }

    public static native /* synthetic */ void access$000(ZYBannerAdapter zYBannerAdapter, String str, String str2);

    public static native /* synthetic */ NativeAdResponse access$102(ZYBannerAdapter zYBannerAdapter, NativeAdResponse nativeAdResponse);

    public static native /* synthetic */ void access$200(ZYBannerAdapter zYBannerAdapter);

    public static native /* synthetic */ void access$300(ZYBannerAdapter zYBannerAdapter, String str, String str2);

    public static native /* synthetic */ WeakReference access$400(ZYBannerAdapter zYBannerAdapter);

    public static native /* synthetic */ void access$500(ZYBannerAdapter zYBannerAdapter, View view);

    public static native /* synthetic */ void access$600(ZYBannerAdapter zYBannerAdapter, View view);

    public static native /* synthetic */ void access$700(ZYBannerAdapter zYBannerAdapter, String str, String str2);

    public static native /* synthetic */ void access$800(ZYBannerAdapter zYBannerAdapter, View view);

    private native void bindAdEventListener(ArrayList<View> arrayList, ImageView imageView);

    private native NativeAdListener createAndSetAdAllListener();

    private native void createNativeAd(Activity activity);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

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
