package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jd9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42563a = "TsDurationReader";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f17370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17374a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f17375b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f17376c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g89 f17372a = new g89(0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f17371a = -9223372036854775807L;
    public long b = -9223372036854775807L;
    public long c = -9223372036854775807L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f17373a = new om6();

    public jd9(int i) {
        this.f17370a = i;
    }

    public final int a(ExtractorInput extractorInput) {
        this.f17373a.P(gj9.f16790a);
        this.f17374a = true;
        extractorInput.resetPeekPosition();
        return 0;
    }

    public long b() {
        return this.c;
    }

    public g89 c() {
        return this.f17372a;
    }

    public boolean d() {
        return this.f17374a;
    }

    public int e(ExtractorInput extractorInput, iv6 iv6Var, int i) throws IOException {
        if (i <= 0) {
            return a(extractorInput);
        }
        if (!this.f17376c) {
            return h(extractorInput, iv6Var, i);
        }
        if (this.b == -9223372036854775807L) {
            return a(extractorInput);
        }
        if (!this.f17375b) {
            return f(extractorInput, iv6Var, i);
        }
        long j = this.f17371a;
        if (j == -9223372036854775807L) {
            return a(extractorInput);
        }
        long jB = this.f17372a.b(this.b) - this.f17372a.b(j);
        this.c = jB;
        if (jB < 0) {
            Log.n(f42563a, "Invalid duration: " + this.c + ". Using TIME_UNSET instead.");
            this.c = -9223372036854775807L;
        }
        return a(extractorInput);
    }

    public final int f(ExtractorInput extractorInput, iv6 iv6Var, int i) throws IOException {
        int iMin = (int) Math.min(this.f17370a, extractorInput.getLength());
        long j = 0;
        if (extractorInput.getPosition() != j) {
            iv6Var.f42452a = j;
            return 1;
        }
        this.f17373a.O(iMin);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.f17373a.d(), 0, iMin);
        this.f17371a = g(this.f17373a, i);
        this.f17375b = true;
        return 0;
    }

    public final long g(om6 om6Var, int i) {
        int iF = om6Var.f();
        for (int iE = om6Var.e(); iE < iF; iE++) {
            if (om6Var.d()[iE] == 71) {
                long jC = md9.c(om6Var, iE, i);
                if (jC != -9223372036854775807L) {
                    return jC;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final int h(ExtractorInput extractorInput, iv6 iv6Var, int i) throws IOException {
        long length = extractorInput.getLength();
        int iMin = (int) Math.min(this.f17370a, length);
        long j = length - ((long) iMin);
        if (extractorInput.getPosition() != j) {
            iv6Var.f42452a = j;
            return 1;
        }
        this.f17373a.O(iMin);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.f17373a.d(), 0, iMin);
        this.b = i(this.f17373a, i);
        this.f17376c = true;
        return 0;
    }

    public final long i(om6 om6Var, int i) {
        int iE = om6Var.e();
        int iF = om6Var.f();
        for (int i2 = iF - 188; i2 >= iE; i2--) {
            if (md9.b(om6Var.d(), iE, iF, i2)) {
                long jC = md9.c(om6Var, i2, i);
                if (jC != -9223372036854775807L) {
                    return jC;
                }
            }
        }
        return -9223372036854775807L;
    }
}
