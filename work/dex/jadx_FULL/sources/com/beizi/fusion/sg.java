package com.beizi.fusion;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.land.LandingOptimizeModel;
import com.beizi.fusion.asnp.adn.ad.widget.activity.ASNPLandingPageActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class sg {
    private final Context d;
    private final LandingOptimizeModel e;
    private dd f;
    private dc g;
    private final xc h;
    private FrameLayout j;
    private e k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27746a = 0;
    private final int b = 1;
    private final int c = 2;
    private int i = 0;
    private boolean l = false;
    private long m = 0;

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sg sgVar = sg.this;
            xc xcVar = sgVar.h;
            if (xcVar instanceof bg) {
                sgVar.l = true;
                ((bg) xcVar).b(dd.a.LANDING_PAGE_INTERACTIVE_TRIGGER);
            }
        }
    }

    public class c implements oc {
        public c() {
        }

        @Override // com.beizi.fusion.oc
        public void a() {
        }

        @Override // com.beizi.fusion.oc
        public void b() {
            sg.this.a(1);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sg sgVar = sg.this;
            xc xcVar = sgVar.h;
            if (xcVar instanceof bg) {
                sgVar.l = true;
                ((bg) xcVar).b(dd.a.LANDING_PAGE_INTERACTIVE_TRIGGER);
            }
        }
    }

    public interface e {
        void a();

        void a(Context context, String str, boolean z);

        void a(FrameLayout frameLayout);

        void b();

        void c();

        void d();

        void e();
    }

    public class f extends hd {
        private f() {
        }

        @Override // com.beizi.fusion.hd
        public void a(ASNPLandingPageActivity aSNPLandingPageActivity) {
            super.a(aSNPLandingPageActivity);
            if (aSNPLandingPageActivity != null) {
                aSNPLandingPageActivity.a(sg.this.k);
            }
            b0.a().b().a(this);
        }
    }

    public sg(Context context, LandingOptimizeModel landingOptimizeModel) {
        this.d = context;
        this.e = landingOptimizeModel;
        this.h = xf.a(context, BridgeDSL.INVOKE, false);
    }

    private boolean b(int i) {
        LandingOptimizeModel landingOptimizeModel = this.e;
        return landingOptimizeModel != null && landingOptimizeModel.getAutoOpen() == 1 && this.e.getAutoOpenType() == i;
    }

    public void a(dd ddVar) {
        this.f = ddVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FrameLayout frameLayout) {
        if (TextUtils.isEmpty(this.e.getUrl())) {
            return;
        }
        FrameLayout frameLayout2 = new FrameLayout(this.d);
        this.j = frameLayout2;
        frameLayout2.setBackgroundColor(Color.parseColor("#66000000"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int iA = gn.a.a(this.d, 30.0f);
        this.j.setLayoutParams(layoutParams);
        this.j.setPadding(iA, 0, iA, 0);
        this.j.addView(a(this.e.getUrl()));
        if (this.e.getShowMask() == 1) {
            this.j.setOnClickListener(new b());
        }
        if (frameLayout != null) {
            frameLayout.addView(this.j);
        }
    }

    public void a(dc dcVar, Object obj) {
        if (dcVar instanceof ha) {
            this.g = dcVar;
        }
    }

    public void a() {
        b0.a().b().b(new f());
        this.k = new a();
    }

    public class a implements e {
        public a() {
        }

        @Override // com.beizi.fusion.sg.e
        public void a() {
            sg sgVar = sg.this;
            if (sgVar.l && sgVar.m > 0 && sgVar.e.getAgainOpen() == 1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                sg sgVar2 = sg.this;
                if (jCurrentTimeMillis - sgVar2.m < sgVar2.e.getAgainOpenTime()) {
                    xc xcVar = sg.this.h;
                    if (xcVar instanceof bg) {
                        ((bg) xcVar).b(dd.a.LANDING_PAGE_INTERACTIVE_TRIGGER);
                    }
                }
            }
            sg.this.m = 0L;
        }

        @Override // com.beizi.fusion.sg.e
        public void b() {
            sg sgVar = sg.this;
            if (sgVar.l && sgVar.m <= 0) {
                sgVar.i++;
                LandingOptimizeModel landingOptimizeModel = sgVar.e;
                if (landingOptimizeModel == null || landingOptimizeModel.getRepeatOpen() != 1) {
                    sg.this.b();
                } else {
                    sg sgVar2 = sg.this;
                    if (sgVar2.i >= sgVar2.e.getRepeatOpenCount()) {
                        sg.this.b();
                    }
                }
            }
            sg.this.l = false;
        }

        @Override // com.beizi.fusion.sg.e
        public void c() {
        }

        @Override // com.beizi.fusion.sg.e
        public void d() {
            sg.this.a(2);
        }

        @Override // com.beizi.fusion.sg.e
        public void e() {
            sg sgVar = sg.this;
            if (sgVar.l) {
                sgVar.b();
                sg.this.m = System.currentTimeMillis();
            }
        }

        @Override // com.beizi.fusion.sg.e
        public void a(FrameLayout frameLayout) {
            sg.this.a(frameLayout);
            sg.this.b(frameLayout);
        }

        @Override // com.beizi.fusion.sg.e
        public void a(Context context, String str, boolean z) {
            if (z) {
                sg sgVar = sg.this;
                xc xcVar = sgVar.h;
                if (xcVar instanceof bg) {
                    sgVar.l = true;
                    ((bg) xcVar).a(context, str);
                    return;
                }
                return;
            }
            sg sgVar2 = sg.this;
            xc xcVar2 = sgVar2.h;
            if (xcVar2 instanceof bg) {
                sgVar2.l = true;
                ((bg) xcVar2).a(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FrameLayout frameLayout) {
        this.h.a((Object) null);
        this.h.a(frameLayout, null);
        this.h.a(this.g);
        xc xcVar = this.h;
        if (xcVar instanceof wa) {
            ((wa) xcVar).d().a(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (b(i)) {
            xc xcVar = this.h;
            if (xcVar instanceof bg) {
                this.l = true;
                ((bg) xcVar).b(dd.a.LANDING_PAGE_INTERACTIVE_TRIGGER);
            }
        }
    }

    private ImageView a(String str) {
        ImageView imageView = new ImageView(this.d);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        a(0);
        mf.a(this.d).b(str).a(new c()).a(imageView);
        imageView.setOnClickListener(new d());
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ScopeExpressContainer.d.a(this.j);
    }
}
