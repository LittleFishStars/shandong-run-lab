package com.byazt.xt;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.hr.yp;
import com.byazt.nbs.da;
import com.byazt.nbs.i;
import com.byazt.vx.md;
import com.byazt.vx.nu;
import com.byazt.vx.p;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE, 54})
public class ve implements com.byazt.db.tt, c {
    public com.byazt.dv.tt c;
    public long sp;
    public com.byazt.iz.tt tt;
    public com.byazt.ll.tt uj;
    public i ve;
    public long x;
    public com.byazt.db.c n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f29192a = -1;

    @Override // com.byazt.db.tt
    public void nativeDislikeClick(com.byazt.yl.ve veVar, String str) {
        if (veVar == null || veVar.getAdType() != 5) {
            return;
        }
        com.byazt.ng.a.c(veVar, this.uj, str);
    }

    @Override // com.byazt.db.tt
    public void notifyLoadFail(com.byazt.pp.c cVar) {
        c(cVar, true);
    }

    @Override // com.byazt.db.tt
    public void notifyLoadSuccess(List<com.byazt.yl.ve> list) {
        long jCurrentTimeMillis;
        String strTt;
        if (list == null) {
            return;
        }
        if (this.f29192a == -1) {
            this.f29192a = SystemClock.elapsedRealtime();
        }
        this.sp = System.currentTimeMillis() - this.x;
        for (com.byazt.yl.ve veVar : list) {
            com.byazt.ll.tt ttVar = this.uj;
            com.byazt.dv.tt ttVar2 = this.c;
            com.byazt.qv.ve.c(veVar, ttVar, ttVar2, this.ve, ttVar2 != null ? c(ttVar2.u()) : "");
        }
        List<com.byazt.yl.ve> listC = c(list);
        if (listC.size() == 0) {
            c(new com.byazt.pp.c(50100, com.byazt.pp.c.c(50100)), false);
            return;
        }
        if (this.c != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (nu.c(this.c.x())) {
                strTt = nu.tt();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                jCurrentTimeMillis = -1;
                strTt = null;
            }
            int i = list.size() > 0 ? 20000 : 820001;
            if (this.c.c() || this.c.gr()) {
                for (com.byazt.yl.ve veVar2 : list) {
                    if (veVar2 != null) {
                        c(i, veVar2, 1, strTt, jCurrentTimeMillis);
                    }
                }
            } else {
                c(i, listC.get(0), listC.size(), strTt, jCurrentTimeMillis);
            }
            if (this.c.gu() && !p.tt(list)) {
                com.byazt.ng.a.c(list.get(0), this.uj, this.c.x(), this.sp);
                com.byazt.iz.tt ttVar3 = this.tt;
                if (ttVar3 != null) {
                    com.byazt.tjo.a.c(ttVar3.ve(), this.tt.tt(this.c.x()), this.tt.cu());
                }
            }
        }
        this.tt = null;
        tt(listC);
        if (this.c.x() != null) {
            if ((this.c.x().u() == 10 && this.c.x().a() == 1) || (this.c.x().u() == 7 && this.c.x().a() == 8)) {
                notifyVideoCache(listC, null);
            }
        }
    }

    @Override // com.byazt.db.tt
    public void notifyVideoCache(final List<com.byazt.yl.ve> list, com.byazt.pp.c cVar) {
        if (list != null) {
            for (com.byazt.yl.ve veVar : list) {
                if (veVar != null) {
                    veVar.setCacheSuccess(true);
                    com.byazt.ll.tt ttVar = this.uj;
                    com.byazt.dv.tt ttVar2 = this.c;
                    com.byazt.qv.ve.c(veVar, ttVar, ttVar2, this.ve, ttVar2 != null ? c(ttVar2.u()) : "");
                    c(veVar);
                }
            }
        }
        if (cVar != null && cVar.c == 30010 && com.byazt.lg.c.c()) {
            com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.xt.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ve.this.c != null && ve.this.c.gu()) {
                        com.byazt.ng.a.c(!p.tt(list) ? (com.byazt.yl.ve) list.get(0) : null, ve.this.uj, ve.this.c.x());
                    }
                    ve.this.c();
                }
            }, 1000L);
            return;
        }
        com.byazt.dv.tt ttVar3 = this.c;
        if (ttVar3 != null && ttVar3.gu()) {
            com.byazt.ng.a.c(!p.tt(list) ? list.get(0) : null, this.uj, this.c.x());
        }
        c();
    }

    private List<com.byazt.yl.ve> c(List<com.byazt.yl.ve> list) {
        String strTt;
        long jCurrentTimeMillis;
        ArrayList arrayList = new ArrayList();
        if (!p.c(list)) {
            arrayList.addAll(list);
        }
        if (this.c != null && !p.tt(list) && (this.c.c() || this.c.gr())) {
            for (com.byazt.yl.ve veVar : list) {
                md.c(veVar, this.c.x(), this.uj, true);
                double dHd = this.uj.hd();
                if (dHd > AudioStats.AUDIO_AMPLITUDE_NONE && dHd > veVar.getCpm()) {
                    arrayList.remove(veVar);
                    String strValueOf = String.valueOf(veVar.getCpm());
                    String levelTag = veVar.getLevelTag();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (nu.c(this.c.x())) {
                        strTt = nu.tt();
                        jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    } else {
                        strTt = null;
                        jCurrentTimeMillis = -1;
                    }
                    com.byazt.pp.c cVar = new com.byazt.pp.c(50100, com.byazt.pp.c.c(50100));
                    cVar.c("is_dex_adapter", Integer.valueOf(this.c.pf() ? 1 : 0));
                    com.byazt.ng.a.c(cVar, this.uj, this.c.x(), this.c.ve(), this.c.sp(), this.c.a(), c(this.c.u()), this.sp, strValueOf, levelTag, strTt, jCurrentTimeMillis);
                    com.byazt.iz.tt ttVar = this.tt;
                    if (ttVar != null) {
                        com.byazt.tjo.a.c(ttVar.ve(), this.tt.ve(veVar), this.tt.cu());
                    }
                }
            }
        }
        return arrayList;
    }

    private void tt(List<com.byazt.yl.ve> list) {
        com.byazt.dv.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c(list, ttVar.x());
        }
        c(new Runnable() { // from class: com.byazt.xt.ve.2
            @Override // java.lang.Runnable
            public void run() {
                if (ve.this.c != null) {
                    com.byazt.xx.ve.ve(ve.this.c.u(), ve.this.c.tt(), ve.this.c.t());
                }
            }
        });
    }

    private void c(com.byazt.pp.c cVar, boolean z) {
        long jCurrentTimeMillis;
        String strTt;
        this.sp = System.currentTimeMillis() - this.x;
        com.byazt.dv.tt ttVar = this.c;
        if (ttVar != null && ttVar.x() != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (nu.c(this.c.x())) {
                strTt = nu.tt();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                jCurrentTimeMillis = -1;
                strTt = null;
            }
            if (!this.c.gu() && z) {
                cVar.c("is_dex_adapter", Integer.valueOf(this.c.pf() ? 1 : 0));
                com.byazt.ng.a.c(cVar, this.uj, this.c.x(), this.c.ve(), this.c.sp(), this.c.a(), c(this.c.u()), this.sp, (String) null, (String) null, strTt, jCurrentTimeMillis);
            } else {
                com.byazt.ng.a.c(cVar, this.uj, this.c.x(), this.c.ve(), this.c.sp(), this.c.a(), c(this.c.u()), this.sp);
            }
            da daVarX = this.c.x();
            com.byazt.iz.tt ttVar2 = this.tt;
            if (ttVar2 != null) {
                com.byazt.tjo.a.c(ttVar2.ve(), this.tt.ve(daVarX), this.tt.cu());
            }
            this.tt = r13;
            if (cVar != null) {
                if (this.uj != null) {
                    if (com.byazt.yl.tt.tt) {
                        StringBuilder sb = new StringBuilder();
                        com.byazt.ll.tt ttVar3 = this.uj;
                        sb.append(com.byazt.eu.uj.c(ttVar3 != null ? ttVar3.gt() : "", "fill_fail"));
                        sb.append("AdNetWorkName[");
                        sb.append(daVarX.z());
                        sb.append("] AdUnitId[");
                        sb.append(daVarX.rh());
                        sb.append("] AdType[");
                        sb.append(com.byazt.yl.c.c(this.uj.my(), daVarX.a(), daVarX));
                        sb.append("] 请求失败 (loadSort=");
                        sb.append(daVarX.yv());
                        sb.append(",showSort=");
                        sb.append(daVarX.p());
                        sb.append("),error=");
                        sb.append(cVar.ve);
                        sb.append(",msg=");
                        sb.append(cVar.uj);
                        com.byazt.eu.tt.uj(MediationConstant.TAG, sb.toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        com.byazt.ll.tt ttVar4 = this.uj;
                        sb2.append(com.byazt.eu.uj.c(ttVar4 != null ? ttVar4.gt() : "", "fill_fail"));
                        sb2.append("AdNetWorkName[");
                        sb2.append(daVarX.z());
                        sb2.append("] AdType[");
                        sb2.append(com.byazt.yl.c.c(this.uj.my(), daVarX.a(), daVarX));
                        sb2.append("] 请求失败 error=");
                        sb2.append(cVar.ve);
                        sb2.append(",msg=");
                        sb2.append(cVar.uj);
                        com.byazt.eu.tt.uj(MediationConstant.TAG, sb2.toString());
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(cVar.ve);
                String string = sb3.toString();
                String strC = com.byazt.lg.c.c(this.c.x().z(), cVar.uj);
                yp ypVarC = yp.c();
                com.byazt.ll.tt ttVar5 = this.uj;
                if (ypVarC.c(ttVar5 == null ? null : ttVar5.gt(), this.c.x().nu())) {
                    yp ypVarC2 = yp.c();
                    com.byazt.ll.tt ttVar6 = this.uj;
                    ypVarC2.c(ttVar6 == null ? null : ttVar6.gt(), this.c.x().z(), this.c.x().rh(), com.byazt.lg.c.c(this.c.x().z(), string, strC));
                } else {
                    com.byazt.hr.ve.c().c(this.c.x().z(), this.c.x().rh(), com.byazt.lg.c.c(this.c.x().z(), string, strC));
                }
            }
        }
        c(cVar);
    }

    private void c(com.byazt.pp.c cVar) {
        com.byazt.dv.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c(cVar, ttVar.x());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.byazt.dv.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.i();
        }
    }

    private void c(Runnable runnable) {
        com.byazt.eu.n.c(runnable);
    }

    @Override // com.byazt.xt.c
    public void c(c.InterfaceC0584c interfaceC0584c) {
        if (interfaceC0584c == null) {
            return;
        }
        this.x = System.currentTimeMillis();
        this.c = interfaceC0584c.c();
        com.byazt.iz.tt ttVarTt = interfaceC0584c.tt();
        this.uj = ttVarTt.gu();
        this.ve = ttVarTt.pf();
        this.tt = ttVarTt;
        if (ttVarTt.getContext() == null) {
            com.byazt.pp.c cVar = new com.byazt.pp.c("request adn context is null");
            c(this.c, ttVarTt, cVar, "");
            notifyLoadFail(cVar);
        } else {
            if (this.c != null) {
                c(ttVarTt);
                return;
            }
            com.byazt.pp.c cVar2 = new com.byazt.pp.c("request adn waterfall request is null");
            c(this.c, ttVarTt, cVar2, "");
            notifyLoadFail(cVar2);
        }
    }

    private void c(com.byazt.dv.tt ttVar, com.byazt.iz.tt ttVar2, com.byazt.pp.c cVar, String str) {
        if (ttVar == null || ttVar2 == null || ttVar.x() == null) {
            return;
        }
        da daVarX = ttVar.x();
        String strC = TextUtils.isEmpty(str) ? com.byazt.hk.c.c().c(daVarX.rh()) : str;
        if (!daVarX.zb()) {
            com.byazt.ng.a.c(daVarX, this.uj, strC, ttVar.n(), ttVar.sp() == 4 ? 3 : 0, ttVar.ve(), ttVar.sp(), ttVar.a(), cVar, ttVar.uj(), ttVar2.pf().n, false, SystemClock.elapsedRealtime() - ttVar2.cu());
            com.byazt.tjo.a.c(ttVar2.ve(), ttVar2.c(daVarX), ttVar2.cu());
        } else if (daVarX.d() != null) {
            com.byazt.ng.a.c(daVarX, this.uj, strC);
            com.byazt.tjo.a.c(ttVar2.ve(), ttVar2.c(daVarX), ttVar2.cu());
        }
    }

    private void c(com.byazt.yl.ve veVar) {
        com.byazt.dv.tt ttVar;
        if (this.uj == null || (ttVar = this.c) == null || ttVar.x() == null) {
            return;
        }
        da daVarX = this.c.x();
        if (!this.c.gu() && veVar != null) {
            com.byazt.ng.a.c(this.uj, veVar, this.c.x());
        }
        if (com.byazt.yl.tt.tt) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.uj.gt(), "fill") + "AdNetWorkName[" + daVarX.z() + "] AdUnitId[" + daVarX.rh() + "] AdType[" + com.byazt.yl.c.c(this.uj.my(), daVarX.a(), daVarX) + "] 视频缓存成功 (loadSort=" + daVarX.yv() + ",showSort=" + daVarX.p() + ")");
            return;
        }
        com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.uj.gt(), "fill") + "AdNetWorkName[" + daVarX.z() + "] AdType[" + com.byazt.yl.c.c(this.uj.my(), daVarX.a(), daVarX) + "] 视频缓存成功 ");
    }

    private void c(int i, com.byazt.yl.ve veVar, int i2, String str, long j) {
        com.byazt.dv.tt ttVar;
        da daVar;
        if (this.uj == null || (ttVar = this.c) == null || ttVar.x() == null) {
            return;
        }
        da daVarX = this.c.x();
        String str2 = i == 20000 ? "load success" : "请求成功，但无广告可用";
        i iVar = this.ve;
        int i3 = (iVar == null || !iVar.f28813a) ? 0 : 1;
        if (this.c.gu() || veVar == null) {
            daVar = daVarX;
        } else {
            daVar = daVarX;
            com.byazt.ng.a.c(veVar, i, str2, this.sp, this.uj, this.c.ve(), i2, i3, str, j, this.f29192a != -1 ? SystemClock.elapsedRealtime() - this.f29192a : -1L);
            com.byazt.iz.tt ttVar2 = this.tt;
            if (ttVar2 != null) {
                com.byazt.tjo.a.c(ttVar2.ve(), this.tt.tt(veVar), this.tt.cu());
            }
        }
        if (com.byazt.yl.tt.tt) {
            StringBuilder sb = new StringBuilder();
            sb.append(com.byazt.eu.uj.c(this.uj.gt(), "fill"));
            sb.append("AdNetWorkName[");
            sb.append(daVar.z());
            sb.append("] AdUnitId[");
            sb.append(daVar.rh());
            sb.append("] AdType[");
            da daVar2 = daVar;
            sb.append(com.byazt.yl.c.c(this.uj.my(), daVar.a(), daVar2));
            sb.append("] 请求成功 (loadSort=");
            sb.append(daVar2.yv());
            sb.append(",showSort=");
            sb.append(daVar2.p());
            sb.append(")");
            com.byazt.eu.tt.tt(MediationConstant.TAG, sb.toString());
            return;
        }
        da daVar3 = daVar;
        com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.uj.gt(), "fill") + "AdNetWorkName[" + daVar3.z() + "] AdType[" + com.byazt.yl.c.c(this.uj.my(), daVar3.a(), daVar3) + "] 请求成功");
    }

    private void c(com.byazt.iz.tt ttVar) {
        com.byazt.dv.tt ttVar2;
        com.byazt.dv.tt ttVar3 = this.c;
        ttVar3.c(com.byazt.qv.ve.c(this.uj, ttVar3));
        this.c.tt(ttVar.m().nb());
        if (!this.c.da()) {
            if (this.c.sl()) {
                this.n = com.byazt.sp.uj.c(this.c, this);
            } else if (com.byazt.oi.ve.c(this.c.x())) {
                this.n = new com.byazt.sp.ve(this);
            }
        } else {
            Context context = com.byazt.bp.tt.getContext();
            com.byazt.dv.tt ttVar4 = this.c;
            com.byazt.sx.tt.c(context, ttVar4 != null ? ttVar4.u() : "");
            if (com.byazt.px.c.c(this.c.u()) == null) {
                com.byazt.ng.a.c("", ttVar.z(), this.uj, this.c.x(), new com.byazt.pp.c(49014, "创建自定义广告对象 configuration is null"));
            } else {
                com.byazt.nbs.c cVarC = com.byazt.ck.ve.c().c(this.c.u());
                if (cVarC == null) {
                    com.byazt.ng.a.c("", (com.byazt.yl.ve) null, (com.byazt.ll.tt) null, (da) null, new com.byazt.pp.c(49013, "创建自定义广告对象 adNetworkConfValue is null"));
                } else if (cVarC.uj() == null) {
                    com.byazt.ng.a.c("", (com.byazt.yl.ve) null, (com.byazt.ll.tt) null, (da) null, new com.byazt.pp.c(49013, "创建自定义广告对象 getGMCustomConfig is null"));
                } else {
                    com.byazt.ih.c cVarC2 = cVarC.uj().c(this.c.yv(), this.c.z());
                    if (cVarC2 == null) {
                        com.byazt.ng.a.c("", (com.byazt.yl.ve) null, (com.byazt.ll.tt) null, (da) null, new com.byazt.pp.c(49013, "创建自定义广告对象 adConfig is null"));
                    } else if (com.byazt.qv.ve.c(cVarC2)) {
                        this.n = com.byazt.sp.uj.c(cVarC2.c(), this.c, this);
                    } else {
                        com.byazt.ng.a.c("", (com.byazt.yl.ve) null, (com.byazt.ll.tt) null, (da) null, new com.byazt.pp.c(49013, "创建自定义广告对象 check className false className is " + cVarC2.c()));
                    }
                }
            }
        }
        com.byazt.db.c cVar = this.n;
        if (cVar != null) {
            String sdkVersion = cVar.getSdkVersion(this.c.u());
            if (!TextUtils.isEmpty(sdkVersion) && (ttVar2 = this.c) != null && !TextUtils.isEmpty(ttVar2.t()) && !this.c.da()) {
                com.byazt.hk.c.c().uj(this.c.t(), sdkVersion);
            }
            c(this.c, ttVar, null, sdkVersion);
            com.byazt.db.c cVar2 = this.n;
            Context context2 = ttVar.getContext();
            com.byazt.dv.tt ttVar5 = this.c;
            com.byazt.ll.tt ttVar6 = this.uj;
            cVar2.adnStartLoad(context2, ttVar5, ttVar6, com.byazt.qv.ve.c(ttVar5, ttVar6, ttVar.zb()));
            if (this.c.da()) {
                return;
            }
            com.byazt.hk.c.c().c(this.c.tt(), this.c.t(), this.c.x(), this.c.ve());
            return;
        }
        com.byazt.eu.tt.uj(MediationConstant.TAG, "**********【重要】" + this.c.u() + "创建失败，请检查adapter是否接入 **********");
        com.byazt.ng.a.c(this.c.x(), this.uj, this.c.sp(), this.c.a());
        c(this.c, ttVar, new com.byazt.pp.c("create adn loader fail"), "");
        notifyLoadFail(new com.byazt.pp.c("create adn loader fail"));
    }

    private String c(String str) {
        com.byazt.ly.uj ujVarC = com.byazt.px.tt.c().c(str);
        if (ujVarC != null) {
            return ujVarC.getNetworkSdkVersion();
        }
        return null;
    }
}
