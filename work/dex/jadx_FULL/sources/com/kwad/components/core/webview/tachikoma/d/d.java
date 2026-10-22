package com.kwad.components.core.webview.tachikoma.d;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.components.o;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends Presenter {
    private FrameLayout akX;
    private o ald;
    private e asx;
    protected b auC;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        b bVar = (b) SB();
        this.auC = bVar;
        e eVar = bVar.asx;
        this.asx = eVar;
        if (eVar != null) {
            eVar.a(new com.kwad.components.core.webview.tachikoma.f.e() { // from class: com.kwad.components.core.webview.tachikoma.d.d.1
                @Override // com.kwad.components.core.webview.tachikoma.f.e
                public final void hm() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.f.e
                public final void hu() {
                }
            });
        }
        o oVarA = this.auC.auF.a(null);
        this.ald = oVarA;
        if (oVarA == null) {
            this.auC.auE.callbackPageStatus(false, null);
            this.asx.getDialog().dismiss();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view = this.ald.getView();
        view.setLayoutParams(layoutParams);
        this.akX.addView(view);
        this.ald.render();
        this.auC.auE.callbackPageStatus(true, null);
    }

    public final boolean onBackPressed() {
        o oVar = this.ald;
        return oVar != null && oVar.onBackPressed();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.akX = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
