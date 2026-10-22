package com.kwad.components.core.s.b;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.proxy.f;
import com.kwad.sdk.R;
import com.kwad.sdk.components.o;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends Presenter {
    private FrameLayout akX;
    private com.kwad.components.core.s.a.b ala;
    private o ald;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.ala = (com.kwad.components.core.s.a.b) SB();
        this.akX = (FrameLayout) findViewById(R.id.ksad_js_container);
        this.ald = this.ala.akR.a(null);
        this.ala.abk.add(new com.kwad.components.core.n.a.a() { // from class: com.kwad.components.core.s.b.b.1
            @Override // com.kwad.components.core.n.a.a
            public final void c(f fVar) {
            }

            @Override // com.kwad.components.core.n.a.a
            public final void d(f fVar) {
            }

            @Override // com.kwad.components.core.n.a.a
            public final void hk() {
            }

            @Override // com.kwad.components.core.n.a.a
            public final void hl() {
                if (b.this.ala.akQ != null) {
                    b.this.ala.akQ.callbackDismiss();
                }
            }
        });
        if (this.ald == null) {
            if (getActivity() != null) {
                getActivity().finish();
            }
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View view = this.ald.getView();
            view.setLayoutParams(layoutParams);
            this.akX.addView(view);
            this.ald.bindActivity(getActivity());
            this.ald.render();
        }
    }

    public final boolean onBackPressed() {
        o oVar = this.ald;
        return oVar != null && oVar.onBackPressed();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
