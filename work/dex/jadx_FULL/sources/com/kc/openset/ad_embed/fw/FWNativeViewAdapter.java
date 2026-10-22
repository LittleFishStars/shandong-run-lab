package com.kc.openset.ad_embed.fw;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.aw.lib.interf.NativeAdvertData;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.openset.ad.base.ViewHolderManager;
import com.kc.openset.ad.base.bridge.BaseNativeViewBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.bean.QDImages;
import com.kc.openset.sdk.adv.OSETQDNativeViewAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class FWNativeViewAdapter extends BaseNativeViewBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(554);
    private static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS);
    private static final String TAG = OSETSDKProtected.getString2(605);
    private FWQDNativeViewAd mFWQDNativeViewAd;
    private PtgNativeExpressAd mFwNativeAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.fw.FWNativeViewAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements PtgAdNative.NativeExpressAdListener {
        final FWNativeViewAdapter this$0;

        static {
            OSETSDKProtected.interface11(3917);
        }

        public AnonymousClass1(FWNativeViewAdapter fWNativeViewAdapter) {
            this.this$0 = fWNativeViewAdapter;
        }

        @Override // com.kc.aw.lib.interf.Error
        public native void onError(AdError adError);

        @Override // com.kc.aw.lib.provider.PtgAdNative.NativeExpressAdListener
        public native void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.fw.FWNativeViewAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements PtgNativeExpressAd.AdInteractionListener {
        final FWNativeViewAdapter this$0;

        static {
            OSETSDKProtected.interface11(3918);
        }

        public AnonymousClass2(FWNativeViewAdapter fWNativeViewAdapter) {
            this.this$0 = fWNativeViewAdapter;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public native void onAdClicked();

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public native void onAdDismiss();

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public native void onAdShow();

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public native void onRenderFail(AdError adError);

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public native void onRenderSuccess(View view);
    }

    @Keep
    public class FWQDNativeViewAd implements OSETQDNativeViewAd {
        private NativeAdvertData mNativeAdvertData;
        private OSETQDNativeViewAd.OnQDAdInteractionListener mOnQDAdInteractionListener;
        private PtgNativeExpressAd mPtgNativeExpressAd;
        final FWNativeViewAdapter this$0;

        /* JADX INFO: renamed from: com.kc.openset.ad_embed.fw.FWNativeViewAdapter$FWQDNativeViewAd$1, reason: invalid class name */
        @Keep
        public class AnonymousClass1 implements View.OnClickListener {
            final FWQDNativeViewAd this$1;
            final Context val$context;
            final String val$url;
            final int val$urlType;

            static {
                OSETSDKProtected.interface11(3919);
            }

            public AnonymousClass1(FWQDNativeViewAd fWQDNativeViewAd, Context context, String str, int i) {
                this.this$1 = fWQDNativeViewAd;
                this.val$context = context;
                this.val$url = str;
                this.val$urlType = i;
            }

            @Override // android.view.View.OnClickListener
            public native void onClick(View view);
        }

        static {
            OSETSDKProtected.interface11(3920);
        }

        public FWQDNativeViewAd(FWNativeViewAdapter fWNativeViewAdapter, PtgNativeExpressAd ptgNativeExpressAd) {
            this.this$0 = fWNativeViewAdapter;
            this.mPtgNativeExpressAd = ptgNativeExpressAd;
            this.mNativeAdvertData = ptgNativeExpressAd.getAdvertData();
        }

        private native void bindToWebPage(Context context, TextView textView, String str, int i);

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native void bindPrivacyInfoClickListener(Context context, TextView textView, TextView textView2, TextView textView3);

        public native void destroy();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native boolean enableRotate();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getAdActionText();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getAdContent();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native int getAdEcpm();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getAdIcon();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native List<QDImages> getAdImageUrls();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getAdSource();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getAdSourceImg();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getAdTitle();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getAppDeveloper();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getAppName();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getAppPrivacyInfoUrl();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getAppVersion();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getIntroductionInfoUrl();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getPackageName();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getPermissionInfoUrl();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getRequestId();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native View getRotateView(Context context);

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native String getVideoCoverImageUrl();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native View getVideoView(Context context);

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native boolean isAppInfoVisibility();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native boolean isUsable();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native boolean isVideoMaterial();

        public native void onAdClicked();

        public native void onAdDismiss();

        public native void onAdShow();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native void registerViewForInteraction(Activity activity, ViewGroup viewGroup, View view, View view2, List<View> list, OSETQDNativeViewAd.OnQDAdInteractionListener onQDAdInteractionListener);
    }

    static {
        OSETSDKProtected.interface11(3921);
    }

    public static native /* synthetic */ PtgNativeExpressAd access$000(FWNativeViewAdapter fWNativeViewAdapter);

    public static native /* synthetic */ PtgNativeExpressAd access$002(FWNativeViewAdapter fWNativeViewAdapter, PtgNativeExpressAd ptgNativeExpressAd);

    public static native /* synthetic */ FWQDNativeViewAd access$100(FWNativeViewAdapter fWNativeViewAdapter);

    public static native /* synthetic */ void access$1000(FWNativeViewAdapter fWNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ FWQDNativeViewAd access$102(FWNativeViewAdapter fWNativeViewAdapter, FWQDNativeViewAd fWQDNativeViewAd);

    public static native /* synthetic */ void access$1100(FWNativeViewAdapter fWNativeViewAdapter, String str);

    public static native /* synthetic */ String access$1200(FWNativeViewAdapter fWNativeViewAdapter);

    public static native /* synthetic */ PtgNativeExpressAd.AdInteractionListener access$1300(FWNativeViewAdapter fWNativeViewAdapter);

    public static native /* synthetic */ void access$200(FWNativeViewAdapter fWNativeViewAdapter);

    public static native /* synthetic */ void access$300(FWNativeViewAdapter fWNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(FWNativeViewAdapter fWNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$500(FWNativeViewAdapter fWNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$600(FWNativeViewAdapter fWNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$700(FWNativeViewAdapter fWNativeViewAdapter, View view);

    public static native /* synthetic */ void access$800(FWNativeViewAdapter fWNativeViewAdapter, View view);

    public static native /* synthetic */ void access$900(FWNativeViewAdapter fWNativeViewAdapter, View view);

    private native PtgNativeExpressAd.AdInteractionListener getFwAdInteractionListener();

    private native PtgAdNative.NativeExpressAdListener getFwAdLoadListener();

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
    public native OSETQDNativeViewAd getQDNativeViewAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity, ViewHolderManager.ViewHolder viewHolder);
}
