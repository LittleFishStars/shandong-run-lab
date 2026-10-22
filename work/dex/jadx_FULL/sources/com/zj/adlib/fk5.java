package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.a;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class fk5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41698a = "MediaPeriodHolder";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSourceList f16540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaPeriod f16541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TrackSelector f16542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public fk5 f16543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ga9 f16544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hk5 f16545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wa9 f16546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f16547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RendererCapabilities[] f16549a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SampleStream[] f16550a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean[] f16551a;
    public boolean b;
    public boolean c;

    public fk5(RendererCapabilities[] rendererCapabilitiesArr, long j, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, hk5 hk5Var, wa9 wa9Var) {
        this.f16549a = rendererCapabilitiesArr;
        this.f16539a = j;
        this.f16542a = trackSelector;
        this.f16540a = mediaSourceList;
        MediaSource.a aVar = hk5Var.f16997a;
        this.f16547a = ((gk5) aVar).f16805a;
        this.f16545a = hk5Var;
        this.f16544a = ga9.f16735a;
        this.f16546a = wa9Var;
        this.f16550a = new SampleStream[rendererCapabilitiesArr.length];
        this.f16551a = new boolean[rendererCapabilitiesArr.length];
        this.f16541a = e(aVar, mediaSourceList, allocator, hk5Var.f42145a, hk5Var.c);
    }

    public static MediaPeriod e(MediaSource.a aVar, MediaSourceList mediaSourceList, Allocator allocator, long j, long j2) {
        MediaPeriod mediaPeriodI = mediaSourceList.i(aVar, allocator, j);
        return j2 != -9223372036854775807L ? new a(mediaPeriodI, true, 0L, j2) : mediaPeriodI;
    }

    public static void u(MediaSourceList mediaSourceList, MediaPeriod mediaPeriod) {
        try {
            if (mediaPeriod instanceof a) {
                mediaSourceList.B(((a) mediaPeriod).f3759a);
            } else {
                mediaSourceList.B(mediaPeriod);
            }
        } catch (RuntimeException e) {
            Log.e(f41698a, "Period release failed.", e);
        }
    }

    public void A() {
        MediaPeriod mediaPeriod = this.f16541a;
        if (mediaPeriod instanceof a) {
            long j = this.f16545a.c;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((a) mediaPeriod).l(0L, j);
        }
    }

    public long a(wa9 wa9Var, long j, boolean z) {
        return b(wa9Var, j, z, new boolean[this.f16549a.length]);
    }

    public long b(wa9 wa9Var, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= wa9Var.f45559a) {
                break;
            }
            boolean[] zArr2 = this.f16551a;
            if (z || !wa9Var.b(this.f16546a, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        g(this.f16550a);
        f();
        this.f16546a = wa9Var;
        h();
        long jF = this.f16541a.f(wa9Var.f20399a, this.f16551a, this.f16550a, zArr, j);
        c(this.f16550a);
        this.b = false;
        int i2 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.f16550a;
            if (i2 >= sampleStreamArr.length) {
                return jF;
            }
            if (sampleStreamArr[i2] != null) {
                sb0.i(wa9Var.c(i2));
                if (this.f16549a[i2].getTrackType() != -2) {
                    this.b = true;
                }
            } else {
                sb0.i(wa9Var.f20399a[i2] == null);
            }
            i2++;
        }
    }

    public final void c(SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.f16549a;
            if (i >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[i].getTrackType() == -2 && this.f16546a.c(i)) {
                sampleStreamArr[i] = new j13();
            }
            i++;
        }
    }

    public void d(long j) {
        sb0.i(r());
        this.f16541a.continueLoading(y(j));
    }

    public final void f() {
        if (!r()) {
            return;
        }
        int i = 0;
        while (true) {
            wa9 wa9Var = this.f16546a;
            if (i >= wa9Var.f45559a) {
                return;
            }
            boolean zC = wa9Var.c(i);
            ExoTrackSelection exoTrackSelection = this.f16546a.f20399a[i];
            if (zC && exoTrackSelection != null) {
                exoTrackSelection.disable();
            }
            i++;
        }
    }

    public final void g(SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.f16549a;
            if (i >= rendererCapabilitiesArr.length) {
                return;
            }
            if (rendererCapabilitiesArr[i].getTrackType() == -2) {
                sampleStreamArr[i] = null;
            }
            i++;
        }
    }

    public final void h() {
        if (!r()) {
            return;
        }
        int i = 0;
        while (true) {
            wa9 wa9Var = this.f16546a;
            if (i >= wa9Var.f45559a) {
                return;
            }
            boolean zC = wa9Var.c(i);
            ExoTrackSelection exoTrackSelection = this.f16546a.f20399a[i];
            if (zC && exoTrackSelection != null) {
                exoTrackSelection.enable();
            }
            i++;
        }
    }

    public long i() {
        if (!this.f16548a) {
            return this.f16545a.f42145a;
        }
        long bufferedPositionUs = this.b ? this.f16541a.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.f16545a.d : bufferedPositionUs;
    }

    @Nullable
    public fk5 j() {
        return this.f16543a;
    }

    public long k() {
        if (this.f16548a) {
            return this.f16541a.getNextLoadPositionUs();
        }
        return 0L;
    }

    public long l() {
        return this.f16539a;
    }

    public long m() {
        return this.f16545a.f42145a + this.f16539a;
    }

    public ga9 n() {
        return this.f16544a;
    }

    public wa9 o() {
        return this.f16546a;
    }

    public void p(float f, Timeline timeline) throws ExoPlaybackException {
        this.f16548a = true;
        this.f16544a = this.f16541a.e();
        wa9 wa9VarV = v(f, timeline);
        hk5 hk5Var = this.f16545a;
        long jMax = hk5Var.f42145a;
        long j = hk5Var.d;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jA = a(wa9VarV, jMax, false);
        long j2 = this.f16539a;
        hk5 hk5Var2 = this.f16545a;
        this.f16539a = j2 + (hk5Var2.f42145a - jA);
        this.f16545a = hk5Var2.b(jA);
    }

    public boolean q() {
        return this.f16548a && (!this.b || this.f16541a.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public final boolean r() {
        return this.f16543a == null;
    }

    public void s(long j) {
        sb0.i(r());
        if (this.f16548a) {
            this.f16541a.reevaluateBuffer(y(j));
        }
    }

    public void t() {
        f();
        u(this.f16540a, this.f16541a);
    }

    public wa9 v(float f, Timeline timeline) throws ExoPlaybackException {
        wa9 wa9VarF = this.f16542a.f(this.f16549a, n(), this.f16545a.f16997a, timeline);
        for (ExoTrackSelection exoTrackSelection : wa9VarF.f20399a) {
            if (exoTrackSelection != null) {
                exoTrackSelection.onPlaybackSpeed(f);
            }
        }
        return wa9VarF;
    }

    public void w(@Nullable fk5 fk5Var) {
        if (fk5Var == this.f16543a) {
            return;
        }
        f();
        this.f16543a = fk5Var;
        h();
    }

    public void x(long j) {
        this.f16539a = j;
    }

    public long y(long j) {
        return j - l();
    }

    public long z(long j) {
        return j + l();
    }
}
