package com.byazt.oq;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.nr.m;
import com.byazt.or.x;
import com.byazt.sr.uj;
import com.byazt.xc.tt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 870})
public class SlideUpView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f28910a;
    public ImageView c;
    public String da;
    public AnimatorSet i;
    public TextView n;
    public int sl;
    public AnimatorSet sp;
    public ImageView tt;
    public TextView uj;
    public ImageView ve;
    public AnimatorSet x;

    public SlideUpView(Context context) {
        super(context);
        this.f28910a = new AnimatorSet();
        this.sp = new AnimatorSet();
        this.x = new AnimatorSet();
        this.i = new AnimatorSet();
        this.sl = 100;
        c(context);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.f28910a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tt();
    }

    public void setGuideText(String str) {
        TextView textView = this.uj;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.n != null) {
            if (TextUtils.isEmpty(str)) {
                this.n.setText("");
            } else {
                this.n.setText(str);
            }
        }
    }

    public void ve() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.c, "translationY", 0.0f, x.c(getContext(), -this.sl));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) x.c(getContext(), this.sl));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.oq.SlideUpView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SlideUpView.this.ve != null) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.ve.getLayoutParams();
                    layoutParams.height = num.intValue();
                    SlideUpView.this.ve.setLayoutParams(layoutParams);
                }
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.ve, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.ve, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.tt, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.tt, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.tt, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.tt, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.tt, "translationY", 0.0f, x.c(getContext(), -this.sl));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.sp.setDuration(50L);
        this.i.setDuration(com.igexin.push.config.c.j);
        this.x.setDuration(50L);
        this.sp.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.x.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.i.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.f28910a.playSequentially(this.x, this.i, this.sp);
    }

    public void c(Context context) {
        if (context == null) {
            context = uj.getContext();
        }
        if ("5".equals(this.da)) {
            addView(tt.a(context));
            this.sl = (int) (((double) this.sl) * 1.25d);
        } else {
            addView(tt.n(context));
        }
        this.c = (ImageView) findViewById(2097610734);
        this.tt = (ImageView) findViewById(2097610735);
        this.uj = (TextView) findViewById(2097610730);
        this.ve = (ImageView) findViewById(2097610733);
        this.n = (TextView) findViewById(2097610731);
    }

    public void tt() {
        try {
            AnimatorSet animatorSet = this.f28910a;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.x;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.sp;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.i;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            m.ve(e.getMessage());
        }
    }

    public SlideUpView(Context context, String str) {
        super(context);
        this.f28910a = new AnimatorSet();
        this.sp = new AnimatorSet();
        this.x = new AnimatorSet();
        this.i = new AnimatorSet();
        this.sl = 100;
        setClipChildren(false);
        this.da = str;
        c(context);
    }

    public void c() {
        ve();
        this.f28910a.start();
        this.f28910a.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.oq.SlideUpView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() { // from class: com.byazt.oq.SlideUpView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideUpView.this.f28910a.start();
                    }
                }, 200L);
            }
        });
    }
}
