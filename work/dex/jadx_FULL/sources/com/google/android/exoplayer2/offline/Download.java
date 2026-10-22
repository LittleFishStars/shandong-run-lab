package com.google.android.exoplayer2.offline;

import com.zj.adlib.qq2;
import com.zj.adlib.sb0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Download {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;
    public static final int i = 5;
    public static final int j = 7;
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f3489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DownloadRequest f3490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qq2 f3491a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f3492b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final long f3493c;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FailureReason {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public Download(DownloadRequest downloadRequest, int i2, long j2, long j3, long j4, int i3, int i4) {
        this(downloadRequest, i2, j2, j3, j4, i3, i4, new qq2());
    }

    public long a() {
        return this.f3491a.f19160a;
    }

    public float b() {
        return this.f3491a.f44275a;
    }

    public boolean c() {
        int i2 = this.f30784a;
        return i2 == 3 || i2 == 4;
    }

    public Download(DownloadRequest downloadRequest, int i2, long j2, long j3, long j4, int i3, int i4, qq2 qq2Var) {
        sb0.g(qq2Var);
        sb0.a((i4 == 0) == (i2 != 4));
        if (i3 != 0) {
            sb0.a((i2 == 2 || i2 == 0) ? false : true);
        }
        this.f3490a = downloadRequest;
        this.f30784a = i2;
        this.f3489a = j2;
        this.f3492b = j3;
        this.f3493c = j4;
        this.b = i3;
        this.c = i4;
        this.f3491a = qq2Var;
    }
}
