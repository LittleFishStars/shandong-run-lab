package com.byazt.dna;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface z {
    void onAdEventReport(String str, String str2, String str3, String str4);

    void onAdEventReport(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, com.byazt.ya.c cVar);

    void onAppLogMiscEvent(String str, JSONObject jSONObject);

    void onExceptionEvent(String str, JSONObject jSONObject, Throwable th);

    void onStatsEvent(String str, JSONObject jSONObject);

    void onStatsEvent(String str, JSONObject jSONObject, JSONObject jSONObject2);
}
