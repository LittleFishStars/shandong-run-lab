package com.byazt.cc;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.aas.pf;
import com.byazt.nr.z;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 870})
public class SlideUpView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f28341a;
    public ImageView c;
    public AnimatorSet n;
    public AnimatorSet sp;
    public ImageView tt;
    public ImageView uj;
    public ImageView ve;
    public AnimatorSet x;

    public SlideUpView(Context context) {
        super(context);
        tt(context);
    }

    private void tt(Context context) {
        if (context == null) {
            context = gt.getContext();
        }
        View viewC = c(context);
        if (viewC == null) {
            return;
        }
        addView(viewC);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.n;
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setGravity(16);
        relativeLayout.setClipChildren(false);
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        this.ve = imageView;
        imageView.setId(2114387639);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        layoutParams2.addRule(14);
        layoutParams2.addRule(8, 2114387761);
        layoutParams2.bottomMargin = pf.ve(context, -24.0f);
        z.c(context, "tt_splash_slide_up_circle", (View) this.ve, 320);
        this.ve.setAlpha(0.0f);
        this.ve.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.ve);
        ImageView imageView2 = new ImageView(context);
        this.tt = imageView2;
        imageView2.setId(2114387939);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(14);
        layoutParams3.addRule(1, 2114387761);
        layoutParams3.addRule(8, 2114387761);
        z.c(context, "tt_splash_slide_up_bg", (View) this.tt, 320);
        layoutParams3.leftMargin = pf.ve(context, -7.0f);
        this.tt.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.tt);
        ImageView imageView3 = new ImageView(context);
        this.c = imageView3;
        imageView3.setId(2114387644);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 91.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 68.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(14);
        layoutParams4.addRule(1, 2114387761);
        layoutParams4.addRule(8, 2114387761);
        z.c(context, "tt_splash_slide_up_finger", (View) this.c, 320);
        layoutParams4.leftMargin = pf.ve(context, -7.0f);
        layoutParams4.bottomMargin = pf.ve(context, -20.0f);
        this.c.setAlpha(0.0f);
        this.c.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.c);
        ImageView imageView4 = new ImageView(context);
        this.uj = imageView4;
        imageView4.setId(2114387761);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 124.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        z.c(context, "tt_splash_slide_up_arrow", (View) this.uj, 320);
        this.uj.setLayoutParams(layoutParams5);
        relativeLayout.addView(this.uj);
        return relativeLayout;
    }

    public void tt() {
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.sp;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f28341a;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.x;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
    }

    public void c() {
        this.f28341a = new AnimatorSet();
        this.sp = new AnimatorSet();
        this.x = new AnimatorSet();
        this.n = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.c, "translationY", 0.0f, pf.ve(getContext(), -110.0f));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, pf.ve(getContext(), 110.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.cc.SlideUpView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.tt.getLayoutParams();
                layoutParams.height = num.intValue();
                SlideUpView.this.tt.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.tt, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.tt, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.ve, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.ve, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.ve, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.ve, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.ve, "translationY", 0.0f, pf.ve(getContext(), -110.0f));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.f28341a.setDuration(50L);
        this.x.setDuration(com.igexin.push.config.c.j);
        this.sp.setDuration(50L);
        this.f28341a.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.sp.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.x.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.n.playSequentially(this.sp, this.x, this.f28341a);
    }
}
