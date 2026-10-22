package com.kc.openset.sdk.apiad.ad_view;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.view.TextureView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.sdk.adv.hub.ADVAdObject;
import com.kc.openset.sdk.adv.listener.ADVBannerListener;
import com.kc.openset.sdk.adv.listener.ADVBaseListener;
import com.kc.openset.sdk.apiad.tools.ApiVideoPlayer;
import com.kc.openset.sdk.apiad.tools.OSETClicksData;
import com.kc.openset.sdk.apiad.tools.OnAdTouchListener;
import com.kc.openset.sdk.apiad.tools.PlayState;
import com.kc.openset.sdk.apiad.tools.i;
import com.kc.openset.util.ApkDownloader;
import com.kc.openset.util.LoadBitmapListener;
import com.kc.openset.util.OSETCountDownTimer;
import com.kc.openset.util.ShakeItUtils;
import com.kc.openset.util.TiltSensorUtils;
import com.kc.openset.view.OSETNativeContainerView;
import com.kc.openset.view.OSETShakeView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class a extends OSETAPIBaseAd implements ShakeItUtils.OnShakeListener, TiltSensorUtils.OnTiltListener {
    private long A;
    private long B;
    private long C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private ApkDownloader J;
    private boolean K;
    private OSETCountDownTimer L;
    private boolean M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f39885a;
    private ImageView b;
    private TextureView c;
    private ImageView d;
    private OSETShakeView e;
    private OSETNativeContainerView f;
    private TextView g;
    private View h;
    private boolean i;
    private boolean j;
    private boolean k;
    private ShakeItUtils l;
    private TiltSensorUtils m;
    private ApiVideoPlayer n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private OSETCountDownTimer t;
    private long u;
    private int v;
    private int w;
    private PlayState x;
    private long y;
    private long z;

    /* JADX INFO: renamed from: com.kc.openset.sdk.apiad.ad_view.a$a, reason: collision with other inner class name */
    @Keep
    public class ViewTreeObserverOnPreDrawListenerC1119a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39886a;

        static {
            OSETSDKProtected.interface11(4823);
        }

        public ViewTreeObserverOnPreDrawListenerC1119a(a aVar) {
            this.f39886a = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public native boolean onPreDraw();
    }

    @Keep
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39887a;

        static {
            OSETSDKProtected.interface11(4824);
        }

        public b(a aVar) {
            this.f39887a = aVar;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Keep
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39888a;

        static {
            OSETSDKProtected.interface11(4825);
        }

        public c(a aVar) {
            this.f39888a = aVar;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Keep
    public class d implements LoadBitmapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39889a;

        static {
            OSETSDKProtected.interface11(4826);
        }

        public d(a aVar) {
            this.f39889a = aVar;
        }

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onFail();

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onSuccess(Bitmap bitmap);
    }

    @Keep
    public class e implements ApiVideoPlayer.ADVPlayerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39890a;

        static {
            OSETSDKProtected.interface11(4827);
        }

        public e(a aVar) {
            this.f39890a = aVar;
        }

        @Override // com.kc.openset.sdk.apiad.tools.ApiVideoPlayer.ADVPlayerListener
        public native void onVideoComplete();

        @Override // com.kc.openset.sdk.apiad.tools.ApiVideoPlayer.ADVPlayerListener
        public native void onVideoError(String str);

        @Override // com.kc.openset.sdk.apiad.tools.ApiVideoPlayer.ADVPlayerListener
        public native void onVideoPause();

        @Override // com.kc.openset.sdk.apiad.tools.ApiVideoPlayer.ADVPlayerListener
        public native void onVideoResume(long j);

        @Override // com.kc.openset.sdk.apiad.tools.ApiVideoPlayer.ADVPlayerListener
        public native void onVideoStart(MediaPlayer mediaPlayer, long j);
    }

    @Keep
    public class f extends OSETCountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39891a;

        static {
            OSETSDKProtected.interface11(4828);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, long j, long j2) {
            super(j, j2);
            this.f39891a = aVar;
        }

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onFinish();

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onTick(long j);
    }

    @Keep
    public class g extends OnAdTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39892a;

        static {
            OSETSDKProtected.interface11(4829);
        }

        public g(a aVar) {
            this.f39892a = aVar;
        }

        @Override // com.kc.openset.sdk.apiad.tools.OnAdTouchListener
        public native void touchAd(View view, i iVar, i iVar2);
    }

    @Keep
    public class h extends OSETCountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39893a;

        static {
            OSETSDKProtected.interface11(4830);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(a aVar, long j, long j2) {
            super(j, j2);
            this.f39893a = aVar;
        }

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onFinish();

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onTick(long j);
    }

    /* JADX INFO: renamed from: $r8$lambda$IYcadYG0ieR-gl1jJtLtp-rwVpY, reason: not valid java name */
    public static native /* synthetic */ void m1044$r8$lambda$IYcadYG0ieRgl1jJtLtprwVpY(a aVar, View view);

    public static native /* synthetic */ void $r8$lambda$TUMEba0da9yLdhHPy4pdCgrkTe4(a aVar, View view);

    public static native /* synthetic */ void $r8$lambda$WtfBH0Gbc3iby8OBtKnBW9_O6Mo(a aVar, boolean z);

    static {
        OSETSDKProtected.interface11(4831);
    }

    public a(ADVAdObject aDVAdObject) {
        super(aDVAdObject);
        this.i = false;
        this.j = false;
        this.k = false;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = false;
        this.s = false;
        this.v = 0;
        this.w = 0;
        this.x = PlayState.INITIALIZE;
        this.D = 1;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.L = null;
        this.M = false;
    }

    public static native /* synthetic */ int a(a aVar, int i);

    public static native /* synthetic */ long a(a aVar, long j);

    public static native /* synthetic */ View a(a aVar);

    public static native /* synthetic */ PlayState a(a aVar, PlayState playState);

    private native void a();

    private native void a(int i);

    private native /* synthetic */ void a(View view);

    private native void a(View view, boolean z);

    public static native /* synthetic */ void a(a aVar, boolean z, OSETClicksData oSETClicksData);

    private native void a(String str);

    private native /* synthetic */ void a(boolean z);

    private native void a(boolean z, OSETClicksData oSETClicksData);

    private native void a(View... viewArr);

    public static native /* synthetic */ boolean a(a aVar, boolean z);

    public static native /* synthetic */ int b(a aVar, int i);

    private native void b();

    private native /* synthetic */ void b(View view);

    public static native /* synthetic */ boolean b(a aVar);

    public static native /* synthetic */ boolean b(a aVar, boolean z);

    public static native /* synthetic */ int c(a aVar, int i);

    private native void c(boolean z);

    public static native /* synthetic */ boolean c(a aVar);

    public static native /* synthetic */ PlayState d(a aVar);

    public static native /* synthetic */ void d(a aVar, int i);

    private native boolean d();

    public static native /* synthetic */ void e(a aVar);

    private native boolean e();

    public static native /* synthetic */ int f(a aVar);

    private native void f();

    public static native /* synthetic */ void g(a aVar);

    private native boolean g();

    public static native /* synthetic */ ApkDownloader h(a aVar);

    private native void h();

    public static native /* synthetic */ OSETShakeView i(a aVar);

    private native void i();

    private native void j();

    public static native /* synthetic */ void j(a aVar);

    public static native /* synthetic */ ApiVideoPlayer k(a aVar);

    private native void k();

    public static native /* synthetic */ long l(a aVar);

    private native void l();

    public static native /* synthetic */ int m(a aVar);

    public static native /* synthetic */ ImageView n(a aVar);

    public native void a(long j);

    public native void b(boolean z);

    public native ADVBannerListener c();

    @Override // com.kc.openset.sdk.apiad.ad_view.OSETAPIBaseAd
    public native void destroy();

    @Override // com.kc.openset.sdk.apiad.ad_view.OSETAPIBaseAd
    public native /* bridge */ /* synthetic */ ADVBaseListener getAdListener();

    @Override // com.kc.openset.sdk.apiad.ad_view.OSETAPIBaseAd
    public native View initAdView();

    @Override // com.kc.openset.sdk.apiad.ad_view.OSETAPIBaseAd
    public native void onActivityPaused();

    @Override // com.kc.openset.sdk.apiad.ad_view.OSETAPIBaseAd
    public native void onActivityResumed();

    @Override // com.kc.openset.sdk.apiad.ad_view.OSETAPIBaseAd
    public native void onAdShow();

    @Override // com.kc.openset.util.ShakeItUtils.OnShakeListener
    public native void onShake(int i, int i2, int i3);

    @Override // com.kc.openset.util.TiltSensorUtils.OnTiltListener
    public native void onTilt(int i, int i2, int i3, long j, boolean z);
}
