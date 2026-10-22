package com.google.android.exoplayer2.extractor.avi;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.UnmodifiableIterator;
import com.zj.adlib.bp5;
import com.zj.adlib.iv6;
import com.zj.adlib.om6;
import com.zj.adlib.os2;
import com.zj.adlib.sb0;
import com.zj.adlib.vk1;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements Extractor {
    public static final int A = 5;
    public static final int B = 6;
    public static final int C = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30629a = "AviExtractor";
    public static final long e = 262144;
    public static final int g = 1179011410;
    public static final int h = 541677121;
    public static final int i = 1414744396;
    public static final int j = 1751742049;
    public static final int k = 1819436136;
    public static final int l = 1819440243;
    public static final int m = 1769369453;
    public static final int n = 829973609;
    public static final int o = 1263424842;
    public static final int p = 1718776947;
    public static final int q = 1852994675;
    public static final int r = 1752331379;
    public static final int s = 1935963489;
    public static final int t = 1937012852;
    public static final int u = 1935960438;
    public static final int v = 0;
    public static final int w = 1;
    public static final int x = 2;
    public static final int y = 3;
    public static final int z = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.extractor.avi.b f2723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public vk1 f2725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2726a;
    public long b;
    public int d;
    public int f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f2724a = new om6(12);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f2722a = new c();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f2721a = new os2();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public vk1[] f2727a = new vk1[0];
    public long c = -1;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f2728d = -1;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f2729e = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2720a = -9223372036854775807L;

    public class b implements SeekMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30630a;

        public b(long j) {
            this.f30630a = j;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.a a(long j) {
            SeekMap.a aVarI = a.this.f2727a[0].i(j);
            for (int i = 1; i < a.this.f2727a.length; i++) {
                SeekMap.a aVarI2 = a.this.f2727a[i].i(j);
                if (aVarI2.f30623a.b < aVarI.f30623a.b) {
                    aVarI = aVarI2;
                }
            }
            return aVarI;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.f30630a;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30631a;
        public int b;
        public int c;

        public c() {
        }

        public void a(om6 om6Var) {
            this.f30631a = om6Var.r();
            this.b = om6Var.r();
            this.c = 0;
        }

        public void b(om6 om6Var) throws ParserException {
            a(om6Var);
            if (this.f30631a == 1414744396) {
                this.c = om6Var.r();
                return;
            }
            throw ParserException.createForMalformedContainer("LIST expected, found: " + this.f30631a, null);
        }
    }

    public static void e(ExtractorInput extractorInput) throws IOException {
        if ((extractorInput.getPosition() & 1) == 1) {
            extractorInput.skipFully(1);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.d = 0;
        this.f2721a = extractorOutput;
        this.b = -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        if (l(extractorInput, iv6Var)) {
            return 1;
        }
        switch (this.d) {
            case 0:
                if (!d(extractorInput)) {
                    throw ParserException.createForMalformedContainer("AVI Header List not found", null);
                }
                extractorInput.skipFully(12);
                this.d = 1;
                return 0;
            case 1:
                extractorInput.readFully(this.f2724a.d(), 0, 12);
                this.f2724a.S(0);
                this.f2722a.b(this.f2724a);
                c cVar = this.f2722a;
                if (cVar.c == 1819436136) {
                    this.f2729e = cVar.b;
                    this.d = 2;
                    return 0;
                }
                throw ParserException.createForMalformedContainer("hdrl expected, found: " + this.f2722a.c, null);
            case 2:
                int i2 = this.f2729e - 4;
                om6 om6Var = new om6(i2);
                extractorInput.readFully(om6Var.d(), 0, i2);
                g(om6Var);
                this.d = 3;
                return 0;
            case 3:
                if (this.c != -1) {
                    long position = extractorInput.getPosition();
                    long j2 = this.c;
                    if (position != j2) {
                        this.b = j2;
                        return 0;
                    }
                }
                extractorInput.peekFully(this.f2724a.d(), 0, 12);
                extractorInput.resetPeekPosition();
                this.f2724a.S(0);
                this.f2722a.a(this.f2724a);
                int iR = this.f2724a.r();
                int i3 = this.f2722a.f30631a;
                if (i3 == 1179011410) {
                    extractorInput.skipFully(12);
                    return 0;
                }
                if (i3 != 1414744396 || iR != 1769369453) {
                    this.b = extractorInput.getPosition() + ((long) this.f2722a.b) + 8;
                    return 0;
                }
                long position2 = extractorInput.getPosition();
                this.c = position2;
                this.f2728d = position2 + ((long) this.f2722a.b) + 8;
                if (!this.f2726a) {
                    if (((com.google.android.exoplayer2.extractor.avi.b) sb0.g(this.f2723a)).a()) {
                        this.d = 4;
                        this.b = this.f2728d;
                        return 0;
                    }
                    this.f2721a.d(new SeekMap.b(this.f2720a));
                    this.f2726a = true;
                }
                this.b = extractorInput.getPosition() + 12;
                this.d = 6;
                return 0;
            case 4:
                extractorInput.readFully(this.f2724a.d(), 0, 8);
                this.f2724a.S(0);
                int iR2 = this.f2724a.r();
                int iR3 = this.f2724a.r();
                if (iR2 == 829973609) {
                    this.d = 5;
                    this.f = iR3;
                } else {
                    this.b = extractorInput.getPosition() + ((long) iR3);
                }
                return 0;
            case 5:
                om6 om6Var2 = new om6(this.f);
                extractorInput.readFully(om6Var2.d(), 0, this.f);
                h(om6Var2);
                this.d = 6;
                this.b = this.c;
                return 0;
            case 6:
                return k(extractorInput);
            default:
                throw new AssertionError();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        extractorInput.peekFully(this.f2724a.d(), 0, 12);
        this.f2724a.S(0);
        if (this.f2724a.r() != 1179011410) {
            return false;
        }
        this.f2724a.T(4);
        return this.f2724a.r() == 541677121;
    }

    @Nullable
    public final vk1 f(int i2) {
        for (vk1 vk1Var : this.f2727a) {
            if (vk1Var.j(i2)) {
                return vk1Var;
            }
        }
        return null;
    }

    public final void g(om6 om6Var) throws IOException {
        d dVarC = d.c(1819436136, om6Var);
        if (dVarC.getType() != 1819436136) {
            throw ParserException.createForMalformedContainer("Unexpected header list type " + dVarC.getType(), null);
        }
        com.google.android.exoplayer2.extractor.avi.b bVar = (com.google.android.exoplayer2.extractor.avi.b) dVarC.b(com.google.android.exoplayer2.extractor.avi.b.class);
        if (bVar == null) {
            throw ParserException.createForMalformedContainer("AviHeader not found", null);
        }
        this.f2723a = bVar;
        this.f2720a = ((long) bVar.c) * ((long) bVar.f30632a);
        ArrayList arrayList = new ArrayList();
        UnmodifiableIterator<AviChunk> it = dVarC.f2732a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            AviChunk next = it.next();
            if (next.getType() == 1819440243) {
                int i3 = i2 + 1;
                vk1 vk1VarJ = j((d) next, i2);
                if (vk1VarJ != null) {
                    arrayList.add(vk1VarJ);
                }
                i2 = i3;
            }
        }
        this.f2727a = (vk1[]) arrayList.toArray(new vk1[0]);
        this.f2721a.endTracks();
    }

    public final void h(om6 om6Var) {
        long jI = i(om6Var);
        while (om6Var.a() >= 16) {
            int iR = om6Var.r();
            int iR2 = om6Var.r();
            long jR = ((long) om6Var.r()) + jI;
            om6Var.r();
            vk1 vk1VarF = f(iR);
            if (vk1VarF != null) {
                if ((iR2 & 16) == 16) {
                    vk1VarF.b(jR);
                }
                vk1VarF.k();
            }
        }
        for (vk1 vk1Var : this.f2727a) {
            vk1Var.c();
        }
        this.f2726a = true;
        this.f2721a.d(new b(this.f2720a));
    }

    public final long i(om6 om6Var) {
        if (om6Var.a() < 16) {
            return 0L;
        }
        int iE = om6Var.e();
        om6Var.T(8);
        long jR = om6Var.r();
        long j2 = this.c;
        long j3 = jR <= j2 ? j2 + 8 : 0L;
        om6Var.S(iE);
        return j3;
    }

    @Nullable
    public final vk1 j(d dVar, int i2) {
        com.google.android.exoplayer2.extractor.avi.c cVar = (com.google.android.exoplayer2.extractor.avi.c) dVar.b(com.google.android.exoplayer2.extractor.avi.c.class);
        e eVar = (e) dVar.b(e.class);
        if (cVar == null) {
            Log.n(f30629a, "Missing Stream Header");
            return null;
        }
        if (eVar == null) {
            Log.n(f30629a, "Missing Stream Format");
            return null;
        }
        long jA = cVar.a();
        com.google.android.exoplayer2.d dVar2 = eVar.f2733a;
        com.google.android.exoplayer2.d.b bVarB = dVar2.b();
        bVarB.R(i2);
        int i3 = cVar.f;
        if (i3 != 0) {
            bVarB.W(i3);
        }
        f fVar = (f) dVar.b(f.class);
        if (fVar != null) {
            bVarB.U(fVar.f30636a);
        }
        int iL = bp5.l(dVar2.k);
        if (iL != 1 && iL != 2) {
            return null;
        }
        TrackOutput trackOutputB = this.f2721a.b(i2, iL);
        trackOutputB.f(bVarB.E());
        vk1 vk1Var = new vk1(i2, iL, jA, cVar.e, trackOutputB);
        this.f2720a = jA;
        return vk1Var;
    }

    public final int k(ExtractorInput extractorInput) throws IOException {
        if (extractorInput.getPosition() >= this.f2728d) {
            return -1;
        }
        vk1 vk1Var = this.f2725a;
        if (vk1Var == null) {
            e(extractorInput);
            extractorInput.peekFully(this.f2724a.d(), 0, 12);
            this.f2724a.S(0);
            int iR = this.f2724a.r();
            if (iR == 1414744396) {
                this.f2724a.S(8);
                extractorInput.skipFully(this.f2724a.r() != 1769369453 ? 8 : 12);
                extractorInput.resetPeekPosition();
                return 0;
            }
            int iR2 = this.f2724a.r();
            if (iR == 1263424842) {
                this.b = extractorInput.getPosition() + ((long) iR2) + 8;
                return 0;
            }
            extractorInput.skipFully(8);
            extractorInput.resetPeekPosition();
            vk1 vk1VarF = f(iR);
            if (vk1VarF == null) {
                this.b = extractorInput.getPosition() + ((long) iR2);
                return 0;
            }
            vk1VarF.p(iR2);
            this.f2725a = vk1VarF;
        } else if (vk1Var.o(extractorInput)) {
            this.f2725a = null;
        }
        return 0;
    }

    public final boolean l(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        boolean z2;
        if (this.b != -1) {
            long position = extractorInput.getPosition();
            long j2 = this.b;
            if (j2 < position || j2 > 262144 + position) {
                iv6Var.f42452a = j2;
                z2 = true;
            } else {
                extractorInput.skipFully((int) (j2 - position));
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.b = -1L;
        return z2;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        this.b = -1L;
        this.f2725a = null;
        for (vk1 vk1Var : this.f2727a) {
            vk1Var.q(j2);
        }
        if (j2 != 0) {
            this.d = 6;
        } else if (this.f2727a.length == 0) {
            this.d = 0;
        } else {
            this.d = 3;
        }
    }
}
