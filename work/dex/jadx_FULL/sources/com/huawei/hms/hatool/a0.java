package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a0 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f37546a = q0.i();
    private String b;
    private JSONObject c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Boolean h;

    public a0(String str, JSONObject jSONObject, String str2, String str3, long j) {
        this.b = str;
        this.c = jSONObject;
        this.d = str2;
        this.e = str3;
        this.f = String.valueOf(j);
        if (z.i(str2, "oper")) {
            p0 p0VarA = y.a().a(str2, j);
            this.g = p0VarA.a();
            this.h = Boolean.valueOf(p0VarA.b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        v.c("hmsSdk", "Begin to run EventRecordTask...");
        int iH = q0.h();
        int iK = a1.k(this.d, this.e);
        if (c0.a(this.f37546a, "stat_v2_1", iH * 1048576)) {
            v.c("hmsSdk", "stat sp file reach max limited size, discard new event");
            e.a().a("", "alltype");
            return;
        }
        b1 b1Var = new b1();
        b1Var.b(this.b);
        b1Var.a(this.c.toString());
        b1Var.d(this.e);
        b1Var.c(this.f);
        b1Var.f(this.g);
        Boolean bool = this.h;
        b1Var.e(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject jSONObjectD = b1Var.d();
            String strA = n1.a(this.d, this.e);
            String strA2 = d.a(this.f37546a, "stat_v2_1", strA, "");
            try {
                jSONArray = !TextUtils.isEmpty(strA2) ? new JSONArray(strA2) : new JSONArray();
            } catch (JSONException unused) {
                v.d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(jSONObjectD);
            d.b(this.f37546a, "stat_v2_1", strA, jSONArray.toString());
            if (jSONArray.toString().length() > iK * 1024) {
                e.a().a(this.d, this.e);
            }
        } catch (JSONException unused2) {
            v.e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
