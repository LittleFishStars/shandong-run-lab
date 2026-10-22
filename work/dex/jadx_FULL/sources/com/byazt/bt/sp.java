package com.byazt.bt;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 274, 91})
public class sp {
    public static final List<String> c = new ArrayList(Arrays.asList("1", "3", "2"));

    public static String c(Context context, com.byazt.dna.c cVar) {
        return c(ve.c(context, cVar));
    }

    public static String c(String str) {
        str.hashCode();
        switch (str) {
            case "46000":
            case "46002":
            case "46004":
            case "46007":
            case "46008":
                return "1";
            case "46001":
            case "46006":
            case "46009":
                return "2";
            case "46003":
            case "46005":
            case "46011":
                return "3";
            default:
                return "0";
        }
    }

    public static String c(com.byazt.dna.c cVar, Context context) {
        String strN = ve.n(cVar, context);
        String strSp = ve.sp(cVar, context);
        String strA = ve.a(cVar, context);
        String strX = ve.x(cVar, context);
        if (!ve.tt(context)) {
            return "5";
        }
        if (!TextUtils.isEmpty(strN) && !TextUtils.isEmpty(strSp)) {
            if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strX)) {
                String strC = c(strN + strSp);
                String strC2 = c(strA + strX);
                List<String> list = c;
                if (list.contains(strC) && list.contains(strC2) && !strC2.equals(strC)) {
                    return "6";
                }
                if (list.contains(strC)) {
                    return strC;
                }
                return list.contains(strC2) ? strC2 : "0";
            }
            return c(strN + strSp);
        }
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strX)) {
            return "4";
        }
        return c(strA + strX);
    }
}
