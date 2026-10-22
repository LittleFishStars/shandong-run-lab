package com.kwad.components.ad.fullscreen.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private TextView kA;
    private String kB;
    private long kC;
    private m kf = new m() { // from class: com.kwad.components.ad.fullscreen.c.a.b.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            b.this.n(j2);
        }
    };
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    private void ds() {
        this.kC = com.kwad.sdk.core.response.helper.d.eA(this.mAdTemplate);
        String strEB = com.kwad.sdk.core.response.helper.d.eB(this.mAdTemplate);
        this.kB = strEB;
        if (TextUtils.isEmpty(strEB)) {
            return;
        }
        g gVar = this.uj;
        this.mApkDownloadHelper = gVar.mApkDownloadHelper;
        gVar.sz.a(this.kf);
    }

    private void dt() {
        if (this.kA.getVisibility() == 0) {
            return;
        }
        this.kA.setText(com.kwad.sdk.core.response.helper.d.eB(this.mAdTemplate));
        this.kA.setVisibility(0);
        this.kA.setOnClickListener(this);
        du();
    }

    private void du() {
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 18, this.uj.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j) {
        if (j >= this.kC) {
            dt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(this.uj.mRootContainer.getTouchCoords()).ec(40), this.uj.mReportExtData);
        this.uj.sy.dc();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        ds();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.kA) {
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(view.getContext()).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).aM(40).aL(1).as(false).ap(this.uj.gU()).aN(1).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.fullscreen.c.a.b.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    b.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kA = (TextView) findViewById(R.id.ksad_detail_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.kA = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (TextUtils.isEmpty(this.kB)) {
            return;
        }
        this.uj.sz.b(this.kf);
    }
}
