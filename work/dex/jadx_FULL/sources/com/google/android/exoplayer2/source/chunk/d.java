package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.zj.adlib.ar8;
import com.zj.adlib.d72;
import com.zj.adlib.zf2;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d extends Chunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChunkExtractor.TrackOutputProvider f30867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ChunkExtractor f3879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f3880a;
    public long d;

    public d(DataSource dataSource, DataSpec dataSpec, com.google.android.exoplayer2.d dVar, int i, @Nullable Object obj, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, 2, dVar, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.f3879a = chunkExtractor;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.f3880a = true;
    }

    public void e(ChunkExtractor.TrackOutputProvider trackOutputProvider) {
        this.f30867a = trackOutputProvider;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws IOException {
        if (this.d == 0) {
            this.f3879a.c(this.f30867a, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            DataSpec dataSpecE = ((Chunk) this).f3838a.e(this.d);
            ar8 ar8Var = ((Chunk) this).f3839a;
            zf2 zf2Var = new zf2(ar8Var, dataSpecE.f5032c, ar8Var.a(dataSpecE));
            while (!this.f3880a && this.f3879a.a(zf2Var)) {
                try {
                } catch (Throwable th) {
                    this.d = zf2Var.getPosition() - ((Chunk) this).f3838a.f5032c;
                    throw th;
                }
            }
            this.d = zf2Var.getPosition() - ((Chunk) this).f3838a.f5032c;
            d72.a(((Chunk) this).f3839a);
        } catch (Throwable th2) {
            d72.a(((Chunk) this).f3839a);
            throw th2;
        }
    }
}
