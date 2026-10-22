package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.flv.b;
import com.google.android.exoplayer2.extractor.h;
import com.zj.adlib.iv6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30646a = new ExtractorsFactory() { // from class: com.zj.adlib.ak3
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return b.g();
        }
    };
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 9;
    public static final int m = 11;
    public static final int n = 8;
    public static final int o = 9;
    public static final int p = 18;
    public static final int q = 4607062;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2752a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f2753a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f2754a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f2756a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2758a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2760b;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f2757a = new om6(4);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final om6 f2759b = new om6(9);
    public final om6 c = new om6(11);

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final om6 f2761d = new om6();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f2755a = new c();
    public int d = 1;

    public static /* synthetic */ Extractor[] g() {
        return new Extractor[]{new b()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f2753a = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        sb0.k(this.f2753a);
        while (true) {
            int i2 = this.d;
            if (i2 != 1) {
                if (i2 == 2) {
                    l(extractorInput);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        throw new IllegalStateException();
                    }
                    if (j(extractorInput)) {
                        return 0;
                    }
                } else if (!k(extractorInput)) {
                    return -1;
                }
            } else if (!i(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        extractorInput.peekFully(this.f2757a.d(), 0, 3);
        this.f2757a.S(0);
        if (this.f2757a.J() != 4607062) {
            return false;
        }
        extractorInput.peekFully(this.f2757a.d(), 0, 2);
        this.f2757a.S(0);
        if ((this.f2757a.M() & 250) != 0) {
            return false;
        }
        extractorInput.peekFully(this.f2757a.d(), 0, 4);
        this.f2757a.S(0);
        int iO = this.f2757a.o();
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(iO);
        extractorInput.peekFully(this.f2757a.d(), 0, 4);
        this.f2757a.S(0);
        return this.f2757a.o() == 0;
    }

    @RequiresNonNull({"extractorOutput"})
    public final void e() {
        if (this.f2760b) {
            return;
        }
        this.f2753a.d(new SeekMap.b(-9223372036854775807L));
        this.f2760b = true;
    }

    public final long f() {
        if (this.f2758a) {
            return this.f2752a + this.b;
        }
        if (this.f2755a.c() == -9223372036854775807L) {
            return 0L;
        }
        return this.b;
    }

    public final om6 h(ExtractorInput extractorInput) throws IOException {
        if (this.g > this.f2761d.b()) {
            om6 om6Var = this.f2761d;
            om6Var.Q(new byte[Math.max(om6Var.b() * 2, this.g)], 0);
        } else {
            this.f2761d.S(0);
        }
        this.f2761d.R(this.g);
        extractorInput.readFully(this.f2761d.d(), 0, this.g);
        return this.f2761d;
    }

    @RequiresNonNull({"extractorOutput"})
    public final boolean i(ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.readFully(this.f2759b.d(), 0, 9, true)) {
            return false;
        }
        this.f2759b.S(0);
        this.f2759b.T(4);
        int iG = this.f2759b.G();
        boolean z = (iG & 4) != 0;
        boolean z2 = (iG & 1) != 0;
        if (z && this.f2754a == null) {
            this.f2754a = new a(this.f2753a.b(8, 1));
        }
        if (z2 && this.f2756a == null) {
            this.f2756a = new d(this.f2753a.b(9, 2));
        }
        this.f2753a.endTracks();
        this.e = (this.f2759b.o() - 9) + 4;
        this.d = 2;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0087  */
    /* JADX WARN: Code duplicated, block: B:27:0x008b  */
    @RequiresNonNull({"extractorOutput"})
    public final boolean j(ExtractorInput extractorInput) throws IOException {
        boolean zA;
        boolean z;
        long j2;
        long jF = f();
        int i2 = this.f;
        if (i2 == 8 && this.f2754a != null) {
            e();
            zA = this.f2754a.a(h(extractorInput), jF);
        } else {
            if (i2 != 9 || this.f2756a == null) {
                if (i2 != 18 || this.f2760b) {
                    extractorInput.skipFully(this.g);
                    zA = false;
                    z = false;
                } else {
                    zA = this.f2755a.a(h(extractorInput), jF);
                    long jC = this.f2755a.c();
                    if (jC != -9223372036854775807L) {
                        this.f2753a.d(new h(this.f2755a.d(), this.f2755a.e(), jC));
                        this.f2760b = true;
                    }
                }
                if (!this.f2758a && zA) {
                    this.f2758a = true;
                    if (this.f2755a.c() == -9223372036854775807L) {
                        j2 = -this.b;
                    } else {
                        j2 = 0;
                    }
                    this.f2752a = j2;
                }
                this.e = 4;
                this.d = 2;
                return z;
            }
            e();
            zA = this.f2756a.a(h(extractorInput), jF);
        }
        z = true;
        if (!this.f2758a) {
            this.f2758a = true;
            if (this.f2755a.c() == -9223372036854775807L) {
                j2 = -this.b;
            } else {
                j2 = 0;
            }
            this.f2752a = j2;
        }
        this.e = 4;
        this.d = 2;
        return z;
    }

    public final boolean k(ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.readFully(this.c.d(), 0, 11, true)) {
            return false;
        }
        this.c.S(0);
        this.f = this.c.G();
        this.g = this.c.J();
        this.b = this.c.J();
        this.b = (((long) (this.c.G() << 24)) | this.b) * 1000;
        this.c.T(3);
        this.d = 4;
        return true;
    }

    public final void l(ExtractorInput extractorInput) throws IOException {
        extractorInput.skipFully(this.e);
        this.e = 0;
        this.d = 3;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        if (j2 == 0) {
            this.d = 1;
            this.f2758a = false;
        } else {
            this.d = 3;
        }
        this.e = 0;
    }
}
