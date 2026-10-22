package com.kwad.components.ad.reward.presenter.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.e;
import com.kwad.components.ad.reward.n.f;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.h;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.app.a, com.kwad.sdk.core.webview.d.a.a, d {
    private static float Bm = 0.4548105f;

    @Nullable
    private ViewGroup Bf;

    @Nullable
    private q Bg;
    private ViewGroup Bh;
    private e Bi;
    private c Bj;

    @Nullable
    private c Bk;
    private AdInfo mAdInfo;
    private com.kwad.components.ad.reward.l.b.a ti;
    private int Bn = 15;
    private long Bo = -1;
    private boolean Bp = false;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.b.3
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (b.this.Bj != null && g.T(b.this.uj.mAdTemplate)) {
                b.this.Bj.lw();
            }
            if (b.this.Bk != null) {
                b.this.Bk.lw();
            }
        }
    };
    private com.kwad.sdk.core.c.c Bq = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.reward.presenter.g.b.4
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            b.this.Y(false);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            b.this.Y(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(boolean z) {
        com.kwad.components.ad.reward.l.b.a aVar;
        com.kwad.components.ad.reward.l.b.a.a(this.ti, getContext(), this.uj.mAdTemplate);
        if (!this.ti.lm()) {
            if (z) {
                Z(false);
            }
        } else {
            if (!z) {
                this.Bo = System.currentTimeMillis();
                return;
            }
            boolean zKz = kz();
            if (zKz && (aVar = this.ti) != null) {
                aVar.ll();
                com.kwad.components.ad.reward.b.gw().notifyRewardVerify();
                this.uj.sy.onRewardVerify();
            }
            Z(zKz);
        }
    }

    private void Z(boolean z) {
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.Bp + " completed: " + z);
        if (this.Bp) {
            return;
        }
        ae.c(getContext(), z ? "恭喜！任务达标啦，成功获取奖励~" : "哎呀，差一点就达标啦，再试一次~", 0);
        if (z) {
            this.Bp = true;
        }
    }

    private void aa(boolean z) {
        this.uj.a(1, getContext(), z ? 1 : 153, 1);
    }

    private boolean kz() {
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.Bo);
        return this.Bo >= 0 && System.currentTimeMillis() - this.Bo > ((long) (this.Bn * 1000));
    }

    @Override // com.kwad.sdk.app.a
    public final void V(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.helper.a.aE(this.mAdInfo), str)) {
            g gVar = this.uj;
            if (gVar.ti == null || !g.R(gVar.mAdTemplate)) {
                return;
            }
            this.uj.ti.lj();
            com.kwad.sdk.core.c.b.LW();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                return;
            }
            this.Bo = System.currentTimeMillis();
        }
    }

    @Override // com.kwad.sdk.app.a
    public final void W(String str) {
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onBind");
        if (g.R(this.uj.mAdTemplate)) {
            this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate);
            this.Bn = com.kwad.components.ad.reward.a.b.hN();
            com.kwad.sdk.core.c.b.LW();
            com.kwad.sdk.core.c.b.a(this.Bq);
            com.kwad.components.ad.reward.b.gw().a(this.mRewardVerifyListener);
            com.kwad.components.ad.reward.l.b.a aVarLe = com.kwad.components.ad.reward.l.d.le();
            this.ti = aVarLe;
            this.uj.ti = aVarLe;
            com.kwad.components.ad.reward.l.b.a.a(aVarLe, getContext(), this.uj.mAdTemplate);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            this.Bf = viewGroup;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                c cVar = new c(this.Bf);
                this.Bk = cVar;
                cVar.a(this.uj.mApkDownloadHelper);
                this.Bk.a(this);
                this.Bk.c(this.uj.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                q qVar = new q((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.Bf, this.uj.mApkDownloadHelper, this);
                this.Bg = qVar;
                qVar.a(this.uj.mAdTemplate, adBaseFrameLayout);
            }
            com.kwad.sdk.app.b.HO().a(this);
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.b(this.Bq);
        com.kwad.components.ad.reward.b.gw().b(this.mRewardVerifyListener);
        com.kwad.sdk.app.b.HO().b(this);
        e eVar = this.Bi;
        if (eVar != null) {
            eVar.ly();
            this.Bi = null;
        }
        c cVar = this.Bk;
        if (cVar != null) {
            cVar.lv();
        }
        this.uj.ti = null;
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z, int i) {
        this.uj.b(1, getContext(), z ? 1 : 153, 1);
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!as.VM()) {
            com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        int i = R.id.ksad_reward_apk_info_card_native_container;
        ViewGroup viewGroup = (ViewGroup) findViewById(i);
        this.Bh = viewGroup;
        viewGroup.setClickable(true);
        new h(this.Bh, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        final float dimension = getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_height);
        kSFrameLayout.post(new bi() { // from class: com.kwad.components.ad.reward.presenter.g.b.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                kSFrameLayout.getHeight();
            }
        });
        ViewGroup viewGroup2 = (ViewGroup) findViewById(i);
        this.Bh = viewGroup2;
        c cVar = new c(viewGroup2);
        this.Bj = cVar;
        cVar.a(this.uj.mApkDownloadHelper);
        this.Bj.a(this);
        this.Bj.c(this.uj.mAdTemplate, false);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.Bh, this.uj.mApkDownloadHelper, this);
        this.Bi = eVar;
        eVar.a(new f() { // from class: com.kwad.components.ad.reward.presenter.g.b.2
            @Override // com.kwad.components.ad.reward.n.f
            public final void i(String str, int i2) {
                com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + com.kwad.sdk.core.response.helper.e.eO(b.this.uj.mAdTemplate).status);
                b.this.Bj.j(str, i2);
            }
        });
        this.Bi.a(this.uj.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        aa(true);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        if (SlideConvertHelper.a(this.uj.mAdTemplate, f, f2, f3, f4)) {
            aa(false);
        }
    }
}
