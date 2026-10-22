package com.byazt.fz;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1022, 34})
public class a implements sl {
    @Override // com.byazt.fz.sl
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public String c(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length >= 2) {
            String strValueOf = String.valueOf(objArr[0]);
            if (TextUtils.isEmpty(strValueOf)) {
                return null;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(strValueOf);
                String strValueOf2 = String.valueOf(objArr[1]);
                if (TextUtils.isEmpty(strValueOf2)) {
                    return null;
                }
                Object objC = com.byazt.kx.c.c(strValueOf2).c(jSONObject2);
                if (!TextUtils.isEmpty(String.valueOf(objC))) {
                    return String.valueOf(objC);
                }
                if (objArr.length >= 3) {
                    return String.valueOf(objArr[2]);
                }
                return null;
            } catch (JSONException e) {
                com.byazt.nr.m.c(e);
            }
        }
        return null;
    }
}
