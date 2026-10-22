package com.byazt.hz;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.byazt.vx.nu;
import com.byazt.vx.yp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 20})
public class c extends uj {
    public com.byazt.zq.tt c;
    public com.byazt.bi.c gt;
    public com.byazt.bi.tt my;
    public boolean rl;
    public com.byazt.zq.ve tt;

    public c(Context context) {
        super(context);
        this.rl = false;
        this.c = new com.byazt.zq.tt() { // from class: com.byazt.hz.c.3
            @Override // com.byazt.ln.c
            public void a() {
                if (!yp.c()) {
                    c.this.yv();
                    if (c.this.gt != null) {
                        c.this.gt.a();
                        return;
                    }
                    return;
                }
                com.byazt.yl.ve veVar = c.this.uj;
                if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                    if (!yp.ve()) {
                        String strC = nu.c();
                        c cVar = c.this;
                        com.byazt.ng.a.c(cVar.uj, cVar.f28639a, 3, 1, cVar.rl() ? 1 : 0, strC);
                        return;
                    }
                    c cVar2 = c.this;
                    com.byazt.ng.a.c(cVar2.uj, cVar2.f28639a, 3, 0, cVar2.rl() ? 1 : 0, (String) null);
                }
                if (c.this.zm()) {
                    return;
                }
                c.this.yv();
                if (c.this.gt != null) {
                    c.this.gt.a();
                }
            }

            /* JADX WARN: Code duplicated, block: B:15:0x0063  */
            @Override // com.byazt.ln.c
            public void c() {
                String strC;
                String str;
                long jCurrentTimeMillis;
                com.byazt.yl.ve veVar;
                c.this.rl = true;
                c.this.qy();
                if (!yp.c() || (veVar = c.this.uj) == null || !MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                    strC = null;
                } else {
                    if (!yp.ve()) {
                        c.this.c(true);
                        com.byazt.pp.c cVar = new com.byazt.pp.c(40063, com.byazt.pp.c.c(40063));
                        String strC2 = nu.c();
                        c cVar2 = c.this;
                        com.byazt.ng.a.c(cVar2.uj, cVar2.f28639a, cVar, 1, cVar2.rl() ? 1 : 0, (String) null, 0L, strC2);
                        c.this.c(cVar);
                        return;
                    }
                    if (yp.sp()) {
                        strC = nu.c();
                    } else {
                        strC = null;
                    }
                }
                if (c.this.gt != null) {
                    c.this.gt.c();
                }
                com.byazt.hr.u.c().sp(c.this.n);
                if (c.this.uj != null) {
                    com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.c(c.this.n, "show_listen") + "adSlotId：" + c.this.uj.getAdNetworkSlotId() + "，广告类型：" + com.byazt.yl.c.c(c.this.uj.getAdNetworkPlatformId()));
                    com.byazt.hr.sl slVarC = com.byazt.hr.sl.c();
                    c cVar3 = c.this;
                    slVarC.tt(cVar3.n, cVar3.uj.getAdNetworkSlotId());
                }
                c cVar4 = c.this;
                cVar4.c(cVar4.ve);
                c cVar5 = c.this;
                cVar5.ve(cVar5.uj);
                com.byazt.yl.ve veVar2 = c.this.uj;
                if (veVar2 != null) {
                    String adnName = veVar2.getAdnName();
                    c cVar6 = c.this;
                    com.byazt.xx.ve.c(adnName, cVar6.n, cVar6.uj.getAdNetworkSlotId());
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    String strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    str = strTt;
                } else {
                    str = null;
                    jCurrentTimeMillis = -1;
                }
                c cVar7 = c.this;
                com.byazt.ng.a.c(cVar7.uj, cVar7.f28639a, cVar7.rl() ? 1 : 0, str, jCurrentTimeMillis, strC, false, c.this.gt());
                com.byazt.bg.c.sp(c.this.n);
                com.byazt.bg.c.ve(c.this.n);
                com.byazt.psp.uj.c(1, c.this.f28639a.gt(), c.this.uj.getAdType(), c.this.uj.getCpm());
                c cVar8 = c.this;
                com.byazt.oi.ve.c(cVar8.n, cVar8.uj);
            }

            /* JADX WARN: Code duplicated, block: B:15:0x0043  */
            @Override // com.byazt.ln.c
            public void g_() {
                String str;
                String str2;
                long jCurrentTimeMillis;
                String strC;
                c.this.gr();
                if (yp.c()) {
                    com.byazt.yl.ve veVar = c.this.uj;
                    if (veVar == null || !MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                        strC = null;
                    } else if (!yp.ve()) {
                        String strC2 = nu.c();
                        c cVar = c.this;
                        com.byazt.ng.a.c(cVar.uj, cVar.f28639a, 5, 1, cVar.rl() ? 1 : 0, strC2);
                        return;
                    } else if (yp.x()) {
                        strC = nu.c();
                    } else {
                        strC = null;
                    }
                    if (!c.this.zm() && c.this.gt != null) {
                        c.this.gt.tt();
                    }
                    str = strC;
                } else {
                    if (c.this.gt != null) {
                        c.this.gt.tt();
                    }
                    str = null;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    String strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    str2 = strTt;
                } else {
                    str2 = null;
                    jCurrentTimeMillis = -1;
                }
                com.byazt.bg.c.n(c.this.n);
                c cVar2 = c.this;
                com.byazt.ng.a.c(cVar2.uj, cVar2.f28639a, cVar2.rl() ? 1 : 0, str2, jCurrentTimeMillis, str, c.this.uj.isClickListenRepeatOnce());
            }

            @Override // com.byazt.ln.c
            public void h_() {
                c.this.gu();
                if (c.this.m) {
                    if (!yp.c()) {
                        c.this.yv();
                        if (c.this.gt != null) {
                            c.this.gt.ve();
                            return;
                        }
                        return;
                    }
                    com.byazt.yl.ve veVar = c.this.uj;
                    if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                        if (!yp.ve()) {
                            String strC = nu.c();
                            c cVar = c.this;
                            com.byazt.ng.a.c(cVar.uj, cVar.f28639a, 2, 1, cVar.rl() ? 1 : 0, strC);
                            return;
                        }
                        c cVar2 = c.this;
                        com.byazt.ng.a.c(cVar2.uj, cVar2.f28639a, 2, 0, cVar2.rl() ? 1 : 0, (String) null);
                    }
                    if (c.this.zm()) {
                        return;
                    }
                    c.this.yv();
                    if (c.this.gt != null) {
                        c.this.gt.ve();
                    }
                }
            }

            @Override // com.byazt.ln.c
            public void n() {
                String strTt;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strTt = null;
                    jCurrentTimeMillis = -1;
                }
                c cVar = c.this;
                com.byazt.ng.a.c(cVar.uj, cVar.f28639a, (com.byazt.pp.c) null, 2, cVar.rl() ? 1 : 0, strTt, jCurrentTimeMillis);
                if (c.this.gt != null) {
                    c.this.gt.n();
                }
            }

            @Override // com.byazt.ln.c
            public void uj() {
                if (!yp.c()) {
                    c.this.yv();
                    if (c.this.gt != null) {
                        c.this.gt.uj();
                        return;
                    }
                    return;
                }
                com.byazt.yl.ve veVar = c.this.uj;
                if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                    if (!yp.ve()) {
                        String strC = nu.c();
                        c cVar = c.this;
                        com.byazt.ng.a.c(cVar.uj, cVar.f28639a, 1, 1, cVar.rl() ? 1 : 0, strC);
                        return;
                    }
                    c cVar2 = c.this;
                    com.byazt.ng.a.c(cVar2.uj, cVar2.f28639a, 1, 0, cVar2.rl() ? 1 : 0, (String) null);
                }
                if (c.this.zm()) {
                    return;
                }
                c.this.yv();
                if (c.this.gt != null) {
                    c.this.gt.uj();
                }
            }

            @Override // com.byazt.ln.c
            public void c(@NonNull com.byazt.pp.c cVar) {
                String strTt;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strTt = null;
                    jCurrentTimeMillis = -1;
                }
                c cVar2 = c.this;
                com.byazt.ng.a.c(cVar2.uj, cVar2.f28639a, cVar, 1, cVar2.rl() ? 1 : 0, strTt, jCurrentTimeMillis);
                c.this.c(cVar);
            }

            @Override // com.byazt.ln.c
            public void c(@NonNull com.byazt.bo.c cVar) {
                if (c.this.gt != null) {
                    com.byazt.bi.c cVar2 = c.this.gt;
                    c cVar3 = c.this;
                    cVar2.c(t.c(cVar3.f28639a, cVar, cVar3.uj, (Map<String, Object>) null));
                }
            }
        };
        this.tt = new com.byazt.zq.ve() { // from class: com.byazt.hz.c.4
            @Override // com.byazt.xu.c
            public void c() {
                String strTt;
                long jCurrentTimeMillis;
                c.this.rl = true;
                c.this.qy();
                if (c.this.gt != null) {
                    c.this.gt.c();
                }
                com.byazt.hr.u.c().sp(c.this.n);
                if (c.this.uj != null) {
                    com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.c(c.this.n, "show_listen") + "adSlotId：" + c.this.uj.getAdNetworkSlotId() + "，广告类型：" + com.byazt.yl.c.c(c.this.uj.getAdNetworkPlatformId()));
                    com.byazt.hr.sl slVarC = com.byazt.hr.sl.c();
                    c cVar = c.this;
                    slVarC.tt(cVar.n, cVar.uj.getAdNetworkSlotId());
                }
                c cVar2 = c.this;
                cVar2.c(cVar2.ve);
                c cVar3 = c.this;
                cVar3.ve(cVar3.uj);
                com.byazt.yl.ve veVar = c.this.uj;
                if (veVar != null) {
                    String adnName = veVar.getAdnName();
                    c cVar4 = c.this;
                    com.byazt.xx.ve.c(adnName, cVar4.n, cVar4.uj.getAdNetworkSlotId());
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strTt = null;
                    jCurrentTimeMillis = -1;
                }
                c cVar5 = c.this;
                com.byazt.yl.ve veVar2 = cVar5.uj;
                com.byazt.ll.tt ttVar = cVar5.f28639a;
                boolean zRl = cVar5.rl();
                com.byazt.ng.a.c(veVar2, ttVar, zRl ? 1 : 0, strTt, jCurrentTimeMillis, false, c.this.gt());
                c cVar6 = c.this;
                com.byazt.oi.ve.c(cVar6.n, cVar6.uj);
            }

            @Override // com.byazt.xu.c
            public void n() {
                if (c.this.gt != null) {
                    c.this.gt.x();
                }
            }

            @Override // com.byazt.xu.c
            public void tt() {
                String strTt;
                long jCurrentTimeMillis;
                c.this.gr();
                if (c.this.gt != null) {
                    c.this.gt.tt();
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strTt = null;
                    jCurrentTimeMillis = -1;
                }
                c cVar = c.this;
                com.byazt.yl.ve veVar = cVar.uj;
                com.byazt.ll.tt ttVar = cVar.f28639a;
                boolean zRl = cVar.rl();
                boolean zIsClickListenRepeatOnce = c.this.uj.isClickListenRepeatOnce();
                com.byazt.ng.a.c(veVar, ttVar, zRl ? 1 : 0, strTt, jCurrentTimeMillis, zIsClickListenRepeatOnce);
            }

            @Override // com.byazt.xu.c
            public void uj() {
                if (c.this.gt != null) {
                    c.this.gt.sp();
                }
            }

            @Override // com.byazt.xu.c
            public void ve() {
                c.this.gu();
                c cVar = c.this;
                if (cVar.m) {
                    cVar.yv();
                    if (c.this.gt != null) {
                        c.this.gt.ve();
                    }
                }
            }

            @Override // com.byazt.xu.c
            public void c(@NonNull com.byazt.pp.c cVar) {
                String strTt;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (nu.c(c.this.uj)) {
                    strTt = nu.tt();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strTt = null;
                    jCurrentTimeMillis = -1;
                }
                c cVar2 = c.this;
                com.byazt.ng.a.c(cVar2.uj, cVar2.f28639a, cVar, 1, cVar2.rl() ? 1 : 0, strTt, jCurrentTimeMillis);
                c.this.c(cVar);
            }
        };
    }

    private void tt(Activity activity, Object obj, String str) {
        super.c(activity, obj, str, new da.c() { // from class: com.byazt.hz.c.1
            @Override // com.byazt.hz.da.c
            public void c() {
                c.this.c(new com.byazt.pp.c(40052, com.byazt.pp.c.c(40052)));
            }
        });
    }

    @Override // com.byazt.hz.tt
    public com.byazt.pp.ve f_() {
        if (this.rl) {
            return super.f_();
        }
        return null;
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void sp() {
        com.byazt.bi.tt ttVar = this.my;
        if (ttVar != null) {
            ttVar.c();
        }
    }

    @Override // com.byazt.hz.da, com.byazt.hz.tt
    public void ve() {
        if (this.uj == null) {
            com.byazt.hk.c.c().c(this.ve.c(false), this.n, this.f28639a, rh(), this.uj);
        }
        super.ve();
        this.gt = null;
        this.my = null;
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void x() {
        com.byazt.bi.tt ttVar = this.my;
        if (ttVar != null) {
            ttVar.tt();
        }
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void tt(com.byazt.pp.c cVar) {
        com.byazt.bi.tt ttVar = this.my;
        if (ttVar != null) {
            ttVar.c(cVar);
        }
    }

    public void c(com.byazt.ll.tt ttVar, com.byazt.bi.tt ttVar2) {
        super.tt(ttVar);
        this.f28639a = ttVar;
        this.my = ttVar2;
        this.i = this.c;
        i();
    }

    public void c(Activity activity) {
        c(activity, (Object) null, (String) null);
    }

    @Override // com.byazt.hz.uj
    public void c(Activity activity, Object obj, String str) {
        if (activity == null) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "activity can not be null !");
        } else {
            tt(activity, obj, str);
            c(this.uj);
        }
    }

    public void c(com.byazt.bi.c cVar) {
        this.gt = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.byazt.pp.c cVar) {
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.gt != null) {
                    c.this.gt.c(cVar);
                }
            }
        });
    }

    @Override // com.byazt.hz.uj, com.byazt.hz.da
    public void c(com.byazt.yl.ve veVar, Activity activity, Object obj, String str) {
        if (veVar != null) {
            if (veVar.getSubAdType() == 1) {
                this.i = this.tt;
            } else if (veVar.getSubAdType() == 2) {
                this.i = this.c;
            }
        }
        super.c(veVar, activity, obj, str);
    }
}
