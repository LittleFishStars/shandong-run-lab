package com.byazt.cc;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.aas.pf;
import com.byazt.nr.m;
import com.byazt.nr.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 1748})
public class SplashClickBarArrow extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f28343a;
    public ImageView c;
    public boolean da;
    public RelativeLayout i;
    public ImageView n;
    public int sl;
    public ImageView sp;
    public AnimatorSet t;
    public RelativeLayout tt;
    public ImageView uj;
    public ImageView ve;
    public SplashDiffuseView x;

    @com.byazt.zqa.c(c = {0, 1, 448, 1709})
    public static class c implements Interpolator {
        private c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }
    }

    public SplashClickBarArrow(Context context) {
        super(context);
        this.da = true;
        this.t = new AnimatorSet();
        tt(context);
    }

    public Animator getAnimator() {
        return this.t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            AnimatorSet animatorSet = this.t;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        } catch (Exception e) {
            m.ve(e.getMessage());
        }
    }

    private void tt(Context context) {
        View viewC = c(getContext());
        if (viewC == null) {
            return;
        }
        addView(viewC);
        SplashDiffuseView splashDiffuseView = new SplashDiffuseView(getContext());
        this.x = splashDiffuseView;
        this.f28343a.addView(splashDiffuseView, 0);
        ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.x.setVisibility(4);
    }

    private void ve() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.sp, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.cc.SplashClickBarArrow.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (SplashClickBarArrow.this.da) {
                    SplashClickBarArrow.this.x.c();
                }
                SplashClickBarArrow splashClickBarArrow = SplashClickBarArrow.this;
                splashClickBarArrow.da = !splashClickBarArrow.da;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(SplashClickBarArrow.this.sp, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                SplashClickBarArrow.this.sp.setVisibility(0);
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.sp, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.t.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.t.setStartDelay(1000L);
    }

    public void c(int i) {
        this.sl = i;
        c();
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setClipChildren(false);
        frameLayout.setLayoutParams(layoutParams);
        this.c = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics()));
        this.c.setId(2114387592);
        layoutParams2.gravity = 16;
        z.c(context, "tt_splash_click_bar_go", (View) this.c, 320);
        this.c.setLayoutParams(layoutParams2);
        frameLayout.addView(this.c);
        pf.c((View) this.c, 8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.tt = relativeLayout;
        relativeLayout.setId(2114387591);
        new FrameLayout.LayoutParams(-2, -2).gravity = 16;
        this.tt.setPadding(pf.ve(context, 4.0f), 0, 0, 0);
        frameLayout.addView(this.tt);
        pf.c((View) this.tt, 8);
        ImageView imageView = new ImageView(context);
        this.ve = imageView;
        imageView.setId(2114387590);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.ve.setAlpha(0.0f);
        z.c(context, "tt_splash_arrow", this.ve, 160);
        this.ve.setLayoutParams(layoutParams3);
        this.tt.addView(this.ve);
        ImageView imageView2 = new ImageView(context);
        this.uj = imageView2;
        imageView2.setId(2114387589);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.uj.setAlpha(0.0f);
        z.c(context, "tt_splash_arrow", (View) this.uj, 160);
        this.uj.setLayoutParams(layoutParams4);
        this.tt.addView(this.uj);
        ImageView imageView3 = new ImageView(context);
        this.n = imageView3;
        imageView3.setId(2114387588);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.n.setAlpha(0.0f);
        z.c(context, "tt_splash_arrow", (View) this.n, 160);
        this.n.setLayoutParams(layoutParams5);
        this.tt.addView(this.n);
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics())));
        this.tt.addView(view);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.f28343a = frameLayout2;
        frameLayout2.setId(2114387587);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        this.f28343a.setClipChildren(false);
        this.f28343a.setLayoutParams(layoutParams6);
        frameLayout.addView(this.f28343a);
        pf.c((View) this.f28343a, 8);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.i = relativeLayout2;
        relativeLayout2.setId(2114387586);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -1);
        this.i.setClipChildren(false);
        this.i.setLayoutParams(layoutParams7);
        this.f28343a.addView(this.i);
        ImageView imageView4 = new ImageView(context);
        this.sp = imageView4;
        imageView4.setId(2114387585);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()));
        z.c(context, "tt_splash_hand", this.sp, 320);
        this.sp.setLayoutParams(layoutParams8);
        this.i.addView(this.sp);
        pf.c((View) this.sp, 4);
        return frameLayout;
    }

    private void tt() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.ve, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new c());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.ve, "translationX", 0.0f, pf.ve(getContext(), 20.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.uj, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new c());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.uj, "translationX", pf.ve(getContext(), 23.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.n, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat5.setInterpolator(new c());
        objectAnimatorOfFloat5.setDuration(1300L);
        objectAnimatorOfFloat5.setStartDelay(200L);
        objectAnimatorOfFloat5.setRepeatCount(-1);
        objectAnimatorOfFloat5.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.n, "translationX", pf.ve(getContext(), 25.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat6.setDuration(1300L);
        objectAnimatorOfFloat6.setStartDelay(200L);
        objectAnimatorOfFloat6.setRepeatCount(-1);
        objectAnimatorOfFloat6.setRepeatMode(1);
        this.t.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat5, objectAnimatorOfFloat2, objectAnimatorOfFloat4, objectAnimatorOfFloat6);
    }

    private void c() {
        this.c.setVisibility(8);
        this.tt.setVisibility(8);
        int i = this.sl;
        if (i == 1) {
            this.tt.setVisibility(0);
            tt();
            return;
        }
        if (i == 2) {
            this.f28343a.setVisibility(0);
            post(new Runnable() { // from class: com.byazt.cc.SplashClickBarArrow.1
                @Override // java.lang.Runnable
                public void run() {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SplashClickBarArrow.this.i.getLayoutParams();
                    layoutParams.topMargin = (int) ((SplashClickBarArrow.this.x.getMeasuredHeight() / 2.0f) - pf.ve(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.leftMargin = (int) ((SplashClickBarArrow.this.x.getMeasuredWidth() / 2.0f) - pf.ve(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.bottomMargin = (int) (((-SplashClickBarArrow.this.x.getMeasuredHeight()) / 2.0f) + pf.ve(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.rightMargin = (int) (((-SplashClickBarArrow.this.x.getMeasuredWidth()) / 2.0f) + pf.ve(SplashClickBarArrow.this.getContext(), 5.0f));
                    SplashClickBarArrow.this.i.setLayoutParams(layoutParams);
                }
            });
            ve();
        } else {
            if (i == 3 || i == 4 || i == 5 || i == 7) {
                return;
            }
            this.c.setVisibility(0);
        }
    }
}
