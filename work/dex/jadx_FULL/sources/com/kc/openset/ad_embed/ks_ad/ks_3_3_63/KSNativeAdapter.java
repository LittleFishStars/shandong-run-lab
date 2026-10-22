package com.kc.openset.ad_embed.ks_ad.ks_3_3_63;

import android.app.Activity;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseNativeBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSNativeAdapter extends BaseNativeBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT);
    private static final String FRONT = OSETSDKProtected.getString2(743);
    private static final String TAG = OSETSDKProtected.getString2(757);
    private KsFeedAd mKsFeedAd;
    private WeakReference<View> mWeakReferenceNative;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSNativeAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsLoadManager.FeedAdListener {
        final KSNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(3987);
        }

        public AnonymousClass1(KSNativeAdapter kSNativeAdapter) {
            this.this$0 = kSNativeAdapter;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public native void onError(int i, String str);

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public native void onFeedAdLoad(List<KsFeedAd> list);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSNativeAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements KsFeedAd.AdRenderListener {
        final KSNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(3988);
        }

        public AnonymousClass2(KSNativeAdapter kSNativeAdapter) {
            this.this$0 = kSNativeAdapter;
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
        public native void onAdRenderFailed(int i, String str);

        @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
        public native void onAdRenderSuccess(View view);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSNativeAdapter$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements KsFeedAd.AdInteractionListener {
        final KSNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(3989);
        }

        public AnonymousClass3(KSNativeAdapter kSNativeAdapter) {
            this.this$0 = kSNativeAdapter;
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public native void onAdClicked();

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public native void onAdShow();

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public native void onDislikeClicked();

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public native void onDownloadTipsDialogDismiss();

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public native void onDownloadTipsDialogShow();
    }

    static {
        OSETSDKProtected.interface11(3990);
    }

    public static native /* synthetic */ void access$000(KSNativeAdapter kSNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$100(KSNativeAdapter kSNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$1000(KSNativeAdapter kSNativeAdapter, View view);

    public static native /* synthetic */ void access$1100(KSNativeAdapter kSNativeAdapter, View view);

    public static native /* synthetic */ KsFeedAd access$202(KSNativeAdapter kSNativeAdapter, KsFeedAd ksFeedAd);

    public static native /* synthetic */ boolean access$300(KSNativeAdapter kSNativeAdapter);

    public static native /* synthetic */ void access$400(KSNativeAdapter kSNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$500(KSNativeAdapter kSNativeAdapter);

    public static native /* synthetic */ void access$600(KSNativeAdapter kSNativeAdapter, View view);

    public static native /* synthetic */ WeakReference access$700(KSNativeAdapter kSNativeAdapter);

    public static native /* synthetic */ void access$800(KSNativeAdapter kSNativeAdapter, View view, String str, String str2);

    public static native /* synthetic */ void access$900(KSNativeAdapter kSNativeAdapter, View view);

    private native KsScene createKsScene(String str);

    private native void loadAndSetAdLoadListener(KsScene ksScene);

    private native void setAdPlayEventListener(KsFeedAd ksFeedAd);

    private native void setAdRenderListener(KsFeedAd ksFeedAd);

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
    public native String getS2SInfo();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadS2SAd(String str);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
