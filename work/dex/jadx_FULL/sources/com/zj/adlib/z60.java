package com.zj.adlib;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class z60 {

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f46191a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ View f20989a;
        public final /* synthetic */ float b;

        public a(final View val$moveView, final float val$dX, final float val$dY) {
            this.f20989a = val$moveView;
            this.f46191a = val$dX;
            this.b = val$dY;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            Float f = (Float) animation.getAnimatedValue();
            View view = this.f20989a;
            if (view != null) {
                view.setTranslationX(this.f46191a * f.floatValue());
                this.f20989a.setTranslationY(this.b * f.floatValue());
                this.f20989a.setAlpha(1.0f - f.floatValue());
            }
        }
    }

    public class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f46192a;

        public b(final View val$moveView) {
            this.f46192a = val$moveView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            View view = this.f46192a;
            if (view != null) {
                view.setTranslationX(0.0f);
                this.f46192a.setTranslationY(0.0f);
                this.f46192a.setAlpha(1.0f);
                this.f46192a.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    public static PointF a(View view) {
        Point pointB = b(view);
        return new PointF(pointB.x + (view.getWidth() / 2.0f), pointB.y + (view.getHeight() / 2.0f));
    }

    public static Point b(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Point(iArr[0], iArr[1]);
    }

    public static void c(View moveView, View targetView, long duration, Animator.AnimatorListener listener) {
        if (moveView == null || targetView == null) {
            return;
        }
        PointF pointFA = a(moveView);
        PointF pointFA2 = a(targetView);
        float f = pointFA2.x - pointFA.x;
        float f2 = pointFA2.y - pointFA.y;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(duration);
        valueAnimatorOfFloat.addUpdateListener(new a(moveView, f, f2));
        if (listener != null) {
            valueAnimatorOfFloat.addListener(listener);
        } else {
            valueAnimatorOfFloat.addListener(new b(moveView));
        }
        valueAnimatorOfFloat.start();
    }
}
