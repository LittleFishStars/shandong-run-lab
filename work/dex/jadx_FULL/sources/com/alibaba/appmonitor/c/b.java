package com.alibaba.appmonitor.c;

import android.text.TextUtils;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.u;
import com.alibaba.analytics.core.a.l;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f23801a;
    private static final String[] e = {"ap_stat", "ap_counter", "ap_alarm"};
    private Map<EventType, a> K = Collections.synchronizedMap(new HashMap(3));
    private int R;

    /* JADX WARN: Multi-variable type inference failed */
    private b() {
        ad();
        for (EventType eventType : EventType.values()) {
            Class<? extends com.alibaba.analytics.core.b.b> cls = eventType.getCls();
            a aVarA = a(com.alibaba.analytics.core.d.a().m112a().find(cls, null, "module,mp ASC ", -1));
            if (aVarA == null) {
                try {
                    a aVar = (a) cls.newInstance();
                    try {
                        aVar.module = "event_type";
                        aVar.setSampling(eventType.getDefaultSampling());
                    } catch (Exception unused) {
                    }
                    aVarA = aVar;
                } catch (Exception unused2) {
                }
            }
            this.K.put(eventType, aVarA);
        }
    }

    public static b a() {
        if (f23801a == null) {
            synchronized (b.class) {
                if (f23801a == null) {
                    f23801a = new b();
                }
            }
        }
        return f23801a;
    }

    private boolean d(EventType eventType, String str, String str2) {
        if (eventType != null && eventType == EventType.COUNTER && "AppMonitor".equalsIgnoreCase(str)) {
            return "upload_traffic".equalsIgnoreCase(str2) || "tnet_request_send".equalsIgnoreCase(str2);
        }
        return false;
    }

    public void ad() {
        this.R = new Random(System.currentTimeMillis()).nextInt(10000);
    }

    public boolean b(EventType eventType, String str, String str2) {
        return b(eventType, str, str2, (Map<String, String>) null);
    }

    public boolean c(EventType eventType, String str, String str2) {
        if (d(eventType, str, str2)) {
            return true;
        }
        a aVar = this.K.get(eventType);
        if (aVar != null) {
            return aVar.f(str, str2);
        }
        return false;
    }

    public int e() {
        return this.R;
    }

    public boolean g(String str, String str2) {
        a aVar = this.K.get(EventType.STAT);
        if (aVar == null) {
            return false;
        }
        return ((e) aVar).g(str, str2);
    }

    @Override // com.alibaba.analytics.core.a.l
    public void o(String str) {
        super.o(str);
    }

    public boolean b(EventType eventType, String str, String str2, Map<String, String> map) {
        a aVar = this.K.get(eventType);
        if (aVar != null) {
            return aVar.a(this.R, str, str2, map);
        }
        j.d("eventTypeSample  ==null", new Object[0]);
        return false;
    }

    public boolean b(String str, String str2, Boolean bool, Map<String, String> map) {
        a aVar = this.K.get(EventType.ALARM);
        if (aVar == null || !(aVar instanceof c)) {
            return false;
        }
        return ((c) aVar).a(this.R, str, str2, bool, map);
    }

    public boolean a(EventType eventType, String str, String str2, Map<String, String> map) {
        return b(eventType, str, str2, map);
    }

    public boolean a(String str, String str2, Boolean bool, Map<String, String> map) {
        return b(str, str2, bool, map);
    }

    public void a(EventType eventType, int i) {
        a aVar = this.K.get(eventType);
        if (aVar != null) {
            aVar.setSampling(i);
        }
        j.d("setSampling end", new Object[0]);
    }

    private a a(Class<? extends a> cls, JSONObject jSONObject) {
        a aVar = null;
        try {
            a aVarNewInstance = cls.newInstance();
            try {
                if (jSONObject.containsKey("offline")) {
                    aVarNewInstance.bo = jSONObject.getString("offline");
                }
                if (jSONObject.containsKey(com.alipay.sdk.m.m.b.m)) {
                    aVarNewInstance.setSampling(jSONObject.getIntValue(com.alipay.sdk.m.m.b.m));
                }
                if (aVarNewInstance instanceof c) {
                    c cVar = (c) aVarNewInstance;
                    if (jSONObject.containsKey("scp")) {
                        cVar.S = jSONObject.getIntValue("scp");
                    }
                    if (jSONObject.containsKey("fcp")) {
                        cVar.T = jSONObject.getIntValue("fcp");
                    }
                    return cVar;
                }
                if (!(aVarNewInstance instanceof e)) {
                    return aVarNewInstance;
                }
                e eVar = (e) aVarNewInstance;
                if (!jSONObject.containsKey("detail")) {
                    return aVarNewInstance;
                }
                eVar.U = jSONObject.getIntValue("detail");
                return aVarNewInstance;
            } catch (Throwable unused) {
                aVar = aVarNewInstance;
                j.e("new AppMonitorConfig error", new Object[0]);
                return aVar;
            }
        } catch (Throwable unused2) {
        }
    }

    private a a(List<a> list) {
        a aVarRemove;
        int size = list.size();
        int i = 0;
        while (i < size && !"event_type".equalsIgnoreCase(list.get(i).module)) {
            i++;
        }
        if (i < size) {
            aVarRemove = list.remove(i);
            j.d("remove root element", new Object[0]);
        } else {
            j.w("cannot found the root element", new Object[0]);
            aVarRemove = null;
        }
        if (aVarRemove == null) {
            return null;
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            a aVar = list.get(i2);
            if (TextUtils.isEmpty(aVar.monitorPoint)) {
                aVarRemove.a(aVar.module, aVar);
            } else {
                aVarRemove.a(aVar.module).a(aVar.monitorPoint, aVar);
            }
        }
        return aVarRemove;
    }

    @Override // com.alibaba.analytics.core.a.l
    /* JADX INFO: renamed from: a */
    public String[] mo100a() {
        return e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.analytics.core.a.l
    public void a(String str, Map<String, String> map) {
        a aVarNewInstance;
        JSONObject object;
        j.d("", "namespace", str, "config:", map);
        if (u.isBlank(str) || map == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        EventType eventTypeByNameSpace = EventType.getEventTypeByNameSpace(str);
        Class cls = eventTypeByNameSpace.getCls();
        try {
            if (map.containsKey("event_type")) {
                aVarNewInstance = a((Class<? extends a>) cls, JSON.parseObject(map.get("event_type")));
                map.remove("event_type");
            } else {
                try {
                    aVarNewInstance = cls.newInstance();
                    if (aVarNewInstance instanceof c) {
                        c cVar = (c) aVarNewInstance;
                        cVar.S = eventTypeByNameSpace.getDefaultSampling();
                        cVar.T = eventTypeByNameSpace.getDefaultSampling();
                    } else {
                        aVarNewInstance.setSampling(eventTypeByNameSpace.getDefaultSampling());
                    }
                } catch (Throwable unused) {
                    return;
                }
            }
            aVarNewInstance.module = "event_type";
            for (String str2 : map.keySet()) {
                try {
                    object = JSON.parseObject(map.get(str2));
                } catch (Throwable th) {
                    j.e(null, th, new Object[0]);
                    object = null;
                }
                if (object != null) {
                    try {
                        a aVarA = a((Class<? extends a>) cls, object);
                        aVarA.module = str2;
                        JSONObject jSONObject = object.getJSONObject("mps");
                        if (jSONObject != null) {
                            for (String str3 : jSONObject.keySet()) {
                                a aVarA2 = a((Class<? extends a>) cls, jSONObject.getJSONObject(str3));
                                aVarA2.module = str2;
                                aVarA2.monitorPoint = str3;
                                aVarA.a(str3, aVarA2);
                                arrayList.add(aVarA2);
                            }
                        }
                        aVarNewInstance.a(str2, aVarA);
                        arrayList.add(aVarA);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
            arrayList.add(aVarNewInstance);
            this.K.put(eventTypeByNameSpace, aVarNewInstance);
            com.alibaba.analytics.core.d.a().m112a().clear((Class<? extends com.alibaba.analytics.core.b.b>) aVarNewInstance.getClass());
            com.alibaba.analytics.core.d.a().m112a().insert(arrayList);
        } catch (Throwable th3) {
            j.e("", "parse config error", th3);
        }
    }
}
