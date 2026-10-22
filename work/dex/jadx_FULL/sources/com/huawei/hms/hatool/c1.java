package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c1 {
    public static Map<String, List<b1>> a(Context context, String str) {
        if (context == null) {
            return null;
        }
        Map<String, ?> mapA = d.a(context, str);
        b(mapA);
        return a(mapA);
    }

    public static Map<String, List<b1>> a(Context context, String str, String str2) {
        Map<String, List<b1>> mapA;
        Map<String, List<b1>> mapA2;
        if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
            v.c("hmsSdk", "read all event records");
            mapA = a(context, "stat_v2_1");
            mapA2 = a(context, "cached_v2_1");
        } else {
            String strA = n1.a(str, str2);
            mapA = b(context, "stat_v2_1", strA);
            mapA2 = b(context, "cached_v2_1", strA);
        }
        return a(mapA, mapA2);
    }

    private static Map<String, List<b1>> a(Map<String, ?> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() instanceof String) {
                a(key, (String) entry.getValue(), map2);
            }
        }
        return map2;
    }

    private static Map<String, List<b1>> a(Map<String, List<b1>> map, Map<String, List<b1>> map2) {
        if (map.size() == 0 && map2.size() == 0) {
            return new HashMap();
        }
        if (map.size() == 0) {
            return map2;
        }
        if (map2.size() == 0) {
            return map;
        }
        HashMap map3 = new HashMap(map);
        map3.putAll(map2);
        return map3;
    }

    private static void a(String str, String str2, Map<String, List<b1>> map) {
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() == 0) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                b1 b1Var = new b1();
                try {
                    b1Var.a(jSONArray.getJSONObject(i));
                    arrayList.add(b1Var);
                } catch (JSONException unused) {
                    v.e("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
                }
            }
            map.put(str, arrayList);
        } catch (JSONException unused2) {
            v.e("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
        }
    }

    public static Map<String, List<b1>> b(Context context, String str, String str2) {
        String strA = d.a(context, str, str2, "");
        HashMap map = new HashMap();
        a(str2, strA, map);
        return map;
    }

    private static void b(Map<String, ?> map) {
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        Set<String> setA = n1.a(q0.b());
        while (it.hasNext()) {
            if (!setA.contains(it.next().getKey())) {
                it.remove();
            }
        }
    }
}
