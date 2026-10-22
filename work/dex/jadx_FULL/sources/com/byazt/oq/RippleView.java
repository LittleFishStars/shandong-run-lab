package com.byazt.oq;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1435})
public class RippleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28907a;
    public float c;
    public int da;
    public Animator.AnimatorListener i;
    public Paint n;
    public float sp;
    public float tt;
    public ValueAnimator uj;
    public ValueAnimator ve;
    public float x;

    public RippleView(Context context, int i) {
        super(context);
        this.f28907a = 300L;
        this.sp = 0.0f;
        this.da = i;
        c();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.c, this.tt, this.sp, this.n);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c = i / 2.0f;
        this.tt = i2 / 2.0f;
        this.x = (float) (Math.hypot(i, i2) / 2.0d);
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.i = animatorListener;
    }

    public void tt() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.x);
        this.ve = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f28907a);
        this.ve.setInterpolator(new LinearInterpolator());
        this.ve.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.oq.RippleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.sp = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        this.ve.start();
    }

    public void ve() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.x, 0.0f);
        this.uj = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f28907a);
        this.uj.setInterpolator(new LinearInterpolator());
        this.uj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.oq.RippleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.sp = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.i;
        if (animatorListener != null) {
            this.uj.addListener(animatorListener);
        }
        this.uj.start();
    }

    public void c() {
        Paint paint = new Paint(1);
        this.n = paint;
        paint.setStyle(Paint.Style.FILL);
        this.n.setColor(this.da);
    }
}
