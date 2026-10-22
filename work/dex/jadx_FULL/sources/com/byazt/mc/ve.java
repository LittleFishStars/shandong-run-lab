package com.byazt.mc;

import com.byazt.bwm.i;
import com.byazt.dna.z;
import com.byazt.nr.m;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1001, 54})
public class ve implements Comparable<ve>, Runnable {
    public static final AtomicInteger c = new AtomicInteger(0);
    public static boolean tt = false;
    public a uj;
    public final Runnable ve;
    public long x;
    public boolean n = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28786a = true;
    public final long sp = System.currentTimeMillis();
    public int i = 0;
    public int da = 0;

    public ve(Runnable runnable) {
        this.ve = runnable;
    }

    private void ve(boolean z) {
        a aVar = this.uj;
        if (aVar != null) {
            aVar.c(this, z);
        }
    }

    public void c(a aVar) {
        this.uj = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        int i2;
        long j2;
        i iVar = i.tt;
        boolean zGt = iVar.gt();
        if (zGt) {
            int activeCount = iVar.i().getActiveCount();
            int activeCount2 = iVar.da().getActiveCount();
            long jCurrentTimeMillis = System.currentTimeMillis();
            i = activeCount;
            i2 = activeCount2;
            j2 = jCurrentTimeMillis;
            j = (jCurrentTimeMillis - this.x) - this.sp;
        } else {
            j = 0;
            i = 0;
            i2 = 0;
            j2 = 0;
        }
        this.ve.run();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - j2;
        if (!this.n && this.i == 2) {
            c.decrementAndGet();
        }
        ve(false);
        if (zGt) {
            if (c(j) || jCurrentTimeMillis2 > iVar.my()) {
                z zVar = (z) com.byazt.ut.uj.getService("event");
                if (zVar == null) {
                    m.tt("BizRunnable", "IEvent service is null");
                } else {
                    c(j, jCurrentTimeMillis2, "", 0, i, i2, zVar);
                }
            }
        }
    }

    public void tt() {
        this.x = System.currentTimeMillis() - this.sp;
    }

    public int uj() {
        return this.i;
    }

    public Runnable c() {
        return this.ve;
    }

    public void tt(boolean z) {
        this.f28786a = z;
    }

    private boolean c(long j) {
        if (this.da == 1) {
            return j > i.tt.nu();
        }
        return j > i.tt.rh();
    }

    public boolean ve() {
        return this.f28786a;
    }

    private void c(long j, long j2, String str, int i, int i2, int i3, z zVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("create_time", this.sp);
            jSONObject.put("is_wrap", this.ve instanceof ve);
            jSONObject.put("is_oom", tt);
            jSONObject.put("pool_wait_time", j);
            jSONObject.put("priority", i);
            jSONObject.put("wait_in_queue", this.x);
            jSONObject.put("pool_type", this.i);
            jSONObject.put("origin_pool_type", this.da);
            jSONObject.put("run_cost", j2);
            jSONObject.put("task_name", str);
            jSONObject.put(CrashHianalyticsData.THREAD_NAME, Thread.currentThread().getName());
            i iVar = i.tt;
            jSONObject.put("little_active_count", i2);
            jSONObject.put("big_active_count", i3);
            jSONObject.put("is_crash", iVar.yp());
            jSONObject.put("auto_size", i.uj);
            jSONObject.put("pri_task_in_little", c.get());
            jSONObject.put("core_count", iVar.x());
            jSONObject.put("max_pool_size", iVar.sl());
            jSONObject.put("use_little_pool", iVar.m());
        } catch (Exception unused) {
        }
        zVar.onStatsEvent("task_run_cost", jSONObject);
    }

    public ve(Runnable runnable, a aVar) {
        this.ve = runnable;
        this.uj = aVar;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(ve veVar) {
        Class<?> cls = this.ve.getClass();
        Class<?> cls2 = veVar.ve.getClass();
        if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
            return 0;
        }
        Runnable runnable = this.ve;
        if (!(runnable instanceof Comparable)) {
            return 0;
        }
        Runnable runnable2 = veVar.ve;
        if (runnable2 instanceof Comparable) {
            return ((Comparable) runnable).compareTo(runnable2);
        }
        return 0;
    }

    public void c(boolean z) {
        this.n = z;
    }

    public void c(int i) {
        int i2 = this.i;
        if (i2 == 0) {
            this.da = i;
        } else {
            this.da = i2;
        }
        this.i = i;
    }
}
