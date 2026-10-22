package com.google.android.exoplayer2.extractor.ogg;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.extractor.g;
import com.zj.adlib.gj9;
import com.zj.adlib.ni3;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends StreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f30694a = -1;
    public static final int g = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public g f3046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public a f3047a;

    public static final class a implements OggSeeker {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public g.a f3048a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public g f3049a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30695a = -1;
        public long b = -1;

        public a(g gVar, g.a aVar) {
            this.f3049a = gVar;
            this.f3048a = aVar;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long a(ExtractorInput extractorInput) {
            long j = this.b;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.b = -1L;
            return j2;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public SeekMap b() {
            sb0.i(this.f30695a != -1);
            return new f(this.f3049a, this.f30695a);
        }

        public void c(long j) {
            this.f30695a = j;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public void startSeek(long j) {
            long[] jArr = this.f3048a.f30650a;
            this.b = jArr[gj9.j(jArr, j, true, true)];
        }
    }

    public static boolean i(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean j(om6 om6Var) {
        return om6Var.a() >= 5 && om6Var.G() == 127 && om6Var.I() == 1179402563;
    }

    public final int h(om6 om6Var) {
        int i = (om6Var.d()[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            om6Var.T(4);
            om6Var.N();
        }
        int iJ = ni3.j(om6Var, i);
        om6Var.S(0);
        return iJ;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long preparePayload(om6 om6Var) {
        if (i(om6Var.d())) {
            return h(om6Var);
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean readHeaders(om6 om6Var, long j, StreamReader.b bVar) {
        byte[] bArrD = om6Var.d();
        g gVar = this.f3046a;
        if (gVar == null) {
            g gVar2 = new g(bArrD, 17);
            this.f3046a = gVar2;
            bVar.f30691a = gVar2.i(Arrays.copyOfRange(bArrD, 9, om6Var.f()), null);
            return true;
        }
        if ((bArrD[0] & 127) == 3) {
            g.a aVarG = com.google.android.exoplayer2.extractor.e.g(om6Var);
            g gVarC = gVar.c(aVarG);
            this.f3046a = gVarC;
            this.f3047a = new a(gVarC, aVarG);
            return true;
        }
        if (!i(bArrD)) {
            return true;
        }
        a aVar = this.f3047a;
        if (aVar != null) {
            aVar.c(j);
            bVar.f3034a = this.f3047a;
        }
        sb0.g(bVar.f30691a);
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.f3046a = null;
            this.f3047a = null;
        }
    }
}
