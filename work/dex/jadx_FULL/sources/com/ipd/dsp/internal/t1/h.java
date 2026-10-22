package com.ipd.dsp.internal.t1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class h extends c {
    public final FrameLayout k;
    public final ImageView l;
    public final int m;
    public final int n;
    public final Paint o;
    public final float p;
    public final int q;
    public final int r;
    public final int s;
    public final float t;
    public final float u;
    public final TextView v;
    public final Path w;
    public final Region x;
    public final float y;

    public h(Context context, int i) {
        super(context);
        this.o = new Paint();
        this.p = s.a(getContext(), 1.0f);
        this.q = Color.parseColor("#4DFFFFFF");
        this.r = Color.parseColor("#66FFFFFF");
        this.s = Color.parseColor("#B3FFFFFF");
        this.t = s.a(getContext(), 1.0f);
        this.u = s.a(getContext(), 10.0f);
        this.w = new Path();
        this.x = new Region();
        float fA = s.a(getContext(), 80.0f);
        this.y = fA;
        this.n = i;
        int iA = (int) s.a(context, 92.0f);
        this.m = iA;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) s.a(context, 30.0f), 0, (int) s.a(context, 50.0f));
        setBackground(new a(fA, s.a(context, 10.0f), s.a(context, 15.0f)));
        FrameLayout frameLayout = new FrameLayout(context);
        this.k = frameLayout;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 1;
        layoutParams.topMargin = (int) s.a(context, 16.0f);
        frameLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        this.l = imageView;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        imageView.setLayoutParams(layoutParams2);
        if (i == 1) {
            imageView.setImageResource(R.drawable.ipd_ic_shake_hand);
        } else {
            imageView.setImageResource(R.drawable.ipd_ic_shake_phone);
        }
        frameLayout.addView(imageView);
        addView(frameLayout);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        layoutParams3.topMargin = (int) s.a(context, 5.0f);
        layoutParams3.bottomMargin = (int) s.a(context, 5.0f);
        textView.setLayoutParams(layoutParams3);
        textView.setTextColor(-1);
        textView.setTextSize(18.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        textView.setText("摇动手机或点击");
        addView(textView);
        TextView textView2 = new TextView(context);
        this.v = textView2;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 1;
        textView2.setLayoutParams(layoutParams4);
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setGravity(17);
        addView(textView2);
        this.f.add(this);
    }

    public final void a(Paint paint, int i) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        paint.setAntiAlias(true);
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
        float f = this.m / 2.0f;
        a(this.o, this.r);
        canvas.drawCircle(this.k.getX() + (this.k.getWidth() / 2.0f), this.k.getY() + (this.k.getHeight() / 2.0f), f, this.o);
        a(this.o, this.q, this.p);
        canvas.drawCircle(this.k.getX() + (this.k.getWidth() / 2.0f), this.k.getY() + (this.k.getHeight() / 2.0f), f, this.o);
        if (this.n == 2) {
            a(this.o, this.s, this.t);
            canvas.drawCircle(this.k.getX() + (this.k.getWidth() / 2.0f), this.k.getY() + (this.k.getHeight() / 2.0f), f - this.u, this.o);
        }
        canvas.clipPath(this.w);
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
        PathInterpolator pathInterpolator = new PathInterpolator(0.33f, 0.0f, 0.36f, 1.0f);
        if (this.n != 1) {
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
        float fA = s.a(getContext(), 8.0f);
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
        return this.l;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        this.w.reset();
        this.w.moveTo(0.0f, this.y);
        Path path = this.w;
        float f2 = this.y;
        path.quadTo(f / 2.0f, -f2, f, f2);
        float f3 = i2;
        this.w.lineTo(f, f3);
        this.w.lineTo(0.0f, f3);
        this.w.close();
        this.x.setPath(this.w, new Region(0, 0, i, i2));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.x.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.t1.c
    public void setText(String str) {
        if (this.v == null || Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        this.v.setText(str);
    }

    public final void a(Paint paint, int i, float f) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f);
        paint.setColor(i);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }
}
