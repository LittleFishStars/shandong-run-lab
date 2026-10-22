package com.byazt.tm;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.byazt.aq.x;
import com.ipd.dsp.internal.v1.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 2062})
public class DynamicBaseScrollWidgetImp extends DynamicBaseWidgetImp implements n {
    public ObjectAnimator c;
    public int gt;
    public Runnable rl;
    public ObjectAnimator tt;

    public DynamicBaseScrollWidgetImp(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.gt = 0;
        this.rl = new Runnable() { // from class: com.byazt.tm.DynamicBaseScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseScrollWidgetImp.this.i();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        final View childAt = getChildAt(this.gt);
        final View childAt2 = getChildAt((this.gt + 1) % getChildCount());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(this.x + getChildAt(this.gt).getHeight())) / 2);
        this.c = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.c.addListener(new Animator.AnimatorListener() { // from class: com.byazt.tm.DynamicBaseScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(childAt2, "translationY", (this.x + childAt2.getHeight()) / 2, 0.0f);
        this.tt = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        this.tt.addListener(new Animator.AnimatorListener() { // from class: com.byazt.tm.DynamicBaseScrollWidgetImp.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt2.setVisibility(0);
            }
        });
        this.c.setDuration(500L);
        this.tt.setDuration(500L);
        this.c.start();
        this.tt.start();
        int i = this.gt + 1;
        this.gt = i;
        this.gt = i % getChildCount();
        postDelayed(this.rl, 2000L);
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.x - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.rl, b.C0923b.f);
    }

    @Override // com.byazt.tm.DynamicBaseWidget, com.byazt.tm.n
    public void tt() {
        removeCallbacks(this.rl);
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.c.cancel();
        }
        ObjectAnimator objectAnimator2 = this.tt;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.tt.cancel();
        }
        super.tt();
    }
}
