package com.kwad.components.ad.splashscreen.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class o extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.d {
    private boolean Hs;
    private TextView ID;
    private KsShakeView IG;
    private ViewGroup IM;
    private com.kwad.components.ad.splashscreen.d Ij;
    private com.kwad.sdk.core.g.d hu;
    private Vibrator hw;
    private long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aw(int i) {
    }

    @Override // com.kwad.sdk.core.g.b
    public final void cj() {
        com.kwad.sdk.core.adlog.c.cw(this.HC.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void fY() {
        this.IG.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.o.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                o.this.IG.od();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        getRootView().post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.o.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                o.this.HC.He = SystemClock.elapsedRealtime() - o.this.mStartTime;
            }
        });
        Context context = getContext();
        if (context != null) {
            this.hw = (Vibrator) context.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_layout);
        if (viewStub != null) {
            this.IM = (ViewGroup) viewStub.inflate();
        } else {
            this.IM = (ViewGroup) findViewById(R.id.ksad_shake_root);
        }
        this.ID = (TextView) this.IM.findViewById(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) this.IM.findViewById(R.id.ksad_shake_view);
        this.IG = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void j(int i, String str) {
        TextView textView = this.ID;
        if (textView != null) {
            if (i == 2) {
                textView.setText(str);
                return;
            }
            textView.setText("或点击" + str);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mJ() {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate);
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        this.Ij = com.kwad.components.ad.splashscreen.d.a(hVar.mAdTemplate, adInfoEO, hVar.mApkDownloadHelper, 2);
        this.Hs = com.kwad.sdk.core.response.helper.d.eD(this.HC.mAdTemplate);
        new com.kwad.sdk.widget.h(this.IG.getContext(), this.IG, this);
        this.HC.a(this);
        TextView textView = this.ID;
        if (textView != null) {
            textView.setText(this.Ij.lW());
        }
        KsShakeView ksShakeView = this.IG;
        if (ksShakeView != null) {
            ksShakeView.aC(this.Ij.lX());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mK() {
        ViewGroup viewGroup = this.IM;
        if (viewGroup == null || this.HC == null) {
            return;
        }
        viewGroup.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.HC.mAdTemplate, 185, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.zA().cl(185);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mL() {
        float fDK = com.kwad.sdk.core.response.helper.b.dK(this.HC.mAdTemplate);
        boolean zDZ = com.kwad.sdk.core.response.helper.b.dZ(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate));
        boolean zEa = com.kwad.sdk.core.response.helper.b.ea(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate));
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.m(fDK);
            return;
        }
        com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(zDZ, fDK);
        this.hu = dVar2;
        dVar2.bG(zEa);
        this.hu.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mM() {
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cb(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mN() {
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cc(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void mc() {
        com.kwad.sdk.core.g.d dVar = this.hu;
        if (dVar != null) {
            dVar.cc(getContext());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        AdTemplate adTemplate;
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.IG) || (hVar = this.HC) == null || (adTemplate = hVar.mAdTemplate) == null || !com.kwad.sdk.core.response.helper.b.es(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            return;
        }
        this.HC.c(1, getContext(), 158, 1);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null) {
            hVar.b(this);
        }
        KsShakeView ksShakeView = this.IG;
        if (ksShakeView != null) {
            ksShakeView.oe();
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(final double d) {
        boolean zPG = com.kwad.components.core.e.c.b.pG();
        if (!this.HC.GP.Ae() || zPG) {
            return;
        }
        this.IG.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.presenter.o.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                o oVar = o.this;
                com.kwad.components.ad.splashscreen.h hVar = oVar.HC;
                if (hVar != null) {
                    hVar.a(1, oVar.getContext(), 157, 1, new com.kwad.components.ad.splashscreen.h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.o.3.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.j(d);
                        }
                    });
                }
                o.this.IG.od();
            }
        });
        by.a(getContext(), this.hw);
        mN();
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onSingleTap: " + view);
        if (com.kwad.sdk.core.response.helper.b.es(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate)) && (hVar = this.HC) != null) {
            hVar.c(1, getContext(), 158, 1);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.Hs);
        if (SlideConvertHelper.a(this.HC.mAdTemplate, f, f2, f3, f4) && (hVar = this.HC) != null) {
            hVar.c(1, view.getContext(), 153, 1);
        }
    }
}
