package com.byazt.hz;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.byazt.nr.m;
import com.byazt.vx.nu;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 67})
public class u extends tt implements com.byazt.zq.n {
    public boolean c;
    public boolean gt;
    public View m;
    public com.byazt.ko.uj my;
    public com.byazt.ko.ve nu;
    public com.byazt.ko.tt rh;
    public boolean tt;

    public u(Context context) {
        super(context);
        this.c = false;
        this.tt = false;
        this.gt = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(ViewGroup viewGroup) {
        boolean z;
        List<com.byazt.ix.sp> listC;
        com.byazt.yl.ve veVar;
        com.byazt.ng.a.c(this.f28639a);
        List<com.byazt.nbs.da> listTt = null;
        if (this.t) {
            com.byazt.ng.a.c((List<com.byazt.yl.ve>) null, this.f28639a, 0);
            ve(new com.byazt.pp.c(40052, com.byazt.pp.c.c(40052)));
            return;
        }
        int iTt = tt.tt(this.n);
        if (iTt != 0) {
            com.byazt.ng.a.c((List<com.byazt.yl.ve>) null, this.f28639a, iTt);
            ve(new com.byazt.pp.c(iTt, com.byazt.pp.c.c(iTt)));
            return;
        }
        List<com.byazt.yl.ve> listC2 = this.ve.c(true);
        this.ve.c(listC2);
        if (viewGroup == null) {
            com.byazt.ng.a.c(listC2, this.f28639a, 0);
            ve(new com.byazt.pp.c(40052, com.byazt.pp.c.c(40052)));
            return;
        }
        try {
            listTt = tt();
        } catch (Throwable th) {
            m.c(th);
        }
        if (listTt == null || listTt.size() <= 0) {
            z = false;
        } else {
            HashMap<String, com.byazt.yl.ve> mapTt = tt(listC2);
            Iterator<com.byazt.nbs.da> it = listTt.iterator();
            while (true) {
                if (it.hasNext()) {
                    com.byazt.nbs.da next = it.next();
                    if (next != null) {
                        String strRh = next.rh();
                        com.byazt.yl.ve veVar2 = mapTt.get(strRh);
                        if (veVar2 != null && veVar2.isReady(this.n) && !veVar2.isHasShown()) {
                            c(veVar2, viewGroup);
                        } else if (next.gt() && com.byazt.hk.c.c().uj(this.n, strRh, rh()) && com.byazt.hk.c.c().c(strRh, this.f28639a, false) == 3 && (listC = com.byazt.hk.c.c().c(strRh, this.f28639a, rh())) != null && listC.size() > 0 && (veVar = listC.get(0).c) != null && veVar.isReady(this.n) && !veVar.isHasShown()) {
                            com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.c(this.n, "show") + "adSlotId：" + veVar.getAdNetworkSlotId() + "，广告类型：" + com.byazt.yl.c.c(veVar.getAdNetworkPlatformId()) + ",isReady()：" + veVar.isReady(this.n));
                            tt(veVar);
                            c(veVar, viewGroup);
                        }
                        z = true;
                    }
                } else {
                    z = false;
                }
            }
        }
        boolean z2 = z;
        if (!z && listC2 != null && listC2.size() > 0) {
            for (com.byazt.yl.ve veVar3 : listC2) {
                if (veVar3 != null && veVar3.isReady(this.n) && !veVar3.isHasShown()) {
                    c(veVar3, viewGroup);
                    z2 = true;
                    break;
                }
            }
        }
        if (!z2) {
            com.byazt.ng.a.c(listC2, this.f28639a, 0);
            ve(new com.byazt.pp.c(40052, com.byazt.pp.c.c(40052)));
            return;
        }
        this.t = true;
        if (this.uj != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.uj);
            c(arrayList);
        }
        com.byazt.ng.a.c(this.uj, this.f28639a, false, 0);
    }

    public View a() {
        return null;
    }

    @Override // com.byazt.hz.tt
    public com.byazt.pp.ve f_() {
        if (this.gt) {
            return super.f_();
        }
        return null;
    }

    @Override // com.byazt.zq.n
    public Activity getActivity() {
        com.byazt.ko.uj ujVar = this.my;
        if (ujVar != null) {
            return ujVar.getActivity();
        }
        return null;
    }

    public void gr() {
        this.tt = true;
    }

    public void gu() {
        if (this.uj.canAdReuse() && com.byazt.hk.c.c().uj(this.n, this.uj.getAdNetworkSlotId(), rh())) {
            com.byazt.hk.c.c().c(this.uj.getAdNetworkSlotId(), this.f28639a, this.ve.zb(), true, this.ve.or(), this.ve.pf(), this.x.get());
        }
    }

    @Override // com.byazt.zq.n
    public void k_() {
        com.byazt.ko.uj ujVar = this.my;
        if (ujVar != null) {
            ujVar.tt();
        }
    }

    @Override // com.byazt.zq.n
    public void l_() {
        com.byazt.ko.uj ujVar = this.my;
        if (ujVar != null) {
            ujVar.ve();
        }
    }

    @Override // com.byazt.ko.tt
    public void n() {
        String strTt;
        long jCurrentTimeMillis;
        this.gt = true;
        com.byazt.ko.tt ttVar = this.rh;
        if (ttVar != null) {
            ttVar.n();
        }
        com.byazt.hr.u.c().sp(this.n);
        if (this.uj != null) {
            com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.c(this.n, "show_listen") + "adSlotId：" + this.uj.getAdNetworkSlotId() + "，广告类型：" + com.byazt.yl.c.c(this.uj.getAdNetworkPlatformId()));
            com.byazt.hr.sl.c().tt(this.n, this.uj.getAdNetworkSlotId());
        }
        com.byazt.yl.ve veVar = this.uj;
        if (veVar != null) {
            com.byazt.xx.ve.c(veVar.getAdnName(), this.n, this.uj.getAdNetworkSlotId());
        }
        gu();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strTt = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.ng.a.c(this.uj, this.f28639a, 0, strTt, jCurrentTimeMillis, false, gt());
        com.byazt.bg.c.sp(this.f28639a.gt());
        com.byazt.bg.c.ve(this.f28639a.gt());
        com.byazt.psp.uj.c(1, this.f28639a.gt(), this.uj.getAdType(), this.uj.getCpm());
        com.byazt.oi.ve.c(this.n, this.uj);
    }

    public View qy() {
        SoftReference<Context> softReference = this.x;
        Context context = softReference != null ? softReference.get() : null;
        if (this.m == null && context != null) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            tt(frameLayout);
            this.m = frameLayout;
            c(this.uj);
        }
        return this.m;
    }

    public boolean rl() {
        List<com.byazt.nbs.da> listTt;
        try {
            listTt = tt();
        } catch (Throwable th) {
            m.c(th);
            listTt = null;
        }
        return com.byazt.vx.t.c(this.ve.sl(), this.ve.yp(), this.ve.t(), this.f28639a, this.t, this.n, this.f28639a.n(), listTt);
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void sp() {
        com.byazt.ko.ve veVar = this.nu;
        if (veVar != null) {
            veVar.c();
        }
    }

    @Override // com.byazt.ko.tt
    public void uj() {
        String strTt;
        long jCurrentTimeMillis;
        com.byazt.ko.tt ttVar = this.rh;
        if (ttVar != null) {
            ttVar.uj();
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.uj)) {
            strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strTt = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.bg.c.n(this.f28639a.gt());
        com.byazt.yl.ve veVar = this.uj;
        com.byazt.ng.a.c(veVar, this.f28639a, 0, strTt, jCurrentTimeMillis, veVar.isClickListenRepeatOnce());
    }

    @Override // com.byazt.hz.tt
    public void ve() {
        if (this.uj == null) {
            com.byazt.hk.c cVarC = com.byazt.hk.c.c();
            List<com.byazt.yl.ve> listC = this.ve.c(false);
            String str = this.n;
            com.byazt.ll.tt ttVar = this.f28639a;
            cVarC.c(listC, str, ttVar, ttVar.n(), this.uj);
        }
        super.ve();
    }

    public void c(com.byazt.ll.tt ttVar, com.byazt.yf.sl slVar, com.byazt.ko.ve veVar) {
        c(ttVar);
        this.ve.c(slVar);
        this.nu = veVar;
        this.i = this;
        this.ve.zb().put("ad_load_timeout", Integer.valueOf(ttVar.m()));
        if (com.byazt.bp.tt.tt().pf()) {
            com.byazt.yf.da.c(new com.byazt.yf.m() { // from class: com.byazt.hz.u.1
                @Override // com.byazt.yf.m
                public void c() {
                    u.this.i();
                }
            });
        } else {
            i();
        }
    }

    private void ve(final com.byazt.pp.c cVar) {
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.u.3
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.rh != null) {
                    u.this.rh.c(cVar);
                }
            }
        });
    }

    public void c(com.byazt.ko.tt ttVar) {
        this.rh = ttVar;
    }

    public void c(com.byazt.ko.uj ujVar) {
        this.my = ujVar;
    }

    public void c(final ViewGroup viewGroup) {
        final String[] strArr = new String[1];
        final boolean zAw = com.byazt.bp.tt.tt().aw();
        if (zAw) {
            strArr[0] = nu.c();
        }
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.hz.u.2
            @Override // java.lang.Runnable
            public void run() {
                u.this.tt(viewGroup);
                if (zAw) {
                    u uVar = u.this;
                    com.byazt.ng.a.c(uVar.uj, uVar.f28639a, strArr[0], 2);
                }
            }
        });
    }

    private void c(com.byazt.yl.ve veVar, ViewGroup viewGroup) {
        this.uj = veVar;
        if (this.tt) {
            veVar.hideSkipButton();
        }
        com.byazt.zh.tt ttVar = this.u;
        if (ttVar != null) {
            this.uj.setTTAdAppDownloadListener(ttVar);
        }
        com.byazt.ocd.tt ttVar2 = this.yp;
        if (ttVar2 != null) {
            this.uj.setAdInteractionListener(ttVar2);
        }
        this.ve.uj(this.uj);
        this.uj.setHasShown(true);
        this.uj.setTTAdatperCallback(this.i);
        if (this.uj.canAdReuse() && com.byazt.hk.c.c().uj(this.n, this.uj.getAdNetworkSlotId(), rh())) {
            com.byazt.yl.ve veVar2 = this.uj;
            com.byazt.qv.a.c(veVar2, this.n, veVar2.getAdNetworkSlotId());
        }
        com.byazt.hk.c.c().c(this.ve.c(false), this.n, this.f28639a, rh(), this.uj);
        com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.c(this.n, "show") + "展示的广告类型：" + com.byazt.yl.c.c(this.uj.getAdNetworkPlatformId()) + ",slotId：" + this.uj.getAdNetworkSlotId() + ",slotType:" + this.uj.getAdNetworkSlotType());
        com.byazt.hr.u uVarC = com.byazt.hr.u.c();
        StringBuilder sb = new StringBuilder();
        sb.append(this.n);
        uVarC.tt(sb.toString());
        com.byazt.hr.t.c().tt(this.n, this.uj.getAdNetworkSlotId());
        this.uj.showSplashAd(viewGroup);
    }

    @Override // com.byazt.zq.n
    public void c() {
        com.byazt.ko.uj ujVar = this.my;
        if (ujVar != null) {
            ujVar.c();
        }
    }

    @Override // com.byazt.ko.tt
    public void c(@NonNull com.byazt.pp.c cVar) {
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
        com.byazt.ng.a.c(this.uj, this.f28639a, cVar, 1, 0, strTt, jCurrentTimeMillis);
        ve(cVar);
    }

    @Override // com.byazt.ko.tt
    public void c(int i) {
        com.byazt.ko.tt ttVar = this.rh;
        if (ttVar != null) {
            ttVar.c(1);
        }
        com.byazt.ix.uj.c().c(this.x.get(), this.n, rh());
    }

    @Override // com.byazt.hz.tt, com.byazt.ul.c
    public void tt(@NonNull com.byazt.pp.c cVar) {
        com.byazt.ko.ve veVar = this.nu;
        if (veVar != null) {
            veVar.c(cVar);
        }
    }

    public void c(ViewGroup viewGroup, Activity activity) {
        com.byazt.yl.ve veVar = this.uj;
        if (veVar != null) {
            veVar.showSplashCardView(viewGroup, activity);
        }
    }

    @Override // com.byazt.ko.tt
    public void tt(int i) {
        com.byazt.ko.tt ttVar = this.rh;
        if (ttVar != null) {
            ttVar.tt(i);
        }
        com.byazt.ix.uj.c().c(this.x.get(), this.n, rh());
    }
}
