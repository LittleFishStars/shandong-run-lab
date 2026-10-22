package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.b;
import com.google.android.exoplayer2.upstream.DataReader;
import com.zj.adlib.at6;
import com.zj.adlib.bp5;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements ExtractorOutput, ChunkExtractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChunkExtractor.Factory f30864a = new ChunkExtractor.Factory() { // from class: com.zj.adlib.c51
        @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor.Factory
        public final ChunkExtractor a(int i, d dVar, boolean z, List list, TrackOutput trackOutput, at6 at6Var) {
            return b.h(i, dVar, z, list, trackOutput, at6Var);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final iv6 f3866a = new iv6();
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<a> f3868a = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.d f3869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Extractor f3870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SeekMap f3871a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ChunkExtractor.TrackOutputProvider f3872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.d[] f3874a;

    public static final class a implements TrackOutput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30865a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final com.google.android.exoplayer2.d f3875a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TrackOutput f3876a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.android.exoplayer2.extractor.d f3877a = new com.google.android.exoplayer2.extractor.d();
        public com.google.android.exoplayer2.d b;
        public final int d;
        public final int e;

        public a(int i, int i2, @Nullable com.google.android.exoplayer2.d dVar) {
            this.d = i;
            this.e = i2;
            this.f3875a = dVar;
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void a(om6 om6Var, int i, int i2) {
            ((TrackOutput) gj9.k(this.f3876a)).c(om6Var, i);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public int d(DataReader dataReader, int i, boolean z, int i2) throws IOException {
            return ((TrackOutput) gj9.k(this.f3876a)).b(dataReader, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void e(long j, int i, int i2, int i3, @Nullable TrackOutput.a aVar) {
            long j2 = this.f30865a;
            if (j2 != -9223372036854775807L && j >= j2) {
                this.f3876a = this.f3877a;
            }
            ((TrackOutput) gj9.k(this.f3876a)).e(j, i, i2, i3, aVar);
        }

        @Override // com.google.android.exoplayer2.extractor.TrackOutput
        public void f(com.google.android.exoplayer2.d dVar) {
            com.google.android.exoplayer2.d dVar2 = this.f3875a;
            if (dVar2 != null) {
                dVar = dVar.A(dVar2);
            }
            this.b = dVar;
            ((TrackOutput) gj9.k(this.f3876a)).f(this.b);
        }

        public void g(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider, long j) {
            if (trackOutputProvider == null) {
                this.f3876a = this.f3877a;
                return;
            }
            this.f30865a = j;
            TrackOutput trackOutputB = trackOutputProvider.b(this.d, this.e);
            this.f3876a = trackOutputB;
            com.google.android.exoplayer2.d dVar = this.b;
            if (dVar != null) {
                trackOutputB.f(dVar);
            }
        }
    }

    public b(Extractor extractor, int i, com.google.android.exoplayer2.d dVar) {
        this.f3870a = extractor;
        this.K = i;
        this.f3869a = dVar;
    }

    public static /* synthetic */ ChunkExtractor h(int i, com.google.android.exoplayer2.d dVar, boolean z, List list, TrackOutput trackOutput, at6 at6Var) {
        Extractor fragmentedMp4Extractor;
        String str = dVar.j;
        if (bp5.s(str)) {
            return null;
        }
        if (bp5.r(str)) {
            fragmentedMp4Extractor = new MatroskaExtractor(1);
        } else {
            fragmentedMp4Extractor = new FragmentedMp4Extractor(z ? 4 : 0, null, null, list, trackOutput);
        }
        return new b(fragmentedMp4Extractor, i, dVar);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public boolean a(ExtractorInput extractorInput) throws IOException {
        int iC = this.f3870a.c(extractorInput, f3866a);
        sb0.i(iC != 1);
        return iC == 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput b(int i, int i2) {
        a aVar = this.f3868a.get(i);
        if (aVar == null) {
            sb0.i(this.f3874a == null);
            aVar = new a(i, i2, i2 == this.K ? this.f3869a : null);
            aVar.g(this.f3872a, this.f3867a);
            this.f3868a.put(i, aVar);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void c(@Nullable ChunkExtractor.TrackOutputProvider trackOutputProvider, long j, long j2) {
        this.f3872a = trackOutputProvider;
        this.f3867a = j2;
        if (!this.f3873a) {
            this.f3870a.b(this);
            if (j != -9223372036854775807L) {
                this.f3870a.seek(0L, j);
            }
            this.f3873a = true;
            return;
        }
        Extractor extractor = this.f3870a;
        if (j == -9223372036854775807L) {
            j = 0;
        }
        extractor.seek(0L, j);
        for (int i = 0; i < this.f3868a.size(); i++) {
            this.f3868a.valueAt(i).g(trackOutputProvider, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void d(SeekMap seekMap) {
        this.f3871a = seekMap;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    @Nullable
    public com.google.android.exoplayer2.d[] e() {
        return this.f3874a;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        com.google.android.exoplayer2.d[] dVarArr = new com.google.android.exoplayer2.d[this.f3868a.size()];
        for (int i = 0; i < this.f3868a.size(); i++) {
            dVarArr[i] = (com.google.android.exoplayer2.d) sb0.k(this.f3868a.valueAt(i).b);
        }
        this.f3874a = dVarArr;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    @Nullable
    public com.google.android.exoplayer2.extractor.b f() {
        SeekMap seekMap = this.f3871a;
        if (seekMap instanceof com.google.android.exoplayer2.extractor.b) {
            return (com.google.android.exoplayer2.extractor.b) seekMap;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractor
    public void release() {
        this.f3870a.release();
    }
}
