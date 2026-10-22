package com.alibaba.analytics.core.a;

import com.alibaba.analytics.core.model.LogField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static n f23762a;
    private Map<String, a> p = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Random f23763a = new Random();
        private int f = 0;
        private Map<String, Integer> q = new HashMap();

        private a() {
        }

        private boolean a(int i) {
            return i != 0 && f23763a.nextInt(10000) < i;
        }

        private boolean d(String str) {
            if (str != null) {
                try {
                    for (String str2 : this.q.keySet()) {
                        if (str2.startsWith("%") && str2.endsWith("%")) {
                            if (str.contains(str2.substring(1, str2.length() - 1))) {
                                return a(this.q.get(str2).intValue());
                            }
                        } else if (str.equals(str2)) {
                            return a(this.q.get(str2).intValue());
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            return a(this.f);
        }

        public boolean c(String str) {
            return d(str);
        }

        public static a a(String str) {
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(com.alipay.sdk.m.m.b.m)) {
                    aVar.f = jSONObject.optInt(com.alipay.sdk.m.m.b.m);
                }
                if (jSONObject.has("arg1")) {
                    HashMap map = new HashMap();
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("arg1");
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            map.put(next, Integer.valueOf(Integer.parseInt(jSONObjectOptJSONObject.optString(next))));
                        }
                    }
                    aVar.q = map;
                }
                return aVar;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static class b {
        private boolean D;
        private boolean E;

        private b() {
            this.D = false;
            this.E = false;
        }

        public void e(boolean z) {
            this.D = z;
        }

        public void f(boolean z) {
            this.E = z;
        }

        public boolean getResult() {
            return this.D;
        }

        public boolean q() {
            return this.E;
        }
    }

    private n() {
    }

    public static n a() {
        if (f23762a == null) {
            f23762a = new n();
        }
        return f23762a;
    }

    public synchronized boolean b(Map<String, String> map) {
        try {
        } catch (Exception e) {
            com.alibaba.analytics.a.j.e("UTSampleConfBiz", e, new Object[0]);
            return false;
        }
        return m105a(Integer.parseInt(map.get(LogField.EVENTID.toString())), map.get(LogField.ARG1.toString()));
    }

    @Override // com.alibaba.analytics.core.a.l
    public void o(String str) {
        super.o(str);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized boolean m105a(int i, String str) {
        if (com.alibaba.analytics.core.d.a().m120j()) {
            return true;
        }
        if (this.p.size() == 0) {
            return true;
        }
        b bVarA = a(i, str);
        if (bVarA.getResult()) {
            return true;
        }
        if (bVarA.q()) {
            return false;
        }
        b bVarA2 = a(i - (i % 10), str);
        if (bVarA2.getResult()) {
            return true;
        }
        if (bVarA2.q()) {
            return false;
        }
        b bVarA3 = a(i - (i % 100), str);
        if (bVarA3.getResult()) {
            return true;
        }
        if (bVarA3.q()) {
            return false;
        }
        b bVarA4 = a(i - (i % 1000), str);
        if (bVarA4.getResult()) {
            return true;
        }
        if (bVarA4.q()) {
            return false;
        }
        b bVarA5 = a(-1, str);
        if (bVarA5.getResult()) {
            return true;
        }
        return bVarA5.q() ? false : false;
    }

    private b a(int i, String str) {
        String strValueOf = String.valueOf(i);
        b bVar = new b();
        if (this.p.containsKey(strValueOf)) {
            a aVar = this.p.get(strValueOf);
            bVar.f(true);
            bVar.e(aVar.c(str));
            return bVar;
        }
        bVar.e(false);
        return bVar;
    }

    @Override // com.alibaba.analytics.core.a.l
    public synchronized void a(String str, Map<String, String> map) {
        a aVarA;
        this.p.clear();
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            if (str3 != null && (aVarA = a.a(str3)) != null) {
                this.p.put(str2, aVarA);
            }
        }
    }

    @Override // com.alibaba.analytics.core.a.l
    /* JADX INFO: renamed from: a */
    public String[] mo100a() {
        return new String[]{"ut_sample"};
    }
}
