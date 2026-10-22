package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class m implements ElementaryStreamReader {
    public static final int j = 0;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 3;
    public static final int n = 1024;
    public static final int o = 86;
    public static final int p = 224;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.d f3250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nm6 f3252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f3254a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3255a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3256b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f3257b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3258b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f3259c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public String f3260c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    public m(@Nullable String str) {
        this.f3254a = str;
        om6 om6Var = new om6(1024);
        this.f3253a = om6Var;
        this.f3252a = new nm6(om6Var.d());
        this.f3249a = -9223372036854775807L;
    }

    public static long c(nm6 nm6Var) {
        return nm6Var.h((nm6Var.h(2) + 1) * 8);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void a(om6 om6Var) throws ParserException {
        sb0.k(this.f3251a);
        while (om6Var.a() > 0) {
            int i = this.f30727a;
            if (i != 0) {
                if (i == 1) {
                    int iG = om6Var.G();
                    if ((iG & 224) == 224) {
                        this.d = iG;
                        this.f30727a = 2;
                    } else if (iG != 86) {
                        this.f30727a = 0;
                    }
                } else if (i == 2) {
                    int iG2 = ((this.d & (-225)) << 8) | om6Var.G();
                    this.c = iG2;
                    if (iG2 > this.f3253a.d().length) {
                        j(this.c);
                    }
                    this.b = 0;
                    this.f30727a = 3;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(om6Var.a(), this.c - this.b);
                    om6Var.k(this.f3252a.f18462a, this.b, iMin);
                    int i2 = this.b + iMin;
                    this.b = i2;
                    if (i2 == this.c) {
                        this.f3252a.q(0);
                        d(this.f3252a);
                        this.f30727a = 0;
                    }
                }
            } else if (om6Var.G() == 86) {
                this.f30727a = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        cVar.a();
        this.f3251a = extractorOutput.b(cVar.c(), 1);
        this.f3257b = cVar.b();
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
    public final void d(nm6 nm6Var) throws ParserException {
        if (!nm6Var.g()) {
            this.f3255a = true;
            i(nm6Var);
        } else if (!this.f3255a) {
            return;
        }
        if (this.e != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (this.f != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        h(nm6Var, g(nm6Var));
        if (this.f3258b) {
            nm6Var.s((int) this.f3256b);
        }
    }

    public final int e(nm6 nm6Var) throws ParserException {
        int iB = nm6Var.b();
        AacUtil.b bVarE = AacUtil.e(nm6Var, true);
        this.f3260c = bVarE.f2344a;
        this.h = bVarE.f30530a;
        this.i = bVarE.b;
        return iB - nm6Var.b();
    }

    public final void f(nm6 nm6Var) {
        int iH = nm6Var.h(3);
        this.g = iH;
        if (iH == 0) {
            nm6Var.s(8);
            return;
        }
        if (iH == 1) {
            nm6Var.s(9);
            return;
        }
        if (iH == 3 || iH == 4 || iH == 5) {
            nm6Var.s(6);
        } else {
            if (iH != 6 && iH != 7) {
                throw new IllegalStateException();
            }
            nm6Var.s(1);
        }
    }

    public final int g(nm6 nm6Var) throws ParserException {
        int iH;
        if (this.g != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        int i = 0;
        do {
            iH = nm6Var.h(8);
            i += iH;
        } while (iH == 255);
        return i;
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
    public final void h(nm6 nm6Var, int i) {
        int iE = nm6Var.e();
        if ((iE & 7) == 0) {
            this.f3253a.S(iE >> 3);
        } else {
            nm6Var.i(this.f3253a.d(), 0, i * 8);
            this.f3253a.S(0);
        }
        this.f3251a.c(this.f3253a, i);
        long j2 = this.f3249a;
        if (j2 != -9223372036854775807L) {
            this.f3251a.e(j2, 1, i, 0, null);
            this.f3249a += this.f3259c;
        }
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
    public final void i(nm6 nm6Var) throws ParserException {
        boolean zG;
        int iH = nm6Var.h(1);
        int iH2 = iH == 1 ? nm6Var.h(1) : 0;
        this.e = iH2;
        if (iH2 != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (iH == 1) {
            c(nm6Var);
        }
        if (!nm6Var.g()) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        this.f = nm6Var.h(6);
        int iH3 = nm6Var.h(4);
        int iH4 = nm6Var.h(3);
        if (iH3 != 0 || iH4 != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (iH == 0) {
            int iE = nm6Var.e();
            int iE2 = e(nm6Var);
            nm6Var.q(iE);
            byte[] bArr = new byte[(iE2 + 7) / 8];
            nm6Var.i(bArr, 0, iE2);
            com.google.android.exoplayer2.d dVarE = new com.google.android.exoplayer2.d.b().S(this.f3257b).e0("audio/mp4a-latm").I(this.f3260c).H(this.i).f0(this.h).T(Collections.singletonList(bArr)).V(this.f3254a).E();
            if (!dVarE.equals(this.f3250a)) {
                this.f3250a = dVarE;
                this.f3259c = 1024000000 / ((long) dVarE.V);
                this.f3251a.f(dVarE);
            }
        } else {
            nm6Var.s(((int) c(nm6Var)) - e(nm6Var));
        }
        f(nm6Var);
        boolean zG2 = nm6Var.g();
        this.f3258b = zG2;
        this.f3256b = 0L;
        if (zG2) {
            if (iH == 1) {
                this.f3256b = c(nm6Var);
            } else {
                do {
                    zG = nm6Var.g();
                    this.f3256b = (this.f3256b << 8) + ((long) nm6Var.h(8));
                } while (zG);
            }
        }
        if (nm6Var.g()) {
            nm6Var.s(8);
        }
    }

    public final void j(int i) {
        this.f3253a.O(i);
        this.f3252a.o(this.f3253a.d());
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j2, int i) {
        if (j2 != -9223372036854775807L) {
            this.f3249a = j2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f30727a = 0;
        this.f3249a = -9223372036854775807L;
        this.f3255a = false;
    }
}
