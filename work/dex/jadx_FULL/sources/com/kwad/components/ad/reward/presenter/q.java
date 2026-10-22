package com.kwad.components.ad.reward.presenter;

import android.view.View;
import com.kwad.components.ad.reward.widget.KsToastView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class q extends b {
    private float wW;
    private r wY;
    private KsToastView xf;
    private Runnable xi;
    private boolean xg = false;
    private boolean xh = false;
    private boolean xj = false;
    private boolean wZ = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.q.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            q.this.xf.setVisibility(8);
        }
    };

    public q(r rVar) {
        this.wY = rVar;
    }

    private synchronized void iU() {
        if (this.wZ) {
            return;
        }
        com.kwad.sdk.core.adlog.c.d(this.uj.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().ee(192).aC(this.uj.sz.getPlayDuration()));
        this.wZ = true;
    }

    private void iZ() {
        this.xi = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.q.3
            @Override // java.lang.Runnable
            public final void run() {
                if (q.this.xj) {
                    return;
                }
                if (q.this.xf != null) {
                    q.this.xf.setVisibility(8);
                }
                com.kwad.components.ad.reward.a.gs().a(PlayableSource.PENDANT_AUTO);
            }
        };
    }

    private void ja() {
        by.b(this.xi);
        this.xi = null;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.xf == null) {
            KsToastView ksToastView = (KsToastView) findViewById(R.id.ksad_toast_view);
            this.xf = ksToastView;
            ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.presenter.q.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.a(q.this, true);
                    q.this.xf.setVisibility(8);
                    com.kwad.components.ad.reward.a.gs().a(PlayableSource.PENDANT_CLICK_AUTO);
                }
            });
        }
        this.uj.b(this.mPlayEndPageListener);
    }

    public final void iX() {
        if (this.xh) {
            return;
        }
        iU();
        this.xh = true;
        this.xf.setVisibility(0);
        this.xf.au(3);
        iZ();
        by.a(this.xi, null, 3000L);
    }

    public final void iY() {
        this.xh = false;
        this.xf.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wW = com.kwad.components.ad.reward.a.b.hR();
        this.xg = com.kwad.components.ad.reward.a.b.hS() && com.kwad.components.ad.reward.a.b.hT();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ja();
        this.uj.c(this.mPlayEndPageListener);
    }

    public static /* synthetic */ boolean a(q qVar, boolean z) {
        qVar.xj = true;
        return true;
    }
}
