package com.zj.adlib;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class j70 extends AbstractExpandedDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42522a = 5;

    public j70(qv0 qv0Var) {
        super(qv0Var);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String b() throws NotFoundException, FormatException {
        return getGeneralDecoder().a(new StringBuilder(), 5);
    }
}
