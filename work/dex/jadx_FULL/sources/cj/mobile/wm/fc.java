package cj.mobile.wm;

import android.content.Context;
import com.wangmai.insightvision.openadsdk.n.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class fc {
    public static final fc dexf = new fc();
    public dc dexa;
    public com.wangmai.insightvision.openadsdk.n.b dexb;
    public Context dexc;
    public final boolean dexd = false;
    public ec dexe;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexa(com.wangmai.insightvision.openadsdk.n.a aVar) {
        if ("AdSensorHelper://ON_SHAKE".equals(aVar.a())) {
            dexe();
        }
    }

    public static fc dexd() {
        return dexf;
    }

    private void dexe() {
        f1.dexa("ShakeManager", "onShake 摇一摇触发");
        dc dcVar = this.dexa;
        if (dcVar != null) {
            dcVar.a();
        }
        com.wangmai.insightvision.openadsdk.n.b bVar = this.dexb;
        if (bVar != null) {
            bVar.a();
        }
        this.dexa = null;
    }

    public void dexa() {
        com.wangmai.insightvision.openadsdk.n.b bVar = this.dexb;
        if (bVar != null) {
            bVar.g();
        }
    }

    public void dexa(Context context, dc dcVar) {
        this.dexa = dcVar;
        this.dexc = context;
        com.wangmai.insightvision.openadsdk.n.b bVar = new com.wangmai.insightvision.openadsdk.n.b(com.wangmai.insightvision.openadsdk.n.b.a.a, context, 0);
        this.dexb = bVar;
        bVar.d(this.dexe);
        this.dexb.c(new cc() { // from class: com.zj.adlib.e4b
            @Override // cj.mobile.wm.cc
            public final void dexa(a aVar) {
                this.f41346a.dexa(aVar);
            }
        });
        this.dexb.k();
    }

    public void dexa(ec ecVar) {
        this.dexe = ecVar;
    }

    public void dexb() {
        com.wangmai.insightvision.openadsdk.n.b bVar = this.dexb;
        if (bVar != null) {
            bVar.i();
        }
    }

    public void dexc() {
        com.wangmai.insightvision.openadsdk.n.b bVar = this.dexb;
        if (bVar != null) {
            bVar.a();
        }
        this.dexb = null;
    }
}
