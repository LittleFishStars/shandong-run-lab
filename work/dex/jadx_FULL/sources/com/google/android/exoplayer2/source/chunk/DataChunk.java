package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.zj.adlib.d72;
import com.zj.adlib.gj9;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class DataChunk extends Chunk {
    public static final int c = 16384;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f30861a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f3863a;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i, com.google.android.exoplayer2.d dVar, int i2, @Nullable Object obj, @Nullable byte[] bArr) {
        super(dataSource, dataSpec, i, dVar, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.f3863a = bArr == null ? gj9.f16790a : bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.f30861a = true;
    }

    public abstract void consume(byte[] bArr, int i) throws IOException;

    public byte[] e() {
        return this.f3863a;
    }

    public final void f(int i) {
        byte[] bArr = this.f3863a;
        if (bArr.length < i + 16384) {
            this.f3863a = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws IOException {
        try {
            ((Chunk) this).f3839a.a(((Chunk) this).f3838a);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.f30861a) {
                f(i2);
                i = ((Chunk) this).f3839a.read(this.f3863a, i2, 16384);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.f30861a) {
                consume(this.f3863a, i2);
            }
        } finally {
            d72.a(((Chunk) this).f3839a);
        }
    }
}
