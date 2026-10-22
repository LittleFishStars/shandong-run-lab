package com.google.common.cache;

import androidx.camera.video.AudioStats;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.e;
import com.google.common.base.g;
import com.google.common.base.i;
import com.google.common.math.LongMath;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f31646a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;

    public a(long j, long j2, long j3, long j4, long j5, long j6) {
        i.d(j >= 0);
        i.d(j2 >= 0);
        i.d(j3 >= 0);
        i.d(j4 >= 0);
        i.d(j5 >= 0);
        i.d(j6 >= 0);
        this.f31646a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
    }

    public double a() {
        long jX = LongMath.x(this.c, this.d);
        return jX == 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : this.e / jX;
    }

    public long b() {
        return this.f;
    }

    public long c() {
        return this.f31646a;
    }

    public double d() {
        long jM = m();
        if (jM == 0) {
            return 1.0d;
        }
        return this.f31646a / jM;
    }

    public long e() {
        return LongMath.x(this.c, this.d);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f31646a == aVar.f31646a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f;
    }

    public long f() {
        return this.d;
    }

    public double g() {
        long jX = LongMath.x(this.c, this.d);
        return jX == 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : this.d / jX;
    }

    public long h() {
        return this.c;
    }

    public int hashCode() {
        return g.b(Long.valueOf(this.f31646a), Long.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f));
    }

    public a i(a aVar) {
        return new a(Math.max(0L, LongMath.A(this.f31646a, aVar.f31646a)), Math.max(0L, LongMath.A(this.b, aVar.b)), Math.max(0L, LongMath.A(this.c, aVar.c)), Math.max(0L, LongMath.A(this.d, aVar.d)), Math.max(0L, LongMath.A(this.e, aVar.e)), Math.max(0L, LongMath.A(this.f, aVar.f)));
    }

    public long j() {
        return this.b;
    }

    public double k() {
        long jM = m();
        return jM == 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : this.b / jM;
    }

    public a l(a aVar) {
        return new a(LongMath.x(this.f31646a, aVar.f31646a), LongMath.x(this.b, aVar.b), LongMath.x(this.c, aVar.c), LongMath.x(this.d, aVar.d), LongMath.x(this.e, aVar.e), LongMath.x(this.f, aVar.f));
    }

    public long m() {
        return LongMath.x(this.f31646a, this.b);
    }

    public long n() {
        return this.e;
    }

    public String toString() {
        return e.c(this).e("hitCount", this.f31646a).e("missCount", this.b).e("loadSuccessCount", this.c).e("loadExceptionCount", this.d).e("totalLoadTime", this.e).e("evictionCount", this.f).toString();
    }
}
