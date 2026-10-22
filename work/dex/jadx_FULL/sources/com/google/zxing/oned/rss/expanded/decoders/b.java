package com.google.zxing.oned.rss.expanded.decoders;

import com.zj.adlib.qv0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class b extends AI013x0xDecoder {
    public b(qv0 qv0Var) {
        super(qv0Var);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    public void addWeightCode(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    public int checkWeight(int i) {
        return i < 10000 ? i : i - 10000;
    }
}
