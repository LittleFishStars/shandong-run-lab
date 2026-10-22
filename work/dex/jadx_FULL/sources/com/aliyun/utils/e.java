package com.aliyun.utils;

import com.cicada.player.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e {
    public static int a(JSONObject jSONObject, String... strArr) {
        if (jSONObject == null) {
            return 0;
        }
        for (String str : strArr) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        for (String str2 : strArr) {
            Logger.w("JsonUtil", "No json int value for " + str2);
        }
        return 0;
    }

    public static long b(JSONObject jSONObject, String... strArr) {
        if (jSONObject == null) {
            return 0L;
        }
        for (String str : strArr) {
            try {
                return jSONObject.getLong(str);
            } catch (JSONException unused) {
            }
        }
        for (String str2 : strArr) {
            Logger.w("JsonUtil", "No json long value for " + str2);
        }
        return 0L;
    }
}
