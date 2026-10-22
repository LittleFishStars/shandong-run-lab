package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class m extends r {
    public static final ConcurrentHashMap c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f26629a;
    public byte[] b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f26630a;
        public final byte[] b;

        public a(byte[] bArr) {
            this.f26630a = com.baidu.mapauto.auth.org.spongycastle.util.a.b(bArr);
            this.b = bArr;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.b, ((a) obj).b);
            }
            return false;
        }

        public final int hashCode() {
            return this.f26630a;
        }
    }

    public m(byte[] bArr) {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        BigInteger bigIntegerShiftLeft = null;
        int i2 = 0;
        long j = 0;
        while (i2 != bArr.length) {
            int i3 = bArr[i2] & 255;
            if (j <= 72057594037927808L) {
                i = i2;
                long j2 = j + ((long) (i3 & 127));
                if ((i3 & 128) == 0) {
                    if (z) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                i = i2;
                BigInteger bigIntegerOr = (bigIntegerShiftLeft == null ? BigInteger.valueOf(j) : bigIntegerShiftLeft).or(BigInteger.valueOf(i3 & 127));
                if ((i3 & 128) == 0) {
                    if (z) {
                        stringBuffer.append('2');
                        bigIntegerOr = bigIntegerOr.subtract(BigInteger.valueOf(80L));
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(bigIntegerOr);
                    bigIntegerShiftLeft = null;
                    j = 0;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
            i2 = i + 1;
        }
        this.f26629a = stringBuffer.toString();
        this.b = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int iBitLength = (bigInteger.bitLength() + 6) / 7;
        if (iBitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[iBitLength];
        int i = iBitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & 127);
        byteArrayOutputStream.write(bArr, 0, iBitLength);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        byte[] bArrI = i();
        pVar.a(6);
        pVar.b(bArrI.length);
        pVar.f26634a.write(bArrI);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar == this) {
            return true;
        }
        if (rVar instanceof m) {
            return this.f26629a.equals(((m) rVar).f26629a);
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int length = i().length;
        return u1.a(length) + 1 + length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return this.f26629a.hashCode();
    }

    public final synchronized byte[] i() {
        String strSubstring;
        int i;
        String strSubstring2;
        int i2;
        String strSubstring3;
        if (this.b == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            String str = this.f26629a;
            int iIndexOf = str.indexOf(46, 0);
            if (iIndexOf == -1) {
                strSubstring = str.substring(0);
                i = -1;
            } else {
                strSubstring = str.substring(0, iIndexOf);
                i = iIndexOf + 1;
            }
            int i3 = Integer.parseInt(strSubstring) * 40;
            if (i == -1) {
                i2 = i;
                strSubstring2 = null;
            } else {
                int iIndexOf2 = str.indexOf(46, i);
                if (iIndexOf2 == -1) {
                    strSubstring2 = str.substring(i);
                    i2 = -1;
                } else {
                    strSubstring2 = str.substring(i, iIndexOf2);
                    i2 = iIndexOf2 + 1;
                }
            }
            int i4 = 18;
            if (strSubstring2.length() <= 18) {
                long j = Long.parseLong(strSubstring2) + ((long) i3);
                byte[] bArr = new byte[9];
                bArr[8] = (byte) (((int) j) & 127);
                int i5 = 8;
                while (j >= 128) {
                    j >>= 7;
                    i5--;
                    bArr[i5] = (byte) ((((int) j) & 127) | 128);
                }
                byteArrayOutputStream.write(bArr, i5, 9 - i5);
            } else {
                a(byteArrayOutputStream, new BigInteger(strSubstring2).add(BigInteger.valueOf(i3)));
            }
            int i6 = i2;
            while (true) {
                if (!(i6 != -1)) {
                    break;
                }
                if (i6 == -1) {
                    strSubstring3 = null;
                } else {
                    int iIndexOf3 = str.indexOf(46, i6);
                    if (iIndexOf3 == -1) {
                        strSubstring3 = str.substring(i6);
                        i6 = -1;
                    } else {
                        String strSubstring4 = str.substring(i6, iIndexOf3);
                        i6 = iIndexOf3 + 1;
                        strSubstring3 = strSubstring4;
                    }
                }
                if (strSubstring3.length() <= i4) {
                    long j2 = Long.parseLong(strSubstring3);
                    byte[] bArr2 = new byte[9];
                    bArr2[8] = (byte) (((int) j2) & 127);
                    int i7 = 8;
                    while (j2 >= 128) {
                        j2 >>= 7;
                        i7--;
                        bArr2[i7] = (byte) ((((int) j2) & 127) | 128);
                    }
                    byteArrayOutputStream.write(bArr2, i7, 9 - i7);
                } else {
                    a(byteArrayOutputStream, new BigInteger(strSubstring3));
                }
                i4 = 18;
            }
            this.b = byteArrayOutputStream.toByteArray();
        }
        return this.b;
    }

    public final String toString() {
        return this.f26629a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static m a(d dVar) {
        if (dVar == 0 || (dVar instanceof m)) {
            return (m) dVar;
        }
        if (dVar.c() instanceof m) {
            return (m) dVar.c();
        }
        if (!(dVar instanceof byte[])) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("illegal object in getInstance: ");
            sbA.append(dVar.getClass().getName());
            throw new IllegalArgumentException(sbA.toString());
        }
        try {
            return (m) r.a((byte[]) dVar);
        } catch (IOException e) {
            StringBuilder sbA2 = com.baidu.mapauto.auth.a.a("failed to construct object identifier from byte[]: ");
            sbA2.append(e.getMessage());
            throw new IllegalArgumentException(sbA2.toString());
        }
    }
}
