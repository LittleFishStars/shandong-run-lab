package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private TextView kA;
    private long kC;
    private m kf = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            b.this.n(j2);
        }
    };
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    private void ds() {
        this.mApkDownloadHelper = this.uj.mApkDownloadHelper;
        this.kC = com.kwad.sdk.core.response.helper.d.eA(this.mAdTemplate);
        this.uj.sz.a(this.kf);
    }

    private void dt() {
        if (this.kA.getVisibility() == 0) {
            return;
        }
        this.kA.setText(com.kwad.sdk.core.response.helper.d.eB(this.mAdTemplate));
        this.kA.setVisibility(0);
        this.kA.setOnClickListener(this);
        this.kA.post(new bi() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                b.this.du();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du() {
        this.uj.E("native_id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j) {
        if (j >= this.kC) {
            dt();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        ds();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.kA) {
            this.uj.a(1, view.getContext(), 40, 1, this.uj.sz.getPlayDuration());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        TextView textView = (TextView) findViewById(R.id.ksad_detail_call_btn);
        this.kA = textView;
        textView.setContentDescription("topBarCallLabel");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.sz.b(this.kf);
        this.kA.setVisibility(8);
    }
}
