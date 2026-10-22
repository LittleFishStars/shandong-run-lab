package com.google.android.exoplayer2.source.smoothstreaming;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.w38;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<SsChunkSource>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DrmSessionEventListener.a f30991a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionManager f4468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CompositeSequenceableLoaderFactory f4469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaPeriod.Callback f4470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSourceEventListener.a f4471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SequenceableLoader f4472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SsChunkSource.Factory f4473a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f4474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Allocator f4475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f4476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoaderErrorThrower f4477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TransferListener f4478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ga9 f4479a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ChunkSampleStream<SsChunkSource>[] f4480a;

    public b(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, SsChunkSource.Factory factory, @Nullable TransferListener transferListener, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, DrmSessionEventListener.a aVar2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.a aVar3, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        this.f4474a = aVar;
        this.f4473a = factory;
        this.f4478a = transferListener;
        this.f4477a = loaderErrorThrower;
        this.f4468a = drmSessionManager;
        this.f30991a = aVar2;
        this.f4476a = loadErrorHandlingPolicy;
        this.f4471a = aVar3;
        this.f4475a = allocator;
        this.f4469a = compositeSequenceableLoaderFactory;
        this.f4479a = g(aVar, drmSessionManager);
        ChunkSampleStream<SsChunkSource>[] chunkSampleStreamArrI = i(0);
        this.f4480a = chunkSampleStreamArrI;
        this.f4472a = compositeSequenceableLoaderFactory.a(chunkSampleStreamArrI);
    }

    public static ga9 g(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, DrmSessionManager drmSessionManager) {
        da9[] da9VarArr = new da9[aVar.f4503a.length];
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b[] bVarArr = aVar.f4503a;
            if (i >= bVarArr.length) {
                return new ga9(da9VarArr);
            }
            d[] dVarArr = bVarArr[i].f4511a;
            d[] dVarArr2 = new d[dVarArr.length];
            for (int i2 = 0; i2 < dVarArr.length; i2++) {
                d dVar = dVarArr[i2];
                dVarArr2[i2] = dVar.d(drmSessionManager.a(dVar));
            }
            da9VarArr[i] = new da9(Integer.toString(i), dVarArr2);
            i++;
        }
    }

    public static ChunkSampleStream<SsChunkSource>[] i(int i) {
        return new ChunkSampleStream[i];
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long a(long j, w38 w38Var) {
        for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.f4480a) {
            if (chunkSampleStream.K == 2) {
                return chunkSampleStream.a(j, w38Var);
            }
        }
        return j;
    }

    public final ChunkSampleStream<SsChunkSource> b(ExoTrackSelection exoTrackSelection, long j) {
        int iC = this.f4479a.c(exoTrackSelection.d());
        return new ChunkSampleStream<>(this.f4474a.f4503a[iC].f31000a, null, null, this.f4473a.a(this.f4477a, this.f4474a, iC, exoTrackSelection, this.f4478a), this, this.f4475a, j, this.f4468a, this.f30991a, this.f4476a, this.f4471a);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void c(MediaPeriod.Callback callback, long j) {
        this.f4470a = callback;
        callback.h(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.f4472a.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.f4480a) {
            chunkSampleStream.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public ga9 e() {
        return this.f4479a;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long f(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        ExoTrackSelection exoTrackSelection;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < exoTrackSelectionArr.length; i++) {
            SampleStream sampleStream = sampleStreamArr[i];
            if (sampleStream != null) {
                ChunkSampleStream chunkSampleStream = (ChunkSampleStream) sampleStream;
                if (exoTrackSelectionArr[i] == null || !zArr[i]) {
                    chunkSampleStream.z();
                    sampleStreamArr[i] = null;
                } else {
                    ((SsChunkSource) chunkSampleStream.o()).b(exoTrackSelectionArr[i]);
                    arrayList.add(chunkSampleStream);
                }
            }
            if (sampleStreamArr[i] == null && (exoTrackSelection = exoTrackSelectionArr[i]) != null) {
                ChunkSampleStream<SsChunkSource> chunkSampleStreamB = b(exoTrackSelection, j);
                arrayList.add(chunkSampleStreamB);
                sampleStreamArr[i] = chunkSampleStreamB;
                zArr2[i] = true;
            }
        }
        ChunkSampleStream<SsChunkSource>[] chunkSampleStreamArrI = i(arrayList.size());
        this.f4480a = chunkSampleStreamArrI;
        arrayList.toArray(chunkSampleStreamArrI);
        this.f4472a = this.f4469a.a(this.f4480a);
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.f4472a.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.f4472a.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ExoTrackSelection exoTrackSelection = list.get(i);
            int iC = this.f4479a.c(exoTrackSelection.d());
            for (int i2 = 0; i2 < exoTrackSelection.length(); i2++) {
                arrayList.add(new StreamKey(iC, exoTrackSelection.getIndexInTrackGroup(i2)));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.f4472a.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void d(ChunkSampleStream<SsChunkSource> chunkSampleStream) {
        this.f4470a.d(this);
    }

    public void k() {
        for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.f4480a) {
            chunkSampleStream.z();
        }
        this.f4470a = null;
    }

    public void l(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        this.f4474a = aVar;
        for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.f4480a) {
            ((SsChunkSource) chunkSampleStream.o()).g(aVar);
        }
        this.f4470a.d(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.f4477a.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.f4472a.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.f4480a) {
            chunkSampleStream.D(j);
        }
        return j;
    }
}
