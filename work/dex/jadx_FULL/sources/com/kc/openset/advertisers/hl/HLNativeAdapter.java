package com.kc.openset.advertisers.hl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.hailiang.advlib.core.AdRequestParam;
import com.hailiang.advlib.core.IMultiAdObject;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseNativeBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HLNativeAdapter extends BaseNativeBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(401);
    private static final String FRONT = OSETSDKProtected.getString2(1041);
    private static final String TAG = OSETSDKProtected.getString2(1036);
    private IMultiAdObject mAdModel;
    private WeakReference<FrameLayout> mWeakReferenceFl;

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLNativeAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements AdRequestParam.ADLoadListener {
        final HLNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(4271);
        }

        public AnonymousClass1(HLNativeAdapter hLNativeAdapter) {
            this.this$0 = hLNativeAdapter;
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
        public native void onADLoaded(IMultiAdObject iMultiAdObject);

        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
        public native void onAdFailed(String str);
    }

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLNativeAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements IMultiAdObject.ADEventListener {
        final HLNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(4272);
        }

        public AnonymousClass2(HLNativeAdapter hLNativeAdapter) {
            this.this$0 = hLNativeAdapter;
        }

        @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
        public native void onADExposed();

        @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
        public native void onAdClick();

        @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
        public native void onAdFailed(String str);
    }

    static {
        OSETSDKProtected.interface11(4273);
    }

    public static native /* synthetic */ void access$000(HLNativeAdapter hLNativeAdapter, String str, String str2);

    public static native /* synthetic */ IMultiAdObject access$102(HLNativeAdapter hLNativeAdapter, IMultiAdObject iMultiAdObject);

    public static native /* synthetic */ void access$200(HLNativeAdapter hLNativeAdapter);

    public static native /* synthetic */ void access$300(HLNativeAdapter hLNativeAdapter, String str, String str2);

    public static native /* synthetic */ WeakReference access$400(HLNativeAdapter hLNativeAdapter);

    public static native /* synthetic */ void access$500(HLNativeAdapter hLNativeAdapter, View view);

    public static native /* synthetic */ void access$600(HLNativeAdapter hLNativeAdapter, View view);

    public static native /* synthetic */ void access$700(HLNativeAdapter hLNativeAdapter, String str, String str2);

    private native void bindView();

    private native void createAdStatusListener();

    private native AdRequestParam.ADLoadListener getLoadListener();

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

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    /* JADX INFO: renamed from: lambda$createAdStatusListener$0$com-kc-openset-advertisers-hl-HLNativeAdapter, reason: not valid java name */
    public native /* synthetic */ void m1026x7c3760b8(int i, Bundle bundle);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadS2SAd(String str);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
