package com.alibaba.analytics.core.a;

import com.alibaba.analytics.a.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i {
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static final Map<String, String> m103a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObject.getString(next);
                if (next != null && string != null) {
                    map.put(next, string);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static final List<j> a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        long j;
        if (jSONObject == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (next.startsWith("B02N")) {
                try {
                    jSONObject2 = jSONObject.getJSONObject(next);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject2 = null;
                }
                if (next.length() > 5) {
                    next = next.substring(5);
                }
                if (jSONObject2 != null) {
                    String strOptString = jSONObject2.optString("content");
                    if (strOptString != null && strOptString.equals("gc_304")) {
                        j jVar = new j();
                        jVar.r(next);
                        jVar.w();
                        linkedList.add(jVar);
                    } else {
                        try {
                            jSONObject3 = jSONObject2.getJSONObject("content");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            jSONObject3 = null;
                        }
                        if (jSONObject2.has("t")) {
                            try {
                                j = jSONObject2.getLong("t");
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                                j = 0;
                            }
                        } else {
                            j = 0;
                        }
                        if (jSONObject3 != null) {
                            linkedList.add(a(next, m103a(jSONObject3), j));
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    public static final j a(String str, Map<String, String> map, long j) {
        j jVar = new j();
        jVar.q(u.e(map));
        jVar.r(str);
        jVar.a(j);
        return jVar;
    }
}
