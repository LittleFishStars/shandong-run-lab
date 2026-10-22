package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import com.zj.adlib.u54;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30640a = 1716281667;
    public static final int b = 16382;
    public static final int c = 18;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public g f30641a;

        public a(@Nullable g gVar) {
            this.f30641a = gVar;
        }
    }

    public static boolean a(ExtractorInput extractorInput) throws IOException {
        om6 om6Var = new om6(4);
        extractorInput.peekFully(om6Var.d(), 0, 4);
        return om6Var.I() == 1716281667;
    }

    public static int b(ExtractorInput extractorInput) throws IOException {
        extractorInput.resetPeekPosition();
        om6 om6Var = new om6(2);
        extractorInput.peekFully(om6Var.d(), 0, 2);
        int iM = om6Var.M();
        if ((iM >> 2) == 16382) {
            extractorInput.resetPeekPosition();
            return iM;
        }
        extractorInput.resetPeekPosition();
        throw ParserException.createForMalformedContainer("First frame does not start with sync code.", null);
    }

    @Nullable
    public static Metadata c(ExtractorInput extractorInput, boolean z) throws IOException {
        Metadata metadataA = new u54().a(extractorInput, z ? null : Id3Decoder.f3476b);
        if (metadataA == null || metadataA.length() == 0) {
            return null;
        }
        return metadataA;
    }

    @Nullable
    public static Metadata d(ExtractorInput extractorInput, boolean z) throws IOException {
        extractorInput.resetPeekPosition();
        long peekPosition = extractorInput.getPeekPosition();
        Metadata metadataC = c(extractorInput, z);
        extractorInput.skipFully((int) (extractorInput.getPeekPosition() - peekPosition));
        return metadataC;
    }

    public static boolean e(ExtractorInput extractorInput, a aVar) throws IOException {
        extractorInput.resetPeekPosition();
        nm6 nm6Var = new nm6(new byte[4]);
        extractorInput.peekFully(nm6Var.f18462a, 0, 4);
        boolean zG = nm6Var.g();
        int iH = nm6Var.h(7);
        int iH2 = nm6Var.h(24) + 4;
        if (iH == 0) {
            aVar.f30641a = h(extractorInput);
        } else {
            g gVar = aVar.f30641a;
            if (gVar == null) {
                throw new IllegalArgumentException();
            }
            if (iH == 3) {
                aVar.f30641a = gVar.c(f(extractorInput, iH2));
            } else if (iH == 4) {
                aVar.f30641a = gVar.d(j(extractorInput, iH2));
            } else if (iH == 6) {
                om6 om6Var = new om6(iH2);
                extractorInput.readFully(om6Var.d(), 0, iH2);
                om6Var.T(4);
                aVar.f30641a = gVar.b(ImmutableList.of(PictureFrame.fromPictureBlock(om6Var)));
            } else {
                extractorInput.skipFully(iH2);
            }
        }
        return zG;
    }

    public static g.a f(ExtractorInput extractorInput, int i) throws IOException {
        om6 om6Var = new om6(i);
        extractorInput.readFully(om6Var.d(), 0, i);
        return g(om6Var);
    }

    public static g.a g(om6 om6Var) {
        om6Var.T(1);
        int iJ = om6Var.J();
        long jE = ((long) om6Var.e()) + ((long) iJ);
        int i = iJ / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            long jZ = om6Var.z();
            if (jZ == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jZ;
            jArrCopyOf2[i2] = om6Var.z();
            om6Var.T(2);
        }
        om6Var.T((int) (jE - ((long) om6Var.e())));
        return new g.a(jArrCopyOf, jArrCopyOf2);
    }

    public static g h(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = new byte[38];
        extractorInput.readFully(bArr, 0, 38);
        return new g(bArr, 4);
    }

    public static void i(ExtractorInput extractorInput) throws IOException {
        om6 om6Var = new om6(4);
        extractorInput.readFully(om6Var.d(), 0, 4);
        if (om6Var.I() != 1716281667) {
            throw ParserException.createForMalformedContainer("Failed to read FLAC stream marker.", null);
        }
    }

    public static List<String> j(ExtractorInput extractorInput, int i) throws IOException {
        om6 om6Var = new om6(i);
        extractorInput.readFully(om6Var.d(), 0, i);
        om6Var.T(4);
        return Arrays.asList(j.j(om6Var, false, false).f2786a);
    }
}
