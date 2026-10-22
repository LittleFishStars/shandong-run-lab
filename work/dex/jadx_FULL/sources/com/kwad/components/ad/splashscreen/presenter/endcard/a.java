package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.splashscreen.presenter.e {
    private AnimatorSet JH;
    private TextView JI;
    private ViewGroup JJ;
    private ViewGroup JK;

    private void initView() {
        this.JI = (TextView) findViewById(R.id.ksad_ad_developer_text);
        this.JJ = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_view);
        this.JK = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
    }

    private void nk() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.JK, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.JI, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.JJ, "scaleX", 0.8f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.JJ, "scaleY", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.JH = animatorSet;
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        this.JH.setDuration(300L);
        this.JH.start();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        nk();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        AnimatorSet animatorSet = this.JH;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
