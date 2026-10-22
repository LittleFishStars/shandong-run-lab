package com.alibaba.analytics.core.a;

import android.text.TextUtils;
import com.alibaba.analytics.core.model.LogField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f23754a;
    private final Map<String, String> g = Collections.synchronizedMap(new HashMap());
    private final Map<String, List<a>> h = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final String[] f627a = {"utap_system"};
    private final Map<String, b> i = new HashMap();

    public interface a {
        void c(String str, String str2);
    }

    private d() {
        try {
            if (com.alibaba.analytics.core.d.a().m112a() != null) {
                List<? extends com.alibaba.analytics.core.b.b> listFind = com.alibaba.analytics.core.d.a().m112a().find(c.class, null, null, -1);
                if (listFind.size() > 0) {
                    Map<String, String> mapSynchronizedMap = Collections.synchronizedMap(new HashMap(listFind.size()));
                    for (int i = 0; i < listFind.size(); i++) {
                        mapSynchronizedMap.put(((c) listFind.get(i)).H, ((c) listFind.get(i)).value);
                    }
                    c(mapSynchronizedMap);
                }
            }
        } catch (Throwable th) {
            com.alibaba.analytics.a.j.e(null, th, new Object[0]);
        }
    }

    public static synchronized d a() {
        if (f23754a == null) {
            f23754a = new d();
        }
        return f23754a;
    }

    private void c(Map<String, String> map) {
        d(map);
        HashMap map2 = new HashMap(this.g.size());
        map2.putAll(this.g);
        this.g.clear();
        this.g.putAll(map);
        for (String str : this.g.keySet()) {
            if ((this.g.get(str) == null && map2.get(str) != null) || (this.g.get(str) != null && !this.g.get(str).equalsIgnoreCase((String) map2.get(str)))) {
                d(str, this.g.get(str));
            }
            map2.remove(str);
        }
        for (String str2 : map2.keySet()) {
            d(str2, this.g.get(str2));
        }
    }

    private void d(String str, String str2) {
        List<a> list = this.h.get(str);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).c(str, str2);
            }
        }
        h.f(str, str2);
    }

    public String get(String str) {
        return this.g.get(str);
    }

    public int getInt(String str) {
        String str2 = get(str);
        if (!TextUtils.isEmpty(str2)) {
            try {
                return Integer.valueOf(str2).intValue();
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public void a(String str, a aVar) {
        List<a> arrayList;
        synchronized (this.h) {
            if (this.h.get(str) == null) {
                arrayList = new ArrayList<>();
            } else {
                arrayList = this.h.get(str);
            }
            arrayList.add(aVar);
            this.h.put(str, arrayList);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0073 A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #1 {all -> 0x0078, blocks: (B:4:0x0003, B:7:0x000c, B:9:0x0016, B:11:0x002c, B:13:0x0030, B:14:0x003b, B:18:0x0048, B:20:0x004e, B:22:0x005e, B:24:0x0064, B:27:0x006b, B:28:0x006f, B:30:0x0073), top: B:38:0x0003, inners: #0 }] */
    private synchronized void d(Map<String, String> map) {
        Map<String, b> map2;
        b bVarA;
        Map<String, b> map3;
        if (map != null) {
            try {
                if (map.containsKey("delay")) {
                    if ((this.g.get("delay") == null || !map.get("delay").equals(this.g.get("delay"))) && (map2 = this.i) != null) {
                        map2.clear();
                        try {
                            JSONObject jSONObject = new JSONObject(map.get("delay"));
                            Iterator<String> itKeys = jSONObject.keys();
                            if (itKeys == null) {
                                return;
                            }
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                String string = jSONObject.getString(next);
                                if (!TextUtils.isEmpty(string) && (bVarA = b.a(string)) != null) {
                                    this.i.put(next, bVarA);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    map3 = this.i;
                    if (map3 != null) {
                        map3.clear();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            map3 = this.i;
            if (map3 != null) {
                map3.clear();
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f23755a = -1;
        private List<String> b = new ArrayList();

        private b() {
        }

        public static b a(String str) {
            try {
                b bVar = new b();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("all_d")) {
                    bVar.f23755a = jSONObject.optInt("all_d", -1);
                }
                if (jSONObject.has("arg1")) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = jSONObject.getJSONArray("arg1");
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.getString(i));
                        }
                    }
                    bVar.b = arrayList;
                }
                return bVar;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        private boolean b(String str) {
            if (!TextUtils.isEmpty(str) && this.b != null) {
                for (int i = 0; i < this.b.size(); i++) {
                    String str2 = this.b.get(i);
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.length() > 2 && str2.startsWith("%") && str2.endsWith("%")) {
                            if (str.contains(str2.substring(1, str2.length() - 1))) {
                                return true;
                            }
                        } else if (str.equals(str2)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m101a(String str) {
            int i = this.f23755a;
            if (i == 0) {
                return b(str);
            }
            if (1 == i) {
                return !b(str);
            }
            return false;
        }
    }

    @Override // com.alibaba.analytics.core.a.l
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String[] mo100a() {
        return this.f627a;
    }

    @Override // com.alibaba.analytics.core.a.l
    public void a(String str, Map<String, String> map) {
        if ("utap_system".equalsIgnoreCase(str)) {
            c(map);
            com.alibaba.analytics.core.d.a().m112a().clear(c.class);
            com.alibaba.analytics.core.d.a().m112a().insert(a(this.g));
        }
    }

    private List<com.alibaba.analytics.core.b.b> a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (String str : map.keySet()) {
            c cVar = new c();
            cVar.H = str;
            cVar.value = map.get(str);
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized boolean m99a(Map<String, String> map) {
        int i;
        Map<String, b> map2 = this.i;
        if (map2 != null && map2.size() >= 1) {
            LogField logField = LogField.EVENTID;
            if (map.containsKey(logField.toString())) {
                try {
                    i = Integer.parseInt(map.get(logField.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                    i = -1;
                }
            } else {
                i = -1;
            }
            if (this.i.containsKey(String.valueOf(i))) {
                return a(map, i);
            }
            int i2 = i - (i % 10);
            if (this.i.containsKey(String.valueOf(i2))) {
                return a(map, i2);
            }
            int i3 = i2 - (i2 % 100);
            if (this.i.containsKey(String.valueOf(i3))) {
                return a(map, i3);
            }
            int i4 = i3 - (i3 % 1000);
            if (this.i.containsKey(String.valueOf(i4))) {
                return a(map, i4);
            }
            if (!this.i.containsKey(String.valueOf(-1))) {
                return false;
            }
            return a(map, -1);
        }
        return false;
    }

    private boolean a(Map<String, String> map, int i) {
        b bVar = this.i.get(String.valueOf(i));
        if (bVar == null) {
            return false;
        }
        LogField logField = LogField.ARG1;
        return bVar.m101a(map.containsKey(logField.toString()) ? map.get(logField.toString()) : null);
    }
}
