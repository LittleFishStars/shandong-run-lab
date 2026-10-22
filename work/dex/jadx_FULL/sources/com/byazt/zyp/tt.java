package com.byazt.zyp;

import android.text.TextUtils;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1493, 13})
public class tt {
    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strC = c();
        String strC2 = c(strC, 32);
        String strTt = tt();
        return 3 + strC + strTt + ((strC2 == null || strTt == null) ? null : c.c(str, strTt, strC2));
    }

    public static String tt(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strC = c(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strC == null) ? str : c.tt(str.substring(49), strSubstring, strC);
    }

    private static SecureRandom ve() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    public static String tt() {
        String strC = c(8);
        if (strC == null || strC.length() != 16) {
            return null;
        }
        return strC;
    }

    public static JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strC = c(jSONObject.toString());
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject2.put("message", strC);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static String c() {
        String strC = c(16);
        if (strC == null || strC.length() != 32) {
            return null;
        }
        return strC;
    }

    public static String c(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String c(int i) {
        try {
            byte[] bArr = new byte[i];
            ve().nextBytes(bArr);
            return uj.c(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
