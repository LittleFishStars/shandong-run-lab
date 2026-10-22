package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.kgc;
import com.zj.adlib.kxc;
import com.zj.adlib.rmc;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h {
    public static int a(byte[] bArr, int i, kgc kgcVar) throws zzeo {
        int iJ = j(bArr, i, kgcVar);
        int i2 = kgcVar.f42815a;
        if (i2 < 0) {
            throw zzeo.zzd();
        }
        if (i2 > bArr.length - iJ) {
            throw zzeo.zzg();
        }
        if (i2 == 0) {
            kgcVar.f17678a = zzdb.zzb;
            return iJ;
        }
        kgcVar.f17678a = zzdb.zzr(bArr, iJ, i2);
        return iJ + i2;
    }

    public static int b(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static int c(zzgh zzghVar, byte[] bArr, int i, int i2, int i3, kgc kgcVar) throws IOException {
        Object objE = zzghVar.e();
        int iN = n(objE, zzghVar, bArr, i, i2, i3, kgcVar);
        zzghVar.b(objE);
        kgcVar.f17678a = objE;
        return iN;
    }

    public static int d(zzgh zzghVar, byte[] bArr, int i, int i2, kgc kgcVar) throws IOException {
        Object objE = zzghVar.e();
        int iO = o(objE, zzghVar, bArr, i, i2, kgcVar);
        zzghVar.b(objE);
        kgcVar.f17678a = objE;
        return iO;
    }

    public static int e(zzgh zzghVar, int i, byte[] bArr, int i2, int i3, zzel zzelVar, kgc kgcVar) throws IOException {
        int iD = d(zzghVar, bArr, i2, i3, kgcVar);
        zzelVar.add(kgcVar.f17678a);
        while (iD < i3) {
            int iJ = j(bArr, iD, kgcVar);
            if (i != kgcVar.f42815a) {
                break;
            }
            iD = d(zzghVar, bArr, iJ, i3, kgcVar);
            zzelVar.add(kgcVar.f17678a);
        }
        return iD;
    }

    public static int f(byte[] bArr, int i, zzel zzelVar, kgc kgcVar) throws IOException {
        t tVar = (t) zzelVar;
        int iJ = j(bArr, i, kgcVar);
        int i2 = kgcVar.f42815a + iJ;
        while (iJ < i2) {
            iJ = j(bArr, iJ, kgcVar);
            tVar.c(kgcVar.f42815a);
        }
        if (iJ == i2) {
            return iJ;
        }
        throw zzeo.zzg();
    }

    public static int g(byte[] bArr, int i, kgc kgcVar) throws zzeo {
        int iJ = j(bArr, i, kgcVar);
        int i2 = kgcVar.f42815a;
        if (i2 < 0) {
            throw zzeo.zzd();
        }
        if (i2 == 0) {
            kgcVar.f17678a = "";
            return iJ;
        }
        kgcVar.f17678a = new String(bArr, iJ, i2, rmc.b);
        return iJ + i2;
    }

    public static int h(byte[] bArr, int i, kgc kgcVar) throws zzeo {
        int iJ = j(bArr, i, kgcVar);
        int i2 = kgcVar.f42815a;
        if (i2 < 0) {
            throw zzeo.zzd();
        }
        if (i2 == 0) {
            kgcVar.f17678a = "";
            return iJ;
        }
        int length = bArr.length;
        int i3 = u0.f31396a;
        if ((iJ | i2 | ((length - iJ) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iJ), Integer.valueOf(i2)));
        }
        int i4 = iJ + i2;
        char[] cArr = new char[i2];
        int i5 = 0;
        while (iJ < i4) {
            byte b = bArr[iJ];
            if (!kxc.d(b)) {
                break;
            }
            iJ++;
            cArr[i5] = (char) b;
            i5++;
        }
        while (iJ < i4) {
            int i6 = iJ + 1;
            byte b2 = bArr[iJ];
            if (kxc.d(b2)) {
                int i7 = i5 + 1;
                cArr[i5] = (char) b2;
                iJ = i6;
                while (true) {
                    i5 = i7;
                    if (iJ >= i4) {
                        break;
                    }
                    byte b3 = bArr[iJ];
                    if (!kxc.d(b3)) {
                        break;
                    }
                    iJ++;
                    i7 = i5 + 1;
                    cArr[i5] = (char) b3;
                }
            } else if (b2 < -32) {
                if (i6 >= i4) {
                    throw zzeo.zzc();
                }
                kxc.c(b2, bArr[i6], cArr, i5);
                iJ = i6 + 1;
                i5++;
            } else if (b2 < -16) {
                if (i6 >= i4 - 1) {
                    throw zzeo.zzc();
                }
                int i8 = i6 + 1;
                kxc.b(b2, bArr[i6], bArr[i8], cArr, i5);
                iJ = i8 + 1;
                i5++;
            } else {
                if (i6 >= i4 - 2) {
                    throw zzeo.zzc();
                }
                int i9 = i6 + 1;
                byte b4 = bArr[i6];
                int i10 = i9 + 1;
                kxc.a(b2, b4, bArr[i9], bArr[i10], cArr, i5);
                i5 += 2;
                iJ = i10 + 1;
            }
        }
        kgcVar.f17678a = new String(cArr, 0, i5);
        return i4;
    }

    public static int i(int i, byte[] bArr, int i2, int i3, o0 o0Var, kgc kgcVar) throws zzeo {
        if ((i >>> 3) == 0) {
            throw zzeo.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iM = m(bArr, i2, kgcVar);
            o0Var.j(i, Long.valueOf(kgcVar.f17676a));
            return iM;
        }
        if (i4 == 1) {
            o0Var.j(i, Long.valueOf(q(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iJ = j(bArr, i2, kgcVar);
            int i5 = kgcVar.f42815a;
            if (i5 < 0) {
                throw zzeo.zzd();
            }
            if (i5 > bArr.length - iJ) {
                throw zzeo.zzg();
            }
            if (i5 == 0) {
                o0Var.j(i, zzdb.zzb);
            } else {
                o0Var.j(i, zzdb.zzr(bArr, iJ, i5));
            }
            return iJ + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzeo.zzb();
            }
            o0Var.j(i, Integer.valueOf(b(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        o0 o0VarF = o0.f();
        int i7 = 0;
        while (i2 < i3) {
            int iJ2 = j(bArr, i2, kgcVar);
            int i8 = kgcVar.f42815a;
            i7 = i8;
            if (i8 == i6) {
                i2 = iJ2;
                break;
            }
            int i9 = i(i7, bArr, iJ2, i3, o0VarF, kgcVar);
            i7 = i8;
            i2 = i9;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzeo.zze();
        }
        o0Var.j(i, o0VarF);
        return i2;
    }

    public static int j(byte[] bArr, int i, kgc kgcVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return k(b, bArr, i2, kgcVar);
        }
        kgcVar.f42815a = b;
        return i2;
    }

    public static int k(int i, byte[] bArr, int i2, kgc kgcVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            kgcVar.f42815a = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            kgcVar.f42815a = i5 | (b2 << com.google.common.base.a.p);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            kgcVar.f42815a = i7 | (b3 << com.google.common.base.a.y);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            kgcVar.f42815a = i9 | (b4 << com.google.common.base.a.F);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                kgcVar.f42815a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int l(int i, byte[] bArr, int i2, int i3, zzel zzelVar, kgc kgcVar) {
        t tVar = (t) zzelVar;
        int iJ = j(bArr, i2, kgcVar);
        tVar.c(kgcVar.f42815a);
        while (iJ < i3) {
            int iJ2 = j(bArr, iJ, kgcVar);
            if (i != kgcVar.f42815a) {
                break;
            }
            iJ = j(bArr, iJ2, kgcVar);
            tVar.c(kgcVar.f42815a);
        }
        return iJ;
    }

    public static int m(byte[] bArr, int i, kgc kgcVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            kgcVar.f17676a = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            i3 = i5;
            b = b2;
        }
        kgcVar.f17676a = j2;
        return i3;
    }

    public static int n(Object obj, zzgh zzghVar, byte[] bArr, int i, int i2, int i3, kgc kgcVar) throws IOException {
        int iF = ((e0) zzghVar).F(obj, bArr, i, i2, i3, kgcVar);
        kgcVar.f17678a = obj;
        return iF;
    }

    public static int o(Object obj, zzgh zzghVar, byte[] bArr, int i, int i2, kgc kgcVar) throws IOException {
        int iK = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iK = k(i3, bArr, iK, kgcVar);
            i3 = kgcVar.f42815a;
        }
        int i4 = iK;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzeo.zzg();
        }
        int i5 = i3 + i4;
        zzghVar.i(obj, bArr, i4, i5, kgcVar);
        kgcVar.f17678a = obj;
        return i5;
    }

    public static int p(int i, byte[] bArr, int i2, int i3, kgc kgcVar) throws zzeo {
        if ((i >>> 3) == 0) {
            throw zzeo.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return m(bArr, i2, kgcVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return j(bArr, i2, kgcVar) + kgcVar.f42815a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzeo.zzb();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = j(bArr, i2, kgcVar);
            i6 = kgcVar.f42815a;
            if (i6 == i5) {
                break;
            }
            i2 = p(i6, bArr, i2, i3, kgcVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzeo.zze();
        }
        return i2;
    }

    public static long q(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
