package com.byazt.qya;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.byazt.bwm.sp;
import com.byazt.dna.u;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import com.igexin.sdk.PushConsts;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 689, 54})
public class ve {
    public final Queue<tt> c;
    public int tt;
    public final com.byazt.fn.ve uj;
    public final AtomicBoolean ve;

    @com.byazt.zqa.c(c = {0, 1, 689, 24})
    public static class c {
        public static final ve c = new ve();
    }

    public interface tt {
        void c() throws Exception;
    }

    private ve() {
        this.c = new ConcurrentLinkedQueue();
        this.ve = new AtomicBoolean(false);
        com.byazt.fn.ve veVar = new com.byazt.fn.ve() { // from class: com.byazt.qya.ve.1
            @Override // com.byazt.fn.ve
            public void onNetworkChanged(Context context, Intent intent, boolean z, int i) {
                if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
                    if (x.m().d()) {
                        ve.this.c(this);
                        return;
                    }
                    if (ve.this.tt == 0 && i != 0) {
                        ve.this.c.size();
                        ve.this.tt();
                    }
                    ve.this.tt = i;
                }
            }
        };
        this.uj = veVar;
        ((u) com.byazt.ut.uj.getService("device_info_new")).registerNetworkMonitor(veVar);
        this.tt = rh.ve(gt.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        while (!this.c.isEmpty()) {
            tt ttVarPoll = this.c.poll();
            if (ttVarPoll != null) {
                tt(ttVarPoll);
            }
        }
    }

    public static ve c() {
        return c.c;
    }

    private void tt(final tt ttVar) {
        com.byazt.bwm.n.tt(new sp("pl download retry") { // from class: com.byazt.qya.ve.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ttVar.c();
                } catch (Exception e) {
                    ve.this.c(ttVar, e);
                }
            }
        });
    }

    public void c(tt ttVar) {
        if (x.m().d()) {
            c(this.uj);
        } else {
            if (this.ve.get()) {
                m.tt("NetWorkRetryManager", "Manager is destroyed, task rejected");
                return;
            }
            this.tt = 0;
            this.c.offer(ttVar);
            this.c.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(tt ttVar, Exception exc) {
        m.tt("NetWorkRetryManager", Log.getStackTraceString(exc));
    }

    public void c(com.byazt.fn.ve veVar) {
        this.ve.set(true);
        ((u) com.byazt.ut.uj.getService("device_info_new")).removeNetworkMonitor(veVar);
        this.c.clear();
    }
}
