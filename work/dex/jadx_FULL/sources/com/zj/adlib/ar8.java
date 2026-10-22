package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ar8 implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f40594a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource f15383a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Uri f15382a = Uri.EMPTY;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, List<String>> f15384a = Collections.emptyMap();

    public ar8(DataSource dataSource) {
        this.f15383a = (DataSource) sb0.g(dataSource);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws IOException {
        this.f15382a = dataSpec.f5026a;
        this.f15384a = Collections.emptyMap();
        long jA = this.f15383a.a(dataSpec);
        this.f15382a = (Uri) sb0.g(getUri());
        this.f15384a = getResponseHeaders();
        return jA;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void b(TransferListener transferListener) {
        sb0.g(transferListener);
        this.f15383a.b(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        this.f15383a.close();
    }

    public long d() {
        return this.f40594a;
    }

    public Uri g() {
        return this.f15382a;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return this.f15383a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f15383a.getUri();
    }

    public Map<String, List<String>> h() {
        return this.f15384a;
    }

    public void i() {
        this.f40594a = 0L;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f15383a.read(bArr, i, i2);
        if (i3 != -1) {
            this.f40594a += (long) i3;
        }
        return i3;
    }
}
