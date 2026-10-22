package com.kc.openset.ad_embed.ms;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.dw.core.ad.recycler.FeedInteractionListener;
import com.kc.dw.core.ad.recycler.RecyclerAdData;
import com.kc.dw.core.ad.recycler.RecyclerAdLoadListener;
import com.kc.dw.core.ad.recycler.RecyclerMixAdEventLoader;
import com.kc.dw.core.utils.AdError;
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
public class MSNativeViewAdapter extends BaseNativeViewBridge {
    private static final String TAG = OSETSDKProtected.getString2(855);
    private MSNativeViewAd mMSNativeViewAd;
    private RecyclerAdData mRecyclerAdData;
    private RecyclerMixAdEventLoader mRecyclerMixAdEventLoader;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSNativeViewAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements RecyclerAdLoadListener {
        final MSNativeViewAdapter this$0;

        static {
            OSETSDKProtected.interface11(4164);
        }

        public AnonymousClass1(MSNativeViewAdapter mSNativeViewAdapter) {
            this.this$0 = mSNativeViewAdapter;
        }

        @Override // com.kc.dw.core.ad.recycler.RecyclerAdLoadListener
        public native void onLoadFail(AdError adError);

        @Override // com.kc.dw.core.ad.recycler.RecyclerAdLoadListener
        public native void onLoadedSuccess(List<RecyclerAdData> list);
    }

    @Keep
    public class MSNativeViewAd implements OSETQDNativeViewAd {
        private OSETQDNativeViewAd.OnQDAdInteractionListener mQDAdInteractionListener;
        private RecyclerAdData mRecyclerAdData;
        private WeakReference<View> mWeakReferenceContainerView;
        final MSNativeViewAdapter this$0;

        /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSNativeViewAdapter$MSNativeViewAd$1, reason: invalid class name */
        @Keep
        public class AnonymousClass1 implements View.OnClickListener {
            final MSNativeViewAd this$1;
            final Context val$context;
            final String val$url;
            final int val$urlType;

            static {
                OSETSDKProtected.interface11(4166);
            }

            public AnonymousClass1(MSNativeViewAd mSNativeViewAd, Context context, String str, int i) {
                this.this$1 = mSNativeViewAd;
                this.val$context = context;
                this.val$url = str;
                this.val$urlType = i;
            }

            @Override // android.view.View.OnClickListener
            public native void onClick(View view);
        }

        /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSNativeViewAdapter$MSNativeViewAd$2, reason: invalid class name */
        @Keep
        public class AnonymousClass2 implements FeedInteractionListener {
            final MSNativeViewAd this$1;

            static {
                OSETSDKProtected.interface11(4167);
            }

            public AnonymousClass2(MSNativeViewAd mSNativeViewAd) {
                this.this$1 = mSNativeViewAd;
            }

            @Override // com.kc.dw.core.loader.InteractionListener
            public native void onAdClicked();

            @Override // com.kc.dw.core.loader.InteractionListener
            public native void onAdClosed();

            @Override // com.kc.dw.core.loader.InteractionListener
            public native void onAdExposure();
        }

        static {
            OSETSDKProtected.interface11(4168);
        }

        public MSNativeViewAd(MSNativeViewAdapter mSNativeViewAdapter, RecyclerAdData recyclerAdData) {
            this.this$0 = mSNativeViewAdapter;
            this.mRecyclerAdData = recyclerAdData;
        }

        public static native /* synthetic */ OSETQDNativeViewAd.OnQDAdInteractionListener access$800(MSNativeViewAd mSNativeViewAd);

        public static native /* synthetic */ WeakReference access$900(MSNativeViewAd mSNativeViewAd);

        private native void bindToWebPage(Context context, TextView textView, String str, int i);

        private native FeedInteractionListener getAdActionListener();

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

        /* JADX INFO: renamed from: lambda$registerViewForInteraction$0$com-kc-openset-ad_embed-ms-MSNativeViewAdapter$MSNativeViewAd, reason: not valid java name */
        public native /* synthetic */ void m1024xbb1aeee7(View view);

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
        public native void registerViewForInteraction(Activity activity, ViewGroup viewGroup, View view, View view2, List<View> list, OSETQDNativeViewAd.OnQDAdInteractionListener onQDAdInteractionListener);
    }

    static {
        OSETSDKProtected.interface11(4169);
    }

    public static native /* synthetic */ void access$000(MSNativeViewAdapter mSNativeViewAdapter, int i, String str);

    public static native /* synthetic */ RecyclerAdData access$100(MSNativeViewAdapter mSNativeViewAdapter);

    public static native /* synthetic */ void access$1000(MSNativeViewAdapter mSNativeViewAdapter, View view);

    public static native /* synthetic */ RecyclerAdData access$102(MSNativeViewAdapter mSNativeViewAdapter, RecyclerAdData recyclerAdData);

    public static native /* synthetic */ void access$1100(MSNativeViewAdapter mSNativeViewAdapter, View view);

    public static native /* synthetic */ void access$1200(MSNativeViewAdapter mSNativeViewAdapter, View view);

    public static native /* synthetic */ void access$1300(MSNativeViewAdapter mSNativeViewAdapter, View view);

    public static native /* synthetic */ void access$200(MSNativeViewAdapter mSNativeViewAdapter, int i, String str);

    public static native /* synthetic */ MSNativeViewAd access$300(MSNativeViewAdapter mSNativeViewAdapter);

    public static native /* synthetic */ MSNativeViewAd access$302(MSNativeViewAdapter mSNativeViewAdapter, MSNativeViewAd mSNativeViewAd);

    public static native /* synthetic */ void access$400(MSNativeViewAdapter mSNativeViewAdapter);

    public static native /* synthetic */ void access$500(MSNativeViewAdapter mSNativeViewAdapter, int i, String str);

    public static native /* synthetic */ void access$600(MSNativeViewAdapter mSNativeViewAdapter, int i, String str);

    public static native /* synthetic */ String access$701(MSNativeViewAdapter mSNativeViewAdapter);

    private native RecyclerAdLoadListener getAdLoadListener();

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
