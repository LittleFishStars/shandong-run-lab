package com.kc.openset.sdk.apiad;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.sdk.adv.listener.ADVRewardListener;
import com.kc.openset.sdk.apiad.tools.APIRewardAdEvent;
import com.kc.openset.sdk.apiad.tools.ApiVideoPlayer;
import com.kc.openset.sdk.apiad.tools.OSETClicksData;
import com.kc.openset.sdk.apiad.tools.OnAdTouchListener;
import com.kc.openset.sdk.apiad.tools.PlayState;
import com.kc.openset.sdk.mat.AwardsTipDialog;
import com.kc.openset.util.ApkDownloader;
import com.kc.openset.util.LoadBitmapListener;
import com.kc.openset.util.OSETCountDownTimer;
import com.kc.openset.view.OSETShakeView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETAPIRewardADActivity extends OSETAPIBaseActivity {
    public FrameLayout G;
    public ImageView H;
    public ImageView I;
    public TextureView J;
    public SeekBar K;
    public TextView L;
    public ImageView M;
    public ImageView N;
    public LinearLayout O;
    public ImageView P;
    public TextView Q;
    public TextView R;
    public ImageView S;
    public TextView T;
    public TextView U;
    public TextView V;
    public OSETShakeView W;
    public TextView X;
    public LinearLayout Y;
    public LinearLayout Z;
    public TextView a0;
    public ImageView b0;
    private Bitmap c0;
    private ApkDownloader d0;
    private boolean e0;
    private ApiVideoPlayer i;
    private OSETCountDownTimer j;
    private long m;
    private long n;
    private long o;
    protected ADVRewardListener u;
    private long v;
    private long w;
    private long x;
    private long y;
    private long z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f39868a = false;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private long h = 0;
    private int k = 0;
    private int l = 0;
    private PlayState p = PlayState.INITIALIZE;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private String t = "";
    private int A = 1;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private OSETCountDownTimer f0 = null;

    @Keep
    public class a extends OSETCountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIRewardADActivity f39869a;

        static {
            OSETSDKProtected.interface11(4796);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OSETAPIRewardADActivity oSETAPIRewardADActivity, long j, long j2) {
            super(j, j2);
            this.f39869a = oSETAPIRewardADActivity;
        }

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onFinish();

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onTick(long j);
    }

    @Keep
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f39870a;

        static {
            OSETSDKProtected.interface11(4797);
            int[] iArr = new int[APIRewardAdEvent.values().length];
            f39870a = iArr;
            try {
                iArr[APIRewardAdEvent.SHOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39870a[APIRewardAdEvent.CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39870a[APIRewardAdEvent.REWARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39870a[APIRewardAdEvent.VIDEO_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f39870a[APIRewardAdEvent.VIDEO_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f39870a[APIRewardAdEvent.SKIP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f39870a[APIRewardAdEvent.CLOSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Keep
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIRewardADActivity f39871a;

        static {
            OSETSDKProtected.interface11(4798);
        }

        public c(OSETAPIRewardADActivity oSETAPIRewardADActivity) {
            this.f39871a = oSETAPIRewardADActivity;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    @Keep
    public class d extends OnAdTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIRewardADActivity f39872a;

        static {
            OSETSDKProtected.interface11(4799);
        }

        public d(OSETAPIRewardADActivity oSETAPIRewardADActivity) {
            this.f39872a = oSETAPIRewardADActivity;
        }

        @Override // com.kc.openset.sdk.apiad.tools.OnAdTouchListener
        public native void touchAd(View view, com.kc.openset.sdk.apiad.tools.i iVar, com.kc.openset.sdk.apiad.tools.i iVar2);
    }

    @Keep
    public class e extends OSETCountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIRewardADActivity f39873a;

        static {
            OSETSDKProtected.interface11(4800);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(OSETAPIRewardADActivity oSETAPIRewardADActivity, long j, long j2) {
            super(j, j2);
            this.f39873a = oSETAPIRewardADActivity;
        }

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onFinish();

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onTick(long j);
    }

    @Keep
    public class f implements AwardsTipDialog.OnActionClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIRewardADActivity f39874a;

        static {
            OSETSDKProtected.interface11(4801);
        }

        public f(OSETAPIRewardADActivity oSETAPIRewardADActivity) {
            this.f39874a = oSETAPIRewardADActivity;
        }

        @Override // com.kc.openset.sdk.mat.AwardsTipDialog.OnActionClickListener
        public native void onContinueVideo();

        @Override // com.kc.openset.sdk.mat.AwardsTipDialog.OnActionClickListener
        public native void onFasterAward();
    }

    @Keep
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIRewardADActivity f39875a;

        static {
            OSETSDKProtected.interface11(4802);
        }

        public g(OSETAPIRewardADActivity oSETAPIRewardADActivity) {
            this.f39875a = oSETAPIRewardADActivity;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Keep
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIRewardADActivity f39876a;

        static {
            OSETSDKProtected.interface11(4803);
        }

        public h(OSETAPIRewardADActivity oSETAPIRewardADActivity) {
            this.f39876a = oSETAPIRewardADActivity;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Keep
    public class i implements ApiVideoPlayer.ADVPlayerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIRewardADActivity f39877a;

        static {
            OSETSDKProtected.interface11(4804);
        }

        public i(OSETAPIRewardADActivity oSETAPIRewardADActivity) {
            this.f39877a = oSETAPIRewardADActivity;
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
    public class j implements LoadBitmapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f39878a;
        final ImageView b;
        final OSETAPIRewardADActivity c;

        public static native /* synthetic */ void $r8$lambda$Cjg2Gc0ERCskCBTQkFBGkhmPBFM(j jVar, Context context, Bitmap bitmap, ImageView imageView);

        public static native /* synthetic */ void $r8$lambda$qG_nycr0YUhjrIKkMAI3_1YLwV8(j jVar, ImageView imageView, Bitmap bitmap);

        static {
            OSETSDKProtected.interface11(4807);
        }

        public j(OSETAPIRewardADActivity oSETAPIRewardADActivity, Context context, ImageView imageView) {
            this.c = oSETAPIRewardADActivity;
            this.f39878a = context;
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
    public class k implements LoadBitmapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETAPIRewardADActivity f39879a;

        static {
            OSETSDKProtected.interface11(4808);
        }

        public k(OSETAPIRewardADActivity oSETAPIRewardADActivity) {
            this.f39879a = oSETAPIRewardADActivity;
        }

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onFail();

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onSuccess(Bitmap bitmap);
    }

    /* JADX INFO: renamed from: $r8$lambda$4mx2ofmDELvDMsVCteXF1-Er3mw, reason: not valid java name */
    public static native /* synthetic */ void m1041$r8$lambda$4mx2ofmDELvDMsVCteXF1Er3mw(OSETAPIRewardADActivity oSETAPIRewardADActivity, Bitmap bitmap);

    public static native /* synthetic */ void $r8$lambda$R2GGCz5n1iPalsS7nDm9j6XT8xM(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    public static native /* synthetic */ void $r8$lambda$SwN3oAady6cJWHoDUyIO7zs_j4I(OSETAPIRewardADActivity oSETAPIRewardADActivity, View view);

    public static native /* synthetic */ void $r8$lambda$XzHjKXo4jLDpWf0DvbEyw0TrA4c(OSETAPIRewardADActivity oSETAPIRewardADActivity, DialogInterface dialogInterface);

    public static native /* synthetic */ void $r8$lambda$obxkUkxKu_FzDEcJIqRscYkjVEg(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    /* JADX INFO: renamed from: $r8$lambda$psiESAHmcGMV14g9Wp4-vWwfECo, reason: not valid java name */
    public static native /* synthetic */ void m1042$r8$lambda$psiESAHmcGMV14g9Wp4vWwfECo(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    /* JADX INFO: renamed from: $r8$lambda$sROm9gwcsy1oQEtDeE1pMrwSS-Q, reason: not valid java name */
    public static native /* synthetic */ void m1043$r8$lambda$sROm9gwcsy1oQEtDeE1pMrwSSQ(OSETAPIRewardADActivity oSETAPIRewardADActivity, View view);

    static {
        OSETSDKProtected.interface11(4809);
    }

    public static native /* synthetic */ int a(OSETAPIRewardADActivity oSETAPIRewardADActivity, int i2);

    public static native /* synthetic */ long a(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    public static native /* synthetic */ long a(OSETAPIRewardADActivity oSETAPIRewardADActivity, long j2);

    public static native /* synthetic */ PlayState a(OSETAPIRewardADActivity oSETAPIRewardADActivity, PlayState playState);

    private native String a(int i2, int i3);

    public static native /* synthetic */ String a(OSETAPIRewardADActivity oSETAPIRewardADActivity, int i2, int i3);

    public static native /* synthetic */ String a(OSETAPIRewardADActivity oSETAPIRewardADActivity, String str);

    private native void a();

    private native void a(int i2);

    public static native void a(Activity activity, com.kc.openset.sdk.apiad.tools.c cVar, boolean z);

    private native void a(Context context, ImageView imageView, String str);

    private native /* synthetic */ void a(DialogInterface dialogInterface);

    private native /* synthetic */ void a(Bitmap bitmap);

    private native /* synthetic */ void a(View view);

    private native void a(View view, boolean z);

    public static native /* synthetic */ void a(OSETAPIRewardADActivity oSETAPIRewardADActivity, Bitmap bitmap);

    public static native /* synthetic */ void a(OSETAPIRewardADActivity oSETAPIRewardADActivity, View view, boolean z);

    public static native /* synthetic */ void a(OSETAPIRewardADActivity oSETAPIRewardADActivity, APIRewardAdEvent aPIRewardAdEvent);

    private native void a(APIRewardAdEvent aPIRewardAdEvent);

    private native void a(boolean z);

    private native void a(View... viewArr);

    public static native /* synthetic */ boolean a(OSETAPIRewardADActivity oSETAPIRewardADActivity, boolean z);

    public static native /* synthetic */ int b(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    public static native /* synthetic */ long b(OSETAPIRewardADActivity oSETAPIRewardADActivity, long j2);

    private native void b();

    private native void b(Bitmap bitmap);

    private native /* synthetic */ void b(View view);

    public static native /* synthetic */ void b(OSETAPIRewardADActivity oSETAPIRewardADActivity, int i2);

    public static native /* synthetic */ boolean b(OSETAPIRewardADActivity oSETAPIRewardADActivity, boolean z);

    public static native /* synthetic */ int c(OSETAPIRewardADActivity oSETAPIRewardADActivity, int i2);

    public static native /* synthetic */ long c(OSETAPIRewardADActivity oSETAPIRewardADActivity, long j2);

    private native void c();

    public static native /* synthetic */ void c(OSETAPIRewardADActivity oSETAPIRewardADActivity, boolean z);

    public static native /* synthetic */ boolean c(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    public static native /* synthetic */ int d(OSETAPIRewardADActivity oSETAPIRewardADActivity, int i2);

    private native void d();

    public static native /* synthetic */ void d(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    public static native /* synthetic */ boolean d(OSETAPIRewardADActivity oSETAPIRewardADActivity, boolean z);

    private native void e();

    public static native /* synthetic */ boolean e(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    private native void f();

    public static native /* synthetic */ void f(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    public static native /* synthetic */ long g(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    private native boolean g();

    public static native /* synthetic */ int h(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    private native boolean h();

    private native boolean i();

    public static native /* synthetic */ boolean i(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    private native void initAdData();

    private native /* synthetic */ void j();

    public static native /* synthetic */ void j(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    public static native /* synthetic */ ApkDownloader k(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    private native /* synthetic */ void k();

    public static native /* synthetic */ long l(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    private native /* synthetic */ void l();

    private native void m();

    public static native /* synthetic */ boolean m(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    private native void n();

    public static native /* synthetic */ void n(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    public static native /* synthetic */ PlayState o(OSETAPIRewardADActivity oSETAPIRewardADActivity);

    private native void o();

    private native void p();

    private native void q();

    private native void r();

    public native void a(long j2);

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
