package com.byazt.vx;

import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 54})
public class ve {
    public static final Random c = new SecureRandom();

    public static JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strC = c(jSONObject.toString());
                if (TextUtils.isEmpty(strC)) {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                } else {
                    jSONObject2.put("message", strC);
                    jSONObject2.put("cypher", 3);
                }
            } catch (Throwable th) {
                com.byazt.eu.tt.c(th.getMessage());
            }
        } catch (Throwable unused) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static String tt() {
        String strC = c(8);
        if (strC == null || strC.length() != 16) {
            return null;
        }
        return strC;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strC = c();
        String strC2 = c(strC, 32);
        String strTt = tt();
        return 3 + strC + strTt + ((strC2 == null || strTt == null) ? null : c.c(str, strTt, strC2));
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
            c.nextBytes(bArr);
            return sl.c(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
