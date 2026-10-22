package com.kc.openset.sdk.apiad.ad_view;

import android.content.Context;
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
import com.kc.openset.sdk.adv.listener.ADVBaseListener;
import com.kc.openset.sdk.adv.listener.ADVNativeListener;
import com.kc.openset.sdk.apiad.tools.ApiVideoPlayer;
import com.kc.openset.sdk.apiad.tools.OSETClicksData;
import com.kc.openset.sdk.apiad.tools.OnAdTouchListener;
import com.kc.openset.sdk.apiad.tools.PlayState;
import com.kc.openset.sdk.apiad.tools.i;
import com.kc.openset.util.LoadBitmapListener;
import com.kc.openset.util.OSETCountDownTimer;
import com.kc.openset.util.ShakeItUtils;
import com.kc.openset.util.TiltSensorUtils;
import com.kc.openset.view.OSETNativeContainerView;
import com.kc.openset.view.OSETShakeView;
import com.kc.openset.view.rounded.ODRoundedImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class b extends OSETAPIBaseAd implements ShakeItUtils.OnShakeListener, TiltSensorUtils.OnTiltListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f39894a = 1;
    private int A;
    private int B;
    private PlayState C;
    private long D;
    private long E;
    private long F;
    private long G;
    private long H;
    private int I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private final String b;
    private View c;
    private LinearLayout d;
    private OSETNativeContainerView e;
    private ImageView f;
    private ODRoundedImageView g;
    private TextureView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private TextView l;
    private OSETShakeView m;
    private Bitmap n;
    private int o;
    private ShakeItUtils p;
    private TiltSensorUtils q;
    private boolean r;
    private boolean s;
    private ApiVideoPlayer t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private OSETCountDownTimer y;
    private long z;

    @Keep
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f39895a;

        static {
            OSETSDKProtected.interface11(4838);
        }

        public a(b bVar) {
            this.f39895a = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public native boolean onPreDraw();
    }

    /* JADX INFO: renamed from: com.kc.openset.sdk.apiad.ad_view.b$b, reason: collision with other inner class name */
    @Keep
    public class RunnableC1120b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f39896a;

        static {
            OSETSDKProtected.interface11(4839);
        }

        public RunnableC1120b(b bVar) {
            this.f39896a = bVar;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Keep
    public class c implements LoadBitmapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f39897a;

        static {
            OSETSDKProtected.interface11(4840);
        }

        public c(b bVar) {
            this.f39897a = bVar;
        }

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onFail();

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onSuccess(Bitmap bitmap);
    }

    @Keep
    public class d implements ApiVideoPlayer.ADVPlayerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f39898a;

        static {
            OSETSDKProtected.interface11(4841);
        }

        public d(b bVar) {
            this.f39898a = bVar;
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
    public class e implements LoadBitmapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f39899a;
        final ImageView b;
        final b c;

        public static native /* synthetic */ void $r8$lambda$MVGO_gTExMxu67ZqMPNq1NCCKEM(Context context, Bitmap bitmap, ImageView imageView);

        public static native /* synthetic */ void $r8$lambda$ibxKFaLYE8oVDQVB0ABuVIVWDEU(ImageView imageView, Bitmap bitmap);

        static {
            OSETSDKProtected.interface11(4844);
        }

        public e(b bVar, Context context, ImageView imageView) {
            this.c = bVar;
            this.f39899a = context;
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
    public class f extends OSETCountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f39900a;

        static {
            OSETSDKProtected.interface11(4845);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b bVar, long j, long j2) {
            super(j, j2);
            this.f39900a = bVar;
        }

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onFinish();

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onTick(long j);
    }

    @Keep
    public class g extends OnAdTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f39901a;

        static {
            OSETSDKProtected.interface11(4846);
        }

        public g(b bVar) {
            this.f39901a = bVar;
        }

        @Override // com.kc.openset.sdk.apiad.tools.OnAdTouchListener
        public native void touchAd(View view, i iVar, i iVar2);
    }

    /* JADX INFO: renamed from: $r8$lambda$KK09TbXXLfNC8wRf5-TX3SUlOqw, reason: not valid java name */
    public static native /* synthetic */ void m1045$r8$lambda$KK09TbXXLfNC8wRf5TX3SUlOqw(b bVar, View view);

    public static native /* synthetic */ void $r8$lambda$OmKyksELXuMtISs25Yla5rqhfyo(b bVar, ImageView imageView);

    public static native /* synthetic */ void $r8$lambda$TN4ytXxnlceuUeqFqdVWgmp1w3Q(b bVar, boolean z);

    public static native /* synthetic */ void $r8$lambda$ZCvBpEqNJRswzu1iO_Gxa9COF4M(b bVar, Bitmap bitmap, ImageView imageView);

    public static native /* synthetic */ void $r8$lambda$_BzJROlqg54KdGt79WLGu45EsEU(b bVar, View view);

    /* JADX INFO: renamed from: $r8$lambda$po8q1czoiESW-e_eTPVjmrniL7w, reason: not valid java name */
    public static native /* synthetic */ void m1046$r8$lambda$po8q1czoiESWe_eTPVjmrniL7w(b bVar, View view);

    static {
        OSETSDKProtected.interface11(4847);
    }

    public b(ADVAdObject aDVAdObject) {
        super(aDVAdObject);
        StringBuilder sb = new StringBuilder();
        sb.append(OSETSDKProtected.getString2(2889));
        int i = f39894a;
        f39894a = i + 1;
        sb.append(i);
        this.b = sb.toString();
        this.r = false;
        this.s = false;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = false;
        this.A = 0;
        this.B = 0;
        this.C = PlayState.INITIALIZE;
        this.I = 1;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.R = false;
    }

    public static native /* synthetic */ int a(b bVar, int i);

    public static native /* synthetic */ long a(b bVar, long j);

    public static native /* synthetic */ View a(b bVar);

    public static native /* synthetic */ PlayState a(b bVar, PlayState playState);

    private native void a(int i);

    private native void a(Context context, ImageView imageView, String str);

    private native /* synthetic */ void a(Bitmap bitmap, ImageView imageView);

    private native /* synthetic */ void a(View view);

    private native void a(View view, boolean z);

    private native /* synthetic */ void a(ImageView imageView);

    public static native /* synthetic */ void a(b bVar, ODRoundedImageView oDRoundedImageView, ImageView imageView, Bitmap bitmap);

    public static native /* synthetic */ void a(b bVar, String str);

    public static native /* synthetic */ void a(b bVar, boolean z, OSETClicksData oSETClicksData);

    private native void a(ODRoundedImageView oDRoundedImageView, ImageView imageView, Bitmap bitmap);

    private native void a(String str);

    private native void a(String str, String str2);

    private native /* synthetic */ void a(boolean z);

    private native void a(boolean z, OSETClicksData oSETClicksData);

    private native void a(View... viewArr);

    private native boolean a();

    public static native /* synthetic */ boolean a(b bVar, boolean z);

    public static native /* synthetic */ String b(b bVar);

    private native void b();

    private native /* synthetic */ void b(View view);

    public static native /* synthetic */ void b(b bVar, int i);

    public static native /* synthetic */ boolean b(b bVar, boolean z);

    public static native /* synthetic */ int c(b bVar, int i);

    public static native /* synthetic */ long c(b bVar);

    private native /* synthetic */ void c(View view);

    private native void c(boolean z);

    public static native /* synthetic */ int d(b bVar);

    public static native /* synthetic */ int d(b bVar, int i);

    private native void d();

    public static native /* synthetic */ ImageView e(b bVar);

    private native void e();

    private native void f();

    public static native /* synthetic */ boolean f(b bVar);

    public static native /* synthetic */ PlayState g(b bVar);

    private native boolean g();

    private native void h();

    public static native /* synthetic */ void h(b bVar);

    public static native /* synthetic */ ImageView i(b bVar);

    private native void i();

    private native void j();

    public static native /* synthetic */ boolean j(b bVar);

    private native int k();

    public static native /* synthetic */ int k(b bVar);

    private native void l();

    public static native /* synthetic */ void l(b bVar);

    private native void m();

    public static native /* synthetic */ void m(b bVar);

    public static native /* synthetic */ ODRoundedImageView n(b bVar);

    public static native /* synthetic */ ImageView o(b bVar);

    public static native /* synthetic */ ApiVideoPlayer p(b bVar);

    public native void a(long j);

    public native void b(boolean z);

    public native ADVNativeListener c();

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
