package com.beizi.fusion;

import android.animation.Animator;
import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class en {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ValueAnimator f27248a;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            en.this.a(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            en.this.b(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            en.this.c(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            en.this.d(animator);
        }
    }

    public en(int i, int i2, long j) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        this.f27248a = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(j);
        a();
    }

    private void a() {
        this.f27248a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.d1b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f41089a.a(valueAnimator);
            }
        });
        this.f27248a.addListener(new a());
    }

    public void a(Animator animator) {
    }

    public void a(ValueAnimator valueAnimator) {
    }

    public void b() {
        ValueAnimator valueAnimator = this.f27248a;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f27248a.pause();
    }

    public void b(Animator animator) {
    }

    public void c() {
        ValueAnimator valueAnimator = this.f27248a;
        if (valueAnimator == null || valueAnimator.isRunning()) {
            return;
        }
        this.f27248a.start();
    }

    public void c(Animator animator) {
    }

    public void d(Animator animator) {
    }

    public void a(int i, int i2) {
        ValueAnimator valueAnimator = this.f27248a;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(i);
            this.f27248a.setRepeatMode(i2);
        }
    }
}
