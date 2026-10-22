package com.kc.openset.ad_embed.gdt.gdt_4_671_1541;

import androidx.fragment.app.Fragment;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.video.BaseTuBeBridge;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.immersive.ImmersiveADFlow;
import com.qq.e.ads.immersive.ImmersiveADFlowListener;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class k extends BaseTuBeBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImmersiveADFlow f39683a;

    @Keep
    public class a implements ImmersiveADFlowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final k f39684a;

        static {
            OSETSDKProtected.interface11(3953);
        }

        public a(k kVar) {
            this.f39684a = kVar;
        }

        public native void onADClick(String str);

        public native void onADExpose(String str);

        public native void onADLoaded();

        public native void onADPageDestroy();

        public native void onADPageShow();

        public native void onNoAD(AdError adError);
    }

    static {
        OSETSDKProtected.interface11(3954);
    }

    public static native /* synthetic */ ImmersiveADFlow a(k kVar);

    private native ImmersiveADFlowListener a();

    public static native /* synthetic */ void a(k kVar, Fragment fragment);

    public static native /* synthetic */ void a(k kVar, String str, String str2);

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native void destroy();

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native String getAdvertisers();

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native String getLogTag();

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native String getParentAdId();

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native int getPrice();

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native void loadVideoContent();

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native boolean onBackPress();

    @Override // com.kc.openset.ad.base.bridge.video.BaseVideoBridge, com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native void onHiddenChanged(boolean z);

    @Override // com.kc.openset.ad.base.bridge.video.BaseVideoBridge, com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native void onPause();

    @Override // com.kc.openset.ad.base.bridge.video.BaseVideoBridge, com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native void onResume();

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native void onTaskError(String str);

    @Override // com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native void onTaskFinish();

    @Override // com.kc.openset.ad.base.bridge.video.BaseVideoBridge, com.kc.openset.ad.base.bridge.video.VideoContentBridge
    public native void setUserVisibleHint(boolean z);
}
