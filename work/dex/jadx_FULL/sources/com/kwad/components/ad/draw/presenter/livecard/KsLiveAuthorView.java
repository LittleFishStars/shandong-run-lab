package com.kwad.components.ad.draw.presenter.livecard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.cc;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KsLiveAuthorView extends FrameLayout implements cc.a {
    public final cc ca;
    protected ViewGroup eA;
    protected KSCornerImageView eB;
    protected KSCornerImageView eC;
    protected KSCornerImageView eD;
    protected KSCornerImageView eE;
    private TextView eF;
    private ImageView eG;
    private View eH;
    private View eI;
    private View eJ;
    protected View eK;

    public KsLiveAuthorView(@NonNull Context context) {
        super(context);
        this.ca = new cc(this);
        A(context);
    }

    private static Animator a(View view, int i) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.setPivotX(width / 2.0f);
        view.setPivotY(height);
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet.setInterpolator(interpolatorCreate);
        animatorSet.setDuration(250L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet2.setInterpolator(interpolatorCreate2);
        animatorSet2.setDuration(250L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.setDuration(500L);
        return animatorSet3;
    }

    private static ValueAnimator.AnimatorUpdateListener b(final View view, final boolean z) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    int i = (int) fFloatValue;
                    layoutParams.width = i;
                    if (!z) {
                        layoutParams.height = i;
                    }
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    public void A(@NonNull Context context) {
        m.inflate(context, R.layout.ksad_draw_author_icon, this);
        this.eA = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.eC = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.eB = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.eD = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.eE = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.eF = (TextView) findViewById(R.id.ksad_fans_count);
        this.eG = (ImageView) findViewById(R.id.ksad_author_arrow_down);
        this.eI = findViewById(R.id.ksad_origin_live_bottom_layout);
        this.eH = findViewById(R.id.ksad_top_layout);
        this.eK = findViewById(R.id.ksad_author_icon_layout);
        this.eJ = findViewById(R.id.ksad_top_flag_layout);
    }

    public float getWaveEndSize() {
        return getResources().getDimension(R.dimen.ksad_draw_author_icon_width);
    }

    public void n(AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        String strCv = com.kwad.sdk.core.response.helper.a.cv(adInfoEO);
        if (!TextUtils.isEmpty(strCv)) {
            KSImageLoader.loadImage(this.eC, strCv, adTemplate);
        }
        int iBm = com.kwad.sdk.core.response.helper.a.bm(adInfoEO);
        if (com.kwad.sdk.core.response.helper.a.cY(e.eO(adTemplate))) {
            this.eF.setText("直播中");
            if (iBm == 8) {
                this.eJ.setVisibility(8);
                this.eG.setVisibility(8);
                this.eI.setVisibility(0);
            } else {
                this.eG.setVisibility(0);
                this.eI.setVisibility(8);
            }
        } else {
            this.eF.setText(com.kwad.sdk.core.response.helper.a.cT(adInfoEO));
        }
        this.ca.sendEmptyMessageAtTime(1, 500L);
    }

    public KsLiveAuthorView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ca = new cc(this);
        A(context);
    }

    public KsLiveAuthorView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ca = new cc(this);
        A(context);
    }

    @RequiresApi(api = 21)
    public KsLiveAuthorView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.ca = new cc(this);
        A(context);
    }

    public static Animator a(View view, boolean z) {
        float width = view.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f = 0.9f * width;
        c.d("KsLiveAuthorView", "getIconScaleAnimator size: " + width + ", endSize: " + f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(width, f);
        valueAnimatorOfFloat.addUpdateListener(b(view, false));
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.setInterpolator(interpolatorCreate);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(f, width);
        valueAnimatorOfFloat2.addUpdateListener(b(view, false));
        Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        valueAnimatorOfFloat2.setDuration(500L);
        valueAnimatorOfFloat2.setInterpolator(interpolatorCreate2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        return animatorSet;
    }

    public final Animator a(View view, long j) {
        if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(view.getWidth(), getWaveEndSize());
        valueAnimatorOfFloat.addUpdateListener(b(view, false));
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(interpolatorCreate);
        animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat);
        return animatorSet;
    }

    public final void a(com.kwad.components.core.widget.e eVar) {
        com.kwad.components.core.t.m.a(eVar, this);
        this.eG.setImageResource(R.drawable.ksad_draw_follow_arrow_down);
        a(eVar, this.eD.getBackground());
        a(eVar, this.eB.getBackground());
        a(eVar, this.eE.getBackground());
        a(eVar, this.eA.getBackground());
    }

    private void a(com.kwad.components.core.widget.e eVar, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.ksad_draw_author_icon_stroke_width), eVar.zX());
        }
    }

    @Override // com.kwad.sdk.utils.cc.a
    public void a(Message message) {
        if (message.what != 1) {
            return;
        }
        c.d("KsLiveAuthorView", "handleMsg MSG_CHECKING");
        final Animator animatorA = a((View) this.eD, 900L);
        final Animator animatorA2 = a((View) this.eE, 1000L);
        final Animator animatorA3 = a((View) this.eC, false);
        final Animator animatorA4 = a(this.eH, 500);
        if (animatorA4 != null && animatorA != null && animatorA2 != null && animatorA3 != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(animatorA3, animatorA, animatorA2);
            animatorSet.start();
            animatorA3.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(animatorA, animatorA2, animatorA3, animatorA4);
                    animatorSet2.start();
                }
            });
            return;
        }
        this.ca.sendEmptyMessageDelayed(1, 500L);
    }
}
