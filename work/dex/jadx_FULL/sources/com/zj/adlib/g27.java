package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g27 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41804a = 20000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f16681a = "PsDurationReader";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16685a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f16686b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f16687c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g89 f16683a = new g89(0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16682a = -9223372036854775807L;
    public long b = -9223372036854775807L;
    public long c = -9223372036854775807L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f16684a = new om6();

    public static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public static long l(om6 om6Var) {
        int iE = om6Var.e();
        if (om6Var.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        om6Var.k(bArr, 0, 9);
        om6Var.S(iE);
        if (a(bArr)) {
            return m(bArr);
        }
        return -9223372036854775807L;
    }

    public static long m(byte[] bArr) {
        byte b = bArr[0];
        long j = (((((long) b) & 56) >> 3) << 30) | ((((long) b) & 3) << 28) | ((((long) bArr[1]) & 255) << 20);
        byte b2 = bArr[2];
        return j | (((((long) b2) & 248) >> 3) << 15) | ((((long) b2) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public final int b(ExtractorInput extractorInput) {
        this.f16684a.P(gj9.f16790a);
        this.f16685a = true;
        extractorInput.resetPeekPosition();
        return 0;
    }

    public long c() {
        return this.c;
    }

    public g89 d() {
        return this.f16683a;
    }

    public boolean e() {
        return this.f16685a;
    }

    public final int f(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public int g(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        if (!this.f16687c) {
            return j(extractorInput, iv6Var);
        }
        if (this.b == -9223372036854775807L) {
            return b(extractorInput);
        }
        if (!this.f16686b) {
            return h(extractorInput, iv6Var);
        }
        long j = this.f16682a;
        if (j == -9223372036854775807L) {
            return b(extractorInput);
        }
        long jB = this.f16683a.b(this.b) - this.f16683a.b(j);
        this.c = jB;
        if (jB < 0) {
            Log.n(f16681a, "Invalid duration: " + this.c + ". Using TIME_UNSET instead.");
            this.c = -9223372036854775807L;
        }
        return b(extractorInput);
    }

    public final int h(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        int iMin = (int) Math.min(20000L, extractorInput.getLength());
        long j = 0;
        if (extractorInput.getPosition() != j) {
            iv6Var.f42452a = j;
            return 1;
        }
        this.f16684a.O(iMin);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.f16684a.d(), 0, iMin);
        this.f16682a = i(this.f16684a);
        this.f16686b = true;
        return 0;
    }

    public final long i(om6 om6Var) {
        int iF = om6Var.f();
        for (int iE = om6Var.e(); iE < iF - 3; iE++) {
            if (f(om6Var.d(), iE) == 442) {
                om6Var.S(iE + 4);
                long jL = l(om6Var);
                if (jL != -9223372036854775807L) {
                    return jL;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final int j(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        long length = extractorInput.getLength();
        int iMin = (int) Math.min(20000L, length);
        long j = length - ((long) iMin);
        if (extractorInput.getPosition() != j) {
            iv6Var.f42452a = j;
            return 1;
        }
        this.f16684a.O(iMin);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.f16684a.d(), 0, iMin);
        this.b = k(this.f16684a);
        this.f16687c = true;
        return 0;
    }

    public final long k(om6 om6Var) {
        int iE = om6Var.e();
        for (int iF = om6Var.f() - 4; iF >= iE; iF--) {
            if (f(om6Var.d(), iF) == 442) {
                om6Var.S(iF + 4);
                long jL = l(om6Var);
                if (jL != -9223372036854775807L) {
                    return jL;
                }
            }
        }
        return -9223372036854775807L;
    }
}
