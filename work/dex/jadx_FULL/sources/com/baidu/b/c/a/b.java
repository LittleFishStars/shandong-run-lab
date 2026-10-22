package com.baidu.b.c.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Array;
import java.security.InvalidKeyException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b implements a {
    private static int[] b;
    private static int[] c;
    private static final byte[] d = new byte[256];
    private static final byte[] e = new byte[256];
    private static final int[] f = new int[256];
    private static final int[] g = new int[256];
    private static final int[] h = new int[256];
    private static final int[] i = new int[256];
    private static final int[] j = new int[256];
    private static final int[] k = new int[256];
    private static final int[] l = new int[256];
    private static final int[] m = new int[256];
    private static final int[] n = new int[256];
    private static final int[] o = new int[256];
    private static final int[] p = new int[256];
    private static final int[] q = new int[256];
    private static final byte[] r = new byte[30];
    private boolean s = false;
    private boolean t = false;
    private Object[] u = null;
    private int[] v = null;
    private int w = 0;

    static {
        int[] iArr = new int[256];
        b = iArr;
        c = new int[256];
        iArr[0] = 1;
        for (int i2 = 1; i2 < 256; i2++) {
            int[] iArr2 = b;
            int i3 = iArr2[i2 - 1];
            int i4 = i3 ^ (i3 << 1);
            if ((i4 & 256) != 0) {
                i4 ^= MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS;
            }
            iArr2[i2] = i4;
        }
        for (int i5 = 1; i5 < 255; i5++) {
            c[b[i5]] = i5;
        }
        byte[][] bArr = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        byte[] bArr2 = {0, 1, 1, 0, 0, 0, 1, 1};
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 256, 8);
        bArr3[1][7] = 1;
        for (int i6 = 2; i6 < 256; i6++) {
            int i7 = b[255 - c[i6]];
            for (int i8 = 0; i8 < 8; i8++) {
                bArr3[i6][i8] = (byte) ((i7 >>> (7 - i8)) & 1);
            }
        }
        byte[][] bArr4 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 256, 8);
        for (int i9 = 0; i9 < 256; i9++) {
            for (int i10 = 0; i10 < 8; i10++) {
                bArr4[i9][i10] = bArr2[i10];
                for (int i11 = 0; i11 < 8; i11++) {
                    byte[] bArr5 = bArr4[i9];
                    bArr5[i10] = (byte) (bArr5[i10] ^ (bArr[i10][i11] * bArr3[i9][i11]));
                }
            }
        }
        for (int i12 = 0; i12 < 256; i12++) {
            d[i12] = (byte) (bArr4[i12][0] << 7);
            for (int i13 = 1; i13 < 8; i13++) {
                byte[] bArr6 = d;
                bArr6[i12] = (byte) (bArr6[i12] ^ (bArr4[i12][i13] << (7 - i13)));
            }
            e[d[i12] & 255] = (byte) i12;
        }
        byte[][] bArr7 = {new byte[]{2, 1, 1, 3}, new byte[]{3, 2, 1, 1}, new byte[]{1, 3, 2, 1}, new byte[]{1, 1, 3, 2}};
        byte[][] bArr8 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 8);
        for (int i14 = 0; i14 < 4; i14++) {
            for (int i15 = 0; i15 < 4; i15++) {
                bArr8[i14][i15] = bArr7[i14][i15];
            }
            bArr8[i14][i14 + 4] = 1;
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 4);
        for (int i16 = 0; i16 < 4; i16++) {
            byte b2 = bArr8[i16][i16];
            if (b2 == 0) {
                int i17 = i16 + 1;
                while (bArr8[i17][i16] == 0 && i17 < 4) {
                    i17++;
                }
                if (i17 == 4) {
                    throw new RuntimeException("G matrix is not invertible");
                }
                for (int i18 = 0; i18 < 8; i18++) {
                    byte[] bArr10 = bArr8[i16];
                    byte b3 = bArr10[i18];
                    byte[] bArr11 = bArr8[i17];
                    bArr10[i18] = bArr11[i18];
                    bArr11[i18] = b3;
                }
                b2 = bArr8[i16][i16];
            }
            for (int i19 = 0; i19 < 8; i19++) {
                byte[] bArr12 = bArr8[i16];
                byte b4 = bArr12[i19];
                if (b4 != 0) {
                    int[] iArr3 = b;
                    int[] iArr4 = c;
                    bArr12[i19] = (byte) iArr3[((iArr4[b4 & 255] + 255) - iArr4[b2 & 255]) % 255];
                }
            }
            for (int i20 = 0; i20 < 4; i20++) {
                if (i16 != i20) {
                    for (int i21 = i16 + 1; i21 < 8; i21++) {
                        byte[] bArr13 = bArr8[i20];
                        bArr13[i21] = (byte) (bArr13[i21] ^ a(bArr8[i16][i21], bArr13[i16]));
                    }
                    bArr8[i20][i16] = 0;
                }
            }
        }
        for (int i22 = 0; i22 < 4; i22++) {
            for (int i23 = 0; i23 < 4; i23++) {
                bArr9[i22][i23] = bArr8[i22][i23 + 4];
            }
        }
        for (int i24 = 0; i24 < 256; i24++) {
            byte b5 = d[i24];
            f[i24] = a(b5, bArr7[0]);
            g[i24] = a(b5, bArr7[1]);
            h[i24] = a(b5, bArr7[2]);
            i[i24] = a(b5, bArr7[3]);
            byte b6 = e[i24];
            j[i24] = a(b6, bArr9[0]);
            k[i24] = a(b6, bArr9[1]);
            l[i24] = a(b6, bArr9[2]);
            m[i24] = a(b6, bArr9[3]);
            n[i24] = a(i24, bArr9[0]);
            o[i24] = a(i24, bArr9[1]);
            p[i24] = a(i24, bArr9[2]);
            q[i24] = a(i24, bArr9[3]);
        }
        r[0] = 1;
        int iA = 1;
        for (int i25 = 1; i25 < 30; i25++) {
            iA = a(2, iA);
            r[i25] = (byte) iA;
        }
        c = null;
        b = null;
    }

    private static final int a(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = b;
        int[] iArr2 = c;
        return iArr[(iArr2[i2 & 255] + iArr2[i3 & 255]) % 255];
    }

    private static final int a(int i2, byte[] bArr) {
        if (i2 == 0) {
            return 0;
        }
        int[] iArr = c;
        int i3 = iArr[i2 & 255];
        byte b2 = bArr[0];
        int i4 = b2 != 0 ? b[(iArr[b2 & 255] + i3) % 255] & 255 : 0;
        byte b3 = bArr[1];
        int i5 = b3 != 0 ? b[(iArr[b3 & 255] + i3) % 255] & 255 : 0;
        byte b4 = bArr[2];
        int i6 = b4 != 0 ? b[(iArr[b4 & 255] + i3) % 255] & 255 : 0;
        byte b5 = bArr[3];
        return (i4 << 24) | (i5 << 16) | (i6 << 8) | (b5 != 0 ? b[(i3 + iArr[b5 & 255]) % 255] & 255 : 0);
    }

    private void a(boolean z) {
        int[][] iArr = (int[][]) this.u[z ? 1 : 0];
        int length = iArr.length;
        this.v = new int[length * 4];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                this.v[(i2 * 4) + i3] = iArr[i2][i3];
            }
        }
        if (z) {
            int[] iArr2 = this.v;
            int i4 = iArr2[iArr2.length - 4];
            int i5 = iArr2[iArr2.length - 3];
            int i6 = iArr2[iArr2.length - 2];
            int i7 = iArr2[iArr2.length - 1];
            for (int length2 = iArr2.length - 1; length2 > 3; length2--) {
                int[] iArr3 = this.v;
                iArr3[length2] = iArr3[length2 - 4];
            }
            int[] iArr4 = this.v;
            iArr4[0] = i4;
            iArr4[1] = i5;
            iArr4[2] = i6;
            iArr4[3] = i7;
        }
        this.s = length >= 13;
        this.t = length == 15;
        this.w = (length - 1) * 4;
    }

    public static final boolean a(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = a.f26278a;
            if (i3 >= iArr.length) {
                return false;
            }
            if (i2 == iArr[i3]) {
                return true;
            }
            i3++;
        }
    }

    private static Object[] a(byte[] bArr) throws InvalidKeyException {
        int i2;
        if (bArr == null) {
            throw new InvalidKeyException("Empty key");
        }
        if (!a(bArr.length)) {
            throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
        }
        int iB = b(bArr.length);
        int i3 = iB + 1;
        int i4 = i3 * 4;
        int i5 = 0;
        Class cls = Integer.TYPE;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, i3, 4);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, i3, 4);
        int length = bArr.length / 4;
        int[] iArr3 = new int[length];
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            iArr3[i6] = ((bArr[i7 + 2] & 255) << 8) | (bArr[i7] << com.google.common.base.a.B) | ((bArr[i7 + 1] & 255) << 16) | (bArr[i7 + 3] & 255);
            i6++;
            i7 += 4;
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < length && i9 < i4) {
            int i10 = i9 / 4;
            int i11 = i9 % 4;
            iArr[i10][i11] = iArr3[i8];
            iArr2[iB - i10][i11] = iArr3[i8];
            i8++;
            i9++;
        }
        int i12 = 0;
        while (i9 < i4) {
            int i13 = iArr3[length - 1];
            int i14 = iArr3[i5];
            byte[] bArr2 = d;
            int i15 = (((bArr2[(i13 >>> 16) & 255] << com.google.common.base.a.B) ^ ((bArr2[(i13 >>> 8) & 255] & 255) << 16)) ^ ((bArr2[i13 & 255] & 255) << 8)) ^ (bArr2[i13 >>> 24] & 255);
            int i16 = i12 + 1;
            iArr3[i5] = ((r[i12] << com.google.common.base.a.B) ^ i15) ^ i14;
            int i17 = 1;
            int i18 = i5;
            if (length != 8) {
                while (i17 < length) {
                    iArr3[i17] = iArr3[i17] ^ iArr3[i18];
                    i17++;
                    i18++;
                }
            } else {
                while (true) {
                    i2 = length / 2;
                    if (i17 >= i2) {
                        break;
                    }
                    iArr3[i17] = iArr3[i17] ^ iArr3[i18];
                    i17++;
                    i18++;
                }
                int i19 = iArr3[i2 - 1];
                int i20 = iArr3[i2];
                byte[] bArr3 = d;
                iArr3[i2] = ((bArr3[i19 >>> 24] << com.google.common.base.a.B) ^ ((((bArr3[(i19 >>> 8) & 255] & 255) << 8) ^ (bArr3[i19 & 255] & 255)) ^ ((bArr3[(i19 >>> 16) & 255] & 255) << 16))) ^ i20;
                int i21 = i2 + 1;
                while (i21 < length) {
                    iArr3[i21] = iArr3[i21] ^ iArr3[i2];
                    i21++;
                    i2++;
                }
            }
            int i22 = 0;
            while (i22 < length && i9 < i4) {
                int i23 = i9 / 4;
                int i24 = i9 % 4;
                iArr[i23][i24] = iArr3[i22];
                iArr2[iB - i23][i24] = iArr3[i22];
                i22++;
                i9++;
            }
            i12 = i16;
            i5 = 0;
        }
        for (int i25 = 1; i25 < iB; i25++) {
            for (int i26 = 0; i26 < 4; i26++) {
                int[] iArr4 = iArr2[i25];
                int i27 = iArr4[i26];
                iArr4[i26] = q[i27 & 255] ^ ((n[(i27 >>> 24) & 255] ^ o[(i27 >>> 16) & 255]) ^ p[(i27 >>> 8) & 255]);
            }
        }
        return new Object[]{iArr, iArr2};
    }

    private static int b(int i2) {
        return (i2 >> 2) + 6;
    }

    public int a() {
        return 16;
    }

    public void a(boolean z, String str, byte[] bArr) throws InvalidKeyException {
        if (a(bArr.length)) {
            this.u = a(bArr);
            a(z);
        } else {
            throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
        }
    }

    public void a(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i4] & 255) << 16) | (bArr[i2] << com.google.common.base.a.B);
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & 255) << 8);
        int i9 = i7 + 1;
        int i10 = i8 | (bArr[i7] & 255);
        int[] iArr = this.v;
        int i11 = i10 ^ iArr[0];
        int i12 = i9 + 1;
        int i13 = i12 + 1;
        int i14 = (bArr[i9] << com.google.common.base.a.B) | ((bArr[i12] & 255) << 16);
        int i15 = i13 + 1;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        int i17 = i15 + 1;
        int i18 = (i16 | (bArr[i15] & 255)) ^ iArr[1];
        int i19 = i17 + 1;
        int i20 = i19 + 1;
        int i21 = ((bArr[i19] & 255) << 16) | (bArr[i17] << com.google.common.base.a.B);
        int i22 = i20 + 1;
        int i23 = i21 | ((bArr[i20] & 255) << 8);
        int i24 = i22 + 1;
        int i25 = (i23 | (bArr[i22] & 255)) ^ iArr[2];
        int i26 = i24 + 1;
        int i27 = i26 + 1;
        int i28 = iArr[3] ^ (((((bArr[i26] & 255) << 16) | (bArr[i24] << com.google.common.base.a.B)) | ((bArr[i27] & 255) << 8)) | (bArr[i27 + 1] & 255));
        int i29 = 4;
        while (i29 < this.w) {
            int[] iArr2 = f;
            int i30 = iArr2[i11 >>> 24];
            int[] iArr3 = g;
            int i31 = i30 ^ iArr3[(i18 >>> 16) & 255];
            int[] iArr4 = h;
            int i32 = i31 ^ iArr4[(i25 >>> 8) & 255];
            int[] iArr5 = i;
            int i33 = i32 ^ iArr5[i28 & 255];
            int[] iArr6 = this.v;
            int i34 = i29 + 1;
            int i35 = iArr6[i29] ^ i33;
            int i36 = i34 + 1;
            int i37 = (((iArr2[i18 >>> 24] ^ iArr3[(i25 >>> 16) & 255]) ^ iArr4[(i28 >>> 8) & 255]) ^ iArr5[i11 & 255]) ^ iArr6[i34];
            int i38 = i36 + 1;
            int i39 = (((iArr2[i25 >>> 24] ^ iArr3[(i28 >>> 16) & 255]) ^ iArr4[(i11 >>> 8) & 255]) ^ iArr5[i18 & 255]) ^ iArr6[i36];
            int i40 = (((iArr3[(i11 >>> 16) & 255] ^ iArr2[i28 >>> 24]) ^ iArr4[(i18 >>> 8) & 255]) ^ iArr5[i25 & 255]) ^ iArr6[i38];
            i18 = i37;
            i25 = i39;
            i28 = i40;
            i11 = i35;
            i29 = i38 + 1;
        }
        int[] iArr7 = this.v;
        int i41 = i29 + 1;
        int i42 = iArr7[i29];
        int i43 = i3 + 1;
        byte[] bArr3 = d;
        bArr2[i3] = (byte) (bArr3[i11 >>> 24] ^ (i42 >>> 24));
        int i44 = i43 + 1;
        bArr2[i43] = (byte) (bArr3[(i18 >>> 16) & 255] ^ (i42 >>> 16));
        int i45 = i44 + 1;
        bArr2[i44] = (byte) (bArr3[(i25 >>> 8) & 255] ^ (i42 >>> 8));
        int i46 = i45 + 1;
        bArr2[i45] = (byte) (i42 ^ bArr3[i28 & 255]);
        int i47 = i41 + 1;
        int i48 = iArr7[i41];
        int i49 = i46 + 1;
        bArr2[i46] = (byte) (bArr3[i18 >>> 24] ^ (i48 >>> 24));
        int i50 = i49 + 1;
        bArr2[i49] = (byte) (bArr3[(i25 >>> 16) & 255] ^ (i48 >>> 16));
        int i51 = i50 + 1;
        bArr2[i50] = (byte) (bArr3[(i28 >>> 8) & 255] ^ (i48 >>> 8));
        int i52 = i51 + 1;
        bArr2[i51] = (byte) (i48 ^ bArr3[i11 & 255]);
        int i53 = i47 + 1;
        int i54 = iArr7[i47];
        int i55 = i52 + 1;
        bArr2[i52] = (byte) (bArr3[i25 >>> 24] ^ (i54 >>> 24));
        int i56 = i55 + 1;
        bArr2[i55] = (byte) (bArr3[(i28 >>> 16) & 255] ^ (i54 >>> 16));
        int i57 = i56 + 1;
        bArr2[i56] = (byte) (bArr3[(i11 >>> 8) & 255] ^ (i54 >>> 8));
        int i58 = i57 + 1;
        bArr2[i57] = (byte) (i54 ^ bArr3[i18 & 255]);
        int i59 = iArr7[i53];
        int i60 = i58 + 1;
        bArr2[i58] = (byte) (bArr3[i28 >>> 24] ^ (i59 >>> 24));
        int i61 = i60 + 1;
        bArr2[i60] = (byte) (bArr3[(i11 >>> 16) & 255] ^ (i59 >>> 16));
        bArr2[i61] = (byte) (bArr3[(i18 >>> 8) & 255] ^ (i59 >>> 8));
        bArr2[i61 + 1] = (byte) (bArr3[i25 & 255] ^ i59);
    }

    public void b(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i2 + 1;
        int i10 = i9 + 1;
        int i11 = i10 + 1;
        int i12 = ((bArr[i9] & 255) << 16) | (bArr[i2] << com.google.common.base.a.B) | ((bArr[i10] & 255) << 8);
        int i13 = i11 + 1;
        int i14 = i12 | (bArr[i11] & 255);
        int[] iArr = this.v;
        int i15 = i14 ^ iArr[4];
        int i16 = i13 + 1;
        int i17 = i16 + 1;
        int i18 = (bArr[i13] << com.google.common.base.a.B) | ((bArr[i16] & 255) << 16);
        int i19 = i17 + 1;
        int i20 = i18 | ((bArr[i17] & 255) << 8);
        int i21 = i19 + 1;
        int i22 = (i20 | (bArr[i19] & 255)) ^ iArr[5];
        int i23 = i21 + 1;
        int i24 = i23 + 1;
        int i25 = ((bArr[i23] & 255) << 16) | (bArr[i21] << com.google.common.base.a.B);
        int i26 = i24 + 1;
        int i27 = i25 | ((bArr[i24] & 255) << 8);
        int i28 = i26 + 1;
        int i29 = (i27 | (bArr[i26] & 255)) ^ iArr[6];
        int i30 = i28 + 1;
        int i31 = i30 + 1;
        int i32 = (((((bArr[i30] & 255) << 16) | (bArr[i28] << com.google.common.base.a.B)) | ((bArr[i31] & 255) << 8)) | (bArr[i31 + 1] & 255)) ^ iArr[7];
        if (this.s) {
            int[] iArr2 = j;
            int i33 = iArr2[i15 >>> 24];
            int[] iArr3 = k;
            int i34 = i33 ^ iArr3[(i32 >>> 16) & 255];
            int[] iArr4 = l;
            int i35 = i34 ^ iArr4[(i29 >>> 8) & 255];
            int[] iArr5 = m;
            int i36 = (i35 ^ iArr5[i22 & 255]) ^ iArr[8];
            int i37 = (((iArr2[i22 >>> 24] ^ iArr3[(i15 >>> 16) & 255]) ^ iArr4[(i32 >>> 8) & 255]) ^ iArr5[i29 & 255]) ^ iArr[9];
            int i38 = (((iArr3[(i22 >>> 16) & 255] ^ iArr2[i29 >>> 24]) ^ iArr4[(i15 >>> 8) & 255]) ^ iArr5[i32 & 255]) ^ iArr[10];
            int i39 = (iArr5[i15 & 255] ^ (iArr4[(i22 >>> 8) & 255] ^ (iArr3[(i29 >>> 16) & 255] ^ iArr2[i32 >>> 24]))) ^ iArr[11];
            i7 = (((iArr2[i36 >>> 24] ^ iArr3[(i39 >>> 16) & 255]) ^ iArr4[(i38 >>> 8) & 255]) ^ iArr5[i37 & 255]) ^ iArr[12];
            i6 = (((iArr2[i37 >>> 24] ^ iArr3[(i36 >>> 16) & 255]) ^ iArr4[(i39 >>> 8) & 255]) ^ iArr5[i38 & 255]) ^ iArr[13];
            i5 = (((iArr2[i38 >>> 24] ^ iArr3[(i37 >>> 16) & 255]) ^ iArr4[(i36 >>> 8) & 255]) ^ iArr5[i39 & 255]) ^ iArr[14];
            int i40 = (((iArr2[i39 >>> 24] ^ iArr3[(i38 >>> 16) & 255]) ^ iArr4[(i37 >>> 8) & 255]) ^ iArr5[i36 & 255]) ^ iArr[15];
            if (this.t) {
                int i41 = (((iArr2[i7 >>> 24] ^ iArr3[(i40 >>> 16) & 255]) ^ iArr4[(i5 >>> 8) & 255]) ^ iArr5[i6 & 255]) ^ iArr[16];
                int i42 = (((iArr2[i6 >>> 24] ^ iArr3[(i7 >>> 16) & 255]) ^ iArr4[(i40 >>> 8) & 255]) ^ iArr5[i5 & 255]) ^ iArr[17];
                int i43 = (((iArr2[i5 >>> 24] ^ iArr3[(i6 >>> 16) & 255]) ^ iArr4[(i7 >>> 8) & 255]) ^ iArr5[i40 & 255]) ^ iArr[18];
                int i44 = (((iArr2[i40 >>> 24] ^ iArr3[(i5 >>> 16) & 255]) ^ iArr4[(i6 >>> 8) & 255]) ^ iArr5[i7 & 255]) ^ iArr[19];
                i7 = (((iArr2[i41 >>> 24] ^ iArr3[(i44 >>> 16) & 255]) ^ iArr4[(i43 >>> 8) & 255]) ^ iArr5[i42 & 255]) ^ iArr[20];
                i6 = (((iArr2[i42 >>> 24] ^ iArr3[(i41 >>> 16) & 255]) ^ iArr4[(i44 >>> 8) & 255]) ^ iArr5[i43 & 255]) ^ iArr[21];
                i5 = (((iArr2[i43 >>> 24] ^ iArr3[(i42 >>> 16) & 255]) ^ iArr4[(i41 >>> 8) & 255]) ^ iArr5[i44 & 255]) ^ iArr[22];
                i4 = (((iArr2[i44 >>> 24] ^ iArr3[(i43 >>> 16) & 255]) ^ iArr4[(i42 >>> 8) & 255]) ^ iArr5[i41 & 255]) ^ iArr[23];
                i8 = 24;
            } else {
                i4 = i40;
                i8 = 16;
            }
        } else {
            i4 = i32;
            i5 = i29;
            i6 = i22;
            i7 = i15;
            i8 = 8;
        }
        int[] iArr6 = j;
        int i45 = iArr6[i7 >>> 24];
        int[] iArr7 = k;
        int i46 = i45 ^ iArr7[(i4 >>> 16) & 255];
        int[] iArr8 = l;
        int i47 = i46 ^ iArr8[(i5 >>> 8) & 255];
        int[] iArr9 = m;
        int i48 = i8 + 1;
        int i49 = iArr[i8] ^ (i47 ^ iArr9[i6 & 255]);
        int i50 = i48 + 1;
        int i51 = (((iArr6[i6 >>> 24] ^ iArr7[(i7 >>> 16) & 255]) ^ iArr8[(i4 >>> 8) & 255]) ^ iArr9[i5 & 255]) ^ iArr[i48];
        int i52 = i50 + 1;
        int i53 = (((iArr7[(i6 >>> 16) & 255] ^ iArr6[i5 >>> 24]) ^ iArr8[(i7 >>> 8) & 255]) ^ iArr9[i4 & 255]) ^ iArr[i50];
        int i54 = iArr9[i7 & 255] ^ ((iArr6[i4 >>> 24] ^ iArr7[(i5 >>> 16) & 255]) ^ iArr8[(i6 >>> 8) & 255]);
        int i55 = i52 + 1;
        int i56 = i54 ^ iArr[i52];
        int i57 = i55 + 1;
        int i58 = iArr[i55] ^ (((iArr6[i49 >>> 24] ^ iArr7[(i56 >>> 16) & 255]) ^ iArr8[(i53 >>> 8) & 255]) ^ iArr9[i51 & 255]);
        int i59 = i57 + 1;
        int i60 = (((iArr6[i51 >>> 24] ^ iArr7[(i49 >>> 16) & 255]) ^ iArr8[(i56 >>> 8) & 255]) ^ iArr9[i53 & 255]) ^ iArr[i57];
        int i61 = i59 + 1;
        int i62 = (((iArr6[i53 >>> 24] ^ iArr7[(i51 >>> 16) & 255]) ^ iArr8[(i49 >>> 8) & 255]) ^ iArr9[i56 & 255]) ^ iArr[i59];
        int i63 = iArr9[i49 & 255] ^ ((iArr6[i56 >>> 24] ^ iArr7[(i53 >>> 16) & 255]) ^ iArr8[(i51 >>> 8) & 255]);
        int i64 = i61 + 1;
        int i65 = i63 ^ iArr[i61];
        int i66 = i64 + 1;
        int i67 = iArr[i64] ^ (((iArr6[i58 >>> 24] ^ iArr7[(i65 >>> 16) & 255]) ^ iArr8[(i62 >>> 8) & 255]) ^ iArr9[i60 & 255]);
        int i68 = i66 + 1;
        int i69 = (((iArr6[i60 >>> 24] ^ iArr7[(i58 >>> 16) & 255]) ^ iArr8[(i65 >>> 8) & 255]) ^ iArr9[i62 & 255]) ^ iArr[i66];
        int i70 = i68 + 1;
        int i71 = (((iArr6[i62 >>> 24] ^ iArr7[(i60 >>> 16) & 255]) ^ iArr8[(i58 >>> 8) & 255]) ^ iArr9[i65 & 255]) ^ iArr[i68];
        int i72 = ((iArr6[i65 >>> 24] ^ iArr7[(i62 >>> 16) & 255]) ^ iArr8[(i60 >>> 8) & 255]) ^ iArr9[i58 & 255];
        int i73 = i70 + 1;
        int i74 = i72 ^ iArr[i70];
        int i75 = i73 + 1;
        int i76 = iArr[i73] ^ (((iArr6[i67 >>> 24] ^ iArr7[(i74 >>> 16) & 255]) ^ iArr8[(i71 >>> 8) & 255]) ^ iArr9[i69 & 255]);
        int i77 = i75 + 1;
        int i78 = (((iArr6[i69 >>> 24] ^ iArr7[(i67 >>> 16) & 255]) ^ iArr8[(i74 >>> 8) & 255]) ^ iArr9[i71 & 255]) ^ iArr[i75];
        int i79 = i77 + 1;
        int i80 = (((iArr6[i71 >>> 24] ^ iArr7[(i69 >>> 16) & 255]) ^ iArr8[(i67 >>> 8) & 255]) ^ iArr9[i74 & 255]) ^ iArr[i77];
        int i81 = ((iArr6[i74 >>> 24] ^ iArr7[(i71 >>> 16) & 255]) ^ iArr8[(i69 >>> 8) & 255]) ^ iArr9[i67 & 255];
        int i82 = i79 + 1;
        int i83 = i81 ^ iArr[i79];
        int i84 = i82 + 1;
        int i85 = iArr[i82] ^ (((iArr6[i76 >>> 24] ^ iArr7[(i83 >>> 16) & 255]) ^ iArr8[(i80 >>> 8) & 255]) ^ iArr9[i78 & 255]);
        int i86 = i84 + 1;
        int i87 = (((iArr6[i78 >>> 24] ^ iArr7[(i76 >>> 16) & 255]) ^ iArr8[(i83 >>> 8) & 255]) ^ iArr9[i80 & 255]) ^ iArr[i84];
        int i88 = i86 + 1;
        int i89 = (((iArr6[i80 >>> 24] ^ iArr7[(i78 >>> 16) & 255]) ^ iArr8[(i76 >>> 8) & 255]) ^ iArr9[i83 & 255]) ^ iArr[i86];
        int i90 = ((iArr6[i83 >>> 24] ^ iArr7[(i80 >>> 16) & 255]) ^ iArr8[(i78 >>> 8) & 255]) ^ iArr9[i76 & 255];
        int i91 = i88 + 1;
        int i92 = i90 ^ iArr[i88];
        int i93 = i91 + 1;
        int i94 = iArr[i91] ^ (((iArr6[i85 >>> 24] ^ iArr7[(i92 >>> 16) & 255]) ^ iArr8[(i89 >>> 8) & 255]) ^ iArr9[i87 & 255]);
        int i95 = i93 + 1;
        int i96 = (((iArr6[i87 >>> 24] ^ iArr7[(i85 >>> 16) & 255]) ^ iArr8[(i92 >>> 8) & 255]) ^ iArr9[i89 & 255]) ^ iArr[i93];
        int i97 = i95 + 1;
        int i98 = (((iArr6[i89 >>> 24] ^ iArr7[(i87 >>> 16) & 255]) ^ iArr8[(i85 >>> 8) & 255]) ^ iArr9[i92 & 255]) ^ iArr[i95];
        int i99 = ((iArr6[i92 >>> 24] ^ iArr7[(i89 >>> 16) & 255]) ^ iArr8[(i87 >>> 8) & 255]) ^ iArr9[i85 & 255];
        int i100 = i97 + 1;
        int i101 = i99 ^ iArr[i97];
        int i102 = i100 + 1;
        int i103 = iArr[i100] ^ (((iArr6[i94 >>> 24] ^ iArr7[(i101 >>> 16) & 255]) ^ iArr8[(i98 >>> 8) & 255]) ^ iArr9[i96 & 255]);
        int i104 = i102 + 1;
        int i105 = (((iArr6[i96 >>> 24] ^ iArr7[(i94 >>> 16) & 255]) ^ iArr8[(i101 >>> 8) & 255]) ^ iArr9[i98 & 255]) ^ iArr[i102];
        int i106 = i104 + 1;
        int i107 = (((iArr6[i98 >>> 24] ^ iArr7[(i96 >>> 16) & 255]) ^ iArr8[(i94 >>> 8) & 255]) ^ iArr9[i101 & 255]) ^ iArr[i104];
        int i108 = ((iArr6[i101 >>> 24] ^ iArr7[(i98 >>> 16) & 255]) ^ iArr8[(i96 >>> 8) & 255]) ^ iArr9[i94 & 255];
        int i109 = i106 + 1;
        int i110 = i108 ^ iArr[i106];
        int i111 = i109 + 1;
        int i112 = iArr[i109] ^ (((iArr6[i103 >>> 24] ^ iArr7[(i110 >>> 16) & 255]) ^ iArr8[(i107 >>> 8) & 255]) ^ iArr9[i105 & 255]);
        int i113 = i111 + 1;
        int i114 = (((iArr6[i105 >>> 24] ^ iArr7[(i103 >>> 16) & 255]) ^ iArr8[(i110 >>> 8) & 255]) ^ iArr9[i107 & 255]) ^ iArr[i111];
        int i115 = i113 + 1;
        int i116 = (((iArr6[i107 >>> 24] ^ iArr7[(i105 >>> 16) & 255]) ^ iArr8[(i103 >>> 8) & 255]) ^ iArr9[i110 & 255]) ^ iArr[i113];
        int i117 = ((iArr6[i110 >>> 24] ^ iArr7[(i107 >>> 16) & 255]) ^ iArr8[(i105 >>> 8) & 255]) ^ iArr9[i103 & 255];
        int i118 = i115 + 1;
        int i119 = i117 ^ iArr[i115];
        int i120 = i118 + 1;
        int i121 = iArr[i118] ^ (((iArr6[i112 >>> 24] ^ iArr7[(i119 >>> 16) & 255]) ^ iArr8[(i116 >>> 8) & 255]) ^ iArr9[i114 & 255]);
        int i122 = i120 + 1;
        int i123 = (((iArr6[i114 >>> 24] ^ iArr7[(i112 >>> 16) & 255]) ^ iArr8[(i119 >>> 8) & 255]) ^ iArr9[i116 & 255]) ^ iArr[i120];
        int i124 = (((iArr6[i116 >>> 24] ^ iArr7[(i114 >>> 16) & 255]) ^ iArr8[(i112 >>> 8) & 255]) ^ iArr9[i119 & 255]) ^ iArr[i122];
        int i125 = (((iArr6[i119 >>> 24] ^ iArr7[(i116 >>> 16) & 255]) ^ iArr8[(i114 >>> 8) & 255]) ^ iArr9[i112 & 255]) ^ iArr[i122 + 1];
        int i126 = iArr[0];
        int i127 = i3 + 1;
        byte[] bArr3 = e;
        bArr2[i3] = (byte) (bArr3[i121 >>> 24] ^ (i126 >>> 24));
        int i128 = i127 + 1;
        bArr2[i127] = (byte) (bArr3[(i125 >>> 16) & 255] ^ (i126 >>> 16));
        int i129 = i128 + 1;
        bArr2[i128] = (byte) (bArr3[(i124 >>> 8) & 255] ^ (i126 >>> 8));
        int i130 = i129 + 1;
        bArr2[i129] = (byte) (i126 ^ bArr3[i123 & 255]);
        int i131 = iArr[1];
        int i132 = i130 + 1;
        bArr2[i130] = (byte) (bArr3[i123 >>> 24] ^ (i131 >>> 24));
        int i133 = i132 + 1;
        bArr2[i132] = (byte) (bArr3[(i121 >>> 16) & 255] ^ (i131 >>> 16));
        int i134 = i133 + 1;
        bArr2[i133] = (byte) (bArr3[(i125 >>> 8) & 255] ^ (i131 >>> 8));
        int i135 = i134 + 1;
        bArr2[i134] = (byte) (i131 ^ bArr3[i124 & 255]);
        int i136 = iArr[2];
        int i137 = i135 + 1;
        bArr2[i135] = (byte) (bArr3[i124 >>> 24] ^ (i136 >>> 24));
        int i138 = i137 + 1;
        bArr2[i137] = (byte) (bArr3[(i123 >>> 16) & 255] ^ (i136 >>> 16));
        int i139 = i138 + 1;
        bArr2[i138] = (byte) (bArr3[(i121 >>> 8) & 255] ^ (i136 >>> 8));
        int i140 = i139 + 1;
        bArr2[i139] = (byte) (i136 ^ bArr3[i125 & 255]);
        int i141 = iArr[3];
        int i142 = i140 + 1;
        bArr2[i140] = (byte) (bArr3[i125 >>> 24] ^ (i141 >>> 24));
        int i143 = i142 + 1;
        bArr2[i142] = (byte) (bArr3[(i124 >>> 16) & 255] ^ (i141 >>> 16));
        bArr2[i143] = (byte) (bArr3[(i123 >>> 8) & 255] ^ (i141 >>> 8));
        bArr2[i143 + 1] = (byte) (bArr3[i121 & 255] ^ i141);
    }
}
