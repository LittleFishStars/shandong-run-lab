package com.kc.openset.sdk.apiad.ad_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.view.TextureView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.sdk.adv.hub.ADVAdObject;
import com.kc.openset.sdk.adv.listener.ADVBaseListener;
import com.kc.openset.sdk.adv.listener.ADVSPlashListener;
import com.kc.openset.sdk.apiad.tools.ApiVideoPlayer;
import com.kc.openset.sdk.apiad.tools.OSETClicksData;
import com.kc.openset.sdk.apiad.tools.OnAdTouchListener;
import com.kc.openset.sdk.apiad.tools.PlayState;
import com.kc.openset.util.ApkDownloader;
import com.kc.openset.util.LoadBitmapListener;
import com.kc.openset.util.OSETCountDownTimer;
import com.kc.openset.util.ShakeItUtils;
import com.kc.openset.util.TiltSensorUtils;
import com.kc.openset.view.OSETShakeView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class c extends OSETAPIBaseAd implements ShakeItUtils.OnShakeListener, TiltSensorUtils.OnTiltListener {
    private long A;
    private int B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private View H;
    private boolean I;
    private ApkDownloader J;
    private boolean K;
    private OSETCountDownTimer L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f39902a;
    private OSETShakeView b;
    private CountdownView c;
    private ImageView d;
    private ImageView e;
    private TextureView f;
    private ImageView g;
    private ShakeItUtils h;
    private TiltSensorUtils i;
    private boolean j;
    private boolean k;
    private boolean l;
    private Bitmap m;
    private ApiVideoPlayer n;
    private boolean o;
    private boolean p;
    private boolean q;
    private OSETCountDownTimer r;
    private long s;
    private int t;
    private int u;
    private PlayState v;
    private long w;
    private long x;
    private long y;
    private long z;

    @Keep
    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f39903a;

        static {
            OSETSDKProtected.interface11(4853);
        }

        public a(c cVar) {
            this.f39903a = cVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public native void onViewAttachedToWindow(View view);

        @Override // android.view.View.OnAttachStateChangeListener
        public native void onViewDetachedFromWindow(View view);
    }

    @Keep
    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f39904a;

        static {
            OSETSDKProtected.interface11(4854);
        }

        public b(c cVar) {
            this.f39904a = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public native boolean onPreDraw();
    }

    /* JADX INFO: renamed from: com.kc.openset.sdk.apiad.ad_view.c$c, reason: collision with other inner class name */
    @Keep
    public class RunnableC1121c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f39905a;

        static {
            OSETSDKProtected.interface11(4855);
        }

        public RunnableC1121c(c cVar) {
            this.f39905a = cVar;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Keep
    public class d implements LoadBitmapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f39906a;

        static {
            OSETSDKProtected.interface11(4856);
        }

        public d(c cVar) {
            this.f39906a = cVar;
        }

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onFail();

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onSuccess(Bitmap bitmap);
    }

    @Keep
    public class e implements ApiVideoPlayer.ADVPlayerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f39907a;

        static {
            OSETSDKProtected.interface11(4857);
        }

        public e(c cVar) {
            this.f39907a = cVar;
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
    public class f implements LoadBitmapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f39908a;
        final ImageView b;
        final c c;

        public static native /* synthetic */ void $r8$lambda$6UxAfVGes9yQvHOjUvsExT5v_tI(ImageView imageView, Bitmap bitmap);

        public static native /* synthetic */ void $r8$lambda$k9csZChPG1T9KWWfYhViPtd3LrI(Context context, Bitmap bitmap, ImageView imageView);

        static {
            OSETSDKProtected.interface11(4860);
        }

        public f(c cVar, Context context, ImageView imageView) {
            this.c = cVar;
            this.f39908a = context;
            this.b = imageView;
        }

        private static native /* synthetic */ void a(Context context, Bitmap bitmap, ImageView imageView);

        private static native /* synthetic */ void a(ImageView imageView, Bitmap bitmap);

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onFail();

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onSuccess(Bitmap bitmap);
    }

    @Keep
    public class g extends OSETCountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f39909a;

        static {
            OSETSDKProtected.interface11(4861);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(c cVar, long j, long j2) {
            super(j, j2);
            this.f39909a = cVar;
        }

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onFinish();

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onTick(long j);
    }

    @Keep
    public class h extends OnAdTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f39910a;

        static {
            OSETSDKProtected.interface11(4862);
        }

        public h(c cVar) {
            this.f39910a = cVar;
        }

        @Override // com.kc.openset.sdk.apiad.tools.OnAdTouchListener
        public native void touchAd(View view, com.kc.openset.sdk.apiad.tools.i iVar, com.kc.openset.sdk.apiad.tools.i iVar2);
    }

    @Keep
    public class i extends OSETCountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f39911a;

        static {
            OSETSDKProtected.interface11(4863);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(c cVar, long j, long j2) {
            super(j, j2);
            this.f39911a = cVar;
        }

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onFinish();

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onTick(long j);
    }

    /* JADX INFO: renamed from: $r8$lambda$3orgZshUNbCXHDvbR-77OCp9J1Y, reason: not valid java name */
    public static native /* synthetic */ void m1047$r8$lambda$3orgZshUNbCXHDvbR77OCp9J1Y(c cVar, View view);

    public static native /* synthetic */ void $r8$lambda$PWtClJ280ldnaAefL3LTvY1YfRk(c cVar, Bitmap bitmap);

    public static native /* synthetic */ void $r8$lambda$TO3cE_7v44EsN8ZzocsOcNOWz4U(c cVar);

    public static native /* synthetic */ void $r8$lambda$jL7_czMPjBQq6gPzGEv_T5lEbJU(c cVar);

    public static native /* synthetic */ void $r8$lambda$umoEwljzOx0sJpVjUGZozLH64y8(c cVar);

    static {
        OSETSDKProtected.interface11(4864);
    }

    public c(ADVAdObject aDVAdObject) {
        super(aDVAdObject);
        this.j = false;
        this.k = false;
        this.l = false;
        this.o = true;
        this.p = false;
        this.q = true;
        this.t = 0;
        this.u = 0;
        this.v = PlayState.INITIALIZE;
        this.B = 1;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.I = false;
        this.L = null;
    }

    public static native /* synthetic */ int a(c cVar, int i2);

    public static native /* synthetic */ long a(c cVar, long j);

    public static native /* synthetic */ PlayState a(c cVar, PlayState playState);

    private native void a();

    private native void a(int i2);

    private native void a(Context context, ImageView imageView, String str);

    private native /* synthetic */ void a(Bitmap bitmap);

    private native /* synthetic */ void a(View view);

    private native void a(View view, boolean z);

    public static native /* synthetic */ void a(c cVar);

    public static native /* synthetic */ void a(c cVar, Bitmap bitmap);

    public static native /* synthetic */ void a(c cVar, OSETClicksData oSETClicksData);

    private native void a(OSETClicksData oSETClicksData);

    private native void a(String str);

    private native void a(String str, String str2);

    private native void a(View... viewArr);

    public static native /* synthetic */ boolean a(c cVar, boolean z);

    public static native /* synthetic */ int b(c cVar, int i2);

    public static native /* synthetic */ View b(c cVar);

    private native void b();

    private native void b(Bitmap bitmap);

    public static native /* synthetic */ boolean b(c cVar, boolean z);

    public static native /* synthetic */ int c(c cVar, int i2);

    private native void c();

    public static native /* synthetic */ boolean c(c cVar);

    public static native /* synthetic */ void d(c cVar);

    public static native /* synthetic */ void d(c cVar, int i2);

    public static native /* synthetic */ int e(c cVar);

    private native boolean e();

    private native /* synthetic */ void f();

    public static native /* synthetic */ void f(c cVar);

    public static native /* synthetic */ ApkDownloader g(c cVar);

    private native void g();

    private native boolean h();

    public static native /* synthetic */ boolean h(c cVar);

    private native void i();

    public static native /* synthetic */ void i(c cVar);

    public static native /* synthetic */ ApiVideoPlayer j(c cVar);

    private native void j();

    public static native /* synthetic */ long k(c cVar);

    private native void k();

    public static native /* synthetic */ int l(c cVar);

    private native void l();

    public static native /* synthetic */ ImageView m(c cVar);

    private native void m();

    private native void n();

    public native void a(long j);

    public native void a(boolean z);

    public native ADVSPlashListener d();

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
    public native void onShake(int i2, int i3, int i4);

    @Override // com.kc.openset.util.TiltSensorUtils.OnTiltListener
    public native void onTilt(int i2, int i3, int i4, long j, boolean z);
}
