package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class bz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f40073a;

    public bz(Context context) {
        if (Engine.loadSuccess) {
            String strGhi = Engine.getInstance(context).ghi();
            if (TextUtils.isEmpty(strGhi)) {
                return;
            }
            try {
                this.f40073a = new JSONObject(strGhi);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f40073a;
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
