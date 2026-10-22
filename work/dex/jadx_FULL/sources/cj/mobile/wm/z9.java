package cj.mobile.wm;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z9 implements ga {
    public final Executor dexa;

    public class dexa implements Executor {
        public final /* synthetic */ Handler dexa;

        public dexa(Handler handler) {
            this.dexa = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.dexa.post(runnable);
        }
    }

    public static class dexb implements Runnable {
        public final com.wangmai.insightvision.openadsdk.j.j.m dexa;
        public final fa dexb;
        public final Runnable dexc;

        public dexb(com.wangmai.insightvision.openadsdk.j.j.m mVar, fa faVar, Runnable runnable) {
            this.dexa = mVar;
            this.dexb = faVar;
            this.dexc = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dexa.dexq()) {
                this.dexa.dexb("canceled-at-delivery");
                return;
            }
            if (this.dexb.dexa()) {
                this.dexa.dexa(this.dexb.dexa);
            } else {
                this.dexa.dexa(this.dexb.dexc);
            }
            if (this.dexb.dexd) {
                this.dexa.dexa("intermediate-response");
            } else {
                this.dexa.dexb("done");
            }
            Runnable runnable = this.dexc;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public z9(Handler handler) {
        this.dexa = new dexa(handler);
    }

    @Override // cj.mobile.wm.ga
    public void dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, fa<?> faVar) {
        dexa(mVar, faVar, null);
    }

    public void dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, fa<?> faVar, Runnable runnable) {
        mVar.dexr();
        mVar.dexa("post-response");
        this.dexa.execute(new dexb(mVar, faVar, runnable));
    }

    @Override // cj.mobile.wm.ga
    public void dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, com.wangmai.insightvision.openadsdk.j.j.t tVar) {
        mVar.dexa("post-error");
        this.dexa.execute(new dexb(mVar, fa.dexa(tVar), null));
    }
}
