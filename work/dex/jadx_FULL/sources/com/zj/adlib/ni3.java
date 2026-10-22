package com.zj.adlib;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.g;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ni3 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f43530a;
    }

    public static boolean a(om6 om6Var, g gVar, int i) {
        int iJ = j(om6Var, i);
        return iJ != -1 && iJ <= gVar.b;
    }

    public static boolean b(om6 om6Var, int i) {
        return om6Var.G() == gj9.w(om6Var.d(), i, om6Var.e() - 1, 0);
    }

    public static boolean c(om6 om6Var, g gVar, boolean z, a aVar) {
        try {
            long jN = om6Var.N();
            if (!z) {
                jN *= (long) gVar.b;
            }
            aVar.f43530a = jN;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(om6 om6Var, g gVar, int i, a aVar) {
        int iE = om6Var.e();
        long jI = om6Var.I();
        long j = jI >>> 16;
        if (j != i) {
            return false;
        }
        return g((int) ((jI >> 4) & 15), gVar) && f((int) ((jI >> 1) & 7), gVar) && !(((jI & 1) > 1L ? 1 : ((jI & 1) == 1L ? 0 : -1)) == 0) && c(om6Var, gVar, ((j & 1) > 1L ? 1 : ((j & 1) == 1L ? 0 : -1)) == 0, aVar) && a(om6Var, gVar, (int) ((jI >> 12) & 15)) && e(om6Var, gVar, (int) ((jI >> 8) & 15)) && b(om6Var, iE);
    }

    public static boolean e(om6 om6Var, g gVar, int i) {
        int i2 = gVar.e;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            return i == gVar.f;
        }
        if (i == 12) {
            return om6Var.G() * 1000 == i2;
        }
        if (i > 14) {
            return false;
        }
        int iM = om6Var.M();
        if (i == 14) {
            iM *= 10;
        }
        return iM == i2;
    }

    public static boolean f(int i, g gVar) {
        return i == 0 || i == gVar.i;
    }

    public static boolean g(int i, g gVar) {
        if (i <= 7) {
            return i == gVar.g - 1;
        }
        return i <= 10 && gVar.g == 2;
    }

    public static boolean h(ExtractorInput extractorInput, g gVar, int i, a aVar) throws IOException {
        long peekPosition = extractorInput.getPeekPosition();
        byte[] bArr = new byte[2];
        extractorInput.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
            return false;
        }
        om6 om6Var = new om6(16);
        System.arraycopy(bArr, 0, om6Var.d(), 0, 2);
        om6Var.R(fc3.c(extractorInput, om6Var.d(), 2, 14));
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
        return d(om6Var, gVar, i, aVar);
    }

    public static long i(ExtractorInput extractorInput, g gVar) throws IOException {
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        extractorInput.peekFully(bArr, 0, 1);
        boolean z = (bArr[0] & 1) == 1;
        extractorInput.advancePeekPosition(2);
        int i = z ? 7 : 6;
        om6 om6Var = new om6(i);
        om6Var.R(fc3.c(extractorInput, om6Var.d(), 0, i));
        extractorInput.resetPeekPosition();
        a aVar = new a();
        if (c(om6Var, gVar, z, aVar)) {
            return aVar.f43530a;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static int j(om6 om6Var, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return hs5.f << (i - 2);
            case 6:
                return om6Var.G() + 1;
            case 7:
                return om6Var.M() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }
}
