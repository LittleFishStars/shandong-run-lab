package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class m extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.a {
    private TextView IA;
    private TextView Ie;
    private com.kwad.components.ad.splashscreen.d Ij;
    private View Iy;
    private KsRotateView Iz;
    private com.kwad.sdk.core.g.c hv;
    private long mStartTime;

    @Nullable
    private Context mS() {
        Context context;
        View view;
        try {
            context = getContext();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            context = null;
        }
        return (context != null || (view = this.Iy) == null) ? context : view.getContext();
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aw(int i) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        View rootView = getRootView();
        if (rootView == null) {
            return;
        }
        rootView.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.m.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.components.ad.splashscreen.h hVar = m.this.HC;
                if (hVar != null) {
                    hVar.He = SystemClock.elapsedRealtime() - m.this.mStartTime;
                }
            }
        });
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null) {
            hVar.a(this);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void ck() {
        com.kwad.sdk.core.adlog.c.cw(this.HC.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void fY() {
        KsRotateView ksRotateView = this.Iz;
        if (ksRotateView == null) {
            return;
        }
        ksRotateView.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.m.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                m.this.Iz.fY();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_rotate_layout);
        if (viewStub != null) {
            this.Iy = viewStub.inflate();
        } else {
            this.Iy = findViewById(R.id.ksad_rotate_root);
        }
        this.IA = (TextView) findViewById(R.id.ksad_rotate_text);
        this.Ie = (TextView) findViewById(R.id.ksad_rotate_action);
        KsRotateView ksRotateView = (KsRotateView) findViewById(R.id.ksad_rotate_view);
        this.Iz = ksRotateView;
        ksRotateView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void j(int i, String str) {
        TextView textView = this.Ie;
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
        AdTemplate adTemplate = this.HC.mAdTemplate;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        this.Ij = com.kwad.components.ad.splashscreen.d.a(adTemplate, adInfoEO, this.HC.mApkDownloadHelper, 1);
        TextView textView = this.IA;
        if (textView != null) {
            textView.setText(com.kwad.sdk.core.response.helper.b.dR(adInfoEO));
        }
        TextView textView2 = this.Ie;
        if (textView2 != null) {
            textView2.setText("或点击" + this.Ij.lW());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mK() {
        View view = this.Iy;
        if (view == null || this.HC == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.HC.mAdTemplate, 184, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.zA().cl(184);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mL() {
        AdMatrixInfo.RotateInfo rotateInfoDL = com.kwad.sdk.core.response.helper.b.dL(this.HC.mAdTemplate);
        com.kwad.sdk.core.g.c cVar = this.hv;
        if (cVar != null) {
            cVar.b(rotateInfoDL);
            return;
        }
        com.kwad.sdk.core.g.c cVar2 = new com.kwad.sdk.core.g.c(rotateInfoDL);
        this.hv = cVar2;
        cVar2.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mM() {
        com.kwad.sdk.core.g.c cVar = this.hv;
        if (cVar != null) {
            cVar.cb(mS());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mN() {
        com.kwad.sdk.core.g.c cVar = this.hv;
        if (cVar != null) {
            cVar.cc(mS());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void mc() {
        com.kwad.sdk.core.g.c cVar = this.hv;
        if (cVar != null) {
            cVar.cc(mS());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.HC.c(1, mS(), 162, 1);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashRotatePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null) {
            hVar.b(this);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void t(final String str) {
        boolean zAe = this.HC.GP.Ae();
        boolean zPG = com.kwad.components.core.e.c.b.pG();
        if (!zAe || zPG) {
            return;
        }
        this.Iz.oc();
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null) {
            hVar.a(1, mS(), 161, 1, new com.kwad.components.ad.splashscreen.h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.m.3
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.ef(str);
                }
            });
        }
        mP();
        mN();
    }
}
