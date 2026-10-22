package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.sdk.R;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.components.ad.splashscreen.presenter.e implements View.OnClickListener, com.kwad.sdk.widget.d {
    private CloseCountDownView JL;
    private ViewGroup JM;
    private ViewGroup JN;
    private ImageView JO;
    private TextView JP;
    private TextView JQ;
    private SplashEndLandView JR;
    private CloseCountDownView.a JS = new CloseCountDownView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.c.1
        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void eo() {
            com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
            com.kwad.components.ad.splashscreen.monitor.a.mt().ao(c.this.HC.mAdTemplate);
            if (c.this.HC.mTimerHelper != null) {
                c1273a.duration = c.this.HC.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.HC.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().ed(1).b(c1273a).el(6), (JSONObject) null);
            c.this.HC.mo();
        }

        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void mB() {
            com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
            if (c.this.HC.mTimerHelper != null) {
                c1273a.duration = c.this.HC.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.HC.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().ed(14).b(c1273a).el(6), (JSONObject) null);
            c.this.HC.ms();
        }
    };

    private void v(View view) {
        if (view == this.JM) {
            this.HC.c(2, view.getContext(), 104, 3);
            return;
        }
        if (view == this.JN) {
            this.HC.c(2, view.getContext(), 26, 1);
            return;
        }
        if (view == this.JO) {
            this.HC.c(2, view.getContext(), 15, 3);
        } else if (view == this.JP) {
            this.HC.c(2, view.getContext(), 16, 3);
        } else if (view == this.JQ) {
            this.HC.c(2, view.getContext(), 17, 3);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.JR == null) {
            SplashEndLandView splashEndLandView = (SplashEndLandView) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
            this.JR = splashEndLandView;
            this.JL = splashEndLandView.getCloseView();
            this.JM = this.JR.getGiftBoxView();
            this.JN = this.JR.getActionBarView();
            this.JO = this.JR.getAppIcon();
            this.JP = this.JR.getAppName();
            this.JQ = this.JR.getAppDesc();
        }
        this.JL.setOnViewClickListener(this.JS);
        this.JN.setOnClickListener(this);
        new com.kwad.sdk.widget.h(this.JN.getContext(), this.JN, this);
        if (com.kwad.sdk.core.response.helper.b.dM(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate))) {
            this.JM.setOnClickListener(this);
            this.JO.setOnClickListener(this);
            this.JP.setOnClickListener(this);
            this.JQ.setOnClickListener(this);
            new com.kwad.sdk.widget.h(this.JN.getContext(), this.JM, this);
            new com.kwad.sdk.widget.h(this.JN.getContext(), this.JO, this);
            new com.kwad.sdk.widget.h(this.JN.getContext(), this.JP, this);
            new com.kwad.sdk.widget.h(this.JN.getContext(), this.JQ, this);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v(view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        v(view);
    }
}
