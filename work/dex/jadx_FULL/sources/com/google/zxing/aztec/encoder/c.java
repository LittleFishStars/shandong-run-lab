package com.google.zxing.aztec.encoder;

import com.zj.adlib.j04;
import com.zj.adlib.qv0;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f32501a = new c(Token.b, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f6724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Token f6725a;
    public final int b;
    public final int c;
    public final int d;

    public c(Token token, int i, int i2, int i3) {
        this.f6725a = token;
        this.f6724a = i;
        this.b = i2;
        this.c = i3;
        this.d = c(i2);
    }

    public static int c(int i) {
        if (i > 62) {
            return 21;
        }
        if (i > 31) {
            return 20;
        }
        return i > 0 ? 10 : 0;
    }

    public c a(int i) {
        int i2;
        Token tokenA = this.f6725a;
        int i3 = this.f6724a;
        int i4 = this.c;
        if (i3 == 4 || i3 == 2) {
            int i5 = j04.f17304a[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            tokenA = tokenA.a(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.b;
        if (i8 == 0 || i8 == 31) {
            i2 = 18;
        } else {
            i2 = i8 == 62 ? 9 : 8;
        }
        c cVar = new c(tokenA, i3, i8 + 1, i4 + i2);
        return cVar.b == 2078 ? cVar.d(i + 1) : cVar;
    }

    public c b(int i) {
        Token tokenA;
        Token token = k(4, 0).f6725a;
        int length = 3;
        if (i < 0) {
            tokenA = token.a(0, 3);
        } else {
            if (i > 999999) {
                throw new IllegalArgumentException("ECI code must be between 0 and 999999");
            }
            byte[] bytes = Integer.toString(i).getBytes(StandardCharsets.ISO_8859_1);
            Token tokenA2 = token.a(bytes.length, 3);
            for (byte b : bytes) {
                tokenA2 = tokenA2.a((b - 48) + 2, 4);
            }
            length = 3 + (bytes.length * 4);
            tokenA = tokenA2;
        }
        return new c(tokenA, this.f6724a, 0, this.c + length);
    }

    public c d(int i) {
        int i2 = this.b;
        return i2 == 0 ? this : new c(this.f6725a.b(i - i2, i2), this.f6724a, 0, this.c);
    }

    public int e() {
        return this.b;
    }

    public int f() {
        return this.c;
    }

    public int g() {
        return this.f6724a;
    }

    public Token h() {
        return this.f6725a;
    }

    public boolean i(c cVar) {
        int i = this.c + (j04.f17304a[this.f6724a][cVar.f6724a] >> 16);
        int i2 = this.b;
        int i3 = cVar.b;
        if (i2 < i3) {
            i += cVar.d - this.d;
        } else if (i2 > i3 && i3 > 0) {
            i += 10;
        }
        return i <= cVar.c;
    }

    public c j(int i, int i2) {
        int i3 = this.c;
        Token tokenA = this.f6725a;
        int i4 = this.f6724a;
        if (i != i4) {
            int i5 = j04.f17304a[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            tokenA = tokenA.a(i6, i7);
            i3 += i7;
        }
        int i8 = i == 2 ? 4 : 5;
        return new c(tokenA.a(i2, i8), i, 0, i3 + i8);
    }

    public c k(int i, int i2) {
        Token token = this.f6725a;
        int i3 = this.f6724a;
        int i4 = i3 == 2 ? 4 : 5;
        return new c(token.a(j04.f17306c[i3][i], i4).a(i2, 5), this.f6724a, 0, this.c + i4 + 5);
    }

    public qv0 l(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        for (Token tokenD = d(bArr.length).f6725a; tokenD != null; tokenD = tokenD.d()) {
            arrayList.add(tokenD);
        }
        qv0 qv0Var = new qv0();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Token) arrayList.get(size)).c(qv0Var, bArr);
        }
        return qv0Var;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", j04.f17303a[this.f6724a], Integer.valueOf(this.c), Integer.valueOf(this.b));
    }
}
