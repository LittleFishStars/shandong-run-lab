package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.zj.adlib.qv0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
abstract class AI013x0xDecoder extends AI01weightDecoder {
    public static final int b = 5;
    public static final int c = 15;

    public AI013x0xDecoder(qv0 qv0Var) {
        super(qv0Var);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String b() throws NotFoundException {
        if (getInformation().s() != 60) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        d(sb, 5);
        f(sb, 45, 15);
        return sb.toString();
    }
}
