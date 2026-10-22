package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunk;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.a;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qi8 extends BaseMediaChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f44218a;
    public final d b;
    public final int c;
    public long g;

    public qi8(DataSource dataSource, DataSpec dataSpec, d dVar, int i, @Nullable Object obj, long j, long j2, long j3, int i2, d dVar2) {
        super(dataSource, dataSpec, dVar, i, obj, j, j2, -9223372036854775807L, -9223372036854775807L, j3);
        this.c = i2;
        this.b = dVar2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean f() {
        return this.f44218a;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws IOException {
        a output = getOutput();
        output.c(0L);
        TrackOutput trackOutputB = output.b(0, this.c);
        trackOutputB.f(this.b);
        try {
            long jA = ((Chunk) this).f3839a.a(((Chunk) this).f3838a.e(this.g));
            if (jA != -1) {
                jA += this.g;
            }
            zf2 zf2Var = new zf2(((Chunk) this).f3839a, this.g, jA);
            for (int iB = 0; iB != -1; iB = trackOutputB.b(zf2Var, Integer.MAX_VALUE, true)) {
                this.g += (long) iB;
            }
            trackOutputB.e(((Chunk) this).f3841b, 1, (int) this.g, 0, null);
            d72.a(((Chunk) this).f3839a);
            this.f44218a = true;
        } catch (Throwable th) {
            d72.a(((Chunk) this).f3839a);
            throw th;
        }
    }
}
