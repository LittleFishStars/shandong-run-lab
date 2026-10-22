package com.byazt.wz;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.aas.zb;
import com.byazt.ete.gt;
import com.byazt.ete.ic;
import com.byazt.hv.TTDownloadField;
import com.byazt.nr.m;
import com.byazt.omf.gu;
import com.byazt.omf.or;
import com.byazt.omf.p;
import com.byazt.omf.rh;
import com.byazt.yih.i;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 65, 46})
public class n extends c {
    public n(Context context, ic icVar, String str) {
        super(context, icVar, str, "");
    }

    private void a(JSONObject jSONObject, final boolean z) {
        rl();
        if (getContext() == null || this.tt == null || !z()) {
            return;
        }
        String str = this.uj;
        com.byazt.qt.ve.c(str, str, jSONObject, gt());
        final zb<String, Object> zbVarC = new zb().c("downloadUrl", this.tt.tt()).c("hashCode", Integer.valueOf(gt())).c(TTDownloadField.TT_ACTIVITY, getContext()).c("open_market_in_app", Boolean.valueOf(gt.my(this.ve))).c("action_type_button", 2);
        ic icVar = this.ve;
        if (icVar != null && !TextUtils.isEmpty(icVar.uj())) {
            zbVarC.c("id", Long.valueOf(Double.valueOf(this.ve.uj()).longValue()));
        }
        if (!uj()) {
            c(zbVarC, z);
            return;
        }
        com.byazt.wrq.c cVar = new com.byazt.wrq.c() { // from class: com.byazt.wz.n.1
            @Override // com.byazt.ou.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z2) {
            }

            @Override // com.byazt.ou.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
                if (zbVarC == null) {
                    return;
                }
                com.byazt.qt.ve.c(0, n.this.gt());
                n.this.x().c(n.this.m());
                zbVarC.remove("downloadButtonClickListener");
                if (n.this.c((com.byazt.ete.uj) null, (com.byazt.wrq.c) null, zbVarC, z)) {
                    return;
                }
                n.this.tt(zbVarC);
            }
        };
        com.byazt.qt.ve.c(zbVarC, cVar);
        if (c((com.byazt.ete.uj) null, cVar, zbVarC, z)) {
            return;
        }
        c(zbVarC, cVar);
    }

    private void rl() {
        if (uj() && !this.my) {
            com.byazt.qt.ve.c(false, (com.byazt.wrq.ve) null, gt());
        }
    }

    private void tt(com.byazt.wrq.c cVar, Map<String, Object> map) {
        if (this.rh == null) {
            return;
        }
        final zb<String, Object> zbVarC = new zb().c("itemClickListener", null).c("downloadButtonClickListener", cVar).c("hashCode", Integer.valueOf(gt())).c(map);
        zbVarC.put("itemClickListener", new com.byazt.wrq.uj() { // from class: com.byazt.wz.n.3
            @Override // com.byazt.wrq.uj
            public void onItemClick() {
                if (n.this.u || n.this.ve.x_()) {
                    com.byazt.qt.ve.tt(1, n.this.gt());
                    zbVarC.remove("itemClickListener");
                    n.this.rh.apply(com.byazt.yxi.uj.c().c(17).c(Void.class).c(0, zbVarC).tt());
                } else {
                    Context context = n.this.getContext();
                    String strX = n.this.ve.x();
                    n nVar = n.this;
                    or.c(context, strX, nVar.ve, nVar.uj, nVar.sp());
                }
            }
        });
        this.rh.apply(com.byazt.yxi.uj.c().c(17).c(Void.class).c(0, zbVarC).tt());
    }

    @Override // com.byazt.wz.c
    public void my() {
        com.byazt.qt.ve.c(this.uj, this.ve, (JSONObject) null, gt());
        com.byazt.qt.ve.c(this.ve, gt(), false);
        com.byazt.qt.ve.c(this.uj, gt());
    }

    @Override // com.byazt.pop.ve
    public void n() {
        ic icVar = this.ve;
        if (icVar != null) {
            com.byazt.rgb.c.uj(icVar.zm());
        }
        if (this.tt == null) {
            return;
        }
        this.sp.set(false);
        Function<SparseArray<Object>, Object> function = this.rh;
        if (function != null) {
            function.apply(com.byazt.yxi.uj.c().c(8).c(Void.class).c(0, new zb().c("force", Boolean.TRUE).c("hashCode", Integer.valueOf(gt()))).tt());
        }
        rh();
    }

    @Override // com.byazt.wz.c
    public synchronized void rh() {
        if (this.tt == null) {
            return;
        }
        this.sp.set(true);
        if (this.rh != null) {
            this.rh.apply(com.byazt.yxi.uj.c().c(5).c(Void.class).c(0, new zb().c("hashCode", Integer.valueOf(gt())).c("downloadStatusChangeListener", this.gu).c("marketStatusChangeListener", this.zm)).tt());
        }
    }

    @Override // com.byazt.pop.ve
    public boolean sp() {
        return this.rl;
    }

    @Override // com.byazt.wz.c
    public synchronized void u() {
        if (this.tt == null) {
            return;
        }
        if (this.rh != null && p.uj >= 6400 && !p.x()) {
            com.byazt.qt.ve.c((com.byazt.wrq.ve) null, gt());
        }
        AtomicBoolean atomicBoolean = this.sp;
        if (atomicBoolean != null && atomicBoolean.get()) {
            this.sp.set(false);
            if (this.rh != null) {
                this.rh.apply(com.byazt.yxi.uj.c().c(4).c(Void.class).c(0, new zb().c("hashCode", Integer.valueOf(gt()))).tt());
            }
        }
        da();
    }

    @Override // com.byazt.wz.c, com.byazt.pop.ve
    public boolean uj() {
        Function<SparseArray<Object>, Object> function = this.rh;
        return function != null && com.byazt.qt.ve.c(function, gt()) == 2;
    }

    @Override // com.byazt.pop.ve
    public void uj(boolean z) {
        this.rl = z;
    }

    @Override // com.byazt.pop.ve
    public void c(JSONObject jSONObject, boolean z) {
        a(jSONObject, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Map<String, Object> map, final com.byazt.wrq.c cVar) {
        tt(true);
        i.c(new Runnable() { // from class: com.byazt.wz.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.c(cVar, (Map<String, Object>) map);
            }
        }, this.ve);
        this.my = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(final Map<String, Object> map) {
        int i = this.nu;
        if (i == 1) {
            return;
        }
        if (i == 2) {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("tt_market_download_check") { // from class: com.byazt.wz.n.5
                @Override // java.lang.Runnable
                public void run() {
                    gu<com.byazt.ddx.c> guVarC = com.byazt.omf.gt.c();
                    n nVar = n.this;
                    com.byazt.ete.uj ujVarC = guVarC.c(nVar.ve, nVar.tt.tt());
                    if (ujVarC == null || !ujVarC.sp()) {
                        return;
                    }
                    rh.a().post(new Runnable() { // from class: com.byazt.wz.n.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            n.this.c((com.byazt.wrq.c) null, (Map<String, Object>) map);
                        }
                    });
                }
            });
        } else {
            c((com.byazt.wrq.c) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.wrq.c cVar, Map<String, Object> map) {
        try {
            if (cVar == null) {
                c(map);
                this.my = false;
            } else {
                tt(cVar, map);
                this.my = false;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.pop.ve
    public void tt(boolean z) {
        if (z) {
            this.my = true;
            if (uj()) {
                try {
                    com.byazt.qt.ve.c(true, com.byazt.qt.ve.c(this.ve, this.gt), gt());
                } catch (Throwable th) {
                    m.ve("xgcdl", "throwable", th);
                }
            }
        }
    }

    private void c(final Map<String, Object> map, final boolean z) {
        int i = this.nu;
        if (i == 1) {
            x.c(com.byazt.omf.gt.getContext(), this.ve, "jsb_1");
        } else if (i != 2) {
            c((com.byazt.ete.uj) null, map, z);
        } else {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("tt_download_check") { // from class: com.byazt.wz.n.4
                @Override // java.lang.Runnable
                public void run() {
                    gu<com.byazt.ddx.c> guVarC = com.byazt.omf.gt.c();
                    n nVar = n.this;
                    com.byazt.ete.uj ujVarC = guVarC.c(nVar.ve, nVar.tt.tt());
                    if (ujVarC == null || !ujVarC.sp()) {
                        x.c(com.byazt.omf.gt.getContext(), n.this.ve, "jsb_2");
                    } else {
                        n.this.c(ujVarC, (Map<String, Object>) map, z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.byazt.ete.uj ujVar, final Map<String, Object> map, final boolean z) {
        c(new com.byazt.wrq.c() { // from class: com.byazt.wz.n.6
            @Override // com.byazt.ou.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z2) {
                if (z2 && n.this.c(ujVar, (com.byazt.wrq.c) null, (Map<String, Object>) map, z)) {
                    return;
                }
                n.this.c((com.byazt.wrq.c) null, (Map<String, Object>) map);
            }

            @Override // com.byazt.ou.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
            }
        }, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.byazt.ete.uj ujVar, final com.byazt.wrq.c cVar, final Map<String, Object> map, boolean z) {
        com.byazt.yzg.ve veVarX = x();
        if (!veVarX.uj(z) || sp()) {
            return false;
        }
        if (c(getContext(), this.ve, this.uj)) {
            return true;
        }
        veVarX.c(ujVar, this.uj, this.tt.tt(), new com.byazt.av.tt() { // from class: com.byazt.wz.n.7
            @Override // com.byazt.av.tt
            public void c() {
                if (n.this.uj()) {
                    n.this.c((Map<String, Object>) map, cVar);
                } else {
                    n.this.c(cVar, (Map<String, Object>) map);
                }
            }
        });
        return true;
    }
}
