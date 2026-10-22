package com.zj.adlib;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.ssa.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bp8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40806a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public bp8(int i, int i2, int i3, int i4, int i5) {
        this.f40806a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    @Nullable
    public static bp8 a(String str) {
        sb0.a(str.startsWith(a.f4617c));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < strArrSplit.length; i5++) {
            String strG = com.google.common.base.a.g(strArrSplit[i5].trim());
            strG.hashCode();
            switch (strG) {
                case "end":
                    i2 = i5;
                    break;
                case "text":
                    i4 = i5;
                    break;
                case "start":
                    i = i5;
                    break;
                case "style":
                    i3 = i5;
                    break;
            }
        }
        if (i == -1 || i2 == -1 || i4 == -1) {
            return null;
        }
        return new bp8(i, i2, i3, i4, strArrSplit.length);
    }
}
