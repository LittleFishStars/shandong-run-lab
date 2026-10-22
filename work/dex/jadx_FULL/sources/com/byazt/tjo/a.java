package com.byazt.tjo;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 516, 34})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f29059a = 0;
    public static long c = 0;
    public static boolean i = false;
    public static long n;
    public static long sp;
    public static long tt;
    public static long uj;
    public static long ve;
    public static long x;

    public static void c() {
        i = true;
    }

    public static void c(JSONObject jSONObject, String str) {
        if (i || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, SystemClock.elapsedRealtime() - sp);
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public static void c(JSONObject jSONObject, String str, long j) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, SystemClock.elapsedRealtime() - j);
        } catch (JSONException e) {
            m.c(e);
        }
    }
}
