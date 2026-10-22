package com.baidu.sec.privacy.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f {
    public static boolean a(Context context, int i) {
        if (com.baidu.sec.privacy.d.a.b(i)) {
            return b(context, i);
        }
        return false;
    }

    public static boolean b(Context context, int i) {
        if (com.baidu.sec.privacy.d.a.a(i)) {
            return true;
        }
        return c.d(context);
    }

    public static int a(Context context, int i, String str, int i2, boolean z, com.baidu.sec.privacy.e.d.a<Integer> aVar, Object... objArr) {
        int iA;
        try {
            if (!com.baidu.sec.privacy.d.a.b(i)) {
                return i2;
            }
            String str2 = i + "";
            if (!TextUtils.isEmpty(str)) {
                str2 = str2 + Base64.encodeToString(str.getBytes(), 0);
            }
            if (!a(str2)) {
                if (com.baidu.sec.privacy.d.a.a(str2) && (iA = com.baidu.sec.privacy.d.a.a(str2, i2)) != i2) {
                    return iA;
                }
                if (b(context, i)) {
                    int iIntValue = aVar.a(str, objArr).intValue();
                    if (iIntValue != i2) {
                        com.baidu.sec.privacy.d.a.b(str2, iIntValue);
                    }
                    return iIntValue;
                }
                return a(context, i2, z);
            }
            if (b(context, i)) {
                int iIntValue2 = aVar.a(str, objArr).intValue();
                if (iIntValue2 == i2) {
                    return com.baidu.sec.privacy.d.a.a(str2) ? com.baidu.sec.privacy.d.a.a(str2, i2) : i2;
                }
                com.baidu.sec.privacy.d.a.b(str2, iIntValue2);
                return iIntValue2;
            }
            if (com.baidu.sec.privacy.d.a.a(str2)) {
                int iA2 = com.baidu.sec.privacy.d.a.a(str2, i2);
                return iA2 == i2 ? a(context, i2, z) : iA2;
            }
            return a(context, i2, z);
        } catch (Throwable th) {
            c.a(th);
            return i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    public static String a(Context context, int i, String str, boolean z, com.baidu.sec.privacy.e.d.a<String> aVar, Object... objArr) {
        boolean z2;
        if (i == 64) {
            try {
                if (com.baidu.sec.privacy.d.a.b()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            } catch (Throwable th) {
                c.a(th);
                return "";
            }
        } else {
            z2 = true;
        }
        if (z2 && !com.baidu.sec.privacy.d.a.b(i)) {
            return "";
        }
        String str2 = i + "";
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + Base64.encodeToString(str.getBytes(), 0);
        }
        if (!a(str2)) {
            if (com.baidu.sec.privacy.d.a.a(str2)) {
                String strA = com.baidu.sec.privacy.d.a.a(str2, "");
                if (!TextUtils.isEmpty(strA)) {
                    return strA;
                }
            }
            if (z2 ? b(context, i) : true) {
                String strA2 = aVar.a(str, objArr);
                if (!TextUtils.isEmpty(strA2)) {
                    com.baidu.sec.privacy.d.a.b(str2, strA2);
                }
                return strA2;
            }
            return a(context, z);
        }
        if (z2 ? b(context, i) : true) {
            String strA3 = aVar.a(str, objArr);
            if (TextUtils.isEmpty(strA3)) {
                return com.baidu.sec.privacy.d.a.a(str2) ? com.baidu.sec.privacy.d.a.a(str2, "") : "";
            }
            com.baidu.sec.privacy.d.a.b(str2, strA3);
            return strA3;
        }
        if (com.baidu.sec.privacy.d.a.a(str2)) {
            String strA4 = com.baidu.sec.privacy.d.a.a(str2, "");
            return TextUtils.isEmpty(strA4) ? a(context, z) : strA4;
        }
        return a(context, z);
    }

    public static String a(Context context, int i, boolean z, com.baidu.sec.privacy.e.d.a<String> aVar, Object... objArr) {
        return a(context, i, null, z, aVar, objArr);
    }

    public static boolean a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("la_in");
        return System.currentTimeMillis() - com.baidu.sec.privacy.d.a.a(sb.toString(), 0L) >= 86400000;
    }

    public static String a(Context context, boolean z) {
        if (z) {
            return !c.c(context) ? "-1000" : "-1001";
        }
        return "";
    }

    public static int a(Context context, int i, boolean z) {
        if (z) {
            return !c.c(context) ? -1000 : -1001;
        }
        return i;
    }
}
