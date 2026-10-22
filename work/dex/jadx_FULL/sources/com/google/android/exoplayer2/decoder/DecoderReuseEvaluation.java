package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.zj.adlib.sb0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DecoderReuseEvaluation {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 4;
    public static final int j = 8;
    public static final int k = 16;
    public static final int l = 32;
    public static final int m = 64;
    public static final int n = 128;
    public static final int o = 256;
    public static final int p = 512;
    public static final int q = 1024;
    public static final int r = 2048;
    public static final int s = 4096;
    public static final int t = 8192;
    public static final int u = 16384;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f2590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f2591a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final d f2592b;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DecoderDiscardReasons {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DecoderReuseResult {
    }

    public DecoderReuseEvaluation(String str, d dVar, d dVar2, int i2, int i3) {
        sb0.a(i2 == 0 || i3 == 0);
        this.f2591a = sb0.e(str);
        this.f2590a = (d) sb0.g(dVar);
        this.f2592b = (d) sb0.g(dVar2);
        this.f30578a = i2;
        this.b = i3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DecoderReuseEvaluation.class != obj.getClass()) {
            return false;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = (DecoderReuseEvaluation) obj;
        return this.f30578a == decoderReuseEvaluation.f30578a && this.b == decoderReuseEvaluation.b && this.f2591a.equals(decoderReuseEvaluation.f2591a) && this.f2590a.equals(decoderReuseEvaluation.f2590a) && this.f2592b.equals(decoderReuseEvaluation.f2592b);
    }

    public int hashCode() {
        return ((((((((527 + this.f30578a) * 31) + this.b) * 31) + this.f2591a.hashCode()) * 31) + this.f2590a.hashCode()) * 31) + this.f2592b.hashCode();
    }
}
