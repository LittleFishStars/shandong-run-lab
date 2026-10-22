package com.byazt.nbs;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1871, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f28817a;
    public String c;
    public String n;
    public double sp;
    public String tt;
    public int uj;
    public String ve;

    public ve(String str, String str2, String str3, int i, String str4, double d, double d2) {
        this.c = str;
        this.tt = str2;
        this.ve = str3;
        this.uj = i;
        this.n = str4;
        this.f28817a = d;
        this.sp = d2;
    }

    public double a() {
        return this.sp;
    }

    public String c() {
        return this.tt;
    }

    public double n() {
        return this.f28817a;
    }

    public String tt() {
        return this.ve;
    }

    public String uj() {
        return this.n;
    }

    public int ve() {
        return this.uj;
    }

    public static ve c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return null;
        }
        return new ve(str, jSONObject.optString("label_name"), jSONObject.optString("timestamp"), jSONObject.optInt("label_id"), jSONObject.optString("label_version"), jSONObject.optDouble("upper_bound"), jSONObject.optDouble("lower_bound"));
    }
}
