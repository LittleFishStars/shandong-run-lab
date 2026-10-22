package com.beizi.fusion;

import android.content.Context;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class uf extends z0 implements vc {
    private final ce v;
    private final fe w;
    private de x;
    private ScopeExpressContainer y;

    public class a implements fe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f27830a;

        private a() {
            this.f27830a = false;
        }

        @Override // com.beizi.fusion.ya
        public void a(ee eeVar) {
        }

        @Override // com.beizi.fusion.fe
        public void f() {
            if (this.f27830a) {
                return;
            }
            this.f27830a = true;
            uf.this.g.a(u7.EVENT_REPORT_RENDER_FAIL_CODE, uf.this.d);
            uf.this.a(sf.NULL_EXPRESS_VIEW);
        }

        @Override // com.beizi.fusion.fe
        public void a(ab abVar) {
            he heVarD = abVar.d();
            if (heVarD instanceof zc) {
                zc zcVar = (zc) heVarD;
                xc xcVarA = uf.this.a(abVar.d(), zcVar.getInteractionType(), zcVar.getActionType());
                if (xcVarA != null) {
                    zcVar.bindInteractionForm(xcVarA);
                }
            }
        }

        @Override // com.beizi.fusion.fe
        public void a() {
            uf.this.g.a(u7.EVENT_REPORT_RENDER_SUCCESS_CODE, uf.this.d);
            View viewA = uf.this.a();
            if (viewA instanceof ScopeExpressContainer) {
                ScopeExpressContainer scopeExpressContainer = (ScopeExpressContainer) viewA;
                uf.this.d.setRecorder(ScopeExpressContainer.d.f(scopeExpressContainer));
                uf ufVar = uf.this;
                ScopeExpressContainer.d.a(scopeExpressContainer, ufVar.b(ufVar.b), uf.this.q(), uf.this.r());
                scopeExpressContainer.setVideoConfig(uf.this.c);
                uf.this.b(viewA);
            }
        }
    }

    public uf(Context context, AdItemModel adItemModel, ba baVar, AdTraceModel adTraceModel) {
        super(context, adItemModel, baVar, adTraceModel);
        this.v = ce.a.a(context, baVar);
        this.w = new a();
    }

    @Override // com.beizi.fusion.vc
    public void k() {
        ce ceVar = this.v;
        if (ceVar != null) {
            if (this.b == null) {
                a(sf.INVALID_MEDIA_STRUCT);
                return;
            }
            if ((ceVar instanceof wa) && ((wa) ceVar).d() != null) {
                ((wa) this.v).d().a(this.w);
            }
            if (!this.v.a(this.b)) {
                a(sf.RENDER_PREPARED_ERROR);
            } else {
                this.g.a(u7.EVENT_REPORT_RENDER_CODE, this.d);
                this.v.c();
            }
        }
    }

    @Override // com.beizi.fusion.z0, com.beizi.fusion.ib
    public void b() {
        super.b();
        ScopeExpressContainer scopeExpressContainer = this.y;
        if (scopeExpressContainer != null) {
            scopeExpressContainer.onViewDestroy();
            this.y.removeFromParent();
        }
        ce ceVar = this.v;
        if (ceVar != null) {
            ceVar.b();
        }
    }

    @Override // com.beizi.fusion.ib
    public View a() {
        ce ceVar = this.v;
        if (ceVar != null) {
            return ceVar.a();
        }
        return null;
    }

    @Override // com.beizi.fusion.vc
    public void a(de deVar) {
        this.x = deVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sf sfVar) {
        de deVar = this.x;
        if (deVar != null) {
            deVar.a(sfVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        if (view instanceof ScopeExpressContainer) {
            this.y = (ScopeExpressContainer) view;
        }
        de deVar = this.x;
        if (deVar != null) {
            deVar.a(view);
        }
    }
}
