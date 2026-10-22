package com.kwad.components.ad.reward.presenter.g;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.e;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.h;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.core.webview.d.a.a, d {

    @Nullable
    private ViewGroup Bf;

    @Nullable
    private q Bg;
    private ViewGroup Bh;
    private e Bi;
    private c Bj;

    @Nullable
    private c Bk;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.a.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (a.this.Bj != null) {
                a.this.Bj.lw();
            }
            if (a.this.Bk != null) {
                a.this.Bk.lw();
            }
        }
    };
    private com.kwad.components.ad.reward.l.a.a tj;

    private void e(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_card_native_container || id == R.id.ksad_activity_apk_info_area_native) {
            e(z, 2);
        }
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.d.c.d("LandPageOpenTaskPresenter", "onBind");
        if (g.S(this.uj.mAdTemplate)) {
            com.kwad.components.ad.reward.l.a.a aVarLf = com.kwad.components.ad.reward.l.d.lf();
            this.tj = aVarLf;
            this.uj.tj = aVarLf;
            com.kwad.components.ad.reward.b.gw().a(this.mRewardVerifyListener);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            this.Bf = viewGroup;
            if (viewGroup != null) {
                viewGroup.setClickable(true);
                this.Bf.setVisibility(8);
                new h(this.Bf, this);
                c cVar = new c(this.Bf);
                this.Bk = cVar;
                cVar.a(this);
                this.Bk.c(this.uj.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                q qVar = new q((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.Bf, null, this);
                this.Bg = qVar;
                qVar.a(this.uj.mAdTemplate, adBaseFrameLayout);
            }
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z, int i) {
        e(z, 1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("LandPageOpenTaskPresenter", "onUnbind");
        e eVar = this.Bi;
        if (eVar != null) {
            eVar.ly();
            this.Bi = null;
        }
        c cVar = this.Bk;
        if (cVar != null) {
            cVar.lv();
        }
        com.kwad.components.ad.reward.b.gw().b(this.mRewardVerifyListener);
        this.uj.tj = null;
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!as.VM()) {
            com.kwad.sdk.core.d.c.d("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        if (com.kwad.sdk.core.response.helper.d.eF(this.uj.mAdTemplate).size() == 0) {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.c.a.a.p(kSFrameLayout, com.kwad.sdk.c.a.a.a(getContext(), 136.0f));
        } else {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.c.a.a.p(kSFrameLayout, com.kwad.sdk.c.a.a.a(getContext(), 155.0f));
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.Bh = viewGroup;
        viewGroup.setClickable(true);
        new h(this.Bh, this);
        c cVar = new c(this.Bh);
        this.Bj = cVar;
        cVar.a(this);
        this.Bj.c(this.uj.mAdTemplate, true);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.Bh, null, this);
        this.Bi = eVar;
        eVar.a(this.uj.mAdTemplate, adBaseFrameLayout);
    }

    private void e(boolean z, int i) {
        this.uj.a(1, getContext(), z ? 1 : 153, i);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        e(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        if (SlideConvertHelper.a(this.uj.mAdTemplate, f, f2, f3, f4)) {
            e(view, false);
        }
    }
}
