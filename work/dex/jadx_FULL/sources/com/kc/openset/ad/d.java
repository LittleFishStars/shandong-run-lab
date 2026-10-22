package com.kc.openset.ad;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.BaseAdLoad;
import com.kc.openset.ad.bid.BidAdInfo;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.listener.OSETBaseListener;
import com.kc.openset.sdk.adv.OSETQDNativeViewAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaseAdLoad f39642a;
    private boolean b = false;
    private double c = AudioStats.AUDIO_AMPLITUDE_NONE;
    private double d = -9999.0d;
    private String e = "";
    private int f = 0;
    private boolean g = false;

    static {
        OSETSDKProtected.interface11(3850);
    }

    public d(BaseAdLoad baseAdLoad) {
        this.f39642a = baseAdLoad;
    }

    public native void a();

    public native void a(double d, String str, double d2);

    public native void a(BidAdInfo bidAdInfo);

    public native void a(d dVar);

    public native void a(d dVar, boolean z);

    public native void a(String str);

    public native boolean a(Activity activity, ViewGroup viewGroup, OSETBaseListener oSETBaseListener);

    public native boolean a(NativeViewConfig nativeViewConfig, Activity activity, OSETBaseListener oSETBaseListener);

    public native String b();

    public native void b(BidAdInfo bidAdInfo);

    public native void b(d dVar);

    public native String c();

    public native AdType d();

    public native String e();

    public native String f();

    public native String g();

    public native long h();

    public native int i();

    public native int j();

    public native String k();

    public native String l();

    public native int m();

    public native OSETQDNativeViewAd n();

    public native String o();

    public native String p();

    public native boolean q();

    public native boolean r();

    public native boolean s();

    public native boolean t();

    public native String toString();
}
