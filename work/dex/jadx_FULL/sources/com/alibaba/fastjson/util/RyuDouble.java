package com.alibaba.fastjson.util;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.math.d;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class RyuDouble {
    private static final int[][] POW5_INV_SPLIT;
    private static final int[][] POW5_SPLIT;

    static {
        int[] iArr = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE, 4};
        Class cls = Integer.TYPE;
        POW5_SPLIT = (int[][]) Array.newInstance((Class<?>) cls, iArr);
        POW5_INV_SPLIT = (int[][]) Array.newInstance((Class<?>) cls, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT, 4);
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigInteger.shiftLeft(31).subtract(bigInteger);
        BigInteger bigIntegerSubtract2 = bigInteger.shiftLeft(31).subtract(bigInteger);
        int i = 0;
        while (i < 326) {
            BigInteger bigIntegerPow = BigInteger.valueOf(5L).pow(i);
            int iBitLength = bigIntegerPow.bitLength();
            int i2 = i == 0 ? 1 : (int) ((((((long) i) * 23219280) + 10000000) - 1) / 10000000);
            if (i2 != iBitLength) {
                throw new IllegalStateException(iBitLength + " != " + i2);
            }
            if (i < POW5_SPLIT.length) {
                for (int i3 = 0; i3 < 4; i3++) {
                    POW5_SPLIT[i][i3] = bigIntegerPow.shiftRight((iBitLength - 121) + ((3 - i3) * 31)).and(bigIntegerSubtract).intValue();
                }
            }
            if (i < POW5_INV_SPLIT.length) {
                BigInteger bigInteger2 = BigInteger.ONE;
                BigInteger bigIntegerAdd = bigInteger2.shiftLeft(iBitLength + 121).divide(bigIntegerPow).add(bigInteger2);
                for (int i4 = 0; i4 < 4; i4++) {
                    if (i4 == 0) {
                        POW5_INV_SPLIT[i][i4] = bigIntegerAdd.shiftRight((3 - i4) * 31).intValue();
                    } else {
                        POW5_INV_SPLIT[i][i4] = bigIntegerAdd.shiftRight((3 - i4) * 31).and(bigIntegerSubtract2).intValue();
                    }
                }
            }
            i++;
        }
    }

    public static String toString(double d) {
        char[] cArr = new char[24];
        return new String(cArr, 0, toString(d, cArr, 0));
    }

    public static int toString(double d, char[] cArr, int i) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        long j;
        long j2;
        long j3;
        int i4;
        boolean z3;
        boolean z4;
        int i5;
        long j4;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z5;
        int i11;
        int i12;
        int i13;
        int i14;
        if (!Double.isNaN(d)) {
            if (d == Double.POSITIVE_INFINITY) {
                int i15 = i + 1;
                cArr[i] = 'I';
                int i16 = i15 + 1;
                cArr[i15] = 'n';
                int i17 = i16 + 1;
                cArr[i16] = 'f';
                int i18 = i17 + 1;
                cArr[i17] = 'i';
                int i19 = i18 + 1;
                cArr[i18] = 'n';
                int i20 = i19 + 1;
                cArr[i19] = 'i';
                int i21 = i20 + 1;
                cArr[i20] = 't';
                i10 = i21 + 1;
                cArr[i21] = 'y';
            } else if (d == Double.NEGATIVE_INFINITY) {
                int i22 = i + 1;
                cArr[i] = '-';
                int i23 = i22 + 1;
                cArr[i22] = 'I';
                int i24 = i23 + 1;
                cArr[i23] = 'n';
                int i25 = i24 + 1;
                cArr[i24] = 'f';
                int i26 = i25 + 1;
                cArr[i25] = 'i';
                int i27 = i26 + 1;
                cArr[i26] = 'n';
                int i28 = i27 + 1;
                cArr[i27] = 'i';
                int i29 = i28 + 1;
                cArr[i28] = 't';
                i14 = i29 + 1;
                cArr[i29] = 'y';
            } else {
                long jDoubleToLongBits = Double.doubleToLongBits(d);
                if (jDoubleToLongBits == 0) {
                    int i30 = i + 1;
                    cArr[i] = '0';
                    int i31 = i30 + 1;
                    cArr[i30] = '.';
                    i14 = i31 + 1;
                    cArr[i31] = '0';
                } else if (jDoubleToLongBits == Long.MIN_VALUE) {
                    int i32 = i + 1;
                    cArr[i] = '-';
                    int i33 = i32 + 1;
                    cArr[i32] = '0';
                    int i34 = i33 + 1;
                    cArr[i33] = '.';
                    i10 = i34 + 1;
                    cArr[i34] = '0';
                } else {
                    int i35 = (int) ((jDoubleToLongBits >>> 52) & 2047);
                    long j5 = jDoubleToLongBits & d.f6378a;
                    if (i35 == 0) {
                        i2 = -1074;
                    } else {
                        i2 = (i35 - 1023) - 52;
                        j5 |= d.d;
                    }
                    boolean z6 = jDoubleToLongBits < 0;
                    boolean z7 = (j5 & 1) == 0;
                    long j6 = 4 * j5;
                    long j7 = j6 + 2;
                    int i36 = (j5 != d.d || i35 <= 1) ? 1 : 0;
                    long j8 = (j6 - 1) - ((long) i36);
                    int i37 = i2 - 2;
                    if (i37 >= 0) {
                        int iMax = Math.max(0, ((int) ((((long) i37) * 3010299) / 10000000)) - 1);
                        int i38 = ((((-i37) + iMax) + (((iMax == 0 ? 1 : (int) ((((((long) iMax) * 23219280) + 10000000) - 1) / 10000000)) + 122) - 1)) - 93) - 21;
                        if (i38 >= 0) {
                            int[] iArr = POW5_INV_SPLIT[iMax];
                            long j9 = j6 >>> 31;
                            long j10 = j6 & 2147483647L;
                            int i39 = iArr[0];
                            z = z6;
                            int i40 = iArr[1];
                            int i41 = iArr[2];
                            z2 = z7;
                            int i42 = iArr[3];
                            long j11 = ((((((((((((j10 * ((long) i42)) >>> 31) + (((long) i41) * j10)) + (j9 * ((long) i42))) >>> 31) + (((long) i40) * j10)) + (((long) i41) * j9)) >>> 31) + (((long) i39) * j10)) + (((long) i40) * j9)) >>> 21) + ((((long) i39) * j9) << 10)) >>> i38;
                            long j12 = j7 >>> 31;
                            long j13 = j7 & 2147483647L;
                            long j14 = ((((((((((((j13 * ((long) i42)) >>> 31) + (((long) i41) * j13)) + (j12 * ((long) i42))) >>> 31) + (((long) i40) * j13)) + (((long) i41) * j12)) >>> 31) + (((long) i39) * j13)) + (((long) i40) * j12)) >>> 21) + ((((long) i39) * j12) << 10)) >>> i38;
                            long j15 = j8 >>> 31;
                            long j16 = j8 & 2147483647L;
                            long j17 = j14;
                            j3 = ((((((((((((j16 * ((long) i42)) >>> 31) + (((long) i41) * j16)) + (j15 * ((long) i42))) >>> 31) + (((long) i40) * j16)) + (((long) i41) * j15)) >>> 31) + (((long) i39) * j16)) + (((long) i40) * j15)) >>> 21) + ((((long) i39) * j15) << 10)) >>> i38;
                            if (iMax <= 21) {
                                long j18 = j6 % 5;
                                if (j18 == 0) {
                                    if (j18 != 0) {
                                        i13 = 0;
                                    } else if (j6 % 25 != 0) {
                                        i13 = 1;
                                    } else if (j6 % 125 != 0) {
                                        i13 = 2;
                                    } else if (j6 % 625 != 0) {
                                        i13 = 3;
                                    } else {
                                        long j19 = j6 / 625;
                                        i13 = 4;
                                        for (long j20 = 0; j19 > j20 && j19 % 5 == j20; j20 = 0) {
                                            j19 /= 5;
                                            i13++;
                                        }
                                    }
                                    z4 = i13 >= iMax;
                                    z5 = false;
                                } else {
                                    if (z2) {
                                        if (j8 % 5 != 0) {
                                            i12 = 0;
                                        } else if (j8 % 25 != 0) {
                                            i12 = 1;
                                        } else if (j8 % 125 != 0) {
                                            i12 = 2;
                                        } else if (j8 % 625 != 0) {
                                            i12 = 3;
                                        } else {
                                            long j21 = j8 / 625;
                                            i12 = 4;
                                            for (long j22 = 0; j21 > j22 && j21 % 5 == j22; j22 = 0) {
                                                j21 /= 5;
                                                i12++;
                                            }
                                        }
                                        z5 = i12 >= iMax;
                                        z4 = false;
                                    } else {
                                        if (j7 % 5 != 0) {
                                            i11 = 0;
                                        } else if (j7 % 25 != 0) {
                                            i11 = 1;
                                        } else if (j7 % 125 != 0) {
                                            i11 = 2;
                                        } else if (j7 % 625 != 0) {
                                            i11 = 3;
                                        } else {
                                            long j23 = j7 / 625;
                                            i11 = 4;
                                            for (long j24 = 0; j23 > j24 && j23 % 5 == j24; j24 = 0) {
                                                j23 /= 5;
                                                i11++;
                                            }
                                        }
                                        if (i11 >= iMax) {
                                            j17--;
                                        }
                                    }
                                    z4 = false;
                                }
                            } else {
                                z4 = false;
                            }
                            j = j11;
                            j2 = j17;
                            i3 = 2;
                            z3 = z5;
                            i4 = iMax;
                        } else {
                            throw new IllegalArgumentException("" + i38);
                        }
                    } else {
                        z = z6;
                        z2 = z7;
                        int i43 = -i37;
                        int iMax2 = Math.max(0, ((int) ((((long) i43) * 6989700) / 10000000)) - 1);
                        int i44 = i43 - iMax2;
                        int i45 = ((iMax2 - ((i44 == 0 ? 1 : (int) ((((((long) i44) * 23219280) + 10000000) - 1) / 10000000)) - 121)) - 93) - 21;
                        if (i45 >= 0) {
                            int[] iArr2 = POW5_SPLIT[i44];
                            long j25 = j6 >>> 31;
                            long j26 = j6 & 2147483647L;
                            int i46 = iArr2[0];
                            int i47 = iArr2[1];
                            int i48 = i36;
                            i3 = 2;
                            int i49 = iArr2[2];
                            int i50 = iArr2[3];
                            long j27 = ((((((((((((j26 * ((long) i50)) >>> 31) + (((long) i49) * j26)) + (j25 * ((long) i50))) >>> 31) + (((long) i47) * j26)) + (((long) i49) * j25)) >>> 31) + (((long) i46) * j26)) + (((long) i47) * j25)) >>> 21) + ((((long) i46) * j25) << 10)) >>> i45;
                            long j28 = j7 >>> 31;
                            long j29 = j7 & 2147483647L;
                            j = j27;
                            long j30 = ((((((((((((j29 * ((long) i50)) >>> 31) + (((long) i49) * j29)) + (j28 * ((long) i50))) >>> 31) + (((long) i47) * j29)) + (((long) i49) * j28)) >>> 31) + (((long) i46) * j29)) + (((long) i47) * j28)) >>> 21) + ((((long) i46) * j28) << 10)) >>> i45;
                            long j31 = j8 >>> 31;
                            long j32 = j8 & 2147483647L;
                            j2 = j30;
                            j3 = ((((((((((((j32 * ((long) i50)) >>> 31) + (((long) i49) * j32)) + (j31 * ((long) i50))) >>> 31) + (((long) i47) * j32)) + (((long) i49) * j31)) >>> 31) + (((long) i46) * j32)) + (((long) i47) * j31)) >>> 21) + ((((long) i46) * j31) << 10)) >>> i45;
                            i4 = iMax2 + i37;
                            boolean z8 = true;
                            if (iMax2 <= 1) {
                                if (z2) {
                                    z4 = true;
                                    z3 = i48 == 1;
                                } else {
                                    j2--;
                                    z4 = z8;
                                    z3 = false;
                                }
                            } else if (iMax2 < 63) {
                                z8 = (j6 & ((1 << (iMax2 - 1)) - 1)) == 0;
                                z4 = z8;
                                z3 = false;
                            } else {
                                z3 = false;
                                z4 = false;
                            }
                        } else {
                            throw new IllegalArgumentException("" + i45);
                        }
                    }
                    if (j2 >= 1000000000000000000L) {
                        i5 = 19;
                    } else if (j2 >= 100000000000000000L) {
                        i5 = 18;
                    } else if (j2 >= 10000000000000000L) {
                        i5 = 17;
                    } else if (j2 >= 1000000000000000L) {
                        i5 = 16;
                    } else if (j2 >= 100000000000000L) {
                        i5 = 15;
                    } else if (j2 >= 10000000000000L) {
                        i5 = 14;
                    } else if (j2 >= 1000000000000L) {
                        i5 = 13;
                    } else if (j2 >= 100000000000L) {
                        i5 = 12;
                    } else if (j2 >= 10000000000L) {
                        i5 = 11;
                    } else if (j2 >= 1000000000) {
                        i5 = 10;
                    } else if (j2 >= 100000000) {
                        i5 = 9;
                    } else if (j2 >= 10000000) {
                        i5 = 8;
                    } else if (j2 >= 1000000) {
                        i5 = 7;
                    } else if (j2 >= 100000) {
                        i5 = 6;
                    } else if (j2 >= 10000) {
                        i5 = 5;
                    } else if (j2 >= 1000) {
                        i5 = 4;
                    } else if (j2 >= 100) {
                        i5 = 3;
                    } else {
                        i5 = j2 >= 10 ? i3 : 1;
                    }
                    int i51 = (i4 + i5) - 1;
                    boolean z9 = i51 < -3 || i51 >= 7;
                    if (z3 || z4) {
                        boolean z10 = z4;
                        int i52 = 0;
                        int i53 = 0;
                        while (true) {
                            long j33 = j2 / 10;
                            long j34 = j3 / 10;
                            if (j33 <= j34 || (j2 < 100 && z9)) {
                                break;
                            }
                            z3 &= j3 % 10 == 0;
                            z10 &= i52 == 0;
                            i52 = (int) (j % 10);
                            j /= 10;
                            i53++;
                            j2 = j33;
                            j3 = j34;
                        }
                        if (z3 && z2) {
                            while (j3 % 10 == 0 && (j2 >= 100 || !z9)) {
                                z10 &= i52 == 0;
                                i52 = (int) (j % 10);
                                j2 /= 10;
                                j /= 10;
                                j3 /= 10;
                                i53++;
                            }
                        }
                        if (z10 && i52 == 5 && j % 2 == 0) {
                            i52 = 4;
                        }
                        j4 = j + ((long) (((j != j3 || (z3 && z2)) && i52 < 5) ? 0 : 1));
                        i6 = i53;
                    } else {
                        i6 = 0;
                        int i54 = 0;
                        while (true) {
                            long j35 = j2 / 10;
                            long j36 = j3 / 10;
                            if (j35 <= j36 || (j2 < 100 && z9)) {
                                break;
                            }
                            i54 = (int) (j % 10);
                            j /= 10;
                            i6++;
                            j2 = j35;
                            j3 = j36;
                        }
                        j4 = j + ((long) ((j == j3 || i54 >= 5) ? 1 : 0));
                    }
                    int i55 = i5 - i6;
                    if (z) {
                        i7 = i + 1;
                        cArr[i] = '-';
                    } else {
                        i7 = i;
                    }
                    if (!z9) {
                        char c = '0';
                        if (i51 < 0) {
                            int i56 = i7 + 1;
                            cArr[i7] = '0';
                            int i57 = i56 + 1;
                            cArr[i56] = '.';
                            int i58 = -1;
                            while (i58 > i51) {
                                cArr[i57] = c;
                                i58--;
                                i57++;
                                c = '0';
                            }
                            i8 = i57;
                            for (int i59 = 0; i59 < i55; i59++) {
                                cArr[((i57 + i55) - i59) - 1] = (char) ((j4 % 10) + 48);
                                j4 /= 10;
                                i8++;
                            }
                        } else {
                            int i60 = i51 + 1;
                            if (i60 >= i55) {
                                for (int i61 = 0; i61 < i55; i61++) {
                                    cArr[((i7 + i55) - i61) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                }
                                int i62 = i7 + i55;
                                while (i55 < i60) {
                                    cArr[i62] = '0';
                                    i55++;
                                    i62++;
                                }
                                int i63 = i62 + 1;
                                cArr[i62] = '.';
                                i8 = i63 + 1;
                                cArr[i63] = '0';
                            } else {
                                int i64 = i7 + 1;
                                for (int i65 = 0; i65 < i55; i65++) {
                                    if ((i55 - i65) - 1 == i51) {
                                        cArr[((i64 + i55) - i65) - 1] = '.';
                                        i64--;
                                    }
                                    cArr[((i64 + i55) - i65) - 1] = (char) ((j4 % 10) + 48);
                                    j4 /= 10;
                                }
                                i8 = i7 + i55 + 1;
                            }
                        }
                        return i8 - i;
                    }
                    for (int i66 = 0; i66 < i55 - 1; i66++) {
                        int i67 = (int) (j4 % 10);
                        j4 /= 10;
                        cArr[(i7 + i55) - i66] = (char) (i67 + 48);
                    }
                    cArr[i7] = (char) ((j4 % 10) + 48);
                    cArr[i7 + 1] = '.';
                    int i68 = i7 + i55 + 1;
                    if (i55 == 1) {
                        cArr[i68] = '0';
                        i68++;
                    }
                    int i69 = i68 + 1;
                    cArr[i68] = 'E';
                    if (i51 < 0) {
                        cArr[i69] = '-';
                        i51 = -i51;
                        i69++;
                    }
                    if (i51 >= 100) {
                        int i70 = i69 + 1;
                        i9 = 48;
                        cArr[i69] = (char) ((i51 / 100) + 48);
                        i51 %= 100;
                        i69 = i70 + 1;
                        cArr[i70] = (char) ((i51 / 10) + 48);
                    } else {
                        i9 = 48;
                        if (i51 >= 10) {
                            cArr[i69] = (char) ((i51 / 10) + 48);
                            i69++;
                        }
                    }
                    i10 = i69 + 1;
                    cArr[i69] = (char) ((i51 % 10) + i9);
                }
            }
            return i10 - i;
        }
        int i71 = i + 1;
        cArr[i] = 'N';
        int i72 = i71 + 1;
        cArr[i71] = 'a';
        i14 = i72 + 1;
        cArr[i72] = 'N';
        return i14 - i;
    }
}
