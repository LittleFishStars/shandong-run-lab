package com.byazt.tp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aas.cu;
import com.byazt.aas.h;
import com.byazt.bzd.x;
import com.byazt.dna.qp;
import com.byazt.ete.bm;
import com.byazt.ete.ic;
import com.byazt.nc.sp;
import com.byazt.nc.uj;
import com.byazt.nc.yp;
import com.byazt.nr.d;
import com.byazt.nr.m;
import com.byazt.omf.EmptyView;
import com.byazt.omf.gt;
import com.byazt.omf.gu;
import com.byazt.ouz.NativeExpressView;
import com.byazt.ouz.a;
import com.byazt.ouz.n;
import com.byazt.ouz.yv;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 436, 13})
public class tt extends com.byazt.ouz.tt implements qp.c {
    public static final String TAG = "TTBannerExpressAd";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.pop.c f29068a;
    public c c;
    public com.byazt.pop.ve da;
    public a gr;
    public volatile View gu;
    public com.byazt.ouz.c n;
    public boolean p;
    public com.byazt.dyf.tt sl;
    public WeakReference<BannerExpressBackupView> sp;
    public d t;
    public final Context tt;
    public int u;
    public com.byazt.dj.tt uj;
    public ic ve;
    public com.byazt.dhf.c yp;
    public NativeExpressView yv;
    public n zm;
    public String z = com.byazt.dyf.tt.AD_TAG_BANNER;
    public final Queue<Long> m = new LinkedList();
    public Double nu = null;
    public boolean rh = false;
    public boolean my = false;
    public AtomicBoolean gt = new AtomicBoolean(false);
    public AtomicBoolean rl = new AtomicBoolean(false);
    public AtomicBoolean qy = new AtomicBoolean(false);

    public tt(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        this.p = false;
        this.tt = context;
        this.ve = icVar;
        this.uj = ttVar;
        boolean z = true;
        com.byazt.rgb.tt.c(icVar, ttVar, 1, getLifecycleId());
        boolean zJl = gt.tt().jl();
        if (!gt.tt().xx() && !zJl) {
            z = false;
        }
        this.p = z;
        c(context, icVar, ttVar);
        c(this.c.getCurView(), this.ve, false);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void destroy() {
        super.destroy();
        x.c(new Runnable() { // from class: com.byazt.tp.tt.1
            @Override // java.lang.Runnable
            public void run() {
                c cVar = tt.this.c;
                if (cVar != null) {
                    cVar.uj();
                }
            }
        });
        d dVar = this.t;
        if (dVar != null) {
            dVar.removeCallbacksAndMessages(null);
            this.t = null;
        }
        ic icVar = this.ve;
        cu.tt(icVar != null ? icVar.eo() : 0);
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.rgb.tt.ve(getLifecycleId(), 3);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public sp getDislikeDialog(Activity activity) {
        if (this.sl == null) {
            c(activity, (com.byazt.dhf.c) null);
        }
        return this.sl;
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public uj getDislikeInfo() {
        ic icVar = this.ve;
        if (icVar == null || icVar.wq() == null) {
            return null;
        }
        this.ve.wq().tt(this.z);
        return new com.byazt.vo.c(this.ve.wq());
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public View getExpressAdView() {
        com.byazt.dz.uj.c().c(this.ve).c(1);
        com.byazt.iyp.tt.c(this.ve.c());
        return this.c;
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public int getImageMode() {
        ic icVar = this.ve;
        if (icVar == null) {
            return -1;
        }
        return icVar.id();
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public int getInteractionType() {
        ic icVar = this.ve;
        if (icVar == null) {
            return -1;
        }
        return icVar.i();
    }

    @Override // com.byazt.nc.yp
    public String getLifecycleId() {
        ic icVar = this.ve;
        if (icVar != null) {
            return icVar.zm();
        }
        return null;
    }

    @Override // com.byazt.ouz.tt
    public ic getMaterialMeta() {
        return this.ve;
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public Map<String, Object> getMediaExtraInfo() {
        ic icVar = this.ve;
        if (icVar != null) {
            return icVar.yt();
        }
        return null;
    }

    @Override // com.byazt.nc.yp
    public com.byazt.sbm.n getMediationManager() {
        return new com.byazt.ah.ve();
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message.what == 112201 && this.gu != null && this.gu.isShown()) {
            uj();
        }
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.x
    public void loss(Double d, String str, String str2) {
        if (this.my) {
            return;
        }
        h.c(this.ve, d, str, str2);
        this.my = true;
    }

    @Override // com.byazt.nc.yp
    public void registerClickableRects(JSONObject jSONObject) {
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void render() {
        com.byazt.dyf.tt ttVar = this.sl;
        if (ttVar != null) {
            ttVar.setMonitorView(this.c);
        }
        this.c.n();
        com.byazt.dz.uj.c().c(this.ve).c(1);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setDislikeCallback(Activity activity, final com.byazt.dhf.c cVar) {
        if (cVar == null || activity == null) {
            return;
        }
        com.byazt.dhf.c cVar2 = new com.byazt.dhf.c(null) { // from class: com.byazt.tp.tt.2
            @Override // com.byazt.dhf.c
            public void c(int i, String str, boolean z) {
                com.byazt.rgb.tt.ve(tt.this.getLifecycleId(), 1);
                cVar.c(i, str, z);
            }

            @Override // com.byazt.dhf.c
            public void tt() {
                cVar.tt();
            }

            @Override // com.byazt.dhf.c
            public void c() {
                cVar.c();
            }
        };
        this.yp = cVar2;
        c(activity, cVar2);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setDownloadListener(com.byazt.ocd.ve veVar) {
        com.byazt.pop.c cVarC = com.byazt.pop.c.C0504c.c(veVar);
        this.f29068a = cVarC;
        com.byazt.ouz.tt.c cVar = this.x;
        if (cVar != null) {
            cVar.c(cVarC);
        }
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setExpressInteractionListener(com.byazt.ft.tt ttVar) {
        com.byazt.ouz.c cVarC = com.byazt.ouz.c.c(this, ttVar);
        this.n = cVarC;
        this.c.setExpressInteractionListener(cVarC);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.x
    public void setPrice(Double d) {
        this.nu = d;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x001e A[PHI: r0
      0x001e: PHI (r0v7 int) = (r0v4 int), (r0v5 int) binds: [B:5:0x001c, B:8:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setSlideIntervalTime(int i) {
        if (i <= 0) {
            return;
        }
        this.z = com.byazt.dyf.tt.AD_TAG_EXPRESS_BANNER;
        c(this.c.getCurView(), this.ve, false);
        this.c.setDuration(1000);
        int i2 = 30000;
        if (i < 30000) {
            i = i2;
        } else {
            i2 = 120000;
            if (i > 120000) {
                i = i2;
            }
        }
        this.u = i;
        this.t = new d(Looper.getMainLooper(), this);
    }

    @Override // com.byazt.nc.yp
    public void unRegisterRects() {
    }

    @Override // com.byazt.nc.yp
    public void uploadDislikeEvent(String str) {
        com.byazt.ddx.uj.tt(this.ve, str);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.x
    public void win(Double d) {
        if (this.rh) {
            return;
        }
        h.c(this.ve, d);
        this.rh = true;
    }

    private void uj() {
        bm bmVar = new bm();
        bmVar.sp = 2;
        gt.c().c(this.uj, bmVar, 1, new com.byazt.gk.c(new gu.tt() { // from class: com.byazt.tp.tt.8
            @Override // com.byazt.omf.gu.tt
            public void c(int i, String str, com.byazt.ete.tt ttVar) {
                tt.this.tt();
            }

            @Override // com.byazt.omf.gu.tt
            public void c(com.byazt.ete.c cVar, com.byazt.ete.tt ttVar) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(cVar.tt());
                if (copyOnWriteArrayList.isEmpty()) {
                    tt.this.tt();
                    return;
                }
                ic icVar = (ic) copyOnWriteArrayList.get(0);
                tt ttVar2 = tt.this;
                ttVar2.c.c(icVar, ttVar2.uj);
                tt.this.c(icVar);
                tt.this.c.ve();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        d dVar = this.t;
        if (dVar != null) {
            dVar.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        d dVar;
        if (this.gu == null || !this.gu.isShown() || (dVar = this.t) == null) {
            return;
        }
        dVar.removeCallbacksAndMessages(null);
        this.t.sendEmptyMessageDelayed(112201, this.u);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setExpressInteractionListener(com.byazt.ft.c cVar) {
        com.byazt.ouz.c cVarC = com.byazt.ouz.c.c((yp) this, cVar);
        this.n = cVarC;
        this.c.setExpressInteractionListener(cVarC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(ic icVar) {
        Queue<Long> queue = this.m;
        if (queue == null || queue.size() <= 0 || icVar == null) {
            return;
        }
        try {
            long jLongValue = this.m.poll().longValue();
            if (jLongValue > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(SystemClock.elapsedRealtime() - jLongValue);
                String string = sb.toString();
                com.byazt.ddx.n nVar = new com.byazt.ddx.n(this.ve, this.z);
                nVar.c(1.0f);
                com.byazt.ddx.uj.c(string, icVar, this.z, 15, nVar.tt());
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void c(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        if (context == null) {
            return;
        }
        this.c = new c(context, icVar, ttVar);
    }

    @Override // com.byazt.ouz.tt
    public void c(Dialog dialog) {
        if (dialog == null) {
            m.ve("dialog is null, please check");
            return;
        }
        c cVar = this.c;
        if (cVar == null || cVar.getCurView() == null) {
            return;
        }
        this.c.getCurView().setOuterDislike(dialog);
    }

    private void c(Activity activity, com.byazt.dhf.c cVar) {
        if (this.sl == null) {
            com.byazt.dyf.tt ttVar = new com.byazt.dyf.tt(activity, this.ve.wq(), this.z, false, com.byazt.xky.tt.c());
            this.sl = ttVar;
            com.byazt.tl.ve.c(activity, this.ve, ttVar);
        }
        com.byazt.dyf.tt ttVar2 = this.sl;
        if (ttVar2 != null) {
            ttVar2.setMonitorView(this.c);
        }
        this.sl.setDislikeInteractionCallback(cVar);
        c cVar2 = this.c;
        if (cVar2 == null || cVar2.getCurView() == null) {
            return;
        }
        this.c.getCurView().setDislike(this.sl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.ve.i() == 4) {
            x.c(new com.byazt.bwm.sp("banner_express_register_download") { // from class: com.byazt.tp.tt.3
                @Override // java.lang.Runnable
                public void run() {
                    if (tt.this.ve.i() == 4) {
                        tt ttVar = tt.this;
                        ttVar.da = com.byazt.yih.x.c(ttVar.tt, ttVar.ve, ttVar.z);
                        tt.this.da.tt();
                        tt ttVar2 = tt.this;
                        if (ttVar2.tt instanceof Activity) {
                            ttVar2.da.c((Activity) tt.this.tt, false);
                        }
                        if (tt.this.gr != null) {
                            ((com.byazt.nat.c) tt.this.gr.c(com.byazt.nat.c.class)).c(tt.this.da);
                        }
                        if (tt.this.zm != null) {
                            ((com.byazt.nat.c) tt.this.zm.c(com.byazt.nat.c.class)).c(tt.this.da);
                        }
                        tt ttVar3 = tt.this;
                        ttVar3.c(ttVar3.da, tt.this.yv);
                        tt.this.da.c();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ic icVar) {
        if (this.c.getNextView() == null || !this.c.tt()) {
            return;
        }
        c(this.c.getNextView(), icVar.wq());
        this.qy.set(false);
        c(this.c.getNextView(), icVar, true);
    }

    private void c(NativeExpressView nativeExpressView, com.byazt.vo.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        if (this.yp != null) {
            this.sl.resetData(ttVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.sl);
            }
        }
        if (this.i != null) {
            c(ttVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.i);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void c(final NativeExpressView nativeExpressView, final ic icVar, boolean z) {
        if (nativeExpressView == null || icVar == null) {
            return;
        }
        this.yv = nativeExpressView;
        ic icVar2 = this.ve;
        if (icVar2 != null) {
            cu.tt(icVar2.eo());
        }
        this.ve = icVar;
        nativeExpressView.setBackupListener(new com.byazt.xl.ve() { // from class: com.byazt.tp.tt.4
            @Override // com.byazt.xl.ve
            public boolean c(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).my();
                    BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(viewGroup.getContext());
                    tt ttVar = tt.this;
                    bannerExpressBackupView.c(ttVar.ve, (NativeExpressView) viewGroup, ttVar.da);
                    bannerExpressBackupView.setDislikeInner(tt.this.sl);
                    bannerExpressBackupView.setDislikeOuter(tt.this.i);
                    tt ttVar2 = tt.this;
                    if (ttVar2.ve != null) {
                        ttVar2.c(icVar.wq());
                    }
                    tt.this.sp = new WeakReference<>(bannerExpressBackupView);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.byazt.ddx.uj.c(icVar);
        EmptyView emptyViewC = c(nativeExpressView);
        if (emptyViewC == null) {
            EmptyView emptyView = new EmptyView(this.tt, nativeExpressView, icVar.m172if());
            emptyView.setAdType(1);
            emptyView.c(this.ve, this.z);
            nativeExpressView.addView(emptyView);
            emptyViewC = emptyView;
        }
        this.gu = emptyViewC;
        emptyViewC.setCallback(new EmptyView.c() { // from class: com.byazt.tp.tt.5
            @Override // com.byazt.omf.EmptyView.c
            public void c(boolean z2) {
                String unused = tt.this.z;
                if (tt.this.da != null) {
                    if (z2) {
                        tt.this.da.tt();
                    } else {
                        com.byazt.pop.ve unused2 = tt.this.da;
                    }
                }
                if (z2) {
                    tt.this.tt();
                } else {
                    tt.this.ve();
                }
                tt.this.c(z2, icVar);
            }

            @Override // com.byazt.omf.EmptyView.c
            public void tt() {
                if (tt.this.da != null) {
                    tt.this.da.ve();
                }
                tt.this.tt(icVar);
                tt.this.gt.set(false);
                tt.this.rl.set(false);
            }

            @Override // com.byazt.omf.EmptyView.c
            public void c() {
                tt.this.c();
            }

            @Override // com.byazt.omf.EmptyView.c
            public void c(View view, Map<String, Object> map) {
                if (tt.this.m != null) {
                    tt.this.m.offer(Long.valueOf(SystemClock.elapsedRealtime()));
                }
                Map mapC = tt.this.c(nativeExpressView, icVar);
                if (map != null && map.containsKey("show_send_type")) {
                    mapC.put("show_send_type", map.get("show_send_type"));
                }
                mapC.put("is_repeat", Boolean.valueOf(tt.this.qy.get()));
                tt.this.gt.set(true);
                if (!tt.this.rl.get()) {
                    tt.this.rl.set(true);
                    com.byazt.ddx.uj.c(icVar, tt.this.z, (Map<String, Object>) mapC, tt.this.nu);
                    com.byazt.pf.c.c().uj();
                    ic icVar3 = icVar;
                    cu.c(icVar3 != null ? icVar3.eo() : 0);
                }
                boolean zOq = gt.tt().oq();
                boolean andSet = tt.this.qy.getAndSet(true);
                com.byazt.ouz.c cVar = tt.this.n;
                if (cVar != null && (!andSet || zOq)) {
                    cVar.tt(view, icVar.i());
                    if (icVar.yv() && icVar.yp() != null) {
                        com.byazt.yxu.c.c().c(tt.this.tt, icVar.yp().tt());
                    }
                }
                if (!andSet) {
                    if (view == null) {
                        view = nativeExpressView;
                    }
                    com.byazt.iyp.tt.c(icVar, tt.this.z, view, icVar.up());
                }
                tt.this.tt();
                c cVar2 = tt.this.c;
                if (cVar2 == null || cVar2.getCurView() == null) {
                    return;
                }
                tt.this.c.getCurView().nu();
                tt.this.c.getCurView().z();
            }
        });
        a aVar = new a(this.tt, icVar, this.z, 2);
        this.gr = aVar;
        final com.byazt.vis.ve veVar = (com.byazt.vis.ve) aVar.c(com.byazt.vis.ve.class);
        final EmptyView emptyView2 = emptyViewC;
        veVar.c(new com.byazt.vis.ve.c() { // from class: com.byazt.tp.tt.6
            @Override // com.byazt.vis.ve.c
            public boolean c() {
                veVar.c(emptyView2);
                veVar.c(tt.this.c(nativeExpressView, icVar));
                veVar.c(tt.this.z);
                veVar.c(tt.this.nu);
                return tt.this.gt.get();
            }
        });
        this.gr.c(nativeExpressView);
        ((com.byazt.nat.c) this.gr.c(com.byazt.nat.c.class)).c(this);
        nativeExpressView.setClickListener(this.gr);
        n nVar = new n(this.tt, icVar, this.z, 2);
        this.zm = nVar;
        final com.byazt.vis.ve veVar2 = (com.byazt.vis.ve) nVar.c(com.byazt.vis.ve.class);
        veVar2.c(new com.byazt.vis.ve.c() { // from class: com.byazt.tp.tt.7
            @Override // com.byazt.vis.ve.c
            public boolean c() {
                veVar2.c(emptyView2);
                veVar2.c(tt.this.c(nativeExpressView, icVar));
                veVar2.c(tt.this.z);
                veVar2.c(tt.this.nu);
                return tt.this.gt.get();
            }
        });
        this.zm.c(nativeExpressView);
        ((com.byazt.nat.c) this.zm.c(com.byazt.nat.c.class)).c(this);
        nativeExpressView.setClickCreativeListener(this.zm);
        if (!this.p) {
            emptyViewC.setNeedCheckingShow(true);
        }
        if (z) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> c(NativeExpressView nativeExpressView, ic icVar) {
        HashMap map = new HashMap();
        yv.c(map, this.ve, nativeExpressView);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.pop.ve veVar, NativeExpressView nativeExpressView) {
        if (veVar == null || nativeExpressView == null) {
            return;
        }
        ic icVar = this.ve;
        com.byazt.ouz.tt.c cVar = new com.byazt.ouz.tt.c(this.f29068a, icVar != null ? icVar.uj() : "");
        this.x = cVar;
        veVar.c(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, ic icVar) {
        Queue<Long> queue = this.m;
        if (queue == null) {
            return;
        }
        try {
            if (z) {
                queue.offer(Long.valueOf(SystemClock.elapsedRealtime()));
                return;
            }
            if (queue.size() > 0) {
                long jLongValue = this.m.poll().longValue();
                StringBuilder sb = new StringBuilder();
                sb.append(SystemClock.elapsedRealtime() - jLongValue);
                String string = sb.toString();
                com.byazt.ddx.n nVar = new com.byazt.ddx.n(this.ve, this.z);
                nVar.c(1.0f);
                com.byazt.ddx.uj.c(string, icVar, this.z, 13, nVar.tt());
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    private EmptyView c(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            try {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
