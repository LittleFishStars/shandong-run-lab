package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f40040a;

    public ap(Context context) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ci.h).intValue(), 0, 0, "");
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.f40040a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = this.f40040a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            return new JSONObject(string);
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(String str) {
        JSONObject jSONObject = this.f40040a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.contains("{}")) {
                    return null;
                }
                return string;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
