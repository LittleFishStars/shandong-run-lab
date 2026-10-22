package com.byazt.cf;

import android.os.Bundle;
import android.text.TextUtils;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.byazt.aas.nb;
import com.byazt.aas.rl;
import com.byazt.bv.BaseConstants;
import com.byazt.bzd.t;
import com.byazt.ete.bm;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.ete.kp;
import com.byazt.ete.l;
import com.byazt.ete.lt;
import com.byazt.ete.my;
import com.byazt.ete.pu;
import com.byazt.ete.x;
import com.byazt.ete.xd;
import com.byazt.ete.zb;
import com.byazt.fk.u;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.gu;
import com.byazt.ukr.yp;
import com.byazt.xs.da;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 18, 46})
public abstract class n<T> extends com.byazt.vvt.tt<T> {
    public n(com.byazt.iu.tt ttVar) {
        super(ttVar);
    }

    @Override // com.byazt.vvt.tt, com.byazt.dx.c
    public void c(int i, com.byazt.dj.tt ttVar, ic icVar) {
    }

    public abstract void c(T t);

    public abstract boolean c();

    public abstract boolean c(com.byazt.ete.c cVar);

    public abstract void tt(com.byazt.dj.tt ttVar, List<ic> list, T t);

    private void tt(com.byazt.dj.tt ttVar, final ic icVar, final com.byazt.iu.ve veVar) {
        if (xd.z(icVar) == null) {
            return;
        }
        com.byazt.jzl.a aVarC = xd.c(1, icVar);
        aVarC.putExtra("material_meta", icVar);
        aVarC.putExtra("ad_slot", ttVar);
        com.byazt.btt.ve.c(aVarC, new com.byazt.ols.c() { // from class: com.byazt.cf.n.3
            @Override // com.byazt.fk.da.c
            public void onVideoPreloadFail(u uVar, int i, String str) {
                m.c("RewardSceneCacheStrategy", "RewardFullLog: Cached ad onVideoPreloadFail");
                if (!xd.u(icVar)) {
                    m.c("RewardSceneCacheStrategy", "RewardFullLog: Cached ad onVideoPreloadFail and block onCached");
                    return;
                }
                com.byazt.iu.ve veVar2 = veVar;
                if (veVar2 != null) {
                    veVar2.tt();
                }
            }

            @Override // com.byazt.fk.da.c
            public void onVideoPreloadSuccess(u uVar, int i) {
                m.c("RewardSceneCacheStrategy", "RewardFullLog: Cached ad onVideoPreloadSuccess");
                com.byazt.iu.ve veVar2 = veVar;
                if (veVar2 != null) {
                    veVar2.tt();
                }
            }
        });
    }

    @Override // com.byazt.vvt.tt, com.byazt.dx.c
    public boolean c(final com.byazt.dj.tt ttVar, List<ic> list) {
        ic icVar = list.get(0);
        if (!com.byazt.vvt.n.c(ttVar, icVar, c())) {
            return false;
        }
        new com.byazt.ddx.c.C0382c().n(icVar.uj()).c(c() ? "rewarded_video" : "fullscreen_interstitial_ad").uj(icVar.w_()).tt("get_preload_ad").c(new com.byazt.ya.c() { // from class: com.byazt.cf.n.1
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                if (ttVar.gu() != null) {
                    int iC = com.byazt.sq.a.c(ttVar.gu());
                    if (iC == 1) {
                        jSONObject2.put("req_type", 1);
                    } else if (iC != 3) {
                        jSONObject2.put("req_type", -1);
                    } else {
                        jSONObject2.put("req_type", 3);
                    }
                }
                jSONObject2.put("preload_ad_type", 2);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
        return true;
    }

    @Override // com.byazt.vvt.tt, com.byazt.dx.c
    public void c(int i, final List<ic> list, final com.byazt.dj.tt ttVar, final com.byazt.iu.n<T> nVar, Bundle bundle, final com.byazt.iu.sp spVar) {
        final boolean z = bundle.getBoolean("is_cache", false);
        final boolean z2 = bundle.getBoolean("is_playAgain", false);
        final long j = bundle.getLong(CropKey.RESULT_KEY_START_TIME);
        final boolean z3 = bundle.getBoolean("is_second_page_ad", false);
        final ic icVar = list.get(0);
        c(ttVar, list, (com.byazt.vvt.tt.c) new com.byazt.vvt.tt.c<T>() { // from class: com.byazt.cf.n.2
            @Override // com.byazt.vvt.tt.c
            public void c(final T t) {
                for (ic icVar2 : list) {
                    icVar2.bn().tt();
                    icVar2.da(z);
                }
                n.this.tt(ttVar, list, t);
                com.byazt.iu.ve veVar = new com.byazt.iu.ve() { // from class: com.byazt.cf.n.2.1
                    public final AtomicBoolean ve = new AtomicBoolean(false);

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // com.byazt.iu.ve
                    public void c() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (!z2 && !z3) {
                            n.this.c(ttVar, (List<ic>) list, t);
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("is_play_again", z2);
                            jSONObject.put("is_second_page_ad", z3);
                            jSONObject.put("is_cache", z);
                            AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                            jSONObject.put("cache_type", icVar.sl(z));
                            jSONObject.put("is_adm", !TextUtils.isEmpty(ttVar.rl()));
                            jSONObject.put("src_req_id", icVar.xv());
                            jSONObject.put("is_map", icVar.rp());
                            jSONObject.put("load_duration", System.currentTimeMillis() - j);
                            jSONObject.put("reward_full_scene_type", com.byazt.fcd.uj.c(icVar));
                        } catch (JSONException unused) {
                        }
                        yp.c().c(icVar, "stats_reward_full_ad_loaded", jSONObject);
                        AnonymousClass2 anonymousClass4 = AnonymousClass2.this;
                        com.byazt.iu.n nVar2 = nVar;
                        if (nVar2 != 0) {
                            nVar2.c(t, z, icVar);
                        }
                        AnonymousClass2 anonymousClass5 = AnonymousClass2.this;
                        n.this.c(ttVar, icVar, this);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.byazt.iu.ve
                    public void tt() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (j != 0) {
                            com.byazt.ddx.uj.tt(icVar, nb.tt(n.this.c() ? 7 : 8), j);
                        }
                        n.this.c(t);
                        com.byazt.iu.n nVar2 = nVar;
                        if (nVar2 != 0) {
                            nVar2.c(t);
                        }
                    }

                    @Override // com.byazt.iu.ve
                    public void ve() {
                        if (this.ve.compareAndSet(false, true)) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            n.this.c(z, ttVar, (List<ic>) list);
                        }
                    }
                };
                com.byazt.iu.sp spVar2 = spVar;
                if (spVar2 != null) {
                    spVar2.c(veVar);
                }
            }
        });
    }

    @Override // com.byazt.vvt.tt, com.byazt.dx.c
    public void c(com.byazt.dj.tt ttVar, int i, String str, com.byazt.ete.tt ttVar2) {
        if (ttVar != null) {
            c(ttVar.uj(), i, str, ttVar2);
        }
    }

    @Override // com.byazt.vvt.tt, com.byazt.dx.c
    public void c(int i, com.byazt.ete.c cVar, com.byazt.ete.tt ttVar, bm bmVar, com.byazt.dj.tt ttVar2, com.byazt.iu.n nVar, com.byazt.iu.sp spVar) {
        if (cVar.tt() == null || cVar.tt().isEmpty()) {
            if (spVar != null) {
                spVar.c(-3);
                return;
            }
            return;
        }
        Bundle bundle = bmVar == null ? null : bmVar.m;
        boolean z = bundle != null && bundle.getBoolean("is_preload", false);
        boolean z2 = bundle != null && bundle.getBoolean("is_playAgain", false);
        long j = bundle != null ? bundle.getLong(CropKey.RESULT_KEY_START_TIME, 0L) : 0L;
        boolean z3 = bundle != null && bundle.getBoolean("is_second_page_ad", false);
        cVar.tt().size();
        ic icVar = cVar.tt().get(0);
        if (c(ttVar2.uj(), icVar)) {
            return;
        }
        if (!icVar.qt()) {
            if (spVar != null) {
                spVar.c(-4);
                return;
            }
            return;
        }
        if (c(cVar)) {
            if (spVar != null) {
                spVar.c(-3);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (cVar.tt().size() > 1) {
            if (x.c(i).c("mix_ad", new x.tt.c().c(ttVar2).c(icVar).c())) {
                com.byazt.omf.c.c(cVar.tt());
                arrayList.add(icVar);
            } else {
                arrayList.addAll(cVar.tt());
            }
        } else {
            arrayList.addAll(cVar.tt());
        }
        Iterator<ic> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().lr(z ? 103 : 102);
        }
        if (z) {
            com.byazt.iu.tt ttVar3 = this.c;
            if (ttVar3 != null) {
                ttVar3.tt().c(ttVar2, icVar);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("src_req_id", icVar.xv());
                jSONObject.put("is_map", icVar.rp());
                jSONObject.put("reward_full_scene_type", com.byazt.fcd.uj.c(icVar));
            } catch (Exception unused) {
            }
            yp.c().c(icVar, "stats_reward_full_preload", jSONObject);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(CropKey.RESULT_KEY_START_TIME, j);
        bundle2.putBoolean("is_playAgain", z2);
        bundle2.putBoolean("is_cache", false);
        bundle2.putBoolean("is_second_page_ad", z3);
        c(i, arrayList, ttVar2, nVar, bundle2, spVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, int i, String str2, com.byazt.ete.tt ttVar) {
        ttVar.c(i);
        ttVar.tt(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", com.byazt.omf.x.m().rl());
            jSONObject.put("rit", str);
        } catch (Exception unused) {
        }
        ttVar.c(jSONObject);
        com.byazt.ete.tt.c(ttVar);
    }

    public void c(ic icVar, com.byazt.dj.tt ttVar) {
        ttVar.uj();
        try {
            zb zbVarTe = icVar.te();
            if (zbVarTe != null && !TextUtils.isEmpty(zbVarTe.c())) {
                com.byazt.hy.ve veVar = new com.byazt.hy.ve(true);
                veVar.c(ttVar.uj());
                veVar.c(8);
                veVar.ve(icVar.uj());
                veVar.uj(icVar.w_());
                veVar.tt(nb.m(icVar));
                com.byazt.xky.tt.c(zbVarTe).to(veVar);
            }
        } catch (Throwable unused) {
        }
        if (pu.da(icVar) && pu.a(icVar) != null) {
            da.c(pu.a(icVar).i(), pu.a(icVar).da(), (com.byazt.xs.ve) null);
        }
        if (c()) {
            for (g gVar : kp.gt(icVar)) {
                da.c(gVar.uj(), gVar.n(), (com.byazt.xs.ve) null);
            }
            for (g gVar2 : l.n(icVar)) {
                da.c(gVar2.uj(), gVar2.n(), (com.byazt.xs.ve) null);
            }
        }
        if (TextUtils.isEmpty(lt.sl(icVar))) {
            return;
        }
        da.c(lt.sl(icVar), lt.t(icVar), (com.byazt.xs.ve) null);
    }

    @Override // com.byazt.vvt.tt
    public void c(com.byazt.dj.tt ttVar, List<ic> list, T t) {
        ic icVar = list.get(0);
        com.byazt.iu.tt ttVar2 = this.c;
        if (ttVar2 != null) {
            ttVar2.tt().c(ttVar, icVar, t, icVar.up());
        }
    }

    @Override // com.byazt.dx.c
    public void c(com.byazt.dj.tt ttVar, ic icVar, com.byazt.iu.ve veVar) {
        c(icVar, ttVar);
        if (com.byazt.ex.c.c(icVar)) {
            com.byazt.ex.c.tt(icVar);
            veVar.tt();
            return;
        }
        if (!kp.ve(icVar, true)) {
            veVar.tt();
            return;
        }
        if (rl.ve(icVar)) {
            if (my.c(icVar) && t.c(icVar)) {
                tt(ttVar, icVar, veVar);
                return;
            } else {
                veVar.tt();
                return;
            }
        }
        if (!ic.ve(icVar) && !t.c(icVar)) {
            veVar.tt();
        } else {
            tt(ttVar, icVar, veVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, ic icVar) {
        if (!gt.tt().tt(str) || icVar == null) {
            return false;
        }
        int i = c() ? 7 : 8;
        ic icVarTt = com.byazt.lvl.c.c().tt(c(), str);
        if (icVarTt == null) {
            return false;
        }
        if (icVarTt.dz() + icVarTt.b() < System.currentTimeMillis()) {
            com.byazt.eti.n.c(i).c(str);
            return true;
        }
        if (!TextUtils.equals(icVarTt.y(), icVar.y())) {
            if (com.byazt.omf.c.c(icVar, c() ? 7 : 8) != 200) {
                return true;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(icVar.s());
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.get(next);
                icVarTt.q_().put(next, jSONObject.get(next));
            }
            icVarTt.gr(icVarTt.q_().toString());
        } catch (Exception e) {
            m.c(e);
        }
        return false;
    }

    @Override // com.byazt.dx.c
    public void c(final com.byazt.dj.tt ttVar) {
        if (gt.tt().tt(ttVar.uj())) {
            bm bmVar = new bm();
            bmVar.c = 2;
            if (gt.tt().i(ttVar.uj()) || ttVar.x() > 0.0f) {
                bmVar.sp = 2;
            }
            gt.c().tt(ttVar, bmVar, c() ? 7 : 8, new gu.tt() { // from class: com.byazt.cf.n.4
                @Override // com.byazt.omf.gu.tt
                public void c(int i, String str, com.byazt.ete.tt ttVar2) {
                    ttVar2.c(i);
                    ttVar2.tt(str);
                    com.byazt.ete.tt.c(ttVar2);
                }

                @Override // com.byazt.omf.gu.tt
                public void c(com.byazt.ete.c cVar, com.byazt.ete.tt ttVar2) {
                    if (cVar.tt() == null || cVar.tt().isEmpty()) {
                        n.this.c(ttVar.uj(), -3, com.byazt.omf.sp.c(-3), ttVar2);
                        return;
                    }
                    ic icVar = cVar.tt().get(0);
                    if (n.this.c(ttVar.uj(), icVar)) {
                        return;
                    }
                    if (!icVar.qt() || n.this.c(cVar)) {
                        n.this.c(ttVar.uj(), -4, com.byazt.omf.sp.c(-4), ttVar2);
                        return;
                    }
                    if (cVar.tt().size() > 1) {
                        if (x.c(n.this.c() ? 7 : 8).c("mix_ad", new x.tt.c().c(ttVar).c(icVar).c())) {
                            com.byazt.omf.c.c(cVar.tt());
                        }
                    }
                    if (n.this.c != null) {
                        n.this.c.tt().c(ttVar, icVar);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("src_req_id", icVar.xv());
                        jSONObject.put("is_map", icVar.rp());
                    } catch (Exception unused) {
                    }
                    yp.c().c(icVar, "stats_reward_full_preload", jSONObject);
                }
            });
        }
    }
}
