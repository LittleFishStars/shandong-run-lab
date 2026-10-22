package com.zj.adlib;

import com.google.zxing.NotFoundException;
import com.google.zxing.oned.OneDReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class xm1 extends OneDReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f45849a = 0.25f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f20681a = 98;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[][] f20682a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    public static final float b = 0.7f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f20683b = 99;
    public static final int c = 100;
    public static final int d = 101;
    public static final int e = 102;
    public static final int f = 97;
    public static final int g = 96;
    public static final int h = 101;
    public static final int i = 100;
    public static final int j = 103;
    public static final int k = 104;
    public static final int l = 105;
    public static final int m = 106;

    public static int e(qv0 qv0Var, int[] iArr, int i2) throws NotFoundException {
        OneDReader.recordPattern(qv0Var, i2, iArr);
        float f2 = 0.25f;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[][] iArr2 = f20682a;
            if (i4 >= iArr2.length) {
                break;
            }
            float fPatternMatchVariance = OneDReader.patternMatchVariance(iArr, iArr2[i4], 0.7f);
            if (fPatternMatchVariance < f2) {
                i3 = i4;
                f2 = fPatternMatchVariance;
            }
            i4++;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] f(qv0 qv0Var) throws NotFoundException {
        int iS = qv0Var.s();
        int iP = qv0Var.p(0);
        int[] iArr = new int[6];
        boolean z = false;
        int i2 = 0;
        int i3 = iP;
        while (iP < iS) {
            if (qv0Var.m(iP) != z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 == 5) {
                    int i4 = -1;
                    float f2 = 0.25f;
                    for (int i5 = 103; i5 <= 105; i5++) {
                        float fPatternMatchVariance = OneDReader.patternMatchVariance(iArr, f20682a[i5], 0.7f);
                        if (fPatternMatchVariance < f2) {
                            i4 = i5;
                            f2 = fPatternMatchVariance;
                        }
                    }
                    if (i4 >= 0 && qv0Var.u(Math.max(0, i3 - ((iP - i3) / 2)), i3, false)) {
                        return new int[]{i3, iP, i4};
                    }
                    i3 += iArr[0] + iArr[1];
                    int i6 = i2 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i6);
                    iArr[i6] = 0;
                    iArr[i2] = 0;
                    i2--;
                } else {
                    i2++;
                }
                iArr[i2] = 1;
                z = !z;
            }
            iP++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x016d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0171  */
    /* JADX WARN: Code duplicated, block: B:104:0x0175  */
    /* JADX WARN: Code duplicated, block: B:106:0x017e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0180  */
    /* JADX WARN: Code duplicated, block: B:109:0x0184  */
    /* JADX WARN: Code duplicated, block: B:111:0x0188  */
    /* JADX WARN: Code duplicated, block: B:113:0x018e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0191  */
    /* JADX WARN: Code duplicated, block: B:116:0x0198  */
    /* JADX WARN: Code duplicated, block: B:118:0x019c  */
    /* JADX WARN: Code duplicated, block: B:120:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:121:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:122:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:123:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:124:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:128:0x01bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:130:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:156:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x005c  */
    /* JADX WARN: Code duplicated, block: B:19:0x006c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0070  */
    /* JADX WARN: Code duplicated, block: B:24:0x007b A[LOOP:1: B:23:0x0079->B:24:0x007b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0085  */
    /* JADX WARN: Code duplicated, block: B:28:0x008c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0095  */
    /* JADX WARN: Code duplicated, block: B:33:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x009b  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ef A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:60:0x00f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:62:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x0100 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x0102  */
    /* JADX WARN: Code duplicated, block: B:68:0x0109  */
    /* JADX WARN: Code duplicated, block: B:70:0x0116 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x0118  */
    /* JADX WARN: Code duplicated, block: B:73:0x011c  */
    /* JADX WARN: Code duplicated, block: B:74:0x011f A[FALL_THROUGH, PHI: r21 r22
      0x011f: PHI (r21v8 boolean) = 
      (r21v5 boolean)
      (r21v5 boolean)
      (r21v5 boolean)
      (r21v5 boolean)
      (r21v15 boolean)
      (r21v15 boolean)
      (r21v15 boolean)
      (r21v15 boolean)
     binds: [B:73:0x011c, B:81:0x0133, B:85:0x013f, B:84:0x013b, B:43:0x00c5, B:51:0x00db, B:55:0x00e7, B:54:0x00e3] A[DONT_GENERATE, DONT_INLINE]
      0x011f: PHI (r22v8 int) = (r22v1 int), (r22v6 int), (r22v6 int), (r22v6 int), (r22v1 int), (r22v12 int), (r22v12 int), (r22v12 int) binds: [B:73:0x011c, B:81:0x0133, B:85:0x013f, B:84:0x013b, B:43:0x00c5, B:51:0x00db, B:55:0x00e7, B:54:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x0121  */
    /* JADX WARN: Code duplicated, block: B:77:0x0127  */
    /* JADX WARN: Code duplicated, block: B:78:0x012a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0131  */
    /* JADX WARN: Code duplicated, block: B:82:0x0135  */
    /* JADX WARN: Code duplicated, block: B:84:0x013b  */
    /* JADX WARN: Code duplicated, block: B:85:0x013f  */
    /* JADX WARN: Code duplicated, block: B:86:0x0145  */
    /* JADX WARN: Code duplicated, block: B:87:0x0147  */
    /* JADX WARN: Code duplicated, block: B:88:0x0149 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:89:0x014b A[PHI: r21
      0x014b: PHI (r21v14 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:88:0x0149, B:57:0x00ef] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:91:0x0151 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:92:0x0153 A[PHI: r21
      0x0153: PHI (r21v12 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:91:0x0151, B:60:0x00f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:93:0x0157 A[PHI: r21
      0x0157: PHI (r21v11 boolean) = (r21v5 boolean), (r21v5 boolean), (r21v15 boolean), (r21v15 boolean) binds: [B:90:0x014f, B:91:0x0151, B:59:0x00f2, B:60:0x00f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:94:0x015a A[PHI: r21
      0x015a: PHI (r21v10 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:73:0x011c, B:43:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:95:0x015e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0162 A[PHI: r21
      0x0162: PHI (r21v9 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:73:0x011c, B:43:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:98:0x0166 A[PHI: r21
      0x0166: PHI (r21v7 boolean) = (r21v5 boolean), (r21v15 boolean) binds: [B:72:0x011a, B:42:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:75:0x0121
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.google.zxing.oned.OneDReader
    public com.zj.adlib.ug7 b(int r26, com.zj.adlib.qv0 r27, java.util.Map<com.google.zxing.DecodeHintType, ?> r28) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            Method dump skipped, instruction units count: 708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zj.adlib.xm1.b(int, com.zj.adlib.qv0, java.util.Map):com.zj.adlib.ug7");
    }
}
