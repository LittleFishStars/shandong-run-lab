package com.ipd.dsp.internal.t1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class i extends b {
    public final ImageView k;
    public final int l;
    public TextView m;

    public i(Context context, int i) {
        this(context, i, "摇动或点击了解更多");
    }

    @Override // com.ipd.dsp.internal.t1.b
    public void a(String str) {
        if (this.m == null || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        this.m.setText(str);
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
        return 500;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public Animator getAnimator() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        PathInterpolator pathInterpolator = new PathInterpolator(0.33f, 0.0f, 0.36f, 1.0f);
        if (this.l != 1) {
            interactionView.setPivotX(interactionView.getWidth() / 2.0f);
            interactionView.setPivotY(interactionView.getHeight() / 2.0f);
            ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f).setDuration(300L);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, 16.0f).setDuration(100L);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 16.0f, -16.0f).setDuration(200L);
            duration3.setInterpolator(pathInterpolator);
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, -16.0f, 16.0f).setDuration(200L);
            ObjectAnimator duration5 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 16.0f, -16.0f).setDuration(200L);
            duration5.setInterpolator(pathInterpolator);
            animatorSet.playSequentially(duration, duration2, duration3, duration4, duration5, ObjectAnimator.ofFloat(interactionView, Key.ROTATION, -16.0f, 0.0f).setDuration(100L));
            return animatorSet;
        }
        interactionView.setPivotX(interactionView.getWidth());
        interactionView.setPivotY(interactionView.getHeight());
        float fA = s.a(getContext(), 6.0f);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, "translationY", fA).setDuration(100L);
        duration6.setInterpolator(pathInterpolator);
        float f = -fA;
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, "translationY", f).setDuration(200L);
        duration7.setInterpolator(pathInterpolator);
        ObjectAnimator duration8 = ObjectAnimator.ofFloat(interactionView, "translationY", fA).setDuration(200L);
        duration8.setInterpolator(pathInterpolator);
        ObjectAnimator duration9 = ObjectAnimator.ofFloat(interactionView, "translationY", f).setDuration(200L);
        duration9.setInterpolator(pathInterpolator);
        animatorSet.playSequentially(duration6, duration7, duration8, duration9, ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f).setDuration(100L));
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
        this.m.setText(String.format(Locale.getDefault(), "摇动手机或点击\n%s", str));
    }

    public i(Context context, int i, String str) {
        super(context);
        setGravity(17);
        setOrientation(0);
        this.l = i;
        int iA = (int) s.a(context, 18.0f);
        int i2 = iA * 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        ImageView imageView = new ImageView(context);
        this.k = imageView;
        imageView.setLayoutParams(layoutParams);
        if (i == 1) {
            imageView.setImageResource(R.drawable.ipd_ic_shake_hand);
        } else {
            imageView.setImageResource(R.drawable.ipd_ic_shake_phone);
        }
        addView(imageView);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.setMarginStart(iA / 2);
        TextView textView = new TextView(context);
        this.m = textView;
        textView.setLayoutParams(layoutParams2);
        this.m.setTextColor(-1);
        this.m.setTextSize(16.0f);
        this.m.setGravity(17);
        this.m.setText(str);
        addView(this.m);
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void a() {
        super.a();
        this.m = null;
    }
}
