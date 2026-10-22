package com.google.zxing.oned.rss.expanded.decoders;

import com.zj.adlib.qv0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
abstract class AI01decoder extends AbstractExpandedDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32521a = 40;

    public AI01decoder(qv0 qv0Var) {
        super(qv0Var);
    }

    public static void c(StringBuilder sb, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3 + i) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        sb.append(i4 != 10 ? i4 : 0);
    }

    public final void d(StringBuilder sb, int i) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        e(sb, i, length);
    }

    public final void e(StringBuilder sb, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int iF = getGeneralDecoder().f((i3 * 10) + i, 10);
            if (iF / 100 == 0) {
                sb.append('0');
            }
            if (iF / 10 == 0) {
                sb.append('0');
            }
            sb.append(iF);
        }
        c(sb, i2);
    }
}
