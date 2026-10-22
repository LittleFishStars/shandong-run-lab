package com.alibaba.analytics.core.a;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static m f23761a;
    private Map<String, a> m = new HashMap();
    private int b = 10;
    private int c = 0;
    private int d = -1;

    public static class a {
        private Map<String, String> n = new HashMap();
        private Map<String, String> o = new HashMap();
        private int e = 0;

        private a() {
        }

        public static a a(String str) {
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(RVParams.TITLE_PENETRATE)) {
                    aVar.e = m.a(jSONObject.optString(RVParams.TITLE_PENETRATE));
                }
                if (jSONObject.has("pg")) {
                    HashMap map = new HashMap();
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("pg");
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            map.put(next, jSONObjectOptJSONObject.optString(next));
                        }
                    }
                    aVar.n = map;
                }
                if (jSONObject.has("arg1")) {
                    HashMap map2 = new HashMap();
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("arg1");
                    if (jSONObjectOptJSONObject2 != null) {
                        Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            map2.put(next2, jSONObjectOptJSONObject2.optString(next2));
                        }
                    }
                    aVar.o = map2;
                }
                return aVar;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private m() {
    }

    public static m a() {
        if (f23761a == null) {
            f23761a = new m();
        }
        return f23761a;
    }

    @Override // com.alibaba.analytics.core.a.l
    public void o(String str) {
        super.o(str);
    }

    public void x() {
        this.m.clear();
        this.b = 10;
        this.c = 0;
    }

    @Override // com.alibaba.analytics.core.a.l
    public synchronized void a(String str, Map<String, String> map) {
        com.alibaba.analytics.a.j.d("", "aGroupname", str, "aConfContent", map);
        x();
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (str2.equals("time")) {
                    int iA = a(str3);
                    if (iA >= 3 && iA <= 20) {
                        this.b = iA;
                    }
                } else if (str2.equals("sample")) {
                    int iA2 = a(str3);
                    if (iA2 >= 0 && iA2 <= 10000) {
                        this.c = iA2;
                    }
                } else {
                    a aVarA = a.a(str3);
                    if (aVarA != null) {
                        this.m.put(str2, aVarA);
                    }
                }
            }
        }
    }

    @Override // com.alibaba.analytics.core.a.l
    /* JADX INFO: renamed from: a */
    public String[] mo100a() {
        return new String[]{"ut_realtime"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            com.alibaba.analytics.a.j.d("", e);
            return 0;
        }
    }
}
