package com.kc.openset.ad_embed.ks_ad.ks_3_3_74;

import android.app.Activity;
import android.view.View;
import com.baidu.mapapi.UIMsg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseDrawNativeBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSDrawNativeAdapter extends BaseDrawNativeBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT);
    private static final String FRONT = OSETSDKProtected.getString2(743);
    private static final String TAG = OSETSDKProtected.getString2(757);
    private View mDrawView;
    private KsDrawAd mKsDrawAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_74.KSDrawNativeAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsLoadManager.DrawAdListener {
        final KSDrawNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(4108);
        }

        public AnonymousClass1(KSDrawNativeAdapter kSDrawNativeAdapter) {
            this.this$0 = kSDrawNativeAdapter;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public native void onDrawAdLoad(List<KsDrawAd> list);

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public native void onError(int i, String str);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_74.KSDrawNativeAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements KsDrawAd.AdInteractionListener {
        final KSDrawNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(UIMsg.k_event.MV_MAP_SETMAPMODE);
        }

        public AnonymousClass2(KSDrawNativeAdapter kSDrawNativeAdapter) {
            this.this$0 = kSDrawNativeAdapter;
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public native void onAdClicked();

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public native void onAdShow();

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public native void onVideoPlayEnd();

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public native void onVideoPlayError();

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public native void onVideoPlayPause();

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public native void onVideoPlayResume();

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public native void onVideoPlayStart();
    }

    static {
        OSETSDKProtected.interface11(4110);
    }

    public static native /* synthetic */ void access$000(KSDrawNativeAdapter kSDrawNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$100(KSDrawNativeAdapter kSDrawNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$1000(KSDrawNativeAdapter kSDrawNativeAdapter, View view);

    public static native /* synthetic */ void access$1100(KSDrawNativeAdapter kSDrawNativeAdapter, View view);

    public static native /* synthetic */ void access$1200(KSDrawNativeAdapter kSDrawNativeAdapter, View view);

    public static native /* synthetic */ void access$1300(KSDrawNativeAdapter kSDrawNativeAdapter, String str, String str2);

    public static native /* synthetic */ KsDrawAd access$202(KSDrawNativeAdapter kSDrawNativeAdapter, KsDrawAd ksDrawAd);

    public static native /* synthetic */ boolean access$300(KSDrawNativeAdapter kSDrawNativeAdapter);

    public static native /* synthetic */ void access$400(KSDrawNativeAdapter kSDrawNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$500(KSDrawNativeAdapter kSDrawNativeAdapter);

    public static native /* synthetic */ View access$600(KSDrawNativeAdapter kSDrawNativeAdapter);

    public static native /* synthetic */ void access$700(KSDrawNativeAdapter kSDrawNativeAdapter, View view);

    public static native /* synthetic */ void access$800(KSDrawNativeAdapter kSDrawNativeAdapter, View view);

    public static native /* synthetic */ void access$900(KSDrawNativeAdapter kSDrawNativeAdapter, View view);

    private native void loadAndSetAdLoadListener(KsScene ksScene);

    private native void setAdPlayEventListener(KsDrawAd ksDrawAd);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseDrawNativeBridge, com.kc.openset.ad.base.bridge.AdBridge
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
