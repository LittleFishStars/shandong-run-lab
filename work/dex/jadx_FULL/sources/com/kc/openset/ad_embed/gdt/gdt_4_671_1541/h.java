package com.kc.openset.ad_embed.gdt.gdt_4_671_1541;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseRewardBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class h extends BaseRewardBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RewardVideoAD f39678a;

    @Keep
    public class a implements RewardVideoADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h f39679a;

        static {
            OSETSDKProtected.interface11(3947);
        }

        public a(h hVar) {
            this.f39679a = hVar;
        }

        public native void onADClick();

        public native void onADClose();

        public native void onADExpose();

        public native void onADLoad();

        public native void onADShow();

        public native void onError(AdError adError);

        public native void onReward(Map<String, Object> map);

        public native void onVideoCached();

        public native void onVideoComplete();
    }

    static {
        OSETSDKProtected.interface11(3948);
    }

    private native RewardVideoAD a(String str);

    public static native /* synthetic */ void a(h hVar);

    public static native /* synthetic */ void a(h hVar, String str, String str2);

    public static native /* synthetic */ void b(h hVar);

    public static native /* synthetic */ void b(h hVar, String str, String str2);

    public static native /* synthetic */ void c(h hVar);

    public static native /* synthetic */ void d(h hVar);

    public static native /* synthetic */ void e(h hVar);

    public static native /* synthetic */ void f(h hVar);

    public static native /* synthetic */ void g(h hVar);

    public static native /* synthetic */ boolean h(h hVar);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

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

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
