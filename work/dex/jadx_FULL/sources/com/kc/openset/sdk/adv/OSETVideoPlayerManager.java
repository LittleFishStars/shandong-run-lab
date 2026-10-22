package com.kc.openset.sdk.adv;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.R;
import com.kc.openset.sdk.apiad.tools.ApiVideoPlayer;
import com.kc.openset.sdk.apiad.tools.PlayState;
import com.kc.openset.util.LoadBitmapListener;
import com.kc.openset.util.OSETCountDownTimer;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETVideoPlayerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f39818a;
    private final View b;
    private final ImageView c;
    private final TextureView d;
    private final ImageView e;
    private final ImageView f;
    private OSETVideoPlayerListener g;
    private ApiVideoPlayer h;
    private OSETCountDownTimer k;
    private long l;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private int u;
    private boolean i = true;
    private boolean j = false;
    private int m = 0;
    private int n = 0;
    private PlayState o = PlayState.INITIALIZE;

    @Keep
    public @interface VideoPlayType {
        public static final int FIRST_PLAY = 1;
        public static final int PAUSED_PLAY = 2;
        public static final int REPLAY = 3;
    }

    @Keep
    public class a implements ApiVideoPlayer.ADVPlayerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETVideoPlayerManager f39819a;

        static {
            OSETSDKProtected.interface11(4704);
        }

        public a(OSETVideoPlayerManager oSETVideoPlayerManager) {
            this.f39819a = oSETVideoPlayerManager;
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
    public class b implements LoadBitmapListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETVideoPlayerManager f39820a;

        public static native /* synthetic */ void $r8$lambda$CRs1ykpxxmMDtKoid2KlB_y03zE(b bVar, Bitmap bitmap);

        public static native /* synthetic */ void $r8$lambda$Xk8oC1DOo48kRcrQPVrMZZT09LU(b bVar, Bitmap bitmap);

        static {
            OSETSDKProtected.interface11(4707);
        }

        public b(OSETVideoPlayerManager oSETVideoPlayerManager) {
            this.f39820a = oSETVideoPlayerManager;
        }

        private native /* synthetic */ void a(Bitmap bitmap);

        private native /* synthetic */ void b(Bitmap bitmap);

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onFail();

        @Override // com.kc.openset.util.LoadBitmapListener
        public native void onSuccess(Bitmap bitmap);
    }

    @Keep
    public class c extends OSETCountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETVideoPlayerManager f39821a;

        static {
            OSETSDKProtected.interface11(4708);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(OSETVideoPlayerManager oSETVideoPlayerManager, long j, long j2) {
            super(j, j2);
            this.f39821a = oSETVideoPlayerManager;
        }

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onFinish();

        @Override // com.kc.openset.util.OSETCountDownTimer
        public native void onTick(long j);
    }

    public static native /* synthetic */ void $r8$lambda$m0VA8oIFjbde8egm_C8CQMJ9Qf4(OSETVideoPlayerManager oSETVideoPlayerManager, View view);

    public static native /* synthetic */ void $r8$lambda$pB02dPj7UAGY8gwr67dM2XqclH8(OSETVideoPlayerManager oSETVideoPlayerManager, View view);

    static {
        OSETSDKProtected.interface11(4709);
    }

    public OSETVideoPlayerManager(Context context) {
        this.f39818a = new WeakReference<>(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.oset_qidian_video_player, (ViewGroup) null, false);
        this.b = viewInflate;
        this.c = (ImageView) viewInflate.findViewById(R.id.iv_cover_image);
        this.d = (TextureView) viewInflate.findViewById(R.id.texture_view);
        this.e = (ImageView) viewInflate.findViewById(R.id.iv_voice);
        this.f = (ImageView) viewInflate.findViewById(R.id.iv_replay);
        k();
    }

    public static native /* synthetic */ int a(OSETVideoPlayerManager oSETVideoPlayerManager, int i);

    public static native /* synthetic */ long a(OSETVideoPlayerManager oSETVideoPlayerManager, long j);

    public static native /* synthetic */ ApiVideoPlayer a(OSETVideoPlayerManager oSETVideoPlayerManager);

    public static native /* synthetic */ PlayState a(OSETVideoPlayerManager oSETVideoPlayerManager, PlayState playState);

    private native void a(int i);

    private native /* synthetic */ void a(View view);

    private native void a(String str);

    public static native /* synthetic */ boolean a(OSETVideoPlayerManager oSETVideoPlayerManager, boolean z);

    public static native /* synthetic */ int b(OSETVideoPlayerManager oSETVideoPlayerManager, int i);

    public static native /* synthetic */ long b(OSETVideoPlayerManager oSETVideoPlayerManager);

    private native /* synthetic */ void b(View view);

    public static native /* synthetic */ ImageView c(OSETVideoPlayerManager oSETVideoPlayerManager);

    public static native /* synthetic */ void c(OSETVideoPlayerManager oSETVideoPlayerManager, int i);

    public static native /* synthetic */ int d(OSETVideoPlayerManager oSETVideoPlayerManager);

    public static native /* synthetic */ int d(OSETVideoPlayerManager oSETVideoPlayerManager, int i);

    public static native /* synthetic */ WeakReference e(OSETVideoPlayerManager oSETVideoPlayerManager);

    public static native /* synthetic */ ImageView f(OSETVideoPlayerManager oSETVideoPlayerManager);

    public static native /* synthetic */ int g(OSETVideoPlayerManager oSETVideoPlayerManager);

    public static native /* synthetic */ ImageView h(OSETVideoPlayerManager oSETVideoPlayerManager);

    public static native /* synthetic */ boolean i(OSETVideoPlayerManager oSETVideoPlayerManager);

    public static native /* synthetic */ PlayState j(OSETVideoPlayerManager oSETVideoPlayerManager);

    public static native /* synthetic */ OSETVideoPlayerListener k(OSETVideoPlayerManager oSETVideoPlayerManager);

    private native void k();

    public static native /* synthetic */ void l(OSETVideoPlayerManager oSETVideoPlayerManager);

    private native void n();

    public native void a();

    public native void a(long j);

    public native void a(String str, String str2, int i, OSETVideoPlayerListener oSETVideoPlayerListener);

    public native int b();

    public native int c();

    public native long d();

    public native long e();

    public native long f();

    public native long g();

    public native long h();

    public native int i();

    public native View j();

    public native void l();

    public native void m();
}
