package com.byazt.cd;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVStartParams;
import com.byazt.nr.m;
import com.zj.adlib.un1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 43, 20})
public class c {

    /* JADX INFO: renamed from: com.byazt.cd.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 43, 44})
    public static class C0376c {
        public GradientDrawable.Orientation c;
        public int[] tt;
        public float[] ve;
    }

    public static int c(String str) {
        return c(str, -16777216);
    }

    public static C0376c tt(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String strSubstring = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")"));
            if (TextUtils.isEmpty(strSubstring)) {
                return null;
            }
            int iC = c(strSubstring, '%');
            int iIndexOf = strSubstring.indexOf(",");
            String strSubstring2 = strSubstring.substring(0, iIndexOf);
            C0376c c0376c = new C0376c();
            c0376c.c = uj(strSubstring2);
            String strSubstring3 = strSubstring.substring(iIndexOf + 1);
            int[] iArr = new int[iC];
            float[] fArr = new float[iC];
            for (int i = 0; i < iC; i++) {
                int iIndexOf2 = strSubstring3.indexOf("%");
                String strTrim = strSubstring3.substring(0, iIndexOf2 + 1).trim();
                int iIndexOf3 = (strTrim.contains(un1.b) ? strTrim.indexOf(")") : strTrim.indexOf(" ")) + 1;
                iArr[i] = c(strTrim.substring(0, iIndexOf3).trim());
                fArr[i] = ve.c(strTrim.substring(iIndexOf3, strTrim.indexOf("%")).trim(), 0.0f) / 100.0f;
                int i2 = iIndexOf2 + 2;
                if (strSubstring3.length() <= i2) {
                    break;
                }
                strSubstring3 = strSubstring3.substring(i2);
            }
            if (iC < 2) {
                return null;
            }
            c0376c.tt = iArr;
            c0376c.ve = fArr;
            return c0376c;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static GradientDrawable.Orientation uj(String str) {
        try {
            int i = str.contains("deg") ? Integer.parseInt(str.substring(0, str.length() - 3).trim()) : Integer.parseInt(str);
            if (i == 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i == 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i == 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            if (i == 135) {
                return GradientDrawable.Orientation.TL_BR;
            }
            return i == 45 ? GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    public static boolean ve(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("linear-gradient");
    }

    public static int c(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        if (str.equals(RVStartParams.KEY_TRANSPARENT)) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 4) {
            StringBuilder sb = new StringBuilder("#");
            char[] charArray = str.toCharArray();
            for (int i2 = 1; i2 < charArray.length; i2++) {
                sb.append(charArray[i2]);
                sb.append(charArray[i2]);
            }
            return Color.parseColor(sb.toString());
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (!str.startsWith(un1.b)) {
            return -16777216;
        }
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        if (strArrSplit == null || strArrSplit.length != 4) {
            return i;
        }
        return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2])) | 0;
    }

    public static int c(String str, char c) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        return i;
    }

    public static int c(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            m.uj("ColorUtils", "alpha must be between 0 and 255. ");
            i2 = 255;
        }
        return (i & 16777215) | (i2 << 24);
    }
}
