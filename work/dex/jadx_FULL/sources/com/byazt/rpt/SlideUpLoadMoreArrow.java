package com.byazt.rpt;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.nr.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 311, 2513})
@SuppressLint({"ViewConstructor"})
public class SlideUpLoadMoreArrow extends LinearLayout {
    public final int c;
    public final AnimatorSet tt;

    @com.byazt.zqa.c(c = {0, 1, 311, 2018})
    public static class c implements Interpolator {
        private c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }
    }

    public SlideUpLoadMoreArrow(Context context, int i, boolean z) {
        super(context);
        this.tt = new AnimatorSet();
        if (z) {
            ve();
        }
        this.c = i;
        uj();
    }

    private View c(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setClipChildren(false);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(context);
        z.c(context, "tt_ic_back_light", imageView, 320);
        imageView.setAlpha(0.0f);
        linearLayout.addView(imageView, -1, -2);
        ImageView imageView2 = new ImageView(context);
        z.c(context, "tt_ic_back_light", imageView2, 320);
        imageView2.setAlpha(0.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = pf.ve(context, -8.0f);
        linearLayout.addView(imageView2, layoutParams);
        setClipChildren(false);
        c(imageView, imageView2);
        return linearLayout;
    }

    private void uj() {
        Context context = getContext();
        setOrientation(1);
        setClipChildren(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = pf.ve(context, 80.0f);
        layoutParams.gravity = 1;
        addView(c(getContext()), layoutParams);
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(pf.ve(context, 17.0f));
        }
        textView.setTextSize(2, 12.0f);
        textView.setText("向上滑动浏览更多");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = pf.ve(context, 6.0f);
        layoutParams2.bottomMargin = pf.ve(context, this.c);
        layoutParams2.gravity = 1;
        addView(textView, layoutParams2);
    }

    private void ve() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.parseColor("#DD000000"), 0});
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        setBackground(gradientDrawable);
    }

    public void tt() {
        if (this.tt.isRunning()) {
            this.tt.cancel();
        }
    }

    private void c(View view, View view2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new c());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, pf.ve(getContext(), -5.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new c());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view2, "translationY", pf.ve(getContext(), -6.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        this.tt.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat2, objectAnimatorOfFloat4);
    }

    public void c() {
        if (this.tt.isStarted()) {
            return;
        }
        this.tt.start();
    }
}
