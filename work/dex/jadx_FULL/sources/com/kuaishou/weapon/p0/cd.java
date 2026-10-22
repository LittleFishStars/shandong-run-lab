package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f40079a;

    public cd(Context context) {
        if (Engine.loadSuccess) {
            String strNop = Engine.getInstance(context).nop();
            if (TextUtils.isEmpty(strNop)) {
                return;
            }
            try {
                this.f40079a = new JSONObject(strNop);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f40079a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f40079a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            try {
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String strA = f.a(jSONObject2.optString("1"));
                        String strA2 = f.a(jSONObject2.optString("2"));
                        if (!TextUtils.isEmpty(strA)) {
                            jSONObject2.put("1", strA);
                        }
                        if (!TextUtils.isEmpty(strA2)) {
                            jSONObject2.put("2", strA2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return jSONArray;
        } catch (Exception unused2) {
            return null;
        }
    }
}
