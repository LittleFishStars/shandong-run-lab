package com.kc.openset.ad_embed.zy;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.cw.ad.NativeAd;
import com.kc.cw.ad.NativeAdListener;
import com.kc.cw.ad.NativeAdResponse;
import com.kc.cw.ad.internal.nativead.NativeAdEventListener;
import com.kc.openset.ad.base.ViewHolderManager;
import com.kc.openset.ad.base.bridge.BaseNativeViewBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.bean.QDImages;
import com.kc.openset.sdk.adv.OSETQDNativeViewAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ZYNativeViewAdapter extends BaseNativeViewBridge implements View.OnClickListener {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(904);
    private static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE);
    private static final String TAG = OSETSDKProtected.getString2(947);
    private NativeAd mNativeAd;
    private NativeAdResponse mNativeAdResponse;
    private ViewHolderManager.ViewHolder mViewHolder;
    private WeakReference<ViewGroup> mWeakReferenceAdContainer;
    private ZYNativeViewAdImp mZYNativeVieAdImp;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.zy.ZYNativeViewAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements NativeAdListener {
        final ZYNativeViewAdapter this$0;

        static {
            OSETSDKProtected.interface11(4219);
        }

        public AnonymousClass1(ZYNativeViewAdapter zYNativeViewAdapter) {
            this.this$0 = zYNativeViewAdapter;
        }

        @Override // com.kc.cw.ad.NativeAdListener
        public native void onAdFailed(int i);

        @Override // com.kc.cw.ad.NativeAdListener
        public native void onAdLoaded(NativeAdResponse nativeAdResponse);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.zy.ZYNativeViewAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements NativeAdEventListener {
        final ZYNativeViewAdapter this$0;

        static {
            OSETSDKProtected.interface11(4220);
        }

        public AnonymousClass2(ZYNativeViewAdapter zYNativeViewAdapter) {
            this.this$0 = zYNativeViewAdapter;
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

    @Keep
    public class ZYNativeViewAdImp implements OSETQDNativeViewAd {
        private NativeAdResponse mNativeAdResponse;
        private OSETQDNativeViewAd.OnQDAdInteractionListener onQDAdInteractionListener;
        final ZYNativeViewAdapter this$0;

        /* JADX INFO: renamed from: com.kc.openset.ad_embed.zy.ZYNativeViewAdapter$ZYNativeViewAdImp$1, reason: invalid class name */
        @Keep
        public class AnonymousClass1 implements NativeAdEventListener {
            final ZYNativeViewAdImp this$1;

            static {
                OSETSDKProtected.interface11(4221);
            }

            public AnonymousClass1(ZYNativeViewAdImp zYNativeViewAdImp) {
                this.this$1 = zYNativeViewAdImp;
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

        /* JADX INFO: renamed from: com.kc.openset.ad_embed.zy.ZYNativeViewAdapter$ZYNativeViewAdImp$2, reason: invalid class name */
        @Keep
        public class AnonymousClass2 implements View.OnClickListener {
            final ZYNativeViewAdImp this$1;
            final Context val$context;
            final String val$url;
            final int val$urlType;

            static {
                OSETSDKProtected.interface11(4222);
            }

            public AnonymousClass2(ZYNativeViewAdImp zYNativeViewAdImp, Context context, String str, int i) {
                this.this$1 = zYNativeViewAdImp;
                this.val$context = context;
                this.val$url = str;
                this.val$urlType = i;
            }

            @Override // android.view.View.OnClickListener
            public native void onClick(View view);
        }

        static {
            OSETSDKProtected.interface11(4223);
        }

        public ZYNativeViewAdImp(ZYNativeViewAdapter zYNativeViewAdapter, NativeAdResponse nativeAdResponse) {
            this.this$0 = zYNativeViewAdapter;
            this.mNativeAdResponse = nativeAdResponse;
        }

        public static native /* synthetic */ OSETQDNativeViewAd.OnQDAdInteractionListener access$1200(ZYNativeViewAdImp zYNativeViewAdImp);

        private native void bindToWebPage(Context context, TextView textView, String str, int i);

        private native NativeAdEventListener getNativeAdEventListener();

        private native boolean noDownload();

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

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native void registerViewForInteraction(Activity activity, ViewGroup viewGroup, View view, View view2, List<View> list, OSETQDNativeViewAd.OnQDAdInteractionListener onQDAdInteractionListener);
    }

    static {
        OSETSDKProtected.interface11(4224);
    }

    public static native /* synthetic */ void access$000(ZYNativeViewAdapter zYNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ NativeAdResponse access$100(ZYNativeViewAdapter zYNativeViewAdapter);

    public static native /* synthetic */ NativeAd access$1000(ZYNativeViewAdapter zYNativeViewAdapter);

    public static native /* synthetic */ NativeAdResponse access$102(ZYNativeViewAdapter zYNativeViewAdapter, NativeAdResponse nativeAdResponse);

    public static native /* synthetic */ WeakReference access$1100(ZYNativeViewAdapter zYNativeViewAdapter);

    public static native /* synthetic */ WeakReference access$1102(ZYNativeViewAdapter zYNativeViewAdapter, WeakReference weakReference);

    public static native /* synthetic */ void access$1300(ZYNativeViewAdapter zYNativeViewAdapter, View view);

    public static native /* synthetic */ void access$1400(ZYNativeViewAdapter zYNativeViewAdapter, View view);

    public static native /* synthetic */ void access$1500(ZYNativeViewAdapter zYNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$1600(ZYNativeViewAdapter zYNativeViewAdapter, View view);

    public static native /* synthetic */ ZYNativeViewAdImp access$200(ZYNativeViewAdapter zYNativeViewAdapter);

    public static native /* synthetic */ ZYNativeViewAdImp access$202(ZYNativeViewAdapter zYNativeViewAdapter, ZYNativeViewAdImp zYNativeViewAdImp);

    public static native /* synthetic */ void access$300(ZYNativeViewAdapter zYNativeViewAdapter);

    public static native /* synthetic */ void access$400(ZYNativeViewAdapter zYNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ ViewHolderManager.ViewHolder access$500(ZYNativeViewAdapter zYNativeViewAdapter);

    public static native /* synthetic */ void access$600(ZYNativeViewAdapter zYNativeViewAdapter, View view);

    public static native /* synthetic */ void access$700(ZYNativeViewAdapter zYNativeViewAdapter, View view);

    public static native /* synthetic */ void access$800(ZYNativeViewAdapter zYNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$900(ZYNativeViewAdapter zYNativeViewAdapter, View view);

    private native void bindAdEventListener(ViewGroup viewGroup);

    private native NativeAdListener createAndSetAdAllListener();

    private native void createNativeAd(Activity activity, ViewHolderManager.ViewHolder viewHolder);

    private native void returnWebPage(Context context, String str, int i);

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

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // android.view.View.OnClickListener
    public native void onClick(View view);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity, ViewHolderManager.ViewHolder viewHolder);
}
