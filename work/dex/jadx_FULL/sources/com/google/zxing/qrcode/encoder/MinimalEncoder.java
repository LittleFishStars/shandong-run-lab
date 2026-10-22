package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.zj.adlib.fv2;
import com.zj.adlib.lm9;
import com.zj.adlib.qv0;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class MinimalEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ErrorCorrectionLevel f32533a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fv2 f6787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f6788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f6789a;

    public enum VersionSize {
        SMALL("version 1-9"),
        MEDIUM("version 10-26"),
        LARGE("version 27-40");

        private final String description;

        VersionSize(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32534a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Mode.values().length];
            b = iArr;
            try {
                iArr[Mode.KANJI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Mode.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Mode.BYTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[Mode.ECI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[VersionSize.values().length];
            f32534a = iArr2;
            try {
                iArr2[VersionSize.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32534a[VersionSize.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32534a[VersionSize.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32535a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Mode f6790a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final b f6791a;
        public final int b;
        public final int c;
        public final int d;

        public /* synthetic */ b(MinimalEncoder minimalEncoder, Mode mode, int i, int i2, int i3, b bVar, lm9 lm9Var, a aVar) {
            this(mode, i, i2, i3, bVar, lm9Var);
        }

        public b(Mode mode, int i, int i2, int i3, b bVar, lm9 lm9Var) {
            this.f6790a = mode;
            this.f32535a = i;
            Mode mode2 = Mode.BYTE;
            int i4 = (mode == mode2 || bVar == null) ? i2 : bVar.b;
            this.b = i4;
            this.c = i3;
            this.f6791a = bVar;
            boolean z = false;
            int characterCountBits = bVar != null ? bVar.d : 0;
            if ((mode == mode2 && bVar == null && i4 != 0) || (bVar != null && i4 != bVar.b)) {
                z = true;
            }
            characterCountBits = (bVar == null || mode != bVar.f6790a || z) ? characterCountBits + mode.getCharacterCountBits(lm9Var) + 4 : characterCountBits;
            int i5 = a.b[mode.ordinal()];
            if (i5 == 1) {
                characterCountBits += 13;
            } else if (i5 == 2) {
                characterCountBits += i3 == 1 ? 6 : 11;
            } else if (i5 == 3) {
                characterCountBits += i3 != 1 ? i3 == 2 ? 7 : 10 : 4;
            } else if (i5 == 4) {
                characterCountBits += MinimalEncoder.this.f6787a.c(MinimalEncoder.this.f6788a.substring(i, i3 + i), i2).length * 8;
                if (z) {
                    characterCountBits += 12;
                }
            }
            this.d = characterCountBits;
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final lm9 f6793a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<a> f6794a = new ArrayList();

        public final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f32537a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final Mode f6795a;
            public final int b;
            public final int c;

            public a(Mode mode, int i, int i2, int i3) {
                this.f6795a = mode;
                this.f32537a = i;
                this.b = i2;
                this.c = i3;
            }

            public final void d(qv0 qv0Var) throws WriterException {
                qv0Var.d(this.f6795a.getBits(), 4);
                if (this.c > 0) {
                    qv0Var.d(e(), this.f6795a.getCharacterCountBits(c.this.f6793a));
                }
                if (this.f6795a == Mode.ECI) {
                    qv0Var.d(MinimalEncoder.this.f6787a.f(this.b), 8);
                } else if (this.c > 0) {
                    String str = MinimalEncoder.this.f6788a;
                    int i = this.f32537a;
                    com.google.zxing.qrcode.encoder.a.c(str.substring(i, this.c + i), this.f6795a, qv0Var, MinimalEncoder.this.f6787a.d(this.b));
                }
            }

            public final int e() {
                if (this.f6795a != Mode.BYTE) {
                    return this.c;
                }
                fv2 fv2Var = MinimalEncoder.this.f6787a;
                String str = MinimalEncoder.this.f6788a;
                int i = this.f32537a;
                return fv2Var.c(str.substring(i, this.c + i), this.b).length;
            }

            public final int f(lm9 lm9Var) {
                int iE = 4;
                int characterCountBits = this.f6795a.getCharacterCountBits(lm9Var) + 4;
                int i = a.b[this.f6795a.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        int i2 = this.c;
                        return characterCountBits + ((i2 / 2) * 11) + (i2 % 2 == 1 ? 6 : 0);
                    }
                    if (i == 3) {
                        int i3 = this.c;
                        characterCountBits += (i3 / 3) * 10;
                        int i4 = i3 % 3;
                        if (i4 != 1) {
                            iE = i4 == 2 ? 7 : 0;
                        }
                    } else {
                        if (i != 4) {
                            return i != 5 ? characterCountBits : characterCountBits + 8;
                        }
                        iE = e() * 8;
                    }
                } else {
                    iE = this.c * 13;
                }
                return characterCountBits + iE;
            }

            public final String g(String str) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) < ' ' || str.charAt(i) > '~') {
                        sb.append('.');
                    } else {
                        sb.append(str.charAt(i));
                    }
                }
                return sb.toString();
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f6795a);
                sb.append('(');
                if (this.f6795a == Mode.ECI) {
                    sb.append(MinimalEncoder.this.f6787a.d(this.b).displayName());
                } else {
                    String str = MinimalEncoder.this.f6788a;
                    int i = this.f32537a;
                    sb.append(g(str.substring(i, this.c + i)));
                }
                sb.append(')');
                return sb.toString();
            }
        }

        public c(lm9 lm9Var, b bVar) {
            int i;
            int i2;
            int i3 = 0;
            boolean z = false;
            while (true) {
                i = 1;
                if (bVar == null) {
                    break;
                }
                int i4 = i3 + bVar.c;
                b bVar2 = bVar.f6791a;
                boolean z2 = (bVar.f6790a == Mode.BYTE && bVar2 == null && bVar.b != 0) || !(bVar2 == null || bVar.b == bVar2.b);
                z = z2 ? true : z;
                if (bVar2 == null || bVar2.f6790a != bVar.f6790a || z2) {
                    this.f6794a.add(0, new a(bVar.f6790a, bVar.f32535a, bVar.b, i4));
                    i4 = 0;
                }
                if (z2) {
                    this.f6794a.add(0, new a(Mode.ECI, bVar.f32535a, bVar.b, 0));
                }
                bVar = bVar2;
                i3 = i4;
            }
            if (MinimalEncoder.this.f6789a) {
                a aVar = this.f6794a.get(0);
                if (aVar != null) {
                    Mode mode = aVar.f6795a;
                    Mode mode2 = Mode.ECI;
                    if (mode != mode2 && z) {
                        this.f6794a.add(0, new a(mode2, 0, 0, 0));
                    }
                }
                this.f6794a.add(this.f6794a.get(0).f6795a == Mode.ECI ? 1 : 0, new a(Mode.FNC1_FIRST_POSITION, 0, 0, 0));
            }
            int iJ = lm9Var.j();
            int i5 = a.f32534a[MinimalEncoder.m(lm9Var).ordinal()];
            if (i5 == 1) {
                i2 = 9;
            } else if (i5 != 2) {
                i = 27;
                i2 = 40;
            } else {
                i = 10;
                i2 = 26;
            }
            int iD = d(lm9Var);
            while (iJ < i2 && !com.google.zxing.qrcode.encoder.a.x(iD, lm9.i(iJ), MinimalEncoder.this.f32533a)) {
                iJ++;
            }
            while (iJ > i && com.google.zxing.qrcode.encoder.a.x(iD, lm9.i(iJ - 1), MinimalEncoder.this.f32533a)) {
                iJ--;
            }
            this.f6793a = lm9.i(iJ);
        }

        public void b(qv0 qv0Var) throws WriterException {
            Iterator<a> it = this.f6794a.iterator();
            while (it.hasNext()) {
                it.next().d(qv0Var);
            }
        }

        public int c() {
            return d(this.f6793a);
        }

        public final int d(lm9 lm9Var) {
            Iterator<a> it = this.f6794a.iterator();
            int iF = 0;
            while (it.hasNext()) {
                iF += it.next().f(lm9Var);
            }
            return iF;
        }

        public lm9 e() {
            return this.f6793a;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            a aVar = null;
            for (a aVar2 : this.f6794a) {
                if (aVar != null) {
                    sb.append(",");
                }
                sb.append(aVar2.toString());
                aVar = aVar2;
            }
            return sb.toString();
        }
    }

    public MinimalEncoder(String str, Charset charset, boolean z, ErrorCorrectionLevel errorCorrectionLevel) {
        this.f6788a = str;
        this.f6789a = z;
        this.f6787a = new fv2(str, charset, -1);
        this.f32533a = errorCorrectionLevel;
    }

    public static c i(String str, lm9 lm9Var, Charset charset, boolean z, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return new MinimalEncoder(str, charset, z, errorCorrectionLevel).h(lm9Var);
    }

    public static int k(Mode mode) {
        int i;
        if (mode == null || (i = a.b[mode.ordinal()]) == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        throw new IllegalStateException("Illegal mode " + mode);
    }

    public static lm9 l(VersionSize versionSize) {
        int i = a.f32534a[versionSize.ordinal()];
        if (i != 1) {
            return i != 2 ? lm9.i(40) : lm9.i(26);
        }
        return lm9.i(9);
    }

    public static VersionSize m(lm9 lm9Var) {
        if (lm9Var.j() <= 9) {
            return VersionSize.SMALL;
        }
        return lm9Var.j() <= 26 ? VersionSize.MEDIUM : VersionSize.LARGE;
    }

    public static boolean n(char c2) {
        return com.google.zxing.qrcode.encoder.a.r(c2) != -1;
    }

    public static boolean o(char c2) {
        return com.google.zxing.qrcode.encoder.a.u(String.valueOf(c2));
    }

    public static boolean p(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public void e(b[][][] bVarArr, int i, b bVar) {
        b[] bVarArr2 = bVarArr[i + bVar.c][bVar.b];
        int iK = k(bVar.f6790a);
        b bVar2 = bVarArr2[iK];
        if (bVar2 == null || bVar2.d > bVar.d) {
            bVarArr2[iK] = bVar;
        }
    }

    public void f(lm9 lm9Var, b[][][] bVarArr, int i, b bVar) {
        int i2;
        int iH = this.f6787a.h();
        int iG = this.f6787a.g();
        if (iG < 0 || !this.f6787a.a(this.f6788a.charAt(i), iG)) {
            iG = 0;
        } else {
            iH = iG + 1;
        }
        int i3 = iH;
        for (int i4 = iG; i4 < i3; i4++) {
            if (this.f6787a.a(this.f6788a.charAt(i), i4)) {
                e(bVarArr, i, new b(this, Mode.BYTE, i, i4, 1, bVar, lm9Var, null));
            }
        }
        Mode mode = Mode.KANJI;
        if (g(mode, this.f6788a.charAt(i))) {
            e(bVarArr, i, new b(this, mode, i, 0, 1, bVar, lm9Var, null));
        }
        int length = this.f6788a.length();
        Mode mode2 = Mode.ALPHANUMERIC;
        if (g(mode2, this.f6788a.charAt(i))) {
            int i5 = i + 1;
            e(bVarArr, i, new b(this, mode2, i, 0, (i5 >= length || !g(mode2, this.f6788a.charAt(i5))) ? 1 : 2, bVar, lm9Var, null));
        }
        Mode mode3 = Mode.NUMERIC;
        if (g(mode3, this.f6788a.charAt(i))) {
            int i6 = 0;
            int i7 = i + 1;
            if (i7 >= length || !g(mode3, this.f6788a.charAt(i7))) {
                i2 = 1;
            } else {
                int i8 = i + 2;
                i2 = (i8 >= length || !g(mode3, this.f6788a.charAt(i8))) ? 2 : 3;
            }
            e(bVarArr, i, new b(this, mode3, i, i6, i2, bVar, lm9Var, null));
        }
    }

    public boolean g(Mode mode, char c2) {
        int i = a.b[mode.ordinal()];
        if (i == 1) {
            return o(c2);
        }
        if (i == 2) {
            return n(c2);
        }
        if (i != 3) {
            return i == 4;
        }
        return p(c2);
    }

    public c h(lm9 lm9Var) throws WriterException {
        if (lm9Var != null) {
            c cVarJ = j(lm9Var);
            if (com.google.zxing.qrcode.encoder.a.x(cVarJ.c(), l(m(cVarJ.e())), this.f32533a)) {
                return cVarJ;
            }
            throw new WriterException("Data too big for version" + lm9Var);
        }
        lm9[] lm9VarArr = {l(VersionSize.SMALL), l(VersionSize.MEDIUM), l(VersionSize.LARGE)};
        c[] cVarArr = {j(lm9VarArr[0]), j(lm9VarArr[1]), j(lm9VarArr[2])};
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 3; i3++) {
            int iC = cVarArr[i3].c();
            if (com.google.zxing.qrcode.encoder.a.x(iC, lm9VarArr[i3], this.f32533a) && iC < i) {
                i2 = i3;
                i = iC;
            }
        }
        if (i2 >= 0) {
            return cVarArr[i2];
        }
        throw new WriterException("Data too big for any version");
    }

    public c j(lm9 lm9Var) throws WriterException {
        int length = this.f6788a.length();
        b[][][] bVarArr = (b[][][]) Array.newInstance((Class<?>) b.class, length + 1, this.f6787a.h(), 4);
        f(lm9Var, bVarArr, 0, null);
        for (int i = 1; i <= length; i++) {
            for (int i2 = 0; i2 < this.f6787a.h(); i2++) {
                for (int i3 = 0; i3 < 4; i3++) {
                    b bVar = bVarArr[i][i2][i3];
                    if (bVar != null && i < length) {
                        f(lm9Var, bVarArr, i, bVar);
                    }
                }
            }
        }
        int i4 = -1;
        int i5 = Integer.MAX_VALUE;
        int i6 = -1;
        for (int i7 = 0; i7 < this.f6787a.h(); i7++) {
            for (int i8 = 0; i8 < 4; i8++) {
                b bVar2 = bVarArr[length][i7][i8];
                if (bVar2 != null && bVar2.d < i5) {
                    i5 = bVar2.d;
                    i4 = i7;
                    i6 = i8;
                }
            }
        }
        if (i4 >= 0) {
            return new c(lm9Var, bVarArr[length][i4][i6]);
        }
        throw new WriterException("Internal error: failed to encode \"" + this.f6788a + "\"");
    }
}
