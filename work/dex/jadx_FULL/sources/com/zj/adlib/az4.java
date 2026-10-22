package com.zj.adlib;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class az4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f40641a = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f15414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri f15415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSpec f15416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, List<String>> f15417a;
    public final long b;
    public final long c;
    public final long d;

    public az4(long j, DataSpec dataSpec, long j2) {
        this(j, dataSpec, dataSpec.f5026a, Collections.emptyMap(), j2, 0L, 0L);
    }

    public static long a() {
        return f40641a.getAndIncrement();
    }

    public az4(long j, DataSpec dataSpec, Uri uri, Map<String, List<String>> map, long j2, long j3, long j4) {
        this.f15414a = j;
        this.f15416a = dataSpec;
        this.f15415a = uri;
        this.f15417a = map;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }
}
