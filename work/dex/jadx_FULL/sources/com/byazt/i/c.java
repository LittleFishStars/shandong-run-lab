package com.byazt.i;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.bv.BaseConstants;
import com.byazt.nr.m;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 42, 20})
public class c {
    public static final HashMap<String, com.byazt.z.a.c> c = new HashMap<>();

    public static boolean c(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("type")) && c(jSONObjectOptJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean tt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        String strOptString = jSONObject.optString("allow_os_api_range");
        int iOptInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(strOptString)) {
            return iOptInt <= 0 || i >= iOptInt;
        }
        try {
            String[] strArrSplit = strOptString.split("[-,]");
            for (int i2 = 0; i2 < strArrSplit.length; i2 += 2) {
                int i3 = Integer.parseInt(strArrSplit[i2]);
                int i4 = Integer.parseInt(strArrSplit[i2 + 1]);
                if (i >= i3 && i <= i4) {
                    return true;
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
        return false;
    }

    public static boolean ve(JSONObject jSONObject) {
        return jSONObject == null || a.c() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return tt(jSONObject) && c(jSONObject.optJSONArray("device_requirements")) && ve(jSONObject);
    }

    public static boolean c(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean zC = false;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("package_names");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("version_allow");
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("version_block");
                String strOptString2 = jSONObjectOptJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                for (String strDa : strOptString.split(",")) {
                    if (BaseConstants.SCHEME_MARKET.equals(strDa)) {
                        strDa = n.da();
                    }
                    com.byazt.z.a.c cVarTt = tt(strDa);
                    if (cVarTt != null && !(zC = c(jSONArrayOptJSONArray, jSONArrayOptJSONArray2, strOptString2, cVarTt))) {
                        return false;
                    }
                }
            }
        }
        return zC;
    }

    private static boolean tt(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static com.byazt.z.a.c tt(String str) {
        HashMap<String, com.byazt.z.a.c> map = c;
        if (map.containsKey(str)) {
            com.byazt.z.a.c cVar = map.get(str);
            if (cVar != null) {
                return cVar;
            }
            return null;
        }
        com.byazt.z.a.c cVarTt = com.byazt.z.a.tt(str);
        map.put(str, cVarTt);
        if (cVarTt != null) {
            return cVarTt;
        }
        return null;
    }

    private static boolean c(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull com.byazt.z.a.c cVar) {
        String strSp = cVar.sp();
        int iA = cVar.a();
        String str2 = iA + LoginConstants.UNDER_LINE + strSp;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("[-,]");
                for (int i = 0; i < strArrSplit.length; i += 2) {
                    int i2 = Integer.parseInt(strArrSplit[i]);
                    int i3 = Integer.parseInt(strArrSplit[i + 1]);
                    if (iA >= i2 && iA <= i3) {
                        return true;
                    }
                }
            } catch (Exception e) {
                m.c(e);
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (tt(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !tt(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static com.byazt.z.a.c c(String str) {
        com.byazt.z.a.c cVarTt;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str) || (cVarTt = tt(str)) == null) {
                return null;
            }
            return cVarTt;
        } catch (Throwable unused) {
        }
    }

    public static boolean c(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("s");
            try {
                String strC = ve.c(jSONObject.optString("az"), strOptString);
                String strC2 = ve.c(jSONObject.optString("ba"), strOptString);
                Field declaredField = ContextWrapper.class.getDeclaredField(strC);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(strC2);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
