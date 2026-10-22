package com.byazt.qk;

import android.text.TextUtils;
import com.byazt.fz.rh;
import com.byazt.nr.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 952, 20})
public class c {
    public static String c(String str, JSONObject jSONObject) {
        com.byazt.kx.c cVarC;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                if (!str.startsWith("${") || !str.endsWith("}") || (cVarC = com.byazt.kx.c.c(str.substring(2, str.length() - 1))) == null) {
                    return str;
                }
                Object objC = cVarC.c(jSONObject);
                if (objC instanceof String) {
                    return (String) objC;
                }
                return objC instanceof com.byazt.il.c ? String.valueOf(rh.c((com.byazt.il.c) objC)) : String.valueOf(objC);
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return str;
    }
}
