package com.byazt.iym;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.aas.cu;
import com.byazt.aas.md;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.da;
import com.byazt.ete.ic;
import com.byazt.ete.lt;
import com.byazt.ete.xd;
import com.byazt.fk.u;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.ouz.NativeExpressView;
import com.byazt.ouz.a;
import com.byazt.ouz.yv;
import com.byazt.rpt.FullRewardExpressView;
import com.byazt.yih.x;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 784, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28674a;
    public final TTBaseVideoActivity c;
    public com.byazt.pop.ve da;
    public com.byazt.hkv.c i;
    public boolean m;
    public FullRewardExpressView nu;
    public ViewGroup sl;
    public a sp;
    public boolean t;
    public final ic tt;
    public long u;
    public boolean uj;
    public final String ve;
    public com.byazt.ouz.n x;
    public final boolean z;
    public final AtomicBoolean yp = new AtomicBoolean(false);
    public boolean n = false;

    public tt(final TTBaseVideoActivity tTBaseVideoActivity, ic icVar, String str, boolean z, boolean z2) {
        this.da = null;
        this.c = tTBaseVideoActivity;
        this.tt = icVar;
        this.ve = str;
        this.z = z;
        this.m = z2;
        a aVar = new a(tTBaseVideoActivity, icVar, str, nb.uj(str)) { // from class: com.byazt.iym.tt.1
            @Override // com.byazt.ouz.a, com.byazt.hkv.tt, com.byazt.hkv.uj
            public void c(View view, da daVar) {
                super.c(view, daVar);
                tTBaseVideoActivity.c(2);
            }
        };
        this.sp = aVar;
        ((com.byazt.vis.c) aVar.c(com.byazt.vis.c.class)).c(tTBaseVideoActivity.c(icVar));
        com.byazt.ouz.n nVar = new com.byazt.ouz.n(tTBaseVideoActivity, icVar, str, nb.uj(str)) { // from class: com.byazt.iym.tt.2
            @Override // com.byazt.ouz.n, com.byazt.hkv.tt, com.byazt.hkv.uj
            public void c(View view, da daVar) {
                super.c(view, daVar);
                com.byazt.zo.tt ttVar = (com.byazt.zo.tt) this.x.c(com.byazt.zo.tt.class);
                if (ttVar == null || !ttVar.tt(view)) {
                    return;
                }
                tTBaseVideoActivity.c(2);
            }
        };
        this.x = nVar;
        ((com.byazt.vis.c) nVar.c(com.byazt.vis.c.class)).c(tTBaseVideoActivity.c(icVar));
        com.byazt.hkv.c cVar = new com.byazt.hkv.c(tTBaseVideoActivity, icVar, str, 7);
        this.i = cVar;
        tTBaseVideoActivity.c((com.byazt.vis.ve) cVar.c(com.byazt.vis.ve.class));
        ((com.byazt.vis.c) this.i.c(com.byazt.vis.c.class)).c(tTBaseVideoActivity.c(icVar));
        if (icVar.i() == 4) {
            this.da = x.c(tTBaseVideoActivity, icVar, str);
            final String strUj = c().uj();
            this.da.c(new com.byazt.pop.c() { // from class: com.byazt.iym.tt.3
                @Override // com.byazt.pop.c
                public void c() {
                    com.byazt.nt.c.c(strUj);
                }

                @Override // com.byazt.pop.c
                public void tt(long j, long j2, String str2, String str3) {
                    com.byazt.nt.c.tt(strUj, j, j2);
                }

                @Override // com.byazt.pop.c
                public void ve(long j, long j2, String str2, String str3) {
                    com.byazt.nt.c.ve(strUj, j, j2);
                }

                @Override // com.byazt.pop.c
                public void c(long j, long j2, String str2, String str3) {
                    com.byazt.nt.c.c(strUj, j, j2);
                }

                @Override // com.byazt.pop.c
                public void c(long j, String str2, String str3) {
                    com.byazt.nt.c.tt(strUj);
                }

                @Override // com.byazt.pop.c
                public void c(String str2, String str3) {
                    com.byazt.nt.c.ve(strUj);
                }
            });
        }
    }

    public boolean a() {
        return this.uj;
    }

    public com.byazt.jzl.a da() {
        com.byazt.jzl.a aVarC = xd.c(1, this.tt);
        aVarC.setCid(this.tt.uj());
        aVarC.setWidth(100);
        aVarC.setHeight(100);
        aVarC.setLogExtra(this.tt.w_());
        aVarC.setQuiet(this.uj);
        return aVarC;
    }

    public void i() {
        if (this.z) {
            this.c.c(this.tt, this.i);
        }
    }

    public com.byazt.zd.c.InterfaceC0595c n() {
        return new com.byazt.zd.c.InterfaceC0595c() { // from class: com.byazt.iym.tt.4
            @Override // com.byazt.zd.c.InterfaceC0595c
            public void c() {
                tt.this.t = true;
            }

            @Override // com.byazt.zd.c.InterfaceC0595c
            public void tt() {
                tt.this.sp();
            }

            @Override // com.byazt.zd.c.InterfaceC0595c
            public void ve() {
            }

            @Override // com.byazt.zd.c.InterfaceC0595c
            public void c(int i, String str) {
                tt.this.sp();
            }

            @Override // com.byazt.zd.c.InterfaceC0595c
            public void c(long j, long j2) {
                pf.c((View) tt.this.sl, 8);
                tt.this.u = j;
            }
        };
    }

    public long sl() {
        return this.u;
    }

    public void sp() {
        pf.c((View) this.sl, 0);
        this.c.u();
    }

    public void t() {
        if (this.m) {
            return;
        }
        this.m = true;
        ic icVar = this.tt;
        com.byazt.dj.tt ttVarC = md.c(7, icVar == null ? null : icVar.jl());
        if (xd.z(this.tt) != null) {
            com.byazt.jzl.a aVarC = xd.c(1, this.tt);
            aVarC.putExtra("material_meta", this.tt);
            aVarC.putExtra("ad_slot", Integer.valueOf(ttVarC != null ? ttVarC.gt() : 0));
            com.byazt.btt.ve.c(aVarC, new com.byazt.fk.da.c() { // from class: com.byazt.iym.tt.5
                @Override // com.byazt.fk.da.c
                public void cancel(u uVar, int i) {
                }

                @Override // com.byazt.fk.da.c
                public void onVideoPreloadFail(u uVar, int i, String str) {
                    uVar.getUrl();
                    uVar.getPreloadSize();
                }

                @Override // com.byazt.fk.da.c
                public void onVideoPreloadSuccess(u uVar, int i) {
                    uVar.getUrl();
                    uVar.getPreloadSize();
                }
            });
        }
    }

    public String tt() {
        return this.ve;
    }

    public int uj() {
        if (!lt.da(this.tt)) {
            return 1;
        }
        if (this.t) {
            int iTt = lt.tt(this.tt) - this.f28674a;
            this.f28674a = lt.tt(this.tt);
            return iTt;
        }
        if (this.f28674a >= lt.tt(this.tt)) {
            return 0;
        }
        this.f28674a++;
        return 1;
    }

    public com.byazt.hkv.c ve() {
        return this.i;
    }

    public void x() {
        com.byazt.pop.ve veVar = this.da;
        if (veVar != null) {
            veVar.ve();
        }
        FullRewardExpressView fullRewardExpressView = this.nu;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.t();
        }
        ic icVar = this.tt;
        cu.tt(icVar != null ? icVar.eo() : 0);
    }

    public void tt(boolean z) {
        this.tt.m(z);
    }

    public FullRewardExpressView tt(float f, float f2) {
        if (this.nu == null) {
            c(f, f2);
        }
        return this.nu;
    }

    public ic c() {
        return this.tt;
    }

    public void c(ViewGroup viewGroup, ViewGroup viewGroup2, FullRewardExpressView fullRewardExpressView) {
        this.sl = viewGroup2;
        if (viewGroup == null || fullRewardExpressView == null || c() == null) {
            return;
        }
        com.byazt.pop.ve veVar = this.da;
        if (veVar != null) {
            veVar.tt();
            if (fullRewardExpressView.getContext() != null && (fullRewardExpressView.getContext() instanceof Activity)) {
                this.da.c((Activity) fullRewardExpressView.getContext(), false);
            }
        }
        this.sp.c(fullRewardExpressView);
        ((com.byazt.nat.c) this.sp.c(com.byazt.nat.c.class)).c(this.da);
        fullRewardExpressView.setClickListener(this.sp);
        this.x.c(fullRewardExpressView);
        ((com.byazt.nat.c) this.x.c(com.byazt.nat.c.class)).c(this.da);
        fullRewardExpressView.setClickCreativeListener(this.x);
        this.i.c(viewGroup);
        ((com.byazt.nat.c) this.i.c(com.byazt.nat.c.class)).c(this.da);
        ImageView imageView = new ImageView(this.c);
        com.byazt.xky.tt.c(this.tt.pa().get(0)).to(imageView);
        this.sl.addView(imageView);
    }

    public void c(boolean z) {
        this.uj = z;
    }

    public void c(NativeExpressView nativeExpressView) {
        if (this.yp.getAndSet(true)) {
            return;
        }
        Map<String, Object> mapC = this.c.c(this.tt);
        yv.c(mapC, this.tt, nativeExpressView);
        com.byazt.ddx.uj.c(this.tt, this.ve, mapC, this.c.hd());
        com.byazt.pf.c.c().uj();
        ic icVar = this.tt;
        cu.c(icVar != null ? icVar.eo() : 0);
    }

    public void c(float f, float f2) {
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.c, c(), md.c(7, String.valueOf(nb.t(c())), f, f2, c()), tt(), false, null);
        this.nu = fullRewardExpressView;
        fullRewardExpressView.getAdShowTime().c(true);
        this.nu.setExpressInteractionListener(new com.byazt.ouz.c() { // from class: com.byazt.iym.tt.6
            @Override // com.byazt.ouz.c
            public void c(View view, float f3, float f4) {
                tt.this.n = true;
            }
        });
        this.nu.m();
    }
}
