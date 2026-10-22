package com.byazt.ows;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.nr.z;
import com.byazt.or.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1068, 1069})
public class BottomGradientHintView extends LinearLayout {
    public ImageView c;
    public AnimatorSet tt;

    public BottomGradientHintView(Context context) {
        super(context);
        this.tt = new AnimatorSet();
        c(context);
    }

    private void c(Context context) {
        setLayoutParams(new LinearLayout.LayoutParams(-1, c(context, 80.0f)));
        setOrientation(1);
        setGravity(17);
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, Color.parseColor("#cc000000")}));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText("向上滑动浏览更多");
        textView.setTextSize(14.0f);
        textView.setTextColor(-1);
        ImageView imageView = new ImageView(context);
        this.c = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        z.c(context, "tt_splash_slide_up_10", (View) this.c, 320);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c(context, 8.0f), c(context, 8.0f));
        layoutParams.leftMargin = c(context, 10.0f);
        this.c.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        linearLayout.addView(this.c);
        addView(linearLayout);
    }

    private void ve() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "translationY", 0.0f, x.c(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.tt.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.tt.setDuration(1000L);
        this.tt.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 8) {
            tt();
        }
        super.setVisibility(i);
    }

    public void tt() {
        AnimatorSet animatorSet = this.tt;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.tt.cancel();
    }

    public void c() {
        ve();
    }

    private int c(Context context, float f) {
        return pf.ve(context, f);
    }
}
