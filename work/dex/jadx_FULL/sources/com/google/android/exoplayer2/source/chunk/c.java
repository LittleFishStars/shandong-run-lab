package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.zj.adlib.ar8;
import com.zj.adlib.d72;
import com.zj.adlib.zf2;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c extends BaseMediaChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChunkExtractor f30866a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f3878a;
    public boolean b;
    public final int c;
    public final long g;
    public long h;

    public c(DataSource dataSource, DataSpec dataSpec, com.google.android.exoplayer2.d dVar, int i, @Nullable Object obj, long j, long j2, long j3, long j4, long j5, int i2, long j6, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, dVar, i, obj, j, j2, j3, j4, j5);
        this.c = i2;
        this.g = j6;
        this.f30866a = chunkExtractor;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.f3878a = true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public long e() {
        return this.d + ((long) this.c);
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean f() {
        return this.b;
    }

    public ChunkExtractor.TrackOutputProvider getTrackOutputProvider(a aVar) {
        return aVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws IOException {
        if (this.h == 0) {
            a output = getOutput();
            output.c(this.g);
            ChunkExtractor chunkExtractor = this.f30866a;
            ChunkExtractor.TrackOutputProvider trackOutputProvider = getTrackOutputProvider(output);
            long j = this.e;
            long j2 = j == -9223372036854775807L ? -9223372036854775807L : j - this.g;
            long j3 = this.f;
            chunkExtractor.c(trackOutputProvider, j2, j3 == -9223372036854775807L ? -9223372036854775807L : j3 - this.g);
        }
        try {
            DataSpec dataSpecE = ((Chunk) this).f3838a.e(this.h);
            ar8 ar8Var = ((Chunk) this).f3839a;
            zf2 zf2Var = new zf2(ar8Var, dataSpecE.f5032c, ar8Var.a(dataSpecE));
            do {
                try {
                    if (this.f3878a) {
                        break;
                    }
                } catch (Throwable th) {
                    this.h = zf2Var.getPosition() - ((Chunk) this).f3838a.f5032c;
                    throw th;
                }
            } while (this.f30866a.a(zf2Var));
            this.h = zf2Var.getPosition() - ((Chunk) this).f3838a.f5032c;
            d72.a(((Chunk) this).f3839a);
            this.b = !this.f3878a;
        } catch (Throwable th2) {
            d72.a(((Chunk) this).f3839a);
            throw th2;
        }
    }
}
