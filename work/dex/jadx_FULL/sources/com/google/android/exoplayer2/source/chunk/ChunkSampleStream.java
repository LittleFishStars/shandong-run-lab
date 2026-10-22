package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.az4;
import com.zj.adlib.gj9;
import com.zj.adlib.oh5;
import com.zj.adlib.sb0;
import com.zj.adlib.uk1;
import com.zj.adlib.w38;
import com.zj.adlib.yk3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    public static final String f = "ChunkSampleStream";
    public final int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.d f3842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSourceEventListener.a f3843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SampleQueue f3844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SequenceableLoader.Callback<ChunkSampleStream<T>> f3845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public BaseMediaChunk f3846a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Chunk f3847a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ReleaseCallback<T> f3848a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final T f3849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.source.chunk.a f3850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f3851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Loader f3852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final uk1 f3853a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<BaseMediaChunk> f3854a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<BaseMediaChunk> f3855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3856a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f3857a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.d[] f3858a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SampleQueue[] f3859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean[] f3860a;
    public long b;

    public interface ReleaseCallback<T extends ChunkSource> {
        void b(ChunkSampleStream<T> chunkSampleStream);
    }

    public final class a implements SampleStream {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SampleQueue f30860a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ChunkSampleStream<T> f3861a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3862a;

        public a(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue, int i) {
            this.f3861a = chunkSampleStream;
            this.f30860a = sampleQueue;
            this.K = i;
        }

        public final void a() {
            if (this.f3862a) {
                return;
            }
            ChunkSampleStream.this.f3843a.i(ChunkSampleStream.this.f3857a[this.K], ChunkSampleStream.this.f3858a[this.K], 0, null, ChunkSampleStream.this.b);
            this.f3862a = true;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int b(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
            if (ChunkSampleStream.this.s()) {
                return -3;
            }
            if (ChunkSampleStream.this.f3846a != null && ChunkSampleStream.this.f3846a.g(this.K + 1) <= this.f30860a.D()) {
                return -3;
            }
            a();
            return this.f30860a.S(yk3Var, decoderInputBuffer, i, ChunkSampleStream.this.f3856a);
        }

        public void c() {
            sb0.i(ChunkSampleStream.this.f3860a[this.K]);
            ChunkSampleStream.this.f3860a[this.K] = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return !ChunkSampleStream.this.s() && this.f30860a.K(ChunkSampleStream.this.f3856a);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            if (ChunkSampleStream.this.s()) {
                return 0;
            }
            int iF = this.f30860a.F(j, ChunkSampleStream.this.f3856a);
            if (ChunkSampleStream.this.f3846a != null) {
                iF = Math.min(iF, ChunkSampleStream.this.f3846a.g(this.K + 1) - this.f30860a.D());
            }
            this.f30860a.e0(iF);
            if (iF > 0) {
                a();
            }
            return iF;
        }
    }

    public ChunkSampleStream(int i, @Nullable int[] iArr, @Nullable com.google.android.exoplayer2.d[] dVarArr, T t, SequenceableLoader.Callback<ChunkSampleStream<T>> callback, Allocator allocator, long j, DrmSessionManager drmSessionManager, DrmSessionEventListener.a aVar, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.a aVar2) {
        this.K = i;
        int i2 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f3857a = iArr;
        this.f3858a = dVarArr == null ? new com.google.android.exoplayer2.d[0] : dVarArr;
        this.f3849a = t;
        this.f3845a = callback;
        this.f3843a = aVar2;
        this.f3851a = loadErrorHandlingPolicy;
        this.f3852a = new Loader(f);
        this.f3853a = new uk1();
        ArrayList<BaseMediaChunk> arrayList = new ArrayList<>();
        this.f3854a = arrayList;
        this.f3855a = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f3859a = new SampleQueue[length];
        this.f3860a = new boolean[length];
        int i3 = length + 1;
        int[] iArr2 = new int[i3];
        SampleQueue[] sampleQueueArr = new SampleQueue[i3];
        SampleQueue sampleQueueL = SampleQueue.l(allocator, drmSessionManager, aVar);
        this.f3844a = sampleQueueL;
        iArr2[0] = i;
        sampleQueueArr[0] = sampleQueueL;
        while (i2 < length) {
            SampleQueue sampleQueueM = SampleQueue.m(allocator);
            this.f3859a[i2] = sampleQueueM;
            int i4 = i2 + 1;
            sampleQueueArr[i4] = sampleQueueM;
            iArr2[i4] = this.f3857a[i2];
            i2 = i4;
        }
        this.f3850a = new com.google.android.exoplayer2.source.chunk.a(iArr2, sampleQueueArr);
        this.f30859a = j;
        this.b = j;
    }

    public void B(@Nullable ReleaseCallback<T> releaseCallback) {
        this.f3848a = releaseCallback;
        this.f3844a.R();
        for (SampleQueue sampleQueue : this.f3859a) {
            sampleQueue.R();
        }
        this.f3852a.k(this);
    }

    public final void C() {
        this.f3844a.V();
        for (SampleQueue sampleQueue : this.f3859a) {
            sampleQueue.V();
        }
    }

    public void D(long j) {
        BaseMediaChunk baseMediaChunk;
        boolean Z;
        this.b = j;
        if (s()) {
            this.f30859a = j;
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 < this.f3854a.size()) {
                baseMediaChunk = this.f3854a.get(i2);
                long j2 = ((Chunk) baseMediaChunk).f3841b;
                if (j2 == j && baseMediaChunk.e == -9223372036854775807L) {
                    break;
                } else if (j2 <= j) {
                    i2++;
                }
            }
            baseMediaChunk = null;
            break;
        }
        if (baseMediaChunk != null) {
            Z = this.f3844a.Y(baseMediaChunk.g(0));
        } else {
            Z = this.f3844a.Z(j, j < getNextLoadPositionUs());
        }
        if (Z) {
            this.L = y(this.f3844a.D(), 0);
            SampleQueue[] sampleQueueArr = this.f3859a;
            int length = sampleQueueArr.length;
            while (i < length) {
                sampleQueueArr[i].Z(j, true);
                i++;
            }
            return;
        }
        this.f30859a = j;
        this.f3856a = false;
        this.f3854a.clear();
        this.L = 0;
        if (!this.f3852a.i()) {
            this.f3852a.f();
            C();
            return;
        }
        this.f3844a.s();
        SampleQueue[] sampleQueueArr2 = this.f3859a;
        int length2 = sampleQueueArr2.length;
        while (i < length2) {
            sampleQueueArr2[i].s();
            i++;
        }
        this.f3852a.e();
    }

    public ChunkSampleStream<T>.a E(long j, int i) {
        for (int i2 = 0; i2 < this.f3859a.length; i2++) {
            if (this.f3857a[i2] == i) {
                sb0.i(!this.f3860a[i2]);
                this.f3860a[i2] = true;
                this.f3859a[i2].Z(j, true);
                return new a(this, this.f3859a[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public long a(long j, w38 w38Var) {
        return this.f3849a.a(j, w38Var);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int b(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
        if (s()) {
            return -3;
        }
        BaseMediaChunk baseMediaChunk = this.f3846a;
        if (baseMediaChunk != null && baseMediaChunk.g(0) <= this.f3844a.D()) {
            return -3;
        }
        t();
        return this.f3844a.S(yk3Var, decoderInputBuffer, i, this.f3856a);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        List<BaseMediaChunk> listEmptyList;
        long j2;
        if (this.f3856a || this.f3852a.i() || this.f3852a.h()) {
            return false;
        }
        boolean zS = s();
        if (zS) {
            listEmptyList = Collections.emptyList();
            j2 = this.f30859a;
        } else {
            listEmptyList = this.f3855a;
            j2 = p().c;
        }
        this.f3849a.h(j, j2, listEmptyList, this.f3853a);
        uk1 uk1Var = this.f3853a;
        boolean z = uk1Var.f20085a;
        Chunk chunk = uk1Var.f45163a;
        uk1Var.a();
        if (z) {
            this.f30859a = -9223372036854775807L;
            this.f3856a = true;
            return true;
        }
        if (chunk == null) {
            return false;
        }
        this.f3847a = chunk;
        if (r(chunk)) {
            BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
            if (zS) {
                long j3 = ((Chunk) baseMediaChunk).f3841b;
                long j4 = this.f30859a;
                if (j3 != j4) {
                    this.f3844a.b0(j4);
                    for (SampleQueue sampleQueue : this.f3859a) {
                        sampleQueue.b0(this.f30859a);
                    }
                }
                this.f30859a = -9223372036854775807L;
            }
            baseMediaChunk.h(this.f3850a);
            this.f3854a.add(baseMediaChunk);
        } else if (chunk instanceof d) {
            ((d) chunk).e(this.f3850a);
        }
        this.f3843a.A(new az4(chunk.f3836a, chunk.f3838a, this.f3852a.l(chunk, this, this.f3851a.getMinimumLoadableRetryCount(chunk.f30858a))), chunk.f30858a, this.K, chunk.f3837a, chunk.b, chunk.f3840a, chunk.f3841b, chunk.c);
        return true;
    }

    public void discardBuffer(long j, boolean z) {
        if (s()) {
            return;
        }
        int iY = this.f3844a.y();
        this.f3844a.r(j, z, true);
        int iY2 = this.f3844a.y();
        if (iY2 > iY) {
            long jZ = this.f3844a.z();
            int i = 0;
            while (true) {
                SampleQueue[] sampleQueueArr = this.f3859a;
                if (i >= sampleQueueArr.length) {
                    break;
                }
                sampleQueueArr[i].r(jZ, z, this.f3860a[i]);
                i++;
            }
        }
        l(iY2);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if (this.f3856a) {
            return Long.MIN_VALUE;
        }
        if (s()) {
            return this.f30859a;
        }
        long jMax = this.b;
        BaseMediaChunk baseMediaChunkP = p();
        if (!baseMediaChunkP.f()) {
            if (this.f3854a.size() > 1) {
                ArrayList<BaseMediaChunk> arrayList = this.f3854a;
                baseMediaChunkP = arrayList.get(arrayList.size() - 2);
            } else {
                baseMediaChunkP = null;
            }
        }
        if (baseMediaChunkP != null) {
            jMax = Math.max(jMax, baseMediaChunkP.c);
        }
        return Math.max(jMax, this.f3844a.A());
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (s()) {
            return this.f30859a;
        }
        if (this.f3856a) {
            return Long.MIN_VALUE;
        }
        return p().c;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.f3852a.i();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return !s() && this.f3844a.K(this.f3856a);
    }

    public final void l(int i) {
        int iMin = Math.min(y(i, 0), this.L);
        if (iMin > 0) {
            gj9.m1(this.f3854a, 0, iMin);
            this.L -= iMin;
        }
    }

    public final void m(int i) {
        sb0.i(!this.f3852a.i());
        int size = this.f3854a.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (!q(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j = p().c;
        BaseMediaChunk baseMediaChunkN = n(i);
        if (this.f3854a.isEmpty()) {
            this.f30859a = this.b;
        }
        this.f3856a = false;
        this.f3843a.D(this.K, ((Chunk) baseMediaChunkN).f3841b, j);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
        this.f3852a.maybeThrowError();
        this.f3844a.N();
        if (this.f3852a.i()) {
            return;
        }
        this.f3849a.maybeThrowError();
    }

    public final BaseMediaChunk n(int i) {
        BaseMediaChunk baseMediaChunk = this.f3854a.get(i);
        ArrayList<BaseMediaChunk> arrayList = this.f3854a;
        gj9.m1(arrayList, i, arrayList.size());
        this.L = Math.max(this.L, this.f3854a.size());
        int i2 = 0;
        this.f3844a.w(baseMediaChunk.g(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.f3859a;
            if (i2 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            SampleQueue sampleQueue = sampleQueueArr[i2];
            i2++;
            sampleQueue.w(baseMediaChunk.g(i2));
        }
    }

    public T o() {
        return this.f3849a;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        this.f3844a.T();
        for (SampleQueue sampleQueue : this.f3859a) {
            sampleQueue.T();
        }
        this.f3849a.release();
        ReleaseCallback<T> releaseCallback = this.f3848a;
        if (releaseCallback != null) {
            releaseCallback.b(this);
        }
    }

    public final BaseMediaChunk p() {
        ArrayList<BaseMediaChunk> arrayList = this.f3854a;
        return arrayList.get(arrayList.size() - 1);
    }

    public final boolean q(int i) {
        int iD;
        BaseMediaChunk baseMediaChunk = this.f3854a.get(i);
        if (this.f3844a.D() > baseMediaChunk.g(0)) {
            return true;
        }
        int i2 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.f3859a;
            if (i2 >= sampleQueueArr.length) {
                return false;
            }
            iD = sampleQueueArr[i2].D();
            i2++;
        } while (iD <= baseMediaChunk.g(i2));
        return true;
    }

    public final boolean r(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        if (this.f3852a.h() || s()) {
            return;
        }
        if (!this.f3852a.i()) {
            int preferredQueueSize = this.f3849a.getPreferredQueueSize(j, this.f3855a);
            if (preferredQueueSize < this.f3854a.size()) {
                m(preferredQueueSize);
                return;
            }
            return;
        }
        Chunk chunk = (Chunk) sb0.g(this.f3847a);
        if (!(r(chunk) && q(this.f3854a.size() - 1)) && this.f3849a.e(j, chunk, this.f3855a)) {
            this.f3852a.e();
            if (r(chunk)) {
                this.f3846a = (BaseMediaChunk) chunk;
            }
        }
    }

    public boolean s() {
        return this.f30859a != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j) {
        if (s()) {
            return 0;
        }
        int iF = this.f3844a.F(j, this.f3856a);
        BaseMediaChunk baseMediaChunk = this.f3846a;
        if (baseMediaChunk != null) {
            iF = Math.min(iF, baseMediaChunk.g(0) - this.f3844a.D());
        }
        this.f3844a.e0(iF);
        t();
        return iF;
    }

    public final void t() {
        int iY = y(this.f3844a.D(), this.L - 1);
        while (true) {
            int i = this.L;
            if (i > iY) {
                return;
            }
            this.L = i + 1;
            u(i);
        }
    }

    public final void u(int i) {
        BaseMediaChunk baseMediaChunk = this.f3854a.get(i);
        com.google.android.exoplayer2.d dVar = ((Chunk) baseMediaChunk).f3837a;
        if (!dVar.equals(this.f3842a)) {
            this.f3843a.i(this.K, dVar, ((Chunk) baseMediaChunk).b, ((Chunk) baseMediaChunk).f3840a, ((Chunk) baseMediaChunk).f3841b);
        }
        this.f3842a = dVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void M(Chunk chunk, long j, long j2, boolean z) {
        this.f3847a = null;
        this.f3846a = null;
        az4 az4Var = new az4(chunk.f3836a, chunk.f3838a, chunk.d(), chunk.c(), j, j2, chunk.a());
        this.f3851a.onLoadTaskConcluded(chunk.f3836a);
        this.f3843a.r(az4Var, chunk.f30858a, this.K, chunk.f3837a, chunk.b, chunk.f3840a, chunk.f3841b, chunk.c);
        if (z) {
            return;
        }
        if (s()) {
            C();
        } else if (r(chunk)) {
            n(this.f3854a.size() - 1);
            if (this.f3854a.isEmpty()) {
                this.f30859a = this.b;
            }
        }
        this.f3845a.d(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void K(Chunk chunk, long j, long j2) {
        this.f3847a = null;
        this.f3849a.f(chunk);
        az4 az4Var = new az4(chunk.f3836a, chunk.f3838a, chunk.d(), chunk.c(), j, j2, chunk.a());
        this.f3851a.onLoadTaskConcluded(chunk.f3836a);
        this.f3843a.u(az4Var, chunk.f30858a, this.K, chunk.f3837a, chunk.b, chunk.f3840a, chunk.f3841b, chunk.c);
        this.f3845a.d(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public Loader.b A(Chunk chunk, long j, long j2, IOException iOException, int i) {
        Loader.b bVarG;
        long jA = chunk.a();
        boolean zR = r(chunk);
        int size = this.f3854a.size() - 1;
        boolean z = (jA != 0 && zR && q(size)) ? false : true;
        az4 az4Var = new az4(chunk.f3836a, chunk.f3838a, chunk.d(), chunk.c(), j, j2, jA);
        LoadErrorHandlingPolicy.c cVar = new LoadErrorHandlingPolicy.c(az4Var, new oh5(chunk.f30858a, this.K, chunk.f3837a, chunk.b, chunk.f3840a, gj9.H1(chunk.f3841b), gj9.H1(chunk.c)), iOException, i);
        if (!this.f3849a.d(chunk, z, cVar, this.f3851a)) {
            bVarG = null;
        } else if (z) {
            bVarG = Loader.f5050c;
            if (zR) {
                sb0.i(n(size) == chunk);
                if (this.f3854a.isEmpty()) {
                    this.f30859a = this.b;
                }
            }
        } else {
            Log.n(f, "Ignoring attempt to cancel non-cancelable load.");
            bVarG = null;
        }
        if (bVarG == null) {
            long jB = this.f3851a.b(cVar);
            bVarG = jB != -9223372036854775807L ? Loader.g(false, jB) : Loader.f5051d;
        }
        boolean z2 = !bVarG.c();
        this.f3843a.w(az4Var, chunk.f30858a, this.K, chunk.f3837a, chunk.b, chunk.f3840a, chunk.f3841b, chunk.c, iOException, z2);
        if (z2) {
            this.f3847a = null;
            this.f3851a.onLoadTaskConcluded(chunk.f3836a);
            this.f3845a.d(this);
        }
        return bVarG;
    }

    public final int y(int i, int i2) {
        do {
            i2++;
            if (i2 >= this.f3854a.size()) {
                return this.f3854a.size() - 1;
            }
        } while (this.f3854a.get(i2).g(0) <= i);
        return i2 - 1;
    }

    public void z() {
        B(null);
    }
}
