package com.alibaba.appmonitor.event;

import com.alibaba.analytics.a.u;
import com.alibaba.appmonitor.pool.ReuseJSONArray;
import com.alibaba.appmonitor.pool.ReuseJSONObject;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends d {
    public Map<String, String> C;
    public Map<String, Integer> D;
    public int M = 0;
    public int N = 0;

    public synchronized void a(Long l) {
        this.M++;
        super.c(l);
    }

    public synchronized void b(Long l) {
        this.N++;
        super.c(l);
    }

    @Override // com.alibaba.appmonitor.event.d, com.alibaba.appmonitor.pool.b
    public synchronized void clean() {
        super.clean();
        this.M = 0;
        this.N = 0;
        Map<String, String> map = this.C;
        if (map != null) {
            map.clear();
        }
        Map<String, Integer> map2 = this.D;
        if (map2 != null) {
            map2.clear();
        }
    }

    public synchronized void m(String str, String str2) {
        if (u.isBlank(str)) {
            return;
        }
        if (this.C == null) {
            this.C = new HashMap();
        }
        if (this.D == null) {
            this.D = new HashMap();
        }
        if (u.f(str2)) {
            int length = 100;
            if (str2.length() <= 100) {
                length = str2.length();
            }
            this.C.put(str, str2.substring(0, length));
        }
        if (this.D.containsKey(str)) {
            Map<String, Integer> map = this.D;
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        } else {
            this.D.put(str, 1);
        }
    }

    @Override // com.alibaba.appmonitor.event.d
    public synchronized JSONObject a() {
        JSONObject jSONObjectA;
        jSONObjectA = super.a();
        jSONObjectA.put("successCount", Integer.valueOf(this.M));
        jSONObjectA.put("failCount", Integer.valueOf(this.N));
        if (this.D != null) {
            JSONArray jSONArray = (JSONArray) com.alibaba.appmonitor.pool.a.a().a(ReuseJSONArray.class, new Object[0]);
            for (Map.Entry<String, Integer> entry : this.D.entrySet()) {
                JSONObject jSONObject = (JSONObject) com.alibaba.appmonitor.pool.a.a().a(ReuseJSONObject.class, new Object[0]);
                String key = entry.getKey();
                jSONObject.put("errorCode", (Object) key);
                jSONObject.put("errorCount", (Object) entry.getValue());
                if (this.C.containsKey(key)) {
                    jSONObject.put("errorMsg", (Object) this.C.get(key));
                }
                jSONArray.add(jSONObject);
            }
            jSONObjectA.put("errors", (Object) jSONArray);
        }
        return jSONObjectA;
    }
}
