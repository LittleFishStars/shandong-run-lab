package com.google.android.exoplayer2.extractor.flac;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.flac.FlacExtractor;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.metadata.Metadata;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.ji3;
import com.zj.adlib.ni3;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class FlacExtractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30643a = new ExtractorsFactory() { // from class: com.zj.adlib.mi3
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return FlacExtractor.i();
        }
    };
    public static final int h = 1;
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    public static final int m = 4;
    public static final int n = 5;
    public static final int o = 32768;
    public static final int p = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f2740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f2741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f2742a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Metadata f2743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ji3 f2744a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ni3.a f2745a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f2746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2747a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f2748a;
    public int d;
    public int e;
    public int f;
    public int g;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public FlacExtractor() {
        this(0);
    }

    public static /* synthetic */ Extractor[] i() {
        return new Extractor[]{new FlacExtractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f2740a = extractorOutput;
        this.f2741a = extractorOutput.b(0, 1);
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        int i2 = this.d;
        if (i2 == 0) {
            l(extractorInput);
            return 0;
        }
        if (i2 == 1) {
            h(extractorInput);
            return 0;
        }
        if (i2 == 2) {
            n(extractorInput);
            return 0;
        }
        if (i2 == 3) {
            m(extractorInput);
            return 0;
        }
        if (i2 == 4) {
            f(extractorInput);
            return 0;
        }
        if (i2 == 5) {
            return k(extractorInput, iv6Var);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        e.c(extractorInput, false);
        return e.a(extractorInput);
    }

    public final long e(om6 om6Var, boolean z) {
        boolean zD;
        sb0.g(this.f2742a);
        int iE = om6Var.e();
        while (iE <= om6Var.f() - 16) {
            om6Var.S(iE);
            if (ni3.d(om6Var, this.f2742a, this.f, this.f2745a)) {
                om6Var.S(iE);
                return this.f2745a.f43530a;
            }
            iE++;
        }
        if (!z) {
            om6Var.S(iE);
            return -1L;
        }
        while (iE <= om6Var.f() - this.e) {
            om6Var.S(iE);
            try {
                zD = ni3.d(om6Var, this.f2742a, this.f, this.f2745a);
            } catch (IndexOutOfBoundsException unused) {
                zD = false;
            }
            if (om6Var.e() <= om6Var.f() ? zD : false) {
                om6Var.S(iE);
                return this.f2745a.f43530a;
            }
            iE++;
        }
        om6Var.S(om6Var.f());
        return -1L;
    }

    public final void f(ExtractorInput extractorInput) throws IOException {
        this.f = e.b(extractorInput);
        ((ExtractorOutput) gj9.k(this.f2740a)).d(g(extractorInput.getPosition(), extractorInput.getLength()));
        this.d = 5;
    }

    public final SeekMap g(long j2, long j3) {
        sb0.g(this.f2742a);
        g gVar = this.f2742a;
        if (gVar.f2776a != null) {
            return new f(gVar, j2);
        }
        if (j3 == -1 || gVar.f2775a <= 0) {
            return new SeekMap.b(gVar.h());
        }
        ji3 ji3Var = new ji3(gVar, this.f, j2, j3);
        this.f2744a = ji3Var;
        return ji3Var.a();
    }

    public final void h(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = this.f2748a;
        extractorInput.peekFully(bArr, 0, bArr.length);
        extractorInput.resetPeekPosition();
        this.d = 2;
    }

    public final void j() {
        ((TrackOutput) gj9.k(this.f2741a)).e((this.f2739a * 1000000) / ((long) ((g) gj9.k(this.f2742a)).e), 1, this.g, 0, null);
    }

    public final int k(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        boolean z;
        sb0.g(this.f2741a);
        sb0.g(this.f2742a);
        ji3 ji3Var = this.f2744a;
        if (ji3Var != null && ji3Var.c()) {
            return this.f2744a.b(extractorInput, iv6Var);
        }
        if (this.f2739a == -1) {
            this.f2739a = ni3.i(extractorInput, this.f2742a);
            return 0;
        }
        int iF = this.f2746a.f();
        if (iF < 32768) {
            int i2 = extractorInput.read(this.f2746a.d(), iF, 32768 - iF);
            z = i2 == -1;
            if (!z) {
                this.f2746a.R(iF + i2);
            } else if (this.f2746a.a() == 0) {
                j();
                return -1;
            }
        } else {
            z = false;
        }
        int iE = this.f2746a.e();
        int i3 = this.g;
        int i4 = this.e;
        if (i3 < i4) {
            om6 om6Var = this.f2746a;
            om6Var.T(Math.min(i4 - i3, om6Var.a()));
        }
        long jE = e(this.f2746a, z);
        int iE2 = this.f2746a.e() - iE;
        this.f2746a.S(iE);
        this.f2741a.c(this.f2746a, iE2);
        this.g += iE2;
        if (jE != -1) {
            j();
            this.g = 0;
            this.f2739a = jE;
        }
        if (this.f2746a.a() < 16) {
            int iA = this.f2746a.a();
            System.arraycopy(this.f2746a.d(), this.f2746a.e(), this.f2746a.d(), 0, iA);
            this.f2746a.S(0);
            this.f2746a.R(iA);
        }
        return 0;
    }

    public final void l(ExtractorInput extractorInput) throws IOException {
        this.f2743a = e.d(extractorInput, !this.f2747a);
        this.d = 1;
    }

    public final void m(ExtractorInput extractorInput) throws IOException {
        e.a aVar = new e.a(this.f2742a);
        boolean zE = false;
        while (!zE) {
            zE = e.e(extractorInput, aVar);
            this.f2742a = (g) gj9.k(aVar.f30641a);
        }
        sb0.g(this.f2742a);
        this.e = Math.max(this.f2742a.c, 6);
        ((TrackOutput) gj9.k(this.f2741a)).f(this.f2742a.i(this.f2748a, this.f2743a));
        this.d = 4;
    }

    public final void n(ExtractorInput extractorInput) throws IOException {
        e.i(extractorInput);
        this.d = 3;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        if (j2 == 0) {
            this.d = 0;
        } else {
            ji3 ji3Var = this.f2744a;
            if (ji3Var != null) {
                ji3Var.d(j3);
            }
        }
        this.f2739a = j3 != 0 ? -1L : 0L;
        this.g = 0;
        this.f2746a.O(0);
    }

    public FlacExtractor(int i2) {
        this.f2748a = new byte[42];
        this.f2746a = new om6(new byte[32768], 0);
        this.f2747a = (i2 & 1) != 0;
        this.f2745a = new ni3.a();
        this.d = 0;
    }
}
