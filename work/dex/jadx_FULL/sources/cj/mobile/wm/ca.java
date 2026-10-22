package cj.mobile.wm;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ca extends Thread {
    public final BlockingQueue<com.wangmai.insightvision.openadsdk.j.j.m<?>> dexa;
    public final ba dexb;
    public final w9 dexc;
    public final ga dexd;
    public volatile boolean dexe = false;

    public ca(BlockingQueue<com.wangmai.insightvision.openadsdk.j.j.m<?>> blockingQueue, ba baVar, w9 w9Var, ga gaVar) {
        this.dexa = blockingQueue;
        this.dexb = baVar;
        this.dexc = w9Var;
        this.dexd = gaVar;
    }

    private void dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, com.wangmai.insightvision.openadsdk.j.j.t tVar) {
        this.dexd.dexa(mVar, mVar.dexb(tVar));
    }

    private void dexb() {
        dexa(this.dexa.take());
    }

    @TargetApi(14)
    private void dexb(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar) {
        TrafficStats.setThreadStatsTag(mVar.dexn());
    }

    public void dexa() {
        this.dexe = true;
        interrupt();
    }

    public void dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        mVar.dexa(3);
        try {
            try {
                mVar.dexa("network-queue-take");
                if (mVar.dexq()) {
                    mVar.dexb("network-discard-cancelled");
                    mVar.dexs();
                    mVar.dexa(4);
                    return;
                }
                dexb(mVar);
                da daVarDexa = this.dexb.dexa(mVar);
                mVar.dexa("network-http-complete");
                if (daVarDexa.dexe && mVar.dexp()) {
                    mVar.dexb("not-modified");
                    mVar.dexs();
                    mVar.dexa(4);
                } else {
                    fa<?> faVarDexa = mVar.dexa(daVarDexa);
                    mVar.dexa("network-parse-complete");
                    mVar.dexr();
                    this.dexd.dexa(mVar, faVarDexa);
                    mVar.dexa(faVarDexa);
                    mVar.dexa(4);
                }
            } catch (Exception e) {
                ia.dexa(e, "Unhandled exception %s", e.toString());
                com.wangmai.insightvision.openadsdk.j.j.t tVar = new com.wangmai.insightvision.openadsdk.j.j.t(e);
                tVar.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                this.dexd.dexa(mVar, tVar);
                mVar.dexs();
            } catch (com.wangmai.insightvision.openadsdk.j.j.t e2) {
                e2.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                dexa(mVar, e2);
                mVar.dexs();
            }
        } catch (Throwable th) {
            mVar.dexa(4);
            throw th;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                dexb();
            } catch (InterruptedException unused) {
                if (this.dexe) {
                    Thread.currentThread().interrupt();
                    return;
                }
                ia.dexc("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
