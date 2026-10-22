package com.beizi.fusion;

import android.animation.Animator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class mh implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f27538a;

    public mh(Animator animator) {
        this.f27538a = animator;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f27538a = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Animator animator2 = this.f27538a;
        if (animator2 != null) {
            animator2.start();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
