package com.kc.openset.sdk.adv.hub;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.sdk.adv.OSETQDNativeViewAd;
import com.kc.openset.sdk.adv.OSETQDNativeViewAdImp;
import com.kc.openset.sdk.adv.OSETVideoPlayerListener;
import com.kc.openset.sdk.adv.OSETVideoPlayerManager;
import com.kc.openset.sdk.adv.listener.ADVBaseListener;
import com.kc.openset.sdk.adv.listener.ADVNativeViewListener;
import com.kc.openset.sdk.apiad.tools.OSETClicksData;
import com.kc.openset.sdk.apiad.tools.OnAdTouchListener;
import com.kc.openset.sdk.apiad.tools.PlayState;
import com.kc.openset.sdk.apiad.tools.i;
import com.kc.openset.util.ShakeItUtils;
import com.kc.openset.util.TiltSensorUtils;
import com.kc.openset.view.OSETShakeView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class d extends ADVAdObject implements ShakeItUtils.OnShakeListener, TiltSensorUtils.OnTiltListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f39847a;
    private boolean b;
    private boolean c;
    private OSETVideoPlayerManager d;
    private RelativeLayout e;
    private OSETShakeView f;
    private boolean g;
    private ShakeItUtils h;
    private TiltSensorUtils i;
    private final boolean[] j;
    private ViewGroup k;
    private View l;
    private OSETQDNativeViewAdImp m;
    private boolean n;
    private final ViewTreeObserver.OnPreDrawListener o;

    @Keep
    public class a implements OSETQDNativeViewAdImp.QDNativeViewInnerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f39848a;

        static {
            OSETSDKProtected.interface11(4746);
        }

        public a(d dVar) {
            this.f39848a = dVar;
        }

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAdImp.QDNativeViewInnerListener
        public native View getRotateView(Context context);

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAdImp.QDNativeViewInnerListener
        public native int[] getTiltSensorSen();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAdImp.QDNativeViewInnerListener
        public native View getVideoView(Context context);

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAdImp.QDNativeViewInnerListener
        public native boolean isClickCallback();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAdImp.QDNativeViewInnerListener
        public native boolean isUsable();

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAdImp.QDNativeViewInnerListener
        public native void onClick(View view, OSETClicksData oSETClicksData);

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAdImp.QDNativeViewInnerListener
        public native void onClose(ViewGroup viewGroup);

        @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAdImp.QDNativeViewInnerListener
        public native void onShow(ViewGroup viewGroup);
    }

    @Keep
    public class b implements OSETVideoPlayerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f39849a;

        static {
            OSETSDKProtected.interface11(4747);
        }

        public b(d dVar) {
            this.f39849a = dVar;
        }

        @Override // com.kc.openset.sdk.adv.OSETVideoPlayerListener
        public native void onMute(boolean z);

        @Override // com.kc.openset.sdk.adv.OSETVideoPlayerListener
        public native void onVideoPlayComplete();

        @Override // com.kc.openset.sdk.adv.OSETVideoPlayerListener
        public native void onVideoPlayError(String str, String str2);

        @Override // com.kc.openset.sdk.adv.OSETVideoPlayerListener
        public native void onVideoPlayPause();

        @Override // com.kc.openset.sdk.adv.OSETVideoPlayerListener
        public native void onVideoPlayProgress(PlayState playState, int i, int i2);

        @Override // com.kc.openset.sdk.adv.OSETVideoPlayerListener
        public native void onVideoPlayResume();

        @Override // com.kc.openset.sdk.adv.OSETVideoPlayerListener
        public native void onVideoPlayStart(int i);
    }

    @Keep
    public class c implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ViewGroup f39850a;
        final d b;

        static {
            OSETSDKProtected.interface11(4748);
        }

        public c(d dVar, ViewGroup viewGroup) {
            this.b = dVar;
            this.f39850a = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public native boolean onPreDraw();
    }

    /* JADX INFO: renamed from: com.kc.openset.sdk.adv.hub.d$d, reason: collision with other inner class name */
    @Keep
    public class C1117d extends OnAdTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f39851a;

        static {
            OSETSDKProtected.interface11(4749);
        }

        public C1117d(d dVar) {
            this.f39851a = dVar;
        }

        @Override // com.kc.openset.sdk.apiad.tools.OnAdTouchListener
        public native void touchAd(View view, i iVar, i iVar2);
    }

    @Keep
    public class e extends OnAdTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f39852a;

        static {
            OSETSDKProtected.interface11(4750);
        }

        public e(d dVar) {
            this.f39852a = dVar;
        }

        @Override // com.kc.openset.sdk.apiad.tools.OnAdTouchListener
        public native void touchAd(View view, i iVar, i iVar2);
    }

    @Keep
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final View f39853a;
        final d b;

        static {
            OSETSDKProtected.interface11(4751);
        }

        public f(d dVar, View view) {
            this.b = dVar;
            this.f39853a = view;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Keep
    public class g implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f39854a;

        static {
            OSETSDKProtected.interface11(4752);
        }

        public g(d dVar) {
            this.f39854a = dVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public native boolean onPreDraw();
    }

    /* JADX INFO: renamed from: $r8$lambda$ovsnDxzqJqQuGd-Z0G_gxRSY-eY, reason: not valid java name */
    public static native /* synthetic */ void m1038$r8$lambda$ovsnDxzqJqQuGdZ0G_gxRSYeY(d dVar, ViewGroup viewGroup, View view);

    static {
        OSETSDKProtected.interface11(4753);
    }

    public d(Context context, String str, String str2) {
        super(context, str, str2, AdType.AD_TYPE_NATIVE);
        this.f39847a = false;
        this.b = false;
        this.c = false;
        this.g = false;
        this.j = new boolean[]{false, false, false, false, false};
        this.o = new g(this);
    }

    public static native /* synthetic */ View a(d dVar, View view);

    public static native /* synthetic */ ViewGroup a(d dVar);

    public static native /* synthetic */ ViewGroup a(d dVar, ViewGroup viewGroup);

    private native void a();

    private native void a(View view);

    private native void a(View view, boolean z);

    private native void a(ViewGroup viewGroup);

    private native /* synthetic */ void a(ViewGroup viewGroup, View view);

    public static native /* synthetic */ void a(d dVar, PlayState playState, int i, int i2);

    public static native /* synthetic */ void a(d dVar, boolean z, boolean z2, OSETClicksData oSETClicksData);

    private native void a(PlayState playState, int i, int i2);

    private native void a(boolean z);

    private native void a(boolean z, boolean z2, OSETClicksData oSETClicksData);

    public static native /* synthetic */ boolean a(d dVar, boolean z);

    public static native /* synthetic */ View b(d dVar);

    private native void b(View view);

    public static native /* synthetic */ void b(d dVar, View view);

    public static native /* synthetic */ void b(d dVar, ViewGroup viewGroup);

    public static native /* synthetic */ void b(d dVar, boolean z);

    public static native /* synthetic */ void c(d dVar, View view);

    public static native /* synthetic */ boolean c(d dVar);

    public static native /* synthetic */ void d(d dVar);

    private native boolean d();

    public static native /* synthetic */ OSETQDNativeViewAdImp e(d dVar);

    private native void e();

    public static native /* synthetic */ OSETVideoPlayerManager f(d dVar);

    public static native /* synthetic */ boolean g(d dVar);

    public native View a(Context context);

    public native void a(ViewGroup viewGroup, View view, View view2);

    public native void a(ADVNativeViewListener aDVNativeViewListener);

    public native View b(Context context);

    public native ADVNativeViewListener b();

    public native OSETQDNativeViewAd c();

    @Override // com.kc.openset.sdk.adv.hub.ADVAdObject
    public native void destroy();

    @Override // com.kc.openset.sdk.adv.hub.ADVAdObject
    public native ADVBaseListener initADVListener(ADVBaseListener aDVBaseListener);

    @Override // com.kc.openset.sdk.adv.hub.ADVAdObject
    public native void onPaused();

    @Override // com.kc.openset.sdk.adv.hub.ADVAdObject
    public native void onResumed();

    @Override // com.kc.openset.util.ShakeItUtils.OnShakeListener
    public native void onShake(int i, int i2, int i3);

    @Override // com.kc.openset.util.TiltSensorUtils.OnTiltListener
    public native void onTilt(int i, int i2, int i3, long j, boolean z);
}
