package com.kc.openset.ad_embed.ks_ad.ks_3_3_69;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.ViewHolderManager;
import com.kc.openset.ad.base.bridge.BaseNativeViewBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSNativeViewAdapter extends BaseNativeViewBridge implements View.OnClickListener {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT);
    private static final String FRONT = OSETSDKProtected.getString2(743);
    private static final String TAG = OSETSDKProtected.getString2(802);
    private String mAppName;
    private String mAppPrivacyUrl;
    private String mIntroductionInfoUrl;
    private KsNativeAd mKsNativeAd;
    private String mPermissionInfoUrl;
    private ViewHolderManager.ViewHolder mViewHolder;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_69.KSNativeViewAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsLoadManager.NativeAdListener {
        final KSNativeViewAdapter this$0;

        static {
            OSETSDKProtected.interface11(4042);
        }

        public AnonymousClass1(KSNativeViewAdapter kSNativeViewAdapter) {
            this.this$0 = kSNativeViewAdapter;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public native void onError(int i, String str);

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public native void onNativeAdLoad(List<KsNativeAd> list);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_69.KSNativeViewAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements KsNativeAd.AdInteractionListener {
        final KSNativeViewAdapter this$0;

        static {
            OSETSDKProtected.interface11(4043);
        }

        public AnonymousClass2(KSNativeViewAdapter kSNativeViewAdapter) {
            this.this$0 = kSNativeViewAdapter;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native void onAdClicked(View view, KsNativeAd ksNativeAd);

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native void onAdShow(KsNativeAd ksNativeAd);

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native void onDownloadTipsDialogDismiss();

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native void onDownloadTipsDialogShow();
    }

    static {
        OSETSDKProtected.interface11(4044);
    }

    public static native /* synthetic */ void access$000(KSNativeViewAdapter kSNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$100(KSNativeViewAdapter kSNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$1000(KSNativeViewAdapter kSNativeViewAdapter);

    public static native /* synthetic */ ViewHolderManager.ViewHolder access$1100(KSNativeViewAdapter kSNativeViewAdapter);

    public static native /* synthetic */ void access$1200(KSNativeViewAdapter kSNativeViewAdapter, View view);

    public static native /* synthetic */ void access$1300(KSNativeViewAdapter kSNativeViewAdapter, View view);

    public static native /* synthetic */ Context access$200(KSNativeViewAdapter kSNativeViewAdapter);

    public static native /* synthetic */ void access$300(KSNativeViewAdapter kSNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(KSNativeViewAdapter kSNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$500(KSNativeViewAdapter kSNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$600(KSNativeViewAdapter kSNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ KsNativeAd access$702(KSNativeViewAdapter kSNativeViewAdapter, KsNativeAd ksNativeAd);

    public static native /* synthetic */ boolean access$800(KSNativeViewAdapter kSNativeViewAdapter);

    public static native /* synthetic */ void access$900(KSNativeViewAdapter kSNativeViewAdapter, String str, String str2);

    private native KsScene createKsScene(String str);

    private native void createNativeAd(Activity activity, ViewHolderManager.ViewHolder viewHolder);

    private native void loadAndSetAdLoadListener(KsScene ksScene);

    private native void registerView(KsNativeAd ksNativeAd, Activity activity, ViewGroup viewGroup, HashMap<View, Integer> map);

    private native void returnWebPage(Context context, String str, int i);

    private native void returnWebPage(Context context, String str, int i, boolean z);

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
    public native String getS2SInfo();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // android.view.View.OnClickListener
    public native void onClick(View view);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadS2SAd(String str);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity, ViewHolderManager.ViewHolder viewHolder);
}
