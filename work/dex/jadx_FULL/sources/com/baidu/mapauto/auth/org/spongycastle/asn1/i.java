package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class i extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f26623a;
    public final boolean b;
    public final byte[][] c;

    public i(int i, InputStream inputStream) {
        this(inputStream, i, false);
    }

    public i(InputStream inputStream, int i, boolean z) {
        super(inputStream);
        this.f26623a = i;
        this.b = z;
        this.c = new byte[11][];
    }

    public i(byte[] bArr) {
        this(bArr.length, new ByteArrayInputStream(bArr));
    }

    public i(byte[] bArr, int i) {
        this(new ByteArrayInputStream(bArr), bArr.length, true);
    }

    public static int a(int i, InputStream inputStream) throws IOException {
        int i2 = inputStream.read();
        if (i2 < 0) {
            throw new EOFException("EOF found when length expected");
        }
        if (i2 == 128) {
            return -1;
        }
        if (i2 <= 127) {
            return i2;
        }
        int i3 = i2 & 127;
        if (i3 > 4) {
            throw new IOException("DER length more than 4 bytes: " + i3);
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = inputStream.read();
            if (i6 < 0) {
                throw new EOFException("EOF found reading length");
            }
            i4 = (i4 << 8) + i6;
        }
        if (i4 < 0) {
            throw new IOException("corrupted stream - negative length found");
        }
        if (i4 < i) {
            return i4;
        }
        throw new IOException("corrupted stream - out of bounds length found");
    }

    public static e a(o1 o1Var) throws IOException {
        i iVar = new i(o1Var, u1.a(o1Var), false);
        e eVar = new e();
        while (true) {
            r rVarA = iVar.a();
            if (rVarA == null) {
                return eVar;
            }
            eVar.f26614a.addElement(rVarA);
        }
    }

    public static int b(int i, InputStream inputStream) throws IOException {
        int i2 = i & 31;
        if (i2 != 31) {
            return i2;
        }
        int i3 = inputStream.read();
        if ((i3 & 127) == 0) {
            throw new IOException("corrupted stream - invalid high tag number found");
        }
        int i4 = 0;
        while (i3 >= 0 && (i3 & 128) != 0) {
            i4 = ((i3 & 127) | i4) << 7;
            i3 = inputStream.read();
        }
        if (i3 >= 0) {
            return (i3 & 127) | i4;
        }
        throw new EOFException("EOF found inside tag value.");
    }

    public final r a(int i, int i2, int i3) throws IOException {
        boolean z = (i & 32) != 0;
        o1 o1Var = new o1(i3, this);
        if ((i & 64) != 0) {
            return new k0(z, i2, o1Var.c());
        }
        if ((i & 128) != 0) {
            return new v(u1.a(o1Var), o1Var).a(z, i2);
        }
        if (!z) {
            return a(i2, o1Var, this.c);
        }
        if (i2 == 4) {
            e eVarA = a(o1Var);
            int size = eVarA.f26614a.size();
            n[] nVarArr = new n[size];
            for (int i4 = 0; i4 != size; i4++) {
                nVarArr[i4] = (n) eVarA.a(i4);
            }
            return new b0(nVarArr);
        }
        if (i2 == 8) {
            return new n0(a(o1Var));
        }
        if (i2 == 16) {
            if (this.b) {
                return new s1(o1Var.c());
            }
            e eVarA2 = a(o1Var);
            return eVarA2.f26614a.size() < 1 ? p0.f26635a : new l1(eVarA2);
        }
        if (i2 == 17) {
            e eVarA3 = a(o1Var);
            z0 z0Var = p0.f26635a;
            return eVarA3.f26614a.size() < 1 ? p0.b : new m1(eVarA3);
        }
        throw new IOException("unknown tag " + i2 + " encountered");
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0095  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00aa  */
    public static r a(int i, o1 o1Var, byte[][] bArr) throws IOException {
        byte[] bArrC;
        int i2;
        byte[] bArrC2;
        byte b;
        byte[] bArrC3;
        if (i == 10) {
            int i3 = o1Var.d;
            if (i3 < bArr.length) {
                bArrC = bArr[i3];
                if (bArrC == null) {
                    bArrC = new byte[i3];
                    bArr[i3] = bArrC;
                }
                int length = bArrC.length;
                int i4 = 0;
                while (i4 < length) {
                    int i5 = o1Var.read(bArrC, 0 + i4, length - i4);
                    if (i5 < 0) {
                        break;
                    }
                    i4 += i5;
                }
            } else {
                bArrC = o1Var.c();
            }
            if (bArrC.length > 1) {
                return new f(bArrC);
            }
            if (bArrC.length == 0) {
                throw new IllegalArgumentException("ENUMERATED has zero length");
            }
            int i6 = bArrC[0] & 255;
            f[] fVarArr = f.b;
            if (i6 >= 12) {
                return new f(com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArrC));
            }
            f fVar = fVarArr[i6];
            if (fVar == null) {
                fVar = new f(com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArrC));
                fVarArr[i6] = fVar;
            }
            return fVar;
        }
        if (i == 12) {
            return new f1(o1Var.c());
        }
        if (i != 30) {
            switch (i) {
                case 1:
                    int i7 = o1Var.d;
                    if (i7 < bArr.length) {
                        bArrC2 = bArr[i7];
                        if (bArrC2 == null) {
                            bArrC2 = new byte[i7];
                            bArr[i7] = bArrC2;
                        }
                        int length2 = bArrC2.length;
                        int i8 = 0;
                        while (i8 < length2) {
                            int i9 = o1Var.read(bArrC2, 0 + i8, length2 - i8);
                            if (i9 >= 0) {
                                i8 += i9;
                            }
                        }
                    } else {
                        bArrC2 = o1Var.c();
                    }
                    byte[] bArr2 = c.b;
                    if (bArrC2.length != 1) {
                        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
                    }
                    byte b2 = bArrC2[0];
                    if (b2 == 0) {
                        return c.d;
                    }
                    return (b2 & 255) == 255 ? c.e : new c(bArrC2);
                case 2:
                    return new j(o1Var.c());
                case 3:
                    int i10 = o1Var.d;
                    if (i10 < 1) {
                        throw new IllegalArgumentException("truncated BIT STRING detected");
                    }
                    int i11 = o1Var.read();
                    int i12 = i10 - 1;
                    byte[] bArr3 = new byte[i12];
                    if (i12 != 0) {
                        int i13 = 0;
                        while (i13 < i12) {
                            int i14 = o1Var.read(bArr3, 0 + i13, i12 - i13);
                            if (i14 >= 0) {
                                i13 += i14;
                            } else {
                                if (i13 == i12) {
                                    throw new EOFException("EOF encountered in middle of BIT STRING");
                                }
                                if (i11 > 0 && i11 < 8) {
                                    b = bArr3[i12 - 1];
                                    if (b != ((byte) ((255 << i11) & b))) {
                                        return new j1(bArr3, i11);
                                    }
                                }
                            }
                        }
                        if (i13 == i12) {
                            throw new EOFException("EOF encountered in middle of BIT STRING");
                        }
                        if (i11 > 0) {
                            b = bArr3[i12 - 1];
                            if (b != ((byte) ((255 << i11) & b))) {
                                return new j1(bArr3, i11);
                            }
                        }
                    }
                    return new m0(bArr3, i11);
                case 4:
                    return new v0(o1Var.c());
                case 5:
                    return t0.f26643a;
                case 6:
                    int i15 = o1Var.d;
                    if (i15 < bArr.length) {
                        bArrC3 = bArr[i15];
                        if (bArrC3 == null) {
                            bArrC3 = new byte[i15];
                            bArr[i15] = bArrC3;
                        }
                        int length3 = bArrC3.length;
                        int i16 = 0;
                        while (i16 < length3) {
                            int i17 = o1Var.read(bArrC3, 0 + i16, length3 - i16);
                            if (i17 >= 0) {
                                i16 += i17;
                            }
                        }
                    } else {
                        bArrC3 = o1Var.c();
                    }
                    m mVar = (m) m.c.get(new m.a(bArrC3));
                    return mVar == null ? new m(bArrC3) : mVar;
                default:
                    switch (i) {
                        case 18:
                            return new u0(o1Var.c());
                        case 19:
                            return new y0(o1Var.c());
                        case 20:
                            return new d1(o1Var.c());
                        case 21:
                            return new h1(o1Var.c());
                        case 22:
                            return new s0(o1Var.c());
                        case 23:
                            return new x(o1Var.c());
                        case 24:
                            return new h(o1Var.c());
                        case 25:
                            return new r0(o1Var.c());
                        case 26:
                            return new i1(o1Var.c());
                        case 27:
                            return new q0(o1Var.c());
                        case 28:
                            return new g1(o1Var.c());
                        default:
                            throw new IOException("unknown tag " + i + " encountered");
                    }
            }
        }
        int i18 = o1Var.d / 2;
        char[] cArr = new char[i18];
        for (int i19 = 0; i19 < i18; i19++) {
            int i20 = o1Var.read();
            if (i20 < 0 || (i2 = o1Var.read()) < 0) {
                break;
            }
            cArr[i19] = (char) ((i20 << 8) | (i2 & 255));
        }
        return new l0(cArr);
    }

    public final r a() throws IOException {
        int i = read();
        if (i <= 0) {
            if (i != 0) {
                return null;
            }
            throw new IOException("unexpected end-of-contents marker");
        }
        int iB = b(i, this);
        boolean z = (i & 32) != 0;
        int iA = a(this.f26623a, this);
        if (iA >= 0) {
            try {
                return a(i, iB, iA);
            } catch (IllegalArgumentException e) {
                throw new g("corrupted stream detected", e);
            }
        }
        if (z) {
            v vVar = new v(this.f26623a, new q1(this.f26623a, this));
            if ((i & 64) != 0) {
                return new y(iB, vVar.b());
            }
            if ((i & 128) != 0) {
                return vVar.a(true, iB);
            }
            if (iB != 4) {
                if (iB == 8) {
                    try {
                        return new n0(vVar.b());
                    } catch (IllegalArgumentException e2) {
                        throw new g(e2.getMessage(), e2);
                    }
                }
                if (iB == 16) {
                    return new d0(vVar.b());
                }
                if (iB == 17) {
                    return new f0(vVar.b());
                }
                throw new IOException("unknown BER object encountered");
            }
            j0 j0Var = new j0(vVar);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = j0Var.read(bArr, 0, 4096);
                if (i2 < 0) {
                    return new b0(byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }
}
