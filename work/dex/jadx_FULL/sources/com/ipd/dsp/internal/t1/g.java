package com.ipd.dsp.internal.t1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g extends b {
    public static final int m = 50;
    public static final int n = -25;
    public static final int o = 25;
    public static final int p = -12;
    public static final int q = 12;
    public final ImageView k;
    public TextView l;

    public g(Context context) {
        this(context, "扭动手机或点击\n跳转详情页/第三方应用");
    }

    @Override // com.ipd.dsp.internal.t1.b
    public void a(String str) {
        if (this.l == null || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        this.l.setText(str);
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
        interactionView.setPivotX(interactionView.getWidth() / 2.0f);
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        animatorSet.playSequentially(ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, -25.0f).setDuration(500L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f).setDuration(340L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, -25.0f, 0.0f).setDuration(50L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, 12.0f).setDuration(50L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 12.0f, 0.0f).setDuration(50L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, -12.0f).setDuration(50L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, -12.0f, 0.0f).setDuration(50L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f).setDuration(500L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, 25.0f).setDuration(500L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f).setDuration(340L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 25.0f, 0.0f).setDuration(50L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, -12.0f).setDuration(50L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, -12.0f, 0.0f).setDuration(50L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, 12.0f).setDuration(50L), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 12.0f, 0.0f).setDuration(50L));
        return animatorSet;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public View getInteractionView() {
        return this.k;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void setText(String str) {
        if (this.l == null || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        this.l.setText(String.format(Locale.getDefault(), "扭动手机或点击\n%s", str));
    }

    public g(Context context, String str) {
        super(context);
        setGravity(17);
        setOrientation(0);
        int iA = (int) s.a(context, 18.0f);
        int i = iA * 2;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        addView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.ipd_ic_rotate_line);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i, i / 3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        ImageView imageView2 = new ImageView(context);
        this.k = imageView2;
        imageView2.setLayoutParams(layoutParams);
        imageView2.setImageResource(R.drawable.ipd_ic_rotate_phone);
        linearLayout.addView(imageView2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.setMarginStart(iA / 2);
        TextView textView = new TextView(context);
        this.l = textView;
        textView.setLayoutParams(layoutParams2);
        this.l.setTextColor(-1);
        this.l.setTextSize(16.0f);
        this.l.setGravity(17);
        this.l.setText(str);
        addView(this.l);
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void a() {
        super.a();
        this.l = null;
    }
}
