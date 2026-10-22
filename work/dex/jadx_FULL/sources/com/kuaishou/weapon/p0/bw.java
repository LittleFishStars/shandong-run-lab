package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class bw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f40070a;

    public bw(Context context) {
        if (Engine.loadSuccess) {
            String strCde = Engine.getInstance(context).cde();
            if (TextUtils.isEmpty(strCde)) {
                return;
            }
            try {
                this.f40070a = new JSONObject(strCde);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f40070a;
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
        JSONObject jSONObject = this.f40070a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return new JSONArray(string);
        } catch (Exception unused) {
            return null;
        }
    }
}
