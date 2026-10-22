package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.zj.adlib.fg0;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AudioTrackPositionTracker {
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static final int i = 10;
    public static final int j = 30000;
    public static final int k = 500000;
    public static final long q = 5000000;
    public static final long r = 5000000;
    public static final long s = 1000000;
    public static final long t = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f30540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public AudioTrack f2365a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Listener f2366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public fg0 f2367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Method f2368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long[] f2370a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f2371b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2372b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f2373c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2374c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f2375d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2376d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f2377e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f2378e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public long f2379f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public long f2380g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public long f2381h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public long f2382i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public long f2383j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public long f2384k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;

    public interface Listener {
        void onInvalidLatency(long j);

        void onPositionAdvancing(long j);

        void onPositionFramesMismatch(long j, long j2, long j3, long j4);

        void onSystemTimeUsMismatch(long j, long j2, long j3, long j4);

        void onUnderrun(int i, long j);
    }

    public AudioTrackPositionTracker(Listener listener) {
        this.f2366a = (Listener) sb0.g(listener);
        if (gj9.f41922a >= 18) {
            try {
                this.f2368a = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f2370a = new long[10];
    }

    public static boolean o(int i2) {
        return gj9.f41922a < 23 && (i2 == 5 || i2 == 6);
    }

    public final boolean a() {
        return this.f2369a && ((AudioTrack) sb0.g(this.f2365a)).getPlayState() == 2 && e() == 0;
    }

    public final long b(long j2) {
        return (j2 * 1000000) / ((long) this.c);
    }

    public int c(long j2) {
        return this.b - ((int) (j2 - (e() * ((long) this.f2363a))));
    }

    public long d(boolean z) {
        long jF;
        if (((AudioTrack) sb0.g(this.f2365a)).getPlayState() == 3) {
            m();
        }
        long jNanoTime = System.nanoTime() / 1000;
        fg0 fg0Var = (fg0) sb0.g(this.f2367a);
        boolean zD = fg0Var.d();
        if (zD) {
            jF = b(fg0Var.b()) + gj9.l0(jNanoTime - fg0Var.c(), this.f30540a);
        } else {
            jF = this.e == 0 ? f() : this.f2371b + jNanoTime;
            if (!z) {
                jF = Math.max(0L, jF - this.f2375d);
            }
        }
        if (this.f2378e != zD) {
            this.p = this.n;
            this.o = this.m;
        }
        long j2 = jNanoTime - this.p;
        if (j2 < 1000000) {
            long jL0 = this.o + gj9.l0(j2, this.f30540a);
            long j3 = (j2 * 1000) / 1000000;
            jF = ((jF * j3) + ((1000 - j3) * jL0)) / 1000;
        }
        if (!this.f2372b) {
            long j4 = this.m;
            if (jF > j4) {
                this.f2372b = true;
                this.f2366a.onPositionAdvancing(System.currentTimeMillis() - gj9.H1(gj9.q0(gj9.H1(jF - j4), this.f30540a)));
            }
        }
        this.n = jNanoTime;
        this.m = jF;
        this.f2378e = zD;
        return jF;
    }

    public final long e() {
        AudioTrack audioTrack = (AudioTrack) sb0.g(this.f2365a);
        if (this.f2382i != -9223372036854775807L) {
            return Math.min(this.l, this.f2384k + ((((SystemClock.elapsedRealtime() * 1000) - this.f2382i) * ((long) this.c)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.f2369a) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f2381h = this.f2379f;
            }
            playbackHeadPosition += this.f2381h;
        }
        if (gj9.f41922a <= 29) {
            if (playbackHeadPosition == 0 && this.f2379f > 0 && playState == 3) {
                if (this.f2383j == -9223372036854775807L) {
                    this.f2383j = SystemClock.elapsedRealtime();
                }
                return this.f2379f;
            }
            this.f2383j = -9223372036854775807L;
        }
        if (this.f2379f > playbackHeadPosition) {
            this.f2380g++;
        }
        this.f2379f = playbackHeadPosition;
        return playbackHeadPosition + (this.f2380g << 32);
    }

    public final long f() {
        return b(e());
    }

    public void g(long j2) {
        this.f2384k = e();
        this.f2382i = SystemClock.elapsedRealtime() * 1000;
        this.l = j2;
    }

    public boolean h(long j2) {
        return j2 > e() || a();
    }

    public boolean i() {
        return ((AudioTrack) sb0.g(this.f2365a)).getPlayState() == 3;
    }

    public boolean j(long j2) {
        return this.f2383j != -9223372036854775807L && j2 > 0 && SystemClock.elapsedRealtime() - this.f2383j >= 200;
    }

    public boolean k(long j2) {
        int playState = ((AudioTrack) sb0.g(this.f2365a)).getPlayState();
        if (this.f2369a) {
            if (playState == 2) {
                this.f2374c = false;
                return false;
            }
            if (playState == 1 && e() == 0) {
                return false;
            }
        }
        boolean z = this.f2374c;
        boolean zH = h(j2);
        this.f2374c = zH;
        if (z && !zH && playState != 1) {
            this.f2366a.onUnderrun(this.b, gj9.H1(this.f2364a));
        }
        return true;
    }

    public final void l(long j2, long j3) {
        fg0 fg0Var = (fg0) sb0.g(this.f2367a);
        if (fg0Var.f(j2)) {
            long jC = fg0Var.c();
            long jB = fg0Var.b();
            if (Math.abs(jC - j2) > 5000000) {
                this.f2366a.onSystemTimeUsMismatch(jB, jC, j2, j3);
                fg0Var.g();
            } else if (Math.abs(b(jB) - j3) <= 5000000) {
                fg0Var.a();
            } else {
                this.f2366a.onPositionFramesMismatch(jB, jC, j2, j3);
                fg0Var.g();
            }
        }
    }

    public final void m() {
        long jF = f();
        if (jF == 0) {
            return;
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.f2373c >= 30000) {
            long[] jArr = this.f2370a;
            int i2 = this.d;
            jArr[i2] = jF - jNanoTime;
            this.d = (i2 + 1) % 10;
            int i3 = this.e;
            if (i3 < 10) {
                this.e = i3 + 1;
            }
            this.f2373c = jNanoTime;
            this.f2371b = 0L;
            int i4 = 0;
            while (true) {
                int i5 = this.e;
                if (i4 >= i5) {
                    break;
                }
                this.f2371b += this.f2370a[i4] / ((long) i5);
                i4++;
            }
        }
        if (this.f2369a) {
            return;
        }
        l(jNanoTime, jF);
        n(jNanoTime);
    }

    public final void n(long j2) {
        Method method;
        if (!this.f2376d || (method = this.f2368a) == null || j2 - this.f2377e < 500000) {
            return;
        }
        try {
            long jIntValue = (((long) ((Integer) gj9.k((Integer) method.invoke(sb0.g(this.f2365a), new Object[0]))).intValue()) * 1000) - this.f2364a;
            this.f2375d = jIntValue;
            long jMax = Math.max(jIntValue, 0L);
            this.f2375d = jMax;
            if (jMax > 5000000) {
                this.f2366a.onInvalidLatency(jMax);
                this.f2375d = 0L;
            }
        } catch (Exception unused) {
            this.f2368a = null;
        }
        this.f2377e = j2;
    }

    public boolean p() {
        r();
        if (this.f2382i != -9223372036854775807L) {
            return false;
        }
        ((fg0) sb0.g(this.f2367a)).h();
        return true;
    }

    public void q() {
        r();
        this.f2365a = null;
        this.f2367a = null;
    }

    public final void r() {
        this.f2371b = 0L;
        this.e = 0;
        this.d = 0;
        this.f2373c = 0L;
        this.n = 0L;
        this.p = 0L;
        this.f2372b = false;
    }

    public void s(AudioTrack audioTrack, boolean z, int i2, int i3, int i4) {
        this.f2365a = audioTrack;
        this.f2363a = i3;
        this.b = i4;
        this.f2367a = new fg0(audioTrack);
        this.c = audioTrack.getSampleRate();
        this.f2369a = z && o(i2);
        boolean zJ0 = gj9.J0(i2);
        this.f2376d = zJ0;
        this.f2364a = zJ0 ? b(i4 / i3) : -9223372036854775807L;
        this.f2379f = 0L;
        this.f2380g = 0L;
        this.f2381h = 0L;
        this.f2374c = false;
        this.f2382i = -9223372036854775807L;
        this.f2383j = -9223372036854775807L;
        this.f2377e = 0L;
        this.f2375d = 0L;
        this.f30540a = 1.0f;
    }

    public void t(float f2) {
        this.f30540a = f2;
        fg0 fg0Var = this.f2367a;
        if (fg0Var != null) {
            fg0Var.h();
        }
    }

    public void u() {
        ((fg0) sb0.g(this.f2367a)).h();
    }
}
