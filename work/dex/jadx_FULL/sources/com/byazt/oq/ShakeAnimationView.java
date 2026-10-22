package com.byazt.oq;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aq.da;
import com.byazt.nr.zm;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1857})
public class ShakeAnimationView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f28908a;
    public int c;
    public da da;
    public LinearLayout i;
    public zm n;
    public boolean sl;
    public TextView sp;
    public TextView tt;
    public ImageView uj;
    public TextView ve;
    public c x;

    /* JADX INFO: renamed from: com.byazt.oq.ShakeAnimationView$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1461})
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShakeAnimationView.this.uj != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new tt(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.oq.ShakeAnimationView.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ShakeAnimationView.this.postDelayed(new Runnable() { // from class: com.byazt.oq.ShakeAnimationView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ShakeAnimationView.this.uj.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                ShakeAnimationView.this.uj.startAnimation(rotateAnimation);
            }
        }
    }

    public interface c {
        void c(boolean z);
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 700})
    public static class tt implements Interpolator {
        private tt() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.25f) {
                return (f * (-2.0f)) + 0.5f;
            }
            if (f <= 0.5f) {
                return (f * 4.0f) - 1.0f;
            }
            return f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }

        public /* synthetic */ tt(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public ShakeAnimationView(Context context, View view, da daVar, boolean z, int i) {
        super(context);
        this.da = daVar;
        this.sl = z;
        this.c = i;
        c(context, view);
    }

    public LinearLayout getShakeLayout() {
        return this.i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.n == null) {
                this.n = new zm(getContext().getApplicationContext(), 1, this.sl);
            }
            this.n.c(new zm.c() { // from class: com.byazt.oq.ShakeAnimationView.2
                @Override // com.byazt.nr.zm.c
                public void c(int i) {
                    boolean zC = ShakeAnimationView.this.n != null ? ShakeAnimationView.this.n.c() : false;
                    if (i == 1 && ShakeAnimationView.this.isShown() && ShakeAnimationView.this.x != null) {
                        ShakeAnimationView.this.x.c(zC);
                    }
                }
            });
            da daVar = this.da;
            if (daVar != null) {
                this.n.c(daVar.c());
                this.n.ve(this.da.sp());
                this.n.ve(this.da.tt());
                this.n.n(this.da.uj());
                this.n.tt(this.da.ve());
                this.n.a(this.da.n());
                this.n.c(this.da.a());
                this.n.tt(this.da.x());
                this.n.c(this.c);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zm zmVar = this.n;
        if (zmVar != null) {
            zmVar.tt(this.c);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        zm zmVar = this.n;
        if (zmVar != null) {
            if (z) {
                zmVar.c(this.c);
            } else {
                zmVar.tt(this.c);
            }
        }
    }

    public void setOnShakeViewListener(c cVar) {
        this.x = cVar;
    }

    public void setShakeText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f28908a.setText(str);
        } else {
            this.f28908a.setVisibility(8);
            this.sp.setVisibility(8);
        }
    }

    public void c(Context context, View view) {
        addView(view);
        this.i = (LinearLayout) findViewById(2097610727);
        this.uj = (ImageView) findViewById(2097610725);
        this.tt = (TextView) findViewById(2097610724);
        this.ve = (TextView) findViewById(2097610726);
        this.f28908a = (TextView) findViewById(2097610723);
        this.sp = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.i.setBackground(gradientDrawable);
    }

    public void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }
}
