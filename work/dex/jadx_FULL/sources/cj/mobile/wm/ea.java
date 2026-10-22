package cj.mobile.wm;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ea {
    public final AtomicInteger dexa;
    public final Set<com.wangmai.insightvision.openadsdk.j.j.m<?>> dexb;
    public final PriorityBlockingQueue<com.wangmai.insightvision.openadsdk.j.j.m<?>> dexc;
    public final PriorityBlockingQueue<com.wangmai.insightvision.openadsdk.j.j.m<?>> dexd;
    public final w9 dexe;
    public final ba dexf;
    public final ga dexg;
    public final ca[] dexh;
    public x9 dexi;
    public final List<dexb> dexj;
    public final List<dexa> dexk;

    public interface dexa {
        void dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, int i);
    }

    @Deprecated
    public interface dexb<T> {
        void dexa(com.wangmai.insightvision.openadsdk.j.j.m<T> mVar);
    }

    public ea(w9 w9Var, ba baVar) {
        this(w9Var, baVar, 4);
    }

    public ea(w9 w9Var, ba baVar, int i) {
        this(w9Var, baVar, i, new z9(new Handler(Looper.getMainLooper())));
    }

    public ea(w9 w9Var, ba baVar, int i, ga gaVar) {
        this.dexa = new AtomicInteger();
        this.dexb = new HashSet();
        this.dexc = new PriorityBlockingQueue<>();
        this.dexd = new PriorityBlockingQueue<>();
        this.dexj = new ArrayList();
        this.dexk = new ArrayList();
        this.dexe = w9Var;
        this.dexf = baVar;
        this.dexh = new ca[i];
        this.dexg = gaVar;
    }

    public int dexa() {
        return this.dexa.incrementAndGet();
    }

    public <T> com.wangmai.insightvision.openadsdk.j.j.m<T> dexa(com.wangmai.insightvision.openadsdk.j.j.m<T> mVar) {
        mVar.dexa(this);
        synchronized (this.dexb) {
            this.dexb.add(mVar);
        }
        mVar.dexb(dexa());
        mVar.dexa("add-to-queue");
        dexa(mVar, 0);
        dexb(mVar);
        return mVar;
    }

    public void dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, int i) {
        synchronized (this.dexk) {
            Iterator<dexa> it = this.dexk.iterator();
            while (it.hasNext()) {
                it.next().dexa(mVar, i);
            }
        }
    }

    public void dexb() {
        dexc();
        for (int i = 0; i < this.dexh.length; i++) {
            ca caVar = new ca(this.dexd, this.dexf, this.dexe, this.dexg);
            this.dexh[i] = caVar;
            caVar.start();
        }
    }

    public <T> void dexb(com.wangmai.insightvision.openadsdk.j.j.m<T> mVar) {
        if (mVar.dext()) {
            this.dexc.add(mVar);
        } else {
            dexd(mVar);
        }
    }

    public void dexc() {
        if (this.dexi != null) {
            throw null;
        }
        for (ca caVar : this.dexh) {
            if (caVar != null) {
                caVar.dexa();
            }
        }
    }

    public <T> void dexc(com.wangmai.insightvision.openadsdk.j.j.m<T> mVar) {
        synchronized (this.dexb) {
            this.dexb.remove(mVar);
        }
        synchronized (this.dexj) {
            Iterator<dexb> it = this.dexj.iterator();
            while (it.hasNext()) {
                it.next().dexa(mVar);
            }
        }
        dexa(mVar, 5);
    }

    public <T> void dexd(com.wangmai.insightvision.openadsdk.j.j.m<T> mVar) {
        this.dexd.add(mVar);
    }
}
