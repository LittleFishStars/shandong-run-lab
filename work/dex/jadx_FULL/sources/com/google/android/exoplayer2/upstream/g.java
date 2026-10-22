package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.g;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final g f5224a = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DataSource.Factory f31148a = new DataSource.Factory() { // from class: com.zj.adlib.bs6
        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public final DataSource a() {
            return g.d();
        }
    };

    public static /* synthetic */ g d() {
        return new g();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void b(TransferListener transferListener) {
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
