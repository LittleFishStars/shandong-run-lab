package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.zj.adlib.ab3;
import com.zj.adlib.sb0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DataSpec {
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 4;
    public static final int f = 8;
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f5025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri f5026a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Object f5027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f5028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, String> f5029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final byte[] f5030a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Deprecated
    public final long f5031b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final long f5032c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final long f5033d;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpMethod {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31106a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f5034a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Uri f5035a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Object f5036a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f5037a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map<String, String> f5038a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public byte[] f5039a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f5040b;
        public long c;

        public DataSpec a() {
            sb0.l(this.f5035a, "The uri must be set.");
            return new DataSpec(this.f5035a, this.f5034a, this.f31106a, this.f5039a, this.f5038a, this.f5040b, this.c, this.f5037a, this.b, this.f5036a);
        }

        public b b(@Nullable Object obj) {
            this.f5036a = obj;
            return this;
        }

        public b c(int i) {
            this.b = i;
            return this;
        }

        public b d(@Nullable byte[] bArr) {
            this.f5039a = bArr;
            return this;
        }

        public b e(int i) {
            this.f31106a = i;
            return this;
        }

        public b f(Map<String, String> map) {
            this.f5038a = map;
            return this;
        }

        public b g(@Nullable String str) {
            this.f5037a = str;
            return this;
        }

        public b h(long j) {
            this.c = j;
            return this;
        }

        public b i(long j) {
            this.f5040b = j;
            return this;
        }

        public b j(Uri uri) {
            this.f5035a = uri;
            return this;
        }

        public b k(String str) {
            this.f5035a = Uri.parse(str);
            return this;
        }

        public b l(long j) {
            this.f5034a = j;
            return this;
        }

        public b() {
            this.f31106a = 1;
            this.f5038a = Collections.emptyMap();
            this.c = -1L;
        }

        public b(DataSpec dataSpec) {
            this.f5035a = dataSpec.f5026a;
            this.f5034a = dataSpec.f5025a;
            this.f31106a = dataSpec.f31105a;
            this.f5039a = dataSpec.f5030a;
            this.f5038a = dataSpec.f5029a;
            this.f5040b = dataSpec.f5032c;
            this.c = dataSpec.f5033d;
            this.f5037a = dataSpec.f5028a;
            this.b = dataSpec.b;
            this.f5036a = dataSpec.f5027a;
        }
    }

    static {
        ab3.a("goog.exo.datasource");
    }

    public static String c(int i2) {
        if (i2 == 1) {
            return "GET";
        }
        if (i2 == 2) {
            return "POST";
        }
        if (i2 == 3) {
            return com.ipd.dsp.internal.g0.c.f38307a;
        }
        throw new IllegalStateException();
    }

    public b a() {
        return new b();
    }

    public final String b() {
        return c(this.f31105a);
    }

    public boolean d(int i2) {
        return (this.b & i2) == i2;
    }

    public DataSpec e(long j) {
        long j2 = this.f5033d;
        return f(j, j2 != -1 ? j2 - j : -1L);
    }

    public DataSpec f(long j, long j2) {
        return (j == 0 && this.f5033d == j2) ? this : new DataSpec(this.f5026a, this.f5025a, this.f31105a, this.f5030a, this.f5029a, this.f5032c + j, j2, this.f5028a, this.b, this.f5027a);
    }

    public DataSpec g(Map<String, String> map) {
        HashMap map2 = new HashMap(this.f5029a);
        map2.putAll(map);
        return new DataSpec(this.f5026a, this.f5025a, this.f31105a, this.f5030a, map2, this.f5032c, this.f5033d, this.f5028a, this.b, this.f5027a);
    }

    public DataSpec h(Map<String, String> map) {
        return new DataSpec(this.f5026a, this.f5025a, this.f31105a, this.f5030a, map, this.f5032c, this.f5033d, this.f5028a, this.b, this.f5027a);
    }

    public DataSpec i(Uri uri) {
        return new DataSpec(uri, this.f5025a, this.f31105a, this.f5030a, this.f5029a, this.f5032c, this.f5033d, this.f5028a, this.b, this.f5027a);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f5026a + ", " + this.f5032c + ", " + this.f5033d + ", " + this.f5028a + ", " + this.b + "]";
    }

    public DataSpec(Uri uri) {
        this(uri, 0L, -1L);
    }

    public DataSpec(Uri uri, long j, long j2) {
        this(uri, 0L, 1, null, Collections.emptyMap(), j, j2, null, 0, null);
    }

    @Deprecated
    public DataSpec(Uri uri, int i2) {
        this(uri, 0L, -1L, null, i2);
    }

    @Deprecated
    public DataSpec(Uri uri, long j, long j2, @Nullable String str) {
        this(uri, j, j, j2, str, 0);
    }

    @Deprecated
    public DataSpec(Uri uri, long j, long j2, @Nullable String str, int i2) {
        this(uri, j, j, j2, str, i2);
    }

    @Deprecated
    public DataSpec(Uri uri, long j, long j2, @Nullable String str, int i2, Map<String, String> map) {
        this(uri, 1, null, j, j, j2, str, i2, map);
    }

    @Deprecated
    public DataSpec(Uri uri, long j, long j2, long j3, @Nullable String str, int i2) {
        this(uri, null, j, j2, j3, str, i2);
    }

    @Deprecated
    public DataSpec(Uri uri, @Nullable byte[] bArr, long j, long j2, long j3, @Nullable String str, int i2) {
        this(uri, bArr != null ? 2 : 1, bArr, j, j2, j3, str, i2);
    }

    @Deprecated
    public DataSpec(Uri uri, int i2, @Nullable byte[] bArr, long j, long j2, long j3, @Nullable String str, int i3) {
        this(uri, i2, bArr, j, j2, j3, str, i3, Collections.emptyMap());
    }

    @Deprecated
    public DataSpec(Uri uri, int i2, @Nullable byte[] bArr, long j, long j2, long j3, @Nullable String str, int i3, Map<String, String> map) {
        this(uri, j - j2, i2, bArr, map, j2, j3, str, i3, null);
    }

    public DataSpec(Uri uri, long j, int i2, @Nullable byte[] bArr, Map<String, String> map, long j2, long j3, @Nullable String str, int i3, @Nullable Object obj) {
        byte[] bArr2 = bArr;
        long j4 = j + j2;
        boolean z = true;
        sb0.a(j4 >= 0);
        sb0.a(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        sb0.a(z);
        this.f5026a = uri;
        this.f5025a = j;
        this.f31105a = i2;
        this.f5030a = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f5029a = Collections.unmodifiableMap(new HashMap(map));
        this.f5032c = j2;
        this.f5031b = j4;
        this.f5033d = j3;
        this.f5028a = str;
        this.b = i3;
        this.f5027a = obj;
    }
}
