package com.kc.openset.ad_embed.gdt.gdt_4_671_1541;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.ViewHolderManager;
import com.kc.openset.ad.base.bridge.BaseNativeViewBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class g extends BaseNativeViewBridge implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeUnifiedADData f39675a;
    private ViewHolderManager.ViewHolder b;
    String c;
    String d;
    String e;
    String f;

    @Keep
    public class a implements NativeADUnifiedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g f39676a;

        static {
            OSETSDKProtected.interface11(3944);
        }

        public a(g gVar) {
            this.f39676a = gVar;
        }

        public native void onADLoaded(List<NativeUnifiedADData> list);

        public native void onNoAD(AdError adError);
    }

    @Keep
    public class b implements NativeADEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g f39677a;

        static {
            OSETSDKProtected.interface11(3945);
        }

        public b(g gVar) {
            this.f39677a = gVar;
        }

        public native void onADClicked();

        public native void onADError(AdError adError);

        public native void onADExposed();

        public native void onADStatusChanged();
    }

    static {
        OSETSDKProtected.interface11(3946);
    }

    private native NativeUnifiedAD a();

    public static native /* synthetic */ NativeUnifiedADData a(g gVar);

    public static native /* synthetic */ NativeUnifiedADData a(g gVar, NativeUnifiedADData nativeUnifiedADData);

    private native void a(Activity activity, ViewHolderManager.ViewHolder viewHolder);

    private native void a(Context context, String str, int i);

    private native void a(Context context, String str, int i, boolean z);

    public static native /* synthetic */ void a(g gVar, View view);

    public static native /* synthetic */ void a(g gVar, String str, String str2);

    private native void b();

    public static native /* synthetic */ void b(g gVar);

    public static native /* synthetic */ void b(g gVar, View view);

    public static native /* synthetic */ void b(g gVar, String str, String str2);

    public static native /* synthetic */ void c(g gVar, String str, String str2);

    public static native /* synthetic */ boolean c(g gVar);

    public static native /* synthetic */ ViewHolderManager.ViewHolder d(g gVar);

    public static native /* synthetic */ void d(g gVar, String str, String str2);

    public static native /* synthetic */ void e(g gVar, String str, String str2);

    public native void a(Activity activity, ViewGroup viewGroup);

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
