package com.zj.adlib;

import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class m6b {
    public static int b = 1;
    public static int c = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f18147a = System.currentTimeMillis();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f18148a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f18149b;

    public m6b(int i, String str, String str2) {
        this.f18148a = str2;
        this.f43236a = i;
        this.f18149b = str;
    }

    public static m6b b(String str, String str2) {
        return new m6b(b, str, str2);
    }

    public static String c(int i) {
        return i == c ? "error" : AliyunLogCommon.LogLevel.INFO;
    }

    public static String d(List<m6b> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<m6b> it = list.iterator();
                    while (it.hasNext()) {
                        String strH = h(it.next());
                        if (!TextUtils.isEmpty(strH)) {
                            jSONArray.put(strH);
                        }
                    }
                    return jSONArray.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static boolean e(m6b m6bVar) {
        return (m6bVar == null || TextUtils.isEmpty(m6bVar.g())) ? false : true;
    }

    public static m6b f(String str, String str2) {
        return new m6b(c, str, str2);
    }

    public static String h(m6b m6bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AliyunLogCommon.LogLevel.INFO, m6bVar.g());
            jSONObject.put("session", m6bVar.j());
            jSONObject.put("timestamp", m6bVar.f18147a);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public final int a() {
        return this.f43236a;
    }

    public final String g() {
        new JSONObject();
        return this.f18148a;
    }

    public final String i() {
        return c(this.f43236a);
    }

    public final String j() {
        return this.f18149b;
    }
}
