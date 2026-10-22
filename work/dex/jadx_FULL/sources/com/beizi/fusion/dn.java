package com.beizi.fusion;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionTagView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeLogoView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class dn implements ce, wa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27196a;
    private ScopeExpressContainer b;
    private pa c;
    private final ee d = new ee();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            dn.this.d.a();
            dn.this.b.measure(0, 0);
            int measuredHeight = dn.this.b.getMeasuredHeight();
            int measuredWidth = dn.this.b.getMeasuredWidth();
            dn dnVar = dn.this;
            dnVar.a(dnVar.c, new int[]{measuredWidth, measuredHeight});
        }
    }

    public class b implements ge.a {
        private b() {
        }

        @Override // com.beizi.fusion.ge.a
        public void a(ab abVar) {
        }

        @Override // com.beizi.fusion.ge.a
        public void b(ab abVar) {
            dn.this.a(abVar);
        }
    }

    public class c implements he.a {
        private c() {
        }

        @Override // com.beizi.fusion.he.a
        public void a(String str) {
            pa paVar = dn.this.c;
            if (paVar != null) {
                Object objD = paVar.a(str).d();
                if (objD instanceof View) {
                    dn.this.b.removeView((View) objD);
                }
            }
        }

        @Override // com.beizi.fusion.he.a
        public void b(String str) {
        }
    }

    public dn(Context context, ba baVar) {
        this.f27196a = context;
    }

    @Override // com.beizi.fusion.ce
    public View a() {
        return null;
    }

    public void a(ScopeExpressContainer scopeExpressContainer) {
        this.b = scopeExpressContainer;
    }

    @Override // com.beizi.fusion.ce
    public void b() {
        this.d.b();
    }

    @Override // com.beizi.fusion.ce
    public void c() {
        pa paVar = this.c;
        if (paVar == null || !paVar.e()) {
            return;
        }
        this.b.post(new a());
    }

    @Override // com.beizi.fusion.wa
    public va d() {
        return this.d;
    }

    @Override // com.beizi.fusion.ce
    public boolean a(AdItemModel adItemModel) {
        this.d.a((Object) null);
        if (adItemModel == null) {
            return false;
        }
        this.c = h9.a().b(this.f27196a, adItemModel, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(pa paVar, int[] iArr) {
        ab abVarF = paVar.f();
        if (abVarF.a() == null || iArr.length != 2) {
            return;
        }
        int i = iArr[0];
        int i2 = iArr[1];
        abVarF.a().b(i);
        abVarF.a().c(i2);
        abVarF.a().a(new b());
        abVarF.a().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ab abVar) {
        ViewGroup viewGroup;
        he heVarD = abVar.d();
        if (heVarD != 0) {
            View view = (View) heVarD;
            if (abVar.e() == null) {
                viewGroup = this.b;
            } else {
                Object objD = abVar.e().d();
                if (objD instanceof ViewGroup) {
                    viewGroup = (ViewGroup) objD;
                } else {
                    viewGroup = this.b;
                }
            }
            RelativeLayout.LayoutParams layoutParamsI = abVar.a().i();
            if (viewGroup != null && layoutParamsI != null) {
                if ((view instanceof ScopeLogoView) || (view instanceof ScopeInteractionTagView)) {
                    ((ViewGroup.LayoutParams) layoutParamsI).width = -2;
                }
                view.setLayoutParams(layoutParamsI);
                this.d.a(fe.a.SINGLE_VIEW_RENDERED, view, abVar);
                int childCount = heVarD.getLayer() == 1 ? 0 : viewGroup.getChildCount();
                if (viewGroup == this.b && viewGroup.getChildCount() > 0) {
                    viewGroup.addView(view, 1);
                } else {
                    viewGroup.addView(view, childCount);
                }
                heVarD.fillContent(new c());
            }
            heVarD.setExpressRoot(this.b);
            this.b.requestLayout();
        }
    }
}
