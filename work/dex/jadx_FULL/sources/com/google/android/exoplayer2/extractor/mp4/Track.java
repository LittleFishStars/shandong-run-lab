package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.zj.adlib.z99;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Track {
    public static final int e = 0;
    public static final int f = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f3008a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f3009a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final long[] f3010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final z99[] f3011a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f3012b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final long[] f3013b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final long f3014c;
    public final int d;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Transformation {
    }

    public Track(int i, int i2, long j, long j2, long j3, d dVar, int i3, @Nullable z99[] z99VarArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f30684a = i;
        this.b = i2;
        this.f3008a = j;
        this.f3012b = j2;
        this.f3014c = j3;
        this.f3009a = dVar;
        this.c = i3;
        this.f3011a = z99VarArr;
        this.d = i4;
        this.f3010a = jArr;
        this.f3013b = jArr2;
    }

    public Track a(d dVar) {
        return new Track(this.f30684a, this.b, this.f3008a, this.f3012b, this.f3014c, dVar, this.c, this.f3011a, this.d, this.f3010a, this.f3013b);
    }

    @Nullable
    public z99 b(int i) {
        z99[] z99VarArr = this.f3011a;
        if (z99VarArr == null) {
            return null;
        }
        return z99VarArr[i];
    }
}
