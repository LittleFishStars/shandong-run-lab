package com.byazt.oq;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.nr.z;
import com.byazt.or.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1716})
public class PressButtonInteractView extends FrameLayout {
    public Context c;
    public boolean n;
    public ImageView tt;
    public AnimatorSet uj;
    public SplashDiffuseView ve;

    public PressButtonInteractView(Context context) {
        super(context);
        this.n = true;
        this.c = context;
        this.uj = new AnimatorSet();
        ve();
        uj();
        post(new Runnable() { // from class: com.byazt.oq.PressButtonInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.tt.getLayoutParams();
                layoutParams.topMargin = (int) ((PressButtonInteractView.this.ve.getMeasuredHeight() / 2.0f) - x.c(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((PressButtonInteractView.this.ve.getMeasuredWidth() / 2.0f) - x.c(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-PressButtonInteractView.this.ve.getMeasuredHeight()) / 2.0f) + x.c(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-PressButtonInteractView.this.ve.getMeasuredWidth()) / 2.0f) + x.c(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressButtonInteractView.this.tt.setLayoutParams(layoutParams);
            }
        });
    }

    private void uj() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.tt, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.oq.PressButtonInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressButtonInteractView.this.n) {
                    PressButtonInteractView.this.ve.c();
                }
                PressButtonInteractView pressButtonInteractView = PressButtonInteractView.this;
                pressButtonInteractView.n = !pressButtonInteractView.n;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressButtonInteractView.this.tt, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                objectAnimatorOfFloat2.start();
                PressButtonInteractView.this.tt.setVisibility(0);
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.tt, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(800L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.uj.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void ve() {
        this.ve = new SplashDiffuseView(this.c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) x.c(this.c, 40.0f), (int) x.c(this.c, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.ve, layoutParams);
        this.tt = new ImageView(this.c);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) x.c(this.c, 62.0f), (int) x.c(this.c, 62.0f));
        layoutParams2.gravity = 16;
        z.c(this.c, "tt_splash_hand", this.tt, 320);
        addView(this.tt, layoutParams2);
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
