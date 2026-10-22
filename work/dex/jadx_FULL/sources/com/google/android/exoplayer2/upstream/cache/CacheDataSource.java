package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.zj.adlib.aa1;
import com.zj.adlib.gj9;
import com.zj.adlib.j29;
import com.zj.adlib.sb0;
import com.zj.adlib.wu1;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class CacheDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31133a = 1;
    public static final int b = 2;
    public static final int c = 4;
    public static final int d = -1;
    public static final int e = 0;
    public static final int f = 1;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final long f5131f = 102400;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f5132a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Uri f5133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource f5134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DataSpec f5135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Cache f5136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final EventListener f5137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheKeyFactory f5138a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public aa1 f5139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5140a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f5141b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final DataSource f5142b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public DataSpec f5143b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f5144b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f5145c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final DataSource f5146c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f5147c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f5148d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    public DataSource f5149d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f5150d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f5151e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f5152e;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    public interface EventListener {
        void onCacheIgnored(int i);

        void onCachedBytesRead(long j, long j2);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class b implements DataSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31134a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public DataSink.Factory f5153a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Cache f5155a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public EventListener f5156a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public PriorityTaskManager f5158a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f5159a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public DataSource.Factory f5160b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DataSource.Factory f5154a = new FileDataSource.b();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CacheKeyFactory f5157a = CacheKeyFactory.f31135a;

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public CacheDataSource a() {
            DataSource.Factory factory = this.f5160b;
            return g(factory != null ? factory.a() : null, this.b, this.f31134a);
        }

        public CacheDataSource e() {
            DataSource.Factory factory = this.f5160b;
            return g(factory != null ? factory.a() : null, this.b | 1, -1000);
        }

        public CacheDataSource f() {
            return g(null, this.b | 1, -1000);
        }

        public final CacheDataSource g(@Nullable DataSource dataSource, int i, int i2) {
            DataSink dataSinkA;
            Cache cache = (Cache) sb0.g(this.f5155a);
            if (this.f5159a || dataSource == null) {
                dataSinkA = null;
            } else {
                DataSink.Factory factory = this.f5153a;
                dataSinkA = factory != null ? factory.a() : new CacheDataSink.a().c(cache).a();
            }
            return new CacheDataSource(cache, dataSource, this.f5154a.a(), dataSinkA, this.f5157a, i, this.f5158a, i2, this.f5156a);
        }

        @Nullable
        public Cache h() {
            return this.f5155a;
        }

        public CacheKeyFactory i() {
            return this.f5157a;
        }

        @Nullable
        public PriorityTaskManager j() {
            return this.f5158a;
        }

        public b k(Cache cache) {
            this.f5155a = cache;
            return this;
        }

        public b l(CacheKeyFactory cacheKeyFactory) {
            this.f5157a = cacheKeyFactory;
            return this;
        }

        public b m(DataSource.Factory factory) {
            this.f5154a = factory;
            return this;
        }

        public b n(@Nullable DataSink.Factory factory) {
            this.f5153a = factory;
            this.f5159a = factory == null;
            return this;
        }

        public b o(@Nullable EventListener eventListener) {
            this.f5156a = eventListener;
            return this;
        }

        public b p(int i) {
            this.b = i;
            return this;
        }

        public b q(@Nullable DataSource.Factory factory) {
            this.f5160b = factory;
            return this;
        }

        public b r(int i) {
            this.f31134a = i;
            return this;
        }

        public b s(@Nullable PriorityTaskManager priorityTaskManager) {
            this.f5158a = priorityTaskManager;
            return this;
        }
    }

    public static Uri i(Cache cache, String str, Uri uri) {
        Uri uriB = ContentMetadata.b(cache.c(str));
        return uriB != null ? uriB : uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws IOException {
        try {
            String strB = this.f5138a.b(dataSpec);
            DataSpec dataSpecA = dataSpec.a().g(strB).a();
            this.f5135a = dataSpecA;
            this.f5133a = i(this.f5136a, strB, dataSpecA.f5026a);
            this.f5141b = dataSpec.f5032c;
            int iS = s(dataSpec);
            boolean z = iS != -1;
            this.f5152e = z;
            if (z) {
                p(iS);
            }
            if (this.f5152e) {
                this.f5145c = -1L;
            } else {
                long jA = ContentMetadata.a(this.f5136a.c(strB));
                this.f5145c = jA;
                if (jA != -1) {
                    long j = jA - dataSpec.f5032c;
                    this.f5145c = j;
                    if (j < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long jMin = dataSpec.f5033d;
            if (jMin != -1) {
                long j2 = this.f5145c;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.f5145c = jMin;
            }
            long j3 = this.f5145c;
            if (j3 > 0 || j3 == -1) {
                q(dataSpecA, false);
            }
            long j4 = dataSpec.f5033d;
            return j4 != -1 ? j4 : this.f5145c;
        } catch (Throwable th) {
            j(th);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void b(TransferListener transferListener) {
        sb0.g(transferListener);
        this.f5134a.b(transferListener);
        this.f5146c.b(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        this.f5135a = null;
        this.f5133a = null;
        this.f5141b = 0L;
        o();
        try {
            d();
        } catch (Throwable th) {
            j(th);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d() throws IOException {
        DataSource dataSource = this.f5149d;
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
        } finally {
            this.f5143b = null;
            this.f5149d = null;
            aa1 aa1Var = this.f5139a;
            if (aa1Var != null) {
                this.f5136a.e(aa1Var);
                this.f5139a = null;
            }
        }
    }

    public Cache g() {
        return this.f5136a;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return m() ? this.f5146c.getResponseHeaders() : Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f5133a;
    }

    public CacheKeyFactory h() {
        return this.f5138a;
    }

    public final void j(Throwable th) {
        if (l() || (th instanceof Cache.CacheException)) {
            this.f5150d = true;
        }
    }

    public final boolean k() {
        return this.f5149d == this.f5146c;
    }

    public final boolean l() {
        return this.f5149d == this.f5134a;
    }

    public final boolean m() {
        return !l();
    }

    public final boolean n() {
        return this.f5149d == this.f5142b;
    }

    public final void o() {
        EventListener eventListener = this.f5137a;
        if (eventListener == null || this.f5148d <= 0) {
            return;
        }
        eventListener.onCachedBytesRead(this.f5136a.getCacheSpace(), this.f5148d);
        this.f5148d = 0L;
    }

    public final void p(int i) {
        EventListener eventListener = this.f5137a;
        if (eventListener != null) {
            eventListener.onCacheIgnored(i);
        }
    }

    public final void q(DataSpec dataSpec, boolean z) throws IOException {
        aa1 aa1VarG;
        long jMin;
        DataSpec dataSpecA;
        DataSource dataSource;
        String str = (String) gj9.k(dataSpec.f5028a);
        if (this.f5152e) {
            aa1VarG = null;
        } else if (this.f5140a) {
            try {
                aa1VarG = this.f5136a.g(str, this.f5141b, this.f5145c);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            aa1VarG = this.f5136a.a(str, this.f5141b, this.f5145c);
        }
        if (aa1VarG == null) {
            dataSource = this.f5146c;
            dataSpecA = dataSpec.a().i(this.f5141b).h(this.f5145c).a();
        } else if (aa1VarG.f15219a) {
            Uri uriFromFile = Uri.fromFile((File) gj9.k(aa1VarG.f15218a));
            long j = aa1VarG.f40491a;
            long j2 = this.f5141b - j;
            long jMin2 = aa1VarG.b - j2;
            long j3 = this.f5145c;
            if (j3 != -1) {
                jMin2 = Math.min(jMin2, j3);
            }
            dataSpecA = dataSpec.a().j(uriFromFile).l(j).i(j2).h(jMin2).a();
            dataSource = this.f5134a;
        } else {
            if (aa1VarG.c()) {
                jMin = this.f5145c;
            } else {
                jMin = aa1VarG.b;
                long j4 = this.f5145c;
                if (j4 != -1) {
                    jMin = Math.min(jMin, j4);
                }
            }
            dataSpecA = dataSpec.a().i(this.f5141b).h(jMin).a();
            dataSource = this.f5142b;
            if (dataSource == null) {
                dataSource = this.f5146c;
                this.f5136a.e(aa1VarG);
                aa1VarG = null;
            }
        }
        this.f5151e = (this.f5152e || dataSource != this.f5146c) ? Long.MAX_VALUE : this.f5141b + 102400;
        if (z) {
            sb0.i(k());
            if (dataSource == this.f5146c) {
                return;
            }
            try {
                d();
            } catch (Throwable th) {
                if (!((aa1) gj9.k(aa1VarG)).b()) {
                    throw th;
                }
                this.f5136a.e(aa1VarG);
                throw th;
            }
        }
        if (aa1VarG != null && aa1VarG.b()) {
            this.f5139a = aa1VarG;
        }
        this.f5149d = dataSource;
        this.f5143b = dataSpecA;
        this.f5132a = 0L;
        long jA = dataSource.a(dataSpecA);
        wu1 wu1Var = new wu1();
        if (dataSpecA.f5033d == -1 && jA != -1) {
            this.f5145c = jA;
            wu1.h(wu1Var, this.f5141b + jA);
        }
        if (m()) {
            Uri uri = dataSource.getUri();
            this.f5133a = uri;
            wu1.i(wu1Var, dataSpec.f5026a.equals(uri) ^ true ? this.f5133a : null);
        }
        if (n()) {
            this.f5136a.f(str, wu1Var);
        }
    }

    public final void r(String str) throws IOException {
        this.f5145c = 0L;
        if (n()) {
            wu1 wu1Var = new wu1();
            wu1.h(wu1Var, this.f5141b);
            this.f5136a.f(str, wu1Var);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0080 A[Catch: all -> 0x0099, TryCatch #0 {all -> 0x0099, blocks: (B:9:0x0021, B:11:0x0029, B:12:0x002d, B:14:0x0041, B:16:0x0047, B:17:0x004d, B:19:0x005e, B:20:0x0062, B:22:0x0068, B:24:0x006e, B:26:0x0074, B:27:0x0080, B:33:0x008e), top: B:38:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0086  */
    /* JADX WARN: Code duplicated, block: B:31:0x008c  */
    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j;
        if (i2 == 0) {
            return 0;
        }
        if (this.f5145c == 0) {
            return -1;
        }
        DataSpec dataSpec = (DataSpec) sb0.g(this.f5135a);
        DataSpec dataSpec2 = (DataSpec) sb0.g(this.f5143b);
        try {
            if (this.f5141b >= this.f5151e) {
                q(dataSpec, true);
            }
            int i3 = ((DataSource) sb0.g(this.f5149d)).read(bArr, i, i2);
            if (i3 != -1) {
                if (l()) {
                    this.f5148d += (long) i3;
                }
                long j2 = i3;
                this.f5141b += j2;
                this.f5132a += j2;
                long j3 = this.f5145c;
                if (j3 != -1) {
                    this.f5145c = j3 - j2;
                }
            } else {
                if (!m()) {
                    j = this.f5145c;
                    if (j <= 0) {
                        if (j == -1) {
                        }
                    }
                    d();
                    q(dataSpec, false);
                    return read(bArr, i, i2);
                }
                long j4 = dataSpec2.f5033d;
                if (j4 != -1 && this.f5132a >= j4) {
                    j = this.f5145c;
                    if (j <= 0) {
                        if (j == -1) {
                        }
                    }
                    d();
                    q(dataSpec, false);
                    return read(bArr, i, i2);
                }
                r((String) gj9.k(dataSpec.f5028a));
            }
            return i3;
        } catch (Throwable th) {
            j(th);
            throw th;
        }
    }

    public final int s(DataSpec dataSpec) {
        if (this.f5144b && this.f5150d) {
            return 0;
        }
        return (this.f5147c && dataSpec.f5033d == -1) ? 1 : -1;
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource) {
        this(cache, dataSource, 0);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, int i) {
        this(cache, dataSource, new FileDataSource(), new CacheDataSink(cache, 5242880L), i, null);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, int i, @Nullable EventListener eventListener) {
        this(cache, dataSource, dataSource2, dataSink, i, eventListener, null);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, int i, @Nullable EventListener eventListener, @Nullable CacheKeyFactory cacheKeyFactory) {
        this(cache, dataSource, dataSource2, dataSink, cacheKeyFactory, i, null, 0, eventListener);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, @Nullable CacheKeyFactory cacheKeyFactory, int i, @Nullable PriorityTaskManager priorityTaskManager, int i2, @Nullable EventListener eventListener) {
        this.f5136a = cache;
        this.f5134a = dataSource2;
        this.f5138a = cacheKeyFactory == null ? CacheKeyFactory.f31135a : cacheKeyFactory;
        this.f5140a = (i & 1) != 0;
        this.f5144b = (i & 2) != 0;
        this.f5147c = (i & 4) != 0;
        if (dataSource != null) {
            dataSource = priorityTaskManager != null ? new h(dataSource, priorityTaskManager, i2) : dataSource;
            this.f5146c = dataSource;
            this.f5142b = dataSink != null ? new j29(dataSource, dataSink) : null;
        } else {
            this.f5146c = g.f5224a;
            this.f5142b = null;
        }
        this.f5137a = eventListener;
    }
}
