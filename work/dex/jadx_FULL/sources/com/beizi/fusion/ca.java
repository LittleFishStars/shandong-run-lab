package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.StrategyModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final d f27135a;
    protected Context b;
    protected ba c;
    protected boolean d = false;
    protected com.beizi.fusion.a e;
    private final c f;
    private final io g;
    private final ho h;
    private final jo i;
    private ConfigResponseModel j;
    private final ga k;
    private boolean l;
    private String m;
    private Map n;

    public class a implements pb {
        public a() {
        }

        @Override // com.beizi.fusion.pb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean fetch(StrategyModel strategyModel, String str) {
            return str.equals(strategyModel.getSpaceID());
        }
    }

    public static class b {
        public static ca a(d dVar, Context context, ba baVar) {
            if (dVar == d.BANNER || dVar == d.NATIVE) {
                return new ii(context, baVar, dVar);
            }
            if (dVar == d.UNIFIED) {
                return new ip(context, baVar, dVar);
            }
            return dVar == d.VIDEO ? new em(context, baVar, dVar) : new fi(context, baVar, dVar);
        }
    }

    public class c implements rc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ea f27137a;

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ea eaVar) {
            this.f27137a = eaVar;
        }

        @Override // com.beizi.fusion.rc
        public void a(List list) {
            ca caVar = ca.this;
            caVar.l = false;
            caVar.a(list);
        }

        @Override // com.beizi.fusion.rc
        public void a(n1 n1Var) {
            if (n1Var != n1.ERROR_AD_REQUESTING) {
                ca.this.l = false;
            }
            ea eaVar = this.f27137a;
            if (eaVar != null) {
                eaVar.a(n1Var.b(), n1Var.c());
            }
        }
    }

    public ca(Context context, ba baVar, d dVar) {
        this.c = baVar;
        this.f27135a = dVar;
        this.b = context;
        this.g = new io(context, baVar.g());
        ho hoVar = new ho();
        this.h = hoVar;
        this.i = new jo(context);
        hoVar.a(this.c.h());
        this.e = (com.beizi.fusion.a) com.beizi.fusion.b.a().b(this.b);
        this.k = new ue(this.b, dVar);
        this.f = new c();
    }

    private boolean e() {
        Context context = this.b;
        ba baVar = this.c;
        return t5.a(context, baVar, a(baVar.g()));
    }

    private boolean g() {
        return this.j != null;
    }

    public void a(ea eaVar) {
        this.f.a(eaVar);
        ga gaVar = this.k;
        if (gaVar != null) {
            gaVar.a(this.f);
        }
    }

    public abstract void a(List list);

    public boolean b() {
        jo joVar;
        long jRandom = (long) ((Math.random() * 100.0d) + 1.0d);
        if (this.f27135a != d.INTERSTITIAL || (joVar = this.i) == null) {
            return false;
        }
        joVar.b(jRandom);
        StrategyFilterModel strategyFilterModelA = a(this.c.g());
        if (strategyFilterModelA != null) {
            return this.i.a(strategyFilterModelA);
        }
        return false;
    }

    public ea c() {
        return this.f.f27137a;
    }

    public Map d() {
        return this.n;
    }

    public boolean f() {
        return this.d;
    }

    public void h() {
        g gVar = (g) h.a().b(this.b);
        a(gVar != null ? gVar.a() : null);
        ba baVar = this.c;
        if (baVar == null) {
            a(n1.ERROR_INVALID_CONFIG);
            return;
        }
        if (TextUtils.isEmpty(baVar.g())) {
            a(n1.ERROR_INVALID_SPACE_ID);
            return;
        }
        if (this.l) {
            a(n1.ERROR_AD_REQUESTING);
            return;
        }
        if (gVar == null) {
            om.b("IBaseAdController", "unexpected error config cache is null...");
            a(n1.ERROR_SDK_NOT_INIT);
            return;
        }
        ConfigResponseModel configResponseModelA = gVar.a(true);
        this.j = configResponseModelA;
        if (configResponseModelA == null) {
            om.b("IBaseAdController", "unexpected error config copy is null...");
            a(n1.ERROR_SDK_NOT_INIT);
            return;
        }
        AdTraceModel adTraceModelA = a(this.c);
        if (adTraceModelA == null) {
            a(n1.ERROR_S2S_VERIFICATION_FAILED);
            return;
        }
        this.m = adTraceModelA.getRequestTracSessionID();
        this.n = adTraceModelA.getSwitch4VInfo();
        adTraceModelA.setStrategyMD5(this.j.getStrategyMD5(this.c.g()));
        ((q9) p.a().b(this.b)).a(u7.EVENT_REPORT_LOAD_CODE, adTraceModelA);
        if (!g()) {
            a(n1.ERROR_SDK_NOT_INIT);
            return;
        }
        if (a()) {
            a(n1.ERROR_REQUEST_TOO_OFTEN);
            return;
        }
        if (e()) {
            a(n1.ERROR_AD_BEING_COMPLAINED);
        } else if (b()) {
            a(n1.ERROR_UNITE_CONTROL);
        } else {
            a(gVar.a(), adTraceModelA);
        }
    }

    private void a(v vVar) {
        if (vVar == null || !vVar.d()) {
            return;
        }
        om.a("IBaseAdController", "允许使用个性化推荐, 初始化OAID...");
        wj.a().d(this.b);
    }

    private AdTraceModel a(ba baVar) {
        AdTraceModel adTraceModel = new AdTraceModel(baVar);
        lm lmVarF = baVar.f();
        if (lmVarF == null) {
            return adTraceModel;
        }
        lmVarF.a(this.b);
        String strC = lmVarF.c();
        if (!lmVarF.a().equals(baVar.g()) || TextUtils.isEmpty(strC)) {
            return null;
        }
        adTraceModel.updateS2SRequestSerialID(strC);
        return adTraceModel;
    }

    private void a(v vVar, AdTraceModel adTraceModel) {
        ba baVar;
        ga gaVar = this.k;
        if (gaVar != null && (baVar = this.c) != null) {
            this.d = false;
            this.l = true;
            gaVar.a(vVar, this.j, baVar, adTraceModel);
        } else {
            om.b("IBaseAdController", "unexpected error iAdRouter or mAdConfig is null...");
            a(n1.ERROR_UNEXPECTED);
        }
    }

    private void a(n1 n1Var) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(n1Var);
        }
    }

    private boolean a() {
        if (this.j == null) {
            return false;
        }
        StrategyFilterModel strategyFilterModelA = a(this.c.g());
        return this.g.a(strategyFilterModelA) || this.h.a(strategyFilterModelA);
    }

    public void a(long j) {
        jo joVar = this.i;
        if (joVar != null) {
            joVar.a(j);
        }
    }

    private StrategyFilterModel a(String str) {
        StrategyModel strategyModel;
        if (this.j == null || TextUtils.isEmpty(str) || (strategyModel = (StrategyModel) k5.a(this.j.getStrategyList(), str, new a())) == null) {
            return null;
        }
        return strategyModel.getFilter();
    }
}
