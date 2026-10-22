package com.zj.adlib;

import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bp2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40800a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f15608a;
    public final int b;

    public bp2(int i, int i2, String str) {
        this.f40800a = i;
        this.b = i2;
        this.f15608a = str;
    }

    @Nullable
    public static bp2 a(om6 om6Var) {
        String str;
        om6Var.T(2);
        int iG = om6Var.G();
        int i = iG >> 1;
        int iG2 = ((om6Var.G() >> 3) & 31) | ((iG & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = VisualSampleEntry.TYPE4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(iG2 >= 10 ? Consts.DOT : ".0");
        sb.append(iG2);
        return new bp2(i, iG2, sb.toString());
    }
}
