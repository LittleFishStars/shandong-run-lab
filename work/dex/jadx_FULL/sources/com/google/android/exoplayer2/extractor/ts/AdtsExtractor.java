package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.zj.adlib.iv6;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AdtsExtractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30700a = new ExtractorsFactory() { // from class: com.zj.adlib.d20
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return AdtsExtractor.h();
        }
    };
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 2048;
    public static final int i = 8192;
    public static final int j = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f3060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e f3061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nm6 f3062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3064a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final om6 f3065b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3066b;
    public boolean c;
    public final int d;
    public int e;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public AdtsExtractor() {
        this(0);
    }

    public static int f(int i2, long j2) {
        return (int) (((((long) i2) * 8) * 1000000) / j2);
    }

    public static /* synthetic */ Extractor[] h() {
        return new Extractor[]{new AdtsExtractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f3060a = extractorOutput;
        this.f3061a.b(extractorOutput, new TsPayloadReader.c(0, 1));
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        sb0.k(this.f3060a);
        long length = extractorInput.getLength();
        int i2 = this.d;
        if (((i2 & 2) == 0 && ((i2 & 1) == 0 || length == -1)) ? false : true) {
            e(extractorInput);
        }
        int i3 = extractorInput.read(this.f3063a.d(), 0, 2048);
        boolean z = i3 == -1;
        i(length, z);
        if (z) {
            return -1;
        }
        this.f3063a.S(0);
        this.f3063a.R(i3);
        if (!this.f3066b) {
            this.f3061a.packetStarted(this.f3059a, 4);
            this.f3066b = true;
        }
        this.f3061a.a(this.f3063a);
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        int iJ = j(extractorInput);
        int i2 = iJ;
        int i3 = 0;
        int i4 = 0;
        do {
            extractorInput.peekFully(this.f3065b.d(), 0, 2);
            this.f3065b.S(0);
            if (e.j(this.f3065b.M())) {
                i3++;
                if (i3 >= 4 && i4 > 188) {
                    return true;
                }
                extractorInput.peekFully(this.f3065b.d(), 0, 4);
                this.f3062a.q(14);
                int iH = this.f3062a.h(13);
                if (iH <= 6) {
                    i2++;
                    extractorInput.resetPeekPosition();
                    extractorInput.advancePeekPosition(i2);
                } else {
                    extractorInput.advancePeekPosition(iH - 6);
                    i4 += iH;
                }
            } else {
                i2++;
                extractorInput.resetPeekPosition();
                extractorInput.advancePeekPosition(i2);
            }
            i3 = 0;
            i4 = 0;
        } while (i2 - iJ < 8192);
        return false;
    }

    public final void e(ExtractorInput extractorInput) throws IOException {
        if (this.f3064a) {
            return;
        }
        this.e = -1;
        extractorInput.resetPeekPosition();
        long j2 = 0;
        if (extractorInput.getPosition() == 0) {
            j(extractorInput);
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                if (extractorInput.peekFully(this.f3065b.d(), 0, 2, true)) {
                    this.f3065b.S(0);
                    if (!e.j(this.f3065b.M())) {
                        break;
                    }
                    if (extractorInput.peekFully(this.f3065b.d(), 0, 4, true)) {
                        this.f3062a.q(14);
                        int iH = this.f3062a.h(13);
                        if (iH <= 6) {
                            this.f3064a = true;
                            throw ParserException.createForMalformedContainer("Malformed ADTS stream", null);
                        }
                        j2 += (long) iH;
                        i3++;
                        if (i3 != 1000 && extractorInput.advancePeekPosition(iH - 6, true)) {
                        }
                    }
                }
            } catch (EOFException unused) {
            }
            i2 = i3;
            break;
        }
        extractorInput.resetPeekPosition();
        if (i2 > 0) {
            this.e = (int) (j2 / ((long) i2));
        } else {
            this.e = -1;
        }
        this.f3064a = true;
    }

    public final SeekMap g(long j2, boolean z) {
        return new com.google.android.exoplayer2.extractor.c(j2, this.b, f(this.e, this.f3061a.h()), this.e, z);
    }

    @RequiresNonNull({"extractorOutput"})
    public final void i(long j2, boolean z) {
        if (this.c) {
            return;
        }
        boolean z2 = (this.d & 1) != 0 && this.e > 0;
        if (z2 && this.f3061a.h() == -9223372036854775807L && !z) {
            return;
        }
        if (!z2 || this.f3061a.h() == -9223372036854775807L) {
            this.f3060a.d(new SeekMap.b(-9223372036854775807L));
        } else {
            this.f3060a.d(g(j2, (this.d & 2) != 0));
        }
        this.c = true;
    }

    public final int j(ExtractorInput extractorInput) throws IOException {
        int i2 = 0;
        while (true) {
            extractorInput.peekFully(this.f3065b.d(), 0, 10);
            this.f3065b.S(0);
            if (this.f3065b.J() != 4801587) {
                break;
            }
            this.f3065b.T(3);
            int iF = this.f3065b.F();
            i2 += iF + 10;
            extractorInput.advancePeekPosition(iF);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i2);
        if (this.b == -1) {
            this.b = i2;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        this.f3066b = false;
        this.f3061a.seek();
        this.f3059a = j3;
    }

    public AdtsExtractor(int i2) {
        this.d = (i2 & 2) != 0 ? i2 | 1 : i2;
        this.f3061a = new e(true);
        this.f3063a = new om6(2048);
        this.e = -1;
        this.b = -1L;
        om6 om6Var = new om6(10);
        this.f3065b = om6Var;
        this.f3062a = new nm6(om6Var.d());
    }
}
