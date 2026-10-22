package com.byazt.gd;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.byazt.aq.sp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2180, 20})
public class c {
    public static int c(sp spVar) {
        if (spVar == null) {
            return 0;
        }
        String strNb = spVar.nb();
        String strGr = spVar.gr();
        if (TextUtils.isEmpty(strGr) || TextUtils.isEmpty(strNb) || !strGr.equals("creative")) {
            return 0;
        }
        if (strNb.equals("shake")) {
            return 2;
        }
        if (strNb.equals("twist")) {
            return 3;
        }
        return strNb.equals("slide") ? 1 : 0;
    }

    public static boolean tt(View view) {
        if (view == null) {
            return false;
        }
        try {
            Pair pair = (Pair) view.getTag(2097610707);
            if (pair == null) {
                return false;
            }
            return (TextUtils.isEmpty((CharSequence) pair.first) || TextUtils.equals("0", (CharSequence) pair.first)) && ((((Long) pair.second).longValue() > 0L ? 1 : (((Long) pair.second).longValue() == 0L ? 0 : -1)) <= 0);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public static boolean c(View view) {
        if (view == null) {
            return false;
        }
        try {
            Object tag = view.getTag(2097610708);
            return tag != null && ((Integer) tag).intValue() == 1;
        } catch (Exception unused) {
        }
    }

    public static boolean c(View view, float f, float f2, float f3, float f4) {
        if (view == null) {
            return false;
        }
        try {
            Pair pair = (Pair) view.getTag(2097610707);
            if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first) && ((Long) pair.second).longValue() > 0) {
                String str = (String) pair.first;
                long jLongValue = ((Long) pair.second).longValue();
                if (str.equals("0")) {
                    return ((float) Math.sqrt(Math.pow((double) (f - f3), 2.0d) + Math.pow((double) (f2 - f4), 2.0d))) >= ((float) jLongValue);
                }
                if (str.equals("1")) {
                    float f5 = f2 - f4;
                    return f5 < 0.0f && Math.abs(f5) >= ((float) jLongValue);
                }
                if (str.equals("2")) {
                    float f6 = f - f3;
                    return f6 > 0.0f && Math.abs(f6) >= ((float) jLongValue);
                }
                if (str.equals("3")) {
                    float f7 = f - f3;
                    return f7 < 0.0f && Math.abs(f7) >= ((float) jLongValue);
                }
                if (str.equals("4")) {
                    float f8 = f2 - f4;
                    if (f8 > 0.0f && Math.abs(f8) >= jLongValue) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
