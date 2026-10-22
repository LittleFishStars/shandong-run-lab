package com.kwad.components.ad.feed.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends FrameLayout {
    private int count;
    private Animator iA;
    private Animation iB;
    private Animation iC;
    private ImageView iw;
    private ImageView ix;
    private ImageView iy;
    private Animator iz;

    public d(@NonNull Context context) {
        this(context, null);
    }

    private void B(Context context) {
        com.kwad.sdk.wrapper.m.inflate(context, R.layout.ksad_promote_ad_click, this);
        this.iw = (ImageView) findViewById(R.id.ksad_inside_circle);
        this.ix = (ImageView) findViewById(R.id.ksad_outside_circle);
        this.iy = (ImageView) findViewById(R.id.ksad_hand);
    }

    private void cG() {
        this.iz = d(this.iy);
        this.iA = e(this.iy);
        this.iB = a(this.iw, 0.45f, com.kwad.sdk.c.a.a.a(getContext(), 34.0f));
        this.iC = a(this.ix, 0.5f, com.kwad.sdk.c.a.a.a(getContext(), 50.0f));
        this.iz.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.d.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.this.iw.startAnimation(d.this.iB);
                d.this.ix.startAnimation(d.this.iC);
                d.this.iA.start();
            }
        });
        this.iA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.d.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.f(d.this);
                if (d.this.count >= 5) {
                    return;
                }
                d.this.iz.start();
            }
        });
    }

    public static /* synthetic */ int f(d dVar) {
        int i = dVar.count;
        dVar.count = i + 1;
        return i;
    }

    public final void cE() {
        cG();
        this.iz.start();
    }

    public final void cF() {
        Animator animator = this.iz;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.iA;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animation animation = this.iB;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.iC;
        if (animation2 != null) {
            animation2.cancel();
        }
    }

    private d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private Animation a(final View view, float f, int i) {
        float fA = com.kwad.sdk.c.a.a.a(getContext(), 10.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, 0.0f);
        float f2 = i / fA;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f2, 1.0f, f2, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ad.feed.widget.d.3
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        return animationSet;
    }

    private Animator d(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, 0.0f, -10.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -com.kwad.sdk.c.a.a.a(getContext(), 9.5f));
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -com.kwad.sdk.c.a.a.a(getContext(), 9.5f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        return animatorSet;
    }

    private Animator e(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.ROTATION, -10.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", -com.kwad.sdk.c.a.a.a(getContext(), 9.5f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "translationY", -com.kwad.sdk.c.a.a.a(getContext(), 9.5f), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        return animatorSet;
    }

    private d(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.count = 0;
        B(context);
    }
}
