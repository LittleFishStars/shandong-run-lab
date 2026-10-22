package com.beizi.fusion;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.beizi.fusion.zp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class zp {

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f28111a;

        public a(View view) {
            this.f28111a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f28111a.clearAnimation();
            this.f28111a.setTranslationX(0.0f);
            this.f28111a.setTranslationY(0.0f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f28111a.setVisibility(0);
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f28112a;

        public b(View view) {
            this.f28112a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            zp.a(this.f28112a);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static void a(final View view, ViewGroup viewGroup, final int i, final long j) {
        if (view == null || viewGroup == null) {
            return;
        }
        if (!a(i) || j <= 0) {
            viewGroup.removeView(view);
            viewGroup.addView(view);
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
            viewGroup.removeView(view);
            viewGroup.addView(view);
            viewGroup.post(new Runnable() { // from class: com.zj.adlib.k6c
                @Override // java.lang.Runnable
                public final void run() {
                    zp.a(view, i, j);
                }
            });
        }
    }

    private static boolean a(int i) {
        return i == 0 || i == 1 || i == 3 || i == 2;
    }

    public static void b(View view, int i, long j) {
        TranslateAnimation translateAnimation;
        if (view == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        if (!a(i) || j <= 0) {
            a(view);
            return;
        }
        float width = view.getWidth();
        float height = view.getHeight();
        if (i == 0) {
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -height);
        } else if (i == 1) {
            translateAnimation = new TranslateAnimation(0.0f, -width, 0.0f, 0.0f);
        } else if (i != 2) {
            translateAnimation = i != 3 ? null : new TranslateAnimation(0.0f, width, 0.0f, 0.0f);
        } else {
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, height);
        }
        if (translateAnimation == null) {
            a(view);
            return;
        }
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new b(view));
        view.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view, int i, long j) {
        TranslateAnimation translateAnimation;
        if (view.getParent() == null) {
            return;
        }
        float width = view.getWidth();
        float height = view.getHeight();
        if (i == 0) {
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, -height, 0.0f);
        } else if (i == 1) {
            translateAnimation = new TranslateAnimation(-width, 0.0f, 0.0f, 0.0f);
        } else if (i != 2) {
            translateAnimation = i != 3 ? null : new TranslateAnimation(width, 0.0f, 0.0f, 0.0f);
        } else {
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, height, 0.0f);
        }
        if (translateAnimation == null) {
            view.setVisibility(0);
            return;
        }
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new a(view));
        view.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        view.clearAnimation();
        view.setVisibility(8);
        ((ViewGroup) view.getParent()).removeView(view);
    }
}
