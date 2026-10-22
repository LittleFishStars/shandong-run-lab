package com.kwad.components.ad.reward.presenter.platdetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private Animator yA;
    private Animator yB;
    private Animator yC;
    private bo yF;
    private bo yG;
    private View yu;
    private View yv;
    private View yw;
    private View yx;
    private final long yr = 1600;
    private final long ys = 3000;
    private final long yt = 5000;
    private boolean yy = false;
    private boolean yz = false;
    private Animator yD = null;
    private long yE = 3000;
    private Interpolator yH = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
    private m kf = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1
        private boolean yI = false;

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            b.this.yy = true;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayPaused : ");
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            if (j2 < b.this.yE || this.yI) {
                return;
            }
            this.yI = true;
            b.this.jq();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.yy = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayStart : ");
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            b.this.yy = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlaying : ");
            if (b.this.yD == null || b.this.yD.isRunning()) {
                return;
            }
            b.this.yD.start();
            b.a(b.this, (Animator) null);
        }
    };

    public static /* synthetic */ View b(b bVar, View view) {
        bVar.yv = null;
        return null;
    }

    private void jo() {
        this.yF = new bo(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_start), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_start));
        this.yG = new bo(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_end), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_end));
    }

    private View jp() {
        ImageView imageView = new ImageView(getContext());
        imageView.setClickable(false);
        imageView.setFocusable(false);
        imageView.setFocusableInTouchMode(false);
        imageView.setLongClickable(false);
        imageView.setBackgroundColor(Color.parseColor("#222222"));
        imageView.setAlpha(0.2f);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq() {
        this.yA = b(this.yu, 1600L);
        this.yB = a(this.yw, this.yx);
        this.yC = c(this.yu, 1600L);
        this.yA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.q(b.this.yv);
                b.b(b.this, (View) null);
                if (b.this.yz) {
                    return;
                }
                b bVar = b.this;
                bVar.a(bVar.yB);
            }
        });
        this.yB.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.yC);
                b.q(b.this.yw);
                b.q(b.this.yx);
                b.c(b.this, (View) null);
                b.d(b.this, null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.b(b.this, true);
            }
        });
        this.yC.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.yC);
            }
        });
        a(this.yA);
    }

    private Animator p(View view) {
        if (this.yF == null || this.yG == null) {
            jo();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", -(com.kwad.sdk.c.a.a.getScreenHeight(getContext()) + ((this.yG.getHeight() + this.yF.getHeight()) / 2)));
        float fWw = this.yG.Ww() / this.yF.Ww();
        float fWx = this.yG.Wx() / this.yF.Wx();
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, fWw);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, fWx);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.8f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000L);
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat, objectAnimatorOfFloat4);
        animatorSet.setInterpolator(this.yH);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.sz.a(this.kf);
        FrameLayout frameLayoutT = this.uj.sz.lu().T(getContext());
        this.yu = frameLayoutT;
        if (frameLayoutT.getParent() != null) {
            return;
        }
        ((FrameLayout) findViewById(R.id.ksad_reward_play_layout)).addView(this.yu, -1, -1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = -this.yF.getHeight();
        ViewGroup viewGroup = (FrameLayout) findViewById(R.id.ksad_root_container);
        View viewJp = jp();
        this.yv = viewJp;
        viewGroup.addView(viewJp, -1, -1);
        View viewA = a(R.drawable.ksad_image_player_sweep1, viewGroup);
        this.yw = viewA;
        viewGroup.addView(viewA, layoutParams);
        View viewA2 = a(R.drawable.ksad_image_player_sweep2, viewGroup);
        this.yx = viewA2;
        viewGroup.addView(viewA2, layoutParams);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        jo();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.yu = null;
        com.kwad.components.ad.reward.m.b bVarLu = this.uj.sz.lu();
        if (bVarLu != null) {
            bVarLu.release();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.yy = true;
        Animator animator = this.yB;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.yA;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.yC;
        if (animator3 != null) {
            animator3.cancel();
        }
        this.uj.sz.b(this.kf);
    }

    public static /* synthetic */ Animator a(b bVar, Animator animator) {
        bVar.yD = null;
        return null;
    }

    public static /* synthetic */ View c(b bVar, View view) {
        bVar.yw = null;
        return null;
    }

    public static /* synthetic */ View d(b bVar, View view) {
        bVar.yx = null;
        return null;
    }

    private Animator c(View view, long j) {
        Animator animatorB = b(view, 1600L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        objectAnimatorOfFloat.setDuration(5000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animatorB, objectAnimatorOfFloat);
        animatorSet.setDuration(1600L);
        return animatorSet;
    }

    public static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.yz = true;
        return true;
    }

    private View a(@DrawableRes int i, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.ksad_image_player_sweep, viewGroup, false);
        imageView.setImageDrawable(getContext().getResources().getDrawable(i));
        return imageView;
    }

    private Animator b(View view, long j) {
        float[] fArr = {1.0f, 1.106f, 1.0f, 1.106f, 1.0f};
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", fArr);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        View view2 = this.yv;
        if (view2 != null) {
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, ObjectAnimator.ofFloat(view2, "alpha", 0.2f, 0.0f));
        } else {
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        }
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(this.yH);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Animator animator) {
        if (!this.yy) {
            animator.start();
        } else {
            this.yD = animator;
        }
    }

    private Animator a(View view, View view2) {
        Animator animatorP = p(view);
        Animator animatorP2 = p(view2);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, animatorP2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animatorP, animatorSet);
        return animatorSet2;
    }
}
