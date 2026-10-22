package com.kwad.components.ad.draw.presenter.livecard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KsLiveEndAuthorView extends KsLiveAuthorView {
    private boolean eS;

    public KsLiveEndAuthorView(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView
    public final void A(@NonNull Context context) {
        m.inflate(context, R.layout.ksad_draw_author_end_icon, this);
        this.eA = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.eC = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.eB = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.eD = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.eE = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.eK = findViewById(R.id.ksad_author_icon_layout);
    }

    @Override // com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView, com.kwad.sdk.utils.cc.a
    public final void a(Message message) {
        if (message.what != 1) {
            return;
        }
        c.d("KsLiveEndAuthorView", "handleMsg MSG_CHECKING");
        final Animator animatorA = a((View) this.eD, 900L);
        final Animator animatorA2 = a((View) this.eE, 1000L);
        final Animator animatorA3 = KsLiveAuthorView.a((View) this.eC, false);
        if (this.eS) {
            return;
        }
        if (animatorA == null || animatorA2 == null || animatorA3 == null) {
            this.ca.sendEmptyMessageDelayed(1, 500L);
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorA3, animatorA, animatorA2);
        animatorSet.start();
        this.eS = true;
        animatorA3.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.presenter.livecard.KsLiveEndAuthorView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(animatorA, animatorA2, animatorA3);
                animatorSet2.start();
            }
        });
    }

    @Override // com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView
    public float getWaveEndSize() {
        return getResources().getDimension(R.dimen.ksad_draw_author_end_icon_width);
    }

    @Override // com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView
    public final void n(AdTemplate adTemplate) {
        String strCv = com.kwad.sdk.core.response.helper.a.cv(e.eO(adTemplate));
        if (!TextUtils.isEmpty(strCv)) {
            KSImageLoader.loadImage(this.eC, strCv, adTemplate);
        }
        this.ca.sendEmptyMessageAtTime(1, 500L);
    }

    public KsLiveEndAuthorView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsLiveEndAuthorView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsLiveEndAuthorView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
