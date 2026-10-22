package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionTagView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeLogoView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class zm implements ce, wa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private pa f28106a;
    private final ee b = new ee();
    private final Context c;
    private final ba d;
    private final s0 e;
    private ScopeExpressContainer f;
    private AtomicInteger g;
    private String h;
    private b i;

    public class a implements pa.a {
        public a() {
        }

        @Override // com.beizi.fusion.pa.a
        public List a(String str) {
            zm zmVar = zm.this;
            return zmVar.e.a(zmVar.d.b(), str);
        }
    }

    public static class b extends o3 {
        private b(int i) {
            super(i);
        }
    }

    public class c implements ge.a {
        private c() {
        }

        @Override // com.beizi.fusion.ge.a
        public void a(ab abVar) {
            pa paVar = zm.this.f28106a;
            if (paVar != null) {
                paVar.c();
                zm.this.c();
            }
        }

        @Override // com.beizi.fusion.ge.a
        public void b(ab abVar) {
            zm.this.c(abVar);
        }
    }

    public class d implements he.a {
        private d() {
        }

        @Override // com.beizi.fusion.he.a
        public void a(String str) {
            pa paVar = zm.this.f28106a;
            if (paVar != null) {
                zm.this.a(paVar.a(str));
            }
        }

        @Override // com.beizi.fusion.he.a
        public void b(String str) {
            pa paVar = zm.this.f28106a;
            if (paVar != null) {
                zm.this.b.a(fe.a.SINGLE_VIEW_RENDERED, null, paVar.a(str));
            }
            AtomicInteger atomicInteger = zm.this.g;
            if (atomicInteger == null || atomicInteger.decrementAndGet() != 0) {
                return;
            }
            pa paVar2 = zm.this.f28106a;
            String strD = paVar2 != null ? paVar2.d() : "";
            if (!TextUtils.isEmpty(zm.this.h) && !TextUtils.isEmpty(strD)) {
                zm zmVar = zm.this;
                zmVar.e.a(zmVar.d.b(), zm.this.h, strD);
            }
            zm.this.b.a(fe.a.RENDER_SUCCESS, null, null);
        }
    }

    public zm(Context context, ba baVar) {
        this.c = context;
        this.d = baVar;
        this.e = (s0) t0.a().b(context);
    }

    @Override // com.beizi.fusion.ce
    public boolean a(AdItemModel adItemModel) {
        if (adItemModel == null) {
            return false;
        }
        this.b.a((Object) null);
        this.f28106a = h9.a().b(this.c, adItemModel, new a());
        this.g = new AtomicInteger(this.f28106a.g());
        this.i = new b(this.f28106a.g());
        this.f = new ScopeExpressContainer(this.c);
        pa paVar = this.f28106a;
        if (paVar == null || !paVar.e()) {
            return false;
        }
        NativeModel nativeModel = adItemModel.getNativeModel();
        if (nativeModel == null) {
            return true;
        }
        this.h = nativeModel.getRenderId();
        return true;
    }

    @Override // com.beizi.fusion.ce
    public void b() {
        pa paVar = this.f28106a;
        if (paVar != null) {
            paVar.b();
            this.f28106a = null;
        }
        ee eeVar = this.b;
        if (eeVar != null) {
            eeVar.b();
        }
    }

    @Override // com.beizi.fusion.ce
    public void c() {
        pa paVar = this.f28106a;
        if (paVar == null || !paVar.e()) {
            a((ab) null);
        } else {
            this.b.a();
            a(this.f28106a);
        }
    }

    @Override // com.beizi.fusion.wa
    public va d() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ab abVar) {
        this.i.a(abVar.f(), abVar);
        if (this.i.a()) {
            for (int i = 0; i < this.i.b(); i++) {
                b((ab) this.i.a(i));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004c A[PHI: r6
      0x004c: PHI (r6v6 int) = (r6v4 int), (r6v8 int) binds: [B:27:0x0049, B:22:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(ab abVar) {
        ViewGroup viewGroup;
        if (abVar == null) {
            a(abVar);
            return;
        }
        he heVarD = abVar.d();
        if (heVarD != 0) {
            View view = (View) heVarD;
            if (abVar.e() == null) {
                viewGroup = this.f;
                float[] fArrA = a(this.d);
                int i = (int) fArrA[0];
                int i2 = (int) fArrA[1];
                RelativeLayout.LayoutParams layoutParamsI = abVar.a().i();
                if (layoutParamsI != null) {
                    if (i == 0 && (i = ((ViewGroup.LayoutParams) layoutParamsI).width) <= 0) {
                        i = -2;
                    }
                    if ((i2 == 0 || i2 <= ((ViewGroup.LayoutParams) layoutParamsI).height) && (i2 = ((ViewGroup.LayoutParams) layoutParamsI).height) <= 0) {
                        i2 = -2;
                    }
                } else {
                    if (i == 0) {
                        i = -2;
                    }
                    if (i2 == 0) {
                        i2 = -2;
                    }
                }
                viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
            } else {
                Object objD = abVar.e().d();
                if (objD instanceof ViewGroup) {
                    viewGroup = (ViewGroup) objD;
                } else {
                    viewGroup = this.f;
                }
            }
            RelativeLayout.LayoutParams layoutParamsI2 = abVar.a().i();
            heVarD.setExpressRoot(this.f);
            if (viewGroup != null && layoutParamsI2 != null) {
                if ((view instanceof ScopeLogoView) || (view instanceof ScopeInteractionTagView)) {
                    ((ViewGroup.LayoutParams) layoutParamsI2).width = -2;
                }
                view.setLayoutParams(layoutParamsI2);
                if (heVarD.getLayer() != 1) {
                    viewGroup.getChildCount();
                }
                viewGroup.addView(view);
                heVarD.fillContent(new d());
            } else {
                a(abVar);
            }
            this.f.requestLayout();
            return;
        }
        a(abVar);
    }

    @Override // com.beizi.fusion.ce
    public View a() {
        return this.f;
    }

    private void a(pa paVar) {
        ab abVarF = paVar.f();
        if (abVarF.a() != null) {
            float[] fArrA = a(this.d);
            om.d("Render", "广告展示大小 " + fArrA[0] + " " + fArrA[1]);
            if (fArrA.length == 2) {
                int i = (int) fArrA[0];
                int i2 = (int) fArrA[1];
                abVarF.a().b(i);
                abVarF.a().c(i2);
                abVarF.a().a(new c());
                abVarF.a().c();
                return;
            }
        }
        a((ab) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ab abVar) {
        this.b.a(fe.a.RENDER_FAILED, null, abVar);
    }

    private float[] a(ba baVar) {
        float[] fArrD = baVar.d();
        if (baVar.b() == com.beizi.fusion.d.SPLASH) {
            if (fArrD[0] <= 0.0f) {
                fArrD[0] = gn.f(this.c);
            }
            if (fArrD[1] <= 0.0f) {
                fArrD[1] = gn.d(this.c);
            }
        }
        return fArrD;
    }
}
