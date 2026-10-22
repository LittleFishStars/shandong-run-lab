package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.zj.adlib.qv0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class c extends AI01decoder {
    public static final int b = 8;
    public static final int c = 2;

    public c(qv0 qv0Var) {
        super(qv0Var);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String b() throws NotFoundException, FormatException {
        if (getInformation().s() < 48) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        d(sb, 8);
        int iF = getGeneralDecoder().f(48, 2);
        sb.append("(392");
        sb.append(iF);
        sb.append(')');
        sb.append(getGeneralDecoder().c(50, null).b());
        return sb.toString();
    }
}
