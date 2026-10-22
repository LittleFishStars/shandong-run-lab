package com.byazt.oq;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.nr.z;
import com.byazt.or.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 2412})
public class SlideRightView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f28909a;
    public Context c;
    public AnimatorSet i;
    public TextView n;
    public AnimatorSet sp;
    public ImageView tt;
    public ImageView uj;
    public ImageView ve;
    public AnimatorSet x;

    public SlideRightView(Context context) {
        super(context);
        this.f28909a = new AnimatorSet();
        this.sp = new AnimatorSet();
        this.x = new AnimatorSet();
        this.i = new AnimatorSet();
        this.c = context;
        ve();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setGuideText(String str) {
        this.n.setText(str);
    }

    private void uj() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.tt, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.ve, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.ve, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.uj, "alpha", 0.0f, 1.0f);
        this.x.setDuration(300L);
        this.x.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.tt, "translationX", 0.0f, x.c(getContext(), 90.0f));
        objectAnimatorOfFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) x.c(getContext(), 90.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.oq.SlideRightView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.uj.getLayoutParams();
                layoutParams.width = num.intValue();
                SlideRightView.this.uj.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.ve, "translationX", 0.0f, x.c(getContext(), 90.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.i.setDuration(com.igexin.push.config.c.j);
        this.i.playTogether(objectAnimatorOfFloat5, valueAnimatorOfInt, objectAnimatorOfFloat6);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.tt, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.uj, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.ve, "alpha", 1.0f, 0.0f);
        this.sp.setDuration(50L);
        this.sp.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
        this.f28909a.playSequentially(this.x, this.i, this.sp);
    }

    private void ve() {
        ImageView imageView = new ImageView(this.c);
        this.uj = imageView;
        z.c(this.c, "tt_splash_slide_right_bg", (View) imageView, 320);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) x.c(this.c, 30.0f);
        addView(this.uj, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.c);
        this.ve = imageView2;
        z.c(this.c, "tt_splash_slide_right_circle", imageView2, 320);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) x.c(this.c, 50.0f), (int) x.c(this.c, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) x.c(this.c, 30.0f);
        addView(this.ve, layoutParams2);
        ImageView imageView3 = new ImageView(this.c);
        this.tt = imageView3;
        z.c(this.c, "tt_splash_hand2", imageView3, 320);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) x.c(this.c, 80.0f), (int) x.c(this.c, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) x.c(this.c, 30.0f);
        addView(this.tt, layoutParams3);
        TextView textView = new TextView(this.c);
        this.n = textView;
        textView.setTextColor(-1);
        this.n.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.n, layoutParams4);
        post(new Runnable() { // from class: com.byazt.oq.SlideRightView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) SlideRightView.this.tt.getLayoutParams();
                layoutParams5.topMargin = (int) ((SlideRightView.this.ve.getMeasuredHeight() / 2.0f) - x.c(SlideRightView.this.getContext(), 7.0f));
                int iC = (-SlideRightView.this.ve.getMeasuredWidth()) + ((int) x.c(SlideRightView.this.c, 30.0f));
                layoutParams5.leftMargin = iC;
                layoutParams5.setMarginStart(iC);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.tt.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) SlideRightView.this.uj.getLayoutParams();
                layoutParams6.topMargin = (int) ((SlideRightView.this.ve.getMeasuredHeight() / 2.0f) - x.c(SlideRightView.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((SlideRightView.this.ve.getMeasuredWidth() / 2.0f) + ((int) x.c(SlideRightView.this.c, 30.0f)));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.uj.setLayoutParams(layoutParams6);
            }
        });
    }

    public void c() {
        uj();
        this.f28909a.start();
        this.f28909a.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.oq.SlideRightView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideRightView.this.postDelayed(new Runnable() { // from class: com.byazt.oq.SlideRightView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideRightView.this.f28909a.start();
                    }
                }, 200L);
            }
        });
    }

    public void tt() {
        try {
            AnimatorSet animatorSet = this.f28909a;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.x;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.i;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.sp;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }
}
