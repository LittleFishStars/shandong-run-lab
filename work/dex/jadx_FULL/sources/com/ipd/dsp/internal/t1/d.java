package com.ipd.dsp.internal.t1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class d extends c {
    public final ImageView k;
    public final ImageView l;
    public final TextView m;

    public d(Context context) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int iA = (int) s.a(context, 10.0f);
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        frameLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        this.m = textView;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = iA;
        int i = iA * 3;
        layoutParams2.leftMargin = i;
        layoutParams2.rightMargin = i;
        textView.setBackgroundResource(R.drawable.ipd_bg_ret);
        int i2 = iA * 2;
        textView.setPadding(i2, i2, i2, i2);
        textView.setLayoutParams(layoutParams2);
        textView.setTextColor(-1);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        textView.setText("点击跳转详情页或第三方应用");
        frameLayout.addView(textView);
        ImageView imageView = new ImageView(context);
        this.k = imageView;
        int i3 = iA * 5;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i3, i3);
        layoutParams3.topMargin = i3;
        layoutParams3.leftMargin = i2;
        layoutParams3.bottomMargin = iA * 4;
        layoutParams3.gravity = 1;
        imageView.setLayoutParams(layoutParams3);
        imageView.setImageResource(R.drawable.ipd_ic_pointer);
        frameLayout.addView(imageView);
        ImageView imageView2 = new ImageView(context);
        this.l = imageView2;
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i3, i3);
        layoutParams4.topMargin = i;
        layoutParams4.rightMargin = iA / 2;
        layoutParams4.gravity = 1;
        imageView2.setLayoutParams(layoutParams4);
        imageView2.setImageResource(R.drawable.ipd_ic_ring);
        imageView2.setAlpha(0.8f);
        frameLayout.addView(imageView2);
        addView(frameLayout);
        this.f.add(textView);
        this.f.add(imageView);
        this.f.add(imageView2);
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void c() {
        View interactionView = getInteractionView();
        if (interactionView != null) {
            interactionView.setRotation(0.0f);
        }
    }

    @Override // com.ipd.dsp.internal.t1.c
    public int getAnimationDelayTime() {
        return 200;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public Animator getAnimator() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        animatorSet.playSequentially(ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, -20.0f).setDuration(400L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, -20.0f, 0.0f).setDuration(400L));
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.l, "scaleX", 1.0f, 1.5f).setDuration(800L), ObjectAnimator.ofFloat(this.l, "scaleY", 1.0f, 1.5f).setDuration(800L), ObjectAnimator.ofFloat(this.l, "alpha", 0.8f, 0.6f, 0.0f).setDuration(800L));
        return animatorSet;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public View getInteractionView() {
        return this.k;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void setText(String str) {
        if (this.m == null || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        this.m.setText(String.format(Locale.getDefault(), "点击%s", str));
    }
}
