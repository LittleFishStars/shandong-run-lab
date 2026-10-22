package com.byazt.om;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.vx.h;
import com.byazt.vx.p;
import com.byazt.vx.rh;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 554, 13})
public class tt implements com.byazt.pq.c, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28875a;
    public Map<Integer, List<com.byazt.nbs.da>> c;
    public com.byazt.py.c da;
    public Handler i;
    public com.byazt.nbs.tt n;
    public com.byazt.ll.tt sp;
    public com.byazt.iz.c tt;
    public com.byazt.iz.tt uj;
    public List<Integer> x;
    public final List<com.byazt.nbs.da> ve = new CopyOnWriteArrayList();
    public boolean sl = false;

    public tt() {
        Looper looperTt = com.byazt.eu.n.tt();
        if (looperTt != null) {
            this.i = new Handler(looperTt) { // from class: com.byazt.om.tt.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    tt.this.c(message);
                }
            };
        } else {
            com.byazt.eu.n.c();
            this.i = new Handler(com.byazt.eu.n.tt()) { // from class: com.byazt.om.tt.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    tt.this.c(message);
                }
            };
        }
    }

    private void uj(int i) {
        if (this.uj.uj() || n()) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "已经触发过成功、失败回调...");
            return;
        }
        if (this.uj.da()) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "已经触发过destroy操作...");
            return;
        }
        if (tt()) {
            return;
        }
        if (i >= this.x.size()) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "第 " + i + " 层没有广告可以请求...");
            return;
        }
        int iIntValue = this.x.get(i).intValue();
        if (this.tt.ve(iIntValue)) {
            ve(i + 1);
            return;
        }
        if (com.byazt.qv.sp.tt(iIntValue) && this.tt.tt() == -1) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "开启serverBidding exchange 请求....");
            c(this.c.get(Integer.valueOf(iIntValue)));
            c(i);
            return;
        }
        this.tt.tt(iIntValue);
        c(iIntValue, i);
        if (com.byazt.qv.sp.ve(iIntValue) || com.byazt.qv.sp.tt(iIntValue)) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "第 " + i + "层 ClientBidding,ServerBidding 广告，levelSort：" + iIntValue + "，同时请求下一层广告...");
            ve(i + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(int i) {
        if (i < 0) {
            return;
        }
        if (!com.byazt.qv.sp.c(i, this.x)) {
            uj(i);
            return;
        }
        int iLt = this.n.lt();
        com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "the " + i + " level is first level normal ad and ParallelNum:" + iLt);
        for (int i2 = 0; i2 < iLt; i2++) {
            uj(i + i2);
        }
    }

    public boolean n() {
        if (this.uj.n()) {
            return (this.sl && com.byazt.fid.c.c(this.n)) ? false : true;
        }
        return false;
    }

    @Override // com.byazt.om.c
    public void tt(c.InterfaceC0486c interfaceC0486c) {
        com.byazt.pl.uj ujVarC = com.byazt.pl.n.c();
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        ((com.byazt.pl.a) ujVarC).c(this.uj.bx(), jElapsedRealtime, this.sp, this.n, new com.byazt.pl.uj.c() { // from class: com.byazt.om.tt.3
            @Override // com.byazt.pl.uj.c
            public void c(com.byazt.pl.tt ttVar) {
                Map<Integer, List<com.byazt.nbs.da>> map = tt.this.c;
                List<com.byazt.nbs.da> list = map != null ? map.get(0) : null;
                tt ttVar2 = tt.this;
                ttVar2.c(ttVar2.sp, list, ttVar, jElapsedRealtime);
            }
        });
    }

    @Override // com.byazt.om.c
    public void c(c.InterfaceC0486c interfaceC0486c) {
        com.byazt.iz.tt ttVarC = interfaceC0486c.c();
        this.uj = ttVarC;
        ttVarC.c(this.i);
        this.tt = this.uj.nu();
        this.n = this.uj.m();
        com.byazt.ll.tt ttVarGu = this.uj.gu();
        this.sp = ttVarGu;
        this.f28875a = ttVarGu.gt();
        this.c = this.n.md();
        ArrayList arrayList = new ArrayList();
        this.x = arrayList;
        arrayList.addAll(this.c.keySet());
        com.byazt.oi.tt.c(this.x);
        this.tt.c(this.x);
        this.tt.sp(this.n.zm());
        List<com.byazt.nbs.da> listC = com.byazt.qv.sp.c(this.n.l());
        List<com.byazt.nbs.da> listTt = com.byazt.qv.sp.tt(this.n.l());
        this.tt.x(listC == null ? 0 : listC.size());
        this.tt.i(listTt == null ? 0 : listTt.size());
        Handler handler = this.i;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(6, this.n.aw());
        }
        if (!this.uj.zm()) {
            com.byazt.ng.a.c(this.sp, this.n.lo(), !this.uj.yv(), this.uj.pf().c, 0, (Map<String, Object>) null);
        }
        if (this.n.z()) {
            interfaceC0486c.c(interfaceC0486c.c());
        } else {
            if (com.byazt.eu.tt.tt()) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "开始加载广告 num:" + this.n.zm());
            }
            ve(0);
        }
        com.byazt.qe.tt.c(com.byazt.bp.tt.tt()).c(1);
    }

    public boolean tt() {
        return tt(null, 3);
    }

    private void ve(com.byazt.nbs.da daVar, int i) {
        int i2;
        if (daVar == null || this.i == null) {
            return;
        }
        if (daVar.cu()) {
            i2 = 1;
        } else if (daVar.or() || daVar.qp()) {
            i2 = 2;
        } else {
            i2 = daVar.zb() ? 3 : 4;
        }
        if (daVar.pf()) {
            this.i.removeMessages(i2, rh.c(i));
        } else {
            this.i.removeMessages(i2);
        }
    }

    public boolean tt(com.byazt.nbs.da daVar, int i) {
        if (this.uj.uj() || n()) {
            return true;
        }
        if (this.tt.n()) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "触发总超时或全部代码位响应结束.....totalTimeout：" + this.tt.n() + "  allWtfFinish:" + this.tt.x());
            if (p.c(this.uj.sl()) && p.c(this.uj.t()) && p.c(this.uj.yp())) {
                if (com.byazt.fid.c.tt(this.n)) {
                    com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "总加载时间超时.......isCallback:true");
                    if (com.byazt.fid.c.c(this.uj, this.x, this.c)) {
                        ve();
                        return true;
                    }
                }
                this.sl = true;
                c(new com.byazt.pp.c(10003, com.byazt.pp.c.c(10003)));
            } else {
                ve();
            }
            return true;
        }
        if (this.tt.x()) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "全部广告完成响应...");
            if (p.c(this.uj.sl()) && p.c(this.uj.t()) && p.c(this.uj.yp())) {
                c(new com.byazt.pp.c(20005, com.byazt.pp.c.c(20005)));
            } else {
                ve();
            }
            return true;
        }
        if (this.uj.rh()) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "p层广告已经满足返回条件...");
            ve();
            return true;
        }
        if (!(this.n.zb() && this.tt.ve()) && this.n.zb()) {
            return false;
        }
        if (daVar == null) {
            if (this.uj.my() && this.uj.rl()) {
                com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "p层&普通层广告 已经满足返回条件 V1 .........");
                ve();
                return true;
            }
            if (!this.uj.gt() || !this.tt.i() || !this.tt.da() || !this.uj.qy()) {
                return false;
            }
            com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "p层&普通&Bidding层广告 已经满足返回条件 V2 .........");
            ve();
            return true;
        }
        if (this.uj.my() && this.uj.rl()) {
            for (com.byazt.yl.ve veVar : this.uj.t()) {
                com.byazt.gp.c cVarC = com.byazt.gp.uj.c(this.n);
                com.byazt.iz.tt ttVar = this.uj;
                Map<Integer, List<com.byazt.nbs.da>> map = this.c;
                if (cVarC.c(ttVar, veVar, map == null ? null : map.get(Integer.valueOf(com.byazt.qv.sp.c(this.n, veVar))))) {
                    com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "p层&普通层广告 已经满足返回条件 V3 .........");
                    ve();
                    return true;
                }
            }
            return false;
        }
        if (!this.uj.gt() || !this.tt.i() || !this.tt.da() || !this.uj.qy()) {
            return false;
        }
        com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "p层&普通&Bidding层广告 已经满足返回条件 V4 .........");
        ve();
        return true;
    }

    public void ve() {
        this.sl = false;
        this.uj.x();
    }

    private void ve(List<com.byazt.yl.ve> list) {
        if (list == null) {
            return;
        }
        for (com.byazt.yl.ve veVar : list) {
            if (veVar != null) {
                com.byazt.ix.uj.c().c(this.f28875a, new com.byazt.ix.sp(veVar, this.uj.eo(), this.sp));
            }
        }
    }

    public void uj() {
        this.uj.i();
    }

    private void c(int i, int i2) {
        long jSv;
        Handler handler;
        Map<Integer, List<com.byazt.nbs.da>> map = this.c;
        if (map == null) {
            return;
        }
        final List<com.byazt.nbs.da> list = map.get(Integer.valueOf(i));
        StringBuilder sb = new StringBuilder();
        sb.append(com.byazt.eu.uj.c(this.n));
        sb.append("loadLevelWaterFall start...执行当前加载层级 ：");
        sb.append(i2);
        sb.append(" levelSort:");
        sb.append(i);
        sb.append("  waterFallConfig.size:");
        sb.append(list == null ? 0 : list.size());
        com.byazt.eu.tt.tt(MediationConstant.TAG, sb.toString());
        if (p.c(list)) {
            return;
        }
        this.tt.c(i, list.size());
        if (com.byazt.qv.sp.ve(i)) {
            jSv = this.n.gu();
        } else {
            jSv = this.n.sv();
        }
        Message messageObtain = Message.obtain();
        if (com.byazt.qv.sp.c(i)) {
            messageObtain.what = 1;
        } else if (com.byazt.qv.sp.ve(i)) {
            messageObtain.what = 2;
        } else if (com.byazt.qv.sp.tt(i)) {
            messageObtain.what = 3;
        } else {
            messageObtain.what = 4;
            messageObtain.obj = rh.c(i);
        }
        messageObtain.arg1 = i;
        Handler handler2 = this.i;
        if (handler2 != null) {
            handler2.sendMessageDelayed(messageObtain, jSv);
        }
        long jBx = this.n.bx();
        if (jBx != 0 && (handler = this.i) != null) {
            handler.removeMessages(5);
            this.i.sendEmptyMessageDelayed(5, jBx);
        }
        for (final int i3 = 0; i3 < list.size(); i3++) {
            try {
                com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.om.tt.4
                    @Override // java.lang.Runnable
                    public void run() {
                        tt.this.c((com.byazt.nbs.da) list.get(i3), list.size());
                    }
                });
                if (this.uj.yv()) {
                    this.uj.d();
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
    }

    public int tt(int i) {
        int iIndexOf;
        List<Integer> list = this.x;
        if (list == null || (iIndexOf = list.indexOf(Integer.valueOf(i))) == -1) {
            return -1;
        }
        return iIndexOf + 1;
    }

    private void tt(List<com.byazt.yl.ve> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        String adNetworkSlotId = list.get(0).getAdNetworkSlotId();
        if (list.get(0).canAdReuse() && com.byazt.hk.c.c().n(this.f28875a, adNetworkSlotId, this.sp.n()) == 1) {
            ArrayList arrayList = new ArrayList();
            for (com.byazt.yl.ve veVar : list) {
                if (veVar != null) {
                    arrayList.add(new com.byazt.ix.sp(veVar, 0L, this.sp));
                }
            }
            if (arrayList.size() > 0) {
                com.byazt.yl.ve veVar2 = ((com.byazt.ix.sp) arrayList.get(0)).c;
                com.byazt.eu.tt.tt(MediationConstant.TAG, "--==-- 广告复用:广告缓存成功 -------" + veVar2.getAdNetWorkName() + ", adType: " + com.byazt.yl.c.c(veVar2.getAdType(), veVar2.getSubAdType()) + ", adnSlotId: " + veVar2.getAdNetworkSlotId() + ", ad个数: " + arrayList.size());
                com.byazt.hk.c.c().c(adNetworkSlotId, (List<com.byazt.ix.sp>) arrayList, false);
            }
        }
    }

    public void c(com.byazt.nbs.da daVar, int i) {
        if (daVar != null && this.sp != null) {
            c(daVar.rh(), daVar.z(), daVar.m(), com.byazt.yl.c.c(this.sp.my(), daVar.a()), 0, "广告请求中");
        }
        com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "开始 某一层级的waterFallConfig请求 WaterFallConfig:" + daVar.toString());
        com.byazt.dv.tt ttVarC = com.byazt.dv.tt.c(daVar, this);
        ttVarC.ve(1);
        ttVarC.tt(1);
        ttVarC.c(i);
        ttVarC.c(!this.uj.yv());
        ttVarC.c(SystemClock.elapsedRealtime());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.byazt.xt.tt());
        arrayList.add(new com.byazt.xt.sp());
        arrayList.add(new com.byazt.xt.uj());
        arrayList.add(new com.byazt.xt.a());
        arrayList.add(new com.byazt.xt.ve());
        new com.byazt.xt.n(arrayList).c(this.uj, ttVarC);
    }

    public void c(final List<com.byazt.nbs.da> list) {
        final Context context = this.uj.getContext();
        if (context != null) {
            com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.om.tt.5
                @Override // java.lang.Runnable
                public void run() {
                    tt ttVar = tt.this;
                    ttVar.c(context, ttVar.sp, list, !tt.this.uj.yv());
                }
            });
        }
    }

    public void c(final int i) {
        com.byazt.py.c cVarC = com.byazt.py.n.c(this.n);
        this.da = cVarC;
        Handler handler = this.i;
        com.byazt.nbs.tt ttVar = this.n;
        cVarC.c(handler, ttVar, new com.byazt.py.tt(ttVar, new Runnable() { // from class: com.byazt.om.tt.6
            @Override // java.lang.Runnable
            public void run() {
                tt.this.ve(i + 1);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        int i = message.arg1;
        switch (message.what) {
            case 1:
            case 4:
                StringBuilder sb = new StringBuilder();
                sb.append(com.byazt.eu.uj.c(this.n));
                sb.append(message.what == 1 ? "P层" : "普通层");
                sb.append("广告触发层超时.........levelSort:");
                sb.append(i);
                com.byazt.eu.tt.uj(MediationConstant.TAG, sb.toString());
                com.byazt.iz.tt ttVar = this.uj;
                if (ttVar != null) {
                    com.byazt.tjo.a.c(ttVar.ve(), "t_out_" + this.uj.c().incrementAndGet(), this.uj.cu());
                }
                this.tt.uj(i);
                if (tt()) {
                    return;
                }
                ve(tt(i));
                return;
            case 2:
                com.byazt.iz.tt ttVar2 = this.uj;
                if (ttVar2 != null) {
                    com.byazt.tjo.a.c(ttVar2.ve(), "cb_t_out" + this.uj.c().incrementAndGet(), this.uj.cu());
                }
                break;
            case 3:
                break;
            case 5:
                com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "触发最小层超时.........levelSort:" + i);
                tt();
                return;
            case 6:
                com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "触发总超时.........");
                com.byazt.iz.tt ttVar3 = this.uj;
                if (ttVar3 != null) {
                    com.byazt.tjo.a.c(ttVar3.ve(), "total_t_out" + this.uj.c().incrementAndGet(), this.uj.cu());
                }
                this.tt.uj();
                this.uj.pf().f28813a = true;
                tt();
                return;
            default:
                return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.byazt.eu.uj.c(this.n));
        sb2.append(message.what == 2 ? "ClientBidding层" : "ServerBidding层层");
        sb2.append("广告触发层超时.........levelSort:");
        sb2.append(i);
        com.byazt.eu.tt.uj(MediationConstant.TAG, sb2.toString());
        this.tt.uj(i);
        tt();
    }

    @Override // com.byazt.pq.c
    public void c(List<com.byazt.yl.ve> list, com.byazt.nbs.da daVar) {
        if (p.c(list) || daVar == null) {
            return;
        }
        c(list, this.n);
        c(daVar.rh(), daVar.z(), daVar.m(), com.byazt.yl.c.c(daVar.u(), daVar.a()), 0, "广告加载成功");
        com.byazt.oi.ve.c(this.f28875a, daVar, !p.tt(list) ? list.get(0) : null);
        tt(list);
        int iC = com.byazt.qv.sp.c(this.n, daVar);
        if (daVar.pf() && com.byazt.ye.c.c(this.tt, this.ve, daVar.rh())) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "返回的普通广告被server Bidding过滤了......slotId:" + daVar.rh());
            this.uj.u().addAll(list);
            return;
        }
        com.byazt.qv.c.c(this.uj, list, false);
        this.tt.c(iC, daVar.rh());
        if (this.uj.yv()) {
            ve(list);
        }
        if (this.tt.n()) {
            c((List<com.byazt.yl.ve>) null, new com.byazt.pp.c(10012, "load ad timeout !!!"));
        } else {
            c(list, (com.byazt.pp.c) null);
        }
        this.uj.tt(list);
        if (this.uj.sp() && !this.uj.yv() && !this.uj.zm()) {
            this.uj.uj(daVar);
        }
        if (tt(daVar, 1) || this.tt.a(iC) != 0 || daVar.nb()) {
            return;
        }
        int iTt = tt(iC);
        ve(daVar, iC);
        com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "onAdLoaded levelSort: " + iC + " 广告全部响应结束&不满足返回条件，直接请求下一层广告 nextIdx：" + iTt);
        ve(iTt);
    }

    @Override // com.byazt.pq.c
    public void c(com.byazt.pp.c cVar, com.byazt.nbs.da daVar) {
        if (daVar == null) {
            return;
        }
        c((List<com.byazt.yl.ve>) null, cVar);
        if (cVar != null) {
            c(daVar.rh(), daVar.nu(), daVar.m(), com.byazt.yl.c.c(daVar.u(), daVar.a()), cVar.ve, cVar.uj);
        }
        com.byazt.oi.ve.c(cVar, daVar);
        if (daVar.pf() && com.byazt.ye.c.c(this.tt, this.ve, daVar.rh())) {
            return;
        }
        int iC = com.byazt.qv.sp.c(this.n, daVar);
        this.tt.c(iC, daVar.rh());
        if (tt(daVar, 2) || this.tt.n(iC) || this.tt.a(iC) != 0 || daVar.nb()) {
            return;
        }
        int iTt = tt(iC);
        ve(daVar, iC);
        com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "onAdFailed levelSort " + iC + " 广告全部响应结束&不满足返回条件，直接请求下一层广告 nextIdx：" + iTt);
        ve(iTt);
    }

    @Override // com.byazt.pq.c
    public void c() {
        com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "onAdVideoCache.....");
        uj();
    }

    public void c(com.byazt.pp.c cVar) {
        this.uj.c(cVar);
    }

    public void c(List<com.byazt.yl.ve> list, com.byazt.pp.c cVar) {
        this.uj.c(list, cVar);
    }

    public void c(Context context, final com.byazt.ll.tt ttVar, final List<com.byazt.nbs.da> list, boolean z) {
        com.byazt.pl.uj ujVarC = com.byazt.pl.n.c();
        if (ujVarC != null) {
            this.tt.c(0);
            this.uj.pf().uj = true;
            final com.byazt.pl.ve veVar = new com.byazt.pl.ve();
            veVar.c = ttVar;
            veVar.tt = list;
            veVar.uj = this.n;
            veVar.f28947a = z;
            veVar.sp = SystemClock.elapsedRealtime();
            veVar.x = this.uj;
            veVar.n = ttVar != null ? ttVar.ve() : 1;
            ujVarC.c(this.uj.gr(), context, veVar, new com.byazt.pl.uj.c() { // from class: com.byazt.om.tt.7
                @Override // com.byazt.pl.uj.c
                public void c(com.byazt.pl.tt ttVar2) {
                    tt.this.c(ttVar, (List<com.byazt.nbs.da>) list, ttVar2, veVar.sp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.ll.tt ttVar, List<com.byazt.nbs.da> list, com.byazt.pl.tt ttVar2, long j) {
        com.byazt.py.c cVar;
        if (this.uj != null && ttVar2 != null && !TextUtils.isEmpty(ttVar2.uj)) {
            this.uj.pf().c = ttVar2.uj;
        }
        com.byazt.nbs.tt ttVar3 = this.n;
        if (ttVar3 != null && ttVar2 != null) {
            ttVar3.x().put("price_source", Integer.valueOf(ttVar2.u));
        }
        if (ttVar2 != null) {
            com.byazt.ng.a.c(ttVar, ttVar2, this.tt.n() ? 1 : 0);
            com.byazt.iz.tt ttVar4 = this.uj;
            if (ttVar4 != null) {
                com.byazt.tjo.a.c(ttVar4.ve(), "ret_sb", this.uj.cu());
            }
        }
        if (ttVar2 != null && !p.c(ttVar2.tt)) {
            this.tt.c(1);
            if (this.uj.uj() || this.uj.n()) {
                return;
            }
            this.ve.clear();
            this.ve.addAll(ttVar2.tt);
            Handler handler = this.i;
            if (handler != null) {
                handler.removeMessages(1);
                this.i.removeMessages(4);
                this.i.removeMessages(5);
            }
            h.c(ttVar2.tt);
            this.c = com.byazt.qv.sp.c(ttVar2.tt, this.n.yp());
            ArrayList arrayList = new ArrayList();
            this.x = arrayList;
            arrayList.addAll(this.c.keySet());
            com.byazt.oi.tt.c(this.x);
            this.tt.c(this.x);
            this.tt.c(ttVar2.tt, com.byazt.qv.sp.c(this.n.l()), com.byazt.qv.sp.ve(this.n.l()));
            com.byazt.ye.c.c(this.n, this.uj, ttVar2.tt);
            com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "serverBidding响应回来..........开始从头开始请求waterFallConfig  代码位总数量：" + ttVar2.tt.size());
            ve(0);
            tt();
        } else {
            this.tt.c(2);
            if (this.uj.uj() || this.uj.n()) {
                return;
            }
            com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "serverBidding响应失败了.......... ");
            this.tt.tt(0);
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    com.byazt.nbs.da daVar = list.get(i);
                    this.tt.c(com.byazt.qv.sp.c(this.n, daVar), daVar.rh());
                }
            }
            if (!tt() && (cVar = this.da) != null) {
                cVar.c();
            }
        }
        if (ttVar2 != null) {
            com.byazt.tjo.a.c(ttVar2.sl, "0-req", j);
        }
        if (this.n != null && ttVar2 != null) {
            com.byazt.psp.tt.uj().c(ttVar2.t, ttVar2.yp, this.n.nb(), this.n.cu());
        }
        if (ttVar2 == null || !ttVar2.ve) {
            return;
        }
        com.byazt.qe.tt.c(com.byazt.bp.tt.tt()).c().c(1);
    }

    public void c(List<com.byazt.yl.ve> list, com.byazt.nbs.tt ttVar) {
        com.byazt.psp.uj.c(list, ttVar);
        com.byazt.bg.c.c(list, ttVar);
    }

    public void c(String str, String str2, String str3, String str4, int i, String str5) {
        com.byazt.pp.tt ttVar = this.uj.p().get(str);
        if (ttVar == null) {
            ttVar = new com.byazt.pp.tt();
        }
        ttVar.tt(str).ve(str2).uj(str3).c(i).n(str5).c(str4);
        this.uj.p().put(str, ttVar);
    }
}
