package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ResolvingDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataSource f31122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Resolver f5073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5074a;

    public interface Resolver {
        DataSpec a(DataSpec dataSpec) throws IOException;

        default Uri resolveReportedUri(Uri uri) {
            return uri;
        }
    }

    public static final class a implements DataSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataSource.Factory f31123a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Resolver f5075a;

        public a(DataSource.Factory factory, Resolver resolver) {
            this.f31123a = factory;
            this.f5075a = resolver;
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ResolvingDataSource a() {
            return new ResolvingDataSource(this.f31123a.a(), this.f5075a);
        }
    }

    public ResolvingDataSource(DataSource dataSource, Resolver resolver) {
        this.f31122a = dataSource;
        this.f5073a = resolver;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws IOException {
        DataSpec dataSpecA = this.f5073a.a(dataSpec);
        this.f5074a = true;
        return this.f31122a.a(dataSpecA);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void b(TransferListener transferListener) {
        sb0.g(transferListener);
        this.f31122a.b(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        if (this.f5074a) {
            this.f5074a = false;
            this.f31122a.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return this.f31122a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        Uri uri = this.f31122a.getUri();
        if (uri == null) {
            return null;
        }
        return this.f5073a.resolveReportedUri(uri);
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f31122a.read(bArr, i, i2);
    }
}
