package com.google.android.exoplayer2.extractor;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.vorbis.VorbisComment;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.om6;
import com.zj.adlib.ss9;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30653a = "VorbisUtil";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30654a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f2783a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long[] f2784a;
        public final int b;
        public final int c;

        public a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.f30654a = i;
            this.b = i2;
            this.f2784a = jArr;
            this.c = i3;
            this.f2783a = z;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30655a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f2785a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String[] f2786a;

        public b(String str, String[] strArr, int i) {
            this.f2785a = str;
            this.f2786a = strArr;
            this.f30655a = i;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30656a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f2787a;
        public final int b;
        public final int c;

        public c(boolean z, int i, int i2, int i3) {
            this.f2787a = z;
            this.f30656a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30657a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f2788a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f2789a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;

        public d(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr) {
            this.f30657a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.f2788a = z;
            this.f2789a = bArr;
        }
    }

    public static int a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static long b(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    @Nullable
    public static Metadata c(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] strArrV1 = gj9.v1(str, "=");
            if (strArrV1.length != 2) {
                Log.n(f30653a, "Failed to parse Vorbis comment: " + str);
            } else if (strArrV1[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.fromPictureBlock(new om6(Base64.decode(strArrV1[1], 0))));
                } catch (RuntimeException e) {
                    Log.o(f30653a, "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new VorbisComment(strArrV1[0], strArrV1[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static a d(ss9 ss9Var) throws ParserException {
        if (ss9Var.e(24) != 5653314) {
            throw ParserException.createForMalformedContainer("expected code book to start with [0x56, 0x43, 0x42] at " + ss9Var.c(), null);
        }
        int iE = ss9Var.e(16);
        int iE2 = ss9Var.e(24);
        long[] jArr = new long[iE2];
        boolean zD = ss9Var.d();
        long jB = 0;
        if (zD) {
            int iE3 = ss9Var.e(5) + 1;
            int i = 0;
            while (i < iE2) {
                int iE4 = ss9Var.e(a(iE2 - i));
                for (int i2 = 0; i2 < iE4 && i < iE2; i2++) {
                    jArr[i] = iE3;
                    i++;
                }
                iE3++;
            }
        } else {
            boolean zD2 = ss9Var.d();
            for (int i3 = 0; i3 < iE2; i3++) {
                if (!zD2) {
                    jArr[i3] = ss9Var.e(5) + 1;
                } else if (ss9Var.d()) {
                    jArr[i3] = ss9Var.e(5) + 1;
                } else {
                    jArr[i3] = 0;
                }
            }
        }
        int iE5 = ss9Var.e(4);
        if (iE5 > 2) {
            throw ParserException.createForMalformedContainer("lookup type greater than 2 not decodable: " + iE5, null);
        }
        if (iE5 == 1 || iE5 == 2) {
            ss9Var.h(32);
            ss9Var.h(32);
            int iE6 = ss9Var.e(4) + 1;
            ss9Var.h(1);
            if (iE5 != 1) {
                jB = ((long) iE2) * ((long) iE);
            } else if (iE != 0) {
                jB = b(iE2, iE);
            }
            ss9Var.h((int) (jB * ((long) iE6)));
        }
        return new a(iE, iE2, jArr, iE5, zD);
    }

    public static void e(ss9 ss9Var) throws ParserException {
        int iE = ss9Var.e(6) + 1;
        for (int i = 0; i < iE; i++) {
            int iE2 = ss9Var.e(16);
            if (iE2 == 0) {
                ss9Var.h(8);
                ss9Var.h(16);
                ss9Var.h(16);
                ss9Var.h(6);
                ss9Var.h(8);
                int iE3 = ss9Var.e(4) + 1;
                for (int i2 = 0; i2 < iE3; i2++) {
                    ss9Var.h(8);
                }
            } else {
                if (iE2 != 1) {
                    throw ParserException.createForMalformedContainer("floor type greater than 1 not decodable: " + iE2, null);
                }
                int iE4 = ss9Var.e(5);
                int[] iArr = new int[iE4];
                int i3 = -1;
                for (int i4 = 0; i4 < iE4; i4++) {
                    int iE5 = ss9Var.e(4);
                    iArr[i4] = iE5;
                    if (iE5 > i3) {
                        i3 = iE5;
                    }
                }
                int i5 = i3 + 1;
                int[] iArr2 = new int[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    iArr2[i6] = ss9Var.e(3) + 1;
                    int iE6 = ss9Var.e(2);
                    if (iE6 > 0) {
                        ss9Var.h(8);
                    }
                    for (int i7 = 0; i7 < (1 << iE6); i7++) {
                        ss9Var.h(8);
                    }
                }
                ss9Var.h(2);
                int iE7 = ss9Var.e(4);
                int i8 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < iE4; i10++) {
                    i8 += iArr2[iArr[i10]];
                    while (i9 < i8) {
                        ss9Var.h(iE7);
                        i9++;
                    }
                }
            }
        }
    }

    public static void f(int i, ss9 ss9Var) throws ParserException {
        int iE = ss9Var.e(6) + 1;
        for (int i2 = 0; i2 < iE; i2++) {
            int iE2 = ss9Var.e(16);
            if (iE2 != 0) {
                Log.d(f30653a, "mapping type other than 0 not supported: " + iE2);
            } else {
                int iE3 = ss9Var.d() ? ss9Var.e(4) + 1 : 1;
                if (ss9Var.d()) {
                    int iE4 = ss9Var.e(8) + 1;
                    for (int i3 = 0; i3 < iE4; i3++) {
                        int i4 = i - 1;
                        ss9Var.h(a(i4));
                        ss9Var.h(a(i4));
                    }
                }
                if (ss9Var.e(2) != 0) {
                    throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (iE3 > 1) {
                    for (int i5 = 0; i5 < i; i5++) {
                        ss9Var.h(4);
                    }
                }
                for (int i6 = 0; i6 < iE3; i6++) {
                    ss9Var.h(8);
                    ss9Var.h(8);
                    ss9Var.h(8);
                }
            }
        }
    }

    public static c[] g(ss9 ss9Var) {
        int iE = ss9Var.e(6) + 1;
        c[] cVarArr = new c[iE];
        for (int i = 0; i < iE; i++) {
            cVarArr[i] = new c(ss9Var.d(), ss9Var.e(16), ss9Var.e(16), ss9Var.e(8));
        }
        return cVarArr;
    }

    public static void h(ss9 ss9Var) throws ParserException {
        int iE = ss9Var.e(6) + 1;
        for (int i = 0; i < iE; i++) {
            if (ss9Var.e(16) > 2) {
                throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", null);
            }
            ss9Var.h(24);
            ss9Var.h(24);
            ss9Var.h(24);
            int iE2 = ss9Var.e(6) + 1;
            ss9Var.h(8);
            int[] iArr = new int[iE2];
            for (int i2 = 0; i2 < iE2; i2++) {
                iArr[i2] = ((ss9Var.d() ? ss9Var.e(5) : 0) * 8) + ss9Var.e(3);
            }
            for (int i3 = 0; i3 < iE2; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    if ((iArr[i3] & (1 << i4)) != 0) {
                        ss9Var.h(8);
                    }
                }
            }
        }
    }

    public static b i(om6 om6Var) throws ParserException {
        return j(om6Var, true, true);
    }

    public static b j(om6 om6Var, boolean z, boolean z2) throws ParserException {
        if (z) {
            m(3, om6Var, false);
        }
        String strD = om6Var.D((int) om6Var.v());
        int length = 11 + strD.length();
        long jV = om6Var.v();
        String[] strArr = new String[(int) jV];
        int length2 = length + 4;
        for (int i = 0; i < jV; i++) {
            String strD2 = om6Var.D((int) om6Var.v());
            strArr[i] = strD2;
            length2 = length2 + 4 + strD2.length();
        }
        if (z2 && (om6Var.G() & 1) == 0) {
            throw ParserException.createForMalformedContainer("framing bit expected to be set", null);
        }
        return new b(strD, strArr, length2 + 1);
    }

    public static d k(om6 om6Var) throws ParserException {
        m(1, om6Var, false);
        int iX = om6Var.x();
        int iG = om6Var.G();
        int iX2 = om6Var.x();
        int iR = om6Var.r();
        if (iR <= 0) {
            iR = -1;
        }
        int iR2 = om6Var.r();
        if (iR2 <= 0) {
            iR2 = -1;
        }
        int iR3 = om6Var.r();
        if (iR3 <= 0) {
            iR3 = -1;
        }
        int iG2 = om6Var.G();
        return new d(iX, iG, iX2, iR, iR2, iR3, (int) Math.pow(2.0d, iG2 & 15), (int) Math.pow(2.0d, (iG2 & 240) >> 4), (om6Var.G() & 1) > 0, Arrays.copyOf(om6Var.d(), om6Var.f()));
    }

    public static c[] l(om6 om6Var, int i) throws ParserException {
        m(5, om6Var, false);
        int iG = om6Var.G() + 1;
        ss9 ss9Var = new ss9(om6Var.d());
        ss9Var.h(om6Var.e() * 8);
        for (int i2 = 0; i2 < iG; i2++) {
            d(ss9Var);
        }
        int iE = ss9Var.e(6) + 1;
        for (int i3 = 0; i3 < iE; i3++) {
            if (ss9Var.e(16) != 0) {
                throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", null);
            }
        }
        e(ss9Var);
        h(ss9Var);
        f(i, ss9Var);
        c[] cVarArrG = g(ss9Var);
        if (ss9Var.d()) {
            return cVarArrG;
        }
        throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", null);
    }

    public static boolean m(int i, om6 om6Var, boolean z) throws ParserException {
        if (om6Var.a() < 7) {
            if (z) {
                return false;
            }
            throw ParserException.createForMalformedContainer("too short header: " + om6Var.a(), null);
        }
        if (om6Var.G() != i) {
            if (z) {
                return false;
            }
            throw ParserException.createForMalformedContainer("expected header type " + Integer.toHexString(i), null);
        }
        if (om6Var.G() == 118 && om6Var.G() == 111 && om6Var.G() == 114 && om6Var.G() == 98 && om6Var.G() == 105 && om6Var.G() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw ParserException.createForMalformedContainer("expected characters 'vorbis'", null);
    }
}
