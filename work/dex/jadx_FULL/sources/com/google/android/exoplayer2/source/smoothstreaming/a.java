package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.c;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.sb0;
import com.zj.adlib.uk1;
import com.zj.adlib.w38;
import com.zj.adlib.z99;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a implements SsChunkSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f4461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExoTrackSelection f4462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource f4463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoaderErrorThrower f4464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public IOException f4465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ChunkExtractor[] f4466a;
    public int b;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a, reason: collision with other inner class name */
    public static final class C0692a implements SsChunkSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataSource.Factory f30989a;

        public C0692a(DataSource.Factory factory) {
            this.f30989a = factory;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory
        public SsChunkSource a(LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, ExoTrackSelection exoTrackSelection, @Nullable TransferListener transferListener) {
            DataSource dataSourceA = this.f30989a.a();
            if (transferListener != null) {
                dataSourceA.b(transferListener);
            }
            return new a(loaderErrorThrower, aVar, i, exoTrackSelection, dataSourceA);
        }
    }

    public static final class b extends BaseMediaChunkIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30990a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b f4467a;

        public b(com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar, int i, int i2) {
            super(i2, bVar.f4517f - 1);
            this.f4467a = bVar;
            this.f30990a = i;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public DataSpec a() {
            checkInBounds();
            return new DataSpec(this.f4467a.a(this.f30990a, (int) getCurrentIndex()));
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            return getChunkStartTimeUs() + this.f4467a.c((int) getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.f4467a.e((int) getCurrentIndex());
        }
    }

    public a(LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i, ExoTrackSelection exoTrackSelection, DataSource dataSource) {
        this.f4464a = loaderErrorThrower;
        this.f4461a = aVar;
        this.f30988a = i;
        this.f4462a = exoTrackSelection;
        this.f4463a = dataSource;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar = aVar.f4503a[i];
        this.f4466a = new ChunkExtractor[exoTrackSelection.length()];
        int i2 = 0;
        while (i2 < this.f4466a.length) {
            int indexInTrackGroup = exoTrackSelection.getIndexInTrackGroup(i2);
            d dVar = bVar.f4511a[indexInTrackGroup];
            z99[] z99VarArr = dVar.f2566a != null ? ((com.google.android.exoplayer2.source.smoothstreaming.manifest.a.C0693a) sb0.g(aVar.f4501a)).f4506a : null;
            int i3 = bVar.f31000a;
            int i4 = i2;
            this.f4466a[i4] = new com.google.android.exoplayer2.source.chunk.b(new FragmentedMp4Extractor(3, null, new Track(indexInTrackGroup, i3, bVar.f4507a, -9223372036854775807L, aVar.f4500a, dVar, 0, z99VarArr, i3 == 2 ? 4 : 0, null, null)), bVar.f31000a, dVar);
            i2 = i4 + 1;
        }
    }

    public static MediaChunk i(d dVar, DataSource dataSource, Uri uri, int i, long j, long j2, long j3, int i2, @Nullable Object obj, ChunkExtractor chunkExtractor) {
        return new c(dataSource, new DataSpec(uri), dVar, i2, obj, j, j2, j3, -9223372036854775807L, i, 1, j, chunkExtractor);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long a(long j, w38 w38Var) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar = this.f4461a.f4503a[this.f30988a];
        int iD = bVar.d(j);
        long jE = bVar.e(iD);
        return w38Var.a(j, jE, (jE >= j || iD >= bVar.f4517f + (-1)) ? jE : bVar.e(iD + 1));
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void b(ExoTrackSelection exoTrackSelection) {
        this.f4462a = exoTrackSelection;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean d(Chunk chunk, boolean z, LoadErrorHandlingPolicy.c cVar, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.b bVarA = loadErrorHandlingPolicy.a(TrackSelectionUtil.c(this.f4462a), cVar);
        if (z && bVarA != null && bVarA.f31114a == 2) {
            ExoTrackSelection exoTrackSelection = this.f4462a;
            if (exoTrackSelection.blacklist(exoTrackSelection.b(chunk.f3837a), bVarA.f5043a)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean e(long j, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.f4465a != null) {
            return false;
        }
        return this.f4462a.f(j, chunk, list);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void f(Chunk chunk) {
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void g(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b[] bVarArr = this.f4461a.f4503a;
        int i = this.f30988a;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar = bVarArr[i];
        int i2 = bVar.f4517f;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar2 = aVar.f4503a[i];
        if (i2 == 0 || bVar2.f4517f == 0) {
            this.b += i2;
        } else {
            int i3 = i2 - 1;
            long jE = bVar.e(i3) + bVar.c(i3);
            long jE2 = bVar2.e(0);
            if (jE <= jE2) {
                this.b += i2;
            } else {
                this.b += bVar.d(jE2);
            }
        }
        this.f4461a = aVar;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j, List<? extends MediaChunk> list) {
        return (this.f4465a != null || this.f4462a.length() < 2) ? list.size() : this.f4462a.evaluateQueueSize(j, list);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public final void h(long j, long j2, List<? extends MediaChunk> list, uk1 uk1Var) {
        int iE;
        long j3 = j2;
        if (this.f4465a != null) {
            return;
        }
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f4461a;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar = aVar.f4503a[this.f30988a];
        if (bVar.f4517f == 0) {
            uk1Var.f20085a = !aVar.f4502a;
            return;
        }
        if (list.isEmpty()) {
            iE = bVar.d(j3);
        } else {
            iE = (int) (list.get(list.size() - 1).e() - ((long) this.b));
            if (iE < 0) {
                this.f4465a = new BehindLiveWindowException();
                return;
            }
        }
        if (iE >= bVar.f4517f) {
            uk1Var.f20085a = !this.f4461a.f4502a;
            return;
        }
        long j4 = j3 - j;
        long j5 = j(j);
        int length = this.f4462a.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        for (int i = 0; i < length; i++) {
            mediaChunkIteratorArr[i] = new b(bVar, this.f4462a.getIndexInTrackGroup(i), iE);
        }
        this.f4462a.c(j, j4, j5, list, mediaChunkIteratorArr);
        long jE = bVar.e(iE);
        long jC = jE + bVar.c(iE);
        if (!list.isEmpty()) {
            j3 = -9223372036854775807L;
        }
        long j6 = j3;
        int i2 = iE + this.b;
        int selectedIndex = this.f4462a.getSelectedIndex();
        uk1Var.f45163a = i(this.f4462a.a(), this.f4463a, bVar.a(this.f4462a.getIndexInTrackGroup(selectedIndex), iE), i2, jE, jC, j6, this.f4462a.getSelectionReason(), this.f4462a.getSelectionData(), this.f4466a[selectedIndex]);
    }

    public final long j(long j) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f4461a;
        if (!aVar.f4502a) {
            return -9223372036854775807L;
        }
        com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar = aVar.f4503a[this.f30988a];
        int i = bVar.f4517f - 1;
        return (bVar.e(i) + bVar.c(i)) - j;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws IOException {
        IOException iOException = this.f4465a;
        if (iOException != null) {
            throw iOException;
        }
        this.f4464a.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void release() {
        for (ChunkExtractor chunkExtractor : this.f4466a) {
            chunkExtractor.release();
        }
    }
}
