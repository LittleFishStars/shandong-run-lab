package com.byazt.hz;

import android.content.Context;
import androidx.annotation.NonNull;
import com.byazt.vx.h;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 46})
public class n extends tt implements com.byazt.ix.ve {
    public final int c;
    public List<com.byazt.nbs.da> m;
    public com.byazt.ix.uj.ve tt;

    public n(Context context, int i) {
        super(context);
        this.c = i;
    }

    @Override // com.byazt.ix.ve
    public void c(com.byazt.ll.tt ttVar, com.byazt.yl.ve veVar, com.byazt.ix.uj.ve veVar2) {
        this.tt = veVar2;
        c(ttVar);
        this.ve.tt(true);
        this.ve.n(true);
        this.ve.gu().c(ttVar.c());
        com.byazt.nbs.tt ttVarC = c(this.sp, veVar);
        this.sp = ttVarC;
        this.ve.c(ttVarC);
        this.f28639a.n(1);
        com.byazt.nbs.tt ttVarC2 = com.byazt.xx.ve.c(this.f28639a, this.sp);
        if (ttVarC2 != null) {
            this.sp = ttVarC2;
            this.ve.c(ttVarC2);
        }
        com.byazt.nbs.tt ttVar2 = this.sp;
        if (ttVar2 == null) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 预缓存补充请求未发起，mRitConfig为null");
            com.byazt.ix.uj.ve veVar3 = this.tt;
            if (veVar3 != null) {
                veVar3.c(this.n, false, 0, null);
                return;
            }
            return;
        }
        List<com.byazt.nbs.da> listL = ttVar2.l();
        if (listL == null || listL.size() <= 0) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 预缓存补充请求未发起，过滤后的waterfall为空");
            com.byazt.ix.uj.ve veVar4 = this.tt;
            if (veVar4 != null) {
                veVar4.c(this.n, false, 0, null);
                return;
            }
            return;
        }
        com.byazt.nbs.tt ttVar3 = this.sp;
        ttVar3.sp((long) (ttVar3.aw() * this.sp.a()));
        com.byazt.nbs.tt ttVar4 = this.sp;
        ttVar4.a((long) (ttVar4.sv() * this.sp.n()));
        this.sp.tt(false);
        this.sp.c(false);
        List<com.byazt.nbs.da> listL2 = this.sp.l();
        this.m = listL2;
        h.c(listL2, this.z);
        if (com.byazt.eu.tt.tt()) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 预缓存补充请求，过滤后的waterfall：");
            for (com.byazt.nbs.da daVar : this.m) {
                com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "waterfall: " + daVar.z() + "adnSlotId: " + daVar.rh() + ", loadSort: " + daVar.yv() + ", showSort: " + daVar.p() + ", eCpm: " + daVar.gr());
            }
        }
        i();
    }

    @Override // com.byazt.hz.tt
    public com.byazt.om.sp i() {
        ArrayList arrayList = new ArrayList();
        int i = this.c;
        if (i == 3) {
            arrayList.add(new com.byazt.om.i());
        } else if (i == 4) {
            arrayList.add(new com.byazt.om.da(this.ve, this.sp, this.m));
        } else {
            arrayList.add(new com.byazt.om.tt());
        }
        com.byazt.om.sp spVar = new com.byazt.om.sp(arrayList);
        spVar.c(this.ve);
        return spVar;
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void sp() {
        super.sp();
        com.byazt.ix.uj.ve veVar = this.tt;
        if (veVar != null) {
            com.byazt.nbs.tt ttVar = this.sp;
            veVar.c(ttVar != null ? ttVar.nb() : "", true, 0, this.ve.t());
        }
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void tt(@NonNull com.byazt.pp.c cVar) {
        super.tt(cVar);
        com.byazt.ix.uj.ve veVar = this.tt;
        if (veVar != null) {
            int i = 20005;
            if (cVar != null && cVar.c == 10003) {
                i = 10003;
            }
            com.byazt.nbs.tt ttVar = this.sp;
            veVar.c(ttVar != null ? ttVar.nb() : "", false, i, null);
        }
    }

    private com.byazt.nbs.tt c(com.byazt.nbs.tt ttVar, com.byazt.yl.ve veVar) {
        if (ttVar == null || veVar == null) {
            return null;
        }
        double cpm = veVar.getCpm();
        com.byazt.eu.tt.tt("TMe", "筛选预缓存 ecpm ".concat(String.valueOf(cpm)));
        com.byazt.nbs.tt ttVarClone = ttVar.clone();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (com.byazt.nbs.da daVar : ttVarClone.l()) {
            if (daVar != null && daVar.pf() && daVar.gr() > cpm) {
                copyOnWriteArrayList.add(daVar);
            }
        }
        if (ttVarClone.yp()) {
            ttVarClone.tt(copyOnWriteArrayList);
        } else {
            ttVarClone.c(copyOnWriteArrayList);
        }
        return ttVarClone;
    }
}
