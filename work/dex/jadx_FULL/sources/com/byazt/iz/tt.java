package com.byazt.iz;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.eu.n;
import com.byazt.ix.uj;
import com.byazt.nbs.da;
import com.byazt.nbs.i;
import com.byazt.ng.a;
import com.byazt.vx.p;
import com.byazt.vx.t;
import com.byazt.yf.sl;
import com.byazt.yl.ve;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 732, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ve f28682a;
    public SoftReference<Context> c;
    public long d;
    public com.byazt.ul.c m;
    public uj.ve md;
    public Handler qy;
    public com.byazt.ll.tt sl;
    public sl t;
    public com.byazt.nbs.tt u;
    public c yp;
    public String z;
    public CopyOnWriteArrayList<ve> tt = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<ve> ve = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<ve> uj = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<ve> n = new CopyOnWriteArrayList<>();
    public final AtomicBoolean nu = new AtomicBoolean(false);
    public final AtomicBoolean rh = new AtomicBoolean(false);
    public final AtomicBoolean my = new AtomicBoolean(false);
    public final AtomicBoolean gt = new AtomicBoolean(false);
    public volatile boolean rl = false;
    public Map<String, com.byazt.db.c> sp = new ConcurrentHashMap();
    public long x = 0;
    public long gu = 0;
    public AtomicBoolean gr = new AtomicBoolean(false);
    public boolean zm = false;
    public boolean yv = false;
    public boolean p = false;
    public final AtomicInteger h = new AtomicInteger(0);
    public Map<String, Object> i = new ConcurrentHashMap();
    public i da = new i();
    public int eo = 0;
    public String zb = null;
    public final AtomicBoolean or = new AtomicBoolean(false);
    public ConcurrentHashMap<String, com.byazt.pp.tt> cu = new ConcurrentHashMap<>();
    public final JSONObject qp = new JSONObject();
    public final AtomicInteger nb = new AtomicInteger(0);
    public final AtomicInteger pf = new AtomicInteger(0);
    public final AtomicInteger bx = new AtomicInteger(0);
    public final AtomicInteger sv = new AtomicInteger(0);
    public final AtomicInteger aw = new AtomicInteger(0);
    public final AtomicInteger ic = new AtomicInteger(0);
    public final AtomicInteger hd = new AtomicInteger(0);
    public final AtomicInteger bm = new AtomicInteger(0);
    public final AtomicInteger lr = new AtomicInteger(0);
    public final AtomicInteger l = new AtomicInteger(0);
    public final AtomicInteger lo = new AtomicInteger(0);
    public final AtomicInteger pu = new AtomicInteger(0);
    public final AtomicInteger lt = new AtomicInteger(0);

    private tt() {
    }

    private boolean aw() {
        return !this.u.zb() || this.yp.n(0) || this.yp.sp();
    }

    private boolean bm() {
        if (sl() != null) {
            Iterator<ve> it = sl().iterator();
            while (it.hasNext()) {
                if (it.next().isCacheSuccess()) {
                    return true;
                }
            }
        }
        if (yp() != null) {
            Iterator<ve> it2 = yp().iterator();
            while (it2.hasNext()) {
                if (it2.next().isCacheSuccess()) {
                    return true;
                }
            }
        }
        if (t() == null) {
            return false;
        }
        Iterator<ve> it3 = t().iterator();
        while (it3.hasNext()) {
            if (it3.next().isCacheSuccess()) {
                return true;
            }
        }
        return false;
    }

    private void hd() {
        if (yv() || n() || a()) {
            return;
        }
        if (uj() || this.gt.get()) {
            if (bm()) {
                i();
            } else {
                final long jC = com.byazt.bp.tt.tt().c(this.sl.my(), this.sl.gt());
                n.c(new Runnable() { // from class: com.byazt.iz.tt.8
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.eu.tt.ve(MediationConstant.TAG, com.byazt.eu.uj.c(tt.this.u) + "m-sdk----设置 cacheTimeout 已到时间【" + jC + "】，给外部invokeAdVideoCache ...");
                        tt.this.i();
                    }
                }, jC);
            }
        }
    }

    private int ic() {
        List<da> list;
        com.byazt.nbs.tt ttVar = this.u;
        int size = 0;
        if (ttVar == null) {
            return 0;
        }
        Map<Integer, List<da>> mapMd = ttVar.md();
        if (mapMd != null && mapMd.size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList();
            arrayList.addAll(mapMd.keySet());
            for (Integer num : arrayList) {
                if (this.yp.ve(num.intValue()) && (list = mapMd.get(num)) != null) {
                    size += list.size();
                }
            }
        }
        return size;
    }

    public String bx() {
        return this.z;
    }

    public long cu() {
        return this.x;
    }

    public void d() {
        this.h.incrementAndGet();
    }

    public boolean da() {
        return this.rl;
    }

    public long eo() {
        return this.d;
    }

    public Context getContext() {
        return this.c.get();
    }

    public Map<String, com.byazt.db.c> gr() {
        return this.sp;
    }

    public boolean gt() {
        int size = this.n.size() + this.tt.size() + this.uj.size();
        com.byazt.ll.tt ttVar = this.sl;
        return size >= (ttVar != null ? ttVar.gr() : 1);
    }

    public com.byazt.ll.tt gu() {
        return this.sl;
    }

    public int h() {
        return this.h.get();
    }

    public void i() {
        if (yv() || n() || a()) {
            return;
        }
        if (uj() || this.gt.get()) {
            com.byazt.ll.tt ttVar = this.sl;
            if (ttVar != null && (ttVar.my() == 7 || this.sl.my() == 8 || this.sl.my() == 10)) {
                com.byazt.eu.tt.ve(MediationConstant.TAG, com.byazt.eu.uj.c(this.u) + "广告缓存成功！给外部回调：invokeAdVideoCacheOnMainUI........");
                a.c(this.sl, z(), SystemClock.elapsedRealtime() - qp());
            }
            this.my.set(true);
            n.ve(new Runnable() { // from class: com.byazt.iz.tt.5
                @Override // java.lang.Runnable
                public void run() {
                    if (tt.this.m != null) {
                        tt.this.m.x();
                    }
                }
            });
        }
    }

    public com.byazt.nbs.tt m() {
        return this.u;
    }

    public List<com.byazt.pp.tt> md() {
        com.byazt.pp.tt value;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, com.byazt.pp.tt> entry : p().entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !TextUtils.equals("广告加载成功", value.a()) && !TextUtils.equals("广告请求中", value.a())) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public boolean my() {
        int size = this.n.size() + this.tt.size();
        com.byazt.ll.tt ttVar = this.sl;
        return size >= (ttVar != null ? ttVar.gr() : 1);
    }

    public boolean nb() {
        return this.gr.get();
    }

    public c nu() {
        return this.yp;
    }

    public sl or() {
        return this.t;
    }

    public ConcurrentHashMap<String, com.byazt.pp.tt> p() {
        return this.cu;
    }

    public i pf() {
        return this.da;
    }

    public long qp() {
        return this.gu;
    }

    public boolean qy() {
        return rl() && aw();
    }

    public boolean rh() {
        int size = this.n.size();
        com.byazt.ll.tt ttVar = this.sl;
        return size >= (ttVar != null ? ttVar.gr() : 1);
    }

    public boolean rl() {
        return !this.u.or() || this.yp.n(-100) || this.yp.a();
    }

    public CopyOnWriteArrayList<ve> sl() {
        return this.n;
    }

    public void sv() {
        n.c(new Runnable() { // from class: com.byazt.iz.tt.7
            @Override // java.lang.Runnable
            public void run() {
                tt.this.rl = true;
                CopyOnWriteArrayList<ve> copyOnWriteArrayList = tt.this.tt;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.clear();
                }
                CopyOnWriteArrayList<ve> copyOnWriteArrayList2 = tt.this.ve;
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.clear();
                }
                CopyOnWriteArrayList<ve> copyOnWriteArrayList3 = tt.this.uj;
                if (copyOnWriteArrayList3 != null) {
                    copyOnWriteArrayList3.clear();
                }
                CopyOnWriteArrayList<ve> copyOnWriteArrayList4 = tt.this.n;
                if (copyOnWriteArrayList4 != null) {
                    copyOnWriteArrayList4.clear();
                }
                if (tt.this.qy != null) {
                    tt.this.qy.removeCallbacksAndMessages(null);
                }
                tt.this.yp.t();
                tt.this.t = null;
                if (tt.this.rh.get() || tt.this.nu.get()) {
                    return;
                }
                tt.this.c(new com.byazt.bnd.c(41044, com.byazt.pp.c.c(41044)));
            }
        });
    }

    public CopyOnWriteArrayList<ve> t() {
        return this.tt;
    }

    public CopyOnWriteArrayList<ve> u() {
        return this.ve;
    }

    public CopyOnWriteArrayList<ve> yp() {
        return this.uj;
    }

    public boolean yv() {
        return this.zm;
    }

    public ve z() {
        return this.f28682a;
    }

    public Map<String, Object> zb() {
        return this.i;
    }

    public boolean zm() {
        return this.p;
    }

    public boolean a() {
        return this.my.get();
    }

    public boolean n() {
        return this.rh.get();
    }

    public boolean sp() {
        com.byazt.nbs.tt ttVar = this.u;
        return ttVar != null && ttVar.c() == 1;
    }

    public String tt(ve veVar) {
        if (veVar == null) {
            return "f_" + this.aw.incrementAndGet();
        }
        if (veVar.isNormalAd()) {
            return "f_" + this.aw.incrementAndGet();
        }
        if (veVar.isPAd()) {
            return "p_f_" + this.pf.incrementAndGet();
        }
        if (veVar.isServerBiddingAd()) {
            return "sb_f_" + this.lo.incrementAndGet();
        }
        if (veVar.isClientBiddingAd()) {
            return "cb_f_" + this.bm.incrementAndGet();
        }
        return "f_" + this.aw.incrementAndGet();
    }

    public boolean uj() {
        return this.nu.get();
    }

    public String ve(ve veVar) {
        if (veVar == null) {
            return "fa_" + this.ic.incrementAndGet();
        }
        if (veVar.isNormalAd()) {
            return "fa_" + this.ic.incrementAndGet();
        }
        if (veVar.isPAd()) {
            return "p_fa_" + this.bx.incrementAndGet();
        }
        if (veVar.isServerBiddingAd()) {
            return "sb_fa_" + this.pu.incrementAndGet();
        }
        if (veVar.isClientBiddingAd()) {
            return "cb_fa_" + this.lr.incrementAndGet();
        }
        return "fa_" + this.ic.incrementAndGet();
    }

    public void x() {
        Map<String, Object> map;
        com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.u) + " v2 load done..........s:" + uj() + "  f:" + n() + "     p.size" + sl().size() + "   bidding.size:" + yp().size() + "   normal.size:" + t().size() + "   underNormal.size:" + u().size());
        if (uj() || n()) {
            return;
        }
        this.nu.set(true);
        Handler handler = this.qy;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        List<ve> listC = c(false);
        ve(listC);
        if (!this.sl.tk() && !this.yv) {
            com.byazt.psp.uj.c(this.u, !p.tt(listC) ? listC.get(0).getCpm() : AudioStats.AUDIO_AMPLITUDE_NONE, this.sl.gt(), this.sl.my());
        }
        if (yv()) {
            a(true);
            return;
        }
        if (this.gt.get()) {
            return;
        }
        int iGr = listC.size() > this.sl.gr() ? this.sl.gr() : listC.size();
        com.byazt.nbs.tt ttVar = this.u;
        if (ttVar != null) {
            Map<String, Object> mapX = ttVar.x();
            mapX.put("has_serverBidding", Boolean.valueOf(this.u.zb()));
            map = mapX;
        } else {
            map = null;
        }
        if (!zm()) {
            com.byazt.ll.tt ttVar2 = this.sl;
            ve veVar = this.f28682a;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.x;
            int iIc = ic();
            int iTt = tt(this.yp.sl());
            com.byazt.nbs.tt ttVar3 = this.u;
            a.c(map, ttVar2, veVar, jElapsedRealtime, iIc, iTt, 0, ttVar3 != null ? ttVar3.lo() : null, iGr, this.eo, this.u, this.qp);
        }
        com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.u) + "广告加载成功！给外部回调：invokeAdLoadSuccessOnMainUI........P.size:" + sl().size() + "   bidding.size:" + yp().size() + "   normal.size:" + t().size());
        n.ve(new Runnable() { // from class: com.byazt.iz.tt.3
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.m != null) {
                    tt.this.m.sp();
                }
            }
        });
        hd();
    }

    private void a(final boolean z) {
        n.c(new Runnable() { // from class: com.byazt.iz.tt.9
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.md != null) {
                    tt.this.md.c(tt.this.sl.gt(), z, 0, null);
                }
            }
        });
    }

    public void n(boolean z) {
        this.gr.set(z);
    }

    public void uj(da daVar) {
        Map<String, Object> mapX;
        if (this.gt.get()) {
            return;
        }
        List<ve> listC = c(true);
        if (listC.size() < this.sl.gr()) {
            return;
        }
        this.gt.set(true);
        if (daVar != null) {
            this.zb = daVar.rh();
        }
        int iGr = listC.size() > this.sl.gr() ? this.sl.gr() : listC.size();
        com.byazt.nbs.tt ttVar = this.u;
        if (ttVar != null) {
            mapX = ttVar.x();
            mapX.put("has_serverBidding", Boolean.valueOf(this.u.zb()));
        } else {
            mapX = null;
        }
        com.byazt.ll.tt ttVar2 = this.sl;
        ve veVar = this.f28682a;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.x;
        int iIc = ic();
        int iTt = tt(this.yp.sl());
        com.byazt.nbs.tt ttVar3 = this.u;
        a.c(mapX, ttVar2, veVar, jElapsedRealtime, iIc, iTt, 0, ttVar3 != null ? ttVar3.lo() : null, iGr, this.eo, this.u, this.qp);
        com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.u) + "广告加载成功！给外部回调：invokeAdQuickLoadSuccessOnMainUI........P.size:" + sl().size() + "   bidding.size:" + yp().size() + "   normal.size:" + t().size());
        n.ve(new Runnable() { // from class: com.byazt.iz.tt.2
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.m != null) {
                    tt.this.m.sp();
                }
            }
        });
        hd();
    }

    public static tt c(SoftReference<Context> softReference, com.byazt.ll.tt ttVar, com.byazt.ul.c cVar) {
        tt ttVar2 = new tt();
        com.byazt.nbs.tt ttVarC = com.byazt.bp.tt.tt().c(ttVar.gt(), ttVar.my(), 100);
        ttVar.c(ttVarC);
        ttVar2.sl = ttVar;
        ttVar2.u = ttVarC;
        if (ttVarC != null) {
            ttVar2.i.put("render_control", Integer.valueOf(ttVarC.uj()));
        }
        ttVar2.sl.uj(com.byazt.bp.tt.tt().tk());
        ttVar2.sl.tt(com.byazt.bp.tt.tt().u());
        ttVar2.sl.c(com.byazt.oi.ve.a());
        ttVar2.sl.c(com.byazt.oi.ve.n());
        ttVar2.sl.ve(uj.c().tt(ttVar2.sl.gt(), com.byazt.bp.tt.tt().tk()));
        ttVar2.da.ve = com.byazt.bp.tt.tt().u();
        ttVar2.c = softReference;
        ttVar2.m = cVar;
        ttVar2.yp = new c();
        return ttVar2;
    }

    public String tt(da daVar) {
        if (daVar == null) {
            return "f_" + this.aw.incrementAndGet();
        }
        if (daVar.pf()) {
            return "f_" + this.aw.incrementAndGet();
        }
        if (daVar.cu()) {
            return "p_f_" + this.pf.incrementAndGet();
        }
        if (daVar.zb()) {
            return "sb_f_" + this.lo.incrementAndGet();
        }
        if (daVar.or()) {
            return "cb_f_" + this.bm.incrementAndGet();
        }
        return "f_" + this.aw.incrementAndGet();
    }

    public String ve(da daVar) {
        if (daVar == null) {
            return "fa_" + this.ic.incrementAndGet();
        }
        if (daVar.pf()) {
            return "fa_" + this.ic.incrementAndGet();
        }
        if (daVar.cu()) {
            return "p_fa_" + this.bx.incrementAndGet();
        }
        if (daVar.zb()) {
            return "sb_fa_" + this.pu.incrementAndGet();
        }
        if (daVar.or()) {
            return "cb_fa_" + this.lr.incrementAndGet();
        }
        return "fa_" + this.ic.incrementAndGet();
    }

    public String c(ve veVar) {
        if (veVar == null) {
            return "r_" + this.sv.incrementAndGet();
        }
        if (veVar.isNormalAd()) {
            return "r_" + this.sv.incrementAndGet();
        }
        if (veVar.isPAd()) {
            return "p_r_" + this.nb.incrementAndGet();
        }
        if (veVar.isServerBiddingAd()) {
            return "sb_r_" + this.l.incrementAndGet();
        }
        if (veVar.isClientBiddingAd()) {
            return "cb_r_" + this.hd.incrementAndGet();
        }
        return "r_" + this.sv.incrementAndGet();
    }

    public void uj(ve veVar) {
        this.f28682a = veVar;
    }

    public String tt() {
        return this.zb;
    }

    public void uj(boolean z) {
        this.yv = z;
    }

    public JSONObject ve() {
        return this.qp;
    }

    private void ve(List<ve> list) {
        ArrayList arrayList;
        if (this.or.get()) {
            return;
        }
        this.or.set(true);
        if ((!yv() && (yv() || this.yv)) || this.u == null || this.sl.tk()) {
            return;
        }
        if (this.u.zb() || this.u.or()) {
            ArrayList arrayList2 = null;
            ve veVar = list.size() > 0 ? list.get(0) : null;
            int iGr = this.sl.gr();
            if (iGr > 1) {
                ArrayList arrayList3 = new ArrayList();
                for (int i = 1; i < iGr; i++) {
                    if (i < list.size()) {
                        arrayList3.add(list.get(i));
                    }
                }
                if (list.size() > iGr) {
                    arrayList2 = new ArrayList();
                    while (iGr < list.size()) {
                        ve veVar2 = list.get(iGr);
                        if (veVar2 != null && veVar2.isServerBiddingAd()) {
                            arrayList2.add(veVar2);
                        }
                        iGr++;
                    }
                }
                arrayList = arrayList2;
                arrayList2 = arrayList3;
            } else {
                arrayList = null;
            }
            a.c(veVar, this.sl, arrayList2, arrayList);
        }
    }

    public void tt(List<ve> list) {
        ve veVar;
        if (p.c(list) || (veVar = list.get(0)) == null) {
            return;
        }
        if (veVar.isPAd()) {
            this.n.addAll(list);
            return;
        }
        if (veVar.isNormalAd()) {
            this.tt.addAll(list);
        } else if (veVar.isServerBiddingAd() || veVar.isClientBiddingAd() || veVar.isMultiBiddingAd()) {
            this.uj.addAll(list);
        }
    }

    public String c(da daVar) {
        if (daVar == null) {
            return "r_" + this.sv.incrementAndGet();
        }
        if (daVar.pf()) {
            return "r_" + this.sv.incrementAndGet();
        }
        if (daVar.cu()) {
            return "p_r_" + this.nb.incrementAndGet();
        }
        if (daVar.zb()) {
            return "sb_r_" + this.l.incrementAndGet();
        }
        if (daVar.or()) {
            return "cb_r_" + this.hd.incrementAndGet();
        }
        return "r_" + this.sv.incrementAndGet();
    }

    public void tt(boolean z) {
        this.p = z;
    }

    public void tt(long j) {
        this.x = j;
    }

    public void tt(String str) {
        this.z = str;
    }

    public int tt(int i) {
        if (this.yp.c() == null) {
            return -1;
        }
        return this.yp.c().indexOf(Integer.valueOf(i)) + 1;
    }

    public AtomicInteger c() {
        return this.lt;
    }

    public void c(int i) {
        this.eo = i;
    }

    public void c(final String str) {
        n.uj(new Runnable() { // from class: com.byazt.iz.tt.1
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.m != null) {
                    tt.this.m.c(str);
                }
            }
        });
    }

    public void ve(boolean z) {
        this.zm = z;
    }

    public void c(List<ve> list) {
        if (sp() && this.gt.get()) {
            ve(list);
        }
    }

    public void ve(long j) {
        this.gu = j;
    }

    public void c(com.byazt.pp.c cVar) {
        Handler handler;
        if (cVar == null) {
            cVar = new com.byazt.pp.c(20005, com.byazt.pp.c.c(20005));
        }
        if ((!com.byazt.fid.c.c(this.u) || cVar.c != 10003) && (handler = this.qy) != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (uj() || n() || this.gt.get()) {
            return;
        }
        this.rh.set(true);
        pf().n = true;
        if (!zm()) {
            a.c(this.sl, cVar, this.da.c);
        }
        if (yv()) {
            a(false);
            return;
        }
        com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.u) + "广告加载失败！给外部回调：invokeAdLoadFailCallbackOnMainUI...... error Code = " + cVar.c + " error Message = " + cVar.tt);
        final com.byazt.pp.c cVarC = t.c(this.sl, cVar, md());
        n.ve(new Runnable() { // from class: com.byazt.iz.tt.4
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.m != null) {
                    tt.this.m.tt(cVarC);
                }
            }
        });
    }

    public void c(final List<ve> list, final com.byazt.pp.c cVar) {
        com.byazt.nbs.tt ttVar = this.u;
        if (ttVar == null || !ttVar.z()) {
            return;
        }
        if (da()) {
            cVar = new com.byazt.pp.c(41044, com.byazt.pp.c.c(41044));
            list = null;
        }
        if (yv()) {
            return;
        }
        if (!p.c(list)) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.u) + "单个广告加载完成！给外部回调：invokeSingleAdLoadCallbackUI......");
            for (ve veVar : list) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.sl.gt(), "fill") + "AdNetWorkName[" + veVar.getAdNetWorkName() + "] AdUnitId[" + veVar.getAdNetworkSlotId() + "]  请求成功 (loadSort=" + veVar.getLoadSort() + ",showSort=" + veVar.getShowSort() + ")");
            }
        }
        if (cVar != null) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(this.u) + "单个广告加载失败！给外部回调：invokeSingleAdLoadCallbackUI...... errorCode:" + cVar.c + "  errorMsg:" + cVar.tt);
        }
        n.ve(new Runnable() { // from class: com.byazt.iz.tt.6
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.m != null) {
                    tt.this.m.c(list, cVar);
                }
            }
        });
    }

    public void c(com.byazt.nbs.tt ttVar) {
        this.u = ttVar;
    }

    public List<ve> c(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (!p.c(this.tt)) {
            arrayList.addAll(this.tt);
        }
        if (!p.c(this.uj)) {
            arrayList.addAll(this.uj);
        }
        com.byazt.oi.ve.c(arrayList, z ? com.byazt.oi.ve.tt() : com.byazt.oi.ve.c());
        if (!p.c(this.n)) {
            com.byazt.oi.ve.c(this.n, (Comparator<ve>) null);
            arrayList.addAll(0, this.n);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ve veVar = (ve) arrayList.get(i);
            veVar.getCpm();
            veVar.getStrategyCpm();
        }
        return arrayList;
    }

    public void c(ConcurrentHashMap<String, com.byazt.pp.tt> concurrentHashMap) {
        this.cu = concurrentHashMap;
    }

    public void c(uj.ve veVar) {
        this.md = veVar;
    }

    public void c(long j) {
        this.d = j;
    }

    public void c(sl slVar) {
        this.t = slVar;
    }

    public void c(Handler handler) {
        this.qy = handler;
    }

    public void c(i iVar) {
        this.da = iVar;
    }
}
