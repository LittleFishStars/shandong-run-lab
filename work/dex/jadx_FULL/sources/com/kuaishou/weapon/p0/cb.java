package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f40077a;

    public cb(Context context) {
        if (Engine.loadSuccess) {
            String strHij = Engine.getInstance(context).hij();
            if (TextUtils.isEmpty(strHij)) {
                return;
            }
            try {
                this.f40077a = new JSONObject(strHij);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f40077a;
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
