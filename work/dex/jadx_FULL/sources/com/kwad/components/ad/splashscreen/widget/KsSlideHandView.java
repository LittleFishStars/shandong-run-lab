package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KsSlideHandView extends c {
    private ImageView LZ;
    private ImageView Ma;
    private ImageView Mb;
    private ImageView Mc;
    private ImageView Md;
    private ImageView Me;

    public KsSlideHandView(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this.Ma = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 206.0f), com.kwad.sdk.c.a.a.a(context, 120.0f));
        this.Ma.setImageResource(R.drawable.ksad_splash_base_arrows);
        layoutParams.gravity = 17;
        addView(this.Ma, layoutParams);
        this.Md = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 206.0f), com.kwad.sdk.c.a.a.a(context, 120.0f));
        this.Md.setImageResource(R.drawable.ksad_splash_up_highlight_arrow);
        this.Md.setAlpha(0.0f);
        layoutParams2.gravity = 17;
        addView(this.Md, layoutParams2);
        this.Mc = new ImageView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 206.0f), com.kwad.sdk.c.a.a.a(context, 120.0f));
        this.Mc.setImageResource(R.drawable.ksad_splash_right_highlight_arrow);
        this.Mc.setAlpha(0.0f);
        layoutParams3.gravity = 17;
        addView(this.Mc, layoutParams3);
        this.Me = new ImageView(context);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 206.0f), com.kwad.sdk.c.a.a.a(context, 120.0f));
        this.Me.setImageResource(R.drawable.ksad_splash_down_highlight_arrow);
        this.Me.setAlpha(0.0f);
        layoutParams4.gravity = 17;
        addView(this.Me, layoutParams4);
        this.Mb = new ImageView(context);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 206.0f), com.kwad.sdk.c.a.a.a(context, 120.0f));
        this.Mb.setImageResource(R.drawable.ksad_splash_left_highlight_arrow);
        this.Mb.setAlpha(0.0f);
        layoutParams5.gravity = 17;
        addView(this.Mb, layoutParams5);
        this.LZ = new ImageView(context);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(com.kwad.sdk.c.a.a.a(context, 100.0f), com.kwad.sdk.c.a.a.a(context, 162.0f));
        this.LZ.setImageResource(R.drawable.ksad_splash_slide_animation_hand);
        layoutParams6.leftMargin = com.kwad.sdk.c.a.a.a(context, 149.0f);
        layoutParams6.bottomMargin = com.kwad.sdk.c.a.a.a(context, -19.0f);
        layoutParams6.gravity = 83;
        addView(this.LZ, layoutParams6);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final Animator fZ() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.LZ, "alpha", 0.0f, 0.0f).setDuration(50L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.LZ, "alpha", 1.0f, 1.0f).setDuration(100L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.Md, "alpha", 0.0f, 1.0f).setDuration(450L);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(this.LZ, "translationY", com.kwad.sdk.c.a.a.a(getContext(), -73.0f)).setDuration(450L);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(this.Md, "alpha", 1.0f, 1.0f).setDuration(100L);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(this.Md, "alpha", 1.0f, 0.0f).setDuration(450L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(this.LZ, "alpha", 1.0f, 0.0f).setDuration(450L);
        ObjectAnimator duration8 = ObjectAnimator.ofFloat(this.LZ, "translationY", com.kwad.sdk.c.a.a.a(getContext(), 0.0f)).setDuration(50L);
        ObjectAnimator duration9 = ObjectAnimator.ofFloat(this.LZ, "alpha", 0.0f, 1.0f).setDuration(100L);
        ObjectAnimator duration10 = ObjectAnimator.ofFloat(this.LZ, "alpha", 1.0f, 1.0f).setDuration(100L);
        ObjectAnimator duration11 = ObjectAnimator.ofFloat(this.Mc, "alpha", 0.0f, 1.0f).setDuration(450L);
        ObjectAnimator duration12 = ObjectAnimator.ofFloat(this.LZ, "translationX", com.kwad.sdk.c.a.a.a(getContext(), 85.0f)).setDuration(450L);
        ObjectAnimator duration13 = ObjectAnimator.ofFloat(this.Mc, "alpha", 1.0f, 1.0f).setDuration(100L);
        ObjectAnimator duration14 = ObjectAnimator.ofFloat(this.Mc, "alpha", 1.0f, 0.0f).setDuration(450L);
        ObjectAnimator duration15 = ObjectAnimator.ofFloat(this.LZ, "alpha", 1.0f, 0.0f).setDuration(450L);
        ObjectAnimator duration16 = ObjectAnimator.ofFloat(this.LZ, "translationX", com.kwad.sdk.c.a.a.a(getContext(), 0.0f)).setDuration(50L);
        ObjectAnimator duration17 = ObjectAnimator.ofFloat(this.LZ, "alpha", 0.0f, 1.0f).setDuration(100L);
        ObjectAnimator duration18 = ObjectAnimator.ofFloat(this.LZ, "alpha", 1.0f, 1.0f).setDuration(100L);
        ObjectAnimator duration19 = ObjectAnimator.ofFloat(this.Me, "alpha", 0.0f, 1.0f).setDuration(450L);
        ObjectAnimator duration20 = ObjectAnimator.ofFloat(this.LZ, "translationY", com.kwad.sdk.c.a.a.a(getContext(), 60.0f)).setDuration(450L);
        ObjectAnimator duration21 = ObjectAnimator.ofFloat(this.Me, "alpha", 1.0f, 1.0f).setDuration(100L);
        ObjectAnimator duration22 = ObjectAnimator.ofFloat(this.Me, "alpha", 1.0f, 0.0f).setDuration(450L);
        ObjectAnimator duration23 = ObjectAnimator.ofFloat(this.LZ, "alpha", 1.0f, 0.0f).setDuration(450L);
        ObjectAnimator duration24 = ObjectAnimator.ofFloat(this.LZ, "translationY", com.kwad.sdk.c.a.a.a(getContext(), 0.0f)).setDuration(50L);
        ObjectAnimator duration25 = ObjectAnimator.ofFloat(this.LZ, "alpha", 0.0f, 1.0f).setDuration(100L);
        ObjectAnimator duration26 = ObjectAnimator.ofFloat(this.LZ, "alpha", 1.0f, 1.0f).setDuration(100L);
        ObjectAnimator duration27 = ObjectAnimator.ofFloat(this.Mb, "alpha", 0.0f, 1.0f).setDuration(450L);
        ObjectAnimator duration28 = ObjectAnimator.ofFloat(this.LZ, "translationX", com.kwad.sdk.c.a.a.a(getContext(), -120.0f)).setDuration(450L);
        ObjectAnimator duration29 = ObjectAnimator.ofFloat(this.Mb, "alpha", 1.0f, 1.0f).setDuration(100L);
        ObjectAnimator duration30 = ObjectAnimator.ofFloat(this.Mb, "alpha", 1.0f, 0.0f).setDuration(450L);
        ObjectAnimator duration31 = ObjectAnimator.ofFloat(this.LZ, "alpha", 1.0f, 0.0f).setDuration(450L);
        ObjectAnimator duration32 = ObjectAnimator.ofFloat(this.LZ, "translationX", com.kwad.sdk.c.a.a.a(getContext(), 0.0f)).setDuration(50L);
        animatorSet.play(duration2).before(duration3);
        animatorSet.play(duration3).with(duration4).before(duration5).before(duration6);
        animatorSet.play(duration6).with(duration7).before(duration8);
        animatorSet.play(duration8).with(duration).before(duration9).before(duration10).before(duration11);
        animatorSet.play(duration11).with(duration12).before(duration13).before(duration14);
        animatorSet.play(duration14).with(duration15).before(duration16);
        animatorSet.play(duration16).with(duration).before(duration17).before(duration18).before(duration19);
        animatorSet.play(duration19).with(duration20).before(duration21).before(duration22);
        animatorSet.play(duration22).with(duration23).before(duration24);
        animatorSet.play(duration24).with(duration).before(duration25).before(duration26).before(duration27);
        animatorSet.play(duration27).with(duration28).before(duration29).before(duration30);
        animatorSet.play(duration30).with(duration31).before(duration32);
        animatorSet.play(duration32).with(duration);
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public int getAnimationDelayTime() {
        return 0;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public View getInteractionView() {
        return this;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void oa() {
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    public final void ob() {
        this.Ma.setAlpha(0.0f);
        this.Md.setAlpha(0.0f);
        this.Mc.setAlpha(0.0f);
        this.Me.setAlpha(0.0f);
        this.Mb.setAlpha(0.0f);
        this.LZ.setAlpha(0.0f);
    }

    public KsSlideHandView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsSlideHandView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
