package com.kuaishou.weapon.p0;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f40130a;
    private JSONObject b;
    private String c;
    private String d;

    public m(String str, JSONObject jSONObject) {
        this.f40130a = str;
        this.b = jSONObject;
    }

    public JSONObject a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(String str) {
        this.d = str;
    }
}
