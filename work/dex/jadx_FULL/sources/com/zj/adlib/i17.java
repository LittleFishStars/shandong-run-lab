package com.zj.adlib;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.internal.PaintDrawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class i17 extends PaintDrawable implements Animatable, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueAnimator f42254a;
    public int K = 0;
    public int L = 0;
    public int M = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Path f17109a = new Path();

    public i17() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(30, 3600);
        this.f42254a = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(10000L);
        this.f42254a.setInterpolator(null);
        this.f42254a.setRepeatCount(-1);
        this.f42254a.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        float f = iWidth;
        float fMax = Math.max(1.0f, f / 22.0f);
        if (this.K != iWidth || this.L != iHeight) {
            this.f17109a.reset();
            float f2 = f - fMax;
            float f3 = iHeight / 2.0f;
            this.f17109a.addCircle(f2, f3, fMax, Path.Direction.CW);
            float f4 = f - (5.0f * fMax);
            this.f17109a.addRect(f4, f3 - fMax, f2, f3 + fMax, Path.Direction.CW);
            this.f17109a.addCircle(f4, f3, fMax, Path.Direction.CW);
            this.K = iWidth;
            this.L = iHeight;
        }
        canvas.save();
        float f5 = f / 2.0f;
        float f6 = iHeight / 2.0f;
        canvas.rotate(this.M, f5, f6);
        for (int i = 0; i < 12; i++) {
            ((PaintDrawable) this).f40422a.setAlpha((i + 5) * 17);
            canvas.rotate(30.0f, f5, f6);
            canvas.drawPath(this.f17109a, ((PaintDrawable) this).f40422a);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f42254a.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.M = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f42254a.isRunning()) {
            return;
        }
        this.f42254a.addUpdateListener(this);
        this.f42254a.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f42254a.isRunning()) {
            this.f42254a.removeAllListeners();
            this.f42254a.removeAllUpdateListeners();
            this.f42254a.cancel();
        }
    }
}
