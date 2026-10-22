package com.beizi.fusion;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.RewardPropModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.ctrl.EndCardPageModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.ctrl.PrimarySkipCtrlModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.ctrl.PrivilegePageModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.ctrl.RetainPageModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.ctrl.RewardConditionModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class em extends fi {
    private final Map A;
    private b B;

    public class a extends fi.a implements tc {
        private a() {
            super();
        }

        @Override // com.beizi.fusion.fi.a, com.beizi.fusion.b6.a, com.beizi.fusion.ud
        public void f() {
            super.f();
        }

        @Override // com.beizi.fusion.tc
        public void h() {
        }

        @Override // com.beizi.fusion.tc
        public void i() {
            em.this.u();
        }

        @Override // com.beizi.fusion.tc
        public void j() {
        }

        @Override // com.beizi.fusion.tc
        public void k() {
        }

        @Override // com.beizi.fusion.fi.a, com.beizi.fusion.b6.a, com.beizi.fusion.td
        public void onAdClicked() {
            super.onAdClicked();
            b bVar = em.this.B;
            if (bVar != null) {
                bVar.v();
                em.this.B.a(re.a.SELECTED);
            }
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.sd
        public void onAdClosed() {
            super.onAdClosed();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RewardPropModel f27245a;
        private int b;
        private int c;
        private final Map d;
        private final List e;
        private ScopeExpressContainer f;
        private long g;
        private long h;
        private final pe i;
        private yk j;
        private final int k;
        private boolean l;
        private boolean m;
        private boolean n;
        private String o;
        private final CopyOnWriteArraySet p;

        public class a extends yk {
            final /* synthetic */ long j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j, long j2, long j3) {
                super(j, j2);
                this.j = j3;
            }

            @Override // com.beizi.fusion.yk
            public void a(long j) {
                pd pdVar = (pd) b.this.d.get("PRIVILEGE");
                if (pdVar != null) {
                    Iterator it = ScopeExpressContainer.d.d((ScopeExpressContainer) pdVar.a()).iterator();
                    while (it.hasNext()) {
                        ((df) it.next()).updateTextWithTimer("__AUTO_CLOSE__", ((this.j - j) / 1000) + "");
                    }
                }
            }

            @Override // com.beizi.fusion.yk
            public void c() {
            }

            @Override // com.beizi.fusion.yk
            public void d() {
                b.this.e();
            }
        }

        private b(RewardPropModel rewardPropModel) {
            RewardConditionModel conditionModel;
            int count = 0;
            this.b = 0;
            this.c = 0;
            this.l = true;
            this.m = true;
            this.n = false;
            this.p = new CopyOnWriteArraySet();
            this.f27245a = rewardPropModel;
            if (rewardPropModel != null && (conditionModel = rewardPropModel.getConditionModel()) != null) {
                count = conditionModel.getCount();
            }
            this.k = count;
            this.d = new HashMap(4);
            this.e = new ArrayList(4);
            this.i = new pe();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ScopeExpressContainer scopeExpressContainer) {
            this.f = scopeExpressContainer;
        }

        private void b() {
            if (d() && x()) {
                a(re.a.FINALLY);
                this.m = false;
                this.i.a(qe.a.REWARD_CLAIM_EVENT, null, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            yk ykVar = this.j;
            if (ykVar != null) {
                ykVar.a();
                this.j = null;
            }
        }

        private boolean d() {
            RewardConditionModel conditionModel = this.f27245a.getConditionModel();
            if (conditionModel == null) {
                return false;
            }
            int i = this.k;
            return (i > 0 && this.b >= i) || (!this.n && conditionModel.getPeriod() > 0 && this.c >= conditionModel.getPeriod()) || (conditionModel.getBrowse() > 0 && (this.h > ((long) conditionModel.getBrowse()) ? 1 : (this.h == ((long) conditionModel.getBrowse()) ? 0 : -1)) >= 0) || (conditionModel.getCount() > 0 && this.b >= conditionModel.getCount());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            pd pdVarA;
            View viewA;
            if (this.f == null || (pdVarA = a("PRIVILEGE")) == null || (viewA = pdVarA.a()) == null) {
                return;
            }
            this.p.remove("PRIVILEGE");
            this.f.removeView(viewA);
        }

        private hc.a f() {
            EndCardPageModel endCardModel = this.f27245a.getEndCardModel();
            if (endCardModel != null) {
                return new hc.a(endCardModel.getAction(), endCardModel.getProbability(), this.f27245a.getForceEndCard() == 1, false);
            }
            return hc.a.f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public hc.a g() {
            PrimarySkipCtrlModel primarySkipCtrlModel = this.f27245a.getPrimarySkipCtrlModel();
            if (primarySkipCtrlModel != null) {
                return new hc.a(primarySkipCtrlModel.getAction(), primarySkipCtrlModel.getProbability(), this.f27245a.getForceEndCard() == 1, true);
            }
            return hc.a.g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int h() {
            if (this.f27245a.getPrimarySkipCtrlModel() != null) {
                return this.f27245a.getPrimarySkipCtrlModel().getDelay();
            }
            return 0;
        }

        private hc.a i() {
            PrivilegePageModel privilegePageModel = this.f27245a.getPrivilegePageModel();
            if (privilegePageModel != null) {
                return new hc.a(privilegePageModel.getAction(), privilegePageModel.getProbability(), this.f27245a.getForceEndCard() == 1, false);
            }
            return hc.a.f;
        }

        private hc.a j() {
            RetainPageModel retainPageModel = this.f27245a.getRetainPageModel();
            if (retainPageModel != null) {
                return new hc.a(retainPageModel.getAction(), retainPageModel.getProbability(), this.f27245a.getForceEndCard() == 1, false);
            }
            return hc.a.f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k() {
            ScopeExpressContainer scopeExpressContainer = this.f;
            if (scopeExpressContainer == null || this.f27245a == null) {
                return;
            }
            List<df> listD = ScopeExpressContainer.d.d(scopeExpressContainer);
            int period = this.f27245a.getConditionModel() != null ? this.f27245a.getConditionModel().getPeriod() : 0;
            int privilegeTime = this.f27245a.getPrivilegeType() == 1 ? this.f27245a.getPrivilegeTime() : 0;
            for (df dfVar : listD) {
                dfVar.updateTextWithTimer("__PERIOD_TIME__", (period / 1000) + "");
                dfVar.updateTextWithTimer("__CLICK_TIME__", (privilegeTime / 1000) + "秒后");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean l() {
            return "PRIMARY".equalsIgnoreCase(this.o) || this.p.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m() {
            yk ykVar = this.j;
            if (ykVar != null) {
                ykVar.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void n() {
            this.d.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o() {
            this.n = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p() {
            RewardPropModel rewardPropModel = this.f27245a;
            if (rewardPropModel == null || rewardPropModel.getPrivilegePageModel() == null) {
                return;
            }
            long remain = this.f27245a.getPrivilegePageModel().getRemain();
            if (remain > 0) {
                a aVar = new a(remain, 1000L, remain);
                this.j = aVar;
                aVar.g();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q() {
            yk ykVar = this.j;
            if (ykVar != null) {
                ykVar.f();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            this.g = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s() {
            ScopeExpressContainer scopeExpressContainer;
            View viewA;
            ScopeExpressContainer scopeExpressContainer2;
            if ("ENDCARD".equalsIgnoreCase(this.o)) {
                return;
            }
            pd pdVarA = a("ENDCARD");
            if (pdVarA != null && pdVarA.j() && (viewA = pdVarA.a()) != null && (scopeExpressContainer2 = this.f) != null) {
                scopeExpressContainer2.addView(viewA);
            }
            RewardPropModel rewardPropModel = this.f27245a;
            if (rewardPropModel == null || rewardPropModel.getEndCardType() != 1 || (scopeExpressContainer = this.f) == null) {
                return;
            }
            scopeExpressContainer.onActivityPause();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t() {
            Map map = this.d;
            if (map == null || !map.containsKey("ENDCARD")) {
                return;
            }
            pd pdVar = (pd) this.d.get("ENDCARD");
            if (this.f27245a.getEndCardType() == 2 && (pdVar instanceof fm)) {
                ((fm) pdVar).m();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u() {
            pd pdVarA;
            View viewA;
            ScopeExpressContainer scopeExpressContainer;
            if ("RETAIN".equalsIgnoreCase(this.o) || (pdVarA = a("RETAIN")) == null || !pdVarA.j() || (viewA = pdVarA.a()) == null || (scopeExpressContainer = this.f) == null) {
                return;
            }
            scopeExpressContainer.addView(viewA);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v() {
            this.b++;
            w();
            b();
        }

        private void w() {
            pd pdVar = (pd) this.d.get("PRIVILEGE");
            if (pdVar != null) {
                Iterator it = ScopeExpressContainer.d.d((ScopeExpressContainer) pdVar.a()).iterator();
                while (it.hasNext()) {
                    ((df) it.next()).updateTextWithTimer("__CLICK_COUNT__", this.b + WVNativeCallbackUtil.SEPERATER + this.k);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean x() {
            return this.m;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(re.a aVar) {
            List listC;
            if (!this.e.isEmpty() && re.a.FINALLY == aVar) {
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    ((hc.b) it.next()).a(1);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (pd pdVar : this.d.values()) {
                if (pdVar != null && (listC = ScopeExpressContainer.d.c((ScopeExpressContainer) pdVar.a())) != null) {
                    arrayList.addAll(listC);
                }
            }
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((re) obj).updateTextWithStatus(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(long j) {
            RewardConditionModel conditionModel;
            int browse;
            RewardPropModel rewardPropModel = this.f27245a;
            if (rewardPropModel == null || (conditionModel = rewardPropModel.getConditionModel()) == null || (browse = conditionModel.getBrowse()) <= 0) {
                return;
            }
            int i = browse - ((int) j);
            pd pdVar = (pd) this.d.get("PRIVILEGE");
            if (pdVar != null) {
                Iterator it = ScopeExpressContainer.d.d((ScopeExpressContainer) pdVar.a()).iterator();
                while (it.hasNext()) {
                    ((df) it.next()).updateTextWithTimer("__BROWSE__TIME__", (i / 1000) + "");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i) {
            if (!this.n) {
                this.c = i;
            }
            long j = i;
            a(j);
            d(j);
            b();
        }

        private void d(long j) {
            ScopeExpressContainer scopeExpressContainer;
            RewardPropModel rewardPropModel;
            pd pdVarA = a("RETAIN");
            if (pdVarA == null || pdVarA.a() == null || (scopeExpressContainer = (ScopeExpressContainer) pdVarA.a()) == null || (rewardPropModel = this.f27245a) == null) {
                return;
            }
            int period = rewardPropModel.getConditionModel() != null ? this.f27245a.getConditionModel().getPeriod() : 0;
            for (df dfVar : ScopeExpressContainer.d.d(scopeExpressContainer)) {
                long j2 = (((long) period) - j) / 1000;
                if (((int) j2) >= 0) {
                    dfVar.updateTextWithTimer("__RETAIN_TIME__", j2 + "");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public hc.a b(String str) {
            if ("PRIVILEGE".equalsIgnoreCase(str)) {
                return i();
            }
            if ("RETAIN".equalsIgnoreCase(str)) {
                return j();
            }
            if ("ENDCARD".equalsIgnoreCase(str)) {
                return f();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            if (z) {
                a();
                return;
            }
            RewardPropModel rewardPropModel = this.f27245a;
            if (rewardPropModel == null || rewardPropModel.getPrivilegeType() != 1 || System.currentTimeMillis() - this.g <= this.f27245a.getPrivilegeTime()) {
                return;
            }
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            this.o = str;
            if ("PRIMARY".equalsIgnoreCase(str)) {
                return;
            }
            this.p.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(String str) {
            this.p.remove(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j) {
            this.h += j;
            d();
        }

        public void a(int i) {
            RewardPropModel rewardPropModel = this.f27245a;
            if (rewardPropModel == null || rewardPropModel.getPrivilegeType() != 2 || i <= this.f27245a.getPrivilegeTime() || !this.l) {
                return;
            }
            this.l = false;
            a();
        }

        private void a() {
            pd pdVarA;
            ScopeExpressContainer scopeExpressContainer;
            if ("PRIVILEGE".equalsIgnoreCase(this.o) || !x() || (pdVarA = a("PRIVILEGE")) == null || !pdVarA.j()) {
                return;
            }
            View viewA = pdVarA.a();
            w();
            if (viewA == null || (scopeExpressContainer = this.f) == null) {
                return;
            }
            scopeExpressContainer.addView(viewA);
        }

        private synchronized pd a(String str) {
            return (pd) this.d.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void a(String str, pd pdVar) {
            if ("PRIMARY".equals(str) && (pdVar instanceof fm)) {
                this.i.a(((fm) pdVar).n());
            }
            this.d.put(str, pdVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(hc.b bVar) {
            this.e.add(bVar);
        }

        private void a(long j) {
            RewardPropModel rewardPropModel;
            if (this.f == null || (rewardPropModel = this.f27245a) == null) {
                return;
            }
            int period = rewardPropModel.getConditionModel() != null ? this.f27245a.getConditionModel().getPeriod() : 0;
            int privilegeTime = this.f27245a.getPrivilegeType() == 1 ? this.f27245a.getPrivilegeTime() : 0;
            for (df dfVar : ScopeExpressContainer.d.d(this.f)) {
                int i = (int) ((((long) period) - j) / 1000);
                if (i > 0) {
                    dfVar.updateTextWithTimer("__PERIOD_TIME__", i + "");
                }
                int i2 = (int) ((((long) privilegeTime) - j) / 1000);
                if (i2 > 0) {
                    dfVar.updateTextWithTimer("__CLICK_TIME__", i2 + "秒后");
                } else {
                    dfVar.updateTextWithTimer("__CLICK_TIME__", "");
                }
            }
        }
    }

    public class c extends fi.c implements tc {

        public class a extends hd {
            public a() {
            }

            @Override // com.beizi.fusion.hd
            public void a() {
                b bVar = em.this.B;
                if (bVar != null) {
                    bVar.m();
                }
            }

            @Override // com.beizi.fusion.hd
            public void b() {
                b bVar = em.this.B;
                if (bVar != null) {
                    bVar.q();
                }
            }
        }

        public class b implements z9 {
            public b() {
            }

            @Override // com.beizi.fusion.z9
            public void a(long j) {
                b bVar = em.this.B;
                if (bVar != null) {
                    bVar.b(j);
                    em.this.B.c(j);
                }
                b0.a().b().b(this);
            }
        }

        public c(String str) {
            super(str);
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.ud
        public void a(View view) {
            super.a(view);
            view.setClickable(true);
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.sd
        public void b() {
            b bVar;
            super.b();
            b bVar2 = em.this.B;
            if (bVar2 != null) {
                bVar2.c(this.d);
            }
            if ("PRIVILEGE".equalsIgnoreCase(this.d) && (bVar = em.this.B) != null) {
                bVar.p();
                em.this.B.c(0L);
                b0.a().b().b(new a());
            }
            if ("ENDCARD".equalsIgnoreCase(this.d)) {
                b bVar3 = em.this.B;
                if (bVar3 != null) {
                    bVar3.o();
                    em.this.B.t();
                    return;
                }
                return;
            }
            View view = em.this.q;
            if (view instanceof ScopeExpressContainer) {
                ((ScopeExpressContainer) view).onActivityPause();
                ScopeExpressContainer.d.h((ScopeExpressContainer) em.this.q);
            }
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.ud
        public void f() {
            super.f();
            Map map = em.this.A;
            if (map != null) {
                map.remove(this.d);
            }
        }

        @Override // com.beizi.fusion.tc
        public void h() {
            b bVar = em.this.B;
            if (bVar != null) {
                bVar.u();
            }
        }

        @Override // com.beizi.fusion.tc
        public void i() {
            em.this.u();
        }

        @Override // com.beizi.fusion.tc
        public void j() {
            b bVar = em.this.B;
            if (bVar == null || !bVar.x()) {
                return;
            }
            em.this.B.a(true);
        }

        @Override // com.beizi.fusion.tc
        public void k() {
            b bVar = em.this.B;
            if (bVar != null) {
                bVar.s();
            }
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.td
        public void onAdClicked() {
            super.onAdClicked();
            if ("PRIVILEGE".equalsIgnoreCase(this.d)) {
                b0.a().b().a(new b());
            }
            b bVar = em.this.B;
            if (bVar != null) {
                bVar.v();
                em.this.B.a(re.a.SELECTED);
                em.this.B.c();
            }
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.sd
        public void onAdClosed() {
            super.onAdClosed();
            b bVar = em.this.B;
            if (bVar != null) {
                bVar.d(this.d);
                em emVar = em.this;
                if (emVar.q == null || !emVar.B.l()) {
                    return;
                }
                ((ScopeExpressContainer) em.this.q).onActivityResume();
                ScopeExpressContainer.d.i((ScopeExpressContainer) em.this.q);
            }
        }
    }

    public em(Context context, ba baVar, com.beizi.fusion.d dVar) {
        super(context, baVar, dVar);
        this.A = new HashMap(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        jb jbVar = this.r;
        if (jbVar instanceof a1) {
            ((a1) jbVar).k();
        }
    }

    @Override // com.beizi.fusion.fi
    public void a(rd rdVar, AdItemModel adItemModel) {
        super.a(rdVar, adItemModel);
        String[] strArr = {"PRIVILEGE", "RETAIN", "ENDCARD"};
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            if (str.equals(adItemModel.getCategory())) {
                pd pdVarA = a(rdVar, adItemModel, new c(str));
                if (pdVarA instanceof fm) {
                    this.A.put(str, pdVarA);
                    b bVar = this.B;
                    if (bVar != null) {
                        hc.a aVarB = bVar.b(str);
                        ((fm) pdVarA).a(aVarB);
                        this.B.a(str, pdVarA);
                        this.B.a(aVarB);
                    }
                }
            }
        }
    }

    @Override // com.beizi.fusion.fi, com.beizi.fusion.b6
    public pd b(rd rdVar) {
        RewardPropModel rewardPropModel;
        AdItemModel adItemModelC = rdVar.c();
        if (adItemModelC != null && (rewardPropModel = adItemModelC.getRewardPropModel()) != null) {
            this.B = new b(rewardPropModel);
        }
        pd pdVarB = super.b(rdVar);
        if (pdVarB instanceof fm) {
            Object obj = this.p;
            if (obj instanceof tc) {
                fm fmVar = (fm) pdVarB;
                fmVar.a((tc) obj);
                b bVar = this.B;
                if (bVar != null) {
                    hc.a aVarG = bVar.g();
                    fmVar.a(aVarG);
                    this.B.a("PRIMARY", pdVarB);
                    this.B.a(aVarG);
                }
            }
            if (b(this.p)) {
                ((fm) pdVarB).a((uc) this.p);
            }
        }
        return pdVarB;
    }

    @Override // com.beizi.fusion.fi
    public wo c(rd rdVar) {
        return new fm(rdVar);
    }

    @Override // com.beizi.fusion.fi
    public wo d(rd rdVar) {
        return new fm(rdVar);
    }

    @Override // com.beizi.fusion.fi, com.beizi.fusion.b6
    public b6.a j() {
        return new d();
    }

    @Override // com.beizi.fusion.fi, com.beizi.fusion.b6
    public void k() {
        super.k();
        b bVar = this.B;
        if (bVar != null) {
            bVar.n();
        }
        this.A.clear();
    }

    @Override // com.beizi.fusion.fi
    public b6.a q() {
        return new a();
    }

    @Override // com.beizi.fusion.fi
    public void t() {
        super.t();
        Map map = this.A;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (pd pdVar : this.A.values()) {
            if (pdVar != null) {
                pdVar.a((ud) this.w.get(Integer.valueOf(pdVar.hashCode())));
            }
        }
    }

    public class d extends fi.g implements tc, uc {
        private d() {
            super();
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.ud
        public void a(View view) {
            ub ubVarB;
            super.a(view);
            em emVar = em.this;
            b bVar = emVar.B;
            if (bVar != null) {
                bVar.a((ScopeExpressContainer) emVar.q);
                em.this.B.k();
                if (em.this.B.h() >= 0 || (ubVarB = ScopeExpressContainer.d.b((ScopeExpressContainer) em.this.q)) == null) {
                    return;
                }
                ubVarB.delayExposure(em.this.B.h());
            }
        }

        @Override // com.beizi.fusion.fi.g, com.beizi.fusion.b6.a, com.beizi.fusion.sd
        public void b() {
            ub ubVarB;
            super.b();
            b bVar = em.this.B;
            if (bVar != null) {
                bVar.c("PRIMARY");
                em.this.B.r();
                if (em.this.B.h() <= 0 || (ubVarB = ScopeExpressContainer.d.b((ScopeExpressContainer) em.this.q)) == null) {
                    return;
                }
                ubVarB.delayExposure(em.this.B.h());
            }
        }

        @Override // com.beizi.fusion.uc
        public void c() {
            y9 y9Var = (y9) em.this.c();
            if (y9Var instanceof te) {
                ((te) y9Var).c();
            }
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.vd
        public void d() {
            b bVar = em.this.B;
            if (bVar != null) {
                bVar.s();
            }
        }

        @Override // com.beizi.fusion.tc
        public void h() {
            b bVar = em.this.B;
            if (bVar != null) {
                bVar.u();
            }
        }

        @Override // com.beizi.fusion.tc
        public void i() {
            em.this.u();
        }

        @Override // com.beizi.fusion.tc
        public void j() {
            b bVar = em.this.B;
            if (bVar == null || !bVar.x()) {
                return;
            }
            em.this.B.a(true);
        }

        @Override // com.beizi.fusion.tc
        public void k() {
            b bVar = em.this.B;
            if (bVar != null) {
                bVar.s();
            }
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.td
        public void onAdClicked() {
            super.onAdClicked();
            b bVar = em.this.B;
            if (bVar != null) {
                bVar.a(re.a.SELECTED);
            }
            b bVar2 = em.this.B;
            if (bVar2 != null) {
                bVar2.a(false);
            }
        }

        @Override // com.beizi.fusion.fi.g, com.beizi.fusion.b6.a, com.beizi.fusion.sd
        public void onAdClosed() {
            super.onAdClosed();
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.vd
        public void a(int i) {
            b bVar = em.this.B;
            if (bVar != null) {
                bVar.b(i);
                em.this.B.a(i);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.beizi.fusion.fi
    public pd a(rd rdVar, AdItemModel adItemModel, b6.a aVar) {
        pd pdVarA = super.a(rdVar, adItemModel, aVar);
        if ((pdVarA instanceof fm) && (aVar instanceof tc)) {
            ((fm) pdVarA).a((tc) aVar);
        }
        return pdVarA;
    }

    private boolean b(b6.a aVar) {
        if (aVar != null) {
            return d.class.isAssignableFrom(aVar.getClass());
        }
        return false;
    }
}
