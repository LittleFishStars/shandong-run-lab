package com.byazt.msx;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.aas.md;
import com.byazt.aas.nb;
import com.byazt.dna.qp;
import com.byazt.ete.ic;
import com.byazt.ete.lt;
import com.byazt.ff.TTProgressBar;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.d;
import com.byazt.nr.m;
import com.byazt.ouz.sl;
import com.byazt.rpt.FullRewardExpressView;
import com.byazt.ukr.yp;
import com.byazt.vfu.a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 341, 2234})
public class FullSwiperItemView extends FrameLayout implements qp.c, sl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f28797a;
    public ViewGroup c;
    public com.byazt.msx.c da;
    public int gt;
    public float i;
    public boolean m;
    public boolean my;
    public FrameLayout n;
    public final d nu;
    public c rh;
    public tt rl;
    public FullRewardExpressView sl;
    public TTProgressBar sp;
    public Context t;
    public FrameLayout tt;
    public com.byazt.xh.c u;
    public FrameLayout uj;
    public FrameLayout ve;
    public float x;
    public int yp;
    public boolean z;

    public interface c {
        void c();
    }

    public interface tt {
        void c(View view, float f, float f2);
    }

    public FullSwiperItemView(Context context, com.byazt.msx.c cVar, float f, float f2) {
        super(context);
        this.nu = new d(Looper.getMainLooper(), this);
        this.da = cVar;
        this.x = f;
        this.i = f2;
        this.t = context;
        setBackgroundColor(0);
        sl();
        this.gt = nb.t(cVar.c());
        this.my = cVar.c().ab() == 1;
        t();
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.c.getContext(), this.da.c(), md.c(8, String.valueOf(this.gt), this.x, this.i, this.da.c()), this.da.tt(), this.my, null);
        this.sl = fullRewardExpressView;
        fullRewardExpressView.getAdShowTime().c(true);
    }

    @Override // com.byazt.ouz.sl
    public void a() {
        yp.c().uj(this.da.c(), "stats_reward_full_click_express_close");
        Context context = this.t;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).to().c().c();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            ic icVarC = this.da.c();
            if (icVarC != null && icVarC.zo() != null) {
                jSONObject.put("refresh_num", this.da.c().zo().ve());
            }
        } catch (JSONException e) {
            m.c(e);
        }
        yp.c().c(this.da.c(), "stats_reward_full_click_native_close", jSONObject);
        c cVar = this.rh;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.byazt.ouz.sl
    public void c(float f) {
    }

    @Override // com.byazt.ouz.sl
    public void c(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.ouz.sl
    public void c(int i) {
    }

    @Override // com.byazt.ouz.sl
    public void c(int i, String str) {
    }

    @Override // com.byazt.ouz.sl
    public void c(ic icVar) {
    }

    @Override // com.byazt.ouz.sl
    public void da() {
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message.what != 102) {
            return;
        }
        com.byazt.msx.c cVar = this.da;
        if (cVar != null) {
            cVar.sp();
        }
        Context context = this.t;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).sl();
        }
        c cVar2 = this.rh;
        if (cVar2 != null) {
            cVar2.c();
        }
    }

    @Override // com.byazt.ouz.sl
    public void i() {
        com.byazt.fcd.c cVar;
        c cVar2 = this.rh;
        if (cVar2 != null) {
            cVar2.c();
        }
        Context context = this.t;
        if (!(context instanceof TTBaseVideoActivity) || (cVar = ((TTBaseVideoActivity) context).to()) == null || cVar.c() == null) {
            return;
        }
        cVar.c().ve();
    }

    public void m() {
        com.byazt.xh.c cVar = this.u;
        if (cVar != null) {
            cVar.x();
        }
    }

    @Override // com.byazt.ouz.sl
    public void n() {
    }

    @Override // com.byazt.ouz.sl
    public void n(int i) {
    }

    public void nu() {
        d dVar = this.nu;
        if (dVar != null) {
            dVar.removeMessages(102);
        }
    }

    public void rh() {
        FullRewardExpressView fullRewardExpressView = this.sl;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.t();
        }
        com.byazt.xh.c cVar = this.u;
        if (cVar != null) {
            cVar.i();
        }
    }

    public void setOnSwiperItemInteractListener(c cVar) {
        this.rh = cVar;
    }

    public void setOnSwiperItemRenderResultListener(tt ttVar) {
        this.rl = ttVar;
    }

    @Override // com.byazt.ouz.sl
    public void setPauseFromExpressView(boolean z) {
    }

    public void sl() {
        View viewT = a.t(this.t);
        addView(viewT);
        this.c = (ViewGroup) viewT.findViewById(2114387892);
        this.tt = (FrameLayout) viewT.findViewById(2114387778);
        this.ve = (FrameLayout) viewT.findViewById(2114387812);
        this.uj = (FrameLayout) viewT.findViewById(2114387670);
        this.n = (FrameLayout) viewT.findViewById(2114387821);
        this.f28797a = (FrameLayout) viewT.findViewById(2114387679);
        this.sp = (TTProgressBar) viewT.findViewById(2114387767);
    }

    @Override // com.byazt.ouz.sl
    public void sp() {
        c cVar = this.rh;
        if (cVar != null) {
            cVar.c();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            ic icVarC = this.da.c();
            if (icVarC != null && icVarC.zo() != null) {
                jSONObject.put("refresh_num", this.da.c().zo().ve());
            }
        } catch (JSONException e) {
            m.c(e);
        }
        yp.c().c(this.da.c(), "stats_reward_full_click_express_close", jSONObject);
        Context context = this.t;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    public void t() {
        ic icVarC = this.da.c();
        if (icVarC == null) {
            return;
        }
        float fFr = icVarC.fr();
        int iBy = icVarC.by();
        float fQe = icVarC.qe();
        float[] fArrC = com.byazt.biq.tt.c(this.t.getApplicationContext(), icVarC.fr(), icVarC.by());
        float f = fArrC[0];
        float f2 = fArrC[1];
        if (fFr == 100.0f) {
            this.x = f;
            this.i = f2;
            return;
        }
        int[] iArrC = com.byazt.biq.tt.c(this.t.getApplicationContext(), fFr, fQe, iBy);
        int i = iArrC[0];
        int i2 = iArrC[1];
        int i3 = iArrC[2];
        int i4 = iArrC[3];
        this.x = (int) ((f - i) - i3);
        this.i = (int) ((f2 - i2) - i4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    @Override // com.byazt.ouz.sl
    public void tt(int i) {
    }

    public void u() {
        if (this.da == null) {
            return;
        }
        this.sp.setVisibility(0);
        this.sl.setExpressInteractionListener(new com.byazt.ouz.c() { // from class: com.byazt.msx.FullSwiperItemView.1
            @Override // com.byazt.ouz.c
            public void c(View view, float f, float f2) {
                if (FullSwiperItemView.this.rl != null) {
                    FullSwiperItemView.this.rl.c(view, f, f2);
                }
            }

            @Override // com.byazt.ouz.c
            public void c(View view, int i) {
                super.c(view, i);
            }
        });
        this.sl.setExpressVideoListenerProxy(this);
        this.sl.setInteractListener(this.rh);
        this.sl.setOnVideoSizeChangeListener(new FullRewardExpressView.c() { // from class: com.byazt.msx.FullSwiperItemView.2
            @Override // com.byazt.rpt.FullRewardExpressView.c
            public void c(int i) {
                FullSwiperItemView.this.yp = i;
            }
        });
        if (this.sl.getParent() != null) {
            ((ViewGroup) this.sl.getParent()).removeView(this.sl);
        }
        this.n.addView(this.sl);
        this.u = new com.byazt.xh.c(this.c.getContext(), this.ve, this.da.c(), null);
        this.u.c(new ve(this.da.n(), lt.ve(this.da.c()), new ve.c() { // from class: com.byazt.msx.FullSwiperItemView.3
            @Override // com.byazt.msx.FullSwiperItemView.ve.c
            public void c() {
                if (FullSwiperItemView.this.t instanceof TTBaseVideoActivity) {
                    ((TTBaseVideoActivity) FullSwiperItemView.this.t).kk();
                }
            }

            @Override // com.byazt.msx.FullSwiperItemView.ve.c
            public void c(long j, long j2) {
                com.byazt.kcl.a aVarPu;
                if (FullSwiperItemView.this.sl == null || !(FullSwiperItemView.this.t instanceof TTBaseVideoActivity) || (aVarPu = ((TTBaseVideoActivity) FullSwiperItemView.this.t).pu()) == null) {
                    return;
                }
                aVarPu.tt(j);
                FullSwiperItemView.this.sl.c(String.valueOf(aVarPu.md()), (int) (aVarPu.h() / 1000), 0, j == j2 || aVarPu.eo());
            }
        }, this.nu));
        this.u.tt(this.my);
        this.sl.setVideoController(this.u);
        this.da.c(this.ve, this.uj, this.sl);
        this.sl.m();
        this.sl.nu();
    }

    @Override // com.byazt.ouz.sl
    public void uj() {
    }

    @Override // com.byazt.ouz.sl
    public void uj(int i) {
    }

    @Override // com.byazt.ouz.sl
    public void ve(int i) {
    }

    @Override // com.byazt.ouz.sl
    public void x() {
    }

    public void yp() {
        if (this.u != null && this.z) {
            this.da.i();
            this.sl.z();
            this.m = true;
            if (ic.ve(this.da.c())) {
                this.nu.sendEmptyMessageDelayed(102, 5000L);
            }
            this.da.c(this.sl);
            if (this.sl.rl()) {
                return;
            }
            this.u.c(this.da.da());
        }
    }

    public void z() {
        com.byazt.xh.c cVar = this.u;
        if (cVar == null) {
            return;
        }
        cVar.a();
    }

    public void tt(boolean z) {
        FullRewardExpressView fullRewardExpressView = this.sl;
        if (fullRewardExpressView == null) {
            return;
        }
        if (fullRewardExpressView.rl()) {
            Context context = this.t;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).rh();
            }
        } else {
            this.sl.c((ViewGroup) this.tt, false);
        }
        this.z = true;
        this.da.ve(z);
        yp();
        this.sp.setVisibility(8);
    }

    @Override // com.byazt.ouz.sl
    public int ve() {
        com.byazt.xh.c cVar = this.u;
        if (cVar == null) {
            return 0;
        }
        return (int) (cVar.sl() / 1000);
    }

    @Override // com.byazt.ouz.sl
    public void c(boolean z) {
        if (this.my != z) {
            this.my = z;
            com.byazt.xh.c cVar = this.u;
            if (cVar != null) {
                cVar.tt(z);
            }
            Context context = this.t;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).to().c().tt();
            }
            c cVar2 = this.rh;
            if (cVar2 != null) {
                cVar2.c();
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 341, 922})
    public static class ve implements com.byazt.zd.c.InterfaceC0595c {
        public final com.byazt.zd.c.InterfaceC0595c c;
        public final d n;
        public final c tt;
        public final int uj;
        public boolean ve = false;

        public interface c {
            void c();

            void c(long j, long j2);
        }

        public ve(com.byazt.zd.c.InterfaceC0595c interfaceC0595c, int i, c cVar, d dVar) {
            this.c = interfaceC0595c;
            this.tt = cVar;
            this.uj = i;
            this.n = dVar;
        }

        @Override // com.byazt.zd.c.InterfaceC0595c
        public void c() {
            this.ve = false;
            com.byazt.zd.c.InterfaceC0595c interfaceC0595c = this.c;
            if (interfaceC0595c != null) {
                interfaceC0595c.c();
            }
            c cVar = this.tt;
            if (cVar != null) {
                cVar.c();
            }
        }

        @Override // com.byazt.zd.c.InterfaceC0595c
        public void tt() {
            com.byazt.zd.c.InterfaceC0595c interfaceC0595c = this.c;
            if (interfaceC0595c != null) {
                interfaceC0595c.tt();
            }
        }

        @Override // com.byazt.zd.c.InterfaceC0595c
        public void ve() {
            com.byazt.zd.c.InterfaceC0595c interfaceC0595c = this.c;
            if (interfaceC0595c != null) {
                interfaceC0595c.ve();
            }
        }

        @Override // com.byazt.zd.c.InterfaceC0595c
        public void c(int i, String str) {
            this.ve = false;
            com.byazt.zd.c.InterfaceC0595c interfaceC0595c = this.c;
            if (interfaceC0595c != null) {
                interfaceC0595c.c(i, str);
            }
        }

        @Override // com.byazt.zd.c.InterfaceC0595c
        public void c(long j, long j2) {
            this.n.removeMessages(102);
            com.byazt.zd.c.InterfaceC0595c interfaceC0595c = this.c;
            if (interfaceC0595c != null) {
                interfaceC0595c.c(j, j2);
            }
            c cVar = this.tt;
            if (cVar != null) {
                cVar.c(j, j2);
            }
        }
    }

    @Override // com.byazt.ouz.sl
    public long c() {
        return this.u.sl();
    }

    @Override // com.byazt.ouz.sl
    public int tt() {
        com.byazt.xh.c cVar = this.u;
        if (cVar == null || !this.m) {
            return 2;
        }
        if (cVar.bm()) {
            return 5;
        }
        if (this.u.qy()) {
            return 1;
        }
        if (this.u.lr()) {
            return 2;
        }
        this.u.gr();
        return 3;
    }
}
