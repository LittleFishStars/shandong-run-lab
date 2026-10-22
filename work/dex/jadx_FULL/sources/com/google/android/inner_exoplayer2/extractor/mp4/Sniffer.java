package com.google.android.inner_exoplayer2.extractor.mp4;

import com.google.android.inner_exoplayer2.extractor.ExtractorInput;
import com.google.android.inner_exoplayer2.util.ParsableByteArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class Sniffer {
    public static final int BRAND_HEIC = 1751476579;
    public static final int BRAND_QUICKTIME = 1903435808;
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};
    private static final int SEARCH_LENGTH = 4096;

    private Sniffer() {
    }

    private static boolean isCompatibleBrand(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput) {
        return sniffInternal(extractorInput, true, false);
    }

    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z, boolean z2) {
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
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z8 = false;
        int i4 = 0;
        boolean z9 = false;
        while (true) {
            if (i4 < i3) {
                parsableByteArray.reset(8);
                if (extractorInput.peekFully(parsableByteArray.getData(), z8 ? 1 : 0, 8, true)) {
                    long unsignedInt = parsableByteArray.readUnsignedInt();
                    int i5 = parsableByteArray.readInt();
                    if (unsignedInt == 1) {
                        extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                        parsableByteArray.setLimit(16);
                        i = 16;
                        unsignedInt = parsableByteArray.readLong();
                    } else {
                        if (unsignedInt == 0) {
                            long length2 = extractorInput.getLength();
                            if (length2 != j) {
                                unsignedInt = (length2 - extractorInput.getPeekPosition()) + ((long) 8);
                            }
                        }
                        i = 8;
                    }
                    long j3 = i;
                    if (unsignedInt < j3) {
                        return z8;
                    }
                    i4 += i;
                    if (i5 == 1836019574) {
                        i3 += (int) unsignedInt;
                        if (i2 != 0 && i3 > length) {
                            i3 = (int) length;
                        }
                    } else if (i5 == 1836019558 || i5 == 1836475768) {
                        z3 = z8 ? 1 : 0;
                        z4 = true;
                        z5 = true;
                    } else {
                        int i6 = i2;
                        if ((((long) i4) + unsignedInt) - j3 >= i3) {
                            z3 = false;
                            z4 = true;
                            z5 = z3 ? 1 : 0;
                        } else {
                            int i7 = (int) (unsignedInt - j3);
                            i4 += i7;
                            if (i5 != 1718909296) {
                                z6 = false;
                                if (i7 != 0) {
                                    z9 = z9;
                                    extractorInput.advancePeekPosition(i7);
                                    z9 = z9;
                                }
                            } else {
                                if (i7 < 8) {
                                    return false;
                                }
                                parsableByteArray.reset(i7);
                                extractorInput.peekFully(parsableByteArray.getData(), 0, i7);
                                int i8 = i7 / 4;
                                int i9 = 0;
                                while (true) {
                                    if (i9 >= i8) {
                                        z7 = z9;
                                        break;
                                    }
                                    if (i9 == 1) {
                                        parsableByteArray.skipBytes(4);
                                    } else if (isCompatibleBrand(parsableByteArray.readInt(), z2)) {
                                        z7 = true;
                                        break;
                                    }
                                    i9++;
                                }
                                z6 = false;
                                z9 = z7;
                                if (!z7) {
                                    return false;
                                }
                            }
                            z9 = z9;
                            z8 = z6;
                            i2 = i6;
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

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) {
        return sniffInternal(extractorInput, false, false);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput, boolean z) {
        return sniffInternal(extractorInput, false, z);
    }
}
