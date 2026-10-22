package com.byazt.ouz;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.el.SSWebView;
import com.byazt.ete.h;
import com.byazt.ete.ic;
import com.byazt.ete.pu;
import com.byazt.ete.v;
import com.byazt.omf.d;
import com.byazt.omf.zb;
import com.byazt.ui.UpieImageView;
import com.byazt.xv.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 2233})
public class NativeExpressView extends FrameLayout implements com.byazt.kn.uj, com.byazt.xv.c, com.byazt.xl.x, com.byazt.xl.z, m, sl, com.byazt.qdk.tt {
    public static int my = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f28916a;
    public Runnable aw;
    public com.byazt.xl.a b;
    public final Runnable bm;
    public final AtomicBoolean bx;
    public boolean c;
    public FrameLayout cu;
    public boolean d;
    public String da;
    public float dz;
    public v eo;
    public float f;
    public View g;
    public com.byazt.hkv.tt gr;
    public boolean gt;
    public com.byazt.hkv.c gu;
    public com.byazt.rbg.c h;
    public final Runnable hd;
    public ic i;
    public final ViewTreeObserver.OnScrollChangedListener ic;
    public long ir;
    public boolean iu;
    public SparseArray<com.byazt.hkv.uj.c> j;
    public volatile com.byazt.xl.yp kk;
    public com.byazt.xl.tt kp;
    public ThemeStatusBroadcastReceiver l;
    public yv lo;
    public final Runnable lr;
    public com.byazt.xl.da.c lt;
    public boolean m;
    public float ma;
    public float md;
    public c n;
    public final com.byazt.ddx.n nb;
    public com.byazt.xl.ve nu;
    public FrameLayout or;
    public com.byazt.xl.u os;
    public nu oz;
    public float p;
    public final AtomicBoolean pf;
    public com.byazt.atv.sp pu;
    public com.byazt.atv.a q;
    public FrameLayout qp;
    public boolean qy;
    public boolean r;
    public boolean rh;
    public FrameLayout rl;
    public qy s;
    public ExpressVideoView sl;
    public String sp;
    public FrameLayout sv;
    public com.byazt.dh.ve.uj t;
    public com.byazt.xl.m tk;
    public List<com.byazt.xl.da> to;
    public int tt;
    public com.byazt.xl.i tx;
    public com.byazt.dh.ve.InterfaceC0386ve u;
    public Dialog uj;
    public com.byazt.xl.uj<? extends View> v;
    public com.byazt.dyf.tt ve;
    public com.byazt.dj.tt x;
    public com.byazt.but.ve y;
    public float yf;
    public FrameLayout yp;
    public String yv;
    public boolean z;
    public com.byazt.qmz.c zb;
    public final AtomicBoolean zm;

    public NativeExpressView(Context context, ic icVar, com.byazt.dj.tt ttVar, String str) {
        super(context);
        this.c = true;
        this.tt = 0;
        this.sp = com.byazt.dyf.tt.AD_TAG_FEED;
        this.zm = new AtomicBoolean(false);
        this.yv = null;
        this.m = false;
        this.rh = false;
        this.gt = false;
        this.d = false;
        this.pf = new AtomicBoolean(false);
        this.qy = false;
        this.bx = new AtomicBoolean(false);
        this.ic = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.ouz.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.a(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.hd);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.hd, 500L);
            }
        };
        this.hd = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.5
            @Override // java.lang.Runnable
            public void run() {
                if (!zb.tt(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.sp(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.sp(nativeExpressView.getVisibility());
                }
            }
        };
        this.bm = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sp(0);
            }
        };
        this.lr = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sp(8);
            }
        };
        this.j = new SparseArray<>();
        this.dz = -1.0f;
        this.ma = -1.0f;
        this.yf = -1.0f;
        this.f = -1.0f;
        this.ir = 0L;
        this.sp = str;
        this.f28916a = context;
        this.i = icVar;
        this.nb = new com.byazt.ddx.n(icVar, str);
        this.x = ttVar;
        sl();
    }

    private void d() {
        if (yp()) {
            return;
        }
        gr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo() {
        com.byazt.rbg.c cVar = this.h;
        if (cVar instanceof com.byazt.ddx.da) {
            ((com.byazt.ddx.da) cVar).tt(this.os.x());
        }
        this.h.c();
        this.lt.c(this);
        this.lt.c();
    }

    private int getRenderThread() {
        if (md() && com.byazt.omf.gt.tt().x(nb.t(this.i)) == 4) {
            return 1;
        }
        if ((com.byazt.by.n.c().t() & 2) == 2) {
            return 1;
        }
        return pu.uj(this.i);
    }

    private void gr() {
        try {
            if (this.l == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            this.f28916a.registerReceiver(this.l, intentFilter, nb.p(), null);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    private void gu() {
        com.byazt.dj.tt ttVar;
        if (TextUtils.equals(this.sp, "splash_ad") && (ttVar = this.x) != null && this.md == ttVar.sp() && this.p == this.x.a()) {
            this.md = pf.uj(this.f28916a, this.md);
            int iUj = pf.uj(this.f28916a);
            float f = this.p;
            float f2 = iUj;
            if (f < f2) {
                this.p = pf.uj(this.f28916a, f2);
            } else {
                this.p = pf.uj(this.f28916a, f);
            }
        }
    }

    private void h() {
        this.tt = pu.tt(this.i);
        if (md() && pu.c(this.i) == 1) {
            this.tt = 1000;
        }
        com.byazt.vu.c cVar = new com.byazt.vu.c(this.i, new WeakReference(this));
        int i = this.tt;
        if (i == 3) {
            com.byazt.xl.tt ttVar = new com.byazt.xl.tt(this.f28916a, this.os, this.l, this.gt, new com.byazt.du.sp(), this, cVar);
            this.kp = ttVar;
            this.to.add(ttVar);
            this.kp.c(com.byazt.omf.gt.tt().ra());
        } else if (i == 7) {
            com.byazt.atv.n nVar = new com.byazt.atv.n(this.f28916a, this.i, (com.byazt.atv.tt) this.os, this);
            this.d = nVar.da();
            com.byazt.atv.a aVar = new com.byazt.atv.a(this.f28916a, nVar, this, this.os, this);
            this.q = aVar;
            this.to.add(aVar);
        } else if (i == 10) {
            com.byazt.atv.sp spVar = new com.byazt.atv.sp(this.f28916a, this.i, (com.byazt.atv.tt) this.os, this);
            this.pu = spVar;
            this.d = spVar.da();
            this.q = new com.byazt.atv.a(this.f28916a, this.pu, this, this.os, this);
            if (pu.c(nb.sl(this.i))) {
                this.pu.c(new com.byazt.sz.x() { // from class: com.byazt.ouz.NativeExpressView.8
                    @Override // com.byazt.sz.x
                    public void c(com.byazt.sz.i.c cVar2) {
                        try {
                            uj.c(cVar2.n(), NativeExpressView.this.os.n());
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.byazt.sz.x
                    public void tt(com.byazt.sz.i.c cVar2) {
                    }
                });
            }
            this.to.add(this.q);
        } else if (i != 1000) {
            yv yvVar = new yv(this.f28916a, this.os, this.l, this.h, this.i, this.tx, this);
            this.lo = yvVar;
            com.byazt.xl.m mVar = new com.byazt.xl.m(this.f28916a, this.os, yvVar, this);
            this.tk = mVar;
            this.to.add(mVar);
        }
        int iVe = pu.ve(this.i);
        if (iVe > 0 && yv() && TextUtils.equals(this.sp, com.byazt.dyf.tt.AD_TAG_FEED)) {
            this.to.add(new com.byazt.atv.a(this.f28916a, new com.byazt.ouc.ve(this.f28916a, this.i, (com.byazt.atv.tt) this.os, this), this, this.os, this));
        } else {
            boolean z = iVe == 1;
            this.c = z;
            if (z || this.tt == 1000) {
                com.byazt.xl.a aVar2 = new com.byazt.xl.a(this.f28916a, this.os, new my(this, this.l, this.os));
                this.b = aVar2;
                this.to.add(aVar2);
            } else if (com.byazt.ouc.c.tt(this.i)) {
                this.to.add(new com.byazt.atv.a(this.f28916a, new com.byazt.ouc.ve(this.f28916a, this.i, (com.byazt.atv.tt) this.os, this), this, this.os, this));
            }
        }
        this.lt = new com.byazt.xl.t(this.to, this.tx);
    }

    private boolean md() {
        return TextUtils.equals(this.sp, "splash_ad") || TextUtils.equals(this.sp, "cache_splash_ad");
    }

    private boolean p() {
        if (TextUtils.equals(this.sp, "rewarded_video") || TextUtils.equals(this.sp, "fullscreen_interstitial_ad")) {
            return this.i.fe();
        }
        return true;
    }

    private void u() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = new ThemeStatusBroadcastReceiver();
        this.l = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.c(this);
    }

    private boolean yp() {
        return md() && pu.c(this.i) == 1;
    }

    private boolean yv() {
        com.byazt.dj.tt ttVar = this.x;
        return ttVar != null && com.byazt.omf.p.uj >= 5900 && ttVar.yv();
    }

    private boolean zb() {
        ic icVar = this.i;
        return icVar != null && icVar.vp() == 1 && ic.ve(this.i);
    }

    private void zm() {
        com.byazt.xl.u.c cVar;
        List<com.byazt.ete.zb> listPa;
        com.byazt.ete.zb zbVar;
        boolean zX = pu.x(this.i);
        JSONObject jSONObjectC = null;
        if (!yp()) {
            boolean z = pu.tt(this.i) == 9 || pu.tt(this.i) == 0;
            if (zX) {
                jSONObjectC = com.byazt.jlk.tt.c(this.i, com.byazt.jlk.tt.c(this.p, this.md, this.m), com.byazt.jlk.tt.c(this.i), false, this.da, z);
            } else if (!pu.da(this.i)) {
                jSONObjectC = com.byazt.jlk.tt.c(this.p, this.md, this.m, this.i, z);
            } else if (pu.a(this.i) != null && !TextUtils.isEmpty(pu.a(this.i).i())) {
                jSONObjectC = com.byazt.xs.da.c(pu.a(this.i).i(), pu.a(this.i).da(), (com.byazt.xs.ve) null);
            }
            if (pu.a(this.i) != null) {
                com.byazt.omf.uj.c().c(pu.a(this.i).tt());
            }
            if (pu.sp(this.i) != null) {
                com.byazt.omf.uj.c().c(pu.sp(this.i).c());
            }
        }
        this.h = tt(jSONObjectC);
        if (yp()) {
            this.tx = new gt();
        } else {
            this.tx = new da(this.h, this.sp, this.i, this.yv);
        }
        boolean zP = p();
        if (pu.da(this.i) || pu.t(this.i) || com.byazt.ouc.c.tt(this.i) || yv()) {
            com.byazt.atv.tt.c cVar2 = new com.byazt.atv.tt.c();
            cVar2.n(com.byazt.xs.da.c(this.i, (View) this, false));
            cVar2.c((com.byazt.sz.qy) this.tx);
            cVar2.c(this.p);
            cVar2.tt(this.md);
            cVar2.n(yv());
            cVar2.sl(1);
            cVar = cVar2;
        } else {
            cVar = new com.byazt.xl.u.c();
        }
        cVar.ve(zX);
        if (TextUtils.equals(this.sp, "splash_ad")) {
            cVar.a(com.byazt.bzd.sl.n());
        }
        if (pu.tt(this.i) == 3 && com.byazt.ic.c.uj(this.i) && (listPa = this.i.pa()) != null && !listPa.isEmpty() && (zbVar = listPa.get(0)) != null) {
            cVar.i(zbVar.c());
            cVar.c(new UpieImageView(this.f28916a, com.byazt.ic.c.i(this.i), com.byazt.nj.c.c(this.i), com.byazt.ic.c.da(this.i)));
        }
        this.os = cVar.c(this.sp).tt(this.i.uj()).ve(nb.my(this.i)).uj(this.i.w_()).c(jSONObjectC).c(this.tx).c(com.byazt.omf.gt.tt().c(this.sp, pu.tt(this.i))).tt(zP).tt(this.i.vi()).ve(this.i.i()).n(com.byazt.jlk.tt.uj(this.i)).c(com.byazt.jlk.tt.n(this.i)).uj(getRenderThread()).n(this.i.ge()).a(this.i.tw()).sp(this.i.br()).tt(this.i.lv()).ve(this.i.cy()).uj(this.i.yx()).i(this.i.pe()).x(this.i.e()).sp(this.i.dn()).x("https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/").c(com.byazt.omf.x.m().uj()).da(this.i.eo()).uj(com.byazt.omf.gt.tt().tw()).c();
    }

    @Override // com.byazt.xl.z
    public void a_(final int i) {
        this.iu = true;
        if (!this.c) {
            this.tx.sl();
        }
        this.tx.t();
        com.byazt.xl.i iVar = this.tx;
        if (iVar instanceof da) {
            ((da) iVar).yp();
        }
        if (this.n != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.n.c(this, com.byazt.omf.sp.c(i), i);
            } else {
                com.byazt.omf.rh.a().post(new Runnable() { // from class: com.byazt.ouz.NativeExpressView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.n != null) {
                            NativeExpressView.this.n.c(NativeExpressView.this, com.byazt.omf.sp.c(i), i);
                        }
                    }
                });
            }
        }
    }

    @Override // com.byazt.xv.c
    public void b_(int i) {
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (ujVar == null || !(ujVar instanceof yp)) {
            return;
        }
        ((yp) ujVar).b_(i);
    }

    public long c() {
        return 0L;
    }

    public void c(float f) {
    }

    public void c(float f, float f2, float f3, float f4, int i) {
    }

    public void c(int i) {
    }

    public void c(int i, String str) {
    }

    @Override // com.byazt.ouz.sl
    public void c(ic icVar) {
    }

    @Override // com.byazt.qdk.tt
    public void c(String str) {
    }

    public void da() {
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b1  */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        SparseArray<com.byazt.hkv.uj.c> sparseArray;
        com.byazt.hkv.c cVar = this.gu;
        int i2 = 0;
        if (cVar != null) {
            cVar.ve(motionEvent.getDeviceId());
            this.gu.tt(motionEvent.getSource());
            this.gu.uj(motionEvent.getToolType(0));
        }
        com.byazt.hkv.tt ttVar = this.gr;
        if (ttVar != null) {
            ttVar.ve(motionEvent.getDeviceId());
            this.gr.tt(motionEvent.getSource());
            this.gr.uj(motionEvent.getToolType(0));
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            i2 = 3;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    i2 = actionMasked != 3 ? -1 : 4;
                } else {
                    this.yf += Math.abs(motionEvent.getX() - this.dz);
                    this.f += Math.abs(motionEvent.getY() - this.ma);
                    this.dz = motionEvent.getX();
                    this.ma = motionEvent.getY();
                    i = (System.currentTimeMillis() - this.ir <= 200 || (this.yf <= 8.0f && this.f <= 8.0f)) ? 2 : 1;
                }
            }
            sparseArray = this.j;
            if (sparseArray != null) {
                sparseArray.put(motionEvent.getActionMasked(), new com.byazt.hkv.uj.c(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        this.dz = motionEvent.getRawX();
        this.ma = motionEvent.getRawY();
        this.ir = System.currentTimeMillis();
        i = i2;
        sparseArray = this.j;
        if (sparseArray != null) {
            sparseArray.put(motionEvent.getActionMasked(), new com.byazt.hkv.uj.c(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.byazt.ddx.n getAdShowTime() {
        return this.nb;
    }

    public com.byazt.hkv.c getClickCreativeListener() {
        return this.gu;
    }

    public com.byazt.hkv.tt getClickListener() {
        return this.gr;
    }

    public int getDynamicShowType() {
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (ujVar != null) {
            return ujVar.ve();
        }
        return 0;
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.qp;
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.md).intValue();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.p).intValue();
    }

    public c getExpressInteractionListener() {
        return this.n;
    }

    public d getJsObject() {
        yv yvVar = this.lo;
        if (yvVar != null) {
            return yvVar.J_();
        }
        return null;
    }

    public int getRenderEngineCacheType() {
        sp spVarZ;
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (!(ujVar instanceof yv) || (spVarZ = ((yv) ujVar).z()) == null) {
            return 0;
        }
        return spVarZ.c();
    }

    public byte getShowDLFactorsEventParams() {
        if (!com.byazt.wz.x.a(this.i)) {
            return (byte) -1;
        }
        boolean zUj = com.byazt.yih.c.uj(this.i);
        boolean z = this.bx.get();
        if (zUj) {
            if (z) {
                return (byte) 3;
            }
            if (!rl()) {
                return (byte) 1;
            }
        } else if (z) {
            return (byte) 2;
        }
        return (byte) 0;
    }

    public com.byazt.atv.sp getUGenV3Render() {
        return this.pu;
    }

    public ViewGroup getVideoContainer() {
        return this.yp;
    }

    public com.byazt.dh.ve getVideoController() {
        return null;
    }

    public SSWebView getWebView() {
        yv yvVar = this.lo;
        if (yvVar == null) {
            return null;
        }
        return yvVar.c();
    }

    public void gt() {
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (!(ujVar instanceof com.byazt.atv.n) || (ujVar instanceof com.byazt.atv.sp)) {
            return;
        }
        ((com.byazt.atv.n) ujVar).uj();
    }

    public void i() {
        Dialog dialog = this.uj;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.byazt.dyf.tt ttVar = this.ve;
        if (ttVar != null) {
            ttVar.showDislikeDialog();
        } else {
            TTDelegateActivity.c(getContext(), this.i);
        }
    }

    public void m() {
        if (!com.byazt.omf.gt.tt().uv() || !this.iu) {
            if (com.byazt.omf.gt.tt().ra() && com.byazt.bzd.x.c()) {
                com.byazt.nr.da.ve().post(new Runnable() { // from class: com.byazt.ouz.NativeExpressView.10
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeExpressView.this.eo();
                    }
                });
                return;
            } else {
                eo();
                return;
            }
        }
        if (this.n != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.n.c(this, com.byazt.omf.sp.c(-16), -16);
            } else {
                com.byazt.omf.rh.a().post(new Runnable() { // from class: com.byazt.ouz.NativeExpressView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.n != null) {
                            NativeExpressView.this.n.c(NativeExpressView.this, com.byazt.omf.sp.c(-16), -16);
                        }
                    }
                });
            }
        }
    }

    public void my() {
        try {
            FrameLayout frameLayout = this.yp;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.yp);
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.ouz.sl
    public void n() {
    }

    public void n(int i) {
    }

    public void nu() {
        yv yvVar = this.lo;
        if (yvVar == null || yvVar.sp() == null) {
            return;
        }
        this.lo.n();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.byazt.nr.m.uj("webviewpool", "onAttachedToWindow+++");
        a(51);
        getViewTreeObserver().addOnScrollChangedListener(this.ic);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.byazt.rbg.c cVar = this.h;
            if (cVar != null) {
                cVar.tt(true);
            }
            getViewTreeObserver().removeOnScrollChangedListener(this.ic);
        } catch (Exception unused) {
        }
        com.byazt.nr.m.uj("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.byazt.nr.m.uj("webviewpool", "onFinishTemporaryDetach+++");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        nu nuVar;
        return (!yv() || (nuVar = this.oz) == null) ? super.onInterceptTouchEvent(motionEvent) : nuVar.c(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a(55);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.byazt.nr.m.uj("webviewpool", "onStartTemporaryDetach===");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        nu nuVar;
        return (!yv() || (nuVar = this.oz) == null) ? super.onTouchEvent(motionEvent) : nuVar.tt(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a(z ? 53 : 54);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z ? getVisibility() : 8);
        }
        yv yvVar = this.lo;
        if (yvVar != null) {
            yvVar.tt(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.lr);
        removeCallbacks(this.bm);
        if (i == 0) {
            postDelayed(this.bm, 50L);
        } else {
            postDelayed(this.lr, 50L);
        }
    }

    public void qy() {
        qy qyVar = this.s;
        if (qyVar != null) {
            qyVar.uj();
        }
    }

    public void rh() {
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (ujVar instanceof com.byazt.atv.n) {
            ((com.byazt.atv.n) ujVar).nu();
        }
    }

    public boolean rl() {
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        return ujVar != null && ujVar.ve() == 1;
    }

    public void setBackupListener(com.byazt.xl.ve veVar) {
        this.nu = veVar;
        com.byazt.xl.a aVar = this.b;
        if (aVar != null) {
            aVar.c(veVar);
        }
    }

    public void setClickCreativeListener(com.byazt.hkv.c cVar) {
        this.gu = cVar;
    }

    public void setClickListener(com.byazt.hkv.tt ttVar) {
        this.gr = ttVar;
    }

    public void setDislike(com.byazt.dyf.tt ttVar) {
        BackupView backupView;
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (ujVar != null && (ujVar instanceof my) && (backupView = (BackupView) ujVar.sp()) != null) {
            backupView.setDislikeInner(ttVar);
        }
        this.ve = ttVar;
        ic icVar = this.i;
        if (icVar != null) {
            com.byazt.omf.rl.tt(icVar.lw(), ttVar, com.byazt.dyf.tt.class);
        }
    }

    public void setDynamicSkipListener(com.byazt.but.ve veVar) {
        this.y = veVar;
    }

    public void setEasyPlayableSender(com.byazt.sy.sp spVar) {
        ExpressVideoView expressVideoView = this.sl;
        if (expressVideoView == null) {
            return;
        }
        expressVideoView.setEasyPlayableEventSender(spVar);
    }

    public void setExpressInteractionListener(c cVar) {
        this.n = cVar;
    }

    public void setOuterDislike(Dialog dialog) {
        BackupView backupView;
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (ujVar != null && (ujVar instanceof my) && (backupView = (BackupView) ujVar.sp()) != null) {
            backupView.setDislikeOuter(dialog);
        }
        this.uj = dialog;
        ic icVar = this.i;
        if (icVar != null) {
            com.byazt.omf.rl.tt(icVar.lw(), dialog, Dialog.class);
        }
    }

    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.kn.uj
    public void setSoundMute(boolean z) {
        this.gt = z;
        com.byazt.xl.tt ttVar = this.kp;
        if (ttVar != null && ttVar.tt() != null) {
            this.kp.tt().setSoundMute(z);
        }
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (ujVar == null || ujVar.ve() != 7) {
            return;
        }
        com.byazt.xl.uj<? extends View> ujVar2 = this.v;
        if (ujVar2 instanceof com.byazt.atv.n) {
            ((com.byazt.kn.uj) ujVar2).setSoundMute(z);
        }
    }

    public void setTimeUpdate(int i) {
    }

    public void setVideoAdInteractionListener(com.byazt.dh.ve.InterfaceC0386ve interfaceC0386ve) {
        this.u = interfaceC0386ve;
    }

    public void setVideoAdListener(com.byazt.dh.ve.uj ujVar) {
        this.t = ujVar;
    }

    public void sl() {
        this.rl = new FrameLayout(this.f28916a);
        this.cu = new FrameLayout(this.f28916a);
        this.qp = new FrameLayout(this.f28916a);
        addView(this.rl);
        addView(this.cu);
        addView(this.qp);
        this.to = new ArrayList();
        com.byazt.dj.tt ttVar = this.x;
        if (ttVar != null) {
            this.p = ttVar.x();
            this.md = this.x.i();
            gu();
            this.yv = this.x.uj();
        }
        if (!yp()) {
            setBackgroundColor(0);
            setBackgroundResource(R.color.transparent);
            u();
        }
        zm();
        h();
        com.byazt.xl.m mVar = this.tk;
        if (mVar != null) {
            this.lo = (yv) mVar.tt();
        }
        if (yv()) {
            this.oz = new nu(this);
        }
    }

    public void t() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver;
        try {
            com.byazt.xl.uj<? extends View> ujVar = this.v;
            if (ujVar instanceof com.byazt.atv.n) {
                ((com.byazt.atv.n) ujVar).m();
            }
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            Iterator<com.byazt.xl.da> it = this.to.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            this.ve = null;
            this.uj = null;
            this.x = null;
            this.i = null;
            this.gu = null;
            this.nu = null;
            this.gr = null;
            this.t = null;
            this.u = null;
            this.n = null;
            Context context = this.f28916a;
            if (context != null && (themeStatusBroadcastReceiver = this.l) != null) {
                context.unregisterReceiver(themeStatusBroadcastReceiver);
            }
            ExpressVideoView expressVideoView = this.sl;
            if (expressVideoView != null) {
                expressVideoView.gt();
            }
            View view = this.g;
            if (view != null) {
                view.removeCallbacks(this.aw);
            }
            this.nb.c(56);
        } catch (Throwable th) {
            com.byazt.nr.m.ve("NativeExpressView", "detach error", th);
        }
    }

    public int tt() {
        return 0;
    }

    @Override // com.byazt.ouz.sl
    public void tt(int i) {
    }

    @Override // com.byazt.ouz.sl
    public void uj() {
    }

    public void uj(int i) {
    }

    @Override // com.byazt.ouz.sl
    public int ve() {
        return 0;
    }

    public void ve(int i) {
    }

    public void x() {
    }

    public void x(int i) {
        this.os.c(i);
    }

    public void z() {
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (ujVar instanceof yp) {
            ((yp) ujVar).x();
        } else if (ujVar instanceof com.byazt.atv.n) {
            ((com.byazt.atv.n) ujVar).z();
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.pf.get() && this.nb.c()) {
            this.nb.c(zb.tt(this), i);
        }
    }

    private void n(ic icVar) {
        try {
            if (com.byazt.wz.x.a(icVar) && !uj(icVar)) {
                if (com.byazt.yih.c.uj(icVar)) {
                    a(icVar);
                    return;
                } else {
                    tt(false);
                    return;
                }
            }
            tt(false);
        } catch (Exception e) {
            com.byazt.ukr.yp.c().c("express_dl", e);
            tt(false);
        }
    }

    private com.byazt.rbg.c tt(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.ddx.da daVar = new com.byazt.ddx.da(this.sp, this.i, jSONObject2, jSONObject);
        daVar.c(jSONObject2, "webview_source", (Object) 1);
        return daVar;
    }

    private boolean uj(ic icVar) {
        if (icVar == null) {
            return true;
        }
        if (nb.sl(icVar) != 8) {
            return this.md == 0.0f;
        }
        if (icVar.fr() == 0.0f || icVar.fr() == 100.0f) {
            return ((float) (this.cu.getHeight() == 0 ? pf.ve(getContext(), this.md) : this.cu.getHeight())) <= 0.0f;
        }
        return true;
    }

    public void sp(int i) {
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (ujVar == null || !(ujVar instanceof yp)) {
            return;
        }
        ((yp) ujVar).tt(i);
    }

    public void ve(boolean z) {
        yv yvVar = this.lo;
        if (yvVar != null) {
            yvVar.ve(z);
        }
    }

    private void a(final ic icVar) {
        if (icVar == null) {
            tt(false);
            return;
        }
        if (com.byazt.wz.x.c(icVar) == 0) {
            tt(icVar, (com.byazt.ete.uj) null);
            return;
        }
        com.byazt.ete.uj ujVarC = com.byazt.yih.c.c(icVar);
        if (ujVarC != null) {
            if (ujVarC.sp()) {
                tt(icVar, ujVarC);
                return;
            } else {
                tt(false);
                return;
            }
        }
        final com.byazt.ete.n nVarZ = icVar.z();
        if (nVarZ == null) {
            tt(false);
        } else {
            com.byazt.bzd.x.c(new com.byazt.bwm.sp("pl_dlf") { // from class: com.byazt.ouz.NativeExpressView.12
                @Override // java.lang.Runnable
                public void run() {
                    final com.byazt.ete.uj ujVarC2 = com.byazt.omf.gt.c().c(NativeExpressView.this.i, nVarZ.tt());
                    com.byazt.bzd.x.c((Runnable) new com.byazt.bwm.sp("pl_udlf") { // from class: com.byazt.ouz.NativeExpressView.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.ete.uj ujVar = ujVarC2;
                            if (ujVar == null || !ujVar.sp()) {
                                NativeExpressView.this.tt(false);
                                return;
                            }
                            try {
                                AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                                NativeExpressView.this.tt(icVar, ujVarC2);
                            } catch (Exception e) {
                                com.byazt.ukr.yp.c().c("express_dl", e);
                                NativeExpressView.this.tt(false);
                            }
                        }
                    });
                }
            });
        }
    }

    private float ve(ic icVar) {
        return (com.byazt.wz.x.n(icVar) && com.byazt.yih.c.uj(icVar)) ? 56.0f : 0.0f;
    }

    private void ve(ic icVar, Context context, String str) {
        if (icVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.aas.n.c(context, icVar, str);
    }

    public void c(View view, int i, com.byazt.sr.ve veVar, v vVar) {
        this.eo = vVar;
        c(view, i, veVar, -1);
        this.eo = null;
    }

    public void sp() {
        if (yv() && TextUtils.equals(this.sp, com.byazt.dyf.tt.AD_TAG_FEED)) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            com.byazt.vo.tt ttVar = new com.byazt.vo.tt(this.i.yg(), com.byazt.tl.uj.c());
            ttVar.tt(com.byazt.dyf.tt.AD_TAG_DISLIKE);
            com.byazt.pr.c.c().c(this.f28916a, ttVar, "close_success");
        }
    }

    public void tt(View view, int i, com.byazt.sr.ve veVar, int i2) {
        if (i == -1 || veVar == null) {
            return;
        }
        com.byazt.ete.gr grVar = (com.byazt.ete.gr) veVar;
        com.byazt.ete.da daVar = new com.byazt.ete.da();
        daVar.c(grVar.nu);
        daVar.c(grVar.c);
        daVar.tt(grVar.tt);
        daVar.ve(grVar.ve);
        daVar.uj(grVar.uj);
        daVar.tt(grVar.z);
        JSONObject jSONObjectC = grVar.c();
        int iOptInt = jSONObjectC.optInt("convertActionType", Integer.MIN_VALUE);
        daVar.uj(jSONObjectC.optBoolean("is_compliant_download"));
        if (iOptInt == 1) {
            if (i == 2) {
                this.gu.ve();
            } else {
                this.gr.ve();
            }
        } else if (iOptInt == 2) {
            if (i == 2) {
                this.gu.uj();
            } else {
                this.gr.uj();
            }
        }
        View view2 = view == null ? this : view;
        com.byazt.hkv.c cVar = this.gu;
        if (cVar != null) {
            cVar.n(getDynamicShowType());
        }
        com.byazt.hkv.tt ttVar = this.gr;
        if (ttVar != null) {
            ttVar.n(getDynamicShowType());
        }
        ic icVar = this.i;
        int i3 = icVar != null ? icVar.i() : 0;
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.yp;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                c(view2, i2, grVar, daVar, i3);
                break;
            case 2:
                tt(view2, i2, grVar, daVar, i3);
                break;
            case 3:
                i();
                break;
            case 4:
                FrameLayout frameLayout2 = this.yp;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                nb.gr(this.i);
                if (com.byazt.dyf.tt.AD_TAG_FEED.equals(this.sp) && zb() && !this.z && nb.gr(this.i)) {
                    tt(view2, i2, grVar, daVar, i3);
                } else {
                    c(view2, i2, grVar, daVar, i3);
                }
                break;
            case 5:
                c(!this.gt);
                break;
            case 6:
                a();
                break;
            case 8:
                sp();
                break;
        }
    }

    @Override // com.byazt.qdk.tt
    public boolean c(String str, com.byazt.xj.ve veVar, com.byazt.qdk.ve veVar2) {
        str.hashCode();
        switch (str) {
            case "clickEvent":
            case "convert":
                c(veVar, veVar2, 2);
                return true;
            case "resumeVideo":
                c(3);
                return true;
            case "pauseVideo":
                c(2);
                return true;
            case "skip":
                a();
                return true;
            case "close":
                sp();
                return true;
            case "videoControl":
                c(veVar, veVar2, 4);
                return true;
            case "muteVideo":
                c(!this.gt);
                return true;
            case "interactiveFinish":
                c(veVar2);
                return true;
            case "dislike":
                i();
                return true;
            default:
                return false;
        }
    }

    public void a() {
        com.byazt.but.ve veVar = this.y;
        if (veVar != null) {
            veVar.c();
        }
    }

    private void c(com.byazt.xj.ve veVar, com.byazt.qdk.ve veVar2, int i) {
        CharSequence text;
        com.byazt.ete.da daVar = (com.byazt.ete.da) veVar2.c("ugen_click_event_params", com.byazt.ete.da.class);
        com.byazt.ete.gr.c cVarC = new com.byazt.ete.gr.c().uj(daVar.nu()).ve(daVar.rh()).tt(daVar.my()).c(daVar.gt()).c(veVar.eo()).tt(daVar.z()).c(daVar.m()).c(com.byazt.atv.sp.tt(veVar2.c("v3_trigger_name")));
        JSONObject jSONObject = new JSONObject();
        int iC = veVar2.c("convert_action_type", 0);
        if (iC > 0) {
            try {
                jSONObject.put("convertActionType", iC);
            } catch (Throwable unused) {
            }
        }
        View viewI = veVar.i();
        try {
            if ((viewI instanceof TextView) && (text = ((TextView) viewI).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused2) {
        }
        cVarC.c(jSONObject);
        c(viewI, i, cVarC.c(), -1);
    }

    public NativeExpressView(boolean z, Context context, ic icVar, com.byazt.dj.tt ttVar, String str, boolean z2) {
        super(context);
        this.c = true;
        this.tt = 0;
        this.sp = com.byazt.dyf.tt.AD_TAG_FEED;
        this.zm = new AtomicBoolean(false);
        this.yv = null;
        this.m = false;
        this.rh = false;
        this.gt = false;
        this.d = false;
        this.pf = new AtomicBoolean(false);
        this.qy = false;
        this.bx = new AtomicBoolean(false);
        this.ic = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.ouz.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.a(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.hd);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.hd, 500L);
            }
        };
        this.hd = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.5
            @Override // java.lang.Runnable
            public void run() {
                if (!zb.tt(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.sp(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.sp(nativeExpressView.getVisibility());
                }
            }
        };
        this.bm = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sp(0);
            }
        };
        this.lr = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sp(8);
            }
        };
        this.j = new SparseArray<>();
        this.dz = -1.0f;
        this.ma = -1.0f;
        this.yf = -1.0f;
        this.f = -1.0f;
        this.ir = 0L;
        this.sp = str;
        this.f28916a = context;
        this.i = icVar;
        this.nb = new com.byazt.ddx.n(icVar, str);
        this.x = ttVar;
        this.m = z;
        this.gt = z2;
        sl();
    }

    private void tt(View view, int i, com.byazt.ete.gr grVar, com.byazt.ete.da daVar, int i2) {
        if (ic.a(this.i)) {
            return;
        }
        com.byazt.hkv.c cVar = this.gu;
        if (cVar != null) {
            c(((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).c(), i);
            this.gu.c(grVar);
            this.gu.c(daVar);
            this.gu.c(view, daVar);
        }
        c cVar2 = this.n;
        if (cVar2 != null) {
            cVar2.c(this, i2);
        }
    }

    public void c(View view, int i, com.byazt.sr.ve veVar, int i2) {
        com.byazt.ete.da daVar;
        com.byazt.vis.c cVar;
        com.byazt.hkv.c cVar2;
        com.byazt.hkv.tt ttVar;
        if (i == -1 || veVar == null) {
            return;
        }
        com.byazt.ete.gr grVar = (com.byazt.ete.gr) veVar;
        com.byazt.hkv.c cVar3 = this.gu;
        if (cVar3 != null) {
            cVar3.n(getDynamicShowType());
        }
        com.byazt.hkv.tt ttVar2 = this.gr;
        if (ttVar2 != null) {
            ttVar2.n(getDynamicShowType());
        }
        if (i != 1 || (ttVar = this.gr) == null) {
            daVar = null;
            cVar = null;
        } else {
            daVar = ttVar.tt();
            cVar = (com.byazt.vis.c) this.gr.c(com.byazt.vis.c.class);
            cVar.c(cVar.n());
        }
        if (i == 2 && (cVar2 = this.gu) != null) {
            daVar = cVar2.tt();
            cVar = (com.byazt.vis.c) this.gu.c(com.byazt.vis.c.class);
            cVar.c(cVar.n());
        }
        try {
            Object obj = grVar.c().get("click_extra_map");
            if (cVar != null && (obj instanceof Map)) {
                cVar.c((Map<String, Object>) obj);
            }
        } catch (JSONException unused) {
        }
        if (daVar == null) {
            daVar = new com.byazt.ete.da();
        }
        if (this.eo != null) {
            daVar.tt(this);
        }
        daVar.c(grVar.c);
        daVar.tt(grVar.tt);
        daVar.ve(grVar.ve);
        daVar.uj(grVar.uj);
        daVar.tt(grVar.z);
        daVar.sp(grVar.my);
        daVar.c(com.byazt.ete.qy.c(this.i, grVar.rh));
        daVar.tt(grVar.rh);
        daVar.c(grVar.m);
        daVar.tt(getShowDLFactorsEventParams());
        SparseArray<com.byazt.hkv.uj.c> sparseArray = grVar.nu;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.j;
        }
        daVar.c(sparseArray);
        JSONObject jSONObjectC = grVar.c();
        daVar.uj(jSONObjectC.optBoolean("is_compliant_download"));
        String strOptString = jSONObjectC.optString("uchain_event_name");
        daVar.ve(strOptString);
        daVar.c(this.qy);
        int iOptInt = jSONObjectC.optInt("convertActionType", Integer.MIN_VALUE);
        if (iOptInt == 1) {
            if (i == 2) {
                com.byazt.hkv.c cVar4 = this.gu;
                if (cVar4 != null) {
                    cVar4.ve();
                }
            } else {
                com.byazt.hkv.tt ttVar3 = this.gr;
                if (ttVar3 != null) {
                    ttVar3.ve();
                }
            }
        } else if (iOptInt == 2) {
            if (i == 2) {
                com.byazt.hkv.c cVar5 = this.gu;
                if (cVar5 != null) {
                    cVar5.uj();
                }
            } else {
                com.byazt.hkv.tt ttVar4 = this.gr;
                if (ttVar4 != null) {
                    ttVar4.uj();
                }
            }
        }
        View view2 = view == null ? this : view;
        String str = grVar.sl;
        ic icVar = this.i;
        int i3 = icVar != null ? icVar.i() : 0;
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.yp;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                c(view2, grVar, daVar, 0, str, i3, i2);
                break;
            case 2:
                c(view2, grVar, daVar, str, i3, i2);
                break;
            case 3:
                i();
                break;
            case 4:
                FrameLayout frameLayout2 = this.yp;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                nb.gr(this.i);
                if (com.byazt.dyf.tt.AD_TAG_FEED.equals(this.sp) && zb() && !this.z && nb.gr(this.i)) {
                    c(view2, grVar, daVar, str, i3, i2);
                } else {
                    c(view2, grVar, daVar, 0, str, i3, i2);
                }
                break;
            case 5:
                c(!this.gt);
                break;
            case 6:
                a();
                break;
            case 7:
                if (!nb.c(strOptString, this.i, this.f28916a)) {
                    com.byazt.aas.n.c(this.f28916a, this.i);
                }
                break;
            case 8:
                sp();
                break;
            case 9:
                tt(this.i, this.f28916a, this.sp);
                break;
            case 10:
                c(this.i, this.f28916a, this.sp);
                break;
            case 12:
                ve(this.i, this.f28916a, this.sp);
                break;
            case 13:
                String strOptString2 = jSONObjectC.optString("openCommonWebUrl", "");
                String strOptString3 = jSONObjectC.optString("openCommonWebTitle", "");
                if (!TextUtils.isEmpty(strOptString2)) {
                    TTDelegateActivity.uj(this.f28916a, strOptString2, strOptString3);
                }
                break;
        }
    }

    private void tt(com.byazt.pop.ve veVar, int i) {
        if (veVar == null) {
            return;
        }
        if (veVar instanceof com.byazt.wz.c) {
            ((com.byazt.wz.c) veVar).x().tt(i);
        }
        veVar.uj(this.bx.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(ic icVar, com.byazt.ete.uj ujVar) {
        c(icVar, ujVar);
        tt(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(final boolean z) {
        d dVarJ_;
        this.bx.set(z);
        FrameLayout frameLayout = this.sv;
        if (frameLayout != null) {
            frameLayout.postDelayed(new Runnable() { // from class: com.byazt.ouz.NativeExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (NativeExpressView.this.sv != null) {
                        NativeExpressView.this.sv.setVisibility(z ? 0 : 8);
                    }
                }
            }, 10L);
        }
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (ujVar == null || !(ujVar instanceof yv) || (dVarJ_ = ((yv) ujVar).J_()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z);
            dVarJ_.tt("isShow7Factors", jSONObject);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    public NativeExpressView(Context context, ic icVar, com.byazt.dj.tt ttVar, String str, boolean z) {
        super(context);
        this.c = true;
        this.tt = 0;
        this.sp = com.byazt.dyf.tt.AD_TAG_FEED;
        this.zm = new AtomicBoolean(false);
        this.yv = null;
        this.m = false;
        this.rh = false;
        this.gt = false;
        this.d = false;
        this.pf = new AtomicBoolean(false);
        this.qy = false;
        this.bx = new AtomicBoolean(false);
        this.ic = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.ouz.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.a(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.hd);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.hd, 500L);
            }
        };
        this.hd = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.5
            @Override // java.lang.Runnable
            public void run() {
                if (!zb.tt(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.sp(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.sp(nativeExpressView.getVisibility());
                }
            }
        };
        this.bm = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sp(0);
            }
        };
        this.lr = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sp(8);
            }
        };
        this.j = new SparseArray<>();
        this.dz = -1.0f;
        this.ma = -1.0f;
        this.yf = -1.0f;
        this.f = -1.0f;
        this.ir = 0L;
        this.sp = str;
        this.f28916a = context;
        this.i = icVar;
        this.nb = new com.byazt.ddx.n(icVar, str);
        this.x = ttVar;
        this.gt = z;
        if (ttVar.gt() == 9) {
            this.m = ttVar.z() == 2;
        }
        sl();
    }

    public void tt(com.byazt.xl.uj<? extends View> ujVar, com.byazt.xl.yp ypVar) {
        int iVe;
        try {
            this.v = ujVar;
            this.kk = ypVar;
            if (ujVar.ve() != 1) {
                View viewSp = ujVar.sp();
                this.g = viewSp;
                if (viewSp.getParent() != null) {
                    ((ViewGroup) this.g.getParent()).removeView(this.g);
                }
                this.cu.addView(this.g);
                if (ypVar.tt() == 10) {
                    if (ypVar.n() == AudioStats.AUDIO_AMPLITUDE_NONE) {
                        int iC = (int) pu.c(this.i, ypVar.uj());
                        if (iC <= 0) {
                            iVe = pf.n(getContext());
                        } else {
                            iVe = pf.ve(getContext(), iC);
                        }
                        this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, iVe));
                    }
                    if (this.i.rm() == 1) {
                        Runnable runnable = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.3
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (NativeExpressView.this.g != null) {
                                        View childAt = ((ViewGroup) NativeExpressView.this.g).getChildAt(0);
                                        View childAt2 = ((ViewGroup) childAt).getChildAt(0);
                                        if (childAt2.getMeasuredHeight() < childAt.getMeasuredHeight()) {
                                            NativeExpressView.this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, childAt2.getHeight()));
                                            NativeExpressView.this.cu.requestLayout();
                                        }
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        };
                        this.aw = runnable;
                        this.g.post(runnable);
                    }
                }
                ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
                }
                n(this.i);
                if (this.s != null && (ujVar instanceof com.byazt.atv.n) && !(ujVar instanceof com.byazt.atv.sp)) {
                    this.s.c(((com.byazt.atv.n) ujVar).i());
                    this.s.c(this);
                }
            }
            com.byazt.xl.i iVar = this.tx;
            if (iVar instanceof da) {
                ((da) iVar).yp();
            }
            if (this.h != null && ujVar.ve() != 0) {
                this.h.c(ujVar.ve(), ypVar.sl(), ypVar.da());
            }
            com.byazt.xl.uj<? extends View> ujVar2 = this.v;
            if ((ujVar2 instanceof z) && ((z) ujVar2).J_() != null) {
                ((z) this.v).J_().c((sl) this);
            }
            if (ypVar.tt() == 10 && (ypVar instanceof com.byazt.atv.ve)) {
                this.zb = ((com.byazt.atv.ve) ypVar).rh();
            }
            c cVar = this.n;
            if (cVar != null) {
                cVar.c(this, (float) ypVar.uj(), (float) ypVar.n());
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public NativeExpressView(Context context, ic icVar, com.byazt.dj.tt ttVar, String str, boolean z, String str2) {
        super(context);
        this.c = true;
        this.tt = 0;
        this.sp = com.byazt.dyf.tt.AD_TAG_FEED;
        this.zm = new AtomicBoolean(false);
        this.yv = null;
        this.m = false;
        this.rh = false;
        this.gt = false;
        this.d = false;
        this.pf = new AtomicBoolean(false);
        this.qy = false;
        this.bx = new AtomicBoolean(false);
        this.ic = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.ouz.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView.this.a(57);
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.hd);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.hd, 500L);
            }
        };
        this.hd = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.5
            @Override // java.lang.Runnable
            public void run() {
                if (!zb.tt(NativeExpressView.this, 0, 5)) {
                    NativeExpressView.this.sp(8);
                } else {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.sp(nativeExpressView.getVisibility());
                }
            }
        };
        this.bm = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.6
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sp(0);
            }
        };
        this.lr = new Runnable() { // from class: com.byazt.ouz.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.sp(8);
            }
        };
        this.j = new SparseArray<>();
        this.dz = -1.0f;
        this.ma = -1.0f;
        this.yf = -1.0f;
        this.f = -1.0f;
        this.ir = 0L;
        this.sp = str;
        this.f28916a = context;
        this.i = icVar;
        this.nb = new com.byazt.ddx.n(icVar, str);
        this.da = str2;
        this.x = ttVar;
        this.gt = z;
        if (ttVar.gt() == 9) {
            this.m = ttVar.z() == 2;
        }
        sl();
    }

    private void tt(ic icVar, Context context, String str) {
        if (icVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.aas.n.tt(icVar, context, str);
    }

    public void tt(int i, String str) {
        d dVarJ_;
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (ujVar == null || !(ujVar instanceof yv) || (dVarJ_ = ((yv) ujVar).J_()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", i);
            jSONObject.put("flag", str);
            dVarJ_.tt("onVideoPaused", jSONObject);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.ouz.m
    public void tt(ic icVar) {
        if (icVar != null) {
            n(icVar);
        }
    }

    private void c(View view, com.byazt.ete.gr grVar, com.byazt.ete.da daVar, String str, int i, int i2) {
        if (ic.a(this.i)) {
            return;
        }
        com.byazt.hkv.c cVar = this.gu;
        if (cVar != null) {
            cVar.c(grVar);
            tt(((com.byazt.nat.c) this.gr.c(com.byazt.nat.c.class)).c(), i2);
            com.byazt.vis.c cVar2 = (com.byazt.vis.c) this.gu.c(com.byazt.vis.c.class);
            c(cVar2);
            cVar2.tt(str);
            this.gu.c(daVar);
            Map<String, Object> mapC = com.byazt.rv.c.c().c(this.i.hashCode() + this.i.qy());
            mapC.put("convert_tag", grVar.rh);
            mapC.put("dpa_convert", com.byazt.ete.qy.uj(this.i.u(), grVar.rh));
            c(grVar, mapC);
            this.gu.c(view, daVar);
        }
        c cVar3 = this.n;
        if (cVar3 != null) {
            cVar3.c(this, i);
        }
    }

    public void c(com.byazt.ete.gr grVar, Map<String, Object> map) {
        try {
            map.put("live_saas_interaction_type", Integer.valueOf(grVar.c().optInt("live_saas_param_interaction_type", -1)));
        } catch (Exception unused) {
        }
    }

    private void c(com.byazt.vis.c cVar) {
        v vVar = this.eo;
        if (vVar != null) {
            HashMap map = new HashMap();
            map.put("custom_express_gesture", 1);
            map.put("express_gesture_type", Integer.valueOf(vVar.tt()));
            map.put("express_slide_direction", Integer.valueOf(vVar.uj()));
            map.put("express_slide_threshold", Double.valueOf(vVar.ve()));
            cVar.c(map);
        }
    }

    private void c(View view, com.byazt.ete.gr grVar, com.byazt.ete.da daVar, int i, String str, int i2, int i3) {
        if (ic.a(this.i)) {
            return;
        }
        com.byazt.hkv.tt ttVar = this.gr;
        if (ttVar != null) {
            ttVar.c(grVar);
            tt(((com.byazt.nat.c) this.gr.c(com.byazt.nat.c.class)).c(), i3);
            com.byazt.vis.c cVar = (com.byazt.vis.c) this.gr.c(com.byazt.vis.c.class);
            c(cVar);
            cVar.tt(str);
            this.gr.c(daVar);
            Map<String, Object> mapC = com.byazt.rv.c.c().c(this.i.hashCode() + this.i.qy());
            mapC.put("convert_tag", grVar.rh);
            mapC.put("dpa_convert", com.byazt.ete.qy.uj(this.i.u(), grVar.rh));
            c(grVar, mapC);
            this.gr.c(view, daVar);
        }
        c cVar2 = this.n;
        if (cVar2 != null) {
            cVar2.c(this, i2);
        }
    }

    private void c(View view, int i, com.byazt.ete.gr grVar, com.byazt.ete.da daVar, int i2) {
        if (ic.a(this.i)) {
            return;
        }
        com.byazt.hkv.tt ttVar = this.gr;
        if (ttVar != null) {
            c(((com.byazt.nat.c) ttVar.c(com.byazt.nat.c.class)).c(), i);
            this.gr.c(grVar);
            this.gr.c(daVar);
            this.gr.c(view, daVar);
        }
        c cVar = this.n;
        if (cVar != null) {
            cVar.c(this, i2);
        }
    }

    private void c(com.byazt.pop.ve veVar, int i) {
        if (veVar == null) {
            return;
        }
        if (veVar instanceof com.byazt.wz.c) {
            com.byazt.yzg.ve veVarX = ((com.byazt.wz.c) veVar).x();
            veVarX.tt(true);
            veVarX.c(i);
        }
        veVar.uj(this.bx.get());
    }

    @Override // com.byazt.xl.z
    public void c(final com.byazt.xl.uj<? extends View> ujVar, final com.byazt.xl.yp ypVar) {
        this.iu = true;
        this.pf.set(true);
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.ouz.NativeExpressView.11
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.tt(ujVar, ypVar);
            }
        });
    }

    private void c(ic icVar, com.byazt.ete.uj ujVar) {
        FrameLayout frameLayout = this.sv;
        if (frameLayout != null && frameLayout.getParent() != null) {
            removeView(this.sv);
        }
        int iSl = nb.sl(icVar);
        FrameLayout frameLayoutC = com.byazt.wz.x.c(getContext(), icVar, ujVar, iSl);
        this.sv = frameLayoutC;
        frameLayoutC.setBackgroundColor(Color.parseColor("#161823"));
        float fVe = ve(icVar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, pf.ve(getContext(), fVe));
        float f = this.md;
        float f2 = (f - fVe) / f;
        layoutParams.gravity = iSl == 8 ? 48 : 80;
        int iVe = pf.ve(getContext(), this.md);
        this.sv.setVisibility(4);
        removeView(this.rl);
        removeView(this.cu);
        FrameLayout frameLayout2 = this.or;
        if (frameLayout2 != null) {
            frameLayout2.removeAllViews();
            removeView(this.or);
        } else {
            this.or = new FrameLayout(this.f28916a);
        }
        this.or.addView(this.rl);
        this.or.addView(this.cu);
        addView(this.or, 0);
        this.or.setBackgroundColor(0);
        this.or.setPivotX(0.0f);
        if (this.cu.getHeight() != 0) {
            iVe = this.cu.getHeight();
        }
        this.or.setPivotY(iSl == 8 ? iVe : 0.0f);
        this.or.setScaleY(f2);
        addView(this.sv, layoutParams);
    }

    public void c(MotionEvent motionEvent) {
        View view = this.g;
        if (view != null) {
            view.dispatchTouchEvent(motionEvent);
        }
    }

    @Override // com.byazt.kn.uj
    public void c(CharSequence charSequence, int i, int i2, boolean z) {
        c(Integer.parseInt(String.valueOf(charSequence)), i, z);
    }

    public void c(int i, int i2, boolean z) {
        int iUj;
        if (TextUtils.equals(this.sp, "fullscreen_interstitial_ad")) {
            iUj = (!h.c(this.i) || h.tt(this.i) <= 0) ? com.byazt.omf.gt.tt().n(Integer.parseInt(this.yv)) : 0;
        } else if (!TextUtils.equals(this.sp, "rewarded_video")) {
            return;
        } else {
            iUj = com.byazt.omf.gt.tt().uj(Integer.parseInt(this.yv));
        }
        int i3 = (i2 >= iUj || z) ? 1 : 0;
        int i4 = i2 <= iUj ? iUj - i2 : 0;
        com.byazt.xl.tt ttVar = this.kp;
        if (ttVar != null && ttVar.tt() != null) {
            this.kp.tt().c(String.valueOf(i), i3, i4, z);
        }
        com.byazt.xl.uj<? extends View> ujVar = this.v;
        if (ujVar != null) {
            if (ujVar.ve() == 7 || this.v.ve() == 10) {
                com.byazt.xl.uj<? extends View> ujVar2 = this.v;
                if (ujVar2 instanceof com.byazt.atv.n) {
                    ((com.byazt.kn.uj) ujVar2).c(String.valueOf(i), i3, i4, z);
                }
            }
        }
    }

    private void c(ic icVar, Context context, String str) {
        if (icVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.aas.n.ve(icVar, context, str);
    }

    private void c(com.byazt.qdk.ve veVar) {
        tt(com.byazt.qx.gu.c(this.i, veVar.c("reduce_duration", 0)));
    }

    public void c(boolean z) {
        if (this.v.ve() == 7) {
            com.byazt.xl.uj<? extends View> ujVar = this.v;
            if (ujVar instanceof com.byazt.atv.n) {
                ((com.byazt.kn.uj) ujVar).setSoundMute(z);
            }
        }
    }

    public void c(JSONObject jSONObject) {
        boolean zGu = com.byazt.omf.gt.tt().gu();
        this.r = zGu;
        if (zGu && nb.uj(this.i)) {
            this.s = new qy(this.i, jSONObject, this);
        }
    }

    public void c(int i, int i2) {
        com.byazt.qmz.c cVar = this.zb;
        if (cVar != null) {
            cVar.c(i, i2);
        }
    }
}
