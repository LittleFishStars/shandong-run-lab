package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataReader;
import com.zj.adlib.om6;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface TrackOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30625a = 0;
    public static final int b = 1;
    public static final int c = 2;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SampleDataPart {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30626a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f2706a;
        public final int b;
        public final int c;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.f30626a = i;
            this.f2706a = bArr;
            this.b = i2;
            this.c = i3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f30626a == aVar.f30626a && this.b == aVar.b && this.c == aVar.c && Arrays.equals(this.f2706a, aVar.f2706a);
        }

        public int hashCode() {
            return (((((this.f30626a * 31) + Arrays.hashCode(this.f2706a)) * 31) + this.b) * 31) + this.c;
        }
    }

    void a(om6 om6Var, int i, int i2);

    default int b(DataReader dataReader, int i, boolean z) throws IOException {
        return d(dataReader, i, z, 0);
    }

    default void c(om6 om6Var, int i) {
        a(om6Var, i, 0);
    }

    int d(DataReader dataReader, int i, boolean z, int i2) throws IOException;

    void e(long j, int i, int i2, int i3, @Nullable a aVar);

    void f(com.google.android.exoplayer2.d dVar);
}
