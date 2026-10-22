package cj.mobile.wm;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g3 implements i3, f4.dexa, l3.dexa {
    public final Map<r2, h3> dexa;
    public final k3 dexb;
    public final f4 dexc;
    public final dexa dexd;
    public final Map<r2, WeakReference<l3<?>>> dexe;
    public final o3 dexf;
    public final dexb dexg;
    public ReferenceQueue<l3<?>> dexh;

    public static class dexa {
        public final ExecutorService dexa;
        public final ExecutorService dexb;
        public final i3 dexc;

        public dexa(ExecutorService executorService, ExecutorService executorService2, i3 i3Var) {
            this.dexa = executorService;
            this.dexb = executorService2;
            this.dexc = i3Var;
        }

        public h3 dexa(r2 r2Var, boolean z) {
            return new h3(r2Var, this.dexa, this.dexb, z, this.dexc);
        }
    }

    public static class dexb implements f3.dexa {
        public final y3.dexa dexa;
        public volatile y3 dexb;

        public dexb(y3.dexa dexaVar) {
            this.dexa = dexaVar;
        }

        @Override // cj.mobile.wm.f3.dexa
        public y3 a() {
            if (this.dexb == null) {
                synchronized (this) {
                    if (this.dexb == null) {
                        this.dexb = this.dexa.a();
                    }
                    if (this.dexb == null) {
                        this.dexb = new z3();
                    }
                }
            }
            return this.dexb;
        }
    }

    public static class dexc {
        public final h3 dexa;
        public final i8 dexb;

        public dexc(i8 i8Var, h3 h3Var) {
            this.dexb = i8Var;
            this.dexa = h3Var;
        }

        public void dexa() {
            this.dexa.dexb(this.dexb);
        }
    }

    public static class dexd implements MessageQueue.IdleHandler {
        public final Map<r2, WeakReference<l3<?>>> dexa;
        public final ReferenceQueue<l3<?>> dexb;

        public dexd(Map<r2, WeakReference<l3<?>>> map, ReferenceQueue<l3<?>> referenceQueue) {
            this.dexa = map;
            this.dexb = referenceQueue;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            dexe dexeVar = (dexe) this.dexb.poll();
            if (dexeVar == null) {
                return true;
            }
            this.dexa.remove(dexeVar.dexa);
            return true;
        }
    }

    public static class dexe extends WeakReference<l3<?>> {
        public final r2 dexa;

        public dexe(r2 r2Var, l3<?> l3Var, ReferenceQueue<? super l3<?>> referenceQueue) {
            super(l3Var, referenceQueue);
            this.dexa = r2Var;
        }
    }

    public g3(f4 f4Var, y3.dexa dexaVar, ExecutorService executorService, ExecutorService executorService2) {
        this(f4Var, dexaVar, executorService, executorService2, null, null, null, null, null);
    }

    public g3(f4 f4Var, y3.dexa dexaVar, ExecutorService executorService, ExecutorService executorService2, Map<r2, h3> map, k3 k3Var, Map<r2, WeakReference<l3<?>>> map2, dexa dexaVar2, o3 o3Var) {
        this.dexc = f4Var;
        this.dexg = new dexb(dexaVar);
        this.dexe = map2 == null ? new HashMap<>() : map2;
        this.dexb = k3Var == null ? new k3() : k3Var;
        this.dexa = map == null ? new HashMap<>() : map;
        this.dexd = dexaVar2 == null ? new dexa(executorService, executorService2, this) : dexaVar2;
        this.dexf = o3Var == null ? new o3() : o3Var;
        f4Var.dexa(this);
    }

    private l3<?> dexa(r2 r2Var) {
        n3<?> n3VarDexa = this.dexc.dexa(r2Var);
        if (n3VarDexa == null) {
            return null;
        }
        return n3VarDexa instanceof l3 ? (l3) n3VarDexa : new l3<>(n3VarDexa, true);
    }

    private l3<?> dexa(r2 r2Var, boolean z) {
        l3<?> l3Var = null;
        if (!z) {
            return null;
        }
        WeakReference<l3<?>> weakReference = this.dexe.get(r2Var);
        if (weakReference != null) {
            l3Var = weakReference.get();
            if (l3Var != null) {
                l3Var.dexa();
            } else {
                this.dexe.remove(r2Var);
            }
        }
        return l3Var;
    }

    private ReferenceQueue<l3<?>> dexa() {
        if (this.dexh == null) {
            this.dexh = new ReferenceQueue<>();
            Looper.myQueue().addIdleHandler(new dexd(this.dexe, this.dexh));
        }
        return this.dexh;
    }

    public static void dexa(String str, long j, r2 r2Var) {
        Log.v(com.ipd.dsp.internal.i.k.i, str + " in " + a9.dexa(j) + "ms, key: " + r2Var);
    }

    private l3<?> dexb(r2 r2Var, boolean z) {
        if (!z) {
            return null;
        }
        l3<?> l3VarDexa = dexa(r2Var);
        if (l3VarDexa != null) {
            l3VarDexa.dexa();
            this.dexe.put(r2Var, new dexe(r2Var, l3VarDexa, dexa()));
        }
        return l3VarDexa;
    }

    public <T, Z, R> dexc dexa(r2 r2Var, int i, int i2, y2<T> y2Var, a8<T, Z> a8Var, v2<Z> v2Var, h7<Z, R> h7Var, com.wangmai.insightvision.openadsdk.image.b.i iVar, boolean z, com.wangmai.insightvision.openadsdk.image.b.n.i.b bVar, i8 i8Var) {
        e9.dexa();
        long jDexa = a9.dexa();
        j3 j3VarDexa = this.dexb.dexa(y2Var.getId(), r2Var, i, i2, a8Var.a(), a8Var.f(), v2Var, a8Var.c(), h7Var, a8Var.d());
        l3<?> l3VarDexb = dexb(j3VarDexa, z);
        if (l3VarDexb != null) {
            i8Var.dexa(l3VarDexb);
            if (Log.isLoggable(com.ipd.dsp.internal.i.k.i, 2)) {
                dexa("Loaded resource from cache", jDexa, j3VarDexa);
            }
            return null;
        }
        l3<?> l3VarDexa = dexa(j3VarDexa, z);
        if (l3VarDexa != null) {
            i8Var.dexa(l3VarDexa);
            if (Log.isLoggable(com.ipd.dsp.internal.i.k.i, 2)) {
                dexa("Loaded resource from active resources", jDexa, j3VarDexa);
            }
            return null;
        }
        h3 h3Var = this.dexa.get(j3VarDexa);
        if (h3Var != null) {
            h3Var.dexa(i8Var);
            if (Log.isLoggable(com.ipd.dsp.internal.i.k.i, 2)) {
                dexa("Added to existing load", jDexa, j3VarDexa);
            }
            return new dexc(i8Var, h3Var);
        }
        h3 h3VarDexa = this.dexd.dexa(j3VarDexa, z);
        com.wangmai.insightvision.openadsdk.image.b.n.i.i iVar2 = new com.wangmai.insightvision.openadsdk.image.b.n.i.i(h3VarDexa, new f3(j3VarDexa, i, i2, y2Var, a8Var, v2Var, h7Var, this.dexg, bVar, iVar), iVar);
        this.dexa.put(j3VarDexa, h3VarDexa);
        h3VarDexa.dexa(i8Var);
        h3VarDexa.dexb(iVar2);
        if (Log.isLoggable(com.ipd.dsp.internal.i.k.i, 2)) {
            dexa("Started new load", jDexa, j3VarDexa);
        }
        return new dexc(i8Var, h3VarDexa);
    }

    @Override // cj.mobile.wm.i3
    public void dexa(h3 h3Var, r2 r2Var) {
        e9.dexa();
        if (h3Var.equals(this.dexa.get(r2Var))) {
            this.dexa.remove(r2Var);
        }
    }

    @Override // cj.mobile.wm.f4.dexa
    public void dexa(n3<?> n3Var) {
        e9.dexa();
        this.dexf.dexa(n3Var);
    }

    @Override // cj.mobile.wm.l3.dexa
    public void dexa(r2 r2Var, l3 l3Var) {
        e9.dexa();
        this.dexe.remove(r2Var);
        if (l3Var.dexb()) {
            this.dexc.dexa(r2Var, l3Var);
        } else {
            this.dexf.dexa(l3Var);
        }
    }

    public void dexb(n3 n3Var) {
        e9.dexa();
        if (!(n3Var instanceof l3)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((l3) n3Var).dexc();
    }

    @Override // cj.mobile.wm.i3
    public void dexb(r2 r2Var, l3<?> l3Var) {
        e9.dexa();
        if (l3Var != null) {
            l3Var.dexa(r2Var, this);
            if (l3Var.dexb()) {
                this.dexe.put(r2Var, new dexe(r2Var, l3Var, dexa()));
            }
        }
        this.dexa.remove(r2Var);
    }
}
