package com.kuaishou.weapon.p0;

import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class dh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f40119a = "bGlidmErKw==";
    private static final String b = "WnBvc2VkQnJpZGdlLmphcg==";
    private static final String c = "bGlienBvc2VkX2FydC5zbw==";

    public static Integer a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            String str = new String(c.a(b.getBytes(), 2));
            byte[] bArrA = c.a(c.getBytes(), 2);
            return (bArrA == null || !a(jSONArray, str, new String(bArrA))) ? null : 1;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Integer b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            String str = new String(c.a(f40119a.getBytes(), 2));
            return (str.length() <= 1 || !a(jSONArray, str)) ? null : 1;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean a(JSONArray jSONArray, String str, String str2) {
        try {
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    String str3 = (String) jSONArray.get(i);
                    if (str3.contains(str) || str3.contains(str2)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean a(JSONArray jSONArray, String str) {
        try {
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (((String) jSONArray.get(i)).contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
