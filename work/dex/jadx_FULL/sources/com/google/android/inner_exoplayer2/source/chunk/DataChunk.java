package com.google.android.inner_exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.Format;
import com.google.android.inner_exoplayer2.upstream.DataSource;
import com.google.android.inner_exoplayer2.upstream.DataSourceUtil;
import com.google.android.inner_exoplayer2.upstream.DataSpec;
import com.google.android.inner_exoplayer2.util.Util;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class DataChunk extends Chunk {
    private static final int READ_GRANULARITY = 16384;
    private byte[] data;
    private volatile boolean loadCanceled;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i, Format format, int i2, @Nullable Object obj, @Nullable byte[] bArr) {
        super(dataSource, dataSpec, i, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.data = bArr == null ? Util.EMPTY_BYTE_ARRAY : bArr;
    }

    private void maybeExpandData(int i) {
        byte[] bArr = this.data;
        if (bArr.length < i + 16384) {
            this.data = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // com.google.android.inner_exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public abstract void consume(byte[] bArr, int i);

    public byte[] getDataHolder() {
        return this.data;
    }

    @Override // com.google.android.inner_exoplayer2.upstream.Loader.Loadable
    public final void load() {
        try {
            this.dataSource.open(this.dataSpec);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.loadCanceled) {
                maybeExpandData(i2);
                i = this.dataSource.read(this.data, i2, 16384);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.loadCanceled) {
                consume(this.data, i2);
            }
        } finally {
            DataSourceUtil.closeQuietly(this.dataSource);
        }
    }
}
