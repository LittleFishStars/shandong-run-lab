package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource f5225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PriorityTaskManager f5226a;

    public static final class a implements DataSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31150a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DataSource.Factory f5227a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final PriorityTaskManager f5228a;

        public a(DataSource.Factory factory, PriorityTaskManager priorityTaskManager, int i) {
            this.f5227a = factory;
            this.f5228a = priorityTaskManager;
            this.f31150a = i;
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public h a() {
            return new h(this.f5227a.a(), this.f5228a, this.f31150a);
        }
    }

    public h(DataSource dataSource, PriorityTaskManager priorityTaskManager, int i) {
        this.f5225a = (DataSource) sb0.g(dataSource);
        this.f5226a = (PriorityTaskManager) sb0.g(priorityTaskManager);
        this.f31149a = i;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws IOException {
        this.f5226a.d(this.f31149a);
        return this.f5225a.a(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void b(TransferListener transferListener) {
        sb0.g(transferListener);
        this.f5225a.b(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        this.f5225a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return this.f5225a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f5225a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.f5226a.d(this.f31149a);
        return this.f5225a.read(bArr, i, i2);
    }
}
