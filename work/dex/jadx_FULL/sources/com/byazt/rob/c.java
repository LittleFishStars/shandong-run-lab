package com.byazt.rob;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.aas.nb;
import com.byazt.bzd.x;
import com.byazt.cf.sp;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.nc.da;
import com.byazt.nc.i;
import com.byazt.nc.sl;
import com.byazt.nc.z;
import com.byazt.nr.h;
import com.byazt.nr.m;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1211, 20})
public class c {
    public ic c;
    public Context tt;
    public AtomicBoolean ve = new AtomicBoolean(false);
    public AtomicBoolean uj = new AtomicBoolean(false);
    public AtomicBoolean n = new AtomicBoolean(false);

    public c(ic icVar, Context context) {
        this.c = icVar;
        this.tt = context;
    }

    public void uj(final int i, com.byazt.dj.tt ttVar, final ic icVar) {
        try {
            com.byazt.cf.tt.c().c(ttVar, tt(icVar, i), new com.byazt.cf.uj(new com.byazt.nh.uj(null) { // from class: com.byazt.rob.c.4
                @Override // com.byazt.nh.uj
                public void c() {
                }

                @Override // com.byazt.nh.uj
                public void c(final sl slVar) {
                    x.c(new Runnable() { // from class: com.byazt.rob.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!(slVar instanceof com.byazt.yi.tt)) {
                                c.this.c();
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                ve.tt(icVar, false, i, 1);
                            } else if (c.this.tt instanceof Activity) {
                                com.byazt.yi.tt ttVar2 = (com.byazt.yi.tt) slVar;
                                ttVar2.setSecondAdPage(true);
                                ttVar2.showFullScreenVideoAd((Activity) c.this.tt);
                                AnonymousClass4 anonymousClass5 = AnonymousClass4.this;
                                ve.tt(icVar, true, i, 0);
                            } else {
                                c.this.c();
                                AnonymousClass4 anonymousClass6 = AnonymousClass4.this;
                                ve.tt(icVar, false, i, 3);
                            }
                            c.this.n.set(false);
                        }
                    });
                }

                @Override // com.byazt.nh.uj
                public void tt(sl slVar) {
                }

                @Override // com.byazt.nh.uj
                public void c(int i2, String str) {
                    m.uj("SecondPageImpl", "requestNewFullScreenAd onError code:" + i2 + " message:" + str);
                    c.this.n.set(false);
                    c.this.c();
                    ve.tt(icVar, false, i, 2);
                }
            }));
        } catch (Throwable th) {
            m.ve("SecondPageImpl", "requestNewAd error", th.toString());
            this.n.set(false);
            c();
            ve.c(icVar, false, i, 6);
        }
    }

    public void ve(final int i, com.byazt.dj.tt ttVar, final ic icVar) {
        try {
            sp.c().c(ttVar, tt(icVar, i), new com.byazt.cf.uj(new com.byazt.nh.sp(null) { // from class: com.byazt.rob.c.3
                @Override // com.byazt.nh.sp
                public void c() {
                }

                @Override // com.byazt.nh.sp
                public void c(final z zVar) {
                    x.c(new Runnable() { // from class: com.byazt.rob.c.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!(zVar instanceof com.byazt.yi.ve)) {
                                c.this.c();
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                ve.tt(icVar, false, i, 1);
                            } else if (c.this.tt instanceof Activity) {
                                com.byazt.yi.ve veVar = (com.byazt.yi.ve) zVar;
                                veVar.setSecondAdPage(true);
                                veVar.showRewardVideoAd((Activity) c.this.tt);
                                AnonymousClass3 anonymousClass4 = AnonymousClass3.this;
                                ve.tt(icVar, true, i, 0);
                            } else {
                                c.this.c();
                                AnonymousClass3 anonymousClass5 = AnonymousClass3.this;
                                ve.tt(icVar, false, i, 3);
                            }
                            c.this.n.set(false);
                        }
                    });
                }

                @Override // com.byazt.nh.sp
                public void tt(z zVar) {
                }

                @Override // com.byazt.nh.sp
                public void c(int i2, String str) {
                    m.uj("SecondPageImpl", "requestNewRewardAd onError code:" + i2 + " message:" + str);
                    c.this.n.set(false);
                    c.this.c();
                    ve.tt(icVar, false, i, 2);
                }
            }));
        } catch (Throwable th) {
            this.n.set(false);
            m.ve("SecondPageImpl", "requestNewAd error", th.toString());
            c();
            ve.c(icVar, false, i, 6);
        }
    }

    public void c(int i, com.byazt.dj.tt ttVar) {
        if (this.c == null) {
            c();
            ve.c(null, false, i, 2);
            return;
        }
        if (this.tt == null) {
            c();
            ve.c(this.c, false, i, 3);
            return;
        }
        if (ttVar == null) {
            c();
            ve.c(this.c, false, i, 7);
            return;
        }
        if (this.n.get()) {
            ve.c(this.c, false, i, 4);
            return;
        }
        this.n.set(true);
        int iSl = nb.sl(this.c);
        if (iSl == 5) {
            c(i, ttVar, this.c);
            return;
        }
        if (iSl == 7) {
            ve(i, ttVar, this.c);
            return;
        }
        if (iSl == 8) {
            uj(i, ttVar, this.c);
        } else {
            if (iSl == 9) {
                tt(i, ttVar, this.c);
                return;
            }
            c();
            ve.c(this.c, false, i, 5);
            this.n.set(false);
        }
    }

    public void tt(final int i, com.byazt.dj.tt ttVar, final ic icVar) {
        try {
            final uj ujVarTt = tt(icVar, i);
            tt();
            com.byazt.wb.c.uj().c(ttVar, ujVarTt, new com.byazt.nh.tt(null) { // from class: com.byazt.rob.c.2
                @Override // com.byazt.nh.tt
                public void c(List<i> list) {
                    list.size();
                    ic icVarTt = ujVarTt.tt();
                    if (icVarTt != null) {
                        c.this.c(icVarTt, i);
                    } else {
                        c.this.c();
                        ve.tt(icVar, false, i, 5);
                    }
                    c.this.n.set(false);
                }

                @Override // com.byazt.nh.tt
                public void c(int i2, String str) {
                    m.uj("SecondPageImpl", "requestNewDrawAd onError code:" + i2 + " message:" + str);
                    c.this.n.set(false);
                    c.this.c();
                    ve.tt(icVar, false, i, 2);
                }
            });
        } catch (Throwable th) {
            this.n.set(false);
            m.ve("SecondPageImpl", "requestNewDrawAd error", th.toString());
            c();
            ve.c(icVar, false, i, 6);
        }
    }

    public boolean uj() {
        return this.ve.get();
    }

    public boolean ve() {
        return this.uj.get();
    }

    public void tt() {
        x.c(new Runnable() { // from class: com.byazt.rob.c.6
            @Override // java.lang.Runnable
            public void run() {
                h.c(c.this.tt, "正在努力加载中", 0);
            }
        });
    }

    public uj tt(ic icVar, int i) {
        String strU = nb.u(icVar);
        uj ujVar = new uj();
        ujVar.c(i);
        ujVar.c(strU);
        ujVar.c(icVar);
        return ujVar;
    }

    public void tt(boolean z) {
        this.ve.set(z);
    }

    public void c(final int i, com.byazt.dj.tt ttVar, final ic icVar) {
        try {
            final uj ujVarTt = tt(icVar, i);
            tt();
            com.byazt.pro.c.uj().c(ttVar, ujVarTt, new com.byazt.nh.ve(null) { // from class: com.byazt.rob.c.1
                @Override // com.byazt.nh.ve
                public void c(List<da> list) {
                    list.size();
                    ic icVarTt = ujVarTt.tt();
                    if (icVarTt != null) {
                        c.this.c(icVarTt, i);
                    } else {
                        c.this.c();
                        ve.tt(icVar, false, i, 5);
                    }
                    c.this.n.set(false);
                }

                @Override // com.byazt.nh.ve
                public void c(int i2, String str) {
                    m.uj("SecondPageImpl", "requestNewFeedAd onError code:" + i2 + " message:" + str);
                    c.this.n.set(false);
                    c.this.c();
                    ve.tt(icVar, false, i, 2);
                }
            });
        } catch (Throwable th) {
            this.n.set(false);
            m.ve("SecondPageImpl", "requestNewFeedAd error", th.toString());
            c();
            ve.c(icVar, false, i, 6);
        }
    }

    public void c() {
        x.c(new Runnable() { // from class: com.byazt.rob.c.5
            @Override // java.lang.Runnable
            public void run() {
                h.c(c.this.tt, "加载失败了，将跳转至推荐页面", 1);
            }
        });
        com.byazt.oit.c.c((View) null, this.c, this.tt);
    }

    public void c(ic icVar, int i) {
        String strTt = nb.tt(nb.sl(icVar));
        String strX = my.x(icVar);
        if (TextUtils.isEmpty(strX)) {
            strX = icVar.x();
        }
        com.byazt.szt.c cVar = new com.byazt.szt.c(icVar, this.tt, strTt, nb.uj(strTt), new HashMap(), null, icVar.yg());
        cVar.c(strX);
        if (cVar.c(new HashMap())) {
            com.byazt.ddx.uj.c(icVar, strTt, new HashMap(), (Double) null);
            ve.tt(icVar, true, i, 0);
        } else {
            c();
            ve.tt(icVar, false, i, 4);
        }
    }

    public void c(boolean z) {
        this.uj.set(z);
    }
}
