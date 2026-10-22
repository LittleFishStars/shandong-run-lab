package com.kwad.components.ad.nativead.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends KSFrameLayout {
    private Animator qU;
    private boolean qV;
    private ImageView qW;
    private ImageView qX;
    private ImageView qY;

    public a(@NonNull Context context) {
        this(context, null, 0);
    }

    private void O(@NonNull Context context) {
        View viewA = m.a(context, R.layout.ksad_native_rotate_layout, this, true);
        this.qY = (ImageView) viewA.findViewById(R.id.rotate_line);
        this.qW = (ImageView) viewA.findViewById(R.id.rotate_phone);
        this.qX = (ImageView) viewA.findViewById(R.id.rotate_alpha_phone);
    }

    private Animator fZ() {
        View interactionView = getInteractionView();
        final View alphaView = getAlphaView();
        if (interactionView == null || alphaView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        new AnimatorSet();
        AnimatorSet animatorSet2 = new AnimatorSet();
        AnimatorSet animatorSet3 = new AnimatorSet();
        AnimatorSet animatorSet4 = new AnimatorSet();
        alphaView.setPivotX(0.0f);
        alphaView.setPivotY(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, "rotationY", 0.0f, 30.0f).setDuration(300L);
        ObjectAnimator.ofFloat(alphaView, "alpha", 1.0f, 0.0f).setDuration(10L).setStartDelay(600L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(alphaView, "scaleX", 0.0f, 0.9f).setDuration(300L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(alphaView, "scaleY", 1.0f, 1.0f).setDuration(300L);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, "rotationY", 30.0f, 0.0f).setDuration(300L);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(alphaView, "scaleX", 0.9f, 0.0f).setDuration(300L);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, "rotationY", 0.0f, 0.0f).setDuration(300L);
        ObjectAnimator.ofFloat(alphaView, "alpha", 0.0f, 1.0f).setDuration(10L).setStartDelay(280L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, "rotationY", 0.0f, -30.0f).setDuration(300L);
        ObjectAnimator duration8 = ObjectAnimator.ofFloat(alphaView, "scaleX", 0.03f, 0.9f).setDuration(300L);
        duration8.setStartDelay(300L);
        ObjectAnimator duration9 = ObjectAnimator.ofFloat(interactionView, "rotationY", -30.0f, 0.0f).setDuration(300L);
        ObjectAnimator duration10 = ObjectAnimator.ofFloat(alphaView, "scaleX", 0.9f, 0.0f).setDuration(300L);
        ObjectAnimator duration11 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, 0.0f).setDuration(300L);
        ObjectAnimator duration12 = ObjectAnimator.ofFloat(alphaView, "alpha", 1.0f, 0.0f).setDuration(10L);
        duration12.setStartDelay(600L);
        ObjectAnimator duration13 = ObjectAnimator.ofFloat(interactionView, "rotationX", 0.0f, 30.0f).setDuration(300L);
        ObjectAnimator duration14 = ObjectAnimator.ofFloat(alphaView, "scaleX", -1.0f, -0.95f).setDuration(300L);
        duration14.setStartDelay(300L);
        ObjectAnimator duration15 = ObjectAnimator.ofFloat(alphaView, "scaleY", 0.02f, 0.87f).setDuration(300L);
        duration15.setStartDelay(300L);
        ObjectAnimator.ofFloat(alphaView, "alpha", 0.0f, 1.0f).setDuration(10L);
        duration12.setStartDelay(280L);
        ObjectAnimator duration16 = ObjectAnimator.ofFloat(interactionView, "rotationX", 30.0f, 0.0f).setDuration(300L);
        ObjectAnimator duration17 = ObjectAnimator.ofFloat(alphaView, "scaleX", -0.95f, -1.0f).setDuration(300L);
        ObjectAnimator duration18 = ObjectAnimator.ofFloat(alphaView, "scaleY", 0.87f, 0.02f).setDuration(300L);
        ObjectAnimator duration19 = ObjectAnimator.ofFloat(interactionView, "rotationX", 0.0f, 0.0f).setDuration(300L);
        ObjectAnimator.ofFloat(alphaView, "alpha", 1.0f, 0.0f).setDuration(10L).setStartDelay(600L);
        ObjectAnimator.ofFloat(alphaView, "alpha", 1.0f, 1.0f).setDuration(10L);
        animatorSet.playSequentially(duration, duration4, duration6, duration7, duration9, duration11, duration13, duration16, duration19);
        animatorSet2.playSequentially(duration2, duration5);
        animatorSet3.playSequentially(duration3);
        animatorSet4.playTogether(animatorSet, animatorSet2, animatorSet3);
        final AnimatorSet animatorSet5 = new AnimatorSet();
        animatorSet5.playSequentially(duration8, duration10);
        duration5.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.nativead.e.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                View view = alphaView;
                view.setPivotX(view.getWidth());
                View view2 = alphaView;
                view2.setPivotY(view2.getHeight());
                animatorSet5.start();
            }
        });
        AnimatorSet animatorSet6 = new AnimatorSet();
        animatorSet6.playSequentially(duration15, duration18);
        AnimatorSet animatorSet7 = new AnimatorSet();
        animatorSet7.playSequentially(duration14, duration17);
        final AnimatorSet animatorSet8 = new AnimatorSet();
        animatorSet8.playTogether(animatorSet6, animatorSet7);
        duration10.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.nativead.e.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                View view = alphaView;
                view.setPivotX(view.getWidth() / 2.0f);
                View view2 = alphaView;
                view2.setPivotY(view2.getHeight());
                animatorSet8.start();
            }
        });
        return animatorSet4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getAlphaView() {
        return this.qX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getInteractionView() {
        return this.qW;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
    }

    @MainThread
    public final void fY() {
        Animator animator = this.qU;
        if (animator != null) {
            animator.cancel();
            this.qU = null;
        }
        Animator animatorFZ = fZ();
        this.qU = animatorFZ;
        if (animatorFZ != null) {
            animatorFZ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.nativead.e.a.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (a.this.qV) {
                        return;
                    }
                    a.this.getInteractionView().postDelayed(new bi() { // from class: com.kwad.components.ad.nativead.e.a.1.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            if (a.this.qU != null) {
                                a.this.getAlphaView().setPivotX(0.0f);
                                a.this.getAlphaView().setPivotY(0.0f);
                                a.this.qU.start();
                            }
                        }
                    }, a.this.getAnimationDelayTime());
                }
            });
            this.qU.start();
        }
    }

    public final int getAnimationDelayTime() {
        return 500;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        try {
            getChildCount();
            int i5 = (i3 - i) / 2;
            int i6 = (i4 - i2) / 2;
            int measuredWidth = 0;
            View childAt = getChildAt(0);
            if (childAt instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) childAt;
                frameLayout.getChildCount();
                View childAt2 = frameLayout.getChildAt(0);
                if (childAt2 != null) {
                    measuredWidth = childAt2.getMeasuredWidth();
                    childAt2.getMeasuredHeight();
                }
                int i7 = measuredWidth / 100;
                View childAt3 = frameLayout.getChildAt(1);
                if (childAt3 != null) {
                    childAt3.getMeasuredWidth();
                    childAt3.getMeasuredHeight();
                    int i8 = i7 * 40;
                    childAt3.layout(i5 - i8, i6 - (i7 * 30), i8 + i5, i6 - (i7 * 10));
                }
                View childAt4 = frameLayout.getChildAt(2);
                if (childAt4 != null) {
                    childAt4.getMeasuredWidth();
                    childAt4.getMeasuredHeight();
                    int i9 = i7 * 14;
                    childAt4.layout(i5 - i9, i6 - i9, i9 + i5, (i7 * 30) + i6);
                }
                View childAt5 = frameLayout.getChildAt(3);
                if (childAt5 != null) {
                    childAt5.getMeasuredWidth();
                    childAt5.getMeasuredHeight();
                    int i10 = i7 * 14;
                    childAt5.layout(i5 - i10, i6 - i10, i5 + i10, i6 + (i7 * 30));
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, null, 0);
        this.qV = false;
        O(context);
    }
}
