package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ogg.c;
import com.zj.adlib.e86;
import com.zj.adlib.iv6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30696a = new ExtractorsFactory() { // from class: com.zj.adlib.c86
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return c.e();
        }
    };
    public static final int d = 8;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f3050a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StreamReader f3051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3052a;

    public static /* synthetic */ Extractor[] e() {
        return new Extractor[]{new c()};
    }

    public static om6 f(om6 om6Var) {
        om6Var.S(0);
        return om6Var;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f3050a = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        sb0.k(this.f3050a);
        if (this.f3051a == null) {
            if (!g(extractorInput)) {
                throw ParserException.createForMalformedContainer("Failed to determine bitstream type", null);
            }
            extractorInput.resetPeekPosition();
        }
        if (!this.f3052a) {
            TrackOutput trackOutputB = this.f3050a.b(0, 1);
            this.f3050a.endTracks();
            this.f3051a.b(this.f3050a, trackOutputB);
            this.f3052a = true;
        }
        return this.f3051a.c(extractorInput, iv6Var);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        try {
            return g(extractorInput);
        } catch (ParserException unused) {
            return false;
        }
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    public final boolean g(ExtractorInput extractorInput) throws IOException {
        e86 e86Var = new e86();
        if (e86Var.a(extractorInput, true) && (e86Var.b & 2) == 2) {
            int iMin = Math.min(e86Var.e, 8);
            om6 om6Var = new om6(iMin);
            extractorInput.peekFully(om6Var.d(), 0, iMin);
            if (b.j(f(om6Var))) {
                this.f3051a = new b();
            } else if (e.l(f(om6Var))) {
                this.f3051a = new e();
            } else if (d.j(f(om6Var))) {
                this.f3051a = new d();
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        StreamReader streamReader = this.f3051a;
        if (streamReader != null) {
            streamReader.g(j, j2);
        }
    }
}
