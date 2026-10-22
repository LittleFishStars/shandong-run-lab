package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseMediaChunk extends MediaChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f30856a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f3835a;
    public final long e;
    public final long f;

    public BaseMediaChunk(DataSource dataSource, DataSpec dataSpec, com.google.android.exoplayer2.d dVar, int i, @Nullable Object obj, long j, long j2, long j3, long j4, long j5) {
        super(dataSource, dataSpec, dVar, i, obj, j, j2, j5);
        this.e = j3;
        this.f = j4;
    }

    public final int g(int i) {
        return ((int[]) sb0.k(this.f3835a))[i];
    }

    public final a getOutput() {
        return (a) sb0.k(this.f30856a);
    }

    public void h(a aVar) {
        this.f30856a = aVar;
        this.f3835a = aVar.a();
    }
}
