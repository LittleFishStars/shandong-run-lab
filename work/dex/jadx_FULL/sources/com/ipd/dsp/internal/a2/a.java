package com.ipd.dsp.internal.a2;

import com.ipd.dsp.internal.c2.k;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f38183a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38184a = new a();
    }

    public static void a(com.ipd.dsp.internal.b2.b bVar) {
        b.f38184a.b(bVar);
    }

    public final void b(com.ipd.dsp.internal.b2.b bVar) {
        try {
            this.f38183a.execute(bVar);
        } catch (Throwable th) {
            k.e(bVar.f, "unexpected req error", th);
            if (bVar.j != null) {
                com.ipd.dsp.internal.f1.a aVarK = com.ipd.dsp.internal.f1.a.k();
                bVar.j.a(aVarK.f38306a, aVarK.b, th);
            }
        }
    }

    public a() {
        this.f38183a = Executors.newCachedThreadPool(new com.ipd.dsp.internal.y1.a("IPDDSP-ad"));
    }
}
