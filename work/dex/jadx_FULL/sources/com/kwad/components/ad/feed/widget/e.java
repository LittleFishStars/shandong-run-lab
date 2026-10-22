package com.kwad.components.ad.feed.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.t.x;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e extends FrameLayout {
    private View iE;
    private ImageView iF;

    @Nullable
    private Animator iG;
    private com.kwad.sdk.widget.d iH;

    public e(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator cH() {
        View view = this.iE;
        if (view == null || this.iF == null || view.getWidth() + this.iE.getHeight() == 0 || this.iF.getWidth() + this.iF.getHeight() == 0) {
            return null;
        }
        Animator animatorCI = cI();
        Animator animatorA = a(this.iF, 100L, 16.0f);
        Animator animatorCJ = cJ();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animatorCI, animatorA, animatorCJ);
        return animatorSet;
    }

    private Animator cI() {
        Animator animatorC = c(this.iE, com.kwad.sdk.c.a.a.a(getContext(), 128.0f));
        Animator animatorC2 = c(this.iF, com.kwad.sdk.c.a.a.a(getContext(), 71.11f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(animatorC, animatorC2);
        return animatorSet;
    }

    private Animator cJ() {
        Animator animatorF = f(this.iE);
        Animator animatorF2 = f(this.iF);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(animatorF, animatorF2);
        return animatorSet;
    }

    private Animator f(final View view) {
        if (view == null) {
            return null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.e.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        return animatorSet;
    }

    private void init(Context context) {
        com.kwad.sdk.wrapper.m.inflate(context, R.layout.ksad_feed_shake, this);
        setClickable(false);
        this.iE = findViewById(R.id.ksad_feed_shake_bg);
        this.iF = (ImageView) findViewById(R.id.ksad_feed_shake_icon);
    }

    public final void setOnViewEventListener(com.kwad.sdk.widget.d dVar) {
        this.iH = dVar;
    }

    private e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private Animator c(final View view, int i) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        float fMin = i / Math.min(view.getHeight(), view.getWidth());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", fMin, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", fMin, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
                view.setClickable(true);
                new com.kwad.sdk.widget.h(view, e.this.iH);
            }
        });
        return animatorSet;
    }

    private e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        init(context);
    }

    @MainThread
    public final void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        Animator animator = this.iG;
        if (animator != null) {
            animator.cancel();
            this.iG = null;
        }
        this.iF.post(new bi() { // from class: com.kwad.components.ad.feed.widget.e.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                e eVar = e.this;
                eVar.iG = eVar.cH();
                if (e.this.iG == null) {
                    animatorListenerAdapter.onAnimationEnd(null);
                } else {
                    e.this.iG.addListener(animatorListenerAdapter);
                    e.this.iG.start();
                }
            }
        });
    }

    private Animator a(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        this.iF.setPivotX(view.getWidth());
        this.iF.setPivotY(view.getHeight());
        Animator animatorA = x.a(view, interpolatorCreate, 100L, 16.0f);
        Animator animatorA2 = x.a(view, interpolatorCreate, 100L, 16.0f);
        Animator animatorA3 = x.a(view, interpolatorCreate, 100L, 16.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animatorA, animatorA2, animatorA3);
        return animatorSet;
    }
}
