package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class tg2 implements LoadControl {
    public static final int c = 50000;
    public static final int d = 50000;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final boolean f19789d = false;
    public static final int e = 2500;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final boolean f19790e = false;
    public static final int f = 5000;
    public static final int g = -1;
    public static final int h = 0;
    public static final int i = 131072000;
    public static final int j = 13107200;
    public static final int k = 131072;
    public static final int l = 131072;
    public static final int m = 131072;
    public static final int n = 131072;
    public static final int o = 144310272;
    public static final int p = 13107200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44910a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f19791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.upstream.a f19792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f19793a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f19794b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f19795b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final long f19796c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f19797c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final long f19798d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final long f19799e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public com.google.android.exoplayer2.upstream.a f19800a;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f19803c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f44911a = 50000;
        public int b = 50000;
        public int c = 2500;
        public int d = 5000;
        public int e = -1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f19801a = false;
        public int f = 0;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f19802b = false;

        public tg2 a() {
            sb0.i(!this.f19803c);
            this.f19803c = true;
            if (this.f19800a == null) {
                this.f19800a = new com.google.android.exoplayer2.upstream.a(true, 65536);
            }
            return new tg2(this.f19800a, this.f44911a, this.b, this.c, this.d, this.e, this.f19801a, this.f, this.f19802b);
        }

        @Deprecated
        public tg2 b() {
            return a();
        }

        public a c(com.google.android.exoplayer2.upstream.a aVar) {
            sb0.i(!this.f19803c);
            this.f19800a = aVar;
            return this;
        }

        public a d(int i, boolean z) {
            sb0.i(!this.f19803c);
            tg2.d(i, 0, "backBufferDurationMs", "0");
            this.f = i;
            this.f19802b = z;
            return this;
        }

        public a e(int i, int i2, int i3, int i4) {
            sb0.i(!this.f19803c);
            tg2.d(i3, 0, "bufferForPlaybackMs", "0");
            tg2.d(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
            tg2.d(i, i3, "minBufferMs", "bufferForPlaybackMs");
            tg2.d(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            tg2.d(i2, i, "maxBufferMs", "minBufferMs");
            this.f44911a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            return this;
        }

        public a f(boolean z) {
            sb0.i(!this.f19803c);
            this.f19801a = z;
            return this;
        }

        public a g(int i) {
            sb0.i(!this.f19803c);
            this.e = i;
            return this;
        }
    }

    public tg2() {
        this(new com.google.android.exoplayer2.upstream.a(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    public static void d(int i2, int i3, String str, String str2) {
        sb0.b(i2 >= i3, str + " cannot be less than " + str2);
    }

    public static int e(int i2) {
        switch (i2) {
            case -2:
                return 0;
            case -1:
            default:
                throw new IllegalArgumentException();
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
        }
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void a(Renderer[] rendererArr, ga9 ga9Var, ExoTrackSelection[] exoTrackSelectionArr) {
        int iCalculateTargetBufferBytes = this.f44910a;
        if (iCalculateTargetBufferBytes == -1) {
            iCalculateTargetBufferBytes = calculateTargetBufferBytes(rendererArr, exoTrackSelectionArr);
        }
        this.b = iCalculateTargetBufferBytes;
        this.f19792a.e(iCalculateTargetBufferBytes);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public Allocator b() {
        return this.f19792a;
    }

    public int calculateTargetBufferBytes(Renderer[] rendererArr, ExoTrackSelection[] exoTrackSelectionArr) {
        int iE = 0;
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            if (exoTrackSelectionArr[i2] != null) {
                iE += e(rendererArr[i2].getTrackType());
            }
        }
        return Math.max(13107200, iE);
    }

    public final void f(boolean z) {
        int i2 = this.f44910a;
        if (i2 == -1) {
            i2 = 13107200;
        }
        this.b = i2;
        this.f19797c = false;
        if (z) {
            this.f19792a.d();
        }
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public long getBackBufferDurationUs() {
        return this.f19799e;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        f(false);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        f(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        f(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean retainBackBufferFromKeyframe() {
        return this.f19795b;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long j2, long j3, float f2) {
        boolean z = true;
        boolean z2 = this.f19792a.getTotalBytesAllocated() >= this.b;
        long jMin = this.f19791a;
        if (f2 > 1.0f) {
            jMin = Math.min(gj9.l0(jMin, f2), this.f19794b);
        }
        if (j3 < Math.max(jMin, 500000L)) {
            if (!this.f19793a && z2) {
                z = false;
            }
            this.f19797c = z;
            if (!z && j3 < 500000) {
                Log.n("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j3 >= this.f19794b || z2) {
            this.f19797c = false;
        }
        return this.f19797c;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long j2, float f2, boolean z, long j3) {
        long jQ0 = gj9.q0(j2, f2);
        long jMin = z ? this.f19798d : this.f19796c;
        if (j3 != -9223372036854775807L) {
            jMin = Math.min(j3 / 2, jMin);
        }
        return jMin <= 0 || jQ0 >= jMin || (!this.f19793a && this.f19792a.getTotalBytesAllocated() >= this.b);
    }

    public tg2(com.google.android.exoplayer2.upstream.a aVar, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, boolean z2) {
        d(i4, 0, "bufferForPlaybackMs", "0");
        d(i5, 0, "bufferForPlaybackAfterRebufferMs", "0");
        d(i2, i4, "minBufferMs", "bufferForPlaybackMs");
        d(i2, i5, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        d(i3, i2, "maxBufferMs", "minBufferMs");
        d(i7, 0, "backBufferDurationMs", "0");
        this.f19792a = aVar;
        this.f19791a = gj9.Z0(i2);
        this.f19794b = gj9.Z0(i3);
        this.f19796c = gj9.Z0(i4);
        this.f19798d = gj9.Z0(i5);
        this.f44910a = i6;
        this.b = i6 == -1 ? 13107200 : i6;
        this.f19793a = z;
        this.f19799e = gj9.Z0(i7);
        this.f19795b = z2;
    }
}
