package com.alibaba.appmonitor.event;

import android.text.TextUtils;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.u;
import com.alibaba.analytics.a.x;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f23803a;
    private AtomicInteger e = new AtomicInteger(0);
    private AtomicInteger f = new AtomicInteger(0);
    private AtomicInteger g = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SimpleDateFormat f675a = new SimpleDateFormat("yyyy-MM-dd");
    private Map<UTDimensionValueSet, com.alibaba.appmonitor.model.c> G = new ConcurrentHashMap();
    private Map<String, c> F = new ConcurrentHashMap();

    private e() {
    }

    public static synchronized e a() {
        if (f23803a == null) {
            f23803a = new e();
        }
        return f23803a;
    }

    private String b(String str, String str2) {
        com.alibaba.appmonitor.model.a aVarA = com.alibaba.appmonitor.model.b.a().a(str, str2);
        if (aVarA != null) {
            return aVarA.G();
        }
        return null;
    }

    private void n(String str, String str2) {
        com.alibaba.appmonitor.model.a aVarA = com.alibaba.appmonitor.model.b.a().a(str, str2);
        if (aVarA != null) {
            aVarA.X();
        }
    }

    public void U() {
        ArrayList arrayList = new ArrayList(this.F.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            c cVar = this.F.get(str);
            if (cVar != null && cVar.w()) {
                this.F.remove(str);
            }
        }
    }

    public void e(String str, String str2, String str3) {
        String strB = b(str, str2);
        if (strB != null) {
            a(strB, str3, true);
        }
    }

    public void l(int i) {
        final Map<UTDimensionValueSet, List<d>> mapM142a = m142a(i);
        x.a().submit(new Runnable() { // from class: com.alibaba.appmonitor.event.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.alibaba.appmonitor.d.a.e(mapM142a);
            }
        });
    }

    private UTDimensionValueSet a(int i, Long l, String str, String str2) {
        UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) com.alibaba.appmonitor.pool.a.a().a(UTDimensionValueSet.class, new Object[0]);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            uTDimensionValueSet.setValue(LogField.ACCESS.toString(), str);
            uTDimensionValueSet.setValue(LogField.ACCESS_SUBTYPE.toString(), str2);
        } else {
            uTDimensionValueSet.setValue(LogField.ACCESS.toString(), com.alibaba.analytics.core.e.b.getAccess(com.alibaba.analytics.core.d.a().getContext()));
            uTDimensionValueSet.setValue(LogField.ACCESS_SUBTYPE.toString(), com.alibaba.analytics.core.e.b.getAccsssSubType(com.alibaba.analytics.core.d.a().getContext()));
        }
        uTDimensionValueSet.setValue(LogField.USERID.toString(), com.alibaba.analytics.core.d.a().m123l());
        uTDimensionValueSet.setValue(LogField.USERNICK.toString(), com.alibaba.analytics.core.d.a().k());
        uTDimensionValueSet.setValue(LogField.EVENTID.toString(), String.valueOf(i));
        if (l == null) {
            l = Long.valueOf(System.currentTimeMillis() / 1000);
        }
        uTDimensionValueSet.setValue("commitDay", this.f675a.format(new Date(l.longValue() * 1000)));
        return uTDimensionValueSet;
    }

    public void a(int i, String str, String str2, String str3) {
        a(i, str, str2, str3, null, null, null);
    }

    public void a(int i, String str, String str2, String str3, Long l, String str4, String str5) {
        UTDimensionValueSet uTDimensionValueSetA = a(i, l, str4, str5);
        a aVar = (a) a(uTDimensionValueSetA, str, str2, str3, a.class);
        if (aVar != null) {
            aVar.a(l);
        }
        if (com.alibaba.analytics.core.d.a().m124l()) {
            a aVar2 = (a) com.alibaba.appmonitor.pool.a.a().a(a.class, Integer.valueOf(i), str, str2, str3);
            aVar2.a(l);
            com.alibaba.appmonitor.d.a.a(uTDimensionValueSetA, aVar2);
        }
        a(EventType.getEventType(i), this.e);
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        a(i, str, str2, str3, str4, str5, null, null, null);
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5, Long l, String str6, String str7) {
        UTDimensionValueSet uTDimensionValueSetA = a(i, l, str6, str7);
        a aVar = (a) a(uTDimensionValueSetA, str, str2, str3, a.class);
        if (aVar != null) {
            aVar.b(l);
            aVar.m(str4, str5);
        }
        if (com.alibaba.analytics.core.d.a().m124l()) {
            a aVar2 = (a) com.alibaba.appmonitor.pool.a.a().a(a.class, Integer.valueOf(i), str, str2, str3);
            aVar2.b(l);
            aVar2.m(str4, str5);
            com.alibaba.appmonitor.d.a.a(uTDimensionValueSetA, aVar2);
        }
        a(EventType.getEventType(i), this.e);
    }

    public void a(int i, String str, String str2, String str3, double d) {
        a(i, str, str2, str3, d, (Long) null, (String) null, (String) null);
    }

    public void a(int i, String str, String str2, String str3, double d, Long l, String str4, String str5) {
        UTDimensionValueSet uTDimensionValueSetA = a(i, l, str4, str5);
        b bVar = (b) a(uTDimensionValueSetA, str, str2, str3, b.class);
        if (bVar != null) {
            bVar.a(d, l);
        }
        if (com.alibaba.analytics.core.d.a().m124l()) {
            b bVar2 = (b) com.alibaba.appmonitor.pool.a.a().a(b.class, Integer.valueOf(i), str, str2, str3);
            bVar2.a(d, l);
            com.alibaba.appmonitor.d.a.a(uTDimensionValueSetA, bVar2);
        }
        a(EventType.getEventType(i), this.f);
    }

    public void a(int i, String str, String str2, MeasureValueSet measureValueSet, DimensionValueSet dimensionValueSet) {
        a(i, str, str2, measureValueSet, dimensionValueSet, (Long) null, (String) null, (String) null);
    }

    public void a(int i, String str, String str2, MeasureValueSet measureValueSet, DimensionValueSet dimensionValueSet, Long l, String str3, String str4) {
        com.alibaba.appmonitor.model.a aVarA = com.alibaba.appmonitor.model.b.a().a(str, str2);
        if (aVarA != null) {
            if (aVarA.a() != null) {
                aVarA.a().setConstantValue(dimensionValueSet);
            }
            if (aVarA.m144a() != null) {
                aVarA.m144a().setConstantValue(measureValueSet);
            }
            UTDimensionValueSet uTDimensionValueSetA = a(i, l, str3, str4);
            f fVar = (f) a(uTDimensionValueSetA, str, str2, (String) null, f.class);
            if (fVar != null) {
                fVar.a(dimensionValueSet, measureValueSet);
            }
            if (com.alibaba.analytics.core.d.a().m124l()) {
                f fVar2 = (f) com.alibaba.appmonitor.pool.a.a().a(f.class, Integer.valueOf(i), str, str2);
                fVar2.a(dimensionValueSet, measureValueSet);
                com.alibaba.appmonitor.d.a.a(uTDimensionValueSetA, fVar2);
            }
            a(EventType.getEventType(i), this.g);
            return;
        }
        j.e("metric is null,stat commit failed,please call AppMonitor.register() once before AppMonitor.STAT.commit()", new Object[0]);
    }

    public void a(Integer num, String str, String str2, String str3) {
        String strB = b(str, str2);
        if (strB != null) {
            a(strB, num, str, str2, str3);
        }
    }

    public void a(String str, Integer num, String str2, String str3, String str4) {
        c cVar;
        com.alibaba.appmonitor.model.a aVarA = com.alibaba.appmonitor.model.b.a().a(str2, str3);
        if (aVarA != null && aVarA.m144a() != null) {
            if (aVarA.m144a().getMeasure(str4) != null) {
                synchronized (c.class) {
                    cVar = this.F.get(str);
                    if (cVar == null) {
                        cVar = (c) com.alibaba.appmonitor.pool.a.a().a(c.class, num, str2, str3);
                        this.F.put(str, cVar);
                    }
                }
                cVar.N(str4);
                return;
            }
            return;
        }
        j.e("log discard!,metric is null,please call AppMonitor.register() once before Transaction.begin(measure)", new Object[0]);
    }

    public void a(String str, String str2, boolean z) {
        c cVar = this.F.get(str);
        if (cVar == null || !cVar.g(str2)) {
            return;
        }
        this.F.remove(str);
        if (z) {
            n(cVar.module, cVar.monitorPoint);
        }
        a(cVar.eventId, cVar.module, cVar.monitorPoint, cVar.m141a(), cVar.a());
        com.alibaba.appmonitor.pool.a.a().a(cVar);
    }

    public void a(String str, Integer num, String str2, String str3, DimensionValueSet dimensionValueSet) {
        c cVar;
        synchronized (c.class) {
            cVar = this.F.get(str);
            if (cVar == null) {
                cVar = (c) com.alibaba.appmonitor.pool.a.a().a(c.class, num, str2, str3);
                this.F.put(str, cVar);
            }
        }
        cVar.a(dimensionValueSet);
    }

    private d a(UTDimensionValueSet uTDimensionValueSet, String str, String str2, String str3, Class<? extends d> cls) {
        Integer eventId;
        com.alibaba.appmonitor.model.c cVar;
        if (!u.f(str) || !u.f(str2) || (eventId = uTDimensionValueSet.getEventId()) == null) {
            return null;
        }
        synchronized (this.G) {
            cVar = this.G.get(uTDimensionValueSet);
            if (cVar == null) {
                cVar = (com.alibaba.appmonitor.model.c) com.alibaba.appmonitor.pool.a.a().a(com.alibaba.appmonitor.model.c.class, new Object[0]);
                this.G.put(uTDimensionValueSet, cVar);
                j.d("EventRepo", "put in Map utDimensionValues", uTDimensionValueSet);
            }
        }
        return cVar.a(eventId, str, str2, str3, cls);
    }

    private void a(EventType eventType, AtomicInteger atomicInteger) {
        if (atomicInteger.incrementAndGet() >= eventType.getTriggerCount()) {
            j.d("EventRepo", eventType.toString(), " event size exceed trigger count.");
            l(eventType.getEventId());
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<UTDimensionValueSet, List<d>> m142a(int i) {
        HashMap map = new HashMap();
        synchronized (this.G) {
            Iterator<Map.Entry<UTDimensionValueSet, com.alibaba.appmonitor.model.c>> it = this.G.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<UTDimensionValueSet, com.alibaba.appmonitor.model.c> next = it.next();
                UTDimensionValueSet key = next.getKey();
                com.alibaba.appmonitor.model.c value = next.getValue();
                if (key.getEventId().intValue() == i) {
                    if (value != null) {
                        map.put(key, value.getEvents());
                    } else {
                        j.d("error", "utDimensionValues", key);
                    }
                    it.remove();
                }
            }
        }
        a(i).set(0);
        return map;
    }

    private AtomicInteger a(int i) {
        if (65501 == i) {
            return this.e;
        }
        if (65502 == i) {
            return this.f;
        }
        if (65503 == i) {
            return this.g;
        }
        return null;
    }
}
