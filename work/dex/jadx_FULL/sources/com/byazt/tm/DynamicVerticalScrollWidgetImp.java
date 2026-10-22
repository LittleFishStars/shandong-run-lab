package com.byazt.tm;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.byazt.aq.x;
import com.ipd.dsp.internal.v1.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 2381})
public class DynamicVerticalScrollWidgetImp extends DynamicBaseWidgetImp implements n {
    public ObjectAnimator c;
    public int gt;
    public Runnable qy;
    public boolean rl;
    public ObjectAnimator tt;

    public DynamicVerticalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.gt = 0;
        this.rl = false;
        this.qy = new Runnable() { // from class: com.byazt.tm.DynamicVerticalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicVerticalScrollWidgetImp.this.i();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        final View childAt;
        final View childAt2 = getChildAt(this.gt);
        int i = this.gt;
        if (i == 0) {
            this.rl = false;
        }
        boolean z = i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.gt + 1)).getChildCount() <= 0;
        if (this.u.da().n().c() || !z) {
            View childAt3 = z ? getChildAt((this.gt + 2) % getChildCount()) : getChildAt((this.gt + 1) % getChildCount());
            this.c = ObjectAnimator.ofFloat(childAt2, "translationY", 0.0f, (-(this.x + getChildAt(this.gt).getHeight())) / 2);
            if (z) {
                this.gt++;
            }
            childAt = childAt3;
        } else {
            this.rl = true;
            childAt = getChildAt(this.gt - 1);
            this.c = ObjectAnimator.ofFloat(childAt2, "translationY", 0.0f, (this.x + getChildAt(this.gt).getHeight()) / 2);
        }
        this.c.setInterpolator(new LinearInterpolator());
        this.c.addListener(new Animator.AnimatorListener() { // from class: com.byazt.tm.DynamicVerticalScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt2.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        if (this.rl) {
            this.tt = ObjectAnimator.ofFloat(childAt, "translationY", (-(this.x + childAt.getHeight())) / 2, 0.0f);
        } else {
            this.tt = ObjectAnimator.ofFloat(childAt, "translationY", (this.x + childAt.getHeight()) / 2, 0.0f);
        }
        this.tt.setInterpolator(new LinearInterpolator());
        this.tt.addListener(new Animator.AnimatorListener() { // from class: com.byazt.tm.DynamicVerticalScrollWidgetImp.3
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
                childAt.setVisibility(0);
            }
        });
        this.c.setDuration(500L);
        this.tt.setDuration(500L);
        this.c.start();
        this.tt.start();
        if (this.rl) {
            this.gt--;
        } else {
            int i2 = this.gt + 1;
            this.gt = i2;
            this.gt = i2 % getChildCount();
        }
        postDelayed(this.qy, 3000L);
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
        postDelayed(this.qy, b.C0923b.f);
    }

    @Override // com.byazt.tm.DynamicBaseWidget, com.byazt.tm.n
    public void tt() {
        removeCallbacks(this.qy);
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
