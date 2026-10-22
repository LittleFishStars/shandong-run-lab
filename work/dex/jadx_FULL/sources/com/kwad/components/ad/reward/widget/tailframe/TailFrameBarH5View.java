package com.kwad.components.ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class TailFrameBarH5View extends LinearLayout {
    protected TextView gW;
    protected TextView gX;
    protected ValueAnimator mn;

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    private void f(Context context, int i) {
        m.inflate(context, i, this);
        this.gW = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.gX = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void lQ() {
        if (this.mn != null) {
            lR();
            this.mn.start();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.mn = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1200L);
        this.mn.setRepeatCount(-1);
        this.mn.setRepeatMode(1);
        this.mn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.gX.setScaleY(fFloatValue);
                TailFrameBarH5View.this.gX.setScaleX(fFloatValue);
            }
        });
        this.mn.start();
    }

    public TextView getH5OpenBtn() {
        return this.gX;
    }

    public final void h(boolean z, boolean z2) {
        int i;
        if (z) {
            i = z2 ? R.layout.ksad_video_tf_bar_h5_portrait_vertical : R.layout.ksad_video_tf_bar_h5_portrait_horizontal;
        } else {
            i = R.layout.ksad_video_tf_bar_h5_landscape;
        }
        f(getContext(), i);
    }

    public final void lR() {
        ValueAnimator valueAnimator = this.mn;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.mn.cancel();
        this.mn.end();
    }

    public final void n(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        this.gW.setText(com.kwad.sdk.core.response.helper.a.aA(adInfoEO));
        this.gX.setText(com.kwad.sdk.core.response.helper.a.aK(adInfoEO));
        lQ();
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
