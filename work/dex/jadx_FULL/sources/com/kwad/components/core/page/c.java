package com.kwad.components.core.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@SuppressLint({"ViewConstructor"})
public final class c extends d {
    private com.kwad.components.core.page.a.a adB;

    private c(Context context) {
        super(context);
        this.adB = null;
    }

    public static c a(Context context, AdWebViewActivityProxy.a aVar) {
        c cVar = new c(context);
        cVar.c(context, aVar);
        return cVar;
    }

    @Override // com.kwad.components.core.page.d, com.kwad.components.core.n.d
    @NonNull
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.core.page.d.a());
        return presenter;
    }

    public final void setH5AuthListener(com.kwad.components.core.page.a.a aVar) {
        T t = this.abm;
        if (t == 0) {
            this.adB = aVar;
        } else {
            ((com.kwad.components.core.page.d.a.b) t).setH5AuthListener(aVar);
        }
    }

    @Override // com.kwad.components.core.page.d, com.kwad.components.core.n.d
    /* JADX INFO: renamed from: ub, reason: merged with bridge method [inline-methods] */
    public final com.kwad.components.core.page.d.a.b an() {
        com.kwad.components.core.page.d.a.b bVarAn = super.an();
        com.kwad.components.core.page.a.a aVar = this.adB;
        if (aVar != null) {
            bVarAn.setH5AuthListener(aVar);
            this.adB = null;
        }
        return bVarAn;
    }

    @Override // com.kwad.components.core.page.d, com.kwad.components.core.n.d
    public final void a(@NonNull ViewGroup viewGroup) {
        super.a(viewGroup);
        View viewFindViewById = findViewById(R.id.ksad_web_tip_bar);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
    }
}
