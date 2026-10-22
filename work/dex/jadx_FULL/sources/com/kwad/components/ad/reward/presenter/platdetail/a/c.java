package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private AdInfo mAdInfo;
    private ImageView zH;
    private TextView zI;
    private boolean zJ = false;
    private View zK = null;
    private long zL = -1;
    private final m kf = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            if (c.this.zL >= 0) {
                if (j2 > Math.min(Math.min(c.this.zL, com.kwad.sdk.core.response.helper.a.ak(c.this.mAdInfo)), j)) {
                    c.this.jK();
                }
            }
        }
    };
    private final com.kwad.components.ad.reward.e.e kL = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.2
        @Override // com.kwad.components.ad.reward.e.e
        public final void dw() {
            c.a(c.this, true);
            c.this.jK();
        }
    };

    private void ds() {
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        this.uj.sz.a(this.kf);
        this.uj.sJ.add(this.kL);
        long jAj = com.kwad.sdk.core.response.helper.a.aj(this.mAdInfo);
        this.zL = jAj;
        if (jAj == 0) {
            this.zK.setVisibility(0);
        } else {
            this.zK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jK() {
        if (this.zK.getVisibility() == 0) {
            return;
        }
        this.zK.setAlpha(0.0f);
        this.zK.setVisibility(0);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.zK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.start();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        ds();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.zK) {
            f.a(this.uj, this.zJ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.zH = (ImageView) findViewById(R.id.ksad_detail_close_btn);
        this.zI = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.components.ad.reward.a.b.hM())) {
            if (com.kwad.components.ad.reward.a.b.hL() == 0) {
                this.zH.setImageResource(R.drawable.ksad_page_close);
            } else {
                this.zH.setImageResource(R.drawable.ksad_video_skip_icon);
            }
            this.zK = this.zH;
        } else {
            this.zI.setText(com.kwad.components.ad.reward.a.b.hM());
            this.zK = this.zI;
        }
        this.zK.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.sz.b(this.kf);
        this.uj.sJ.remove(this.kL);
        this.zK.setVisibility(8);
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.zJ = true;
        return true;
    }
}
