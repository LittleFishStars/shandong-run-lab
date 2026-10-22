package com.kc.openset.advertisers.hl;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import com.hailiang.advlib.core.AdRequestParam;
import com.hailiang.advlib.core.IAppDownloadListener;
import com.hailiang.advlib.core.IMultiAdObject;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseBannerBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HLBannerAdapter extends BaseBannerBridge implements View.OnClickListener {
    private static final int INTERACTION_TYPE_DOWNLOAD = 2;
    private static final int INTERACTION_TYPE_LANDPAGE = 1;
    private static final int MATERIAL_TYPE_BIG_IMAGE = 2;
    private static final int MATERIAL_TYPE_GROUP_IMAGE = 3;
    private static final int MATERIAL_TYPE_SMALL_IMAGE = 1;
    private static final int MATERIAL_TYPE_VIDEO_H = 4;
    private static final int MATERIAL_TYPE_VIDEO_V = 9;
    private IMultiAdObject mAdModel;
    private WeakReference<Button> mWeakReferenceBtn;
    private WeakReference<View> mWeakReferenceView;
    private static final String ADVERTISERS = OSETSDKProtected.getString2(401);
    private static final String FRONT = OSETSDKProtected.getString2(1041);
    private static final String TAG = OSETSDKProtected.getString2(1036);

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLBannerAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements AdRequestParam.ADLoadListener {
        final HLBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4259);
        }

        public AnonymousClass1(HLBannerAdapter hLBannerAdapter) {
            this.this$0 = hLBannerAdapter;
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
        public native void onADLoaded(IMultiAdObject iMultiAdObject);

        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
        public native void onAdFailed(String str);
    }

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLBannerAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements IMultiAdObject.ADEventListener {
        final HLBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4260);
        }

        public AnonymousClass2(HLBannerAdapter hLBannerAdapter) {
            this.this$0 = hLBannerAdapter;
        }

        @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
        public native void onADExposed();

        @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
        public native void onAdClick();

        @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
        public native void onAdFailed(String str);
    }

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLBannerAdapter$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements IAppDownloadListener {
        final HLBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4261);
        }

        public AnonymousClass3(HLBannerAdapter hLBannerAdapter) {
            this.this$0 = hLBannerAdapter;
        }

        @Override // com.hailiang.advlib.core.IAppDownloadListener
        public native void onDownloadActive(long j, long j2, String str);

        @Override // com.hailiang.advlib.core.IAppDownloadListener
        public native void onDownloadCompleted(String str);

        @Override // com.hailiang.advlib.core.IAppDownloadListener
        public native void onDownloadFailed();

        @Override // com.hailiang.advlib.core.IAppDownloadListener
        public native void onDownloadPaused(long j, long j2, String str);

        @Override // com.hailiang.advlib.core.IAppDownloadListener
        public native void onIdle();

        @Override // com.hailiang.advlib.core.IAppDownloadListener
        public native void onInstalled(String str);
    }

    static {
        OSETSDKProtected.interface11(4262);
    }

    public static native /* synthetic */ void access$000(HLBannerAdapter hLBannerAdapter, String str, String str2);

    public static native /* synthetic */ void access$100(HLBannerAdapter hLBannerAdapter, String str, String str2);

    public static native /* synthetic */ WeakReference access$1000(HLBannerAdapter hLBannerAdapter);

    public static native /* synthetic */ void access$200(HLBannerAdapter hLBannerAdapter, String str, String str2);

    public static native /* synthetic */ IMultiAdObject access$302(HLBannerAdapter hLBannerAdapter, IMultiAdObject iMultiAdObject);

    public static native /* synthetic */ void access$400(HLBannerAdapter hLBannerAdapter);

    public static native /* synthetic */ void access$500(HLBannerAdapter hLBannerAdapter, String str, String str2);

    public static native /* synthetic */ WeakReference access$600(HLBannerAdapter hLBannerAdapter);

    public static native /* synthetic */ void access$700(HLBannerAdapter hLBannerAdapter, View view);

    public static native /* synthetic */ void access$800(HLBannerAdapter hLBannerAdapter, View view);

    public static native /* synthetic */ void access$900(HLBannerAdapter hLBannerAdapter, String str, String str2);

    private native void createView(Activity activity);

    private native IMultiAdObject.ADEventListener getAdActionListener();

    private native IAppDownloadListener getDownloadListener();

    private native AdRequestParam.ADLoadListener getLoadListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseBannerBridge, com.kc.openset.ad.base.bridge.AdBridge
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

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // android.view.View.OnClickListener
    public native void onClick(View view);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadS2SAd(String str);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
