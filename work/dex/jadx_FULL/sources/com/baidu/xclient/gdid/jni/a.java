package com.baidu.xclient.gdid.jni;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.xclient.gdid.j.d;
import com.zj.adlib.u15;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {
    public static Pair<Integer, Integer> a(int i, int i2, int i3) {
        if (i2 <= i || i == 0) {
            i = 1;
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i3));
    }

    public static boolean a(int i, int i2) {
        String binaryString = Integer.toBinaryString(i2);
        return i <= binaryString.length() && binaryString.charAt(i - 1) == '1';
    }

    public static boolean a(Context context, JSONObject jSONObject, String str, int i, int i2, int i3) {
        if (com.baidu.sec.privacy.b.b.a(context).a() || a(i2, i3)) {
            return TextUtils.isEmpty(str) || jSONObject.optInt(str, i) == 1;
        }
        return false;
    }

    public static String[] a(String str) {
        String[] strArrSplit;
        String str2;
        String[] strArr = new String[2];
        try {
            String[] strArrSplit2 = str.split("\n");
            if (strArrSplit2 == null) {
                return strArr;
            }
            for (String str3 : strArrSplit2) {
                if (!TextUtils.isEmpty(str3) && (strArrSplit = str3.trim().split(u15.f19942b)) != null && strArrSplit.length == 2 && (str2 = strArrSplit[0]) != null && strArrSplit[1] != null) {
                    String strTrim = str2.trim();
                    if (strTrim.equals("Hardware") || strTrim.equals("model name")) {
                        strArr[0] = strArrSplit[1].trim();
                    } else if (strTrim.equals("vendor_id") || strTrim.equals("Processor")) {
                        strArr[1] = strArrSplit[1].trim();
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return strArr;
    }
}
