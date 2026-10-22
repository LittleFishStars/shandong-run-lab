package cj.mobile.wm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h3 implements com.wangmai.insightvision.openadsdk.image.b.n.i.i.dexa {
    public static final dexb dexq = new dexb();
    public static final Handler dexr = new Handler(Looper.getMainLooper(), new dexc());
    public final List<i8> dexa;
    public final dexb dexb;
    public final i3 dexc;
    public final r2 dexd;
    public final ExecutorService dexe;
    public final ExecutorService dexf;
    public final boolean dexg;
    public boolean dexh;
    public n3<?> dexi;
    public boolean dexj;
    public Exception dexk;
    public boolean dexl;
    public Set<i8> dexm;
    public com.wangmai.insightvision.openadsdk.image.b.n.i.i dexn;
    public l3<?> dexo;
    public volatile Future<?> dexp;

    public static class dexb {
        public <R> l3<R> dexa(n3<R> n3Var, boolean z) {
            return new l3<>(n3Var, z);
        }
    }

    public static class dexc implements Handler.Callback {
        public dexc() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (1 != i && 2 != i) {
                return false;
            }
            h3 h3Var = (h3) message.obj;
            if (1 == i) {
                h3Var.dexc();
            } else {
                h3Var.dexb();
            }
            return true;
        }
    }

    public h3(r2 r2Var, ExecutorService executorService, ExecutorService executorService2, boolean z, i3 i3Var) {
        this(r2Var, executorService, executorService2, z, i3Var, dexq);
    }

    public h3(r2 r2Var, ExecutorService executorService, ExecutorService executorService2, boolean z, i3 i3Var, dexb dexbVar) {
        this.dexa = new ArrayList();
        this.dexd = r2Var;
        this.dexe = executorService;
        this.dexf = executorService2;
        this.dexg = z;
        this.dexc = i3Var;
        this.dexb = dexbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexb() {
        if (this.dexh) {
            return;
        }
        if (this.dexa.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
        this.dexl = true;
        this.dexc.dexb(this.dexd, null);
        for (i8 i8Var : this.dexa) {
            if (!dexd(i8Var)) {
                i8Var.a(this.dexk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexc() {
        if (this.dexh) {
            this.dexi.b();
            return;
        }
        if (this.dexa.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        l3<?> l3VarDexa = this.dexb.dexa(this.dexi, this.dexg);
        this.dexo = l3VarDexa;
        this.dexj = true;
        l3VarDexa.dexa();
        this.dexc.dexb(this.dexd, this.dexo);
        for (i8 i8Var : this.dexa) {
            if (!dexd(i8Var)) {
                this.dexo.dexa();
                i8Var.dexa(this.dexo);
            }
        }
        this.dexo.dexc();
    }

    private void dexc(i8 i8Var) {
        if (this.dexm == null) {
            this.dexm = new HashSet();
        }
        this.dexm.add(i8Var);
    }

    private boolean dexd(i8 i8Var) {
        Set<i8> set = this.dexm;
        return set != null && set.contains(i8Var);
    }

    public void a(Exception exc) {
        this.dexk = exc;
        dexr.obtainMessage(2, this).sendToTarget();
    }

    public void dexa() {
        if (this.dexl || this.dexj || this.dexh) {
            return;
        }
        this.dexn.b();
        Future<?> future = this.dexp;
        if (future != null) {
            future.cancel(true);
        }
        this.dexh = true;
        this.dexc.dexa(this, this.dexd);
    }

    public void dexa(i8 i8Var) {
        e9.dexa();
        if (this.dexj) {
            i8Var.dexa(this.dexo);
        } else if (this.dexl) {
            i8Var.a(this.dexk);
        } else {
            this.dexa.add(i8Var);
        }
    }

    public void dexa(n3<?> n3Var) {
        this.dexi = n3Var;
        dexr.obtainMessage(1, this).sendToTarget();
    }

    public void dexa(com.wangmai.insightvision.openadsdk.image.b.n.i.i iVar) {
        this.dexp = this.dexf.submit((Runnable) iVar);
    }

    public void dexb(i8 i8Var) {
        e9.dexa();
        if (this.dexj || this.dexl) {
            dexc(i8Var);
            return;
        }
        this.dexa.remove(i8Var);
        if (this.dexa.isEmpty()) {
            dexa();
        }
    }

    public void dexb(com.wangmai.insightvision.openadsdk.image.b.n.i.i iVar) {
        this.dexn = iVar;
        this.dexp = this.dexe.submit((Runnable) iVar);
    }
}
