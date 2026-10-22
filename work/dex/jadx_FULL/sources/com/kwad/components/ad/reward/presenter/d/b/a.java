package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private TextView Ah;
    private TextView Ai;

    private void du() {
        g gVar = this.uj;
        com.kwad.sdk.core.adlog.c.b(gVar.mAdTemplate, 17, gVar.mReportExtData);
    }

    private void jY() {
        String strEC = com.kwad.sdk.core.response.helper.d.eC(this.uj.mAdTemplate);
        if (this.uj.mScreenOrientation == 1) {
            this.Ai.setVisibility(8);
            this.Ah.setText(strEC);
            this.Ah.setVisibility(0);
            this.Ah.setOnClickListener(this);
        } else {
            this.Ah.setVisibility(8);
            this.Ai.setText(strEC);
            this.Ai.setVisibility(0);
            this.Ai.setOnClickListener(this);
        }
        du();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jZ() {
        com.kwad.sdk.core.adlog.c.b bVarEc = new com.kwad.sdk.core.adlog.c.b().f(this.uj.mRootContainer.getTouchCoords()).ec(39);
        g gVar = this.uj;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, "native_id", "endTopBar", bVarEc, gVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        this.uj.sy.dc();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void ka() {
        if (this.uj.tb) {
            return;
        }
        jY();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.Ah || view == this.Ai) {
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(view.getContext()).aJ(this.uj.mAdTemplate).b(this.uj.mApkDownloadHelper).as(false).aN(1).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.a.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.jZ();
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Ah = (TextView) findViewById(R.id.ksad_end_left_call_btn);
        this.Ai = (TextView) findViewById(R.id.ksad_end_right_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Ah.setVisibility(8);
        this.Ai.setVisibility(8);
    }
}
