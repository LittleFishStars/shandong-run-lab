package com.kwad.components.ad.fullscreen.c.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.o;
import com.kwad.components.core.t.x;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.widget.h;
import com.kwad.sdk.wrapper.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends com.kwad.components.ad.reward.presenter.b implements o, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.d {
    private com.kwad.sdk.core.g.d hu;
    private Vibrator hw;
    private ViewGroup kN;
    private TextView kO;
    private TextView kP;
    private ImageView kQ;
    private FrameLayout kR;
    private ImageView kS;
    private FrameLayout kT;
    private TextView kU;

    @Nullable
    private Animator kV;
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.c.a.f.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            if (f.this.kN != null) {
                f.this.kN.setVisibility(8);
            }
            if (f.this.kT != null) {
                f.this.kT.setVisibility(8);
            }
            if (f.this.hu != null) {
                f.this.hu.cc(f.this.getContext());
            }
            if (f.this.kV != null) {
                f.this.kV.cancel();
                f.this.kV = null;
            }
        }
    };

    private void dy() {
        boolean z;
        final AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) m.a(getContext(), R.layout.ksad_shake_center, adBaseFrameLayout, false);
        this.kN = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.kN.getResources();
        try {
            z = com.kwad.sdk.core.response.helper.a.bl(com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate)) == 8 && this.uj.mScreenOrientation == 0;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        final int dimensionPixelSize = z ? resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_live_shop_marginBottom) : resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_marginBottom);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_marginLeft);
        int dimensionPixelSize3 = z ? resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_title_live_shop_marginBottom) : resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_title_marginBottom);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_height);
        FrameLayout frameLayout = (FrameLayout) m.a(getContext(), R.layout.ksad_shake_tips_title, adBaseFrameLayout, false);
        this.kT = frameLayout;
        this.kU = (TextView) frameLayout.findViewById(R.id.ksad_shake_tips_label);
        this.kT.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize2;
        layoutParams.bottomMargin = dimensionPixelSize3;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.kT, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.kN, layoutParams2);
        com.kwad.sdk.core.adlog.c.b(this.uj.mAdTemplate, 185, (JSONObject) null);
        this.kN.post(new bi() { // from class: com.kwad.components.ad.fullscreen.c.a.f.6
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                int height = adBaseFrameLayout.getHeight();
                f fVar = f.this;
                fVar.kV = fVar.a(dimensionPixelSize2, height - dimensionPixelSize);
                if (f.this.kV != null) {
                    f.this.kV.start();
                }
            }
        });
    }

    private void initView() {
        this.kO = (TextView) this.kN.findViewById(R.id.ksad_shake_center_title);
        this.kP = (TextView) this.kN.findViewById(R.id.ksad_shake_center_sub_title);
        this.kQ = (ImageView) this.kN.findViewById(R.id.ksad_shake_center_icon);
        this.kR = (FrameLayout) this.kN.findViewById(R.id.ksad_shake_center_circle_area);
        this.kS = (ImageView) this.kN.findViewById(R.id.ksad_shake_center_circle_area_bg);
        new h(getContext(), this.kN, this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate);
        if (com.kwad.components.ad.fullscreen.b.a.b(getContext(), this.uj.mAdTemplate)) {
            this.uj.a(this);
            this.uj.b(this.mPlayEndPageListener);
            dy();
            initView();
            a(adInfoEO);
            float fEw = com.kwad.sdk.core.response.helper.b.ew(adInfoEO);
            boolean zEx = com.kwad.sdk.core.response.helper.b.ex(adInfoEO);
            boolean zEy = com.kwad.sdk.core.response.helper.b.ey(adInfoEO);
            com.kwad.sdk.core.g.d dVar = this.hu;
            if (dVar == null) {
                com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(zEx, fEw);
                this.hu = dVar2;
                dVar2.bG(zEy);
                this.hu.a(this);
            } else {
                dVar.m(fEw);
            }
            this.hu.cb(getContext());
            Context context = getContext();
            if (context != null) {
                this.hw = (Vibrator) context.getSystemService("vibrator");
            }
            com.kwad.components.ad.fullscreen.b.a.H(getContext());
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void cj() {
    }

    @Override // com.kwad.components.ad.reward.e.o
    public final int dx() {
        return com.kwad.sdk.c.a.a.h(getContext(), R.dimen.ksad_fullscreen_shake_tips_title_marginBottom) + com.kwad.sdk.c.a.a.h(getContext(), R.dimen.ksad_fullscreen_shake_tips_height);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.kN;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.kN.getParent()).removeView(this.kN);
            }
            this.kN = null;
        }
        by.b(getContext(), this.hw);
        this.hw = null;
        Animator animator = this.kV;
        if (animator != null) {
            animator.cancel();
            this.kV = null;
        }
        this.uj.c(this.mPlayEndPageListener);
    }

    private void a(AdInfo adInfo) {
        String strEB = com.kwad.sdk.core.response.helper.b.eB(adInfo);
        TextView textView = this.kO;
        if (textView != null) {
            textView.setText(strEB);
        }
        TextView textView2 = this.kU;
        if (textView2 != null) {
            textView2.setText(strEB);
        }
        String strA = a(this.uj, adInfo);
        TextView textView3 = this.kP;
        if (textView3 != null) {
            textView3.setText("或点击" + strA);
        }
    }

    private static String a(com.kwad.components.ad.reward.g gVar, AdInfo adInfo) {
        String strED = com.kwad.sdk.core.response.helper.b.eD(adInfo);
        com.kwad.components.core.e.d.d dVar = gVar.mApkDownloadHelper;
        if (!com.kwad.sdk.core.response.helper.a.aL(adInfo) || dVar == null) {
            return strED;
        }
        int iQn = dVar.qn();
        AdMatrixInfo.DownloadTexts downloadTextsEF = com.kwad.sdk.core.response.helper.b.eF(adInfo);
        if (iQn == 8) {
            return downloadTextsEF.installAppLabel;
        }
        if (iQn != 12) {
            return downloadTextsEF.adActionDescription;
        }
        return downloadTextsEF.openAppLabel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(float f, float f2) {
        if (this.kN == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.kN.getResources();
        Animator animatorA = x.a((View) this.kQ, (Interpolator) null, 100L, 16.0f);
        animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.c.a.f.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.kQ.setPivotX(f.this.kQ.getWidth());
                f.this.kQ.setPivotY(f.this.kQ.getHeight());
            }
        });
        float left = this.kN.getLeft() + (this.kN.getWidth() / 2.0f);
        float top = this.kN.getTop() + (this.kN.getHeight() / 2.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.kN, "translationX", f - left);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.kN, "translationY", f2 - top);
        float dimension = resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_height);
        final float dimension2 = resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_icon_size);
        float width = this.kR.getWidth();
        float width2 = this.kQ.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(width, dimension);
        valueAnimatorOfFloat.addUpdateListener(new com.kwad.components.ad.widget.a(this.kS) { // from class: com.kwad.components.ad.fullscreen.c.a.f.8
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float fFloatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) fFloatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(width2, dimension2);
        valueAnimatorOfFloat2.addUpdateListener(new com.kwad.components.ad.widget.a(this.kQ) { // from class: com.kwad.components.ad.fullscreen.c.a.f.9
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float fFloatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) fFloatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        int color = resources.getColor(R.color.ksad_shake_icon_bg_start_color);
        final int color2 = resources.getColor(R.color.ksad_reward_main_color);
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_stroke_size);
        ValueAnimator valueAnimatorOfArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) f.this.kS.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(iIntValue);
                    if (iIntValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    f.this.kS.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setDuration(200L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.kO.setAlpha(fFloatValue);
                    f.this.kP.setAlpha(fFloatValue);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(this.kO.getHeight(), 0.0f);
        valueAnimatorOfFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.kO) { // from class: com.kwad.components.ad.fullscreen.c.a.f.12
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator valueAnimatorOfFloat5 = ValueAnimator.ofFloat(this.kP.getHeight(), 0.0f);
        valueAnimatorOfFloat5.addUpdateListener(new com.kwad.components.ad.widget.a(this.kP) { // from class: com.kwad.components.ad.fullscreen.c.a.f.13
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, valueAnimatorOfFloat, valueAnimatorOfFloat2, valueAnimatorOfArgb, valueAnimatorOfFloat4, valueAnimatorOfFloat5);
        AnimatorSet animatorSet3 = new AnimatorSet();
        final Animator animatorClone = animatorA.clone();
        animatorClone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.c.a.f.2
            private boolean kX = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.kX = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.kX) {
                    return;
                }
                animatorClone.start();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.kQ.setPivotX(dimension2);
                f.this.kQ.setPivotY(dimension2);
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.kT.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    f.this.kT.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.kT.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(animatorClone, duration, ObjectAnimator.ofFloat(this.kU, "alpha", 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(animatorA, animatorA.clone(), animatorA.clone(), valueAnimatorOfFloat3, animatorSet2, animatorSet3);
        return animatorSet;
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(double d) {
        com.kwad.sdk.core.c.b.LW();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z = activity != null && activity.equals(currentActivity);
        if (!com.kwad.components.core.e.c.b.pG() && z) {
            if (this.uj != null) {
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.j(d);
                this.uj.a(1, getContext(), 157, 1, 0L, false, bVar);
            }
            by.a(new bi() { // from class: com.kwad.components.ad.fullscreen.c.a.f.5
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("ShakePresenter", "onShakeEvent openGate2");
                    f.this.hu.NJ();
                }
            }, null, 500L);
            by.a(getContext(), this.hw);
            return;
        }
        by.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.c.a.f.4
            @Override // java.lang.Runnable
            public final void run() {
                f.this.hu.NJ();
            }
        }, null, 500L);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        this.uj.a(1, getContext(), 158, 1);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        if (SlideConvertHelper.a(this.uj.mAdTemplate, f, f2, f3, f4)) {
            this.uj.a(1, getContext(), 158, 1);
        }
    }
}
