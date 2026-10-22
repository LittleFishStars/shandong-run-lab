package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.zj.adlib.qv0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class e extends AI01weightDecoder {
    public static final int b = 8;
    public static final int c = 20;
    public static final int d = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32525a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f6771b;

    public e(qv0 qv0Var, String str, String str2) {
        super(qv0Var);
        this.f32525a = str2;
        this.f6771b = str;
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    public void addWeightCode(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.f6771b);
        sb.append(i / 100000);
        sb.append(')');
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String b() throws NotFoundException {
        if (getInformation().s() != 84) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        d(sb, 8);
        f(sb, 48, 20);
        g(sb, 68);
        return sb.toString();
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    public int checkWeight(int i) {
        return i % 100000;
    }

    public final void g(StringBuilder sb, int i) {
        int iF = getGeneralDecoder().f(i, 16);
        if (iF == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f32525a);
        sb.append(')');
        int i2 = iF % 32;
        int i3 = iF / 32;
        int i4 = (i3 % 12) + 1;
        int i5 = i3 / 12;
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i4 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i4);
        if (i2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i2);
    }
}
