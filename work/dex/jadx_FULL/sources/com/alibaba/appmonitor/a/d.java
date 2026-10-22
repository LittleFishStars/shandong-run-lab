package com.alibaba.appmonitor.a;

import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.x;
import com.alibaba.appmonitor.event.EventType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class d implements Runnable {
    private static Map<Integer, d> A = null;
    private static boolean Y = false;
    private static HashMap<Integer, ScheduledFuture> f = new HashMap<>();
    private int L;
    private int eventId;
    private long startTime = System.currentTimeMillis();

    private d(int i, int i2) {
        this.eventId = i;
        this.L = i2;
    }

    public static void T() {
        for (EventType eventType : EventType.values()) {
            com.alibaba.appmonitor.event.e.a().l(eventType.getEventId());
        }
    }

    public static void c(int i, int i2) {
        synchronized (A) {
            d dVar = A.get(Integer.valueOf(i));
            if (dVar == null) {
                if (i2 > 0) {
                    d dVar2 = new d(i, i2 * 1000);
                    A.put(Integer.valueOf(i), dVar2);
                    f.put(Integer.valueOf(i), x.a().schedule(f.get(Integer.valueOf(i)), dVar2, dVar2.L));
                }
            } else if (i2 > 0) {
                int i3 = i2 * 1000;
                if (dVar.L != i3) {
                    dVar.L = i3;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j = ((long) dVar.L) - (jCurrentTimeMillis - dVar.startTime);
                    if (j < 0) {
                        j = 0;
                    }
                    ScheduledFuture scheduledFuture = f.get(Integer.valueOf(i));
                    x.a().schedule(scheduledFuture, dVar, j);
                    f.put(Integer.valueOf(i), scheduledFuture);
                    dVar.startTime = jCurrentTimeMillis;
                }
            } else {
                A.remove(Integer.valueOf(i));
            }
        }
    }

    public static void destroy() {
        Iterator<Integer> it = f.keySet().iterator();
        while (it.hasNext()) {
            ScheduledFuture scheduledFuture = f.get(it.next());
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                scheduledFuture.cancel(true);
            }
        }
        Y = false;
        A = null;
        f.clear();
    }

    public static void init() {
        if (Y) {
            return;
        }
        j.d("CommitTask", "init StatisticsAlarmEvent");
        A = new ConcurrentHashMap();
        for (EventType eventType : EventType.values()) {
            if (eventType.isOpen()) {
                int eventId = eventType.getEventId();
                d dVar = new d(eventId, eventType.getForegroundStatisticsInterval() * 1000);
                A.put(Integer.valueOf(eventId), dVar);
                f.put(Integer.valueOf(eventId), x.a().schedule(f.get(Integer.valueOf(eventId)), dVar, dVar.L));
            }
        }
        Y = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        j.d("CommitTask", "check&commit event", Integer.valueOf(this.eventId));
        com.alibaba.appmonitor.event.e.a().l(this.eventId);
        if (A.containsValue(this)) {
            this.startTime = System.currentTimeMillis();
            f.put(Integer.valueOf(this.eventId), x.a().schedule(f.get(Integer.valueOf(this.eventId)), this, this.L));
        }
    }
}
