package com.google.zxing.oned.rss.expanded.decoders;

import com.zj.adlib.qv0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
abstract class AI01weightDecoder extends AI01decoder {
    public AI01weightDecoder(qv0 qv0Var) {
        super(qv0Var);
    }

    public abstract void addWeightCode(StringBuilder sb, int i);

    public abstract int checkWeight(int i);

    public final void f(StringBuilder sb, int i, int i2) {
        int iF = getGeneralDecoder().f(i, i2);
        addWeightCode(sb, iF);
        int iCheckWeight = checkWeight(iF);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (iCheckWeight / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(iCheckWeight);
    }
}
