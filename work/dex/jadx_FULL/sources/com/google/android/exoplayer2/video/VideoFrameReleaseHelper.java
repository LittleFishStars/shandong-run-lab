package com.google.android.exoplayer2.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.th3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class VideoFrameReleaseHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31178a = "VideoFrameReleaseHelper";
    public static final int b = 30;
    public static final float e = 0.02f;
    public static final float f = 1.0f;
    public static final long h = 5000000000L;
    public static final long i = 500;
    public static final long j = 20000000;
    public static final long k = 80;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f5333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f5334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f5335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Surface f5336a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final DisplayHelper f5337a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final d f5338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final th3 f5339a = new th3();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5340a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f5341b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f5342b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f5343c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f5344d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f5345e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public long f5346f;
    public long g;

    public interface DisplayHelper {

        public interface Listener {
            void onDefaultDisplayChanged(@Nullable Display display);
        }

        void a(Listener listener);

        void unregister();
    }

    @RequiresApi(30)
    public static final class a {
        @DoNotInline
        public static void a(Surface surface, float f) {
            try {
                surface.setFrameRate(f, f == 0.0f ? 0 : 1);
            } catch (IllegalStateException e) {
                Log.e(VideoFrameReleaseHelper.f31178a, "Failed to call Surface.setFrameRate", e);
            }
        }
    }

    public static final class b implements DisplayHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowManager f31179a;

        public b(WindowManager windowManager) {
            this.f31179a = windowManager;
        }

        @Nullable
        public static DisplayHelper b(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new b(windowManager);
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.video.VideoFrameReleaseHelper.DisplayHelper
        public void a(DisplayHelper.Listener listener) {
            listener.onDefaultDisplayChanged(this.f31179a.getDefaultDisplay());
        }

        @Override // com.google.android.exoplayer2.video.VideoFrameReleaseHelper.DisplayHelper
        public void unregister() {
        }
    }

    @RequiresApi(17)
    public static final class c implements DisplayHelper, DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DisplayManager f31180a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public DisplayHelper.Listener f5347a;

        public c(DisplayManager displayManager) {
            this.f31180a = displayManager;
        }

        @Nullable
        public static DisplayHelper c(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                return new c(displayManager);
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.video.VideoFrameReleaseHelper.DisplayHelper
        public void a(DisplayHelper.Listener listener) {
            this.f5347a = listener;
            this.f31180a.registerDisplayListener(this, gj9.y());
            listener.onDefaultDisplayChanged(b());
        }

        public final Display b() {
            return this.f31180a.getDisplay(0);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            DisplayHelper.Listener listener = this.f5347a;
            if (listener == null || i != 0) {
                return;
            }
            listener.onDefaultDisplayChanged(b());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }

        @Override // com.google.android.exoplayer2.video.VideoFrameReleaseHelper.DisplayHelper
        public void unregister() {
            this.f31180a.unregisterDisplayListener(this);
            this.f5347a = null;
        }
    }

    public static final class d implements Choreographer.FrameCallback, Handler.Callback {
        public static final int L = 0;
        public static final int M = 1;
        public static final int N = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f31181a = new d();
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public volatile long f5348a = -9223372036854775807L;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Handler f5349a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HandlerThread f5350a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Choreographer f5351a;

        public d() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f5350a = handlerThread;
            handlerThread.start();
            Handler handlerX = gj9.x(handlerThread.getLooper(), this);
            this.f5349a = handlerX;
            handlerX.sendEmptyMessage(0);
        }

        public static d d() {
            return f31181a;
        }

        public void a() {
            this.f5349a.sendEmptyMessage(1);
        }

        public final void b() {
            Choreographer choreographer = this.f5351a;
            if (choreographer != null) {
                int i = this.K + 1;
                this.K = i;
                if (i == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        public final void c() {
            try {
                this.f5351a = Choreographer.getInstance();
            } catch (RuntimeException e) {
                Log.o(VideoFrameReleaseHelper.f31178a, "Vsync sampling disabled due to platform error", e);
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.f5348a = j;
            ((Choreographer) sb0.g(this.f5351a)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f5349a.sendEmptyMessage(2);
        }

        public final void f() {
            Choreographer choreographer = this.f5351a;
            if (choreographer != null) {
                int i = this.K - 1;
                this.K = i;
                if (i == 0) {
                    choreographer.removeFrameCallback(this);
                    this.f5348a = -9223372036854775807L;
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c();
                return true;
            }
            if (i == 1) {
                b();
                return true;
            }
            if (i != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public VideoFrameReleaseHelper(@Nullable Context context) {
        DisplayHelper displayHelperF = f(context);
        this.f5337a = displayHelperF;
        this.f5338a = displayHelperF != null ? d.d() : null;
        this.f5335a = -9223372036854775807L;
        this.f5342b = -9223372036854775807L;
        this.f5333a = -1.0f;
        this.d = 1.0f;
        this.f5334a = 0;
    }

    public static boolean c(long j2, long j3) {
        return Math.abs(j2 - j3) <= 20000000;
    }

    public static long e(long j2, long j3, long j4) {
        long j5;
        long j6 = j3 + (((j2 - j3) / j4) * j4);
        if (j2 <= j6) {
            j5 = j6 - j4;
        } else {
            j6 = j4 + j6;
            j5 = j6;
        }
        return j6 - j2 < j2 - j5 ? j6 : j5;
    }

    @Nullable
    public static DisplayHelper f(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        DisplayHelper displayHelperC = gj9.f41922a >= 17 ? c.c(applicationContext) : null;
        return displayHelperC == null ? b.b(applicationContext) : displayHelperC;
    }

    public long b(long j2) {
        long j3;
        if (this.f5346f == -1 || !this.f5339a.e()) {
            j3 = j2;
        } else {
            long jA = this.g + ((long) ((this.f5339a.a() * (this.f5343c - this.f5346f)) / this.d));
            if (c(j2, jA)) {
                j3 = jA;
            } else {
                n();
                j3 = j2;
            }
        }
        this.f5344d = this.f5343c;
        this.f5345e = j3;
        d dVar = this.f5338a;
        if (dVar == null || this.f5335a == -9223372036854775807L) {
            return j3;
        }
        long j4 = dVar.f5348a;
        return j4 == -9223372036854775807L ? j3 : e(j3, j4, this.f5335a) - this.f5342b;
    }

    public final void d() {
        Surface surface;
        if (gj9.f41922a < 30 || (surface = this.f5336a) == null || this.f5334a == Integer.MIN_VALUE || this.c == 0.0f) {
            return;
        }
        this.c = 0.0f;
        a.a(surface, 0.0f);
    }

    public void g(float f2) {
        this.f5333a = f2;
        this.f5339a.g();
        q();
    }

    public void h(long j2) {
        long j3 = this.f5344d;
        if (j3 != -1) {
            this.f5346f = j3;
            this.g = this.f5345e;
        }
        this.f5343c++;
        this.f5339a.f(j2 * 1000);
        q();
    }

    public void i(float f2) {
        this.d = f2;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.f5340a = true;
        n();
        if (this.f5337a != null) {
            ((d) sb0.g(this.f5338a)).a();
            this.f5337a.a(new DisplayHelper.Listener() { // from class: com.zj.adlib.kn9
                @Override // com.google.android.exoplayer2.video.VideoFrameReleaseHelper.DisplayHelper.Listener
                public final void onDefaultDisplayChanged(Display display) {
                    this.f42866a.p(display);
                }
            });
        }
        r(false);
    }

    public void l() {
        this.f5340a = false;
        DisplayHelper displayHelper = this.f5337a;
        if (displayHelper != null) {
            displayHelper.unregister();
            ((d) sb0.g(this.f5338a)).e();
        }
        d();
    }

    public void m(@Nullable Surface surface) {
        if (surface instanceof PlaceholderSurface) {
            surface = null;
        }
        if (this.f5336a == surface) {
            return;
        }
        d();
        this.f5336a = surface;
        r(true);
    }

    public final void n() {
        this.f5343c = 0L;
        this.f5346f = -1L;
        this.f5344d = -1L;
    }

    public void o(int i2) {
        if (this.f5334a == i2) {
            return;
        }
        this.f5334a = i2;
        r(true);
    }

    public final void p(@Nullable Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.f5335a = refreshRate;
            this.f5342b = (refreshRate * 80) / 100;
        } else {
            Log.n(f31178a, "Unable to query display refresh rate");
            this.f5335a = -9223372036854775807L;
            this.f5342b = -9223372036854775807L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    public final void q() {
        if (gj9.f41922a < 30 || this.f5336a == null) {
            return;
        }
        float fB = this.f5339a.e() ? this.f5339a.b() : this.f5333a;
        float f2 = this.f5341b;
        if (fB == f2) {
            return;
        }
        boolean z = true;
        if (fB != -1.0f && f2 != -1.0f) {
            if (Math.abs(fB - this.f5341b) < (this.f5339a.e() && (this.f5339a.d() > h ? 1 : (this.f5339a.d() == h ? 0 : -1)) >= 0 ? 0.02f : 1.0f)) {
                z = false;
            }
        } else if (fB == -1.0f && this.f5339a.c() < 30) {
            z = false;
        }
        if (z) {
            this.f5341b = fB;
            r(false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0021  */
    public final void r(boolean z) {
        Surface surface;
        float f2;
        if (gj9.f41922a < 30 || (surface = this.f5336a) == null || this.f5334a == Integer.MIN_VALUE) {
            return;
        }
        if (this.f5340a) {
            float f3 = this.f5341b;
            if (f3 != -1.0f) {
                f2 = f3 * this.d;
            } else {
                f2 = 0.0f;
            }
        } else {
            f2 = 0.0f;
        }
        if (z || this.c != f2) {
            this.c = f2;
            a.a(surface, f2);
        }
    }
}
