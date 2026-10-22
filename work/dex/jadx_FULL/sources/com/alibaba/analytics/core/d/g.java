package com.alibaba.analytics.core.d;

import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.x;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g implements com.alibaba.appmonitor.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f23776a = new g();
    private static long c = 300000;
    private long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private ScheduledFuture f648b = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final AtomicInteger f649b = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private final AtomicInteger f650c = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Runnable f647b = new Runnable() { // from class: com.alibaba.analytics.core.d.g.1
        @Override // java.lang.Runnable
        public void run() {
            g.this.b = System.currentTimeMillis();
            g.this.f649b.set(0);
            g.this.f650c.set(0);
        }
    };

    private g() {
        this.b = System.currentTimeMillis();
        this.b = System.currentTimeMillis();
        com.alibaba.appmonitor.a.b.a(this);
    }

    @Override // com.alibaba.appmonitor.a.b.a
    public void B() {
        j.d();
        this.f648b = x.a().schedule(this.f648b, this.f647b, c);
    }

    @Override // com.alibaba.appmonitor.a.b.a
    public void C() {
        ScheduledFuture scheduledFuture = this.f648b;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            return;
        }
        this.f648b.cancel(true);
    }

    public long c() {
        return this.f649b.incrementAndGet();
    }

    public long d() {
        return this.f650c.incrementAndGet();
    }

    public long b() {
        return this.b;
    }

    public static g a() {
        return f23776a;
    }
}
