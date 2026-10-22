package com.zj.adlib;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.oned.rss.AbstractRSSReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class d97 extends AbstractRSSReader {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<sl6> f15947a = new ArrayList();
    public final List<sl6> b = new ArrayList();
    public static final int[] e = {1, 10, 34, 70, 126};
    public static final int[] f = {4, 20, 48, 81};
    public static final int[] g = {0, 161, 961, 2015, 2715};
    public static final int[] h = {0, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 1036, 1516};
    public static final int[] i = {8, 6, 4, 3, 1};
    public static final int[] j = {2, 4, 6, 8};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[][] f41131a = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    public static void e(Collection<sl6> collection, sl6 sl6Var) {
        boolean z;
        if (sl6Var == null) {
            return;
        }
        Iterator<sl6> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            sl6 next = it.next();
            if (next.b() == sl6Var.b()) {
                next.e();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(sl6Var);
    }

    public static boolean g(sl6 sl6Var, sl6 sl6Var2) {
        int iA = (sl6Var.a() + (sl6Var2.a() * 16)) % 79;
        int iC = (sl6Var.d().c() * 9) + sl6Var2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    public static ug7 h(sl6 sl6Var, sl6 sl6Var2) {
        String strValueOf = String.valueOf((((long) sl6Var.b()) * 4537077) + ((long) sl6Var2.b()));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        xg7[] xg7VarArrA = sl6Var.d().a();
        xg7[] xg7VarArrA2 = sl6Var2.d().a();
        ug7 ug7Var = new ug7(sb.toString(), null, new xg7[]{xg7VarArrA[0], xg7VarArrA[1], xg7VarArrA2[0], xg7VarArrA2[1]}, BarcodeFormat.RSS_14);
        ug7Var.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]e0");
        return ug7Var;
    }

    @Override // com.google.zxing.oned.OneDReader
    public ug7 b(int i2, qv0 qv0Var, Map<DecodeHintType, ?> map) throws NotFoundException {
        e(this.f15947a, j(qv0Var, false, i2, map));
        qv0Var.x();
        e(this.b, j(qv0Var, true, i2, map));
        qv0Var.x();
        for (sl6 sl6Var : this.f15947a) {
            if (sl6Var.c() > 1) {
                for (sl6 sl6Var2 : this.b) {
                    if (sl6Var2.c() > 1 && g(sl6Var, sl6Var2)) {
                        return h(sl6Var, sl6Var2);
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003c A[PHI: r6 r7
      0x003c: PHI (r6v4 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:22:0x003a, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]
      0x003c: PHI (r7v4 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:22:0x003a, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0041 A[PHI: r6 r7
      0x0041: PHI (r6v5 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:24:0x003f, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x0041: PHI (r7v5 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:24:0x003f, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0044 A[PHI: r6 r7
      0x0044: PHI (r6v7 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:24:0x003f, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x0044: PHI (r7v11 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:24:0x003f, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    public final void f(boolean z, int i2) throws NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int iD = se5.d(getOddCounts());
        int iD2 = se5.d(getEvenCounts());
        boolean z6 = true;
        if (z) {
            if (iD > 12) {
                z3 = true;
                z2 = false;
            } else if (iD < 4) {
                z2 = true;
                z3 = false;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iD2 > 12) {
                z4 = true;
                z5 = false;
            } else if (iD2 < 4) {
                z5 = true;
                z4 = false;
            } else {
                z5 = false;
                z4 = false;
            }
        } else {
            if (iD > 11) {
                z3 = true;
                z2 = false;
            } else if (iD < 5) {
                z2 = true;
                z3 = false;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iD2 > 10) {
                z4 = true;
                z5 = false;
            } else if (iD2 < 4) {
                z5 = true;
                z4 = false;
            } else {
                z5 = false;
                z4 = false;
            }
        }
        int i3 = (iD + iD2) - i2;
        boolean z7 = (iD & 1) == z;
        boolean z8 = (iD2 & 1) == 1;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 1) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z7) {
                    if (z8) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z3 = true;
                } else {
                    if (!z8) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z4 = true;
                }
            } else if (z7) {
                if (!z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (iD < iD2) {
                    z4 = true;
                } else {
                    z5 = true;
                    z3 = true;
                }
            } else if (z8) {
                throw NotFoundException.getNotFoundInstance();
            }
            z6 = z2;
        } else if (z7) {
            if (z8) {
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            if (!z8) {
                throw NotFoundException.getNotFoundInstance();
            }
            z5 = true;
            z6 = z2;
        }
        if (z6) {
            if (z3) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z3) {
            AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z5) {
            if (z4) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z4) {
            AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    public final p62 i(qv0 qv0Var, bh3 bh3Var, boolean z) throws NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        Arrays.fill(dataCharacterCounters, 0);
        if (z) {
            OneDReader.recordPatternInReverse(qv0Var, bh3Var.b()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(qv0Var, bh3Var.b()[1], dataCharacterCounters);
            int i2 = 0;
            for (int length = dataCharacterCounters.length - 1; i2 < length; length--) {
                int i3 = dataCharacterCounters[i2];
                dataCharacterCounters[i2] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i3;
                i2++;
            }
        }
        int i4 = z ? 16 : 15;
        float fD = se5.d(dataCharacterCounters) / i4;
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i5 = 0; i5 < dataCharacterCounters.length; i5++) {
            float f2 = dataCharacterCounters[i5] / fD;
            int i6 = (int) (0.5f + f2);
            if (i6 < 1) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                oddCounts[i7] = i6;
                oddRoundingErrors[i7] = f2 - i6;
            } else {
                evenCounts[i7] = i6;
                evenRoundingErrors[i7] = f2 - i6;
            }
        }
        f(z, i4);
        int i8 = 0;
        int i9 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            int i10 = oddCounts[length2];
            i8 = (i8 * 9) + i10;
            i9 += i10;
        }
        int i11 = 0;
        int i12 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            int i13 = evenCounts[length3];
            i11 = (i11 * 9) + i13;
            i12 += i13;
        }
        int i14 = i8 + (i11 * 3);
        if (!z) {
            if ((i12 & 1) != 0 || i12 > 10 || i12 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i15 = (10 - i12) / 2;
            int i16 = j[i15];
            return new p62((f97.b(evenCounts, 9 - i16, false) * f[i15]) + f97.b(oddCounts, i16, true) + h[i15], i14);
        }
        if ((i9 & 1) != 0 || i9 > 12 || i9 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i17 = (12 - i9) / 2;
        int i18 = i[i17];
        return new p62((f97.b(oddCounts, i18, false) * e[i17]) + f97.b(evenCounts, 9 - i18, true) + g[i17], i14);
    }

    public final sl6 j(qv0 qv0Var, boolean z, int i2, Map<DecodeHintType, ?> map) {
        try {
            bh3 bh3VarL = l(qv0Var, i2, z, k(qv0Var, z));
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                int[] iArrB = bh3VarL.b();
                float fS = ((iArrB[0] + iArrB[1]) - 1) / 2.0f;
                if (z) {
                    fS = (qv0Var.s() - 1) - fS;
                }
                resultPointCallback.a(new xg7(fS, i2));
            }
            p62 p62VarI = i(qv0Var, bh3VarL, true);
            p62 p62VarI2 = i(qv0Var, bh3VarL, false);
            return new sl6((p62VarI.b() * 1597) + p62VarI2.b(), p62VarI.a() + (p62VarI2.a() * 4), bh3VarL);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public final int[] k(qv0 qv0Var, boolean z) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int iS = qv0Var.s();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < iS) {
            z2 = !qv0Var.m(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = 0;
        int i4 = i2;
        while (i2 < iS) {
            if (qv0Var.m(i2) != z2) {
                decodeFinderCounters[i3] = decodeFinderCounters[i3] + 1;
            } else {
                if (i3 != 3) {
                    i3++;
                } else {
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        return new int[]{i4, i2};
                    }
                    i4 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i3--;
                }
                decodeFinderCounters[i3] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final bh3 l(qv0 qv0Var, int i2, boolean z, int[] iArr) throws NotFoundException {
        int iS;
        int i3;
        boolean zM = qv0Var.m(iArr[0]);
        int i4 = iArr[0] - 1;
        while (i4 >= 0 && zM != qv0Var.m(i4)) {
            i4--;
        }
        int i5 = i4 + 1;
        int i6 = iArr[0] - i5;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i6;
        int finderValue = AbstractRSSReader.parseFinderValue(decodeFinderCounters, f41131a);
        int i7 = iArr[1];
        if (z) {
            int iS2 = (qv0Var.s() - 1) - i5;
            iS = (qv0Var.s() - 1) - i7;
            i3 = iS2;
        } else {
            iS = i7;
            i3 = i5;
        }
        return new bh3(finderValue, new int[]{i5, iArr[1]}, i3, iS, i2);
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.f15947a.clear();
        this.b.clear();
    }
}
