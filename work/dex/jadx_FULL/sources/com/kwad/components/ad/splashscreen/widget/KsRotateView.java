package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KsRotateView extends c {
    private static int LG = 50;
    private static int LH = -12;
    private static int LI = -25;
    private static int LJ = 12;
    private static int LK = 25;

    @DrawableRes
    private int LF;
    private ImageView iF;
    private ImageView qY;

    public KsRotateView(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.LF = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_rotate_phone);
        typedArrayObtainStyledAttributes.recycle();
        ImageView imageView = new ImageView(getContext());
        this.qY = imageView;
        imageView.setImageResource(R.drawable.ksad_ic_rotate_line);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        addView(this.qY, layoutParams);
        this.iF = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.kwad.sdk.c.a.a.a(context, 22.0f);
        layoutParams2.gravity = 1;
        addView(this.iF, layoutParams2);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final Animator fZ() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotX(interactionView.getWidth() / 2.0f);
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, LI).setDuration(500L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(340L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, LI, 0.0f).setDuration(LG);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, LJ).setDuration(LG);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, LJ, 0.0f).setDuration(LG);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, LH).setDuration(LG);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, LH, 0.0f).setDuration(LG);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(500L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, LK).setDuration(500L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(340L);
        animatorSet.playSequentially(duration, objectAnimatorOfFloat, duration2, duration3, duration4, duration5, duration6, objectAnimatorOfFloat2, duration7, objectAnimatorOfFloat3, ObjectAnimator.ofFloat(interactionView, Key.ROTATION, LK, 0.0f).setDuration(LG), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, LH).setDuration(LG), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, LH, 0.0f).setDuration(LG), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, LJ).setDuration(LG), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, LJ, 0.0f).setDuration(LG));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public int getAnimationDelayTime() {
        return 500;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public View getInteractionView() {
        return this.iF;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void oa() {
        this.iF.setImageResource(this.LF);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void ob() {
        getInteractionView().setRotation(0.0f);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
