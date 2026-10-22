package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class MediaChunk extends Chunk {
    public final long d;

    public MediaChunk(DataSource dataSource, DataSpec dataSpec, com.google.android.exoplayer2.d dVar, int i, @Nullable Object obj, long j, long j2, long j3) {
        super(dataSource, dataSpec, 1, dVar, i, obj, j, j2);
        sb0.g(dVar);
        this.d = j3;
    }

    public long e() {
        long j = this.d;
        if (j != -1) {
            return 1 + j;
        }
        return -1L;
    }

    public abstract boolean f();
}
