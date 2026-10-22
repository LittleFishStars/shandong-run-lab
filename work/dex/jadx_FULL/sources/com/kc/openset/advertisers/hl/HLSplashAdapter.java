package com.kc.openset.advertisers.hl;

import android.app.Activity;
import android.view.ViewGroup;
import com.hailiang.advlib.core.AdRequestParam;
import com.hailiang.advlib.core.IMultiAdObject;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseSplashBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HLSplashAdapter extends BaseSplashBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(401);
    private static final String FRONT = OSETSDKProtected.getString2(1041);
    private static final String TAG = OSETSDKProtected.getString2(1064);
    private IMultiAdObject mSplashAd;

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLSplashAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements AdRequestParam.ADLoadListener {
        final HLSplashAdapter this$0;

        static {
            OSETSDKProtected.interface11(4281);
        }

        public AnonymousClass1(HLSplashAdapter hLSplashAdapter) {
            this.this$0 = hLSplashAdapter;
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
        public native void onADLoaded(IMultiAdObject iMultiAdObject);

        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
        public native void onAdFailed(String str);
    }

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLSplashAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements IMultiAdObject.SplashEventListener {
        final HLSplashAdapter this$0;

        static {
            OSETSDKProtected.interface11(4282);
        }

        public AnonymousClass2(HLSplashAdapter hLSplashAdapter) {
            this.this$0 = hLSplashAdapter;
        }

        @Override // com.hailiang.advlib.core.IMultiAdObject.SplashEventListener
        public native void onObClicked();

        @Override // com.hailiang.advlib.core.IMultiAdObject.SplashEventListener
        public native void onObShow();

        @Override // com.hailiang.advlib.core.IMultiAdObject.SplashEventListener
        public native void onObSkip();

        @Override // com.hailiang.advlib.core.IMultiAdObject.SplashEventListener
        public native void onObTimeOver();
    }

    static {
        OSETSDKProtected.interface11(4283);
    }

    public static native /* synthetic */ IMultiAdObject access$002(HLSplashAdapter hLSplashAdapter, IMultiAdObject iMultiAdObject);

    public static native /* synthetic */ void access$100(HLSplashAdapter hLSplashAdapter);

    public static native /* synthetic */ void access$200(HLSplashAdapter hLSplashAdapter, String str, String str2);

    public static native /* synthetic */ void access$300(HLSplashAdapter hLSplashAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(HLSplashAdapter hLSplashAdapter);

    public static native /* synthetic */ void access$500(HLSplashAdapter hLSplashAdapter);

    public static native /* synthetic */ void access$600(HLSplashAdapter hLSplashAdapter);

    public static native /* synthetic */ void access$700(HLSplashAdapter hLSplashAdapter);

    private native AdRequestParam.ADLoadListener getLoadListener();

    private native IMultiAdObject.SplashEventListener getSplashEventListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseSplashBridge, com.kc.openset.ad.base.bridge.AdBridge
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
    public native void toShowAd(Activity activity, ViewGroup viewGroup);
}
