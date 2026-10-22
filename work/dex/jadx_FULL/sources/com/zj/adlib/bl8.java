package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bl8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40776a = 1903435808;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f15567a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};
    public static final int b = 1751476579;
    public static final int c = 4096;

    public static boolean a(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : f15567a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(ExtractorInput extractorInput) throws IOException {
        return c(extractorInput, true, false);
    }

    public static boolean c(ExtractorInput extractorInput, boolean z, boolean z2) throws IOException {
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        long length = extractorInput.getLength();
        long j = -1;
        int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j2 = 4096;
        if (i2 != 0 && length <= 4096) {
            j2 = length;
        }
        int i3 = (int) j2;
        om6 om6Var = new om6(64);
        boolean z8 = false;
        int i4 = 0;
        boolean z9 = false;
        while (true) {
            if (i4 < i3) {
                om6Var.O(8);
                if (extractorInput.peekFully(om6Var.d(), z8 ? 1 : 0, 8, true)) {
                    long jI = om6Var.I();
                    int iO = om6Var.o();
                    if (jI == 1) {
                        extractorInput.peekFully(om6Var.d(), 8, 8);
                        om6Var.R(16);
                        i = 16;
                        jI = om6Var.z();
                    } else {
                        if (jI == 0) {
                            long length2 = extractorInput.getLength();
                            if (length2 != j) {
                                jI = (length2 - extractorInput.getPeekPosition()) + ((long) 8);
                            }
                        }
                        i = 8;
                    }
                    long j3 = i;
                    if (jI < j3) {
                        return z8;
                    }
                    i4 += i;
                    if (iO == 1836019574) {
                        i3 += (int) jI;
                        if (i2 != 0 && i3 > length) {
                            i3 = (int) length;
                        }
                    } else if (iO == 1836019558 || iO == 1836475768) {
                        z3 = z8 ? 1 : 0;
                        z4 = true;
                        z5 = true;
                    } else {
                        int i5 = i2;
                        if ((((long) i4) + jI) - j3 >= i3) {
                            z3 = false;
                            z4 = true;
                            z5 = z3 ? 1 : 0;
                        } else {
                            int i6 = (int) (jI - j3);
                            i4 += i6;
                            if (iO != 1718909296) {
                                z6 = false;
                                if (i6 != 0) {
                                    z9 = z9;
                                    extractorInput.advancePeekPosition(i6);
                                    z9 = z9;
                                }
                            } else {
                                if (i6 < 8) {
                                    return false;
                                }
                                om6Var.O(i6);
                                extractorInput.peekFully(om6Var.d(), 0, i6);
                                int i7 = i6 / 4;
                                int i8 = 0;
                                while (true) {
                                    if (i8 >= i7) {
                                        z7 = z9;
                                        break;
                                    }
                                    if (i8 == 1) {
                                        om6Var.T(4);
                                    } else if (a(om6Var.o(), z2)) {
                                        z7 = true;
                                        break;
                                    }
                                    i8++;
                                }
                                if (!z7) {
                                    return false;
                                }
                                z6 = false;
                                z9 = z7;
                            }
                            z9 = z9;
                            z8 = z6;
                            i2 = i5;
                        }
                    }
                    j = -1;
                    z9 = z9;
                }
                return (z9 || z != z5) ? z3 : z4;
            }
            z3 = z8 ? 1 : 0;
            z4 = true;
            z5 = z3 ? 1 : 0;
            if (z9) {
            }
        }
    }

    public static boolean d(ExtractorInput extractorInput) throws IOException {
        return c(extractorInput, false, false);
    }

    public static boolean e(ExtractorInput extractorInput, boolean z) throws IOException {
        return c(extractorInput, false, z);
    }
}
