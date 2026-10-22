package com.zj.adlib;

import com.alipay.sdk.m.p.a;
import com.alipay.sdk.m.y.l;
import com.google.common.net.c;
import com.hp.hpl.sparta.EncodingMismatchException;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.ParseHandler;
import com.hp.hpl.sparta.ParseLog;
import com.hp.hpl.sparta.ParseSource;
import com.hp.hpl.sparta.Sparta;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class rm6 implements ParseSource {
    public static final boolean c = true;
    public static final boolean d = false;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final char[] f19352d;
    public static final char[] e;
    public static final char[] f;
    public static final int g = 128;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final char[] f19353g;
    public static final int h = 255;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final char[] f19354h;
    public static final int i = 100;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final char[] f19355i;
    public static final char[] j;
    public static final char[] k;
    public static final char[] l;
    public static final char[] m;
    public static final char[] n;
    public static final char[] o;
    public static final char[] p;
    public static final char[] q;
    public static final char[] r;
    public static final char[] s;
    public static final char[] t;
    public static final char[] u;
    public static final char[] v;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ParseHandler f19356a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vi1 f19357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Reader f19358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f19359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Hashtable f19360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19361a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final char[] f19362a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ParseLog f19363b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f19364b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Hashtable f19365b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f19366b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final char[] f19367b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f19368c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final String f19369c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f19370d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f19371e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public int f19372f;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final char[] f19351c = {'.', '-', '_', c.b};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean[] f44483a = new boolean[128];

    static {
        for (char c2 = 0; c2 < 128; c2 = (char) (c2 + 1)) {
            f44483a[c2] = x(c2);
        }
        f19352d = "<!--".toCharArray();
        e = "-->".toCharArray();
        f = "<?".toCharArray();
        f19353g = "?>".toCharArray();
        f19354h = "<!DOCTYPE".toCharArray();
        f19355i = "<?xml".toCharArray();
        j = "encoding".toCharArray();
        k = "version".toCharArray();
        l = new char[]{'_', '.', c.b, '-'};
        m = "<!".toCharArray();
        n = "&#".toCharArray();
        o = "<!ENTITY".toCharArray();
        p = "NDATA".toCharArray();
        q = "SYSTEM".toCharArray();
        r = "PUBLIC".toCharArray();
        s = "<![CDATA[".toCharArray();
        t = "]]>".toCharArray();
        u = "/>".toCharArray();
        v = "</".toCharArray();
    }

    public rm6(String str, char[] cArr, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        this(str, null, cArr, parseLog, str2, parseHandler);
    }

    public static boolean r(char c2) {
        if (c2 == 183 || c2 == 903 || c2 == 1600 || c2 == 3654 || c2 == 3782 || c2 == 12293 || c2 == 720 || c2 == 721 || c2 == 12445 || c2 == 12446) {
            return true;
        }
        switch (c2) {
            case 12337:
            case 12338:
            case 12339:
            case 12340:
            case 12341:
                return true;
            default:
                switch (c2) {
                    case 12540:
                    case 12541:
                    case 12542:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public static final boolean t(char c2, char[] cArr) {
        for (char c3 : cArr) {
            if (c2 == c3) {
                return true;
            }
        }
        return false;
    }

    public static boolean u(char c2) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(Character.toLowerCase(c2)) != -1;
    }

    public static boolean x(char c2) {
        return Character.isDigit(c2) || u(c2) || t(c2, f19351c) || r(c2);
    }

    public final boolean A() throws ParseException, IOException {
        return h(dv9.d);
    }

    public final boolean B() throws ParseException, IOException {
        return j(' ', '\t', '\r', '\n');
    }

    public final boolean C(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f19371e - this.f19370d < length && c(length) <= 0) {
            this.b = -1;
            return false;
        }
        char[] cArr2 = this.f19362a;
        int i2 = this.f19371e;
        this.b = cArr2[i2 - 1];
        if (i2 - this.f19370d < length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (this.f19362a[this.f19370d + i3] != cArr[i3]) {
                return false;
            }
        }
        return true;
    }

    public final boolean D() throws ParseException, IOException {
        char cF = F();
        return Character.isDigit(cF) || ('a' <= cF && cF <= 'z') || (('Z' <= cF && cF <= 'Z') || t(cF, l));
    }

    public final boolean E() throws ParseException, IOException {
        return C(f19355i);
    }

    public final char F() throws ParseException, IOException {
        if (this.f19370d < this.f19371e || b() != -1) {
            return this.f19362a[this.f19370d];
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    public final String G() throws ParseException, IOException {
        char cK = K('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!h(cK)) {
            if (A()) {
                stringBuffer.append(k0());
            } else {
                stringBuffer.append(J());
            }
        }
        M(cK);
        return stringBuffer.toString();
    }

    public final void H(vy2 vy2Var) throws ParseException, IOException {
        String strD0 = d0();
        Z();
        String strG = G();
        if (vy2Var.B(strD0) != null) {
            this.f19363b.a("Element " + this + " contains attribute " + strD0 + "more than once", this.f19359a, getLineNumber());
        }
        vy2Var.M(strD0, strG);
    }

    public final void I() throws ParseException, IOException {
        char[] cArr;
        m0(s);
        StringBuffer stringBuffer = null;
        int i2 = 0;
        while (true) {
            cArr = t;
            if (C(cArr)) {
                break;
            }
            if (i2 >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i2);
                    stringBuffer.append(this.f19367b, 0, i2);
                } else {
                    stringBuffer.append(this.f19367b, 0, i2);
                }
                i2 = 0;
            }
            this.f19367b[i2] = J();
            i2++;
        }
        m0(cArr);
        if (stringBuffer == null) {
            this.f19356a.characters(this.f19367b, 0, i2);
            return;
        }
        stringBuffer.append(this.f19367b, 0, i2);
        char[] charArray = stringBuffer.toString().toCharArray();
        this.f19356a.characters(charArray, 0, charArray.length);
    }

    public final char J() throws ParseException, IOException {
        if (this.f19370d >= this.f19371e && b() == -1) {
            throw new ParseException(this, "unexpected end of expression.");
        }
        char[] cArr = this.f19362a;
        int i2 = this.f19370d;
        char c2 = cArr[i2];
        if (c2 == '\n') {
            this.f19372f++;
        }
        this.f19370d = i2 + 1;
        return c2;
    }

    public final char K(char c2, char c3) throws ParseException, IOException {
        char cJ = J();
        if (cJ == c2 || cJ == c3) {
            return cJ;
        }
        throw new ParseException(this, cJ, new char[]{c2, c3});
    }

    public final char L(char c2, char c3, char c4, char c5) throws ParseException, IOException {
        char cJ = J();
        if (cJ == c2 || cJ == c3 || cJ == c4 || cJ == c5) {
            return cJ;
        }
        throw new ParseException(this, cJ, new char[]{c2, c3, c4, c5});
    }

    public final void M(char c2) throws ParseException, IOException {
        char cJ = J();
        if (cJ != c2) {
            throw new ParseException(this, cJ, c2);
        }
    }

    public final char N() throws ParseException, IOException {
        int i2;
        m0(n);
        if (h('x')) {
            J();
            i2 = 16;
        } else {
            i2 = 10;
        }
        int i3 = 0;
        while (!h(dv9.e)) {
            int i4 = i3 + 1;
            this.f19367b[i3] = J();
            if (i4 >= 255) {
                this.f19363b.a("Tmp buffer overflow on readCharRef", this.f19359a, getLineNumber());
                return ' ';
            }
            i3 = i4;
        }
        M(dv9.e);
        String str = new String(this.f19367b, 0, i3);
        try {
            return (char) Integer.parseInt(str, i2);
        } catch (NumberFormatException unused) {
            ParseLog parseLog = this.f19363b;
            StringBuilder sb = new StringBuilder();
            sb.append("\"");
            sb.append(str);
            sb.append("\" is not a valid ");
            sb.append(i2 == 16 ? "hexadecimal" : "decimal");
            sb.append(" number");
            parseLog.a(sb.toString(), this.f19359a, getLineNumber());
            return ' ';
        }
    }

    public final void O() throws ParseException, IOException {
        m0(f19352d);
        while (true) {
            char[] cArr = e;
            if (C(cArr)) {
                m0(cArr);
                return;
            }
            J();
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000d  */
    public final void P() throws ParseException, IOException {
        h0();
        boolean z = true;
        while (z) {
            if (n()) {
                z = false;
            } else if (A()) {
                char[] cArrK0 = k0();
                this.f19356a.characters(cArrK0, 0, cArrK0.length);
            } else if (g()) {
                I();
            } else if (z()) {
                g0();
            } else if (k()) {
                O();
            } else if (h(dv9.f41283a)) {
                T();
            } else {
                z = false;
            }
            h0();
        }
    }

    public final void Q() throws ParseException, IOException {
        if (y()) {
            f0();
        } else {
            l0();
        }
    }

    public final void R() throws ParseException, IOException {
        m0(f19354h);
        l0();
        this.f19364b = d0();
        if (B()) {
            l0();
            if (!h(dv9.b) && !h('[')) {
                this.f19361a = true;
                a0();
                if (B()) {
                    l0();
                }
            }
        }
        if (h('[')) {
            J();
            while (!h(']')) {
                if (l()) {
                    Q();
                } else {
                    b0();
                }
            }
            M(']');
            if (B()) {
                l0();
            }
        }
        M(dv9.b);
    }

    public final void S(vy2 vy2Var) throws ParseException, IOException {
        m0(v);
        String strD0 = d0();
        if (!strD0.equals(vy2Var.F())) {
            this.f19363b.a("end tag (" + strD0 + ") does not match begin tag (" + vy2Var.F() + ")", this.f19359a, getLineNumber());
        }
        if (B()) {
            l0();
        }
        M(dv9.b);
    }

    public final vy2 T() throws ParseException, IOException {
        vy2 vy2Var = new vy2();
        boolean zU = U(vy2Var);
        this.f19356a.c(vy2Var);
        if (zU) {
            P();
            S(vy2Var);
        }
        this.f19356a.d(vy2Var);
        return vy2Var;
    }

    public final boolean U(vy2 vy2Var) throws ParseException, IOException {
        M(dv9.f41283a);
        vy2Var.N(d0());
        while (B()) {
            l0();
            if (!i('/', dv9.b)) {
                H(vy2Var);
            }
        }
        if (B()) {
            l0();
        }
        boolean zH = h(dv9.b);
        if (zH) {
            M(dv9.b);
        } else {
            m0(u);
        }
        return zH;
    }

    public final String V() throws ParseException, IOException {
        m0(j);
        Z();
        char cK = K('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!h(cK)) {
            stringBuffer.append(J());
        }
        M(cK);
        return stringBuffer.toString();
    }

    public final void W() throws ParseException, IOException {
        String strA0;
        m0(o);
        l0();
        if (h('%')) {
            M('%');
            l0();
            String strD0 = d0();
            l0();
            this.f19365b.put(strD0, q() ? Y() : a0());
        } else {
            String strD1 = d0();
            l0();
            if (q()) {
                strA0 = Y();
            } else {
                if (!s()) {
                    throw new ParseException(this, "expecting double-quote, \"PUBLIC\" or \"SYSTEM\" while reading entity declaration");
                }
                strA0 = a0();
                if (B()) {
                    l0();
                }
                char[] cArr = p;
                if (C(cArr)) {
                    m0(cArr);
                    l0();
                    d0();
                }
            }
            this.f19360a.put(strD1, strA0);
        }
        if (B()) {
            l0();
        }
        M(dv9.b);
    }

    public final String X() throws ParseException, IOException {
        M(dv9.d);
        String strD0 = d0();
        String str = (String) this.f19360a.get(strD0);
        if (str == null) {
            if (this.f19361a) {
                this.f19363b.a("&" + strD0 + "; not found -- possibly defined in external DTD)", this.f19359a, getLineNumber());
            } else {
                this.f19363b.a("No declaration of &" + strD0 + l.b, this.f19359a, getLineNumber());
            }
            str = "";
        }
        M(dv9.e);
        return str;
    }

    public final String Y() throws ParseException, IOException {
        char cK = K('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!h(cK)) {
            if (y()) {
                stringBuffer.append(f0());
            } else if (A()) {
                stringBuffer.append(k0());
            } else {
                stringBuffer.append(J());
            }
        }
        M(cK);
        return stringBuffer.toString();
    }

    public final void Z() throws ParseException, IOException {
        if (B()) {
            l0();
        }
        M(a.h);
        if (B()) {
            l0();
        }
    }

    public final String a0() throws ParseException, IOException {
        char[] cArr = q;
        if (C(cArr)) {
            m0(cArr);
        } else {
            char[] cArr2 = r;
            if (!C(cArr2)) {
                throw new ParseException(this, "expecting \"SYSTEM\" or \"PUBLIC\" while reading external ID");
            }
            m0(cArr2);
            l0();
            j0();
        }
        l0();
        n0();
        return "(WARNING: external ID not read)";
    }

    public final int b() throws IOException {
        if (this.f19366b) {
            return -1;
        }
        int i2 = this.f19371e;
        char[] cArr = this.f19362a;
        if (i2 == cArr.length) {
            this.f19371e = 0;
            this.f19370d = 0;
        }
        Reader reader = this.f19358a;
        int i3 = this.f19371e;
        int i4 = reader.read(cArr, i3, cArr.length - i3);
        if (i4 <= 0) {
            this.f19366b = true;
            return -1;
        }
        this.f19371e += i4;
        return i4;
    }

    public final void b0() throws ParseException, IOException {
        if (z()) {
            g0();
            return;
        }
        if (k()) {
            O();
            return;
        }
        if (p()) {
            W();
            return;
        }
        if (!C(m)) {
            throw new ParseException(this, "expecting processing instruction, comment, or \"<!\"");
        }
        while (!h(dv9.b)) {
            if (i('\'', '\"')) {
                char cJ = J();
                while (!h(cJ)) {
                    J();
                }
                M(cJ);
            } else {
                J();
            }
        }
        M(dv9.b);
    }

    public final int c(int i2) throws IOException {
        int i3;
        int i4;
        if (this.f19366b) {
            return -1;
        }
        int i5 = 0;
        if (this.f19362a.length - this.f19370d < i2) {
            int i6 = 0;
            while (true) {
                i3 = this.f19370d;
                int i7 = i3 + i6;
                i4 = this.f19371e;
                if (i7 >= i4) {
                    break;
                }
                char[] cArr = this.f19362a;
                cArr[i6] = cArr[i3 + i6];
                i6++;
            }
            int i8 = i4 - i3;
            this.f19371e = i8;
            this.f19370d = 0;
            i5 = i8;
        }
        int iB = b();
        if (iB != -1) {
            return i5 + iB;
        }
        if (i5 == 0) {
            return -1;
        }
        return i5;
    }

    public final void c0() throws ParseException, IOException {
        if (k()) {
            O();
        } else if (z()) {
            g0();
        } else {
            if (!B()) {
                throw new ParseException(this, "expecting comment or processing instruction or space");
            }
            l0();
        }
    }

    public final String d() {
        return "";
    }

    public final String d0() throws ParseException, IOException {
        this.f19367b[0] = e0();
        StringBuffer stringBuffer = null;
        int i2 = 1;
        while (w()) {
            if (i2 >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i2);
                    stringBuffer.append(this.f19367b, 0, i2);
                } else {
                    stringBuffer.append(this.f19367b, 0, i2);
                }
                i2 = 0;
            }
            this.f19367b[i2] = J();
            i2++;
        }
        if (stringBuffer == null) {
            return Sparta.a(new String(this.f19367b, 0, i2));
        }
        stringBuffer.append(this.f19367b, 0, i2);
        return stringBuffer.toString();
    }

    public int e() {
        return this.b;
    }

    public final char e0() throws ParseException, IOException {
        char cJ = J();
        if (u(cJ) || cJ == '_' || cJ == ':') {
            return cJ;
        }
        throw new ParseException(this, cJ, "letter, underscore, colon");
    }

    public ParseLog f() {
        return this.f19363b;
    }

    public final String f0() throws ParseException, IOException {
        M('%');
        String strD0 = d0();
        String str = (String) this.f19365b.get(strD0);
        if (str == null) {
            this.f19363b.a("No declaration of %" + strD0 + l.b, this.f19359a, getLineNumber());
            str = "";
        }
        M(dv9.e);
        return str;
    }

    public final boolean g() throws ParseException, IOException {
        return C(s);
    }

    public final void g0() throws ParseException, IOException {
        m0(f);
        while (true) {
            char[] cArr = f19353g;
            if (C(cArr)) {
                m0(cArr);
                return;
            }
            J();
        }
    }

    @Override // com.hp.hpl.sparta.ParseSource
    public int getLineNumber() {
        return this.f19372f;
    }

    @Override // com.hp.hpl.sparta.ParseSource
    public String getSystemId() {
        return this.f19359a;
    }

    public final boolean h(char c2) throws ParseException, IOException {
        if (this.f19370d < this.f19371e || b() != -1) {
            return this.f19362a[this.f19370d] == c2;
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    public final void h0() throws ParseException, IOException {
        int i2;
        loop0: while (true) {
            i2 = 0;
            do {
                if (h(dv9.f41283a) || h(dv9.d) || C(t)) {
                    break loop0;
                }
                this.f19367b[i2] = J();
                if (this.f19367b[i2] == '\r' && F() == '\n') {
                    this.f19367b[i2] = J();
                }
                i2++;
            } while (i2 != 255);
            this.f19356a.characters(this.f19367b, 0, 255);
        }
        if (i2 > 0) {
            this.f19356a.characters(this.f19367b, 0, i2);
        }
    }

    public final boolean i(char c2, char c3) throws ParseException, IOException {
        if (this.f19370d >= this.f19371e && b() == -1) {
            return false;
        }
        char c4 = this.f19362a[this.f19370d];
        return c4 == c2 || c4 == c3;
    }

    public final void i0() throws ParseException, IOException {
        if (E()) {
            q0();
        }
        while (v()) {
            c0();
        }
        if (m()) {
            R();
            while (v()) {
                c0();
            }
        }
    }

    public final boolean j(char c2, char c3, char c4, char c5) throws ParseException, IOException {
        if (this.f19370d >= this.f19371e && b() == -1) {
            return false;
        }
        char c6 = this.f19362a[this.f19370d];
        return c6 == c2 || c6 == c3 || c6 == c4 || c6 == c5;
    }

    public final void j0() throws ParseException, IOException {
        n0();
    }

    public final boolean k() throws ParseException, IOException {
        return C(f19352d);
    }

    public final char[] k0() throws ParseException, IOException {
        return C(n) ? new char[]{N()} : X().toCharArray();
    }

    public final boolean l() throws ParseException, IOException {
        return y() || B();
    }

    public final void l0() throws ParseException, IOException {
        L(' ', '\t', '\r', '\n');
        while (j(' ', '\t', '\r', '\n')) {
            J();
        }
    }

    public final boolean m() throws ParseException, IOException {
        return C(f19354h);
    }

    public final void m0(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f19371e - this.f19370d < length && c(length) <= 0) {
            this.b = -1;
            throw new ParseException(this, "end of XML file", cArr);
        }
        char[] cArr2 = this.f19362a;
        int i2 = this.f19371e;
        this.b = cArr2[i2 - 1];
        if (i2 - this.f19370d < length) {
            throw new ParseException(this, "end of XML file", cArr);
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (this.f19362a[this.f19370d + i3] != cArr[i3]) {
                throw new ParseException(this, new String(this.f19362a, this.f19370d, length), cArr);
            }
        }
        this.f19370d += length;
    }

    public final boolean n() throws ParseException, IOException {
        return C(v);
    }

    public final void n0() throws ParseException, IOException {
        char cJ = J();
        while (F() != cJ) {
            J();
        }
        M(cJ);
    }

    public final boolean o() throws ParseException, IOException {
        return C(j);
    }

    public final void o0() throws ParseException, IOException {
        l0();
        m0(k);
        Z();
        char cK = K('\'', '\"');
        p0();
        M(cK);
    }

    public final boolean p() throws ParseException, IOException {
        return C(o);
    }

    public final void p0() throws ParseException, IOException {
        J();
        while (D()) {
            J();
        }
    }

    public final boolean q() throws ParseException, IOException {
        return i('\'', '\"');
    }

    public final void q0() throws ParseException, IOException {
        m0(f19355i);
        o0();
        if (B()) {
            l0();
        }
        if (o()) {
            String strV = V();
            if (this.f19369c != null && !strV.toLowerCase().equals(this.f19369c)) {
                throw new EncodingMismatchException(this.f19359a, strV, this.f19369c);
            }
        }
        while (true) {
            char[] cArr = f19353g;
            if (C(cArr)) {
                m0(cArr);
                return;
            }
            J();
        }
    }

    public final boolean s() throws ParseException, IOException {
        return C(q) || C(r);
    }

    @Override // com.hp.hpl.sparta.ParseSource
    public String toString() {
        return this.f19359a;
    }

    public final boolean v() throws ParseException, IOException {
        return k() || z() || B();
    }

    public final boolean w() throws ParseException, IOException {
        char cF = F();
        return cF < 128 ? f44483a[cF] : x(cF);
    }

    public final boolean y() throws ParseException, IOException {
        return h('%');
    }

    public final boolean z() throws ParseException, IOException {
        return C(f);
    }

    public rm6(String str, Reader reader, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        this(str, reader, null, parseLog, str2, parseHandler);
    }

    public rm6(String str, Reader reader, char[] cArr, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        this.f19364b = null;
        Hashtable hashtable = new Hashtable();
        this.f19360a = hashtable;
        this.f19365b = new Hashtable();
        this.b = -2;
        this.f19361a = false;
        this.f19368c = 1024;
        this.f19370d = 0;
        this.f19371e = 0;
        this.f19366b = false;
        this.f19367b = new char[255];
        this.f19372f = 1;
        this.f19357a = null;
        parseLog = parseLog == null ? ParseSource.f6848a : parseLog;
        this.f19363b = parseLog;
        this.f19369c = str2 == null ? null : str2.toLowerCase();
        hashtable.put(dv9.f16123a, "<");
        hashtable.put(dv9.f16127b, ">");
        hashtable.put(dv9.f16131c, "&");
        hashtable.put("apos", "'");
        hashtable.put("quot", "\"");
        if (cArr != null) {
            this.f19362a = cArr;
            this.f19370d = 0;
            this.f19371e = cArr.length;
            this.f19366b = true;
            this.f19358a = null;
        } else {
            this.f19358a = reader;
            this.f19362a = new char[1024];
            b();
        }
        this.f19359a = str;
        this.f19356a = parseHandler;
        parseHandler.e(this);
        i0();
        parseHandler.startDocument();
        vy2 vy2VarT = T();
        String str3 = this.f19364b;
        if (str3 != null && !str3.equals(vy2VarT.F())) {
            parseLog.a("DOCTYPE name \"" + this.f19364b + "\" not same as tag name, \"" + vy2VarT.F() + "\" of root element", this.f19359a, getLineNumber());
        }
        while (v()) {
            c0();
        }
        Reader reader2 = this.f19358a;
        if (reader2 != null) {
            reader2.close();
        }
        this.f19356a.endDocument();
    }
}
