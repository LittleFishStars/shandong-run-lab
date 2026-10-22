package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.ar8;
import com.zj.adlib.az4;
import com.zj.adlib.bp5;
import com.zj.adlib.d72;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.oh5;
import com.zj.adlib.sb0;
import com.zj.adlib.w38;
import com.zj.adlib.yk3;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j implements MediaPeriod, Loader.Callback<c> {
    public static final int L = 1024;
    public static final String f = "SingleSampleMediaPeriod";
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30941a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.d f4278a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSourceEventListener.a f4279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource.Factory f4280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSpec f4281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f4282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TransferListener f4284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ga9 f4285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f4288a;
    public boolean b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<b> f4286a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Loader f4283a = new Loader(f);

    public final class b implements SampleStream {
        public static final int L = 0;
        public static final int M = 1;
        public static final int N = 2;
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4289a;

        public b() {
        }

        public final void a() {
            if (this.f4289a) {
                return;
            }
            j.this.f4279a.i(bp5.l(j.this.f4278a.k), j.this.f4278a, 0, null, 0L);
            this.f4289a = true;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int b(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
            a();
            j jVar = j.this;
            boolean z = jVar.b;
            if (z && jVar.f4288a == null) {
                this.K = 2;
            }
            int i2 = this.K;
            if (i2 == 2) {
                decoderInputBuffer.a(4);
                return -4;
            }
            if ((i & 2) != 0 || i2 == 0) {
                yk3Var.f46052a = jVar.f4278a;
                this.K = 1;
                return -5;
            }
            if (!z) {
                return -3;
            }
            sb0.g(jVar.f4288a);
            decoderInputBuffer.a(1);
            decoderInputBuffer.f30576a = 0L;
            if ((i & 4) == 0) {
                decoderInputBuffer.k(j.this.K);
                ByteBuffer byteBuffer = decoderInputBuffer.f2588a;
                j jVar2 = j.this;
                byteBuffer.put(jVar2.f4288a, 0, jVar2.K);
            }
            if ((i & 1) == 0) {
                this.K = 2;
            }
            return -4;
        }

        public void c() {
            if (this.K == 2) {
                this.K = 1;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return j.this.b;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            j jVar = j.this;
            if (jVar.f4287a) {
                return;
            }
            jVar.f4283a.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            a();
            if (j <= 0 || this.K == 2) {
                return 0;
            }
            this.K = 2;
            return 1;
        }
    }

    public static final class c implements Loader.Loadable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30943a = az4.a();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DataSpec f4290a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ar8 f4291a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public byte[] f4292a;

        public c(DataSpec dataSpec, DataSource dataSource) {
            this.f4290a = dataSpec;
            this.f4291a = new ar8(dataSource);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException {
            this.f4291a.i();
            try {
                this.f4291a.a(this.f4290a);
                int i = 0;
                while (i != -1) {
                    int iD = (int) this.f4291a.d();
                    byte[] bArr = this.f4292a;
                    if (bArr == null) {
                        this.f4292a = new byte[1024];
                    } else if (iD == bArr.length) {
                        this.f4292a = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    ar8 ar8Var = this.f4291a;
                    byte[] bArr2 = this.f4292a;
                    i = ar8Var.read(bArr2, iD, bArr2.length - iD);
                }
            } finally {
                d72.a(this.f4291a);
            }
        }
    }

    public j(DataSpec dataSpec, DataSource.Factory factory, @Nullable TransferListener transferListener, com.google.android.exoplayer2.d dVar, long j, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.a aVar, boolean z) {
        this.f4281a = dataSpec;
        this.f4280a = factory;
        this.f4284a = transferListener;
        this.f4278a = dVar;
        this.f30941a = j;
        this.f4282a = loadErrorHandlingPolicy;
        this.f4279a = aVar;
        this.f4287a = z;
        this.f4285a = new ga9(new da9(dVar));
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long a(long j, w38 w38Var) {
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void c(MediaPeriod.Callback callback, long j) {
        callback.h(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.b || this.f4283a.i() || this.f4283a.h()) {
            return false;
        }
        DataSource dataSourceA = this.f4280a.a();
        TransferListener transferListener = this.f4284a;
        if (transferListener != null) {
            dataSourceA.b(transferListener);
        }
        c cVar = new c(this.f4281a, dataSourceA);
        this.f4279a.A(new az4(cVar.f30943a, this.f4281a, this.f4283a.l(cVar, this, this.f4282a.getMinimumLoadableRetryCount(1))), 1, -1, this.f4278a, 0, null, 0L, this.f30941a);
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void M(c cVar, long j, long j2, boolean z) {
        ar8 ar8Var = cVar.f4291a;
        az4 az4Var = new az4(cVar.f30943a, cVar.f4290a, ar8Var.g(), ar8Var.h(), j, j2, ar8Var.d());
        this.f4282a.onLoadTaskConcluded(cVar.f30943a);
        this.f4279a.r(az4Var, 1, -1, null, 0, null, 0L, this.f30941a);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public ga9 e() {
        return this.f4285a;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long f(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            SampleStream sampleStream = sampleStreamArr[i];
            if (sampleStream != null && (exoTrackSelectionArr[i] == null || !zArr[i])) {
                this.f4286a.remove(sampleStream);
                sampleStreamArr[i] = null;
            }
            if (sampleStreamArr[i] == null && exoTrackSelectionArr[i] != null) {
                b bVar = new b();
                this.f4286a.add(bVar);
                sampleStreamArr[i] = bVar;
                zArr2[i] = true;
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void K(c cVar, long j, long j2) {
        this.K = (int) cVar.f4291a.d();
        this.f4288a = (byte[]) sb0.g(cVar.f4292a);
        this.b = true;
        ar8 ar8Var = cVar.f4291a;
        az4 az4Var = new az4(cVar.f30943a, cVar.f4290a, ar8Var.g(), ar8Var.h(), j, j2, this.K);
        this.f4282a.onLoadTaskConcluded(cVar.f30943a);
        this.f4279a.u(az4Var, 1, -1, this.f4278a, 0, null, 0L, this.f30941a);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.b ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return (this.b || this.f4283a.i()) ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Loader.b A(c cVar, long j, long j2, IOException iOException, int i) {
        Loader.b bVarG;
        ar8 ar8Var = cVar.f4291a;
        az4 az4Var = new az4(cVar.f30943a, cVar.f4290a, ar8Var.g(), ar8Var.h(), j, j2, ar8Var.d());
        long jB = this.f4282a.b(new LoadErrorHandlingPolicy.c(az4Var, new oh5(1, -1, this.f4278a, 0, null, 0L, gj9.H1(this.f30941a)), iOException, i));
        boolean z = jB == -9223372036854775807L || i >= this.f4282a.getMinimumLoadableRetryCount(1);
        if (this.f4287a && z) {
            Log.o(f, "Loading failed, treating as end-of-stream.", iOException);
            this.b = true;
            bVarG = Loader.f5050c;
        } else {
            bVarG = jB != -9223372036854775807L ? Loader.g(false, jB) : Loader.f5051d;
        }
        Loader.b bVar = bVarG;
        boolean z2 = !bVar.c();
        this.f4279a.w(az4Var, 1, -1, this.f4278a, 0, null, 0L, this.f30941a, iOException, z2);
        if (z2) {
            this.f4282a.onLoadTaskConcluded(cVar.f30943a);
        }
        return bVar;
    }

    public void i() {
        this.f4283a.j();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.f4283a.i();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        for (int i = 0; i < this.f4286a.size(); i++) {
            this.f4286a.get(i).c();
        }
        return j;
    }
}
