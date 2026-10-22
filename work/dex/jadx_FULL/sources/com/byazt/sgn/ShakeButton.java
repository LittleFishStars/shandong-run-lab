package com.byazt.sgn;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 2162})
public class ShakeButton extends Button {
    public ValueAnimator c;

    public ShakeButton(Context context) {
        super(context);
    }

    private void c() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.c.removeAllListeners();
            this.c.removeAllUpdateListeners();
            this.c = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.c = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1300L);
        this.c.setInterpolator(new LinearInterpolator());
        this.c.setRepeatCount(-1);
        this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.sgn.ShakeButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float animatedFraction = valueAnimator2.getAnimatedFraction();
                ShakeButton.this.setRotation((float) (((double) ((1.0f - animatedFraction) * 6.0f)) * Math.cos(((double) (animatedFraction * 10.0f)) * 3.141592653589793d)));
            }
        });
        this.c.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.sgn.ShakeButton.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationEnd(animator);
                ShakeButton.this.setRotation(6.0f);
            }
        });
        this.c.start();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.c.removeAllListeners();
            this.c.removeAllUpdateListeners();
            this.c = null;
        }
    }
}
