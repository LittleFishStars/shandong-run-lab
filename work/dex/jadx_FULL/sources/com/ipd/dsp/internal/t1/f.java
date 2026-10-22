package com.ipd.dsp.internal.t1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f extends c {
    public static final int p = 50;
    public static final int q = -25;
    public static final int r = 25;
    public static final int s = -12;
    public static final int t = 12;
    public final ImageView k;
    public final TextView l;
    public final Path m;
    public final Region n;
    public final float o;

    public f(Context context) {
        super(context);
        this.m = new Path();
        this.n = new Region();
        float fA = s.a(getContext(), 80.0f);
        this.o = fA;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) s.a(context, 30.0f), 0, (int) s.a(context, 48.0f));
        setBackground(new a(fA, s.a(context, 10.0f), s.a(context, 15.0f)));
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, (int) s.a(context, 24.5f));
        layoutParams.gravity = 49;
        layoutParams.topMargin = (int) s.a(context, 24.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.ipd_ic_rotate_line);
        addView(imageView);
        ImageView imageView2 = new ImageView(context);
        this.k = imageView2;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, (int) s.a(context, 63.5f));
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = (int) s.a(context, -2.5f);
        imageView2.setLayoutParams(layoutParams2);
        imageView2.setImageResource(R.drawable.ipd_ic_rotate_phone);
        addView(imageView2);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextColor(-1);
        textView.setTextSize(18.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        textView.setShadowLayer(1.0f, 0.0f, 1.0f, Color.parseColor("#95000000"));
        textView.setText("扭动手机或点击");
        addView(textView);
        TextView textView2 = new TextView(context);
        this.l = textView2;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 1;
        textView2.setLayoutParams(layoutParams4);
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setGravity(17);
        textView2.setShadowLayer(1.0f, 0.0f, 1.0f, Color.parseColor("#95000000"));
        addView(textView2);
        this.f.add(this);
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void c() {
        View interactionView = getInteractionView();
        if (interactionView != null) {
            interactionView.setRotation(0.0f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.clipPath(this.m);
        super.dispatchDraw(canvas);
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

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        this.m.reset();
        this.m.moveTo(0.0f, this.o);
        Path path = this.m;
        float f2 = this.o;
        path.quadTo(f / 2.0f, -f2, f, f2);
        float f3 = i2;
        this.m.lineTo(f, f3);
        this.m.lineTo(0.0f, f3);
        this.m.close();
        this.n.setPath(this.m, new Region(0, 0, i, i2));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void setText(String str) {
        if (this.l == null || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        this.l.setText(str);
    }
}
