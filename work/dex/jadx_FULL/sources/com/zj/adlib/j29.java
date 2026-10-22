package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j29 implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f42493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSink f17314a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource f17315a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17316a;

    public j29(DataSource dataSource, DataSink dataSink) {
        this.f17315a = (DataSource) sb0.g(dataSource);
        this.f17314a = (DataSink) sb0.g(dataSink);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws IOException {
        long jA = this.f17315a.a(dataSpec);
        this.f42493a = jA;
        if (jA == 0) {
            return 0L;
        }
        if (dataSpec.f5033d == -1 && jA != -1) {
            dataSpec = dataSpec.f(0L, jA);
        }
        this.f17316a = true;
        this.f17314a.a(dataSpec);
        return this.f42493a;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void b(TransferListener transferListener) {
        sb0.g(transferListener);
        this.f17315a.b(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        try {
            this.f17315a.close();
        } finally {
            if (this.f17316a) {
                this.f17316a = false;
                this.f17314a.close();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return this.f17315a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f17315a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f42493a == 0) {
            return -1;
        }
        int i3 = this.f17315a.read(bArr, i, i2);
        if (i3 > 0) {
            this.f17314a.write(bArr, i, i3);
            long j = this.f42493a;
            if (j != -1) {
                this.f42493a = j - ((long) i3);
            }
        }
        return i3;
    }
}
