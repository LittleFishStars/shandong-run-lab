package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class q20 implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataSource f44108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public r20 f18990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f18991a;

    public q20(byte[] bArr, DataSource dataSource) {
        this.f44108a = dataSource;
        this.f18991a = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws IOException {
        long jA = this.f44108a.a(dataSpec);
        this.f18990a = new r20(2, this.f18991a, dataSpec.f5028a, dataSpec.f5025a + dataSpec.f5032c);
        return jA;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void b(TransferListener transferListener) {
        sb0.g(transferListener);
        this.f44108a.b(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        this.f18990a = null;
        this.f44108a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return this.f44108a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f44108a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.f44108a.read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        ((r20) gj9.k(this.f18990a)).d(bArr, i, i3);
        return i3;
    }
}
