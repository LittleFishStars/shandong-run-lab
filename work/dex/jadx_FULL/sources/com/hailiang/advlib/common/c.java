package com.hailiang.advlib.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f32561a = "com.hailiang.advlib.host_config";
    private static final String b = "host_config";

    public static String a(Context context, String str, String str2) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f32561a, 0);
            if (sharedPreferences == null) {
                Log.e("update_tag", "sharedPreferences is null");
                return str;
            }
            String string = sharedPreferences.getString(b, "");
            if (TextUtils.isEmpty(string)) {
                Log.e("update_tag", "config is null");
                return str;
            }
            String strB = b(string);
            Log.d("update_tag", "config:" + strB);
            JSONObject jSONObject = new JSONObject(strB);
            String strOptString = jSONObject.optString(str2);
            if (TextUtils.isEmpty(strOptString)) {
                String strOptString2 = jSONObject.optString("base_api");
                if (TextUtils.isEmpty(strOptString2)) {
                    return str;
                }
                String strA = a(str, strOptString2);
                Log.e("update_tag", "replaceDomain:" + strA);
                return strA;
            }
            String str3 = "https://" + strOptString;
            Log.e("update_tag", "replace url:" + str3);
            return str3;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String a(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : new String(Base64.decode(str, 2));
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length < 2) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArrSplit.length - 2; i++) {
            sb.append(strArrSplit[i]);
            if (i < strArrSplit.length - 3) {
                sb.append(Consts.DOT);
            }
        }
        String string = sb.toString();
        if (string.isEmpty()) {
            return str2;
        }
        return string + Consts.DOT + str2;
    }

    public static String b(String str) {
        String strA = a(str);
        return TextUtils.isEmpty(strA) ? str : strA;
    }
}
