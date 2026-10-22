package com.ipd.dsp.internal.a2;

import com.ipd.dsp.internal.c2.k;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f38185a;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.a2.b$b, reason: collision with other inner class name */
    public static class C0858b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f38186a = new b();
    }

    public static void a(com.ipd.dsp.internal.b2.b bVar) {
        C0858b.f38186a.b(bVar);
    }

    public final void b(com.ipd.dsp.internal.b2.b bVar) {
        try {
            this.f38185a.execute(bVar);
        } catch (Throwable th) {
            k.e(bVar.f, "unexpected event error", th);
            if (bVar.j != null) {
                com.ipd.dsp.internal.f1.a aVarK = com.ipd.dsp.internal.f1.a.k();
                bVar.j.a(aVarK.f38306a, aVarK.b, th);
            }
        }
    }

    public b() {
        this.f38185a = new ThreadPoolExecutor(1, 10, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new com.ipd.dsp.internal.y1.a("IPDDSP-event"), new ThreadPoolExecutor.DiscardPolicy());
    }
}
