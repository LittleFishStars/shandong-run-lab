package com.google.android.exoplayer2.source.chunk;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.zj.adlib.ar8;
import com.zj.adlib.az4;
import com.zj.adlib.sb0;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class Chunk implements Loader.Loadable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30858a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f3836a = az4.a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.d f3837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSpec f3838a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ar8 f3839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Object f3840a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f3841b;
    public final long c;

    public Chunk(DataSource dataSource, DataSpec dataSpec, int i, com.google.android.exoplayer2.d dVar, int i2, @Nullable Object obj, long j, long j2) {
        this.f3839a = new ar8(dataSource);
        this.f3838a = (DataSpec) sb0.g(dataSpec);
        this.f30858a = i;
        this.f3837a = dVar;
        this.b = i2;
        this.f3840a = obj;
        this.f3841b = j;
        this.c = j2;
    }

    public final long a() {
        return this.f3839a.d();
    }

    public final long b() {
        return this.c - this.f3841b;
    }

    public final Map<String, List<String>> c() {
        return this.f3839a.h();
    }

    public final Uri d() {
        return this.f3839a.g();
    }
}
