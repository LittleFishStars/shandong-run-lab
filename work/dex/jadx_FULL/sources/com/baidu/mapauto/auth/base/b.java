package com.baidu.mapauto.auth.base;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f26597a;
    public final JSONObject b;

    public b(String str) {
        JSONObject jSONObject;
        this.f26597a = str;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        this.b = jSONObject;
    }
}
