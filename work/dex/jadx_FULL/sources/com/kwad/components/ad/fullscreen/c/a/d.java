package com.kwad.components.ad.fullscreen.c.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView kI;
    private TextView kJ;
    private View kK = null;
    private com.kwad.components.ad.reward.e.e kL = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.fullscreen.c.a.d.1
        @Override // com.kwad.components.ad.reward.e.e
        public final void dw() {
            d.this.dv();
        }
    };
    private m kf = new m() { // from class: com.kwad.components.ad.fullscreen.c.a.d.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            d.this.n(j2);
        }
    };

    private void ds() {
        this.uj.sz.a(this.kf);
        this.uj.sJ.add(this.kL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv() {
        if (this.kK.getVisibility() == 0) {
            return;
        }
        this.kK.setAlpha(0.0f);
        this.kK.setVisibility(0);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.kK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.start();
        this.kK.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        ds();
    }

    public final void n(long j) {
        if (j >= com.kwad.sdk.core.response.helper.a.ap(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate))) {
            dv();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.kK) {
            com.kwad.components.ad.reward.presenter.f.a(this.uj, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kI = (ImageView) findViewById(R.id.ksad_skip_icon);
        this.kJ = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (!TextUtils.isEmpty(com.kwad.components.ad.fullscreen.a.b.df())) {
            this.kJ.setText(com.kwad.components.ad.fullscreen.a.b.df());
            this.kI.setVisibility(8);
            this.kK = this.kJ;
        } else {
            if (com.kwad.components.ad.fullscreen.a.b.de() == 0) {
                this.kI.setImageResource(R.drawable.ksad_page_close);
            } else {
                this.kI.setImageResource(R.drawable.ksad_video_skip_icon);
            }
            this.kJ.setVisibility(8);
            this.kK = this.kI;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.sJ.remove(this.kL);
        this.uj.sz.b(this.kf);
    }
}
