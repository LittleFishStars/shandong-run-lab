package com.byazt.om;

import android.text.TextUtils;
import com.byazt.vx.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 554, 72})
public class da extends tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.byazt.nbs.da> f28874a;
    public final com.byazt.nbs.tt n;
    public final HashSet<String> sp = new HashSet<>();
    public final com.byazt.iz.tt uj;

    public da(com.byazt.iz.tt ttVar, com.byazt.nbs.tt ttVar2, List<com.byazt.nbs.da> list) {
        this.uj = ttVar;
        this.n = ttVar2;
        this.f28874a = list;
    }

    private com.byazt.nbs.da a() {
        List<com.byazt.nbs.da> list = this.f28874a;
        if (list == null) {
            return null;
        }
        for (com.byazt.nbs.da daVar : list) {
            if (daVar != null) {
                if (!this.sp.contains(daVar.rh())) {
                    return daVar;
                }
            }
        }
        return null;
    }

    @Override // com.byazt.om.tt
    public boolean tt(com.byazt.nbs.da daVar, int i) {
        com.byazt.nbs.da daVarA;
        if (i == 1) {
            com.byazt.nbs.da daVarA2 = a();
            if (daVarA2 != null && daVar != null && TextUtils.equals(daVarA2.rh(), daVar.rh())) {
                ve();
                return true;
            }
        } else if (i == 2) {
            if (daVar != null) {
                this.sp.add(daVar.rh());
                CopyOnWriteArrayList<com.byazt.yl.ve> copyOnWriteArrayListT = this.uj.t();
                com.byazt.yl.ve veVar = (copyOnWriteArrayListT == null || copyOnWriteArrayListT.size() <= 0) ? null : copyOnWriteArrayListT.get(0);
                if (veVar != null && (daVarA = a()) != null && TextUtils.equals(daVarA.rh(), veVar.getAdNetworkSlotId())) {
                    ve();
                    return true;
                }
            }
            if (this.tt.x()) {
                com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "全部广告完成响应...");
                if (p.c(this.uj.t())) {
                    c(new com.byazt.pp.c(20005, com.byazt.pp.c.c(20005)));
                }
                return true;
            }
        } else if (this.tt.n()) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "触发总超时或全部代码位响应结束.....totalTimeout：" + this.tt.n() + "  allWtfFinish:" + this.tt.x());
            if (p.c(this.uj.t())) {
                c(new com.byazt.pp.c(10003, com.byazt.pp.c.c(10003)));
            } else {
                ve();
            }
            return true;
        }
        return false;
    }
}
