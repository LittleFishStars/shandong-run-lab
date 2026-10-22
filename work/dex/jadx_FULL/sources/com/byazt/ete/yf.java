package com.byazt.ete;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 508})
public class yf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28522a;
    public String c;
    public String n;
    public String tt;
    public String uj;
    public String ve;

    public yf(String str, String str2, String str3, String str4) {
        this.c = str3;
        this.tt = str2;
        this.uj = str;
        this.ve = str4;
    }

    public void c(String str, String str2, String str3, String str4) {
        this.c = str3;
        this.tt = str2;
        this.uj = str;
        this.ve = str4;
    }

    public String toString() {
        JSONObject jSONObjectVe = ve();
        return jSONObjectVe.length() > 0 ? jSONObjectVe.toString() : "";
    }

    public String tt() {
        return this.c;
    }

    public JSONObject ve() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tk", this.c).put("vd", this.uj).put("cr", this.ve).put(NotificationCompat.CATEGORY_ERROR, this.tt);
            if (!TextUtils.isEmpty(this.ve) && this.ve.equals("2")) {
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.put("i6", this.n);
                }
                if (!TextUtils.isEmpty(this.f28522a)) {
                    jSONObject.put("prov", this.f28522a);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void tt(String str) {
        this.f28522a = str;
    }

    public String c() {
        return this.tt;
    }

    public void c(String str) {
        this.n = str;
    }
}
