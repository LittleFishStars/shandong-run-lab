package com.alibaba.appmonitor.b;

import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.x;
import com.alibaba.appmonitor.event.EventType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements com.alibaba.analytics.core.a.d.a, com.alibaba.analytics.core.selfmonitor.c, com.alibaba.appmonitor.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f23800a = new d();
    private List<c> l = Collections.synchronizedList(new ArrayList());
    private List<c> m = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    private List<c> f672n = Collections.synchronizedList(new ArrayList());
    private List<com.alibaba.appmonitor.model.a> o = Collections.synchronizedList(new ArrayList());
    private long n = -2;
    private ScheduledFuture c = null;
    private ScheduledFuture h = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Runnable f671a = new Runnable() { // from class: com.alibaba.appmonitor.b.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.store();
        }
    };
    private Runnable d = new Runnable() { // from class: com.alibaba.appmonitor.b.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.Y();
        }
    };

    /* JADX INFO: renamed from: com.alibaba.appmonitor.b.d$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] e;

        static {
            int[] iArr = new int[EventType.values().length];
            e = iArr;
            try {
                iArr[EventType.ALARM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                e[EventType.COUNTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                e[EventType.STAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.ab();
            d.this.aa();
            d.this.ac();
        }
    }

    private d() {
        com.alibaba.appmonitor.a.b.a(this);
        com.alibaba.analytics.core.selfmonitor.b.a().a(this);
        com.alibaba.analytics.core.a.d.a().a("offline_duration", this);
        x.a().submit(new a());
        Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        EventType[] eventTypeArr;
        int i;
        j.d();
        EventType[] eventTypeArrValues = EventType.values();
        int length = eventTypeArrValues.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            EventType eventType = eventTypeArrValues[i3];
            while (true) {
                List<? extends c> listA = a(eventType, 500);
                Object[] objArr = new Object[4];
                objArr[i2] = "type";
                objArr[1] = eventType;
                int i4 = 2;
                objArr[2] = "events.size()";
                int i5 = 3;
                objArr[3] = Integer.valueOf(listA.size());
                j.d((String) null, objArr);
                if (listA.size() == 0) {
                    break;
                }
                int i6 = i2;
                while (i6 < listA.size()) {
                    int i7 = AnonymousClass3.e[eventType.ordinal()];
                    if (i7 == 1) {
                        eventTypeArr = eventTypeArrValues;
                        i = length;
                        com.alibaba.appmonitor.b.a aVar = (com.alibaba.appmonitor.b.a) listA.get(i6);
                        if (aVar.y()) {
                            com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), aVar.module, aVar.monitorPoint, aVar.aT, Long.valueOf(aVar.m), aVar.aj, aVar.ak);
                        } else {
                            com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), aVar.module, aVar.monitorPoint, aVar.aT, aVar.bj, aVar.bk, Long.valueOf(aVar.m), aVar.aj, aVar.ak);
                        }
                    } else if (i7 != i4) {
                        if (i7 == i5) {
                            e eVar = (e) listA.get(i6);
                            com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), eVar.module, eVar.monitorPoint, eVar.m140b(), eVar.b());
                        }
                        eventTypeArr = eventTypeArrValues;
                        i = length;
                    } else {
                        b bVar = (b) listA.get(i6);
                        eventTypeArr = eventTypeArrValues;
                        i = length;
                        com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), bVar.module, bVar.monitorPoint, bVar.aT, bVar.value, Long.valueOf(bVar.m), bVar.aj, bVar.ak);
                    }
                    i6++;
                    eventTypeArrValues = eventTypeArr;
                    length = i;
                    i4 = 2;
                    i5 = 3;
                }
                e(listA);
                i2 = 0;
            }
        }
    }

    private void Z() {
        long duration = getDuration();
        if (this.n != duration) {
            this.n = duration;
            this.h = x.a().a(this.h, this.d, this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        m139a(b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab() {
        m139a(com.alibaba.appmonitor.b.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac() {
        m139a(e.class);
    }

    private void e(List<? extends c> list) {
        com.alibaba.analytics.core.d.a().m112a().delete(list);
    }

    private long getDuration() {
        int i;
        int i2 = com.alibaba.analytics.core.a.d.a().getInt("offline_duration");
        if (i2 <= 0) {
            i = 21600000;
        } else {
            i = i2 <= 3600 ? 3600000 : i2 * 1000;
        }
        return i;
    }

    @Override // com.alibaba.appmonitor.a.b.a
    public void B() {
        j.d();
        this.c = x.a().schedule(null, this.f671a, 0L);
    }

    @Override // com.alibaba.appmonitor.a.b.a
    public void C() {
    }

    public void store() {
        j.d();
        c(this.l);
        c(this.m);
        c(this.f672n);
        d(this.o);
    }

    public static d a() {
        return f23800a;
    }

    private void c(List<?> list) {
        ArrayList arrayList;
        if (list != null && list.size() > 0) {
            synchronized (list) {
                arrayList = new ArrayList(list);
                list.clear();
            }
            com.alibaba.analytics.core.d.a().m112a().insert(arrayList);
        }
    }

    private void d(List<com.alibaba.appmonitor.model.a> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (list) {
            for (int i = 0; i < list.size(); i++) {
                com.alibaba.appmonitor.model.a aVar = list.get(i);
                com.alibaba.appmonitor.model.a aVarA = a(aVar.getModule(), aVar.H());
                if (aVarA != null) {
                    aVar._id = aVarA._id;
                    arrayList.add(aVar);
                } else {
                    arrayList2.add(aVar);
                }
            }
            list.clear();
        }
        if (arrayList.size() > 0) {
            com.alibaba.analytics.core.d.a().m112a().update(arrayList);
        }
        if (arrayList2.size() > 0) {
            com.alibaba.analytics.core.d.a().m112a().insert(arrayList2);
        }
    }

    public void a(EventType eventType, c cVar) {
        j.d();
        if (EventType.ALARM == eventType) {
            this.l.add(cVar);
        } else if (EventType.COUNTER == eventType) {
            this.m.add(cVar);
        } else if (EventType.STAT == eventType) {
            this.f672n.add(cVar);
        }
        if (this.l.size() < 100 && this.m.size() < 100 && this.f672n.size() < 100) {
            ScheduledFuture scheduledFuture = this.c;
            if (scheduledFuture == null || (scheduledFuture != null && scheduledFuture.isDone())) {
                this.c = x.a().schedule(this.c, this.f671a, 30000L);
                return;
            }
            return;
        }
        this.c = x.a().schedule(null, this.f671a, 0L);
    }

    @Override // com.alibaba.analytics.core.a.d.a
    public void c(String str, String str2) {
        if ("offline_duration".equalsIgnoreCase(str)) {
            Z();
        }
    }

    public void a(com.alibaba.appmonitor.model.a aVar) {
        j.d();
        if (aVar != null) {
            this.o.add(aVar);
        }
        if (this.o.size() >= 100) {
            this.c = x.a().schedule(null, this.f671a, 0L);
        } else {
            this.c = x.a().schedule(this.c, this.f671a, 30000L);
        }
    }

    public com.alibaba.appmonitor.model.a a(String str, String str2) {
        List<? extends com.alibaba.analytics.core.b.b> listFind = com.alibaba.analytics.core.d.a().m112a().find(com.alibaba.appmonitor.model.a.class, "module=\"" + str + "\" and monitor_point=\"" + str2 + "\"", null, 1);
        if (listFind == null || listFind.size() <= 0) {
            return null;
        }
        return (com.alibaba.appmonitor.model.a) listFind.get(0);
    }

    public List<? extends c> a(EventType eventType, int i) {
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - (getDuration() / 1000);
        return com.alibaba.analytics.core.d.a().m112a().find(a(eventType), "commit_time<" + jCurrentTimeMillis, "access,sub_access,module,monitor_point", i);
    }

    private Class<? extends com.alibaba.analytics.core.b.b> a(EventType eventType) {
        if (EventType.ALARM == eventType) {
            return com.alibaba.appmonitor.b.a.class;
        }
        if (EventType.COUNTER == eventType) {
            return b.class;
        }
        if (EventType.STAT == eventType) {
            return e.class;
        }
        return c.class;
    }

    @Override // com.alibaba.analytics.core.selfmonitor.c
    public void a(Thread thread, Throwable th) {
        j.d();
        store();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m139a(Class<? extends com.alibaba.analytics.core.b.b> cls) {
        a(cls);
        if (com.alibaba.analytics.core.d.a().m112a().count(cls) > 50000) {
            a(cls, 10000);
        }
    }

    private long a(Class<? extends com.alibaba.analytics.core.b.b> cls, int i) {
        String tablename = com.alibaba.analytics.core.d.a().m112a().getTablename(cls);
        return com.alibaba.analytics.core.d.a().m112a().delete(cls, " _id in ( select _id from " + tablename + "  ORDER BY  _id ASC LIMIT " + i + " )", null);
    }

    private int a(Class<? extends com.alibaba.analytics.core.b.b> cls) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -7);
        long timeInMillis = calendar.getTimeInMillis() / 1000;
        return com.alibaba.analytics.core.d.a().m112a().delete(cls, "commit_time< " + timeInMillis, null);
    }
}
