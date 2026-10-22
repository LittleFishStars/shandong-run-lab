package com.beizi.fusion;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class d7 {

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f27171a;

        public a(View view) {
            this.f27171a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            try {
                View view = this.f27171a;
                if (view != null) {
                    view.setVisibility(8);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static void a(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        ObjectAnimator objectAnimatorOfFloat3;
        ObjectAnimator objectAnimator;
        if (view == null) {
            return;
        }
        try {
            i7 = view.getContext().getResources().getDisplayMetrics().widthPixels;
            try {
                i8 = view.getContext().getResources().getDisplayMetrics().heightPixels;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                i8 = 0;
            }
        } catch (Exception e2) {
            e = e2;
            i7 = 0;
        }
        if (i5 == 0) {
            view.setTranslationY(-view.getHeight());
            float f = i3;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", f, f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", -i2, i4);
        } else {
            if (i5 != 1) {
                if (i5 == 2) {
                    float f2 = i7;
                    view.setTranslationX(f2);
                    objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", f2, i3);
                    float f3 = i4;
                    objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", f3, f3);
                } else if (i5 != 3) {
                    objectAnimator = null;
                    objectAnimatorOfFloat3 = null;
                } else {
                    float f4 = i8;
                    view.setTranslationY(f4);
                    float f5 = i3;
                    ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "translationX", f5, f5);
                    objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "translationY", f4, i4);
                    objectAnimator = objectAnimatorOfFloat4;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimator, objectAnimatorOfFloat3);
                animatorSet.setDuration(i6);
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                animatorSet.start();
            }
            float f6 = -i;
            view.setTranslationX(f6);
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", f6, i3);
            float f7 = i4;
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", f7, f7);
        }
        ObjectAnimator objectAnimator2 = objectAnimatorOfFloat;
        objectAnimatorOfFloat3 = objectAnimatorOfFloat2;
        objectAnimator = objectAnimator2;
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(objectAnimator, objectAnimatorOfFloat3);
        animatorSet2.setDuration(i6);
        animatorSet2.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet2.start();
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        TranslateAnimation translateAnimation;
        if (view == null) {
            return;
        }
        try {
            if (view.getVisibility() == 8) {
                return;
            }
            if (i3 == 0) {
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            } else if (i3 == 1) {
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            } else if (i3 != 2) {
                translateAnimation = i3 != 3 ? null : new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 0, i2);
            } else {
                translateAnimation = new TranslateAnimation(1, 0.0f, 0, i, 1, 0.0f, 1, 0.0f);
            }
            translateAnimation.setDuration(i4);
            translateAnimation.setAnimationListener(new a(view));
            view.startAnimation(translateAnimation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
