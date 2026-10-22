package com.kwad.components.core.e.a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@SuppressLint({"ViewConstructor"})
public final class g extends KSFrameLayout {
    private final d Qa;
    private a Qj;
    private final d Ql;
    private final com.kwad.components.core.widget.a.c fx;
    private final AdTemplate mAdTemplate;
    private Presenter mPresenter;
    private boolean rN;

    public g(@NonNull Context context, AdTemplate adTemplate, d dVar) {
        super(context);
        this.Ql = new d() { // from class: com.kwad.components.core.e.a.g.1
            @Override // com.kwad.components.core.e.a.d
            public final void pt() {
                g.this.eS();
            }
        };
        this.mAdTemplate = adTemplate;
        this.Qa = dVar;
        this.fx = new com.kwad.components.core.widget.a.c(this, 70);
        initMVP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS() {
        if (this.rN) {
            return;
        }
        this.rN = true;
        this.Qa.pt();
    }

    private void initMVP() {
        this.Qj = pA();
        Presenter presenterOnCreatePresenter = onCreatePresenter();
        this.mPresenter = presenterOnCreatePresenter;
        presenterOnCreatePresenter.N(this);
        this.mPresenter.q(this.Qj);
    }

    private static Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new f());
        return presenter;
    }

    private a pA() {
        a aVar = new a();
        aVar.PY = this;
        aVar.mAdTemplate = this.mAdTemplate;
        aVar.PZ = this.fx;
        aVar.Qa = this.Ql;
        return aVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        com.kwad.sdk.core.d.c.d("InstalledActivateView", "onViewAttached");
        this.fx.Aa();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        com.kwad.sdk.core.d.c.d("InstalledActivateView", "onViewDetached");
        this.fx.release();
        this.mPresenter.destroy();
        this.Qj.release();
        eS();
    }
}
