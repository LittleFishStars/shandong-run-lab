package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.q;
import com.zj.adlib.f27;
import com.zj.adlib.g27;
import com.zj.adlib.g89;
import com.zj.adlib.iv6;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class q implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30731a = new ExtractorsFactory() { // from class: com.zj.adlib.i27
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return q.e();
        }
    };
    public static final long b = 1048576;
    public static final long c = 8192;
    public static final int d = 442;
    public static final int e = 443;
    public static final int f = 1;
    public static final int g = 441;
    public static final int h = 256;
    public static final int i = 189;
    public static final int j = 192;
    public static final int k = 224;
    public static final int l = 224;
    public static final int m = 240;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3278a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<a> f3279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f3280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public f27 f3281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g27 f3282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g89 f3283a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3285a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3286b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3287c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f3288d;

    public static final class a {
        public static final int b = 64;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30732a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f3289a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ElementaryStreamReader f3290a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final g89 f3291a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final nm6 f3292a = new nm6(new byte[64]);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3293a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f3294b;
        public boolean c;

        public a(ElementaryStreamReader elementaryStreamReader, g89 g89Var) {
            this.f3290a = elementaryStreamReader;
            this.f3291a = g89Var;
        }

        public void a(om6 om6Var) throws ParserException {
            om6Var.k(this.f3292a.f18462a, 0, 3);
            this.f3292a.q(0);
            b();
            om6Var.k(this.f3292a.f18462a, 0, this.f30732a);
            this.f3292a.q(0);
            c();
            this.f3290a.packetStarted(this.f3289a, 4);
            this.f3290a.a(om6Var);
            this.f3290a.packetFinished();
        }

        public final void b() {
            this.f3292a.s(8);
            this.f3293a = this.f3292a.g();
            this.f3294b = this.f3292a.g();
            this.f3292a.s(6);
            this.f30732a = this.f3292a.h(8);
        }

        public final void c() {
            this.f3289a = 0L;
            if (this.f3293a) {
                this.f3292a.s(4);
                long jH = ((long) this.f3292a.h(3)) << 30;
                this.f3292a.s(1);
                long jH2 = jH | ((long) (this.f3292a.h(15) << 15));
                this.f3292a.s(1);
                long jH3 = jH2 | ((long) this.f3292a.h(15));
                this.f3292a.s(1);
                if (!this.c && this.f3294b) {
                    this.f3292a.s(4);
                    long jH4 = ((long) this.f3292a.h(3)) << 30;
                    this.f3292a.s(1);
                    long jH5 = jH4 | ((long) (this.f3292a.h(15) << 15));
                    this.f3292a.s(1);
                    long jH6 = jH5 | ((long) this.f3292a.h(15));
                    this.f3292a.s(1);
                    this.f3291a.b(jH6);
                    this.c = true;
                }
                this.f3289a = this.f3291a.b(jH3);
            }
        }

        public void d() {
            this.c = false;
            this.f3290a.seek();
        }
    }

    public q() {
        this(new g89(0L));
    }

    public static /* synthetic */ Extractor[] e() {
        return new Extractor[]{new q()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f3280a = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        ElementaryStreamReader hVar;
        sb0.k(this.f3280a);
        long length = extractorInput.getLength();
        if ((length != -1) && !this.f3282a.e()) {
            return this.f3282a.g(extractorInput, iv6Var);
        }
        f(length);
        f27 f27Var = this.f3281a;
        if (f27Var != null && f27Var.c()) {
            return this.f3281a.b(extractorInput, iv6Var);
        }
        extractorInput.resetPeekPosition();
        long peekPosition = length != -1 ? length - extractorInput.getPeekPosition() : -1L;
        if ((peekPosition != -1 && peekPosition < 4) || !extractorInput.peekFully(this.f3284a.d(), 0, 4, true)) {
            return -1;
        }
        this.f3284a.S(0);
        int iO = this.f3284a.o();
        if (iO == 441) {
            return -1;
        }
        if (iO == 442) {
            extractorInput.peekFully(this.f3284a.d(), 0, 10);
            this.f3284a.S(9);
            extractorInput.skipFully((this.f3284a.G() & 7) + 14);
            return 0;
        }
        if (iO == 443) {
            extractorInput.peekFully(this.f3284a.d(), 0, 2);
            this.f3284a.S(0);
            extractorInput.skipFully(this.f3284a.M() + 6);
            return 0;
        }
        if (((iO & (-256)) >> 8) != 1) {
            extractorInput.skipFully(1);
            return 0;
        }
        int i2 = iO & 255;
        a aVar = this.f3279a.get(i2);
        if (!this.f3285a) {
            if (aVar == null) {
                if (i2 == 189) {
                    hVar = new b();
                    this.f3286b = true;
                    this.f3278a = extractorInput.getPosition();
                } else if ((i2 & 224) == 192) {
                    hVar = new n();
                    this.f3286b = true;
                    this.f3278a = extractorInput.getPosition();
                } else if ((i2 & 240) == 224) {
                    hVar = new h();
                    this.f3287c = true;
                    this.f3278a = extractorInput.getPosition();
                } else {
                    hVar = null;
                }
                if (hVar != null) {
                    hVar.b(this.f3280a, new TsPayloadReader.c(i2, 256));
                    aVar = new a(hVar, this.f3283a);
                    this.f3279a.put(i2, aVar);
                }
            }
            if (extractorInput.getPosition() > ((this.f3286b && this.f3287c) ? this.f3278a + 8192 : 1048576L)) {
                this.f3285a = true;
                this.f3280a.endTracks();
            }
        }
        extractorInput.peekFully(this.f3284a.d(), 0, 2);
        this.f3284a.S(0);
        int iM = this.f3284a.M() + 6;
        if (aVar == null) {
            extractorInput.skipFully(iM);
        } else {
            this.f3284a.O(iM);
            extractorInput.readFully(this.f3284a.d(), 0, iM);
            this.f3284a.S(6);
            aVar.a(this.f3284a);
            om6 om6Var = this.f3284a;
            om6Var.R(om6Var.b());
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = new byte[14];
        extractorInput.peekFully(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.advancePeekPosition(bArr[13] & 7);
        extractorInput.peekFully(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
    public final void f(long j2) {
        if (this.f3288d) {
            return;
        }
        this.f3288d = true;
        if (this.f3282a.c() == -9223372036854775807L) {
            this.f3280a.d(new SeekMap.b(this.f3282a.c()));
            return;
        }
        f27 f27Var = new f27(this.f3282a.d(), this.f3282a.c(), j2);
        this.f3281a = f27Var;
        this.f3280a.d(f27Var.a());
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        boolean z = this.f3283a.e() == -9223372036854775807L;
        if (!z) {
            long jC = this.f3283a.c();
            z = (jC == -9223372036854775807L || jC == 0 || jC == j3) ? false : true;
        }
        if (z) {
            this.f3283a.g(j3);
        }
        f27 f27Var = this.f3281a;
        if (f27Var != null) {
            f27Var.d(j3);
        }
        for (int i2 = 0; i2 < this.f3279a.size(); i2++) {
            this.f3279a.valueAt(i2).d();
        }
    }

    public q(g89 g89Var) {
        this.f3283a = g89Var;
        this.f3284a = new om6(4096);
        this.f3279a = new SparseArray<>();
        this.f3282a = new g27();
    }
}
