package com.zj.adlib;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class au9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40614a = "WavHeaderReader";

    public static final class a {
        public static final int b = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f40615a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f15398a;

        public a(int i, long j) {
            this.f40615a = i;
            this.f15398a = j;
        }

        public static a a(ExtractorInput extractorInput, om6 om6Var) throws IOException {
            extractorInput.peekFully(om6Var.d(), 0, 8);
            om6Var.S(0);
            return new a(om6Var.o(), om6Var.v());
        }
    }

    public static boolean a(ExtractorInput extractorInput) throws IOException {
        om6 om6Var = new om6(8);
        int i = a.a(extractorInput, om6Var).f40615a;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        extractorInput.peekFully(om6Var.d(), 0, 4);
        om6Var.S(0);
        int iO = om6Var.o();
        if (iO == 1463899717) {
            return true;
        }
        Log.d(f40614a, "Unsupported form type: " + iO);
        return false;
    }

    public static zt9 b(ExtractorInput extractorInput) throws IOException {
        byte[] bArr;
        om6 om6Var = new om6(16);
        a aVarD = d(1718449184, extractorInput, om6Var);
        sb0.i(aVarD.f15398a >= 16);
        extractorInput.peekFully(om6Var.d(), 0, 16);
        om6Var.S(0);
        int iY = om6Var.y();
        int iY2 = om6Var.y();
        int iX = om6Var.x();
        int iX2 = om6Var.x();
        int iY3 = om6Var.y();
        int iY4 = om6Var.y();
        int i = ((int) aVarD.f15398a) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            extractorInput.peekFully(bArr2, 0, i);
            bArr = bArr2;
        } else {
            bArr = gj9.f16790a;
        }
        extractorInput.skipFully((int) (extractorInput.getPeekPosition() - extractorInput.getPosition()));
        return new zt9(iY, iY2, iX, iX2, iY3, iY4, bArr);
    }

    public static long c(ExtractorInput extractorInput) throws IOException {
        om6 om6Var = new om6(8);
        a aVarA = a.a(extractorInput, om6Var);
        if (aVarA.f40615a != 1685272116) {
            extractorInput.resetPeekPosition();
            return -1L;
        }
        extractorInput.advancePeekPosition(8);
        om6Var.S(0);
        extractorInput.peekFully(om6Var.d(), 0, 8);
        long jT = om6Var.t();
        extractorInput.skipFully(((int) aVarA.f15398a) + 8);
        return jT;
    }

    public static a d(int i, ExtractorInput extractorInput, om6 om6Var) throws IOException {
        a aVarA = a.a(extractorInput, om6Var);
        while (aVarA.f40615a != i) {
            Log.n(f40614a, "Ignoring unknown WAV chunk: " + aVarA.f40615a);
            long j = aVarA.f15398a + 8;
            if (j > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Chunk is too large (~2GB+) to skip; id: " + aVarA.f40615a);
            }
            extractorInput.skipFully((int) j);
            aVarA = a.a(extractorInput, om6Var);
        }
        return aVarA;
    }

    public static Pair<Long, Long> e(ExtractorInput extractorInput) throws IOException {
        extractorInput.resetPeekPosition();
        a aVarD = d(1684108385, extractorInput, new om6(8));
        extractorInput.skipFully(8);
        return Pair.create(Long.valueOf(extractorInput.getPosition()), Long.valueOf(aVarD.f15398a));
    }
}
