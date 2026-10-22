package com.google.android.exoplayer2.metadata.id3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import com.zj.adlib.xn5;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Id3Decoder extends SimpleMetadataDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30777a = 4801587;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f3475a = "Id3Decoder";
    public static final int b = 10;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final FramePredicate f3476b = new FramePredicate() { // from class: com.zj.adlib.t54
        @Override // com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate
        public final boolean evaluate(int i2, int i3, int i4, int i5, int i6) {
            return Id3Decoder.y(i2, i3, i4, i5, i6);
        }
    };
    public static final int c = 128;
    public static final int d = 64;
    public static final int e = 32;
    public static final int f = 8;
    public static final int g = 4;
    public static final int h = 64;
    public static final int i = 2;
    public static final int j = 1;
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final FramePredicate f3477a;

    public interface FramePredicate {
        boolean evaluate(int i, int i2, int i3, int i4, int i5);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30778a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f3478a;
        public final int b;

        public a(int i, boolean z, int i2) {
            this.f30778a = i;
            this.f3478a = z;
            this.b = i2;
        }
    }

    public Id3Decoder() {
        this(null);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0079 A[PHI: r3
      0x0079: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:40:0x0086, B:31:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    public static boolean A(om6 om6Var, int i2, int i3, boolean z) {
        int iJ;
        long J;
        int iM;
        int i4;
        int iE = om6Var.e();
        while (true) {
            try {
                boolean z2 = true;
                if (om6Var.a() < i3) {
                    om6Var.S(iE);
                    return true;
                }
                if (i2 >= 3) {
                    iJ = om6Var.o();
                    J = om6Var.I();
                    iM = om6Var.M();
                } else {
                    iJ = om6Var.J();
                    J = om6Var.J();
                    iM = 0;
                }
                if (iJ == 0 && J == 0 && iM == 0) {
                    om6Var.S(iE);
                    return true;
                }
                if (i2 == 4 && !z) {
                    if ((8421504 & J) != 0) {
                        om6Var.S(iE);
                        return false;
                    }
                    J = (((J >> 24) & 255) << 21) | (J & 255) | (((J >> 8) & 255) << 7) | (((J >> 16) & 255) << 14);
                }
                if (i2 == 4) {
                    i4 = (iM & 64) != 0 ? 1 : 0;
                    if ((iM & 1) == 0) {
                        z2 = false;
                    }
                } else if (i2 == 3) {
                    i4 = (iM & 32) != 0 ? 1 : 0;
                    if ((iM & 128) == 0) {
                        z2 = false;
                    }
                } else {
                    i4 = 0;
                    z2 = false;
                }
                if (z2) {
                    i4 += 4;
                }
                if (J < i4) {
                    om6Var.S(iE);
                    return false;
                }
                if (om6Var.a() < J) {
                    om6Var.S(iE);
                    return false;
                }
                om6Var.T((int) J);
            } catch (Throwable th) {
                om6Var.S(iE);
                throw th;
            }
        }
    }

    public static byte[] c(byte[] bArr, int i2, int i3) {
        return i3 <= i2 ? gj9.f16790a : Arrays.copyOfRange(bArr, i2, i3);
    }

    public static ApicFrame e(om6 om6Var, int i2, int i3) throws UnsupportedEncodingException {
        int iX;
        String str;
        int iG = om6Var.G();
        String strU = u(iG);
        int i4 = i2 - 1;
        byte[] bArr = new byte[i4];
        om6Var.k(bArr, 0, i4);
        if (i3 == 2) {
            str = "image/" + com.google.common.base.a.g(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            iX = 2;
        } else {
            iX = x(bArr, 0);
            String strG = com.google.common.base.a.g(new String(bArr, 0, iX, "ISO-8859-1"));
            if (strG.indexOf(47) == -1) {
                str = "image/" + strG;
            } else {
                str = strG;
            }
        }
        int i5 = bArr[iX + 1] & 255;
        int i6 = iX + 2;
        int iW = w(bArr, i6, iG);
        return new ApicFrame(str, new String(bArr, i6, iW - i6, strU), i5, c(bArr, iW + t(iG), i4));
    }

    public static BinaryFrame f(om6 om6Var, int i2, String str) {
        byte[] bArr = new byte[i2];
        om6Var.k(bArr, 0, i2);
        return new BinaryFrame(str, bArr);
    }

    public static ChapterFrame g(om6 om6Var, int i2, int i3, boolean z, int i4, @Nullable FramePredicate framePredicate) throws UnsupportedEncodingException {
        int iE = om6Var.e();
        int iX = x(om6Var.d(), iE);
        String str = new String(om6Var.d(), iE, iX - iE, "ISO-8859-1");
        om6Var.S(iX + 1);
        int iO = om6Var.o();
        int iO2 = om6Var.o();
        long jI = om6Var.I();
        long j2 = jI == 4294967295L ? -1L : jI;
        long jI2 = om6Var.I();
        long j3 = jI2 == 4294967295L ? -1L : jI2;
        ArrayList arrayList = new ArrayList();
        int i5 = iE + i2;
        while (om6Var.e() < i5) {
            Id3Frame id3FrameJ = j(i3, om6Var, z, i4, framePredicate);
            if (id3FrameJ != null) {
                arrayList.add(id3FrameJ);
            }
        }
        return new ChapterFrame(str, iO, iO2, j2, j3, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static ChapterTocFrame h(om6 om6Var, int i2, int i3, boolean z, int i4, @Nullable FramePredicate framePredicate) throws UnsupportedEncodingException {
        int iE = om6Var.e();
        int iX = x(om6Var.d(), iE);
        String str = new String(om6Var.d(), iE, iX - iE, "ISO-8859-1");
        om6Var.S(iX + 1);
        int iG = om6Var.G();
        boolean z2 = (iG & 2) != 0;
        boolean z3 = (iG & 1) != 0;
        int iG2 = om6Var.G();
        String[] strArr = new String[iG2];
        for (int i5 = 0; i5 < iG2; i5++) {
            int iE2 = om6Var.e();
            int iX2 = x(om6Var.d(), iE2);
            strArr[i5] = new String(om6Var.d(), iE2, iX2 - iE2, "ISO-8859-1");
            om6Var.S(iX2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i6 = iE + i2;
        while (om6Var.e() < i6) {
            Id3Frame id3FrameJ = j(i3, om6Var, z, i4, framePredicate);
            if (id3FrameJ != null) {
                arrayList.add(id3FrameJ);
            }
        }
        return new ChapterTocFrame(str, z2, z3, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    public static CommentFrame i(om6 om6Var, int i2) throws UnsupportedEncodingException {
        if (i2 < 4) {
            return null;
        }
        int iG = om6Var.G();
        String strU = u(iG);
        byte[] bArr = new byte[3];
        om6Var.k(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        om6Var.k(bArr2, 0, i3);
        int iW = w(bArr2, 0, iG);
        String str2 = new String(bArr2, 0, iW, strU);
        int iT = iW + t(iG);
        return new CommentFrame(str, str2, o(bArr2, iT, w(bArr2, iT, iG), strU));
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0198  */
    /* JADX WARN: Code duplicated, block: B:140:0x01a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x01c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:151:0x01db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:152:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:157:0x01ea A[Catch: all -> 0x012e, UnsupportedEncodingException -> 0x0218, Merged into TryCatch #1 {all -> 0x012e, UnsupportedEncodingException -> 0x0218, blocks: (B:91:0x011c, B:159:0x01f4, B:162:0x0218, B:93:0x0124, B:102:0x013d, B:104:0x0145, B:112:0x015f, B:121:0x0177, B:132:0x0192, B:139:0x01a4, B:145:0x01b3, B:150:0x01cb, B:156:0x01e5, B:157:0x01ea), top: B:169:0x0112 }] */
    @Nullable
    public static Id3Frame j(int i2, om6 om6Var, boolean z, int i3, @Nullable FramePredicate framePredicate) {
        int iK;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Id3Frame id3FrameF;
        int iG = om6Var.G();
        int iG2 = om6Var.G();
        int iG3 = om6Var.G();
        int iG4 = i2 >= 3 ? om6Var.G() : 0;
        if (i2 == 4) {
            iK = om6Var.K();
            if (!z) {
                iK = (((iK >> 24) & 255) << 21) | (iK & 255) | (((iK >> 8) & 255) << 7) | (((iK >> 16) & 255) << 14);
            }
        } else {
            iK = i2 == 3 ? om6Var.K() : om6Var.J();
        }
        int iZ = iK;
        int iM = i2 >= 3 ? om6Var.M() : 0;
        if (iG == 0 && iG2 == 0 && iG3 == 0 && iG4 == 0 && iZ == 0 && iM == 0) {
            om6Var.S(om6Var.f());
            return null;
        }
        int iE = om6Var.e() + iZ;
        if (iE > om6Var.f()) {
            Log.n(f3475a, "Frame size exceeds remaining tag data");
            om6Var.S(om6Var.f());
            return null;
        }
        if (framePredicate != null) {
            i4 = iE;
            if (!framePredicate.evaluate(i2, iG, iG2, iG3, iG4)) {
                om6Var.S(i4);
                return null;
            }
        } else {
            i4 = iE;
        }
        if (i2 == 3) {
            int i5 = iM;
            z3 = (i5 & 128) != 0;
            z4 = (i5 & 64) != 0;
            z2 = (i5 & 32) != 0;
            z6 = z3;
            z5 = false;
        } else {
            int i6 = iM;
            if (i2 == 4) {
                boolean z7 = (i6 & 64) != 0;
                boolean z8 = (i6 & 8) != 0;
                boolean z9 = (i6 & 4) != 0;
                z5 = (i6 & 2) != 0;
                boolean z10 = (i6 & 1) != 0;
                z2 = z7;
                z3 = z10;
                z6 = z8;
                z4 = z9;
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                z6 = false;
            }
        }
        if (z6 || z4) {
            Log.n(r4, "Skipping unsupported compressed or encrypted frame");
            om6Var.S(i4);
            return null;
        }
        if (z2) {
            iZ--;
            om6Var.T(1);
        }
        if (z3) {
            iZ -= 4;
            om6Var.T(4);
        }
        if (z5) {
            iZ = z(om6Var, iZ);
        }
        try {
            if (iG == 84 && iG2 == 88 && iG3 == 88 && (i2 == 2 || iG4 == 88)) {
                id3FrameF = q(om6Var, iZ);
            } else if (iG == 84) {
                id3FrameF = p(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
            } else if (iG == 87 && iG2 == 88 && iG3 == 88 && (i2 == 2 || iG4 == 88)) {
                id3FrameF = s(om6Var, iZ);
            } else if (iG == 87) {
                id3FrameF = r(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
            } else if (iG == 80 && iG2 == 82 && iG3 == 73 && iG4 == 86) {
                id3FrameF = n(om6Var, iZ);
            } else if (iG == 71 && iG2 == 69 && iG3 == 79 && (iG4 == 66 || i2 == 2)) {
                id3FrameF = k(om6Var, iZ);
            } else if (i2 == 2) {
                if (iG == 80 && iG2 == 73 && iG3 == 67) {
                    id3FrameF = e(om6Var, iZ, i2);
                } else if (iG != 67 && iG2 == 79 && iG3 == 77 && (iG4 == 77 || i2 == 2)) {
                    id3FrameF = i(om6Var, iZ);
                } else if (iG != 67 && iG2 == 72 && iG3 == 65 && iG4 == 80) {
                    id3FrameF = g(om6Var, iZ, i2, z, i3, framePredicate);
                } else if (iG != 67 && iG2 == 84 && iG3 == 79 && iG4 == 67) {
                    id3FrameF = h(om6Var, iZ, i2, z, i3, framePredicate);
                } else if (iG != 77 && iG2 == 76 && iG3 == 76 && iG4 == 84) {
                    id3FrameF = m(om6Var, iZ);
                } else {
                    id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                }
            } else if (iG == 65 && iG2 == 80 && iG3 == 73 && iG4 == 67) {
                id3FrameF = e(om6Var, iZ, i2);
            } else if (iG != 67) {
                if (iG != 67) {
                    if (iG != 67) {
                        if (iG != 77) {
                            id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                        } else {
                            id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                        }
                    } else if (iG != 77) {
                        id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                    } else {
                        id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                    }
                } else if (iG != 67) {
                    if (iG != 77) {
                        id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                    } else {
                        id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                    }
                } else if (iG != 77) {
                    id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                } else {
                    id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                }
            } else if (iG != 67) {
                if (iG != 67) {
                    if (iG != 77) {
                        id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                    } else {
                        id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                    }
                } else if (iG != 77) {
                    id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                } else {
                    id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                }
            } else if (iG != 67) {
                if (iG != 77) {
                    id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                } else {
                    id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
                }
            } else if (iG != 77) {
                id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
            } else {
                id3FrameF = f(om6Var, iZ, v(i2, iG, iG2, iG3, iG4));
            }
            if (id3FrameF == null) {
                Log.n(f3475a, "Failed to decode frame: id=" + v(i2, iG, iG2, iG3, iG4) + ", frameSize=" + iZ);
            }
            om6Var.S(i4);
            return id3FrameF;
        } catch (UnsupportedEncodingException unused) {
            Log.n(r4, "Unsupported character encoding");
            return null;
        } finally {
            om6Var.S(i4);
        }
    }

    public static GeobFrame k(om6 om6Var, int i2) throws UnsupportedEncodingException {
        int iG = om6Var.G();
        String strU = u(iG);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        om6Var.k(bArr, 0, i3);
        int iX = x(bArr, 0);
        String str = new String(bArr, 0, iX, "ISO-8859-1");
        int i4 = iX + 1;
        int iW = w(bArr, i4, iG);
        String strO = o(bArr, i4, iW, strU);
        int iT = iW + t(iG);
        int iW2 = w(bArr, iT, iG);
        return new GeobFrame(str, strO, o(bArr, iT, iW2, strU), c(bArr, iW2 + t(iG), i3));
    }

    @Nullable
    public static a l(om6 om6Var) {
        if (om6Var.a() < 10) {
            Log.n(f3475a, "Data too short to be an ID3 tag");
            return null;
        }
        int iJ = om6Var.J();
        boolean z = false;
        if (iJ != 4801587) {
            Log.n(f3475a, "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(iJ)));
            return null;
        }
        int iG = om6Var.G();
        om6Var.T(1);
        int iG2 = om6Var.G();
        int iF = om6Var.F();
        if (iG == 2) {
            if ((iG2 & 64) != 0) {
                Log.n(f3475a, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iG == 3) {
            if ((iG2 & 64) != 0) {
                int iO = om6Var.o();
                om6Var.T(iO);
                iF -= iO + 4;
            }
        } else {
            if (iG != 4) {
                Log.n(f3475a, "Skipped ID3 tag with unsupported majorVersion=" + iG);
                return null;
            }
            if ((iG2 & 64) != 0) {
                int iF2 = om6Var.F();
                om6Var.T(iF2 - 4);
                iF -= iF2;
            }
            if ((iG2 & 16) != 0) {
                iF -= 10;
            }
        }
        if (iG < 4 && (iG2 & 128) != 0) {
            z = true;
        }
        return new a(iG, z, iF);
    }

    public static MlltFrame m(om6 om6Var, int i2) {
        int iM = om6Var.M();
        int iJ = om6Var.J();
        int iJ2 = om6Var.J();
        int iG = om6Var.G();
        int iG2 = om6Var.G();
        nm6 nm6Var = new nm6();
        nm6Var.n(om6Var);
        int i3 = ((i2 - 10) * 8) / (iG + iG2);
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int iH = nm6Var.h(iG);
            int iH2 = nm6Var.h(iG2);
            iArr[i4] = iH;
            iArr2[i4] = iH2;
        }
        return new MlltFrame(iM, iJ, iJ2, iArr, iArr2);
    }

    public static PrivFrame n(om6 om6Var, int i2) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i2];
        om6Var.k(bArr, 0, i2);
        int iX = x(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iX, "ISO-8859-1"), c(bArr, iX + 1, i2));
    }

    public static String o(byte[] bArr, int i2, int i3, String str) throws UnsupportedEncodingException {
        return (i3 <= i2 || i3 > bArr.length) ? "" : new String(bArr, i2, i3 - i2, str);
    }

    @Nullable
    public static TextInformationFrame p(om6 om6Var, int i2, String str) throws UnsupportedEncodingException {
        if (i2 < 1) {
            return null;
        }
        int iG = om6Var.G();
        String strU = u(iG);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        om6Var.k(bArr, 0, i3);
        return new TextInformationFrame(str, null, new String(bArr, 0, w(bArr, 0, iG), strU));
    }

    @Nullable
    public static TextInformationFrame q(om6 om6Var, int i2) throws UnsupportedEncodingException {
        if (i2 < 1) {
            return null;
        }
        int iG = om6Var.G();
        String strU = u(iG);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        om6Var.k(bArr, 0, i3);
        int iW = w(bArr, 0, iG);
        String str = new String(bArr, 0, iW, strU);
        int iT = iW + t(iG);
        return new TextInformationFrame("TXXX", str, o(bArr, iT, w(bArr, iT, iG), strU));
    }

    public static UrlLinkFrame r(om6 om6Var, int i2, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i2];
        om6Var.k(bArr, 0, i2);
        return new UrlLinkFrame(str, null, new String(bArr, 0, x(bArr, 0), "ISO-8859-1"));
    }

    @Nullable
    public static UrlLinkFrame s(om6 om6Var, int i2) throws UnsupportedEncodingException {
        if (i2 < 1) {
            return null;
        }
        int iG = om6Var.G();
        String strU = u(iG);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        om6Var.k(bArr, 0, i3);
        int iW = w(bArr, 0, iG);
        String str = new String(bArr, 0, iW, strU);
        int iT = iW + t(iG);
        return new UrlLinkFrame("WXXX", str, o(bArr, iT, x(bArr, iT), "ISO-8859-1"));
    }

    public static int t(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    public static String u(int i2) {
        if (i2 == 1) {
            return "UTF-16";
        }
        if (i2 != 2) {
            return i2 != 3 ? "ISO-8859-1" : "UTF-8";
        }
        return "UTF-16BE";
    }

    public static String v(int i2, int i3, int i4, int i5, int i6) {
        return i2 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static int w(byte[] bArr, int i2, int i3) {
        int iX = x(bArr, i2);
        if (i3 == 0 || i3 == 3) {
            return iX;
        }
        while (iX < bArr.length - 1) {
            if ((iX - i2) % 2 == 0 && bArr[iX + 1] == 0) {
                return iX;
            }
            iX = x(bArr, iX + 1);
        }
        return bArr.length;
    }

    public static int x(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    public static /* synthetic */ boolean y(int i2, int i3, int i4, int i5, int i6) {
        return false;
    }

    public static int z(om6 om6Var, int i2) {
        byte[] bArrD = om6Var.d();
        int iE = om6Var.e();
        int i3 = iE;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= iE + i2) {
                return i2;
            }
            if ((bArrD[i3] & 255) == 255 && bArrD[i4] == 0) {
                System.arraycopy(bArrD, i3 + 2, bArrD, i4, (i2 - (i3 - iE)) - 2);
                i2--;
            }
            i3 = i4;
        }
    }

    @Nullable
    public Metadata d(byte[] bArr, int i2) {
        ArrayList arrayList = new ArrayList();
        om6 om6Var = new om6(bArr, i2);
        a aVarL = l(om6Var);
        if (aVarL == null) {
            return null;
        }
        int iE = om6Var.e();
        int i3 = aVarL.f30778a == 2 ? 6 : 10;
        int iZ = aVarL.b;
        if (aVarL.f3478a) {
            iZ = z(om6Var, aVarL.b);
        }
        om6Var.R(iE + iZ);
        boolean z = false;
        if (!A(om6Var, aVarL.f30778a, i3, false)) {
            if (aVarL.f30778a != 4 || !A(om6Var, 4, i3, true)) {
                Log.n(f3475a, "Failed to validate ID3 tag with majorVersion=" + aVarL.f30778a);
                return null;
            }
            z = true;
        }
        while (om6Var.a() >= i3) {
            Id3Frame id3FrameJ = j(aVarL.f30778a, om6Var, z, i3, this.f3477a);
            if (id3FrameJ != null) {
                arrayList.add(id3FrameJ);
            }
        }
        return new Metadata(arrayList);
    }

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    @Nullable
    public Metadata decode(xn5 xn5Var, ByteBuffer byteBuffer) {
        return d(byteBuffer.array(), byteBuffer.limit());
    }

    public Id3Decoder(@Nullable FramePredicate framePredicate) {
        this.f3477a = framePredicate;
    }
}
