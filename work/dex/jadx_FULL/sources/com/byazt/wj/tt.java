package com.byazt.wj;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.sa.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1288, 13})
public class tt {
    public static String c(String str, JSONObject jSONObject) {
        c cVarVe;
        c.InterfaceC0567c interfaceC0567cC;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                return (!str.startsWith("${") || !str.endsWith("}") || (cVarVe = n.c().ve()) == null || (interfaceC0567cC = cVarVe.c(str.substring(2, str.length() + (-1)))) == null) ? str : (String) interfaceC0567cC.c(jSONObject);
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return str;
    }

    public static Object c(Object obj, JSONObject jSONObject) {
        if (obj == null) {
            return null;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            return null;
        }
        return (strValueOf.startsWith("${") && strValueOf.endsWith("}")) ? c(strValueOf, jSONObject) : obj;
    }
}
