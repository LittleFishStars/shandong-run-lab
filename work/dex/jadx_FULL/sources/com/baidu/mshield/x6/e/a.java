package com.baidu.mshield.x6.e;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {
    public static boolean a(Context context, String str) {
        return b(context, str, true);
    }

    public static boolean b(Context context, String str, boolean z) {
        try {
            return a(context, str, z);
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
            return z;
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            String strA = new com.baidu.mshield.x6.b.b(context).a(str);
            if (TextUtils.isEmpty(strA)) {
                return z;
            }
            return new JSONObject(strA).getInt("1") != 0;
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
            return z;
        }
    }

    public static JSONObject b(Context context, String str) {
        try {
            return new JSONObject(new com.baidu.mshield.x6.b.b(context).a(str)).optJSONObject("2");
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
            return new JSONObject();
        }
    }

    public static int a(Context context) {
        try {
            int iO = new com.baidu.mshield.x6.b.b(context).o();
            if (iO <= 0) {
                iO = 60;
            }
            return iO / 60;
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
            return 1;
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z) {
        try {
            JSONObject jSONObjectB = b(context, str);
            if (jSONObjectB.has(str2)) {
                return jSONObjectB.optInt(str2, z ? 1 : 0) == 1;
            }
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
        return z;
    }
}
