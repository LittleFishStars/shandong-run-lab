package com.byazt.hz;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.byazt.vx.nu;
import com.byazt.vx.yp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 71})
public class x extends uj implements com.byazt.zq.tt {
    public com.byazt.ln.tt c;
    public boolean my;
    public com.byazt.ln.c tt;

    public x(Context context) {
        super(context);
        this.my = false;
    }

    @Override // com.byazt.ln.c
    public void a() {
        if (!yp.c()) {
            yv();
            com.byazt.ln.c cVar = this.tt;
            if (cVar != null) {
                cVar.a();
                return;
            }
            return;
        }
        com.byazt.yl.ve veVar = this.uj;
        if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
            if (!yp.ve()) {
                com.byazt.ng.a.c(this.uj, this.f28639a, 3, 1, rl() ? 1 : 0, nu.c());
                return;
            }
            com.byazt.ng.a.c(this.uj, this.f28639a, 3, 0, rl() ? 1 : 0, (String) null);
        }
        if (zm()) {
            return;
        }
        yv();
        com.byazt.ln.c cVar2 = this.tt;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    @Override // com.byazt.hz.tt
    public com.byazt.pp.ve f_() {
        if (this.my) {
            return super.f_();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003d  */
    @Override // com.byazt.ln.c
    public void g_() {
        String str;
        String str2;
        long jCurrentTimeMillis;
        String strC;
        com.byazt.ln.c cVar;
        gr();
        if (yp.c()) {
            com.byazt.yl.ve veVar = this.uj;
            if (veVar == null || !MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                strC = null;
            } else if (!yp.ve()) {
                com.byazt.ng.a.c(this.uj, this.f28639a, 5, 1, rl() ? 1 : 0, nu.c());
                return;
            } else if (yp.x()) {
                strC = nu.c();
            } else {
                strC = null;
            }
            if (!zm() && (cVar = this.tt) != null) {
                cVar.g_();
            }
            str = strC;
        } else {
            com.byazt.ln.c cVar2 = this.tt;
            if (cVar2 != null) {
                cVar2.g_();
            }
            str = null;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            String strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            str2 = strTt;
        } else {
            str2 = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.bg.c.n(this.f28639a.gt());
        com.byazt.ng.a.c(this.uj, this.f28639a, rl() ? 1 : 0, str2, jCurrentTimeMillis, str, this.uj.isClickListenRepeatOnce());
    }

    @Override // com.byazt.ln.c
    public void h_() {
        gu();
        if (this.m) {
            if (!yp.c()) {
                yv();
                com.byazt.ln.c cVar = this.tt;
                if (cVar != null) {
                    cVar.h_();
                    return;
                }
                return;
            }
            com.byazt.yl.ve veVar = this.uj;
            if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
                if (!yp.ve()) {
                    com.byazt.ng.a.c(this.uj, this.f28639a, 2, 1, rl() ? 1 : 0, nu.c());
                    return;
                }
                com.byazt.ng.a.c(this.uj, this.f28639a, 2, 0, rl() ? 1 : 0, (String) null);
            }
            if (zm()) {
                return;
            }
            yv();
            com.byazt.ln.c cVar2 = this.tt;
            if (cVar2 != null) {
                cVar2.h_();
            }
        }
    }

    @Override // com.byazt.ln.c
    public void n() {
        String strTt;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strTt = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.ng.a.c(this.uj, this.f28639a, (com.byazt.pp.c) null, 2, rl() ? 1 : 0, strTt, jCurrentTimeMillis);
        com.byazt.ln.c cVar = this.tt;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void sp() {
        com.byazt.ln.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c();
        }
    }

    public void tt(Activity activity, Object obj, String str) {
        c(activity, obj, str);
    }

    @Override // com.byazt.ln.c
    public void uj() {
        if (!yp.c()) {
            yv();
            com.byazt.ln.c cVar = this.tt;
            if (cVar != null) {
                cVar.uj();
                return;
            }
            return;
        }
        com.byazt.yl.ve veVar = this.uj;
        if (veVar != null && MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
            if (!yp.ve()) {
                com.byazt.ng.a.c(this.uj, this.f28639a, 1, 1, rl() ? 1 : 0, nu.c());
                return;
            }
            com.byazt.ng.a.c(this.uj, this.f28639a, 1, 0, rl() ? 1 : 0, (String) null);
        }
        if (zm()) {
            return;
        }
        yv();
        com.byazt.ln.c cVar2 = this.tt;
        if (cVar2 != null) {
            cVar2.uj();
        }
    }

    @Override // com.byazt.hz.da, com.byazt.hz.tt
    public void ve() {
        if (this.uj == null) {
            com.byazt.hk.c.c().c(this.ve.c(false), this.n, this.f28639a, rh(), this.uj);
        }
        super.ve();
        this.tt = null;
        this.c = null;
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void x() {
        com.byazt.ln.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.tt();
        }
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void tt(com.byazt.pp.c cVar) {
        com.byazt.ln.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c(cVar);
        }
    }

    public void c(com.byazt.ll.tt ttVar, @NonNull com.byazt.ln.tt ttVar2) {
        super.tt(ttVar);
        this.c = ttVar2;
        this.f28639a = ttVar;
        this.i = this;
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(final com.byazt.pp.c cVar) {
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.x.2
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.tt != null) {
                    x.this.tt.c(cVar);
                }
            }
        });
    }

    public void c(Activity activity) {
        tt(activity, null, null);
    }

    @Override // com.byazt.hz.uj
    @MainThread
    public void c(Activity activity, Object obj, String str) {
        super.c(activity, obj, str, new da.c() { // from class: com.byazt.hz.x.1
            @Override // com.byazt.hz.da.c
            public void c() {
                x.this.ve(new com.byazt.pp.c(40052, com.byazt.pp.c.c(40052)));
            }
        });
        if (this.tt == null) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "注意：未设置GMFullVideoAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
        c(this.uj);
    }

    public void c(com.byazt.ln.c cVar) {
        this.tt = cVar;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0056  */
    @Override // com.byazt.ln.c
    public void c() {
        String strC;
        String str;
        long jCurrentTimeMillis;
        com.byazt.yl.ve veVar;
        this.my = true;
        qy();
        if (!yp.c() || (veVar = this.uj) == null || !MediationConstant.ADN_PANGLE.equals(veVar.getAdNetWorkName())) {
            strC = null;
        } else {
            if (!yp.ve()) {
                c(true);
                com.byazt.pp.c cVar = new com.byazt.pp.c(40063, com.byazt.pp.c.c(40063));
                com.byazt.ng.a.c(this.uj, this.f28639a, cVar, 1, rl() ? 1 : 0, (String) null, 0L, nu.c());
                ve(cVar);
                return;
            }
            if (yp.sp()) {
                strC = nu.c();
            } else {
                strC = null;
            }
        }
        com.byazt.ln.c cVar2 = this.tt;
        if (cVar2 != null) {
            cVar2.c();
        }
        com.byazt.hr.u.c().sp(this.n);
        if (this.uj != null) {
            com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.c(this.n, "show_listen") + "adSlotId：" + this.uj.getAdNetworkSlotId() + "，广告类型：" + com.byazt.yl.c.c(this.uj.getAdNetworkPlatformId()));
            com.byazt.hr.sl.c().tt(this.n, this.uj.getAdNetworkSlotId());
        }
        c(this.ve);
        ve(this.uj);
        com.byazt.yl.ve veVar2 = this.uj;
        if (veVar2 != null) {
            com.byazt.xx.ve.c(veVar2.getAdnName(), this.n, this.uj.getAdNetworkSlotId());
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            String strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            str = strTt;
        } else {
            str = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.ng.a.c(this.uj, this.f28639a, rl() ? 1 : 0, str, jCurrentTimeMillis, strC, false, gt());
        com.byazt.bg.c.sp(this.f28639a.gt());
        com.byazt.bg.c.ve(this.f28639a.gt());
        com.byazt.psp.uj.c(1, this.f28639a.gt(), this.uj.getAdType(), this.uj.getCpm());
        com.byazt.oi.ve.c(this.n, this.uj);
    }

    @Override // com.byazt.ln.c
    public void c(com.byazt.pp.c cVar) {
        String strTt;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strTt = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.ng.a.c(this.uj, this.f28639a, cVar, 1, rl() ? 1 : 0, strTt, jCurrentTimeMillis);
        ve(cVar);
    }

    @Override // com.byazt.ln.c
    public void c(@NonNull com.byazt.bo.c cVar) {
        com.byazt.ln.c cVar2 = this.tt;
        if (cVar2 != null) {
            cVar2.c(t.c(this.f28639a, cVar, this.uj, (Map<String, Object>) null));
        }
    }
}
