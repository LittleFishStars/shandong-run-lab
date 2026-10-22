package com.kc.openset.advertisers.hl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.hailiang.advlib.core.AdRequestParam;
import com.hailiang.advlib.core.IAppDownloadListener;
import com.hailiang.advlib.core.IMultiAdObject;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.ViewHolderManager;
import com.kc.openset.ad.base.bridge.BaseNativeViewBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HLNativeViewAdapter extends BaseNativeViewBridge implements View.OnClickListener {
    private static final int INTERACTION_TYPE_DOWNLOAD = 2;
    private static final int INTERACTION_TYPE_LANDPAGE = 1;
    private static final int MATERIAL_TYPE_BIG_IMAGE = 2;
    private static final int MATERIAL_TYPE_GROUP_IMAGE = 3;
    private static final int MATERIAL_TYPE_SMALL_IMAGE = 1;
    private static final int MATERIAL_TYPE_VIDEO_H = 4;
    private static final int MATERIAL_TYPE_VIDEO_V = 9;
    private IMultiAdObject mAdModel;
    private String mAppName;
    private String mFunctionDescUrl;
    private String mPermissionProtocolUrl;
    private String mPrivacyProtocolUrl;
    private ViewHolderManager.ViewHolder mViewHolder;
    private WeakReference<Button> mWeakReferenceBtn;
    private WeakReference<View> mWeakReferenceView;
    private static final String ADVERTISERS = OSETSDKProtected.getString2(401);
    private static final String FRONT = OSETSDKProtected.getString2(1041);
    private static final String TAG = OSETSDKProtected.getString2(1059);

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLNativeViewAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements AdRequestParam.ADLoadListener {
        final HLNativeViewAdapter this$0;

        static {
            OSETSDKProtected.interface11(4274);
        }

        public AnonymousClass1(HLNativeViewAdapter hLNativeViewAdapter) {
            this.this$0 = hLNativeViewAdapter;
        }

        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
        public native void onADLoaded(IMultiAdObject iMultiAdObject);

        @Override // com.hailiang.advlib.core.AdRequestParam.ADLoadListener
        public native void onAdFailed(String str);
    }

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLNativeViewAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements IMultiAdObject.ADEventListener {
        final HLNativeViewAdapter this$0;

        static {
            OSETSDKProtected.interface11(4275);
        }

        public AnonymousClass2(HLNativeViewAdapter hLNativeViewAdapter) {
            this.this$0 = hLNativeViewAdapter;
        }

        @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
        public native void onADExposed();

        @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
        public native void onAdClick();

        @Override // com.hailiang.advlib.core.IMultiAdObject.ADEventListener
        public native void onAdFailed(String str);
    }

    /* JADX INFO: renamed from: com.kc.openset.advertisers.hl.HLNativeViewAdapter$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements IAppDownloadListener {
        final HLNativeViewAdapter this$0;

        static {
            OSETSDKProtected.interface11(4276);
        }

        public AnonymousClass3(HLNativeViewAdapter hLNativeViewAdapter) {
            this.this$0 = hLNativeViewAdapter;
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
        OSETSDKProtected.interface11(4277);
    }

    public static native /* synthetic */ void access$000(HLNativeViewAdapter hLNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ void access$100(HLNativeViewAdapter hLNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ WeakReference access$1000(HLNativeViewAdapter hLNativeViewAdapter);

    public static native /* synthetic */ void access$200(HLNativeViewAdapter hLNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ IMultiAdObject access$302(HLNativeViewAdapter hLNativeViewAdapter, IMultiAdObject iMultiAdObject);

    public static native /* synthetic */ void access$400(HLNativeViewAdapter hLNativeViewAdapter);

    public static native /* synthetic */ void access$500(HLNativeViewAdapter hLNativeViewAdapter, String str, String str2);

    public static native /* synthetic */ WeakReference access$600(HLNativeViewAdapter hLNativeViewAdapter);

    public static native /* synthetic */ void access$700(HLNativeViewAdapter hLNativeViewAdapter, View view);

    public static native /* synthetic */ void access$800(HLNativeViewAdapter hLNativeViewAdapter, View view);

    public static native /* synthetic */ void access$900(HLNativeViewAdapter hLNativeViewAdapter, String str, String str2);

    private native void createView(Activity activity, ViewHolderManager.ViewHolder viewHolder);

    private native IMultiAdObject.ADEventListener getAdActionListener();

    private native IAppDownloadListener getDownloadListener();

    private native AdRequestParam.ADLoadListener getLoadListener();

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
