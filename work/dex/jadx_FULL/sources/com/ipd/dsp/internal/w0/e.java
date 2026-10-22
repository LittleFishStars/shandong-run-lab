package com.ipd.dsp.internal.w0;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38596a = 4;

    public static String a(String str) {
        String strB = b(str);
        String strA = com.ipd.dsp.internal.y0.a.a(str);
        if (TextUtils.isEmpty(strB)) {
            return strA;
        }
        return strA + Consts.DOT + strB;
    }

    public static String b(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || iLastIndexOf + 6 <= str.length()) ? "" : str.substring(iLastIndexOf + 1);
    }
}
