package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class s extends b implements com.kwad.components.ad.reward.e.g, com.kwad.components.core.j.a.InterfaceC1214a, y.b {
    private List<com.kwad.components.core.j.c> bT;

    @Nullable
    private com.kwad.components.ad.reward.d sE;
    private ImageView ww;
    private int xA;
    private View xB;
    private FrameLayout xC;
    private Animator xD;
    private Animator xE;
    private Animator xF;
    private AdTemplate xG;
    private boolean xO;
    private View xx;
    private KsLogoView xy;
    private DetailVideoView xz;

    @RewardPreEndCardPresenter.PreEndPageStatus
    private int xw = 1;
    private long xH = 500;
    private long xI = 50;
    private float xJ = 1.2254902f;
    private float xK = 0.80472106f;
    private float xL = 0.0f;
    private boolean xM = false;
    private long showTime = -1;
    private long xN = -1;
    private com.kwad.components.core.video.m kf = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.s.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            s.this.n(j2);
        }
    };
    private com.kwad.sdk.core.webview.d.a.a fl = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.s.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar == null || com.kwad.sdk.core.response.helper.e.b(s.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                s.this.uj.sy.dc();
                return;
            }
            com.kwad.components.core.j.c cVarA = com.kwad.components.ad.reward.g.a((List<com.kwad.components.core.j.c>) s.this.bT, aVar.creativeId);
            if (cVarA != null) {
                s.this.uj.a(cVarA);
            }
        }
    };

    private boolean K(boolean z) {
        int iB = b(je());
        al(iB);
        com.kwad.components.ad.reward.d dVar = this.sE;
        boolean zBc = dVar != null ? dVar.bc() : false;
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "webLoadSuccess: " + zBc);
        if (!zBc) {
            return false;
        }
        int iA = a(je());
        float f = -iB;
        this.xL = f;
        Animator animatorA = a(true, f, iA, true, z);
        this.xD = animatorA;
        animatorA.start();
        Animator animatorJd = jd();
        this.xF = animatorJd;
        animatorJd.start();
        this.xw = 2;
        return true;
    }

    private void L(boolean z) {
        Animator animatorA = a(false, (je() - jf()) + this.xL, a(jf()), false, z);
        this.xE = animatorA;
        animatorA.start();
        com.kwad.sdk.core.local.a.LY();
        com.kwad.sdk.core.local.a.cG(this.xG);
        this.xw = 3;
        com.kwad.components.ad.reward.d dVar = this.sE;
        if (dVar != null) {
            dVar.gG();
        }
    }

    private void al(int i) {
        ViewGroup.LayoutParams layoutParams = this.xx.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = -i;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
            layoutParams3.height = i;
            layoutParams3.bottomMargin = -i;
            this.xx.setLayoutParams(layoutParams3);
        }
    }

    private void f(List<AdTemplate> list) {
        com.kwad.components.ad.reward.d dVar = new com.kwad.components.ad.reward.d(list, this.uj.mReportExtData, this);
        this.sE = dVar;
        this.uj.sE = dVar;
        dVar.setShowLandingPage(com.kwad.sdk.core.response.helper.b.de(this.mAdTemplate));
        this.sE.a(this.fl);
        com.kwad.components.ad.reward.d dVar2 = this.sE;
        FrameLayout frameLayout = this.xC;
        com.kwad.components.ad.reward.g gVar = this.uj;
        dVar2.a(frameLayout, gVar.mRootContainer, this.mAdTemplate, gVar.mApkDownloadHelper, gVar.mScreenOrientation);
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "startPreloadWebView");
        this.sE.a(new com.kwad.components.ad.l.b.InterfaceC1156b() { // from class: com.kwad.components.ad.reward.presenter.s.2
            @Override // com.kwad.components.ad.l.b.InterfaceC1156b
            public final void jg() {
                com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                s.this.uj.th = true;
            }
        });
    }

    private Animator jd() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.xB, "alpha", 255.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        objectAnimatorOfFloat.setDuration(200L);
        return objectAnimatorOfFloat;
    }

    private float je() {
        return com.kwad.sdk.c.a.a.j(getActivity()) / this.xJ;
    }

    private float jf() {
        return com.kwad.sdk.c.a.a.j(getActivity()) / this.xK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j) {
        AdTemplate adTemplate = this.xG;
        if (adTemplate == null || this.xO) {
            return;
        }
        if (this.showTime <= 0) {
            this.showTime = com.kwad.sdk.core.response.helper.b.db(adTemplate);
            this.xN = com.kwad.sdk.core.response.helper.b.da(this.xG) + this.showTime;
        }
        long j2 = this.showTime;
        if (j2 > 0 && !this.xM && j > j2) {
            this.xO = !K(true);
            com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "showError: " + this.xO);
            if (this.xO) {
                return;
            } else {
                this.xM = true;
            }
        }
        boolean z = this.xw == 3;
        long j3 = this.xN;
        if (j3 <= 0 || z || j <= j3) {
            return;
        }
        L(true);
    }

    @Override // com.kwad.components.core.webview.jshandler.y.b
    public final void aa(AdTemplate adTemplate) {
        com.kwad.components.core.j.c cVar = new com.kwad.components.core.j.c(adTemplate, com.kwad.components.core.j.e.AGGREGATION);
        com.kwad.components.ad.reward.g gVar = this.uj;
        if (gVar != null) {
            gVar.b(cVar);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.sz.a(this.kf);
        this.uj.b((com.kwad.components.ad.reward.e.g) this);
        this.uj.a(this);
        this.xA = com.kwad.sdk.c.a.a.M(this.xz);
        com.kwad.sdk.c.a.a.q(this.xz, 49);
        this.xy.bl(this.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void dd() {
        int i;
        if (this.xG == null || (i = this.xw) == 3) {
            return;
        }
        if (i == 1) {
            K(false);
            L(false);
        } else if (i == 2) {
            L(true);
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC1214a
    public final void e(@Nullable List<com.kwad.components.core.j.c> list) {
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
        if (list == null || list.size() == 0) {
            return;
        }
        this.xG = list.get(0).getAdTemplate();
        this.bT = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAdTemplate);
        arrayList.addAll(com.kwad.components.core.j.c.q(list));
        f(arrayList);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.xx = findViewById(R.id.ksad_middle_end_card);
        this.xz = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.xy = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.ww = (ImageView) findViewById(R.id.ksad_blur_video_cover);
        this.xB = findViewById(R.id.ksad_play_web_card_webView);
        this.xC = (FrameLayout) findViewById(R.id.ksad_middle_end_card_webview_container);
    }

    @Override // com.kwad.components.core.j.a.InterfaceC1214a
    public final void onError(int i, String str) {
        com.kwad.sdk.core.d.c.w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    @Override // com.kwad.components.core.j.a.InterfaceC1214a
    public final void onRequestResult(int i) {
        com.kwad.sdk.core.d.c.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.g gVar = this.uj;
        gVar.th = false;
        gVar.sz.b(this.kf);
        this.uj.c(this);
        this.uj.b((com.kwad.components.core.j.a.InterfaceC1214a) this);
        com.kwad.components.ad.reward.d dVar = this.sE;
        if (dVar != null) {
            dVar.oe();
        }
        Animator animator = this.xF;
        if (animator != null) {
            animator.cancel();
        }
        DetailVideoView detailVideoView = this.xz;
        if (detailVideoView != null) {
            com.kwad.sdk.c.a.a.q(detailVideoView, this.xA);
        }
        Animator animator2 = this.xD;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.xF = null;
        this.xD = null;
    }

    private int b(float f) {
        return (int) (f + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_height) + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    private Animator a(boolean z, float f, int i, boolean z2, boolean z3) {
        ValueAnimator valueAnimatorOfFloat;
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f + ", videoTargetHeight: " + i);
        if (z) {
            valueAnimatorOfFloat = ObjectAnimator.ofFloat(this.xx, "translationY", f);
        } else {
            int height = this.xx.getHeight();
            final ViewGroup.LayoutParams layoutParams = this.xx.getLayoutParams();
            valueAnimatorOfFloat = ValueAnimator.ofFloat(height, Math.abs(f));
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.xx.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator objectAnimatorOfFloat = z2 ? ObjectAnimator.ofFloat(this.xy, "alpha", 0.0f, 255.0f) : null;
        final ViewGroup.LayoutParams layoutParams2 = this.ww.getLayoutParams();
        ValueAnimator valueAnimatorA = this.xz.a(this.mAdTemplate, i, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams3 != null) {
                    layoutParams3.height = iIntValue;
                    s.this.ww.setLayoutParams(layoutParams2);
                }
            }
        });
        long j = z3 ? this.xH : this.xI;
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(interpolatorCreate);
        if (objectAnimatorOfFloat != null) {
            if (z3) {
                animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat, valueAnimatorA);
            } else {
                animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat);
            }
        } else if (z3) {
            animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorA);
        } else {
            animatorSet.playTogether(valueAnimatorOfFloat);
        }
        return animatorSet;
    }

    private int a(float f) {
        return (int) (com.kwad.sdk.c.a.a.k(getActivity()) - f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
