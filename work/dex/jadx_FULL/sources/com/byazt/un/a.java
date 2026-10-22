package com.byazt.un;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.bzd.x;
import com.byazt.dna.qp;
import com.byazt.ete.bx;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.pu;
import com.byazt.ete.xd;
import com.byazt.ff.RoundImageView;
import com.byazt.ff.TTProgressBar;
import com.byazt.jr.SSRenderTextureView;
import com.byazt.kft.TTLottieVideoContainer;
import com.byazt.kft.UpieVideoView;
import com.byazt.lbn.TTViewStub;
import com.byazt.nc.u;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import com.byazt.omf.my;
import com.byazt.omf.rl;
import com.byazt.ouz.gu;
import com.byazt.sgn.yp;
import com.byazt.sgn.z;
import com.byazt.yj.gr;
import com.byazt.yj.m;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 96, 34})
public class a implements com.byazt.jr.c, com.byazt.dh.tt<ic>, qp.c, yp.c, z.tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f29103a;
    public RelativeLayout aw;
    public boolean b;
    public RelativeLayout bm;
    public TextView bx;
    public View c;
    public com.byazt.uz.c cu;
    public com.byazt.pop.ve d;
    public View da;
    public com.byazt.dh.ve eo;
    public EnumSet<com.byazt.dh.tt.c> gr;
    public int gt;
    public int gu;
    public boolean h;
    public TextView hd;
    public ImageView i;
    public RoundImageView ic;
    public com.byazt.ua.c.InterfaceC0539c kk;
    public int kp;
    public View l;
    public RelativeLayout lo;
    public TTViewStub lr;
    public TextView lt;
    public TTViewStub m;
    public tt md;
    public int my;
    public View n;
    public View nb;
    public int nu;
    public com.byazt.hkv.c or;
    public final int os;
    public final int oz;
    public z p;
    public TextView pf;
    public RoundImageView pu;
    public com.byazt.hkv.c q;
    public boolean qp;
    public volatile boolean qy;
    public AtomicBoolean r;
    public int rh;
    public boolean rl;
    public RoundImageView sl;
    public TTViewStub sp;
    public NativeVideoTsView.c sv;
    public TextView t;
    public String tk;
    public TextView to;
    public com.byazt.jr.tt tt;
    public sp tx;
    public TextView u;
    public View uj;
    public final int v;
    public ImageView ve;
    public View x;
    public TextView yp;
    public Context yv;
    public TTProgressBar z;
    public com.byazt.hkv.c zb;
    public ic zm;

    public a(Context context, View view, boolean z, EnumSet<com.byazt.dh.tt.c> enumSet, ic icVar, com.byazt.dh.ve veVar, boolean z2, com.byazt.hkv.c cVar) {
        this.rl = true;
        this.h = true;
        this.qp = true;
        this.v = 1;
        this.os = 2;
        this.oz = 3;
        this.r = new AtomicBoolean(false);
        if (this instanceof n) {
            return;
        }
        this.yv = gt.getContext().getApplicationContext();
        uj(z2);
        this.c = view;
        this.rl = z;
        this.gr = enumSet == null ? EnumSet.noneOf(com.byazt.dh.tt.c.class) : enumSet;
        this.eo = veVar;
        this.q = cVar;
        this.zm = icVar;
        h();
        uj(8);
        c(context, this.c, icVar);
        uj();
        m();
    }

    private boolean bx() {
        ic icVar;
        return this.h && this.da != null && (icVar = this.zm) != null && icVar.ir() == 1;
    }

    private void cu() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        ic icVar = this.zm;
        if (icVar != null && com.byazt.ex.c.c(icVar)) {
            String strI = bx.i(this.zm);
            if (!TextUtils.isEmpty(strI)) {
                com.byazt.xky.tt.c(strI).to(this.ic);
            }
            String strVe = bx.ve(this.zm);
            String strX = bx.x(this.zm);
            if (!TextUtils.isEmpty(strVe)) {
                pf.c(this.hd, strVe);
            }
            if (this.aw == null) {
                return;
            }
            com.byazt.xky.tt.c(strX).type(2).to(new gr<Bitmap>() { // from class: com.byazt.un.a.10
                @Override // com.byazt.yj.gr
                public void onFailed(int i, String str, Throwable th) {
                    a aVar = a.this;
                    com.byazt.ddx.uj.c(aVar.zm, aVar.tk, i, str);
                }

                @Override // com.byazt.yj.gr
                public void onSuccess(m<Bitmap> mVar) {
                    Bitmap bitmapC = com.byazt.or.tt.c(a.this.yv, mVar.getResult(), 25);
                    if (bitmapC == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(a.this.aw.getResources(), bitmapC);
                    x.c(new Runnable() { // from class: com.byazt.un.a.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.aw != null) {
                                a.this.aw.setBackground(bitmapDrawable);
                            }
                        }
                    });
                    a aVar = a.this;
                    com.byazt.ddx.uj.uj(aVar.zm, aVar.tk, System.currentTimeMillis() - jCurrentTimeMillis);
                }
            }, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        x.c(new com.byazt.bwm.sp("native_video_layout_download_listener") { // from class: com.byazt.un.a.1
            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                if (aVar.d == null) {
                    aVar.d = com.byazt.yih.x.c(aVar.yv, aVar.zm, aVar.tk);
                }
                com.byazt.hkv.c cVar = a.this.zb;
                if (cVar != null) {
                    ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).c(a.this.d);
                }
                com.byazt.hkv.c cVar2 = a.this.or;
                if (cVar2 != null) {
                    ((com.byazt.nat.c) cVar2.c(com.byazt.nat.c.class)).c(a.this.d);
                }
                if (a.this.kk != null) {
                    a aVar2 = a.this;
                    aVar2.d.c(aVar2.kk);
                }
                com.byazt.pop.ve veVar = a.this.d;
                if (veVar != null) {
                    veVar.c();
                }
            }
        });
    }

    private boolean eo() {
        ic icVar = this.zm;
        return icVar != null && pu.a(icVar) == null && pu.sp(this.zm) == null && this.zm.vp() == 1 && ic.ve(this.zm);
    }

    private void h() {
        this.kp = 1;
        String strTt = nb.tt(this.zm);
        String str = "embeded_ad_landingpage";
        if (strTt == null) {
            strTt = this.h ? com.byazt.dyf.tt.AD_TAG_FEED : "embeded_ad_landingpage";
        }
        this.kp = nb.uj(strTt);
        if (!this.h && strTt.equals("draw_ad")) {
            str = "draw_ad_landingpage";
        } else if (this.h || !strTt.equals(com.byazt.dyf.tt.AD_TAG_FEED)) {
            str = strTt;
        }
        this.tk = str;
    }

    private void nb() {
        if (qp()) {
            pf.c((View) this.ve, 8);
            if (!gt.tt().pe()) {
                pf.c(this.uj, 8);
                pf.c(this.n, 8);
                pf.c((View) this.f29103a, 8);
                return;
            }
        }
        pf.c(this.uj, 0);
        pf.c((View) this.aw, 8);
        pf.a(this.uj);
        if (qp() && gt.tt().pe()) {
            pf.c(this.n, 8);
        } else {
            pf.a(this.n);
        }
        if (this.f29103a == null || TextUtils.isEmpty(xd.tt(this.zm))) {
            return;
        }
        pf.a(this.f29103a);
        com.byazt.xky.tt.c(xd.tt(this.zm)).to(this.f29103a);
        c(this.f29103a, xd.tt(this.zm));
    }

    private boolean or() {
        if (this.zm == null) {
            return false;
        }
        if ("fullscreen_interstitial_ad".equals(this.tk) || "rewarded_video".equals(this.tk)) {
            int iBy = this.zm.by();
            float fFr = this.zm.fr();
            if (iBy == 1 && fFr == 100.0f) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pf() {
        try {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            layoutParams.addRule(15);
            View view = this.da;
            if (view != null) {
                view.setLayoutParams(layoutParams);
            }
            View view2 = this.c;
            if (view2 == null) {
                return;
            }
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = this.c.getMeasuredHeight();
            int iVe = pf.ve(this.yv, 200.0f);
            int iVe2 = pf.ve(this.yv, 331.0f);
            int iVe3 = pf.ve(this.yv, 110.0f);
            int iVe4 = pf.ve(this.yv, 100.0f);
            if (measuredWidth >= iVe && measuredHeight >= iVe2) {
                a(1);
                return;
            }
            if (measuredWidth > iVe3 && measuredHeight > iVe4) {
                a(3);
                return;
            }
            a(2);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    private boolean qp() {
        return TextUtils.equals(this.tk, "splash_ad") || TextUtils.equals(this.tk, "cache_splash_ad");
    }

    private void zb() {
        if (this.yv == null || this.c == null) {
            return;
        }
        View view = new View(this.yv) { // from class: com.byazt.un.a.8
            public final AtomicBoolean tt = new AtomicBoolean(true);

            private void c() {
                if (a.this.zm == null) {
                    return;
                }
                if (this.tt.getAndSet(false) && (com.byazt.ex.c.c(a.this.zm) || a.this.zm.i() == 4)) {
                    a.this.d();
                }
                rl.tt(a.this.zm.lw(), a.this.tx, sp.class);
            }

            private void tt() {
                com.byazt.pop.ve veVar;
                if (this.tt.getAndSet(true) || (veVar = a.this.d) == null) {
                    return;
                }
                veVar.ve();
            }

            @Override // android.view.View
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                a.this.r.set(false);
                c();
            }

            @Override // android.view.View
            public void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                a.this.r.set(true);
                tt();
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                super.onFinishTemporaryDetach();
                c();
            }

            @Override // android.view.View
            public void onMeasure(int i, int i2) {
                super.onMeasure(0, 0);
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                super.onStartTemporaryDetach();
                tt();
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                com.byazt.pop.ve veVar = a.this.d;
                if (veVar == null || !z) {
                    return;
                }
                veVar.tt();
            }
        };
        View view2 = this.c;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    public void a() {
    }

    public void c(long j) {
    }

    public void c(long j, long j2) {
    }

    @Override // com.byazt.sgn.yp.c
    public void c(View view, boolean z) {
    }

    public void c(ViewGroup viewGroup) {
    }

    public void c(String str) {
    }

    @Override // com.byazt.sgn.z.tt
    public boolean da() {
        return false;
    }

    @TargetApi(14)
    public void gr() {
        pf.c(this.c, 0);
        com.byazt.jr.tt ttVar = this.tt;
        if (ttVar != null) {
            View view = ttVar.getView();
            pf.c(view, 8);
            pf.c(view, 0);
        }
    }

    public void gt() {
        z zVar = this.p;
        if (zVar != null) {
            zVar.c(false);
        }
    }

    public void gu() {
        if (com.byazt.ex.c.c(this.zm)) {
            qy();
        } else {
            pf.c((View) this.aw, 8);
            pf.a(this.uj);
            pf.a(this.n);
        }
        ImageView imageView = this.ve;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        pf.c((View) this.ve, 8);
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
    }

    public void m() {
        View view;
        h();
        if (com.byazt.ex.c.c(this.zm)) {
            com.byazt.hkv.c cVar = this.q;
            if (cVar != null) {
                this.zb = cVar;
            } else {
                this.zb = new com.byazt.hkv.c(this.yv, this.zm, this.tk, this.kp);
            }
            com.byazt.nat.c.InterfaceC0470c interfaceC0470c = new com.byazt.nat.c.InterfaceC0470c() { // from class: com.byazt.un.a.5
                @Override // com.byazt.nat.c.InterfaceC0470c
                public void c(View view2, int i) {
                    if (a.this.sv != null) {
                        a.this.sv.c(view2, i);
                    }
                }
            };
            ((com.byazt.nat.c) this.zb.c(com.byazt.nat.c.class)).c(interfaceC0470c);
            ic icVar = this.zm;
            if (icVar != null) {
                rl.tt(icVar.lw(), interfaceC0470c, com.byazt.nat.c.InterfaceC0470c.class);
            }
            if (this.q == null && (view = this.c) != null) {
                view.setOnClickListener(this.zb);
                this.c.setOnTouchListener(this.zb);
            }
            if (pf.uj(this.bm)) {
                this.bm.setOnClickListener(this.zb);
                this.bm.setOnTouchListener(this.zb);
                return;
            }
            return;
        }
        zb();
        com.byazt.hkv.c cVar2 = new com.byazt.hkv.c(this.yv, this.zm, this.tk, this.kp);
        this.zb = cVar2;
        ((com.byazt.nat.c) cVar2.c(com.byazt.nat.c.class)).tt(true);
        com.byazt.nat.c.InterfaceC0470c interfaceC0470c2 = new com.byazt.nat.c.InterfaceC0470c() { // from class: com.byazt.un.a.6
            @Override // com.byazt.nat.c.InterfaceC0470c
            public void c(View view2, int i) {
                if (a.this.sv != null) {
                    a.this.sv.c(view2, i);
                }
            }
        };
        ((com.byazt.nat.c) this.zb.c(com.byazt.nat.c.class)).c(interfaceC0470c2);
        ic icVar2 = this.zm;
        if (icVar2 != null) {
            rl.tt(icVar2.lw(), interfaceC0470c2, com.byazt.nat.c.InterfaceC0470c.class);
        }
        tt(this.zb);
        if (this.h) {
            ((com.byazt.nat.c) this.zb.c(com.byazt.nat.c.class)).ve(true);
        } else {
            ((com.byazt.nat.c) this.zb.c(com.byazt.nat.c.class)).ve(false);
            ((com.byazt.nat.c) this.zb.c(com.byazt.nat.c.class)).c(true);
        }
        if (eo()) {
            com.byazt.hkv.c cVar3 = new com.byazt.hkv.c(this.yv, this.zm, this.tk, this.kp);
            this.or = cVar3;
            tt(cVar3);
            this.tx = new sp(this);
            ((com.byazt.nat.c) this.or.c(com.byazt.nat.c.class)).tt(true);
            com.byazt.nat.c.InterfaceC0470c interfaceC0470c3 = new com.byazt.nat.c.InterfaceC0470c() { // from class: com.byazt.un.a.7
                @Override // com.byazt.nat.c.InterfaceC0470c
                public void c(View view2, int i) {
                    if (a.this.sv != null) {
                        a.this.sv.c(view2, i);
                    }
                }
            };
            ((com.byazt.nat.c) this.or.c(com.byazt.nat.c.class)).c(interfaceC0470c3);
            ic icVar3 = this.zm;
            if (icVar3 != null) {
                rl.tt(icVar3.lw(), interfaceC0470c3, com.byazt.nat.c.InterfaceC0470c.class);
            }
            if (this.h) {
                ((com.byazt.nat.c) this.or.c(com.byazt.nat.c.class)).ve(true);
            } else {
                ((com.byazt.nat.c) this.or.c(com.byazt.nat.c.class)).ve(false);
            }
            c(this.or);
            View view2 = this.c;
            if (view2 != null) {
                view2.setOnClickListener(this.or);
                this.c.setOnTouchListener(this.or);
            }
        }
    }

    public boolean md() {
        return !this.gr.contains(com.byazt.dh.tt.c.alwayShowMediaView) || this.rl;
    }

    public void my() {
        if (this.md == null || this.p != null) {
            return;
        }
        System.currentTimeMillis();
        z zVar = new z();
        this.p = zVar;
        zVar.c(this.yv, this.c);
        this.p.c(this.md, this);
        System.currentTimeMillis();
    }

    public void n() {
    }

    public com.byazt.jr.tt nu() {
        return this.tt;
    }

    public void p() {
        if (qp()) {
            pf.c((View) this.ve, 8);
            pf.n(this.uj);
            pf.n(this.n);
            ImageView imageView = this.f29103a;
            if (imageView != null) {
                pf.n(imageView);
            }
        }
    }

    public void qy() {
        pf.c(this.uj, 8);
        pf.c((View) this.aw, 0);
        cu();
    }

    public void rh() {
        if (this.zm == null) {
            return;
        }
        if (this.b) {
            pf.c((View) this.to, 8);
        }
        if (com.byazt.ex.c.c(this.zm)) {
            String strI = bx.i(this.zm);
            String strVe = bx.ve(this.zm);
            String strX = bx.x(this.zm);
            pf.c(this.l, 0);
            pf.c((View) this.lo, 0);
            if (!TextUtils.isEmpty(strI)) {
                com.byazt.xky.tt.c(strI).to(this.pu);
            }
            if (!TextUtils.isEmpty(strVe)) {
                pf.c(this.lt, strVe);
            }
            if (this.lo == null) {
                return;
            }
            com.byazt.xky.tt.c(strX).type(2).to(new gr<Bitmap>() { // from class: com.byazt.un.a.9
                @Override // com.byazt.yj.gr
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.byazt.yj.gr
                public void onSuccess(m<Bitmap> mVar) {
                    Bitmap bitmapC = com.byazt.or.tt.c(a.this.yv, mVar.getResult(), 25);
                    if (bitmapC == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(a.this.lo.getResources(), bitmapC);
                    x.c(new Runnable() { // from class: com.byazt.un.a.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.lo != null) {
                                a.this.lo.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    public boolean rl() {
        if (this.md != null) {
            return true;
        }
        com.byazt.nr.m.uj("NewLiveViewLayout", "callback is null");
        return false;
    }

    public boolean sl() {
        return this.rl;
    }

    @Override // com.byazt.sgn.z.tt
    public void t() {
        c(true, false);
    }

    public void tt(ViewGroup viewGroup) {
    }

    public void tt(boolean z) {
    }

    public boolean u() {
        return this.qy;
    }

    public void ve(boolean z) {
    }

    public boolean ve(int i) {
        return false;
    }

    @Override // com.byazt.sgn.yp.c
    public void yp() {
    }

    public void yv() {
        ic icVar = this.zm;
        if (icVar == null) {
            return;
        }
        if (this.zm.wn() != 5 ? icVar.wn() == 1 && kp.nu(this.zm) : true) {
            c(false, this.rl);
            c(this.c, gt.getContext());
            if (this.i == null || TextUtils.isEmpty(xd.tt(this.zm))) {
                return;
            }
            pf.c(this.x, 0);
            pf.c((View) this.i, 0);
            pf.c(this.da, 8);
            com.byazt.xky.tt.c(xd.tt(this.zm)).to(this.i);
            c(this.i, xd.tt(this.zm));
        }
    }

    @Override // com.byazt.sgn.yp.c
    public boolean z() {
        z zVar = this.p;
        return zVar != null && zVar.c();
    }

    public void zm() {
        pf.c(this.x, 8);
        pf.c((View) this.i, 8);
        pf.c(this.da, 8);
        pf.c((View) this.sl, 8);
        pf.c((View) this.t, 8);
        pf.c((View) this.u, 8);
        pf.c((View) this.yp, 8);
        pf.c(this.l, 8);
        pf.c((View) this.lo, 8);
    }

    private int sp(int i) {
        if (this.my <= 0 || this.gt <= 0) {
            return 0;
        }
        int iVe = pf.ve(this.yv, 228.0f);
        int iVe2 = pf.ve(this.yv, 160.0f);
        int i2 = (int) (this.gt * ((i * 1.0f) / this.my));
        if (i2 > iVe) {
            return iVe;
        }
        return i2 < iVe2 ? iVe2 : i2;
    }

    private void tt(com.byazt.hkv.c cVar) {
        ic icVar;
        if (cVar == null || (icVar = this.zm) == null) {
            return;
        }
        com.byazt.nc.yp ypVarC = com.byazt.btt.c.c(Integer.valueOf(icVar.hashCode()));
        if (ypVarC instanceof gu) {
            ((gu) ypVarC).setAdShowCallBack((com.byazt.vis.ve) cVar.c(com.byazt.vis.ve.class));
        }
    }

    private void x(int i) {
        pf.c(this.da, i);
        pf.c(this.nb, i);
    }

    public void a(int i) {
        ic icVar;
        if (this.sl == null || (icVar = this.zm) == null || icVar.te() == null || this.zm.te().c() == null) {
            return;
        }
        if (i == 1) {
            int iVe = pf.ve(this.yv, 71.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iVe, iVe);
            layoutParams.addRule(14);
            this.sl.setLayoutParams(layoutParams);
            this.t.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = pf.ve(this.yv, 16.0f);
            layoutParams2.topMargin = pf.ve(this.yv, 8.0f);
            layoutParams2.leftMargin = pf.ve(this.yv, 16.0f);
            layoutParams2.rightMargin = pf.ve(this.yv, 16.0f);
            layoutParams2.addRule(3, this.sl.getId());
            layoutParams2.addRule(14);
            this.u.setLayoutParams(layoutParams2);
            this.u.setTextSize(16.0f);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, pf.ve(this.yv, 32.0f));
            layoutParams3.addRule(14);
            layoutParams3.addRule(3, this.u.getId());
            layoutParams3.leftMargin = pf.ve(this.yv, 20.0f);
            layoutParams3.rightMargin = pf.ve(this.yv, 20.0f);
            this.yp.setPadding(pf.ve(this.yv, 36.0f), pf.ve(this.yv, 7.0f), pf.ve(this.yv, 36.0f), pf.ve(this.yv, 8.0f));
            this.yp.setLayoutParams(layoutParams3);
            this.yp.setEllipsize(TextUtils.TruncateAt.END);
            this.yp.setSingleLine(true);
            this.yp.setTextSize(14.0f);
            return;
        }
        if (i == 2) {
            int iVe2 = pf.ve(this.yv, 40.0f);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iVe2, iVe2);
            layoutParams4.addRule(14);
            this.sl.setLayoutParams(layoutParams4);
            this.t.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.bottomMargin = pf.ve(this.yv, 8.0f);
            layoutParams5.topMargin = pf.ve(this.yv, 8.0f);
            layoutParams5.addRule(3, this.sl.getId());
            layoutParams5.addRule(14);
            this.u.setLayoutParams(layoutParams5);
            this.u.setTextSize(10.0f);
            pf.c((View) this.yp, 8);
            return;
        }
        int iVe3 = pf.ve(this.yv, 49.0f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(iVe3, iVe3);
        layoutParams6.addRule(14);
        this.sl.setLayoutParams(layoutParams6);
        this.t.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.bottomMargin = pf.ve(this.yv, 8.0f);
        layoutParams7.topMargin = pf.ve(this.yv, 8.0f);
        layoutParams7.addRule(3, this.sl.getId());
        layoutParams7.addRule(14);
        this.u.setLayoutParams(layoutParams7);
        this.u.setTextSize(13.0f);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, pf.ve(this.yv, 28.0f));
        layoutParams8.addRule(13);
        layoutParams8.addRule(3, this.u.getId());
        int iVe4 = pf.ve(this.yv, 20.0f);
        int iVe5 = pf.ve(this.yv, 25.0f);
        int iVe6 = pf.ve(this.yv, 6.0f);
        TextPaint paint = this.yp.getPaint();
        Rect rect = new Rect();
        CharSequence text = this.yp.getText();
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        String string = text.toString();
        paint.getTextBounds(string, 0, string.length(), rect);
        this.yp.setTextSize(13.0f);
        if (this.yp.getWidth() > (iVe5 * 2) + rect.width() && this.yp.getHeight() > (iVe6 * 2) + rect.height()) {
            layoutParams8.leftMargin = iVe4;
            layoutParams8.rightMargin = iVe4;
            this.yp.setPadding(iVe5, pf.ve(this.yv, 5.0f), iVe5, iVe6);
        }
        this.yp.setEllipsize(TextUtils.TruncateAt.END);
        this.yp.setSingleLine(true);
        this.yp.setLayoutParams(layoutParams8);
    }

    @Override // com.byazt.dh.tt
    @SuppressLint({"ClickableViewAccessibility"})
    public /* bridge */ /* synthetic */ void c(ic icVar, WeakReference weakReference, boolean z) {
        c2(icVar, (WeakReference<Context>) weakReference, z);
    }

    public void i() {
        TTProgressBar tTProgressBar = this.z;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(0);
            this.z.setSecondaryProgress(0);
        }
        uj(8);
        if (md()) {
            this.tt.setVisibility(8);
        }
        ImageView imageView = this.f29103a;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.f29103a.setBackground(null);
        }
        ImageView imageView2 = this.i;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
            this.i.setBackground(null);
        }
        uj(8);
        pf.c(this.x, 8);
        pf.c((View) this.i, 8);
        pf.c(this.da, 8);
        pf.c((View) this.sl, 8);
        pf.c((View) this.t, 8);
        pf.c((View) this.u, 8);
        pf.c(this.l, 8);
        pf.c((View) this.lo, 8);
        z zVar = this.p;
        if (zVar != null) {
            zVar.c(true);
        }
    }

    public void n(int i) {
        pf.c(this.c, 0);
        com.byazt.jr.tt ttVar = this.tt;
        if (ttVar != null) {
            ttVar.setVisibility(i);
        }
    }

    public void uj() {
        this.tt.c(this);
        ImageView imageView = this.ve;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.un.a.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.rl()) {
                        TextView textView = a.this.yp;
                        if (textView == null || textView.getVisibility() != 0) {
                            a aVar = a.this;
                            aVar.md.c(aVar, view);
                        }
                    }
                }
            });
        }
    }

    public void ve(int i, int i2) {
        this.my = i;
        this.gt = i2;
    }

    private void c(com.byazt.hkv.c cVar) {
        ic icVar;
        if (cVar == null || (icVar = this.zm) == null || !com.byazt.ex.c.c(icVar)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("click_live_element", "click_live_feed");
        ((com.byazt.vis.c) cVar.c(com.byazt.vis.c.class)).c(map);
    }

    public void ve(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.c.getParent() == null) {
            viewGroup.addView(this.c);
        }
        uj(0);
    }

    public void x() {
        if (com.byazt.ex.c.c(this.zm)) {
            pf.c((View) this.aw, 8);
        } else {
            pf.n(this.uj);
        }
    }

    public void n(boolean z) {
        this.b = z;
    }

    public void uj(boolean z) {
        this.h = z;
        if (z) {
            com.byazt.hkv.c cVar = this.zb;
            if (cVar != null) {
                ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).ve(true);
            }
            com.byazt.hkv.c cVar2 = this.or;
            if (cVar2 != null) {
                ((com.byazt.nat.c) cVar2.c(com.byazt.nat.c.class)).ve(true);
                return;
            }
            return;
        }
        com.byazt.hkv.c cVar3 = this.zb;
        if (cVar3 != null) {
            ((com.byazt.nat.c) cVar3.c(com.byazt.nat.c.class)).ve(true);
            ((com.byazt.nat.c) this.zb.c(com.byazt.nat.c.class)).c(true);
        }
        com.byazt.hkv.c cVar4 = this.or;
        if (cVar4 != null) {
            ((com.byazt.nat.c) cVar4.c(com.byazt.nat.c.class)).ve(true);
            ((com.byazt.nat.c) this.or.c(com.byazt.nat.c.class)).c(true);
        }
    }

    private void tt(Context context, View view) {
        if (view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2114387888);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(2114387688);
        if (or()) {
            pf.c((View) relativeLayout, 0);
            pf.c((View) relativeLayout2, 8);
            this.aw = relativeLayout;
        } else {
            pf.c((View) relativeLayout2, 0);
            pf.c((View) relativeLayout, 8);
            this.aw = relativeLayout2;
        }
        RelativeLayout relativeLayout3 = this.aw;
        if (relativeLayout3 == null) {
            return;
        }
        this.ic = (RoundImageView) relativeLayout3.findViewById(2114387831);
        this.hd = (TextView) this.aw.findViewById(2114387742);
        this.bm = (RelativeLayout) this.aw.findViewById(2114387693);
    }

    public void sp() {
        if (com.byazt.ex.c.c(this.zm)) {
            qy();
        } else {
            nb();
        }
        ImageView imageView = this.ve;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        pf.c((View) this.ve, 8);
    }

    @Override // com.byazt.dh.tt
    public View ve() {
        return this.c;
    }

    public void c(NativeVideoTsView.c cVar) {
        this.sv = cVar;
    }

    public void c(u uVar) {
        c(uVar, this.zb);
        c(uVar, this.or);
    }

    private void c(u uVar, com.byazt.hkv.c cVar) {
        my interactionManager;
        if (cVar == null) {
            return;
        }
        ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).c(uVar);
        com.byazt.vis.ve veVar = (com.byazt.vis.ve) cVar.c(com.byazt.vis.ve.class);
        if ((uVar instanceof com.byazt.kyz.ve) && (interactionManager = ((com.byazt.kyz.ve) uVar).getInteractionManager()) != null) {
            interactionManager.c(veVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View, com.byazt.jr.tt] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.ViewGroup, android.widget.RelativeLayout] */
    public void c(Context context, View view, ic icVar) {
        ?? sSRenderTextureView;
        System.currentTimeMillis();
        if (view != null) {
            view.setKeepScreenOn(true);
        }
        if (com.byazt.ic.c.tt(icVar)) {
            sSRenderTextureView = new TTLottieVideoContainer(this.yv);
        } else if (com.byazt.ic.c.ve(icVar)) {
            sSRenderTextureView = new UpieVideoView(context, com.byazt.ic.c.i(icVar));
        } else {
            sSRenderTextureView = new SSRenderTextureView(this.yv);
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(sSRenderTextureView, 0, layoutParams);
            if (qp()) {
                view.setBackgroundColor(0);
            } else {
                view.setBackgroundColor(-16777216);
            }
        }
        pf.c((View) sSRenderTextureView, 8);
        this.tt = sSRenderTextureView;
        this.ve = (ImageView) view.findViewById(2114387626);
        this.z = (TTProgressBar) view.findViewById(2114387653);
        this.uj = view.findViewById(2114387900);
        this.n = view.findViewById(2114387631);
        this.f29103a = (ImageView) view.findViewById(2114387651);
        this.sp = (TTViewStub) view.findViewById(2114387744);
        this.lr = (TTViewStub) view.findViewById(2114387666);
        this.m = (TTViewStub) view.findViewById(2114387828);
        if (com.byazt.ex.c.c(icVar)) {
            tt(context, view);
        }
        System.currentTimeMillis();
    }

    public void uj(int i) {
        this.gu = i;
        pf.c(this.c, i);
    }

    private void tt(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.m) == null || tTViewStub.getParent() == null || this.nb != null) {
            return;
        }
        this.m.c();
        this.nb = view.findViewById(2114387674);
        this.pf = (TextView) view.findViewById(2114387868);
        this.bx = (TextView) view.findViewById(2114387842);
    }

    public a(Context context, View view, boolean z, EnumSet<com.byazt.dh.tt.c> enumSet, ic icVar, com.byazt.dh.ve veVar, com.byazt.hkv.c cVar) {
        this(context, view, z, enumSet, icVar, veVar, true, cVar);
    }

    public void tt(boolean z, boolean z2) {
        ImageView imageView = this.ve;
        if (imageView != null) {
            if (z) {
                com.byazt.nr.z.c(this.yv, "tt_new_play_video", imageView, 320);
            } else {
                com.byazt.nr.z.c(this.yv, "tt_new_pause_video", imageView, 320);
            }
        }
    }

    public void tt(int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.c;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.c.setLayoutParams(layoutParams);
    }

    public void tt(int i) {
        com.byazt.nr.m.c("Progress", "setSeekProgress-percent=".concat(String.valueOf(i)));
        pf.c((View) this.z, 0);
        TTProgressBar tTProgressBar = this.z;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(i);
        }
    }

    @Override // com.byazt.dh.tt
    public void tt() {
        if (qp()) {
            pf.c(this.uj, 8);
            pf.c(this.n, 8);
            pf.c((View) this.f29103a, 8);
            pf.c((View) this.ve, 8);
            return;
        }
        pf.c((View) this.aw, 8);
        pf.n(this.uj);
        pf.n(this.n);
        ImageView imageView = this.f29103a;
        if (imageView != null) {
            pf.n(imageView);
        }
    }

    public void c(Context context, View view) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.lr) == null || tTViewStub.getParent() == null || this.l != null) {
            return;
        }
        this.l = this.lr.c();
        this.lo = (RelativeLayout) view.findViewById(2114387953);
        this.pu = (RoundImageView) view.findViewById(2114387958);
        this.lt = (TextView) view.findViewById(2114387926);
        this.to = (TextView) view.findViewById(2114387877);
    }

    public void c(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.sp) == null || tTViewStub.getParent() == null || this.x != null) {
            return;
        }
        this.x = this.sp.c();
        this.sp.setVisibility(0);
        this.i = (ImageView) view.findViewById(2114387804);
        this.da = view.findViewById(2114387961);
        this.sl = (RoundImageView) view.findViewById(2114387664);
        this.t = (TextView) view.findViewById(2114387957);
        this.u = (TextView) view.findViewById(2114387764);
        this.yp = (TextView) view.findViewById(2114387686);
    }

    public boolean c(int i, com.byazt.jzl.uj ujVar, boolean z) {
        z zVar = this.p;
        return zVar == null || zVar.c(i, ujVar, z);
    }

    public void c(com.byazt.dh.c cVar) {
        if (cVar instanceof tt) {
            this.md = (tt) cVar;
            my();
        }
    }

    public void c(int i, int i2) {
        if (i == -1) {
            i = pf.uj(this.yv);
        }
        if (i <= 0) {
            return;
        }
        this.nu = i;
        if (!sl() && !da() && !this.gr.contains(com.byazt.dh.tt.c.fixedSize)) {
            this.rh = sp(i);
        } else {
            this.rh = i2;
        }
        tt(this.nu, this.rh);
    }

    @Override // com.byazt.dh.tt
    public void c() {
        c(false, this.rl);
        zm();
    }

    @Override // com.byazt.dh.tt
    public void c(boolean z) {
        this.qp = z;
    }

    public void c(final ImageView imageView, String str) {
        if (imageView == null || !com.byazt.ic.c.c(this.zm) || com.byazt.ic.c.sp(this.zm)) {
            return;
        }
        com.byazt.xky.tt.c(str).config(Bitmap.Config.ARGB_4444).type(2).to(new gr<Bitmap>() { // from class: com.byazt.un.a.12
            @Override // com.byazt.yj.gr
            public void onFailed(int i, String str2, Throwable th) {
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(m<Bitmap> mVar) {
                Bitmap result;
                if (mVar == null || (result = mVar.getResult()) == null) {
                    return;
                }
                final Bitmap bitmapC = com.byazt.or.tt.c(a.this.yv, result, 25);
                x.c(new Runnable() { // from class: com.byazt.un.a.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bitmapC != null) {
                            imageView.setBackground(new BitmapDrawable(bitmapC));
                        }
                    }
                });
            }
        }, 4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    public void c2(ic icVar, WeakReference<Context> weakReference, boolean z) {
        String strOp;
        ic icVar2;
        if (icVar == null || qp()) {
            return;
        }
        c(false, this.rl);
        if (com.byazt.ex.c.c(icVar)) {
            c(gt.getContext(), this.c);
            rh();
            return;
        }
        c(this.c, gt.getContext());
        View view = this.x;
        if (view != null) {
            pf.c(view, 0);
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            pf.c((View) imageView, 0);
        }
        if (nb.ve(this.zm)) {
            tt(this.c, gt.getContext());
            pf.c(this.da, 8);
            pf.c((View) this.i, 0);
            pf.c(this.nb, 0);
            pf.c((View) this.pf, 0);
            pf.c((View) this.bx, 0);
            if (this.bx != null && rh.ve(gt.getContext()) == 0) {
                pf.c((View) this.bx, 8);
            }
            View view2 = this.x;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.un.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        com.byazt.dh.ve veVar = a.this.eo;
                        if (veVar != null) {
                            ((com.byazt.dh.c) veVar).c();
                            com.byazt.uz.c cVar = a.this.cu;
                            if (cVar != null) {
                                cVar.c();
                            }
                        }
                    }
                });
            }
            if (this.i != null && !TextUtils.isEmpty(xd.tt(this.zm))) {
                if (com.byazt.ic.c.tt(icVar)) {
                    com.byazt.xky.tt.c(xd.tt(this.zm)).to(this.i);
                    c(this.i, xd.tt(this.zm));
                } else {
                    com.byazt.vv.tt.c(2147483647L, xd.c(this.zm), new com.byazt.vv.tt.InterfaceC0560tt() { // from class: com.byazt.un.a.3
                        @Override // com.byazt.vv.tt.InterfaceC0560tt
                        public void c(Bitmap bitmap) {
                            if (bitmap == null) {
                                com.byazt.xky.tt.c(xd.tt(a.this.zm)).to(a.this.i);
                                return;
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a.this.i.getLayoutParams();
                            if (bitmap.getWidth() > bitmap.getHeight()) {
                                float height = (bitmap.getHeight() * pf.uj(gt.getContext())) / bitmap.getWidth();
                                layoutParams.width = pf.uj(gt.getContext());
                                layoutParams.height = (int) height;
                                layoutParams.addRule(13);
                                a.this.i.setLayoutParams(layoutParams);
                            }
                            a.this.i.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        } else {
            pf.c(this.da, 0);
            if (this.i != null && !TextUtils.isEmpty(xd.tt(this.zm))) {
                com.byazt.xky.tt.c(xd.tt(this.zm)).to(this.i);
                c(this.i, xd.tt(this.zm));
            }
            if (bx()) {
                this.da.post(new Runnable() { // from class: com.byazt.un.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.pf();
                    }
                });
            }
        }
        if (!TextUtils.isEmpty(icVar.an())) {
            strOp = icVar.an();
        } else if (!TextUtils.isEmpty(icVar.v_())) {
            strOp = icVar.v_();
        } else {
            strOp = !TextUtils.isEmpty(icVar.op()) ? icVar.op() : "";
        }
        if (this.sl != null && (icVar2 = this.zm) != null && icVar2.te() != null && this.zm.te().c() != null) {
            pf.c((View) this.sl, 0);
            pf.c((View) this.t, 4);
            com.byazt.xky.tt.c(this.zm.te()).to(this.sl);
            if (eo()) {
                this.sl.setOnClickListener(this.or);
                this.sl.setOnTouchListener(this.or);
            } else {
                this.sl.setOnClickListener(this.zb);
                this.sl.setOnTouchListener(this.zb);
            }
        } else if (!TextUtils.isEmpty(strOp)) {
            pf.c((View) this.sl, 4);
            pf.c((View) this.t, 0);
            TextView textView = this.t;
            if (textView != null) {
                textView.setText(strOp.substring(0, 1));
                if (eo()) {
                    this.t.setOnClickListener(this.or);
                    this.t.setOnTouchListener(this.or);
                } else {
                    this.t.setOnClickListener(this.zb);
                    this.t.setOnTouchListener(this.zb);
                }
            }
        }
        if (this.u != null && !TextUtils.isEmpty(strOp)) {
            this.u.setText(strOp);
        }
        pf.c((View) this.u, 0);
        pf.c((View) this.yp, 0);
        String strTj = icVar.tj();
        if (TextUtils.isEmpty(strTj)) {
            int i = icVar.i();
            if (i != 4) {
                strTj = i != 5 ? "查看详情" : "立即拨打";
            } else {
                strTj = "立即下载";
            }
        }
        TextView textView2 = this.yp;
        if (textView2 != null) {
            textView2.setText(strTj);
            this.yp.setOnClickListener(this.zb);
            this.yp.setOnTouchListener(this.zb);
        }
        TextView textView3 = this.pf;
        if (textView3 != null) {
            textView3.setText(strTj);
            this.pf.setOnClickListener(this.zb);
            this.pf.setOnTouchListener(this.zb);
        }
        if (this.qp) {
            return;
        }
        x(4);
    }

    @Override // com.byazt.jr.c
    public void c(SurfaceTexture surfaceTexture, int i, int i2) {
        this.qy = true;
        if (rl()) {
            this.md.c(this, surfaceTexture);
        }
    }

    @Override // com.byazt.jr.c
    public boolean c(SurfaceTexture surfaceTexture) {
        this.qy = false;
        if (!rl()) {
            return true;
        }
        this.md.tt(this, surfaceTexture);
        return true;
    }

    public void c(boolean z, boolean z2, boolean z3) {
        pf.c((View) this.z, 0);
        pf.c((View) this.ve, (z && (pf.uj(this.uj) && pf.uj(this.aw))) ? 0 : 8);
    }

    public void c(boolean z, boolean z2) {
        pf.c((View) this.z, z ? 0 : 8);
        pf.c((View) this.ve, 8);
    }

    public void c(com.byazt.uz.c cVar) {
        this.cu = cVar;
        com.byazt.hkv.c cVar2 = this.zb;
        if (cVar2 != null) {
            ((com.byazt.nat.c) cVar2.c(com.byazt.nat.c.class)).c(cVar);
        }
    }

    @Override // com.byazt.dh.tt
    public void c(Drawable drawable) {
        View view = this.c;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.byazt.dh.tt
    public void c(int i) {
        pf.c((View) this.bm, i);
    }

    public void c(com.byazt.ua.c.InterfaceC0539c interfaceC0539c) {
        this.kk = interfaceC0539c;
        com.byazt.pop.ve veVar = this.d;
        if (veVar != null) {
            veVar.c(interfaceC0539c);
        }
    }
}
