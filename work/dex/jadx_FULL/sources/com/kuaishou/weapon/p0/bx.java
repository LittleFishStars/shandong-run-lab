package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class bx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f40071a;

    public bx(Context context) {
        if (Engine.loadSuccess) {
            String strFgh = Engine.getInstance(context).fgh();
            if (TextUtils.isEmpty(strFgh)) {
                return;
            }
            try {
                this.f40071a = new JSONObject(strFgh);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f40071a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
