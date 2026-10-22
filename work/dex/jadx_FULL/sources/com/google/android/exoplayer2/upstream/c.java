package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.a72;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31128a = "DefaultDataSource";
    public static final String b = "asset";
    public static final String c = "content";
    public static final String d = "rtmp";
    public static final String e = "udp";
    public static final String f = "data";
    public static final String g = "rawresource";
    public static final String h = "android.resource";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f5109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource f5110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<TransferListener> f5111a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public DataSource f5112b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public DataSource f5113c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    public DataSource f5114d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @Nullable
    public DataSource f5115e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @Nullable
    public DataSource f5116f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @Nullable
    public DataSource f5117g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    @Nullable
    public DataSource f5118h;

    @Nullable
    public DataSource i;

    public static final class a implements DataSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f31129a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DataSource.Factory f5119a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public TransferListener f5120a;

        public a(Context context) {
            this(context, new e.b());
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public c a() {
            c cVar = new c(this.f31129a, this.f5119a.a());
            TransferListener transferListener = this.f5120a;
            if (transferListener != null) {
                cVar.b(transferListener);
            }
            return cVar;
        }

        public a e(@Nullable TransferListener transferListener) {
            this.f5120a = transferListener;
            return this;
        }

        public a(Context context, DataSource.Factory factory) {
            this.f31129a = context.getApplicationContext();
            this.f5119a = factory;
        }
    }

    public c(Context context, boolean z) {
        this(context, null, 8000, 8000, z);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws IOException {
        sb0.i(this.i == null);
        String scheme = dataSpec.f5026a.getScheme();
        if (gj9.L0(dataSpec.f5026a)) {
            String path = dataSpec.f5026a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.i = j();
            } else {
                this.i = g();
            }
        } else if ("asset".equals(scheme)) {
            this.i = g();
        } else if ("content".equals(scheme)) {
            this.i = h();
        } else if ("rtmp".equals(scheme)) {
            this.i = l();
        } else if (e.equals(scheme)) {
            this.i = m();
        } else if ("data".equals(scheme)) {
            this.i = i();
        } else if ("rawresource".equals(scheme) || h.equals(scheme)) {
            this.i = k();
        } else {
            this.i = this.f5110a;
        }
        return this.i.a(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void b(TransferListener transferListener) {
        sb0.g(transferListener);
        this.f5110a.b(transferListener);
        this.f5111a.add(transferListener);
        n(this.f5112b, transferListener);
        n(this.f5113c, transferListener);
        n(this.f5114d, transferListener);
        n(this.f5115e, transferListener);
        n(this.f5116f, transferListener);
        n(this.f5117g, transferListener);
        n(this.f5118h, transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        DataSource dataSource = this.i;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.i = null;
            }
        }
    }

    public final void d(DataSource dataSource) {
        for (int i = 0; i < this.f5111a.size(); i++) {
            dataSource.b(this.f5111a.get(i));
        }
    }

    public final DataSource g() {
        if (this.f5113c == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f5109a);
            this.f5113c = assetDataSource;
            d(assetDataSource);
        }
        return this.f5113c;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        DataSource dataSource = this.i;
        return dataSource == null ? Collections.emptyMap() : dataSource.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        DataSource dataSource = this.i;
        if (dataSource == null) {
            return null;
        }
        return dataSource.getUri();
    }

    public final DataSource h() {
        if (this.f5114d == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f5109a);
            this.f5114d = contentDataSource;
            d(contentDataSource);
        }
        return this.f5114d;
    }

    public final DataSource i() {
        if (this.f5117g == null) {
            a72 a72Var = new a72();
            this.f5117g = a72Var;
            d(a72Var);
        }
        return this.f5117g;
    }

    public final DataSource j() {
        if (this.f5112b == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f5112b = fileDataSource;
            d(fileDataSource);
        }
        return this.f5112b;
    }

    public final DataSource k() {
        if (this.f5118h == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f5109a);
            this.f5118h = rawResourceDataSource;
            d(rawResourceDataSource);
        }
        return this.f5118h;
    }

    public final DataSource l() {
        if (this.f5115e == null) {
            try {
                DataSource dataSource = (DataSource) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f5115e = dataSource;
                d(dataSource);
            } catch (ClassNotFoundException unused) {
                Log.n(f31128a, "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.f5115e == null) {
                this.f5115e = this.f5110a;
            }
        }
        return this.f5115e;
    }

    public final DataSource m() {
        if (this.f5116f == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.f5116f = udpDataSource;
            d(udpDataSource);
        }
        return this.f5116f;
    }

    public final void n(@Nullable DataSource dataSource, TransferListener transferListener) {
        if (dataSource != null) {
            dataSource.b(transferListener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return ((DataSource) sb0.g(this.i)).read(bArr, i, i2);
    }

    public c(Context context, @Nullable String str, boolean z) {
        this(context, str, 8000, 8000, z);
    }

    public c(Context context, @Nullable String str, int i, int i2, boolean z) {
        this(context, new e.b().l(str).f(i).j(i2).e(z).a());
    }

    public c(Context context, DataSource dataSource) {
        this.f5109a = context.getApplicationContext();
        this.f5110a = (DataSource) sb0.g(dataSource);
        this.f5111a = new ArrayList();
    }
}
