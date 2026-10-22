package com.alibaba.analytics.core.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static o f23764a;
    private Map<String, a> r = new HashMap();

    public static class a {
        private Map<String, String> s = new HashMap();
        private String O = null;

        private a() {
        }

        public static a a(String str) {
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("stm")) {
                    aVar.O = jSONObject.optString("stm");
                }
                if (jSONObject.has("arg1")) {
                    HashMap map = new HashMap();
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("arg1");
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            map.put(next, jSONObjectOptJSONObject.optString(next));
                        }
                    }
                    aVar.s = map;
                }
                return aVar;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private o() {
    }

    public static o a() {
        if (f23764a == null) {
            f23764a = new o();
        }
        return f23764a;
    }

    @Override // com.alibaba.analytics.core.a.l
    public void o(String str) {
        super.o(str);
    }

    @Override // com.alibaba.analytics.core.a.l
    public synchronized void a(String str, Map<String, String> map) {
        a aVarA;
        this.r.clear();
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            if (str3 != null && (aVarA = a.a(str3)) != null) {
                this.r.put(str2, aVarA);
            }
        }
    }

    @Override // com.alibaba.analytics.core.a.l
    /* JADX INFO: renamed from: a */
    public String[] mo100a() {
        return new String[]{"ut_stream"};
    }
}
