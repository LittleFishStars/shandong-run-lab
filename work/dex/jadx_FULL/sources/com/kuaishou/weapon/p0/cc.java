package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f40078a;

    public cc(Context context) {
        if (Engine.loadSuccess) {
            Engine.getInstance(context);
            String strAbc = Engine.abc();
            if (TextUtils.isEmpty(strAbc)) {
                return;
            }
            try {
                this.f40078a = new JSONObject(strAbc);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f40078a;
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
