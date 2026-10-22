package com.alibaba.fastjson.util;

import com.zj.adlib.vj9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class RyuFloat {
    private static final int[][] POW5_SPLIT = {new int[]{536870912, 0}, new int[]{671088640, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{vj9.f20229a, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, 1073741824}, new int[]{762939453, 268435456}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};
    private static final int[][] POW5_INV_SPLIT = {new int[]{268435456, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};

    public static String toString(float f) {
        char[] cArr = new char[15];
        return new String(cArr, 0, toString(f, cArr, 0));
    }

    public static int toString(float f, char[] cArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        if (Float.isNaN(f)) {
            int i17 = i + 1;
            cArr[i] = 'N';
            int i18 = i17 + 1;
            cArr[i17] = 'a';
            i16 = i18 + 1;
            cArr[i18] = 'N';
        } else {
            if (f == Float.POSITIVE_INFINITY) {
                int i19 = i + 1;
                cArr[i] = 'I';
                int i20 = i19 + 1;
                cArr[i19] = 'n';
                int i21 = i20 + 1;
                cArr[i20] = 'f';
                int i22 = i21 + 1;
                cArr[i21] = 'i';
                int i23 = i22 + 1;
                cArr[i22] = 'n';
                int i24 = i23 + 1;
                cArr[i23] = 'i';
                int i25 = i24 + 1;
                cArr[i24] = 't';
                cArr[i25] = 'y';
                return (i25 + 1) - i;
            }
            if (f == Float.NEGATIVE_INFINITY) {
                int i26 = i + 1;
                cArr[i] = '-';
                int i27 = i26 + 1;
                cArr[i26] = 'I';
                int i28 = i27 + 1;
                cArr[i27] = 'n';
                int i29 = i28 + 1;
                cArr[i28] = 'f';
                int i30 = i29 + 1;
                cArr[i29] = 'i';
                int i31 = i30 + 1;
                cArr[i30] = 'n';
                int i32 = i31 + 1;
                cArr[i31] = 'i';
                int i33 = i32 + 1;
                cArr[i32] = 't';
                i16 = i33 + 1;
                cArr[i33] = 'y';
            } else {
                int iFloatToIntBits = Float.floatToIntBits(f);
                if (iFloatToIntBits != 0) {
                    if (iFloatToIntBits == Integer.MIN_VALUE) {
                        int i34 = i + 1;
                        cArr[i] = '-';
                        int i35 = i34 + 1;
                        cArr[i34] = '0';
                        int i36 = i35 + 1;
                        cArr[i35] = '.';
                        cArr[i36] = '0';
                        return (i36 + 1) - i;
                    }
                    int i37 = (iFloatToIntBits >> 23) & 255;
                    int i38 = 8388607 & iFloatToIntBits;
                    if (i37 == 0) {
                        i2 = -149;
                    } else {
                        i2 = (i37 - 127) - 23;
                        i38 |= 8388608;
                    }
                    boolean z = iFloatToIntBits < 0;
                    boolean z2 = (i38 & 1) == 0;
                    int i39 = i38 * 4;
                    int i40 = i39 + 2;
                    int i41 = i39 - ((((long) i38) != 8388608 || i37 <= 1) ? 2 : 1);
                    int i42 = i2 - 2;
                    if (i42 >= 0) {
                        i6 = (int) ((((long) i42) * 3010299) / 10000000);
                        int i43 = i6 == 0 ? 1 : (int) ((((((long) i6) * 23219280) + 10000000) - 1) / 10000000);
                        int i44 = (-i42) + i6;
                        int[][] iArr = POW5_INV_SPLIT;
                        int[] iArr2 = iArr[i6];
                        long j = iArr2[0];
                        long j2 = iArr2[1];
                        long j3 = i39;
                        int i45 = (((i43 + 59) - 1) + i44) - 31;
                        int i46 = (int) (((j3 * j) + ((j3 * j2) >> 31)) >> i45);
                        long j4 = i40;
                        i8 = (int) (((j4 * j) + ((j4 * j2) >> 31)) >> i45);
                        int i47 = i41;
                        long j5 = i47;
                        int i48 = (int) (((j * j5) + ((j5 * j2) >> 31)) >> i45);
                        if (i6 == 0 || (i8 - 1) / 10 > i48 / 10) {
                            i12 = 0;
                        } else {
                            int i49 = i6 - 1;
                            int i50 = (i44 - 1) + (((i49 == 0 ? 1 : (int) ((((((long) i49) * 23219280) + 10000000) - 1) / 10000000)) + 59) - 1);
                            int[] iArr3 = iArr[i49];
                            i12 = (int) ((((((long) iArr3[0]) * j3) + ((((long) iArr3[1]) * j3) >> 31)) >> (i50 - 31)) % 10);
                        }
                        int i51 = 0;
                        while (i40 > 0 && i40 % 5 == 0) {
                            i40 /= 5;
                            i51++;
                        }
                        int i52 = 0;
                        while (i39 > 0 && i39 % 5 == 0) {
                            i39 /= 5;
                            i52++;
                        }
                        int i53 = 0;
                        while (i47 > 0 && i47 % 5 == 0) {
                            i47 /= 5;
                            i53++;
                        }
                        int i54 = i51 >= i6 ? 1 : 0;
                        i9 = i52 >= i6 ? 1 : 0;
                        i11 = i53 >= i6 ? 1 : 0;
                        i7 = i54;
                        i4 = 0;
                        i3 = i48;
                        i10 = i46;
                    } else {
                        int i55 = -i42;
                        int i56 = (int) ((((long) i55) * 6989700) / 10000000);
                        int i57 = i55 - i56;
                        int i58 = i57 == 0 ? 1 : (int) ((((((long) i57) * 23219280) + 10000000) - 1) / 10000000);
                        int[][] iArr4 = POW5_SPLIT;
                        int[] iArr5 = iArr4[i57];
                        long j6 = iArr5[0];
                        long j7 = iArr5[1];
                        int i59 = (i56 - (i58 - 61)) - 31;
                        long j8 = i39;
                        int i60 = (int) (((j8 * j6) + ((j8 * j7) >> 31)) >> i59);
                        long j9 = i40;
                        int i61 = (int) (((j9 * j6) + ((j9 * j7) >> 31)) >> i59);
                        long j10 = i41;
                        i3 = (int) (((j6 * j10) + ((j10 * j7) >> 31)) >> i59);
                        if (i56 == 0 || (i61 - 1) / 10 > i3 / 10) {
                            i4 = 0;
                            i5 = 0;
                        } else {
                            int i62 = i57 + 1;
                            int i63 = (i56 - 1) - ((i62 == 0 ? 1 : (int) ((((((long) i62) * 23219280) + 10000000) - 1) / 10000000)) - 61);
                            int[] iArr6 = iArr4[i62];
                            i4 = 0;
                            i5 = (int) ((((j8 * ((long) iArr6[0])) + ((((long) iArr6[1]) * j8) >> 31)) >> (i63 - 31)) % 10);
                        }
                        i6 = i56 + i42;
                        i7 = 1 >= i56 ? 1 : i4;
                        int i64 = (i56 >= 23 || (i39 & ((1 << (i56 + (-1))) - 1)) != 0) ? i4 : 1;
                        int i65 = (i41 % 2 == 1 ? i4 : 1) >= i56 ? 1 : i4;
                        i8 = i61;
                        i9 = i64;
                        i10 = i60;
                        int i66 = i5;
                        i11 = i65;
                        i12 = i66;
                    }
                    int i67 = vj9.f20229a;
                    int i68 = 10;
                    while (i68 > 0 && i8 < i67) {
                        i67 /= 10;
                        i68--;
                    }
                    int i69 = (i6 + i68) - 1;
                    int i70 = (i69 < -3 || i69 >= 7) ? 1 : i4;
                    if (i7 != 0 && !z2) {
                        i8--;
                    }
                    int i71 = i4;
                    while (true) {
                        int i72 = i8 / 10;
                        int i73 = i3 / 10;
                        if (i72 <= i73 || (i8 < 100 && i70 != 0)) {
                            break;
                        }
                        i11 &= i3 % 10 == 0 ? 1 : i4;
                        i12 = i10 % 10;
                        i10 /= 10;
                        i71++;
                        i8 = i72;
                        i3 = i73;
                    }
                    if (i11 != 0 && z2 != 0) {
                        while (i3 % 10 == 0 && (i8 >= 100 || i70 == 0)) {
                            i8 /= 10;
                            i12 = i10 % 10;
                            i10 /= 10;
                            i3 /= 10;
                            i71++;
                        }
                    }
                    if (i9 != 0 && i12 == 5 && i10 % 2 == 0) {
                        i12 = 4;
                    }
                    int i74 = i10 + ((!(i10 == i3 && (i11 == 0 || z2 == 0)) && i12 < 5) ? i4 : 1);
                    int i75 = i68 - i71;
                    if (z) {
                        i13 = i + 1;
                        cArr[i] = '-';
                    } else {
                        i13 = i;
                    }
                    if (i70 != 0) {
                        for (int i76 = i4; i76 < i75 - 1; i76++) {
                            int i77 = i74 % 10;
                            i74 /= 10;
                            cArr[(i13 + i75) - i76] = (char) (i77 + 48);
                        }
                        cArr[i13] = (char) ((i74 % 10) + 48);
                        cArr[i13 + 1] = '.';
                        int i78 = i13 + i75 + 1;
                        if (i75 == 1) {
                            cArr[i78] = '0';
                            i78++;
                        }
                        int i79 = i78 + 1;
                        cArr[i78] = 'E';
                        if (i69 < 0) {
                            cArr[i79] = '-';
                            i69 = -i69;
                            i79++;
                        }
                        if (i69 >= 10) {
                            i15 = 48;
                            cArr[i79] = (char) ((i69 / 10) + 48);
                            i79++;
                        } else {
                            i15 = 48;
                        }
                        i14 = i79 + 1;
                        cArr[i79] = (char) ((i69 % 10) + i15);
                    } else {
                        int i80 = 48;
                        if (i69 < 0) {
                            int i81 = i13 + 1;
                            cArr[i13] = '0';
                            int i82 = i81 + 1;
                            cArr[i81] = '.';
                            int i83 = -1;
                            while (i83 > i69) {
                                cArr[i82] = '0';
                                i83--;
                                i82++;
                            }
                            int i84 = i82;
                            int i85 = i4;
                            while (i85 < i75) {
                                cArr[((i82 + i75) - i85) - 1] = (char) ((i74 % 10) + i80);
                                i74 /= 10;
                                i84++;
                                i85++;
                                i80 = 48;
                            }
                            i14 = i84;
                        } else {
                            int i86 = i69 + 1;
                            if (i86 >= i75) {
                                for (int i87 = i4; i87 < i75; i87++) {
                                    cArr[((i13 + i75) - i87) - 1] = (char) ((i74 % 10) + 48);
                                    i74 /= 10;
                                }
                                int i88 = i13 + i75;
                                while (i75 < i86) {
                                    cArr[i88] = '0';
                                    i75++;
                                    i88++;
                                }
                                int i89 = i88 + 1;
                                cArr[i88] = '.';
                                i14 = i89 + 1;
                                cArr[i89] = '0';
                            } else {
                                int i90 = i13 + 1;
                                for (int i91 = i4; i91 < i75; i91++) {
                                    if ((i75 - i91) - 1 == i69) {
                                        cArr[((i90 + i75) - i91) - 1] = '.';
                                        i90--;
                                    }
                                    cArr[((i90 + i75) - i91) - 1] = (char) ((i74 % 10) + 48);
                                    i74 /= 10;
                                }
                                i14 = i13 + i75 + 1;
                            }
                        }
                    }
                    return i14 - i;
                }
                int i92 = i + 1;
                cArr[i] = '0';
                int i93 = i92 + 1;
                cArr[i92] = '.';
                i16 = i93 + 1;
                cArr[i93] = '0';
            }
        }
        return i16 - i;
    }
}
