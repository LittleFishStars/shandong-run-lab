package com.byazt.hz;

import android.app.Activity;
import android.content.Context;
import com.byazt.nr.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 72})
public abstract class da extends tt {
    public boolean nu;
    public boolean rh;

    public interface c {
        void c();
    }

    public da(Context context) {
        super(context);
        this.nu = false;
        this.rh = false;
    }

    private boolean tt(com.byazt.yl.ve veVar, Activity activity, Object obj, String str) {
        if (!veVar.isReady(this.n) || veVar.isHasShown()) {
            return false;
        }
        if (!rl()) {
            com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.tt(this.n, veVar.getAdNetworkSlotId()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.byazt.yl.c.c(veVar.getAdNetworkPlatformId()) + ",isReady()：" + veVar.isReady(this.n));
            c(veVar, activity, obj, str);
            return true;
        }
        if (!uj(veVar) || com.byazt.cz.c.c(veVar.getAdNetWorkName(), veVar.getAdType(), veVar.getSubAdType())) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.tt(this.n, veVar.getAdNetworkSlotId()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.byazt.yl.c.c(veVar.getAdNetworkPlatformId()) + ",isReady()：" + veVar.isReady(this.n));
        c(veVar, activity, obj, str);
        return true;
    }

    private boolean uj(com.byazt.yl.ve veVar) {
        return !veVar.isCustomAd() || veVar.getIsRefresh() == 1;
    }

    public void c(boolean z) {
        this.nu = z;
    }

    public boolean p() {
        List<com.byazt.nbs.da> listTt;
        try {
            listTt = tt();
        } catch (Throwable th) {
            m.c(th);
            listTt = null;
        }
        return com.byazt.vx.t.c(this.ve.sl(), this.ve.yp(), this.ve.t(), this.f28639a, this.t, this.n, this.f28639a.n(), listTt);
    }

    public boolean rl() {
        return false;
    }

    public void ve(final com.byazt.yl.ve veVar) {
        if (this.f28639a.tk()) {
            return;
        }
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.da.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yl.ve veVar2 = veVar;
                if (veVar2 == null || !veVar2.adnHasAdVideoCachedApi() || !veVar.isCacheSuccess() || (da.this.uj instanceof com.byazt.zm.tt)) {
                    return;
                }
                com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.tt(da.this.n, veVar.getAdNetworkSlotId()) + "在show时触发了预加载【" + veVar.getAdNetWorkName() + "】, loadSort: " + veVar.getLoadSort() + ", showSort: " + veVar.getShowSort());
                da.this.rh = true;
                com.byazt.ix.uj ujVarC = com.byazt.ix.uj.c();
                Context context = da.this.x.get();
                da daVar = da.this;
                ujVarC.tt(context, daVar.n, daVar.f28639a.n());
            }
        });
    }

    public void yv() {
        com.byazt.yl.ve veVar;
        if (this.f28639a.tk() || (veVar = this.uj) == null || veVar.getAdNetworkPlatformId() == 4) {
            return;
        }
        com.byazt.ix.uj.c().c(this.x.get(), this.n, this.f28639a.n());
    }

    public boolean zm() {
        return this.nu;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001f A[PHI: r2
      0x001f: PHI (r2v5 boolean) = (r2v2 boolean), (r2v0 boolean) binds: [B:31:0x006c, B:7:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    public void c(com.byazt.iz.tt ttVar) {
        boolean z;
        com.byazt.nbs.tt ttVar2;
        boolean z2 = true;
        if (this.uj.getAdType() == 10 || this.uj.getAdType() == 8 || this.uj.getAdType() == 7) {
            boolean z3 = (this.uj.adnHasAdVideoCachedApi() && this.uj.isCacheSuccess() && com.byazt.ix.uj.c().ve(this.n, this.f28639a.n())) ? false : true;
            com.byazt.ll.tt ttVar3 = this.f28639a;
            z2 = (ttVar3 == null || !(ttVar3.my() == 10 || this.f28639a.my() == 8) || (ttVar2 = this.sp) == null || ttVar2.m() == 0) ? z3 : true;
            if (this.uj.getAdNetworkPlatformId() == 4) {
                z = false;
            } else {
                z = z2;
            }
        } else {
            z = z2;
        }
        if (this.uj.canAdReuse() && com.byazt.hk.c.c().uj(this.n, this.uj.getAdNetworkSlotId(), this.f28639a.n())) {
            com.byazt.hk.c.c().c(this.uj.getAdNetworkSlotId(), this.f28639a, ttVar != null ? ttVar.zb() : null, z, ttVar != null ? ttVar.or() : null, (com.byazt.nbs.i) null, this.x.get());
        }
    }

    @Override // com.byazt.hz.tt
    public void ve() {
        super.ve();
    }

    private boolean ve(com.byazt.yl.ve veVar, Activity activity, Object obj, String str) {
        if (!veVar.isReady(this.n) || veVar.isHasShown()) {
            return false;
        }
        if (rl()) {
            if (uj(veVar) && !com.byazt.cz.c.c(veVar.getAdNetWorkName(), veVar.getAdType(), veVar.getSubAdType())) {
                com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.tt(this.n, veVar.getAdNetworkSlotId()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.byazt.yl.c.c(veVar.getAdNetworkPlatformId()) + ",isReady()：" + veVar.isReady(this.n));
                tt(veVar);
                c(veVar, activity, obj, str);
                return true;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- cache 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.tt(this.n, veVar.getAdNetworkSlotId()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.byazt.yl.c.c(veVar.getAdNetworkPlatformId()) + ",isReady()：" + veVar.isReady(this.n));
        tt(veVar);
        c(veVar, activity, obj, str);
        return true;
    }

    public void c(Activity activity, Object obj, String str, c cVar) {
        List<com.byazt.nbs.da> listTt = null;
        if (!rl()) {
            com.byazt.ng.a.c(this.f28639a);
            if (this.t) {
                com.byazt.ng.a.c((List<com.byazt.yl.ve>) null, this.f28639a, 0);
                if (cVar != null) {
                    cVar.c();
                    return;
                }
                return;
            }
        }
        int iTt = tt.tt(this.n);
        if (iTt != 0) {
            com.byazt.ng.a.c((List<com.byazt.yl.ve>) null, this.f28639a, iTt);
            if (cVar != null) {
                cVar.c();
                return;
            }
            return;
        }
        boolean zU = u();
        List<com.byazt.yl.ve> listC = this.ve.c(true);
        this.ve.c(listC);
        try {
            listTt = tt();
        } catch (Throwable th) {
            m.c(th);
        }
        List<com.byazt.nbs.da> list = listTt;
        if (list == null || list.size() <= 0 || !c(list, listC, zU, activity, obj, str)) {
            if (listC != null && listC.size() > 0) {
                for (com.byazt.yl.ve veVar : listC) {
                    if (veVar != null && (!zU || veVar.isCacheSuccess())) {
                        if (tt(veVar, activity, obj, str)) {
                            return;
                        }
                    }
                }
                if (zU && this.uj == null) {
                    for (com.byazt.yl.ve veVar2 : listC) {
                        if (veVar2 != null && tt(veVar2, activity, obj, str)) {
                            return;
                        }
                    }
                }
            }
            com.byazt.ng.a.c(listC, this.f28639a, 0);
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public void c(com.byazt.yl.ve veVar, final Activity activity, final Object obj, final String str) {
        this.uj = veVar;
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.da.2
            @Override // java.lang.Runnable
            public void run() {
                da daVar = da.this;
                com.byazt.yl.ve veVar2 = daVar.uj;
                if (veVar2 != null) {
                    com.byazt.zh.tt ttVar = daVar.u;
                    if (ttVar != null) {
                        veVar2.setTTAdAppDownloadListener(ttVar);
                    }
                    da daVar2 = da.this;
                    com.byazt.ocd.tt ttVar2 = daVar2.yp;
                    if (ttVar2 != null) {
                        daVar2.uj.setAdInteractionListener(ttVar2);
                    }
                    da daVar3 = da.this;
                    daVar3.ve.uj(daVar3.uj);
                    da.this.uj.setHasShown(true);
                    da daVar4 = da.this;
                    daVar4.uj.setTTAdatperCallback(daVar4.i);
                    if (da.this.uj.canAdReuse()) {
                        com.byazt.hk.c cVarC = com.byazt.hk.c.c();
                        da daVar5 = da.this;
                        if (cVarC.uj(daVar5.n, daVar5.uj.getAdNetworkSlotId(), da.this.rh())) {
                            da daVar6 = da.this;
                            com.byazt.yl.ve veVar3 = daVar6.uj;
                            com.byazt.qv.a.c(veVar3, daVar6.n, veVar3.getAdNetworkSlotId());
                        }
                    }
                    List<com.byazt.yl.ve> listC = da.this.ve.c(true);
                    com.byazt.hk.c cVarC2 = com.byazt.hk.c.c();
                    da daVar7 = da.this;
                    String str2 = daVar7.n;
                    com.byazt.ll.tt ttVar3 = daVar7.f28639a;
                    cVarC2.c(listC, str2, ttVar3, ttVar3.n(), da.this.uj);
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.byazt.eu.uj.c(da.this.n, "show"));
                    sb.append("展示的广告类型：");
                    sb.append(com.byazt.yl.c.c(da.this.uj.getAdNetworkPlatformId()));
                    sb.append(",slotId：");
                    sb.append(da.this.uj.getAdNetworkSlotId());
                    sb.append(",slotType:");
                    sb.append(da.this.uj.getAdNetworkSlotType());
                    sb.append(",isReady()：");
                    da daVar8 = da.this;
                    sb.append(daVar8.uj.isReady(daVar8.n));
                    sb.append("，是否为缓存广告:");
                    sb.append(da.this.uj.isCacheSuccess());
                    com.byazt.eu.tt.c(MediationConstant.TAG, sb.toString());
                    da.this.uj.showAd(activity, obj, str);
                    com.byazt.hr.u.c().tt(da.this.n);
                    com.byazt.hr.t tVarC = com.byazt.hr.t.c();
                    da daVar9 = da.this;
                    tVarC.tt(daVar9.n, daVar9.uj.getAdNetworkSlotId());
                    da.this.t = true;
                    if (da.this.uj != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(da.this.uj);
                        if (da.this.f28639a.my() == 7 || da.this.f28639a.my() == 10) {
                            com.byazt.vy.c cVarC3 = com.byazt.vy.c.c();
                            com.byazt.ll.tt ttVar4 = da.this.f28639a;
                            cVarC3.c(ttVar4, com.byazt.vy.c.c(ttVar4, arrayList, listC));
                        }
                        da.this.c(arrayList);
                    }
                    da daVar10 = da.this;
                    com.byazt.ng.a.c(daVar10.uj, daVar10.f28639a, false, daVar10.rl() ? 1 : 0);
                }
            }
        });
    }

    private boolean c(List<com.byazt.nbs.da> list, List<com.byazt.yl.ve> list2, boolean z, Activity activity, Object obj, String str) {
        com.byazt.yl.ve veVar;
        com.byazt.yl.ve veVar2;
        HashMap<String, com.byazt.yl.ve> mapTt = tt(list2);
        for (com.byazt.nbs.da daVar : list) {
            if (daVar != null) {
                String strRh = daVar.rh();
                com.byazt.yl.ve veVar3 = mapTt.get(strRh);
                if (veVar3 != null) {
                    if (z) {
                        if (veVar3.isCacheSuccess() && tt(veVar3, activity, obj, str)) {
                            return true;
                        }
                    } else if (tt(veVar3, activity, obj, str)) {
                        return true;
                    }
                }
                if (daVar.gt() && com.byazt.hk.c.c().uj(this.n, strRh, this.f28639a.n()) && com.byazt.hk.c.c().c(strRh, this.f28639a, false) == 3) {
                    com.byazt.hk.c cVarC = com.byazt.hk.c.c();
                    com.byazt.ll.tt ttVar = this.f28639a;
                    List<com.byazt.ix.sp> listC = cVarC.c(strRh, ttVar, ttVar.n());
                    if (listC != null && listC.size() > 0 && (veVar2 = listC.get(0).c) != null) {
                        if (z) {
                            if (veVar2.isCacheSuccess() && ve(veVar2, activity, obj, str)) {
                                return true;
                            }
                        } else if (ve(veVar2, activity, obj, str)) {
                            return true;
                        }
                    }
                }
            }
        }
        if (z && this.uj == null) {
            for (com.byazt.nbs.da daVar2 : list) {
                if (daVar2 != null) {
                    String strRh2 = daVar2.rh();
                    com.byazt.yl.ve veVar4 = mapTt.get(strRh2);
                    if (veVar4 != null && tt(veVar4, activity, obj, str)) {
                        return true;
                    }
                    if (daVar2.gt() && com.byazt.hk.c.c().uj(this.n, strRh2, this.f28639a.n()) && com.byazt.hk.c.c().c(strRh2, this.f28639a, false) == 3) {
                        com.byazt.hk.c cVarC2 = com.byazt.hk.c.c();
                        com.byazt.ll.tt ttVar2 = this.f28639a;
                        List<com.byazt.ix.sp> listC2 = cVarC2.c(strRh2, ttVar2, ttVar2.n());
                        if (listC2 != null && listC2.size() > 0 && (veVar = listC2.get(0).c) != null && ve(veVar, activity, obj, str)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
