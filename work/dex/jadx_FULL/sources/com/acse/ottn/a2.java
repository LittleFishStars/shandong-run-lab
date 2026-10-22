package com.acse.ottn;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a2 {
    public static List<Map<String, String>> a(String str) {
        Exception e;
        ArrayList arrayList;
        try {
            JSONArray jSONArray = new JSONArray(str);
            arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(b(jSONArray.getJSONObject(i).toString()));
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
        }
        return arrayList;
    }

    public static Map<String, String> b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            HashMap map = new HashMap();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, (String) jSONObject.get(next));
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            h2.a("JsonMapUtil", "getShowAdActivityPackageName samon--> Exception e =" + e.getMessage());
            return null;
        }
    }
}
