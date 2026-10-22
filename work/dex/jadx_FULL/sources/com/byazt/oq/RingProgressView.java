package com.byazt.oq;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 2195})
public class RingProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28906a;
    public Context c;
    public ValueAnimator n;
    public boolean sp;
    public Paint tt;
    public float uj;
    public RectF ve;

    public RingProgressView(Context context) {
        super(context);
        this.f28906a = 1500;
        this.c = context;
        Paint paint = new Paint();
        this.tt = paint;
        paint.setAntiAlias(true);
        this.tt.setStyle(Paint.Style.STROKE);
        this.tt.setStrokeWidth(10.0f);
        this.tt.setColor(Color.parseColor("#80FFFFFF"));
        this.ve = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.sp) {
            return;
        }
        canvas.drawArc(this.ve, 270.0f, this.uj, false, this.tt);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.ve.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    public void setDuration(int i) {
        this.f28906a = i;
    }

    public void tt() {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void ve() {
        this.sp = true;
        invalidate();
    }

    public void c() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.n = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f28906a);
        this.n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.oq.RingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RingProgressView.this.uj = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RingProgressView.this.requestLayout();
            }
        });
        this.n.start();
    }
}
