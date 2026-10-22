package com.byazt.oq;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.nr.z;
import com.byazt.or.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, SecExceptionCode.SEC_ERROR_MIDDLE_TIER_UNKONWN_ENCODING_ERROR})
public class PressInteractView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f28905a;
    public Context c;
    public boolean n;
    public ImageView tt;
    public AnimatorSet uj;
    public SplashDiffuseView ve;

    public PressInteractView(Context context) {
        super(context);
        this.n = true;
        this.c = context;
        this.uj = new AnimatorSet();
        ve();
        uj();
        post(new Runnable() { // from class: com.byazt.oq.PressInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                int iC = (int) x.c(PressInteractView.this.c, 50.0f);
                int iC2 = (int) x.c(PressInteractView.this.c, 50.0f);
                if (PressInteractView.this.ve.getMeasuredHeight() > 0) {
                    iC = PressInteractView.this.ve.getMeasuredHeight();
                }
                if (PressInteractView.this.ve.getMeasuredWidth() > 0) {
                    iC2 = PressInteractView.this.ve.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressInteractView.this.tt.getLayoutParams();
                layoutParams.topMargin = ((int) ((iC / 2.0f) - x.c(PressInteractView.this.getContext(), 5.0f))) + ((int) x.c(PressInteractView.this.c, 40.0f));
                layoutParams.leftMargin = ((int) ((iC2 / 2.0f) - x.c(PressInteractView.this.getContext(), 5.0f))) + ((int) x.c(PressInteractView.this.c, 20.0f));
                layoutParams.bottomMargin = (int) (((-iC) / 2.0f) + x.c(PressInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-iC2) / 2.0f) + x.c(PressInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressInteractView.this.tt.setLayoutParams(layoutParams);
            }
        });
    }

    public void setGuideText(String str) {
        this.f28905a.setVisibility(0);
        this.f28905a.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.f28905a.setTextColor(i);
    }

    private void uj() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.tt, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.oq.PressInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressInteractView.this.n) {
                    PressInteractView.this.ve.c();
                }
                PressInteractView pressInteractView = PressInteractView.this;
                pressInteractView.n = !pressInteractView.n;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressInteractView.this.tt, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                PressInteractView.this.tt.setVisibility(0);
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.tt, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(600L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.uj.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void ve() {
        this.ve = new SplashDiffuseView(this.c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) x.c(this.c, 50.0f), (int) x.c(this.c, 50.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) x.c(this.c, 40.0f);
        int iC = (int) x.c(this.c, 20.0f);
        layoutParams.leftMargin = iC;
        layoutParams.setMarginStart(iC);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.ve, layoutParams);
        this.tt = new ImageView(this.c);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) x.c(this.c, 78.0f), (int) x.c(this.c, 78.0f));
        z.c(this.c, "tt_splash_hand", this.tt, 320);
        addView(this.tt, layoutParams2);
        TextView textView = new TextView(this.c);
        this.f28905a = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) x.c(this.c, 10.0f);
        addView(this.f28905a, layoutParams3);
        this.f28905a.setVisibility(8);
    }

    public void tt() {
        AnimatorSet animatorSet = this.uj;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SplashDiffuseView splashDiffuseView = this.ve;
        if (splashDiffuseView != null) {
            splashDiffuseView.tt();
        }
        ImageView imageView = this.tt;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public void c() {
        this.uj.start();
    }
}
