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
public class KsSlideArrowView extends c {
    private ImageView LW;

    @DrawableRes
    private int LX;
    private int LY;

    public KsSlideArrowView(@NonNull Context context) {
        super(context);
        this.LY = 0;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.LX = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_splash_slide_tag);
        typedArrayObtainStyledAttributes.recycle();
        this.LW = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.LW.setScaleType(ImageView.ScaleType.FIT_XY);
        this.LW.setAlpha(0.0f);
        addView(this.LW, layoutParams);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final Animator fZ() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ObjectAnimator.ofFloat(interactionView, "alpha", 0.0f, 1.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 0.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "alpha", 0.0f, 0.0f).setDuration(200L));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public int getAnimationDelayTime() {
        return this.LY;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public View getInteractionView() {
        return this.LW;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void oa() {
        ImageView imageView = this.LW;
        if (imageView != null) {
            imageView.setImageResource(this.LX);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void ob() {
        getInteractionView().setAlpha(1.0f);
    }

    public void setAnimationDelayTime(int i) {
        this.LY = i;
    }

    public KsSlideArrowView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.LY = 0;
    }

    public KsSlideArrowView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.LY = 0;
    }
}
