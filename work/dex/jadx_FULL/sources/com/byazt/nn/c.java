package com.byazt.nn;

import com.byazt.hu.u;
import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1020, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28838a;
    public long c;
    public String n;
    public String sp;
    public long tt;
    public String uj;
    public long ve;
    public volatile long x;

    public c() {
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.c);
            jSONObject.put("mAdId", this.tt);
            jSONObject.put("mExtValue", this.ve);
            jSONObject.put("mPackageName", this.uj);
            jSONObject.put("mAppName", this.n);
            jSONObject.put("mLogExtra", this.f28838a);
            jSONObject.put("mFileName", this.sp);
            jSONObject.put("mTimeStamp", this.x);
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject;
    }

    public c(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.c = j;
        this.tt = j2;
        this.ve = j3;
        this.uj = str;
        this.n = str2;
        this.f28838a = str3;
        this.sp = str4;
    }

    public static c c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        try {
            cVar.c = u.c(jSONObject, "mDownloadId");
            cVar.tt = u.c(jSONObject, "mAdId");
            cVar.ve = u.c(jSONObject, "mExtValue");
            cVar.uj = jSONObject.optString("mPackageName");
            cVar.n = jSONObject.optString("mAppName");
            cVar.f28838a = jSONObject.optString("mLogExtra");
            cVar.sp = jSONObject.optString("mFileName");
            cVar.x = u.c(jSONObject, "mTimeStamp");
            return cVar;
        } catch (Exception e) {
            m.c(e);
            return null;
        }
    }
}
