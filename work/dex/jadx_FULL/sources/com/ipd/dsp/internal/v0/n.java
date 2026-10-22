package com.ipd.dsp.internal.v0;

import androidx.annotation.NonNull;
import com.kuaishou.weapon.p0.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f38570a;
    public final long b;
    public final String c;

    public n(String str, long j, String str2) {
        this.f38570a = str;
        this.b = j;
        this.c = str2;
    }

    public static n a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new n(jSONObject.getString("url"), jSONObject.getLong(t.d), jSONObject.getString("mime"));
        } catch (JSONException unused) {
            return null;
        }
    }

    @NonNull
    public String toString() {
        return "SourceInfo{url='" + this.f38570a + "', length=" + this.b + ", mime='" + this.c + "'}";
    }

    public String a() {
        return "{\"url\":\"" + this.f38570a + "\",\"l\":" + this.b + ",\"mime\":\"" + this.c + "\"}";
    }
}
