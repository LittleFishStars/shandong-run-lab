package com.alibaba.analytics.core.f;

import android.util.Log;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.w;
import com.alibaba.analytics.a.x;
import com.alibaba.analytics.core.selfmonitor.f;
import com.alibaba.analytics.core.selfmonitor.g;
import com.alibaba.fastjson.JSON;
import com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements com.alibaba.appmonitor.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f23782a = new d();
    public static g mMonitor = new g();
    private static int u = 0;
    private static final Object c = new Object();
    private List<com.alibaba.analytics.core.model.a> g = new CopyOnWriteArrayList();
    private List<com.alibaba.analytics.core.f.a> h = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private ScheduledFuture f654c = null;
    private ScheduledFuture d = null;
    private ScheduledFuture e = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private Runnable f653c = new Runnable() { // from class: com.alibaba.analytics.core.f.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.store();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.analytics.core.f.b f652a = new com.alibaba.analytics.core.f.c(com.alibaba.analytics.core.d.a().getContext());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iA;
            j.d();
            int iC = d.this.c();
            if (iC > 0) {
                d.mMonitor.a(f.a(f.j, "time_ex", Double.valueOf(iC)));
            }
            int iCount = d.this.f652a.count();
            if (iCount <= 9000 || (iA = d.this.a(iCount)) <= 0) {
                return;
            }
            d.mMonitor.a(f.a(f.j, "count_ex", Double.valueOf(iA)));
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.d("LogStoreMgr", "CleanLogTask");
            int iCount = d.this.f652a.count();
            if (iCount > 9000) {
                d.this.a(iCount);
            }
        }
    }

    public class c implements Runnable {
        private int min = 0;

        public c() {
        }

        public c a(int i) {
            this.min = i;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int iCount = d.this.f652a.count();
                double dA = d.this.f652a.a();
                double dB = w.b();
                HashMap map = new HashMap();
                map.put(MoreDistanceDialog.VALUE_MIN, Integer.valueOf(this.min));
                map.put("dbLeft", Integer.valueOf(iCount));
                map.put("dbFileSize", Double.valueOf(dA));
                map.put("freeSize", Double.valueOf(dB));
                d.mMonitor.a(f.a(f.m, JSON.toJSONString(map), Double.valueOf(1.0d)));
            } catch (Throwable unused) {
            }
        }
    }

    private d() {
        x.a().submit(new a());
        com.alibaba.appmonitor.a.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        j.d();
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -3);
        return this.f652a.a("time", String.valueOf(calendar.getTimeInMillis()));
    }

    @Override // com.alibaba.appmonitor.a.b.a
    public void B() {
        this.f654c = x.a().schedule(null, this.f653c, 0L);
        this.d = x.a().schedule(this.d, new c().a(1), 60000L);
        this.e = x.a().schedule(this.e, new c().a(30), 1800000L);
    }

    @Override // com.alibaba.appmonitor.a.b.a
    public void C() {
    }

    public void b(com.alibaba.analytics.core.model.a aVar) {
        a(aVar);
        store();
    }

    public long count() {
        j.d("LogStoreMgr", "[count] memory count:", Integer.valueOf(this.g.size()), " db count:", Integer.valueOf(this.f652a.count()));
        return this.f652a.count() + this.g.size();
    }

    public int delete(List<com.alibaba.analytics.core.model.a> list) {
        return this.f652a.delete(list);
    }

    public long f() {
        return this.f652a.count();
    }

    public List<com.alibaba.analytics.core.model.a> get(int i) {
        return this.f652a.get(i);
    }

    public synchronized void store() {
        ArrayList arrayList;
        try {
            synchronized (this.g) {
                if (this.g.size() > 0) {
                    arrayList = new ArrayList(this.g);
                    this.g.clear();
                } else {
                    arrayList = null;
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                this.f652a.a(arrayList);
                b(1, arrayList.size());
            }
        } catch (Throwable th) {
            Log.w("LogStoreMgr", "", th);
        }
    }

    public void updateLogPriority(List<com.alibaba.analytics.core.model.a> list) {
        this.f652a.updateLogPriority(list);
    }

    public void b(com.alibaba.analytics.core.f.a aVar) {
        this.h.remove(aVar);
    }

    public static d a() {
        return f23782a;
    }

    private void b(int i, int i2) {
        for (int i3 = 0; i3 < this.h.size(); i3++) {
            com.alibaba.analytics.core.f.a aVar = this.h.get(i3);
            if (aVar != null) {
                if (i == 1) {
                    aVar.a(i2, f());
                } else if (i == 2) {
                    aVar.b(i2, f());
                }
            }
        }
    }

    public void a(com.alibaba.analytics.core.model.a aVar) {
        if (j.isDebug()) {
            j.i("LogStoreMgr", com.ipd.dsp.internal.h1.a.f38319a, aVar.getContent());
        }
        this.g.add(aVar);
        if (this.g.size() < 45 && !com.alibaba.analytics.core.d.a().m122k()) {
            ScheduledFuture scheduledFuture = this.f654c;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.f654c = x.a().schedule(this.f654c, this.f653c, 5000L);
            }
        } else {
            this.f654c = x.a().schedule(null, this.f653c, 0L);
        }
        synchronized (c) {
            int i = u + 1;
            u = i;
            if (i > 5000) {
                u = 0;
                x.a().submit(new b());
            }
        }
    }

    public void a(com.alibaba.analytics.core.f.a aVar) {
        this.h.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        j.d("LogStoreMgr", "clearOldLogByCount", Integer.valueOf(i > 9000 ? this.f652a.a((i - 9000) + 1000) : 0));
        return i;
    }
}
