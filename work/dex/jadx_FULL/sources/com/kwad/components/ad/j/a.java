package com.kwad.components.ad.j;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private View CR;
    private Button CS;
    private Button CU;
    private View Ia;
    private Runnable Ng;
    private boolean Nh = false;

    @Nullable
    private Animator kV;

    public a(View view) {
        this.Ia = view;
        initView();
    }

    private static Animator d(View view, long j) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(j);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return objectAnimatorOfFloat;
    }

    private void initView() {
        this.CS = (Button) this.Ia.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.CU = (Button) this.Ia.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.CR = this.Ia.findViewById(R.id.ksad_reward_apk_info_install_container);
    }

    public final void jq() {
        com.kwad.sdk.core.d.c.d("ApkInstallAnimHelper", "startAnimation");
        int height = this.CR.getHeight();
        int width = this.CR.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.kV == null) {
            Animator animatorA = a(this.CU, this.CS, width, height, 1600L, 200L);
            this.kV = animatorA;
            animatorA.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.j.a.1
                @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(final Animator animator) {
                    if (a.this.Nh) {
                        return;
                    }
                    if (a.this.Ng == null) {
                        a.this.Ng = new Runnable() { // from class: com.kwad.components.ad.j.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                animator.start();
                            }
                        };
                    }
                    by.a(a.this.Ng, null, 1600L);
                }
            });
        }
        com.kwad.sdk.core.d.c.d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.kV.isStarted());
        if (!this.kV.isStarted()) {
            com.kwad.sdk.core.d.c.d("ApkInstallAnimHelper", "mAnimator.start()");
            this.kV.start();
        }
        this.Nh = false;
    }

    public final void lv() {
        ok();
    }

    public final void ok() {
        Animator animator = this.kV;
        if (animator != null) {
            animator.cancel();
            this.kV.removeAllListeners();
            this.Nh = true;
        }
        Runnable runnable = this.Ng;
        if (runnable != null) {
            by.b(runnable);
            this.Ng = null;
        }
    }

    public final void ol() {
        this.Nh = true;
    }

    private static Animator a(final View view, View view2, int i, int i2, long j, long j2) {
        Animator animatorD = d(view, 200L);
        float f = i;
        float f2 = i2;
        Animator animatorA = a(view2, f, f2, 200L);
        animatorA.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.j.a.2
            @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(1600L);
        Animator animatorD2 = d(view2, 200L);
        Animator animatorA2 = a(view, f, f2, 200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animatorD, animatorA, objectAnimatorOfFloat, animatorD2, animatorA2);
        return animatorSet;
    }

    private static Animator a(final View view, float f, final float f2, long j) {
        final float f3 = f / f2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, f2);
        valueAnimatorOfFloat.setDuration(j);
        valueAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view.getResources().getDimension(R.dimen.ksad_reward_apk_info_card_actionbar_text_size);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.j.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f4 = f3 * fFloatValue;
                float f5 = f2;
                if (f5 != 0.0f) {
                    float f6 = (fFloatValue / f5) * dimension;
                    View view2 = view;
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setTextSize(0, f6);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) fFloatValue;
                    layoutParams.width = (int) f4;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return valueAnimatorOfFloat;
    }
}
