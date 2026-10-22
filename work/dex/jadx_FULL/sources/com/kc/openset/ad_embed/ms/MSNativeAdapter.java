package com.kc.openset.ad_embed.ms;

import android.app.Activity;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener;
import com.kc.dw.core.ad.recycler.RecyclerAdData;
import com.kc.dw.core.ad.recycler.RecyclerAdLoadListener;
import com.kc.dw.core.ad.recycler.RecyclerMixAdEventLoader;
import com.kc.dw.core.utils.AdError;
import com.kc.openset.ad.base.bridge.BaseNativeBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class MSNativeAdapter extends BaseNativeBridge {
    private static final String TAG = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_MASK_STREAM_OPEN_TIME);
    private RecyclerAdData mRecyclerAdData;
    private RecyclerMixAdEventLoader mRecyclerMixAdEventLoader;
    private WeakReference<View> mWeakReferenceExpressView;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSNativeAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements RecyclerAdLoadListener {
        final MSNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(4161);
        }

        public AnonymousClass1(MSNativeAdapter mSNativeAdapter) {
            this.this$0 = mSNativeAdapter;
        }

        @Override // com.kc.dw.core.ad.recycler.RecyclerAdLoadListener
        public native void onLoadFail(AdError adError);

        @Override // com.kc.dw.core.ad.recycler.RecyclerAdLoadListener
        public native void onLoadedSuccess(List<RecyclerAdData> list);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSNativeAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements FeedExpressAdInteractionListener {
        final MSNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(4162);
        }

        public AnonymousClass2(MSNativeAdapter mSNativeAdapter) {
            this.this$0 = mSNativeAdapter;
        }

        @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
        public native void onAdClicked();

        @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
        public native void onAdClosed();

        @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
        public native void onAdExposure();

        @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener
        public native void onRenderError(int i, String str);

        @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener
        public native void onRenderSuccess();
    }

    static {
        OSETSDKProtected.interface11(4163);
    }

    public static native /* synthetic */ void access$000(MSNativeAdapter mSNativeAdapter, int i, String str);

    public static native /* synthetic */ RecyclerAdData access$100(MSNativeAdapter mSNativeAdapter);

    public static native /* synthetic */ void access$1000(MSNativeAdapter mSNativeAdapter, int i, String str);

    public static native /* synthetic */ RecyclerAdData access$102(MSNativeAdapter mSNativeAdapter, RecyclerAdData recyclerAdData);

    public static native /* synthetic */ void access$1100(MSNativeAdapter mSNativeAdapter, View view);

    public static native /* synthetic */ void access$1200(MSNativeAdapter mSNativeAdapter, View view, String str, String str2);

    public static native /* synthetic */ void access$200(MSNativeAdapter mSNativeAdapter, int i, String str);

    public static native /* synthetic */ void access$300(MSNativeAdapter mSNativeAdapter);

    public static native /* synthetic */ void access$400(MSNativeAdapter mSNativeAdapter, int i, String str);

    public static native /* synthetic */ void access$500(MSNativeAdapter mSNativeAdapter, int i, String str);

    public static native /* synthetic */ WeakReference access$600(MSNativeAdapter mSNativeAdapter);

    public static native /* synthetic */ WeakReference access$602(MSNativeAdapter mSNativeAdapter, WeakReference weakReference);

    public static native /* synthetic */ void access$700(MSNativeAdapter mSNativeAdapter, View view);

    public static native /* synthetic */ void access$800(MSNativeAdapter mSNativeAdapter, View view);

    public static native /* synthetic */ void access$900(MSNativeAdapter mSNativeAdapter, View view);

    private native RecyclerAdLoadListener getAdLoadListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseNativeBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdTitle();

    @Override // com.kc.openset.ad.base.bridge.BaseNativeBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdUserName();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdvertisers();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native int getEcpm();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getLogTag();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getParentAdId();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
