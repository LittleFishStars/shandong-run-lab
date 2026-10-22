package com.huachenjie.common.util.anim;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.huachenjie.common.util.anim.AnimationHelper;
import com.zj.adlib.fv5;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class AnimationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f33914a = 0;
    public static final int b = 500;

    public interface OnAnimationEndListener {
        void onAnimationEnd();
    }

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f33915a;

        public a(final View val$view, final int val$visible) {
            this.f33915a = val$view;
            this.K = val$visible;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            this.f33915a.setVisibility(this.K);
        }
    }

    public class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ int K;
        public final /* synthetic */ int L;
        public final /* synthetic */ int M;
        public final /* synthetic */ int N;
        public final /* synthetic */ int O;
        public final /* synthetic */ int P;
        public final /* synthetic */ int Q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f33916a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Activity f8895a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Intent f8896a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Bundle f8897a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Handler f8898a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ImageView f8899a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ OnAnimationEndListener f8900a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Integer f8901a;

        public class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f33917a;

            public a(final long val$removeDelay) {
                this.f33917a = val$removeDelay;
            }

            public static /* synthetic */ void b(Activity activity, int i) {
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                ImageView imageView = (ImageView) viewGroup.findViewWithTag("AnimationHelper#" + i);
                if (imageView != null) {
                    viewGroup.removeView(imageView);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                b bVar = b.this;
                Handler handler = bVar.f8898a;
                final Activity activity = bVar.f8895a;
                final int i = bVar.P;
                handler.postDelayed(new Runnable() { // from class: com.zj.adlib.x60
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnimationHelper.b.a.b(activity, i);
                    }
                }, this.f33917a);
                b bVar2 = b.this;
                if (bVar2.P < bVar2.Q - 1) {
                    return;
                }
                Integer num = bVar2.f8901a;
                if (num == null) {
                    bVar2.f8895a.startActivity(bVar2.f8896a);
                } else if (bVar2.f8897a == null) {
                    bVar2.f8895a.startActivityForResult(bVar2.f8896a, num.intValue());
                } else {
                    bVar2.f8895a.startActivityForResult(bVar2.f8896a, num.intValue(), b.this.f8897a);
                }
                b.this.f8895a.overridePendingTransition(R.anim.fade_in, 0);
                OnAnimationEndListener onAnimationEndListener = b.this.f8900a;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd();
                }
            }
        }

        public b(final ImageView val$imageView, final int val$xCenter, final int val$yCenter, final int val$finalRadius, final int val$w, final int val$h, final long val$durationMills, final Handler val$mH, final Activity val$thisActivity, final int val$finalI, final int val$frames, final Integer val$requestCode, final Intent val$intent, final Bundle val$bundle, final OnAnimationEndListener val$listener) {
            this.f8899a = val$imageView;
            this.K = val$xCenter;
            this.L = val$yCenter;
            this.M = val$finalRadius;
            this.N = val$w;
            this.O = val$h;
            this.f33916a = val$durationMills;
            this.f8898a = val$mH;
            this.f8895a = val$thisActivity;
            this.P = val$finalI;
            this.Q = val$frames;
            this.f8901a = val$requestCode;
            this.f8896a = val$intent;
            this.f8897a = val$bundle;
            this.f8900a = val$listener;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            v.removeOnLayoutChangeListener(this);
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(this.f8899a, this.K, this.L, 0.0f, this.M);
            int i = this.N;
            int i2 = this.O;
            int iSqrt = ((int) Math.sqrt((i * i) + (i2 * i2))) + 1;
            long j = this.f33916a;
            if (j == 500) {
                j = (long) (((((double) this.M) * 1.0d) / ((double) iSqrt)) * 500.0d);
            }
            animatorCreateCircularReveal.setDuration(j);
            animatorCreateCircularReveal.addListener(new a(j * 2));
            animatorCreateCircularReveal.start();
        }
    }

    public static void c(View myView) {
        d(myView, 0.0f, 500L, 4);
    }

    @SuppressLint({"NewApi"})
    public static void d(final View view, float endRadius, long durationMills, final int visible) {
        int left = (view.getLeft() + view.getRight()) / 2;
        int top = (view.getTop() + view.getBottom()) / 2;
        int width = view.getWidth();
        int height = view.getHeight();
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, left, top, (int) (Math.sqrt((width * width) + (height * height)) + 1.0d), endRadius);
        animatorCreateCircularReveal.addListener(new a(view, visible));
        animatorCreateCircularReveal.setDuration(durationMills);
        animatorCreateCircularReveal.start();
    }

    public static void e(View myView, int endVisible) {
        d(myView, 0.0f, 500L, endVisible);
    }

    public static /* synthetic */ void f(View view) {
    }

    public static /* synthetic */ void g(Activity activity, int[] iArr, int i, int i2, int i3, long j, Handler handler, int i4, Integer num, Intent intent, Bundle bundle, OnAnimationEndListener onAnimationEndListener) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        ImageView imageView = new ImageView(activity);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(iArr[i]);
        imageView.setTag("AnimationHelper#" + i);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.v60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnimationHelper.f(view);
            }
        });
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        viewGroup.addView(imageView, width, height);
        int iMax = Math.max(i2, width - i2);
        int iMax2 = Math.max(i3, height - i3);
        imageView.addOnLayoutChangeListener(new b(imageView, i2, i3, ((int) Math.sqrt((iMax * iMax) + (iMax2 * iMax2))) + 1, width, height, j, handler, activity, i, i4, num, intent, bundle, onAnimationEndListener));
    }

    public static void h(View myView) {
        i(myView, 0.0f, 500L);
    }

    @SuppressLint({"NewApi"})
    public static void i(View view, float startRadius, long durationMills) {
        int left = (view.getLeft() + view.getRight()) / 2;
        int top = (view.getTop() + view.getBottom()) / 2;
        int width = view.getWidth();
        int height = view.getHeight();
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, left, top, startRadius, (int) (Math.sqrt((width * width) + (height * height)) + 1.0d));
        view.setVisibility(0);
        animatorCreateCircularReveal.setDuration(durationMills);
        animatorCreateCircularReveal.start();
    }

    @SuppressLint({"NewApi"})
    public static void startActivityForResult(final Activity thisActivity, final Intent intent, final Integer requestCode, final Bundle bundle, final View view, final int[] colorOrImageRes, final long durationMills, long frameBeginInterval, final OnAnimationEndListener listener) {
        if (colorOrImageRes == null || colorOrImageRes.length == 0) {
            fv5.b("动画颜色不能为空");
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = iArr[0] + (view.getWidth() / 2);
        final int height = iArr[1] + (view.getHeight() / 2);
        Handler handler = new Handler(Looper.getMainLooper());
        int i = 0;
        for (int length = colorOrImageRes.length; i < length; length = length) {
            final int i2 = i;
            final int i3 = width;
            final Handler handler2 = handler;
            final int i4 = length;
            int i5 = width;
            int i6 = i;
            Handler handler3 = handler;
            handler3.postDelayed(new Runnable() { // from class: com.zj.adlib.w60
                @Override // java.lang.Runnable
                public final void run() {
                    AnimationHelper.g(thisActivity, colorOrImageRes, i2, i3, height, durationMills, handler2, i4, requestCode, intent, bundle, listener);
                }
            }, ((long) i6) * frameBeginInterval);
            i = i6 + 1;
            handler = handler3;
            width = i5;
        }
    }
}
