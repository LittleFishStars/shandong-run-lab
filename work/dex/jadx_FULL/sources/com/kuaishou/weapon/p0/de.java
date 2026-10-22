package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class de {
    public JSONArray a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 2) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add((String) jSONArray.get(i));
            }
            if (hashSet.size() > 0) {
                return new JSONArray((Collection) hashSet);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                String str2 = (String) jSONArray.get(i);
                if (str2.contains("frida")) {
                    hashSet.add(str2);
                }
            }
            if (hashSet.size() > 0) {
                return new JSONArray((Collection) hashSet);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray c(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                String str2 = (String) jSONArray.get(i);
                if (str2.contains("substrate") || str2.contains(".jar") || str2.contains("xposed")) {
                    hashSet.add(str2);
                }
            }
            if (hashSet.size() > 0) {
                return new JSONArray((Collection) hashSet);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && jSONArray2 != null && jSONArray2.length() > 0) {
                    Set setA = dj.a(jSONArray);
                    Set setA2 = dj.a(jSONArray2);
                    if (setA != null && setA2 != null) {
                        setA.removeAll(setA2);
                        if (setA.size() > 0) {
                            return new JSONArray((Collection) setA);
                        }
                        return null;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }
}
