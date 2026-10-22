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
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KsButtonBorderSpreadView extends c {

    @DrawableRes
    private int LA;
    private ImageView Lz;

    public KsButtonBorderSpreadView(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.LA = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_splash_shake_combo_border);
        typedArrayObtainStyledAttributes.recycle();
        this.Lz = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 267.0f), com.kwad.sdk.c.a.a.a(context, 66.0f));
        layoutParams.gravity = 17;
        addView(this.Lz, layoutParams);
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
        animatorSet.playTogether(ObjectAnimator.ofFloat(interactionView, "scaleX", 1.0f, 1.1f).setDuration(1000L), ObjectAnimator.ofFloat(interactionView, "scaleY", 1.0f, 1.4f).setDuration(1000L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 0.0f).setDuration(1000L));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public int getAnimationDelayTime() {
        return 0;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public View getInteractionView() {
        return this.Lz;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void oa() {
        this.Lz.setImageResource(this.LA);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void ob() {
        getInteractionView().setScaleX(1.0f);
        getInteractionView().setScaleY(1.0f);
        getInteractionView().setAlpha(1.0f);
    }

    public KsButtonBorderSpreadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsButtonBorderSpreadView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
