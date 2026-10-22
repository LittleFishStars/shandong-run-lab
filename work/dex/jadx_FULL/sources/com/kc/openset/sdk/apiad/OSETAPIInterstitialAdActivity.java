package com.kc.openset.sdk.apiad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.sdk.adv.listener.ADVInterstitialListener;
import com.kc.openset.sdk.apiad.tools.ApiVideoPlayer;
import com.kc.openset.sdk.apiad.tools.OSETClicksData;
import com.kc.openset.sdk.apiad.tools.OnAdTouchListener;
import com.kc.openset.sdk.apiad.tools.PlayState;
import com.kc.openset.sdk.apiad.tools.i;
import com.kc.openset.util.ApkDownloader;
import com.kc.openset.util.LoadBitmapListener;
import com.kc.openset.util.OSETCountDownTimer;
import com.kc.openset.view.OSETShakeView;
import com.kc.openset.view.rounded.ODRoundedImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETAPIInterstitialAdActivity extends OSETAPIBaseActivity {
    private long A;
    private long E;
    private long F;
    private long G;
    private long H;
    private long I;
    private ApkDownloader P;
    private boolean Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FrameLayout f39859a;
    private ODRoundedImageView b;
    private ODRoundedImageView c;
    private TextureView d;
    private ImageView e;
    private ImageView f;
    private LinearLayout g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private ImageView k;
    private TextView l;
    private TextView m;
    private LinearLayout n;
    private TextView o;
    public OSETShakeView p;
    public TextView q;
    public TextView r;
    public LinearLayout s;
    private ApiVideoPlayer t;
    protected ADVInterstitialListener w;
    private OSETCountDownTimer x;
    private int y;
    private OSETCountDownTimer z;
    private boolean u = false;
    private boolean v = false;
    private int B = 0;
    private int C = 0;
    private PlayState D = PlayState.INITIALIZE;
    private int J = 1;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private OSETCountDownTimer R = null;

    @Keep
    public class a extends OnAdTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIInterstitialAdActivity f39860a;

        static {
            OSETSDKProtected.interface11(4778);
        }

        public a(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity) {
            this.f39860a = oSETAPIInterstitialAdActivity;
        }

        @Override // com.kc.openset.sdk.apiad.tools.OnAdTouchListener
        public native void touchAd(View view, i iVar, i iVar2);
    }

    @Keep
    public class b extends OSETCountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIInterstitialAdActivity f39861a;

        static {
            OSETSDKProtected.interface11(4779);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, long j, long j2) {
            super(j, j2);
            this.f39861a = oSETAPIInterstitialAdActivity;
        }

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onFinish();

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onTick(long j);
    }

    @Keep
    public class c implements LoadBitmapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIInterstitialAdActivity f39862a;

        static {
            OSETSDKProtected.interface11(4780);
        }

        public c(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity) {
            this.f39862a = oSETAPIInterstitialAdActivity;
        }

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onFail();

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onSuccess(Bitmap bitmap);
    }

    @Keep
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIInterstitialAdActivity f39863a;

        static {
            OSETSDKProtected.interface11(4781);
        }

        public d(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity) {
            this.f39863a = oSETAPIInterstitialAdActivity;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Keep
    public class e implements ApiVideoPlayer.ADVPlayerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIInterstitialAdActivity f39864a;

        static {
            OSETSDKProtected.interface11(4782);
        }

        public e(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity) {
            this.f39864a = oSETAPIInterstitialAdActivity;
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
        final Context f39865a;
        final ImageView b;
        final OSETAPIInterstitialAdActivity c;

        public static native /* synthetic */ void $r8$lambda$FpML5UerH1wGNLCZLoobcg9kBtE(f fVar, ImageView imageView, Bitmap bitmap);

        /* JADX INFO: renamed from: $r8$lambda$JVY8y3-6JWgMScDPyt_w53gktxo, reason: not valid java name */
        public static native /* synthetic */ void m1040$r8$lambda$JVY8y36JWgMScDPyt_w53gktxo(f fVar, Context context, Bitmap bitmap, ImageView imageView);

        static {
            OSETSDKProtected.interface11(4785);
        }

        public f(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, Context context, ImageView imageView) {
            this.c = oSETAPIInterstitialAdActivity;
            this.f39865a = context;
            this.b = imageView;
        }

        private native /* synthetic */ void a(Context context, Bitmap bitmap, ImageView imageView);

        private native /* synthetic */ void a(ImageView imageView, Bitmap bitmap);

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onFail();

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onSuccess(Bitmap bitmap);
    }

    @Keep
    public class g extends OSETCountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIInterstitialAdActivity f39866a;

        static {
            OSETSDKProtected.interface11(4786);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, long j, long j2) {
            super(j, j2);
            this.f39866a = oSETAPIInterstitialAdActivity;
        }

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onFinish();

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onTick(long j);
    }

    @Keep
    public class h extends OSETCountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIInterstitialAdActivity f39867a;

        static {
            OSETSDKProtected.interface11(4787);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, long j, long j2) {
            super(j, j2);
            this.f39867a = oSETAPIInterstitialAdActivity;
        }

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onFinish();

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onTick(long j);
    }

    public static native /* synthetic */ void $r8$lambda$46ZmNtLkJneKYBAdokyjhNg5yq8(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, View view);

    public static native /* synthetic */ void $r8$lambda$6UkJh7v4rFiunykT9k_bMjcucvY(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, Bitmap bitmap);

    /* JADX INFO: renamed from: $r8$lambda$f-AWBwNOl592gR32-jllEHeMp0k, reason: not valid java name */
    public static native /* synthetic */ void m1039$r8$lambda$fAWBwNOl592gR32jllEHeMp0k(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, Bitmap bitmap);

    public static native /* synthetic */ void $r8$lambda$jRrj3BrPk8LCk0hl3l25R1wW7I8(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, View view);

    static {
        OSETSDKProtected.interface11(4788);
    }

    public static native /* synthetic */ int a(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity);

    public static native /* synthetic */ int a(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, int i);

    public static native /* synthetic */ long a(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, long j);

    public static native /* synthetic */ PlayState a(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, PlayState playState);

    private native void a();

    private native void a(double d2);

    private native void a(int i);

    public static native void a(Activity activity, com.kc.openset.sdk.apiad.tools.c cVar);

    private native void a(Context context, ImageView imageView, String str);

    private native /* synthetic */ void a(Bitmap bitmap);

    private native /* synthetic */ void a(View view);

    private native void a(View view, boolean z);

    private native void a(FrameLayout frameLayout, int i, int i2, int i3);

    public static native /* synthetic */ void a(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, Bitmap bitmap);

    private native void a(String str, String str2);

    private native void a(View... viewArr);

    public static native /* synthetic */ int b(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, int i);

    private native void b();

    private native /* synthetic */ void b(Bitmap bitmap);

    private native /* synthetic */ void b(View view);

    public static native /* synthetic */ void b(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity);

    public static native /* synthetic */ int c(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity);

    public static native /* synthetic */ int c(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, int i);

    private native void c();

    private native void c(Bitmap bitmap);

    private native void d();

    public static native /* synthetic */ void d(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity);

    public static native /* synthetic */ void d(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, int i);

    public static native /* synthetic */ int e(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, int i);

    public static native /* synthetic */ ApkDownloader e(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity);

    private native void e();

    private native void f();

    public static native /* synthetic */ void f(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity);

    public static native /* synthetic */ long g(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity);

    private native void g();

    public static native /* synthetic */ int h(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity);

    private native void h();

    public static native /* synthetic */ ImageView i(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity);

    private native void i();

    private native void initAdData();

    private native void j();

    public static native /* synthetic */ boolean j(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity);

    public static native /* synthetic */ PlayState k(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity);

    private native void k();

    public native void a(long j);

    @Override // com.kc.openset.sdk.apiad.OSETAPIBaseActivity
    public native boolean displayFullScreen();

    @Override // com.kc.openset.sdk.apiad.OSETAPIBaseActivity
    public native void onAdClick(boolean z, OSETClicksData oSETClicksData);

    @Override // com.kc.openset.sdk.apiad.OSETAPIBaseActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // com.kc.openset.sdk.apiad.OSETAPIBaseActivity, android.app.Activity
    public native void onDestroy();

    @Override // com.kc.openset.sdk.apiad.OSETAPIBaseActivity, android.app.Activity
    public native void onPause();

    @Override // com.kc.openset.sdk.apiad.OSETAPIBaseActivity, android.app.Activity
    public native void onResume();
}
