package com.ipd.dsp.internal.t1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class c extends LinearLayout {
    public static final String j = "AV";
    public final ArrayList<View> f;
    public final AtomicBoolean g;
    public Animator h;
    public boolean i;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public final /* synthetic */ void a() {
            c.this.h.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            c.this.c();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View interactionView;
            super.onAnimationEnd(animator);
            if (c.this.i || (interactionView = c.this.getInteractionView()) == null) {
                return;
            }
            interactionView.postDelayed(new Runnable() { // from class: com.zj.adlib.xqa
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45879a.a();
                }
            }, c.this.getAnimationDelayTime());
        }
    }

    public c(@NonNull Context context) {
        super(context);
        this.g = new AtomicBoolean(true);
        this.i = false;
        this.f = new ArrayList<>();
        setOrientation(1);
    }

    public abstract void c();

    public final void d() {
        Animator animator = this.h;
        if (animator != null) {
            animator.cancel();
            this.h = null;
        }
        Animator animator2 = getAnimator();
        this.h = animator2;
        if (animator2 != null) {
            animator2.addListener(new a());
            this.h.start();
        }
    }

    public abstract int getAnimationDelayTime();

    public abstract Animator getAnimator();

    public ArrayList<View> getClickableViews() {
        return this.f;
    }

    public abstract View getInteractionView();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g.getAndSet(false)) {
            com.ipd.dsp.internal.c2.k.a(j, "onViewAttached");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.g.getAndSet(false)) {
            com.ipd.dsp.internal.c2.k.a(j, "onViewDetached");
            Animator animator = this.h;
            if (animator != null) {
                animator.cancel();
            }
        }
    }

    public abstract void setText(String str);

    public void a() {
        this.i = true;
        Animator animator = this.h;
        if (animator != null) {
            animator.cancel();
        }
    }

    public boolean b() {
        return !this.i;
    }
}
