package cj.mobile.wm;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class a4 {
    public final Map<r2, dexb> dexa = new HashMap();
    public final dexc dexb = new dexc();

    public static class dexb {
        public final Lock dexa;
        public int dexb;

        public dexb() {
            this.dexa = new ReentrantLock();
        }
    }

    public static class dexc {
        public final Queue<dexb> dexa;

        public dexc() {
            this.dexa = new ArrayDeque();
        }

        public dexb dexa() {
            dexb dexbVarPoll;
            synchronized (this.dexa) {
                dexbVarPoll = this.dexa.poll();
            }
            return dexbVarPoll == null ? new dexb() : dexbVarPoll;
        }

        public void dexa(dexb dexbVar) {
            synchronized (this.dexa) {
                if (this.dexa.size() < 10) {
                    this.dexa.offer(dexbVar);
                }
            }
        }
    }

    public void dexa(r2 r2Var) {
        dexb dexbVarDexa;
        synchronized (this) {
            dexbVarDexa = this.dexa.get(r2Var);
            if (dexbVarDexa == null) {
                dexbVarDexa = this.dexb.dexa();
                this.dexa.put(r2Var, dexbVarDexa);
            }
            dexbVarDexa.dexb++;
        }
        dexbVarDexa.dexa.lock();
    }

    public void dexb(r2 r2Var) {
        dexb dexbVar;
        int i;
        synchronized (this) {
            dexbVar = this.dexa.get(r2Var);
            if (dexbVar != null && (i = dexbVar.dexb) > 0) {
                int i2 = i - 1;
                dexbVar.dexb = i2;
                if (i2 == 0) {
                    dexb dexbVarRemove = this.dexa.remove(r2Var);
                    if (!dexbVarRemove.equals(dexbVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + dexbVar + ", but actually removed: " + dexbVarRemove + ", key: " + r2Var);
                    }
                    this.dexb.dexa(dexbVarRemove);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot release a lock that is not held, key: ");
            sb.append(r2Var);
            sb.append(", interestedThreads: ");
            sb.append(dexbVar == null ? 0 : dexbVar.dexb);
            throw new IllegalArgumentException(sb.toString());
        }
        dexbVar.dexa.unlock();
    }
}
