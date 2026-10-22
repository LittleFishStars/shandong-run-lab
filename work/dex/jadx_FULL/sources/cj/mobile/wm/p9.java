package cj.mobile.wm;

import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p9 {
    public static volatile p9 dexa;

    public class dexa implements k9 {
        public final /* synthetic */ m9 dexa;

        public dexa(m9 m9Var) {
            this.dexa = m9Var;
        }

        @Override // cj.mobile.wm.k9
        public void a(int i, String str) {
            m9 m9Var = this.dexa;
            if (m9Var != null) {
                m9Var.a(i, str);
            }
        }

        @Override // cj.mobile.wm.k9
        public void dexa(h9 h9Var) {
            m9 m9Var = this.dexa;
            if (m9Var != null) {
                m9Var.dexa(null, null, h9Var.dexa());
            }
        }
    }

    private i9 dexa(AdSlot adSlot) {
        q9 q9Var = new q9();
        q9Var.dexa(adSlot);
        return new v9().dexa(q9Var);
    }

    public static p9 dexa() {
        if (dexa == null) {
            synchronized (p9.class) {
                if (dexa == null) {
                    dexa = new p9();
                    f1.dexa("AdRequestManager", "getInstance: new sInstance = " + dexa);
                }
            }
        }
        return dexa;
    }

    public void dexa(AdSlot adSlot, m9 m9Var) {
        InsightProxy.getInstance().getNetworkProxy().dexa(dexa(adSlot), new dexa(m9Var));
    }
}
