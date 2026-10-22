package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.zj.adlib.uk1;
import com.zj.adlib.w38;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ChunkSource {
    long a(long j, w38 w38Var);

    boolean d(Chunk chunk, boolean z, LoadErrorHandlingPolicy.c cVar, LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    boolean e(long j, Chunk chunk, List<? extends MediaChunk> list);

    void f(Chunk chunk);

    int getPreferredQueueSize(long j, List<? extends MediaChunk> list);

    void h(long j, long j2, List<? extends MediaChunk> list, uk1 uk1Var);

    void maybeThrowError() throws IOException;

    void release();
}
