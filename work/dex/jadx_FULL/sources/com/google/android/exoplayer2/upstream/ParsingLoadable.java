package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.zj.adlib.ar8;
import com.zj.adlib.az4;
import com.zj.adlib.b72;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ParsingLoadable<T> implements Loader.Loadable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31120a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f5062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSpec f5063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Parser<? extends T> f5064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ar8 f5065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public volatile T f5066a;

    public interface Parser<T> {
        T parse(Uri uri, InputStream inputStream) throws IOException;
    }

    public ParsingLoadable(DataSource dataSource, Uri uri, int i, Parser<? extends T> parser) {
        this(dataSource, new DataSpec.b().j(uri).c(1).a(), i, parser);
    }

    public static <T> T e(DataSource dataSource, Parser<? extends T> parser, Uri uri, int i) throws IOException {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, uri, i, parser);
        parsingLoadable.load();
        return (T) sb0.g(parsingLoadable.c());
    }

    public static <T> T f(DataSource dataSource, Parser<? extends T> parser, DataSpec dataSpec, int i) throws IOException {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, dataSpec, i, parser);
        parsingLoadable.load();
        return (T) sb0.g(parsingLoadable.c());
    }

    public long a() {
        return this.f5065a.d();
    }

    public Map<String, List<String>> b() {
        return this.f5065a.h();
    }

    @Nullable
    public final T c() {
        return this.f5066a;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
    }

    public Uri d() {
        return this.f5065a.g();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws IOException {
        this.f5065a.i();
        b72 b72Var = new b72(this.f5065a, this.f5063a);
        try {
            b72Var.j();
            this.f5066a = this.f5064a.parse((Uri) sb0.g(this.f5065a.getUri()), b72Var);
        } finally {
            gj9.p(b72Var);
        }
    }

    public ParsingLoadable(DataSource dataSource, DataSpec dataSpec, int i, Parser<? extends T> parser) {
        this.f5065a = new ar8(dataSource);
        this.f5063a = dataSpec;
        this.f31120a = i;
        this.f5064a = parser;
        this.f5062a = az4.a();
    }
}
