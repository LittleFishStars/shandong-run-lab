package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.oned.OneDReader;
import com.zj.adlib.se5;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class AbstractRSSReader extends OneDReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f32520a = 0.2f;
    public static final float b = 0.45f;
    public static final float c = 0.7916667f;
    public static final float d = 0.89285713f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int[] f6766b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int[] f6767c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final int[] f6768d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f6764a = new int[4];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f6763a = new float[4];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final float[] f6765b = new float[4];

    public AbstractRSSReader() {
        int[] iArr = new int[8];
        this.f6766b = iArr;
        this.f6767c = new int[iArr.length / 2];
        this.f6768d = new int[iArr.length / 2];
    }

    @Deprecated
    public static int count(int[] iArr) {
        return se5.d(iArr);
    }

    public static void decrement(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 < f) {
                i = i2;
                f = f2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    public static void increment(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 > f) {
                i = i2;
                f = f2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    public static boolean isFinderPattern(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f = i / ((iArr[2] + i) + iArr[3]);
        if (f < 0.7916667f || f > 0.89285713f) {
            return false;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 : iArr) {
            if (i4 > i3) {
                i3 = i4;
            }
            if (i4 < i2) {
                i2 = i4;
            }
        }
        return i3 < i2 * 10;
    }

    public static int parseFinderValue(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (OneDReader.patternMatchVariance(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final int[] getDataCharacterCounters() {
        return this.f6766b;
    }

    public final int[] getDecodeFinderCounters() {
        return this.f6764a;
    }

    public final int[] getEvenCounts() {
        return this.f6768d;
    }

    public final float[] getEvenRoundingErrors() {
        return this.f6765b;
    }

    public final int[] getOddCounts() {
        return this.f6767c;
    }

    public final float[] getOddRoundingErrors() {
        return this.f6763a;
    }
}
